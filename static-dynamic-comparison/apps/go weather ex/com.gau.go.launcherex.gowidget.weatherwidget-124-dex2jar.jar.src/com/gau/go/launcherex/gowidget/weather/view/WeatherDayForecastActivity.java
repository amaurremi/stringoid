package com.gau.go.launcherex.gowidget.weather.view;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;
import com.gau.go.launcherex.gowidget.language.b;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.model.ForecastBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.scroller.WeatherDetailScrollGroup;
import com.gau.go.launcherex.gowidget.weather.scroller.l;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.gau.go.launcherex.gowidget.weather.util.r;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class WeatherDayForecastActivity
  extends GoWeatherEXActivity
  implements l
{
  private TextView a = null;
  private View b;
  private View c;
  private f d = null;
  private e e;
  private LayoutInflater f = null;
  private Indicator g = null;
  private WeatherDetailScrollGroup h = null;
  private String i = null;
  private Notification j;
  private NotificationManager k;
  private int l = 1;
  private int m = 2;
  private int n = 2;
  
  private WeatherForecastView a(String paramString1, String paramString2, ForecastBean paramForecastBean)
  {
    Object localObject = null;
    String str2 = paramForecastBean.a();
    String str1 = paramForecastBean.b();
    WeatherForecastView localWeatherForecastView;
    if (!r.a(str2))
    {
      paramForecastBean = (ForecastBean)localObject;
      if (!r.a(str1)) {}
    }
    else
    {
      localWeatherForecastView = (WeatherForecastView)this.f.inflate(2130903351, null);
      localWeatherForecastView.c(paramString2);
      localWeatherForecastView.d(paramString1);
      if (this.m != 1) {
        break label150;
      }
      localObject = com.gau.go.launcherex.gowidget.weather.util.q.g(str2);
      paramForecastBean = com.gau.go.launcherex.gowidget.weather.util.q.g(str1);
      paramString1 = paramForecastBean;
      paramString2 = (String)localObject;
      switch (this.n)
      {
      default: 
        paramString2 = (String)localObject;
        paramString1 = paramForecastBean;
      }
    }
    for (;;)
    {
      localWeatherForecastView.a(paramString2);
      localWeatherForecastView.b(paramString1);
      paramForecastBean = localWeatherForecastView;
      return paramForecastBean;
      label150:
      paramForecastBean = str1;
      localObject = str2;
      if (this.m != 2) {
        break;
      }
      localObject = com.gau.go.launcherex.gowidget.weather.util.q.f(str2);
      paramForecastBean = com.gau.go.launcherex.gowidget.weather.util.q.f(str1);
      break;
      paramString2 = com.gau.go.launcherex.gowidget.weather.util.q.h((String)localObject);
      paramString1 = com.gau.go.launcherex.gowidget.weather.util.q.h(paramForecastBean);
      continue;
      paramString2 = com.gau.go.launcherex.gowidget.weather.util.q.i((String)localObject);
      paramString1 = com.gau.go.launcherex.gowidget.weather.util.q.i(paramForecastBean);
      continue;
      paramString2 = com.gau.go.launcherex.gowidget.weather.util.q.j((String)localObject);
      paramString1 = com.gau.go.launcherex.gowidget.weather.util.q.j(paramForecastBean);
      continue;
      paramString2 = com.gau.go.launcherex.gowidget.weather.util.q.k((String)localObject);
      paramString1 = com.gau.go.launcherex.gowidget.weather.util.q.k(paramForecastBean);
      continue;
      paramString2 = com.gau.go.launcherex.gowidget.weather.util.q.l((String)localObject);
      paramString1 = com.gau.go.launcherex.gowidget.weather.util.q.l(paramForecastBean);
    }
  }
  
  private void a()
  {
    String str = "";
    if (this.h.getChildCount() > 0) {
      str = ((WeatherForecastView)this.h.getChildAt(this.h.b())).b();
    }
    startActivity(WeatherDetailActivity.a(this, str, true, 15, "", 2));
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      this.b.setVisibility(4);
    }
    while (paramInt1 == paramInt2 - 1)
    {
      this.c.setVisibility(4);
      return;
      this.b.setVisibility(0);
    }
    this.c.setVisibility(0);
  }
  
  private boolean a(String paramString)
  {
    boolean bool = false;
    if (this.i.equals(paramString)) {
      bool = true;
    }
    return bool;
  }
  
  private void b()
  {
    Iterator localIterator1 = this.d.d().iterator();
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        break label100;
      }
      Object localObject = (WeatherBean)localIterator1.next();
      Iterator localIterator2 = ((WeatherBean)localObject).g.iterator();
      if (localIterator2.hasNext())
      {
        ForecastBean localForecastBean = (ForecastBean)localIterator2.next();
        if (!a(localForecastBean.c())) {
          break;
        }
        localObject = a(((WeatherBean)localObject).c(), ((WeatherBean)localObject).d(), localForecastBean);
        if (localObject != null) {
          this.h.addView((View)localObject);
        }
      }
    }
    label100:
    this.h.a();
  }
  
  private void f()
  {
    int i1 = this.h.b();
    int i2 = this.h.getChildCount();
    if ((i2 <= 1) || (i1 == i2 - 1)) {
      return;
    }
    this.h.a(i1 + 1);
  }
  
  private void g()
  {
    int i1 = this.h.b();
    if (i1 == 0) {
      return;
    }
    this.h.a(i1 - 1);
  }
  
  public void a(WeatherDetailScrollGroup paramWeatherDetailScrollGroup, int paramInt) {}
  
  public void b(WeatherDetailScrollGroup paramWeatherDetailScrollGroup, int paramInt)
  {
    paramWeatherDetailScrollGroup = (WeatherForecastView)paramWeatherDetailScrollGroup.getChildAt(paramInt);
    if (paramWeatherDetailScrollGroup != null) {
      this.a.setText(paramWeatherDetailScrollGroup.a());
    }
    this.g.b(paramInt);
  }
  
  public void c(WeatherDetailScrollGroup paramWeatherDetailScrollGroup, int paramInt)
  {
    a(paramInt, paramWeatherDetailScrollGroup.getChildCount());
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    super.dispatchKeyEvent(paramKeyEvent);
    if (this.k != null)
    {
      this.k.cancel(this.l);
      this.k = null;
    }
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    super.dispatchTouchEvent(paramMotionEvent);
    if (this.k != null)
    {
      this.k.cancel(this.l);
      this.k = null;
    }
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903350);
    getWindow().clearFlags(134217728);
    int i1 = e().getDisplayMetrics().widthPixels;
    int i2 = (int)e().getDimension(2131427470);
    paramBundle = getWindow().getAttributes();
    paramBundle.width = (i1 - i2 * 2);
    getWindow().setAttributes(paramBundle);
    this.d = f.a(getApplicationContext());
    this.e = e.a(getApplicationContext());
    this.f = getLayoutInflater();
    paramBundle = Calendar.getInstance();
    paramBundle.add(5, 1);
    this.i = new SimpleDateFormat("yyyy/MM/dd").format(paramBundle.getTime());
    this.m = this.e.a().g;
    this.n = this.e.a().q;
    paramBundle = (TextView)findViewById(2131232097);
    paramBundle.setVisibility(0);
    paramBundle.setText(2131165795);
    paramBundle.setOnClickListener(new bp(this));
    this.a = ((TextView)findViewById(2131231208));
    this.g = ((Indicator)findViewById(2131232095));
    this.g.a(2130839019, 2130839018);
    this.h = ((WeatherDetailScrollGroup)findViewById(2131232096));
    this.h.a(this);
    this.b = findViewById(2131232093);
    this.b.setOnClickListener(new bq(this));
    this.c = findViewById(2131232094);
    this.c.setOnClickListener(new br(this));
    b();
    i1 = this.h.getChildCount();
    if (i1 == 0)
    {
      finish();
      return;
    }
    this.g.a(i1);
    this.g.c((int)(10.0F * e().getDisplayMetrics().density));
    this.g.b(0);
    a(0, i1);
    paramBundle = (WeatherForecastView)this.h.getChildAt(0);
    this.a.setText(paramBundle.a());
    this.j = new Notification();
    this.k = ((NotificationManager)getSystemService("notification"));
    this.j.defaults = 1;
    this.k.notify(this.l, this.j);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.k != null)
    {
      this.k.cancel(this.l);
      this.k = null;
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.h.removeAllViews();
    b();
    int i1 = this.h.getChildCount();
    if (i1 == 0)
    {
      finish();
      return;
    }
    this.g.a(i1);
    this.g.c((int)(10.0F * e().getDisplayMetrics().density));
    this.g.b(0);
    a(0, i1);
    paramIntent = (WeatherForecastView)this.h.getChildAt(0);
    this.a.setText(paramIntent.a());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/WeatherDayForecastActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */