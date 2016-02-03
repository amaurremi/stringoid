package mobi.beyondpod.ui.views.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.services.player.impl.ChromecastDevice;
import mobi.beyondpod.ui.core.ActionBarHelper;
import mobi.beyondpod.ui.core.SimpleMenu;
import mobi.beyondpod.ui.core.mediarouter.BPMediaRouteDialogFactory;
import mobi.beyondpod.ui.core.mediarouter.MediaRouteButton;
import mobi.beyondpod.ui.views.Workspace;

public class TitleBarMasterView
  extends TitleBarBase
{
  MediaRouteButton _MediaRouteButton;
  protected ImageView _OverflowMenu;
  View.OnClickListener _OverflowMenuClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (TitleBarMasterView.this._Owner.ActiveView() == null) {
        return;
      }
      paramAnonymousView = TitleBarMasterView.this._Owner.ActiveView().PreparePopupOptionsMenu();
      paramAnonymousView.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
      {
        public boolean onMenuItemClick(MenuItem paramAnonymous2MenuItem)
        {
          return TitleBarMasterView.this._Owner.ActiveView().HandleOptionsMenu(0, paramAnonymous2MenuItem);
        }
      });
      paramAnonymousView.showAsPopupMenu();
    }
  };
  Workspace _Owner;
  TitleBarTabButton _SectionEpisodes;
  TitleBarTabButton _SectionFeeds;
  TitleBarTabButtonPlayer _SectionPlayer;
  
  public TitleBarMasterView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TitleBarMasterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void ActivateTab(int paramInt1, int paramInt2)
  {
    Object localObject = findViewById(2131230869);
    View localView = findViewById(2131230870);
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    if (localView != null) {
      localView.setVisibility(0);
    }
    localObject = this._OverflowMenu;
    if (ActionBarHelper.HasPermanentMenuKey())
    {
      paramInt1 = 8;
      ((ImageView)localObject).setVisibility(paramInt1);
      if (this._OverflowMenu.getVisibility() == 0)
      {
        if (paramInt2 != 4) {
          break label135;
        }
        this._OverflowMenu.setBackgroundDrawable(this._OverflowSelectedBackground);
      }
    }
    for (;;)
    {
      if (this._OldActiveButton == null)
      {
        this._SectionEpisodes.setVisibility(0);
        this._SectionPlayer.setVisibility(0);
        this._SectionFeeds.setReadOnly(false);
        this._OldActiveButton = this._SectionFeeds;
      }
      ActivateView(paramInt2);
      this._LastActiveView = paramInt2;
      return;
      paramInt1 = 0;
      break;
      label135:
      this._OverflowMenu.setBackgroundResource(2130837651);
    }
  }
  
  private void ActivateView(int paramInt)
  {
    if (paramInt == 1)
    {
      AnimateTo(this._SectionFeeds);
      return;
    }
    if (paramInt == 3)
    {
      AnimateTo(this._SectionEpisodes);
      return;
    }
    AnimateTo(this._SectionPlayer);
  }
  
  public void Initialize(Workspace paramWorkspace)
  {
    super.Initialize();
    this._Owner = paramWorkspace;
    this._SectionFeeds = ((TitleBarTabButton)findViewById(2131230863));
    this._SectionEpisodes = ((TitleBarTabButton)findViewById(2131230864));
    this._SectionPlayer = ((TitleBarTabButtonPlayer)findViewById(2131230865));
    this._SectionFeeds.setButtonType(0);
    this._SectionEpisodes.setButtonType(1);
    this._OverflowMenu = ((ImageView)findViewById(2131230867));
    this._OverflowMenu.setOnClickListener(this._OverflowMenuClickListener);
    this._OverflowMenu.setAlpha(128);
    this._SectionEpisodes.setVisibility(8);
    this._SectionEpisodes.setActive(false);
    AssignWidth(this._SectionEpisodes, 0.0F);
    this._SectionPlayer.setVisibility(8);
    this._SectionPlayer.setInactiveOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        TitleBarMasterView.this._Owner.ActivateView(4);
      }
    });
    this._SectionPlayer.setActiveOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        TitleBarMasterView.this._Owner.TogglePlayerPlaylist();
      }
    });
    AssignWidth(this._SectionPlayer, 0.0F);
    this._SectionPlayer.setActive(false);
    AssignWidth(this._SectionFeeds, 1.0F);
    this._SectionFeeds.setActive(true);
    this._SectionFeeds.setReadOnly(true);
    this._SectionFeeds.setVisibility(0);
    this._Animation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        if (TitleBarMasterView.this._OldActiveButton == TitleBarMasterView.this._SectionFeeds)
        {
          TitleBarMasterView.this.AssignWidth(TitleBarMasterView.this._SectionEpisodes, 0.0F);
          TitleBarMasterView.this.AssignWidth(TitleBarMasterView.this._SectionPlayer, 0.0F);
          return;
        }
        if (TitleBarMasterView.this._OldActiveButton == TitleBarMasterView.this._SectionEpisodes)
        {
          TitleBarMasterView.this.AssignWidth(TitleBarMasterView.this._SectionFeeds, 0.0F);
          TitleBarMasterView.this.AssignWidth(TitleBarMasterView.this._SectionPlayer, 0.0F);
          return;
        }
        TitleBarMasterView.this.AssignWidth(TitleBarMasterView.this._SectionEpisodes, 0.0F);
        TitleBarMasterView.this.AssignWidth(TitleBarMasterView.this._SectionFeeds, 0.0F);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        paramAnonymousAnimation = (TitleBarBase.WeightAnimation)paramAnonymousAnimation;
        ((TitleBarBase.ISelectableTab)paramAnonymousAnimation.FromSection).setActive(false);
        ((TitleBarBase.ISelectableTab)paramAnonymousAnimation.ToSection).setActive(true);
        if (paramAnonymousAnimation.ToSection == TitleBarMasterView.this._SectionEpisodes) {
          TitleBarMasterView.this._SectionFeeds.setBackgroundDrawable(TitleBarMasterView.this._SectionFeeds._MiddleBackground);
        }
        for (;;)
        {
          TitleBarMasterView.this._OldActiveButton = paramAnonymousAnimation.ToSection;
          return;
          if (paramAnonymousAnimation.ToSection == TitleBarMasterView.this._SectionPlayer) {
            TitleBarMasterView.this._SectionFeeds.setBackgroundDrawable(TitleBarMasterView.this._SectionFeeds._LeftBackground);
          }
        }
      }
    });
    this._MediaRouteButton = ((MediaRouteButton)findViewById(2131230866));
    this._MediaRouteButton.setRouteSelector(BeyondPodApplication.GetInstance().ChromecastDevice().getRouteSelector());
    this._MediaRouteButton.setDialogFactory(new BPMediaRouteDialogFactory());
  }
  
  public void ToggleTittleIndeterminateProgress(boolean paramBoolean)
  {
    ProgressBar localProgressBar = this._Progress;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localProgressBar.setVisibility(i);
      return;
    }
  }
  
  public void onPause()
  {
    this._SectionFeeds.onPause();
    this._SectionEpisodes.onPause();
  }
  
  public void setTitle(TitleBarBase.TitleInfo paramTitleInfo)
  {
    if (IsRepositoryLoading())
    {
      this._SectionFeeds.setTitle(paramTitleInfo);
      return;
    }
    int i = this._Owner.ActiveViewIndex();
    if (i != this._LastActiveView) {
      ActivateTab(this._LastActiveView, i);
    }
    if (i == 3) {
      this._SectionEpisodes.setTitle(paramTitleInfo);
    }
    for (;;)
    {
      this._SectionPlayer.refresh();
      return;
      if (i == 4) {
        this._SectionPlayer.setTitle(paramTitleInfo);
      } else {
        this._SectionFeeds.setTitle(paramTitleInfo);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/base/TitleBarMasterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */