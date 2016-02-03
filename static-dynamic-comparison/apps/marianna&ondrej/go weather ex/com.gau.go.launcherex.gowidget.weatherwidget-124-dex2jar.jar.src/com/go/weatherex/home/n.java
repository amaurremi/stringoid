package com.go.weatherex.home;

import android.app.Activity;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.b.u;
import com.getjar.sdk.Account;
import com.getjar.sdk.GetjarClient;
import com.gtp.go.weather.sharephoto.a.a;
import com.gtp.go.weather.sharephoto.a.g;
import com.gtp.go.weather.sharephoto.b.o;

class n
  implements Runnable
{
  n(m paramm) {}
  
  public void run()
  {
    if (m.a(this.a)) {}
    String str;
    do
    {
      do
      {
        return;
        m.b(this.a).b();
      } while ((!TextUtils.isEmpty(g.a(m.c(this.a).getApplicationContext()).b().a())) || (!y.h(m.c(this.a).getApplicationContext())));
      str = m.d(this.a).getCurrentAccount().getName();
    } while (TextUtils.isEmpty(str));
    g.a(m.c(this.a).getApplicationContext()).c().a(false, str);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */