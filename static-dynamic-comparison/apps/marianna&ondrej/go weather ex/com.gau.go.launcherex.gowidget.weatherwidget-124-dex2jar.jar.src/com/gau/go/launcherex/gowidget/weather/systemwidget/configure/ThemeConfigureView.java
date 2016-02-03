package com.gau.go.launcherex.gowidget.weather.systemwidget.configure;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View.MeasureSpec;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.jiubang.playsdk.a.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ThemeConfigureView
  extends ScrollView
  implements com.gau.go.launcherex.gowidget.messagecenter.util.g, com.gau.go.launcherex.gowidget.weather.globaltheme.c.c, k
{
  FrameLayout a;
  LinearLayout b;
  LinearLayout c;
  public com.gau.go.launcherex.gowidget.weather.globaltheme.d d;
  private Context e;
  private LinearLayout f;
  private e g;
  private a h;
  private boolean i;
  private ArrayList j;
  private ArrayList k;
  private AlphaAnimation l;
  private AlphaAnimation m;
  private ArrayList n;
  private com.gau.go.launcherex.gowidget.messagecenter.util.c o;
  private com.jiubang.playsdk.a.aa p;
  private com.jiubang.playsdk.main.c q;
  private com.gau.go.launcherex.goweather.goplay.q r;
  private ThemeConfigureView.PackageChangeReceiver s;
  private t t;
  private i u;
  
  public ThemeConfigureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.e = paramContext;
    this.l = new AlphaAnimation(0.0F, 1.0F);
    this.l.setDuration(300L);
    this.m = new AlphaAnimation(1.0F, 0.0F);
    this.m.setDuration(300L);
    this.s = new ThemeConfigureView.PackageChangeReceiver(this);
    paramContext = new IntentFilter();
    paramContext.addAction("android.intent.action.PACKAGE_ADDED");
    paramContext.addAction("android.intent.action.PACKAGE_REMOVED");
    paramContext.addAction("android.intent.action.PACKAGE_REPLACED");
    paramContext.addDataScheme("package");
    this.e.registerReceiver(this.s, paramContext);
    this.t = new t(this, null);
    paramContext = new IntentFilter();
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_THEME_CHANGE");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_USED_COUPON_ID");
    this.e.registerReceiver(this.t, paramContext);
    this.p = com.jiubang.playsdk.a.aa.a();
    this.p.a(this.e);
    this.q = this.p.b();
    if ((this.q != null) && ((this.q instanceof com.gau.go.launcherex.goweather.goplay.q))) {
      this.r = ((com.gau.go.launcherex.goweather.goplay.q)this.q);
    }
    for (;;)
    {
      this.d = new com.gau.go.launcherex.gowidget.weather.globaltheme.d(this.e);
      this.d.a(this);
      this.o = new com.gau.go.launcherex.gowidget.messagecenter.util.c(this.e);
      this.o.a(this);
      return;
      this.r = new com.gau.go.launcherex.goweather.goplay.q();
      this.p.a(this.r);
    }
  }
  
  private void a(String paramString)
  {
    this.u.a(paramString);
  }
  
  private void b(String paramString)
  {
    paramString = this.d.a(paramString);
    if ((paramString != null) && (paramString.D()) && (this.g.c())) {
      this.g.c(paramString);
    }
  }
  
  private void c(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.g.c()))
    {
      this.g.a(this.b.getWidth(), this.b.getHeight());
      this.g.b(paramString);
    }
  }
  
  public void a()
  {
    if (this.d != null) {
      this.d.a();
    }
    if (this.o != null) {
      this.o.c();
    }
    if (this.s != null) {
      this.e.unregisterReceiver(this.s);
    }
    if (this.t != null) {
      this.e.unregisterReceiver(this.t);
    }
    if (this.g != null) {
      this.g.a();
    }
    if (this.h != null) {
      this.h.c();
    }
    if ((this.r != null) && (this.r != this.q))
    {
      this.p.a(this.q);
      this.r = null;
    }
  }
  
  public void a(int paramInt, com.gau.go.launcherex.gowidget.weather.globaltheme.b.e parame) {}
  
  public void a(Activity paramActivity)
  {
    this.g.a(paramActivity);
    this.u.a(paramActivity);
    this.p.a(40, this);
    this.d.a(0);
    this.o.a();
  }
  
  public void a(com.android.a.aa paramaa) {}
  
  public void a(com.gau.go.launcherex.gowidget.weather.globaltheme.b.g paramg)
  {
    if (paramg != null) {
      switch (paramg.a())
      {
      }
    }
    for (;;)
    {
      this.f.setVisibility(0);
      return;
      this.j = paramg.b();
      if (this.i)
      {
        this.g.a(this.b.getWidth(), this.b.getHeight());
        this.g.a(this.j);
        requestLayout();
      }
    }
  }
  
  public void a(q paramq)
  {
    this.g.a(paramq);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null)
    {
      SparseArray localSparseArray = new SparseArray();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        com.gau.go.launcherex.gowidget.weather.globaltheme.b.a locala = (com.gau.go.launcherex.gowidget.weather.globaltheme.b.a)paramArrayList.next();
        if ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.a)localSparseArray.get(locala.b()) == null) {
          localSparseArray.append(locala.b(), locala);
        }
      }
      this.n = new ArrayList();
      int i2 = localSparseArray.size();
      int i1 = 0;
      while (i1 < i2)
      {
        this.n.add(localSparseArray.valueAt(i1));
        i1 += 1;
      }
      this.g.b(this.n);
    }
  }
  
  public void a(List paramList)
  {
    ArrayList localArrayList;
    int i1;
    if (paramList != null)
    {
      localArrayList = new ArrayList();
      paramList = paramList.iterator();
      i1 = 0;
    }
    com.jiubang.playsdk.e.e locale;
    com.jiubang.playsdk.e.a locala;
    do
    {
      if (paramList.hasNext())
      {
        locale = (com.jiubang.playsdk.e.e)paramList.next();
        if (i1 <= 8) {}
      }
      else
      {
        this.k = localArrayList;
        if (this.i)
        {
          this.h.a(this.c.getWidth(), this.c.getHeight());
          this.h.d(this.k);
          requestLayout();
        }
        return;
      }
      locala = locale.f();
    } while (com.gau.go.launcherex.gowidget.weather.globaltheme.a.j(locala.c(), this.e));
    com.gau.go.launcherex.gowidget.weather.globaltheme.b.d locald = new com.gau.go.launcherex.gowidget.weather.globaltheme.b.d();
    locald.f(i1);
    locald.e((int)locala.b());
    locald.h(locala.i());
    locald.g(locala.j());
    locald.d(locala.d());
    locald.e(locala.c());
    if (locala.h() == 1) {
      if (locala.m()) {
        locald.a(2);
      }
    }
    for (;;)
    {
      locald.b(locala.g());
      locald.b(1);
      locald.a(locale.a());
      locald.p(true);
      localArrayList.add(locald);
      i1 += 1;
      break;
      if (locala.n())
      {
        locald.a(1);
      }
      else
      {
        locald.a(4);
        continue;
        locald.a(4);
      }
    }
  }
  
  public void b(ArrayList paramArrayList) {}
  
  public void c(ArrayList paramArrayList) {}
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((FrameLayout)findViewById(2131231953));
    this.f = ((LinearLayout)findViewById(2131231674));
    this.g = new e(this.e);
    this.b = ((LinearLayout)findViewById(2131231675));
    this.b.addView(this.g.b());
    this.h = new a(this.e);
    this.c = ((LinearLayout)findViewById(2131231676));
    this.c.addView(this.h.a());
    this.u = new i(this);
    this.u.a(this.g);
    this.u.a(this.h);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.i = true;
    if ((!this.g.c()) && (this.j != null))
    {
      this.g.a(this.b.getWidth(), this.b.getHeight());
      this.g.a(this.j);
    }
    if ((!this.h.b()) && (this.k != null))
    {
      this.h.a(this.c.getWidth(), this.c.getHeight());
      this.h.d(this.k);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = (int)(getResources().getDisplayMetrics().density * 265.0F);
    paramInt1 = Math.max(getMeasuredHeight(), paramInt1);
    this.a.measure(View.MeasureSpec.makeMeasureSpec(this.a.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/configure/ThemeConfigureView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */