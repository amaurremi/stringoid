package com.go.weatherex.city;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.statistics.r;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.go.weatherex.viewex.ExtendableButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EditCityScrollComponent
  extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener, b
{
  private com.gau.go.launcherex.gowidget.weather.util.f a;
  private com.go.weatherex.framework.fragment.a b;
  private HorizontalScrollView c;
  private CityLinearLayout d;
  private LinearLayout.LayoutParams e;
  private TextView f;
  private ExtendableButton g;
  private j h;
  private ScaleAnimation i;
  private boolean j;
  private String k = "1";
  
  public EditCityScrollComponent(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = c.a(paramContext).h();
    this.h = new e(this);
    this.i = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.i.setDuration(300L);
    this.i.setInterpolator(new AccelerateDecelerateInterpolator());
  }
  
  private void a(int paramInt)
  {
    Toast.makeText(getContext(), paramInt, 0).show();
  }
  
  private void a(int paramInt, a parama)
  {
    this.i.setAnimationListener(new g(this, parama));
    parama.startAnimation(this.i);
  }
  
  private void a(a parama, boolean paramBoolean)
  {
    int m = this.d.indexOfChild(parama);
    this.d.b(parama);
    if (paramBoolean) {
      this.h.b(m, parama);
    }
    this.j = false;
  }
  
  private a b(WeatherBean paramWeatherBean)
  {
    a locala = new a(getContext());
    locala.setOnLongClickListener(this);
    locala.a(paramWeatherBean);
    return locala;
  }
  
  private void b(a parama)
  {
    com.gau.go.launcherex.gowidget.weather.globalview.b localb = new com.gau.go.launcherex.gowidget.weather.globalview.b((Activity)getContext());
    localb.c(2131165779);
    localb.b(2131165760);
    localb.a(new i(this, parama));
    localb.b();
  }
  
  private void c(String paramString)
  {
    paramString = new com.gau.go.launcherex.gowidget.statistics.a.a(93, paramString);
    paramString.d(this.k);
    r.a(getContext().getApplicationContext()).a(paramString);
  }
  
  private LinearLayout.LayoutParams g()
  {
    Resources localResources = getResources();
    int m = Math.min(localResources.getDisplayMetrics().widthPixels, localResources.getDisplayMetrics().heightPixels);
    int n = localResources.getDimensionPixelOffset(2131427784);
    return new LinearLayout.LayoutParams((localResources.getDimensionPixelOffset(2131427786) + (m - n * 2)) / 3, -1);
  }
  
  private void h()
  {
    if (this.f != null) {
      this.b.a(this.f, 4, true);
    }
  }
  
  private boolean i()
  {
    return this.d.d() > 1;
  }
  
  public a a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = this.d.c().iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (paramString.equals(locala.a)) {
          return locala;
        }
      }
    }
    return null;
  }
  
  public void a()
  {
    this.f.setText(getResources().getString(2131165988));
  }
  
  public void a(View paramView)
  {
    if (!isEnabled()) {}
    Object localObject;
    long l;
    do
    {
      do
      {
        return;
        if (!(paramView instanceof a)) {
          break;
        }
      } while (this.j);
      paramView = (a)paramView;
      int m = this.d.indexOfChild(paramView);
      if (this.d.a())
      {
        if (i())
        {
          if (paramView.b())
          {
            b(paramView);
            return;
          }
          a(m, paramView);
          return;
        }
        a(2131165762);
        return;
      }
      this.h.a(m, paramView);
      return;
      localObject = paramView.getTag();
      l = SystemClock.elapsedRealtime();
      if (localObject == null) {
        break;
      }
    } while (l - ((Long)localObject).longValue() < 500L);
    paramView.setTag(Long.valueOf(l));
    for (;;)
    {
      c("c000_adcity");
      this.b.a(com.go.weatherex.f.i.class, null);
      return;
      paramView.setTag(Long.valueOf(l));
    }
  }
  
  public void a(WeatherBean paramWeatherBean)
  {
    paramWeatherBean = b(paramWeatherBean);
    this.d.a(paramWeatherBean);
    int m = this.d.d() + 1;
    if (m > 3)
    {
      int n = this.e.width;
      this.c.postDelayed(new f(this, n, m), 50L);
    }
  }
  
  public void a(a parama)
  {
    if (parama != null) {
      this.d.b(parama);
    }
  }
  
  public void a(j paramj)
  {
    this.h = paramj;
  }
  
  public void a(com.go.weatherex.framework.fragment.a parama)
  {
    this.b = parama;
    h();
  }
  
  public void a(List paramList)
  {
    if (!paramList.isEmpty())
    {
      paramList = a((String)paramList.get(0));
      if (paramList != null) {
        a(paramList, false);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.g.a();
    }
    for (;;)
    {
      this.d.a(paramBoolean);
      return;
      this.g.b();
    }
  }
  
  public void b(String paramString)
  {
    this.k = paramString;
  }
  
  public boolean b()
  {
    return this.d.a();
  }
  
  public void c()
  {
    Iterator localIterator = this.d.c().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      WeatherBean localWeatherBean = this.a.a(locala.a);
      if (localWeatherBean != null) {
        locala.a(localWeatherBean);
      }
    }
  }
  
  public void d()
  {
    this.d.b();
  }
  
  public a e()
  {
    Iterator localIterator = this.d.c().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.b()) {
        return locala;
      }
    }
    return null;
  }
  
  public void f()
  {
    if (this.d.a()) {
      a(false);
    }
    this.c.scrollTo(0, 0);
  }
  
  public void onClick(View paramView)
  {
    if (!isEnabled()) {}
    while (!paramView.equals(this.g)) {
      return;
    }
    if (!this.d.a())
    {
      a(true);
      return;
    }
    a(false);
  }
  
  protected void onFinishInflate()
  {
    this.c = ((HorizontalScrollView)findViewById(2131231198));
    this.d = ((CityLinearLayout)findViewById(2131231199));
    this.d.a(this);
    this.e = g();
    this.f = ((TextView)findViewById(2131230797));
    this.g = ((ExtendableButton)findViewById(2131231197));
    this.g.setOnClickListener(this);
  }
  
  public boolean onLongClick(View paramView)
  {
    if (!this.d.a()) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/city/EditCityScrollComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */