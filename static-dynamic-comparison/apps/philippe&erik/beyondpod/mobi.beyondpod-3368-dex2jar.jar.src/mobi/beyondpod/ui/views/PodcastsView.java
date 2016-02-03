package mobi.beyondpod.ui.views;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.downloadengine.UpdateAndDownloadEvents.UpdateAndDownloadEvent;
import mobi.beyondpod.downloadengine.UpdateAndDownloadEvents.UpdateAndDownloadEventListener;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.TrackSorter;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.CoreHelper.TrackSizeInfo;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.repository.FlashStorageLocation;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEvent;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEventListener;
import mobi.beyondpod.services.player.PlayList;
import mobi.beyondpod.services.player.PlayListEvents.PlayListEvent;
import mobi.beyondpod.services.player.PlayListEvents.PlayListEventListener;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.core.ActionBarHelper;
import mobi.beyondpod.ui.core.MasterViewState;
import mobi.beyondpod.ui.core.SimpleMenu;
import mobi.beyondpod.ui.views.base.ActionModeBP;
import mobi.beyondpod.ui.views.base.ActionModeBP.Callback;
import mobi.beyondpod.ui.views.base.CommonMenuHandler;
import mobi.beyondpod.ui.views.base.IView;
import mobi.beyondpod.ui.views.base.TitleBarBase.TitleInfo;
import mobi.beyondpod.ui.views.notifications.UserNotificationManager;

public class PodcastsView
  extends FrameLayout
  implements IView, RepositoryEvents.RepositoryEventListener, UpdateAndDownloadEvents.UpdateAndDownloadEventListener, PlayListEvents.PlayListEventListener, PodcastsListView.PodcastListChangedListener
{
  private static final String ABOUT;
  private static final String ALL_EPISODES = CoreHelper.LoadResourceString(2131296377);
  private static final String EPISODES;
  private static final String FREE;
  private static final int MENU_ADD_TO_PLAYLIST = 8;
  private static final int MENU_BATCH_OPERATIONS = 7;
  private static final int MENU_CANCEL_MULTI_SELECT = 19;
  private static final int MENU_CLEAR_PLAYLIST = 20;
  private static final int MENU_CLEAR_SELECTION = 3;
  private static final int MENU_DELETE_ALL_PLAYED = 16;
  private static final int MENU_DELETE_EPISODES = 1;
  private static final int MENU_EPISODE_CLEANUP = 17;
  private static final int MENU_PLAY_LATEST = 22;
  private static final int MENU_PLAY_OLDEST = 23;
  private static final int MENU_PLAY_SMART_PLAYLIST = 21;
  private static final int MENU_REMOVE_FROM_PLAYLIST = 9;
  private static final int MENU_SELECT_ALL = 2;
  private static final int MENU_SELECT_PLAYED = 4;
  private static final int MENU_SELECT_TOP_LARGEST = 6;
  private static final int MENU_SELECT_TOP_OLDEST = 5;
  private static final int MENU_SHOW_PLAYLIST = 18;
  private static final String PLAYLIST = CoreHelper.LoadResourceString(2131297096);
  private static final String PLAYLIST_EMPTY;
  PodcastsListView PodcastList;
  private ActionModeBP _CurrentActionMode;
  TextView _EpisodeFilter;
  TextView _EpisodeSort;
  View.OnClickListener _EpisodeSortListener = new View.OnClickListener()
  {
    public void HandleEpisodesSort()
    {
      Context localContext = PodcastsView.this.getContext();
      if (Configuration.getGroupByFeedIfShowingCategoryTracks()) {}
      for (int i = -1;; i = Configuration.getPodcastsSortOrder())
      {
        i = CoreHelper.FindIndexInNumArray(localContext, 2131623943, Integer.valueOf(i));
        new AlertDialog.Builder(PodcastsView.this.getContext()).setTitle(2131296787).setSingleChoiceItems(2131623942, i, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            String[] arrayOfString = PodcastsView.this.getResources().getStringArray(2131623943);
            if (paramAnonymous2Int >= arrayOfString.length) {
              return;
            }
            paramAnonymous2Int = Integer.parseInt(arrayOfString[paramAnonymous2Int]);
            if (paramAnonymous2Int < 0) {
              Configuration.setGroupByFeedIfShowingCategoryTracks(true);
            }
            for (;;)
            {
              PodcastsView.this.PodcastList.ReloadTracks();
              PodcastsView.this.UpdateSortLabel();
              paramAnonymous2DialogInterface.dismiss();
              return;
              Configuration.setGroupByFeedIfShowingCategoryTracks(false);
              Configuration.setPodcastsSortOrder(paramAnonymous2Int);
            }
          }
        }).setCancelable(true).create().show();
        return;
      }
    }
    
    public void HandleFeedSort(final Feed paramAnonymousFeed)
    {
      int i = CoreHelper.FindIndexInNumArray(PodcastsView.this.getContext(), 2131623941, Integer.valueOf(paramAnonymousFeed.getLocalOrInheritedTrackSortOrder()));
      new AlertDialog.Builder(PodcastsView.this.getContext()).setTitle(2131296787).setSingleChoiceItems(2131623940, i, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
        {
          Object localObject = PodcastsView.this.getResources().getStringArray(2131623941);
          if (paramAnonymous2Int >= localObject.length) {
            return;
          }
          paramAnonymous2Int = Integer.parseInt(localObject[paramAnonymous2Int]);
          for (localObject = paramAnonymousFeed;; localObject = ((Feed)localObject).ParentFeed()) {
            if (!((Feed)localObject).IsSubFeed())
            {
              ((Feed)localObject).setTrackSortOrder(paramAnonymous2Int);
              PodcastsView.this.PodcastList.ReloadTracks();
              PodcastsView.this.UpdateSortLabel();
              paramAnonymous2DialogInterface.dismiss();
              return;
            }
          }
        }
      }).setCancelable(true).create().show();
    }
    
    public void onClick(View paramAnonymousView)
    {
      paramAnonymousView = Configuration.getActiveFeedFilter();
      if (paramAnonymousView == null)
      {
        HandleEpisodesSort();
        return;
      }
      HandleFeedSort(paramAnonymousView);
    }
  };
  private boolean _IsActive = false;
  TextView _NumInPlaylist;
  View.OnClickListener _OpenPlaylistListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      CommandManager.CmdOpenManagePlaylistView(false);
    }
  };
  private Animation _PlayListChangedAnimation;
  View _PlaylistEditor;
  private ImageView _PlaylistImage;
  View.OnClickListener _StartAddToPlaylistActionModeListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      paramAnonymousView = PodcastsView.this;
      if ((PodcastsView.this.MultiselectModeKind() == 0) && (!PodcastsView.this.PodcastList.IsEmpty())) {}
      for (int i = 2;; i = 0)
      {
        paramAnonymousView.SwitchMultiselect(i);
        return;
      }
    }
  };
  Toast _Toast;
  private ActionModeBP.Callback mContentSelectionActionModeCallback = new ActionModeBP.Callback()
  {
    public boolean onActionItemClicked(ActionModeBP paramAnonymousActionModeBP, MenuItem paramAnonymousMenuItem)
    {
      switch (paramAnonymousMenuItem.getItemId())
      {
      }
      for (;;)
      {
        PodcastsView.this.RefreshMultiselectTitle();
        return true;
        paramAnonymousActionModeBP = PodcastsView.this.PodcastList.getCheckedTracks();
        if (paramAnonymousActionModeBP.size() > 0)
        {
          CommandManager.CmdDeletePodcasts(PodcastsView.this.getContext(), paramAnonymousActionModeBP);
          continue;
          PodcastsView.this.PodcastList.multiSelectTracks(3);
          continue;
          PodcastsView.this.PodcastList.multiSelectTracks(2);
          continue;
          PodcastsView.this.PodcastList.multiSelectTracks(5);
          continue;
          PodcastsView.this.PodcastList.multiSelectTracks(4);
          continue;
          PodcastsView.this.PodcastList.multiSelectTracks(1);
          continue;
          if (Configuration.KeepCurrentEpisodeForClearPlaylist()) {}
          for (boolean bool = false;; bool = true)
          {
            CommandManager.CmdEmptyPlaylist(false, bool);
            return true;
          }
          paramAnonymousActionModeBP = PodcastsView.this.PodcastList.GeneratePlaylistFrom(0);
          if (paramAnonymousActionModeBP.size() > 0)
          {
            BeyondPodApplication.GetInstance().PlayList().AddTracks(paramAnonymousActionModeBP);
            continue;
            paramAnonymousActionModeBP = PodcastsView.this.PodcastList.GeneratePlaylistFrom(0);
            if (paramAnonymousActionModeBP.size() > 0) {
              BeyondPodApplication.GetInstance().PlayList().RemoveTracks(paramAnonymousActionModeBP);
            }
          }
        }
      }
    }
    
    public void onAfterActionModeCreate(ActionModeBP paramAnonymousActionModeBP) {}
    
    public boolean onCreateActionMode(ActionModeBP paramAnonymousActionModeBP, Menu paramAnonymousMenu)
    {
      PodcastsView.this.PodcastList.setFastScrollEnabled(false);
      PodcastsView.this.PodcastList.clearChoices();
      PodcastsView.this.PodcastList.setChoiceMode(2);
      switch (PodcastsView.this.MultiselectModeKind())
      {
      }
      for (;;)
      {
        PodcastsView.this.PodcastList.Refresh();
        return true;
        paramAnonymousMenu.add(0, 1, 0, 2131296637).setIcon(2130837948);
        paramAnonymousActionModeBP = paramAnonymousMenu.addSubMenu(0, 0, 0, 2131296637).setIcon(2130837957);
        paramAnonymousActionModeBP.add(0, 4, 1, 2131297140);
        paramAnonymousActionModeBP.add(0, 6, 2, 2131297143);
        paramAnonymousActionModeBP.add(0, 5, 3, 2131297144);
        paramAnonymousActionModeBP.add(0, 2, 4, 2131297141);
        paramAnonymousActionModeBP.add(0, 3, 5, 2131297142);
        continue;
        paramAnonymousActionModeBP = paramAnonymousMenu.addSubMenu(0, 7, 0, 2131296638).setIcon(2130837957);
        paramAnonymousActionModeBP.add(0, 8, 1, 2131296640);
        paramAnonymousActionModeBP.add(0, 9, 2, 2131296641);
        paramAnonymousActionModeBP.add(0, 20, 3, 2131296656);
      }
    }
    
    public void onDestroyActionMode(ActionModeBP paramAnonymousActionModeBP)
    {
      PodcastsView.this.PodcastList.clearChoices();
      PodcastsView.this.PodcastList.setChoiceMode(0);
      PodcastsView.this._CurrentActionMode = null;
      PodcastsView.this.setMultiselectModeKind(0);
      PodcastsView.this.UpdatePlaylistButtonActions();
      PodcastsView.this.PodcastList.Refresh();
      PodcastsView.this.PodcastList.enableFastScrollIfNeeded();
      MasterView.Master().RefreshActiveViewTitle();
    }
    
    public boolean onUpdateActionModeToolsVisibility(ActionModeBP paramAnonymousActionModeBP, Menu paramAnonymousMenu)
    {
      paramAnonymousActionModeBP = PodcastsView.this.PodcastList.GeneratePlaylistFrom(0);
      boolean bool2 = false;
      boolean bool1 = false;
      paramAnonymousActionModeBP = paramAnonymousActionModeBP.iterator();
      Object localObject;
      if (!paramAnonymousActionModeBP.hasNext())
      {
        paramAnonymousActionModeBP = paramAnonymousMenu.findItem(7);
        if (paramAnonymousActionModeBP != null)
        {
          localObject = paramAnonymousActionModeBP.getSubMenu().findItem(8);
          if (localObject != null) {
            ((MenuItem)localObject).setVisible(bool1);
          }
          localObject = paramAnonymousActionModeBP.getSubMenu().findItem(9);
          if (localObject != null) {
            ((MenuItem)localObject).setVisible(bool2);
          }
          paramAnonymousActionModeBP = paramAnonymousActionModeBP.getSubMenu().findItem(20);
          if (paramAnonymousActionModeBP != null) {
            if (!PlayList.IsEmpty()) {
              break label206;
            }
          }
        }
      }
      label206:
      for (bool1 = false;; bool1 = true)
      {
        paramAnonymousActionModeBP.setVisible(bool1);
        paramAnonymousActionModeBP = paramAnonymousMenu.findItem(1);
        if (paramAnonymousActionModeBP != null) {
          paramAnonymousActionModeBP.setVisible(PodcastsView.this.PodcastList.hasCheckedItems());
        }
        return false;
        localObject = (Track)paramAnonymousActionModeBP.next();
        if (BeyondPodApplication.GetInstance().PlayList().HasTrack((Track)localObject))
        {
          bool2 = true;
          break;
        }
        bool1 = true;
        break;
      }
    }
  };
  
  static
  {
    FREE = CoreHelper.LoadResourceString(2131297094);
    ABOUT = CoreHelper.LoadResourceString(2131297095);
    PLAYLIST_EMPTY = CoreHelper.LoadResourceString(2131296902);
    EPISODES = CoreHelper.LoadResourceString(2131297108);
  }
  
  public PodcastsView(Context paramContext)
  {
    super(paramContext);
    paramContext = MasterView.Master().getLayoutInflater().inflate(2130903151, this);
    this.PodcastList = ((PodcastsListView)paramContext.findViewById(2131231157));
    this.PodcastList.setCategoryChangedListener(this);
    this._EpisodeSort = ((TextView)findViewById(2131231161));
    TextView localTextView = this._EpisodeSort;
    if (ActionBarHelper.HasPermanentMenuKey()) {}
    for (float f = getResources().getDimension(2131492925);; f = getResources().getDimension(2131492926))
    {
      localTextView.setMaxWidth((int)f);
      this._EpisodeSort.setOnClickListener(this._EpisodeSortListener);
      UpdateSortLabel();
      this._EpisodeFilter = ((TextView)findViewById(2131231159));
      this._EpisodeFilter.setMaxWidth((int)getResources().getDimension(2131492924));
      this._EpisodeFilter.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          int i = CoreHelper.FindIndexInNumArray(PodcastsView.this.getContext(), 2131623945, Integer.valueOf(Configuration.getActiveMediaFilter()));
          new AlertDialog.Builder(PodcastsView.this.getContext()).setTitle(2131296788).setSingleChoiceItems(2131623944, i, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              String[] arrayOfString = PodcastsView.this.getResources().getStringArray(2131623945);
              if (paramAnonymous2Int >= arrayOfString.length) {
                return;
              }
              Configuration.setActiveMediaFilter(Integer.parseInt(arrayOfString[paramAnonymous2Int]));
              PodcastsView.this.PodcastList.ReloadTracks();
              PodcastsView.this.UpdateFilterLabel();
              paramAnonymous2DialogInterface.dismiss();
            }
          }).setCancelable(true).create().show();
        }
      });
      UpdateFilterLabel();
      this._PlaylistEditor = paramContext.findViewById(2131230972);
      this._PlaylistEditor.setOnLongClickListener(new View.OnLongClickListener()
      {
        public boolean onLongClick(View paramAnonymousView)
        {
          CommandManager.CmdOpenManagePlaylistView(false);
          return true;
        }
      });
      this._PlaylistImage = ((ImageView)paramContext.findViewById(2131231160));
      this._NumInPlaylist = ((TextView)paramContext.findViewById(2131230973));
      this._PlayListChangedAnimation = AnimationUtils.loadAnimation(getContext(), 2130968589);
      return;
    }
  }
  
  public PodcastsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void GeneratePlaylistAndPlay(int paramInt)
  {
    TrackList localTrackList = this.PodcastList.GeneratePlaylistFrom(0);
    TrackSorter localTrackSorter = new TrackSorter();
    localTrackSorter.SortOrder = paramInt;
    Collections.sort(localTrackList, localTrackSorter);
    if (CommandManager.CmdPlayTracks(getContext(), localTrackList)) {
      MasterView.Master().ActivatePlayer();
    }
  }
  
  private boolean IsShowingPlaylistButton()
  {
    return (this.PodcastList.IsEmpty()) || (this._CurrentActionMode != null);
  }
  
  private int MultiselectModeKind()
  {
    return this.PodcastList.CurrentMultiselectMode();
  }
  
  private void UpdateFilterLabel()
  {
    int i = CoreHelper.FindIndexInNumArray(getContext(), 2131623945, Integer.valueOf(Configuration.getActiveMediaFilter()));
    if (i >= 0)
    {
      this._EpisodeFilter.setText(getResources().getStringArray(2131623944)[i]);
      return;
    }
    this._EpisodeFilter.setText(2131297092);
  }
  
  private void UpdatePlaylistButtonActions()
  {
    if (MultiselectModeKind() == 1)
    {
      this._PlaylistEditor.setVisibility(8);
      this._NumInPlaylist.setVisibility(8);
      return;
    }
    this._PlaylistEditor.setVisibility(0);
    if (IsShowingPlaylistButton())
    {
      this._PlaylistImage.setImageResource(2130837839);
      this._PlaylistEditor.setOnClickListener(this._OpenPlaylistListener);
      this._NumInPlaylist.setVisibility(0);
    }
    for (;;)
    {
      RefreshPlaylistCount();
      return;
      this._PlaylistImage.setImageResource(2130837840);
      this._PlaylistEditor.setOnClickListener(this._StartAddToPlaylistActionModeListener);
      this._NumInPlaylist.setVisibility(8);
    }
  }
  
  private void UpdateSortLabel()
  {
    Object localObject = Configuration.getActiveFeedFilter();
    int i;
    if (localObject == null)
    {
      localObject = getContext();
      if (Configuration.getGroupByFeedIfShowingCategoryTracks())
      {
        i = -1;
        i = CoreHelper.FindIndexInNumArray((Context)localObject, 2131623943, Integer.valueOf(i));
        if (i >= 0) {
          this._EpisodeSort.setText(getResources().getStringArray(2131623942)[i]);
        }
      }
    }
    do
    {
      return;
      i = Configuration.getPodcastsSortOrder();
      break;
      i = CoreHelper.FindIndexInNumArray(getContext(), 2131623941, Integer.valueOf(((Feed)localObject).getLocalOrInheritedTrackSortOrder()));
    } while (i < 0);
    this._EpisodeSort.setText(getResources().getStringArray(2131623940)[i]);
  }
  
  private void setMultiselectModeKind(int paramInt)
  {
    this.PodcastList.setCurrentMultiselectMode(paramInt);
  }
  
  public boolean AllowScrollLeftRightFor(float paramFloat1, float paramFloat2)
  {
    return true;
  }
  
  public boolean CanScrollLeft()
  {
    return false;
  }
  
  public boolean CanScrollRight()
  {
    return false;
  }
  
  public int CurrentMultiselectMode()
  {
    return MultiselectModeKind();
  }
  
  public void FinishActionMode()
  {
    if (this._CurrentActionMode != null) {
      this._CurrentActionMode.finish();
    }
  }
  
  public TitleBarBase.TitleInfo GetViewTitle()
  {
    return this.PodcastList.GetViewTitle();
  }
  
  public boolean HandleContextMenu(MenuItem paramMenuItem)
  {
    return this.PodcastList.HandleContextMenu(paramMenuItem);
  }
  
  public boolean HandleOptionsMenu(int paramInt, MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      if (!CommonMenuHandler.HandleCommonMenu(paramMenuItem, getContext())) {
        break;
      }
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
      do
      {
        return true;
        CommandManager.CmdDeletePodcasts(MasterView.Master(), this.PodcastList.GetAllPlayedPodcasts());
        return true;
        SwitchMultiselect(1);
        return true;
        CommandManager.CmdOpenManagePlaylistView(false);
        return true;
        SwitchMultiselect(0);
        return true;
        if (Configuration.KeepCurrentEpisodeForClearPlaylist()) {}
        for (boolean bool = false;; bool = true)
        {
          CommandManager.CmdEmptyPlaylist(false, bool);
          return true;
        }
      } while (!CommandManager.CmdPlaySmartPlayList(getContext()));
      MasterView.Master().ActivatePlayer();
      return true;
    case 22: 
      GeneratePlaylistAndPlay(3);
      return true;
    case 23: 
      GeneratePlaylistAndPlay(2);
      return true;
    }
    MasterView.Master().RefreshActiveViewTitle();
    return false;
  }
  
  public void InitializeView()
  {
    this.PodcastList.InitializeView();
  }
  
  public boolean IsActive()
  {
    return this._IsActive;
  }
  
  public void OnActivityDestroy()
  {
    this.PodcastList.OnActivityDestroy();
  }
  
  public void OnAfterActivate()
  {
    this.PodcastList.OnAfterActivate();
    this._IsActive = true;
  }
  
  public void OnAfterDeactivate(boolean paramBoolean)
  {
    BeyondPodApplication.MessageBus.Unsubscribe(this, PlayListEvents.PlayListEvent.class);
    BeyondPodApplication.MessageBus.Unsubscribe(this, UpdateAndDownloadEvents.UpdateAndDownloadEvent.class);
    BeyondPodApplication.MessageBus.Unsubscribe(this, RepositoryEvents.RepositoryEvent.class);
    if (paramBoolean) {
      FinishActionMode();
    }
    this.PodcastList.OnAfterDeactivate(paramBoolean);
    this._IsActive = false;
  }
  
  public void OnBeforeActivate()
  {
    this.PodcastList.OnBeforeActivate();
    BeyondPodApplication.MessageBus.Subscribe(this, RepositoryEvents.RepositoryEvent.class);
    BeyondPodApplication.MessageBus.Subscribe(this, UpdateAndDownloadEvents.UpdateAndDownloadEvent.class);
    BeyondPodApplication.MessageBus.Subscribe(this, PlayListEvents.PlayListEvent.class);
  }
  
  public void OnCategoryChanged()
  {
    if (MasterView.Master().Workspace.ActiveView() != this) {
      return;
    }
    String str1;
    Object localObject2;
    String str3;
    if (Configuration.getActiveFeedCategory() == CategoryManager.AllFeeds)
    {
      str1 = ALL_EPISODES;
      localObject1 = Long.valueOf(new FlashStorageLocation(FeedRepository.getRootPath()).FreeSpace());
      if (this.PodcastList.TotalListSize() <= 0) {
        break label231;
      }
      localObject2 = this.PodcastList.GetCurrentTracksSizeOnDisk();
      str3 = CoreHelper.GetFileLengthAsString(Long.valueOf(((CoreHelper.TrackSizeInfo)localObject2).SizeOnDisk));
      if (!((CoreHelper.TrackSizeInfo)localObject2).TotalTimeIsApproximate) {
        break label217;
      }
      str2 = ABOUT + " ";
      label107:
      localObject2 = CoreHelper.GetApproximateTimeDurationAsString(((CoreHelper.TrackSizeInfo)localObject2).TotalTime * 1000L, false);
      if (localObject1 == null) {
        break label224;
      }
    }
    label217:
    label224:
    for (Object localObject1 = CoreHelper.GetFileLengthAsString((Long)localObject1);; localObject1 = "N/A")
    {
      str1 = String.format("%s\n\n  %s (%s%s)\n  %s %s", new Object[] { str1, str3, str2, localObject2, localObject1, FREE });
      ShowToast(str1, 0);
      RefreshMultiselectTitle();
      return;
      str1 = Configuration.getActiveFeedCategory().Name() + " " + EPISODES;
      break;
      str2 = "";
      break label107;
    }
    label231:
    if (localObject1 != null) {}
    for (String str2 = CoreHelper.GetFileLengthAsString((Long)localObject1);; str2 = "N/A")
    {
      str1 = String.format("%s\n\n  %s %s", new Object[] { str1, str2, FREE });
      break;
    }
  }
  
  public void OnContentChanged()
  {
    UpdatePlaylistButtonActions();
    UpdateSortLabel();
  }
  
  public void OnFilterChaged()
  {
    UpdateFilterLabel();
  }
  
  public void OnPlayListEvent(PlayListEvents.PlayListEvent paramPlayListEvent)
  {
    if (paramPlayListEvent.Type == 0) {
      MasterView.Master().runOnUiThread(new Runnable()
      {
        public void run()
        {
          PodcastsView.this.RefreshPlaylistCount();
          PodcastsView.this.PodcastList.ReloadTracks();
          PodcastsView.this.RefreshMultiselectTitle();
        }
      });
    }
  }
  
  public void OnRepositoryEvent(RepositoryEvents.RepositoryEvent paramRepositoryEvent)
  {
    if ((paramRepositoryEvent.Type == 11) && (paramRepositoryEvent.Track != null)) {
      this.PodcastList.Refresh();
    }
    if ((paramRepositoryEvent.Type == 8) || (paramRepositoryEvent.Type == 10))
    {
      this.PodcastList.ReloadTracks();
      if (this.PodcastList.IsEmpty()) {
        MasterView.Master().Workspace.ActivateView(1);
      }
      RefreshMultiselectTitle();
    }
  }
  
  public void OnUpdateAndDownloadEvent(UpdateAndDownloadEvents.UpdateAndDownloadEvent paramUpdateAndDownloadEvent)
  {
    if ((paramUpdateAndDownloadEvent.Type == UpdateAndDownloadEvents.UpdateAndDownloadEvent.ENCLOSURE_DOWNLOAD_STARTED) || (paramUpdateAndDownloadEvent.Type == UpdateAndDownloadEvents.UpdateAndDownloadEvent.ENCLOSURE_DOWNLOAD_COMPLETED) || (paramUpdateAndDownloadEvent.Type == UpdateAndDownloadEvents.UpdateAndDownloadEvent.ENCLOSURE_DOWNLOAD_QUEUE_CHANGED)) {
      this.PodcastList.Refresh();
    }
  }
  
  public void PrepareContextMenu(ContextMenu paramContextMenu, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    this.PodcastList.PrepareContextMenu(paramContextMenu, paramContextMenuInfo);
  }
  
  public boolean PrepareOptionsMenu(Menu paramMenu)
  {
    boolean bool = false;
    paramMenu.clear();
    if (MultiselectModeKind() == 2) {}
    while (MultiselectModeKind() == 1) {
      return false;
    }
    if (!PlayList.IsEmpty()) {
      paramMenu.add(0, 20, 1, 2131296656).setIcon(2130837945);
    }
    if (!this.PodcastList.IsEmpty())
    {
      SubMenu localSubMenu = paramMenu.addSubMenu(0, 0, 0, 2131296693);
      localSubMenu.setIcon(2130837966);
      localSubMenu.add(0, 22, 1, getResources().getStringArray(2131623942)[CoreHelper.FindIndexInNumArray(getContext(), 2131623943, Integer.valueOf(3))]);
      localSubMenu.add(0, 23, 2, getResources().getStringArray(2131623942)[CoreHelper.FindIndexInNumArray(getContext(), 2131623943, Integer.valueOf(2))]);
      localSubMenu.add(0, 21, 3, 2131296692);
      paramMenu.add(0, 17, 1, 2131296633).setIcon(2130837952);
      if (this.PodcastList.hasPlayedEpisodes()) {
        paramMenu.add(0, 16, 2, 2131296632).setIcon(2130837949);
      }
    }
    if ((ActionBarHelper.HasPermanentMenuKey()) && (CoreHelper.ApiLevel() <= 15)) {}
    for (;;)
    {
      CommonMenuHandler.AddMoreMenuAt(paramMenu, 3, 160, bool);
      return true;
      bool = true;
    }
  }
  
  public SimpleMenu PreparePopupOptionsMenu()
  {
    SimpleMenu localSimpleMenu = new SimpleMenu(getContext(), MasterView.Master().ContentRoot().findViewById(2131230867));
    PrepareOptionsMenu(localSimpleMenu);
    return localSimpleMenu;
  }
  
  public void RefreshMultiselectTitle()
  {
    if (this._CurrentActionMode == null) {
      return;
    }
    MasterView.Master().runOnUiThread(new Runnable()
    {
      public void run()
      {
        Object localObject1 = PodcastsView.this.PodcastList.getCheckedTracks();
        Object localObject3;
        switch (PodcastsView.this.MultiselectModeKind())
        {
        default: 
          return;
        case 1: 
          CoreHelper.TrackSizeInfo localTrackSizeInfo = PodcastsView.this.PodcastList.GetCheckedSizeOnDiskFor((TrackList)localObject1);
          localObject2 = Long.valueOf(new FlashStorageLocation(FeedRepository.getRootPath()).FreeSpace());
          if (((TrackList)localObject1).size() > 0)
          {
            localObject3 = PodcastsView.this._CurrentActionMode;
            int i = ((TrackList)localObject1).size();
            int j = PodcastsView.this.PodcastList.VisibleListSize();
            if (localTrackSizeInfo.SizeOnDisk > 0L)
            {
              localObject1 = " (" + CoreHelper.GetFileLengthAsString(Long.valueOf(localTrackSizeInfo.SizeOnDisk)) + ")";
              ((ActionModeBP)localObject3).setTitle(String.format("%s/%s%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject1 }));
              label180:
              localObject3 = PodcastsView.this._CurrentActionMode;
              if (localObject2 == null) {
                break label262;
              }
            }
          }
          label262:
          for (localObject1 = CoreHelper.GetFileLengthAsString((Long)localObject2);; localObject1 = "N/A")
          {
            ((ActionModeBP)localObject3).setSubTitle(String.format("%s %s", new Object[] { localObject1, PodcastsView.FREE }));
            PodcastsView.this._CurrentActionMode.invalidateOptionsMenu();
            return;
            localObject1 = "";
            break;
            PodcastsView.this._CurrentActionMode.setTitle("");
            break label180;
          }
        }
        Object localObject2 = BeyondPodApplication.GetInstance().PlayList();
        localObject1 = String.format("%s - %s", new Object[] { PodcastsView.PLAYLIST, Integer.valueOf(((PlayList)localObject2).PlaylistSize()) });
        if (((PlayList)localObject2).PlaylistSize() > 0)
        {
          localObject3 = ((PlayList)localObject2).PlaylistTotalTime();
          if ((!((CoreHelper.TrackSizeInfo)localObject3).TotalTimeIsApproximate) || (((CoreHelper.TrackSizeInfo)localObject3).TotalTime > 200L)) {
            localObject1 = String.format("%s - %s", new Object[] { PodcastsView.PLAYLIST, Integer.valueOf(((PlayList)localObject2).PlaylistSize()) });
          }
          if (((CoreHelper.TrackSizeInfo)localObject3).TotalTimeIsApproximate)
          {
            localObject2 = PodcastsView.ABOUT + " ";
            localObject2 = String.format("%s%s", new Object[] { localObject2, CoreHelper.GetApproximateTimeDurationAsString(((CoreHelper.TrackSizeInfo)localObject3).TotalTime * 1000L, false) });
            PodcastsView.this._CurrentActionMode.setTitle((CharSequence)localObject1);
            PodcastsView.this._CurrentActionMode.setSubTitle((CharSequence)localObject2);
          }
        }
        for (;;)
        {
          PodcastsView.this._CurrentActionMode.invalidateOptionsMenu();
          return;
          localObject2 = "";
          break;
          PodcastsView.this._CurrentActionMode.setTitle(PodcastsView.PLAYLIST_EMPTY);
          PodcastsView.this._CurrentActionMode.setSubTitle("");
        }
      }
    });
  }
  
  public void RefreshPlaylistCount()
  {
    int j = 0;
    int i = BeyondPodApplication.GetInstance().PlayList().PlaylistSize();
    if ((i == 0) || (!IsShowingPlaylistButton())) {
      this._NumInPlaylist.setVisibility(8);
    }
    do
    {
      return;
      this._NumInPlaylist.setVisibility(0);
      String str1 = Integer.toString(i);
      String str2 = this._NumInPlaylist.getText().toString();
      i = j;
      if (!StringUtils.IsNullOrEmpty(str2))
      {
        i = j;
        if (!StringUtils.Equals("0", str2))
        {
          i = j;
          if (!StringUtils.Equals(str2, str1)) {
            i = 1;
          }
        }
      }
      this._NumInPlaylist.setText(str1);
    } while (i == 0);
    this._PlaylistEditor.startAnimation(this._PlayListChangedAnimation);
  }
  
  public void RestoreState(MasterViewState paramMasterViewState)
  {
    this.PodcastList.setSelection(paramMasterViewState.PodcastsFirstVisibleItem);
  }
  
  public void SaveState(MasterViewState paramMasterViewState)
  {
    paramMasterViewState.PodcastsFirstVisibleItem = this.PodcastList.getFirstVisiblePosition();
  }
  
  public void ShowToast(final CharSequence paramCharSequence, final int paramInt)
  {
    MasterView.Master().runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (PodcastsView.this._Toast != null) {
          PodcastsView.this._Toast.cancel();
        }
        PodcastsView.this._Toast = Toast.makeText(PodcastsView.this.getContext(), paramCharSequence, paramInt);
        PodcastsView.this._Toast.show();
      }
    });
  }
  
  public void SwitchMultiselect(int paramInt)
  {
    setMultiselectModeKind(paramInt);
    if ((paramInt == 2) || (paramInt == 1))
    {
      this._CurrentActionMode = MasterView.Master().startMultiselect(this.mContentSelectionActionModeCallback);
      UpdatePlaylistButtonActions();
      if (paramInt == 2) {
        UserNotificationManager.TipNotifyTapToAddRemovewPlaylist(MasterView.Master().Workspace);
      }
      RefreshMultiselectTitle();
      return;
    }
    FinishActionMode();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/PodcastsView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */