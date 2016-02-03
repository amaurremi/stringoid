package mobi.beyondpod.downloadengine;

import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import android.os.Environment;
import java.io.File;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.R.string;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.AnalyticsTracker;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.rsscore.helpers.NotificationHelper;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.repository.FlashStorageLocation;
import mobi.beyondpod.services.download.DownloadHolderService;
import mobi.beyondpod.ui.core.MusicUtils;
import mobi.beyondpod.ui.core.TrackMetadataParser;

public class DownloadEngineNotificationManager
{
  private static final String CONNECTING;
  private static final String DOWNLOADED;
  private static final String DOWNLOADING;
  private static final String FEED2;
  private static final String FEEDS;
  private static final String FEEDS2;
  private static final String FEEDS_FAILED;
  private static final String FEED_UPDATE_COMPLETED;
  private static final String FEED_UPDATE_FAILED;
  private static final String FOUND;
  private static final String LEFT_TO_DOWNLOAD;
  private static final String LEFT_TO_UPDATE;
  private static final String LOOKING_FOR_NEW_PODCASTS_ACROSS_S_FEEDS;
  private static final String MORE;
  private static final String NEW;
  private static final String NEW_PODCASTS;
  private static final String NO_NETWORK_CONNECTION;
  private static final String NO_NEW_PODCASTS;
  private static final String NO_NEW_POSTS;
  private static final String OF;
  private static final String PODCAST;
  private static final String PODCASTS = CoreHelper.LoadResourceString(R.string.download_engine_notification_podcasts);
  private static final String PODCASTS_FAILED;
  private static final String RETRYING;
  private static final String TAG;
  private static final String THERE_WERE_ERRORS_DURING_THE_LAST_UPDATE;
  private static final String THE_PHONE_IS_IN_AIRPLANE_MODE;
  private static final String UNABLE_TO_ESTABLISH_NETWORK_CONNECTION;
  private static final String UPDATED;
  private static final String UPDATING;
  private static Context _Context;
  private static EnclosureDownloadManager.EnclosureBatchDownloadListener _EnclosureBatchUpdateListener;
  private static MediaScannerConnection.MediaScannerConnectionClient _MediaScannerConnectionClient;
  private static RssFeedUpdateManager.FeedBatchUpdateListener _RssFeedUpdateListener;
  private static MediaScannerConnection _Scanner;
  private static UpdateAndDownloadManager.UpdateAndDownloadListener _UpdateAndDownloadListener;
  private static boolean _WiFiTurnedOnAtStart;
  private static StringBuilder sFormatBuilder;
  private static Formatter sFormatter;
  
  static
  {
    PODCAST = CoreHelper.LoadResourceString(R.string.download_engine_notification_podcast);
    FEEDS2 = CoreHelper.LoadResourceString(R.string.download_engine_notification_feeds);
    LEFT_TO_DOWNLOAD = CoreHelper.LoadResourceString(R.string.download_engine_notification_left_to_download);
    LEFT_TO_UPDATE = CoreHelper.LoadResourceString(R.string.download_engine_notification_left_to_update);
    THE_PHONE_IS_IN_AIRPLANE_MODE = CoreHelper.LoadResourceString(R.string.update_engine_notification_the_phone_is_in_airplane_mode);
    UNABLE_TO_ESTABLISH_NETWORK_CONNECTION = CoreHelper.LoadResourceString(R.string.update_engine_notification_unable_to_establish_network_connection);
    FEED_UPDATE_FAILED = CoreHelper.LoadResourceString(R.string.update_engine_notification__feed_update_failed);
    NO_NETWORK_CONNECTION = CoreHelper.LoadResourceString(R.string.update_engine_notification_no_network_connection);
    FEED_UPDATE_COMPLETED = CoreHelper.LoadResourceString(R.string.update_engine_notification__feed_update_completed);
    NO_NEW_PODCASTS = CoreHelper.LoadResourceString(R.string.update_engine_notification_no_new_podcasts);
    PODCASTS_FAILED = CoreHelper.LoadResourceString(R.string.update_engine_notification__podcasts_failed);
    FEEDS_FAILED = CoreHelper.LoadResourceString(R.string.update_engine_notification_feeds_failed);
    NO_NEW_POSTS = CoreHelper.LoadResourceString(R.string.update_engine_notification_no_new_posts);
    UPDATED = CoreHelper.LoadResourceString(R.string.update_engine_notification_updated);
    THERE_WERE_ERRORS_DURING_THE_LAST_UPDATE = CoreHelper.LoadResourceString(R.string.update_engine_notification_there_were_errors_during_the_last_update);
    LOOKING_FOR_NEW_PODCASTS_ACROSS_S_FEEDS = CoreHelper.LoadResourceString(R.string.download_engine_notification_looking_for_new_podcasts_across);
    NEW_PODCASTS = CoreHelper.LoadResourceString(R.string.download_engine_notification_new_podcasts);
    FOUND = CoreHelper.LoadResourceString(R.string.download_engine_notification_found);
    DOWNLOADED = CoreHelper.LoadResourceString(R.string.download_engine_notification_downloaded);
    NEW = CoreHelper.LoadResourceString(R.string.download_engine_notification_new);
    DOWNLOADING = CoreHelper.LoadResourceString(R.string.download_engine_notification_downloading);
    RETRYING = CoreHelper.LoadResourceString(R.string.download_engine_notification_retrying);
    OF = CoreHelper.LoadResourceString(R.string.download_engine_notification_of);
    UPDATING = CoreHelper.LoadResourceString(R.string.download_engine_notification_updating);
    CONNECTING = CoreHelper.LoadResourceString(R.string.download_engine_notification_connecting);
    FEED2 = CoreHelper.LoadResourceString(R.string.download_engine_notification_feed);
    FEEDS = CoreHelper.LoadResourceString(R.string.download_engine_notification_feeds);
    MORE = CoreHelper.LoadResourceString(R.string.download_engine_notification_more);
    _WiFiTurnedOnAtStart = false;
    sFormatBuilder = new StringBuilder();
    sFormatter = new Formatter(sFormatBuilder, Locale.getDefault());
    TAG = DownloadEngineNotificationManager.class.getSimpleName();
    _MediaScannerConnectionClient = new MediaScannerConnection.MediaScannerConnectionClient()
    {
      public void onMediaScannerConnected() {}
      
      public void onScanCompleted(String paramAnonymousString, Uri paramAnonymousUri)
      {
        CoreHelper.WriteTraceEntry(DownloadEngineNotificationManager.TAG, "Media scan of '" + paramAnonymousString + "' completed! Result:" + paramAnonymousUri);
        paramAnonymousString = FeedRepository.GetTrackByPath(paramAnonymousString);
        if (paramAnonymousString != null) {
          if (!Configuration.SharePodcasts()) {
            break label57;
          }
        }
        label57:
        for (boolean bool = false;; bool = true)
        {
          MusicUtils.LoadID3InfoForTrack(paramAnonymousString, bool, paramAnonymousUri, null, false);
          return;
        }
      }
    };
    _RssFeedUpdateListener = new RssFeedUpdateManager.FeedBatchUpdateListener()
    {
      String _FeedsLeftToUpdate;
      
      public void OnAnotherUpdateIsInProgress() {}
      
      public void OnFeedBatchUpdateCanceled() {}
      
      public void OnFeedBatchUpdateCompleted() {}
      
      public void OnFeedBatchUpdateStarted(Feed paramAnonymousFeed)
      {
        int i;
        String str2;
        if (RssFeedUpdateManager.QueueCount() > 1)
        {
          i = RssFeedUpdateManager.QueueCount();
          str2 = DownloadEngineNotificationManager.MORE;
          if (RssFeedUpdateManager.QueueCount() - 1 > 1) {
            str1 = DownloadEngineNotificationManager.FEEDS;
          }
        }
        for (String str1 = String.format("%s %s %s %s", new Object[] { Integer.valueOf(i - 1), str2, str1, DownloadEngineNotificationManager.LEFT_TO_UPDATE });; str1 = "")
        {
          this._FeedsLeftToUpdate = str1;
          DownloadEngineNotificationManager.SetNotification(2, "", paramAnonymousFeed.getName(), DownloadEngineNotificationManager.CONNECTING + ", " + this._FeedsLeftToUpdate);
          return;
          str1 = DownloadEngineNotificationManager.FEED2;
          break;
        }
      }
      
      public void OnFeedBatchUpdateUnableToEstablishNetworkConnection() {}
      
      public void OnFeedUpdateCompleted(Feed paramAnonymousFeed) {}
      
      public void OnFeedUpdateProgress(Feed paramAnonymousFeed)
      {
        DownloadEngineNotificationManager.sFormatBuilder.setLength(0);
        if (paramAnonymousFeed.getUpdateSize() <= 0L) {}
        for (String str = DownloadEngineNotificationManager.sFormatter.format("%s %s, %s", new Object[] { DownloadEngineNotificationManager.UPDATING, CoreHelper.GetFileLengthAsString(Long.valueOf(paramAnonymousFeed.getUpdatedPortion())), this._FeedsLeftToUpdate }).toString();; str = DownloadEngineNotificationManager.sFormatter.format("%s %s%% %s %s, %s", new Object[] { DownloadEngineNotificationManager.UPDATING, Integer.valueOf(paramAnonymousFeed.UpdatePercent()), DownloadEngineNotificationManager.OF, CoreHelper.GetFileLengthAsString(Long.valueOf(paramAnonymousFeed.getUpdateSize())), this._FeedsLeftToUpdate }).toString())
        {
          DownloadEngineNotificationManager.SetNotification(4, "", paramAnonymousFeed.getName(), str);
          return;
        }
      }
      
      public void OnFeedUpdateStarted(Feed paramAnonymousFeed) {}
      
      public void OnInsufficientSpaceAtDownloadLocation(FlashStorageLocation paramAnonymousFlashStorageLocation) {}
    };
    _EnclosureBatchUpdateListener = new EnclosureDownloadManager.EnclosureBatchDownloadListener()
    {
      private String RemainingPodcastsText()
      {
        DownloadEngineNotificationManager.sFormatBuilder.setLength(0);
        if (EnclosureDownloadManager.QueueCount() > 1)
        {
          Formatter localFormatter = DownloadEngineNotificationManager.sFormatter;
          int i = EnclosureDownloadManager.QueueCount();
          String str2 = DownloadEngineNotificationManager.MORE;
          if (EnclosureDownloadManager.QueueCount() - 1 > 1) {}
          for (String str1 = DownloadEngineNotificationManager.PODCASTS;; str1 = DownloadEngineNotificationManager.PODCAST) {
            return localFormatter.format(", %s %s %s %s", new Object[] { Integer.valueOf(i - 1), str2, str1, DownloadEngineNotificationManager.LEFT_TO_DOWNLOAD }).toString();
          }
        }
        return "";
      }
      
      public void OnAnotherDownloadIsInProgress() {}
      
      public void OnEnclosureBatchDownloadCanceled()
      {
        if (DownloadEngineNotificationManager._Scanner != null) {
          DownloadEngineNotificationManager._Scanner.disconnect();
        }
      }
      
      public void OnEnclosureBatchDownloadCompleted()
      {
        if (DownloadEngineNotificationManager._Scanner != null) {
          DownloadEngineNotificationManager._Scanner.disconnect();
        }
      }
      
      public void OnEnclosureBatchDownloadStarted()
      {
        AnalyticsTracker.OnBatchDownloadStarted(EnclosureDownloadManager.QueueCount());
        try
        {
          if (DownloadEngineNotificationManager._Scanner == null) {
            DownloadEngineNotificationManager._Scanner = new MediaScannerConnection(DownloadEngineNotificationManager._Context, DownloadEngineNotificationManager._MediaScannerConnectionClient);
          }
          DownloadEngineNotificationManager._Scanner.connect();
          return;
        }
        catch (Exception localException)
        {
          CoreHelper.LogException("", "Unable to connect to the media scanner service", localException);
        }
      }
      
      public void OnEnclosureBatchEnclosureDownloadStarting(Track paramAnonymousTrack, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousTrack == null) {
          return;
        }
        String str = paramAnonymousTrack.getParentFeed().getName();
        if (paramAnonymousBoolean) {}
        for (paramAnonymousTrack = DownloadEngineNotificationManager.RETRYING;; paramAnonymousTrack = DownloadEngineNotificationManager.DOWNLOADING)
        {
          DownloadEngineNotificationManager.SetNotification(2, "", str, paramAnonymousTrack + RemainingPodcastsText());
          return;
        }
      }
      
      public void OnEnclosureDownloadCanceled(Track paramAnonymousTrack) {}
      
      public void OnEnclosureDownloadCompleted(Track paramAnonymousTrack)
      {
        String str1 = paramAnonymousTrack.TrackPath();
        String str2 = Environment.getExternalStorageDirectory().getPath();
        if (!str1.startsWith(str2)) {
          CoreHelper.WriteLogEntryInProduction(DownloadEngineNotificationManager.TAG, "Trying to scan file with incorrect storage root! Environment Root: " + str2 + ", File: " + str1);
        }
        if ((CoreHelper.ApiLevel() >= 16) || ((!Configuration.SharePodcasts()) && (CoreHelper.ApiLevel() >= 10))) {
          TrackMetadataParser.LoadMetadataFor(paramAnonymousTrack);
        }
        for (;;)
        {
          BeyondPodApplication.MessageBus.PublishEvent(new UpdateAndDownloadEvents.UpdateAndDownloadEvent(DownloadEngineNotificationManager.class, UpdateAndDownloadEvents.UpdateAndDownloadEvent.ENCLOSURE_DOWNLOAD_COMPLETED, paramAnonymousTrack));
          return;
          if (DownloadEngineNotificationManager._Scanner.isConnected()) {
            DownloadEngineNotificationManager._Scanner.scanFile(str1, null);
          }
        }
      }
      
      public void OnEnclosureDownloadFailed(Track paramAnonymousTrack, Exception paramAnonymousException) {}
      
      public void OnEnclosureDownloadProgress(Track paramAnonymousTrack)
      {
        if (paramAnonymousTrack.getDownloadStatus() != 2) {
          return;
        }
        DownloadEngineNotificationManager.sFormatBuilder.setLength(0);
        if (paramAnonymousTrack.getDownloadSize() <= 0L) {}
        for (String str = DownloadEngineNotificationManager.DOWNLOADED + " " + CoreHelper.GetFileLengthAsString(Long.valueOf(paramAnonymousTrack.getDownloadedPortion())) + RemainingPodcastsText();; str = DownloadEngineNotificationManager.DOWNLOADED + " " + (int)paramAnonymousTrack.getDownloadPercent() + "% " + DownloadEngineNotificationManager.OF + " " + CoreHelper.GetFileLengthAsString(Long.valueOf(paramAnonymousTrack.getDownloadSize())) + RemainingPodcastsText().toString())
        {
          DownloadEngineNotificationManager.SetNotification(4, "", paramAnonymousTrack.getParentFeed().getName(), str);
          return;
        }
      }
      
      public void OnEnclosureDownloadStarted(Track paramAnonymousTrack)
      {
        BeyondPodApplication.MessageBus.PublishEvent(new UpdateAndDownloadEvents.UpdateAndDownloadEvent(DownloadEngineNotificationManager.class, UpdateAndDownloadEvents.UpdateAndDownloadEvent.ENCLOSURE_DOWNLOAD_STARTED, paramAnonymousTrack));
      }
      
      public void OnEnclosureDownloadTerminated(Track paramAnonymousTrack) {}
      
      public void OnUnableToEstablishNetworkConnection() {}
    };
    _UpdateAndDownloadListener = new UpdateAndDownloadManager.UpdateAndDownloadListener()
    {
      public void OnAnotherDownloadIsInProgress()
      {
        BeyondPodApplication.MessageBus.PublishEvent(new UpdateAndDownloadEvents.UpdateAndDownloadEvent(DownloadEngineNotificationManager.class, UpdateAndDownloadEvents.UpdateAndDownloadEvent.UPDATE_AND_DOWNLOAD_COMPLETED));
      }
      
      public void OnUnableToEstablishNetworkConnection()
      {
        DownloadEngineNotificationManager.access$21();
        BeyondPodApplication.MessageBus.PublishEvent(new UpdateAndDownloadEvents.UpdateAndDownloadEvent(DownloadEngineNotificationManager.class, UpdateAndDownloadEvents.UpdateAndDownloadEvent.UPDATE_AND_DOWNLOAD_COMPLETED));
      }
      
      public void ProcessingCanceled(int paramAnonymousInt) {}
      
      public void ProcessingCompleted(int paramAnonymousInt)
      {
        DownloadEngineNotificationManager.SetNotification(6, "", String.format("%s %s %s", new Object[] { DownloadEngineNotificationManager.FOUND, Integer.valueOf(paramAnonymousInt), DownloadEngineNotificationManager.NEW_PODCASTS }), "");
      }
      
      public void ProcessingStarted(int paramAnonymousInt)
      {
        DownloadEngineNotificationManager.SetNotification(5, "", String.format("%s %s %s", new Object[] { DownloadEngineNotificationManager.LOOKING_FOR_NEW_PODCASTS_ACROSS_S_FEEDS, Integer.valueOf(paramAnonymousInt), DownloadEngineNotificationManager.FEEDS2 }), "");
      }
      
      public void UpdateAndDownloadBatchCompleted()
      {
        CoreHelper.WriteTraceEntry(DownloadEngineNotificationManager.TAG, "Update and download batch completed!");
        FeedRepository.SaveRepositoryAsync();
        BeyondPodApplication.MessageBus.PublishEvent(new UpdateAndDownloadEvents.UpdateAndDownloadEvent(DownloadEngineNotificationManager.class, UpdateAndDownloadEvents.UpdateAndDownloadEvent.UPDATE_AND_DOWNLOAD_COMPLETED));
        DownloadEngineNotificationManager.access$27();
        if ((RssFeedUpdateManager.FeedsWithNewContentCount() == 0) && (EnclosureDownloadManager.SuccessfulDownloadsCount() == 0) && (RssFeedUpdateManager.FeedsFailedCount() == 0) && (EnclosureDownloadManager.FailedDownloadsCount() == 0) && (UpdateAndDownloadManager.NumStreamableEnclosures() == 0))
        {
          DownloadEngineNotificationManager.ClearNotification();
          DownloadEngineNotificationManager.access$36();
          BeyondPodApplication.GetInstance().StopDownloadServiceHolder();
          return;
        }
        String str1;
        if ((RssFeedUpdateManager.FeedsFailedCount() > 0) || (EnclosureDownloadManager.FailedDownloadsCount() > 0))
        {
          str1 = DownloadEngineNotificationManager.THERE_WERE_ERRORS_DURING_THE_LAST_UPDATE;
          if ((RssFeedUpdateManager.FeedsFailedCount() <= 0) && (EnclosureDownloadManager.FailedDownloadsCount() <= 0)) {
            break label467;
          }
        }
        label204:
        label213:
        label258:
        label300:
        label446:
        label453:
        label460:
        label467:
        for (int i = 8;; i = 7)
        {
          DownloadEngineNotificationManager.SetNotification(i, "", DateTime.FormatTime(new Date()) + " - " + DownloadEngineNotificationManager.FEED_UPDATE_COMPLETED, str1);
          RssFeedUpdateManager.ResetUpdateCounters();
          break;
          str1 = DownloadEngineNotificationManager.NO_NEW_PODCASTS;
          Object localObject;
          String str2;
          if (EnclosureDownloadManager.SuccessfulDownloadsCount() > 0)
          {
            localObject = new StringBuilder(String.valueOf(DownloadEngineNotificationManager.DOWNLOADED)).append(" ").append(EnclosureDownloadManager.SuccessfulDownloadsCount()).append(" ");
            if (EnclosureDownloadManager.SuccessfulDownloadsCount() > 1)
            {
              str1 = DownloadEngineNotificationManager.PODCASTS;
              str1 = str1;
              if (RssFeedUpdateManager.FeedsWithNewContentCount() <= 0) {
                break label446;
              }
              localObject = DownloadEngineNotificationManager.UPDATED + " " + RssFeedUpdateManager.FeedsWithNewContentCount() + " " + DownloadEngineNotificationManager.FEEDS;
              if (RssFeedUpdateManager.FeedsFailedCount() <= 0) {
                break label453;
              }
              str2 = " (" + RssFeedUpdateManager.FeedsFailedCount() + " " + DownloadEngineNotificationManager.FEEDS_FAILED + ")";
              if (EnclosureDownloadManager.FailedDownloadsCount() <= 0) {
                break label460;
              }
            }
          }
          for (String str3 = "(" + EnclosureDownloadManager.FailedDownloadsCount() + " " + DownloadEngineNotificationManager.PODCASTS_FAILED + ")";; str3 = "")
          {
            str1 = String.format("%s%s. %s %s", new Object[] { localObject, str2, str1, str3 });
            break;
            str1 = DownloadEngineNotificationManager.PODCAST;
            break label204;
            if (UpdateAndDownloadManager.NumStreamableEnclosures() <= 0) {
              break label213;
            }
            localObject = new StringBuilder(String.valueOf(UpdateAndDownloadManager.NumStreamableEnclosures())).append(" ").append(DownloadEngineNotificationManager.NEW).append(" ");
            if (UpdateAndDownloadManager.NumStreamableEnclosures() > 1) {}
            for (str1 = DownloadEngineNotificationManager.PODCASTS;; str1 = DownloadEngineNotificationManager.PODCAST)
            {
              str1 = str1;
              break;
            }
            localObject = DownloadEngineNotificationManager.NO_NEW_POSTS;
            break label258;
            str2 = "";
            break label300;
          }
        }
      }
      
      public void UpdateAndDownloadBatchStarted()
      {
        AnalyticsTracker.OnBatchUpdateStarted(UpdateAndDownloadManager.QueueCount());
        CoreHelper.WriteTraceEntry(DownloadEngineNotificationManager.TAG, "Update and download batch Started!");
        BeyondPodApplication.GetInstance().StartDownloadServiceHolder();
        DownloadEngineNotificationManager.access$26();
        BeyondPodApplication.MessageBus.PublishEvent(new UpdateAndDownloadEvents.UpdateAndDownloadEvent(DownloadEngineNotificationManager.class, UpdateAndDownloadEvents.UpdateAndDownloadEvent.UPDATE_AND_DOWNLOAD_STARTED));
      }
    };
    EnclosureDownloadManager.addEnclosureBatchDownloadListener(_EnclosureBatchUpdateListener);
    UpdateAndDownloadManager.addUpdateAndDownloadListener(_UpdateAndDownloadListener);
    RssFeedUpdateManager.addFeedBatchUpdateListener(_RssFeedUpdateListener);
  }
  
  private static void AutoClearNotificationIfNeeded()
  {
    if (Configuration.ClearStatusNotificationAtTheEndOfUpdate()) {}
    try
    {
      Thread.sleep(1000L);
      ClearNotification();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  public static void ClearNotification()
  {
    NotificationHelper.getInstance().ClearNotification(_Context, 129);
  }
  
  public static void Initialize(Context paramContext)
  {
    _Context = paramContext;
  }
  
  private static void NotifyUnableToEstablishNetworkConnection()
  {
    String str2 = NO_NETWORK_CONNECTION;
    String str3 = DateTime.FormatTime(new Date()) + " - " + FEED_UPDATE_FAILED;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(UNABLE_TO_ESTABLISH_NETWORK_CONNECTION));
    if (BeyondPodApplication.GetInstance().IsInAirplaneMode()) {}
    for (String str1 = THE_PHONE_IS_IN_AIRPLANE_MODE;; str1 = "")
    {
      SetNotification(8, str2, str3, str1);
      AutoClearNotificationIfNeeded();
      BeyondPodApplication.GetInstance().StopDownloadServiceHolder();
      return;
    }
  }
  
  private static void SetNotification(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(_Context, DownloadHolderService.class);
    localIntent.putExtra(NotificationHelper.NOTIFICATION_TYPE_EXTRA, paramInt);
    localIntent.putExtra(NotificationHelper.NOTIFICATION_TICKER_EXTRA, paramString1);
    localIntent.putExtra(NotificationHelper.NOTIFICATION_LINE1_EXTRA, paramString2);
    localIntent.putExtra(NotificationHelper.NOTIFICATION_LINE2_EXTRA, paramString3);
    _Context.startService(localIntent);
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/downloadengine/DownloadEngineNotificationManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */