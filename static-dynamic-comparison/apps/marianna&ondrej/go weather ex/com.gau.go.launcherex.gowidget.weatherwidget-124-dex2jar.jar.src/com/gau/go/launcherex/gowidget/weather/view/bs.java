package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.f.e;
import com.gau.go.launcherex.gowidget.weather.f.f;
import com.gau.go.launcherex.gowidget.weather.model.ForecastBean;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.WidgetSettingBean;
import com.gau.go.launcherex.gowidget.weather.util.c;
import com.gau.go.launcherex.gowidget.weather.util.q;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.GoWidgetDynamicIconView;
import com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a.b;
import com.jiubang.core.a.l;
import java.util.ArrayList;
import java.util.HashMap;

public class bs
  extends dg
  implements View.OnClickListener, View.OnLongClickListener, b
{
  private ImageView A = null;
  private String[] B = null;
  private com.gau.go.launcherex.gowidget.weather.f.a C = null;
  private int D;
  private int E;
  private int F;
  private int G;
  private g H = null;
  private int I = 55536;
  private int J = 0;
  private WeatherWidgetDays41 K;
  boolean a = true;
  private WeatherBean d = null;
  private LinearLayout e;
  private ImageView f = null;
  private ImageView g = null;
  private ImageView h = null;
  private ImageView i = null;
  private ImageView j = null;
  private ImageView k = null;
  private LinearLayout l = null;
  private ImageView m = null;
  private ImageView n = null;
  private ImageView o = null;
  private ImageView p = null;
  private ImageView q = null;
  private TextView r = null;
  private GoWidgetDynamicIconView s = null;
  private TextView t = null;
  private ImageView u = null;
  private ProgressBar v = null;
  private FrameLayout w = null;
  private WeatherForecastItem[] x = null;
  private ImageView[] y = null;
  private ImageView z = null;
  
  public bs(Context paramContext)
  {
    super(paramContext, dh.a);
    a(paramContext);
    m();
  }
  
  private String a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String[] arrayOfString = this.C.d;; arrayOfString = this.C.e)
    {
      String str = arrayOfString[0];
      switch (paramInt)
      {
      default: 
        return arrayOfString[0];
      }
    }
    return arrayOfString[0];
    return arrayOfString[1];
    return arrayOfString[2];
    return arrayOfString[3];
    return arrayOfString[4];
    return arrayOfString[5];
    return arrayOfString[6];
    return arrayOfString[7];
    return arrayOfString[8];
    return arrayOfString[9];
  }
  
  private void a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.r.setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.t.setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    b(paramInt1, paramInt2);
    int i1 = paramInt1;
    if (!r.b(this.b))
    {
      paramInt1 %= 12;
      i1 = paramInt1;
      if (paramInt1 == 0) {
        i1 = paramInt1 + 12;
      }
    }
    this.f.setImageDrawable(e.a(this.C.b, a(i1 / 10, true), this.C.a));
    this.g.setImageDrawable(e.a(this.C.b, a(i1 % 10, true), this.C.a));
    this.h.setImageDrawable(e.a(this.C.b, a(paramInt2 / 10, true), this.C.a));
    this.i.setImageDrawable(e.a(this.C.b, a(paramInt2 % 10, true), this.C.a));
  }
  
  private void a(Context paramContext)
  {
    this.C = new com.gau.go.launcherex.gowidget.weather.f.a();
    this.C.a = paramContext.getPackageName();
    this.C.b = paramContext.getResources();
    this.C.d = new String[] { "gw_weather_42_time_num0_w", "gw_weather_42_time_num1_w", "gw_weather_42_time_num2_w", "gw_weather_42_time_num3_w", "gw_weather_42_time_num4_w", "gw_weather_42_time_num5_w", "gw_weather_42_time_num6_w", "gw_weather_42_time_num7_w", "gw_weather_42_time_num8_w", "gw_weather_42_time_num9_w" };
    this.C.e = new String[] { "gw_weather_42_temp_num0_w", "gw_weather_42_temp_num1_w", "gw_weather_42_temp_num2_w", "gw_weather_42_temp_num3_w", "gw_weather_42_temp_num4_w", "gw_weather_42_temp_num5_w", "gw_weather_42_temp_num6_w", "gw_weather_42_temp_num7_w", "gw_weather_42_temp_num8_w", "gw_weather_42_temp_num9_w" };
    this.C.c = new String[] { "gowidget_42_weather_na", "gowidget_42_weather_sunny_day", "gowidget_42_weather_sunny_night", "gowidget_42_weather_cloudy_day", "gowidget_42_weather_cloudy_night", "gowidget_42_weather_overcast", "gowidget_42_weather_snowy", "gowidget_42_weather_foggy", "gowidget_42_weather_rainy", "gowidget_42_weather_thunderstorm" };
    this.C.f = new String[] { "gw_weather_forecast_item_unknown", "gw_weather_forecast_item_sun", "gw_weather_forecast_item_cloudy", "gw_weather_forecast_item_darkcloudy", "gw_weather_forecast_item_snow", "gw_weather_forecast_item_fog", "gw_weather_forecast_item_rain", "gw_weather_forecast_item_thunderstorm" };
    paramContext = new HashMap();
    paramContext.put("gw_weather_days_41_temp_minus", "gw_weather_42_temp_minus_w");
    paramContext.put("gw_weather_days_41_temp_unit", "gw_weather_42_temp_unit_w");
    paramContext.put("gw_weather_days_41_temp_unit_celsius", "widget_l_temp_centigrade_w");
    paramContext.put("gw_weather_days_41_temp_unit_fahrenheit", "widget_l_temp_fahrenheit_w");
    paramContext.put("gw_weather_days_41_time_divider", "gw_weather_41_time_divider_w");
    paramContext.put("gw_weather_days_41_time_am", "gw_weather_days_42_am_w");
    paramContext.put("gw_weather_days_41_time_pm", "gw_weather_days_42_pm_w");
    paramContext.put("gw_weather_days_41_bg", "gw_weather_41_bg_w");
    paramContext.put("gw_weather_days_41_txt_selector", "text_selector_w");
    paramContext.put("gw_weather_days_41_txt_shadow_color", "#66FFFFFF");
    paramContext.put("gw_weather_days_41_txt_shadow_dx", "0");
    paramContext.put("gw_weather_days_41_txt_shadow_dy", "1");
    paramContext.put("gw_weather_days_41_txt_shadow_radius", "1");
    paramContext.put("gw_weather_days_41_refresh_selector", "gw_weather_41_refresh_selector_w");
    paramContext.put("refresh_progress_days_41", "refresh_progress_41_w");
    paramContext.put("gw_weather_days_41_arrow_next", "appwidget_days_arrow_right");
    paramContext.put("gw_weather_days_41_arrow_previous", "appwidget_days_arrow_left");
    paramContext.put("gw_weather_days_41_divider_forecast", "appwidget_days_divider");
    this.C.a(paramContext);
  }
  
  private void a(ColorStateList paramColorStateList)
  {
    this.r.setTextColor(paramColorStateList);
    this.t.setTextColor(paramColorStateList);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    boolean bool = k();
    if (!(this.a & bool)) {
      this.a = bool;
    }
    while ((paramInt1 == 0) && (paramInt2 == 0)) {
      return true;
    }
    return false;
  }
  
  private void b(int paramInt)
  {
    if (r.b(this.b))
    {
      this.k.setVisibility(8);
      return;
    }
    if ((paramInt >= 0) && (paramInt < 12)) {
      if (this.C != null) {
        this.k.setImageDrawable(e.a(this.C.b, this.C.a("gw_weather_days_41_time_am"), this.C.a));
      }
    }
    for (;;)
    {
      this.k.setVisibility(0);
      return;
      this.k.setImageResource(2130838100);
      continue;
      if (this.C != null)
      {
        Drawable localDrawable = e.a(this.C.b, this.C.a("gw_weather_days_41_time_pm"), this.C.a);
        this.k.setImageDrawable(localDrawable);
      }
      else
      {
        this.k.setImageResource(2130838102);
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (this.d == null) {}
    while (((paramInt1 != this.D) || (paramInt2 != this.E)) && ((paramInt1 != this.F) || (paramInt2 != this.G))) {
      return;
    }
    a(null, false, false, true);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.x != null)
    {
      int i2 = this.x.length;
      int i1 = 0;
      while (i1 < i2)
      {
        this.x[i1].a(this.K.c.a, paramBoolean);
        i1 += 1;
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    String str = this.C.c[0];
    boolean bool = k();
    Object localObject = str;
    if (this.d != null) {
      switch (this.d.k.d())
      {
      default: 
        localObject = str;
      }
    }
    for (;;)
    {
      localObject = e.a(this.C.b, (String)localObject, this.C.a);
      if (localObject != null)
      {
        localObject = f.a((Drawable)localObject);
        if (localObject != null) {
          this.s.a((Bitmap)localObject, paramBoolean);
        }
      }
      return;
      if (bool)
      {
        localObject = this.C.c[1];
      }
      else
      {
        localObject = this.C.c[2];
        continue;
        if (bool)
        {
          localObject = this.C.c[3];
        }
        else
        {
          localObject = this.C.c[4];
          continue;
          localObject = this.C.c[5];
          continue;
          localObject = this.C.c[6];
          continue;
          localObject = this.C.c[7];
          continue;
          localObject = this.C.c[8];
          continue;
          localObject = this.C.c[9];
        }
      }
    }
  }
  
  private void m()
  {
    this.B = c.h(this.b);
    o();
    p();
    q();
    float f1 = this.b.getResources().getDisplayMetrics().density;
    this.v.setLayoutParams(new FrameLayout.LayoutParams((int)(17.0F * f1), (int)(f1 * 17.0F)));
    Object localObject = getResources().getDrawable(2130838480);
    this.v.setIndeterminateDrawable((Drawable)localObject);
    this.v.setVisibility(4);
    this.w.addView(this.v);
    try
    {
      localObject = BitmapFactory.decodeResource(getResources(), 2130838042);
      this.s.a((Bitmap)localObject, false);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
  }
  
  private void o()
  {
    this.e = ((LinearLayout)findViewById(2131231277));
    this.f = ((ImageView)findViewById(2131232059));
    this.g = ((ImageView)findViewById(2131232060));
    this.h = ((ImageView)findViewById(2131232061));
    this.i = ((ImageView)findViewById(2131232062));
    this.j = ((ImageView)findViewById(2131232009));
    this.k = ((ImageView)findViewById(2131232003));
    this.l = ((LinearLayout)findViewById(2131231981));
    this.m = ((ImageView)findViewById(2131231990));
    this.n = ((ImageView)findViewById(2131231991));
    this.o = ((ImageView)findViewById(2131231992));
    this.p = ((ImageView)findViewById(2131231993));
    this.q = ((ImageView)findViewById(2131231994));
    this.r = ((TextView)findViewById(2131231995));
    this.s = ((GoWidgetDynamicIconView)findViewById(2131231987));
    this.t = ((TextView)findViewById(2131232057));
    this.u = ((ImageView)findViewById(2131232002));
    this.v = new ProgressBar(this.b);
    this.w = ((FrameLayout)findViewById(2131232058));
    this.x = new WeatherForecastItem[] { (WeatherForecastItem)findViewById(2131232064), (WeatherForecastItem)findViewById(2131232066), (WeatherForecastItem)findViewById(2131232068), (WeatherForecastItem)findViewById(2131232070) };
    this.y = new ImageView[] { (ImageView)findViewById(2131232065), (ImageView)findViewById(2131232067), (ImageView)findViewById(2131232069) };
    this.z = ((ImageView)findViewById(2131232071));
    this.A = ((ImageView)findViewById(2131232000));
  }
  
  private void p()
  {
    if (this.x != null)
    {
      int i2 = this.x.length;
      int i1 = 0;
      while (i1 < i2)
      {
        this.x[i1].a(this.B, this, this.b);
        i1 += 1;
      }
    }
  }
  
  private void q()
  {
    this.r.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.r.setOnLongClickListener(this);
    this.u.setOnLongClickListener(this);
    this.w.setOnLongClickListener(this);
    this.k.setOnLongClickListener(this);
    this.e.setOnLongClickListener(this);
    this.z.setOnLongClickListener(this);
    this.s.setOnLongClickListener(this);
    this.l.setOnLongClickListener(this);
    this.t.setOnLongClickListener(this);
    if (this.x != null)
    {
      int i2 = this.x.length;
      int i1 = 0;
      while (i1 < i2)
      {
        this.x[i1].setOnLongClickListener(this);
        i1 += 1;
      }
    }
  }
  
  private void r()
  {
    int i2 = 1;
    int i1 = i2;
    if (this.d != null)
    {
      i1 = i2;
      if (this.d.g != null)
      {
        i1 = this.d.k.n();
        Object localObject = this.H.c(i1);
        ArrayList localArrayList = r.a(this.d.g, (Time)localObject, true);
        if (this.J + 1 >= localArrayList.size()) {
          this.J = 0;
        }
        if (localArrayList.size() <= 5)
        {
          this.z.setVisibility(8);
          localObject = y.f(this.b);
          if ((localObject == null) || ((!((String)localObject).equals("200")) && (!((String)localObject).equals("414")))) {
            break label211;
          }
        }
        for (;;)
        {
          if (localArrayList.size() >= 10) {
            break label223;
          }
          localArrayList.add(null);
          continue;
          this.z.setVisibility(0);
          if (this.J == 0) {}
          for (localObject = "gw_weather_days_41_arrow_next";; localObject = "gw_weather_days_41_arrow_previous")
          {
            localObject = this.C.a((String)localObject);
            localObject = e.a(this.C.b, (String)localObject, this.C.a);
            this.z.setImageDrawable((Drawable)localObject);
            break;
          }
          label211:
          this.z.setVisibility(8);
        }
        label223:
        if (this.x != null)
        {
          i2 = this.x.length;
          i1 = 0;
          while (i1 < i2)
          {
            this.x[i1].a((ForecastBean)localArrayList.get(i1 + 1 + this.J));
            i1 += 1;
          }
        }
        i1 = 0;
      }
    }
    if (i1 != 0)
    {
      if (this.x != null)
      {
        i2 = this.x.length;
        i1 = 0;
        while (i1 < i2)
        {
          this.x[i1].a(null);
          i1 += 1;
        }
      }
      this.z.setVisibility(8);
    }
  }
  
  public int a()
  {
    return 2130903346;
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat == -10000.0F)
    {
      localObject1 = this.C.a("gw_weather_days_41_temp_minus");
      localObject1 = e.a(this.C.b, (String)localObject1, this.C.a);
      this.m.setVisibility(8);
      this.n.setVisibility(8);
      this.o.setVisibility(0);
      this.p.setVisibility(0);
      this.o.setImageDrawable((Drawable)localObject1);
      this.p.setImageDrawable((Drawable)localObject1);
      return;
    }
    int i1 = q.a(paramFloat);
    int i2;
    label134:
    int i3;
    if (i1 < 0)
    {
      this.m.setVisibility(0);
      i1 = Math.abs(i1);
      i2 = i1 / 100;
      if (i2 != 0) {
        break label285;
      }
      this.n.setVisibility(8);
      i3 = (i1 - i2 * 100) / 10;
      if ((i3 != 0) || (i2 != 0)) {
        break label326;
      }
      this.o.setVisibility(8);
      label163:
      this.p.setImageDrawable(e.a(this.C.b, a(i1 % 10, false), this.C.a));
      if (this.K.c.a != 1) {
        break label368;
      }
    }
    label285:
    label326:
    label368:
    for (Object localObject1 = this.C.a("gw_weather_days_41_temp_unit_celsius");; localObject1 = this.C.a("gw_weather_days_41_temp_unit_fahrenheit"))
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.C.a("gw_weather_days_41_temp_unit");
      }
      this.q.setImageDrawable(e.a(this.C.b, (String)localObject2, this.C.a));
      return;
      this.m.setVisibility(8);
      break;
      this.n.setImageDrawable(e.a(this.C.b, a(i2, false), this.C.a));
      this.n.setVisibility(0);
      break label134;
      this.o.setImageDrawable(e.a(this.C.b, a(i3, false), this.C.a));
      this.o.setVisibility(0);
      break label163;
    }
  }
  
  public void a(int paramInt)
  {
    this.d.a(paramInt);
  }
  
  public void a(g paramg)
  {
    this.H = paramg;
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.f.a parama)
  {
    this.C = parama;
    Object localObject1 = this.C.c[0];
    localObject1 = e.a(this.C.b, (String)localObject1, this.C.a);
    if (localObject1 != null)
    {
      localObject1 = f.a((Drawable)localObject1);
      if (localObject1 != null) {
        this.s.a((Bitmap)localObject1, false);
      }
    }
    localObject1 = this.C.a("gw_weather_days_41_temp_minus");
    localObject1 = e.a(this.C.b, (String)localObject1, this.C.a);
    this.o.setImageDrawable((Drawable)localObject1);
    this.p.setImageDrawable((Drawable)localObject1);
    this.m.setImageDrawable((Drawable)localObject1);
    localObject1 = parama.a("gw_weather_days_41_time_divider");
    this.j.setImageDrawable(e.a(this.C.b, (String)localObject1, this.C.a));
    a(0, 0, false);
    if (this.K.c.a == 1) {
      localObject1 = this.C.a("gw_weather_days_41_temp_unit_celsius");
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.C.a("gw_weather_days_41_temp_unit");
      }
      this.q.setImageDrawable(e.a(this.C.b, (String)localObject2, this.C.a));
      localObject1 = e.b(this.C.b, parama.a("gw_weather_days_41_txt_selector"), this.C.a);
      if (localObject1 != null) {
        a((ColorStateList)localObject1);
      }
      try
      {
        a(e.a(this.C.a("gw_weather_days_41_txt_shadow_color"), 16777215), Float.parseFloat(this.C.a("gw_weather_days_41_txt_shadow_dx")), Float.parseFloat(this.C.a("gw_weather_days_41_txt_shadow_dy")), Float.parseFloat(this.C.a("gw_weather_days_41_txt_shadow_radius")));
        localObject1 = this.C.a("gw_weather_days_41_theme_setting_selector");
        localObject1 = e.a(this.C.b, (String)localObject1, this.C.a);
        if (localObject1 != null)
        {
          this.A.setVisibility(0);
          this.A.setImageDrawable((Drawable)localObject1);
          i1 = this.u.getVisibility();
          this.u.setBackgroundDrawable(e.a(this.C.b, parama.a("gw_weather_days_41_refresh_selector"), this.C.a));
          this.u.setVisibility(i1);
          i1 = this.v.getVisibility();
          this.w.removeView(this.v);
          this.v = new ProgressBar(this.b);
          localObject1 = parama.a("refresh_progress_days_41");
          localObject1 = e.a(this.C.b, (String)localObject1, this.C.a);
          float f1 = this.b.getResources().getDisplayMetrics().density;
          this.v.setLayoutParams(new FrameLayout.LayoutParams((int)(18.0F * f1), (int)(f1 * 18.0F)));
          this.v.setIndeterminateDrawable((Drawable)localObject1);
          this.v.setVisibility(i1);
          this.w.addView(this.v);
          localObject1 = parama.a("gw_weather_days_41_divider_forecast");
          localObject1 = e.a(this.C.b, (String)localObject1, this.C.a);
          if (this.y == null) {
            break label678;
          }
          i2 = this.y.length;
          i1 = 0;
          while (i1 < i2)
          {
            this.y[i1].setImageDrawable((Drawable)localObject1);
            i1 += 1;
            continue;
            localObject1 = this.C.a("gw_weather_days_41_temp_unit_fahrenheit");
          }
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int i1;
        int i2;
        for (;;)
        {
          localNumberFormatException.printStackTrace();
          continue;
          this.A.setVisibility(4);
        }
        label678:
        parama = parama.a("gw_weather_days_41_arrow_next");
        parama = e.a(this.C.b, parama, this.C.a);
        this.z.setImageDrawable(parama);
        if (this.x != null)
        {
          i2 = this.x.length;
          i1 = 0;
          while (i1 < i2)
          {
            this.x[i1].a(this.C);
            i1 += 1;
          }
        }
        f();
        a(null, false, false, false);
      }
    }
  }
  
  public void a(WeatherBean paramWeatherBean, boolean paramBoolean)
  {
    Object localObject;
    if (paramWeatherBean != null)
    {
      if ((paramWeatherBean.g == null) && (this.d != null)) {
        paramWeatherBean.g = this.d.g;
      }
      this.d = paramWeatherBean;
      r();
      if (paramBoolean)
      {
        localObject = paramWeatherBean.k.j();
        paramWeatherBean = paramWeatherBean.k.k();
        if ((!r.a((String)localObject)) || (!r.a(paramWeatherBean))) {
          break label135;
        }
      }
    }
    try
    {
      localObject = ((String)localObject).split(":");
      this.D = Integer.parseInt(localObject[0]);
      this.E = Integer.parseInt(localObject[1]);
      paramWeatherBean = paramWeatherBean.split(":");
      this.F = Integer.parseInt(paramWeatherBean[0]);
      this.G = Integer.parseInt(paramWeatherBean[1]);
      return;
    }
    catch (Exception paramWeatherBean)
    {
      paramWeatherBean.printStackTrace();
      return;
    }
    label135:
    this.D = 6;
    this.E = 0;
    this.F = 18;
    this.G = 0;
  }
  
  public void a(WeatherWidgetDays41 paramWeatherWidgetDays41)
  {
    this.K = paramWeatherWidgetDays41;
  }
  
  public void a(b paramb, l paraml, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paraml != null)
    {
      if (this.d != null) {
        if (this.d.k.d() == paramInt) {
          this.s.a(paraml, paramBoolean2);
        }
      }
      while (paramInt != 1) {
        return;
      }
      this.s.a(paraml, paramBoolean2);
      return;
    }
    c(paramBoolean2);
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a parama, boolean paramBoolean)
  {
    Time localTime = e();
    if (localTime != null)
    {
      a(localTime.hour, localTime.minute, paramBoolean);
      b(localTime.hour);
      r();
      if (a(localTime.hour, localTime.minute)) {
        a(parama, this.K.b, this.K.c.g, paramBoolean);
      }
    }
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.d == null) {
      return;
    }
    g();
    b(parama, paramBoolean1, paramBoolean2, paramBoolean3);
    a(this.d.k.a(this.K.c.a));
    this.t.setText(this.d.k.e());
    b(paramBoolean3);
  }
  
  public void a(String paramString)
  {
    this.r.setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.u.setVisibility(4);
      this.v.setVisibility(0);
      return;
    }
    this.u.setVisibility(0);
    this.v.setVisibility(4);
  }
  
  public void b(com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = this.C.c[0];
    boolean bool = k();
    int i1;
    if (this.d != null)
    {
      i1 = this.d.k.d();
      switch (this.d.k.d())
      {
      }
    }
    for (;;)
    {
      localObject = e.a(this.C.b, (String)localObject, this.C.a);
      if ((parama != null) && (paramBoolean1) && (paramBoolean2) && (paramBoolean3))
      {
        localObject = parama.a(i1, bool, true);
        if (localObject == null) {
          parama.a(i1, bool, true, this);
        }
      }
      do
      {
        do
        {
          return;
          if (bool)
          {
            localObject = this.C.c[1];
            break;
          }
          localObject = this.C.c[2];
          break;
          if (bool)
          {
            localObject = this.C.c[3];
            break;
          }
          localObject = this.C.c[4];
          break;
          localObject = this.C.c[5];
          break;
          localObject = this.C.c[6];
          break;
          localObject = this.C.c[7];
          break;
          localObject = this.C.c[8];
          break;
          localObject = this.C.c[9];
          break;
          this.s.a((l)localObject, true);
          return;
        } while (localObject == null);
        parama = f.a((Drawable)localObject);
      } while (parama == null);
      this.s.a(parama, paramBoolean3);
      return;
      i1 = 1;
    }
  }
  
  public boolean b()
  {
    return TextUtils.isEmpty(c());
  }
  
  public String c()
  {
    if (this.d != null) {
      return this.d.c();
    }
    return null;
  }
  
  public WeatherBean d()
  {
    return this.d;
  }
  
  public Time e()
  {
    if (this.d != null)
    {
      this.I = this.d.k.n();
      return this.H.b(this.I);
    }
    return this.H.c();
  }
  
  public void f()
  {
    if ((this.H.d()) && (this.d != null) && (this.d.k.n() != this.I)) {
      this.I = this.d.k.n();
    }
    a(null, false);
  }
  
  public void g()
  {
    this.r.setText(this.d.d());
  }
  
  public void h()
  {
    a(null, true);
    a(this.K.getDynamicIconManager(), this.K.b, this.K.c.g, true);
  }
  
  public void i()
  {
    if (this.d == null) {}
    for (;;)
    {
      return;
      a(this.d.k.a(this.K.c.a));
      if (this.x != null)
      {
        int i2 = this.x.length;
        int i1 = 0;
        while (i1 < i2)
        {
          this.x[i1].a(this.K.c.a, false);
          i1 += 1;
        }
      }
    }
  }
  
  public int j()
  {
    return this.d.e();
  }
  
  public boolean k()
  {
    if (this.d == null) {
      return true;
    }
    String str1 = this.d.k.j();
    String str2 = this.d.k.k();
    if (this.H.d())
    {
      int i1 = this.d.k.n();
      return r.a(str1, str2, this.H.b(i1));
    }
    return r.a(str1, str2);
  }
  
  public void l()
  {
    this.K.gotoWeatherDetail(c());
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.equals(this.r)) || (paramView.equals(this.s)) || (paramView.equals(this.l)) || (paramView.equals(this.t))) {
      l();
    }
    do
    {
      return;
      if ((paramView.equals(this.e)) || (paramView.equals(this.k)))
      {
        this.K.gotoClock();
        return;
      }
      if (paramView.equals(this.z))
      {
        if (this.K.b)
        {
          if (this.J == 0) {
            this.J = 4;
          }
          for (paramView = "gw_weather_days_41_arrow_previous";; paramView = "gw_weather_days_41_arrow_next")
          {
            paramView = this.C.a(paramView);
            paramView = e.a(this.C.b, paramView, this.C.a);
            this.z.setImageDrawable(paramView);
            r();
            b(true);
            return;
            this.J = 0;
          }
        }
        this.K.gotoBilling();
        return;
      }
      if (paramView.equals(this.u))
      {
        this.K.doRefresh();
        return;
      }
    } while (!paramView.equals(this.A));
    this.K.gotoThemeSetting();
  }
  
  public boolean onLongClick(View paramView)
  {
    performLongClick();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */