package com.gau.go.launcherex.gowidget.weather.view;

import android.content.pm.ResolveInfo;
import com.gau.go.launcherex.gowidget.weather.globalview.c;
import java.util.List;

class m
  implements c
{
  m(AppListActivity paramAppListActivity, int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    ResolveInfo localResolveInfo;
    if (paramBoolean) {
      localResolveInfo = (ResolveInfo)AppListActivity.b(this.b).get(this.a);
    }
    switch (AppListActivity.f(this.b))
    {
    default: 
      return;
    case 1: 
      AppListActivity.a(this.b, localResolveInfo);
      return;
    }
    AppListActivity.b(this.b, localResolveInfo);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */