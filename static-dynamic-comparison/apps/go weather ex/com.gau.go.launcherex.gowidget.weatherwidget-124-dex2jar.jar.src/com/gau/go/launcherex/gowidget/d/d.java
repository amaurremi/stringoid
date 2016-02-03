package com.gau.go.launcherex.gowidget.d;

import java.lang.ref.WeakReference;

class d
  implements Runnable
{
  private final int a;
  private final Object b;
  private final WeakReference c;
  
  d(c paramc, int paramInt, Object paramObject)
  {
    this.c = new WeakReference(paramc);
    this.a = paramInt;
    this.b = paramObject;
  }
  
  public void run()
  {
    c localc = (c)this.c.get();
    if (localc == null) {
      return;
    }
    c.a(localc, this.a);
    localc.a(this.a, this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */