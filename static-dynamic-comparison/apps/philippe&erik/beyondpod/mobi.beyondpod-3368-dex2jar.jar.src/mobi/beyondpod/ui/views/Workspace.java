package mobi.beyondpod.ui.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import mobi.beyondpod.aggregators.greader.GoogleReader;
import mobi.beyondpod.downloadengine.VersionCheckManager;
import mobi.beyondpod.downloadengine.VersionCheckManager.VersionInformation;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.schedulercore.ScheduledTasksManager;
import mobi.beyondpod.ui.core.MasterViewState;
import mobi.beyondpod.ui.views.base.IView;
import mobi.beyondpod.ui.views.base.WorkspaceViewManagerPager;
import mobi.beyondpod.ui.views.notifications.Message;
import mobi.beyondpod.ui.views.notifications.UserNotificationManager;

public class Workspace
  extends LinearLayout
{
  public static final int FEEDS_VIEW = 1;
  public static final int INVALID_VIEW = -1;
  public static final int PLAYER_VIEW = 4;
  public static final int PODCASTS_VIEW = 3;
  private static final String TAG = MasterView.class.getSimpleName();
  public boolean DataIsLoadedInWorkspaceViews = false;
  public FeedsView Feeds;
  public String LastExternalPlayerTrackPath;
  public long LastExternalPlayerTrackTime;
  public PlayerView Player;
  public PodcastsListView Podcasts;
  public PodcastsView PodcastsList;
  WorkspaceViewManagerPager _Flipper;
  Handler _Handler = new Handler();
  MasterViewState _InitialState;
  long _LastUnhandledFocusMove = 0L;
  long _LoadDataStartTime;
  Bundle _SavedInstanceState;
  Runnable _StartupNotificationRunnable = new Runnable()
  {
    public void run()
    {
      Workspace.this.ShowUserNotificationIfNeeded();
    }
  };
  private IView[] _Views = new IView[5];
  
  public Workspace(Context paramContext)
  {
    super(paramContext);
  }
  
  public Workspace(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @SuppressLint({"NewApi"})
  private void ShowUserNotificationIfNeeded()
  {
    if (MasterView.Master() == null) {
      return;
    }
    Object localObject2 = VersionCheckManager.VersionInfo.GetCustomizedMessage();
    Object localObject1 = localObject2;
    if (!((Message)localObject2).HasText())
    {
      localObject1 = localObject2;
      if (Configuration.NotifyForBetaReleases()) {
        localObject1 = VersionCheckManager.VersionInfo.BetaUsers;
      }
    }
    if (new Date().compareTo(Configuration.getNextNotificationTime()) > 0) {}
    for (int i = 1; (((Message)localObject1).HasText()) && (i != 0) && (!((Message)localObject1).IsExpired()); i = 0)
    {
      localObject2 = new GregorianCalendar();
      ((Calendar)localObject2).add(10, ((Message)localObject1).RepeatInterval);
      Configuration.setNextNotificationTime(((Calendar)localObject2).getTime());
      UserNotificationManager.ShowPopupNotificationMessage(this, (Message)localObject1, null);
      return;
    }
    if ((ScheduledTasksManager.ActiveTaskCount() > 0) && (Configuration.IsInstalledOnSDCard())) {
      UserNotificationManager.WarnAboutInstalledOnSDCard(MasterView.Master(), null);
    }
    if (getResources().getBoolean(2131427334)) {
      UserNotificationManager.TipNotifyConsiderUsingTabletVersion(this);
    }
    if ((Configuration.StartupView() == 0) && (FeedRepository.GetTrackCount() > 5)) {
      UserNotificationManager.TipNotifyStartupScreen(this);
    }
    if (GoogleReader.IsLoggedIn())
    {
      UserNotificationManager.TipNotifySwitchingToFeedly(this);
      return;
    }
    UserNotificationManager.TipNotifyHowToChangeCategory(this);
  }
  
  private int getNextView()
  {
    int j = ActiveViewIndex() + 1;
    int i = j;
    if (j > 4) {
      i = -1;
    }
    return i;
  }
  
  private int getPreviousView()
  {
    int j = ActiveViewIndex() - 1;
    int i = j;
    if (j < 1) {
      i = -1;
    }
    return i;
  }
  
  private void setActiveView(int paramInt)
  {
    if (ActiveViewIndex() == paramInt) {
      return;
    }
    this._Flipper.setCurrentView((View)this._Views[paramInt]);
  }
  
  public void ActivateView(final int paramInt)
  {
    MasterView.Master().runOnUiThread(new Runnable()
    {
      public void run()
      {
        IView localIView1 = Workspace.this.ActiveView();
        IView localIView2 = Workspace.this._Views[paramInt];
        if ((localIView2 == null) || ((localIView1 != null) && (localIView1.equals(localIView2)))) {
          return;
        }
        Workspace.this.setActiveView(paramInt);
        MasterView.Master().RefreshActiveViewTitle();
      }
    });
  }
  
  public IView ActiveView()
  {
    return (IView)this._Flipper.getCurrentView();
  }
  
  public int ActiveViewIndex()
  {
    View localView = this._Flipper.getCurrentView();
    if (localView != null) {
      return localView.getId();
    }
    return -1;
  }
  
  public void BuildViews()
  {
    long l1 = System.currentTimeMillis();
    this.Feeds = new FeedsView(getContext());
    this.Feeds.setId(1);
    MasterView.Master().registerForContextMenu(this.Feeds.FeedsList);
    this.Feeds.Initialize();
    this.PodcastsList = new PodcastsView(getContext());
    this.PodcastsList.setId(3);
    this.Podcasts = this.PodcastsList.PodcastList;
    this.Player = new PlayerView(getContext(), MasterView.Master());
    this.Player.setId(4);
    this._Flipper.addPage(this.Feeds);
    this._Flipper.addPage(this.PodcastsList);
    this._Flipper.addPage(this.Player);
    MasterView.Master().registerForContextMenu(this.Podcasts);
    MasterView.Master().registerForContextMenu(this.Player);
    if (this.Player.PlayListView() != null) {
      MasterView.Master().registerForContextMenu(this.Player.PlayListView());
    }
    this._Views[1] = this.Feeds;
    this._Views[3] = this.PodcastsList;
    this._Views[4] = this.Player;
    long l2 = System.currentTimeMillis();
    CoreHelper.WriteTraceEntry(TAG, "Build workspace Views Completed in: " + (l2 - l1) + " ms");
  }
  
  public boolean GoToHomeView()
  {
    int i = ActiveViewIndex();
    if (((i == 1) && (Configuration.StartupView() == 0)) || ((i == 3) && (Configuration.StartupView() == 1)) || ((i == 4) && (Configuration.StartupView() == 2))) {
      return false;
    }
    switch (Configuration.StartupView())
    {
    default: 
      return false;
    case 0: 
      ActivateView(1);
      return true;
    case 1: 
      ActivateView(3);
      return true;
    }
    ActivateView(4);
    return true;
  }
  
  void Initialize(MasterViewState paramMasterViewState, Bundle paramBundle)
  {
    this._Flipper = ((WorkspaceViewManagerPager)findViewById(2131231093));
    this._InitialState = paramMasterViewState;
    this._SavedInstanceState = paramBundle;
    this.DataIsLoadedInWorkspaceViews = false;
  }
  
  public void LoadDataInWorkspaceViews(int paramInt)
  {
    long l = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        BuildViews();
      }
      catch (Exception localException2)
      {
        MasterViewState localMasterViewState1;
        MasterViewState localMasterViewState2;
        Object localObject;
        CoreHelper.LogException(TAG, "Failed to Load Data into the Workspace", localException2);
        continue;
        localMasterViewState2.CurrentView = 3;
        continue;
        localMasterViewState2.CurrentView = 4;
        continue;
        continue;
      }
      try
      {
        if (this._InitialState != null)
        {
          localMasterViewState1 = this._InitialState;
          localMasterViewState2 = localMasterViewState1;
          if (localMasterViewState1 == null)
          {
            localMasterViewState2 = new MasterViewState();
            localMasterViewState2.FeedsViewRootFeed = FeedRepository.getRootFeed();
            localMasterViewState2.PodcastCurrentScope = 1;
          }
        }
        switch (paramInt)
        {
        case 0: 
          this.PodcastsList.RestoreState(localMasterViewState2);
          this.Feeds.RestoreState(localMasterViewState2);
          if ((localMasterViewState2.CurrentView != -1) && (this._Views[localMasterViewState2.CurrentView] != null)) {
            setActiveView(localMasterViewState2.CurrentView);
          }
          this.LastExternalPlayerTrackPath = localMasterViewState2.LastExternalPlayingTrackPath;
          this.LastExternalPlayerTrackTime = localMasterViewState2.LastExternalPlayingTrackTime;
          this.DataIsLoadedInWorkspaceViews = true;
          MasterView.Master().RefreshActiveViewTitle();
          this._Handler.postDelayed(this._StartupNotificationRunnable, 2000L);
          CoreHelper.WriteTraceEntry(TAG, "LoadData in Workspace Views Completed in: " + (System.currentTimeMillis() - l) + " ms.");
          return;
          localMasterViewState1 = MasterViewState.FromBundle(this._SavedInstanceState);
        }
      }
      catch (Exception localException1)
      {
        localObject = null;
        continue;
        localMasterViewState2.CurrentView = 1;
      }
    }
  }
  
  void OnMasterViewDestroy()
  {
    this._Handler.removeCallbacks(this._StartupNotificationRunnable);
    if (this.Player != null) {
      this.Player.OnActivityDestroy();
    }
    if (this.Feeds != null) {
      this.Feeds.OnActivityDestroy();
    }
    if (this.PodcastsList != null) {
      this.PodcastsList.OnActivityDestroy();
    }
  }
  
  MasterViewState SaveCurrentState()
  {
    Object localObject;
    if (!this.DataIsLoadedInWorkspaceViews) {
      localObject = null;
    }
    MasterViewState localMasterViewState;
    do
    {
      return (MasterViewState)localObject;
      localMasterViewState = new MasterViewState();
      localObject = localMasterViewState;
    } while (!this.DataIsLoadedInWorkspaceViews);
    localMasterViewState.CurrentView = this._Flipper.getCurrentView().getId();
    this.Feeds.SaveState(localMasterViewState);
    this.PodcastsList.SaveState(localMasterViewState);
    localMasterViewState.LastExternalPlayingTrackPath = this.LastExternalPlayerTrackPath;
    localMasterViewState.LastExternalPlayingTrackTime = this.LastExternalPlayerTrackTime;
    return localMasterViewState;
  }
  
  void SaveCurrentStateToBundle(Bundle paramBundle)
  {
    MasterViewState localMasterViewState = SaveCurrentState();
    if (localMasterViewState != null) {
      localMasterViewState.ToBundle(paramBundle);
    }
  }
  
  public void TogglePlayerPlaylist()
  {
    PlayerView localPlayerView;
    if (this.Player != null)
    {
      localPlayerView = this.Player;
      if (!Configuration.PlayerPlaylistVisible()) {
        break label26;
      }
    }
    label26:
    for (boolean bool = false;; bool = true)
    {
      localPlayerView.TogglePlaylist(bool);
      return;
    }
  }
  
  public boolean dispatchUnhandledMove(View paramView, int paramInt)
  {
    if (System.currentTimeMillis() - this._LastUnhandledFocusMove < 500L) {
      return true;
    }
    if ((paramInt == 17) || (paramInt == 66))
    {
      if (paramInt != 17) {
        break label59;
      }
      paramInt = getPreviousView();
      if (paramInt == -1) {
        break label67;
      }
      ActivateView(paramInt);
    }
    for (;;)
    {
      this._LastUnhandledFocusMove = System.currentTimeMillis();
      return true;
      label59:
      paramInt = getNextView();
      break;
      label67:
      MasterView.Master().Vibrate();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/Workspace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */