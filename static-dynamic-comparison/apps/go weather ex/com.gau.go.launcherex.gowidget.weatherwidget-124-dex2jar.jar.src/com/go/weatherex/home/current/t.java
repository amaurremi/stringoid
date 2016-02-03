package com.go.weatherex.home.current;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.scroller.WeatherDetailScrollGroup;
import com.gau.go.launcherex.gowidget.weather.scroller.h;
import com.gau.go.launcherex.gowidget.weather.scroller.l;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.gau.go.launcherex.gowidget.weather.view.MapDetailActivity;
import com.go.weatherex.weatheralert.WeatherAlertActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class t
  extends com.go.weatherex.framework.fragment.a
  implements AbsListView.OnScrollListener, l
{
  private LayoutInflater a;
  private WeatherDetailScrollGroup b;
  private int c = 0;
  private String d = "";
  private f e;
  private final v f = new v(this, null);
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private AccelerateDecelerateInterpolator j = new AccelerateDecelerateInterpolator();
  private int k;
  private int l;
  
  public static Bundle a(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("cityId", paramString);
    localBundle.putInt("detail_goto", paramInt);
    return localBundle;
  }
  
  private void a(int paramInt)
  {
    if ((this.b != null) && (this.b.getChildCount() != 0) && (paramInt < this.b.getChildCount())) {
      ((CurrentWeatherContent)this.b.getChildAt(paramInt)).i();
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int n = this.b.getChildCount();
    int m = 0;
    while (m < n)
    {
      ((CurrentWeatherContent)this.b.getChildAt(m)).setSelectionFromTop(paramInt1, paramInt2);
      m += 1;
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    case 6: 
    default: 
      return;
    case 1: 
    case 2: 
      c(paramString);
      return;
    case 3: 
      d(paramString);
      return;
    case 4: 
      a(paramString);
      return;
    case 5: 
      e(paramString);
      return;
    }
    f(paramString);
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    boolean bool2 = false;
    Object localObject;
    int m;
    if (!this.g)
    {
      localObject = this.e.d();
      m = this.b.getChildCount();
      if (m == ((ArrayList)localObject).size()) {
        break label39;
      }
    }
    for (;;)
    {
      return;
      label39:
      boolean bool1 = (paramInt - 1 + m) % m;
      boolean bool3 = b(bool1, ((WeatherBean)((ArrayList)localObject).get(bool1)).c());
      bool1 = (paramInt + 1) % m;
      bool1 = false | bool3 | b(bool1, ((WeatherBean)((ArrayList)localObject).get(bool1)).c());
      if ((paramBoolean) && (m > 3))
      {
        int n = (paramInt - 2 + m) % m;
        paramBoolean = b(n, ((WeatherBean)((ArrayList)localObject).get(n)).c());
        paramInt = (paramInt + 2) % m;
      }
      for (paramInt = b(paramInt, ((WeatherBean)((ArrayList)localObject).get(paramInt)).c()) | bool1 | paramBoolean; paramInt != 0; paramInt = bool1)
      {
        paramInt = 0;
        if (paramInt < this.b.getChildCount())
        {
          localObject = (CurrentWeatherContent)this.b.getChildAt(paramInt);
          if ((localObject == null) || (((CurrentWeatherContent)localObject).g())) {}
        }
        for (paramBoolean = bool2;; paramBoolean = true)
        {
          this.g = paramBoolean;
          return;
          paramInt += 1;
          break;
        }
      }
    }
  }
  
  private void b()
  {
    int n = this.b.getChildCount();
    int m = 0;
    while (m < n)
    {
      ((CurrentWeatherContent)this.b.getChildAt(m)).f();
      m += 1;
    }
  }
  
  private boolean b(int paramInt, String paramString)
  {
    paramString = (CurrentWeatherContent)this.b.getChildAt(paramInt);
    if ((paramString != null) && (!paramString.g()))
    {
      paramString.a();
      paramString.setSelectionFromTop(this.k, this.l);
      return true;
    }
    return false;
  }
  
  private void c()
  {
    int m = 0;
    ArrayList localArrayList = this.e.d();
    int n = localArrayList.size();
    boolean bool;
    label29:
    CurrentWeatherContent localCurrentWeatherContent;
    if (n < 4)
    {
      bool = true;
      this.g = bool;
      if (m >= n) {
        break label131;
      }
      String str = ((WeatherBean)localArrayList.get(m)).c();
      localCurrentWeatherContent = d();
      localCurrentWeatherContent.a(str);
      localCurrentWeatherContent.a(this);
      if (!str.equals(this.d)) {
        break label116;
      }
      this.c = m;
      localCurrentWeatherContent.a();
      localCurrentWeatherContent.setOnScrollListener(this);
    }
    for (;;)
    {
      this.b.addView(localCurrentWeatherContent);
      m += 1;
      break label29;
      bool = false;
      break;
      label116:
      if (this.g) {
        localCurrentWeatherContent.a();
      }
    }
    label131:
    this.b.a();
    this.b.getScreenScroller().i(this.c);
    a(true, this.c);
  }
  
  private CurrentWeatherContent d()
  {
    return (CurrentWeatherContent)this.a.inflate(2130903091, null, false);
  }
  
  private void g(String paramString)
  {
    com.gau.go.launcherex.gowidget.statistics.r.a(getActivity().getApplicationContext()).a(new com.gau.go.launcherex.gowidget.statistics.a.a(93, paramString));
  }
  
  private boolean h(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int m = 0;
    label11:
    CurrentWeatherContent localCurrentWeatherContent;
    if (m < this.b.getChildCount())
    {
      localCurrentWeatherContent = (CurrentWeatherContent)this.b.getChildAt(m);
      if (localCurrentWeatherContent != null) {
        break label45;
      }
    }
    label45:
    while (!paramString.equals(localCurrentWeatherContent.c()))
    {
      m += 1;
      break label11;
      break;
    }
    return true;
  }
  
  private void i(String paramString)
  {
    int m;
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.d)))
    {
      this.d = paramString;
      m = 0;
    }
    for (;;)
    {
      if (m < this.b.getChildCount())
      {
        CurrentWeatherContent localCurrentWeatherContent = (CurrentWeatherContent)this.b.getChildAt(m);
        if ((localCurrentWeatherContent != null) && (paramString.equals(localCurrentWeatherContent.c()))) {
          this.b.a(m);
        }
      }
      else
      {
        return;
      }
      m += 1;
    }
  }
  
  private void j()
  {
    int n = this.b.getChildCount();
    int m = 0;
    while (m < n)
    {
      ((CurrentWeatherContent)this.b.getChildAt(m)).d();
      m += 1;
    }
  }
  
  private void k()
  {
    int n = this.b.getChildCount();
    int m = 0;
    while (m < n)
    {
      ((CurrentWeatherContent)this.b.getChildAt(m)).e();
      m += 1;
    }
  }
  
  private void l()
  {
    if (!this.h) {
      a(this.c);
    }
  }
  
  private boolean m()
  {
    return GoWidgetApplication.c(getActivity()).a().getBoolean("key_home_screen_slide_tips", false);
  }
  
  private void n()
  {
    if (this.h) {
      return;
    }
    GoWidgetApplication.c(getActivity()).a().edit().putBoolean("key_home_screen_slide_tips", true).commit();
  }
  
  private void o()
  {
    int m = 0;
    while (m < this.b.getChildCount())
    {
      CurrentWeatherContent localCurrentWeatherContent = (CurrentWeatherContent)this.b.getChildAt(m);
      if (localCurrentWeatherContent != null) {
        localCurrentWeatherContent.b();
      }
      m += 1;
    }
  }
  
  private void p()
  {
    int n = this.b.getChildCount();
    int m = 0;
    while (m < n)
    {
      ((CurrentWeatherContent)this.b.getChildAt(m)).setOnScrollListener(null);
      m += 1;
    }
  }
  
  private void q()
  {
    ((CurrentWeatherContent)this.b.getChildAt(this.c)).setOnScrollListener(this);
  }
  
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    int m;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("cityId");
      if ((!TextUtils.isEmpty(paramBundle)) && (!paramBundle.equals(this.d)))
      {
        this.d = paramBundle;
        m = 0;
      }
    }
    for (;;)
    {
      if (m < this.b.getChildCount())
      {
        CurrentWeatherContent localCurrentWeatherContent = (CurrentWeatherContent)this.b.getChildAt(m);
        if ((localCurrentWeatherContent != null) && (localCurrentWeatherContent.c().equals(paramBundle))) {
          this.b.a(m);
        }
      }
      else
      {
        return;
        paramBundle = "";
        break;
      }
      m += 1;
    }
  }
  
  public void a(WeatherDetailScrollGroup paramWeatherDetailScrollGroup, int paramInt) {}
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("cityId", paramString);
    a(com.go.weatherex.home.windforecast.c.class, localBundle);
    g("c000_wind");
  }
  
  protected void b(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    i(String.valueOf(paramObject));
  }
  
  public void b(WeatherDetailScrollGroup paramWeatherDetailScrollGroup, int paramInt)
  {
    if (paramInt < paramWeatherDetailScrollGroup.getChildCount())
    {
      paramWeatherDetailScrollGroup = (CurrentWeatherContent)paramWeatherDetailScrollGroup.getChildAt(paramInt);
      if (paramWeatherDetailScrollGroup == null) {
        break label75;
      }
    }
    label75:
    for (paramWeatherDetailScrollGroup = paramWeatherDetailScrollGroup.c();; paramWeatherDetailScrollGroup = null)
    {
      if ((!TextUtils.isEmpty(paramWeatherDetailScrollGroup)) && (!paramWeatherDetailScrollGroup.equals(this.d)))
      {
        this.d = paramWeatherDetailScrollGroup;
        if (!isHidden()) {
          a(10, paramWeatherDetailScrollGroup);
        }
      }
      a(false, paramInt);
      return;
      paramWeatherDetailScrollGroup = null;
      break;
    }
  }
  
  public void b(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("cityId", paramString);
    a(com.go.weatherex.home.hourforecast.c.class, localBundle);
    g("24_hour_weather");
  }
  
  public void c(WeatherDetailScrollGroup paramWeatherDetailScrollGroup, int paramInt)
  {
    int m = paramWeatherDetailScrollGroup.getChildCount();
    if ((paramInt == this.c) || (!com.gau.go.launcherex.gowidget.weather.util.r.c(paramInt, 0, m - 1))) {}
    do
    {
      return;
      this.c = paramInt;
      p();
      q();
    } while ((TextUtils.isEmpty(this.d)) || (isHidden()));
    a(12, this.d, 10L, true);
  }
  
  public void c(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("cityId", paramString);
    a(com.go.weatherex.home.dayforecast.g.class, localBundle);
    g("c000_moeweather");
  }
  
  public void d(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("cityId", paramString);
    a(com.go.weatherex.home.rain.g.class, localBundle);
    g("c000_rain");
  }
  
  public void e(String paramString)
  {
    boolean bool2 = true;
    if (!GoWidgetApplication.a) {
      Toast.makeText(getActivity(), 2131165995, 0).show();
    }
    do
    {
      return;
      localObject1 = this.e.d();
      localNowBean = null;
      localObject2 = ((ArrayList)localObject1).iterator();
      do
      {
        localObject1 = localNowBean;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (WeatherBean)((Iterator)localObject2).next();
      } while (!((WeatherBean)localObject1).c().equals(paramString));
    } while (localObject1 == null);
    paramString = new Bundle();
    paramString.putString("cityId", ((WeatherBean)localObject1).c());
    NowBean localNowBean = ((WeatherBean)localObject1).k;
    Object localObject2 = new Intent(getActivity(), MapDetailActivity.class);
    Object localObject1 = ((WeatherBean)localObject1).d();
    double d1 = localNowBean.w();
    double d2 = localNowBean.v();
    boolean bool1;
    if (localNowBean.x() == 1)
    {
      bool1 = true;
      if (localNowBean.y() != 1) {
        break label212;
      }
    }
    for (;;)
    {
      MapDetailActivity.a((Intent)localObject2, (String)localObject1, d1, d2, bool1, bool2);
      ((Intent)localObject2).putExtras(paramString);
      startActivity((Intent)localObject2);
      g("c000_radio");
      return;
      bool1 = false;
      break;
      label212:
      bool2 = false;
    }
  }
  
  protected void f()
  {
    super.f();
    int m = 0;
    while (m < this.b.getChildCount())
    {
      CurrentWeatherContent localCurrentWeatherContent = (CurrentWeatherContent)this.b.getChildAt(m);
      if (localCurrentWeatherContent != null) {
        localCurrentWeatherContent.k();
      }
      m += 1;
    }
  }
  
  public void f(String paramString)
  {
    Intent localIntent = new Intent(getActivity(), WeatherAlertActivity.class);
    localIntent.putExtra("cityId", paramString);
    startActivityForResult(localIntent, 0);
    getActivity().overridePendingTransition(2130968584, 2130968606);
  }
  
  @SuppressLint({"NewApi"})
  public void onActivityCreated(Bundle paramBundle)
  {
    int m = -1;
    super.onActivityCreated(paramBundle);
    paramBundle = getArguments();
    this.e = f.a(getActivity().getApplicationContext());
    this.b = ((WeatherDetailScrollGroup)c(2131231345));
    this.b.a(true);
    this.b.a(this);
    if (paramBundle != null)
    {
      this.d = paramBundle.getString("cityId");
      m = paramBundle.getInt("detail_goto", -1);
    }
    if ((TextUtils.isEmpty(this.d)) && (!this.e.c().isEmpty())) {
      this.d = ((WeatherBean)this.e.d().get(0)).c();
    }
    c();
    a(m, this.d);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(new int[] { 10, 3 });
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903140, paramViewGroup, false);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    b(this.f);
    b();
  }
  
  public void onPause()
  {
    super.onPause();
    j();
  }
  
  public void onResume()
  {
    super.onResume();
    k();
    if (!this.h)
    {
      this.h = m();
      if (this.e.e() != 0)
      {
        this.i = true;
        l();
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    float f1 = 0.0F;
    if (paramInt1 == 0)
    {
      paramAbsListView = paramAbsListView.getChildAt(0);
      if (paramAbsListView != null)
      {
        paramInt1 = paramAbsListView.getMeasuredHeight();
        f1 = com.gau.go.launcherex.gowidget.weather.util.r.a(-paramAbsListView.getTop() * 1.6F / paramInt1, 0.0F, 1.0F);
      }
    }
    for (f1 = this.j.getInterpolation(f1);; f1 = 1.0F)
    {
      a(9, Float.valueOf(f1));
      return;
      n();
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.k = paramAbsListView.getFirstVisiblePosition();
      this.l = paramAbsListView.getChildAt(0).getTop();
      a(this.k, this.l);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.a = getActivity().getLayoutInflater();
    a(this.f);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/current/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */