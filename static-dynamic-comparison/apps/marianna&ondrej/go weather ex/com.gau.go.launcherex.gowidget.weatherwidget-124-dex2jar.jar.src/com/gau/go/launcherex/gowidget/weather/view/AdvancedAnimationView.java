package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;

public abstract class AdvancedAnimationView
  extends RelativeLayout
{
  protected boolean a = true;
  
  public AdvancedAnimationView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AdvancedAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public abstract void a();
  
  protected void a(View paramView, Animation paramAnimation)
  {
    if (paramView.getVisibility() != 0) {
      paramView.setVisibility(0);
    }
    paramView.startAnimation(paramAnimation);
  }
  
  public abstract void b();
  
  public abstract long c();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/AdvancedAnimationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */