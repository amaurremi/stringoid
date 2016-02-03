package com.go.weatherex.home.refresh;

import android.view.animation.Animation;

class j
  implements Runnable
{
  j(PullRefreshLayout paramPullRefreshLayout) {}
  
  public void run()
  {
    PullRefreshLayout.a(this.a, true);
    if (PullRefreshLayout.e(this.a) != null)
    {
      PullRefreshLayout.b(this.a, PullRefreshLayout.j(this.a));
      PullRefreshLayout.l(this.a).setDuration(PullRefreshLayout.k(this.a));
      PullRefreshLayout.l(this.a).setAnimationListener(PullRefreshLayout.m(this.a));
      PullRefreshLayout.l(this.a).reset();
      this.a.startAnimation(PullRefreshLayout.l(this.a));
    }
    PullRefreshLayout.a(this.a, PullRefreshLayout.g(this.a) + this.a.getPaddingTop(), PullRefreshLayout.h(this.a));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/refresh/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */