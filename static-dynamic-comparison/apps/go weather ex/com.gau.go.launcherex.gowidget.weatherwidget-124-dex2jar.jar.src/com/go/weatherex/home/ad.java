package com.go.weatherex.home;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ad
  implements Animation.AnimationListener
{
  ad(SidebarIcon paramSidebarIcon) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!SidebarIcon.a(this.a)) {
      this.a.b();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */