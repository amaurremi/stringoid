package com.go.weatherex.weatheralert;

import android.annotation.SuppressLint;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.d.h;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.go.weatherex.b.a.g;
import com.go.weatherex.framework.fragment.a;
import com.jiubang.a.a.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class i
  extends a
{
  private LayoutInflater a;
  private String b;
  private ArrayList c = new ArrayList();
  private q d;
  private View e;
  private TextView f;
  private ListView g;
  private e h;
  private l i;
  private TextView j;
  private o k;
  private FrameLayout l;
  private final h m = new h();
  
  @SuppressLint({"SimpleDateFormat"})
  private String a(String paramString)
  {
    Object localObject2 = new SimpleDateFormat("yyyy/MM/dd HH:mm Z");
    Object localObject1 = null;
    try
    {
      localObject2 = ((SimpleDateFormat)localObject2).parse(paramString);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int n;
        localException.printStackTrace();
        continue;
        ((StringBuffer)localObject1).append(n).append("/");
        continue;
        label268:
        ((StringBuffer)localObject1).append(n).append(" ");
        continue;
        label282:
        ((StringBuffer)localObject1).append(n).append(":");
        continue;
        label296:
        ((StringBuffer)localObject1).append(n);
      }
    }
    if (localObject1 != null)
    {
      localObject2 = f.a(getActivity().getApplicationContext()).a(this.b);
      if (localObject2 != null)
      {
        paramString = new Time();
        paramString.set(((Date)localObject1).getTime());
        paramString.set(paramString.toMillis(true) - (paramString.gmtoff * 1000L - ((WeatherBean)localObject2).k.n()));
        localObject1 = new StringBuffer();
        ((StringBuffer)localObject1).append(paramString.year).append("/");
        n = paramString.month + 1;
        if ((n >= 0) && (n <= 9))
        {
          ((StringBuffer)localObject1).append("0").append(n).append("/");
          n = paramString.monthDay;
          if ((n < 0) || (n > 9)) {
            break label268;
          }
          ((StringBuffer)localObject1).append("0").append(n).append(" ");
          n = paramString.hour;
          if ((n < 0) || (n > 9)) {
            break label282;
          }
          ((StringBuffer)localObject1).append("0").append(n).append(":");
          n = paramString.minute;
          if ((n < 0) || (n > 9)) {
            break label296;
          }
          ((StringBuffer)localObject1).append("0").append(n);
          return ((StringBuffer)localObject1).toString();
        }
      }
    }
    return b(paramString);
  }
  
  private String b(String paramString)
  {
    if (paramString != null)
    {
      int n = paramString.lastIndexOf(" ");
      if (n != -1) {
        return paramString.substring(0, n);
      }
    }
    return "";
  }
  
  private void c()
  {
    if (this.c.size() == 0)
    {
      d();
      return;
    }
    this.i.a(this.c);
    this.i.notifyDataSetChanged();
  }
  
  private void d()
  {
    h();
  }
  
  public void b()
  {
    c();
  }
  
  protected void f()
  {
    super.f();
    if (getActivity() != null)
    {
      WeatherBean localWeatherBean = f.a(getActivity().getApplicationContext()).a(this.b);
      if (localWeatherBean != null) {
        this.f.setText(String.format(getString(2131165791), new Object[] { localWeatherBean.d() }));
      }
      this.j.setText(getString(2131165792));
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getActivity().getWindow().clearFlags(134217728);
    this.a = getActivity().getLayoutInflater();
    this.m.a(800L);
    this.d = new q(this, null);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_UPDATE_EXTREME_WEATHER");
    paramBundle.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DELETE_EXPIRED_EXTREME_WEATHER");
    paramBundle.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CLEAR_EXTREME_WEATHER");
    getActivity().registerReceiver(this.d, paramBundle);
    this.f = ((TextView)c(2131231208));
    this.g = ((ListView)c(2131231544));
    this.i = new l(this);
    this.h = new e(this.i);
    this.h.a(this.g);
    this.g.setAdapter(this.h);
    this.j = ((TextView)c(2131231546));
    this.j.setOnClickListener(new j(this));
    this.e = c(2131231543);
    this.e.setOnClickListener(new k(this));
    paramBundle = getArguments();
    if (paramBundle != null) {
      this.b = paramBundle.getString("cityId");
    }
    paramBundle = f.a(getActivity().getApplicationContext()).a(this.b);
    if (paramBundle != null) {
      this.f.setText(String.format(getString(2131165791), new Object[] { paramBundle.d() }));
    }
    this.k = new o(this, getActivity().getContentResolver());
    if (!TextUtils.isEmpty(this.b))
    {
      this.k.a(this.b);
      this.l = ((FrameLayout)c(2131231545));
      g.a(getActivity().getApplicationContext()).a(getActivity(), this.l);
      return;
    }
    d();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903165, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    getActivity().unregisterReceiver(this.d);
    g.a(getActivity().getApplicationContext()).a(this.l);
    super.onDestroy();
  }
  
  public void onPause()
  {
    if (this.l.getVisibility() == 0) {
      g.a(getActivity().getApplicationContext()).a();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.l.getVisibility() == 0) {
      g.a(getActivity().getApplicationContext()).b();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    y.a("weather_warning_detail_show", getActivity().getApplicationContext());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/weatheralert/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */