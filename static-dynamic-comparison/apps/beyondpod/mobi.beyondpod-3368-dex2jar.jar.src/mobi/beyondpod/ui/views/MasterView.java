package mobi.beyondpod.ui.views;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;
import com.google.android.gcm.GCMRegistrar;
import java.io.File;
import java.util.Date;
import java.util.UUID;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.downloadengine.DownloadEngineNotificationManager;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.categories.FeedCategories;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.AnalyticsTracker;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEvent;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEventListener;
import mobi.beyondpod.rsscore.rss.ItemStateHistory;
import mobi.beyondpod.rsscore.rss.LicenseManager;
import mobi.beyondpod.schedulercore.ScheduledTasksManager;
import mobi.beyondpod.services.player.MediaButtonIntentReceiver;
import mobi.beyondpod.services.player.PlayList;
import mobi.beyondpod.services.player.PlayListEvents.PlayListEvent;
import mobi.beyondpod.services.player.PlayListEvents.PlayListEventListener;
import mobi.beyondpod.services.player.impl.ChromecastDevice;
import mobi.beyondpod.sync.ChangeTracker;
import mobi.beyondpod.sync.TrackedChangeBase;
import mobi.beyondpod.sync.trackers.bp.BPTracker;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.core.ActionBarHelper;
import mobi.beyondpod.ui.core.SimpleMenu;
import mobi.beyondpod.ui.core.ThemeManager;
import mobi.beyondpod.ui.core.mediarouter.MediaRouteDiscoveryFragment;
import mobi.beyondpod.ui.core.mediarouter.MediaRouteDiscoveryFragment.IDiscoveryFragmentOwner;
import mobi.beyondpod.ui.search.RepositorySearchProvider;
import mobi.beyondpod.ui.views.base.ActionModeBP;
import mobi.beyondpod.ui.views.base.ActionModeBP.Callback;
import mobi.beyondpod.ui.views.base.IView;
import mobi.beyondpod.ui.views.base.TitleBarActionMode;
import mobi.beyondpod.ui.views.base.TitleBarBase.TitleInfo;
import mobi.beyondpod.ui.views.base.TitleBarMasterView;
import mobi.beyondpod.ui.views.feedsettings.FeedPropertiesView;

public class MasterView
  extends FragmentActivity
  implements PlayerView.IPlayerOwner, MediaRouteDiscoveryFragment.IDiscoveryFragmentOwner
{
  private static final String BEYOND_POD_FAILED_TO_START = CoreHelper.LoadResourceString(2131296996);
  private static final String BEYOND_POD_WILL_NOW_EXIT;
  private static final String LAST_QUICK_PLAY_INTENT = "#LAST_QUICK_PLAY_INTENT#";
  private static final String LOADED_S_FEEDS = CoreHelper.LoadResourceString(2131296997);
  private static final String LOADING_FEEDS = CoreHelper.LoadResourceString(2131296998);
  private static final String TAG = MasterView.class.getSimpleName();
  private static final String THIS_FEED_ALREADY_EXISTS_IN_CATEGORY = CoreHelper.LoadResourceString(2131297042);
  private static final String WELCOME_TO_BEYOND_POD;
  private static final String WHAT_IS_NEW = CoreHelper.LoadResourceString(2131296993);
  private static int _InstanceCount;
  private static Uri _LastAddFeedUri;
  public Workspace Workspace;
  Handler _Handler;
  private Intent _LastQuickPlayIntent;
  private final PlayListEvents.PlayListEventListener _PlaylistListener = new PlayListEvents.PlayListEventListener()
  {
    public void OnPlayListEvent(PlayListEvents.PlayListEvent paramAnonymousPlayListEvent)
    {
      MasterView.this.RefreshActiveViewTitle();
      if ((MasterView.this.Workspace.Player != null) && (!MasterView.this.Workspace.Player.IsActive())) {
        MasterView.this.Workspace.Player.OnPlayListEvent(paramAnonymousPlayListEvent);
      }
    }
  };
  AsyncTask<Void, Void, Void> _RegisterTask;
  private final RepositoryEvents.RepositoryEventListener _RepositoryListener = new RepositoryEvents.RepositoryEventListener()
  {
    public void OnRepositoryEvent(final RepositoryEvents.RepositoryEvent paramAnonymousRepositoryEvent)
    {
      MasterView.this.runOnUiThread(new Runnable()
      {
        public void run()
        {
          TitleBarBase.TitleInfo localTitleInfo = new TitleBarBase.TitleInfo();
          if (paramAnonymousRepositoryEvent.Type == 0)
          {
            localTitleInfo.PrimaryTitle = MasterView.LOADING_FEEDS;
            MasterView.this.SetMasterViewTitle(localTitleInfo);
            MasterView.this.ToggleTittleIndeterminateProgress(true);
          }
          do
          {
            do
            {
              return;
              if (paramAnonymousRepositoryEvent.Type != 1) {
                break;
              }
              localTitleInfo.PrimaryTitle = String.format(MasterView.LOADED_S_FEEDS, new Object[] { Integer.valueOf(FeedRepository.GetFeedCount()) });
              MasterView.this.SetMasterViewTitle(localTitleInfo);
              MasterView.this.ToggleTittleIndeterminateProgress(true);
            } while (mobi.beyondpod.rsscore.Configuration.StartupView() != 0);
            MasterView.this.FinishInitialization();
            return;
          } while (paramAnonymousRepositoryEvent.Type != 2);
          MasterView.this.FinishInitialization();
          MasterView.this.ToggleTittleIndeterminateProgress(false);
          MasterView.this.RefreshActiveViewTitle();
          MasterView.this.Workspace.Podcasts.PrimeView();
          MasterView.this.StartPlaybackFromSearchIfNeeded(MasterView.this.getIntent());
        }
      });
    }
  };
  private Intent _SavedIntent;
  private TitleBarMasterView _Title;
  private TitleBarActionMode _TitleActionMode;
  Toast _Toast;
  boolean _WarnedForExit = false;
  
  static
  {
    WELCOME_TO_BEYOND_POD = CoreHelper.LoadResourceString(2131296994);
    BEYOND_POD_WILL_NOW_EXIT = CoreHelper.LoadResourceString(2131296995);
  }
  
  private void CaptureNavigationHistory() {}
  
  private void FinishInitialization()
  {
    if (this.Workspace.DataIsLoadedInWorkspaceViews) {
      return;
    }
    Workspace localWorkspace = this.Workspace;
    int i;
    if (ShouldOpenPlayerViewBasedOnIntentSource(getIntent()))
    {
      i = 2;
      localWorkspace.LoadDataInWorkspaceViews(i);
      if (!mobi.beyondpod.rsscore.Configuration.IsFirstRun()) {
        break label92;
      }
      CommandManager.CmdOpenWelcomePage(mobi.beyondpod.rsscore.Configuration.WelcomeFileURI(), WELCOME_TO_BEYOND_POD);
      mobi.beyondpod.rsscore.Configuration.ClearIsFirstRun();
      mobi.beyondpod.rsscore.Configuration.WriteLastInstalledVersionCode();
      label55:
      ScheduledTasksManager.RescheduleAllActiveTasksIfNeeded();
      if (!LicenseManager.IsUnlocked()) {
        break label167;
      }
      AnalyticsTracker.OnApplicationStartedUnlocked(LicenseManager.GetLicenseTypeString(false));
    }
    for (;;)
    {
      ShowStartupWarningsIfNeeded();
      NavigateToViewBasedOnIntentSource(getIntent(), false);
      return;
      i = mobi.beyondpod.rsscore.Configuration.StartupView();
      break;
      label92:
      if (mobi.beyondpod.rsscore.Configuration.CurrentProductVersionCode() == mobi.beyondpod.rsscore.Configuration.GetLastInstalledVesionCode()) {
        break label55;
      }
      CoreHelper.WriteTraceEntry(TAG, "##### Detected product version change from " + mobi.beyondpod.rsscore.Configuration.GetLastInstalledVesionCode() + " to " + mobi.beyondpod.rsscore.Configuration.CurrentProductVersionCode());
      BeyondPodApplication.GetInstance().ConfigureDefaultsForVersionUpgrade(mobi.beyondpod.rsscore.Configuration.GetLastInstalledVesionCode(), mobi.beyondpod.rsscore.Configuration.CurrentProductVersionCode());
      CommandManager.CmdOpenWelcomePage(mobi.beyondpod.rsscore.Configuration.WhatIsNewFileURI(), WHAT_IS_NEW);
      mobi.beyondpod.rsscore.Configuration.WriteLastInstalledVersionCode();
      ScheduledTasksManager.RescheduleAllActiveTasks();
      break label55;
      label167:
      AnalyticsTracker.OnApplicationStartedLocked();
    }
  }
  
  private void ForwardToSpalshScreenOnNoStorageCard()
  {
    CoreHelper.WriteTraceEntry(TAG, "Master View started with no storage card. Exiting...");
    startActivity(new Intent(getApplicationContext(), Splash.class));
    finish();
  }
  
  public static MasterView Master()
  {
    Activity localActivity = BeyondPodApplication.GetInstance().MasterActivity();
    if (localActivity == null) {
      return null;
    }
    return (MasterView)localActivity;
  }
  
  private void NavigateToViewBasedOnIntentSource(Intent paramIntent, boolean paramBoolean)
  {
    CoreHelper.WriteTraceEntry(TAG, "BeyondPod Received intent: " + paramIntent + ", flags:" + paramIntent.getFlags());
    DownloadEngineNotificationManager.ClearNotification();
    if ((paramBoolean) && (ShouldOpenPlayerViewBasedOnIntentSource(paramIntent))) {
      ActivatePlayer();
    }
    do
    {
      return;
      if ((paramIntent != null) && (paramIntent.getData() != null) && ("mobi.beyondpod.ui.views.PlaylistEditorActivity".equals(paramIntent.getData().getPath())))
      {
        CommandManager.CmdOpenManagePlaylistView(false);
        return;
      }
    } while ((StartPlaybackFromSearchIfNeeded(paramIntent)) || (OpenSearchResult(paramIntent)));
    OpenAddFeedActivityIfNeeded(paramIntent);
  }
  
  private void OpenAddFeedActivityIfNeeded(Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    final Object localObject1;
    for (;;)
    {
      return;
      Object localObject2 = null;
      if ("android.intent.action.PICK".equals(paramIntent.getAction()))
      {
        if ((paramIntent.getData() != null) && (StringUtils.EqualsIgnoreCase("file", paramIntent.getData().getScheme())) && (!paramIntent.getData().equals(_LastAddFeedUri)))
        {
          localObject1 = new File(paramIntent.getData().getPath());
          if ((((File)localObject1).exists()) && (((File)localObject1).getName().toLowerCase().endsWith("opml")))
          {
            _LastAddFeedUri = paramIntent.getData();
            CommandManager.CmdOpenOpmlImporter((File)localObject1);
          }
        }
      }
      else
      {
        if ("android.intent.action.SEND".equals(paramIntent.getAction()))
        {
          paramIntent = paramIntent.getCharSequenceExtra("android.intent.extra.TEXT");
          localObject1 = localObject2;
          if (paramIntent != null) {
            localObject1 = Uri.parse(paramIntent.toString());
          }
        }
        while ((CoreHelper.IsPodcastOrFeedUrl((Uri)localObject1)) && (!((Uri)localObject1).equals(_LastAddFeedUri)))
        {
          paramIntent = FeedRepository.GetFeedByUrl(((Uri)localObject1).toString());
          if (paramIntent == null) {
            break label270;
          }
          ShowToast(String.format(THIS_FEED_ALREADY_EXISTS_IN_CATEGORY, new Object[] { paramIntent.getCategories().getPrimary().Name() }), 1);
          return;
          localObject1 = localObject2;
          if (paramIntent.getData() != null)
          {
            paramIntent = "http:" + paramIntent.getData().getEncodedSchemeSpecificPart();
            localObject1 = localObject2;
            if (!StringUtils.IsNullOrEmpty(paramIntent)) {
              localObject1 = Uri.parse(CoreHelper.SafeDecodeUrl(paramIntent.replaceAll("\\\\x", "%")));
            }
          }
        }
      }
    }
    label270:
    _LastAddFeedUri = (Uri)localObject1;
    ToggleTittleIndeterminateProgress(true);
    this._Handler.postDelayed(new Runnable()
    {
      public void run()
      {
        Intent localIntent = new Intent(MasterView.this, FeedPropertiesView.class);
        localIntent.setData(localObject1);
        MasterView.this.startActivity(localIntent);
        MasterView.this.ToggleTittleIndeterminateProgress(false);
      }
    }, 1000L);
  }
  
  private boolean OpenSearchResult(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if ("android.intent.action.SEARCH".equals(paramIntent.getAction()))
      {
        CommandManager.CmdOpenFeedSearch(paramIntent.getStringExtra("query"));
        return true;
      }
      if ((paramIntent.getData() != null) && (paramIntent.getData().getPath() != null))
      {
        paramIntent = paramIntent.getData().getPath().toString();
        Object localObject = RepositorySearchProvider.PATH + "/";
        if (paramIntent.startsWith((String)localObject))
        {
          paramIntent = paramIntent.substring(((String)localObject).length());
          if (!StringUtils.IsNullOrEmpty(paramIntent))
          {
            if (paramIntent.startsWith("/"))
            {
              localObject = FeedRepository.GetTrackByPath(paramIntent);
              if (localObject != null)
              {
                CommandManager.CmdOpenTrackPropertiesDialog((Track)localObject);
                return true;
              }
            }
            try
            {
              paramIntent = FeedRepository.GetFeedById(UUID.fromString(paramIntent));
              if (paramIntent != null)
              {
                CommandManager.CmdOpenFeed(paramIntent);
                return true;
              }
            }
            catch (Exception paramIntent) {}
          }
        }
      }
    }
    return false;
  }
  
  private boolean ShouldOpenPlayerViewBasedOnIntentSource(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getData() != null))
    {
      if ("mobi.beyondpod.services.player.LockScreenWakeUp".equals(paramIntent.getData().getPath())) {}
      while ((("mobi.beyondpod.ui.dialogs.WidgetActionPicker".equals(paramIntent.getData().getPath())) || ("mobi.beyondpod.services.player.MediaPlaybackService".equals(paramIntent.getData().getPath()))) && (BeyondPodApplication.GetInstance().PlayList().CurrentTrack() != null) && (BeyondPodApplication.GetInstance().PlayList().CurrentTrack().getCurrentPlayState() == 1)) {
        return true;
      }
    }
    return false;
  }
  
  private void ShowStartupWarningsIfNeeded()
  {
    if (FeedRepository.RepositoryLoadKind == 0) {
      FeedRepository.RepositoryLoadKind = 1;
    }
    Date localDate;
    do
    {
      this._Handler.postDelayed(new Runnable()
      {
        public void run()
        {
          CommandManager.CmdShowRestoreDefaultsDialog(MasterView.this);
        }
      }, 2000L);
      do
      {
        return;
      } while (LicenseManager.IsUnlocked());
      localDate = new Date();
    } while ((mobi.beyondpod.rsscore.Configuration.IsExpirationWarningShownInThisSession()) || (localDate.compareTo(LicenseManager.TrialExpirationWarningDate()) <= 0));
    this._Handler.postDelayed(new Runnable()
    {
      public void run()
      {
        if (!LicenseManager.IfInRestrictedMode())
        {
          MasterView.this.ShowToast(2131296898, 1);
          mobi.beyondpod.rsscore.Configuration.setExpirationWarningShownInThisSession();
        }
      }
    }, 2000L);
  }
  
  private boolean StartPlaybackFromSearchIfNeeded(Intent paramIntent)
  {
    if ((paramIntent.getFlags() & 0x100000) != 0) {}
    do
    {
      return false;
      if (this._LastQuickPlayIntent != null)
      {
        CoreHelper.WriteTraceEntry(TAG, "Found a repeating QuickPlay intent. Ignoring...");
        return false;
      }
      if (this._SavedIntent != null)
      {
        CoreHelper.WriteTraceEntry(TAG, "QuickPlay saved intent found. Executing Play from Search...");
        paramIntent = this._SavedIntent;
      }
    } while (!"android.media.action.MEDIA_PLAY_FROM_SEARCH".equals(paramIntent.getAction()));
    if (FeedRepository.RepositoryLoadState() == 2)
    {
      String str = paramIntent.getStringExtra("query");
      if (!CommandManager.CmdPlayFromVoiceSearch(str)) {
        ShowToast(getResources().getString(2131297203, new Object[] { str }), 1);
      }
      for (;;)
      {
        setIntent(new Intent());
        this._SavedIntent = null;
        this._LastQuickPlayIntent = paramIntent;
        return true;
        ActivatePlayer();
      }
    }
    CoreHelper.WriteTraceEntry(TAG, "QuickPlay intent received but repository was not loaded! Will retry when repo loads...");
    this._SavedIntent = paramIntent;
    return false;
  }
  
  private void UpdateGCMRegistration()
  {
    if (!BeyondPodApplication.GetInstance().IsGCMSupportedOnDevice()) {}
    final String str;
    do
    {
      do
      {
        return;
      } while (!ChangeTracker.IsTrackingEnabled());
      str = GCMRegistrar.getRegistrationId(this);
      if (StringUtils.IsNullOrEmpty(str))
      {
        TrackedChangeBase.LogSyncEvent(TAG, "--- Found that CDS is enabled but the device is not registered with the CDS server! Registering...", null);
        GCMRegistrar.register(this, new String[] { mobi.beyondpod.rsscore.Configuration.GCMSenderID() });
        return;
      }
    } while (GCMRegistrar.isRegisteredOnServer(this));
    this._RegisterTask = new AsyncTask()
    {
      protected Void doInBackground(Void... paramAnonymousVarArgs)
      {
        try
        {
          paramAnonymousVarArgs = new BPTracker();
          paramAnonymousVarArgs.Initialize();
          if (!paramAnonymousVarArgs.UpdateServerCDMRegistration(jdField_this, str, true)) {
            GCMRegistrar.unregister(jdField_this);
          }
          return null;
        }
        catch (Exception paramAnonymousVarArgs)
        {
          TrackedChangeBase.LogSyncEvent(MasterView.TAG, "--- Failed to add CDS registration! Reason: " + paramAnonymousVarArgs.getMessage(), null);
        }
        return null;
      }
      
      protected void onPostExecute(Void paramAnonymousVoid)
      {
        MasterView.this._RegisterTask = null;
      }
    };
    TrackedChangeBase.LogSyncEvent(TAG, "--- Found local CDS registration, but not server one. Updating server...", null);
    this._RegisterTask.execute(new Void[] { null, null, null });
  }
  
  public void ActivatePlayer()
  {
    this.Workspace.ActivateView(4);
  }
  
  public ViewGroup ContentRoot()
  {
    return (ViewGroup)this.Workspace.getRootView();
  }
  
  public void LockCurrentScreenOrientation()
  {
    if (getResources().getConfiguration().orientation == 1)
    {
      setRequestedOrientation(1);
      return;
    }
    setRequestedOrientation(0);
  }
  
  public void OpenDialog(int paramInt)
  {
    showDialog(paramInt);
  }
  
  public void RefreshActiveViewTitle()
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (MasterView.this.Workspace.ActiveView() == null) {
          return;
        }
        if (mobi.beyondpod.rsscore.Configuration.EnableLoggingInProduction())
        {
          ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
          ((ActivityManager)MasterView.this.getSystemService("activity")).getMemoryInfo(localMemoryInfo);
          if (localMemoryInfo.availMem < localMemoryInfo.threshold) {
            CoreHelper.WriteTraceEntry(MasterView.TAG, "Available memory is under the threshold! Avaialble: " + localMemoryInfo.availMem / 1024L + "K, Threshold: " + localMemoryInfo.threshold / 1024L + "K");
          }
          TitleBarBase.TitleInfo localTitleInfo = MasterView.this.Workspace.ActiveView().GetViewTitle();
          localTitleInfo.DebugText = (localMemoryInfo.availMem / 1024000L + "M");
          localTitleInfo.InfoText = DateTime.FormatTime(mobi.beyondpod.rsscore.Configuration.getLastUpdateAndDownloadManagerRunTime());
          MasterView.this.SetMasterViewTitle(localTitleInfo);
        }
        for (;;)
        {
          MasterView.this.CaptureNavigationHistory();
          return;
          MasterView.this.SetMasterViewTitle(MasterView.this.Workspace.ActiveView().GetViewTitle());
        }
      }
    });
  }
  
  public void RestoreCurrentScreenOrientation()
  {
    if (mobi.beyondpod.rsscore.Configuration.OrientationLock() == 2)
    {
      setRequestedOrientation(0);
      return;
    }
    if (mobi.beyondpod.rsscore.Configuration.OrientationLock() == 1)
    {
      setRequestedOrientation(1);
      return;
    }
    setRequestedOrientation(-1);
  }
  
  public void SetMasterViewTitle(final TitleBarBase.TitleInfo paramTitleInfo)
  {
    if (this._Title != null) {
      runOnUiThread(new Runnable()
      {
        public void run()
        {
          MasterView.this._Title.setTitle(paramTitleInfo);
        }
      });
    }
  }
  
  public void ShowToast(final int paramInt1, final int paramInt2)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        Toast.makeText(MasterView.this, paramInt1, paramInt2).show();
      }
    });
  }
  
  public void ShowToast(final CharSequence paramCharSequence, final int paramInt)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (MasterView.this._Toast != null) {
          MasterView.this._Toast.cancel();
        }
        MasterView.this._Toast = Toast.makeText(MasterView.this, paramCharSequence, paramInt);
        MasterView.this._Toast.show();
      }
    });
  }
  
  public void ToggleTittleIndeterminateProgress(final boolean paramBoolean)
  {
    if (this._Title != null) {
      runOnUiThread(new Runnable()
      {
        public void run()
        {
          MasterView.this._Title.ToggleTittleIndeterminateProgress(paramBoolean);
        }
      });
    }
  }
  
  public void Vibrate()
  {
    ((Vibrator)getSystemService("vibrator")).vibrate(30L);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int i = paramKeyEvent.getAction();
    switch (paramKeyEvent.getKeyCode())
    {
    default: 
      return super.dispatchKeyEvent(paramKeyEvent);
    case 24: 
      if (i == 0) {
        return BeyondPodApplication.GetInstance().ChromecastDevice().adjustVolume(1);
      }
      break;
    case 25: 
      if (i == 0) {
        return BeyondPodApplication.GetInstance().ChromecastDevice().adjustVolume(-1);
      }
      break;
    }
    return false;
  }
  
  protected void finalize()
    throws Throwable
  {
    if (CoreHelper.IsDebugBuild())
    {
      _InstanceCount -= 1;
      CoreHelper.WriteTraceEntryInDebug(TAG, "###### MasterView FINALIZED! Remaining instances: " + _InstanceCount);
    }
    super.finalize();
  }
  
  public void onConnectedToDevice(String paramString)
  {
    if (PlayList.IsEmpty())
    {
      Toast.makeText(this, getResources().getString(2131297088, new Object[] { paramString }), 1).show();
      return;
    }
    Toast.makeText(this, getResources().getString(2131297089, new Object[] { paramString }), 1).show();
    ActivatePlayer();
  }
  
  public void onConnectionRefused()
  {
    Toast.makeText(this, 2131297091, 1).show();
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return this.Workspace.ActiveView().HandleContextMenu(paramMenuItem);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    try
    {
      _InstanceCount += 1;
      CoreHelper.WriteTraceEntryInDebug(TAG, "###### MasterView Created! Current instances: " + _InstanceCount);
      if (_InstanceCount > 1) {
        CoreHelper.WriteTraceErrorInDebug(TAG, "################## Possible MasterView Leak ############ " + _InstanceCount);
      }
      str = TAG;
      localStringBuilder = new StringBuilder("Master View Created! ");
      if (paramBundle == null) {
        break label469;
      }
      localObject = " (restoring)";
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        String str;
        StringBuilder localStringBuilder;
        CoreHelper.LogException(TAG, "Exception loading the Workspace!", paramBundle);
        if (BeyondPodApplication.LastApplicationException != null) {}
        for (paramBundle = BeyondPodApplication.LastApplicationException;; paramBundle = paramBundle.getMessage())
        {
          Toast.makeText(this, BEYOND_POD_FAILED_TO_START + "\n\n" + paramBundle + "\n\n" + BEYOND_POD_WILL_NOW_EXIT, 1).show();
          finish();
          return;
          if (mobi.beyondpod.rsscore.Configuration.OrientationLock() != 1) {
            break;
          }
          setRequestedOrientation(1);
          break;
        }
        label469:
        Object localObject = " (new)";
      }
    }
    CoreHelper.WriteTraceEntry(str, (String)localObject);
    if (ThemeManager.CurrentTheme() != -1) {
      setTheme(ThemeManager.CurrentTheme());
    }
    super.onCreate(paramBundle);
    BeyondPodApplication.GetInstance().setMasterActivity(this);
    if (!BeyondPodApplication.IsInitialized())
    {
      ForwardToSpalshScreenOnNoStorageCard();
      return;
    }
    if (mobi.beyondpod.rsscore.Configuration.OrientationLock() == 2)
    {
      setRequestedOrientation(0);
      requestWindowFeature(7);
      if (mobi.beyondpod.rsscore.Configuration.PreventKeyguard()) {
        getWindow().addFlags(0x80000 | 0x100000);
      }
      BeyondPodApplication.MessageBus.Subscribe(this._RepositoryListener, RepositoryEvents.RepositoryEvent.class);
      BeyondPodApplication.MessageBus.Subscribe(this._PlaylistListener, PlayListEvents.PlayListEvent.class);
      this._Handler = new Handler();
      setContentView(2130903133);
      getWindow().setFeatureInt(7, 2130903080);
      this.Workspace = ((Workspace)findViewById(2131230975));
      this.Workspace.Initialize(null, paramBundle);
      this._Title = ((TitleBarMasterView)findViewById(2131230862));
      this._Title.Initialize(this.Workspace);
      this._TitleActionMode = ((TitleBarActionMode)findViewById(2131230804));
      this._TitleActionMode.Initialize();
      if (FeedRepository.IsRepositoryAvailable()) {
        FinishInitialization();
      }
      paramBundle = getSupportFragmentManager();
      if (paramBundle.findFragmentByTag("DiscoveryFragment") == null)
      {
        localObject = new MediaRouteDiscoveryFragment();
        ((MediaRouteDiscoveryFragment)localObject).setOwner(this);
        ((MediaRouteDiscoveryFragment)localObject).setRouteSelector(BeyondPodApplication.GetInstance().ChromecastDevice().getRouteSelector());
        paramBundle.beginTransaction().add((Fragment)localObject, "DiscoveryFragment").commit();
      }
      UpdateGCMRegistration();
      return;
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if (this.Workspace.ActiveView() != null) {
      this.Workspace.ActiveView().PrepareContextMenu(paramContextMenu, paramContextMenuInfo);
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public void onDestroy()
  {
    CoreHelper.WriteTraceEntry(TAG, "MasterView OnDestroy");
    FeedRepository.SaveRepositoryAsync();
    BeyondPodApplication.MessageBus.Unsubscribe(this._RepositoryListener, RepositoryEvents.RepositoryEvent.class);
    BeyondPodApplication.MessageBus.Unsubscribe(this._PlaylistListener, PlayListEvents.PlayListEvent.class);
    BeyondPodApplication.GetInstance().setMasterActivity(null);
    if (this.Workspace != null) {
      this.Workspace.OnMasterViewDestroy();
    }
    if (this._RegisterTask != null) {
      this._RegisterTask.cancel(true);
    }
    GCMRegistrar.onDestroy(getApplicationContext());
    super.onDestroy();
  }
  
  public void onDisconnectFromDevice() {}
  
  public void onIncompatiblePlayServices()
  {
    ChromecastDevice.checkGooglePlaySevices(this, true);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this._TitleActionMode.isActive()) {
        this._TitleActionMode.finishMultiselect();
      }
      do
      {
        return true;
        if ((this.Workspace.ActiveViewIndex() == 4) && (this.Workspace.Player != null) && (this.Workspace.Player.IsPlaylistVisible()))
        {
          this.Workspace.Player.TogglePlaylist(false);
          return true;
        }
      } while (this.Workspace.GoToHomeView());
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (!this.Workspace.ActiveView().HandleOptionsMenu(paramInt, paramMenuItem)) {
      return super.onMenuItemSelected(paramInt, paramMenuItem);
    }
    return true;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if ("android.media.action.MEDIA_PLAY_FROM_SEARCH".equals(paramIntent.getAction()))
    {
      CoreHelper.WriteTraceEntry(TAG, "Received new QuickPlay intent! Query:" + paramIntent.getStringExtra("query"));
      this._LastQuickPlayIntent = null;
    }
    NavigateToViewBasedOnIntentSource(paramIntent, true);
  }
  
  protected void onPause()
  {
    CoreHelper.WriteTraceEntry(TAG, "MasterView OnPause");
    if (this.Workspace.ActiveView() != null) {
      this.Workspace.ActiveView().OnAfterDeactivate(false);
    }
    if (this._Title != null) {
      this._Title.onPause();
    }
    super.onPause();
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    if (FeedRepository.IsRepositoryAvailable())
    {
      FinishInitialization();
      return;
    }
    CoreHelper.WriteTraceEntry(TAG, "OnPostResume found that repository is not loaded! (repo state is: " + FeedRepository.RepositoryLoadState() + ") Loading repository...");
    FeedRepository.InitializeAndLoadRepository();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (this.Workspace.ActiveView() == null) {
      return false;
    }
    if (ActionBarHelper.HasPermanentMenuKey()) {
      return this.Workspace.ActiveView().PrepareOptionsMenu(paramMenu);
    }
    paramMenu = this.Workspace.ActiveView().PreparePopupOptionsMenu();
    if (paramMenu != null) {
      paramMenu.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
      {
        public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          MasterView.this.Workspace.ActiveView().HandleOptionsMenu(0, paramAnonymousMenuItem);
          return false;
        }
      });
    }
    paramMenu.showAsPopupMenu();
    return false;
  }
  
  protected void onRestart()
  {
    CoreHelper.WriteTraceEntry(TAG, "MasterView OnRestart");
    super.onRestart();
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if (paramBundle.containsKey("#LAST_QUICK_PLAY_INTENT#"))
    {
      this._LastQuickPlayIntent = ((Intent)paramBundle.getParcelable("#LAST_QUICK_PLAY_INTENT#"));
      if (this._LastQuickPlayIntent != null) {
        CoreHelper.WriteTraceEntry(TAG, "Restoring QuickPlay intent! Query:" + this._LastQuickPlayIntent.getStringExtra("query"));
      }
    }
    CoreHelper.WriteTraceEntry(TAG, "MasterView RestoreInstanceState");
  }
  
  protected void onResume()
  {
    super.onResume();
    CoreHelper.WriteTraceEntry(TAG, "MasterView OnResume");
    if (Master() == null) {
      BeyondPodApplication.GetInstance().setMasterActivity(this);
    }
    if ((this.Workspace.ActiveView() != null) && (!this.Workspace.ActiveView().IsActive()))
    {
      this.Workspace.ActiveView().OnBeforeActivate();
      this.Workspace.ActiveView().OnAfterActivate();
    }
    MediaButtonIntentReceiver.StartListeningForMediaButton();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    CoreHelper.WriteTraceEntry(TAG, "MasterView SaveInstanceState");
    this.Workspace.SaveCurrentStateToBundle(paramBundle);
    if (this._LastQuickPlayIntent != null)
    {
      CoreHelper.WriteTraceEntry(TAG, "Saving Last QuickPlay intent! Query:" + this._LastQuickPlayIntent.getStringExtra("query"));
      paramBundle.putParcelable("#LAST_QUICK_PLAY_INTENT#", this._LastQuickPlayIntent);
    }
    if (getChangingConfigurations() == 0)
    {
      ItemStateHistory.SaveHistoryAsync();
      FeedRepository.SaveRepositoryAsync();
    }
  }
  
  public void onStart()
  {
    CoreHelper.WriteTraceEntry(TAG, "MasterView OnStart");
    super.onStart();
    AnalyticsTracker.StartSession(this);
    DownloadEngineNotificationManager.ClearNotification();
  }
  
  public void onStop()
  {
    CoreHelper.WriteTraceEntry(TAG, "MasterView OnStop");
    AnalyticsTracker.EndSession(this);
    ItemStateHistory.SaveHistoryAsync();
    super.onStop();
  }
  
  public ActionModeBP startMultiselect(ActionModeBP.Callback paramCallback)
  {
    if (paramCallback == null) {
      return null;
    }
    return this._TitleActionMode.startMultiselect(paramCallback);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/MasterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */