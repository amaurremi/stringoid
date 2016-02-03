package mobi.beyondpod.ui.views.base;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import mobi.beyondpod.R.styleable;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategories;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.dialogs.CategoryQuickPickDialog;
import mobi.beyondpod.ui.dialogs.CategoryQuickPickDialog.CategorySelectedListener;
import mobi.beyondpod.ui.dialogs.QuickPickDialogBase;
import mobi.beyondpod.ui.views.FeedsView;
import mobi.beyondpod.ui.views.MasterView;
import mobi.beyondpod.ui.views.Workspace;

public class TitleBarTabButton
  extends FrameLayout
  implements TitleBarBase.ISelectableTab
{
  static final int BUTTON_TYPE_EPISODES = 1;
  static final int BUTTON_TYPE_FEEDS = 0;
  int _ButtonType = 0;
  QuickPickDialogBase _CategoryPicker;
  View.OnClickListener _DropDownClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      int i = 1;
      paramAnonymousView = TitleBarTabButton.this;
      Context localContext = TitleBarTabButton.this.getContext();
      CategoryQuickPickDialog.CategorySelectedListener local1 = new CategoryQuickPickDialog.CategorySelectedListener()
      {
        public void onCategorySelected(FeedCategory paramAnonymous2FeedCategory)
        {
          if (paramAnonymous2FeedCategory != null) {
            CommandManager.CmdSelectCategoryQuick(paramAnonymous2FeedCategory);
          }
        }
        
        public void onFeedSelected(Feed paramAnonymous2Feed)
        {
          FeedsView localFeedsView;
          if (paramAnonymous2Feed != null)
          {
            Configuration.setActiveFeedCategory(paramAnonymous2Feed.getCategories().getPrimary());
            localFeedsView = MasterView.Master().Workspace.Feeds;
            if (!paramAnonymous2Feed.IsSubFeed()) {
              break label46;
            }
          }
          label46:
          for (Feed localFeed = paramAnonymous2Feed.ParentFeed();; localFeed = FeedRepository.getRootFeed())
          {
            localFeedsView.SetRootFeed(localFeed);
            CommandManager.CmdOpenPodcastsView(paramAnonymous2Feed);
            return;
          }
        }
      };
      FeedCategory localFeedCategory = Configuration.getActiveFeedCategory();
      if (TitleBarTabButton.this._ButtonType == 1) {}
      for (;;)
      {
        paramAnonymousView._CategoryPicker = new CategoryQuickPickDialog(localContext, local1, localFeedCategory, i);
        TitleBarTabButton.this._CategoryPicker.show(TitleBarTabButton.this);
        return;
        i = 0;
      }
    }
  };
  ImageView _DropDownIndicator;
  TextView _InactiveButton;
  View.OnClickListener _InactiveClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      paramAnonymousView = MasterView.Master().Workspace;
      if (TitleBarTabButton.this._ButtonType == 0) {}
      for (int i = 1;; i = 3)
      {
        paramAnonymousView.ActivateView(i);
        return;
      }
    }
  };
  boolean _IsActive = false;
  boolean _IsReadOnly = false;
  Drawable _LeftBackground;
  Drawable _LeftBackgroundSelected;
  Drawable _MiddleBackground;
  Drawable _MiddleBackgroundSelected;
  TextView _SubTitle;
  float _SubTitleBottomMargin;
  TextView _Title;
  float _TitleBottomMargin;
  TextView _TitleLabel;
  
  public TitleBarTabButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public TitleBarTabButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void HideTtitleLabel()
  {
    FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)this._SubTitle.getLayoutParams();
    FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)this._Title.getLayoutParams();
    localLayoutParams1.gravity = 16;
    localLayoutParams1.bottomMargin = 0;
    localLayoutParams2.gravity = 16;
    localLayoutParams2.bottomMargin = 0;
    this._TitleLabel.setVisibility(8);
  }
  
  private void ShowTtitleLabel()
  {
    Object localObject = (FrameLayout.LayoutParams)this._SubTitle.getLayoutParams();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this._Title.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).gravity = 80;
    ((FrameLayout.LayoutParams)localObject).bottomMargin = ((int)this._SubTitleBottomMargin);
    localLayoutParams.gravity = 80;
    localLayoutParams.bottomMargin = ((int)this._TitleBottomMargin);
    localObject = this._TitleLabel;
    if (this._ButtonType == 0) {}
    for (int i = 2131296988;; i = 2131296989)
    {
      ((TextView)localObject).setText(i);
      this._TitleLabel.setVisibility(0);
      return;
    }
  }
  
  private void UpdateTitleLabel()
  {
    if (this._IsReadOnly)
    {
      HideTtitleLabel();
      return;
    }
    if ((this._IsActive) && (Configuration.getActiveFeedCategory() != CategoryManager.AllFeeds)) {}
    for (int i = 1; i != 0; i = 0)
    {
      ShowTtitleLabel();
      return;
    }
    HideTtitleLabel();
  }
  
  public void Initialize()
  {
    this._Title = ((TextView)findViewById(2131230782));
    this._SubTitle = ((TextView)findViewById(2131230873));
    this._TitleLabel = ((TextView)findViewById(2131230872));
    this._Title.setEllipsize(TextUtils.TruncateAt.MARQUEE);
    this._Title.setFadingEdgeLength((int)getResources().getDimension(2131492952) * 4);
    this._Title.setHorizontalFadingEdgeEnabled(true);
    this._InactiveButton = ((TextView)findViewById(2131230871));
    this._DropDownIndicator = ((ImageView)findViewById(2131230874));
    TypedArray localTypedArray = MasterView.Master().obtainStyledAttributes(R.styleable.TitleButtons);
    this._LeftBackground = localTypedArray.getDrawable(6);
    this._LeftBackgroundSelected = localTypedArray.getDrawable(9);
    this._MiddleBackground = localTypedArray.getDrawable(7);
    this._MiddleBackgroundSelected = localTypedArray.getDrawable(10);
    localTypedArray.recycle();
    this._TitleBottomMargin = getResources().getDimension(2131492917);
    this._SubTitleBottomMargin = getResources().getDimension(2131492918);
    setActive(false);
    this._DropDownIndicator.setVisibility(8);
    ((FrameLayout.LayoutParams)this._DropDownIndicator.getLayoutParams()).bottomMargin = ((int)(this._SubTitleBottomMargin * 0.7D));
  }
  
  public void draw(Canvas paramCanvas)
  {
    try
    {
      super.draw(paramCanvas);
      return;
    }
    catch (Exception paramCanvas)
    {
      this._Title.setEllipsize(TextUtils.TruncateAt.END);
      this._Title.setHorizontalFadingEdgeEnabled(false);
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    Initialize();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = Math.min(getWidth() - this._SubTitle.getWidth() - 25, this._Title.getRight());
    this._Title.layout(this._Title.getLeft(), this._Title.getTop(), paramInt1, this._Title.getBottom());
    this._SubTitle.layout(paramInt1, this._SubTitle.getTop(), this._SubTitle.getWidth() + paramInt1, this._SubTitle.getBottom());
  }
  
  public void onPause()
  {
    if (this._CategoryPicker != null) {
      this._CategoryPicker.dismiss();
    }
  }
  
  public void setActive(boolean paramBoolean)
  {
    this._IsActive = paramBoolean;
    if (paramBoolean)
    {
      this._Title.setVisibility(0);
      this._SubTitle.setVisibility(0);
      this._DropDownIndicator.setVisibility(0);
      this._InactiveButton.setVisibility(8);
      setOnClickListener(this._DropDownClickListener);
      if (this._ButtonType == 0) {}
      for (localDrawable = this._LeftBackgroundSelected;; localDrawable = this._MiddleBackgroundSelected)
      {
        setBackgroundDrawable(localDrawable);
        UpdateTitleLabel();
        return;
      }
    }
    this._Title.setVisibility(8);
    this._SubTitle.setVisibility(8);
    this._DropDownIndicator.setVisibility(8);
    this._InactiveButton.setVisibility(0);
    setOnClickListener(this._InactiveClickListener);
    if (this._ButtonType == 0) {}
    for (Drawable localDrawable = this._LeftBackground;; localDrawable = this._MiddleBackground)
    {
      setBackgroundDrawable(localDrawable);
      break;
    }
  }
  
  public void setButtonType(int paramInt)
  {
    this._ButtonType = paramInt;
    Object localObject = this._InactiveButton;
    if (this._ButtonType == 0)
    {
      paramInt = 2131296990;
      ((TextView)localObject).setText(paramInt);
      if (this._ButtonType != 0) {
        break label51;
      }
    }
    label51:
    for (localObject = this._LeftBackground;; localObject = this._MiddleBackground)
    {
      setBackgroundDrawable((Drawable)localObject);
      return;
      paramInt = 2131296987;
      break;
    }
  }
  
  public void setReadOnly(boolean paramBoolean)
  {
    this._IsReadOnly = paramBoolean;
    Object localObject = this._DropDownIndicator;
    int i;
    if (paramBoolean)
    {
      i = 8;
      ((ImageView)localObject).setVisibility(i);
      if (this._ButtonType == 0) {
        if (!paramBoolean) {
          break label57;
        }
      }
    }
    label57:
    for (localObject = this._MiddleBackground;; localObject = this._LeftBackgroundSelected)
    {
      setBackgroundDrawable((Drawable)localObject);
      if (!paramBoolean) {
        break label65;
      }
      HideTtitleLabel();
      return;
      i = 0;
      break;
    }
    label65:
    UpdateTitleLabel();
  }
  
  public void setTitle(TitleBarBase.TitleInfo paramTitleInfo)
  {
    TextView localTextView = this._Title;
    Object localObject;
    if (paramTitleInfo.PrimaryTitle != null)
    {
      localObject = paramTitleInfo.PrimaryTitle;
      localTextView.setText((CharSequence)localObject);
      localObject = this._SubTitle;
      if (paramTitleInfo.SubTitle == null) {
        break label56;
      }
    }
    label56:
    for (paramTitleInfo = paramTitleInfo.SubTitle;; paramTitleInfo = "")
    {
      ((TextView)localObject).setText(paramTitleInfo);
      UpdateTitleLabel();
      return;
      localObject = "";
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/base/TitleBarTabButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */