package com.go.weatherex.themestore.detail;

import android.content.Context;
import com.jiubang.playsdk.a.k;
import com.jiubang.playsdk.detail.ThemeLocalDetailView;
import com.jiubang.playsdk.f.a;

class h
  implements k
{
  h(g paramg) {}
  
  public void a(com.android.a.aa paramaa)
  {
    g.a(this.a).b();
    paramaa = com.jiubang.playsdk.a.aa.a().c(this.a.a);
    g.a(this.a, paramaa);
  }
  
  public void a(com.jiubang.playsdk.a.a.c paramc)
  {
    g.a(this.a).b();
    if ((paramc == null) || (paramc.a == null))
    {
      paramc = com.jiubang.playsdk.a.aa.a().c(this.a.a);
      g.a(this.a, paramc);
      return;
    }
    int i = com.jiubang.playsdk.a.aa.a().b().r();
    int j = com.jiubang.playsdk.a.aa.a().b().o();
    String str = a.a(this.a.a, this.a.a.getPackageName());
    a.a(this.a.a, j, i, str, 0);
    if (paramc.b == 0)
    {
      g.b(this.a, paramc.a);
      return;
    }
    g.a(this.a, paramc.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/detail/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */