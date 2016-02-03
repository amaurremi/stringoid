package mobi.beyondpod.ui.core.pulltorefresh.internal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LoadingLayout
  extends FrameLayout
{
  static final int DEFAULT_ROTATION_ANIMATION_DURATION = 150;
  private final ImageView headerImage;
  private final ProgressBar headerProgress;
  private final TextView headerText;
  private String pullLabel;
  private String refreshingLabel;
  private String releaseLabel;
  private final Animation resetRotateAnimation;
  private final Animation rotateAnimation;
  
  public LoadingLayout(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    super(paramContext);
    paramContext = (ViewGroup)LayoutInflater.from(paramContext).inflate(2130903158, this);
    this.headerText = ((TextView)paramContext.findViewById(2131231167));
    this.headerImage = ((ImageView)paramContext.findViewById(2131231169));
    this.headerProgress = ((ProgressBar)paramContext.findViewById(2131231168));
    paramContext = new LinearInterpolator();
    this.rotateAnimation = new RotateAnimation(0.0F, -180.0F, 1, 0.5F, 1, 0.5F);
    this.rotateAnimation.setInterpolator(paramContext);
    this.rotateAnimation.setDuration(150L);
    this.rotateAnimation.setFillAfter(true);
    this.resetRotateAnimation = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.resetRotateAnimation.setInterpolator(paramContext);
    this.resetRotateAnimation.setDuration(150L);
    this.resetRotateAnimation.setFillAfter(true);
    this.releaseLabel = paramString1;
    this.pullLabel = paramString2;
    this.refreshingLabel = paramString3;
    switch (paramInt)
    {
    default: 
      this.headerImage.setImageResource(2130838078);
      return;
    }
    this.headerImage.setImageResource(2130838079);
  }
  
  public void pullToRefresh()
  {
    this.headerText.setText(this.pullLabel);
    this.headerImage.clearAnimation();
    this.headerImage.startAnimation(this.resetRotateAnimation);
  }
  
  public void refreshing()
  {
    this.headerText.setText(this.refreshingLabel);
    this.headerImage.clearAnimation();
    this.headerImage.setVisibility(4);
    this.headerProgress.setVisibility(0);
  }
  
  public void releaseToRefresh()
  {
    this.headerText.setText(this.releaseLabel);
    this.headerImage.clearAnimation();
    this.headerImage.startAnimation(this.rotateAnimation);
  }
  
  public void reset()
  {
    this.headerText.setText(this.pullLabel);
    this.headerImage.setVisibility(0);
    this.headerProgress.setVisibility(8);
  }
  
  public void setPullLabel(String paramString)
  {
    this.pullLabel = paramString;
  }
  
  public void setRefreshingLabel(String paramString)
  {
    this.refreshingLabel = paramString;
  }
  
  public void setReleaseLabel(String paramString)
  {
    this.releaseLabel = paramString;
  }
  
  public void setTextColor(int paramInt)
  {
    this.headerText.setTextColor(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/pulltorefresh/internal/LoadingLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */