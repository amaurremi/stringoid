package mobi.beyondpod.ui.commands;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.widget.Toast;
import com.aocate.media.MediaPlayer;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.aggregators.AggregatorLoginHelper;
import mobi.beyondpod.aggregators.AggregatorLoginHelper.GSyncStatusResult;
import mobi.beyondpod.downloadengine.UpdateAndDownloadManager;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.AnalyticsTracker;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.rss.LicenseManager;
import mobi.beyondpod.rsscore.rss.entities.RssEnclosure;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;
import mobi.beyondpod.services.player.MediaPlaybackService;
import mobi.beyondpod.services.player.PlayList;
import mobi.beyondpod.sync.ChangeSyncManager;
import mobi.beyondpod.sync.ChangeSyncManager.ChangeSyncStatusResult;

public class CommandManagerBase
{
  private static final String TAG = CommandManagerBase.class.getSimpleName();
  
  private static String BuildEpisodeShareBody(Feed paramFeed, RssFeedItem paramRssFeedItem)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramRssFeedItem.ShortTaglessDescription());
    localStringBuilder.append("\n\n");
    if (paramRssFeedItem.PubDate() != null)
    {
      localStringBuilder.append("* Published: ");
      localStringBuilder.append(DateTime.ToShortString(paramRssFeedItem.PubDate()));
    }
    if (paramRssFeedItem.Enclosure() != null)
    {
      localStringBuilder.append("\n\n* Episode Download Link");
      if ((paramRssFeedItem.Enclosure().EnclosureFileLength() != null) && (paramRssFeedItem.Enclosure().EnclosureFileLength().longValue() > 30720L)) {
        localStringBuilder.append(" (" + paramRssFeedItem.Enclosure().EnclosureSizeAsString() + ")");
      }
      localStringBuilder.append(": ");
      localStringBuilder.append(paramRssFeedItem.Enclosure().Url);
    }
    if (!StringUtils.IsNullOrEmpty(paramRssFeedItem.Link))
    {
      if (paramRssFeedItem.Enclosure() != null) {
        localStringBuilder.append("\n\n* Show Notes: ");
      }
    }
    else
    {
      localStringBuilder.append(paramRssFeedItem.Link);
      if (paramRssFeedItem.Enclosure() == null) {
        break label231;
      }
      localStringBuilder.append("\n\n* Episode Feed: ");
    }
    for (;;)
    {
      localStringBuilder.append(paramFeed.getName());
      localStringBuilder.append(" (");
      localStringBuilder.append(paramFeed.getFeedUrl());
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append("\n\n* Post Link: ");
      break;
      label231:
      localStringBuilder.append("\n\n* Feed: ");
    }
  }
  
  private static String BuildEpisodeShareBody(Track paramTrack)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramTrack.TrackDescription());
    localStringBuilder.append("\n\n");
    if (!StringUtils.IsNullOrEmpty(paramTrack.TotalTimeAsString())) {
      localStringBuilder.append("* Duration " + paramTrack.TotalTimeAsString());
    }
    if (paramTrack.getLastModifiedDate() != null)
    {
      localStringBuilder.append(", Published ");
      localStringBuilder.append(DateTime.ToShortString(paramTrack.getLastModifiedDate()));
    }
    localStringBuilder.append("\n\n* Episode Download Link");
    if (paramTrack.getDownloadSize() > 30720L) {
      localStringBuilder.append(" (" + CoreHelper.GetFileLengthAsString(Long.valueOf(paramTrack.getDownloadSize())) + ")");
    }
    localStringBuilder.append(": ");
    localStringBuilder.append(paramTrack.getUrl());
    if (!StringUtils.IsNullOrEmpty(paramTrack.TrackPostUrl()))
    {
      localStringBuilder.append("\n\n* Show Notes: ");
      localStringBuilder.append(paramTrack.TrackPostUrl());
    }
    localStringBuilder.append("\n\n* Podcast Feed: ");
    localStringBuilder.append(paramTrack.getParentFeed().getName());
    localStringBuilder.append(" (");
    localStringBuilder.append(paramTrack.getParentFeed().getFeedUrl());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static Intent BuildShareEpisodeIntent(Context paramContext, Track paramTrack)
  {
    Object localObject2 = null;
    if ((paramContext == null) || (paramTrack == null) || (!paramTrack.HasUrl())) {
      return null;
    }
    String str1 = Configuration.getDefaultSendToMailAddress();
    String str2 = paramTrack.DisplayName();
    String str3 = BuildEpisodeShareBody(paramTrack);
    Object localObject1 = localObject2;
    if (Configuration.AttachDownloadedPodcastsWhenSharing())
    {
      localObject1 = localObject2;
      if (paramTrack.IsFullyDownloaded()) {
        localObject1 = paramTrack.TrackPath();
      }
    }
    return BuildShareIntent(paramContext, str1, str2, str3, (String)localObject1, false);
  }
  
  public static Intent BuildShareIntent(Context paramContext, String paramString1, CharSequence paramCharSequence1, CharSequence paramCharSequence2, String paramString2, boolean paramBoolean)
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    if (paramBoolean) {}
    for (paramContext = "plain/text";; paramContext = "text/plain")
    {
      localIntent.setType(paramContext);
      paramContext = new String[0];
      if (!StringUtils.IsNullOrEmpty(paramString1)) {
        paramContext = paramString1.split(",\\s+");
      }
      localIntent.putExtra("android.intent.extra.EMAIL", paramContext);
      localIntent.putExtra("android.intent.extra.SUBJECT", paramCharSequence1);
      localIntent.putExtra("android.intent.extra.TEXT", paramCharSequence2);
      localIntent.setFlags(268435456);
      if (!StringUtils.IsNullOrEmpty(paramString2)) {
        localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(paramString2)));
      }
      return localIntent;
    }
  }
  
  public static void CmdEmptyPlaylist(boolean paramBoolean1, boolean paramBoolean2)
  {
    PlayList localPlayList = BeyondPodApplication.GetInstance().PlayList();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localPlayList.GetTracks().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        if (localArrayList.size() > 0) {
          localPlayList.RemoveTracks(localArrayList);
        }
        return;
      }
      Track localTrack = (Track)localIterator.next();
      if (((paramBoolean1) || ((localTrack.getCurrentPlayState() != 1) && (localTrack.getCurrentPlayState() != 3) && (localTrack.getCurrentPlayState() != 6))) && ((paramBoolean2) || (localPlayList.CurrentTrack() != localTrack))) {
        localArrayList.add(localTrack);
      }
    }
  }
  
  public static void CmdLoadCurrentTrack()
  {
    if (BeyondPodApplication.GetInstance().PlayList().CurrentTrack() != null)
    {
      Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), MediaPlaybackService.class);
      localIntent.setAction("mobi.beyondpod.services.musicservicecommand");
      localIntent.putExtra("command", "loadcurrenttrack");
      BeyondPodApplication.GetInstance().startService(localIntent);
    }
  }
  
  public static void CmdPlayNextTrack()
  {
    if (BeyondPodApplication.GetInstance().PlayList().CurrentTrack() != null)
    {
      Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), MediaPlaybackService.class);
      localIntent.setAction("mobi.beyondpod.services.musicservicecommand");
      localIntent.putExtra("command", "playnext");
      BeyondPodApplication.GetInstance().startService(localIntent);
    }
  }
  
  public static void CmdPlayPosition(int paramInt)
  {
    AnalyticsTracker.OnCommand("CmdPlayPosition", "");
    if ((paramInt >= 0) && (paramInt < BeyondPodApplication.GetInstance().PlayList().PlaylistSize()))
    {
      Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), MediaPlaybackService.class);
      localIntent.setAction("mobi.beyondpod.services.musicservicecommand");
      localIntent.putExtra("command", "open");
      localIntent.putExtra("trackPos", paramInt);
      BeyondPodApplication.GetInstance().startService(localIntent);
    }
  }
  
  public static void CmdPlayPreviousTrack()
  {
    if (BeyondPodApplication.GetInstance().PlayList().CurrentTrack() != null)
    {
      Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), MediaPlaybackService.class);
      localIntent.setAction("mobi.beyondpod.services.musicservicecommand");
      localIntent.putExtra("command", "playprevious");
      BeyondPodApplication.GetInstance().startService(localIntent);
    }
  }
  
  public static boolean CmdPlaySmartPlayList(Context paramContext)
  {
    BeyondPodApplication.GetInstance().ExecuteCommandPlaySmartPlayList(paramContext);
    return true;
  }
  
  public static void CmdSendEMail(Context paramContext, String paramString1, CharSequence paramCharSequence1, CharSequence paramCharSequence2, String paramString2, boolean paramBoolean)
  {
    try
    {
      paramContext.startActivity(Intent.createChooser(BuildShareIntent(paramContext, paramString1, paramCharSequence1, paramCharSequence2, paramString2, paramBoolean), null));
      return;
    }
    catch (ActivityNotFoundException paramContext) {}
  }
  
  public static void CmdSharePodcast(Context paramContext, Track paramTrack)
  {
    if ((paramContext == null) || (paramTrack == null) || (!paramTrack.HasUrl())) {
      return;
    }
    String str1 = Configuration.getDefaultSendToMailAddress();
    String str2 = paramTrack.DisplayName();
    String str3 = BuildEpisodeShareBody(paramTrack);
    if ((Configuration.AttachDownloadedPodcastsWhenSharing()) && (paramTrack.IsFullyDownloaded())) {}
    for (paramTrack = paramTrack.TrackPath();; paramTrack = null)
    {
      CmdSendEMail(paramContext, str1, str2, str3, paramTrack, false);
      return;
    }
  }
  
  public static void CmdSharePost(Context paramContext, Feed paramFeed, RssFeedItem paramRssFeedItem)
  {
    if ((paramContext == null) || (paramRssFeedItem == null)) {
      return;
    }
    CmdSendEMail(paramContext, Configuration.getDefaultSendToMailAddress(), paramRssFeedItem.Title.toString(), BuildEpisodeShareBody(paramFeed, paramRssFeedItem), null, false);
  }
  
  public static void CmdShowPrestoOnAndropidMarket(Context paramContext)
  {
    try
    {
      paramContext.startActivity(MediaPlayer.getPrestoMarketIntent());
      return;
    }
    catch (Exception localException)
    {
      Toast.makeText(paramContext, localException.getMessage(), 1).show();
    }
  }
  
  public static void CmdStopPlayback()
  {
    AnalyticsTracker.OnCommand("CmdStopPlayback", "");
    if (BeyondPodApplication.GetInstance().PlayList().CurrentTrack() != null)
    {
      Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), MediaPlaybackService.class);
      localIntent.setAction("mobi.beyondpod.services.musicservicecommand");
      localIntent.putExtra("command", "stop");
      BeyondPodApplication.GetInstance().startService(localIntent);
    }
  }
  
  public static void CmdSuggestFeature(Context paramContext)
  {
    CmdSendEMail(paramContext, "support@beyondpod.mobi", "I want to suggest a Feature in BeyondPod", "My device is running BeyondPod " + Configuration.ProductVersion() + LicenseManager.GetShortLicenseKind() + " on " + Build.MANUFACTURER + " " + Build.MODEL + " with Android " + Build.VERSION.RELEASE + "\n\nIt would be nice if BeyondPod...\n\n\n\n", null, true);
  }
  
  public static void CmdSwitchPlayerForCurrentTrack(boolean paramBoolean)
  {
    if (BeyondPodApplication.GetInstance().PlayList().CurrentTrack() != null)
    {
      Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), MediaPlaybackService.class);
      localIntent.setAction("mobi.beyondpod.services.musicservicecommand");
      localIntent.putExtra("command", "loadcurrenttrack");
      localIntent.putExtra("startPlaybackOnLoad", paramBoolean);
      BeyondPodApplication.GetInstance().startService(localIntent);
    }
  }
  
  public static void CmdUpdateFeeds(FeedList paramFeedList, final boolean paramBoolean)
  {
    if (LicenseManager.CheckAndNotifyIfInRestrictedMode()) {
      return;
    }
    Configuration.SetUnableToEstablishWiFiConnectionInThisSession(false);
    try
    {
      AggregatorLoginHelper.SyncItemStatus(new AggregatorLoginHelper.GSyncStatusResult()
      {
        public void SyncCompleted(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          try
          {
            ChangeSyncManager.SyncChanges(new ChangeSyncManager.ChangeSyncStatusResult()
            {
              public void SyncCompleted(boolean paramAnonymous2Boolean)
              {
                UpdateAndDownloadManager.StartUpdateDownload(this.val$f, this.val$isUnattended);
              }
            });
            return;
          }
          catch (Exception localException)
          {
            CoreHelper.LogException(CommandManagerBase.TAG, "Unable to start Episode Sync!", localException);
            UpdateAndDownloadManager.StartUpdateDownload(CommandManagerBase.this, paramBoolean);
          }
        }
      });
      return;
    }
    catch (Exception localException)
    {
      CoreHelper.LogException(TAG, "Unable to start Reader Sync!", localException);
      UpdateAndDownloadManager.StartUpdateDownload(paramFeedList, paramBoolean);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/commands/CommandManagerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */