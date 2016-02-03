package com.gtp.go.weather.sharephoto.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class LikeUnlikeAnimView
  extends RelativeLayout
  implements Animation.AnimationListener
{
  private ImageView a;
  
  @SuppressLint({"NewApi"})
  public LikeUnlikeAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (Build.VERSION.SDK_INT == 15) {
      setLayerType(1, null);
    }
  }
  
  private void c()
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(this);
    }
  }
  
  public void a()
  {
    this.a.setImageResource(2130838428);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130968613);
    localAnimation.setInterpolator(new OvershootInterpolator());
    localAnimation.setAnimationListener(this);
    this.a.startAnimation(localAnimation);
  }
  
  public void b()
  {
    this.a.setImageResource(2130838437);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130968613);
    localAnimation.setInterpolator(new OvershootInterpolator());
    localAnimation.setAnimationListener(this);
    this.a.startAnimation(localAnimation);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    c();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((ImageView)findViewById(2131231829));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/view/LikeUnlikeAnimView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */