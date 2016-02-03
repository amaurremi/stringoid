package com.go.weatherex.home;

import com.gau.go.launcherex.gowidget.a.g;
import com.gau.go.launcherex.gowidget.weather.globalview.a;
import com.gau.go.launcherex.gowidget.weather.globalview.t;
import com.gau.go.launcherex.gowidget.weather.globalview.w;
import com.getjar.sdk.GetjarClient;

class p
  implements w
{
  p(o paramo) {}
  
  public void a(t paramt, boolean paramBoolean, a parama)
  {
    if ((paramBoolean) && (parama != null)) {
      m.e(this.a.a).c().setCurrentAccount(parama.a, "getjar.android_account");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */