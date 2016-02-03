package mobi.beyondpod.ui.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.TextView;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.downloadengine.EnclosureDownloadManager;
import mobi.beyondpod.downloadengine.EnclosureDownloadManager.DownloadableEnclosure;
import mobi.beyondpod.downloadengine.UpdateAndDownloadManager;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.AnalyticsTracker;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.CoreHelper.TrackSizeInfo;
import mobi.beyondpod.rsscore.rss.entities.RssEnclosure;
import mobi.beyondpod.services.player.PlayList;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.core.SimpleMenu;
import mobi.beyondpod.ui.core.volley.ImageLoader;
import mobi.beyondpod.ui.core.volley.ImageLoaderTrack;
import mobi.beyondpod.ui.views.base.IView;
import mobi.beyondpod.ui.views.base.ListViewEx;
import mobi.beyondpod.ui.views.base.TitleBarBase.TitleInfo;

public class PodcastsListView
  extends ListViewEx
  implements IView, AbsListView.OnScrollListener, View.OnClickListener, View.OnLongClickListener
{
  private static final String BEYOND_POD_FAQ = CoreHelper.LoadResourceString(2131297093);
  private static final int MENU_ADD_TO_PLAYLIST = 5;
  private static final int MENU_DELETE_PODCAST = 2;
  private static final int MENU_GO_TO_FEED = 8;
  private static final int MENU_PLAY_IN_EXTERNAL_PLAYER = 10;
  private static final int MENU_REMOVE_FROM_PLAYLIST = 6;
  private static final int MENU_RESUME_OR_STOP_DOWNLOAD = 4;
  private static final int MENU_SHARE_PODCAST_URL = 7;
  private static final int MENU_TOGGLE_LOCK_PODCAST = 9;
  private static final int MENU_TOGGLE_PLAYED = 24;
  public static final int MULTISELECT_ALL = 1;
  public static final int MULTISELECT_NONE = 2;
  public static final int MULTISELECT_PLAYED = 3;
  public static final int MULTISELECT_TOP_LARGEST = 5;
  public static final int MULTISELECT_TOP_OLDEST = 4;
  private static final int NUM_LARGEST_TO_GET = 3;
  private static final int NUM_OLDEST_TO_GET = 3;
  public boolean ViewIsScrolling = false;
  private PodcastsViewAdapter _Adapter;
  PodcastListChangedListener _FilterChangedListener;
  private ImageLoader _ImageLoader;
  View _InfoFooter;
  private boolean _IsActive = false;
  private TitleBarBase.TitleInfo _Title = new TitleBarBase.TitleInfo();
  
  public PodcastsListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void CheckTracks(List<Track> paramList)
  {
    int i = 0;
    for (;;)
    {
      if (i == this._Adapter.getCount()) {
        return;
      }
      if (paramList.contains(this._Adapter.getTrackAt(i))) {
        setItemChecked(i, true);
      }
      i += 1;
    }
  }
  
  private void NotifyIfEpisodesFiltered()
  {
    if ((VisibleListSize() == 0) || ((TotalListSize() > 0) && (VisibleListSize() == TotalListSize())))
    {
      localObject = Configuration.getActiveFeedFilter();
      if ((localObject != null) && (((Feed)localObject).HasUrl()) && (VisibleListSize() > 0))
      {
        ((TextView)this._InfoFooter.findViewById(2131230901)).setText(getResources().getString(2131296935));
        ((TextView)this._InfoFooter.findViewById(2131230959)).setVisibility(8);
        addFooterView(this._InfoFooter, null, false);
        this._InfoFooter.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            PodcastsListView.this.OpenFeedContent(localObject);
          }
        });
      }
      return;
    }
    int i = CoreHelper.FindIndexInNumArray(getContext(), 2131623945, Integer.valueOf(Configuration.getActiveMediaFilter()));
    final Object localObject = (TextView)this._InfoFooter.findViewById(2131230901);
    Resources localResources = getResources();
    String[] arrayOfString = getResources().getStringArray(2131623944);
    if (i >= 0) {}
    for (;;)
    {
      ((TextView)localObject).setText(localResources.getString(2131296936, new Object[] { arrayOfString[i] }));
      ((TextView)this._InfoFooter.findViewById(2131230959)).setVisibility(8);
      addFooterView(this._InfoFooter, null, false);
      this._InfoFooter.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          PodcastsListView.this.ShowAllEpisodes();
        }
      });
      return;
      i = 0;
    }
  }
  
  private void OpenFeedContent(Feed paramFeed)
  {
    Configuration.setItemFilter(0);
    CommandManager.CmdOpenFeed(paramFeed);
  }
  
  private void PlayTrack(Track paramTrack)
  {
    if (paramTrack == null) {}
    do
    {
      return;
      if (paramTrack.IsPlayed()) {
        paramTrack.ClearPlayed();
      }
    } while (!CommandManager.CmdPlayPauseTrack(getContext(), paramTrack, this._Adapter.GeneratePlaylist(paramTrack)));
    MasterView.Master().ActivatePlayer();
  }
  
  private void ShowAllEpisodes()
  {
    Configuration.setActiveMediaFilter(0);
    if (this._FilterChangedListener != null) {
      this._FilterChangedListener.OnFilterChaged();
    }
    ReloadTracks();
  }
  
  public boolean AllowScrollLeftRightFor(float paramFloat1, float paramFloat2)
  {
    return true;
  }
  
  public int CurrentMultiselectMode()
  {
    return this._Adapter.CurrentMultiselectMode();
  }
  
  public TrackList GeneratePlaylistFrom(int paramInt)
  {
    Track localTrack = this._Adapter.getTrackAt(paramInt);
    return this._Adapter.GeneratePlaylist(localTrack);
  }
  
  public TrackList GetAllPlayedPodcasts()
  {
    return this._Adapter.GetAllPlayedPodcasts();
  }
  
  public CoreHelper.TrackSizeInfo GetCheckedSizeOnDiskFor(TrackList paramTrackList)
  {
    CoreHelper.TrackSizeInfo localTrackSizeInfo = new CoreHelper.TrackSizeInfo();
    paramTrackList = paramTrackList.iterator();
    for (;;)
    {
      if (!paramTrackList.hasNext()) {
        return localTrackSizeInfo;
      }
      Track localTrack = (Track)paramTrackList.next();
      localTrackSizeInfo.SizeOnDisk += localTrack.getSizeOnDisk();
    }
  }
  
  public List<Track> GetCurrentPlaylist()
  {
    return this._Adapter.GeneratePlaylist(null);
  }
  
  public CoreHelper.TrackSizeInfo GetCurrentTracksSizeOnDisk()
  {
    return this._Adapter.GetCurrentTracksSizeOnDisk();
  }
  
  public TitleBarBase.TitleInfo GetViewTitle()
  {
    TitleBarBase.TitleInfo localTitleInfo = this._Title;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(VisibleListSize()));
    Object localObject;
    if (TotalListSize() == VisibleListSize())
    {
      localObject = "";
      localTitleInfo.SubTitle = ((String)localObject);
      localObject = Configuration.getActiveFeedFilter();
      if (localObject != null) {
        break label137;
      }
      localTitleInfo = this._Title;
      if (Configuration.getActiveFeedCategory() == null) {
        break label130;
      }
      if (Configuration.getActiveFeedCategory() != CategoryManager.AllFeeds) {
        break label120;
      }
      localObject = getResources().getString(2131296377);
    }
    label86:
    label120:
    label130:
    label137:
    for (localTitleInfo.PrimaryTitle = ((String)localObject);; this._Title.PrimaryTitle = ((Feed)localObject).getName())
    {
      return this._Title;
      localObject = "/" + TotalListSize();
      break;
      localObject = Configuration.getActiveFeedCategory().Name();
      break label86;
      localObject = "";
      break label86;
    }
  }
  
  public boolean HandleContextMenu(MenuItem paramMenuItem)
  {
    AdapterView.AdapterContextMenuInfo localAdapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo();
    Track localTrack = null;
    if (localAdapterContextMenuInfo != null) {
      localTrack = this._Adapter.getTrackAt(localAdapterContextMenuInfo.position);
    }
    if (localTrack == null) {
      return false;
    }
    switch (paramMenuItem.getItemId())
    {
    default: 
      return HandleOptionsMenu(0, paramMenuItem);
    case 24: 
      CommandManager.CmdTogglePlayedState(localTrack);
      return true;
    case 2: 
      paramMenuItem = new TrackList();
      paramMenuItem.add(localTrack);
      CommandManager.CmdDeletePodcasts(MasterView.Master(), paramMenuItem);
      return true;
    case 4: 
      paramMenuItem = new File(localTrack.TrackPath());
      paramMenuItem = new RssEnclosure(localTrack.getUrl(), paramMenuItem.getParent(), paramMenuItem.getName(), localTrack.ContentMimeType(), localTrack.RssItemID(), localTrack.getDownloadSize(), localTrack.getLastModifiedDate(), localTrack.DisplayName());
      if (localTrack.getDownloadStatus() == 2) {
        UpdateAndDownloadManager.TerminateAll();
      }
      for (;;)
      {
        return true;
        if (EnclosureDownloadManager.IsDownloadPending(paramMenuItem))
        {
          EnclosureDownloadManager.RemoveFromQueue(paramMenuItem);
        }
        else
        {
          paramMenuItem = new EnclosureDownloadManager.DownloadableEnclosure(localTrack.getParentFeed(), paramMenuItem);
          FeedContentListView.DownloadEnclosures(getContext(), paramMenuItem);
        }
      }
    case 5: 
      CommandManager.CmdAddToPlaylist(localTrack);
      return true;
    case 10: 
      CommandManager.CmdOpenExternalPlayer(getContext(), localTrack);
      return true;
    case 6: 
      CommandManager.CmdRemoveFromPlaylist(localTrack);
      return true;
    case 7: 
      CommandManager.CmdSharePodcast(getContext(), localTrack);
      return true;
    case 8: 
      CommandManager.CmdOpenFeed(localTrack.getParentFeed());
      return true;
    }
    if (localTrack.AllowAutoDelete()) {
      CommandManager.CmdLockTrack(getContext(), localTrack);
    }
    for (;;)
    {
      return true;
      CommandManager.CmdUnlockTrack(getContext(), localTrack);
    }
  }
  
  public boolean HandleOptionsMenu(int paramInt, MenuItem paramMenuItem)
  {
    return false;
  }
  
  protected void InitializeView()
  {
    super.InitializeView();
    setFooterDividersEnabled(false);
    this._ImageLoader = new ImageLoaderTrack(MasterView.Master());
    this._InfoFooter = LayoutInflater.from(getContext()).inflate(2130903107, null);
    addFooterView(this._InfoFooter, null, false);
    this._Adapter = new PodcastsViewAdapter(getContext(), this);
    setAdapter(this._Adapter);
    removeFooterView(this._InfoFooter);
    setFadingEdgeLength((int)getResources().getDimension(2131492952));
    setVerticalFadingEdgeEnabled(true);
    setTextFilterEnabled(false);
    setOnScrollListener(this);
    setCacheColorHint(0);
    ReloadTracks();
  }
  
  public boolean IsActive()
  {
    return this._IsActive;
  }
  
  public boolean IsEmpty()
  {
    return VisibleListSize() == 0;
  }
  
  public void OnActivityDestroy()
  {
    this._ImageLoader.release();
  }
  
  public void OnAfterActivate()
  {
    AnalyticsTracker.OnViewDisplayed("Podcasts View");
    this._IsActive = true;
  }
  
  public void OnAfterDeactivate(boolean paramBoolean)
  {
    this._IsActive = false;
  }
  
  public void OnBeforeActivate()
  {
    if (this._Adapter != null) {
      this._Adapter.LoadDefaultFontSize();
    }
    this.ViewIsScrolling = false;
    if (CurrentMultiselectMode() != 1) {
      ReloadTracks();
    }
  }
  
  protected void OnItemChecked(int paramInt)
  {
    Track localTrack;
    if (CurrentMultiselectMode() == 2)
    {
      localTrack = this._Adapter.getTrackAt(paramInt);
      if (!BeyondPodApplication.GetInstance().PlayList().HasTrack(localTrack)) {
        break label47;
      }
      CommandManager.CmdRemoveFromPlaylist(localTrack);
    }
    for (;;)
    {
      MasterView.Master().Workspace.PodcastsList.RefreshMultiselectTitle();
      return;
      label47:
      CommandManager.CmdAddToPlaylist(localTrack);
    }
  }
  
  protected void OnItemSelected(int paramInt)
  {
    Object localObject = this._Adapter.getTrackAt(paramInt);
    if (localObject != null)
    {
      if (!Configuration.FeedContentItemOptimizeForReading())
      {
        PlayTrack((Track)localObject);
        return;
      }
      CommandManager.CmdOpenTrackPropertiesDialog((Track)localObject);
      return;
    }
    localObject = this._Adapter.getFeedAt(paramInt);
    if (localObject != null)
    {
      OpenFeedContent((Feed)localObject);
      return;
    }
    if (TotalListSize() == 0)
    {
      localObject = Configuration.getActiveFeedFilter();
      if (localObject == null)
      {
        CommandManager.CmdStartHtmlViewActivity(Configuration.UpdateAndDownloadHelpFileURL(), BEYOND_POD_FAQ, false);
        return;
      }
      OpenFeedContent((Feed)localObject);
      return;
    }
    ShowAllEpisodes();
  }
  
  public void PrepareContextMenu(ContextMenu paramContextMenu, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if (getChoiceMode() != 0) {}
    do
    {
      return;
      AdapterView.AdapterContextMenuInfo localAdapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      paramContextMenuInfo = null;
      if (localAdapterContextMenuInfo != null) {
        paramContextMenuInfo = this._Adapter.getTrackAt(localAdapterContextMenuInfo.position);
      }
    } while (paramContextMenuInfo == null);
    paramContextMenu.add(0, 2, 0, 2131296636);
    if (EnclosureDownloadManager.IsDownloadPending(paramContextMenuInfo.getUrl()))
    {
      paramContextMenu.add(0, 4, 1, 2131296646);
      label74:
      if (BeyondPodApplication.GetInstance().PlayList().HasTrack(paramContextMenuInfo)) {
        break label307;
      }
      if (BeyondPodApplication.GetInstance().PlayList().CanAddToPlaylist(paramContextMenuInfo))
      {
        if ((paramContextMenuInfo.ContentType() != 1) && (paramContextMenuInfo.ContentType() != -1)) {
          break label300;
        }
        i = 2131296638;
        label120:
        paramContextMenu.add(0, 5, 2, i);
      }
      label131:
      paramContextMenu.add(0, 24, 3, 2131296643);
      if (!paramContextMenuInfo.AllowAutoDelete()) {
        break label324;
      }
    }
    label300:
    label307:
    label324:
    for (int i = 2131296644;; i = 2131296645)
    {
      paramContextMenu.add(0, 9, 4, i);
      if (Configuration.PlayerIntegrationType() != 3) {
        paramContextMenu.add(0, 10, 5, 2131296649);
      }
      if (paramContextMenuInfo.HasUrl()) {
        paramContextMenu.add(0, 7, 6, 2131296671).setIcon(2130837983);
      }
      if (!paramContextMenuInfo.getParentFeed().HasUrl()) {
        break;
      }
      paramContextMenu.add(0, 8, 7, 2131296935);
      return;
      if (paramContextMenuInfo.IsFullyDownloaded()) {
        break label74;
      }
      if (paramContextMenuInfo.getDownloadStatus() == 2) {
        i = 2131296646;
      }
      for (;;)
      {
        paramContextMenu.add(0, 4, 1, i);
        break;
        if (paramContextMenuInfo.getDownloadedPortion() > 0L) {
          i = 2131296647;
        } else {
          i = 2131296648;
        }
      }
      i = 2131296639;
      break label120;
      paramContextMenu.add(0, 6, 2, 2131296642);
      break label131;
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
  
  public void PrimeView()
  {
    ReloadTracks();
  }
  
  public void Refresh()
  {
    if (MasterView.Master() == null) {
      return;
    }
    MasterView.Master().runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (PodcastsListView.this._Adapter != null) {
          PodcastsListView.this._Adapter.Refresh();
        }
      }
    });
  }
  
  public void ReloadTracks()
  {
    MasterView.Master().runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (PodcastsListView.this._Adapter != null)
        {
          PodcastsListView.this.removeFooterView(PodcastsListView.this._InfoFooter);
          boolean bool = PodcastsListView.this._Adapter.setCategoryFilter(Configuration.getActiveFeedCategory());
          MasterView.Master().RefreshActiveViewTitle();
          if (bool)
          {
            PodcastsListView.this.setSelectionAfterHeaderView();
            if (PodcastsListView.this._FilterChangedListener != null) {
              PodcastsListView.this._FilterChangedListener.OnCategoryChanged();
            }
          }
          PodcastsListView.this.NotifyIfEpisodesFiltered();
        }
        PodcastsListView.this.clearChoices();
        if (PodcastsListView.this._FilterChangedListener != null) {
          PodcastsListView.this._FilterChangedListener.OnContentChanged();
        }
      }
    });
  }
  
  public int TotalListSize()
  {
    return this._Adapter.getPodcastCount();
  }
  
  public int VisibleListSize()
  {
    return this._Adapter.getVisiblePodcastCount();
  }
  
  public void enableFastScrollIfNeeded()
  {
    this._Adapter.enableFasScrollIfNeeded();
  }
  
  public TrackList getCheckedTracks()
  {
    TrackList localTrackList = new TrackList();
    SparseBooleanArray localSparseBooleanArray = getCheckedItemPositions();
    int i = 0;
    for (;;)
    {
      if (i == this._Adapter.getCount()) {
        return localTrackList;
      }
      if (localSparseBooleanArray.get(i))
      {
        Track localTrack = this._Adapter.getTrackAt(i);
        if (localTrack != null) {
          localTrackList.add(localTrack);
        }
      }
      i += 1;
    }
  }
  
  public ImageLoader getImageLoader()
  {
    return this._ImageLoader;
  }
  
  public boolean hasCheckedItems()
  {
    SparseBooleanArray localSparseBooleanArray = getCheckedItemPositions();
    int i = 0;
    for (;;)
    {
      if (i == this._Adapter.getCount()) {
        return false;
      }
      if (localSparseBooleanArray.get(i)) {
        return true;
      }
      i += 1;
    }
  }
  
  public boolean hasPlayedEpisodes()
  {
    int i = 0;
    for (;;)
    {
      if (i == this._Adapter.getCount()) {
        return false;
      }
      Track localTrack = this._Adapter.getTrackAt(i);
      if ((localTrack != null) && (localTrack.IsPlayed())) {
        return true;
      }
      i += 1;
    }
  }
  
  public void multiSelectTracks(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 2: 
    case 1: 
    case 3: 
      for (;;)
      {
        Refresh();
        return;
        clearChoices();
        continue;
        paramInt = 0;
        while (paramInt != this._Adapter.getCount())
        {
          setItemChecked(paramInt, true);
          paramInt += 1;
        }
        clearChoices();
        CheckTracks(this._Adapter.GetAllPlayedPodcasts());
      }
    case 4: 
      clearChoices();
      localObject = this._Adapter.getOldestPodcasts();
      if (((List)localObject).size() > 3) {
        localObject = ((List)localObject).subList(0, 3);
      }
      for (;;)
      {
        CheckTracks((List)localObject);
        break;
      }
    }
    clearChoices();
    Object localObject = this._Adapter.getLargestPodcasts();
    if (((List)localObject).size() > 3) {
      localObject = ((List)localObject).subList(0, 3);
    }
    for (;;)
    {
      CheckTracks((List)localObject);
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    Track localTrack = (Track)paramView.getTag();
    if (localTrack == null) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131230933: 
      PlayTrack(localTrack);
      return;
    }
    CommandManager.CmdOpenTrackPropertiesDialog(localTrack);
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
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
      this.ViewIsScrolling = isFastScrollEnabled();
      return;
    }
    this.ViewIsScrolling = true;
  }
  
  public void setCategoryChangedListener(PodcastListChangedListener paramPodcastListChangedListener)
  {
    this._FilterChangedListener = paramPodcastListChangedListener;
  }
  
  public void setCurrentMultiselectMode(int paramInt)
  {
    this._Adapter.setCurrentMultiselectMode(paramInt);
  }
  
  public static abstract interface PodcastListChangedListener
  {
    public abstract void OnCategoryChanged();
    
    public abstract void OnContentChanged();
    
    public abstract void OnFilterChaged();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/PodcastsListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */