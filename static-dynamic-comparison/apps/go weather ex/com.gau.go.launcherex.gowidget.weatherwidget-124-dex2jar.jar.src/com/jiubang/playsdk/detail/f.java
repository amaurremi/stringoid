package com.jiubang.playsdk.detail;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.adapter.PackageBroadcastReceiver;
import com.jiubang.playsdk.adapter.m;
import com.jiubang.playsdk.detail.a.n;
import com.jiubang.playsdk.main.c;
import com.jiubang.playsdk.main.t;
import com.jiubang.playsdk.main.u;
import com.jiubang.playsdk.views.ConfirmDialogView;
import com.jiubang.playsdk.views.ThemeFullPreview;
import com.jiubang.playsdk.views.TitleBar;
import java.util.ArrayList;
import java.util.List;

public class f
  extends t
  implements com.jiubang.playsdk.adapter.k, com.jiubang.playsdk.adapter.l, m, com.jiubang.playsdk.detail.a.d, com.jiubang.playsdk.main.i
{
  private com.jiubang.playsdk.a.a m;
  private int n;
  private ThemeLocalDetailView o;
  private ThemeDetailView p;
  private com.jiubang.playsdk.detail.a.g q;
  private com.jiubang.playsdk.detail.a.l r;
  private com.jiubang.playsdk.detail.a.e s;
  private PackageBroadcastReceiver t;
  private boolean u = false;
  private com.jiubang.playsdk.a.k v = new g(this);
  private Dialog w;
  private ConfirmDialogView x;
  
  public f(u paramu)
  {
    super(paramu);
    b();
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.w == null)
    {
      this.w = new AlertDialog.Builder(this.a).create();
      this.x = ConfirmDialogView.a(this.a);
      this.x.a(new j(this));
      this.x.b(new k(this));
    }
    this.w.show();
    String str = a(this.a, paramString);
    this.x.a(str);
    this.x.a(paramInt);
    this.x.b(paramString);
    this.w.setContentView(this.x);
  }
  
  private void a(View paramView)
  {
    paramView.setClickable(false);
    new Handler().postDelayed(new l(this, paramView), 500L);
  }
  
  private void a(List paramList)
  {
    int i = v();
    this.o.b(com.jiubang.playsdk.i.k);
    this.o.c(com.jiubang.playsdk.e.k);
    this.r = new com.jiubang.playsdk.detail.a.l(this.a, paramList, i);
    this.o.c(this.r);
    this.o.a(new h(this));
  }
  
  private void b(com.jiubang.playsdk.a.a parama)
  {
    parama = this.g.c(this.a, parama);
    this.o.a(new n(this.a, parama, this.n));
  }
  
  private void b(List paramList)
  {
    this.o.b(com.jiubang.playsdk.i.n);
    this.o.c(com.jiubang.playsdk.e.l);
    this.q = new com.jiubang.playsdk.detail.a.g(this.a, paramList, this.n);
    this.o.b(this.q);
    this.q.a(new i(this));
  }
  
  private void s()
  {
    this.n = t();
    if ((this.b instanceof ThemeDetailView))
    {
      this.p = ((ThemeDetailView)this.b);
      localView = this.g.a(this.a, this.m, this);
      if (localView != null)
      {
        com.jiubang.playsdk.g.a.a(localView);
        this.p.addView(localView);
      }
    }
    while (!(this.b instanceof ThemeLocalDetailView))
    {
      View localView;
      return;
    }
    this.o = ((ThemeLocalDetailView)this.b);
  }
  
  private int t()
  {
    int i = this.a.getResources().getDimensionPixelSize(com.jiubang.playsdk.d.t);
    int j = this.a.getResources().getDimensionPixelSize(com.jiubang.playsdk.d.d);
    int k = com.jiubang.playsdk.g.j.a(2.0F);
    return (u() - i * 2 - (j + k) * 2) / 3;
  }
  
  private int u()
  {
    int i = 1;
    if (this.a.getResources().getConfiguration().orientation == 1) {}
    while (i != 0)
    {
      return com.jiubang.playsdk.g.j.c;
      i = 0;
    }
    return com.jiubang.playsdk.g.j.d;
  }
  
  private int v()
  {
    int i = this.a.getResources().getDimensionPixelSize(com.jiubang.playsdk.d.t);
    int j = this.a.getResources().getDimensionPixelSize(com.jiubang.playsdk.d.w);
    return (u() - i * 2 - j * 2) / 3;
  }
  
  private boolean w()
  {
    return this.m.f();
  }
  
  private void x()
  {
    z();
    if (this.m.g())
    {
      this.p.a(this.g.a(this.a, this.m));
      return;
    }
    ArrayList localArrayList = this.g.c(this.a, this.m);
    this.s = new com.jiubang.playsdk.detail.a.e(this.a, localArrayList);
    this.s.a(this);
    this.p.a(this.s);
  }
  
  private void y()
  {
    b(this.m);
    z();
    j();
  }
  
  private void z()
  {
    if (this.m.e()) {
      this.h.a();
    }
    while (!this.g.d(this.a, this.m))
    {
      if (this.o != null)
      {
        this.o.a(com.jiubang.playsdk.i.b);
        this.o.a(this);
      }
      if (this.p != null)
      {
        this.p.b(com.jiubang.playsdk.i.b);
        this.p.a(this);
      }
      return;
      this.h.b();
    }
    if (this.o != null) {
      this.o.a(com.jiubang.playsdk.i.a);
    }
    if (this.p != null)
    {
      this.p.b(com.jiubang.playsdk.i.a);
      this.p.a(false);
    }
    this.h.b();
  }
  
  public String a(Context paramContext, String paramString)
  {
    int i;
    if ("com.jb.gokeyboard".equals(paramString)) {
      i = com.jiubang.playsdk.i.f;
    }
    for (;;)
    {
      paramString = paramContext.getString(i);
      return paramContext.getString(com.jiubang.playsdk.i.c, new Object[] { paramString });
      if ("com.gau.go.launcherex".equals(paramString)) {
        i = com.jiubang.playsdk.i.g;
      } else if ("com.jiubang.goscreenlock".equals(paramString)) {
        i = com.jiubang.playsdk.i.h;
      } else if ("com.jb.gosms".equals(paramString)) {
        i = com.jiubang.playsdk.i.i;
      } else {
        i = com.jiubang.playsdk.i.j;
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.s != null)
    {
      ThemeFullPreview localThemeFullPreview = (ThemeFullPreview)this.d.inflate(com.jiubang.playsdk.g.h, null);
      localThemeFullPreview.setClickable(true);
      localThemeFullPreview.setFocusable(true);
      localThemeFullPreview.setFocusableInTouchMode(true);
      localThemeFullPreview.requestFocus();
      localThemeFullPreview.a(this.s.a(), paramInt);
      if ((this.b.getParent().getParent() instanceof RelativeLayout)) {
        ((RelativeLayout)this.b.getParent().getParent()).addView(localThemeFullPreview);
      }
    }
  }
  
  public void a(com.jiubang.playsdk.a.a parama)
  {
    this.m = parama;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.q != null)
    {
      this.q.a();
      this.q.notifyDataSetChanged();
    }
    if (this.r != null)
    {
      this.r.a();
      this.r.notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    if (this.t == null) {
      this.t = new PackageBroadcastReceiver(this.a);
    }
    if (this.u) {
      c();
    }
    this.t.a(this);
    this.t.a(this);
    this.t.a(this);
    this.a.registerReceiver(this.t, this.t.a());
    this.u = true;
  }
  
  public void c()
  {
    this.a.unregisterReceiver(this.t);
    this.t.a(null);
    this.t.a(null);
    this.t.a(null);
    this.u = false;
  }
  
  protected boolean d()
  {
    return this.m != null;
  }
  
  protected void e()
  {
    s();
    if (d())
    {
      o();
      return;
    }
    a("no detail data");
  }
  
  protected int f()
  {
    int i = com.jiubang.playsdk.g.A;
    if (w()) {
      i = com.jiubang.playsdk.g.x;
    }
    return i;
  }
  
  protected void g()
  {
    p();
    if (this.p != null) {
      x();
    }
    while (this.o == null) {
      return;
    }
    y();
  }
  
  public void h()
  {
    if (this.m == null) {
      return;
    }
    String str = com.jiubang.playsdk.g.e.d(this.a);
    str = this.m.f(str);
    this.h.a(str);
  }
  
  public void i()
  {
    this.h.a(null);
    this.h.a(null);
    if (this.s != null) {
      this.s = null;
    }
    if (this.r != null) {
      this.r = null;
    }
    if (this.q != null) {
      this.q = null;
    }
    c();
  }
  
  protected void j()
  {
    this.o.a();
    String str = this.m.a();
    aa.a().a(str, 1, this.f.b().o(), this.v);
  }
  
  public void k()
  {
    z();
  }
  
  public void l()
  {
    if (this.o != null) {
      this.o.c();
    }
    if (this.p != null) {
      this.p.a();
    }
  }
  
  public void m()
  {
    z();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == com.jiubang.playsdk.f.aq) || (paramView.getId() == com.jiubang.playsdk.f.n))
    {
      if (!this.g.d(this.a, this.m))
      {
        this.g.e(this.a, this.m);
        a(paramView);
      }
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/detail/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */