package com.go.weatherex.themestore.detail;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jiubang.playsdk.adapter.PackageBroadcastReceiver;
import com.jiubang.playsdk.adapter.l;
import com.jiubang.playsdk.adapter.m;
import com.jiubang.playsdk.detail.a.d;
import com.jiubang.playsdk.e.e;
import com.jiubang.playsdk.main.u;

public class b
  extends n
  implements com.jiubang.playsdk.a.k, com.jiubang.playsdk.adapter.k, l, m, d
{
  private e s;
  private long t;
  private ThemeDetailView u;
  private PackageBroadcastReceiver v;
  private boolean w = false;
  private com.jiubang.playsdk.detail.a.a x;
  private View.OnClickListener y = new c(this);
  
  public b(u paramu)
  {
    super(paramu);
    b();
  }
  
  private void m()
  {
    this.u = ((ThemeDetailView)this.b);
    this.u.a(this.y);
  }
  
  private void s()
  {
    if (this.s == null) {
      return;
    }
    this.o.setText(this.s.b());
    this.x = new com.jiubang.playsdk.detail.a.a(this.a, this.s);
    this.x.a(this);
    this.u.a(this.x);
    t();
  }
  
  private void t()
  {
    if (u())
    {
      this.u.b(2131165219);
      return;
    }
    this.u.b(2131165213);
    com.jiubang.playsdk.e.a locala = this.s.f();
    if ((locala != null) && (locala.m()))
    {
      this.u.a(2130837989);
      return;
    }
    if ((locala != null) && (locala.o()))
    {
      this.u.a(2130837989);
      return;
    }
    this.u.a(2130837990);
  }
  
  private boolean u()
  {
    if (this.g.a(this.a)) {}
    com.jiubang.playsdk.e.a locala;
    do
    {
      return true;
      locala = this.s.f();
    } while ((locala == null) || (locala.h() == 0));
    return false;
  }
  
  public void a(int paramInt)
  {
    ThemeFullPreview localThemeFullPreview = (ThemeFullPreview)this.d.inflate(2130903307, null);
    localThemeFullPreview.setClickable(true);
    localThemeFullPreview.setFocusable(true);
    localThemeFullPreview.setFocusableInTouchMode(true);
    localThemeFullPreview.requestFocus();
    localThemeFullPreview.a(this.s, paramInt);
    if ((this.b.getParent().getParent() instanceof RelativeLayout)) {
      ((RelativeLayout)this.b.getParent().getParent()).addView(localThemeFullPreview);
    }
  }
  
  public void a(com.android.a.aa paramaa) {}
  
  public void a(e parame)
  {
    this.s = parame;
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
    if (this.v == null) {
      this.v = new PackageBroadcastReceiver(this.a);
    }
    if (this.w) {
      c();
    }
    this.v.a(this);
    this.v.a(this);
    this.v.a(this);
    this.a.registerReceiver(this.v, this.v.a());
    this.w = true;
  }
  
  public void b(e parame)
  {
    if (parame != null)
    {
      this.s = parame;
      o();
    }
  }
  
  public void c()
  {
    this.a.unregisterReceiver(this.v);
    this.v.a(null);
    this.v.a(null);
    this.v.a(null);
    this.w = false;
  }
  
  protected boolean d()
  {
    return (this.s != null) && (this.s.f() != null);
  }
  
  protected void e()
  {
    m();
    if (d())
    {
      o();
      return;
    }
    if (this.t == 0L)
    {
      a("no detail data");
      return;
    }
    q();
    this.f.a(this.t, this);
  }
  
  protected int f()
  {
    return 2130903306;
  }
  
  protected void g()
  {
    s();
  }
  
  public void h() {}
  
  public void i()
  {
    c();
    if (this.x != null) {
      this.x.a(null);
    }
  }
  
  public String j()
  {
    String str2 = "";
    String str1 = str2;
    if (this.s != null)
    {
      str1 = str2;
      if (this.s.f() != null) {
        str1 = this.s.f().c();
      }
    }
    return str1;
  }
  
  public void k()
  {
    if (this.x != null) {
      this.x.a();
    }
  }
  
  public void l()
  {
    if (this.u != null) {
      this.u.a();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/detail/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */