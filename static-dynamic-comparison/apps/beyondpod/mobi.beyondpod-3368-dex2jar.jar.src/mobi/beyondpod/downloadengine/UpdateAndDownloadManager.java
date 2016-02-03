package mobi.beyondpod.downloadengine;

import android.os.Handler;
import android.os.Process;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.R.string;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackFilter;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.CoreHelper.DeviceNetworkConnection;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.repository.FlashStorageLocation;
import mobi.beyondpod.rsscore.repository.RepositoryPersistence;
import mobi.beyondpod.rsscore.rss.EnclosureDownloadHistory;
import mobi.beyondpod.rsscore.rss.RssFeedCache;
import mobi.beyondpod.rsscore.rss.entities.RssEnclosure;
import mobi.beyondpod.rsscore.rss.entities.RssFeed;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;
import mobi.beyondpod.rsscore.rss.parsers.FeedParseData;
import mobi.beyondpod.services.player.PlayList;
import mobi.beyondpod.services.player.SmartPlaylistTemplate;

public class UpdateAndDownloadManager
{
  private static final String CURRENTLY_PODCASTS_CAN_BE_DOWNLOADED_AUTOMATICALLY_ONLY_OVER_A_WI_FI;
  private static final String CURRENTLY_PODCASTS_CAN_BE_DOWNLOADED_AUTOMATICALLY_ONLY_WHEN_THE_DEVICE_IS_PLUGGED_IN;
  private static final String SCHEDULED_UPDATE_DID_NOT_RUN_BECAUSE_BACKGROUND_DATA_IS_DISABLED = CoreHelper.LoadResourceString(R.string.update_download_mgr_scheduled_update_did_not_run_because_background_data_is_disabled);
  protected static final String TAG;
  private static final String THE_DEVICE_HAS_NO_INTERNET_CONNECTION_WI_FI_ADAPTER_IS_OFF;
  private static final String UNABLE_TO_ESTABLISH_INTERNET_CONECTION_THE_DEVICE_IS_IN_AIRPLANE_MODE = CoreHelper.LoadResourceString(R.string.update_download_mgr_unable_to_establish_internet_conection_the_device_is_in_airplane_mode);
  static EnclosureDownloadManager.EnclosureBatchDownloadListener _EnclosureBatchDownloadListener;
  static RssFeedUpdateManager.FeedBatchUpdateListener _FeedBatchUpdateListener;
  private static Runnable _FeedProcessingRunnable = new Runnable()
  {
    private boolean IsDownloadAllowed(ProcessStatistics paramAnonymousProcessStatistics, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      if (UpdateAndDownloadManager.m_AllowMobileDataUseForDownloads)
      {
        paramAnonymousProcessStatistics.PodcastDownloadForced = true;
        CoreHelper.WriteTraceEntry(UpdateAndDownloadManager.TAG, "Force Download is in effect! Ignoring 'Is WiFi On' and 'Is Plugged-In' checks...!");
      }
      do
      {
        return true;
        if ((Configuration.DownloadEnclosuresOnWiFiOnly()) && (!paramAnonymousBoolean2))
        {
          paramAnonymousProcessStatistics.PodcastDownloadSkipped_WiFiNotDetected = true;
          CoreHelper.WriteTraceEntry(UpdateAndDownloadManager.TAG, "Processing skipped! Current settings allow podcast downloads over WiFi only!");
          paramAnonymousProcessStatistics.LastException = new Exception(UpdateAndDownloadManager.CURRENTLY_PODCASTS_CAN_BE_DOWNLOADED_AUTOMATICALLY_ONLY_OVER_A_WI_FI);
          return false;
        }
      } while ((!Configuration.DownloadEnclosuresWhenChargingOnly()) || (paramAnonymousBoolean1));
      paramAnonymousProcessStatistics.PodcastDownloadSkipped_DeviceIsNotPluggedIn = true;
      CoreHelper.WriteTraceEntry(UpdateAndDownloadManager.TAG, "Processing skipped! Current settings allow podcast downloads only when the device is plugged in!");
      paramAnonymousProcessStatistics.LastException = new Exception(UpdateAndDownloadManager.CURRENTLY_PODCASTS_CAN_BE_DOWNLOADED_AUTOMATICALLY_ONLY_WHEN_THE_DEVICE_IS_PLUGGED_IN);
      return false;
    }
    
    private boolean IsEnqueued(ArrayList<EnclosureDownloadManager.DownloadableEnclosure> paramAnonymousArrayList, RssEnclosure paramAnonymousRssEnclosure)
    {
      paramAnonymousArrayList = paramAnonymousArrayList.iterator();
      EnclosureDownloadManager.DownloadableEnclosure localDownloadableEnclosure;
      do
      {
        if (!paramAnonymousArrayList.hasNext()) {
          return false;
        }
        localDownloadableEnclosure = (EnclosureDownloadManager.DownloadableEnclosure)paramAnonymousArrayList.next();
      } while ((localDownloadableEnclosure.Enclosure == null) || (!StringUtils.Equals(localDownloadableEnclosure.Enclosure.Url, paramAnonymousRssEnclosure.Url)));
      return true;
    }
    
    private void ProcessRemoteEpisodes(ArrayList<EnclosureDownloadManager.DownloadableEnclosure> paramAnonymousArrayList, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      ProcessStatistics localProcessStatistics = new ProcessStatistics();
      UpdateAndDownloadManager.m_Statistics.add(localProcessStatistics);
      Object localObject1 = FeedRepository.FilterTracks(new TrackFilter()
      {
        public boolean apply(Track paramAnonymous2Track)
        {
          return (paramAnonymous2Track != null) && (paramAnonymous2Track.IsRemoteEpisode()) && (!paramAnonymous2Track.IsFullyDownloaded());
        }
      });
      if (((TrackList)localObject1).size() == 0) {}
      for (;;)
      {
        return;
        if (IsDownloadAllowed(localProcessStatistics, paramAnonymousBoolean1, paramAnonymousBoolean2))
        {
          localObject1 = ((TrackList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (Track)((Iterator)localObject1).next();
            Feed localFeed = ((Track)localObject2).getParentFeed();
            File localFile = new File(((Track)localObject2).TrackPath());
            localObject2 = new RssEnclosure(((Track)localObject2).getUrl(), localFile.getParent(), localFile.getName(), ((Track)localObject2).ContentMimeType(), ((Track)localObject2).RssItemID(), ((Track)localObject2).getDownloadSize(), ((Track)localObject2).getLastModifiedDate(), ((Track)localObject2).DisplayName());
            localProcessStatistics.NewEnclosures.add(((RssEnclosure)localObject2).Url);
            if ((UpdateAndDownloadManager.m_SkipDownloads) || (IsEnqueued(paramAnonymousArrayList, (RssEnclosure)localObject2)) || ((localFeed.getPodcastDownloadAction() != 1) && (localFeed.getPodcastDownloadAction() != 4)))
            {
              localProcessStatistics.IgnoredEnclosures.add(((RssEnclosure)localObject2).Url);
            }
            else
            {
              if (localFeed.NumEnclosuresAvailableForDownload == 0)
              {
                localFeed.NumDownloadedEnclosures = 0;
                localFeed.DownloadFailed = false;
              }
              localFeed.NumEnclosuresAvailableForDownload += 1;
              paramAnonymousArrayList.add(new EnclosureDownloadManager.DownloadableEnclosure(localFeed, (RssEnclosure)localObject2));
            }
          }
        }
      }
    }
    
    private void ProcessUpdatedFeeds(ArrayList<EnclosureDownloadManager.DownloadableEnclosure> paramAnonymousArrayList, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      Iterator localIterator = UpdateAndDownloadManager.m_DownloadQueue.iterator();
      label523:
      label613:
      label693:
      label778:
      do
      {
        do
        {
          if (!localIterator.hasNext()) {}
          Feed localFeed;
          ProcessStatistics localProcessStatistics;
          do
          {
            return;
            localFeed = (Feed)localIterator.next();
            localFeed.NumEnclosuresAvailableForDownload = 0;
            localFeed.NumDownloadedEnclosures = 0;
            localFeed.DownloadFailed = false;
            if ((localFeed.getPodcastDownloadAction() == 0) || (localFeed.getPodcastDownloadAction() == 3) || (localFeed.getMaxNumberPodcastToDownload() == 0)) {
              break;
            }
            localProcessStatistics = new ProcessStatistics();
            localProcessStatistics.ProcessedFeed = localFeed;
            UpdateAndDownloadManager.m_Statistics.add(localProcessStatistics);
          } while (((localFeed.getPodcastDownloadAction() == 1) || (localFeed.getPodcastDownloadAction() == 4)) && (!IsDownloadAllowed(localProcessStatistics, paramAnonymousBoolean1, paramAnonymousBoolean2)));
          RssEnclosure localRssEnclosure = null;
          Object localObject4 = null;
          Object localObject2 = localRssEnclosure;
          try
          {
            localObject6 = new FeedParseData(0);
            localObject2 = localRssEnclosure;
            RssFeedCache.LoadFromCache(localFeed, (FeedParseData)localObject6);
            localObject1 = localObject4;
            localObject2 = localRssEnclosure;
            if (((FeedParseData)localObject6).RssFeed != null)
            {
              localObject1 = localObject4;
              localObject2 = localRssEnclosure;
              if (FeedParseData.IsRssFeedType(((FeedParseData)localObject6).ParsedFeedType))
              {
                localObject2 = localRssEnclosure;
                localObject1 = ((FeedParseData)localObject6).RssFeed;
              }
            }
            localObject4 = localObject1;
            localObject2 = localObject1;
            if (((FeedParseData)localObject6).HasParseFailed())
            {
              localObject2 = localObject1;
              localFeed.UpdateFailed = true;
              localObject2 = localObject1;
              localProcessStatistics.LastException = ((FeedParseData)localObject6).ParseException;
              localObject4 = localObject1;
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              Object localObject6;
              Object localObject1;
              Object localObject5 = localObject3;
            }
          }
        } while (localObject4 == null);
        for (;;)
        {
          try
          {
            if ((localFeed.getPodcastDownloadAction() == 4) || (localFeed.getPodcastDownloadAction() == 5))
            {
              localObject1 = ((RssFeed)localObject4).GetCatchUpDownloadableEnclosures(localFeed.getMaxNumberPodcastToDownload() - localFeed.Tracks().size());
              if ((localFeed.getPodcastDownloadAction() == 1) || (localFeed.getPodcastDownloadAction() == 4))
              {
                localFeed.NumEnclosuresAvailableForDownload = ((List)localObject1).size();
                FeedRepository.NotifyFeedChanged(localFeed);
              }
              localObject2 = ((RssFeed)localObject4).Items.iterator();
              if (((Iterator)localObject2).hasNext()) {
                break label523;
              }
              if (((List)localObject1).size() <= 0) {
                break label778;
              }
              localObject1 = ((List)localObject1).iterator();
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (RssEnclosure)((Iterator)localObject1).next();
              localProcessStatistics.NewEnclosures.add(((RssEnclosure)localObject2).Url);
              if ((!localFeed.HasUrl()) || (StringUtils.IsNullOrEmpty(((RssEnclosure)localObject2).Url))) {
                continue;
              }
              if ((localFeed.getPodcastDownloadAction() != 1) && (localFeed.getPodcastDownloadAction() != 4)) {
                break label693;
              }
              if (!UpdateAndDownloadManager.m_SkipDownloads) {
                break label613;
              }
              localProcessStatistics.IgnoredEnclosures.add(((RssEnclosure)localObject2).Url);
              continue;
            }
          }
          catch (Exception localException1)
          {
            CoreHelper.LogException(UpdateAndDownloadManager.TAG, "Failed to process feed " + localFeed.getName(), localException1);
            localProcessStatistics.LastException = localException1;
          }
          ??? = ((RssFeed)localObject4).GetDownloadableEnclosures(localFeed.getMaxNumberPodcastToDownload());
          continue;
          localObject4 = (RssFeedItem)((Iterator)localObject2).next();
          localRssEnclosure = ((RssFeedItem)localObject4).Enclosure();
          if (localRssEnclosure != null)
          {
            localObject6 = localRssEnclosure.GetLocalEnclosureTrack();
            if (localObject6 != null)
            {
              ((Track)localObject6).setRssItemID(((RssFeedItem)localObject4).ItemID());
              if ((Configuration.SetAsPlayedOnMarkRead()) && (localRssEnclosure.Parent != null) && (!localRssEnclosure.Parent.IsGoogleReadLocked) && (localRssEnclosure.Parent.IsGoogleRead()))
              {
                ((Track)localObject6).MarkPlayed();
                continue;
                if ((Configuration.SetAsDownloadedOnMarkRead()) && (((RssEnclosure)localObject2).Parent != null) && (((RssEnclosure)localObject2).Parent.InGoogleReadingList()) && (((RssEnclosure)localObject2).Parent.IsGoogleRead()))
                {
                  EnclosureDownloadHistory.AddEnclosure((RssEnclosure)localObject2, false);
                  localProcessStatistics.IgnoredEnclosures.add(((RssEnclosure)localObject2).Url);
                }
                else
                {
                  paramAnonymousArrayList.add(new EnclosureDownloadManager.DownloadableEnclosure(localFeed, (RssEnclosure)localObject2));
                  continue;
                  try
                  {
                    if (localFeed.getPodcastDownloadAction() != 5) {
                      FeedRepository.DeleteOldTracksForFeed(localFeed, true);
                    }
                    RssFeedCache.CreateStreamableTrackFromEnclosure(localFeed, (RssEnclosure)localObject2, true);
                    localProcessStatistics.StreamableEnclosures.add(((RssEnclosure)localObject2).Url);
                    UpdateAndDownloadManager.m_NumStreamableEnclosures += 1;
                  }
                  catch (Exception localException3)
                  {
                    for (;;)
                    {
                      CoreHelper.LogException(UpdateAndDownloadManager.TAG, "Unable to delete old tracks for feed: " + localFeed.getName(), localException3);
                    }
                  }
                }
              }
            }
          }
        }
      } while (UpdateAndDownloadManager.m_Processing);
      synchronized (UpdateAndDownloadManager._UpdateAndDownloadListener)
      {
        localObject2 = UpdateAndDownloadManager._UpdateAndDownloadListener.iterator();
        if (!((Iterator)localObject2).hasNext())
        {
          UpdateAndDownloadManager.access$0();
          return;
        }
        ((UpdateAndDownloadManager.UpdateAndDownloadListener)((Iterator)localObject2).next()).ProcessingCanceled(0);
      }
    }
    
    public void run()
    {
      Process.setThreadPriority(10);
      UpdateAndDownloadManager.m_Processing = true;
      UpdateAndDownloadManager.m_NumStreamableEnclosures = 0;
      UpdateAndDownloadManager.m_Statistics.ProcessTime = new Date();
      ArrayList localArrayList1 = new ArrayList();
      CoreHelper.KeepDeviceAwake();
      for (;;)
      {
        Iterator localIterator;
        synchronized (UpdateAndDownloadManager._UpdateAndDownloadListener)
        {
          localIterator = UpdateAndDownloadManager._UpdateAndDownloadListener.iterator();
          if (!localIterator.hasNext())
          {
            CoreHelper.WriteTraceEntry(UpdateAndDownloadManager.TAG, "Processing started...");
            boolean bool1 = CoreHelper.IsDevicePlugged();
            boolean bool2 = CoreHelper.GetDeviceNetworkConnection().IsConnectionWiFi();
            ProcessUpdatedFeeds(localArrayList1, bool1, bool2);
            ProcessRemoteEpisodes(localArrayList1, bool1, bool2);
          }
        }
        synchronized (UpdateAndDownloadManager._UpdateAndDownloadListener)
        {
          localIterator = UpdateAndDownloadManager._UpdateAndDownloadListener.iterator();
          if (!localIterator.hasNext())
          {
            CoreHelper.KeepDeviceAwake();
            CoreHelper.WriteTraceEntry(UpdateAndDownloadManager.TAG, "Processing Completed!");
            UpdateAndDownloadManager.m_Processing = false;
            EnclosureDownloadManager.DownloadEnclosures(localArrayList1, true);
            return;
            ((UpdateAndDownloadManager.UpdateAndDownloadListener)localIterator.next()).ProcessingStarted(UpdateAndDownloadManager.m_DownloadQueue.size());
            continue;
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          ((UpdateAndDownloadManager.UpdateAndDownloadListener)localIterator.next()).ProcessingCompleted(((ArrayList)localObject1).size());
        }
      }
    }
  };
  static Thread _ProcessingThread;
  static Runnable _SaveUpdateQueueRunnable = new Runnable()
  {
    public void run() {}
  };
  private static ArrayList<UpdateAndDownloadListener> _UpdateAndDownloadListener;
  private static boolean m_AllowMobileDataUseForDownloads;
  private static final FeedList m_DownloadQueue;
  private static boolean m_IsUnattended;
  private static int m_NumStreamableEnclosures;
  public static boolean m_Processing;
  private static boolean m_SkipDownloads;
  private static final ProcessStatistics.ProcessedFeedList m_Statistics;
  
  static
  {
    THE_DEVICE_HAS_NO_INTERNET_CONNECTION_WI_FI_ADAPTER_IS_OFF = CoreHelper.LoadResourceString(R.string.update_download_mgr_the_device_has_no_internet_connection);
    CURRENTLY_PODCASTS_CAN_BE_DOWNLOADED_AUTOMATICALLY_ONLY_WHEN_THE_DEVICE_IS_PLUGGED_IN = CoreHelper.LoadResourceString(R.string.update_download_mgr_currently_podcasts_can_be_downloaded_automatically_only_when_the_device_is_plugged_in);
    CURRENTLY_PODCASTS_CAN_BE_DOWNLOADED_AUTOMATICALLY_ONLY_OVER_A_WI_FI = CoreHelper.LoadResourceString(R.string.update_download_mgr_currently_podcasts_can_be_downloaded_automatically_only_over_a_wifi_connection);
    TAG = UpdateAndDownloadManager.class.getSimpleName();
    _UpdateAndDownloadListener = new ArrayList();
    m_DownloadQueue = new FeedList();
    m_Statistics = new ProcessStatistics.ProcessedFeedList();
    m_Processing = false;
    m_IsUnattended = true;
    m_SkipDownloads = false;
    m_AllowMobileDataUseForDownloads = false;
    m_NumStreamableEnclosures = 0;
    _FeedBatchUpdateListener = new RssFeedUpdateManager.FeedBatchUpdateListener()
    {
      public void OnAnotherUpdateIsInProgress() {}
      
      public void OnFeedBatchUpdateCanceled() {}
      
      public void OnFeedBatchUpdateCompleted() {}
      
      public void OnFeedBatchUpdateStarted(Feed paramAnonymousFeed) {}
      
      public void OnFeedBatchUpdateUnableToEstablishNetworkConnection() {}
      
      public void OnFeedUpdateCompleted(Feed paramAnonymousFeed) {}
      
      public void OnFeedUpdateProgress(Feed paramAnonymousFeed) {}
      
      public void OnFeedUpdateStarted(Feed paramAnonymousFeed) {}
      
      public void OnInsufficientSpaceAtDownloadLocation(FlashStorageLocation paramAnonymousFlashStorageLocation) {}
    };
    _EnclosureBatchDownloadListener = new EnclosureDownloadManager.EnclosureBatchDownloadListener()
    {
      public void OnAnotherDownloadIsInProgress() {}
      
      public void OnEnclosureBatchDownloadCanceled() {}
      
      public void OnEnclosureBatchDownloadCompleted() {}
      
      public void OnEnclosureBatchDownloadStarted() {}
      
      public void OnEnclosureBatchEnclosureDownloadStarting(Track paramAnonymousTrack, boolean paramAnonymousBoolean) {}
      
      public void OnEnclosureDownloadCanceled(Track paramAnonymousTrack) {}
      
      public void OnEnclosureDownloadCompleted(Track paramAnonymousTrack) {}
      
      public void OnEnclosureDownloadFailed(Track paramAnonymousTrack, Exception paramAnonymousException) {}
      
      public void OnEnclosureDownloadProgress(Track paramAnonymousTrack) {}
      
      public void OnEnclosureDownloadStarted(Track paramAnonymousTrack) {}
      
      public void OnEnclosureDownloadTerminated(Track paramAnonymousTrack) {}
      
      public void OnUnableToEstablishNetworkConnection() {}
    };
    _ProcessingThread = new Thread();
    RssFeedUpdateManager.addFeedBatchUpdateListener(_FeedBatchUpdateListener);
    EnclosureDownloadManager.addEnclosureBatchDownloadListener(_EnclosureBatchDownloadListener);
  }
  
  public static boolean AllowMobiuleDataUseForDownloads()
  {
    return m_AllowMobileDataUseForDownloads;
  }
  
  public static void DownloadEnclosures(List<EnclosureDownloadManager.DownloadableEnclosure> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    m_NumStreamableEnclosures = 0;
    m_IsUnattended = paramBoolean1;
    if ((!EnclosureDownloadManager.IsDownloading()) || (!m_AllowMobileDataUseForDownloads)) {
      m_AllowMobileDataUseForDownloads = paramBoolean2;
    }
    EnclosureDownloadManager.DownloadEnclosures(paramList, m_IsUnattended);
  }
  
  public static boolean HasWorkToDo()
  {
    return QueueCount() > 0;
  }
  
  public static boolean IsUnattended()
  {
    return m_IsUnattended;
  }
  
  public static boolean IsWorking()
  {
    return (m_Processing) || (RssFeedUpdateManager.IsUpdating()) || (EnclosureDownloadManager.IsDownloading());
  }
  
  /* Error */
  public static FeedList LoadUpdateQueueFromFile()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_0
    //   2: aconst_null
    //   3: astore_3
    //   4: new 99	mobi/beyondpod/rsscore/FeedList
    //   7: dup
    //   8: invokespecial 100	mobi/beyondpod/rsscore/FeedList:<init>	()V
    //   11: astore 4
    //   13: new 178	java/io/File
    //   16: dup
    //   17: invokestatic 183	mobi/beyondpod/rsscore/Configuration:FeedUpdateQueueFilePath	()Ljava/lang/String;
    //   20: invokespecial 186	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: astore_1
    //   24: aload_1
    //   25: invokevirtual 189	java/io/File:exists	()Z
    //   28: ifeq +72 -> 100
    //   31: new 191	java/io/FileInputStream
    //   34: dup
    //   35: aload_1
    //   36: invokespecial 194	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   39: astore_1
    //   40: new 196	java/io/DataInputStream
    //   43: dup
    //   44: aload_1
    //   45: invokespecial 199	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   48: astore_3
    //   49: aconst_null
    //   50: astore_0
    //   51: aload_3
    //   52: invokevirtual 202	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   55: invokestatic 208	java/util/UUID:fromString	(Ljava/lang/String;)Ljava/util/UUID;
    //   58: astore_2
    //   59: aload_2
    //   60: astore_0
    //   61: aload_0
    //   62: invokestatic 214	mobi/beyondpod/rsscore/repository/FeedRepository:GetFeedById	(Ljava/util/UUID;)Lmobi/beyondpod/rsscore/Feed;
    //   65: astore_0
    //   66: aload_0
    //   67: ifnull -18 -> 49
    //   70: aload 4
    //   72: aload_0
    //   73: invokevirtual 218	mobi/beyondpod/rsscore/FeedList:add	(Ljava/lang/Object;)Z
    //   76: pop
    //   77: goto -28 -> 49
    //   80: astore_2
    //   81: aload_1
    //   82: astore_0
    //   83: getstatic 90	mobi/beyondpod/downloadengine/UpdateAndDownloadManager:TAG	Ljava/lang/String;
    //   86: ldc -36
    //   88: aload_2
    //   89: invokestatic 224	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   92: aload_1
    //   93: ifnull +7 -> 100
    //   96: aload_1
    //   97: invokevirtual 227	java/io/FileInputStream:close	()V
    //   100: getstatic 90	mobi/beyondpod/downloadengine/UpdateAndDownloadManager:TAG	Ljava/lang/String;
    //   103: new 229	java/lang/StringBuilder
    //   106: dup
    //   107: ldc -25
    //   109: invokespecial 232	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   112: aload 4
    //   114: invokevirtual 235	mobi/beyondpod/rsscore/FeedList:size	()I
    //   117: invokevirtual 239	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: ldc -15
    //   122: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 251	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload 4
    //   133: areturn
    //   134: astore_0
    //   135: aload_1
    //   136: invokevirtual 227	java/io/FileInputStream:close	()V
    //   139: aload_1
    //   140: ifnull +57 -> 197
    //   143: aload_1
    //   144: invokevirtual 227	java/io/FileInputStream:close	()V
    //   147: goto -47 -> 100
    //   150: astore_0
    //   151: getstatic 90	mobi/beyondpod/downloadengine/UpdateAndDownloadManager:TAG	Ljava/lang/String;
    //   154: ldc -36
    //   156: aload_0
    //   157: invokestatic 224	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   160: goto -60 -> 100
    //   163: astore_1
    //   164: aload_0
    //   165: ifnull +7 -> 172
    //   168: aload_0
    //   169: invokevirtual 227	java/io/FileInputStream:close	()V
    //   172: aload_1
    //   173: athrow
    //   174: astore_0
    //   175: getstatic 90	mobi/beyondpod/downloadengine/UpdateAndDownloadManager:TAG	Ljava/lang/String;
    //   178: ldc -36
    //   180: aload_0
    //   181: invokestatic 224	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   184: goto -12 -> 172
    //   187: astore_0
    //   188: getstatic 90	mobi/beyondpod/downloadengine/UpdateAndDownloadManager:TAG	Ljava/lang/String;
    //   191: ldc -36
    //   193: aload_0
    //   194: invokestatic 224	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   197: goto -97 -> 100
    //   200: astore_2
    //   201: aload_1
    //   202: astore_0
    //   203: aload_2
    //   204: astore_1
    //   205: goto -41 -> 164
    //   208: astore_2
    //   209: aload_3
    //   210: astore_1
    //   211: goto -130 -> 81
    //   214: astore_2
    //   215: goto -154 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	82	0	localObject1	Object
    //   134	1	0	localEOFException	java.io.EOFException
    //   150	19	0	localException1	Exception
    //   174	7	0	localException2	Exception
    //   187	7	0	localException3	Exception
    //   202	1	0	localObject2	Object
    //   23	121	1	localObject3	Object
    //   163	39	1	localObject4	Object
    //   204	7	1	localObject5	Object
    //   58	2	2	localUUID	java.util.UUID
    //   80	9	2	localException4	Exception
    //   200	4	2	localObject6	Object
    //   208	1	2	localException5	Exception
    //   214	1	2	localException6	Exception
    //   3	207	3	localDataInputStream	java.io.DataInputStream
    //   11	121	4	localFeedList	FeedList
    // Exception table:
    //   from	to	target	type
    //   40	49	80	java/lang/Exception
    //   61	66	80	java/lang/Exception
    //   70	77	80	java/lang/Exception
    //   135	139	80	java/lang/Exception
    //   51	59	134	java/io/EOFException
    //   96	100	150	java/lang/Exception
    //   31	40	163	finally
    //   83	92	163	finally
    //   168	172	174	java/lang/Exception
    //   143	147	187	java/lang/Exception
    //   40	49	200	finally
    //   51	59	200	finally
    //   61	66	200	finally
    //   70	77	200	finally
    //   135	139	200	finally
    //   31	40	208	java/lang/Exception
    //   51	59	214	java/lang/Exception
  }
  
  public static int NumStreamableEnclosures()
  {
    return m_NumStreamableEnclosures;
  }
  
  private static void OnCancel()
  {
    m_DownloadQueue.clear();
    SaveUpdateQueueToFile();
    OnUpdateAndDownloadFinished();
  }
  
  private static void OnDownloadCompleted()
  {
    m_DownloadQueue.clear();
    SaveUpdateQueueToFile();
    OnUpdateAndDownloadFinished();
  }
  
  private static void OnUpdateAndDownloadFinished()
  {
    if (!m_IsUnattended) {
      CoreHelper.AnalyzeStatisticsAndNotify();
    }
    m_AllowMobileDataUseForDownloads = false;
    m_SkipDownloads = false;
    SyncSmartPlayIfNeeded();
    CoreHelper.DumpUpdateStatistics();
    synchronized (_UpdateAndDownloadListener)
    {
      Iterator localIterator = _UpdateAndDownloadListener.iterator();
      if (!localIterator.hasNext()) {
        return;
      }
      ((UpdateAndDownloadListener)localIterator.next()).UpdateAndDownloadBatchCompleted();
    }
  }
  
  private static void OnUpdateCompleted()
  {
    _ProcessingThread = new Thread(_FeedProcessingRunnable);
    _ProcessingThread.setName("Update and Download Processing Thread");
    _ProcessingThread.setPriority(4);
    _ProcessingThread.start();
  }
  
  public static int QueueCount()
  {
    return m_DownloadQueue.size();
  }
  
  public static boolean ResumeUpdateAndDownloads()
  {
    if (m_DownloadQueue.size() > 0)
    {
      CoreHelper.WriteLogEntry(TAG, "Resuming downloads found non empty download queue! Resume aborted!");
      return false;
    }
    Object localObject = EnclosureDownloadManager.LoadDownloadQueueFromFile();
    if (((List)localObject).size() > 0)
    {
      CoreHelper.WriteTraceEntry(TAG, "Resuming Enclosure Downloads...");
      EnclosureDownloadManager.DownloadEnclosures((List)localObject, true);
      return true;
    }
    localObject = LoadUpdateQueueFromFile();
    if (((FeedList)localObject).size() > 0)
    {
      CoreHelper.WriteTraceEntry(TAG, "Resuming Feed Updates...!");
      StartUpdateDownload((FeedList)localObject, true);
      return true;
    }
    CoreHelper.WriteTraceEntry(TAG, "No pending Feed updates or Enclosure downloads. Exiting...");
    return false;
  }
  
  private static void SaveUpdateQueueToFile()
  {
    RepositoryPersistence.RepositoryHandler().removeCallbacks(_SaveUpdateQueueRunnable);
    RepositoryPersistence.RepositoryHandler().postDelayed(_SaveUpdateQueueRunnable, 100L);
  }
  
  /* Error */
  public static void SaveUpdateQueueToFileInternal()
  {
    // Byte code:
    //   0: invokestatic 183	mobi/beyondpod/rsscore/Configuration:FeedUpdateQueueFilePath	()Ljava/lang/String;
    //   3: astore_3
    //   4: aconst_null
    //   5: astore_1
    //   6: aconst_null
    //   7: astore_2
    //   8: aload_1
    //   9: astore_0
    //   10: getstatic 102	mobi/beyondpod/downloadengine/UpdateAndDownloadManager:m_DownloadQueue	Lmobi/beyondpod/rsscore/FeedList;
    //   13: invokevirtual 235	mobi/beyondpod/rsscore/FeedList:size	()I
    //   16: ifne +53 -> 69
    //   19: aload_1
    //   20: astore_0
    //   21: new 178	java/io/File
    //   24: dup
    //   25: aload_3
    //   26: invokespecial 186	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: invokevirtual 350	java/io/File:delete	()Z
    //   32: pop
    //   33: aload_1
    //   34: astore_0
    //   35: getstatic 90	mobi/beyondpod/downloadengine/UpdateAndDownloadManager:TAG	Ljava/lang/String;
    //   38: ldc_w 352
    //   41: invokestatic 251	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: iconst_0
    //   45: ifeq +11 -> 56
    //   48: new 354	java/lang/NullPointerException
    //   51: dup
    //   52: invokespecial 355	java/lang/NullPointerException:<init>	()V
    //   55: athrow
    //   56: return
    //   57: astore_0
    //   58: getstatic 90	mobi/beyondpod/downloadengine/UpdateAndDownloadManager:TAG	Ljava/lang/String;
    //   61: ldc_w 357
    //   64: aload_0
    //   65: invokestatic 224	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   68: return
    //   69: aload_1
    //   70: astore_0
    //   71: getstatic 90	mobi/beyondpod/downloadengine/UpdateAndDownloadManager:TAG	Ljava/lang/String;
    //   74: new 229	java/lang/StringBuilder
    //   77: dup
    //   78: ldc_w 359
    //   81: invokespecial 232	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   84: getstatic 102	mobi/beyondpod/downloadengine/UpdateAndDownloadManager:m_DownloadQueue	Lmobi/beyondpod/rsscore/FeedList;
    //   87: invokevirtual 235	mobi/beyondpod/rsscore/FeedList:size	()I
    //   90: invokevirtual 239	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: ldc_w 361
    //   96: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 251	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload_1
    //   106: astore_0
    //   107: new 363	java/io/FileOutputStream
    //   110: dup
    //   111: aload_3
    //   112: invokespecial 364	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   115: astore_3
    //   116: aload_1
    //   117: astore_0
    //   118: new 366	java/io/DataOutputStream
    //   121: dup
    //   122: aload_3
    //   123: invokespecial 369	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   126: astore_1
    //   127: getstatic 102	mobi/beyondpod/downloadengine/UpdateAndDownloadManager:m_DownloadQueue	Lmobi/beyondpod/rsscore/FeedList;
    //   130: invokevirtual 370	mobi/beyondpod/rsscore/FeedList:iterator	()Ljava/util/Iterator;
    //   133: astore_0
    //   134: aload_0
    //   135: invokeinterface 281 1 0
    //   140: ifne +21 -> 161
    //   143: aload_3
    //   144: invokestatic 374	mobi/beyondpod/rsscore/helpers/CoreHelper:sync	(Ljava/io/FileOutputStream;)Z
    //   147: pop
    //   148: aload_1
    //   149: invokevirtual 375	java/io/DataOutputStream:close	()V
    //   152: aload_1
    //   153: ifnull +100 -> 253
    //   156: aload_1
    //   157: invokevirtual 375	java/io/DataOutputStream:close	()V
    //   160: return
    //   161: aload_1
    //   162: aload_0
    //   163: invokeinterface 285 1 0
    //   168: checkcast 377	mobi/beyondpod/rsscore/Feed
    //   171: invokevirtual 381	mobi/beyondpod/rsscore/Feed:ID	()Ljava/util/UUID;
    //   174: invokevirtual 382	java/util/UUID:toString	()Ljava/lang/String;
    //   177: invokevirtual 385	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   180: goto -46 -> 134
    //   183: astore_2
    //   184: aload_1
    //   185: astore_0
    //   186: getstatic 90	mobi/beyondpod/downloadengine/UpdateAndDownloadManager:TAG	Ljava/lang/String;
    //   189: ldc_w 357
    //   192: aload_2
    //   193: invokestatic 224	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   196: aload_1
    //   197: ifnull -141 -> 56
    //   200: aload_1
    //   201: invokevirtual 375	java/io/DataOutputStream:close	()V
    //   204: return
    //   205: astore_0
    //   206: getstatic 90	mobi/beyondpod/downloadengine/UpdateAndDownloadManager:TAG	Ljava/lang/String;
    //   209: ldc_w 357
    //   212: aload_0
    //   213: invokestatic 224	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   216: return
    //   217: astore_1
    //   218: aload_0
    //   219: ifnull +7 -> 226
    //   222: aload_0
    //   223: invokevirtual 375	java/io/DataOutputStream:close	()V
    //   226: aload_1
    //   227: athrow
    //   228: astore_0
    //   229: getstatic 90	mobi/beyondpod/downloadengine/UpdateAndDownloadManager:TAG	Ljava/lang/String;
    //   232: ldc_w 357
    //   235: aload_0
    //   236: invokestatic 224	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   239: goto -13 -> 226
    //   242: astore_0
    //   243: getstatic 90	mobi/beyondpod/downloadengine/UpdateAndDownloadManager:TAG	Ljava/lang/String;
    //   246: ldc_w 357
    //   249: aload_0
    //   250: invokestatic 224	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   253: return
    //   254: astore_2
    //   255: aload_1
    //   256: astore_0
    //   257: aload_2
    //   258: astore_1
    //   259: goto -41 -> 218
    //   262: astore_0
    //   263: aload_2
    //   264: astore_1
    //   265: aload_0
    //   266: astore_2
    //   267: goto -83 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	26	0	localDataOutputStream1	java.io.DataOutputStream
    //   57	8	0	localException1	Exception
    //   70	116	0	localObject1	Object
    //   205	18	0	localException2	Exception
    //   228	8	0	localException3	Exception
    //   242	8	0	localException4	Exception
    //   256	1	0	localObject2	Object
    //   262	4	0	localException5	Exception
    //   5	196	1	localDataOutputStream2	java.io.DataOutputStream
    //   217	39	1	localObject3	Object
    //   258	7	1	localObject4	Object
    //   7	1	2	localObject5	Object
    //   183	10	2	localException6	Exception
    //   254	10	2	localObject6	Object
    //   266	1	2	localObject7	Object
    //   3	141	3	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   48	56	57	java/lang/Exception
    //   127	134	183	java/lang/Exception
    //   134	152	183	java/lang/Exception
    //   161	180	183	java/lang/Exception
    //   200	204	205	java/lang/Exception
    //   10	19	217	finally
    //   21	33	217	finally
    //   35	44	217	finally
    //   71	105	217	finally
    //   107	116	217	finally
    //   118	127	217	finally
    //   186	196	217	finally
    //   222	226	228	java/lang/Exception
    //   156	160	242	java/lang/Exception
    //   127	134	254	finally
    //   134	152	254	finally
    //   161	180	254	finally
    //   10	19	262	java/lang/Exception
    //   21	33	262	java/lang/Exception
    //   35	44	262	java/lang/Exception
    //   71	105	262	java/lang/Exception
    //   107	116	262	java/lang/Exception
    //   118	127	262	java/lang/Exception
  }
  
  public static void StartQuickUpdate(FeedList paramFeedList)
  {
    m_SkipDownloads = true;
    StartUpdateDownload(paramFeedList, false);
  }
  
  public static void StartUpdateDownload(FeedList arg0, boolean paramBoolean)
  {
    int j = 0;
    CoreHelper.KeepDeviceAwake();
    m_AllowMobileDataUseForDownloads = false;
    m_IsUnattended = paramBoolean;
    int i = j;
    if (paramBoolean)
    {
      i = j;
      if (!CoreHelper.IsBackgroundDataAllowed()) {
        i = 1;
      }
    }
    if ((!CoreHelper.IsAlreadyConnectedOrWiFiShouldBeTurnedOnDuringUpdate()) || (i != 0))
    {
      ??? = THE_DEVICE_HAS_NO_INTERNET_CONNECTION_WI_FI_ADAPTER_IS_OFF;
      if (BeyondPodApplication.GetInstance().IsInAirplaneMode()) {
        ??? = UNABLE_TO_ESTABLISH_INTERNET_CONECTION_THE_DEVICE_IS_IN_AIRPLANE_MODE;
      }
      for (;;)
      {
        CoreHelper.WriteLogEntryInProduction(TAG, ???);
        RssFeedUpdateManager.Statistics().clear();
        RssFeedUpdateManager.Statistics().DownloadTime = new Date();
        RssFeedUpdateManager.Statistics().IsUnattended = m_IsUnattended;
        Statistics().clear();
        Statistics().LastException = new Exception(???);
        CoreHelper.DumpUpdateStatistics();
        synchronized (_UpdateAndDownloadListener)
        {
          Iterator localIterator1 = _UpdateAndDownloadListener.iterator();
          if (!localIterator1.hasNext())
          {
            return;
            if (i != 0) {
              ??? = SCHEDULED_UPDATE_DID_NOT_RUN_BECAUSE_BACKGROUND_DATA_IS_DISABLED;
            }
          }
          else
          {
            ((UpdateAndDownloadListener)localIterator1.next()).OnUnableToEstablishNetworkConnection();
          }
        }
      }
    }
    if (m_DownloadQueue.size() > 0) {
      for (;;)
      {
        synchronized (_UpdateAndDownloadListener)
        {
          Iterator localIterator2 = _UpdateAndDownloadListener.iterator();
          if (!localIterator2.hasNext()) {
            return;
          }
        }
        ((UpdateAndDownloadListener)((Iterator)localObject2).next()).OnAnotherDownloadIsInProgress();
      }
    }
    ??? = ???.iterator();
    for (;;)
    {
      if (!???.hasNext()) {
        SaveUpdateQueueToFile();
      }
      synchronized (_UpdateAndDownloadListener)
      {
        Object localObject3 = _UpdateAndDownloadListener.iterator();
        if (!((Iterator)localObject3).hasNext())
        {
          Configuration.setLastUpdateAndDownloadManagerRunTime(new Date());
          RssFeedUpdateManager.UpdateFeeds(m_DownloadQueue);
          return;
          localObject3 = (Feed)???.next();
          if ((!((Feed)localObject3).HasUrl()) || (m_DownloadQueue.containsUrl(((Feed)localObject3).getFeedUrl()))) {
            continue;
          }
          m_DownloadQueue.add(localObject3);
          continue;
        }
        ((UpdateAndDownloadListener)((Iterator)localObject3).next()).UpdateAndDownloadBatchStarted();
      }
    }
  }
  
  public static ProcessStatistics.ProcessedFeedList Statistics()
  {
    return m_Statistics;
  }
  
  private static void SyncSmartPlayIfNeeded()
  {
    if ((!Configuration.AutoSyncSmartPlay()) || (!SmartPlaylistTemplate.IsConfigured()))
    {
      CoreHelper.WriteTraceEntry(TAG, "SmartPlay sync - no SmartPlay or Sync is disabled!");
      return;
    }
    CoreHelper.WriteTraceEntry(TAG, "SmartPlay sync - last update created: " + EnclosureDownloadManager.SuccessfulDownloadsCount() + " downloaded and " + NumStreamableEnclosures() + " streamable episodes");
    int i = 0;
    int j = 0;
    Object localObject3;
    Object localObject2;
    Object localObject1;
    if ((EnclosureDownloadManager.SuccessfulDownloadsCount() > 0) || (NumStreamableEnclosures() > 0))
    {
      localObject3 = new SmartPlaylistTemplate().GeneratePlaylist();
      localObject2 = Statistics().GetUrlsOfNewEpisodes();
      localObject1 = localObject2;
      if (((List)localObject2).size() == 0)
      {
        localObject1 = new ArrayList();
        localObject2 = EnclosureDownloadManager.Statistics().GetSuccesfulDownloads().iterator();
        if (((Iterator)localObject2).hasNext()) {
          break label213;
        }
      }
      localObject2 = ((List)localObject3).iterator();
    }
    for (i = j;; i = 1)
    {
      label213:
      do
      {
        if (!((Iterator)localObject2).hasNext())
        {
          if (Configuration.DefferAutoSyncSmartPlay())
          {
            CoreHelper.WriteTraceEntry(TAG, "SmartPlay sync - Detected pending deffered rebuild at the end of download. SmartPlay will be restarted.");
            i = 1;
            Configuration.setDefferAutoSyncSmartPlay(false);
          }
          if (i == 0) {
            break label326;
          }
          if (PlayList.IsCurrentlyPlaying()) {
            break label312;
          }
          CoreHelper.WriteTraceEntry(TAG, "SmartPlay sync - Syncing SmartPlay...");
          BeyondPodApplication.GetInstance().PlayList().RebuildSmartPlay(Configuration.KeepCurrentEpisodeForDefferAutoSyncSmartPlay(), false);
          return;
          ((List)localObject1).add(((DownloadStatistics)((Iterator)localObject2).next()).Url);
          break;
        }
        localObject3 = (Track)((Iterator)localObject2).next();
      } while ((BeyondPodApplication.GetInstance().PlayList().HasTrack((Track)localObject3)) || (!((List)localObject1).contains(((Track)localObject3).getUrl())));
      CoreHelper.WriteTraceEntry(TAG, "SmartPlay sync - Track " + ((Track)localObject3).getName() + " was not found in the current playlist. SmartPlay will be restarted.");
    }
    label312:
    CoreHelper.WriteTraceEntry(TAG, "SmartPlay sync - Currently Playing... Syncing will be deffered for later...");
    Configuration.setDefferAutoSyncSmartPlay(true);
    return;
    label326:
    CoreHelper.WriteTraceEntry(TAG, "SmartPlay sync - No need to sync SmartPlay!");
  }
  
  public static void TerminateAll()
  {
    if (m_Processing) {
      m_Processing = false;
    }
    do
    {
      return;
      if (RssFeedUpdateManager.IsUpdating())
      {
        RssFeedUpdateManager.TerminateAllUpdates();
        return;
      }
    } while (!EnclosureDownloadManager.IsDownloading());
    EnclosureDownloadManager.TerminateAllDownloads();
  }
  
  public static void addUpdateAndDownloadListener(UpdateAndDownloadListener paramUpdateAndDownloadListener)
  {
    synchronized (_UpdateAndDownloadListener)
    {
      if (_UpdateAndDownloadListener.contains(paramUpdateAndDownloadListener)) {
        return;
      }
      _UpdateAndDownloadListener.add(paramUpdateAndDownloadListener);
      return;
    }
  }
  
  public static void removeUpdateAndDownloadListener(UpdateAndDownloadListener paramUpdateAndDownloadListener)
  {
    synchronized (_UpdateAndDownloadListener)
    {
      if (!_UpdateAndDownloadListener.contains(paramUpdateAndDownloadListener)) {
        return;
      }
      _UpdateAndDownloadListener.remove(paramUpdateAndDownloadListener);
      return;
    }
  }
  
  public boolean HasUpdateQueueFile()
  {
    return new File(Configuration.FeedUpdateQueueFilePath()).exists();
  }
  
  public static abstract interface UpdateAndDownloadListener
  {
    public abstract void OnAnotherDownloadIsInProgress();
    
    public abstract void OnUnableToEstablishNetworkConnection();
    
    public abstract void ProcessingCanceled(int paramInt);
    
    public abstract void ProcessingCompleted(int paramInt);
    
    public abstract void ProcessingStarted(int paramInt);
    
    public abstract void UpdateAndDownloadBatchCompleted();
    
    public abstract void UpdateAndDownloadBatchStarted();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/downloadengine/UpdateAndDownloadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */