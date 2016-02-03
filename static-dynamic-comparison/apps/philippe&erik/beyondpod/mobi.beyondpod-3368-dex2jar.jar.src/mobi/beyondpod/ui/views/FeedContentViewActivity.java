package mobi.beyondpod.ui.views;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;
import java.util.UUID;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEvent;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEventListener;
import mobi.beyondpod.rsscore.rss.ItemStateHistory;
import mobi.beyondpod.rsscore.rss.entities.RssEnclosure;
import mobi.beyondpod.services.player.PlayList;
import mobi.beyondpod.services.player.PlayListEvents.PlayListEvent;
import mobi.beyondpod.services.player.PlayListEvents.PlayListEventListener;
import mobi.beyondpod.services.player.impl.ChromecastDevice;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.core.MasterViewState;
import mobi.beyondpod.ui.core.ThemeManager;
import mobi.beyondpod.ui.core.mediarouter.MediaRouteDiscoveryFragment;
import mobi.beyondpod.ui.core.mediarouter.MediaRouteDiscoveryFragment.IDiscoveryFragmentOwner;
import mobi.beyondpod.ui.search.RepositorySearchProvider;
import mobi.beyondpod.ui.views.base.IView;
import mobi.beyondpod.ui.views.base.TitleBarBase.TitleInfo;
import mobi.beyondpod.ui.views.base.TitleBarFeedContent;
import mobi.beyondpod.ui.views.base.WorkspaceViewManagerPager;

public class FeedContentViewActivity
  extends FragmentActivity
  implements PlayerView.IPlayerOwner, MediaRouteDiscoveryFragment.IDiscoveryFragmentOwner
{
  public static final int FEED_CONTENT_VIEW = 1;
  public static final int FILTER_HINT_MY_EPISODES = 1;
  public static final int FILTER_HINT_NORMAL = 0;
  public static final int FILTER_HINT_SERACH = -1;
  public static final int INVALID_VIEW = -1;
  private static final String LOADED_S_FEEDS = CoreHelper.LoadResourceString(2131296997);
  private static final String LOADING_FEEDS = CoreHelper.LoadResourceString(2131296998);
  public static final int PLAYER_VIEW = 2;
  private static final String TAG = FeedContentViewActivity.class.getSimpleName();
  private static int _InstanceCount;
  private boolean DataIsLoadedInWorkspaceViews;
  protected FeedContentView FeedContent;
  protected WorkspaceViewManagerPager Flipper;
  public PlayerView Player;
  private MasterViewState _InitialState;
  private final PlayListEvents.PlayListEventListener _PlaylistListener = new PlayListEvents.PlayListEventListener()
  {
    public void OnPlayListEvent(PlayListEvents.PlayListEvent paramAnonymousPlayListEvent)
    {
      if ((FeedContentViewActivity.this.Player != null) && (!FeedContentViewActivity.this.Player.IsActive())) {
        FeedContentViewActivity.this.Player.OnPlayListEvent(paramAnonymousPlayListEvent);
      }
    }
  };
  private final RepositoryEvents.RepositoryEventListener _RepositoryListener = new RepositoryEvents.RepositoryEventListener()
  {
    public void OnRepositoryEvent(final RepositoryEvents.RepositoryEvent paramAnonymousRepositoryEvent)
    {
      FeedContentViewActivity.this.runOnUiThread(new Runnable()
      {
        TitleBarBase.TitleInfo info = new TitleBarBase.TitleInfo();
        
        public void run()
        {
          if (paramAnonymousRepositoryEvent.Type == 0)
          {
            this.info.PrimaryTitle = FeedContentViewActivity.LOADING_FEEDS;
            FeedContentViewActivity.this.SetTitle(this.info);
            FeedContentViewActivity.this.SetTitleProgress(10);
          }
          do
          {
            return;
            if (paramAnonymousRepositoryEvent.Type == 1)
            {
              this.info.PrimaryTitle = String.format(FeedContentViewActivity.LOADED_S_FEEDS, new Object[] { Integer.valueOf(FeedRepository.GetFeedCount()) });
              FeedContentViewActivity.this.SetTitle(this.info);
              FeedContentViewActivity.this.SetTitleProgress(60);
              return;
            }
          } while (paramAnonymousRepositoryEvent.Type != 2);
          FeedContentViewActivity.this.FinishInitialization();
          FeedContentViewActivity.this.SetTitleProgress(100);
        }
      });
    }
  };
  private Bundle _SavedInstanceState;
  protected TitleBarFeedContent _Title;
  
  private void FinishInitialization()
  {
    if (this.DataIsLoadedInWorkspaceViews) {
      return;
    }
    WSLoadDataInWorkspaceViews();
    NavigateToViewBasedOnIntentSource(getIntent());
  }
  
  private void NavigateToViewBasedOnIntentSource(Intent paramIntent)
  {
    CoreHelper.WriteTraceEntry(TAG, "FeedContentView Received intent: " + paramIntent);
    OpenSearchResult(paramIntent);
  }
  
  private boolean OpenSearchResult(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getData() != null) && (paramIntent.getData().getPath() != null))
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
              LoadFeed(paramIntent, -1);
              ActivateView(1);
              return true;
            }
          }
          catch (Exception paramIntent) {}
        }
      }
    }
    return false;
  }
  
  public static boolean PlayPauseEnclosure(Context paramContext, RssEnclosure paramRssEnclosure)
  {
    if (paramRssEnclosure == null) {
      return false;
    }
    paramRssEnclosure = FeedContentListView.FindOrCreateStreamableTrack(paramRssEnclosure);
    if (paramRssEnclosure != null) {
      return CommandManager.CmdPlayPauseTrack(paramContext, paramRssEnclosure, null);
    }
    CommandManager.CmdNotifyStreamingNotAllowed(paramContext);
    return false;
  }
  
  private MasterViewState SaveCurrentState()
  {
    MasterViewState localMasterViewState = new MasterViewState();
    this.FeedContent.SaveCurrentState(localMasterViewState);
    localMasterViewState.CurrentView = this.Flipper.getCurrentView().getId();
    return localMasterViewState;
  }
  
  private void WSInitialize(MasterViewState paramMasterViewState, Bundle paramBundle)
  {
    this._InitialState = paramMasterViewState;
    this._SavedInstanceState = paramBundle;
    this.Flipper = ((WorkspaceViewManagerPager)findViewById(2131230976));
    this.DataIsLoadedInWorkspaceViews = false;
  }
  
  private void setActiveView(int paramInt)
  {
    if (ActiveViewIndex() == paramInt) {
      return;
    }
    WorkspaceViewManagerPager localWorkspaceViewManagerPager = this.Flipper;
    if (paramInt == 1) {}
    for (Object localObject = this.FeedContent;; localObject = this.Player)
    {
      localWorkspaceViewManagerPager.setCurrentView((View)localObject);
      return;
    }
  }
  
  public void ActivatePlayer()
  {
    setActiveView(2);
  }
  
  public void ActivateView(final int paramInt)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        IView localIView = FeedContentViewActivity.this.ActiveView();
        if (paramInt == 1) {}
        for (Object localObject = FeedContentViewActivity.this.FeedContent; (localObject == null) || ((localIView != null) && (localIView.equals(localObject))); localObject = FeedContentViewActivity.this.Player) {
          return;
        }
        FeedContentViewActivity.this.setActiveView(paramInt);
        FeedContentViewActivity.this.RefreshActiveViewTitle();
      }
    });
  }
  
  public IView ActiveView()
  {
    return (IView)this.Flipper.getCurrentView();
  }
  
  public int ActiveViewIndex()
  {
    View localView = this.Flipper.getCurrentView();
    if (localView != null) {
      return localView.getId();
    }
    return -1;
  }
  
  protected int ConfigureFeedFilter(int paramInt, Feed paramFeed)
  {
    int k = Configuration.getItemFilter();
    int i;
    int j;
    if ((paramFeed != null) && (paramFeed.Tracks().size() > 0))
    {
      i = 1;
      if ((paramFeed == null) || (!paramFeed.HasUnreadItems())) {
        break label49;
      }
      j = 1;
      label35:
      if (paramInt != 1) {
        break label55;
      }
      paramInt = 2;
    }
    label49:
    label55:
    do
    {
      do
      {
        return paramInt;
        i = 0;
        break;
        j = 0;
        break label35;
        paramInt = k;
      } while (!FeedContentListViewDataSource.IsEpisodeOnlyFilter(k));
      paramInt = k;
    } while (i != 0);
    if (j != 0) {
      return 1;
    }
    return 0;
  }
  
  public ViewGroup ContentRoot()
  {
    return (ViewGroup)findViewById(2131230975).getRootView();
  }
  
  public void LoadFeed(Feed paramFeed, int paramInt)
  {
    this.FeedContent.setCurrentFeed(paramFeed, paramInt);
  }
  
  public void PlayEnclosure(RssEnclosure paramRssEnclosure)
  {
    if (paramRssEnclosure == null) {}
    for (;;)
    {
      return;
      Track localTrack2 = paramRssEnclosure.GetLocalEnclosureTrack();
      Track localTrack1 = localTrack2;
      if (localTrack2 == null) {
        localTrack1 = FeedContentListView.FindOrCreateStreamableTrack(paramRssEnclosure);
      }
      if (localTrack1 == null)
      {
        CommandManager.CmdNotifyStreamingNotAllowed(this);
        return;
      }
      if (localTrack1.IsPlayed()) {
        localTrack1.ClearPlayed();
      }
      if (Configuration.AutoPlaylistEnabled()) {}
      for (paramRssEnclosure = this.FeedContent.FeedContentList.GeneratePlaylist(localTrack1); CommandManager.CmdPlayPauseTrack(this, localTrack1, paramRssEnclosure); paramRssEnclosure = null)
      {
        setActiveView(2);
        return;
      }
    }
  }
  
  public void RefreshActiveViewTitle()
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (FeedContentViewActivity.this.ActiveView() != null) {
          FeedContentViewActivity.this.SetTitle(FeedContentViewActivity.this.ActiveView().GetViewTitle());
        }
      }
    });
  }
  
  public void SetTitle(TitleBarBase.TitleInfo paramTitleInfo)
  {
    if (this._Title != null) {
      this._Title.setTitle(paramTitleInfo);
    }
  }
  
  public void SetTitleProgress(int paramInt)
  {
    if (this._Title != null) {
      this._Title.SetTitleProgress(paramInt);
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
  
  /* Error */
  protected void WSLoadDataInWorkspaceViews()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 246	mobi/beyondpod/ui/views/FeedContentViewActivity:_InitialState	Lmobi/beyondpod/ui/core/MasterViewState;
    //   4: ifnull +250 -> 254
    //   7: aload_0
    //   8: getfield 246	mobi/beyondpod/ui/views/FeedContentViewActivity:_InitialState	Lmobi/beyondpod/ui/core/MasterViewState;
    //   11: astore_3
    //   12: aload_3
    //   13: ifnonnull +316 -> 329
    //   16: new 218	mobi/beyondpod/ui/core/MasterViewState
    //   19: dup
    //   20: invokespecial 219	mobi/beyondpod/ui/core/MasterViewState:<init>	()V
    //   23: astore 4
    //   25: aload 4
    //   27: iconst_1
    //   28: putfield 242	mobi/beyondpod/ui/core/MasterViewState:CurrentView	I
    //   31: aload_0
    //   32: new 223	mobi/beyondpod/ui/views/FeedContentView
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 374	mobi/beyondpod/ui/views/FeedContentView:<init>	(Lmobi/beyondpod/ui/views/FeedContentViewActivity;)V
    //   40: putfield 221	mobi/beyondpod/ui/views/FeedContentViewActivity:FeedContent	Lmobi/beyondpod/ui/views/FeedContentView;
    //   43: aload_0
    //   44: getfield 221	mobi/beyondpod/ui/views/FeedContentViewActivity:FeedContent	Lmobi/beyondpod/ui/views/FeedContentView;
    //   47: iconst_1
    //   48: invokevirtual 377	mobi/beyondpod/ui/views/FeedContentView:setId	(I)V
    //   51: aload_0
    //   52: new 369	mobi/beyondpod/ui/views/PlayerView
    //   55: dup
    //   56: aload_0
    //   57: aload_0
    //   58: invokespecial 380	mobi/beyondpod/ui/views/PlayerView:<init>	(Landroid/content/Context;Lmobi/beyondpod/ui/views/PlayerView$IPlayerOwner;)V
    //   61: putfield 272	mobi/beyondpod/ui/views/FeedContentViewActivity:Player	Lmobi/beyondpod/ui/views/PlayerView;
    //   64: aload_0
    //   65: getfield 272	mobi/beyondpod/ui/views/FeedContentViewActivity:Player	Lmobi/beyondpod/ui/views/PlayerView;
    //   68: iconst_2
    //   69: invokevirtual 381	mobi/beyondpod/ui/views/PlayerView:setId	(I)V
    //   72: aload_0
    //   73: getfield 228	mobi/beyondpod/ui/views/FeedContentViewActivity:Flipper	Lmobi/beyondpod/ui/views/base/WorkspaceViewManagerPager;
    //   76: aload_0
    //   77: getfield 221	mobi/beyondpod/ui/views/FeedContentViewActivity:FeedContent	Lmobi/beyondpod/ui/views/FeedContentView;
    //   80: invokevirtual 384	mobi/beyondpod/ui/views/base/WorkspaceViewManagerPager:addPage	(Landroid/view/View;)V
    //   83: aload_0
    //   84: getfield 228	mobi/beyondpod/ui/views/FeedContentViewActivity:Flipper	Lmobi/beyondpod/ui/views/base/WorkspaceViewManagerPager;
    //   87: aload_0
    //   88: getfield 272	mobi/beyondpod/ui/views/FeedContentViewActivity:Player	Lmobi/beyondpod/ui/views/PlayerView;
    //   91: invokevirtual 384	mobi/beyondpod/ui/views/base/WorkspaceViewManagerPager:addPage	(Landroid/view/View;)V
    //   94: aload_0
    //   95: getfield 272	mobi/beyondpod/ui/views/FeedContentViewActivity:Player	Lmobi/beyondpod/ui/views/PlayerView;
    //   98: invokevirtual 387	mobi/beyondpod/ui/views/PlayerView:PlayListView	()Landroid/view/View;
    //   101: ifnull +14 -> 115
    //   104: aload_0
    //   105: aload_0
    //   106: getfield 272	mobi/beyondpod/ui/views/FeedContentViewActivity:Player	Lmobi/beyondpod/ui/views/PlayerView;
    //   109: invokevirtual 387	mobi/beyondpod/ui/views/PlayerView:PlayListView	()Landroid/view/View;
    //   112: invokevirtual 390	mobi/beyondpod/ui/views/FeedContentViewActivity:registerForContextMenu	(Landroid/view/View;)V
    //   115: aload_0
    //   116: aload_0
    //   117: getfield 221	mobi/beyondpod/ui/views/FeedContentViewActivity:FeedContent	Lmobi/beyondpod/ui/views/FeedContentView;
    //   120: getfield 345	mobi/beyondpod/ui/views/FeedContentView:FeedContentList	Lmobi/beyondpod/ui/views/FeedContentListView;
    //   123: invokevirtual 390	mobi/beyondpod/ui/views/FeedContentViewActivity:registerForContextMenu	(Landroid/view/View;)V
    //   126: aload 4
    //   128: getfield 394	mobi/beyondpod/ui/core/MasterViewState:ContentViewFeed	Lmobi/beyondpod/rsscore/Feed;
    //   131: ifnonnull +174 -> 305
    //   134: aconst_null
    //   135: astore 5
    //   137: aconst_null
    //   138: astore_3
    //   139: iconst_m1
    //   140: istore_2
    //   141: aload_0
    //   142: invokevirtual 96	mobi/beyondpod/ui/views/FeedContentViewActivity:getIntent	()Landroid/content/Intent;
    //   145: invokevirtual 130	android/content/Intent:getData	()Landroid/net/Uri;
    //   148: astore 6
    //   150: iload_2
    //   151: istore_1
    //   152: ldc_w 396
    //   155: aload 6
    //   157: invokevirtual 399	android/net/Uri:getScheme	()Ljava/lang/String;
    //   160: invokevirtual 403	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   163: ifeq +81 -> 244
    //   166: aload 6
    //   168: invokevirtual 407	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   171: astore 6
    //   173: aload 6
    //   175: invokeinterface 410 1 0
    //   180: ifle +21 -> 201
    //   183: aload 6
    //   185: iconst_0
    //   186: invokeinterface 414 2 0
    //   191: checkcast 137	java/lang/String
    //   194: invokestatic 186	java/util/UUID:fromString	(Ljava/lang/String;)Ljava/util/UUID;
    //   197: invokestatic 417	mobi/beyondpod/rsscore/Configuration:FindFeedByIdInTempOrRepository	(Ljava/util/UUID;)Lmobi/beyondpod/rsscore/Feed;
    //   200: astore_3
    //   201: aload_3
    //   202: astore 5
    //   204: iload_2
    //   205: istore_1
    //   206: aload 6
    //   208: invokeinterface 410 1 0
    //   213: iconst_1
    //   214: if_icmple +30 -> 244
    //   217: aload_3
    //   218: astore 5
    //   220: iload_2
    //   221: istore_1
    //   222: ldc_w 419
    //   225: aload 6
    //   227: iconst_1
    //   228: invokeinterface 414 2 0
    //   233: invokevirtual 403	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   236: ifeq +8 -> 244
    //   239: iconst_1
    //   240: istore_1
    //   241: aload_3
    //   242: astore 5
    //   244: aload 5
    //   246: ifnonnull +25 -> 271
    //   249: aload_0
    //   250: invokevirtual 422	mobi/beyondpod/ui/views/FeedContentViewActivity:finish	()V
    //   253: return
    //   254: aload_0
    //   255: getfield 248	mobi/beyondpod/ui/views/FeedContentViewActivity:_SavedInstanceState	Landroid/os/Bundle;
    //   258: invokestatic 426	mobi/beyondpod/ui/core/MasterViewState:FromBundle	(Landroid/os/Bundle;)Lmobi/beyondpod/ui/core/MasterViewState;
    //   261: astore_3
    //   262: goto -250 -> 12
    //   265: astore_3
    //   266: aconst_null
    //   267: astore_3
    //   268: goto -256 -> 12
    //   271: aload_0
    //   272: aload 5
    //   274: iload_1
    //   275: invokevirtual 194	mobi/beyondpod/ui/views/FeedContentViewActivity:LoadFeed	(Lmobi/beyondpod/rsscore/Feed;I)V
    //   278: aload_0
    //   279: aload 4
    //   281: getfield 242	mobi/beyondpod/ui/core/MasterViewState:CurrentView	I
    //   284: invokespecial 263	mobi/beyondpod/ui/views/FeedContentViewActivity:setActiveView	(I)V
    //   287: aload_0
    //   288: iconst_1
    //   289: putfield 89	mobi/beyondpod/ui/views/FeedContentViewActivity:DataIsLoadedInWorkspaceViews	Z
    //   292: return
    //   293: astore_3
    //   294: getstatic 62	mobi/beyondpod/ui/views/FeedContentViewActivity:TAG	Ljava/lang/String;
    //   297: ldc_w 428
    //   300: aload_3
    //   301: invokestatic 432	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   304: return
    //   305: aload_0
    //   306: getfield 221	mobi/beyondpod/ui/views/FeedContentViewActivity:FeedContent	Lmobi/beyondpod/ui/views/FeedContentView;
    //   309: aload 4
    //   311: invokevirtual 435	mobi/beyondpod/ui/views/FeedContentView:RestoreCurrentState	(Lmobi/beyondpod/ui/core/MasterViewState;)V
    //   314: aload_0
    //   315: getfield 221	mobi/beyondpod/ui/views/FeedContentViewActivity:FeedContent	Lmobi/beyondpod/ui/views/FeedContentView;
    //   318: aconst_null
    //   319: invokevirtual 439	mobi/beyondpod/ui/views/FeedContentView:RestoreFeedContentState	(Landroid/os/Bundle;)V
    //   322: goto -44 -> 278
    //   325: astore_3
    //   326: goto -32 -> 294
    //   329: aload_3
    //   330: astore 4
    //   332: goto -301 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	this	FeedContentViewActivity
    //   151	124	1	i	int
    //   140	81	2	j	int
    //   11	251	3	localObject1	Object
    //   265	1	3	localException1	Exception
    //   267	1	3	localObject2	Object
    //   293	8	3	localException2	Exception
    //   325	5	3	localException3	Exception
    //   23	308	4	localObject3	Object
    //   135	138	5	localObject4	Object
    //   148	78	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   0	12	265	java/lang/Exception
    //   254	262	265	java/lang/Exception
    //   25	31	293	java/lang/Exception
    //   31	115	293	java/lang/Exception
    //   115	134	293	java/lang/Exception
    //   141	150	293	java/lang/Exception
    //   152	173	293	java/lang/Exception
    //   173	201	293	java/lang/Exception
    //   206	217	293	java/lang/Exception
    //   222	239	293	java/lang/Exception
    //   249	253	293	java/lang/Exception
    //   271	278	293	java/lang/Exception
    //   278	292	293	java/lang/Exception
    //   305	322	293	java/lang/Exception
    //   16	25	325	java/lang/Exception
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
      CoreHelper.WriteTraceEntryInDebug(TAG, "###### FeedContentView FINALIZED! Remaining instances: " + _InstanceCount);
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
    setActiveView(2);
  }
  
  public void onConnectionRefused()
  {
    Toast.makeText(this, 2131297091, 1).show();
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return ActiveView().HandleContextMenu(paramMenuItem);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (ThemeManager.CurrentFeedContentViewDialogTheme() != -1) {
      setTheme(ThemeManager.CurrentFeedContentViewDialogTheme());
    }
    _InstanceCount += 1;
    CoreHelper.WriteTraceEntryInDebug(TAG, "###### FeedContentView Created! Current instances: " + _InstanceCount);
    if (_InstanceCount > 1) {
      CoreHelper.WriteTraceErrorInDebug(TAG, "################## Possible FeedContentView Leak ############ " + _InstanceCount);
    }
    super.onCreate(paramBundle);
    BeyondPodApplication.MessageBus.Subscribe(this._RepositoryListener, RepositoryEvents.RepositoryEvent.class);
    BeyondPodApplication.MessageBus.Subscribe(this._PlaylistListener, PlayListEvents.PlayListEvent.class);
    if (Configuration.OrientationLock() == 2) {
      setRequestedOrientation(0);
    }
    for (;;)
    {
      requestWindowFeature(7);
      if (Configuration.PreventKeyguard()) {
        getWindow().addFlags(0x80000 | 0x100000);
      }
      setContentView(2130903111);
      getWindow().setFeatureInt(7, 2130903083);
      this._Title = ((TitleBarFeedContent)findViewById(2131230862));
      this._Title.Initialize(this);
      WSInitialize(null, paramBundle);
      if (FeedRepository.IsRepositoryAvailable()) {
        FinishInitialization();
      }
      paramBundle = getSupportFragmentManager();
      if (paramBundle.findFragmentByTag("DiscoveryFragment") == null)
      {
        MediaRouteDiscoveryFragment localMediaRouteDiscoveryFragment = new MediaRouteDiscoveryFragment();
        localMediaRouteDiscoveryFragment.setOwner(this);
        localMediaRouteDiscoveryFragment.setRouteSelector(BeyondPodApplication.GetInstance().ChromecastDevice().getRouteSelector());
        paramBundle.beginTransaction().add(localMediaRouteDiscoveryFragment, "DiscoveryFragment").commit();
      }
      return;
      if (Configuration.OrientationLock() == 1) {
        setRequestedOrientation(1);
      }
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if (ActiveView() != null) {
      ActiveView().PrepareContextMenu(paramContextMenu, paramContextMenuInfo);
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    BeyondPodApplication.MessageBus.Unsubscribe(this._RepositoryListener, RepositoryEvents.RepositoryEvent.class);
    BeyondPodApplication.MessageBus.Unsubscribe(this._PlaylistListener, PlayListEvents.PlayListEvent.class);
    if (this.Player != null) {
      this.Player.OnActivityDestroy();
    }
    if (this.FeedContent != null) {
      this.FeedContent.OnActivityDestroy();
    }
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
      if ((ActiveViewIndex() == 2) && (this.Player != null) && (this.Player.IsPlaylistVisible()))
      {
        this.Player.TogglePlaylist(false);
        return true;
      }
      if (ActiveViewIndex() != 1)
      {
        ActivateView(1);
        return true;
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    NavigateToViewBasedOnIntentSource(paramIntent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return ActiveView().HandleOptionsMenu(0, paramMenuItem);
    }
    finish();
    return true;
  }
  
  protected void onPause()
  {
    super.onPause();
    if (ActiveView() != null) {
      ActiveView().OnAfterDeactivate(false);
    }
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    if (FeedRepository.IsRepositoryAvailable()) {
      FinishInitialization();
    }
    do
    {
      return;
      CoreHelper.WriteTraceEntry(TAG, "OnPostResume found that repository is not loaded! (repo state is: " + FeedRepository.RepositoryLoadState() + ") Loading repository...");
    } while (FeedRepository.InitializeAndLoadRepository());
    String str2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder("Repository can not be loaded at this time!");
    if (!FeedRepository.CanRepositoryBeLoaded()) {}
    for (String str1 = " (probably the storage card is not currently available)";; str1 = "")
    {
      CoreHelper.WriteTraceEntry(str2, str1 + " Exiting...");
      finish();
      return;
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (this.FeedContent == null) {
      return false;
    }
    return ActiveView().PrepareOptionsMenu(paramMenu);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
  }
  
  protected void onResume()
  {
    super.onResume();
    if ((ActiveView() != null) && (!ActiveView().IsActive()))
    {
      ActiveView().OnBeforeActivate();
      ActiveView().OnAfterActivate();
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.FeedContent != null) {
      SaveCurrentState().ToBundle(paramBundle);
    }
    if (getChangingConfigurations() == 0)
    {
      ItemStateHistory.SaveHistoryAsync();
      FeedRepository.SaveRepositoryAsync();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/FeedContentViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */