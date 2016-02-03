package mobi.beyondpod;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Notification;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.provider.Settings.System;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.google.android.gcm.GCMRegistrar;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import mobi.beyondpod.downloadengine.DownloadEngineNotificationManager;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.StartupContentBuilder.Content;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.AnalyticsTracker;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.CoreHelper.DeviceNetworkConnection;
import mobi.beyondpod.rsscore.helpers.NotificationHelper;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.services.download.DownloadHolderService;
import mobi.beyondpod.services.player.MediaButtonIntentReceiver;
import mobi.beyondpod.services.player.MediaPlaybackService;
import mobi.beyondpod.services.player.PlayList;
import mobi.beyondpod.services.player.PlayListEvents.PlayListEvent;
import mobi.beyondpod.services.player.PlayListEvents.PlayListEventListener;
import mobi.beyondpod.services.player.impl.ChromecastDevice;
import mobi.beyondpod.ui.core.MovieViewCounter;

public abstract class BeyondPodApplication
  extends Application
  implements Thread.UncaughtExceptionHandler
{
  public static int BatteryLevel = 0;
  public static int BatteryPlugged = 0;
  public static int BatteryStatus = 0;
  protected static final int CHANGE_SYNC_STATUS_NOTIFICATION_ID = 179;
  public static final int ERROR_STATUS_NOTIFICATION = 51;
  public static String LastApplicationException;
  public static SimpleMessageBus MessageBus;
  protected static final int READER_SYNC_STATUS_NOTIFICATION_ID = 171;
  private static final int RELEASE_WAKELOCKS = 1;
  public static final int REPOSITORY_STATUS_NOTIFICATION = 50;
  private static final String TAG = BeyondPodApplication.class.getSimpleName();
  private static PowerManager.WakeLock _BPScreenDimWakeLock = null;
  private static PowerManager.WakeLock _BPWakeLock = null;
  private static WifiManager.WifiLock _BPWifiLock = null;
  private static ChromecastDevice _ChromecastDevice;
  private static Handler _Handler;
  private static BeyondPodApplication _Instance;
  private static PlayList _PlayList;
  private static WifiManager _WiFiMgr = null;
  private BroadcastReceiver _BatteryStateReceiver = null;
  private ComponentName _DownloadService;
  private boolean _IsShutdown = false;
  private IntentFilter _NetworkStateChangedFilter;
  private BroadcastReceiver _NetworkStateIntentReceiver;
  private PlayListEvents.PlayListEventListener _PlayListListener = new PlayListEvents.PlayListEventListener()
  {
    public void OnPlayListEvent(PlayListEvents.PlayListEvent paramAnonymousPlayListEvent)
    {
      if (paramAnonymousPlayListEvent.Type == 2)
      {
        paramAnonymousPlayListEvent = BeyondPodApplication.this.PlayList().CurrentTrack();
        if (paramAnonymousPlayListEvent != null)
        {
          int i = paramAnonymousPlayListEvent.getCurrentPlayState();
          if ((i == 1) || (i == 3)) {
            MediaButtonIntentReceiver.StartListeningForMediaButton();
          }
        }
        return;
      }
      if ((paramAnonymousPlayListEvent.Type == 3) || (BeyondPodApplication.this.PlayList().PlaylistSize() == 0))
      {
        MediaButtonIntentReceiver.StopListeningForMediaButton();
        return;
      }
      MediaButtonIntentReceiver.StartListeningForMediaButton();
    }
  };
  private BroadcastReceiver _StorageCardUnmountReceiver = null;
  
  public BeyondPodApplication()
  {
    Thread.setDefaultUncaughtExceptionHandler(this);
  }
  
  public static String DumpWakeLocks()
  {
    StringBuilder localStringBuilder;
    if ((_BPWakeLock != null) && (_BPWakeLock.isHeld()))
    {
      str = "*";
      localStringBuilder = new StringBuilder(String.valueOf(str));
      if ((_BPScreenDimWakeLock == null) || (!_BPScreenDimWakeLock.isHeld())) {
        break label100;
      }
      str = "$";
      label48:
      localStringBuilder = new StringBuilder(String.valueOf(str));
      if ((_BPWifiLock == null) || (!_BPWifiLock.isHeld())) {
        break label106;
      }
    }
    label100:
    label106:
    for (String str = "#";; str = "")
    {
      return str;
      str = "";
      break;
      str = "";
      break label48;
    }
  }
  
  public static BeyondPodApplication GetInstance()
  {
    if (_Instance == null) {
      throw new IllegalStateException("Not yet loaded");
    }
    return _Instance;
  }
  
  public static Handler GetMainMessageHandler()
  {
    if (_Handler == null) {
      throw new IllegalStateException("null handler");
    }
    return _Handler;
  }
  
  public static boolean IsInitialized()
  {
    return (StringUtils.IsNullOrEmpty(LastApplicationException)) && (StringUtils.IsNullOrEmpty(Configuration.ConfigurationInitErrorMsg)) && (CoreHelper.ExternalStorageState().equals("mounted"));
  }
  
  public static boolean IsWiFiEnabled()
  {
    if (_WiFiMgr == null) {}
    int i;
    do
    {
      return false;
      i = _WiFiMgr.getWifiState();
    } while ((i != 3) && (i != 2));
    return true;
  }
  
  public static void KeepDeviceAwake()
  {
    if (Configuration.DefaultDeviceWakeLock() == 1) {}
    for (Object localObject = _BPWakeLock;; localObject = _BPScreenDimWakeLock)
    {
      if (localObject != null)
      {
        if (!((PowerManager.WakeLock)localObject).isHeld()) {
          ((PowerManager.WakeLock)localObject).acquire();
        }
        if ((IsWiFiEnabled()) && (_BPWifiLock != null) && (!_BPWifiLock.isHeld())) {
          _BPWifiLock.acquire();
        }
        localObject = _Handler.obtainMessage(1);
        _Handler.removeMessages(1);
        _Handler.sendMessageDelayed((Message)localObject, 45000L);
      }
      return;
    }
  }
  
  public static void PokeWiFi()
  {
    if ((IsWiFiEnabled()) && (_BPScreenDimWakeLock != null) && (!_BPScreenDimWakeLock.isHeld()))
    {
      _BPScreenDimWakeLock.acquire();
      CoreHelper.WriteLogEntryInProduction(TAG, "######## Poking WiFi by turning on the screen to a dim level!");
    }
  }
  
  public static void PokeWiFiIfNeeded(Throwable paramThrowable)
  {
    if (Configuration.ScreenPowerStateDuringWiFiUpdates() == 2) {}
    do
    {
      do
      {
        return;
      } while ((!(paramThrowable instanceof SocketTimeoutException)) && (!(paramThrowable instanceof UnknownHostException)) && (!(paramThrowable instanceof SocketException)));
      paramThrowable = CoreHelper.GetDeviceNetworkConnection();
    } while ((!IsWiFiEnabled()) && ((!paramThrowable.IsConnectedToNetwork()) || (!paramThrowable.IsConnectionWiFi())));
    CoreHelper.WriteLogEntryInProduction(TAG, "######## WiFi Connection was dropped! Trying to poke WiFi adapter!!!");
    PokeWiFi();
  }
  
  public static void ReleaseWakeLocks()
  {
    if ((_BPWakeLock != null) && (_BPWakeLock.isHeld())) {
      _BPWakeLock.release();
    }
    if ((_BPScreenDimWakeLock != null) && (_BPScreenDimWakeLock.isHeld())) {
      _BPScreenDimWakeLock.release();
    }
    if ((_BPWifiLock != null) && (_BPWifiLock.isHeld())) {
      _BPWifiLock.release();
    }
  }
  
  private void StartMonitoringNetworkConnectivity()
  {
    final ConnectivityManager localConnectivityManager = (ConnectivityManager)getSystemService("connectivity");
    this._NetworkStateChangedFilter = new IntentFilter();
    this._NetworkStateChangedFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    this._NetworkStateChangedFilter.addAction("android.net.conn.BACKGROUND_DATA_SETTING_CHANGED");
    this._NetworkStateIntentReceiver = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        if ((paramAnonymousIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) && (paramAnonymousIntent.getBooleanExtra("noConnectivity", false))) {
          CoreHelper.WriteLogEntryInProduction(BeyondPodApplication.TAG, "########### All network connections are lost! ########");
        }
        StringBuilder localStringBuilder;
        if (paramAnonymousIntent.getAction().equals("android.net.conn.BACKGROUND_DATA_SETTING_CHANGED"))
        {
          paramAnonymousIntent = BeyondPodApplication.TAG;
          localStringBuilder = new StringBuilder("########### ACTION_BACKGROUND_DATA_SETTING_CHANGED! Background Data:");
          if (!localConnectivityManager.getBackgroundDataSetting()) {
            break label82;
          }
        }
        label82:
        for (paramAnonymousContext = " Allowed";; paramAnonymousContext = "Not Allowed")
        {
          CoreHelper.WriteTraceEntry(paramAnonymousIntent, paramAnonymousContext);
          return;
        }
      }
    };
    registerReceiver(this._NetworkStateIntentReceiver, this._NetworkStateChangedFilter);
  }
  
  public static boolean ToggleWiFi(boolean paramBoolean, String paramString)
  {
    if (_WiFiMgr != null)
    {
      if ((paramBoolean) && (IsWiFiEnabled())) {
        CoreHelper.WriteTraceEntry(TAG, "WiFi adapter is already on. (called by: " + paramString + ")");
      }
    }
    else {
      return false;
    }
    String str2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder("Switching WiFi adapter:");
    if (paramBoolean) {}
    for (String str1 = "ON";; str1 = "OFF")
    {
      CoreHelper.WriteTraceEntry(str2, str1 + " (called by: " + paramString + ")");
      return _WiFiMgr.setWifiEnabled(paramBoolean);
    }
  }
  
  public abstract String AppKind();
  
  public ChromecastDevice ChromecastDevice()
  {
    return _ChromecastDevice;
  }
  
  public abstract void ClearChangeSyncNotification();
  
  public abstract void ClearReaderSyncNotification();
  
  public abstract void ConfigureDefaults();
  
  public abstract void ConfigureDefaultsForVersionUpgrade(int paramInt1, int paramInt2);
  
  public abstract void ExecuteCommandPlaySmartPlayList(Context paramContext);
  
  public abstract Notification GetDefaultNotificationForService(Service paramService, String paramString);
  
  public abstract StartupContentBuilder.Content[] GetDemoContent();
  
  @SuppressLint({"HandlerLeak"})
  protected void Initialize()
  {
    try
    {
      LastApplicationException = null;
      MessageBus = new SimpleMessageBus(_Handler);
      RegisterEnvironmentListeners();
      DownloadEngineNotificationManager.Initialize(getApplicationContext());
      _PlayList = new PlayList();
      InitializeWidgets();
      MessageBus.Subscribe(this._PlayListListener, PlayListEvents.PlayListEvent.class);
      if (!Configuration.Initialize(getApplicationContext())) {
        CoreHelper.WriteTraceEntry(TAG, "Unable to find Storage card! Waiting for a storage card to be mounted...");
      }
      _ChromecastDevice = new ChromecastDevice(getApplicationContext());
      return;
    }
    catch (Exception localException)
    {
      Log.e(TAG, "Failed to initialize BeyondPod application", localException);
      LastApplicationException = "Error loading application data!\n\n" + CoreHelper.ExtractExceptionMessages(localException);
    }
  }
  
  public abstract void InitializeWidgets();
  
  public boolean IsDownloadServiceHolderRunning()
  {
    return this._DownloadService != null;
  }
  
  public boolean IsGCMSupportedOnDevice()
  {
    try
    {
      GCMRegistrar.checkDevice(getApplicationContext());
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public boolean IsInAirplaneMode()
  {
    return Settings.System.getInt(getApplicationContext().getContentResolver(), "airplane_mode_on", 0) == 1;
  }
  
  public boolean IsLockScreenWidgetInstalled()
  {
    return false;
  }
  
  protected boolean IsMovieViewActive()
  {
    return MovieViewCounter.HasInstances();
  }
  
  public boolean IsShutdown()
  {
    return this._IsShutdown;
  }
  
  public abstract Activity MasterActivity();
  
  public abstract Class<?> MasterViewClass();
  
  public PlayList PlayList()
  {
    return _PlayList;
  }
  
  public abstract void RefreshWidgets();
  
  public void RegisterEnvironmentListeners()
  {
    IntentFilter localIntentFilter;
    if (this._StorageCardUnmountReceiver == null)
    {
      this._StorageCardUnmountReceiver = new BroadcastReceiver()
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          String str = paramAnonymousIntent.getAction();
          if ((str.equals("android.intent.action.MEDIA_EJECT")) || (str.equals("android.intent.action.MEDIA_UNMOUNTED")))
          {
            CoreHelper.WriteTraceEntry(BeyondPodApplication.TAG, "Storage card " + paramAnonymousIntent.getData().getPath() + " unmounted!");
            if (PlayList.IsCurrentlyPlaying())
            {
              paramAnonymousIntent = new Intent(paramAnonymousContext, MediaPlaybackService.class);
              paramAnonymousIntent.setAction("mobi.beyondpod.services.musicservicecommand");
              paramAnonymousIntent.putExtra("command", "stop");
              paramAnonymousContext.startService(paramAnonymousIntent);
            }
            if (BeyondPodApplication.this.MasterActivity() != null)
            {
              CoreHelper.WriteTraceEntry(BeyondPodApplication.TAG, "Closing Master View!");
              BeyondPodApplication.this.MasterActivity().finish();
            }
            CoreHelper.WriteTraceEntry(BeyondPodApplication.TAG, "Saving and unloading the repository...");
            FeedRepository.SaveAndUnloadRepositoryAsync();
          }
          while (!str.equals("android.intent.action.MEDIA_MOUNTED")) {
            return;
          }
          CoreHelper.WriteTraceEntry(BeyondPodApplication.TAG, "Storage card " + paramAnonymousIntent.getData().getPath() + " mounted!");
          if ((FeedRepository.RepositoryLoadState() == -1) || (FeedRepository.IsEmpty()))
          {
            if ((StringUtils.IsNullOrEmpty(Configuration.LastSDCardRootPath())) || (StringUtils.Equals(paramAnonymousIntent.getData().getPath(), Configuration.LastSDCardRootPath())))
            {
              CoreHelper.WriteTraceEntry(BeyondPodApplication.TAG, "Storage root card mounted!, Initializing configuration...");
              BeyondPodApplication.this.Initialize();
              return;
            }
            CoreHelper.WriteTraceEntry(BeyondPodApplication.TAG, "Mounted card is not our storage root (" + Configuration.LastSDCardRootPath() + "), Ignoring...");
            return;
          }
          CoreHelper.WriteTraceEntry(BeyondPodApplication.TAG, "Detected a fake mount, Repository is already initialized! State:" + FeedRepository.RepositoryLoadState());
        }
      };
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.MEDIA_EJECT");
      localIntentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
      localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
      localIntentFilter.addDataScheme("file");
      registerReceiver(this._StorageCardUnmountReceiver, localIntentFilter);
    }
    if (this._BatteryStateReceiver == null)
    {
      this._BatteryStateReceiver = new BroadcastReceiver()
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          if (paramAnonymousIntent.getAction().equals("android.intent.action.BATTERY_CHANGED"))
          {
            BeyondPodApplication.BatteryLevel = paramAnonymousIntent.getIntExtra("level", -1);
            BeyondPodApplication.BatteryStatus = paramAnonymousIntent.getIntExtra("status", -1);
            BeyondPodApplication.BatteryPlugged = paramAnonymousIntent.getIntExtra("plugged", -1);
          }
        }
      };
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.BATTERY_CHANGED");
      localIntentFilter.addAction("android.intent.action.BATTERY_LOW");
      registerReceiver(this._BatteryStateReceiver, localIntentFilter);
    }
  }
  
  public abstract boolean SendCommandToVideoPlayer(Intent paramIntent);
  
  public abstract void SetChangeSyncNotification(String paramString1, String paramString2);
  
  public abstract void SetNotification(Service paramService, Intent paramIntent);
  
  public abstract void SetPlayerNotification(Service paramService, Track paramTrack);
  
  public abstract void SetPlayerPauseNotification(Context paramContext, Track paramTrack);
  
  public abstract void SetReaderSyncNotification(String paramString1, String paramString2);
  
  public boolean StartDownloadServiceHolder()
  {
    if (!IsDownloadServiceHolderRunning()) {
      this._DownloadService = getApplicationContext().startService(new Intent(getApplicationContext(), DownloadHolderService.class));
    }
    return IsDownloadServiceHolderRunning();
  }
  
  public abstract void StartVideoPlayback(Track paramTrack);
  
  public void StopDownloadServiceHolder()
  {
    if (getApplicationContext().stopService(new Intent(getApplicationContext(), DownloadHolderService.class))) {
      this._DownloadService = null;
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    CoreHelper.WriteTraceEntry(TAG, "**************************************************************");
    CoreHelper.WriteTraceEntry(TAG, "************ BeyondPod Process is starting *******************");
    if (_Instance != null) {
      throw new IllegalStateException("Not a singleton");
    }
    _Instance = this;
    _WiFiMgr = (WifiManager)getSystemService("wifi");
    Object localObject;
    if (_WiFiMgr != null)
    {
      localObject = _WiFiMgr;
      if (CoreHelper.ApiLevel() >= 12) {
        break label240;
      }
    }
    label240:
    for (int i = 1;; i = 3)
    {
      _BPWifiLock = ((WifiManager)localObject).createWifiLock(i, getClass().getName());
      _BPWifiLock.setReferenceCounted(false);
      localObject = (PowerManager)getSystemService("power");
      if (localObject != null)
      {
        _BPWakeLock = ((PowerManager)localObject).newWakeLock(1, getClass().getName() + " - Screen OFF");
        _BPWakeLock.setReferenceCounted(false);
        _BPScreenDimWakeLock = ((PowerManager)localObject).newWakeLock(268435462, getClass().getName() + " - Screen DIM");
        _BPScreenDimWakeLock.setReferenceCounted(false);
      }
      _Handler = new Handler()
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          switch (paramAnonymousMessage.what)
          {
          default: 
            return;
          }
          BeyondPodApplication.ReleaseWakeLocks();
        }
      };
      _BPWakeLock.acquire(2000L);
      CookieSyncManager.createInstance(this);
      CookieManager.getInstance().removeExpiredCookie();
      StartMonitoringNetworkConnectivity();
      MediaButtonIntentReceiver.Touch();
      Initialize();
      return;
    }
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    CoreHelper.WriteTraceEntry(TAG, ">>>>>>>>>> Low Memory Detected! <<<<<<<<<<<<");
  }
  
  public void onTerminate()
  {
    if (this._StorageCardUnmountReceiver != null)
    {
      unregisterReceiver(this._StorageCardUnmountReceiver);
      this._StorageCardUnmountReceiver = null;
    }
    if (this._BatteryStateReceiver != null)
    {
      unregisterReceiver(this._BatteryStateReceiver);
      this._BatteryStateReceiver = null;
    }
    MediaButtonIntentReceiver.StopListeningForMediaButton();
    CoreHelper.WriteTraceEntry(TAG, "BeyondPodApplication is Terminating... Releasing the wake locks");
    ReleaseWakeLocks();
    FeedRepository.SaveRepositorySync();
    MessageBus.Unsubscribe(this._PlayListListener, PlayListEvents.PlayListEvent.class);
    _Instance = null;
    if (_Handler != null) {
      _Handler.removeCallbacksAndMessages(null);
    }
    NotificationHelper.getInstance().ClearNotification(this, 1);
    super.onTerminate();
  }
  
  public abstract void setMasterActivity(Activity paramActivity);
  
  public void shutdown()
  {
    this._IsShutdown = true;
    _Handler.postDelayed(new Runnable()
    {
      public void run()
      {
        if (BeyondPodApplication.this.MasterActivity() != null) {
          BeyondPodApplication.this.MasterActivity().finish();
        }
        BeyondPodApplication.this.onTerminate();
        System.exit(0);
      }
    }, 1000L);
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    CoreHelper.LogException(TAG, "!!! Unhandled exception !!!", paramThrowable);
    if (MasterActivity() != null) {}
    for (paramThread = MasterActivity();; paramThread = getApplicationContext())
    {
      AnalyticsTracker.EndSession(paramThread);
      ReleaseWakeLocks();
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/BeyondPodApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */