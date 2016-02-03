package mobi.beyondpod.downloadengine;

import android.net.Uri;
import android.os.Process;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import mobi.beyondpod.R.string;
import mobi.beyondpod.aggregators.AggregatorLoginHelper;
import mobi.beyondpod.aggregators.AggregatorLoginHelper.AuthenticationException;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.CoreHelper.DeviceNetworkConnection;
import mobi.beyondpod.rsscore.helpers.CoreHelper.IssuficientStorageSpaceException;
import mobi.beyondpod.rsscore.helpers.CoreHelper.UnableToEstablishNetworkConnectionException;
import mobi.beyondpod.rsscore.helpers.FileUtils;
import mobi.beyondpod.rsscore.helpers.NetworkCredential;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FlashStorageLocation;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;

public class DownloadAgent
  implements Runnable
{
  private static final String BOTH_MOBILE_AND_WI_FI_DATA_CONNECTIONS_ARE_ALLOWED;
  private static final String INSUFFICIENT_DISK_SPACE = CoreHelper.LoadResourceString(R.string.download_agent_insufficient_disk_space_to_complete_the_download_required);
  private static final String PODCAST_DOWNLOAD_MOBILE = CoreHelper.LoadResourceString(R.string.download_agent_mobile_connections_not_allowed);
  private static final String PODCAST_WIFI_ALLOWED = CoreHelper.LoadResourceString(R.string.download_agent_wifi_allowed);
  private static final String TAG = DownloadAgent.class.getSimpleName();
  private static final String UNABLE_TO_ESTABLISH_INTERNET_CONNECTION;
  public static final int UPDATE_TYPE_FeedUpdate = 0;
  public static final int UPDATE_TYPE_PodcastDownload = 1;
  private boolean _AllowMobileDataUse = false;
  private boolean _AllowRedirects = true;
  private boolean _AllowResume = true;
  private String _ContentDisposition;
  private NetworkCredential _Credentials = null;
  private final File _Destination;
  DownloadListener _DownloadListener;
  private Thread _DownloadThread = null;
  private volatile boolean _DownloadThreadIsDownloading;
  private Long _ExpectedSize = null;
  private BeyondPodHttpClient _HttpClient;
  private Date _IgnoreIfNotModifiedSinceDate = null;
  private Long _IgnoreIfSize = null;
  long _LastConnectionCheckTime = 0L;
  long _LastWakeLock = 0L;
  private FileOutputStream _LocalStream = null;
  private boolean _MustRequestReaderAuthToken = false;
  private String _RequestCookie;
  private Long _ResourceContentLength = null;
  private Date _ResourceLastModified = null;
  private String _ResponseCookie;
  private final URI _Source;
  private DownloadStatistics _Statistics;
  private boolean _StopDownload;
  private int _UpdateType = 0;
  private String _UserAgent = null;
  private HttpGet _WebRequest = null;
  private HttpResponse _WebResponse = null;
  private InputStream _WebResponseStream = null;
  private ArrayList<RequestHeader> _extraHeaders = new ArrayList();
  
  static
  {
    BOTH_MOBILE_AND_WI_FI_DATA_CONNECTIONS_ARE_ALLOWED = CoreHelper.LoadResourceString(R.string.download_agent_both_mobile_and_wifi_data_connections_are_allowed);
    UNABLE_TO_ESTABLISH_INTERNET_CONNECTION = CoreHelper.LoadResourceString(R.string.download_agent_unable_to_establish_internet_connection);
  }
  
  public DownloadAgent(Uri paramUri, File paramFile, NetworkCredential paramNetworkCredential)
  {
    if (paramUri == null) {
      throw new IllegalArgumentException("Download agent was created with an empty URL!");
    }
    this._Destination = paramFile;
    this._Source = CoreHelper.SafeCreateURI(paramUri.toString().trim());
    this._Credentials = paramNetworkCredential;
    this._HttpClient = BeyondPodHttpClient.newInstance(Configuration.DefaultUserAgent());
  }
  
  private boolean AllowMobileDataConnectionsForThisSession()
  {
    return ((this._AllowMobileDataUse) || (Configuration.IsCellularConnectionAllowed())) && (!EnclosureDownloadMustUseWiFi());
  }
  
  private void DoCleanup()
  {
    if (this._DownloadThread == null) {}
    for (str = "sync request";; str = this._DownloadThread.getName())
    {
      CoreHelper.WriteTraceEntry(TAG, ">> Cleanup Started... " + str);
      CoreHelper.KeepDeviceAwake();
      this._DownloadThreadIsDownloading = false;
      try
      {
        if (this._LocalStream != null)
        {
          CoreHelper.sync(this._LocalStream);
          this._LocalStream.close();
        }
        if (this._WebRequest != null)
        {
          this._WebRequest.abort();
          if (this._WebResponseStream != null) {
            this._WebResponseStream.close();
          }
        }
        this._HttpClient.close();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          CoreHelper.WriteTraceEntry(TAG, ">> Unable to close the HTTP stream. Reason: " + localException.getMessage() + "---" + str);
          this._WebRequest = null;
          this._WebResponseStream = null;
          this._WebResponse = null;
          this._LocalStream = null;
          this._HttpClient = null;
        }
      }
      finally
      {
        this._WebRequest = null;
        this._WebResponseStream = null;
        this._WebResponse = null;
        this._LocalStream = null;
        this._HttpClient = null;
      }
      CoreHelper.WriteTraceEntry(TAG, ">> Cleanup Complete..." + str);
      return;
    }
  }
  
  private boolean EnclosureDownloadMustUseWiFi()
  {
    return (this._UpdateType == 1) && (Configuration.DownloadEnclosuresOnWiFiOnly()) && (!this._AllowMobileDataUse);
  }
  
  private boolean HasNetworkConnection()
  {
    if ((AllowMobileDataConnectionsForThisSession()) && ((!Configuration.TurnWiFiDuringUpdate()) || (Configuration.UnableToEstablishWiFiConnectionInThisSession()))) {}
    CoreHelper.DeviceNetworkConnection localDeviceNetworkConnection;
    do
    {
      return true;
      localDeviceNetworkConnection = CoreHelper.GetDeviceNetworkConnection();
      if (!localDeviceNetworkConnection.IsConnectedToNetwork()) {
        break;
      }
    } while (AllowMobileDataConnectionsForThisSession());
    return localDeviceNetworkConnection.IsConnectionWiFi();
    return false;
  }
  
  private boolean IsUnAuthorizedMobileDataConnection()
  {
    if (AllowMobileDataConnectionsForThisSession()) {}
    long l;
    do
    {
      return false;
      l = System.currentTimeMillis();
    } while (l - this._LastConnectionCheckTime < 10000L);
    CoreHelper.WriteTraceEntry(TAG, "Checking for unauthorized mobile data connection...");
    this._LastConnectionCheckTime = l;
    return CoreHelper.GetDeviceNetworkConnection().IsConnectionCellular();
  }
  
  private void OnDownloadCompleted(boolean paramBoolean)
  {
    this._DownloadThreadIsDownloading = false;
    if (this._DownloadListener != null) {
      this._DownloadListener.OnDownloadCompleted(this, paramBoolean);
    }
  }
  
  private void OnDownloadError(Exception paramException)
  {
    CoreHelper.WriteLogEntryInProduction(TAG, "===> Download Agent Exception! Reason:" + CoreHelper.ExtractExceptionMessages(paramException) + ", Type:" + paramException.getClass().getSimpleName());
    if (this._StopDownload) {
      CoreHelper.WriteLogEntryInProduction(TAG, "===> Download Exception was received after manual download termination. Ignoring...");
    }
    do
    {
      return;
      Statistics().LastException = paramException;
    } while (this._DownloadListener == null);
    this._DownloadListener.OnDownloadError(this, paramException);
  }
  
  private void OnDownloadProgress(long paramLong1, long paramLong2)
  {
    long l = System.currentTimeMillis();
    if (l - this._LastWakeLock > 3000L)
    {
      this._LastWakeLock = l;
      CoreHelper.KeepDeviceAwake();
    }
    DownloadListener localDownloadListener;
    if ((!this._StopDownload) && (this._DownloadListener != null))
    {
      localDownloadListener = this._DownloadListener;
      if ((paramLong2 <= 0L) || (paramLong1 <= paramLong2)) {
        break label73;
      }
      paramLong2 = paramLong1;
    }
    label73:
    for (;;)
    {
      localDownloadListener.OnDownloadProgress(this, paramLong1, paramLong2);
      return;
    }
  }
  
  private void WaitForInternetConnection()
    throws CoreHelper.UnableToEstablishNetworkConnectionException, InterruptedException
  {
    int j = 0;
    int i = j;
    String str;
    if (Configuration.EnableQuickNetworkCheck())
    {
      i = j;
      if (!AllowMobileDataConnectionsForThisSession())
      {
        i = j;
        if (!Configuration.TurnWiFiDuringUpdate())
        {
          i = j;
          if (CoreHelper.GetDeviceNetworkConnection().IsConnectionCellular())
          {
            j = 8;
            CoreHelper.WriteLogEntryInProduction(TAG, ">> Waiting for internet connection was ignored!");
            if (j <= 7) {
              return;
            }
            Configuration.SetUnableToEstablishWiFiConnectionInThisSession(true);
            str = UNABLE_TO_ESTABLISH_INTERNET_CONNECTION;
            if (!AllowMobileDataConnectionsForThisSession()) {
              break label208;
            }
            str = str + BOTH_MOBILE_AND_WI_FI_DATA_CONNECTIONS_ARE_ALLOWED;
          }
        }
      }
    }
    for (;;)
    {
      if ((AllowMobileDataConnectionsForThisSession()) && ((!AllowMobileDataConnectionsForThisSession()) || (CoreHelper.GetDeviceNetworkConnection().IsConnectedToNetwork()))) {
        return;
      }
      throw new CoreHelper.UnableToEstablishNetworkConnectionException(str);
      do
      {
        CoreHelper.KeepDeviceAwake();
        CoreHelper.WriteLogEntryInProduction(TAG, ">> Waiting for internet connection ... " + i + " (Available Connections: " + CoreHelper.GetDeviceNetworkConnection().ExtraInfo() + ")");
        CoreHelper.nap(5);
        i += 1;
        j = i;
        if (this._StopDownload) {
          break;
        }
        j = i;
        if (HasNetworkConnection()) {
          break;
        }
      } while (i <= 7);
      j = i;
      break;
      label208:
      if (EnclosureDownloadMustUseWiFi()) {
        str = str + PODCAST_WIFI_ALLOWED;
      } else {
        str = str + PODCAST_DOWNLOAD_MOBILE;
      }
    }
  }
  
  public void AddExtraHeader(String paramString1, String paramString2)
  {
    this._extraHeaders.add(new RequestHeader(paramString1, paramString2));
  }
  
  public boolean AllowResume()
  {
    return this._AllowResume;
  }
  
  public File Destination()
  {
    return this._Destination;
  }
  
  public Date IgnoreIfNotModifiedSinceDate()
  {
    return this._IgnoreIfNotModifiedSinceDate;
  }
  
  public Long IgnoreIfSize()
  {
    return this._IgnoreIfSize;
  }
  
  public boolean IsDownloading()
  {
    return this._DownloadThreadIsDownloading;
  }
  
  public Date LastModifiedDate()
  {
    return this._ResourceLastModified;
  }
  
  public Long ResourceContentLength()
  {
    return this._ResourceContentLength;
  }
  
  public String ResponseCookie()
  {
    return this._ResponseCookie;
  }
  
  public void SetAllowMobileDataUse(boolean paramBoolean)
  {
    this._AllowMobileDataUse = paramBoolean;
  }
  
  public void SetAllowRedirects(boolean paramBoolean)
  {
    this._AllowRedirects = paramBoolean;
  }
  
  public void SetAllowResume(boolean paramBoolean)
  {
    this._AllowResume = paramBoolean;
  }
  
  public void SetIgnoreIfNotModifiedSinceDate(Date paramDate)
  {
    this._IgnoreIfNotModifiedSinceDate = paramDate;
  }
  
  public void SetIgnoreIfSize(Long paramLong)
  {
    this._IgnoreIfSize = paramLong;
  }
  
  public void SetMustRequestReaderToken(boolean paramBoolean)
  {
    this._MustRequestReaderAuthToken = paramBoolean;
  }
  
  public void SetRequestCookie(String paramString)
  {
    this._RequestCookie = paramString;
  }
  
  public void SetUpdateType(int paramInt)
  {
    this._UpdateType = paramInt;
  }
  
  public void SetUserAgent(String paramString)
  {
    this._UserAgent = paramString;
  }
  
  public void StartDownload()
    throws Exception
  {
    if (this._DownloadThread != null) {
      throw new Exception("You must use a new instance of this class for each new download!");
    }
    if (this._DownloadThreadIsDownloading) {
      throw new Exception("Downlod is already in progress!");
    }
    this._DownloadThreadIsDownloading = true;
    this._DownloadThread = new Thread(this);
    this._DownloadThread.setName("Download thread: " + this._Source);
    this._DownloadThread.setPriority(1);
    this._DownloadThread.start();
  }
  
  public DownloadStatistics Statistics()
  {
    return this._Statistics;
  }
  
  public void Stop()
  {
    CoreHelper.WriteTraceEntry(TAG, ">> Received Stop command to terminate the Download of: " + this._Source);
    if (!IsDownloading())
    {
      CoreHelper.WriteTraceEntry(TAG, ">> Download is already stopped!");
      return;
    }
    CoreHelper.WriteTraceEntry(TAG, ">> Download is in progress! Waitng for the download thread to stop!");
    this._StopDownload = true;
    if (this._WebRequest != null)
    {
      CoreHelper.WriteTraceEntry(TAG, ">> Awaitng Response! Canceling the request...");
      this._WebRequest.abort();
    }
    this._DownloadThreadIsDownloading = false;
    if (this._DownloadListener != null) {
      this._DownloadListener.OnDownloadTerminated(this);
    }
    CoreHelper.WriteTraceEntry(TAG, ">> Stop Download operation complete!");
  }
  
  public void run()
  {
    Process.setThreadPriority(10);
    this._StopDownload = false;
    this._Statistics = new DownloadStatistics();
    long l2 = 0L;
    long l1 = l2;
    int j;
    label359:
    int i;
    long l5;
    int k;
    try
    {
      if (AllowResume())
      {
        l1 = l2;
        if (this._Destination.exists()) {
          l1 = this._Destination.length();
        }
      }
      Statistics().StartPosition = l1;
      Statistics().Url = this._Source.toString();
      Statistics().SkipSize = IgnoreIfSize();
      Statistics().SkipDate = IgnoreIfNotModifiedSinceDate();
      this._ResourceLastModified = null;
      if (this._DownloadListener != null) {
        this._DownloadListener.OnDownloadStarted(this);
      }
      CoreHelper.WriteTraceEntry(TAG, "");
      CoreHelper.WriteTraceEntry(TAG, ">> -------------- Download of " + this._Source + " started from pos: " + l1 + "! --------------");
      WaitForInternetConnection();
      if (this._StopDownload)
      {
        CoreHelper.WriteTraceEntry(TAG, ">> Wait for Connection Canceled!");
        Statistics().Terminated = true;
        DoCleanup();
        return;
      }
      j = (int)l1;
      this._HttpClient.SetCredentialsTo(this._Credentials, this._Source);
      if (this._MustRequestReaderAuthToken)
      {
        CoreHelper.WriteTraceEntry(TAG, "Requesting Aggregator authentication...");
        String str = AggregatorLoginHelper.BlockingGetAuthToken();
        if ((StringUtils.IsNullOrEmpty(str)) && (this._Source.getHost().toLowerCase().contains("feedly.com")))
        {
          CoreHelper.WriteTraceEntry(TAG, "Not logged in!");
          Statistics().FinalDownloadUrl = this._Source;
          throw new AggregatorLoginHelper.AuthenticationException();
        }
      }
    }
    catch (WebException localWebException)
    {
      if (localWebException.StatusCode != 304) {
        break label1989;
      }
      Statistics().DownloadSkipped = true;
      CoreHelper.WriteTraceEntry(TAG, ">> Download skipped!");
      DoCleanup();
      if (this._ResourceContentLength != null) {
        break label1965;
      }
      l1 = 0L;
      if (this._ResourceContentLength != null) {
        break label1977;
      }
      l2 = 0L;
      OnDownloadProgress(l1, l2);
      OnDownloadCompleted(false);
      return;
      AddExtraHeader(AggregatorLoginHelper.AuthRequestHeader, localWebException);
      CoreHelper.WriteTraceEntry(TAG, "Reader authentication granted!");
      this._WebRequest = new HttpGet(this._Source);
      BeyondPodHttpClient.SetUserAgentTo(this._UserAgent, this._WebRequest);
      BeyondPodHttpClient.SetAcceptTo("*/*", this._WebRequest);
      BeyondPodHttpClient.SetAcceptEncodingTo("gzip", this._WebRequest);
      i = 200;
      if (!StringUtils.IsNullOrEmpty(this._RequestCookie)) {
        BeyondPodHttpClient.SetRequestCookie(this._RequestCookie, this._WebRequest);
      }
      Object localObject2;
      if (this._extraHeaders.size() > 0)
      {
        localObject2 = this._extraHeaders.iterator();
        if (((Iterator)localObject2).hasNext()) {}
      }
      else
      {
        if (IgnoreIfNotModifiedSinceDate() != null) {
          BeyondPodHttpClient.SetIfModifiedSinceTo(IgnoreIfNotModifiedSinceDate(), this._WebRequest);
        }
        if (j > 0)
        {
          BeyondPodHttpClient.SetRangeTo(j, this._ExpectedSize, this._WebRequest);
          i = 206;
        }
        Statistics().EventDate = new Date();
        l1 = System.currentTimeMillis();
        CoreHelper.WriteTraceEntry(TAG, ">> Sending Request...");
        CoreHelper.KeepDeviceAwake();
        this._WebResponse = this._HttpClient.execute(this._WebRequest);
        CoreHelper.KeepDeviceAwake();
        l5 = System.currentTimeMillis();
        localObject2 = Statistics();
        localObject4 = Statistics();
        l1 = l5 - l1;
        ((DownloadStatistics)localObject4).TimeToFirstByte = l1;
        ((DownloadStatistics)localObject2).DownloadTime = l1;
        CoreHelper.WriteTraceEntry(TAG, ">> Got Response... Status Code: " + this._WebResponse.getStatusLine().getStatusCode() + " (" + this._WebResponse.getStatusLine().getReasonPhrase() + "), expected code: " + i);
        k = this._WebResponse.getStatusLine().getStatusCode();
        if (k == i) {
          break label1121;
        }
        if (this._AllowRedirects) {
          break label2012;
        }
        if ((k == 301) || (k == 302)) {
          break label1121;
        }
        break label2012;
        if (this._Destination.exists())
        {
          CoreHelper.WriteTraceEntry(TAG, ">> Server does not support partial downloads! Deleting the partially downloaded file and Retrying...");
          this._Destination.delete();
        }
        throw new WebException(416, "Server does not support partial downloads!");
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        CoreHelper.WriteTraceEntry(TAG, ">> Error downloading: " + this._Source + ". Reason: " + localOutOfMemoryError.getMessage());
        DoCleanup();
        OnDownloadError(new Exception(localOutOfMemoryError));
        return;
        localObject4 = (RequestHeader)localOutOfMemoryError.next();
        BeyondPodHttpClient.SetHeader(this._WebRequest, ((RequestHeader)localObject4).Name, ((RequestHeader)localObject4).Value);
      }
    }
    catch (Exception localException)
    {
      label729:
      CoreHelper.WriteTraceEntry(TAG, ">> Error downloading: " + this._Source + ". Reason: " + CoreHelper.ExtractExceptionMessages(localException));
      if (Configuration.DebugDownloadProgress())
      {
        CoreHelper.Vibrate(CoreHelper.VIBRATE_LONG);
        CoreHelper.Vibrate(CoreHelper.VIBRATE_SHORT);
        CoreHelper.Vibrate(CoreHelper.VIBRATE_LONG);
      }
      DoCleanup();
      OnDownloadError(localException);
      return;
    }
    label939:
    if ((k == 401) && ((this._Source.getHost().toLowerCase().contains("google.com")) || (this._Source.getHost().toLowerCase().contains("feedly.com"))) && (!this._Source.getHost().toLowerCase().startsWith("feedproxy")))
    {
      CoreHelper.WriteTraceEntry(TAG, ">> Request Failed! Failed to authenticate against aggregator service!");
      throw new AggregatorLoginHelper.AuthenticationException();
    }
    CoreHelper.WriteTraceEntry(TAG, ">> Request Failed! Status Code: " + this._WebResponse.getStatusLine().getStatusCode() + " (" + this._WebResponse.getStatusLine().getReasonPhrase() + ")");
    throw new WebException(this._WebResponse.getStatusLine().getStatusCode(), this._WebResponse.getStatusLine().getReasonPhrase());
    label1121:
    this._ResponseCookie = BeyondPodHttpClient.GetResponseCookie(this._WebResponse);
    this._ContentDisposition = BeyondPodHttpClient.GetContentDisposition(this._WebResponse);
    this._ResourceContentLength = BeyondPodHttpClient.GetContentLengthFrom(this._WebResponse);
    this._ResourceLastModified = BeyondPodHttpClient.GetLastModifiedFrom(this._WebResponse);
    if (this._ResourceContentLength == null) {}
    for (l1 = 0L;; l1 = this._ResourceContentLength.longValue())
    {
      l1 = Math.max(l1, 2048000L);
      if (FlashStorageLocation.CheckIfSpaceIsAvailable(this._Destination.getParent(), l1)) {
        break label1297;
      }
      if (FileUtils.Exists(this._Destination.getParent())) {
        break;
      }
      throw new CoreHelper.IssuficientStorageSpaceException("Invalid download folder: " + this._Destination.getParent());
    }
    throw new CoreHelper.IssuficientStorageSpaceException(INSUFFICIENT_DISK_SPACE + " " + CoreHelper.GetFileLengthAsString(Long.valueOf(l1)));
    label1297:
    Statistics().TotalSize = this._ResourceContentLength;
    Statistics().ContentLastModifyDate = this._ResourceLastModified;
    Statistics().ResponseCookie = this._ResponseCookie;
    Statistics().ContentDisposition = this._ContentDisposition;
    Statistics().ContentEncoding = BeyondPodHttpClient.GetContentEncodingFrom(this._WebResponse);
    Statistics().FinalDownloadUrl = this._HttpClient.FinalDownloadUrl();
    Object localObject4 = TAG;
    Object localObject5 = new StringBuilder(">> Downloading Response Stream... ");
    if (this._ContentDisposition != null) {}
    for (Object localObject3 = " for file: " + this._ContentDisposition;; localObject3 = "")
    {
      CoreHelper.WriteTraceEntry((String)localObject4, (String)localObject3);
      this._WebResponseStream = BeyondPodHttpClient.getUngzippedContent(this._WebResponse.getEntity());
      if (0L > 0L) {
        this._WebResponseStream.skip(0L);
      }
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (AllowResume())
      {
        bool1 = bool2;
        if (this._Destination.exists())
        {
          bool1 = bool2;
          if (this._Destination.isFile()) {
            bool1 = true;
          }
        }
      }
      this._LocalStream = new FileOutputStream(this._Destination, bool1);
      localObject4 = new byte[32768];
      l2 = j;
      l1 = l2;
      long l3;
      if (this._ResourceContentLength == null) {
        l3 = 0L;
      }
      for (;;)
      {
        if (!this._StopDownload)
        {
          i = this._WebResponseStream.read((byte[])localObject4);
          if (i > 0) {
            break label1651;
          }
        }
        for (;;)
        {
          Statistics().DownloadedSize = Long.valueOf(l2);
          DoCleanup();
          if (this._StopDownload) {
            break label1947;
          }
          Statistics().DownloadTime = (System.currentTimeMillis() - l5);
          if (!Statistics().InidicatesReaderLoginFailure()) {
            break label1909;
          }
          CoreHelper.WriteTraceEntry(TAG, ">> Download completed, but there was a Aggregator Authentication Error!");
          OnDownloadError(new AggregatorLoginHelper.AuthenticationException());
          return;
          l3 = this._ResourceContentLength.longValue();
          break label2036;
          label1651:
          if (!Thread.interrupted()) {
            break;
          }
          CoreHelper.WriteTraceEntry(TAG, ">> The download thread was aborted when downloading: " + this._Source);
          this._WebRequest.abort();
          this._StopDownload = true;
        }
        l2 += i;
        long l4 = l1;
        Object localObject1;
        label1727:
        StringBuilder localStringBuilder;
        if (Configuration.DebugDownloadProgress())
        {
          if (localObject1 != 0L) {
            break label1877;
          }
          l3 = 1000000L;
          l4 = l1;
          if (l2 - l1 > l3)
          {
            localObject5 = TAG;
            localStringBuilder = new StringBuilder(">> Downloading content... ");
            if (localObject1 != 0L) {
              break label1888;
            }
          }
        }
        label1877:
        label1888:
        for (localObject3 = (int)((float)l2 / 1024.0D) + " K";; localObject3 = Integer.valueOf((int)((float)l2 / (float)localObject1 * 100.0D)))
        {
          CoreHelper.WriteTraceEntry((String)localObject5, localObject3 + " %");
          l4 = l2;
          CoreHelper.Vibrate(CoreHelper.VIBRATE_SHORT);
          this._LocalStream.write((byte[])localObject4, 0, i);
          OnDownloadProgress(l2, localObject1);
          l1 = l4;
          if (!IsUnAuthorizedMobileDataConnection()) {
            break;
          }
          CoreHelper.WriteLogEntryInProduction(TAG, "!!!!!! Detected unauthorized mobile connection! Aborting Download!");
          throw new CoreHelper.UnableToEstablishNetworkConnectionException("Update or Download was interrupted because mobile connections are NOT allowed, and the WiFi connection has disconnected.");
          l3 = localObject1 / 100L;
          break label1727;
        }
        label1909:
        Statistics().CompletedNormaly = true;
        CoreHelper.WriteTraceEntry(TAG, ">> Download completed!");
        if (this._ResourceContentLength == null) {
          OnDownloadProgress(l2, l2);
        }
        OnDownloadCompleted(true);
        return;
        label1947:
        CoreHelper.WriteTraceEntry(TAG, ">> Download Canceled!");
        Statistics().Terminated = true;
        return;
        label1965:
        l1 = this._ResourceContentLength.longValue();
        break;
        label1977:
        l2 = this._ResourceContentLength.longValue();
        break label359;
        label1989:
        if (Configuration.DebugDownloadProgress()) {
          CoreHelper.Vibrate(CoreHelper.VIBRATE_LONG);
        }
        DoCleanup();
        OnDownloadError((Exception)localObject3);
        return;
        label2012:
        if ((k == 200) && (i == 206)) {
          break label729;
        }
        if (k != 416) {
          break label939;
        }
        break label729;
        label2036:
        long l6 = l3 + j;
      }
    }
  }
  
  public void setDownloadListenter(DownloadListener paramDownloadListener)
  {
    this._DownloadListener = paramDownloadListener;
  }
  
  public static abstract interface DownloadListener
  {
    public abstract void OnDownloadCompleted(DownloadAgent paramDownloadAgent, boolean paramBoolean);
    
    public abstract void OnDownloadError(DownloadAgent paramDownloadAgent, Exception paramException);
    
    public abstract void OnDownloadProgress(DownloadAgent paramDownloadAgent, long paramLong1, long paramLong2);
    
    public abstract void OnDownloadStarted(DownloadAgent paramDownloadAgent);
    
    public abstract void OnDownloadTerminated(DownloadAgent paramDownloadAgent);
  }
  
  public static class RequestHeader
  {
    public String Name;
    public String Value;
    
    public RequestHeader(String paramString1, String paramString2)
    {
      this.Name = paramString1;
      this.Value = paramString2;
    }
  }
  
  static class WebException
    extends Exception
  {
    private static final long serialVersionUID = -6829746333153305412L;
    int StatusCode = -1;
    
    public WebException(int paramInt, String paramString)
    {
      super();
      this.StatusCode = paramInt;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/downloadengine/DownloadAgent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */