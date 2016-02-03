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
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.ui.dialogs.FeedQuickPickDialog;
import mobi.beyondpod.ui.dialogs.FeedQuickPickDialog.FeedSelectedListener;
import mobi.beyondpod.ui.dialogs.QuickPickDialogBase;

public class TitleBarFeedButton
  extends FrameLayout
  implements TitleBarBase.ISelectableTab
{
  Feed _CurrentFeed;
  View.OnClickListener _DropDownClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      TitleBarFeedButton.this._FeedPicker = new FeedQuickPickDialog(TitleBarFeedButton.this.getContext(), TitleBarFeedButton.this._FeedSelectedListener, TitleBarFeedButton.this._CurrentFeed);
      TitleBarFeedButton.this._FeedPicker.show(TitleBarFeedButton.this);
    }
  };
  ImageView _DropDownIndicator;
  QuickPickDialogBase _FeedPicker;
  FeedQuickPickDialog.FeedSelectedListener _FeedSelectedListener;
  TextView _InactiveButton;
  View.OnClickListener _InactiveClickListener;
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
  
  public TitleBarFeedButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public TitleBarFeedButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void HideSubTitle()
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this._Title.getLayoutParams();
    localLayoutParams.gravity = 16;
    localLayoutParams.bottomMargin = 0;
    this._SubTitle.setVisibility(8);
  }
  
  private void ShowSubTtitle()
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this._Title.getLayoutParams();
    localLayoutParams.gravity = 80;
    localLayoutParams.bottomMargin = ((int)this._TitleBottomMargin);
    this._SubTitle.setVisibility(0);
  }
  
  private void UpdateTitleLabel()
  {
    if ((this._IsReadOnly) || (!this._IsActive) || (this._SubTitle.getText().length() == 0))
    {
      HideSubTitle();
      return;
    }
    ShowSubTtitle();
  }
  
  public void Initialize()
  {
    this._Title = ((TextView)findViewById(2131230782));
    this._SubTitle = ((TextView)findViewById(2131230873));
    this._InactiveButton = ((TextView)findViewById(2131230871));
    this._DropDownIndicator = ((ImageView)findViewById(2131230874));
    this._Title.setEllipsize(TextUtils.TruncateAt.MARQUEE);
    this._Title.setFadingEdgeLength((int)getResources().getDimension(2131492952) * 4);
    this._Title.setHorizontalFadingEdgeEnabled(true);
    TypedArray localTypedArray = getContext().obtainStyledAttributes(R.styleable.TitleButtons);
    this._LeftBackground = localTypedArray.getDrawable(6);
    this._LeftBackgroundSelected = localTypedArray.getDrawable(9);
    this._MiddleBackground = localTypedArray.getDrawable(7);
    this._MiddleBackgroundSelected = localTypedArray.getDrawable(10);
    localTypedArray.recycle();
    this._TitleBottomMargin = getResources().getDimension(2131492917);
    this._SubTitleBottomMargin = getResources().getDimension(2131492918);
    setActive(false);
    this._DropDownIndicator.setVisibility(8);
    ((FrameLayout.LayoutParams)this._DropDownIndicator.getLayoutParams()).bottomMargin = ((int)(this._SubTitleBottomMargin * 0.8D));
    setBackgroundDrawable(this._MiddleBackground);
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
  
  public void onPause()
  {
    if (this._FeedPicker != null) {
      this._FeedPicker.dismiss();
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
      setBackgroundDrawable(this._MiddleBackgroundSelected);
    }
    for (;;)
    {
      UpdateTitleLabel();
      return;
      this._Title.setVisibility(8);
      this._SubTitle.setVisibility(8);
      this._DropDownIndicator.setVisibility(8);
      this._InactiveButton.setVisibility(0);
      setOnClickListener(this._InactiveClickListener);
      setBackgroundDrawable(this._MiddleBackground);
    }
  }
  
  public void setFeedPreviewMode()
  {
    this._DropDownIndicator.setVisibility(8);
    setBackgroundDrawable(this._MiddleBackground);
    setEnabled(false);
  }
  
  void setFeedSelectedListener(FeedQuickPickDialog.FeedSelectedListener paramFeedSelectedListener)
  {
    this._FeedSelectedListener = paramFeedSelectedListener;
  }
  
  void setInactiveOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this._InactiveClickListener = paramOnClickListener;
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
      if ((!paramBoolean) && (this._IsActive)) {
        break label57;
      }
    }
    label57:
    for (localObject = this._MiddleBackground;; localObject = this._MiddleBackgroundSelected)
    {
      setBackgroundDrawable((Drawable)localObject);
      if (!paramBoolean) {
        break label65;
      }
      HideSubTitle();
      return;
      i = 0;
      break;
    }
    label65:
    UpdateTitleLabel();
  }
  
  public void setTitle(TitleBarBase.TitleInfo paramTitleInfo)
  {
    this._CurrentFeed = paramTitleInfo.CurrentFeed;
    TextView localTextView = this._Title;
    Object localObject;
    if (paramTitleInfo.PrimaryTitle != null)
    {
      localObject = paramTitleInfo.PrimaryTitle;
      localTextView.setText((CharSequence)localObject);
      localObject = this._SubTitle;
      if (paramTitleInfo.SubTitle == null) {
        break label63;
      }
    }
    label63:
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/base/TitleBarFeedButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */