package com.go.weatherex.home;

import android.app.Activity;
import com.gau.go.launcherex.gowidget.a.g;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.b.u;
import com.gau.go.launcherex.gowidget.weather.globalview.a;
import com.gau.go.launcherex.gowidget.weather.globalview.t;
import com.getjar.sdk.Account;
import com.getjar.sdk.GetjarClient;
import java.util.ArrayList;
import java.util.List;

class o
  implements Runnable
{
  o(m paramm) {}
  
  public void run()
  {
    if (m.a(this.a)) {
      return;
    }
    Object localObject = m.e(this.a).c().getAvailableAccounts();
    if (((List)localObject).size() < 1)
    {
      m.b(this.a).b();
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < ((List)localObject).size())
    {
      Account localAccount = (Account)((List)localObject).get(i);
      a locala = new a();
      locala.b = false;
      locala.a = localAccount.getName();
      localArrayList.add(locala);
      i += 1;
    }
    localObject = new t(m.c(this.a));
    ((t)localObject).b(2131165985);
    ((t)localObject).a(8);
    ((t)localObject).a(localArrayList);
    ((t)localObject).setCanceledOnTouchOutside(false);
    ((t)localObject).setCancelable(false);
    ((t)localObject).c(0);
    ((t)localObject).a(new p(this));
    ((t)localObject).a();
    y.a("maps_tab_map_detail", m.c(this.a).getApplicationContext());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */