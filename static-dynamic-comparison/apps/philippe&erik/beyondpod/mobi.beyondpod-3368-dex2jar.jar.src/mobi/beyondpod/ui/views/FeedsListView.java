package mobi.beyondpod.ui.views;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.provider.Browser;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.TextView;
import java.util.UUID;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.downloadengine.UpdateAndDownloadManager;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.AnalyticsTracker;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEvent;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEventListener;
import mobi.beyondpod.sync.ChangeTracker;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.commands.RefreshVirtualFeedTask;
import mobi.beyondpod.ui.commands.RefreshVirtualFeedTask.ITrackImageRefreshProgress;
import mobi.beyondpod.ui.core.ScaleGestureHelper;
import mobi.beyondpod.ui.core.ScaleGestureHelper.OnScaleGestureListener;
import mobi.beyondpod.ui.core.SimpleMenu;
import mobi.beyondpod.ui.core.volley.ImageLoader;
import mobi.beyondpod.ui.core.volley.ImageLoaderFeed;
import mobi.beyondpod.ui.views.base.IView;
import mobi.beyondpod.ui.views.base.ListViewEx;
import mobi.beyondpod.ui.views.base.TitleBarBase.TitleInfo;

public class FeedsListView
  extends ListViewEx
  implements IView, View.OnClickListener, View.OnLongClickListener, RepositoryEvents.RepositoryEventListener, AbsListView.OnScrollListener
{
  private static final String ALL_FEEDS = CoreHelper.LoadResourceString(2131297059);
  private static final int MENU_DELETE_FEED = 17;
  private static final int MENU_EDIT_FEED = 16;
  private static final int MENU_FIRST = 15;
  private static final int MENU_SEND_TO_OTHER_DEVICES = 21;
  private static final int MENU_SHARE_FEED_URL = 20;
  private static final int MENU_STOP_UPDATE = 19;
  private static final int MENU_UPDATE_FEED = 18;
  public boolean ViewIsScrolling = false;
  private FeedsViewAdapter _Adapter;
  ImageLoaderFeed _ImageLoader;
  View _InfoFooter;
  private boolean _IsActive = false;
  private FeedsView _Owner;
  private TitleBarBase.TitleInfo _Title = new TitleBarBase.TitleInfo();
  ScaleGestureHelper _scaleDetector;
  
  public FeedsListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void NotifyItemsFiltered()
  {
    removeFooterView(this._InfoFooter);
    if (!HasHiddenFeeds()) {
      return;
    }
    ((TextView)this._InfoFooter.findViewById(2131230901)).setText(this._Owner.getResources().getString(2131296916));
    ((TextView)this._InfoFooter.findViewById(2131230959)).setText("");
    addFooterView(this._InfoFooter, null, false);
    this._InfoFooter.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        FeedsListView.this._Adapter.ToggleReadFeeds(true);
      }
    });
  }
  
  private void RefreshTitle()
  {
    if (MasterView.Master() != null) {
      MasterView.Master().RefreshActiveViewTitle();
    }
  }
  
  private void RefreshVirtualFeed(Feed paramFeed)
  {
    final ProgressDialog localProgressDialog = new ProgressDialog(MasterView.Master());
    localProgressDialog.setIndeterminate(true);
    localProgressDialog.setMessage(CoreHelper.LoadResourceString(2131297046));
    localProgressDialog.setCancelable(false);
    new RefreshVirtualFeedTask(new RefreshVirtualFeedTask.ITrackImageRefreshProgress()
    {
      public void OnRefreshCompleted()
      {
        if (localProgressDialog != null) {
          localProgressDialog.dismiss();
        }
        MasterView.Master().RestoreCurrentScreenOrientation();
      }
      
      public void OnRefreshProgress(int paramAnonymousInt)
      {
        localProgressDialog.setMessage(this.val$RETRIEVING_FEED + " " + paramAnonymousInt + " %");
      }
      
      public void OnRefreshStarted()
      {
        MasterView.Master().LockCurrentScreenOrientation();
        localProgressDialog.show();
      }
    }).execute(new Feed[] { paramFeed });
  }
  
  public boolean AllowScrollLeftRightFor(float paramFloat1, float paramFloat2)
  {
    return true;
  }
  
  public int FeedCount()
  {
    return this._Adapter.FeedCount();
  }
  
  public FeedList Feeds()
  {
    return this._Adapter.Feeds();
  }
  
  public TitleBarBase.TitleInfo GetViewTitle()
  {
    this._Title.PrimaryTitle = null;
    this._Title.SubTitle = null;
    if ((this._Adapter == null) || (this._Adapter.getRootFeed() == null)) {
      return this._Title;
    }
    Object localObject;
    int i;
    int j;
    StringBuilder localStringBuilder;
    if (Configuration.getActiveFeedCategory().equals(CategoryManager.AllFeeds))
    {
      str = ALL_FEEDS;
      localObject = str;
      if (FeedRepository.getRootFeed() != this._Adapter.getRootFeed())
      {
        localObject = str;
        if (this._Adapter.getRootFeed().SubFeeds().size() > 0) {
          localObject = str + " > " + this._Adapter.getRootFeed().getName();
        }
      }
      this._Title.PrimaryTitle = ((String)localObject);
      i = this._Adapter.FeedCount();
      j = this._Adapter.HiddenFeedCount();
      localObject = this._Title;
      localStringBuilder = new StringBuilder(String.valueOf(this._Adapter.FeedCount()));
      if (!this._Adapter.HasHiddenFeeds()) {
        break label232;
      }
    }
    label232:
    for (String str = "/" + (i + j);; str = "")
    {
      ((TitleBarBase.TitleInfo)localObject).SubTitle = str;
      return this._Title;
      str = Configuration.getActiveFeedCategory().Name();
      break;
    }
  }
  
  public boolean HandleContextMenu(MenuItem paramMenuItem)
  {
    AdapterView.AdapterContextMenuInfo localAdapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo();
    Feed localFeed = null;
    if (localAdapterContextMenuInfo != null) {
      localFeed = this._Adapter.getFeedAtPosition(localAdapterContextMenuInfo.position);
    }
    if (localFeed == null) {}
    while (localFeed.IsSubFeed()) {
      return false;
    }
    switch (paramMenuItem.getItemId())
    {
    default: 
      return HandleOptionsMenu(0, paramMenuItem);
    case 17: 
      CommandManager.CmdDeleteFeed(getContext(), localFeed);
      return true;
    case 16: 
      CommandManager.CmdEditFeed(localFeed, -1);
      return true;
    case 18: 
      if (localFeed.getType() == 1) {
        RefreshVirtualFeed(localFeed);
      }
      for (;;)
      {
        return true;
        paramMenuItem = new FeedList();
        paramMenuItem.add(localFeed);
        CommandManager.CmdUpdateFeeds(paramMenuItem, false);
      }
    case 19: 
      CommandManager.CmdStopAllUpdates();
      return true;
    case 20: 
      Browser.sendString(getContext(), localFeed.getName() + "  (" + localFeed.getFeedUrl() + ")");
      return true;
    }
    ChangeTracker.AddLocalFeedChange(14, localFeed, 15);
    return true;
  }
  
  public boolean HandleOptionsMenu(int paramInt, MenuItem paramMenuItem)
  {
    return false;
  }
  
  public boolean HasHiddenFeeds()
  {
    return this._Adapter.HasHiddenFeeds();
  }
  
  public boolean HasReadFeeds()
  {
    return this._Adapter.HasReadFeeds();
  }
  
  public void Initialize(FeedsView paramFeedsView)
  {
    this._Owner = paramFeedsView;
    this._scaleDetector = ScaleGestureHelper.getInstance();
    this._scaleDetector.Initialize(getContext(), new ScaleListener(null));
    this._ImageLoader = new ImageLoaderFeed(MasterView.Master());
    this._InfoFooter = LayoutInflater.from(getContext()).inflate(2130903107, null);
    setFooterDividersEnabled(false);
    setFadingEdgeLength((int)getResources().getDimension(2131492952));
    setVerticalFadingEdgeEnabled(true);
    addFooterView(this._InfoFooter, null, false);
    this._Adapter = new FeedsViewAdapter(getContext(), this);
    setAdapter(this._Adapter);
    removeFooterView(this._InfoFooter);
    this._Adapter.setIfEmptyText(getContext().getString(2131297205));
    setOnScrollListener(this);
  }
  
  public boolean IsActive()
  {
    return this._IsActive;
  }
  
  public Feed NextFeed(Feed paramFeed)
  {
    if (this._Adapter == null) {
      return null;
    }
    return this._Adapter.NextFeed(paramFeed);
  }
  
  public Feed NextUnreadFeed(Feed paramFeed)
  {
    if (this._Adapter == null) {
      return null;
    }
    return this._Adapter.NextUnreadFeed(paramFeed);
  }
  
  public void OnActivityDestroy()
  {
    this._ImageLoader.release();
  }
  
  public void OnAfterActivate()
  {
    AnalyticsTracker.OnViewDisplayed("Feeds List View");
    RefreshTitle();
    this._IsActive = true;
  }
  
  public void OnAfterDeactivate(boolean paramBoolean)
  {
    BeyondPodApplication.MessageBus.Unsubscribe(this, RepositoryEvents.RepositoryEvent.class);
    this._IsActive = false;
  }
  
  public void OnBeforeActivate()
  {
    this.ViewIsScrolling = false;
    BeyondPodApplication.MessageBus.Subscribe(this, RepositoryEvents.RepositoryEvent.class);
    if (this._Adapter != null) {
      this._Adapter.Refresh();
    }
  }
  
  protected void OnItemSelected(int paramInt)
  {
    Feed localFeed1 = this._Adapter.getFeedAtPosition(paramInt);
    if (localFeed1 != null)
    {
      Feed localFeed2 = this._Adapter.getRootFeed();
      if ((localFeed2.CanNavigateUp()) && (localFeed1.equals(FeedRepository.getGoUpPlaceholder())))
      {
        OpenDefaultFeedView(localFeed2.ParentFeed());
        return;
      }
      OpenDefaultFeedView(localFeed1);
      return;
    }
    this._Adapter.ToggleReadFeeds(this._Adapter.HasHiddenFeeds());
  }
  
  public void OnRepositoryEvent(RepositoryEvents.RepositoryEvent paramRepositoryEvent)
  {
    if ((paramRepositoryEvent.Type == 5) && (paramRepositoryEvent.Feed != null)) {
      this._Adapter.RefreshFeed(paramRepositoryEvent.Feed);
    }
    if ((paramRepositoryEvent.Type == 8) || (paramRepositoryEvent.Type == 10) || (paramRepositoryEvent.Type == 7))
    {
      this._Adapter.Refresh();
      RefreshTitle();
    }
    if (paramRepositoryEvent.Type == 2) {
      this._Adapter.notifyDataSetChanged();
    }
  }
  
  public void OpenDefaultFeedView(Feed paramFeed)
  {
    if (paramFeed == null) {
      return;
    }
    if (paramFeed.SubFeeds().size() != 0)
    {
      SetRootFeed(paramFeed);
      Feed localFeed = paramFeed;
      if (paramFeed == FeedRepository.getRootFeed()) {
        localFeed = null;
      }
      Configuration.setActiveFeedFilter(localFeed);
      return;
    }
    CommandManager.CmdOpenFeed(paramFeed);
  }
  
  public void PrepareContextMenu(ContextMenu paramContextMenu, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AdapterView.AdapterContextMenuInfo localAdapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = null;
    if (localAdapterContextMenuInfo != null) {
      paramContextMenuInfo = this._Adapter.getFeedAtPosition(localAdapterContextMenuInfo.position);
    }
    if (paramContextMenuInfo == null) {
      break label27;
    }
    label27:
    while (paramContextMenuInfo.IsSubFeed()) {
      return;
    }
    if (!UpdateAndDownloadManager.IsWorking()) {
      paramContextMenu.add(0, 18, 1, 2131296655).setIcon(2130837974);
    }
    for (;;)
    {
      paramContextMenu.add(0, 17, 2, 2131296653).setIcon(2130837948);
      paramContextMenu.add(0, 16, 3, 2131296654).setIcon(2130837951);
      paramContextMenu.add(0, 20, 4, 2131296670);
      if ((!ChangeTracker.IsTrackingEnabled()) || (!paramContextMenuInfo.HasUrl())) {
        break;
      }
      paramContextMenu.add(0, 21, 5, 2131297235);
      return;
      paramContextMenu.add(0, 19, 1, 2131296664).setIcon(2130837984);
    }
  }
  
  public boolean PrepareOptionsMenu(Menu paramMenu)
  {
    return false;
  }
  
  public SimpleMenu PreparePopupOptionsMenu()
  {
    return null;
  }
  
  public Feed PreviousFeed(Feed paramFeed)
  {
    if (this._Adapter == null) {
      return null;
    }
    return this._Adapter.PreviousFeed(paramFeed);
  }
  
  Feed RootFeed()
  {
    if (this._Adapter != null) {
      return this._Adapter.getRootFeed();
    }
    return null;
  }
  
  public void SetRootFeed(Feed paramFeed)
  {
    if ((RootFeed() != null) && (paramFeed != null) && (!RootFeed().ID().equals(paramFeed.ID()))) {}
    for (int i = 1;; i = 0)
    {
      this._Adapter.SetRootFeed(paramFeed);
      RefreshTitle();
      if (i != 0) {
        postDelayed(new Runnable()
        {
          public void run()
          {
            FeedsListView.this.setSelectionAfterHeaderView();
          }
        }, 100L);
      }
      postDelayed(new Runnable()
      {
        public void run()
        {
          FeedsListView.this._Adapter.PrefetchItemImages();
        }
      }, 1000L);
      return;
    }
  }
  
  public void ToggleReadFeeds(boolean paramBoolean)
  {
    this._Adapter.ToggleReadFeeds(paramBoolean);
  }
  
  void ToggleReadItems()
  {
    if (this._Adapter.HasReadFeeds()) {
      this._Adapter.ToggleReadFeeds(false);
    }
    while (!this._Adapter.HasHiddenFeeds()) {
      return;
    }
    this._Adapter.ToggleReadFeeds(true);
  }
  
  public void UpdateFooterToolbar()
  {
    NotifyItemsFiltered();
    this._Owner.UpdateFooterToolbar();
  }
  
  ImageLoader getImageLoader()
  {
    return this._ImageLoader;
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if (paramView != null) {
      CommandManager.CmdOpenPodcastsView(FeedRepository.GetFeedById((UUID)paramView));
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    paramView = paramView.getTag();
    if (paramView != null)
    {
      paramView = FeedRepository.GetFeedById((UUID)paramView);
      if ((paramView != null) && (CommandManager.CmdPlayFeedEpisodes(getContext(), paramView, paramView.getLocalOrInheritedTrackSortOrder()))) {
        MasterView.Master().ActivatePlayer();
      }
    }
    return true;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.ViewIsScrolling = false;
      int i = paramAbsListView.getFirstVisiblePosition();
      int j = paramAbsListView.getChildCount();
      paramInt = 0;
      for (;;)
      {
        if (paramInt >= j)
        {
          this._Adapter.PrefetchItemImages();
          return;
        }
        this._Adapter.getView(i + paramInt, paramAbsListView.getChildAt(paramInt), paramAbsListView);
        paramInt += 1;
      }
    case 1: 
      this.ViewIsScrolling = false;
      return;
    }
    this.ViewIsScrolling = true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this._scaleDetector != null) {
      this._scaleDetector.onTouchEvent(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  private class ScaleListener
    implements ScaleGestureHelper.OnScaleGestureListener
  {
    private ScaleListener() {}
    
    public boolean onScale(float paramFloat)
    {
      if ((paramFloat > 1.1D) && (FeedsListView.this._Adapter.HasHiddenFeeds()))
      {
        Configuration.setHideReadFeeds(false);
        FeedsListView.this._Adapter.ToggleReadFeeds(true);
        return true;
      }
      if ((paramFloat < 0.9D) && (FeedsListView.this._Adapter.HasReadFeeds()))
      {
        Configuration.setHideReadFeeds(true);
        FeedsListView.this._Adapter.ToggleReadFeeds(false);
        return true;
      }
      return false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/FeedsListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */