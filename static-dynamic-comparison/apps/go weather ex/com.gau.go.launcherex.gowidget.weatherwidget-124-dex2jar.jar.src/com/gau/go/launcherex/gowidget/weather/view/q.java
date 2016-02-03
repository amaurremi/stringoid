package com.gau.go.launcherex.gowidget.weather.view;

import android.content.ContentResolver;
import com.jiubang.core.c.j;
import java.lang.ref.WeakReference;

class q
  extends j
{
  private WeakReference a;
  
  public q(ContentResolver paramContentResolver, AppListActivity paramAppListActivity)
  {
    super(paramContentResolver);
    this.a = new WeakReference(paramAppListActivity);
  }
  
  protected void a(int paramInt1, Object paramObject, int paramInt2)
  {
    AppListActivity localAppListActivity = (AppListActivity)this.a.get();
    if (localAppListActivity != null) {
      AppListActivity.a(localAppListActivity, paramInt1, paramObject, paramInt2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */