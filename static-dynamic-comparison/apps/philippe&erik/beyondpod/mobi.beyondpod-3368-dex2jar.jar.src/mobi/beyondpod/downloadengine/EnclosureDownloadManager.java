package mobi.beyondpod.downloadengine;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.aggregators.AggregatorLoginHelper.AuthenticationException;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.CoreHelper.IssuficientStorageSpaceException;
import mobi.beyondpod.rsscore.helpers.CoreHelper.UnableToEstablishNetworkConnectionException;
import mobi.beyondpod.rsscore.helpers.GenericQueue;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.repository.RepositoryPersistence;
import mobi.beyondpod.rsscore.rss.EnclosureDownloadHistory;
import mobi.beyondpod.rsscore.rss.entities.RssEnclosure;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;

public class EnclosureDownloadManager
{
  private static final String TAG = EnclosureDownloadManager.class.getSimpleName();
  private static boolean _DownloadServiceHolderStartedAtStart;
  private static final DownloadStatisticsList _DownloadStats = new DownloadStatisticsList();
  private static ArrayList<EnclosureBatchDownloadListener> _EnclosureBatchDownloadListener;
  static EnclosureDownloader.EnclosureDownloadListener _EnclosureDownloadListener;
  private static int _FailedDownloadsCount;
  private static int _SuccessfulDownloadsCount;
  private static boolean _WiFiTurnedOnAtStart;
  private static boolean m_AtQueueStart;
  private static final EnclosureDownloadQueue m_DownloadQueue;
  private static final EnclosureDownloader m_Downloader = new EnclosureDownloader();
  public static boolean m_IsUnattended;
  private static final HashMap<String, Integer> m_RetryList;
  
  static
  {
    m_DownloadQueue = new EnclosureDownloadQueue(null);
    m_RetryList = new HashMap();
    m_AtQueueStart = false;
    _WiFiTurnedOnAtStart = false;
    _DownloadServiceHolderStartedAtStart = false;
    m_IsUnattended = true;
    _EnclosureBatchDownloadListener = new ArrayList();
    _EnclosureDownloadListener = new EnclosureDownloader.EnclosureDownloadListener()
    {
      public void OnEnclosureDownloadCompleted(Track paramAnonymousTrack)
      {
        EnclosureDownloadManager.UpdateStatistics(paramAnonymousTrack);
        if (EnclosureDownloadManager.m_RetryList.containsKey(paramAnonymousTrack.getUrl())) {
          EnclosureDownloadManager.m_RetryList.remove(paramAnonymousTrack.getUrl());
        }
        ??? = paramAnonymousTrack.getParentFeed();
        ((Feed)???).NumDownloadedEnclosures += 1;
        EnclosureDownloadManager._SuccessfulDownloadsCount += 1;
        synchronized (EnclosureDownloadManager._EnclosureBatchDownloadListener)
        {
          Iterator localIterator = EnclosureDownloadManager._EnclosureBatchDownloadListener.iterator();
          if (!localIterator.hasNext())
          {
            EnclosureDownloadManager.m_DownloadQueue.dequeue();
            FeedRepository.NotifyFeedChanged(paramAnonymousTrack.getParentFeed());
            EnclosureDownloadManager.access$6();
            return;
          }
          ((EnclosureDownloadManager.EnclosureBatchDownloadListener)localIterator.next()).OnEnclosureDownloadCompleted(paramAnonymousTrack);
        }
      }
      
      public void OnEnclosureDownloadError(Track paramAnonymousTrack, Exception paramAnonymousException)
      {
        EnclosureDownloadManager.UpdateStatistics(paramAnonymousTrack);
        boolean bool = EnclosureDownloadManager.ShouldRetry(paramAnonymousTrack, paramAnonymousException);
        if (!bool)
        {
          EnclosureDownloadManager.m_DownloadQueue.dequeue();
          if ((!paramAnonymousTrack.Exists()) && (!paramAnonymousTrack.IsRemoteEpisode()) && (paramAnonymousTrack.getPlayedTime() == 0L) && (paramAnonymousTrack.RowID() == null))
          {
            paramAnonymousTrack.ChangeTrackingEnabled = false;
            FeedRepository.DeleteTrackAsync(paramAnonymousTrack);
          }
          EnclosureDownloadManager._FailedDownloadsCount += 1;
          CoreHelper.WriteTraceEntry(EnclosureDownloadManager.TAG, "@@@@ All retries failed! Giving up the download of: " + paramAnonymousTrack.getName());
        }
        synchronized (EnclosureDownloadManager._EnclosureBatchDownloadListener)
        {
          Iterator localIterator = EnclosureDownloadManager._EnclosureBatchDownloadListener.iterator();
          if (!localIterator.hasNext())
          {
            if ((paramAnonymousException instanceof CoreHelper.UnableToEstablishNetworkConnectionException)) {
              EnclosureDownloadManager.TerminateAllDownloads();
            }
          }
          else {
            ((EnclosureDownloadManager.EnclosureBatchDownloadListener)localIterator.next()).OnEnclosureDownloadFailed(paramAnonymousTrack, paramAnonymousException);
          }
        }
        if (bool)
        {
          CoreHelper.KeepDeviceAwake();
          CoreHelper.WriteLogEntryInProduction(EnclosureDownloadManager.TAG, "@@@@@ Sleeping before episode download retry...");
          CoreHelper.nap(10);
        }
        EnclosureDownloadManager.access$6();
      }
      
      public void OnEnclosureDownloadProgress(Track paramAnonymousTrack)
      {
        EnclosureDownloadManager.m_RetryList.containsKey(paramAnonymousTrack.getUrl());
        synchronized (EnclosureDownloadManager._EnclosureBatchDownloadListener)
        {
          Iterator localIterator = EnclosureDownloadManager._EnclosureBatchDownloadListener.iterator();
          if (!localIterator.hasNext()) {
            return;
          }
          ((EnclosureDownloadManager.EnclosureBatchDownloadListener)localIterator.next()).OnEnclosureDownloadProgress(paramAnonymousTrack);
        }
      }
      
      public void OnEnclosureDownloadStarted(Track paramAnonymousTrack)
      {
        synchronized (EnclosureDownloadManager._EnclosureBatchDownloadListener)
        {
          Iterator localIterator = EnclosureDownloadManager._EnclosureBatchDownloadListener.iterator();
          if (!localIterator.hasNext()) {
            return;
          }
          ((EnclosureDownloadManager.EnclosureBatchDownloadListener)localIterator.next()).OnEnclosureDownloadStarted(paramAnonymousTrack);
        }
      }
      
      public void OnEnclosureDownloadTerminated(Track paramAnonymousTrack)
      {
        EnclosureDownloadManager.UpdateStatistics(paramAnonymousTrack);
        synchronized (EnclosureDownloadManager._EnclosureBatchDownloadListener)
        {
          Iterator localIterator = EnclosureDownloadManager._EnclosureBatchDownloadListener.iterator();
          if (!localIterator.hasNext())
          {
            EnclosureDownloadManager.m_DownloadQueue.dequeue();
            EnclosureDownloadManager.access$6();
            return;
          }
          ((EnclosureDownloadManager.EnclosureBatchDownloadListener)localIterator.next()).OnEnclosureDownloadTerminated(paramAnonymousTrack);
        }
      }
    };
    m_Downloader.setEnclosureDownloadListener(_EnclosureDownloadListener);
  }
  
  public static Feed CurrentFeed()
  {
    if (m_DownloadQueue.size() == 0) {
      return null;
    }
    return ((DownloadableEnclosure)m_DownloadQueue.peek()).Feed;
  }
  
  public static int DownloadCount()
  {
    return m_DownloadQueue.DownloadCount;
  }
  
  private static void DownloadEnclosureInternal(DownloadableEnclosure paramDownloadableEnclosure)
  {
    Feed localFeed = paramDownloadableEnclosure.Feed;
    Long localLong = paramDownloadableEnclosure.Enclosure.EnclosureFileLength();
    for (;;)
    {
      try
      {
        if (((m_IsUnattended) || (Configuration.AllowCleanupForManualDownloads())) && (localFeed.getPodcastDownloadAction() != 4) && (localFeed.getPodcastDownloadAction() != 5))
        {
          localObject = paramDownloadableEnclosure.Enclosure.GetLocalEnclosureTrack();
          if ((localObject == null) || (!((Track)localObject).IsRemoteEpisode())) {
            continue;
          }
          CoreHelper.WriteLogEntryInProduction(TAG, "Episode Cleanup rules were ignored when downloading the remote episode: " + ((Track)localObject).getName());
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        CharSequence localCharSequence;
        CoreHelper.LogException(TAG, "Unable to delete old tracks for feed: " + localFeed.getName(), localException);
        continue;
        boolean bool = false;
        continue;
        String str = "";
        continue;
        str = "";
        continue;
        long l = localLong.longValue();
        continue;
        paramDownloadableEnclosure = new DownloadStatistics();
        paramDownloadableEnclosure.OwnerFeed = localFeed;
        paramDownloadableEnclosure.OwnerTrack = str;
        if (str != null) {
          break label388;
        }
      }
      if (paramDownloadableEnclosure.Enclosure.Parent == null) {
        continue;
      }
      localObject = CoreHelper.htmlDecode(paramDownloadableEnclosure.Enclosure.Parent.Title);
      localCharSequence = CoreHelper.cleanTitle((CharSequence)localObject);
      if (paramDownloadableEnclosure.Enclosure.Parent == null) {
        continue;
      }
      localObject = paramDownloadableEnclosure.Enclosure.Parent.Link.toString();
      localObject = FeedRepository.FindOrCreateLocalTrack(localFeed, paramDownloadableEnclosure.Enclosure.Url, paramDownloadableEnclosure.Enclosure.PubDate(), paramDownloadableEnclosure.Enclosure.ParentItemID(), paramDownloadableEnclosure.Enclosure.Type, localCharSequence.toString(), paramDownloadableEnclosure.Enclosure.Description(), (String)localObject, true);
      if ((localObject == null) || (((Track)localObject).IsFullyDownloaded())) {
        continue;
      }
      if (localLong != null) {
        continue;
      }
      l = 0L;
      ((Track)localObject).setDownloadSize(l);
      ((Track)localObject).setDownloadStatus(6);
      OnEnclosureDownloadStarting((Track)localObject);
      m_Downloader.DownloadTrack((Track)localObject, paramDownloadableEnclosure.Enclosure);
      return;
      if (localObject != null) {
        continue;
      }
      bool = true;
      FeedRepository.DeleteOldTracksForFeed(localFeed, bool);
    }
    paramDownloadableEnclosure.LastException = new Exception("Unable to create local track for download!");
    for (;;)
    {
      _DownloadStats.add(paramDownloadableEnclosure);
      m_DownloadQueue.dequeue();
      DownloadQueuedEnclosures();
      return;
      label388:
      paramDownloadableEnclosure.DownloadSkipped = true;
    }
  }
  
  static void DownloadEnclosures(List<DownloadableEnclosure> paramList, boolean paramBoolean)
  {
    if (IsDownloading())
    {
      CoreHelper.WriteTraceEntry(TAG, "Enclosure Download Manager is Downloading... Adding " + paramList.size() + " enclosures to the queue!");
      m_DownloadQueue.enqueue(paramList);
      OnEnclosureDownloadStarting(null);
      return;
    }
    CoreHelper.WriteTraceEntry(TAG, "Enclosure Download Manager is Idle... Starting download of " + paramList.size() + " enclosures!");
    if (PrepareForDownload())
    {
      m_IsUnattended = paramBoolean;
      m_DownloadQueue.enqueue(paramList);
      DownloadQueuedEnclosures();
      return;
    }
    OnDownloadBatchCompleted();
  }
  
  public static List<DownloadableEnclosure> DownloadQueue()
  {
    return m_DownloadQueue.DownloadQueue();
  }
  
  private static void DownloadQueuedEnclosures()
  {
    if (IsAtQueueStart()) {
      OnDownloadBatchStarted();
    }
    if (m_DownloadQueue.size() > 0)
    {
      DownloadEnclosureInternal((DownloadableEnclosure)m_DownloadQueue.peek());
      return;
    }
    CoreHelper.WriteTraceEntry(TAG, "Nothing to Download!");
    OnDownloadBatchCompleted();
  }
  
  public static int FailedDownloadsCount()
  {
    return _FailedDownloadsCount;
  }
  
  public static boolean IsAtQueueStart()
  {
    return m_AtQueueStart;
  }
  
  public static boolean IsDownloadPending(String paramString)
  {
    return m_DownloadQueue.containsUrl(paramString);
  }
  
  public static boolean IsDownloadPending(RssEnclosure paramRssEnclosure)
  {
    return IsDownloadPending(paramRssEnclosure.Url);
  }
  
  public static boolean IsDownloading()
  {
    return (m_Downloader.IsDownloading()) || (m_DownloadQueue.size() > 0);
  }
  
  public static List<DownloadableEnclosure> LoadDownloadQueueFromFile()
  {
    return m_DownloadQueue.LoadDownloadQueueFromFile();
  }
  
  private static void OnDownloadBatchCompleted()
  {
    synchronized (_EnclosureBatchDownloadListener)
    {
      Iterator localIterator = _EnclosureBatchDownloadListener.iterator();
      if (!localIterator.hasNext())
      {
        TurnWiFiOffIfNeeded();
        EnclosureDownloadHistory.SaveHistorySync();
        if (_DownloadServiceHolderStartedAtStart) {
          BeyondPodApplication.GetInstance().StopDownloadServiceHolder();
        }
        return;
      }
      ((EnclosureBatchDownloadListener)localIterator.next()).OnEnclosureBatchDownloadCompleted();
    }
  }
  
  private static void OnDownloadBatchStarted()
  {
    _FailedDownloadsCount = 0;
    _SuccessfulDownloadsCount = 0;
    _DownloadStats.clear();
    _DownloadStats.DownloadTime = new Date();
    _DownloadStats.IsUnattended = UpdateAndDownloadManager.IsUnattended();
    m_AtQueueStart = false;
    Object localObject2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder("Starting ");
    if (m_IsUnattended) {
      ??? = "automatic";
    }
    for (;;)
    {
      CoreHelper.WriteLogEntryInProduction((String)localObject2, (String)??? + " download batch of " + m_DownloadQueue.size() + " enclosures");
      if (!BeyondPodApplication.GetInstance().IsDownloadServiceHolderRunning()) {
        _DownloadServiceHolderStartedAtStart = BeyondPodApplication.GetInstance().StartDownloadServiceHolder();
      }
      TurnWiFiOnIfNeeded();
      synchronized (_EnclosureBatchDownloadListener)
      {
        localObject2 = _EnclosureBatchDownloadListener.iterator();
        if (!((Iterator)localObject2).hasNext())
        {
          return;
          ??? = "manual";
          continue;
        }
        ((EnclosureBatchDownloadListener)((Iterator)localObject2).next()).OnEnclosureBatchDownloadStarted();
      }
    }
  }
  
  private static void OnEnclosureDownloadStarting(Track paramTrack)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramTrack != null)
    {
      bool1 = bool2;
      if (m_RetryList.containsKey(paramTrack.getUrl())) {
        bool1 = true;
      }
    }
    synchronized (_EnclosureBatchDownloadListener)
    {
      Iterator localIterator = _EnclosureBatchDownloadListener.iterator();
      if (!localIterator.hasNext()) {
        return;
      }
      ((EnclosureBatchDownloadListener)localIterator.next()).OnEnclosureBatchEnclosureDownloadStarting(paramTrack, bool1);
    }
  }
  
  private static boolean PrepareForDownload()
  {
    if (!CoreHelper.IsAlreadyConnectedOrWiFiShouldBeTurnedOnDuringUpdate())
    {
      CoreHelper.WriteLogEntryInProduction(TAG, "Unable to start enclosure download! Device is not connected to a network!");
      synchronized (_EnclosureBatchDownloadListener)
      {
        Iterator localIterator = _EnclosureBatchDownloadListener.iterator();
        if (!localIterator.hasNext()) {
          return false;
        }
        ((EnclosureBatchDownloadListener)localIterator.next()).OnUnableToEstablishNetworkConnection();
      }
    }
    _DownloadStats.clear();
    m_RetryList.clear();
    m_DownloadQueue.clear();
    m_AtQueueStart = true;
    return true;
  }
  
  public static int QueueCount()
  {
    return m_DownloadQueue.size();
  }
  
  public static void RemoveFromQueue(RssEnclosure paramRssEnclosure)
  {
    Track localTrack = m_Downloader.Track();
    if ((localTrack != null) && (StringUtils.EqualsIgnoreCase(localTrack.getUrl(), paramRssEnclosure.Url))) {
      return;
    }
    m_DownloadQueue.removeFromQueue(paramRssEnclosure.Url);
  }
  
  private static boolean ShouldRetry(Track paramTrack, Exception paramException)
  {
    int i = 1;
    if ((paramException instanceof CoreHelper.IssuficientStorageSpaceException)) {
      i = 0;
    }
    BeyondPodApplication.PokeWiFiIfNeeded(paramException);
    if ((paramException instanceof AggregatorLoginHelper.AuthenticationException)) {
      i = 0;
    }
    if ((paramException instanceof DownloadAgent.WebException))
    {
      if (((DownloadAgent.WebException)paramException).StatusCode == 416) {
        i = 1;
      }
    }
    else
    {
      if (i == 0) {
        break label141;
      }
      if (!m_RetryList.containsKey(paramTrack.getUrl())) {
        break label123;
      }
      paramException = (Integer)m_RetryList.get(paramTrack.getUrl());
      m_RetryList.put(paramTrack.getUrl(), Integer.valueOf(paramException.intValue() - 1));
    }
    for (;;)
    {
      if (((Integer)m_RetryList.get(paramTrack.getUrl())).intValue() <= 0) {
        break label159;
      }
      return true;
      i = 0;
      break;
      label123:
      m_RetryList.put(paramTrack.getUrl(), Integer.valueOf(2));
      continue;
      label141:
      m_RetryList.put(paramTrack.getUrl(), Integer.valueOf(0));
    }
    label159:
    return false;
  }
  
  public static DownloadStatisticsList Statistics()
  {
    return _DownloadStats;
  }
  
  public static int SuccessfulDownloadsCount()
  {
    return _SuccessfulDownloadsCount;
  }
  
  public static void TerminateAllDownloads()
  {
    CoreHelper.WriteLogEntry(TAG, ">> Received TerminatinateAllDownloads command");
    if (m_DownloadQueue.size() > 0) {
      m_DownloadQueue.clear();
    }
    if (m_Downloader.IsDownloading()) {
      m_Downloader.Stop();
    }
    EnclosureDownloadHistory.SaveHistorySync();
    synchronized (_EnclosureBatchDownloadListener)
    {
      Iterator localIterator = _EnclosureBatchDownloadListener.iterator();
      if (!localIterator.hasNext()) {
        return;
      }
      ((EnclosureBatchDownloadListener)localIterator.next()).OnEnclosureBatchDownloadCanceled();
    }
  }
  
  public static void TerminateCurrentDownload()
  {
    if (m_Downloader.IsDownloading()) {
      m_Downloader.Stop();
    }
  }
  
  private static void TurnWiFiOffIfNeeded()
  {
    if (_WiFiTurnedOnAtStart) {
      BeyondPodApplication.ToggleWiFi(false, TAG);
    }
    _WiFiTurnedOnAtStart = false;
  }
  
  private static void TurnWiFiOnIfNeeded()
  {
    if (Configuration.TurnWiFiDuringUpdate()) {
      _WiFiTurnedOnAtStart = BeyondPodApplication.ToggleWiFi(true, TAG);
    }
  }
  
  private static void UpdateStatistics(Track paramTrack)
  {
    if (m_Downloader.Statistics() != null)
    {
      m_Downloader.Statistics().OwnerTrack = paramTrack;
      m_Downloader.Statistics().OwnerFeed = paramTrack.getParentFeed();
      _DownloadStats.add(m_Downloader.Statistics());
    }
  }
  
  public static void addEnclosureBatchDownloadListener(EnclosureBatchDownloadListener paramEnclosureBatchDownloadListener)
  {
    synchronized (_EnclosureBatchDownloadListener)
    {
      if (_EnclosureBatchDownloadListener.contains(paramEnclosureBatchDownloadListener)) {
        return;
      }
      _EnclosureBatchDownloadListener.add(paramEnclosureBatchDownloadListener);
      return;
    }
  }
  
  public static void removeEnclosureBatchDownloadListener(EnclosureBatchDownloadListener paramEnclosureBatchDownloadListener)
  {
    synchronized (_EnclosureBatchDownloadListener)
    {
      if (!_EnclosureBatchDownloadListener.contains(paramEnclosureBatchDownloadListener)) {
        return;
      }
      _EnclosureBatchDownloadListener.remove(paramEnclosureBatchDownloadListener);
      return;
    }
  }
  
  public static class DownloadableEnclosure
  {
    public RssEnclosure Enclosure;
    public Feed Feed;
    
    public DownloadableEnclosure(Feed paramFeed, RssEnclosure paramRssEnclosure)
    {
      this.Feed = paramFeed;
      this.Enclosure = paramRssEnclosure;
    }
  }
  
  public static abstract interface EnclosureBatchDownloadListener
  {
    public abstract void OnAnotherDownloadIsInProgress();
    
    public abstract void OnEnclosureBatchDownloadCanceled();
    
    public abstract void OnEnclosureBatchDownloadCompleted();
    
    public abstract void OnEnclosureBatchDownloadStarted();
    
    public abstract void OnEnclosureBatchEnclosureDownloadStarting(Track paramTrack, boolean paramBoolean);
    
    public abstract void OnEnclosureDownloadCanceled(Track paramTrack);
    
    public abstract void OnEnclosureDownloadCompleted(Track paramTrack);
    
    public abstract void OnEnclosureDownloadFailed(Track paramTrack, Exception paramException);
    
    public abstract void OnEnclosureDownloadProgress(Track paramTrack);
    
    public abstract void OnEnclosureDownloadStarted(Track paramTrack);
    
    public abstract void OnEnclosureDownloadTerminated(Track paramTrack);
    
    public abstract void OnUnableToEstablishNetworkConnection();
  }
  
  private static class EnclosureDownloadQueue
    extends GenericQueue<EnclosureDownloadManager.DownloadableEnclosure>
  {
    public int DownloadCount = 0;
    Runnable _SaveDownloadQueueRunnable = new Runnable()
    {
      public void run()
      {
        EnclosureDownloadManager.EnclosureDownloadQueue.this.SaveDownloadQueueToFileInternal();
      }
    };
    
    private void OnDownloadQueueChanged()
    {
      BeyondPodApplication.MessageBus.PublishEvent(new UpdateAndDownloadEvents.UpdateAndDownloadEvent(DownloadEngineNotificationManager.class, UpdateAndDownloadEvents.UpdateAndDownloadEvent.ENCLOSURE_DOWNLOAD_QUEUE_CHANGED, null));
      SaveDownloadQueueToFile();
    }
    
    private void SaveDownloadQueueToFile()
    {
      RepositoryPersistence.RepositoryHandler().removeCallbacks(this._SaveDownloadQueueRunnable);
      RepositoryPersistence.RepositoryHandler().postDelayed(this._SaveDownloadQueueRunnable, 100L);
    }
    
    /* Error */
    private void SaveDownloadQueueToFileInternal()
    {
      // Byte code:
      //   0: invokestatic 80	mobi/beyondpod/rsscore/Configuration:EnclosureDownloadQueueFilePath	()Ljava/lang/String;
      //   3: astore 6
      //   5: aconst_null
      //   6: astore 5
      //   8: aconst_null
      //   9: astore 7
      //   11: aload 5
      //   13: astore 4
      //   15: aload_0
      //   16: invokevirtual 84	mobi/beyondpod/downloadengine/EnclosureDownloadManager$EnclosureDownloadQueue:hasItems	()Z
      //   19: ifne +59 -> 78
      //   22: aload 5
      //   24: astore 4
      //   26: new 86	java/io/File
      //   29: dup
      //   30: invokestatic 80	mobi/beyondpod/rsscore/Configuration:EnclosureDownloadQueueFilePath	()Ljava/lang/String;
      //   33: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;)V
      //   36: invokevirtual 92	java/io/File:delete	()Z
      //   39: pop
      //   40: aload 5
      //   42: astore 4
      //   44: invokestatic 95	mobi/beyondpod/downloadengine/EnclosureDownloadManager:access$10	()Ljava/lang/String;
      //   47: ldc 97
      //   49: invokestatic 103	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
      //   52: iconst_0
      //   53: ifeq +11 -> 64
      //   56: new 105	java/lang/NullPointerException
      //   59: dup
      //   60: invokespecial 106	java/lang/NullPointerException:<init>	()V
      //   63: athrow
      //   64: return
      //   65: astore 4
      //   67: invokestatic 95	mobi/beyondpod/downloadengine/EnclosureDownloadManager:access$10	()Ljava/lang/String;
      //   70: ldc 108
      //   72: aload 4
      //   74: invokestatic 112	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   77: return
      //   78: aload 5
      //   80: astore 4
      //   82: invokestatic 95	mobi/beyondpod/downloadengine/EnclosureDownloadManager:access$10	()Ljava/lang/String;
      //   85: new 114	java/lang/StringBuilder
      //   88: dup
      //   89: ldc 116
      //   91: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   94: aload_0
      //   95: invokevirtual 121	mobi/beyondpod/downloadengine/EnclosureDownloadManager$EnclosureDownloadQueue:size	()I
      //   98: invokevirtual 125	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   101: ldc 127
      //   103: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   106: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   109: invokestatic 103	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
      //   112: aload 5
      //   114: astore 4
      //   116: new 135	java/io/FileOutputStream
      //   119: dup
      //   120: aload 6
      //   122: invokespecial 136	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
      //   125: astore 6
      //   127: aload 5
      //   129: astore 4
      //   131: new 138	java/io/DataOutputStream
      //   134: dup
      //   135: aload 6
      //   137: invokespecial 141	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   140: astore 5
      //   142: iconst_0
      //   143: istore_1
      //   144: iload_1
      //   145: aload_0
      //   146: invokevirtual 121	mobi/beyondpod/downloadengine/EnclosureDownloadManager$EnclosureDownloadQueue:size	()I
      //   149: if_icmpne +25 -> 174
      //   152: aload 6
      //   154: invokestatic 145	mobi/beyondpod/rsscore/helpers/CoreHelper:sync	(Ljava/io/FileOutputStream;)Z
      //   157: pop
      //   158: aload 5
      //   160: invokevirtual 148	java/io/DataOutputStream:close	()V
      //   163: aload 5
      //   165: ifnull +283 -> 448
      //   168: aload 5
      //   170: invokevirtual 148	java/io/DataOutputStream:close	()V
      //   173: return
      //   174: aload_0
      //   175: iload_1
      //   176: invokevirtual 152	mobi/beyondpod/downloadengine/EnclosureDownloadManager$EnclosureDownloadQueue:get	(I)Ljava/lang/Object;
      //   179: checkcast 154	mobi/beyondpod/downloadengine/EnclosureDownloadManager$DownloadableEnclosure
      //   182: astore 7
      //   184: aload 5
      //   186: aload 7
      //   188: getfield 158	mobi/beyondpod/downloadengine/EnclosureDownloadManager$DownloadableEnclosure:Feed	Lmobi/beyondpod/rsscore/Feed;
      //   191: invokevirtual 164	mobi/beyondpod/rsscore/Feed:ID	()Ljava/util/UUID;
      //   194: invokevirtual 167	java/util/UUID:toString	()Ljava/lang/String;
      //   197: invokevirtual 170	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
      //   200: aload 7
      //   202: getfield 174	mobi/beyondpod/downloadengine/EnclosureDownloadManager$DownloadableEnclosure:Enclosure	Lmobi/beyondpod/rsscore/rss/entities/RssEnclosure;
      //   205: getfield 180	mobi/beyondpod/rsscore/rss/entities/RssEnclosure:Type	Ljava/lang/String;
      //   208: ifnonnull +111 -> 319
      //   211: ldc -74
      //   213: astore 4
      //   215: aload 5
      //   217: aload 4
      //   219: invokevirtual 170	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
      //   222: aload 5
      //   224: aload 7
      //   226: getfield 174	mobi/beyondpod/downloadengine/EnclosureDownloadManager$DownloadableEnclosure:Enclosure	Lmobi/beyondpod/rsscore/rss/entities/RssEnclosure;
      //   229: getfield 185	mobi/beyondpod/rsscore/rss/entities/RssEnclosure:Url	Ljava/lang/String;
      //   232: invokevirtual 170	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
      //   235: aload 5
      //   237: aload 7
      //   239: getfield 174	mobi/beyondpod/downloadengine/EnclosureDownloadManager$DownloadableEnclosure:Enclosure	Lmobi/beyondpod/rsscore/rss/entities/RssEnclosure;
      //   242: getfield 188	mobi/beyondpod/rsscore/rss/entities/RssEnclosure:DownloadPath	Ljava/lang/String;
      //   245: invokevirtual 170	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
      //   248: aload 5
      //   250: aload 7
      //   252: getfield 174	mobi/beyondpod/downloadengine/EnclosureDownloadManager$DownloadableEnclosure:Enclosure	Lmobi/beyondpod/rsscore/rss/entities/RssEnclosure;
      //   255: invokevirtual 191	mobi/beyondpod/rsscore/rss/entities/RssEnclosure:FileName	()Ljava/lang/String;
      //   258: invokevirtual 170	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
      //   261: aload 5
      //   263: aload 7
      //   265: getfield 174	mobi/beyondpod/downloadengine/EnclosureDownloadManager$DownloadableEnclosure:Enclosure	Lmobi/beyondpod/rsscore/rss/entities/RssEnclosure;
      //   268: invokevirtual 194	mobi/beyondpod/rsscore/rss/entities/RssEnclosure:ParentItemID	()Ljava/lang/String;
      //   271: invokevirtual 170	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
      //   274: aload 7
      //   276: getfield 174	mobi/beyondpod/downloadengine/EnclosureDownloadManager$DownloadableEnclosure:Enclosure	Lmobi/beyondpod/rsscore/rss/entities/RssEnclosure;
      //   279: invokevirtual 198	mobi/beyondpod/rsscore/rss/entities/RssEnclosure:EnclosureFileLength	()Ljava/lang/Long;
      //   282: ifnonnull +50 -> 332
      //   285: lconst_0
      //   286: lstore_2
      //   287: aload 5
      //   289: lload_2
      //   290: invokevirtual 202	java/io/DataOutputStream:writeLong	(J)V
      //   293: aload 7
      //   295: getfield 174	mobi/beyondpod/downloadengine/EnclosureDownloadManager$DownloadableEnclosure:Enclosure	Lmobi/beyondpod/rsscore/rss/entities/RssEnclosure;
      //   298: invokevirtual 206	mobi/beyondpod/rsscore/rss/entities/RssEnclosure:PubDate	()Ljava/util/Date;
      //   301: ifnonnull +46 -> 347
      //   304: lconst_0
      //   305: lstore_2
      //   306: aload 5
      //   308: lload_2
      //   309: invokevirtual 202	java/io/DataOutputStream:writeLong	(J)V
      //   312: iload_1
      //   313: iconst_1
      //   314: iadd
      //   315: istore_1
      //   316: goto -172 -> 144
      //   319: aload 7
      //   321: getfield 174	mobi/beyondpod/downloadengine/EnclosureDownloadManager$DownloadableEnclosure:Enclosure	Lmobi/beyondpod/rsscore/rss/entities/RssEnclosure;
      //   324: getfield 180	mobi/beyondpod/rsscore/rss/entities/RssEnclosure:Type	Ljava/lang/String;
      //   327: astore 4
      //   329: goto -114 -> 215
      //   332: aload 7
      //   334: getfield 174	mobi/beyondpod/downloadengine/EnclosureDownloadManager$DownloadableEnclosure:Enclosure	Lmobi/beyondpod/rsscore/rss/entities/RssEnclosure;
      //   337: invokevirtual 198	mobi/beyondpod/rsscore/rss/entities/RssEnclosure:EnclosureFileLength	()Ljava/lang/Long;
      //   340: invokevirtual 212	java/lang/Long:longValue	()J
      //   343: lstore_2
      //   344: goto -57 -> 287
      //   347: aload 7
      //   349: getfield 174	mobi/beyondpod/downloadengine/EnclosureDownloadManager$DownloadableEnclosure:Enclosure	Lmobi/beyondpod/rsscore/rss/entities/RssEnclosure;
      //   352: invokevirtual 206	mobi/beyondpod/rsscore/rss/entities/RssEnclosure:PubDate	()Ljava/util/Date;
      //   355: invokevirtual 217	java/util/Date:getTime	()J
      //   358: lstore_2
      //   359: goto -53 -> 306
      //   362: astore 6
      //   364: aload 7
      //   366: astore 5
      //   368: aload 5
      //   370: astore 4
      //   372: invokestatic 95	mobi/beyondpod/downloadengine/EnclosureDownloadManager:access$10	()Ljava/lang/String;
      //   375: ldc 108
      //   377: aload 6
      //   379: invokestatic 112	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   382: aload 5
      //   384: ifnull -320 -> 64
      //   387: aload 5
      //   389: invokevirtual 148	java/io/DataOutputStream:close	()V
      //   392: return
      //   393: astore 4
      //   395: invokestatic 95	mobi/beyondpod/downloadengine/EnclosureDownloadManager:access$10	()Ljava/lang/String;
      //   398: ldc 108
      //   400: aload 4
      //   402: invokestatic 112	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   405: return
      //   406: astore 5
      //   408: aload 4
      //   410: ifnull +8 -> 418
      //   413: aload 4
      //   415: invokevirtual 148	java/io/DataOutputStream:close	()V
      //   418: aload 5
      //   420: athrow
      //   421: astore 4
      //   423: invokestatic 95	mobi/beyondpod/downloadengine/EnclosureDownloadManager:access$10	()Ljava/lang/String;
      //   426: ldc 108
      //   428: aload 4
      //   430: invokestatic 112	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   433: goto -15 -> 418
      //   436: astore 4
      //   438: invokestatic 95	mobi/beyondpod/downloadengine/EnclosureDownloadManager:access$10	()Ljava/lang/String;
      //   441: ldc 108
      //   443: aload 4
      //   445: invokestatic 112	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   448: return
      //   449: astore 6
      //   451: aload 5
      //   453: astore 4
      //   455: aload 6
      //   457: astore 5
      //   459: goto -51 -> 408
      //   462: astore 6
      //   464: goto -96 -> 368
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	467	0	this	EnclosureDownloadQueue
      //   143	173	1	i	int
      //   286	73	2	l	long
      //   13	30	4	localObject1	Object
      //   65	8	4	localException1	Exception
      //   80	291	4	localObject2	Object
      //   393	21	4	localException2	Exception
      //   421	8	4	localException3	Exception
      //   436	8	4	localException4	Exception
      //   453	1	4	localObject3	Object
      //   6	382	5	localObject4	Object
      //   406	46	5	localObject5	Object
      //   457	1	5	localObject6	Object
      //   3	150	6	localObject7	Object
      //   362	16	6	localException5	Exception
      //   449	7	6	localObject8	Object
      //   462	1	6	localException6	Exception
      //   9	356	7	localDownloadableEnclosure	EnclosureDownloadManager.DownloadableEnclosure
      // Exception table:
      //   from	to	target	type
      //   56	64	65	java/lang/Exception
      //   15	22	362	java/lang/Exception
      //   26	40	362	java/lang/Exception
      //   44	52	362	java/lang/Exception
      //   82	112	362	java/lang/Exception
      //   116	127	362	java/lang/Exception
      //   131	142	362	java/lang/Exception
      //   387	392	393	java/lang/Exception
      //   15	22	406	finally
      //   26	40	406	finally
      //   44	52	406	finally
      //   82	112	406	finally
      //   116	127	406	finally
      //   131	142	406	finally
      //   372	382	406	finally
      //   413	418	421	java/lang/Exception
      //   168	173	436	java/lang/Exception
      //   144	163	449	finally
      //   174	211	449	finally
      //   215	285	449	finally
      //   287	304	449	finally
      //   306	312	449	finally
      //   319	329	449	finally
      //   332	344	449	finally
      //   347	359	449	finally
      //   144	163	462	java/lang/Exception
      //   174	211	462	java/lang/Exception
      //   215	285	462	java/lang/Exception
      //   287	304	462	java/lang/Exception
      //   306	312	462	java/lang/Exception
      //   319	329	462	java/lang/Exception
      //   332	344	462	java/lang/Exception
      //   347	359	462	java/lang/Exception
    }
    
    private boolean enqueueInternal(EnclosureDownloadManager.DownloadableEnclosure paramDownloadableEnclosure)
    {
      if ((paramDownloadableEnclosure.Feed == null) || (StringUtils.IsNullOrEmpty(paramDownloadableEnclosure.Enclosure.Url))) {}
      while (contains(paramDownloadableEnclosure)) {
        return false;
      }
      if (size() == 0) {}
      for (this.DownloadCount = 1;; this.DownloadCount += 1)
      {
        super.enqueue(paramDownloadableEnclosure);
        return true;
      }
    }
    
    public List<EnclosureDownloadManager.DownloadableEnclosure> DownloadQueue()
    {
      ArrayList localArrayList = new ArrayList(size());
      int i = 0;
      for (;;)
      {
        if (i == size()) {
          return localArrayList;
        }
        localArrayList.add((EnclosureDownloadManager.DownloadableEnclosure)get(i));
        i += 1;
      }
    }
    
    /* Error */
    public ArrayList<EnclosureDownloadManager.DownloadableEnclosure> LoadDownloadQueueFromFile()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: aconst_null
      //   3: astore 6
      //   5: new 239	java/util/ArrayList
      //   8: dup
      //   9: invokespecial 255	java/util/ArrayList:<init>	()V
      //   12: astore 7
      //   14: new 86	java/io/File
      //   17: dup
      //   18: invokestatic 80	mobi/beyondpod/rsscore/Configuration:EnclosureDownloadQueueFilePath	()Ljava/lang/String;
      //   21: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;)V
      //   24: astore 4
      //   26: aload 4
      //   28: invokevirtual 258	java/io/File:exists	()Z
      //   31: ifeq +176 -> 207
      //   34: new 260	java/io/FileInputStream
      //   37: dup
      //   38: aload 4
      //   40: invokespecial 263	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   43: astore 4
      //   45: new 265	java/io/DataInputStream
      //   48: dup
      //   49: aload 4
      //   51: invokespecial 268	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
      //   54: astore 6
      //   56: aconst_null
      //   57: astore_3
      //   58: aload 6
      //   60: invokevirtual 271	java/io/DataInputStream:readUTF	()Ljava/lang/String;
      //   63: invokestatic 275	java/util/UUID:fromString	(Ljava/lang/String;)Ljava/util/UUID;
      //   66: astore 5
      //   68: aload 5
      //   70: astore_3
      //   71: aload 6
      //   73: invokevirtual 271	java/io/DataInputStream:readUTF	()Ljava/lang/String;
      //   76: astore 5
      //   78: aload 6
      //   80: invokevirtual 271	java/io/DataInputStream:readUTF	()Ljava/lang/String;
      //   83: astore 8
      //   85: aload 6
      //   87: invokevirtual 271	java/io/DataInputStream:readUTF	()Ljava/lang/String;
      //   90: astore 9
      //   92: aload 6
      //   94: invokevirtual 271	java/io/DataInputStream:readUTF	()Ljava/lang/String;
      //   97: astore 10
      //   99: aload 6
      //   101: invokevirtual 271	java/io/DataInputStream:readUTF	()Ljava/lang/String;
      //   104: astore 11
      //   106: aload 6
      //   108: invokevirtual 278	java/io/DataInputStream:readLong	()J
      //   111: lstore_1
      //   112: aload 6
      //   114: invokevirtual 278	java/io/DataInputStream:readLong	()J
      //   117: invokestatic 282	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   120: astore 13
      //   122: aload_3
      //   123: invokestatic 288	mobi/beyondpod/rsscore/repository/FeedRepository:GetFeedById	(Ljava/util/UUID;)Lmobi/beyondpod/rsscore/Feed;
      //   126: astore 12
      //   128: aload 12
      //   130: ifnull -74 -> 56
      //   133: lload_1
      //   134: invokestatic 282	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   137: invokevirtual 212	java/lang/Long:longValue	()J
      //   140: lstore_1
      //   141: aload 13
      //   143: invokevirtual 212	java/lang/Long:longValue	()J
      //   146: lconst_0
      //   147: lcmp
      //   148: ifne +99 -> 247
      //   151: aconst_null
      //   152: astore_3
      //   153: aload 7
      //   155: new 154	mobi/beyondpod/downloadengine/EnclosureDownloadManager$DownloadableEnclosure
      //   158: dup
      //   159: aload 12
      //   161: new 176	mobi/beyondpod/rsscore/rss/entities/RssEnclosure
      //   164: dup
      //   165: aload 8
      //   167: aload 9
      //   169: aload 10
      //   171: aload 5
      //   173: aload 11
      //   175: lload_1
      //   176: aload_3
      //   177: aconst_null
      //   178: invokespecial 291	mobi/beyondpod/rsscore/rss/entities/RssEnclosure:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/util/Date;Ljava/lang/String;)V
      //   181: invokespecial 294	mobi/beyondpod/downloadengine/EnclosureDownloadManager$DownloadableEnclosure:<init>	(Lmobi/beyondpod/rsscore/Feed;Lmobi/beyondpod/rsscore/rss/entities/RssEnclosure;)V
      //   184: invokevirtual 295	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   187: pop
      //   188: goto -132 -> 56
      //   191: astore_3
      //   192: aload 4
      //   194: invokevirtual 296	java/io/FileInputStream:close	()V
      //   197: aload 4
      //   199: ifnull +154 -> 353
      //   202: aload 4
      //   204: invokevirtual 296	java/io/FileInputStream:close	()V
      //   207: invokestatic 95	mobi/beyondpod/downloadengine/EnclosureDownloadManager:access$10	()Ljava/lang/String;
      //   210: new 114	java/lang/StringBuilder
      //   213: dup
      //   214: ldc_w 298
      //   217: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   220: aload 7
      //   222: invokevirtual 299	java/util/ArrayList:size	()I
      //   225: invokevirtual 125	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   228: ldc_w 301
      //   231: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   234: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   237: invokestatic 103	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
      //   240: aload 7
      //   242: areturn
      //   243: astore_3
      //   244: goto -52 -> 192
      //   247: new 214	java/util/Date
      //   250: dup
      //   251: aload 13
      //   253: invokevirtual 212	java/lang/Long:longValue	()J
      //   256: invokespecial 303	java/util/Date:<init>	(J)V
      //   259: astore_3
      //   260: goto -107 -> 153
      //   263: astore 5
      //   265: aload 4
      //   267: astore_3
      //   268: invokestatic 95	mobi/beyondpod/downloadengine/EnclosureDownloadManager:access$10	()Ljava/lang/String;
      //   271: ldc_w 305
      //   274: aload 5
      //   276: invokestatic 112	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   279: aload 4
      //   281: ifnull -74 -> 207
      //   284: aload 4
      //   286: invokevirtual 296	java/io/FileInputStream:close	()V
      //   289: goto -82 -> 207
      //   292: astore_3
      //   293: invokestatic 95	mobi/beyondpod/downloadengine/EnclosureDownloadManager:access$10	()Ljava/lang/String;
      //   296: ldc_w 305
      //   299: aload_3
      //   300: invokestatic 112	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   303: goto -96 -> 207
      //   306: astore 5
      //   308: aload_3
      //   309: astore 4
      //   311: aload 5
      //   313: astore_3
      //   314: aload 4
      //   316: ifnull +8 -> 324
      //   319: aload 4
      //   321: invokevirtual 296	java/io/FileInputStream:close	()V
      //   324: aload_3
      //   325: athrow
      //   326: astore 4
      //   328: invokestatic 95	mobi/beyondpod/downloadengine/EnclosureDownloadManager:access$10	()Ljava/lang/String;
      //   331: ldc_w 305
      //   334: aload 4
      //   336: invokestatic 112	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   339: goto -15 -> 324
      //   342: astore_3
      //   343: invokestatic 95	mobi/beyondpod/downloadengine/EnclosureDownloadManager:access$10	()Ljava/lang/String;
      //   346: ldc_w 305
      //   349: aload_3
      //   350: invokestatic 112	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   353: goto -146 -> 207
      //   356: astore_3
      //   357: goto -43 -> 314
      //   360: astore 5
      //   362: aload 6
      //   364: astore 4
      //   366: goto -101 -> 265
      //   369: astore 5
      //   371: goto -300 -> 71
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	374	0	this	EnclosureDownloadQueue
      //   111	65	1	l	long
      //   1	176	3	localObject1	Object
      //   191	1	3	localEOFException1	java.io.EOFException
      //   243	1	3	localEOFException2	java.io.EOFException
      //   259	9	3	localObject2	Object
      //   292	17	3	localException1	Exception
      //   313	12	3	localObject3	Object
      //   342	8	3	localException2	Exception
      //   356	1	3	localObject4	Object
      //   24	296	4	localObject5	Object
      //   326	9	4	localException3	Exception
      //   364	1	4	localDataInputStream1	java.io.DataInputStream
      //   66	106	5	localObject6	Object
      //   263	12	5	localException4	Exception
      //   306	6	5	localObject7	Object
      //   360	1	5	localException5	Exception
      //   369	1	5	localException6	Exception
      //   3	360	6	localDataInputStream2	java.io.DataInputStream
      //   12	229	7	localArrayList	ArrayList
      //   83	83	8	str1	String
      //   90	78	9	str2	String
      //   97	73	10	str3	String
      //   104	70	11	str4	String
      //   126	34	12	localFeed	Feed
      //   120	132	13	localLong	Long
      // Exception table:
      //   from	to	target	type
      //   71	128	191	java/io/EOFException
      //   133	151	191	java/io/EOFException
      //   153	188	191	java/io/EOFException
      //   247	260	191	java/io/EOFException
      //   58	68	243	java/io/EOFException
      //   45	56	263	java/lang/Exception
      //   71	128	263	java/lang/Exception
      //   133	151	263	java/lang/Exception
      //   153	188	263	java/lang/Exception
      //   192	197	263	java/lang/Exception
      //   247	260	263	java/lang/Exception
      //   284	289	292	java/lang/Exception
      //   34	45	306	finally
      //   268	279	306	finally
      //   319	324	326	java/lang/Exception
      //   202	207	342	java/lang/Exception
      //   45	56	356	finally
      //   58	68	356	finally
      //   71	128	356	finally
      //   133	151	356	finally
      //   153	188	356	finally
      //   192	197	356	finally
      //   247	260	356	finally
      //   34	45	360	java/lang/Exception
      //   58	68	369	java/lang/Exception
    }
    
    public void clear()
    {
      super.clear();
      OnDownloadQueueChanged();
    }
    
    public boolean contains(EnclosureDownloadManager.DownloadableEnclosure paramDownloadableEnclosure)
    {
      return containsUrl(paramDownloadableEnclosure.Enclosure.Url);
    }
    
    public boolean containsUrl(String paramString)
    {
      int i = 0;
      for (;;)
      {
        if (i == size()) {
          return false;
        }
        if (StringUtils.Equals(((EnclosureDownloadManager.DownloadableEnclosure)get(i)).Enclosure.Url, paramString)) {
          return true;
        }
        i += 1;
      }
    }
    
    public EnclosureDownloadManager.DownloadableEnclosure dequeue()
    {
      EnclosureDownloadManager.DownloadableEnclosure localDownloadableEnclosure = (EnclosureDownloadManager.DownloadableEnclosure)super.dequeue();
      OnDownloadQueueChanged();
      return localDownloadableEnclosure;
    }
    
    public void enqueue(List<EnclosureDownloadManager.DownloadableEnclosure> paramList)
    {
      paramList = paramList.iterator();
      for (;;)
      {
        if (!paramList.hasNext())
        {
          OnDownloadQueueChanged();
          return;
        }
        enqueueInternal((EnclosureDownloadManager.DownloadableEnclosure)paramList.next());
      }
    }
    
    public void enqueue(EnclosureDownloadManager.DownloadableEnclosure paramDownloadableEnclosure)
    {
      if (enqueueInternal(paramDownloadableEnclosure)) {
        OnDownloadQueueChanged();
      }
    }
    
    public void removeFromQueue(String paramString)
    {
      int i = 0;
      for (;;)
      {
        if (i == size()) {
          return;
        }
        EnclosureDownloadManager.DownloadableEnclosure localDownloadableEnclosure = (EnclosureDownloadManager.DownloadableEnclosure)get(i);
        if (StringUtils.Equals(localDownloadableEnclosure.Enclosure.Url, paramString))
        {
          super.remove(localDownloadableEnclosure);
          OnDownloadQueueChanged();
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/downloadengine/EnclosureDownloadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */