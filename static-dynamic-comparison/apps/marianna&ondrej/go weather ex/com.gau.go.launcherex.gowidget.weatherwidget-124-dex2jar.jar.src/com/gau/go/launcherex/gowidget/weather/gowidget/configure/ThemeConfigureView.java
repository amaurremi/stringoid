package com.gau.go.launcherex.gowidget.weather.gowidget.configure;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.gau.go.launcherex.goweather.goplay.q;
import com.jiubang.playsdk.a.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ThemeConfigureView
  extends ScrollView
  implements com.gau.go.launcherex.gowidget.messagecenter.util.g, com.gau.go.launcherex.gowidget.weather.globaltheme.c.c, k
{
  private Context a;
  private LinearLayout b;
  private LinearLayout c;
  private f d;
  private LinearLayout e;
  private a f;
  private boolean g;
  private ArrayList h;
  private ArrayList i;
  private AlphaAnimation j;
  private AlphaAnimation k;
  private ArrayList l;
  private com.gau.go.launcherex.gowidget.messagecenter.util.c m;
  private com.gau.go.launcherex.gowidget.weather.globaltheme.d n;
  private com.jiubang.playsdk.a.aa o;
  private com.jiubang.playsdk.main.c p;
  private q q;
  private ThemeConfigureView.PackageChangeReceiver r;
  private l s;
  
  public ThemeConfigureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    this.j = new AlphaAnimation(0.0F, 1.0F);
    this.j.setDuration(300L);
    this.k = new AlphaAnimation(1.0F, 0.0F);
    this.k.setDuration(300L);
    this.r = new ThemeConfigureView.PackageChangeReceiver(this);
    paramContext = new IntentFilter();
    paramContext.addAction("android.intent.action.PACKAGE_ADDED");
    paramContext.addAction("android.intent.action.PACKAGE_REMOVED");
    paramContext.addAction("android.intent.action.PACKAGE_REPLACED");
    paramContext.addDataScheme("package");
    this.a.registerReceiver(this.r, paramContext);
    this.s = new l(this, null);
    paramContext = new IntentFilter();
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_GOWIDGET_THEME_CHANGE");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_USED_COUPON_ID");
    this.a.registerReceiver(this.s, paramContext);
    this.o = com.jiubang.playsdk.a.aa.a();
    this.o.a(this.a);
    this.p = this.o.b();
    if ((this.p != null) && ((this.p instanceof q))) {
      this.q = ((q)this.p);
    }
    for (;;)
    {
      this.n = new com.gau.go.launcherex.gowidget.weather.globaltheme.d(this.a);
      this.n.a(this);
      this.m = new com.gau.go.launcherex.gowidget.messagecenter.util.c(this.a);
      this.m.a(this);
      return;
      this.q = new q();
      this.o.a(this.q);
    }
  }
  
  private void a(String paramString)
  {
    com.gau.go.launcherex.gowidget.weather.globaltheme.b.e locale = this.n.a(paramString);
    if ((locale != null) && (locale.C()) && (this.d.e()))
    {
      this.d.a(this.c.getWidth(), this.c.getHeight());
      this.d.b(locale);
    }
    if ((!TextUtils.isEmpty(paramString)) && (this.f.b()))
    {
      this.f.a(this.e.getWidth(), this.e.getHeight());
      this.f.a(paramString);
    }
  }
  
  private void b(String paramString)
  {
    paramString = this.n.a(paramString);
    if ((paramString != null) && (paramString.C()) && (this.d.e())) {
      this.d.c(paramString);
    }
  }
  
  private void c(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.d.e()))
    {
      this.d.a(this.c.getWidth(), this.c.getHeight());
      this.d.b(paramString);
    }
  }
  
  public void a()
  {
    if (this.n != null) {
      this.n.a();
    }
    if (this.m != null) {
      this.m.c();
    }
    if (this.r != null) {
      this.a.unregisterReceiver(this.r);
    }
    if (this.s != null) {
      this.a.unregisterReceiver(this.s);
    }
    if (this.d != null) {
      this.d.a();
    }
    if (this.f != null) {
      this.f.c();
    }
    if ((this.q != null) && (this.q != this.p))
    {
      this.o.a(this.p);
      this.q = null;
    }
  }
  
  public void a(int paramInt, com.gau.go.launcherex.gowidget.weather.globaltheme.b.e parame) {}
  
  public void a(Activity paramActivity)
  {
    this.d.a(paramActivity);
    this.o.a(39, this);
    this.n.a(2);
    this.m.a();
  }
  
  public void a(ImageView paramImageView)
  {
    this.d.a(paramImageView);
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
      this.b.setVisibility(0);
      return;
      this.h = paramg.b();
      if (this.g)
      {
        this.d.a(this.c.getWidth(), this.c.getHeight());
        this.d.a(this.h);
        requestLayout();
      }
    }
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
      this.l = new ArrayList();
      int i2 = localSparseArray.size();
      int i1 = 0;
      while (i1 < i2)
      {
        this.l.add(localSparseArray.valueAt(i1));
        i1 += 1;
      }
      this.d.b(this.l);
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
        this.i = localArrayList;
        if (this.g)
        {
          this.f.a(this.e.getWidth(), this.e.getHeight());
          this.f.d(this.i);
          requestLayout();
        }
        return;
      }
      locala = locale.f();
    } while (com.gau.go.launcherex.gowidget.weather.globaltheme.a.j(locala.c(), this.a));
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
      locald.b(2);
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
  
  public void b()
  {
    if (this.d.e()) {
      this.d.b();
    }
  }
  
  public void b(ArrayList paramArrayList) {}
  
  public void c()
  {
    if (this.d.e()) {
      this.d.c();
    }
  }
  
  public void c(ArrayList paramArrayList) {}
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = ((LinearLayout)findViewById(2131231674));
    this.d = new f(this.a);
    this.d.a(this.n);
    this.c = ((LinearLayout)findViewById(2131231675));
    this.c.addView(this.d.d());
    this.f = new a(this.a);
    this.e = ((LinearLayout)findViewById(2131231676));
    this.e.addView(this.f.a());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.g = true;
    if ((!this.d.e()) && (this.h != null))
    {
      this.d.a(this.c.getWidth(), this.c.getHeight());
      this.d.a(this.h);
    }
    if ((!this.f.b()) && (this.i != null))
    {
      this.f.a(this.e.getWidth(), this.e.getHeight());
      this.f.d(this.i);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = (int)(getResources().getDisplayMetrics().density * 265.0F);
    paramInt1 = Math.max(getMeasuredHeight(), paramInt1);
    this.b.measure(View.MeasureSpec.makeMeasureSpec(this.b.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/gowidget/configure/ThemeConfigureView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */