package com.jiubang.playsdk.detail;

import android.content.Context;
import com.jiubang.playsdk.a.k;
import com.jiubang.playsdk.f.a;

class g
  implements k
{
  g(f paramf) {}
  
  public void a(com.android.a.aa paramaa)
  {
    f.a(this.a).b();
    paramaa = com.jiubang.playsdk.a.aa.a().c(f.b(this.a));
    f.a(this.a, paramaa);
  }
  
  public void a(com.jiubang.playsdk.a.a.c paramc)
  {
    f.a(this.a).b();
    if ((paramc == null) || (paramc.a == null))
    {
      paramc = com.jiubang.playsdk.a.aa.a().c(f.c(this.a));
      f.a(this.a, paramc);
      return;
    }
    int i = com.jiubang.playsdk.a.aa.a().b().r();
    int j = com.jiubang.playsdk.a.aa.a().b().o();
    String str = a.a(f.d(this.a), f.e(this.a).getPackageName());
    a.a(f.f(this.a), j, i, str, 0);
    if (paramc.b == 0)
    {
      f.b(this.a, paramc.a);
      return;
    }
    f.a(this.a, paramc.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/detail/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */