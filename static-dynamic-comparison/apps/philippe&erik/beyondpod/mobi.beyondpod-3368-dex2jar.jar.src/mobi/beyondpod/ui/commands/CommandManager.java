package mobi.beyondpod.ui.commands;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.downloadengine.EnclosureDownloadManager;
import mobi.beyondpod.downloadengine.EnclosureDownloadManager.DownloadableEnclosure;
import mobi.beyondpod.downloadengine.UpdateAndDownloadManager;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.FeedSorter;
import mobi.beyondpod.rsscore.StartupContentBuilder;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.TrackSorter;
import mobi.beyondpod.rsscore.categories.CategoryList;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.AnalyticsTracker;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.CoreHelper.DeviceNetworkConnection;
import mobi.beyondpod.rsscore.helpers.MediaFile;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.repository.FeedRepository.FeedSearchArguments;
import mobi.beyondpod.rsscore.repository.RepositoryPersistence;
import mobi.beyondpod.rsscore.rss.ItemStateHistory;
import mobi.beyondpod.rsscore.rss.LicenseManager;
import mobi.beyondpod.rsscore.rss.RssFeedCache;
import mobi.beyondpod.rsscore.rss.entities.RssEnclosure;
import mobi.beyondpod.schedulercore.ScheduleUtils;
import mobi.beyondpod.schedulercore.ScheduledTasksManager;
import mobi.beyondpod.services.player.CategoryPlaylistTemplate;
import mobi.beyondpod.services.player.MediaPlaybackService;
import mobi.beyondpod.services.player.PlayList;
import mobi.beyondpod.services.player.SmartPlaylistTemplate;
import mobi.beyondpod.services.player.impl.ChromecastDevice;
import mobi.beyondpod.ui.core.FeedImageCache;
import mobi.beyondpod.ui.dialogs.AboutDialog;
import mobi.beyondpod.ui.dialogs.ClearCachesDialog;
import mobi.beyondpod.ui.dialogs.DeleteCategoryDialog;
import mobi.beyondpod.ui.dialogs.DeleteFeedDialog;
import mobi.beyondpod.ui.dialogs.DeletePodcastDialog;
import mobi.beyondpod.ui.dialogs.ExternalPlayerStarterActivity;
import mobi.beyondpod.ui.dialogs.PurchaseUnlockKeyDialog;
import mobi.beyondpod.ui.dialogs.RestoreDefaultsDialog;
import mobi.beyondpod.ui.dialogs.TrackPropertiesDialog;
import mobi.beyondpod.ui.settings.SettingsView;
import mobi.beyondpod.ui.views.CategoryEditorActivity;
import mobi.beyondpod.ui.views.CategoryPropertiesView;
import mobi.beyondpod.ui.views.CategoryScheduleView;
import mobi.beyondpod.ui.views.FeedContentViewActivity;
import mobi.beyondpod.ui.views.FeedPreviewActivity;
import mobi.beyondpod.ui.views.FeedsView;
import mobi.beyondpod.ui.views.FileViewActivity;
import mobi.beyondpod.ui.views.HtmlViewActivity;
import mobi.beyondpod.ui.views.MasterView;
import mobi.beyondpod.ui.views.MovieView;
import mobi.beyondpod.ui.views.OpmlListViewActivity;
import mobi.beyondpod.ui.views.PlaylistEditorActivity;
import mobi.beyondpod.ui.views.PodcastsListView;
import mobi.beyondpod.ui.views.SmartPlaylistEditorView;
import mobi.beyondpod.ui.views.UpdateAndDownloadQueueActivityDialog;
import mobi.beyondpod.ui.views.Workspace;
import mobi.beyondpod.ui.views.feedsettings.FeedPropertiesView;
import mobi.beyondpod.ui.views.impexp.AddFeedView;
import mobi.beyondpod.ui.views.impexp.DisableGoogleReaderDialog;
import mobi.beyondpod.ui.views.impexp.ExportToOPMLActivity;
import mobi.beyondpod.ui.views.impexp.ImportFeedlyActivity;
import mobi.beyondpod.ui.views.impexp.ImportOPMLActivity;
import mobi.beyondpod.ui.views.notifications.UserNotificationManager;
import mobi.beyondpod.ui.views.notifications.UserNotificationManager.OnContinueListener;

public class CommandManager
  extends CommandManagerBase
{
  private static final String BEYOND_POD_FEED_SEARCH;
  private static final String PER_CATEGORY = CoreHelper.LoadResourceString(2131297166);
  private static final String PICK_SCHEDULING_METHOD;
  private static final String SELECT_UPDATE_SCHEDULE;
  private static final String SINGLE_SCHEDULE = CoreHelper.LoadResourceString(2131297167);
  private static final String TAG = CommandManager.class.getSimpleName();
  private static final String THERE_IS_NOTHING_TO_PLAY;
  private static final String UNABLE_TO_OPEN_URL;
  private static final String UNABLE_TO_START_EXTERNAL_PLAYER;
  private static final String UNABLE_TO_START_VIDEO_PLAYER;
  private static final String UPDATE_AND_DOWNLOAD_LOG;
  private static final String VOICE_SEARCH_CATEGORY_TAG = "category ";
  private static final String VOICE_SEARCH_EPISODE_TAG = "episode ";
  private static final String VOICE_SEARCH_FEED_TAG = "feed ";
  private static final String VOICE_SEARCH_SMARTPLAY_TAG1 = "smart play";
  private static final String VOICE_SEARCH_SMARTPLAY_TAG2 = "smart";
  private static final String VOICE_SEARCH_SMARTPLAY_TAG3 = "playlist";
  private static final String VOICE_SEARCH_SORT_LATEST = "latest in ";
  private static final String VOICE_SEARCH_SORT_OLDEST = "oldest in ";
  private static final String VOICE_SEARCH_SORT_RANDOM = "random in ";
  
  static
  {
    SELECT_UPDATE_SCHEDULE = CoreHelper.LoadResourceString(2131297168);
    PICK_SCHEDULING_METHOD = CoreHelper.LoadResourceString(2131297169);
    BEYOND_POD_FEED_SEARCH = CoreHelper.LoadResourceString(2131297039);
    UPDATE_AND_DOWNLOAD_LOG = CoreHelper.LoadResourceString(2131297029);
    THERE_IS_NOTHING_TO_PLAY = CoreHelper.LoadResourceString(2131297030);
    UNABLE_TO_OPEN_URL = CoreHelper.LoadResourceString(2131297031);
    UNABLE_TO_START_EXTERNAL_PLAYER = CoreHelper.LoadResourceString(2131297032);
    UNABLE_TO_START_VIDEO_PLAYER = CoreHelper.LoadResourceString(2131297033);
  }
  
  private static void AskForReplaceAppend(final Context paramContext, final List<Track> paramList, final Track paramTrack, final boolean paramBoolean)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2130903067, null);
    localView.setMinimumHeight(300);
    final CheckBox localCheckBox = (CheckBox)localView.findViewById(2131230813);
    ((TextView)localView.findViewById(2131230809)).setGravity(3);
    RadioGroup localRadioGroup = (RadioGroup)localView.findViewById(2131230810);
    localRadioGroup.check(2131230811);
    localRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        if (paramAnonymousInt == 2131230812)
        {
          CommandManager.this.setText(2131296748);
          return;
        }
        CommandManager.this.setText(2131296749);
      }
    });
    new AlertDialog.Builder(paramContext).setTitle(2131296744).setView(localView).setPositiveButton(2131296752, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        if (CommandManager.this.getCheckedRadioButtonId() == 2131230811)
        {
          if (localCheckBox.isChecked())
          {
            UserNotificationManager.setNotificationPreferenceFor(21, false);
            Toast.makeText(paramContext, 2131296750, 1).show();
          }
          CommandManager.CmdLoadPlaylistAndPlayTrack(paramList, paramTrack, paramBoolean);
        }
        while (CommandManager.this.getCheckedRadioButtonId() != 2131230812) {
          return;
        }
        if (localCheckBox.isChecked())
        {
          Configuration.setAutoPlaylistEnabled(false);
          Toast.makeText(paramContext, 2131296750, 1).show();
        }
        CommandManager.CmdPlayTrack(paramContext, paramTrack);
      }
    }).setNegativeButton(2131296315, null).create().show();
  }
  
  public static void CmdAddNewCategory()
  {
    AnalyticsTracker.OnCommand("CmdAddNewCategory", "");
    StartActivity(new Intent(BeyondPodApplication.GetInstance(), CategoryPropertiesView.class));
  }
  
  public static void CmdAddNewFeed()
  {
    AnalyticsTracker.OnCommand("CmdAddNewFeed", "");
    Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), FeedPropertiesView.class);
    localIntent.setType(UUID.randomUUID().toString());
    StartActivity(localIntent);
  }
  
  public static void CmdAddToPlaylist(Track paramTrack)
  {
    AnalyticsTracker.OnCommand("CmdAddToPlaylist", "");
    BeyondPodApplication.GetInstance().PlayList().AddTrack(paramTrack);
  }
  
  public static void CmdAddToPlaylist(TrackList paramTrackList)
  {
    AnalyticsTracker.OnCommand("CmdAddToPlaylist", "");
    BeyondPodApplication.GetInstance().PlayList().AddTracks(paramTrackList);
  }
  
  public static void CmdClearCaches(Context paramContext)
  {
    ClearCachesDialog.ShowDialog(paramContext);
  }
  
  public static void CmdDeleteCategory(Context paramContext, FeedCategory paramFeedCategory)
  {
    DeleteCategoryDialog.ShowDialog(paramContext, paramFeedCategory);
  }
  
  public static void CmdDeleteFeed(Context paramContext, Feed paramFeed)
  {
    DeleteFeedDialog.ShowDialog(paramContext, paramFeed);
  }
  
  public static void CmdDeletePodcasts(Context paramContext, TrackList paramTrackList)
  {
    DeletePodcastDialog.ShowDialog(paramContext, paramTrackList);
  }
  
  public static void CmdDownloadAllInPlaylistManually(Context paramContext)
  {
    CmdDownloadTracks(paramContext, BeyondPodApplication.GetInstance().PlayList().GetTracks());
  }
  
  public static void CmdDownloadEnclosuresManually(Context paramContext, ArrayList<EnclosureDownloadManager.DownloadableEnclosure> paramArrayList)
  {
    if (((paramArrayList.size() > 1) || (EnclosureDownloadManager.IsDownloading())) && (LicenseManager.CheckAndNotifyIfInRestrictedMode())) {
      return;
    }
    if (!EnclosureDownloadManager.IsDownloading())
    {
      int i;
      int j;
      label58:
      int k;
      if ((!Configuration.IsCellularConnectionAllowed()) && (CoreHelper.GetDeviceNetworkConnection().IsConnectionCellular()))
      {
        i = 1;
        if ((!Configuration.DownloadEnclosuresWhenChargingOnly()) || (CoreHelper.IsDevicePlugged())) {
          break label151;
        }
        j = 1;
        if ((!Configuration.DownloadEnclosuresOnWiFiOnly()) || (CoreHelper.GetDeviceNetworkConnection().IsConnectionWiFi())) {
          break label156;
        }
        k = 1;
        label76:
        if ((j == 0) && (k == 0) && (i == 0)) {
          break label180;
        }
        if (k == 0) {
          break label162;
        }
        i = 2131296956;
      }
      for (;;)
      {
        new AlertDialog.Builder(paramContext).setTitle(2131296714).setMessage(i).setPositiveButton(2131296584, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            CommandManager.DownloadEnclosuresManuallyInternal(CommandManager.this, true);
          }
        }).setNegativeButton(2131296585, null).setCancelable(true).show();
        return;
        i = 0;
        break;
        label151:
        j = 0;
        break label58;
        label156:
        k = 0;
        break label76;
        label162:
        if (i != 0) {
          i = 2131296958;
        } else {
          i = 2131296957;
        }
      }
    }
    label180:
    DownloadEnclosuresManuallyInternal(paramArrayList, false);
  }
  
  public static void CmdDownloadTracks(Context paramContext, List<Track> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    for (;;)
    {
      if (!paramList.hasNext())
      {
        if (localArrayList.size() > 0) {
          CmdDownloadEnclosuresManually(paramContext, localArrayList);
        }
        return;
      }
      Track localTrack = (Track)paramList.next();
      if ((!localTrack.IsFullyDownloaded()) && (localTrack.getDownloadStatus() != 2))
      {
        Object localObject = new File(localTrack.TrackPath());
        localObject = new RssEnclosure(localTrack.getUrl(), ((File)localObject).getParent(), ((File)localObject).getName(), localTrack.ContentMimeType(), localTrack.RssItemID(), localTrack.getDownloadSize(), localTrack.getLastModifiedDate(), localTrack.DisplayName());
        if (!EnclosureDownloadManager.IsDownloadPending((RssEnclosure)localObject)) {
          localArrayList.add(new EnclosureDownloadManager.DownloadableEnclosure(localTrack.getParentFeed(), (RssEnclosure)localObject));
        }
      }
    }
  }
  
  public static void CmdEditCategory(FeedCategory paramFeedCategory)
  {
    AnalyticsTracker.OnCommand("CmdEditCategory", "");
    Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), CategoryPropertiesView.class);
    localIntent.setType(paramFeedCategory.Name());
    StartActivity(localIntent);
  }
  
  public static void CmdEditFeed(Feed paramFeed, int paramInt)
  {
    AnalyticsTracker.OnCommand("CmdEditFeed", "");
    Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), FeedPropertiesView.class);
    localIntent.setType(paramFeed.ID().toString());
    localIntent.putExtra("FocusControl", paramInt);
    StartActivity(localIntent);
  }
  
  public static void CmdEditSmartPlayList()
  {
    Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), SmartPlaylistEditorView.class);
    localIntent.setFlags(268435456);
    StartActivity(localIntent);
  }
  
  public static void CmdExit()
  {
    if (MasterView.Master() != null) {
      MasterView.Master().finish();
    }
    if (MediaPlaybackService.ServiceIsRunning)
    {
      CmdStopPlayback();
      Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), MediaPlaybackService.class);
      localIntent.setAction("mobi.beyondpod.services.musicservicecommand");
      localIntent.putExtra("command", "stopService");
      BeyondPodApplication.GetInstance().startService(localIntent);
    }
    RepositoryPersistence.RepositoryHandler().post(new Runnable()
    {
      public void run()
      {
        ItemStateHistory.SaveHistorySync();
        StartupContentBuilder.BackupRepositoriesSync();
        BeyondPodApplication.GetInstance().shutdown();
      }
    });
  }
  
  private static void CmdLoadPlaylistAndPlayTrack(List<Track> paramList, Track paramTrack, boolean paramBoolean)
  {
    BeyondPodApplication.GetInstance().PlayList().LoadTracks(paramList, paramBoolean);
    CmdPlayPosition(BeyondPodApplication.GetInstance().PlayList().GetTrackPosition(paramTrack));
  }
  
  public static void CmdLockTrack(Context paramContext, Track paramTrack)
  {
    AnalyticsTracker.OnCommand("CmdLockTrack", "");
    Toast.makeText(paramContext, 2131296676, 1).show();
    paramTrack.setLocked(true);
  }
  
  public static void CmdNotifyStreamingNotAllowed(Context paramContext)
  {
    if (Configuration.AllowEpisodeStreaming() == 1)
    {
      Toast.makeText(paramContext, 2131297082, 1).show();
      return;
    }
    Toast.makeText(paramContext, 2131297081, 1).show();
  }
  
  public static void CmdOpenAboutDialog(Context paramContext)
  {
    AboutDialog.ShowDialog(paramContext);
  }
  
  public static void CmdOpenAddFeedDialog()
  {
    AnalyticsTracker.OnCommand("CmdOpenAddFeed", "");
    StartActivity(new Intent(BeyondPodApplication.GetInstance(), AddFeedView.class));
  }
  
  public static void CmdOpenDisconnectAggregatorDialog()
  {
    Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), DisableGoogleReaderDialog.class);
    localIntent.setFlags(268435456);
    StartActivity(localIntent);
  }
  
  public static void CmdOpenExternalBrowser(String paramString)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(paramString));
      localIntent.setFlags(268435456);
      BeyondPodApplication.GetInstance().startActivity(localIntent);
      return;
    }
    catch (Exception paramString)
    {
      Toast.makeText(BeyondPodApplication.GetInstance(), UNABLE_TO_OPEN_URL + "\n\n" + paramString.getMessage(), 1).show();
    }
  }
  
  public static void CmdOpenExternalPlayer(Context paramContext, Track paramTrack)
  {
    UserNotificationManager.WarnAboutPlaybackInExternalPlayer(paramContext, new UserNotificationManager.OnContinueListener()
    {
      public void OnContinue()
      {
        for (;;)
        {
          Intent localIntent;
          try
          {
            localIntent = new Intent("android.intent.action.VIEW");
            String str1 = CommandManager.this.ContentMimeType();
            String str3 = CommandManager.this.getUrl();
            i = 1;
            boolean bool;
            if ((str1.equals("application/x-shockwave-flash")) && (str3.contains("youtube.com/v/")))
            {
              str1 = null;
              if (i != 0) {
                CommandManager.CmdPauseAudioPlayback();
              }
              AnalyticsTracker.OnCommand("CmdOpenExternalPlayer", str1);
              if (CommandManager.this.Exists())
              {
                localIntent.setDataAndType(Uri.fromFile(new File(CommandManager.this.TrackPath())), str1);
                localIntent.putExtra("startPosition", CommandManager.this.PlayedAsFraction());
                if (CommandManager.this.PlayedAsFraction() != 0.0F) {
                  break label363;
                }
                bool = true;
                localIntent.putExtra("fromStart", bool);
                localIntent.putExtra("savePosition", true);
                localIntent.putExtra("position", (int)(CommandManager.this.getPlayedTime() * 1000L));
                localIntent.putExtra("return_result", true);
                localIntent.putExtra("title", CommandManager.this.getName());
                if ((MasterView.Master() == null) || (!CoreHelper.IsPartnerPlayerInstalled(CommandManager.this.TrackPath(), str1))) {
                  break label368;
                }
                MasterView.Master().Workspace.LastExternalPlayerTrackPath = CommandManager.this.TrackPath();
                MasterView.Master().Workspace.LastExternalPlayerTrackTime = System.currentTimeMillis();
                localIntent.setComponent(new ComponentName(BeyondPodApplication.GetInstance(), ExternalPlayerStarterActivity.class));
                CommandManager.StartActivity(localIntent);
              }
            }
            else if (StringUtils.IsNullOrEmpty(str1))
            {
              str1 = "audio/*";
              continue;
            }
            switch (CommandManager.this.ContentType())
            {
            default: 
              localIntent.setDataAndType(Uri.parse(str3), str1);
              continue;
              bool = false;
            }
          }
          catch (Exception localException)
          {
            Toast.makeText(BeyondPodApplication.GetInstance(), CommandManager.UNABLE_TO_START_EXTERNAL_PLAYER + "\n\n" + localException.getMessage(), 1).show();
            return;
          }
          label363:
          continue;
          label368:
          CommandManager.StartActivity(localIntent);
          CommandManager.this.MarkPlayed();
          ItemStateHistory.MarkTracksItemAsRead(CommandManager.this);
          return;
          continue;
          String str2 = "audio/*";
          continue;
          str2 = "video/*";
          continue;
          int i = 0;
          str2 = "image/*";
        }
      }
    });
  }
  
  public static void CmdOpenFeed(Feed paramFeed)
  {
    if (paramFeed == null) {
      return;
    }
    if (paramFeed.HasUrl())
    {
      CmdOpenFeedUrl(paramFeed, false);
      return;
    }
    CmdOpenPodcastsView(paramFeed);
  }
  
  public static void CmdOpenFeedPreview(Uri paramUri, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramUri == null) {
      return;
    }
    paramUri = Feed.CreateTransientFeed(paramUri.toString(), paramString1);
    if (!StringUtils.IsNullOrEmpty(paramString2)) {
      paramUri.TransientEpisodeUrl = paramString2;
    }
    if (paramBoolean) {
      paramUri.setType(5);
    }
    Configuration.TempFeedHolder.put(paramUri.ID(), paramUri);
    RssFeedCache.DeleteFeedCacheFor(paramUri);
    FeedImageCache.DeleteImageCacheFor(paramUri);
    paramString1 = new Intent(BeyondPodApplication.GetInstance(), FeedPreviewActivity.class);
    paramString1.setData(Uri.parse("feed://feed/" + paramUri.ID().toString()));
    StartActivity(paramString1);
  }
  
  public static void CmdOpenFeedSearch(String paramString)
  {
    AnalyticsTracker.OnCommand("CmdOpenFeedSearch", "");
    Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), AddFeedView.class);
    localIntent.putExtra("Query", paramString);
    localIntent.putExtra("Title", BEYOND_POD_FEED_SEARCH);
    StartActivity(localIntent);
  }
  
  public static void CmdOpenFeedUrl(Feed paramFeed, boolean paramBoolean)
  {
    if ((paramFeed.getType() == 4) && (RssFeedCache.HasCachedFileFor(paramFeed)))
    {
      CmdOpenOpmlImporter(paramFeed);
      return;
    }
    AnalyticsTracker.OnCommand("CmdOpenFeedUrl", "");
    Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), FeedContentViewActivity.class);
    StringBuilder localStringBuilder = new StringBuilder("feed://feed/").append(paramFeed.ID().toString());
    if (paramBoolean) {}
    for (paramFeed = "/episodes";; paramFeed = "")
    {
      localIntent.setData(Uri.parse(paramFeed));
      StartActivity(localIntent);
      return;
    }
  }
  
  public static void CmdOpenGReaderLogin(Context paramContext, int paramInt)
  {
    paramContext = new Intent(BeyondPodApplication.GetInstance(), ImportFeedlyActivity.class);
    paramContext.putExtra("LoginOnly", paramInt);
    paramContext.setFlags(268435456);
    StartActivity(paramContext);
  }
  
  public static void CmdOpenManageCategoriesView()
  {
    AnalyticsTracker.OnCommand("CmdOpenManageCategoriesView", "");
    StartActivity(new Intent(BeyondPodApplication.GetInstance(), CategoryEditorActivity.class));
  }
  
  public static void CmdOpenManagePlaylistView(boolean paramBoolean)
  {
    AnalyticsTracker.OnCommand("CmdOpenPlaylistView", "");
    Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), PlaylistEditorActivity.class);
    localIntent.putExtra("OpenInEdit", paramBoolean);
    StartActivity(localIntent);
  }
  
  public static void CmdOpenOpmlExport()
  {
    AnalyticsTracker.OnCommand("CmdOpenOpmlExport", "");
    StartActivity(new Intent(BeyondPodApplication.GetInstance(), ExportToOPMLActivity.class));
  }
  
  public static void CmdOpenOpmlImport()
  {
    AnalyticsTracker.OnCommand("CmdOpenOpmlImport", "");
    StartActivity(new Intent(BeyondPodApplication.GetInstance(), ImportOPMLActivity.class));
  }
  
  public static void CmdOpenOpmlImporter(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      return;
    }
    CmdOpenOpmlImporter(new Feed(UUID.randomUUID(), null, paramFile.getName(), Uri.fromFile(paramFile).toString(), 4));
  }
  
  public static void CmdOpenOpmlImporter(Feed paramFeed)
  {
    if ((paramFeed.IsGReaderFeed()) || (paramFeed.getType() == 4))
    {
      Configuration.TempFeedHolder.put(paramFeed.ID(), paramFeed);
      Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), OpmlListViewActivity.class);
      localIntent.setData(Uri.parse("opml://feed/" + paramFeed.ID().toString()));
      StartActivity(localIntent);
      return;
    }
    CmdOpenFeedUrl(paramFeed, false);
  }
  
  public static void CmdOpenPodcastsView(Feed paramFeed)
  {
    Configuration.setActiveFeedFilter(paramFeed);
    if ((MasterView.Master() != null) && (MasterView.Master().Workspace != null))
    {
      MasterView.Master().Workspace.Podcasts.ReloadTracks();
      MasterView.Master().Workspace.ActivateView(3);
    }
  }
  
  public static void CmdOpenTrackPropertiesDialog(Track paramTrack)
  {
    if (paramTrack == null) {
      return;
    }
    Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), TrackPropertiesDialog.class);
    localIntent.setAction(paramTrack.TrackPath());
    StartActivity(localIntent);
  }
  
  public static void CmdOpenWelcomePage(Uri paramUri, CharSequence paramCharSequence)
  {
    Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), HtmlViewActivity.class);
    localIntent.setData(paramUri);
    localIntent.putExtra("Title", paramCharSequence);
    localIntent.putExtra("HasBottomToolbar", true);
    StartActivity(localIntent);
  }
  
  public static void CmdPauseAudioPlayback()
  {
    AnalyticsTracker.OnCommand("CmdPausePlayback", "");
    if ((BeyondPodApplication.GetInstance().PlayList().CurrentTrack() != null) && (BeyondPodApplication.GetInstance().PlayList().CurrentTrack().getCurrentPlayState() == 1))
    {
      Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), MediaPlaybackService.class);
      localIntent.setAction("mobi.beyondpod.services.musicservicecommand");
      localIntent.putExtra("command", "pause");
      BeyondPodApplication.GetInstance().startService(localIntent);
    }
  }
  
  public static boolean CmdPlayAllInCategory(Context paramContext)
  {
    AnalyticsTracker.OnCommand("CmdPlayAllInCategory", "");
    return PlayGeneratedPlaylist(paramContext, CategoryPlaylistTemplate.GeneratePlaylist(Configuration.getActiveFeedCategory(), -1, Configuration.getPodcastsSortOrder(), -2, new ArrayList()), false);
  }
  
  public static boolean CmdPlayFeedEpisodes(Context paramContext, Feed paramFeed, int paramInt)
  {
    if (paramFeed == null) {}
    label66:
    label149:
    label164:
    label175:
    for (;;)
    {
      return false;
      TrackList localTrackList = new TrackList();
      PlayList localPlayList = BeyondPodApplication.GetInstance().PlayList();
      paramFeed = paramFeed.TracksAndSubTracks().iterator();
      if (!paramFeed.hasNext())
      {
        if (localTrackList.size() <= 0) {
          continue;
        }
        if (paramInt != 100) {
          break label149;
        }
        Collections.shuffle(localTrackList, new Random(System.nanoTime()));
        if (!Configuration.AutoPlaylistEnabled()) {
          break label164;
        }
        CmdEmptyPlaylist(true, true);
      }
      for (;;)
      {
        if (PlayList.IsCurrentlyPlaying()) {
          break label175;
        }
        return PlayTracksInternal(paramContext, localTrackList, (Track)localTrackList.get(0), true, false, false);
        Track localTrack = (Track)paramFeed.next();
        if ((localTrack.IsPlayed()) || ((!localPlayList.CanAddToPlaylist(localTrack)) && (!localPlayList.HasTrack(localTrack)))) {
          break;
        }
        localTrackList.add(localTrack);
        break;
        Collections.sort(localTrackList, new TrackSorter(paramInt));
        break label66;
        if (!PlayList.IsEmpty()) {
          CmdAddToPlaylist(localTrackList);
        }
      }
    }
  }
  
  public static boolean CmdPlayFromVoiceSearch(String paramString)
  {
    CoreHelper.WriteTraceEntry(TAG, "QuickPlay is matching keyword '" + paramString + "'...");
    if (StringUtils.IsNullOrEmpty(paramString)) {
      return false;
    }
    String str2 = paramString.toLowerCase(Locale.US);
    if ((StringUtils.EqualsIgnoreCase("smart play", str2)) || (StringUtils.EqualsIgnoreCase("smart", str2)) || (StringUtils.EqualsIgnoreCase("playlist", str2)))
    {
      CoreHelper.WriteTraceEntry(TAG, "QuickPlay starting SmartPlay...");
      CmdPlaySmartPlayList(BeyondPodApplication.GetInstance());
      return true;
    }
    int i = -1;
    String str1;
    if (str2.startsWith("oldest in "))
    {
      CoreHelper.WriteTraceEntry(TAG, "QuickPlay found match for sort order 'oldest in'");
      i = 2;
      str1 = paramString.substring("oldest in ".length());
    }
    int j;
    for (;;)
    {
      paramString = str1.toLowerCase(Locale.US);
      if (!paramString.startsWith("category ")) {
        break;
      }
      paramString = str1.substring("category ".length());
      j = i;
      if (i == -1) {
        j = Configuration.getPodcastsSortOrder();
      }
      if (!PlayCategorySearch(paramString, j)) {
        break label369;
      }
      return true;
      if (str2.startsWith("latest in "))
      {
        CoreHelper.WriteTraceEntry(TAG, "QuickPlay found match for sort order 'latest in'");
        i = 3;
        str1 = paramString.substring("latest in ".length());
      }
      else
      {
        str1 = paramString;
        if (str2.startsWith("random in "))
        {
          CoreHelper.WriteTraceEntry(TAG, "QuickPlay found match for sort order 'random in'");
          i = 100;
          str1 = paramString.substring("random in ".length());
        }
      }
    }
    if (paramString.startsWith("feed "))
    {
      if (PlayFeedSearch(str1.substring("feed ".length()), i)) {
        return true;
      }
    }
    else if (paramString.startsWith("episode "))
    {
      paramString = str1.substring("episode ".length());
      j = i;
      if (i == -1) {
        j = Configuration.getPodcastsSortOrder();
      }
      if (PlayEpisodeSearch(paramString, j)) {
        return true;
      }
    }
    else
    {
      if (i == -1) {}
      for (j = Configuration.getPodcastsSortOrder(); PlayCategorySearch(str1, j); j = i) {
        return true;
      }
      if (PlayFeedSearch(str1, i)) {
        return true;
      }
      j = i;
      if (i == -1) {
        j = Configuration.getPodcastsSortOrder();
      }
      if (PlayEpisodeSearch(str1, j)) {
        return true;
      }
    }
    label369:
    CoreHelper.WriteTraceEntry(TAG, "QuickPlay was unable to find match for: '" + str1 + "'!");
    return false;
  }
  
  public static void CmdPlayMovie(Context paramContext, Track paramTrack)
  {
    if ((Configuration.PlayerIntegrationType() == 0) || (Configuration.PlayerIntegrationType() == 2))
    {
      CmdPlayMovieInternalPlayer(paramContext, paramTrack);
      return;
    }
    CmdOpenExternalPlayer(paramContext, paramTrack);
  }
  
  public static void CmdPlayMovieInternalPlayer(Context paramContext, Track paramTrack)
  {
    try
    {
      CmdPauseAudioPlayback();
      AnalyticsTracker.OnCommand("CmdPlayMovie", "");
      if (ChromecastDevice.IsConnected())
      {
        CmdAddToPlaylist(paramTrack);
        CmdPlayPosition(BeyondPodApplication.GetInstance().PlayList().GetTrackPosition(paramTrack));
        return;
      }
      paramContext = new Intent(paramContext, MovieView.class);
      paramContext.setAction(paramTrack.TrackPath());
      paramContext.addFlags(268435456);
      BeyondPodApplication.GetInstance().startActivity(paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      Toast.makeText(BeyondPodApplication.GetInstance(), UNABLE_TO_START_VIDEO_PLAYER + "\n\n" + paramContext.getMessage(), 1).show();
    }
  }
  
  public static boolean CmdPlayPauseTrack(Context paramContext, Track paramTrack, List<Track> paramList)
  {
    if (paramTrack.getCurrentPlayState() == 0)
    {
      CmdResumePlayback();
      return false;
    }
    if (paramTrack.getCurrentPlayState() == 1)
    {
      CmdPauseAudioPlayback();
      return false;
    }
    if (!PlayList.AllowStreaming(paramTrack))
    {
      CmdNotifyStreamingNotAllowed(paramContext);
      return false;
    }
    if ((!BeyondPodApplication.GetInstance().PlayList().HasTrack(paramTrack)) && (Configuration.AutoPlaylistEnabled()))
    {
      if ((paramList == null) || (paramList.size() == 0))
      {
        paramList = new TrackList();
        paramList.add(paramTrack);
      }
      for (;;)
      {
        return PlayTracksInternal(paramContext, paramList, paramTrack, true, false, false);
      }
    }
    return CmdPlayTrack(paramContext, paramTrack);
  }
  
  public static boolean CmdPlaySmartPlayList(Context paramContext)
  {
    AnalyticsTracker.OnCommand("CmdPlaySmartPlayList", "");
    if (FeedRepository.RepositoryLoadState() != 2) {
      return false;
    }
    SmartPlaylistTemplate localSmartPlaylistTemplate = new SmartPlaylistTemplate();
    if (!localSmartPlaylistTemplate.IsLoaded())
    {
      CoreHelper.WriteLogEntry(TAG, "Attempting to play smart playlist that was not yet loaded. Ignoring...");
      return false;
    }
    if (localSmartPlaylistTemplate.IsEmpty())
    {
      CmdEditSmartPlayList();
      return false;
    }
    return PlayGeneratedPlaylist(paramContext, localSmartPlaylistTemplate.GeneratePlaylist(), false);
  }
  
  public static boolean CmdPlayTrack(Context paramContext, Track paramTrack)
  {
    if ((paramTrack.ContentType() != 3) && (!PlayList.IsEmpty())) {
      CmdAddToPlaylist(paramTrack);
    }
    TrackList localTrackList = new TrackList();
    localTrackList.add(paramTrack);
    return PlayTracksInternal(paramContext, localTrackList, paramTrack, true, false, false);
  }
  
  public static boolean CmdPlayTracks(Context paramContext, List<Track> paramList)
  {
    AnalyticsTracker.OnCommand("CmdPlayTracks", "");
    return PlayGeneratedPlaylist(paramContext, paramList, false);
  }
  
  public static void CmdRemoveFromPlaylist(Track paramTrack)
  {
    AnalyticsTracker.OnCommand("CmdRemoveFromPlaylist", "");
    BeyondPodApplication.GetInstance().PlayList().RemoveTrack(paramTrack);
  }
  
  public static void CmdReplaceTracksInPlaylist(TrackList paramTrackList)
  {
    AnalyticsTracker.OnCommand("CmdReplaceTracksInPlaylist", "");
    BeyondPodApplication.GetInstance().PlayList().LoadTracks(paramTrackList, false);
  }
  
  public static void CmdResumeAllDownloads(Context paramContext)
  {
    CmdDownloadTracks(paramContext, FeedRepository.AllResumableDownloads());
  }
  
  public static void CmdResumePlayback()
  {
    AnalyticsTracker.OnCommand("CmdResumePlayback", "");
    if ((BeyondPodApplication.GetInstance().PlayList().CurrentTrack() != null) && (BeyondPodApplication.GetInstance().PlayList().CurrentTrack().getCurrentPlayState() == 0))
    {
      Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), MediaPlaybackService.class);
      localIntent.setAction("mobi.beyondpod.services.musicservicecommand");
      localIntent.putExtra("command", "resume");
      BeyondPodApplication.GetInstance().startService(localIntent);
    }
  }
  
  public static void CmdSelectCategoryQuick(FeedCategory paramFeedCategory)
  {
    AnalyticsTracker.OnCommand("CmdSelectCategoryQuick", paramFeedCategory.Name());
    FeedCategory localFeedCategory = Configuration.getActiveFeedCategory();
    Configuration.setActiveFeedCategory(paramFeedCategory);
    if ((!localFeedCategory.equals(paramFeedCategory)) || (Configuration.getActiveFeedFilter() != null))
    {
      Configuration.setActiveFeedFilter(null);
      if ((MasterView.Master() != null) && (MasterView.Master().Workspace != null))
      {
        MasterView.Master().Workspace.Feeds.SetRootFeed(FeedRepository.getRootFeed());
        MasterView.Master().Workspace.Podcasts.ReloadTracks();
      }
    }
  }
  
  public static void CmdSendMediaCommandToVideoPlayer(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramContext = new Intent(paramContext, MovieView.class);
      paramContext.setAction("mobi.beyondpod.services.musicservicecommand");
      paramContext.putExtra("command", paramIntent.getStringExtra("command"));
      paramContext.addFlags(268435456);
      BeyondPodApplication.GetInstance().startActivity(paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      CoreHelper.LogException(TAG, "Failed to send Media Command to Video Player", paramContext);
    }
  }
  
  public static void CmdSetUpdateSchedule(FeedCategory paramFeedCategory, Context paramContext, boolean paramBoolean)
  {
    AnalyticsTracker.OnCommand("CmdSetUpdateSchedule", "");
    if (LicenseManager.CheckAndNotifyIfInRestrictedMode()) {
      return;
    }
    if ((paramBoolean) && (ScheduledTasksManager.ActiveTaskCount() == 0))
    {
      new AlertDialog.Builder(paramContext).setMessage(PICK_SCHEDULING_METHOD).setTitle(SELECT_UPDATE_SCHEDULE).setPositiveButton(SINGLE_SCHEDULE, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          CommandManager.ConfigureUpdateScheduleFor(CategoryManager.AllFeeds);
        }
      }).setNegativeButton(PER_CATEGORY, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          if (CommandManager.this == null)
          {
            CommandManager.CmdOpenManageCategoriesView();
            return;
          }
          CommandManager.ConfigureUpdateScheduleFor(CommandManager.this);
        }
      }).create().show();
      return;
    }
    if (paramFeedCategory == null)
    {
      if (ScheduleUtils.IsSingleSchedule())
      {
        ConfigureUpdateScheduleFor(CategoryManager.AllFeeds);
        return;
      }
      CmdOpenManageCategoriesView();
      return;
    }
    ConfigureUpdateScheduleFor(paramFeedCategory);
  }
  
  public static void CmdShareUrl(Context paramContext, String paramString1, String paramString2)
  {
    if (!StringUtils.IsNullOrEmpty(paramString2)) {
      CmdSendEMail(paramContext, Configuration.getDefaultSendToMailAddress(), paramString1, paramString2, null, false);
    }
  }
  
  public static void CmdShowAdvancedSettings()
  {
    Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), SettingsView.class);
    localIntent.setType("advanced");
    StartActivity(localIntent);
  }
  
  public static void CmdShowDeveloperSettings()
  {
    Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), SettingsView.class);
    localIntent.setType("developer");
    StartActivity(localIntent);
  }
  
  public static void CmdShowDownloadQueue()
  {
    StartActivity(new Intent(BeyondPodApplication.GetInstance(), UpdateAndDownloadQueueActivityDialog.class));
  }
  
  public static void CmdShowGlobalSettings()
  {
    StartActivity(new Intent("mobi.beyondpod.action.OPEN_SETTINGS_SELECTOR"));
  }
  
  public static void CmdShowRestoreDefaultsDialog(Context paramContext)
  {
    RestoreDefaultsDialog.ShowDialog(paramContext);
  }
  
  public static void CmdShowUpdateLog(Context paramContext)
  {
    ArrayList localArrayList = CoreHelper.GetUpdateLogs();
    if (localArrayList.size() == 0) {
      return;
    }
    if (localArrayList.size() == 1)
    {
      OpenLogVile((File)localArrayList.get(0));
      return;
    }
    String[] arrayOfString = new String[localArrayList.size()];
    int i = 0;
    for (;;)
    {
      if (i == localArrayList.size())
      {
        new AlertDialog.Builder(paramContext).setItems(arrayOfString, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            CommandManager.OpenLogVile((File)CommandManager.this.get(paramAnonymousInt));
          }
        }).setTitle("Select Update Log").create().show();
        return;
      }
      arrayOfString[i] = ("Log for " + DateUtils.formatDateTime(paramContext, ((File)localArrayList.get(i)).lastModified(), 526865));
      i += 1;
    }
  }
  
  public static void CmdSkipToEnd()
  {
    AnalyticsTracker.OnCommand("CmdSkipToEnd", "");
    if (BeyondPodApplication.GetInstance().PlayList().CurrentTrack() != null)
    {
      Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), MediaPlaybackService.class);
      localIntent.setAction("mobi.beyondpod.services.musicservicecommand");
      localIntent.putExtra("command", "skiptoend");
      BeyondPodApplication.GetInstance().startService(localIntent);
    }
  }
  
  public static void CmdStartHtmlViewActivity(Uri paramUri, CharSequence paramCharSequence, boolean paramBoolean)
  {
    Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), HtmlViewActivity.class);
    localIntent.setData(paramUri);
    localIntent.putExtra("Title", paramCharSequence);
    localIntent.putExtra("IsFeedContentLink", paramBoolean);
    StartActivity(localIntent);
  }
  
  public static void CmdStopAllUpdates()
  {
    if (UpdateAndDownloadManager.IsWorking()) {
      UpdateAndDownloadManager.TerminateAll();
    }
    while (!EnclosureDownloadManager.IsDownloading()) {
      return;
    }
    EnclosureDownloadManager.TerminateAllDownloads();
  }
  
  public static void CmdStreamEnclosure(final Context paramContext, final RssEnclosure paramRssEnclosure)
  {
    if (paramRssEnclosure == null) {
      return;
    }
    for (;;)
    {
      Intent localIntent;
      Object localObject;
      String str2;
      String str3;
      String str1;
      try
      {
        localIntent = new Intent("android.intent.action.VIEW");
        localObject = paramRssEnclosure.Type;
        str2 = paramRssEnclosure.Url;
        str3 = MediaFile.ConvertToStreamableMimeType((String)localObject, str2, null);
        if (str3.startsWith("audio"))
        {
          localObject = "audio/*";
          str1 = str2;
          AnalyticsTracker.OnCommand("CmdStreamEnclosure", "");
          if (StringUtils.IsNullOrEmpty((String)localObject)) {
            break label200;
          }
          localIntent.setDataAndType(Uri.parse(str1), (String)localObject);
          UserNotificationManager.WarnAboutStreamingInExternalPlayer(paramContext, new UserNotificationManager.OnContinueListener()
          {
            public void OnContinue()
            {
              try
              {
                CommandManager.StartActivity(CommandManager.this);
                ItemStateHistory.SetItemAsRead(paramRssEnclosure.Parent);
                return;
              }
              catch (Exception localException)
              {
                Toast.makeText(paramContext, 2131296954, 1).show();
              }
            }
          });
          return;
        }
      }
      catch (Exception paramRssEnclosure)
      {
        Toast.makeText(paramContext, 2131296954, 1).show();
        return;
      }
      if (str3.startsWith("video"))
      {
        localObject = "video/*";
        str1 = str2;
      }
      else
      {
        localObject = str3;
        str1 = str2;
        if (str3.equals("application/x-shockwave-flash"))
        {
          localObject = str3;
          str1 = str2;
          if (str2.contains("youtube.com/v/"))
          {
            str1 = str2.replace("?", "&").replace("youtube.com/v/", "youtube.com/watch?v=").replace(".swf", "");
            localObject = "";
            continue;
            label200:
            localIntent.setData(Uri.parse(str1));
          }
        }
      }
    }
  }
  
  public static void CmdTogglePlayedState(Track paramTrack)
  {
    if (paramTrack.IsPlayed())
    {
      paramTrack.ClearPlayed();
      ItemStateHistory.MarkTracksItemAsUnRead(paramTrack);
      return;
    }
    paramTrack.MarkPlayed();
    ItemStateHistory.MarkTracksItemAsRead(paramTrack);
  }
  
  public static void CmdUnlockBeyondPod(Context paramContext)
  {
    File localFile = CoreHelper.GetFirstDownloadedUnlockKey();
    if (localFile == null)
    {
      AnalyticsTracker.OnCommand("CmdOpenPurchaseKeyDialog", "");
      PurchaseUnlockKeyDialog.ShowDialog(paramContext);
      return;
    }
    AnalyticsTracker.OnCommand("CmdInstallUnlockKey", "");
    paramContext = new Intent("android.intent.action.VIEW");
    paramContext.setDataAndType(Uri.fromFile(localFile), "application/vnd.android.package-archive");
    StartActivity(paramContext);
  }
  
  public static void CmdUnlockTrack(Context paramContext, Track paramTrack)
  {
    if (!paramTrack.getParentFeed().CanDeleteTracks())
    {
      Toast.makeText(paramContext, 2131296675, 1).show();
      return;
    }
    AnalyticsTracker.OnCommand("CmdUnlockTrack", "");
    paramTrack.setLocked(false);
  }
  
  public static void CmdUpdateSmartPlayList()
  {
    AnalyticsTracker.OnCommand("CmdUpdateSmartPlayList", "");
    Intent localIntent = new Intent("mobi.beyondpod.scheduling.SCHEDULED_TASK");
    localIntent.setData(Uri.parse("bpscheduler:task/BPT#UPDATE_SMARTPLAY_FEEDS"));
    localIntent.putExtra("task_id", "BPT#UPDATE_SMARTPLAY_FEEDS");
    BeyondPodApplication.GetInstance().getApplicationContext().sendBroadcast(localIntent);
  }
  
  public static void CmdViewFileContent(String paramString, boolean paramBoolean)
  {
    try
    {
      Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), FileViewActivity.class);
      localIntent.setData(Uri.parse(paramString));
      localIntent.putExtra("ScrollToEnd", paramBoolean);
      StartActivity(localIntent);
      return;
    }
    catch (Exception paramString)
    {
      Toast.makeText(BeyondPodApplication.GetInstance().getApplicationContext(), paramString.getMessage(), 0).show();
    }
  }
  
  private static void ConfigureUpdateScheduleFor(FeedCategory paramFeedCategory)
  {
    Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), CategoryScheduleView.class);
    localIntent.setType(paramFeedCategory.Name());
    StartActivity(localIntent);
  }
  
  private static void DownloadEnclosuresManuallyInternal(ArrayList<EnclosureDownloadManager.DownloadableEnclosure> paramArrayList, boolean paramBoolean)
  {
    Configuration.SetUnableToEstablishWiFiConnectionInThisSession(false);
    Iterator localIterator = paramArrayList.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        UpdateAndDownloadManager.DownloadEnclosures(paramArrayList, false, paramBoolean);
        return;
      }
      Object localObject = (EnclosureDownloadManager.DownloadableEnclosure)localIterator.next();
      ((EnclosureDownloadManager.DownloadableEnclosure)localObject).Feed.NumDownloadedEnclosures = 0;
      localObject = ((EnclosureDownloadManager.DownloadableEnclosure)localObject).Feed;
      ((Feed)localObject).NumEnclosuresAvailableForDownload += 1;
    }
  }
  
  private static void OpenLogVile(File paramFile)
  {
    CmdStartHtmlViewActivity(Uri.parse(Configuration.BeyondPodContentUrl() + "/BeyondPodStorageRootPath/" + paramFile.getName()), UPDATE_AND_DOWNLOAD_LOG, false);
  }
  
  private static boolean PlayCategorySearch(String paramString, int paramInt)
  {
    boolean bool = false;
    paramString = new FeedRepository.FeedSearchArguments(paramString);
    paramString.LeafFeedsOnly = false;
    paramString = FeedRepository.SearchForCategory(paramString);
    if (paramString.size() > 0)
    {
      FeedCategory localFeedCategory = (FeedCategory)paramString.get(0);
      CoreHelper.WriteTraceEntry(TAG, "QuickPlay found " + paramString.size() + " category matches! Starting: " + localFeedCategory.Name());
      PlayGeneratedPlaylist(BeyondPodApplication.GetInstance(), CategoryPlaylistTemplate.GeneratePlaylist(localFeedCategory, -1, paramInt, -2, new ArrayList()), false);
      bool = true;
    }
    return bool;
  }
  
  private static boolean PlayEpisodeSearch(String paramString, int paramInt)
  {
    boolean bool = false;
    paramString = FeedRepository.SearchForTracks(null, new FeedRepository.FeedSearchArguments(paramString));
    if (paramInt == 100) {
      Collections.shuffle(paramString, new Random(System.nanoTime()));
    }
    for (;;)
    {
      if (paramString.size() > 0)
      {
        Track localTrack = (Track)paramString.get(0);
        CoreHelper.WriteTraceEntry(TAG, "QuickPlay found " + paramString.size() + " episode matches! Starting: " + localTrack.getName());
        PlayTracksInternal(BeyondPodApplication.GetInstance(), paramString, localTrack, false, false, false);
        bool = true;
      }
      return bool;
      Collections.sort(paramString, new TrackSorter(paramInt));
    }
  }
  
  private static boolean PlayFeedSearch(String paramString, int paramInt)
  {
    paramString = new FeedRepository.FeedSearchArguments(paramString);
    paramString.LeafFeedsOnly = false;
    Object localObject = FeedRepository.SearchForFeeds(FeedRepository.getRootFeed(), paramString);
    Collections.sort(((Feed)localObject).SubFeeds(), new FeedSorter(Configuration.getFeedsSortOrder()));
    PlayList localPlayList;
    Iterator localIterator1;
    if (((Feed)localObject).SubFeeds().size() > 0)
    {
      localPlayList = BeyondPodApplication.GetInstance().PlayList();
      localIterator1 = ((Feed)localObject).SubFeeds().iterator();
    }
    Track localTrack;
    do
    {
      Iterator localIterator2;
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          return false;
        }
        paramString = (Feed)localIterator1.next();
        localIterator2 = paramString.TracksAndSubTracks().iterator();
      }
      localTrack = (Track)localIterator2.next();
    } while ((localTrack.IsPlayed()) || ((!localPlayList.CanAddToPlaylist(localTrack)) && (!localPlayList.HasTrack(localTrack))));
    CoreHelper.WriteTraceEntry(TAG, "QuickPlay found " + ((Feed)localObject).SubFeeds().size() + " feed matches! Starting: " + paramString.getName());
    localObject = BeyondPodApplication.GetInstance();
    int i = paramInt;
    if (paramInt == -1) {
      i = paramString.getLocalOrInheritedTrackSortOrder();
    }
    CmdPlayFeedEpisodes((Context)localObject, paramString, i);
    return true;
  }
  
  private static boolean PlayGeneratedPlaylist(Context paramContext, List<Track> paramList, boolean paramBoolean)
  {
    if (paramList.size() == 0)
    {
      Toast.makeText(BeyondPodApplication.GetInstance(), THERE_IS_NOTHING_TO_PLAY, 0).show();
      return false;
    }
    return PlayTracksInternal(paramContext, paramList, (Track)paramList.get(0), false, false, paramBoolean);
  }
  
  private static boolean PlayTracksInternal(Context paramContext, List<Track> paramList, Track paramTrack, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AnalyticsTracker.OnCommand("CmdPlayTrack", "");
    if (paramTrack == null) {}
    while ((paramList == null) || (paramList.size() == 0)) {
      return false;
    }
    if (((paramTrack.ContentType() != 1) && (paramTrack.ContentType() != -1)) || ((Configuration.PlayerIntegrationType() == 0) || (Configuration.PlayerIntegrationType() == 1) || ((paramTrack.ContentType() == 2) && ((Configuration.PlayerIntegrationType() == 0) || (Configuration.PlayerIntegrationType() == 2)))))
    {
      int i = BeyondPodApplication.GetInstance().PlayList().GetTrackPosition(paramTrack);
      if ((i >= 0) && (paramBoolean1))
      {
        CmdPlayPosition(i);
        return false;
      }
      CoreHelper.WriteTraceEntryInDebug(TAG, "Manually modified: " + PlayList.IsManuallyModified() + ", Allow Append: " + paramBoolean1);
      if ((!paramBoolean2) && ((!PlayList.IsManuallyModified()) || (PlayList.IsEmpty()) || (!paramBoolean1)))
      {
        CmdLoadPlaylistAndPlayTrack(paramList, paramTrack, paramBoolean3);
        return true;
      }
      if (!Configuration.AutoPlaylistEnabled())
      {
        CmdPlayTrack(paramContext, paramTrack);
        return false;
      }
      if (UserNotificationManager.isNotificationEnabledFor(21))
      {
        AskForReplaceAppend(paramContext, paramList, paramTrack, paramBoolean3);
        return false;
      }
      CmdLoadPlaylistAndPlayTrack(paramList, paramTrack, paramBoolean3);
      return false;
    }
    if (paramTrack.ContentType() == 2)
    {
      CmdPlayMovie(paramContext, paramTrack);
      return false;
    }
    CmdOpenExternalPlayer(paramContext, paramTrack);
    return false;
  }
  
  public static void StartActivity(Intent paramIntent)
  {
    if (MasterView.Master() != null)
    {
      MasterView.Master().startActivity(paramIntent);
      return;
    }
    paramIntent.addFlags(268435456);
    BeyondPodApplication.GetInstance().startActivity(paramIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/commands/CommandManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */