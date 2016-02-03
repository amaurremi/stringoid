package mobi.beyondpod.ui.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.downloadengine.EnclosureDownloadManager;
import mobi.beyondpod.downloadengine.UpdateAndDownloadEvents.UpdateAndDownloadEvent;
import mobi.beyondpod.downloadengine.UpdateAndDownloadEvents.UpdateAndDownloadEventListener;
import mobi.beyondpod.downloadengine.UpdateAndDownloadManager;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.services.player.PlayList;
import mobi.beyondpod.services.player.SmartPlaylistTemplate;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.core.ActionBarHelper;
import mobi.beyondpod.ui.core.MasterViewState;
import mobi.beyondpod.ui.core.SimpleMenu;
import mobi.beyondpod.ui.views.base.CommonMenuHandler;
import mobi.beyondpod.ui.views.base.IView;
import mobi.beyondpod.ui.views.base.TitleBarBase.TitleInfo;
import mobi.beyondpod.ui.views.notifications.UserNotificationManager;
import mobi.beyondpod.ui.views.notifications.UserNotificationManager.OnContinueListener;

public class FeedsView
  extends FrameLayout
  implements IView, UpdateAndDownloadEvents.UpdateAndDownloadEventListener
{
  private static final String CATEGORY = CoreHelper.LoadResourceString(2131296660);
  private static final int MENU_ADD_FEED = 3;
  private static final int MENU_CLEAR_PLAYLIST = 7;
  private static final int MENU_PLAY_ALL_IN_CATEGORY = 9;
  private static final int MENU_PLAY_SMART_PLAYLIST = 8;
  private static final int MENU_RESUME_DOWNLOADS = 11;
  private static final int MENU_STOP_UPDATE = 10;
  private static final int MENU_UPDATE_ALL = 6;
  private static final int MENU_UPDATE_CATEGORY = 4;
  private static final int MENU_UPDATE_SMART_PLAY = 5;
  private static final String PLAY_ALL_IN = CoreHelper.LoadResourceString(2131297060);
  FeedsListView FeedsList;
  private TextView _FooterAddFeed;
  private TextView _FooterToggleRead;
  private ImageView _FooterUpdateAll;
  private boolean _IsActive = false;
  private boolean _ViewSettled = false;
  
  public FeedsView(Context paramContext)
  {
    super(paramContext);
    paramContext = MasterView.Master().getLayoutInflater().inflate(2130903124, this);
    this.FeedsList = ((FeedsListView)paramContext.findViewById(2131231066));
    this._FooterAddFeed = ((TextView)paramContext.findViewById(2131231070));
    this._FooterToggleRead = ((TextView)paramContext.findViewById(2131231068));
    this._FooterUpdateAll = ((ImageView)paramContext.findViewById(2131231069));
    this._FooterAddFeed.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView) {}
    });
    TextView localTextView = this._FooterAddFeed;
    if (ActionBarHelper.HasPermanentMenuKey()) {}
    for (float f = getResources().getDimension(2131492925);; f = getResources().getDimension(2131492926))
    {
      localTextView.setMaxWidth((int)f);
      this._FooterToggleRead.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          FeedsView.this.FeedsList.ToggleReadFeeds(FeedsView.this.FeedsList.HasHiddenFeeds());
        }
      });
      this._FooterToggleRead.setMaxWidth((int)getResources().getDimension(2131492924));
      this._FooterUpdateAll.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (UpdateAndDownloadManager.IsWorking())
          {
            CommandManager.CmdShowDownloadQueue();
            return;
          }
          UserNotificationManager.WarnAboutStartUpdateAndDownload(FeedsView.this.getContext(), new UserNotificationManager.OnContinueListener()
          {
            public void OnContinue()
            {
              CommandManager.CmdUpdateFeeds(FeedsView.this.FeedsList.Feeds(), false);
            }
          });
        }
      });
      CoreHelper.ForceBackgroundTile(paramContext.findViewById(2131231067));
      return;
    }
  }
  
  public FeedsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void ToggleUpdateAnimation(boolean paramBoolean)
  {
    if (!this._ViewSettled) {}
    Object localObject;
    AnimationDrawable localAnimationDrawable;
    do
    {
      return;
      localObject = this._FooterUpdateAll.getDrawable();
      localAnimationDrawable = null;
      if ((localObject instanceof AnimationDrawable)) {
        localAnimationDrawable = (AnimationDrawable)localObject;
      }
      if (paramBoolean)
      {
        localObject = localAnimationDrawable;
        if (localAnimationDrawable == null)
        {
          this._FooterUpdateAll.setImageResource(2130837976);
          localObject = (AnimationDrawable)this._FooterUpdateAll.getDrawable();
        }
        ((AnimationDrawable)localObject).start();
        return;
      }
    } while (localAnimationDrawable == null);
    ((AnimationDrawable)localObject).stop();
    this._FooterUpdateAll.setImageResource(2130837977);
  }
  
  public boolean AllowScrollLeftRightFor(float paramFloat1, float paramFloat2)
  {
    return this.FeedsList.AllowScrollLeftRightFor(paramFloat1, paramFloat2);
  }
  
  public boolean CanScrollLeft()
  {
    return false;
  }
  
  public boolean CanScrollRight()
  {
    return false;
  }
  
  public TitleBarBase.TitleInfo GetViewTitle()
  {
    return this.FeedsList.GetViewTitle();
  }
  
  public boolean HandleContextMenu(MenuItem paramMenuItem)
  {
    return this.FeedsList.HandleContextMenu(paramMenuItem);
  }
  
  public boolean HandleOptionsMenu(int paramInt, MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      if (!CommonMenuHandler.HandleCommonMenu(paramMenuItem, getContext())) {
        break;
      }
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 10: 
    case 11: 
    case 7: 
    case 8: 
    case 9: 
      do
      {
        do
        {
          return true;
          CommandManager.CmdOpenAddFeedDialog();
          return true;
          CommandManager.CmdUpdateFeeds(this.FeedsList.Feeds(), false);
          return true;
          CommandManager.CmdUpdateSmartPlayList();
          return true;
          CommandManager.CmdUpdateFeeds(FeedRepository.getRootFeed().SubFeeds(), false);
          return true;
          CommandManager.CmdStopAllUpdates();
          return true;
          CommandManager.CmdResumeAllDownloads(getContext());
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
      } while (!CommandManager.CmdPlayAllInCategory(getContext()));
      MasterView.Master().ActivatePlayer();
      return true;
    }
    return false;
  }
  
  public void Initialize()
  {
    this.FeedsList.Initialize(this);
  }
  
  public boolean IsActive()
  {
    return this._IsActive;
  }
  
  public Feed NextFeed(Feed paramFeed)
  {
    return this.FeedsList.NextFeed(paramFeed);
  }
  
  public Feed NextUnreadFeed(Feed paramFeed)
  {
    return this.FeedsList.NextUnreadFeed(paramFeed);
  }
  
  public void OnActivityDestroy()
  {
    this.FeedsList.OnActivityDestroy();
  }
  
  public void OnAfterActivate()
  {
    BeyondPodApplication.MessageBus.Subscribe(this, UpdateAndDownloadEvents.UpdateAndDownloadEvent.class);
    this.FeedsList.OnAfterActivate();
    postDelayed(new Runnable()
    {
      public void run()
      {
        FeedsView.this._ViewSettled = true;
      }
    }, 1000L);
    this._IsActive = true;
  }
  
  public void OnAfterDeactivate(boolean paramBoolean)
  {
    BeyondPodApplication.MessageBus.Unsubscribe(this, UpdateAndDownloadEvents.UpdateAndDownloadEvent.class);
    ToggleUpdateAnimation(false);
    this.FeedsList.OnAfterDeactivate(paramBoolean);
    this._IsActive = false;
  }
  
  public void OnBeforeActivate()
  {
    this.FeedsList.OnBeforeActivate();
  }
  
  public void OnUpdateAndDownloadEvent(UpdateAndDownloadEvents.UpdateAndDownloadEvent paramUpdateAndDownloadEvent)
  {
    if ((paramUpdateAndDownloadEvent.Type == UpdateAndDownloadEvents.UpdateAndDownloadEvent.UPDATE_AND_DOWNLOAD_COMPLETED) || (paramUpdateAndDownloadEvent.Type == UpdateAndDownloadEvents.UpdateAndDownloadEvent.UPDATE_AND_DOWNLOAD_STARTED)) {
      MasterView.Master().runOnUiThread(new Runnable()
      {
        public void run()
        {
          FeedsView.this.ToggleUpdateAnimation(UpdateAndDownloadManager.IsWorking());
        }
      });
    }
  }
  
  public void PrepareContextMenu(ContextMenu paramContextMenu, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    this.FeedsList.PrepareContextMenu(paramContextMenu, paramContextMenuInfo);
  }
  
  public boolean PrepareOptionsMenu(Menu paramMenu)
  {
    paramMenu.clear();
    SubMenu localSubMenu = paramMenu.addSubMenu(0, 0, 0, 2131296693);
    localSubMenu.setIcon(2130837966);
    localSubMenu.add(0, 9, 1, PLAY_ALL_IN + " " + Configuration.getActiveFeedCategory().Name());
    localSubMenu.add(0, 8, 2, 2131296692);
    if (!PlayList.IsEmpty()) {
      paramMenu.add(0, 7, 1, 2131296656).setIcon(2130837945);
    }
    if ((this.FeedsList.FeedCount() > 0) || (this.FeedsList.HasHiddenFeeds()))
    {
      if (UpdateAndDownloadManager.IsWorking()) {
        break label303;
      }
      localSubMenu = paramMenu.addSubMenu(0, 0, 2, 2131296659).setIcon(2130837974);
      if (Configuration.getActiveFeedCategory() != CategoryManager.AllFeeds) {
        localSubMenu.add(0, 4, 1, CATEGORY + " " + Configuration.getActiveFeedCategory().Name());
      }
      if (SmartPlaylistTemplate.IsConfigured()) {
        localSubMenu.add(0, 5, 2, 2131296663);
      }
      localSubMenu.add(0, 6, 3, 2131296661);
      if (FeedRepository.AllResumableDownloads().size() > 0) {
        localSubMenu.add(0, 11, 4, 2131296662);
      }
    }
    if ((ActionBarHelper.HasPermanentMenuKey()) && (CoreHelper.ApiLevel() <= 15)) {}
    for (boolean bool = false;; bool = true)
    {
      CommonMenuHandler.AddMoreMenuAt(paramMenu, 3, 158, bool);
      return true;
      label303:
      if (EnclosureDownloadManager.IsDownloading()) {}
      for (int i = 2131296646;; i = 2131296664)
      {
        paramMenu.add(0, 10, 4, i).setIcon(2130837984);
        break;
      }
    }
  }
  
  public SimpleMenu PreparePopupOptionsMenu()
  {
    SimpleMenu localSimpleMenu = new SimpleMenu(getContext(), MasterView.Master().ContentRoot().findViewById(2131230867));
    PrepareOptionsMenu(localSimpleMenu);
    return localSimpleMenu;
  }
  
  public Feed PreviousFeed(Feed paramFeed)
  {
    return this.FeedsList.PreviousFeed(paramFeed);
  }
  
  public void RestoreState(MasterViewState paramMasterViewState)
  {
    if (paramMasterViewState.FeedsViewRootFeed != null)
    {
      SetRootFeed(paramMasterViewState.FeedsViewRootFeed);
      this.FeedsList.setSelection(paramMasterViewState.FeedsFirstVisibleItem);
    }
  }
  
  public Feed RootFeed()
  {
    return this.FeedsList.RootFeed();
  }
  
  public void SaveState(MasterViewState paramMasterViewState)
  {
    paramMasterViewState.FeedsViewRootFeed = RootFeed();
    paramMasterViewState.FeedsFirstVisibleItem = this.FeedsList.getFirstVisiblePosition();
  }
  
  public void SetRootFeed(Feed paramFeed)
  {
    this.FeedsList.SetRootFeed(paramFeed);
  }
  
  void UpdateFooterToolbar()
  {
    if (this.FeedsList.FeedCount() == 0) {
      if (!this.FeedsList.HasHiddenFeeds())
      {
        this._FooterToggleRead.setVisibility(8);
        this._FooterUpdateAll.setVisibility(8);
      }
    }
    for (;;)
    {
      if (this._FooterUpdateAll.getVisibility() == 0) {
        ToggleUpdateAnimation(UpdateAndDownloadManager.IsWorking());
      }
      return;
      this._FooterToggleRead.setVisibility(0);
      this._FooterToggleRead.setText(2131296914);
      this._FooterUpdateAll.setVisibility(0);
      continue;
      this._FooterUpdateAll.setVisibility(0);
      if (this.FeedsList.HasHiddenFeeds())
      {
        this._FooterToggleRead.setText(2131296914);
        this._FooterToggleRead.setVisibility(0);
      }
      else if (this.FeedsList.HasReadFeeds())
      {
        this._FooterToggleRead.setText(2131296915);
        this._FooterToggleRead.setVisibility(0);
      }
      else
      {
        this._FooterToggleRead.setVisibility(8);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/FeedsView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */