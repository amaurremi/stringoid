package mobi.beyondpod.ui.views.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import mobi.beyondpod.R.styleable;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.repository.FeedRepository;

public class TitleBarBase
  extends LinearLayout
{
  protected WeightAnimation _Animation = new WeightAnimation();
  protected int _LastActiveView = -1;
  protected View _OldActiveButton;
  protected Drawable _OverflowSelectedBackground;
  protected ProgressBar _Progress;
  
  public TitleBarBase(Context paramContext)
  {
    super(paramContext);
  }
  
  public TitleBarBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void AnimateTo(View paramView)
  {
    if (this._OldActiveButton == paramView) {
      return;
    }
    this._Animation.reset();
    this._Animation.setFromTo(this._OldActiveButton, paramView);
    startAnimation(this._Animation);
  }
  
  protected void AssignWidth(View paramView, float paramFloat)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.weight = paramFloat;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  public void Initialize()
  {
    this._Progress = ((ProgressBar)findViewById(2131230868));
    setWeightSum(1.0F);
    this._Animation.setDuration(150L);
    this._Animation.setInterpolator(new DecelerateInterpolator());
    TypedArray localTypedArray = getContext().obtainStyledAttributes(R.styleable.TitleButtons);
    this._OverflowSelectedBackground = localTypedArray.getDrawable(12);
    localTypedArray.recycle();
  }
  
  protected boolean IsRepositoryLoading()
  {
    return (FeedRepository.RepositoryLoadState() != 2) && (FeedRepository.RepositoryLoadState() != 3);
  }
  
  public static abstract interface ISelectableTab
  {
    public abstract void setActive(boolean paramBoolean);
    
    public abstract void setReadOnly(boolean paramBoolean);
    
    public abstract void setTitle(TitleBarBase.TitleInfo paramTitleInfo);
  }
  
  public static class TitleInfo
  {
    public Feed CurrentFeed;
    public String DebugText;
    public Drawable Icon;
    public String InfoText;
    public String PrimaryTitle;
    public String SubTitle;
  }
  
  public static class WeightAnimation
    extends Animation
  {
    View FromSection;
    View ToSection;
    LinearLayout.LayoutParams _FromParams;
    float _FromW;
    LinearLayout.LayoutParams _ToParams;
    float _ToW;
    
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      float f = this._FromW;
      paramFloat = f + (this._ToW - f) * paramFloat;
      this._FromParams.weight = paramFloat;
      this._ToParams.weight = (1.0F - paramFloat);
      this.FromSection.setLayoutParams(this._FromParams);
      this.ToSection.setLayoutParams(this._ToParams);
    }
    
    void setFromTo(View paramView1, View paramView2)
    {
      this.FromSection = paramView1;
      this.ToSection = paramView2;
      this._FromParams = ((LinearLayout.LayoutParams)this.FromSection.getLayoutParams());
      this._FromW = this._FromParams.weight;
      this._ToParams = ((LinearLayout.LayoutParams)this.ToSection.getLayoutParams());
      this._ToW = this._ToParams.weight;
    }
    
    public boolean willChangeBounds()
    {
      return false;
    }
    
    public boolean willChangeTransformationMatrix()
    {
      return false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/base/TitleBarBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */