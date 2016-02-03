package com.jiubang.playsdk.main;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jiubang.playsdk.a.k;
import com.jiubang.playsdk.a.x;
import com.jiubang.playsdk.i;
import com.jiubang.playsdk.imageload.p;
import com.jiubang.playsdk.views.TitleBar;
import com.jiubang.playsdk.views.q;

public class e
  extends t
  implements k
{
  private x m;
  private boolean n = false;
  private Handler o = new f(this);
  
  public e(u paramu)
  {
    super(paramu);
  }
  
  private void b(x paramx)
  {
    com.jiubang.playsdk.e.d locald = paramx.a(paramx.a());
    if (locald != null)
    {
      paramx = com.jiubang.playsdk.views.a.a(LayoutInflater.from(this.a), locald, paramx);
      if (paramx != null)
      {
        this.b.removeAllViews();
        this.b.addView(paramx.a());
      }
    }
  }
  
  private void d()
  {
    if (!com.jiubang.playsdk.g.e.j(this.a))
    {
      this.o.sendEmptyMessageDelayed(1, 1L);
      return;
    }
    this.o.sendEmptyMessageDelayed(1, 5000L);
    this.f.a(0L, 1, 2, 0, this);
  }
  
  private void j()
  {
    if (this.b.getChildCount() != 0) {
      return;
    }
    this.n = true;
    Object localObject = com.jiubang.playsdk.e.f.b(0L, 1, 2, 0);
    if (this.f.c((String)localObject))
    {
      com.jiubang.playsdk.c.d.a(new h(this, (String)localObject));
      return;
    }
    localObject = LayoutInflater.from(this.a).inflate(com.jiubang.playsdk.g.f, null);
    this.b.addView((View)localObject);
    p();
  }
  
  public void a(com.android.a.aa paramaa) {}
  
  public void a(x paramx)
  {
    if ((paramx != null) && (!this.n))
    {
      this.o.removeMessages(1);
      this.m = paramx;
      o();
    }
  }
  
  protected boolean b()
  {
    return this.m != null;
  }
  
  protected void c()
  {
    if (this.f.f())
    {
      String str = com.jiubang.playsdk.e.f.b(0L, 1, 2, 0);
      if (this.f.c(str)) {
        com.jiubang.playsdk.c.d.a(new g(this, str));
      }
    }
    for (;;)
    {
      new com.jiubang.playsdk.imageload.a().a(this.a);
      return;
      d();
      continue;
      d();
    }
  }
  
  protected void e()
  {
    if (b())
    {
      o();
      return;
    }
    q();
    c();
  }
  
  protected int f()
  {
    return com.jiubang.playsdk.g.l;
  }
  
  protected void g()
  {
    b(this.m);
  }
  
  public void h()
  {
    this.h.a(this.a.getString(i.m));
  }
  
  public void i()
  {
    super.i();
    com.jiubang.playsdk.a.aa.a().c();
    p.a().b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/main/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */