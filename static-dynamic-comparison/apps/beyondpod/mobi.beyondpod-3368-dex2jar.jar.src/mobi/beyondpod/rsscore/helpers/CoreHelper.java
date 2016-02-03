package mobi.beyondpod.rsscore.helpers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.downloadengine.BeyondPodHttpClient;
import mobi.beyondpod.downloadengine.DownloadStatisticsList;
import mobi.beyondpod.downloadengine.EnclosureDownloadManager;
import mobi.beyondpod.downloadengine.ProcessStatistics;
import mobi.beyondpod.downloadengine.ProcessStatistics.ProcessedFeedList;
import mobi.beyondpod.downloadengine.RssFeedUpdateManager;
import mobi.beyondpod.downloadengine.UpdateAndDownloadManager;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.events.ApplicationEvents.ApplicationErrorEvent;
import mobi.beyondpod.rsscore.repository.FlashStorageLocation;
import mobi.beyondpod.rsscore.repository.RepositoryPersistence;
import mobi.beyondpod.rsscore.rss.LicenseManager;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;

public class CoreHelper
{
  public static final int ALLOW_DELATIONS_Allow = 0;
  public static final int ALLOW_DELATIONS_DoNotAllow = 1;
  public static final int ALLOW_DELATIONS_UseParentSetting = 2;
  public static final int ALLOW_STREAMING_ALWAYS = 0;
  public static final int ALLOW_STREAMING_NONE = 2;
  public static final int ALLOW_STREAMING_WIFI_ONLY = 1;
  public static final int APP_STORE_AMAZON = 2;
  public static final int APP_STORE_ANDROID_MARKET = 1;
  public static final int APP_STORE_UNKNOWN = 0;
  public static final int CDS_ALLOW_REMOTE_FEED_ADD_ALWAYS = 1;
  public static final int CDS_ALLOW_REMOTE_FEED_ADD_NEVER = 0;
  public static final int CDS_ALLOW_REMOTE_FEED_ADD_PUSH_ONLY = 2;
  public static final int DOWNLOAD_STATUS_Connecting = 1;
  public static final int DOWNLOAD_STATUS_Downloaded = 3;
  public static final int DOWNLOAD_STATUS_Downloading = 2;
  public static final int DOWNLOAD_STATUS_Error = 5;
  public static final int DOWNLOAD_STATUS_PreparingForDownload = 6;
  public static final int DOWNLOAD_STATUS_Stopped = 4;
  public static final int DOWNLOAD_STATUS_Unknown = 0;
  public static final int EPISODE_FILTER_Audio_Only = 1;
  public static final int EPISODE_FILTER_Downloaded_Only = 3;
  public static final int EPISODE_FILTER_Locked = 5;
  public static final int EPISODE_FILTER_None = 0;
  public static final int EPISODE_FILTER_Not_Played = 6;
  public static final int EPISODE_FILTER_Unfinished = 4;
  public static final int EPISODE_FILTER_Video_Only = 2;
  public static final int FEED_TYPE_AudioBook = 6;
  public static final int FEED_TYPE_GReaderFeed = 5;
  public static final int FEED_TYPE_LocalFolder = 1;
  public static final int FEED_TYPE_OPMLFeed = 4;
  public static final int FEED_TYPE_RSSFeed = 2;
  public static final int FEED_TYPE_RSSFeedWithPodcasts = 3;
  public static final int FEED_TYPE_Unknown = 0;
  private static final float GB = 1.07374182E9F;
  public static final int HEADSET_REMOTE_ACTION_NEXT_TRACK = 1;
  public static final int HEADSET_REMOTE_ACTION_PREV_TRACK = 2;
  public static final int HEADSET_REMOTE_ACTION_SKIP_BACK = 4;
  public static final int HEADSET_REMOTE_ACTION_SKIP_FORWARD = 3;
  public static final int HEADSET_REMOTE_ACTION_SKIP_TO_END = 5;
  public static final int ITEM_FILTER_Downloaded_Only = 3;
  public static final int ITEM_FILTER_Local_Only = 2;
  public static final int ITEM_FILTER_None = 0;
  public static final int ITEM_FILTER_Unread_Only = 1;
  public static final int ITEM_ID_ALGORITHM_FP_TITLE_LINK_PUB_DATE = 1;
  public static final int ITEM_ID_ALGORITHM_ITEM_GUID = 2;
  public static final int ITEM_ID_ALGORITHM_TITLE = 4;
  public static final int ITEM_ID_ALGORITHM_TITLE_LINK = 3;
  public static final int ITEM_ID_ALGORITHM_UNKNOWN = -1;
  public static final int MARK_AS_READ_ON_OPEN_AllFeeds = 2;
  public static final int MARK_AS_READ_ON_OPEN_NonPodcastFeeds = 1;
  public static final int MARK_AS_READ_ON_OPEN_None = 0;
  private static final float MB = 1048576.0F;
  public static final int MEDIA_END_ACTION_DeleteAndDoNothing = 3;
  public static final int MEDIA_END_ACTION_DeleteAndPlayNext = 1;
  public static final int MEDIA_END_ACTION_DoNothing = 2;
  public static final int MEDIA_END_ACTION_PlayNext = 0;
  public static final int MillisecondsInDay = 86400000;
  public static final int ORIENTATION_AUTO = 0;
  public static final int ORIENTATION_LOCKED_LANDSCAPE = 2;
  public static final int ORIENTATION_LOCKED_PORTRAIT = 1;
  public static final int ORIENTATION_STICKY_PLAYER = 3;
  @SuppressLint({"SdCardPath"})
  static String[] OptionalStorageMounts = { "/emmc", "/mnt/sdcard/external_sd", "/mnt/external_sd", "/sdcard/sd", "/mnt/sdcard/bpemmctest", "/mnt/sdcard/_ExternalSD", "/mnt/sdcard-ext", "/mnt/Removable/MicroSD", "/Removable/MicroSD", "/mnt/external1", "/mnt/extSdCard", "/storage/sdcard1" };
  public static final int PLAYER_INTEGRATION_UseDefault = -1;
  public static final int PLAYER_INTEGRATION_UseExternal = 3;
  public static final int PLAYER_INTEGRATION_UseExternalAudioPlayer = 2;
  public static final int PLAYER_INTEGRATION_UseExternalVideoPlayer = 1;
  public static final int PLAYER_INTEGRATION_UseInternalPlayer = 0;
  public static final int PLAYER_PLAYBACK_SCREEN_POWER_STATE_AlwaysBright = 4;
  public static final int PLAYER_PLAYBACK_SCREEN_POWER_STATE_AlwaysDim = 3;
  public static final int PLAYER_PLAYBACK_SCREEN_POWER_STATE_AlwaysOff = 0;
  public static final int PLAYER_PLAYBACK_SCREEN_POWER_STATE_BrightIfCharging = 2;
  public static final int PLAYER_PLAYBACK_SCREEN_POWER_STATE_DimIfCharging = 1;
  public static final int PLAY_STATE_Error = 7;
  public static final int PLAY_STATE_Error_Cant_Cast = 9;
  public static final int PLAY_STATE_Error_Streaming_Disabled = 8;
  public static final int PLAY_STATE_Paused = 0;
  public static final int PLAY_STATE_Playing = 1;
  public static final int PLAY_STATE_Prepared = 4;
  public static final int PLAY_STATE_Preparing = 3;
  public static final int PLAY_STATE_Seeking = 6;
  public static final int PLAY_STATE_Stop = 2;
  public static final int PLAY_STATE_Unknown = -1;
  public static final int PODCAST_DOWNLOAD_ACTION_CreateStreamableTrack = 2;
  public static final int PODCAST_DOWNLOAD_ACTION_CreateStreamableTrack_InOrder = 5;
  public static final int PODCAST_DOWNLOAD_ACTION_DoNotDownload = 0;
  public static final int PODCAST_DOWNLOAD_ACTION_DownloadPodcast = 1;
  public static final int PODCAST_DOWNLOAD_ACTION_DownloadPodcasts_In_Order = 4;
  public static final int PODCAST_DOWNLOAD_ACTION_IgnoreTracks = 3;
  public static final int PODCAST_NAMING_SCHEME_POST_FILE_NAME = 2;
  public static final int PODCAST_NAMING_SCHEME_POST_ID3_TAG_NAME = 1;
  public static final int PODCAST_NAMING_SCHEME_POST_TITLE = 0;
  public static final int REPOSITORY_LOAD_KIND_Backup = 2;
  public static final int REPOSITORY_LOAD_KIND_LongTermBackup = 3;
  public static final int REPOSITORY_LOAD_KIND_Normal = 1;
  public static final int REPOSITORY_LOAD_KIND_RecoveryFailed = 0;
  public static final int REPOSITORY_LOAD_KIND_Unknown = -1;
  public static final int REPOSITORY_STATE_Loaded = 2;
  public static final int REPOSITORY_STATE_Loading = 0;
  public static final int REPOSITORY_STATE_Saving = 3;
  public static final int REPOSITORY_STATE_ScanningForPodcasts = 1;
  public static final int REPOSITORY_STATE_Uninitialized = -1;
  public static final int SCREEN_POWER_STATE_DURING_WIFI_UPDATES_ALWAYS_OFF = 2;
  public static final int SCREEN_POWER_STATE_DURING_WIFI_UPDATES_ALWAYS_ON = 1;
  public static final int SCREEN_POWER_STATE_DURING_WIFI_UPDATES_AUTOMATIC = 0;
  public static final int SORT_ORDER_ByDateAsc = 2;
  public static final int SORT_ORDER_ByDateDesc = 3;
  public static final int SORT_ORDER_ByFileNameAsc = 8;
  public static final int SORT_ORDER_ByFileNameDesc = 9;
  public static final int SORT_ORDER_ByFileSizeDesc = 10;
  public static final int SORT_ORDER_ByMediaTypeAsc = 7;
  public static final int SORT_ORDER_ByNameAsc = 0;
  public static final int SORT_ORDER_ByNameDesc = 1;
  public static final int SORT_ORDER_ByPlayedPortionAsc = 6;
  public static final int SORT_ORDER_ByTotalTimeAsc = 4;
  public static final int SORT_ORDER_ByTotalTimeDesc = 5;
  public static final int SORT_ORDER_Random = 100;
  public static final int SORT_ORDER_Unknown = -1;
  public static final int STARTUP_VIEW_CATEGORIES = 3;
  public static final int STARTUP_VIEW_FEEDS = 0;
  public static final int STARTUP_VIEW_PLAYER = 2;
  public static final int STARTUP_VIEW_PODCASTS = 1;
  public static final int STREAM_TYPE_InternetStream = 1;
  public static final int STREAM_TYPE_LocalFile = 0;
  public static final int STREAM_TYPE_RSSFeed = 2;
  public static final int STREAM_TYPE_Unknown = 3;
  private static final String TAG = CoreHelper.class.getSimpleName();
  public static final int TRACK_CONTENT_TYPE_Audio = 1;
  public static final int TRACK_CONTENT_TYPE_Image = 3;
  public static final int TRACK_CONTENT_TYPE_Unavailalble = -1;
  public static final int TRACK_CONTENT_TYPE_Unknown = 0;
  public static final int TRACK_CONTENT_TYPE_Unspecified = -2;
  public static final int TRACK_CONTENT_TYPE_Video = 2;
  public static final int TRACK_PLAYABLE_STATE_CurrentlyDownloading = 5;
  public static final int TRACK_PLAYABLE_STATE_LocalTrackExistsAndFullyDownloaded = 0;
  public static final int TRACK_PLAYABLE_STATE_LocalTrackExistsAndFullyDownloadedAndPlaying = 6;
  public static final int TRACK_PLAYABLE_STATE_LocalTrackExistsAndPartiallyDownloaded = 1;
  public static final int TRACK_PLAYABLE_STATE_NoTrackExists_InHistory = 3;
  public static final int TRACK_PLAYABLE_STATE_NoTrackExists_NotInHistory = 4;
  public static final int TRACK_PLAYABLE_STATE_StreamableTrackExists = 2;
  public static final int TRACK_PLAYABLE_STATE_StreamableTrackExistsAndPlaying = 7;
  public static final int UI_MODE_DEFAULT = 0;
  public static final int UI_MODE_GOOGLE_TV = 2;
  public static final int UI_MODE_TOUCHSCREEN = 1;
  public static int VIBRATE_LONG = 0;
  public static int VIBRATE_SHORT = 0;
  public static final int VOLUME_NAVIGATION_OFF = 1;
  public static final int VOLUME_NAVIGATION_OFF_IF_PLAYING = 0;
  public static final int VOLUME_NAVIGATION_ON = 2;
  public static final int WIDGET_BG_COLOR_DARK = 1;
  public static final int WIDGET_BG_COLOR_LIGHT = 2;
  public static final int WIDGET_BG_COLOR_NONE = 3;
  private static Boolean _CGBuild = null;
  private static int _HtmlPadding;
  static long _LastTraceTime;
  static Thread _RedirectFollowerThread;
  static Runnable _SaveStatisticsRunnable;
  static Handler _TraceBroadcastHandler;
  private static final String[] _decoded;
  private static final String[] _empty;
  private static final String[] _encoded;
  private static final String[] _html;
  private static Pattern _htmlTags;
  private static Pattern _nl;
  private static StringBuilder sFormatBuilder = new StringBuilder();
  private static Formatter sFormatter = new Formatter(sFormatBuilder, Locale.getDefault());
  private static final Object[] sTimeArgs = new Long[5];
  
  static
  {
    _SaveStatisticsRunnable = new Runnable()
    {
      public void run() {}
    };
    _RedirectFollowerThread = new Thread();
    _encoded = new String[] { "&lt;", "&gt;", "&amp;", "&apos;", "&quot;", "&#39;", "&#039;", "&nbsp;", "&raquo;", "&laquo;", "&#8220;", "&rsquo;" };
    _decoded = new String[] { "<", ">", "&", "'", "\"", "'", "'", "", "", "", "'", "'" };
    _html = new String[] { "<b>", "</b>", "<i>", "</i>", "\n" };
    _empty = new String[] { "", "", "", "", "" };
    _htmlTags = Pattern.compile("<style.*/style>|<[^>]*>|&#[0-9]*;|\\s{3,}", 32);
    _nl = Pattern.compile("\r\n|[\r\n]", 32);
    _HtmlPadding = 100;
    VIBRATE_SHORT = 30;
    VIBRATE_LONG = 90;
  }
  
  public static void AnalyzeStatisticsAndNotify()
  {
    if (RssFeedUpdateManager.Statistics().HasAnySDCardCorruptionFalures()) {
      BeyondPodApplication.MessageBus.PublishEventAsync(new ApplicationEvents.ApplicationErrorEvent(new Exception("Unable to write to SD Card!"), 0));
    }
    do
    {
      return;
      if (RssFeedUpdateManager.Statistics().HasAnyReaderLoginFalures())
      {
        BeyondPodApplication.MessageBus.PublishEventAsync(new ApplicationEvents.ApplicationErrorEvent(new Exception("Invalid or expired Feedly login! (You can modify your Feedly login in: Add Feed > Import Feeds > Import from Feedly)"), 1));
        return;
      }
      if (RssFeedUpdateManager.Statistics().HasAnyFailedDownloads())
      {
        BeyondPodApplication.MessageBus.PublishEventAsync(new ApplicationEvents.ApplicationErrorEvent(new Exception("Download Failed!"), 5));
        return;
      }
      Iterator localIterator = UpdateAndDownloadManager.Statistics().iterator();
      ProcessStatistics localProcessStatistics;
      do
      {
        if (!localIterator.hasNext())
        {
          if (!EnclosureDownloadManager.Statistics().HasAnySDCardCorruptionFalures()) {
            break;
          }
          BeyondPodApplication.MessageBus.PublishEventAsync(new ApplicationEvents.ApplicationErrorEvent(new Exception("Unable to write to SD Card!"), 0));
          return;
        }
        localProcessStatistics = (ProcessStatistics)localIterator.next();
        if (localProcessStatistics.PodcastDownloadSkipped_DeviceIsNotPluggedIn)
        {
          BeyondPodApplication.MessageBus.PublishEventAsync(new ApplicationEvents.ApplicationErrorEvent(localProcessStatistics.LastException, 3));
          return;
        }
      } while (!localProcessStatistics.PodcastDownloadSkipped_WiFiNotDetected);
      BeyondPodApplication.MessageBus.PublishEventAsync(new ApplicationEvents.ApplicationErrorEvent(localProcessStatistics.LastException, 4));
      return;
    } while (!EnclosureDownloadManager.Statistics().HasAnyFailedDownloads());
    BeyondPodApplication.MessageBus.PublishEventAsync(new ApplicationEvents.ApplicationErrorEvent(new Exception("Download Failed!"), 5));
  }
  
  public static int ApiLevel()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static File AutodetectExternalStorageDirectoryInternal()
  {
    File localFile1 = Environment.getExternalStorageDirectory();
    File localFile2 = GetOptionalStorageMount();
    boolean bool1 = false;
    if (localFile2 != null) {}
    try
    {
      bool1 = Configuration.ConstructBeyondPodRootIn(localFile2.getPath()).exists();
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          bool2 = Configuration.ConstructBeyondPodRootIn(localFile1.getPath()).exists();
          if (!bool2) {
            break;
          }
          return localFile1;
          localException1 = localException1;
          bool1 = false;
        }
      }
      catch (Exception localException2)
      {
        String str;
        do
        {
          for (;;)
          {
            boolean bool2 = false;
          }
          if (bool1) {
            return localFile2;
          }
          str = Environment.getExternalStorageState();
        } while (("mounted".equals(str)) || ("shared".equals(str)) || ("unmounted".equals(str)) || (localFile2 == null));
      }
    }
    return localFile2;
  }
  
  static void BackUpExistingUpdateLog()
  {
    Object localObject2 = GetUpdateLogs();
    label11:
    int i;
    if (((ArrayList)localObject2).size() == 0) {
      return;
    } else {
      i = Math.min(((ArrayList)localObject2).size(), 9);
    }
    for (;;)
    {
      if (i >= ((ArrayList)localObject2).size())
      {
        Object localObject1 = Configuration.FeedUpdateLogFilePath();
        Iterator localIterator = ((ArrayList)localObject2).iterator();
        if (!localIterator.hasNext()) {
          break label11;
        }
        localObject2 = (File)localIterator.next();
        if (!((String)localObject1).equals(((File)localObject2).getAbsolutePath())) {
          break;
        }
        localObject1 = new File(((File)localObject2).getAbsolutePath().replace(".htm", "_" + System.currentTimeMillis() + ".htm"));
        ((File)localObject2).renameTo((File)localObject1);
        WriteTraceEntry(TAG, "The existing update log was backed up as: " + ((File)localObject1).getName());
        return;
      }
      if (((File)((ArrayList)localObject2).get(i)).delete()) {
        WriteTraceEntry(TAG, "Deleted old update log backup: " + ((File)((ArrayList)localObject2).get(i)).getName());
      }
      i += 1;
    }
  }
  
  public static CharSequence CleanHtmlTags(CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    int m = 0;
    if (TextUtils.isEmpty(paramCharSequence))
    {
      paramCharSequence = "";
      return paramCharSequence;
    }
    int i;
    label32:
    CharSequence localCharSequence;
    int j;
    if (paramCharSequence.length() > _HtmlPadding + paramInt)
    {
      i = 1;
      Pattern localPattern = _htmlTags;
      localCharSequence = paramCharSequence;
      if (i != 0) {
        localCharSequence = paramCharSequence.subSequence(0, _HtmlPadding + paramInt);
      }
      paramCharSequence = localPattern.matcher(localCharSequence).replaceAll("");
      paramCharSequence = _nl.matcher(htmlDecode(paramCharSequence)).replaceAll(" ");
      j = paramCharSequence.length();
      paramInt = 0;
      label99:
      if ((paramInt < j) && (paramCharSequence.charAt(paramInt) <= ' ')) {
        break label214;
      }
    }
    for (;;)
    {
      if ((j <= paramInt) || (paramCharSequence.charAt(j - 1) > ' '))
      {
        int k = m;
        if (i != 0)
        {
          k = m;
          if (j - paramInt > _HtmlPadding) {
            k = _HtmlPadding;
          }
        }
        localCharSequence = paramCharSequence.subSequence(paramInt, j - k);
        paramCharSequence = localCharSequence;
        if (i == 0) {
          break;
        }
        paramCharSequence = localCharSequence;
        if (!paramBoolean) {
          break;
        }
        return new StringBuilder(localCharSequence).append("…");
        i = 0;
        break label32;
        label214:
        paramInt += 1;
        break label99;
      }
      j -= 1;
    }
  }
  
  public static boolean CopyAssetToFile(String paramString, File paramFile)
  {
    try
    {
      paramString = BeyondPodApplication.GetInstance().getResources().getAssets().open(paramString);
      DataOutputStream localDataOutputStream = new DataOutputStream(new FileOutputStream(paramFile));
      byte[] arrayOfByte = new byte['က'];
      for (;;)
      {
        int i = paramString.read(arrayOfByte);
        if (i == -1)
        {
          localDataOutputStream.close();
          paramString.close();
          return true;
        }
        localDataOutputStream.write(arrayOfByte, 0, i);
      }
      return false;
    }
    catch (Exception paramString)
    {
      LogException(TAG, "Failed to copy asset resource to " + paramFile, paramString);
    }
  }
  
  public static boolean CopyResToFile(int paramInt, File paramFile)
  {
    try
    {
      InputStream localInputStream = BeyondPodApplication.GetInstance().getResources().openRawResource(paramInt);
      DataOutputStream localDataOutputStream = new DataOutputStream(new FileOutputStream(paramFile));
      byte[] arrayOfByte = new byte['က'];
      for (;;)
      {
        paramInt = localInputStream.read(arrayOfByte);
        if (paramInt == -1)
        {
          localDataOutputStream.close();
          localInputStream.close();
          return true;
        }
        localDataOutputStream.write(arrayOfByte, 0, paramInt);
      }
      return false;
    }
    catch (Exception localException)
    {
      LogException(TAG, "Failed to copy raw resource to " + paramFile, localException);
    }
  }
  
  public static String CreateFileNameFromUrl(String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4)
  {
    String str2 = SafeDecodeUrl(Path.GetFileName(paramString1));
    int i = str2.indexOf("?");
    int j = str2.indexOf("&");
    String str1 = MimeTypeMap.getFileExtensionFromUrl(paramString1);
    if (StringUtils.Equals(str2, "redirect.mp3")) {
      paramBoolean = true;
    }
    if (StringUtils.IsNullOrEmpty(str1)) {
      paramBoolean = true;
    }
    if (j >= 0) {
      paramBoolean = true;
    }
    if (i >= 0) {
      paramBoolean = true;
    }
    if (paramBoolean)
    {
      paramString1 = str1;
      if (StringUtils.IsNullOrEmpty(str1))
      {
        paramString1 = str1;
        if (!StringUtils.IsNullOrEmpty(paramString4))
        {
          str1 = MimeTypeMap.getSingleton().getExtensionFromMimeType(paramString4);
          paramString1 = str1;
          if (StringUtils.IsNullOrEmpty(str1)) {
            paramString1 = MediaFile.getFileExtensionForType(MediaFile.getFileTypeForMimeType(paramString4));
          }
        }
      }
      if (!StringUtils.IsNullOrEmpty(paramString1))
      {
        paramString4 = paramString1;
        if (!"mpga".equals(paramString1)) {}
      }
      else
      {
        paramString4 = "mp3";
      }
      return String.format("%s%s.%s", new Object[] { MakeValidPodcastName(paramString2), Integer.valueOf(paramString3.hashCode()), paramString4 });
    }
    paramString1 = MakeValidFileName(str2);
    if (i < 0) {
      return paramString1;
    }
    i = paramString1.lastIndexOf("=");
    if ((i >= 0) && (i < paramString1.length() - 2)) {
      return paramString1.substring(i + 1);
    }
    return paramString1;
  }
  
  public static String DumpEnvironment()
  {
    for (;;)
    {
      Object localObject2;
      StringBuilder localStringBuilder1;
      try
      {
        File localFile = Environment.getExternalStorageDirectory();
        localObject2 = GetOptionalStorageMount();
        Object localObject3 = Configuration.findAndroidReportedExternalStorage();
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("BeyondPod Version: " + Configuration.ProductVersion() + LicenseManager.GetShortLicenseKind() + "\n\n");
        localStringBuilder1.append("DEVICE: " + Build.MANUFACTURER + " " + Build.MODEL + " (" + Build.PRODUCT + ") with Android " + Build.VERSION.RELEASE + "\n\n");
        localStringBuilder1.append("DEVICE STORAGE\n\n");
        StringBuilder localStringBuilder2 = new StringBuilder("• SD Card Root: ").append(localFile.getPath());
        if (!localFile.canWrite()) {
          break label1395;
        }
        Object localObject1 = "";
        localStringBuilder1.append((String)localObject1 + "\n");
        if (localObject2 != null)
        {
          localStringBuilder2 = new StringBuilder("• Optional Root: ").append(((File)localObject2).getPath());
          if (!((File)localObject2).canWrite()) {
            break label1403;
          }
          localObject1 = "";
          localStringBuilder1.append((String)localObject1 + "\n");
        }
        if (localObject3 != null)
        {
          localStringBuilder2 = new StringBuilder("• Application root on external SD: ").append(((File)localObject3).getPath());
          if (!isFolderReallyWritable((File)localObject3)) {
            break label1411;
          }
          localObject1 = "";
          localStringBuilder1.append((String)localObject1 + "\n");
        }
        localObject3 = new StringBuilder("• Cached SD Card Root: ").append(Configuration.LastSDCardRootPath()).append(" (");
        if (!Configuration.PreferLastSDCardRoot()) {
          break label1419;
        }
        localObject1 = "use cached root, ";
        localObject3 = ((StringBuilder)localObject3).append((String)localObject1);
        if (!Configuration.KeepMetadataForMissingEpisodes()) {
          break label1427;
        }
        localObject1 = "keep";
        localStringBuilder1.append((String)localObject1 + " missing episodes)\n");
        localStringBuilder1.append("• External SD State: " + Environment.getExternalStorageState() + "\n");
        localObject1 = Configuration.ConstructBeyondPodRootIn(localFile.getPath());
        localStringBuilder1.append("• BP location on SD: " + localObject1 + ", Exists: " + ((File)localObject1).exists() + "\n");
        if (localObject2 != null)
        {
          localObject1 = Configuration.ConstructBeyondPodRootIn(((File)localObject2).getPath());
          localStringBuilder1.append("• BP location on Optional: " + localObject1 + ", Exists: " + ((File)localObject1).exists() + "\n");
        }
        localStringBuilder1.append("• BP will use: " + Configuration.BeyondPodPublicStorageRootPath() + "\n");
        long l = new FlashStorageLocation(Configuration.BeyondPodPublicStorageRootPath()).FreeSpace();
        localStringBuilder1.append("• Free space: " + GetFileLengthAsString(Long.valueOf(l)) + "\n\n");
        localStringBuilder1.append("\nBATTERY INFO\n\n");
        localStringBuilder1.append("• Status: " + BeyondPodApplication.BatteryStatus + "\n");
        localStringBuilder1.append("• Level: " + BeyondPodApplication.BatteryLevel + "\n");
        localStringBuilder1.append("• Plugged In: " + BeyondPodApplication.BatteryPlugged + "\n");
        localStringBuilder1.append("• Is Charging? " + IsDeviceCharging() + "\n");
        localStringBuilder1.append("• Is Plugged In? " + IsDevicePlugged() + "\n");
        localStringBuilder1.append("\n\nFEEDLY INFO\n\n");
        localObject2 = new StringBuilder("• Logged In: ");
        if (StringUtils.IsNullOrEmpty(Configuration.OAuthAccessToken())) {
          break label1435;
        }
        localObject1 = "Yes";
        localStringBuilder1.append((String)localObject1 + "\n");
        localObject1 = Configuration.OAuthAccessTokenExpiration();
        if (((Date)localObject1).getTime() > 100L) {
          localStringBuilder1.append("• Log In Expires: " + DateTime.FormatTime((Date)localObject1) + " " + DateTime.FormatDate((Date)localObject1) + "\n");
        }
        localObject2 = new StringBuilder("• Has User: ");
        if (StringUtils.IsNullOrEmpty(Configuration.OAuthUser())) {
          break label1443;
        }
        localObject1 = "Yes";
        localStringBuilder1.append((String)localObject1 + "\n");
        localObject2 = new StringBuilder("• Can Re-Log in: ");
        if (StringUtils.IsNullOrEmpty(Configuration.OAuthRefreshToken())) {
          break label1451;
        }
        localObject1 = "Yes";
        localStringBuilder1.append((String)localObject1 + "\n");
        localStringBuilder1.append("\n\nAPPLICATION INFO\n\n");
        localObject2 = new StringBuilder("• Playback Speed Enabled: ");
        if (!Configuration.EnableAudioPlugins()) {
          break label1459;
        }
        localObject1 = "Yes";
        localStringBuilder1.append((String)localObject1 + "\n");
        localObject2 = new StringBuilder("• CDS Enabled: ");
        if (!Configuration.CDSEnabled()) {
          break label1467;
        }
        localObject1 = "Yes";
        localStringBuilder1.append((String)localObject1 + "\n");
        localObject1 = (ConnectivityManager)BeyondPodApplication.GetInstance().getSystemService("connectivity");
        if (localObject1 == null)
        {
          localStringBuilder1.append("•  Failed to retrieve device ConnectivityManager!");
          return localStringBuilder1.toString();
        }
        localObject1 = ((ConnectivityManager)localObject1).getAllNetworkInfo();
        localStringBuilder1.append("\nNETWORK CONNECTIONS (" + localObject1.length + ")\n\n");
        if (localObject1.length == 0)
        {
          localStringBuilder1.append("•  There are no network connections!");
          continue;
        }
        j = localException.length;
      }
      catch (Exception localException)
      {
        return "Failed to determine SD card location! Reason: " + localException.getMessage();
      }
      int j;
      int i = 0;
      while (i < j)
      {
        localObject2 = localException[i];
        localStringBuilder1.append("•  Type: " + ((NetworkInfo)localObject2).getTypeName() + " (" + ((NetworkInfo)localObject2).getSubtypeName() + ")");
        localStringBuilder1.append(", Available: " + ((NetworkInfo)localObject2).isAvailable());
        localStringBuilder1.append(", Connected: " + ((NetworkInfo)localObject2).isConnected());
        localStringBuilder1.append(", State: " + ((NetworkInfo)localObject2).getState().name());
        localStringBuilder1.append(", Roaming: " + ((NetworkInfo)localObject2).isRoaming() + "\n");
        i += 1;
      }
      label1395:
      String str = " (Read Only)";
      continue;
      label1403:
      str = " (Read Only)";
      continue;
      label1411:
      str = " (Read Only)";
      continue;
      label1419:
      str = "autodetect root, ";
      continue;
      label1427:
      str = "delete";
      continue;
      label1435:
      str = "No";
      continue;
      label1443:
      str = "No";
      continue;
      label1451:
      str = "No";
      continue;
      label1459:
      str = "No";
      continue;
      label1467:
      str = "No";
    }
  }
  
  public static void DumpUpdateStatistics()
  {
    RepositoryPersistence.RepositoryHandler().removeCallbacks(_SaveStatisticsRunnable);
    RepositoryPersistence.RepositoryHandler().postDelayed(_SaveStatisticsRunnable, 500L);
  }
  
  /* Error */
  private static void DumpUpdateStatisticsInternal()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_2
    //   6: astore_1
    //   7: invokestatic 1047	mobi/beyondpod/rsscore/Configuration:EnableLoggingInProduction	()Z
    //   10: ifeq +8 -> 18
    //   13: aload_2
    //   14: astore_1
    //   15: invokestatic 1049	mobi/beyondpod/rsscore/helpers/CoreHelper:BackUpExistingUpdateLog	()V
    //   18: aload_2
    //   19: astore_1
    //   20: new 1051	java/io/BufferedWriter
    //   23: dup
    //   24: new 1053	java/io/FileWriter
    //   27: dup
    //   28: invokestatic 531	mobi/beyondpod/rsscore/Configuration:FeedUpdateLogFilePath	()Ljava/lang/String;
    //   31: iconst_0
    //   32: invokespecial 1056	java/io/FileWriter:<init>	(Ljava/lang/String;Z)V
    //   35: sipush 16000
    //   38: invokespecial 1059	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   41: astore_2
    //   42: aload_2
    //   43: ldc_w 1061
    //   46: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   49: invokestatic 392	mobi/beyondpod/downloadengine/RssFeedUpdateManager:Statistics	()Lmobi/beyondpod/downloadengine/DownloadStatisticsList;
    //   52: getfield 1067	mobi/beyondpod/downloadengine/DownloadStatisticsList:DownloadTime	Ljava/util/Date;
    //   55: astore_1
    //   56: invokestatic 392	mobi/beyondpod/downloadengine/RssFeedUpdateManager:Statistics	()Lmobi/beyondpod/downloadengine/DownloadStatisticsList;
    //   59: getfield 1070	mobi/beyondpod/downloadengine/DownloadStatisticsList:IsUnattended	Z
    //   62: istore_0
    //   63: aload_1
    //   64: astore_3
    //   65: aload_1
    //   66: ifnonnull +17 -> 83
    //   69: invokestatic 451	mobi/beyondpod/downloadengine/EnclosureDownloadManager:Statistics	()Lmobi/beyondpod/downloadengine/DownloadStatisticsList;
    //   72: getfield 1067	mobi/beyondpod/downloadengine/DownloadStatisticsList:DownloadTime	Ljava/util/Date;
    //   75: astore_3
    //   76: invokestatic 451	mobi/beyondpod/downloadengine/EnclosureDownloadManager:Statistics	()Lmobi/beyondpod/downloadengine/DownloadStatisticsList;
    //   79: getfield 1070	mobi/beyondpod/downloadengine/DownloadStatisticsList:IsUnattended	Z
    //   82: istore_0
    //   83: new 1072	java/text/SimpleDateFormat
    //   86: dup
    //   87: ldc_w 1074
    //   90: invokespecial 1075	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   93: astore_1
    //   94: aload_3
    //   95: ifnull +503 -> 598
    //   98: aload_1
    //   99: aload_3
    //   100: invokevirtual 1077	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   103: astore_1
    //   104: aload_3
    //   105: ifnull +754 -> 859
    //   108: new 1079	mobi/beyondpod/rsscore/helpers/TimeSpan
    //   111: dup
    //   112: new 914	java/util/Date
    //   115: dup
    //   116: invokespecial 1080	java/util/Date:<init>	()V
    //   119: invokevirtual 917	java/util/Date:getTime	()J
    //   122: aload_3
    //   123: invokevirtual 917	java/util/Date:getTime	()J
    //   126: lsub
    //   127: invokespecial 1083	mobi/beyondpod/rsscore/helpers/TimeSpan:<init>	(J)V
    //   130: invokevirtual 1087	mobi/beyondpod/rsscore/helpers/TimeSpan:getTotalMinutes	()D
    //   133: invokestatic 1091	java/lang/Math:round	(D)J
    //   136: invokestatic 1094	java/lang/Long:toString	(J)Ljava/lang/String;
    //   139: astore_3
    //   140: goto +707 -> 847
    //   143: aload_2
    //   144: ldc_w 1096
    //   147: iconst_3
    //   148: anewarray 4	java/lang/Object
    //   151: dup
    //   152: iconst_0
    //   153: aload_1
    //   154: aastore
    //   155: dup
    //   156: iconst_1
    //   157: aload_3
    //   158: aastore
    //   159: dup
    //   160: iconst_2
    //   161: aload 4
    //   163: aastore
    //   164: invokestatic 759	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   167: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   170: invokestatic 437	mobi/beyondpod/downloadengine/UpdateAndDownloadManager:Statistics	()Lmobi/beyondpod/downloadengine/ProcessStatistics$ProcessedFeedList;
    //   173: getfield 1097	mobi/beyondpod/downloadengine/ProcessStatistics$ProcessedFeedList:LastException	Ljava/lang/Exception;
    //   176: ifnull +38 -> 214
    //   179: aload_2
    //   180: new 249	java/lang/StringBuilder
    //   183: dup
    //   184: ldc_w 1099
    //   187: invokespecial 540	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   190: invokestatic 437	mobi/beyondpod/downloadengine/UpdateAndDownloadManager:Statistics	()Lmobi/beyondpod/downloadengine/ProcessStatistics$ProcessedFeedList;
    //   193: getfield 1097	mobi/beyondpod/downloadengine/ProcessStatistics$ProcessedFeedList:LastException	Ljava/lang/Exception;
    //   196: invokevirtual 977	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   199: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: ldc_w 1101
    //   205: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 556	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   214: aload_2
    //   215: new 249	java/lang/StringBuilder
    //   218: dup
    //   219: ldc_w 1103
    //   222: invokespecial 540	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   225: invokestatic 1106	mobi/beyondpod/rsscore/Configuration:getContentViewColor	()Ljava/lang/String;
    //   228: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: ldc_w 1108
    //   234: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 556	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   243: aload_2
    //   244: new 249	java/lang/StringBuilder
    //   247: dup
    //   248: ldc_w 1110
    //   251: invokespecial 540	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   254: invokestatic 1106	mobi/beyondpod/rsscore/Configuration:getContentViewColor	()Ljava/lang/String;
    //   257: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: ldc_w 1112
    //   263: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 556	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   272: invokestatic 392	mobi/beyondpod/downloadengine/RssFeedUpdateManager:Statistics	()Lmobi/beyondpod/downloadengine/DownloadStatisticsList;
    //   275: invokevirtual 1116	mobi/beyondpod/downloadengine/DownloadStatisticsList:GetSuccesfulDownloads	()Ljava/util/List;
    //   278: invokeinterface 1119 1 0
    //   283: astore_1
    //   284: aload_1
    //   285: invokeinterface 448 1 0
    //   290: ifne +315 -> 605
    //   293: aload_2
    //   294: new 249	java/lang/StringBuilder
    //   297: dup
    //   298: ldc_w 1121
    //   301: invokespecial 540	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   304: invokestatic 1106	mobi/beyondpod/rsscore/Configuration:getContentViewColor	()Ljava/lang/String;
    //   307: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: ldc_w 1123
    //   313: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: invokevirtual 556	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   322: aload_2
    //   323: new 249	java/lang/StringBuilder
    //   326: dup
    //   327: ldc_w 1110
    //   330: invokespecial 540	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   333: invokestatic 1106	mobi/beyondpod/rsscore/Configuration:getContentViewColor	()Ljava/lang/String;
    //   336: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: ldc_w 1112
    //   342: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 556	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   351: invokestatic 451	mobi/beyondpod/downloadengine/EnclosureDownloadManager:Statistics	()Lmobi/beyondpod/downloadengine/DownloadStatisticsList;
    //   354: invokevirtual 1116	mobi/beyondpod/downloadengine/DownloadStatisticsList:GetSuccesfulDownloads	()Ljava/util/List;
    //   357: invokeinterface 1119 1 0
    //   362: astore_1
    //   363: aload_1
    //   364: invokeinterface 448 1 0
    //   369: ifne +295 -> 664
    //   372: aload_2
    //   373: ldc_w 1125
    //   376: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   379: invokestatic 392	mobi/beyondpod/downloadengine/RssFeedUpdateManager:Statistics	()Lmobi/beyondpod/downloadengine/DownloadStatisticsList;
    //   382: invokevirtual 1128	mobi/beyondpod/downloadengine/DownloadStatisticsList:GetFailedDownloads	()Ljava/util/List;
    //   385: astore_1
    //   386: aload_1
    //   387: invokeinterface 1129 1 0
    //   392: ifle +40 -> 432
    //   395: aload_2
    //   396: ldc_w 1131
    //   399: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   402: aload_2
    //   403: ldc_w 1133
    //   406: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   409: aload_1
    //   410: invokeinterface 1119 1 0
    //   415: astore_1
    //   416: aload_1
    //   417: invokeinterface 448 1 0
    //   422: ifne +315 -> 737
    //   425: aload_2
    //   426: ldc_w 1125
    //   429: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   432: invokestatic 451	mobi/beyondpod/downloadengine/EnclosureDownloadManager:Statistics	()Lmobi/beyondpod/downloadengine/DownloadStatisticsList;
    //   435: invokevirtual 1128	mobi/beyondpod/downloadengine/DownloadStatisticsList:GetFailedDownloads	()Ljava/util/List;
    //   438: astore_1
    //   439: aload_1
    //   440: invokeinterface 1129 1 0
    //   445: ifle +40 -> 485
    //   448: aload_2
    //   449: ldc_w 1135
    //   452: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   455: aload_2
    //   456: ldc_w 1133
    //   459: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   462: aload_1
    //   463: invokeinterface 1119 1 0
    //   468: astore_1
    //   469: aload_1
    //   470: invokeinterface 448 1 0
    //   475: ifne +306 -> 781
    //   478: aload_2
    //   479: ldc_w 1125
    //   482: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   485: aload_2
    //   486: ldc_w 1137
    //   489: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   492: aload_2
    //   493: ldc_w 1139
    //   496: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   499: aload_2
    //   500: ldc_w 1141
    //   503: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   506: aload_2
    //   507: invokestatic 392	mobi/beyondpod/downloadengine/RssFeedUpdateManager:Statistics	()Lmobi/beyondpod/downloadengine/DownloadStatisticsList;
    //   510: invokevirtual 1142	mobi/beyondpod/downloadengine/DownloadStatisticsList:toString	()Ljava/lang/String;
    //   513: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   516: aload_2
    //   517: ldc_w 1144
    //   520: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   523: aload_2
    //   524: invokestatic 437	mobi/beyondpod/downloadengine/UpdateAndDownloadManager:Statistics	()Lmobi/beyondpod/downloadengine/ProcessStatistics$ProcessedFeedList;
    //   527: invokevirtual 1145	mobi/beyondpod/downloadengine/ProcessStatistics$ProcessedFeedList:toString	()Ljava/lang/String;
    //   530: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   533: aload_2
    //   534: ldc_w 1147
    //   537: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   540: aload_2
    //   541: invokestatic 451	mobi/beyondpod/downloadengine/EnclosureDownloadManager:Statistics	()Lmobi/beyondpod/downloadengine/DownloadStatisticsList;
    //   544: invokevirtual 1142	mobi/beyondpod/downloadengine/DownloadStatisticsList:toString	()Ljava/lang/String;
    //   547: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   550: aload_2
    //   551: invokestatic 1150	mobi/beyondpod/rsscore/helpers/CoreHelper:GetFormattedDeviceConnections	()Ljava/lang/String;
    //   554: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   557: aload_2
    //   558: invokestatic 1153	mobi/beyondpod/rsscore/helpers/CoreHelper:GetFormattedEnvironmentInfo	()Ljava/lang/String;
    //   561: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   564: aload_2
    //   565: ldc_w 1155
    //   568: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   571: invokestatic 392	mobi/beyondpod/downloadengine/RssFeedUpdateManager:Statistics	()Lmobi/beyondpod/downloadengine/DownloadStatisticsList;
    //   574: invokevirtual 1158	mobi/beyondpod/downloadengine/DownloadStatisticsList:ClearStatistics	()V
    //   577: invokestatic 451	mobi/beyondpod/downloadengine/EnclosureDownloadManager:Statistics	()Lmobi/beyondpod/downloadengine/DownloadStatisticsList;
    //   580: invokevirtual 1158	mobi/beyondpod/downloadengine/DownloadStatisticsList:ClearStatistics	()V
    //   583: invokestatic 437	mobi/beyondpod/downloadengine/UpdateAndDownloadManager:Statistics	()Lmobi/beyondpod/downloadengine/ProcessStatistics$ProcessedFeedList;
    //   586: invokevirtual 1159	mobi/beyondpod/downloadengine/ProcessStatistics$ProcessedFeedList:ClearStatistics	()V
    //   589: aload_2
    //   590: ifnull +256 -> 846
    //   593: aload_2
    //   594: invokevirtual 1160	java/io/BufferedWriter:close	()V
    //   597: return
    //   598: ldc_w 1162
    //   601: astore_1
    //   602: goto -498 -> 104
    //   605: aload_2
    //   606: ldc_w 1164
    //   609: iconst_1
    //   610: anewarray 4	java/lang/Object
    //   613: dup
    //   614: iconst_0
    //   615: aload_1
    //   616: invokeinterface 455 1 0
    //   621: checkcast 1166	mobi/beyondpod/downloadengine/DownloadStatistics
    //   624: getfield 1170	mobi/beyondpod/downloadengine/DownloadStatistics:OwnerFeed	Lmobi/beyondpod/rsscore/Feed;
    //   627: invokevirtual 1173	mobi/beyondpod/rsscore/Feed:getName	()Ljava/lang/String;
    //   630: aastore
    //   631: invokestatic 759	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   634: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   637: goto -353 -> 284
    //   640: astore_3
    //   641: aload_2
    //   642: astore_1
    //   643: getstatic 247	mobi/beyondpod/rsscore/helpers/CoreHelper:TAG	Ljava/lang/String;
    //   646: ldc_w 1175
    //   649: aload_3
    //   650: invokestatic 680	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   653: aload_2
    //   654: ifnull -57 -> 597
    //   657: aload_2
    //   658: invokevirtual 1160	java/io/BufferedWriter:close	()V
    //   661: return
    //   662: astore_1
    //   663: return
    //   664: aload_1
    //   665: invokeinterface 455 1 0
    //   670: checkcast 1166	mobi/beyondpod/downloadengine/DownloadStatistics
    //   673: astore_3
    //   674: aload_2
    //   675: ldc_w 1177
    //   678: iconst_3
    //   679: anewarray 4	java/lang/Object
    //   682: dup
    //   683: iconst_0
    //   684: aload_3
    //   685: getfield 1181	mobi/beyondpod/downloadengine/DownloadStatistics:OwnerTrack	Lmobi/beyondpod/rsscore/Track;
    //   688: invokevirtual 1186	mobi/beyondpod/rsscore/Track:DisplayName	()Ljava/lang/String;
    //   691: aastore
    //   692: dup
    //   693: iconst_1
    //   694: aload_3
    //   695: getfield 1190	mobi/beyondpod/downloadengine/DownloadStatistics:DownloadedSize	Ljava/lang/Long;
    //   698: invokestatic 869	mobi/beyondpod/rsscore/helpers/CoreHelper:GetFileLengthAsString	(Ljava/lang/Long;)Ljava/lang/String;
    //   701: aastore
    //   702: dup
    //   703: iconst_2
    //   704: aload_3
    //   705: getfield 1192	mobi/beyondpod/downloadengine/DownloadStatistics:DownloadTime	J
    //   708: aload_3
    //   709: getfield 1195	mobi/beyondpod/downloadengine/DownloadStatistics:TimeToFirstByte	J
    //   712: ladd
    //   713: invokestatic 1198	mobi/beyondpod/rsscore/helpers/CoreHelper:GetTimeDurationAsString	(J)Ljava/lang/String;
    //   716: aastore
    //   717: invokestatic 759	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   720: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   723: goto -360 -> 363
    //   726: astore_1
    //   727: aload_2
    //   728: ifnull +7 -> 735
    //   731: aload_2
    //   732: invokevirtual 1160	java/io/BufferedWriter:close	()V
    //   735: aload_1
    //   736: athrow
    //   737: aload_1
    //   738: invokeinterface 455 1 0
    //   743: checkcast 1166	mobi/beyondpod/downloadengine/DownloadStatistics
    //   746: astore_3
    //   747: aload_2
    //   748: ldc_w 1200
    //   751: iconst_2
    //   752: anewarray 4	java/lang/Object
    //   755: dup
    //   756: iconst_0
    //   757: aload_3
    //   758: getfield 1170	mobi/beyondpod/downloadengine/DownloadStatistics:OwnerFeed	Lmobi/beyondpod/rsscore/Feed;
    //   761: invokevirtual 1173	mobi/beyondpod/rsscore/Feed:getName	()Ljava/lang/String;
    //   764: aastore
    //   765: dup
    //   766: iconst_1
    //   767: aload_3
    //   768: invokevirtual 1203	mobi/beyondpod/downloadengine/DownloadStatistics:GetErrorDescription	()Ljava/lang/String;
    //   771: aastore
    //   772: invokestatic 759	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   775: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   778: goto -362 -> 416
    //   781: aload_1
    //   782: invokeinterface 455 1 0
    //   787: checkcast 1166	mobi/beyondpod/downloadengine/DownloadStatistics
    //   790: astore_3
    //   791: aload_2
    //   792: ldc_w 1200
    //   795: iconst_2
    //   796: anewarray 4	java/lang/Object
    //   799: dup
    //   800: iconst_0
    //   801: aload_3
    //   802: getfield 1181	mobi/beyondpod/downloadengine/DownloadStatistics:OwnerTrack	Lmobi/beyondpod/rsscore/Track;
    //   805: invokevirtual 1204	mobi/beyondpod/rsscore/Track:getName	()Ljava/lang/String;
    //   808: aastore
    //   809: dup
    //   810: iconst_1
    //   811: aload_3
    //   812: invokevirtual 1203	mobi/beyondpod/downloadengine/DownloadStatistics:GetErrorDescription	()Ljava/lang/String;
    //   815: aastore
    //   816: invokestatic 759	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   819: invokevirtual 1063	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   822: goto -353 -> 469
    //   825: astore_1
    //   826: return
    //   827: astore_2
    //   828: goto -93 -> 735
    //   831: astore_3
    //   832: aload_1
    //   833: astore_2
    //   834: aload_3
    //   835: astore_1
    //   836: goto -109 -> 727
    //   839: astore_3
    //   840: aload 4
    //   842: astore_2
    //   843: goto -202 -> 641
    //   846: return
    //   847: iload_0
    //   848: ifeq +18 -> 866
    //   851: ldc_w 1206
    //   854: astore 4
    //   856: goto -713 -> 143
    //   859: ldc_w 1208
    //   862: astore_3
    //   863: goto -16 -> 847
    //   866: ldc_w 1210
    //   869: astore 4
    //   871: goto -728 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   62	786	0	bool	boolean
    //   6	637	1	localObject1	Object
    //   662	3	1	localIOException1	IOException
    //   726	56	1	localObject2	Object
    //   825	8	1	localIOException2	IOException
    //   835	1	1	localObject3	Object
    //   1	791	2	localBufferedWriter	BufferedWriter
    //   827	1	2	localIOException3	IOException
    //   833	10	2	localObject4	Object
    //   64	94	3	localObject5	Object
    //   640	10	3	localException1	Exception
    //   673	139	3	localDownloadStatistics	mobi.beyondpod.downloadengine.DownloadStatistics
    //   831	4	3	localObject6	Object
    //   839	1	3	localException2	Exception
    //   862	1	3	str1	String
    //   3	867	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   42	63	640	java/lang/Exception
    //   69	83	640	java/lang/Exception
    //   83	94	640	java/lang/Exception
    //   98	104	640	java/lang/Exception
    //   108	140	640	java/lang/Exception
    //   143	214	640	java/lang/Exception
    //   214	284	640	java/lang/Exception
    //   284	363	640	java/lang/Exception
    //   363	416	640	java/lang/Exception
    //   416	432	640	java/lang/Exception
    //   432	469	640	java/lang/Exception
    //   469	485	640	java/lang/Exception
    //   485	589	640	java/lang/Exception
    //   605	637	640	java/lang/Exception
    //   664	723	640	java/lang/Exception
    //   737	778	640	java/lang/Exception
    //   781	822	640	java/lang/Exception
    //   657	661	662	java/io/IOException
    //   42	63	726	finally
    //   69	83	726	finally
    //   83	94	726	finally
    //   98	104	726	finally
    //   108	140	726	finally
    //   143	214	726	finally
    //   214	284	726	finally
    //   284	363	726	finally
    //   363	416	726	finally
    //   416	432	726	finally
    //   432	469	726	finally
    //   469	485	726	finally
    //   485	589	726	finally
    //   605	637	726	finally
    //   664	723	726	finally
    //   737	778	726	finally
    //   781	822	726	finally
    //   593	597	825	java/io/IOException
    //   731	735	827	java/io/IOException
    //   7	13	831	finally
    //   15	18	831	finally
    //   20	42	831	finally
    //   643	653	831	finally
    //   7	13	839	java/lang/Exception
    //   15	18	839	java/lang/Exception
    //   20	42	839	java/lang/Exception
  }
  
  public static File ExternalStorageDirectory()
  {
    if ((Configuration.PreferLastSDCardRoot()) && (!StringUtils.IsNullOrEmpty(Configuration.LastSDCardRootPath()))) {
      return new File(Configuration.LastSDCardRootPath());
    }
    return AutodetectExternalStorageDirectoryInternal();
  }
  
  public static String ExternalStorageState()
  {
    if ((IsExternalStorageLocatedOnSDCard()) || (Configuration.PreferLastSDCardRoot())) {
      return Environment.getExternalStorageState();
    }
    return "mounted";
  }
  
  public static String ExtractExceptionMessages(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      paramThrowable = "";
    }
    Object localObject;
    String str;
    do
    {
      return paramThrowable;
      localObject = new StringBuilder(String.valueOf(paramThrowable.getClass().getSimpleName()));
      if (!StringUtils.IsNullOrEmpty(paramThrowable.getMessage())) {
        break;
      }
      str = "";
      str = str;
      localObject = ExtractExceptionMessages(paramThrowable.getCause());
      paramThrowable = str;
    } while (StringUtils.IsNullOrEmpty((String)localObject));
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str));
    if (StringUtils.IsNullOrEmpty(str)) {}
    for (paramThrowable = "";; paramThrowable = " -> ")
    {
      return paramThrowable + (String)localObject;
      str = " - " + paramThrowable.getMessage();
      break;
    }
  }
  
  public static File FindExternalSDCard()
  {
    String[] arrayOfString = OptionalStorageMounts;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      Object localObject;
      if (i >= j) {
        localObject = null;
      }
      File localFile;
      do
      {
        return (File)localObject;
        localFile = new File(arrayOfString[i]);
        localObject = localFile;
      } while (localFile.exists());
      i += 1;
    }
  }
  
  public static <T> int FindIndexInNumArray(Context paramContext, int paramInt, T paramT)
  {
    paramContext = paramContext.getResources().getStringArray(paramInt);
    paramT = String.valueOf(paramT);
    paramInt = 0;
    for (;;)
    {
      int i;
      if (paramInt == paramContext.length) {
        i = -1;
      }
      do
      {
        return i;
        i = paramInt;
      } while (paramContext[paramInt].equals(paramT));
      paramInt += 1;
    }
  }
  
  public static int FindIndexValueInNumArray(Context paramContext, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = Integer.parseInt(paramContext.getResources().getStringArray(paramInt1)[paramInt2]);
      return paramInt1;
    }
    catch (Exception paramContext) {}
    return Integer.MIN_VALUE;
  }
  
  public static void FollowRedirects(String paramString, FollowRedirectResult paramFollowRedirectResult)
  {
    if (_RedirectFollowerThread.isAlive()) {
      return;
    }
    _RedirectFollowerThread = new Thread(new RedirectFollowerRunnable(paramString, paramFollowRedirectResult));
    _RedirectFollowerThread.setName("RedirectFollower Thread");
    _RedirectFollowerThread.setPriority(1);
    _RedirectFollowerThread.start();
  }
  
  public static void ForceBackgroundTile(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      paramView = paramView.getBackground();
    } while ((paramView == null) || (!(paramView instanceof BitmapDrawable)));
    ((BitmapDrawable)paramView).setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
  }
  
  public static String FormatSecondsAsMinutes(long paramLong)
  {
    if (paramLong <= 0L) {
      return "";
    }
    sFormatBuilder.setLength(0);
    int j = (int)Math.floor(paramLong / 60L);
    int i = j;
    if (paramLong % 60L >= 30L) {
      i = j + 1;
    }
    return sFormatter.format("%d min", new Object[] { Integer.valueOf(i) }).toString();
  }
  
  public static String FormatTimeAsString(long paramLong)
  {
    return FormatTimeAsString(paramLong, false);
  }
  
  public static String FormatTimeAsString(long paramLong, boolean paramBoolean)
  {
    sFormatBuilder.setLength(0);
    Object[] arrayOfObject = sTimeArgs;
    arrayOfObject[0] = Long.valueOf(paramLong / 3600L);
    arrayOfObject[1] = Long.valueOf(paramLong / 60L);
    arrayOfObject[2] = Long.valueOf(paramLong / 60L % 60L);
    arrayOfObject[3] = Long.valueOf(paramLong);
    arrayOfObject[4] = Long.valueOf(paramLong % 60L);
    String str;
    if (paramLong / 3600.0D > 1.0D) {
      if (paramBoolean) {
        str = "%1$d:%3$02d:%5$02d";
      }
    }
    for (;;)
    {
      return sFormatter.format(str, arrayOfObject).toString();
      str = "%1$d:%3$02dh";
      continue;
      if (paramLong / 60.0D > 1.0D) {
        str = "%2$d:%5$02d";
      } else {
        str = "%4$ds";
      }
    }
  }
  
  public static long GenerateRandomNumber(long paramLong1, long paramLong2, Random paramRandom)
  {
    Random localRandom = paramRandom;
    if (paramRandom == null) {
      localRandom = new Random(SystemClock.elapsedRealtime());
    }
    if (paramLong1 > paramLong2) {
      throw new IllegalArgumentException("Start cannot exceed End.");
    }
    return ((paramLong2 - paramLong1 + 1L) * localRandom.nextDouble()) + paramLong1;
  }
  
  public static String GetApproximateTimeDurationAsString(long paramLong, boolean paramBoolean)
  {
    int i = 1;
    Object localObject = new TimeSpan(paramLong);
    if (((TimeSpan)localObject).getTotalMinutes() < 1.0D)
    {
      if (paramBoolean) {
        return "1m";
      }
      return "1 min";
    }
    if (((TimeSpan)localObject).getTotalHours() < 1.0D)
    {
      paramLong = ((TimeSpan)localObject).getMinutes();
      StringBuilder localStringBuilder;
      if (((TimeSpan)localObject).getSeconds() > 30L)
      {
        localStringBuilder = new StringBuilder(String.valueOf(i + paramLong));
        if (!paramBoolean) {
          break label103;
        }
      }
      label103:
      for (localObject = "m";; localObject = " min")
      {
        return (String)localObject;
        i = 0;
        break;
      }
    }
    if (paramBoolean) {
      return String.format("%d:%02d", new Object[] { Integer.valueOf((int)Math.floor(((TimeSpan)localObject).getTotalHours())), Long.valueOf(((TimeSpan)localObject).getMinutes()) });
    }
    return String.format("%d h %02d min", new Object[] { Integer.valueOf((int)Math.floor(((TimeSpan)localObject).getTotalHours())), Long.valueOf(((TimeSpan)localObject).getMinutes()) });
  }
  
  public static Long GetBrowserCacheSizeOnDisk()
  {
    File localFile = BeyondPodApplication.GetInstance().getCacheDir();
    if (localFile != null) {
      return Long.valueOf(localFile.length());
    }
    return Long.valueOf(0L);
  }
  
  public static DeviceNetworkConnection GetDeviceNetworkConnection()
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)BeyondPodApplication.GetInstance().getSystemService("connectivity");
    if (localConnectivityManager == null) {
      WriteLogEntryInProduction(TAG, "!!!!! Failed to retrieve device ConnectivityManager");
    }
    for (;;)
    {
      return new DeviceNetworkConnection(null, true);
      NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      if (localNetworkInfo != null) {
        return new DeviceNetworkConnection(localNetworkInfo, localConnectivityManager.getBackgroundDataSetting());
      }
      WriteLogEntryInProduction(TAG, "*** ConnectivityManager reported that the device has no active Network Connections");
    }
  }
  
  public static String GetDownloadSpeedAsString(long paramLong1, long paramLong2)
  {
    float f2 = (float)paramLong2 / 1000.0F;
    float f3 = (float)paramLong1 / 1024.0F;
    float f1 = 0.0F;
    if (f2 != 0.0F) {
      f1 = f3 / f2;
    }
    return String.format("%.2f KB/Sec", new Object[] { Float.valueOf(f1) });
  }
  
  public static List<String> GetExternalPlayersFor(String paramString1, String paramString2)
  {
    Object localObject = new Intent("android.intent.action.VIEW");
    ((Intent)localObject).setDataAndType(Uri.fromFile(new File(paramString1)), paramString2);
    paramString2 = BeyondPodApplication.GetInstance().getPackageManager().queryIntentActivities((Intent)localObject, 65536);
    paramString1 = new ArrayList();
    if (paramString2.size() > 1) {
      paramString2 = paramString2.iterator();
    }
    for (;;)
    {
      if (!paramString2.hasNext()) {
        return paramString1;
      }
      localObject = (ResolveInfo)paramString2.next();
      if ((((ResolveInfo)localObject).activityInfo != null) && (((ResolveInfo)localObject).activityInfo.packageName != null)) {
        paramString1.add(((ResolveInfo)localObject).activityInfo.packageName);
      }
    }
  }
  
  public static String GetFileLengthAsString(Long paramLong)
  {
    String str = "";
    float f;
    if (paramLong != null)
    {
      f = (float)paramLong.longValue();
      if (f > 1.07374182E9F) {
        str = String.format("%.2f GB", new Object[] { Float.valueOf(f / 1.07374182E9F) });
      }
    }
    else
    {
      return str;
    }
    if (f > 1048576.0F) {
      return String.format("%.0f MB", new Object[] { Float.valueOf(f / 1048576.0F) });
    }
    if (f > 1024.0F) {
      return String.format("%.0f KB", new Object[] { Float.valueOf(f / 1024.0F) });
    }
    return String.format("%.0f Bytes", new Object[] { Float.valueOf(f) });
  }
  
  public static File GetFirstDownloadedUnlockKey()
  {
    File[] arrayOfFile = new File(Configuration.BeyondPodPublicStorageRootPath()).listFiles(new FilenameFilter()
    {
      public boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        paramAnonymousFile = paramAnonymousString.toLowerCase();
        return (paramAnonymousFile.startsWith("beyondpodunlockkey")) && (paramAnonymousFile.endsWith("apk"));
      }
    });
    if (arrayOfFile.length > 0) {
      return arrayOfFile[0];
    }
    return null;
  }
  
  private static String GetFormattedDeviceConnections()
  {
    Object localObject = GetDeviceNetworkConnection();
    String str = ((DeviceNetworkConnection)localObject).ExtraInfo();
    if (((DeviceNetworkConnection)localObject).IsBackgroundDataAllowed()) {}
    for (localObject = "Allowed";; localObject = "Not Allowed") {
      return String.format("<div><h3>Device Network Connections: <b>%s</b></h3>Background data %s</div>", new Object[] { str, localObject });
    }
  }
  
  private static String GetFormattedEnvironmentInfo()
  {
    return String.format("<div><h3>Environment Info</h3><pre>%s</pre></div>", new Object[] { DumpEnvironment() });
  }
  
  public static File GetOptionalStorageMount()
  {
    Object localObject = Configuration.CustomSDCardLocation();
    if (!StringUtils.IsNullOrEmpty((String)localObject))
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists()) {
        return (File)localObject;
      }
    }
    return FindExternalSDCard();
  }
  
  public static String GetTimeDurationAsString(long paramLong)
  {
    TimeSpan localTimeSpan = new TimeSpan(paramLong);
    if (localTimeSpan.getTotalSeconds() < 1.0D) {
      return localTimeSpan.getMilliseconds() + " mSec.";
    }
    if (localTimeSpan.getTotalMinutes() < 1.0D) {
      return localTimeSpan.getSeconds() + " sec.";
    }
    if (localTimeSpan.getTotalHours() < 1.0D) {
      return localTimeSpan.getMinutes() + " min. " + localTimeSpan.getSeconds() + " sec.";
    }
    if (localTimeSpan.getDays() < 1L) {
      return localTimeSpan.getHours() + "hr. " + localTimeSpan.getMinutes() + " min. " + localTimeSpan.getSeconds() + " sec.";
    }
    return localTimeSpan.toString();
  }
  
  public static ArrayList<File> GetUpdateLogs()
  {
    Object localObject = new File(Configuration.FeedUpdateLogFilePath());
    if (!((File)localObject).exists()) {
      return new ArrayList();
    }
    localObject = new ArrayList(Arrays.asList(new File(Configuration.BeyondPodPublicStorageRootPath()).listFiles(new FileFilter()
    {
      public boolean accept(File paramAnonymousFile)
      {
        return paramAnonymousFile.getName().contains(CoreHelper.this.getName().substring(0, CoreHelper.this.getName().lastIndexOf('.')));
      }
    })));
    Collections.sort((List)localObject, new Comparator()
    {
      public int compare(File paramAnonymousFile1, File paramAnonymousFile2)
      {
        return Long.valueOf(paramAnonymousFile2.lastModified()).compareTo(Long.valueOf(paramAnonymousFile1.lastModified()));
      }
    });
    return (ArrayList<File>)localObject;
  }
  
  public static boolean IsAlreadyConnectedOrWiFiShouldBeTurnedOnDuringUpdate()
  {
    return (GetDeviceNetworkConnection().IsConnectedToNetwork()) || (BeyondPodApplication.IsWiFiEnabled()) || (Configuration.TurnWiFiDuringUpdate());
  }
  
  public static boolean IsBackgroundDataAllowed()
  {
    return GetDeviceNetworkConnection().IsBackgroundDataAllowed();
  }
  
  public static boolean IsCGBuild()
  {
    if (_CGBuild != null) {
      return _CGBuild.booleanValue();
    }
    try
    {
      _CGBuild = Boolean.valueOf(Configuration.getInternalPlayerSupportedFileExtensions().contains("cyanogenmod"));
      return _CGBuild.booleanValue();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        _CGBuild = Boolean.valueOf(false);
      }
    }
  }
  
  public static boolean IsDebugBuild()
  {
    ApplicationInfo localApplicationInfo = BeyondPodApplication.GetInstance().getApplicationInfo();
    int i = localApplicationInfo.flags & 0x2;
    localApplicationInfo.flags = i;
    return i != 0;
  }
  
  public static boolean IsDeviceCharging()
  {
    return (BeyondPodApplication.BatteryStatus == 2) || (BeyondPodApplication.BatteryStatus == 5);
  }
  
  public static boolean IsDevicePlugged()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (BeyondPodApplication.BatteryPlugged != 1)
    {
      bool1 = bool2;
      if (BeyondPodApplication.BatteryPlugged != 2)
      {
        bool1 = bool2;
        if (BeyondPodApplication.BatteryPlugged != 4) {
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  public static boolean IsDeviceWiFiOnlyDevice()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)BeyondPodApplication.GetInstance().getSystemService("phone");
    return (localTelephonyManager != null) && (localTelephonyManager.getPhoneType() == 0);
  }
  
  public static boolean IsExternalStorageLocatedOnSDCard()
  {
    return ExternalStorageDirectory().getPath().equals(Environment.getExternalStorageDirectory().getPath());
  }
  
  public static boolean IsPartnerPlayerInstalled(String paramString1, String paramString2)
  {
    return Configuration.getInternalPlayerSupportedFileExtensions().contains("partner_player");
  }
  
  public static boolean IsPartnerSony()
  {
    return (StringUtils.EqualsIgnoreCase("Sony Tablet S", Build.MODEL)) || (StringUtils.EqualsIgnoreCase("Sony Tablet P", Build.MODEL));
  }
  
  public static boolean IsPodcastOrFeedUrl(Uri paramUri)
  {
    if (paramUri == null) {}
    do
    {
      return false;
      paramUri = paramUri.getScheme();
    } while ((paramUri == null) || ("pcast,itpc,rss,feed,http,https".indexOf(paramUri.toLowerCase()) < 0));
    return true;
  }
  
  public static boolean IsUrlValid(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    try
    {
      paramString = URI.create(paramString);
      if (!paramBoolean) {
        return true;
      }
      BeyondPodHttpClient localBeyondPodHttpClient = BeyondPodHttpClient.newInstance(Configuration.DefaultUserAgent());
      int i = localBeyondPodHttpClient.execute(new HttpGet(paramString)).getStatusLine().getStatusCode();
      paramBoolean = bool;
      if (i != 200)
      {
        paramBoolean = bool;
        if (i != 301)
        {
          paramBoolean = bool;
          if (i != 302) {
            paramBoolean = false;
          }
        }
      }
      bool = paramBoolean;
      if (localBeyondPodHttpClient != null)
      {
        localBeyondPodHttpClient.close();
        return paramBoolean;
      }
    }
    catch (Exception paramString)
    {
      bool = false;
    }
    return bool;
  }
  
  public static boolean IsWiFiConnected()
  {
    Object localObject = (ConnectivityManager)BeyondPodApplication.GetInstance().getSystemService("connectivity");
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      return (localObject != null) && (((NetworkInfo)localObject).getType() == 1);
    }
    return false;
  }
  
  public static void KeepDeviceAwake() {}
  
  public static String LoadResToString(int paramInt)
  {
    try
    {
      InputStream localInputStream = BeyondPodApplication.GetInstance().getResources().openRawResource(paramInt);
      byte[] arrayOfByte = new byte['က'];
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      for (;;)
      {
        paramInt = localInputStream.read(arrayOfByte);
        if (paramInt == -1)
        {
          localByteArrayOutputStream.close();
          localInputStream.close();
          return localByteArrayOutputStream.toString();
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, paramInt);
      }
      return null;
    }
    catch (Exception localException)
    {
      Log.e(TAG, "ResourceUtils failed to load resource to string", localException);
    }
  }
  
  public static String LoadResourceString(int paramInt)
  {
    return BeyondPodApplication.GetInstance().getResources().getString(paramInt);
  }
  
  public static void LogException(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    localPrintWriter.print(paramString2 + " Reason: ");
    localPrintWriter.print(" [ ");
    localPrintWriter.print(paramThrowable.getClass().getName());
    localPrintWriter.print(" ] ");
    localPrintWriter.print(paramThrowable.getMessage());
    paramThrowable.printStackTrace(localPrintWriter);
    paramThrowable = localStringWriter.toString();
    AnalyticsTracker.LogError(paramString2, paramThrowable, paramString1);
    WriteLogEntry(paramString1, paramThrowable);
  }
  
  public static String MakeValidFileName(String paramString)
  {
    return paramString.replace("<", "").replace(">", "").replace("\\", "").replace("/", "").replace(":", "").replace("*", "").replace("?", "").replace("\"", "").replace("|", "");
  }
  
  public static String MakeValidPodcastName(String paramString)
  {
    String str = "Podcast";
    if (!StringUtils.IsNullOrEmpty(paramString)) {
      str = paramString.replaceAll("[^a-zA-Z0-9 - ]", "").trim();
    }
    paramString = str;
    if (str.length() > 30) {
      paramString = str.substring(0, 30).trim();
    }
    str = paramString;
    if (paramString.length() == 0) {
      str = "Podcast";
    }
    return str;
  }
  
  public static int PowerBatteryStrength()
  {
    return BeyondPodApplication.BatteryLevel;
  }
  
  public static URI SafeCreateURI(String paramString)
  {
    int i = 100;
    for (;;)
    {
      try
      {
        URI localURI = new URI(paramString);
        return localURI;
      }
      catch (URISyntaxException localURISyntaxException)
      {
        String str = paramString.substring(localURISyntaxException.getIndex(), localURISyntaxException.getIndex() + 1);
        paramString = paramString.replace(str, URLEncoder.encode(str));
        if (i <= 0) {
          return null;
        }
      }
      catch (Exception localException)
      {
        WriteLogEntry(TAG, "Failed to create URI from" + paramString);
        return null;
      }
      i -= 1;
    }
  }
  
  public static Uri SafeCreateUri(String paramString)
  {
    try
    {
      Uri localUri = Uri.parse(paramString);
      return localUri;
    }
    catch (Exception localException)
    {
      WriteLogEntry(TAG, "Failed to create URI from" + paramString);
    }
    return null;
  }
  
  public static String SafeDecodeUrl(String paramString)
  {
    try
    {
      String str = URLDecoder.decode(paramString);
      return str;
    }
    catch (Exception localException)
    {
      WriteTraceEntryInDebug(TAG, "Unable to URL decode url: " + paramString + "! Reason:" + localException.getMessage());
    }
    return paramString;
  }
  
  public static void SetTraceBroadcastContext(Handler paramHandler)
  {
    _TraceBroadcastHandler = paramHandler;
  }
  
  public static void TouchFile(File paramFile)
  {
    if (paramFile.exists()) {
      paramFile.setLastModified(new Date().getTime());
    }
  }
  
  public static void TruncateLogFile(File paramFile)
  {
    try
    {
      final String str2 = paramFile.getName();
      int i = str2.indexOf(".");
      String str1 = str2.substring(0, i) + "_";
      str2 = str2.substring(i);
      File localFile = new File(paramFile.getParent());
      paramFile.renameTo(File.createTempFile(str1, str2, localFile));
      paramFile = localFile.listFiles(new FileFilter()
      {
        public boolean accept(File paramAnonymousFile)
        {
          return (paramAnonymousFile.getName().startsWith(CoreHelper.this)) && (paramAnonymousFile.getName().endsWith(str2));
        }
      });
      if (paramFile.length <= 3) {
        return;
      }
      Arrays.sort(paramFile, 0, paramFile.length, new Comparator()
      {
        public int compare(File paramAnonymousFile1, File paramAnonymousFile2)
        {
          if (paramAnonymousFile1.lastModified() > paramAnonymousFile2.lastModified()) {
            return 1;
          }
          if (paramAnonymousFile1.lastModified() < paramAnonymousFile2.lastModified()) {
            return -1;
          }
          return 0;
        }
      });
      i = 0;
      while (i != paramFile.length - 3)
      {
        paramFile[i].delete();
        i += 1;
      }
      return;
    }
    catch (Exception paramFile)
    {
      LogException(TAG, "Failed to truncate the log file!", paramFile);
    }
  }
  
  public static void TruncateLogFileIfNecessary()
  {
    File localFile = new File(Configuration.LogFilePath());
    if ((localFile.exists()) && (localFile.length() > 51200L)) {
      TruncateLogFile(localFile);
    }
    localFile = new File(Configuration.SyncLogFilePath());
    if ((localFile.exists()) && (localFile.length() > 51200L)) {
      TruncateLogFile(localFile);
    }
  }
  
  public static void Vibrate(int paramInt)
  {
    Vibrator localVibrator = (Vibrator)BeyondPodApplication.GetInstance().getSystemService("vibrator");
    if (localVibrator != null) {
      localVibrator.vibrate(paramInt);
    }
  }
  
  public static String WhoCalledMe()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int i = 2;
    for (;;)
    {
      if (i >= arrayOfStackTraceElement.length) {
        return localStringBuilder.toString();
      }
      StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
      String str1 = localStackTraceElement.getClassName();
      String str2 = localStackTraceElement.getMethodName();
      int j = localStackTraceElement.getLineNumber();
      localStringBuilder.append(str1 + "." + str2 + ":" + j + " <= ");
      i += 1;
    }
  }
  
  public static void WriteLogEntry(String paramString1, final String paramString2)
  {
    WriteTraceEntry(paramString1, paramString2);
    RepositoryPersistence.RepositoryHandler().post(new Runnable()
    {
      public void run()
      {
        String str = String.format("%s: %s (%s) - %s\r\n", new Object[] { DateTime.ToShortString(new Date()), CoreHelper.this, Configuration.ProductVersion(), paramString2 });
        try
        {
          BufferedWriter localBufferedWriter = new BufferedWriter(new FileWriter(Configuration.LogFilePath(), true), 8192);
          localBufferedWriter.write(str);
          localBufferedWriter.close();
          return;
        }
        catch (Exception localException)
        {
          Log.e(CoreHelper.TAG, "Unable to write to the log file. Reason: " + localException.getMessage());
          Log.e(CoreHelper.this, str);
        }
      }
    });
  }
  
  public static void WriteLogEntryInDebug(String paramString1, String paramString2)
  {
    if (IsDebugBuild())
    {
      WriteLogEntry(paramString1, paramString2);
      return;
    }
    WriteTraceEntry(paramString1, paramString2);
  }
  
  public static void WriteLogEntryInProduction(String paramString1, String paramString2)
  {
    if (Configuration.EnableLoggingInProduction())
    {
      WriteLogEntry(paramString1, paramString2);
      return;
    }
    WriteTraceEntry(paramString1, paramString2);
  }
  
  public static void WriteStringToFile(String paramString1, final String paramString2)
  {
    RepositoryPersistence.RepositoryHandler().post(new Runnable()
    {
      public void run()
      {
        try
        {
          BufferedWriter localBufferedWriter = new BufferedWriter(new FileWriter(File.createTempFile(CoreHelper.this, ".txt", new File(Configuration.BeyondPodPublicStorageRootPath())), true), 8192);
          localBufferedWriter.write(paramString2);
          localBufferedWriter.close();
          return;
        }
        catch (Exception localException)
        {
          Log.e(CoreHelper.TAG, "Unable to write string to file. Reason: " + localException.getMessage());
        }
      }
    });
  }
  
  public static void WriteTraceEntry(String paramString1, String paramString2)
  {
    WriteTraceEntryInternal(paramString1, paramString2, 0);
  }
  
  public static void WriteTraceEntryInDebug(String paramString1, String paramString2)
  {
    if (IsDebugBuild()) {
      WriteTraceEntryInternal(paramString1, paramString2, 0);
    }
  }
  
  private static void WriteTraceEntryInternal(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      long l1 = System.currentTimeMillis();
      String str = paramString2;
      long l2;
      if (_LastTraceTime != 0L)
      {
        l2 = l1 - _LastTraceTime;
        if (l2 < 1000L) {
          str = paramString2 + "  (" + (l1 - _LastTraceTime) + " ms. since last trace)";
        }
      }
      else
      {
        if (paramInt != 0) {
          break label188;
        }
        Log.v("BeyondPod", str + "   [" + paramString1 + "]");
      }
      for (;;)
      {
        _LastTraceTime = l1;
        if (_TraceBroadcastHandler == null) {
          return;
        }
        paramString1 = Message.obtain(_TraceBroadcastHandler);
        paramString1.obj = str;
        paramString1.sendToTarget();
        return;
        float f = (float)l2 / 1000.0F;
        str = paramString2 + String.format("  (%.2f s. since last trace)", new Object[] { Float.valueOf(f) });
        break;
        label188:
        Log.e("BeyondPod", str + "   [" + paramString1 + "]");
      }
      return;
    }
    catch (Throwable paramString1)
    {
      Log.e("BeyondPod", paramString1.getMessage());
    }
  }
  
  public static void WriteTraceErrorInDebug(String paramString1, String paramString2)
  {
    if (IsDebugBuild()) {
      WriteTraceEntryInternal(paramString1, paramString2, 1);
    }
  }
  
  public static CharSequence cleanTitle(CharSequence paramCharSequence)
  {
    return replace(paramCharSequence, _html, _empty);
  }
  
  public static CharSequence htmlDecode(CharSequence paramCharSequence)
  {
    return replace(paramCharSequence, _encoded, _decoded);
  }
  
  public static boolean isFolderReallyWritable(File paramFile)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFile != null) {}
    try
    {
      paramFile = File.createTempFile("probe", "tmp", paramFile);
      bool1 = bool2;
      if (paramFile.exists()) {
        bool1 = paramFile.delete();
      }
      return bool1;
    }
    catch (Exception paramFile) {}
    return false;
  }
  
  public static boolean isFolderReallyWritable(String paramString)
  {
    if (StringUtils.IsNullOrEmpty(paramString)) {
      return false;
    }
    return isFolderReallyWritable(new File(paramString));
  }
  
  public static void nap(int paramInt)
  {
    long l = paramInt * 1000;
    try
    {
      Thread.sleep(l);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  private static CharSequence replace(CharSequence paramCharSequence, String[] paramArrayOfString, CharSequence[] paramArrayOfCharSequence)
  {
    for (;;)
    {
      CharSequence localCharSequence = TextUtils.replace(paramCharSequence, paramArrayOfString, paramArrayOfCharSequence);
      if (localCharSequence.length() == paramCharSequence.length()) {
        return localCharSequence;
      }
      paramCharSequence = localCharSequence;
    }
  }
  
  public static boolean sync(FileOutputStream paramFileOutputStream)
  {
    if (paramFileOutputStream != null) {}
    try
    {
      paramFileOutputStream.getFD().sync();
      return true;
    }
    catch (IOException paramFileOutputStream) {}
    return false;
  }
  
  public static class DeviceNetworkConnection
  {
    boolean _AllowBackground = false;
    NetworkInfo _Info;
    
    public DeviceNetworkConnection(NetworkInfo paramNetworkInfo, boolean paramBoolean)
    {
      this._Info = paramNetworkInfo;
      this._AllowBackground = paramBoolean;
    }
    
    public String ExtraInfo()
    {
      if (this._Info != null)
      {
        if (this._Info.getExtraInfo() != null) {
          return this._Info.getExtraInfo() + " (" + this._Info.getTypeName() + ")";
        }
        return this._Info.getTypeName();
      }
      return "N/A";
    }
    
    public boolean IsBackgroundDataAllowed()
    {
      return this._AllowBackground;
    }
    
    public boolean IsConnectedToNetwork()
    {
      if (!Configuration.CheckForNetworkConnectivity()) {}
      while ((this._Info != null) && (this._Info.isConnected())) {
        return true;
      }
      return false;
    }
    
    public boolean IsConnectionCellular()
    {
      return (this._Info != null) && (this._Info.getType() == 0);
    }
    
    public boolean IsConnectionWiFi()
    {
      return (this._Info != null) && (this._Info.getType() == 1);
    }
    
    public String toString()
    {
      if (this._Info != null) {
        return this._Info.toString();
      }
      return "N/A";
    }
  }
  
  public static abstract interface FollowRedirectResult
  {
    public abstract void OnComplete(String paramString, int paramInt, Exception paramException);
  }
  
  public static class IssuficientStorageSpaceException
    extends Exception
  {
    public IssuficientStorageSpaceException(String paramString)
    {
      super();
    }
  }
  
  private static class RedirectFollowerRunnable
    implements Runnable
  {
    private CoreHelper.FollowRedirectResult _OnCompleteHandler;
    private String _UrlToTry;
    
    public RedirectFollowerRunnable(String paramString, CoreHelper.FollowRedirectResult paramFollowRedirectResult)
    {
      this._UrlToTry = paramString;
      this._OnCompleteHandler = paramFollowRedirectResult;
    }
    
    public void run()
    {
      try
      {
        Object localObject = URI.create(this._UrlToTry);
        BeyondPodHttpClient localBeyondPodHttpClient = BeyondPodHttpClient.newInstance(Configuration.DefaultUserAgent());
        localObject = localBeyondPodHttpClient.execute(new HttpGet((URI)localObject));
        CoreHelper.WriteTraceEntry(CoreHelper.TAG, "Resolved URL Redirect: " + this._UrlToTry + " => " + localBeyondPodHttpClient.FinalDownloadUrl().toString());
        if (this._OnCompleteHandler != null) {
          this._OnCompleteHandler.OnComplete(localBeyondPodHttpClient.FinalDownloadUrl().toString(), ((HttpResponse)localObject).getStatusLine().getStatusCode(), null);
        }
        if (localBeyondPodHttpClient != null) {
          localBeyondPodHttpClient.close();
        }
        return;
      }
      catch (Exception localException)
      {
        do
        {
          CoreHelper.LogException(CoreHelper.TAG, "Failed to follow redirect: " + this._UrlToTry, localException);
        } while (this._OnCompleteHandler == null);
        this._OnCompleteHandler.OnComplete(this._UrlToTry, -1, localException);
      }
    }
  }
  
  public static class TrackSizeInfo
  {
    public long SizeOnDisk;
    public long TotalTime;
    public boolean TotalTimeIsApproximate;
  }
  
  public static class UnableToEstablishNetworkConnectionException
    extends Exception
  {
    public UnableToEstablishNetworkConnectionException(String paramString)
    {
      super();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/helpers/CoreHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */