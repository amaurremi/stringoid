package com.jiubang.playsdk.detail;

import android.text.TextUtils;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.detail.a.j;
import com.jiubang.playsdk.main.c;

class i
  implements j
{
  i(f paramf) {}
  
  public void a(com.jiubang.playsdk.e.a parama, int paramInt)
  {
    switch (paramInt)
    {
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (parama == null);
          localObject = parama.p();
          boolean bool = com.jiubang.playsdk.g.a.a(f.q(this.a), (String)localObject, null);
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!bool))
          {
            f.a(this.a, parama.i(), (String)localObject);
            return;
          }
          localObject = com.jiubang.playsdk.f.a.a(f.r(this.a), f.s(this.a).a(parama));
          com.jiubang.playsdk.f.a.a(f.t(this.a), f.u(this.a).o(), parama.b(), f.v(this.a).r(), parama.t(), (String)localObject);
          localObject = f.x(this.a).a(f.w(this.a), parama);
        } while (f.z(this.a).f(f.y(this.a), (com.jiubang.playsdk.a.a)localObject));
        com.jiubang.playsdk.g.a.a(f.A(this.a), parama);
        return;
      } while (parama == null);
      localObject = aa.a().a(parama);
    } while (TextUtils.isEmpty((CharSequence)localObject));
    if (!com.jiubang.playsdk.g.a.a(f.B(this.a), (String)localObject, null))
    {
      f.a(this.a, parama.i(), (String)localObject);
      return;
    }
    f.D(this.a).a(f.C(this.a), (String)localObject, parama.c());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/detail/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */