package mobi.beyondpod.ui.settings;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceScreen;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.aggregators.AggregatorLoginHelper;
import mobi.beyondpod.rsscore.BackupRestorePreference;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.CrossDeviceSyncPreference;
import mobi.beyondpod.rsscore.DownloadFolderPreference;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.ScheduledUpdatesPreference;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.helpers.BackupHelper;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.LogcatSnapshotHelper;
import mobi.beyondpod.rsscore.helpers.LogcatSnapshotHelper.ILogcatSnapshot;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.helpers.TimeSpan;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.rss.ItemStateHistory;
import mobi.beyondpod.services.player.MediaButtonIntentReceiver;
import mobi.beyondpod.services.player.PlayList;
import mobi.beyondpod.services.player.PlayListEvents.PlayListEvent;
import mobi.beyondpod.sync.ChangeTracker;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.core.ActionBarHelper;
import mobi.beyondpod.ui.core.ActionBarPreferenceActivityBase;
import mobi.beyondpod.ui.core.MusicUtils;
import mobi.beyondpod.ui.core.MusicUtils.RebuildMediaDatabaseListener;
import mobi.beyondpod.ui.dialogs.MoveFilesDialog;
import mobi.beyondpod.ui.views.feedsettings.FeedPropertiesView;
import mobi.beyondpod.ui.views.notifications.UserNotificationManager;

public class SettingsView
  extends ActionBarPreferenceActivityBase
  implements SharedPreferences.OnSharedPreferenceChangeListener, LogcatSnapshotHelper.ILogcatSnapshot
{
  public static final String ADVANCED_PREFERENCES_KEY = "advanced";
  private static final String AUTO_PLAYLIST_ENABLED = "AutoPlaylistEnabled";
  private static final String CLOSE = CoreHelper.LoadResourceString(2131297003);
  private static final String DEFAULT_KEEP_AT_MOST_PODCASTS = "DefaultKeepAtMostPodcasts";
  private static final String DEFAULT_MAX_PODCAST_AGE = "DefaultMaximumPodcastAge";
  private static final String DEFAULT_NUM_PODCASTS_TO_DOWNLOAD = "DefaultNumberPodcastsToDownload";
  private static final String DEFAULT_PODCAST_DOWNLOAD_ACTION = "DefaultPodcastDownloadAction";
  public static final String DEVELOPER_PREFERENCES_KEY = "developer";
  private static final String ENVIRONMENT_INFO = CoreHelper.LoadResourceString(2131297002);
  private static final String E_MAIL_SUPPORT;
  private static final String FORCE_MEDIA_RESCAN = "ForceMediaDtabaseRescanOnDownloadOrDelete";
  private static final String HEADSET_BUTTON_KEY = "EnableHeadsetButton";
  private static final String LOCK_TO_CURRENT_ROOT = "PreferLastSDCardRoot";
  private static final int MENU_ADVANCED_SETTINGS = 6;
  private static final int MENU_CLEAR_CACHE = 7;
  private static final int MENU_ENVIRONMENT_INFO = 8;
  private static final int MENU_FLUSH_READER_ITEMS = 10;
  private static final int MENU_FORCE_MEDIA_RESCAN = 2;
  private static final int MENU_OPEN_WELCOME_LITE_PAGE = 3;
  private static final int MENU_OPEN_WELCOME_PRO_PAGE = 4;
  private static final int MENU_OPEN_WHAT_IS_NEW_PAGE = 5;
  private static final int MENU_RESET_NOTIFICATIONS = 1;
  private static final int MENU_VIEW_LOGCAT_FILE = 12;
  private static final int MENU_VIEW_LOG_FILE = 9;
  private static final int MENU_VIEW_SYNC_LOG_FILE = 13;
  private static final int MENU_VIEW_UPDATE_LOG = 11;
  private static final String ORIENTATION_LOCK = "OrientationLock";
  private static final String PREVENT_KEYGUARD_CHANGED = "PreventKeyguard";
  public static final int SCREEN_BACKUP_RESTORE = 6;
  public static final int SCREEN_FEED_CONTENT = 3;
  public static final int SCREEN_FEED_DEFAULTS = 5;
  public static final int SCREEN_FEED_UPDATE = 4;
  public static final int SCREEN_GENERAL = 0;
  public static final int SCREEN_PLAYER = 1;
  public static final int SCREEN_PLAYLIST = 2;
  private static final String SHARE_PODCASTS_KEY = "SharePodcasts";
  private static final String SHOW_CDS_SETTINGS = "ShowCDSSettings";
  private static final String SHOW_PODCAST_THUMBNAILS = "ShowPodcastThumbnails";
  public static final String START_SCREEN_PREFERENCES_KEY = "StartScreen";
  private static final String SUPPORTED_EXTENSIONS = "PlayerSupportedFileExtensions";
  private static final String TAG;
  private static final String THEME_CHANGED = "CurrentTheme";
  private static final String WELCOME_TO_BEYOND_POD;
  private static final String WHAT_IS_NEW = CoreHelper.LoadResourceString(2131296993);
  private static final String WIDGET_BACKGROUND = "WidgetBackgroundColor";
  private static final String WIDGET_BUTTON_ACTION = "WidgetSecondaryButtonAction";
  boolean _IsAdvancedPrefs = false;
  boolean _IsDeveloperPrefs = false;
  Preference.OnPreferenceChangeListener _SpaceSaversListener = new Preference.OnPreferenceChangeListener()
  {
    public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject)
    {
      int i = Configuration.getGlobalDefaultNumberPodcastsToDownload();
      int j = Configuration.getGlobalDefaultKeepAtMostPodcasts();
      if ("DefaultNumberPodcastsToDownload".equals(paramAnonymousPreference.getKey())) {
        i = StringUtils.TryParseIntFromString((String)paramAnonymousObject, Integer.valueOf(Configuration.getGlobalDefaultNumberPodcastsToDownload())).intValue();
      }
      if ("DefaultKeepAtMostPodcasts".equals(paramAnonymousPreference.getKey())) {
        j = StringUtils.TryParseIntFromString((String)paramAnonymousObject, Integer.valueOf(Configuration.getGlobalDefaultKeepAtMostPodcasts())).intValue();
      }
      if (i > j)
      {
        Toast.makeText(SettingsView.this, 2131296792, 1).show();
        return false;
      }
      return true;
    }
  };
  
  static
  {
    WELCOME_TO_BEYOND_POD = CoreHelper.LoadResourceString(2131296994);
    TAG = FeedPropertiesView.class.getSimpleName();
    E_MAIL_SUPPORT = CoreHelper.LoadResourceString(2131297004);
  }
  
  private void ApplySettings(String paramString)
  {
    int j = 0;
    int i = 0;
    if (paramString.equals("DefaultPodcastDownloadAction"))
    {
      paramString = FeedRepository.getRootFeed().SubFeeds().iterator();
      for (;;)
      {
        if (!paramString.hasNext())
        {
          j = i;
          FeedRepository.SaveRepositoryAsync();
          Toast.makeText(this, getResources().getString(2131296624, new Object[] { Integer.valueOf(j) }), 0).show();
          return;
        }
        ((Feed)paramString.next()).setPodcastDownloadAction(Configuration.getGlobalDefaultPodcastDownloadAction());
        i += 1;
      }
    }
    Iterator localIterator = FeedRepository.getRootFeed().SubFeeds().iterator();
    i = j;
    label340:
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
      Feed localFeed = (Feed)localIterator.next();
      if ((localFeed.getType() != 1) && (localFeed.getPodcastDownloadAction() != 0) && (localFeed.getPodcastDownloadAction() != 3))
      {
        j = localFeed.getKeepAtMostPodcasts();
        int n = localFeed.getMaxNumberPodcastToDownload();
        TimeSpan localTimeSpan = localFeed.getMaximumPodcastAge();
        int k;
        int m;
        if (paramString.equals("DefaultKeepAtMostPodcasts"))
        {
          k = Configuration.getGlobalDefaultKeepAtMostPodcasts();
          m = n;
        }
        for (;;)
        {
          if ((k < m) || (FeedRepository.GetOldTracksForFeed(localFeed, k, localTimeSpan, false).size() > 0)) {
            break label340;
          }
          j = i;
          if (localFeed.getKeepAtMostPodcasts() != k)
          {
            localFeed.setKeepAtMostPodcasts(k);
            j = i + 1;
          }
          k = j;
          if (localFeed.getMaxNumberPodcastToDownload() != m)
          {
            localFeed.setMaxNumberPodcastsToDownload(m);
            k = j + 1;
          }
          i = k;
          if (localFeed.getMaximumPodcastAge().compareTo(localTimeSpan) == 0) {
            break;
          }
          localFeed.setMaximumPodcastAge(localTimeSpan);
          i = k + 1;
          break;
          if (paramString.equals("DefaultNumberPodcastsToDownload"))
          {
            m = Configuration.getGlobalDefaultNumberPodcastsToDownload();
            k = j;
          }
          else
          {
            k = j;
            m = n;
            if (paramString.equals("DefaultMaximumPodcastAge"))
            {
              localTimeSpan = Configuration.getGlobalDefaultMaximumPodcastAge();
              k = j;
              m = n;
            }
          }
        }
      }
    }
  }
  
  private void AskToApplySettings(final String paramString)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this).setTitle(2131296581);
    if (paramString.equals("DefaultPodcastDownloadAction")) {}
    for (int i = 2131296582;; i = 2131296583)
    {
      localBuilder.setMessage(i).setPositiveButton(2131296584, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          SettingsView.this.ApplySettings(paramString);
        }
      }).setNegativeButton(2131296585, null).setCancelable(true).show();
      return;
    }
  }
  
  public void SnapshotFailed(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("Unable to read Android Log file!");
    if (StringUtils.IsNullOrEmpty(paramString)) {}
    for (paramString = "";; paramString = "\n\n" + paramString)
    {
      Toast.makeText(this, paramString, 0).show();
      return;
    }
  }
  
  public void SnapshotPrepared()
  {
    CommandManager.CmdViewFileContent(Configuration.LogcatFilePath(), true);
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return Configuration._preferences;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    super.onCreate(paramBundle);
    if (!FeedRepository.IsRepositoryAvailable())
    {
      CoreHelper.WriteTraceEntry(TAG, "Closing view because the repository is not Loaded");
      finish();
      return;
    }
    boolean bool1;
    if ((getIntent() != null) && ("advanced".equals(getIntent().getType()))) {
      bool1 = true;
    }
    for (;;)
    {
      this._IsAdvancedPrefs = bool1;
      label82:
      int i;
      if ((getIntent() != null) && ("developer".equals(getIntent().getType())))
      {
        bool1 = bool2;
        this._IsDeveloperPrefs = bool1;
        if ((!this._IsAdvancedPrefs) && (!this._IsDeveloperPrefs)) {
          break label241;
        }
        i = 2131034112;
        addPreferencesFromResource(i);
        paramBundle = getPreferenceScreen().findPreference("DefaultNumberPodcastsToDownload");
        if (paramBundle != null) {
          paramBundle.setOnPreferenceChangeListener(this._SpaceSaversListener);
        }
        paramBundle = getPreferenceScreen().findPreference("DefaultKeepAtMostPodcasts");
        if (paramBundle != null) {
          paramBundle.setOnPreferenceChangeListener(this._SpaceSaversListener);
        }
        if (getIntent() != null)
        {
          i = getIntent().getIntExtra("StartScreen", -1);
          if (i < 0) {}
        }
      }
      try
      {
        if (i < getPreferenceScreen().getPreferenceCount()) {
          getPreferenceScreen().onItemClick(null, null, i, 0L);
        }
        if ((this._IsAdvancedPrefs) || (this._IsDeveloperPrefs))
        {
          i = 2131296471;
          setTitle(i);
          getActionBarHelper().setDisplayOptions(4, 4);
          return;
          bool1 = false;
          continue;
          bool1 = false;
          break label82;
          label241:
          i = 2131034118;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          CoreHelper.LogException(TAG, "Unable to open the preference screen: " + i, paramBundle);
          continue;
          i = 2131296626;
        }
      }
    }
  }
  
  public boolean onMenuItemSelected(int paramInt, final MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
    case 16908332: 
    case 7: 
    case 8: 
    case 9: 
    case 11: 
    case 13: 
    case 12: 
    case 1: 
    case 6: 
    case 3: 
    case 4: 
    case 5: 
    case 10: 
      for (;;)
      {
        return false;
        finish();
        return true;
        CommandManager.CmdClearCaches(this);
        return true;
        paramMenuItem = CoreHelper.DumpEnvironment();
        new AlertDialog.Builder(this).setIcon(17301659).setTitle(ENVIRONMENT_INFO).setMessage(paramMenuItem).setNegativeButton(CLOSE, null).setPositiveButton(E_MAIL_SUPPORT, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            CommandManager.CmdSendEMail(SettingsView.this, "support@beyondpod.mobi", "BeyondPod environment", paramMenuItem, null, true);
          }
        }).create().show();
        return true;
        CommandManager.CmdViewFileContent(Configuration.LogFilePath(), true);
        return true;
        CommandManager.CmdShowUpdateLog(this);
        return true;
        CommandManager.CmdViewFileContent(Configuration.SyncLogFilePath(), true);
        return true;
        new LogcatSnapshotHelper(this, 1000, Configuration.LogcatFilePath(), this).execute(new Boolean[] { Boolean.valueOf(true) });
        return true;
        UserNotificationManager.ResetDefaultPrefs();
        return true;
        CommandManager.CmdShowAdvancedSettings();
        return true;
        CommandManager.CmdOpenWelcomePage(Configuration.WelcomeLiteFileURI(), WELCOME_TO_BEYOND_POD);
        continue;
        CommandManager.CmdOpenWelcomePage(Configuration.WelcomeProFileURI(), WELCOME_TO_BEYOND_POD);
        continue;
        CommandManager.CmdOpenWelcomePage(Configuration.WhatIsNewFileURI(), WHAT_IS_NEW);
        continue;
        ItemStateHistory.PurgeAllGoogleReaderItems();
        ItemStateHistory.SaveHistorySync();
      }
    }
    paramMenuItem = new ProgressDialog(this);
    paramMenuItem.setIndeterminate(true);
    paramMenuItem.setCancelable(false);
    MusicUtils.RebuildMediaDatabase(new MusicUtils.RebuildMediaDatabaseListener()
    {
      public void RebuiltComplete()
      {
        paramMenuItem.dismiss();
      }
      
      public void RebuiltProgress(final String paramAnonymousString)
      {
        SettingsView.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            this.val$dlg.setMessage(paramAnonymousString);
          }
        });
      }
      
      public void RebuiltStarted(ArrayList<File> paramAnonymousArrayList)
      {
        paramMenuItem.show();
      }
    });
    return true;
  }
  
  protected void onPause()
  {
    super.onPause();
    getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    paramMenu.clear();
    if (this._IsDeveloperPrefs)
    {
      paramMenu.add(0, 1, 0, "Reset Notifications");
      paramMenu.add(0, 2, 1, "Rebuild Media Database").setIcon(2130837974);
      if ((ItemStateHistory.GetAllUnsynchronizedGoogleReaderItems().size() == 0) && (ItemStateHistory.HasUnsynchronizedGoogleReaderItems())) {
        paramMenu.add(0, 10, 1, "Flush Orphan Reader Items");
      }
      paramMenu.add(0, 3, 2, "Open 'Welcome' Page");
      paramMenu.add(0, 4, 3, "Open 'Welcome Pro' Page");
      paramMenu.add(0, 5, 4, "Open 'What is New' Page");
    }
    do
    {
      do
      {
        return true;
      } while (this._IsAdvancedPrefs);
      paramMenu.add(0, 6, 1, 2131296877).setIcon(2130837972);
      paramMenu.add(0, 7, 2, 2131296689);
      paramMenu = paramMenu.addSubMenu(0, 0, 3, 2131296698);
      paramMenu.add(0, 8, 1, 2131296695);
      paramMenu.add(0, 11, 2, 2131296680);
      paramMenu.add(0, 9, 3, 2131296696);
      if (CoreHelper.ApiLevel() > 15) {
        paramMenu.add(0, 12, 4, 2131296697);
      }
    } while (!ChangeTracker.IsSyncLicenseValid());
    paramMenu.add(0, 13, 5, 2131297236);
    return true;
  }
  
  protected void onResume()
  {
    super.onResume();
    Object localObject = getPreferenceScreen();
    ((PreferenceScreen)localObject).getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    Preference localPreference = ((PreferenceScreen)localObject).findPreference("ScheduledUpdatesPreference");
    if (localPreference != null) {
      ((ScheduledUpdatesPreference)localPreference).Refresh();
    }
    localPreference = ((PreferenceScreen)localObject).findPreference("BackupRestore");
    if (localPreference != null) {
      ((BackupRestorePreference)localPreference).Refresh();
    }
    localPreference = ((PreferenceScreen)localObject).findPreference(CrossDeviceSyncPreference.PREFERENCE_KEY);
    if (localPreference != null) {
      ((CrossDeviceSyncPreference)localPreference).Refresh();
    }
    localPreference = ((PreferenceScreen)localObject).findPreference("CustomSDCardLocation");
    if (localPreference != null) {
      ((DownloadFolderPreference)localPreference).Refresh();
    }
    localPreference = ((PreferenceScreen)localObject).findPreference("PreferLastSDCardRoot");
    if (localPreference != null) {
      localPreference.setSummary(getResources().getString(2131296464) + " " + CoreHelper.ExternalStorageDirectory());
    }
    if ((!AggregatorLoginHelper.IsLoggedIn()) && (AggregatorLoginHelper.getAllAggregatorFeeds().size() == 0))
    {
      localObject = ((PreferenceScreen)localObject).findPreference("DisconnectAggregatorFeeds");
      if (localObject != null) {
        ((Preference)localObject).setEnabled(false);
      }
    }
    if (MoveFilesDialog._isRunning) {
      CommandManager.StartActivity(new Intent(BeyondPodApplication.GetInstance(), MoveFilesDialog.class));
    }
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    if ((paramString.equals("EnableHeadsetButton")) && (BeyondPodApplication.GetInstance().PlayList().PlaylistSize() > 0))
    {
      MediaButtonIntentReceiver.StopListeningForMediaButton();
      MediaButtonIntentReceiver.StartListeningForMediaButton();
    }
    File localFile;
    if (paramString.equals("SharePodcasts"))
    {
      boolean bool = paramSharedPreferences.getBoolean(paramString, false);
      localFile = new File(Configuration.EnclosureDownloadRoot(), ".nomedia");
      if (!bool) {
        break label350;
      }
      if (localFile.exists()) {
        localFile.delete();
      }
    }
    for (;;)
    {
      if (paramString.equals("CurrentTheme")) {
        Toast.makeText(this, 2131296588, 1).show();
      }
      if (paramString.equals("PreventKeyguard")) {
        Toast.makeText(this, 2131296590, 1).show();
      }
      if (paramString.equals("OrientationLock")) {
        Toast.makeText(this, 2131296589, 1).show();
      }
      if ((paramString.equals("DefaultNumberPodcastsToDownload")) || (paramString.equals("DefaultKeepAtMostPodcasts")) || (paramString.equals("DefaultMaximumPodcastAge")) || (paramString.equals("DefaultPodcastDownloadAction"))) {
        AskToApplySettings(paramString);
      }
      if ((paramString.equals("ForceMediaDtabaseRescanOnDownloadOrDelete")) && (paramSharedPreferences.getBoolean(paramString, false))) {
        MusicUtils.ForceMediaScanFor(FeedRepository.getRootPath());
      }
      if ((paramString.equals("WidgetBackgroundColor")) || (paramString.equals("WidgetSecondaryButtonAction"))) {
        BeyondPodApplication.MessageBus.PublishEvent(new PlayListEvents.PlayListEvent(BeyondPodApplication.GetInstance().PlayList(), 0));
      }
      if (paramString.equals("PlayerSupportedFileExtensions")) {
        Track.ReloadSupportedFileTypes();
      }
      paramString.equals("ShowPodcastThumbnails");
      if ((paramString.equals("ShowCDSSettings")) && (paramSharedPreferences.getBoolean(paramString, false))) {
        new AlertDialog.Builder(this).setTitle(2131297242).setMessage(2131297243).setNegativeButton(2131296759, null).setCancelable(true).show();
      }
      if ((paramString.equals("AutoPlaylistEnabled")) && (paramSharedPreferences.getBoolean(paramString, false))) {
        UserNotificationManager.setNotificationPreferenceFor(21, true);
      }
      BackupHelper.getInstance().RequestBackup();
      return;
      label350:
      if (!localFile.exists()) {
        CoreHelper.CopyResToFile(2131099650, localFile);
      }
      new AlertDialog.Builder(this).setTitle(2131296714).setMessage(2131296591).show();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/settings/SettingsView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */