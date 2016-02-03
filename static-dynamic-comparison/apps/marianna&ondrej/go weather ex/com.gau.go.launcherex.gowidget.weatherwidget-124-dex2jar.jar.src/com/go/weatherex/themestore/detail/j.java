package com.go.weatherex.themestore.detail;

import android.text.TextUtils;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.main.c;

class j
  implements com.jiubang.playsdk.detail.a.j
{
  j(g paramg) {}
  
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
          boolean bool = com.jiubang.playsdk.g.a.a(this.a.a, (String)localObject, null);
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!bool))
          {
            g.a(this.a, parama.i(), (String)localObject);
            return;
          }
          localObject = com.jiubang.playsdk.f.a.a(this.a.a, this.a.f.a(parama));
          com.jiubang.playsdk.f.a.a(this.a.a, this.a.g.o(), parama.b(), this.a.g.r(), parama.t(), (String)localObject);
          localObject = this.a.f.a(this.a.a, parama);
        } while (this.a.g.f(this.a.a, (com.jiubang.playsdk.a.a)localObject));
        com.jiubang.playsdk.g.a.a(this.a.a, parama);
        return;
      } while (parama == null);
      localObject = aa.a().a(parama);
    } while (TextUtils.isEmpty((CharSequence)localObject));
    if (!com.jiubang.playsdk.g.a.a(this.a.a, (String)localObject, null))
    {
      g.a(this.a, parama.i(), (String)localObject);
      return;
    }
    this.a.g.a(this.a.a, (String)localObject, parama.c());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/detail/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */