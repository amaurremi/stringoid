package com.gau.go.launcherex.gowidget.weather.view;

import android.os.AsyncTask;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;

class p
  extends AsyncTask
{
  private p(AppListActivity paramAppListActivity) {}
  
  protected BaseAdapter a(String... paramVarArgs)
  {
    AppListActivity.a(this.a);
    AppListActivity.a(this.a, new n(this.a, AppListActivity.b(this.a)));
    return AppListActivity.c(this.a);
  }
  
  protected void a(BaseAdapter paramBaseAdapter)
  {
    if (!this.a.isFinishing())
    {
      AppListActivity.d(this.a).setVisibility(8);
      AppListActivity.e(this.a).setAdapter(paramBaseAdapter);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */