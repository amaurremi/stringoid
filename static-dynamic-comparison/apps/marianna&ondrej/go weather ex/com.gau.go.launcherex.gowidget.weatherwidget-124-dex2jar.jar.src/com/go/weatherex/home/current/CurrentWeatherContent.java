package com.go.weatherex.home.current;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.a.a.an;
import com.a.a.d;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.gau.go.launcherex.gowidget.weather.util.w;
import java.util.List;

public class CurrentWeatherContent
  extends ListView
  implements AdapterView.OnItemClickListener
{
  private t a;
  private Activity b;
  private CityWeatherInfoBase c;
  private com.go.weatherex.home.current.a.a d;
  private f e;
  private String f = "";
  private Context g;
  private boolean h = false;
  
  public CurrentWeatherContent(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
    setOnItemClickListener(this);
  }
  
  private void a(Context paramContext)
  {
    this.g = paramContext;
    this.e = f.a(paramContext);
  }
  
  private void m()
  {
    int i = getResources().getDimensionPixelSize(2131427798);
    this.c = y.a(this.b);
    int[] arrayOfInt = new int[2];
    com.gau.go.launcherex.gowidget.d.g.a(getContext(), arrayOfInt);
    this.c.setLayoutParams(new AbsListView.LayoutParams(-1, arrayOfInt[1] - i));
    this.c.a(this.a);
    this.c.c().setOnClickListener(new p(this));
    addHeaderView(this.c);
  }
  
  public void a()
  {
    this.h = true;
    if (!TextUtils.isEmpty(this.f))
    {
      this.c.a(this.a);
      WeatherBean localWeatherBean = this.e.a(this.f);
      this.c.b(localWeatherBean);
      this.c.a();
      this.d = new com.go.weatherex.home.current.a.a(this.a, this.f);
      setAdapter(this.d);
      this.d.notifyDataSetChanged();
    }
  }
  
  public void a(w paramw)
  {
    if (paramw.e != null)
    {
      int i = paramw.e.indexOf(this.f);
      if (i != -1)
      {
        i = ((Integer)paramw.f.get(i)).intValue();
        this.c.a(i);
      }
    }
  }
  
  public void a(t paramt)
  {
    this.a = paramt;
    this.b = this.a.getActivity();
    m();
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public void b()
  {
    this.c.a();
  }
  
  public String c()
  {
    return this.f;
  }
  
  public void d()
  {
    if (this.d != null) {
      this.d.a();
    }
  }
  
  public void e()
  {
    if (this.d != null) {
      this.d.b();
    }
  }
  
  public void f()
  {
    setOnScrollListener(null);
    if (this.d != null) {
      this.d.c();
    }
  }
  
  public boolean g()
  {
    return this.h;
  }
  
  public com.go.weatherex.home.current.a.a h()
  {
    return this.d;
  }
  
  public void i()
  {
    post(new q(this));
  }
  
  public void j()
  {
    d locald = new d();
    int i = com.gtp.a.a.d.a.a(this.g, 50.0F);
    an localan1 = new an();
    localan1.a(new int[] { 0, i });
    localan1.a(new r(this));
    localan1.c(300L);
    localan1.e(500L);
    localan1.a(new AccelerateDecelerateInterpolator());
    an localan2 = new an();
    localan2.a(new int[] { i, 0 });
    localan2.c(800L);
    localan2.a(new BounceInterpolator());
    localan2.a(new s(this));
    locald.a(localan1).b(localan2);
    locald.a();
  }
  
  public void k()
  {
    a();
    if (this.d != null) {
      this.d.g();
    }
  }
  
  protected void l()
  {
    Object localObject = GoWidgetApplication.c(this.b.getApplicationContext()).a();
    if (!((SharedPreferences)localObject).getBoolean("key_brief_card_tap_for_more", false))
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("key_brief_card_tap_for_more", true);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  protected void onFinishInflate()
  {
    setFadingEdgeLength(0);
    setCacheColorHint(0);
    setVerticalFadingEdgeEnabled(false);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == 0) {
      return;
    }
    switch (this.d.a(paramInt - 1).intValue())
    {
    case 3: 
    case 6: 
    default: 
      return;
    case 1: 
      this.a.b(this.f);
      l();
      return;
    case 2: 
      this.a.c(this.f);
      l();
      return;
    case 4: 
      this.a.a(this.f);
      l();
      return;
    }
    this.a.d(this.f);
    l();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AbsListView.LayoutParams localLayoutParams;
    if ((paramBoolean) && (this.c != null))
    {
      localLayoutParams = (AbsListView.LayoutParams)this.c.getLayoutParams();
      if (localLayoutParams != null) {
        break label60;
      }
      new AbsListView.LayoutParams(-1, paramInt4 - paramInt2);
    }
    for (;;)
    {
      this.c.requestLayout();
      return;
      label60:
      localLayoutParams.height = (paramInt4 - paramInt2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/current/CurrentWeatherContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */