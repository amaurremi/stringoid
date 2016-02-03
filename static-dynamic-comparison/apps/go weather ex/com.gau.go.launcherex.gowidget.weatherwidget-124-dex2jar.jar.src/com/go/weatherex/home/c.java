package com.go.weatherex.home;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.gau.go.launcherex.goweather.ad.InlandAdView;
import com.gau.go.launcherex.gowidget.billing.BillingActivity;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.view.ThemeSettingActivity;
import com.go.weatherex.home.current.t;
import com.go.weatherex.home.refresh.PullRefreshLayout;
import com.go.weatherex.viewex.AlphaChangeFrameLayout;
import com.go.weatherex.viewex.CityNameSwitcher;
import com.go.weatherex.viewex.FrameImageView;
import java.util.ArrayList;

public class c
  extends com.go.weatherex.framework.fragment.a
  implements View.OnClickListener, com.go.weatherex.city.d, com.go.weatherex.home.refresh.k
{
  private LinearLayout a;
  private com.go.weatherex.home.b.a b = new com.go.weatherex.home.b.a(0);
  private SidebarIcon c;
  private boolean d;
  private int[] e = { 2130838206, 2130838211, 2130838212, 2130838213, 2130838214, 2130838215, 2130838216, 2130838217, 2130838218, 2130838207, 2130838208, 2130838209, 2130838210 };
  private FrameImageView f;
  private CityNameSwitcher g;
  private boolean h = false;
  private PullRefreshLayout i;
  private FrameLayout j;
  private k k = new k(this, null);
  private com.gau.go.launcherex.gowidget.weather.d.f l;
  private com.gau.go.launcherex.gowidget.weather.util.f m;
  private com.gau.go.launcherex.gowidget.weather.c.g n;
  private String o = "";
  private SharedPreferences p;
  private AlphaChangeFrameLayout q;
  private TextView r;
  private TextView s;
  private com.go.weatherex.city.c t = com.go.weatherex.city.c.a();
  private InlandAdView u;
  private boolean v;
  private final View.OnClickListener w = new d(this);
  private final View.OnClickListener x = new e(this);
  
  public static Bundle a(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("cityId", paramString);
    localBundle.putInt("detail_goto", paramInt);
    return localBundle;
  }
  
  private void a(String paramString)
  {
    paramString = new com.gau.go.launcherex.gowidget.statistics.a.a(93, paramString);
    paramString.d("1");
    com.gau.go.launcherex.gowidget.statistics.r.a(getActivity().getApplicationContext()).a(paramString);
  }
  
  private boolean a(int paramInt)
  {
    return (this.l.b()) || (b(paramInt));
  }
  
  private boolean b(int paramInt)
  {
    Time localTime = new Time();
    localTime.setToNow();
    return localTime.gmtoff * 1000L == paramInt;
  }
  
  private void d(int paramInt)
  {
    Intent localIntent = new Intent(getActivity(), BillingActivity.class);
    localIntent.putExtra("recommend_type", paramInt);
    localIntent.putExtra("recommend_enterance", 4);
    getActivity().startActivity(localIntent);
  }
  
  private void e(int paramInt)
  {
    Intent localIntent = ThemeSettingActivity.a(getActivity(), paramInt, 40, 40, this.o);
    localIntent.addFlags(67108864);
    getActivity().startActivity(localIntent);
  }
  
  private void f(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  private void j()
  {
    boolean bool1 = true;
    com.gau.go.launcherex.gowidget.statistics.a locala = com.gau.go.launcherex.gowidget.statistics.a.a(getActivity().getApplicationContext());
    int i1 = this.p.getInt("key_ab_test_user", -1);
    if (i1 == 0) {}
    for (;;)
    {
      boolean bool2 = this.l.b();
      if ((bool1) && (!bool2)) {
        break;
      }
      this.j.setVisibility(8);
      return;
      if (i1 == 1) {
        bool1 = locala.c();
      }
    }
    this.j.setVisibility(0);
    if (locala.b()) {
      locala.d();
    }
    com.go.weatherex.b.a.g.a(getActivity().getApplicationContext()).a(getActivity(), this.j);
  }
  
  private void k()
  {
    if ((this.p.getBoolean("key_ad_world_clock", false)) || (this.l.b()))
    {
      l();
      return;
    }
    a(true);
  }
  
  private void l()
  {
    if (this.s.getVisibility() == 0)
    {
      this.s.setText(2131166112);
      return;
    }
    Object localObject;
    if (!TextUtils.isEmpty(this.o))
    {
      localObject = this.m.a(this.o);
      if (localObject == null) {}
    }
    for (int i1 = ((WeatherBean)localObject).k.n();; i1 = 55536)
    {
      if ((this.n.d()) && (i1 != 55536))
      {
        if (a(i1))
        {
          localObject = this.n.b(i1);
          localObject = this.n.b((Time)localObject);
          this.r.setText((CharSequence)localObject);
          this.r.setEnabled(false);
        }
        for (;;)
        {
          this.r.setVisibility(0);
          return;
          this.r.setText("Local Time");
          this.r.setEnabled(true);
        }
      }
      this.r.setVisibility(8);
      return;
    }
  }
  
  private void m()
  {
    int i2 = 1;
    int i1 = i2;
    if (!this.l.a(2))
    {
      i1 = i2;
      if (!this.l.a(1)) {
        if (!this.l.a(32)) {
          break label78;
        }
      }
    }
    label78:
    for (i1 = i2;; i1 = 0)
    {
      boolean bool1 = y.p(getActivity());
      boolean bool2 = y.h(getActivity());
      if ((i1 == 0) && (bool1) && (!bool2)) {
        n();
      }
      return;
    }
  }
  
  private boolean n()
  {
    boolean bool = true;
    if (this.p.getInt("key_inland_ad_show_count", 0) >= 3)
    {
      long l1 = this.p.getLong("key_inland_ad_show", 0L);
      if ((System.currentTimeMillis() - l1 < 14400000L) || (!o())) {
        break label109;
      }
      new j(this, null).execute(new Void[0]);
    }
    for (;;)
    {
      if (!bool) {
        this.u.a();
      }
      return bool;
      if (o()) {
        new j(this, null).execute(new Void[0]);
      } else {
        label109:
        bool = false;
      }
    }
  }
  
  private boolean o()
  {
    Cursor localCursor = getActivity().getContentResolver().query(WeatherContentProvider.s, new String[] { "ad_id" }, null, null, null);
    if ((localCursor != null) && (localCursor.getCount() != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (localCursor != null) {}
      try
      {
        localCursor.close();
        return bool;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return bool;
  }
  
  public void a(String paramString1, String paramString2)
  {
    WeatherBean localWeatherBean = this.m.a(paramString2);
    if ((localWeatherBean != null) && (this.g != null))
    {
      if (TextUtils.isEmpty(paramString1)) {
        this.g.b(localWeatherBean.d(), this.m.g(paramString2));
      }
    }
    else {
      return;
    }
    this.g.a(localWeatherBean.d(), this.m.g(paramString2));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.s.setVisibility(0);
      return;
    }
    this.s.setVisibility(8);
    this.r.postDelayed(new h(this), 1500L);
  }
  
  public String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    WeatherBean localWeatherBean;
    if (this.m.e() != 0)
    {
      localWeatherBean = this.m.a(this.o);
      if (localWeatherBean == null) {}
    }
    for (long l1 = localWeatherBean.k.f();; l1 = -1L)
    {
      localStringBuffer.append(getString(2131165966)).append(" : ");
      if ((l1 != -1L) && (com.gau.go.launcherex.gowidget.weather.util.r.b((float)l1))) {
        localStringBuffer.append(com.gau.go.launcherex.gowidget.weather.util.r.a(getActivity(), l1));
      }
      for (;;)
      {
        return localStringBuffer.toString();
        localStringBuffer.append("N/A");
      }
    }
  }
  
  protected void b(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        float f1;
        do
        {
          return;
          f1 = ((Float)paramObject).floatValue();
          f(Color.argb((int)(f1 * 76.8D), 0, 0, 0));
          paramInt = Math.min(255, Math.max(0, (int)(255.0F * (1.0F - f1))));
          if (this.n.d()) {
            this.q.a(paramInt);
          }
        } while ((this.v) || (f1 != 1.0F));
        this.v = true;
        a("up_detail");
        return;
        paramObject = String.valueOf(paramObject);
      } while (TextUtils.isEmpty((CharSequence)paramObject));
      this.o = ((String)paramObject);
      this.t.b(this.o);
      l();
      return;
      if (((Boolean)paramObject).booleanValue())
      {
        this.i.setEnabled(false);
        this.q.setVisibility(8);
        return;
      }
      this.i.setEnabled(true);
      this.q.setVisibility(0);
      return;
      if (((Boolean)paramObject).booleanValue())
      {
        a(15, Boolean.valueOf(false));
        this.c.setOnClickListener(this.w);
        this.c.c();
        return;
      }
      a(15, Boolean.valueOf(true));
      this.c.setOnClickListener(this.x);
      this.c.b();
      return;
      paramObject = (String)paramObject;
      if (com.go.weatherex.home.hourforecast.c.class.getName().equals(paramObject))
      {
        this.g.a(getText(2131165957), false);
        this.h = true;
        return;
      }
      if (com.go.weatherex.home.dayforecast.g.class.getName().equals(paramObject))
      {
        this.g.a(getText(2131165958), false);
        this.h = true;
        return;
      }
      if (com.go.weatherex.home.rain.g.class.getName().equals(paramObject))
      {
        this.g.a(getText(2131165960), false);
        this.h = true;
        return;
      }
      if (com.go.weatherex.home.windforecast.c.class.getName().equals(paramObject))
      {
        this.g.a(getText(2131165959), false);
        this.h = true;
        return;
      }
    } while (!t.class.getName().equals(paramObject));
    if (this.h) {
      this.g.showPrevious();
    }
    this.h = false;
  }
  
  public void c()
  {
    this.m.i();
  }
  
  public void d()
  {
    this.i.a(b());
  }
  
  protected void f()
  {
    super.f();
    l();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    int i1 = -1;
    super.onActivityCreated(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.o = paramBundle.getString("cityId");
      i1 = paramBundle.getInt("detail_goto", -1);
    }
    a(t.class, t.a(this.o, i1));
    Object localObject2 = this.m.d();
    if (((ArrayList)localObject2).isEmpty())
    {
      a(com.go.weatherex.f.i.class, null);
      k();
      return;
    }
    if (!TextUtils.isEmpty(this.o)) {}
    for (paramBundle = this.m.a(this.o);; paramBundle = null)
    {
      Object localObject1 = paramBundle;
      if (paramBundle == null)
      {
        localObject1 = (WeatherBean)((ArrayList)localObject2).get(0);
        this.o = ((WeatherBean)localObject1).c();
      }
      this.t.a(this.o);
      paramBundle = this.g;
      localObject2 = ((WeatherBean)localObject1).d();
      if (((WeatherBean)localObject1).e() != 1) {}
      for (boolean bool = true;; bool = false)
      {
        paramBundle.b((CharSequence)localObject2, bool);
        break;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.f))
    {
      a("c000_shop");
      e(1);
      if (this.d)
      {
        this.d = false;
        this.f.b();
        com.gau.go.launcherex.gowidget.weather.globaltheme.a.d.a(getActivity(), false);
      }
    }
    do
    {
      do
      {
        return;
      } while (this.q.a() < 20);
      a("c000_clock");
      if (paramView.equals(this.s))
      {
        d(3);
        paramView = this.p.edit();
        paramView.putBoolean("key_ad_world_clock", true);
        paramView.commit();
        this.s.setVisibility(8);
        this.s.postDelayed(new i(this), 1000L);
        return;
      }
    } while ((!paramView.equals(this.r)) || (this.l.b()));
    d(3);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(new int[] { 9, 10, 16, 11, 13, 17, 18 });
    paramBundle = com.gau.go.launcherex.gowidget.weather.c.c.a(getActivity().getApplicationContext());
    this.m = paramBundle.h();
    this.l = paramBundle.e();
    this.n = paramBundle.g();
    this.p = GoWidgetApplication.c(getActivity().getApplicationContext()).a();
    com.go.weatherex.b.a.g.a = false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903166, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    if (this.j.getVisibility() == 0) {
      com.go.weatherex.b.a.g.a(getActivity().getApplicationContext()).a(this.j);
    }
    this.t.b(this);
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    b(this.k);
  }
  
  public void onPause()
  {
    if (this.j.getVisibility() == 0) {
      com.go.weatherex.b.a.g.a(getActivity().getApplicationContext()).a();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.j.getVisibility() == 0) {
      com.go.weatherex.b.a.g.a(getActivity().getApplicationContext()).b();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView.setBackgroundDrawable(this.b);
    this.a = ((LinearLayout)c(2131230797));
    a(this.a, 4, 0);
    this.c = ((SidebarIcon)c(2131231207));
    this.c.setOnClickListener(this.w);
    this.f = ((FrameImageView)c(2131231209));
    this.f.setOnClickListener(this);
    this.f.a(3);
    this.f.a(this.e);
    this.d = this.p.getBoolean("new_theme", false);
    if (this.d) {
      this.f.a();
    }
    this.g = ((CityNameSwitcher)c(2131231208));
    this.g.setFactory(new f(this));
    paramView = AnimationUtils.loadAnimation(getActivity(), 17432576);
    paramView.setStartOffset(200L);
    paramView.setAnimationListener(new g(this));
    this.g.setInAnimation(paramView);
    this.g.setOutAnimation(getActivity(), 17432577);
    this.t.a(this);
    this.q = ((AlphaChangeFrameLayout)c(2131231552));
    this.s = ((TextView)c(2131231553));
    this.s.setOnClickListener(this);
    a(this.s, 4, 0);
    this.r = ((TextView)c(2131231554));
    this.r.setOnClickListener(this);
    a(this.r, 4, 0);
    this.i = ((PullRefreshLayout)c(2131231550));
    this.i.a(this);
    this.u = ((InlandAdView)c(2131231555));
    m();
    this.j = ((FrameLayout)c(2131231556));
    j();
    a(this.k);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */