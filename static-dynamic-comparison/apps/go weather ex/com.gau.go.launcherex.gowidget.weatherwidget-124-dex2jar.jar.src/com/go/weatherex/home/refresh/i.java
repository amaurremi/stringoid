package com.go.weatherex.home.refresh;

class i
  implements Runnable
{
  i(PullRefreshLayout paramPullRefreshLayout) {}
  
  public void run()
  {
    PullRefreshLayout.b(this.a, PullRefreshLayout.g(this.a) + this.a.getPaddingTop(), PullRefreshLayout.i(this.a));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/refresh/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */