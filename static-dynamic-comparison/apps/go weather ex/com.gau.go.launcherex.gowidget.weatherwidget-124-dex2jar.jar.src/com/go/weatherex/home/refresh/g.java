package com.go.weatherex.home.refresh;

import android.view.animation.Animation;
import com.gau.go.launcherex.gowidget.weather.util.b;

class g
  extends b
{
  g(PullRefreshLayout paramPullRefreshLayout) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    PullRefreshLayout.a(this.a, 0.0F);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/refresh/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */