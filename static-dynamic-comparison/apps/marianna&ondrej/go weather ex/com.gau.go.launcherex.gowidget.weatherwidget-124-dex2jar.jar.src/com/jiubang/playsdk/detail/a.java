package com.jiubang.playsdk.detail;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.jiubang.playsdk.adapter.PackageBroadcastReceiver;
import com.jiubang.playsdk.adapter.l;
import com.jiubang.playsdk.adapter.m;
import com.jiubang.playsdk.detail.a.d;
import com.jiubang.playsdk.g;
import com.jiubang.playsdk.i;
import com.jiubang.playsdk.main.c;
import com.jiubang.playsdk.main.t;
import com.jiubang.playsdk.main.u;
import com.jiubang.playsdk.views.ThemeFullPreview;
import com.jiubang.playsdk.views.TitleBar;

public class a
  extends t
  implements com.jiubang.playsdk.a.k, com.jiubang.playsdk.adapter.k, l, m, d
{
  private com.jiubang.playsdk.e.e m;
  private long n;
  private ThemeDetailView o;
  private PackageBroadcastReceiver p;
  private boolean q = false;
  private com.jiubang.playsdk.detail.a.a r;
  private View.OnClickListener s = new b(this);
  
  public a(u paramu)
  {
    super(paramu);
    b();
  }
  
  private void m()
  {
    this.o = ((ThemeDetailView)this.b);
    this.o.a(this.s);
  }
  
  private void s()
  {
    if (this.m == null) {
      return;
    }
    this.h.a(this.m.b());
    this.r = new com.jiubang.playsdk.detail.a.a(this.a, this.m);
    this.r.a(this);
    this.o.a(this.r);
    t();
  }
  
  private void t()
  {
    if (u())
    {
      this.o.b(i.d);
      return;
    }
    this.o.b(i.e);
    com.jiubang.playsdk.e.a locala = this.m.f();
    if ((locala != null) && (locala.m()))
    {
      this.o.a(com.jiubang.playsdk.e.i);
      return;
    }
    if ((locala != null) && (locala.o()))
    {
      this.o.a(com.jiubang.playsdk.e.i);
      return;
    }
    this.o.a(com.jiubang.playsdk.e.j);
  }
  
  private boolean u()
  {
    if (this.g.a(this.a)) {}
    com.jiubang.playsdk.e.a locala;
    do
    {
      return true;
      locala = this.m.f();
    } while ((locala == null) || (locala.h() == 0));
    return false;
  }
  
  public void a(int paramInt)
  {
    ThemeFullPreview localThemeFullPreview = (ThemeFullPreview)this.d.inflate(g.h, null);
    localThemeFullPreview.setClickable(true);
    localThemeFullPreview.setFocusable(true);
    localThemeFullPreview.setFocusableInTouchMode(true);
    localThemeFullPreview.requestFocus();
    localThemeFullPreview.a(this.m, paramInt);
    if ((this.b.getParent().getParent() instanceof RelativeLayout)) {
      ((RelativeLayout)this.b.getParent().getParent()).addView(localThemeFullPreview);
    }
  }
  
  public void a(com.android.a.aa paramaa) {}
  
  public void a(com.jiubang.playsdk.e.e parame)
  {
    this.m = parame;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      String str = j();
      if ((!TextUtils.isEmpty(str)) && (paramString.contains(str)) && ((this.a instanceof Activity))) {
        ((Activity)this.a).finish();
      }
    }
  }
  
  public void b()
  {
    if (this.p == null) {
      this.p = new PackageBroadcastReceiver(this.a);
    }
    if (this.q) {
      c();
    }
    this.p.a(this);
    this.p.a(this);
    this.p.a(this);
    this.a.registerReceiver(this.p, this.p.a());
    this.q = true;
  }
  
  public void b(com.jiubang.playsdk.e.e parame)
  {
    if (parame != null)
    {
      this.m = parame;
      o();
    }
  }
  
  public void c()
  {
    this.a.unregisterReceiver(this.p);
    this.p.a(null);
    this.p.a(null);
    this.p.a(null);
    this.q = false;
  }
  
  protected boolean d()
  {
    return (this.m != null) && (this.m.f() != null);
  }
  
  protected void e()
  {
    m();
    if (d())
    {
      o();
      return;
    }
    if (this.n == 0L)
    {
      a("no detail data");
      return;
    }
    q();
    this.f.a(this.n, this);
  }
  
  protected int f()
  {
    return g.x;
  }
  
  protected void g()
  {
    s();
  }
  
  public void h() {}
  
  public void i()
  {
    c();
    if (this.r != null) {
      this.r.a(null);
    }
  }
  
  public String j()
  {
    String str2 = "";
    String str1 = str2;
    if (this.m != null)
    {
      str1 = str2;
      if (this.m.f() != null) {
        str1 = this.m.f().c();
      }
    }
    return str1;
  }
  
  public void k()
  {
    if (this.r != null) {
      this.r.a();
    }
  }
  
  public void l()
  {
    if (this.o != null) {
      this.o.a();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/detail/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */