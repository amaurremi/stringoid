package com.gau.go.launcherex.goweather.a;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class d
  implements Animation.AnimationListener
{
  d(b paramb, View paramView, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setVisibility(this.b);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.setVisibility(0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */