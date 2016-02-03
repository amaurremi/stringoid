package com.go.weatherex.home.current;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.a.a.s;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.util.w;
import com.go.weatherex.home.hourforecast.ForecastHourTrend;
import java.util.ArrayList;
import java.util.List;

public class d
  extends x
  implements SharedPreferences.OnSharedPreferenceChangeListener, View.OnClickListener
{
  private Context b;
  private View c;
  private ForecastHourTrend d;
  private TextView e;
  private String f;
  private TextView g;
  private View h;
  private Time i;
  private boolean j = false;
  private boolean k = false;
  
  public d(com.go.weatherex.framework.fragment.a parama, int paramInt)
  {
    super(parama, paramInt);
    this.b = parama.getActivity().getApplicationContext();
    this.c = parama.getActivity().getLayoutInflater().inflate(2130903081, null);
    this.d = ((ForecastHourTrend)this.c.findViewById(2131231124));
    this.e = ((TextView)this.c.findViewById(2131231145));
    this.a.a(this.e, 4, true);
    this.g = ((TextView)this.c.findViewById(2131231125));
    this.h = this.c.findViewById(2131231121);
    this.g.setOnClickListener(this);
    this.i = new Time();
    this.i.setToNow();
    if (GoWidgetApplication.c(this.b).a().getBoolean("key_brief_card_tap_for_more", false))
    {
      this.g.setVisibility(8);
      return;
    }
    this.g.setVisibility(0);
    GoWidgetApplication.c(this.b).a().registerOnSharedPreferenceChangeListener(this);
    this.k = true;
  }
  
  private void a(View paramView)
  {
    if (this.j) {
      return;
    }
    this.j = true;
    s locals = s.a(paramView, "alpha", new float[] { 1.0F, 0.0F });
    locals.a(1000L);
    com.a.a.d locald = new com.a.a.d();
    locald.a(new f(this, paramView));
    locald.a(locals);
    locald.a();
  }
  
  private boolean m()
  {
    Time localTime = new Time();
    localTime.setToNow();
    if ((this.i.year == localTime.year) && (this.i.month == localTime.month) && (this.i.monthDay == localTime.monthDay) && (this.i.hour == localTime.hour)) {
      return false;
    }
    this.i.setToNow();
    return true;
  }
  
  public void a()
  {
    super.a();
    if (!m()) {
      return;
    }
    a(this.f);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    a(this.f);
  }
  
  public void a(String paramString)
  {
    this.e.setText(this.b.getResources().getString(2131165957));
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      this.f = paramString;
      ArrayList localArrayList = com.go.weatherex.h.a.a(this.b, paramString);
      if ((localArrayList != null) && (!localArrayList.isEmpty()))
      {
        this.d.setVisibility(0);
        this.h.setVisibility(8);
        this.d.a(paramString, false, localArrayList);
      }
      while (this.g.getVisibility() == 0)
      {
        this.g.postDelayed(new e(this), 5000L);
        return;
        this.d.setVisibility(8);
        this.h.setVisibility(0);
      }
    }
  }
  
  public void a(List paramList, w paramw)
  {
    super.a(paramList, paramw);
    a(this.f);
  }
  
  public void b()
  {
    super.b();
    if (!m()) {
      return;
    }
    a(this.f);
  }
  
  public void c()
  {
    super.c();
    a(this.f);
  }
  
  public View f()
  {
    return this.c;
  }
  
  public void g() {}
  
  public void h()
  {
    this.e.setText(this.b.getResources().getString(2131165957));
  }
  
  public void i()
  {
    this.d.a();
    if (this.k) {
      GoWidgetApplication.c(this.b).a().unregisterOnSharedPreferenceChangeListener(this);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.g))
    {
      a(this.g);
      this.g.postDelayed(new g(this), 500L);
    }
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    if ((!paramString.equals("key_brief_card_tap_for_more")) || (this.g.getVisibility() != 0)) {
      return;
    }
    a(this.g);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/current/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */