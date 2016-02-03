package com.gtp.go.weather.sharephoto.d;

import android.content.Context;
import android.os.Handler;
import com.jiubang.core.c.a.a;
import java.io.File;
import java.util.WeakHashMap;

public class c
  implements com.jiubang.core.c.a.c
{
  private Context a;
  private com.jiubang.core.c.a.b b;
  private WeakHashMap c = new WeakHashMap();
  private Handler d;
  
  public c(Context paramContext)
  {
    this.a = paramContext;
    this.b = new com.jiubang.core.c.a.b(this.a);
    this.b.a(this);
    this.d = new Handler();
  }
  
  public void a()
  {
    this.b.a(true);
  }
  
  public void a(j paramj, String paramString, b paramb, k paramk)
  {
    paramj = h.a(paramj);
    String str1 = h.a(paramString) + ".png";
    String str2 = paramj + File.separator + str1;
    if (h.b(str2))
    {
      paramk.a();
      new d(this, str2, paramb, paramk, paramString).start();
      return;
    }
    this.c.put(paramString, paramk);
    this.b.a(new a(paramString, paramj, str1));
  }
  
  public void a(a parama)
  {
    parama = (k)this.c.get(parama.a);
    if (parama != null) {
      parama.a();
    }
  }
  
  public void b(a parama)
  {
    k localk = (k)this.c.get(parama.a);
    if (localk != null) {
      localk.a(parama.e);
    }
  }
  
  public void c(a parama)
  {
    k localk = (k)this.c.remove(parama.a);
    if (localk != null) {
      new f(this, parama, localk).start();
    }
  }
  
  public void d(a parama)
  {
    k localk = (k)this.c.remove(parama.a);
    if (localk != null) {
      localk.a(false, parama.a, null, "");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */