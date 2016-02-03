package mobi.beyondpod;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.widget.Toast;
import java.lang.ref.SoftReference;
import mobi.beyondpod.downloadengine.EnclosureDownloadManager;
import mobi.beyondpod.downloadengine.UpdateAndDownloadManager;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.StartupContentBuilder;
import mobi.beyondpod.rsscore.StartupContentBuilder.Content;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.events.ApplicationEvents.ApplicationErrorEvent;
import mobi.beyondpod.rsscore.events.ApplicationEvents.ApplicationErrorEventListener;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.NotificationBuilderHelper;
import mobi.beyondpod.rsscore.helpers.NotificationHelper;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.services.player.MediaAppWidgetProvider;
import mobi.beyondpod.services.player.MediaAppWidgetProviderBase;
import mobi.beyondpod.services.player.MediaAppWidgetProviderICS;
import mobi.beyondpod.services.player.MediaAppWidgetProviderLockscreen;
import mobi.beyondpod.services.player.MediaAppWidgetProviderMini;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.dialogs.ApplicationErrorMessageDialog;
import mobi.beyondpod.ui.views.HtmlViewActivity;
import mobi.beyondpod.ui.views.MasterView;
import mobi.beyondpod.ui.views.UpdateAndDownloadQueueActivityDialog;
import mobi.beyondpod.ui.views.notifications.UserNotificationManager;

public class BeyondPodApplicationSD
  extends BeyondPodApplication
  implements Thread.UncaughtExceptionHandler
{
  private static SoftReference<Activity> _MasterActivity;
  private static MediaAppWidgetProviderBase _MediaAppWidgetProvider;
  private static MediaAppWidgetProviderBase _MediaAppWidgetProviderICS;
  private static MediaAppWidgetProviderBase _MediaAppWidgetProviderLockScreen;
  private static MediaAppWidgetProviderBase _MediaAppWidgetProviderMini;
  private ApplicationEvents.ApplicationErrorEventListener _ApplicationEventListener = new ApplicationEvents.ApplicationErrorEventListener()
  {
    public void OnApplicationErrorEvent(ApplicationEvents.ApplicationErrorEvent paramAnonymousApplicationErrorEvent)
    {
      if (BeyondPodApplicationSD.this.MasterActivity() == null) {}
      do
      {
        do
        {
          do
          {
            return;
            Resources localResources = BeyondPodApplicationSD.this.getResources();
            Intent localIntent = new Intent(BeyondPodApplicationSD.this.getApplicationContext(), ApplicationErrorMessageDialog.class);
            switch (paramAnonymousApplicationErrorEvent.Type)
            {
            case 2: 
            default: 
            case 0: 
            case 1: 
              for (;;)
              {
                localIntent.setFlags(268435456);
                BeyondPodApplicationSD.this.startActivity(localIntent);
                return;
                CharSequence localCharSequence = localResources.getText(2131296909);
                paramAnonymousApplicationErrorEvent = localCharSequence;
                if (CoreHelper.ApiLevel() >= 19)
                {
                  paramAnonymousApplicationErrorEvent = localCharSequence;
                  if (!CoreHelper.isFolderReallyWritable(Configuration.BeyondPodPublicStorageRootPath())) {
                    paramAnonymousApplicationErrorEvent = localResources.getText(2131296910);
                  }
                }
                localIntent.putExtra(ApplicationErrorMessageDialog.ERROR_MESSAGE, paramAnonymousApplicationErrorEvent);
                continue;
                paramAnonymousApplicationErrorEvent = localResources.getText(2131296911);
                localIntent.putExtra(ApplicationErrorMessageDialog.ERROR_MESSAGE, paramAnonymousApplicationErrorEvent);
                paramAnonymousApplicationErrorEvent = localResources.getText(2131296912);
                localIntent.putExtra(ApplicationErrorMessageDialog.BUTTON_TEXT, paramAnonymousApplicationErrorEvent);
                localIntent.putExtra(ApplicationErrorMessageDialog.ERROR_TYPE, 1);
              }
            case 3: 
            case 4: 
              paramAnonymousApplicationErrorEvent = (Exception)paramAnonymousApplicationErrorEvent.getSource();
            }
          } while (paramAnonymousApplicationErrorEvent == null);
          Toast.makeText(BeyondPodApplicationSD.this.getApplicationContext(), paramAnonymousApplicationErrorEvent.getMessage(), 1).show();
          return;
        } while ((MasterView.Master() == null) || (MasterView.Master().Workspace == null));
        UserNotificationManager.NotifyUpdateErrors(MasterView.Master().Workspace);
        return;
      } while ((MasterView.Master() == null) || (MasterView.Master().Workspace == null));
      UserNotificationManager.NotifyDeviceTimeIncorrect(MasterView.Master().Workspace);
    }
  };
  Notification _PlayerNotification;
  Notification _UpdateNotification;
  
  private void SetSyncNotificationInternal(int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this, MasterViewClass());
    BeyondPodApplication localBeyondPodApplication = BeyondPodApplication.GetInstance();
    paramString1 = NotificationBuilderHelper.getInstance(localBeyondPodApplication).setSmallIcon(17301640).setContentIntent(PendingIntent.getActivity(localBeyondPodApplication, 0, localIntent, 134217728)).setContentTitle(paramString1).setContentText(paramString2).setOngoing(true).getNotification(null);
    NotificationHelper.getInstance().UpdateNotification(BeyondPodApplication.GetInstance(), paramInt, paramString1);
  }
  
  public String AppKind()
  {
    return "bpsd";
  }
  
  public void ClearChangeSyncNotification()
  {
    NotificationHelper.getInstance().ClearNotification(BeyondPodApplication.GetInstance(), 179);
  }
  
  public void ClearReaderSyncNotification()
  {
    NotificationHelper.getInstance().ClearNotification(BeyondPodApplication.GetInstance(), 171);
  }
  
  public void ConfigureDefaults()
  {
    Configuration.ConfigureDefaults();
    Configuration.setShowContentListPostImages(true);
    Configuration.setAllowVideosInPlaylist(true);
    Configuration.setPauseVideoOnScreenOff(true);
    if (CoreHelper.ApiLevel() >= 10) {}
    for (boolean bool = true;; bool = false)
    {
      Configuration.setUseFeedContentViewPager(bool);
      Configuration.setRichPlayerNotication(true);
      Configuration.setMultilineEpisodeTitle(true);
      Configuration.setSetAsPlayedOnMarkRead(true);
      if (CoreHelper.IsDeviceWiFiOnlyDevice()) {
        Configuration.setScreenPowerStateDuringWiFiUpdates(0);
      }
      return;
    }
  }
  
  public void ConfigureDefaultsForVersionUpgrade(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 2902) && (paramInt2 >= 2902)) {
      Configuration.setShowContentListPostImages(true);
    }
    if ((paramInt1 < 2908) && (paramInt2 >= 2908)) {
      if (CoreHelper.ApiLevel() < 10) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      Configuration.setUseFeedContentViewPager(bool);
      if ((paramInt1 < 3024) && (paramInt2 >= 3024))
      {
        Configuration.setActiveFeedFilter(null);
        Configuration.setRichPlayerNotication(true);
      }
      return;
    }
  }
  
  public void ExecuteCommandPlaySmartPlayList(Context paramContext)
  {
    CommandManager.CmdPlaySmartPlayList(paramContext);
  }
  
  public Notification GetDefaultNotificationForService(Service paramService, String paramString)
  {
    Intent localIntent = new Intent(paramService, MasterViewClass());
    localIntent.setAction("mobi.beyondpod.action.VIEW_PLAYER");
    return NotificationBuilderHelper.getInstance(paramService).setSmallIcon(2130838093).setContentIntent(PendingIntent.getActivity(paramService, 0, localIntent, 134217728)).setContentTitle(paramString).setContentText("").setOngoing(false).getNotification(null);
  }
  
  public StartupContentBuilder.Content[] GetDemoContent()
  {
    return StartupContentBuilder.LoadSeedFeedImages();
  }
  
  protected void Initialize()
  {
    super.Initialize();
    MessageBus.Subscribe(this._ApplicationEventListener, ApplicationEvents.ApplicationErrorEvent.class);
  }
  
  public void InitializeWidgets()
  {
    _MediaAppWidgetProvider = new MediaAppWidgetProvider();
    _MediaAppWidgetProvider.Initialize();
    _MediaAppWidgetProviderMini = new MediaAppWidgetProviderMini();
    _MediaAppWidgetProviderMini.Initialize();
    _MediaAppWidgetProviderICS = new MediaAppWidgetProviderICS();
    _MediaAppWidgetProviderICS.Initialize();
    _MediaAppWidgetProviderLockScreen = new MediaAppWidgetProviderLockscreen();
    _MediaAppWidgetProviderLockScreen.Initialize();
  }
  
  public boolean IsLockScreenWidgetInstalled()
  {
    return (_MediaAppWidgetProviderLockScreen != null) && (_MediaAppWidgetProviderLockScreen.HasInstances());
  }
  
  public Activity MasterActivity()
  {
    if (_MasterActivity == null) {
      return null;
    }
    return (Activity)_MasterActivity.get();
  }
  
  public Class<?> MasterViewClass()
  {
    return MasterView.class;
  }
  
  public void RefreshWidgets()
  {
    new MediaAppWidgetProvider().RefreshViews();
    new MediaAppWidgetProviderMini().RefreshViews();
    new MediaAppWidgetProviderICS().RefreshViews();
    new MediaAppWidgetProviderLockscreen().RefreshViews();
  }
  
  public boolean SendCommandToVideoPlayer(Intent paramIntent)
  {
    if (!IsMovieViewActive()) {
      return false;
    }
    CommandManager.CmdSendMediaCommandToVideoPlayer(getApplicationContext(), paramIntent);
    return true;
  }
  
  public void SetChangeSyncNotification(String paramString1, String paramString2)
  {
    SetSyncNotificationInternal(179, paramString1, paramString2);
  }
  
  public void SetNotification(Service paramService, Intent paramIntent)
  {
    boolean bool = false;
    int n = paramIntent.getIntExtra(NotificationHelper.NOTIFICATION_TYPE_EXTRA, -1);
    String str1 = paramIntent.getStringExtra(NotificationHelper.NOTIFICATION_TICKER_EXTRA);
    String str2 = paramIntent.getStringExtra(NotificationHelper.NOTIFICATION_LINE1_EXTRA);
    String str3 = paramIntent.getStringExtra(NotificationHelper.NOTIFICATION_LINE2_EXTRA);
    int m = 17301633;
    Object localObject = null;
    int k = 128;
    int i = m;
    paramIntent = (Intent)localObject;
    int j = k;
    switch (n)
    {
    default: 
      j = k;
      paramIntent = (Intent)localObject;
      i = m;
    }
    for (;;)
    {
      if ((paramIntent == null) || (UpdateAndDownloadManager.HasWorkToDo()) || (EnclosureDownloadManager.QueueCount() > 0)) {
        paramIntent = new Intent(paramService, UpdateAndDownloadQueueActivityDialog.class);
      }
      paramIntent = NotificationBuilderHelper.getInstance(paramService).setSmallIcon(i).setContentIntent(PendingIntent.getActivity(paramService, 0, paramIntent, 134217728)).setTicker(str1).setContentTitle(str2).setContentText(str3);
      if (j == 128) {
        bool = true;
      }
      this._UpdateNotification = paramIntent.setOngoing(bool).getNotification(this._UpdateNotification);
      NotificationHelper.getInstance().UpdateNotification(paramService, j, this._UpdateNotification);
      if (j != 128) {
        this._UpdateNotification = null;
      }
      return;
      i = 2130838096;
      paramIntent = (Intent)localObject;
      j = k;
      continue;
      i = 2130838089;
      paramIntent = new Intent(paramService, MasterViewClass());
      paramIntent.setAction("mobi.beyondpod.action.VIEW_PLAYER");
      j = 129;
      this._UpdateNotification = null;
      continue;
      i = 17301624;
      paramIntent = new Intent(paramService, HtmlViewActivity.class);
      paramIntent.setData(Configuration.getFeedUpdateLogURL());
      paramIntent.putExtra("Title", "Update and Download Log");
      paramIntent.putExtra("IsFeedContentLink", false);
      j = 129;
      this._UpdateNotification = null;
    }
  }
  
  public void SetPlayerNotification(Service paramService, Track paramTrack)
  {
    if (Configuration.RichPlayerNotication())
    {
      paramTrack = MediaAppWidgetProvider.CreatePlayerNotification(paramService, paramTrack, false);
      NotificationHelper.getInstance().StartForegroundAndShowNotification(paramService, 1, paramTrack);
      return;
    }
    Intent localIntent = new Intent(this, MasterViewClass());
    localIntent.setData(Uri.parse("mobi.beyondpod.services.player.MediaPlaybackService"));
    paramTrack = NotificationBuilderHelper.getInstance(paramService).setSmallIcon(2130838090).setContentIntent(PendingIntent.getActivity(paramService, 0, localIntent, 134217728)).setContentTitle(paramTrack.DisplayName()).setContentText(paramTrack.getParentFeed().getName()).setOngoing(true);
    NotificationHelper.getInstance().StartForegroundAndShowNotification(paramService, 1, paramTrack.getNotification(this._PlayerNotification));
  }
  
  public void SetPlayerPauseNotification(Context paramContext, Track paramTrack)
  {
    this._PlayerNotification = null;
    if ((Configuration.RichPlayerNotication()) && (paramTrack != null)) {}
    for (int i = 0; i != 0; i = 1)
    {
      if ((paramContext instanceof Service)) {
        NotificationHelper.getInstance().StopForeground((Service)paramContext, 1);
      }
      return;
    }
    paramTrack = MediaAppWidgetProvider.CreatePlayerNotification(paramContext, paramTrack, false);
    NotificationHelper.getInstance().UpdateNotification(paramContext, 1, paramTrack);
  }
  
  public void SetReaderSyncNotification(String paramString1, String paramString2)
  {
    SetSyncNotificationInternal(171, paramString1, paramString2);
  }
  
  public void StartVideoPlayback(Track paramTrack)
  {
    CommandManager.CmdPlayMovie(getApplicationContext(), paramTrack);
  }
  
  public void onTerminate()
  {
    MessageBus.Unsubscribe(this._ApplicationEventListener, ApplicationEvents.ApplicationErrorEvent.class);
    super.onTerminate();
  }
  
  public void setMasterActivity(Activity paramActivity)
  {
    if (paramActivity == null)
    {
      if (_MasterActivity != null) {
        _MasterActivity.clear();
      }
      _MasterActivity = null;
    }
    _MasterActivity = new SoftReference(paramActivity);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/BeyondPodApplicationSD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */