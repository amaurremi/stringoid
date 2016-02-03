package mobi.beyondpod.ui.views.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.helpers.AnalyticsTracker;
import mobi.beyondpod.services.player.impl.ChromecastDevice;
import mobi.beyondpod.ui.core.ActionBarHelper;
import mobi.beyondpod.ui.core.SimpleMenu;
import mobi.beyondpod.ui.core.mediarouter.BPMediaRouteDialogFactory;
import mobi.beyondpod.ui.core.mediarouter.MediaRouteButton;
import mobi.beyondpod.ui.dialogs.FeedQuickPickDialog.FeedSelectedListener;
import mobi.beyondpod.ui.views.FeedContentViewActivity;

public class TitleBarFeedContent
  extends TitleBarBase
{
  View.OnClickListener _FeedInactiveListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      TitleBarFeedContent.this._Owner.ActivateView(1);
    }
  };
  MediaRouteButton _MediaRouteButton;
  ImageView _OverflowMenu;
  View.OnClickListener _OverflowMenuClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      paramAnonymousView = TitleBarFeedContent.this._Owner.ActiveView().PreparePopupOptionsMenu();
      paramAnonymousView.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
      {
        public boolean onMenuItemClick(MenuItem paramAnonymous2MenuItem)
        {
          return TitleBarFeedContent.this._Owner.ActiveView().HandleOptionsMenu(0, paramAnonymous2MenuItem);
        }
      });
      paramAnonymousView.showAsPopupMenu();
    }
  };
  FeedContentViewActivity _Owner;
  View.OnClickListener _PlayerActiveListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      TitleBarFeedContent.this._Owner.TogglePlayerPlaylist();
    }
  };
  View.OnClickListener _PlayerInactiveListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      TitleBarFeedContent.this._Owner.ActivateView(2);
    }
  };
  TitleBarFeedButton _SectionFeed;
  TitleBarHomeButton _SectionHome;
  TitleBarTabButtonPlayer _SectionPlayer;
  
  public TitleBarFeedContent(Context paramContext)
  {
    super(paramContext);
  }
  
  public TitleBarFeedContent(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void ActivateTab(int paramInt1, int paramInt2)
  {
    Object localObject = findViewById(2131230869);
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this._OverflowMenu;
    if (ActionBarHelper.HasPermanentMenuKey())
    {
      paramInt1 = 8;
      ((ImageView)localObject).setVisibility(paramInt1);
      if (this._OverflowMenu.getVisibility() == 0)
      {
        if (paramInt2 != 2) {
          break label116;
        }
        this._OverflowMenu.setBackgroundDrawable(this._OverflowSelectedBackground);
      }
    }
    for (;;)
    {
      if (this._OldActiveButton == null)
      {
        this._SectionHome.setVisibility(0);
        this._SectionPlayer.setVisibility(0);
        this._SectionFeed.setReadOnly(false);
        this._OldActiveButton = this._SectionFeed;
      }
      ActivateView(paramInt2);
      this._LastActiveView = paramInt2;
      return;
      paramInt1 = 0;
      break;
      label116:
      this._OverflowMenu.setBackgroundResource(2130837651);
    }
  }
  
  private void ActivateView(int paramInt)
  {
    if (paramInt == 1)
    {
      AnimateTo(this._SectionFeed);
      return;
    }
    AnimateTo(this._SectionPlayer);
  }
  
  public void Initialize(FeedContentViewActivity paramFeedContentViewActivity)
  {
    super.Initialize();
    this._Owner = paramFeedContentViewActivity;
    this._SectionFeed = ((TitleBarFeedButton)findViewById(2131230863));
    this._SectionHome = ((TitleBarHomeButton)findViewById(2131230875));
    this._SectionPlayer = ((TitleBarTabButtonPlayer)findViewById(2131230865));
    this._Progress = ((ProgressBar)findViewById(2131230868));
    this._OverflowMenu = ((ImageView)findViewById(2131230867));
    this._OverflowMenu.setOnClickListener(this._OverflowMenuClickListener);
    this._OverflowMenu.setAlpha(128);
    this._MediaRouteButton = ((MediaRouteButton)findViewById(2131230866));
    this._MediaRouteButton.setRouteSelector(BeyondPodApplication.GetInstance().ChromecastDevice().getRouteSelector());
    this._MediaRouteButton.setDialogFactory(new BPMediaRouteDialogFactory());
    this._SectionHome.setVisibility(8);
    AssignWidth(this._SectionHome, 0.0F);
    this._SectionPlayer.setVisibility(8);
    AssignWidth(this._SectionPlayer, 0.0F);
    this._SectionPlayer.setInactiveOnClickListener(this._PlayerInactiveListener);
    this._SectionPlayer.setActiveOnClickListener(this._PlayerActiveListener);
    this._SectionPlayer.setActive(false);
    AssignWidth(this._SectionFeed, 1.0F);
    this._SectionFeed.setActive(true);
    this._SectionFeed.setReadOnly(true);
    this._SectionFeed.setVisibility(0);
    this._SectionFeed.setInactiveOnClickListener(this._FeedInactiveListener);
    this._SectionFeed.setFeedSelectedListener(new FeedQuickPickDialog.FeedSelectedListener()
    {
      public void onFeedSelected(Feed paramAnonymousFeed)
      {
        AnalyticsTracker.OnCommand("Feeds Contnent View", "Active Feed Changed");
        TitleBarFeedContent.this._Owner.LoadFeed(paramAnonymousFeed, 0);
      }
    });
    this._Animation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        if (TitleBarFeedContent.this._OldActiveButton == TitleBarFeedContent.this._SectionFeed)
        {
          TitleBarFeedContent.this.AssignWidth(TitleBarFeedContent.this._SectionPlayer, 0.0F);
          return;
        }
        TitleBarFeedContent.this.AssignWidth(TitleBarFeedContent.this._SectionFeed, 0.0F);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        paramAnonymousAnimation = (TitleBarBase.WeightAnimation)paramAnonymousAnimation;
        ((TitleBarBase.ISelectableTab)paramAnonymousAnimation.FromSection).setActive(false);
        ((TitleBarBase.ISelectableTab)paramAnonymousAnimation.ToSection).setActive(true);
        if (paramAnonymousAnimation.ToSection == TitleBarFeedContent.this._SectionFeed) {
          TitleBarFeedContent.this._SectionHome.setBackgroundDrawable(TitleBarFeedContent.this._SectionHome._MiddleBackground);
        }
        for (;;)
        {
          TitleBarFeedContent.this._OldActiveButton = paramAnonymousAnimation.ToSection;
          return;
          if (paramAnonymousAnimation.ToSection == TitleBarFeedContent.this._SectionPlayer) {
            TitleBarFeedContent.this._SectionHome.setBackgroundDrawable(TitleBarFeedContent.this._SectionHome._LeftBackground);
          }
        }
      }
    });
    this._SectionHome.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        TitleBarFeedContent.this._Owner.finish();
      }
    });
  }
  
  public void SetTitleProgress(int paramInt)
  {
    ProgressBar localProgressBar = this._Progress;
    if (paramInt < 100) {}
    for (paramInt = 0;; paramInt = 8)
    {
      localProgressBar.setVisibility(paramInt);
      return;
    }
  }
  
  public void onPause()
  {
    this._SectionFeed.onPause();
  }
  
  public void setFeedPreviewMode()
  {
    ViewParent localViewParent = this._MediaRouteButton.getParent();
    if ((localViewParent instanceof ViewGroup)) {
      ((ViewGroup)localViewParent).removeView(this._MediaRouteButton);
    }
    this._OverflowMenu.setVisibility(8);
    this._SectionPlayer.setVisibility(8);
    this._SectionFeed.setFeedPreviewMode();
  }
  
  public void setTitle(final TitleBarBase.TitleInfo paramTitleInfo)
  {
    this._Owner.runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (TitleBarFeedContent.this.IsRepositoryLoading())
        {
          TitleBarFeedContent.this._SectionFeed.setTitle(paramTitleInfo);
          return;
        }
        int i = TitleBarFeedContent.this._Owner.ActiveViewIndex();
        if (i != TitleBarFeedContent.this._LastActiveView) {
          TitleBarFeedContent.this.ActivateTab(TitleBarFeedContent.this._LastActiveView, i);
        }
        if (i == 2) {
          TitleBarFeedContent.this._SectionPlayer.setTitle(paramTitleInfo);
        }
        for (;;)
        {
          TitleBarFeedContent.this._SectionPlayer.refresh();
          return;
          TitleBarFeedContent.this._SectionFeed.setTitle(paramTitleInfo);
        }
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/base/TitleBarFeedContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */