package com.go.weatherex.themestore.detail;

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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.adapter.PackageBroadcastReceiver;
import com.jiubang.playsdk.detail.ThemeLocalDetailView;
import com.jiubang.playsdk.detail.a.d;
import com.jiubang.playsdk.main.c;
import com.jiubang.playsdk.main.u;
import com.jiubang.playsdk.views.ConfirmDialogView;
import com.jiubang.playsdk.views.TitleBar;
import java.util.ArrayList;
import java.util.List;

public class g
  extends n
  implements com.jiubang.playsdk.adapter.k, com.jiubang.playsdk.adapter.l, com.jiubang.playsdk.adapter.m, d, com.jiubang.playsdk.main.i
{
  private boolean A = false;
  private com.jiubang.playsdk.a.k B = new h(this);
  private Dialog C;
  private ConfirmDialogView D;
  private com.jiubang.playsdk.a.a s;
  private int t;
  private ThemeLocalDetailView u;
  private ThemeDetailView v;
  private com.jiubang.playsdk.detail.a.g w;
  private com.jiubang.playsdk.detail.a.l x;
  private com.jiubang.playsdk.detail.a.e y = null;
  private PackageBroadcastReceiver z;
  
  public g(u paramu)
  {
    super(paramu);
    b();
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.C == null)
    {
      this.C = new AlertDialog.Builder(this.a).create();
      this.D = ConfirmDialogView.a(this.a);
      this.D.a(new k(this));
      this.D.b(new l(this));
    }
    this.C.show();
    String str = a(this.a, paramString);
    this.D.a(str);
    this.D.a(paramInt);
    this.D.b(paramString);
    this.C.setContentView(this.D);
  }
  
  private void a(View paramView)
  {
    paramView.setClickable(false);
    new Handler().postDelayed(new m(this, paramView), 500L);
  }
  
  private void a(List paramList)
  {
    int i = v();
    this.u.b(2131165214);
    this.u.c(2130837994);
    this.x = new com.jiubang.playsdk.detail.a.l(this.a, paramList, i);
    this.u.c(this.x);
    this.u.a(new i(this));
  }
  
  private void b(com.jiubang.playsdk.a.a parama)
  {
    parama = this.g.c(this.a, parama);
    this.u.a(new com.jiubang.playsdk.detail.a.n(this.a, parama, this.t));
  }
  
  private void b(List paramList)
  {
    this.u.b(2131165215);
    this.u.c(2130837995);
    this.w = new com.jiubang.playsdk.detail.a.g(this.a, paramList, this.t);
    this.u.b(this.w);
    this.w.a(new j(this));
  }
  
  private void s()
  {
    this.t = t();
    if ((this.b instanceof ThemeDetailView))
    {
      this.v = ((ThemeDetailView)this.b);
      localView = this.g.a(this.a, this.s, this);
      if (localView != null)
      {
        com.jiubang.playsdk.g.a.a(localView);
        this.v.addView(localView);
      }
    }
    while (!(this.b instanceof ThemeLocalDetailView))
    {
      View localView;
      return;
    }
    this.u = ((ThemeLocalDetailView)this.b);
  }
  
  private int t()
  {
    int i = this.a.getResources().getDimensionPixelSize(2131427345);
    int j = this.a.getResources().getDimensionPixelSize(2131427396);
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
    int i = this.a.getResources().getDimensionPixelSize(2131427345);
    int j = this.a.getResources().getDimensionPixelSize(2131427350);
    return (u() - i * 2 - j * 2) / 3;
  }
  
  private boolean w()
  {
    return this.s.f();
  }
  
  private void x()
  {
    z();
    if (this.s.g())
    {
      this.v.a(this.g.a(this.a, this.s));
      return;
    }
    ArrayList localArrayList = this.g.c(this.a, this.s);
    this.y = new com.jiubang.playsdk.detail.a.e(this.a, localArrayList);
    this.y.a(this);
    this.v.a(this.y);
  }
  
  private void y()
  {
    b(this.s);
    z();
    j();
  }
  
  private void z()
  {
    if (this.s.e())
    {
      this.r.setVisibility(0);
      if (this.g.d(this.a, this.s)) {
        break label99;
      }
      if (this.u != null)
      {
        this.u.a(2131165216);
        this.u.a(this);
      }
      if (this.v != null)
      {
        this.v.b(2131165216);
        this.v.a(this);
      }
    }
    label99:
    do
    {
      return;
      this.r.setVisibility(8);
      break;
      if (this.u != null) {
        this.u.a(2131165217);
      }
    } while (this.v == null);
    this.v.b(2131165217);
    this.v.a(false);
  }
  
  public String a(Context paramContext, String paramString)
  {
    int i;
    if ("com.jb.gokeyboard".equals(paramString)) {
      i = 2131165238;
    }
    for (;;)
    {
      return paramContext.getString(2131165232, new Object[] { paramContext.getString(i) });
      if ("com.gau.go.launcherex".equals(paramString)) {
        i = 2131165235;
      } else if ("com.jiubang.goscreenlock".equals(paramString)) {
        i = 2131165237;
      } else if ("com.jb.gosms".equals(paramString)) {
        i = 2131165234;
      } else {
        i = 2131165236;
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.y != null)
    {
      ThemeFullPreview localThemeFullPreview = (ThemeFullPreview)this.d.inflate(2130903307, null);
      localThemeFullPreview.setClickable(true);
      localThemeFullPreview.setFocusable(true);
      localThemeFullPreview.setFocusableInTouchMode(true);
      localThemeFullPreview.requestFocus();
      localThemeFullPreview.a(this.y.a(), paramInt);
      if ((this.b.getParent().getParent() instanceof RelativeLayout)) {
        ((RelativeLayout)this.b.getParent().getParent()).addView(localThemeFullPreview);
      }
    }
  }
  
  public void a(com.jiubang.playsdk.a.a parama)
  {
    this.s = parama;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.w != null)
    {
      this.w.a();
      this.w.notifyDataSetChanged();
    }
    if (this.x != null)
    {
      this.x.a();
      this.x.notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    if (this.z == null) {
      this.z = new PackageBroadcastReceiver(this.a);
    }
    if (this.A) {
      c();
    }
    this.z.a(this);
    this.z.a(this);
    this.z.a(this);
    this.a.registerReceiver(this.z, this.z.a());
    this.A = true;
  }
  
  public void c()
  {
    this.a.unregisterReceiver(this.z);
    this.z.a(null);
    this.z.a(null);
    this.z.a(null);
    this.A = false;
  }
  
  protected boolean d()
  {
    return this.s != null;
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
    int i = 2130903206;
    if (w()) {
      i = 2130903306;
    }
    return i;
  }
  
  protected void g()
  {
    p();
    if (this.v != null) {
      x();
    }
    while (this.u == null) {
      return;
    }
    y();
  }
  
  public void h()
  {
    if (this.s == null) {
      return;
    }
    String str = com.jiubang.playsdk.g.e.d(this.a);
    str = this.s.f(str);
    this.o.setText(str);
  }
  
  public void i()
  {
    this.h.a(null);
    this.h.a(null);
    if (this.y != null) {
      this.y = null;
    }
    if (this.x != null) {
      this.x = null;
    }
    if (this.w != null) {
      this.w = null;
    }
    c();
  }
  
  protected void j()
  {
    this.u.a();
    String str = this.s.a();
    aa.a().a(str, 1, this.f.b().o(), this.B);
  }
  
  public void k()
  {
    z();
  }
  
  public void l()
  {
    if (this.u != null) {
      this.u.c();
    }
    if (this.v != null) {
      this.v.a();
    }
  }
  
  public void m()
  {
    z();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131231634) || (paramView.getId() == 2131231653))
    {
      if (!this.g.d(this.a, this.s))
      {
        this.g.e(this.a, this.s);
        a(paramView);
      }
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/detail/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */