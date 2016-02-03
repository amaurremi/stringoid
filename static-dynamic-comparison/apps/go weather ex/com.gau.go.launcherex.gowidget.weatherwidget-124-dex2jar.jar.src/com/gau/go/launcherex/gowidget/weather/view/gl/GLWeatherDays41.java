package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.format.Time;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.f.a;
import com.gau.go.launcherex.gowidget.weather.f.e;
import com.gau.go.launcherex.gowidget.weather.model.ForecastBean;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.WidgetSettingBean;
import com.gau.go.launcherex.gowidget.weather.util.c;
import com.gau.go.launcherex.gowidget.weather.util.q;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gau.go.launcherex.gowidget.weather.view.dh;
import com.go.gl.graphics.GLDrawable;
import com.go.gl.view.GLFrameLayout;
import com.go.gl.view.GLLinearLayout;
import com.go.gl.view.GLView;
import com.go.gl.view.GLView.OnClickListener;
import com.go.gl.view.GLView.OnLongClickListener;
import com.go.gl.widget.GLImageView;
import com.go.gl.widget.GLTextViewWrapper;
import java.util.ArrayList;
import java.util.HashMap;

public class GLWeatherDays41
  extends GLWidgetChildView
  implements GLView.OnClickListener, GLView.OnLongClickListener
{
  private int A;
  private int B;
  private int C;
  private int D;
  private g E;
  private int F = 55536;
  private int G = 0;
  private GLWeatherWidgetDays41 H;
  private WeatherBean a = null;
  private GLLinearLayout b;
  private GLImageView c;
  private GLImageView d;
  private GLImageView e;
  private GLImageView f;
  private GLImageView g;
  private GLImageView h;
  private GLLinearLayout i;
  private GLImageView j;
  private GLImageView k;
  private GLImageView l;
  private GLImageView m;
  boolean mIsDay = true;
  private GLImageView n;
  private GLTextViewWrapper o;
  private GLWeatherLouverView p;
  private GLTextViewWrapper q;
  private GLImageView r;
  private GLProgressBar s;
  private GLFrameLayout t;
  private GLWeatherForecastItem[] u;
  private GLImageView[] v;
  private GLImageView w;
  private GLImageView x;
  private String[] y;
  private a z;
  
  public GLWeatherDays41(Context paramContext)
  {
    super(paramContext, dh.a);
    this.mContext = paramContext;
    a();
    a(paramContext);
  }
  
  private String a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String[] arrayOfString = this.z.d;; arrayOfString = this.z.e)
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
  
  private void a()
  {
    this.y = c.h(this.mContext);
    b();
    c();
    d();
    try
    {
      GLDrawable localGLDrawable = GLDrawable.getDrawable(getResources(), 2130838042);
      this.p.setWeather(localGLDrawable, false);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
  }
  
  private void a(int paramInt)
  {
    if (r.b(this.mContext))
    {
      this.h.setVisibility(8);
      return;
    }
    if ((paramInt >= 0) && (paramInt < 12)) {
      if (this.z != null) {
        this.h.setImageDrawable(e.a(this.z.b, this.z.a("gw_weather_days_41_time_am"), this.z.a));
      }
    }
    for (;;)
    {
      this.h.setVisibility(0);
      return;
      this.h.setImageResource(2130838100);
      continue;
      if (this.z != null)
      {
        Drawable localDrawable = e.a(this.z.b, this.z.a("gw_weather_days_41_time_pm"), this.z.a);
        this.h.setImageDrawable(localDrawable);
      }
      else
      {
        this.h.setImageResource(2130838102);
      }
    }
  }
  
  private void a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.o.getTextView().setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.q.getTextView().setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    b(paramInt1, paramInt2);
    int i1 = paramInt1;
    if (!r.b(this.mContext))
    {
      paramInt1 %= 12;
      i1 = paramInt1;
      if (paramInt1 == 0) {
        i1 = paramInt1 + 12;
      }
    }
    this.c.setImageDrawable(e.a(this.z.b, a(i1 / 10, true), this.z.a));
    this.d.setImageDrawable(e.a(this.z.b, a(i1 % 10, true), this.z.a));
    this.e.setImageDrawable(e.a(this.z.b, a(paramInt2 / 10, true), this.z.a));
    this.f.setImageDrawable(e.a(this.z.b, a(paramInt2 % 10, true), this.z.a));
  }
  
  private void a(Context paramContext)
  {
    this.z = new a();
    this.z.a = paramContext.getPackageName();
    this.z.b = paramContext.getResources();
    this.z.d = new String[] { "gw_weather_42_time_num0_w", "gw_weather_42_time_num1_w", "gw_weather_42_time_num2_w", "gw_weather_42_time_num3_w", "gw_weather_42_time_num4_w", "gw_weather_42_time_num5_w", "gw_weather_42_time_num6_w", "gw_weather_42_time_num7_w", "gw_weather_42_time_num8_w", "gw_weather_42_time_num9_w" };
    this.z.e = new String[] { "gw_weather_42_temp_num0_w", "gw_weather_42_temp_num1_w", "gw_weather_42_temp_num2_w", "gw_weather_42_temp_num3_w", "gw_weather_42_temp_num4_w", "gw_weather_42_temp_num5_w", "gw_weather_42_temp_num6_w", "gw_weather_42_temp_num7_w", "gw_weather_42_temp_num8_w", "gw_weather_42_temp_num9_w" };
    this.z.c = new String[] { "gowidget_42_weather_na", "gowidget_42_weather_sunny_day", "gowidget_42_weather_sunny_night", "gowidget_42_weather_cloudy_day", "gowidget_42_weather_cloudy_night", "gowidget_42_weather_overcast", "gowidget_42_weather_snowy", "gowidget_42_weather_foggy", "gowidget_42_weather_rainy", "gowidget_42_weather_thunderstorm" };
    this.z.f = new String[] { "gw_weather_forecast_item_unknown", "gw_weather_forecast_item_sun", "gw_weather_forecast_item_cloudy", "gw_weather_forecast_item_darkcloudy", "gw_weather_forecast_item_snow", "gw_weather_forecast_item_fog", "gw_weather_forecast_item_rain", "gw_weather_forecast_item_thunderstorm" };
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
    this.z.a(paramContext);
  }
  
  private void a(ColorStateList paramColorStateList)
  {
    this.o.getTextView().setTextColor(paramColorStateList);
    this.q.getTextView().setTextColor(paramColorStateList);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.u != null)
    {
      int i2 = this.u.length;
      int i1 = 0;
      while (i1 < i2)
      {
        this.u[i1].showForecastInfo(this.H.mSettings.a, paramBoolean);
        i1 += 1;
      }
    }
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    boolean bool = isDayTime();
    if (!(this.mIsDay & bool)) {
      this.mIsDay = bool;
    }
    while ((paramInt1 == 0) && (paramInt2 == 0)) {
      return true;
    }
    return false;
  }
  
  private void b()
  {
    this.b = ((GLLinearLayout)findViewById(2131231277));
    this.c = ((GLImageView)findViewById(2131232059));
    this.d = ((GLImageView)findViewById(2131232060));
    this.e = ((GLImageView)findViewById(2131232061));
    this.f = ((GLImageView)findViewById(2131232062));
    this.g = ((GLImageView)findViewById(2131232009));
    this.h = ((GLImageView)findViewById(2131232003));
    this.i = ((GLLinearLayout)findViewById(2131231981));
    this.j = ((GLImageView)findViewById(2131231990));
    this.k = ((GLImageView)findViewById(2131231991));
    this.l = ((GLImageView)findViewById(2131231992));
    this.m = ((GLImageView)findViewById(2131231993));
    this.n = ((GLImageView)findViewById(2131231994));
    this.o = ((GLTextViewWrapper)findViewById(2131231995));
    this.p = ((GLWeatherLouverView)findViewById(2131231987));
    this.q = ((GLTextViewWrapper)findViewById(2131232057));
    this.r = ((GLImageView)findViewById(2131232002));
    this.s = ((GLProgressBar)findViewById(2131232072));
    this.t = ((GLFrameLayout)findViewById(2131232058));
    this.u = new GLWeatherForecastItem[] { (GLWeatherForecastItem)findViewById(2131232064), (GLWeatherForecastItem)findViewById(2131232066), (GLWeatherForecastItem)findViewById(2131232068), (GLWeatherForecastItem)findViewById(2131232070) };
    this.v = new GLImageView[] { (GLImageView)findViewById(2131232065), (GLImageView)findViewById(2131232067), (GLImageView)findViewById(2131232069) };
    this.w = ((GLImageView)findViewById(2131232071));
    this.x = ((GLImageView)findViewById(2131232000));
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (this.a == null) {}
    while (((paramInt1 != this.A) || (paramInt2 != this.B)) && ((paramInt1 != this.C) || (paramInt2 != this.D))) {
      return;
    }
    showWeatherInfo(true);
  }
  
  private void c()
  {
    if (this.u != null)
    {
      int i2 = this.u.length;
      int i1 = 0;
      while (i1 < i2)
      {
        this.u[i1].initView(this.y, this);
        i1 += 1;
      }
    }
  }
  
  private void d()
  {
    this.o.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.o.setOnLongClickListener(this);
    this.r.setOnLongClickListener(this);
    this.t.setOnLongClickListener(this);
    this.h.setOnLongClickListener(this);
    this.b.setOnLongClickListener(this);
    this.w.setOnLongClickListener(this);
    this.p.setOnLongClickListener(this);
    this.i.setOnLongClickListener(this);
    this.q.setOnLongClickListener(this);
    if (this.u != null)
    {
      int i2 = this.u.length;
      int i1 = 0;
      while (i1 < i2)
      {
        this.u[i1].setOnLongClickListener(this);
        i1 += 1;
      }
    }
  }
  
  private void e()
  {
    int i2 = 1;
    int i1 = i2;
    if (this.a != null)
    {
      i1 = i2;
      if (this.a.g != null)
      {
        i1 = this.a.k.n();
        Object localObject = this.E.c(i1);
        ArrayList localArrayList = r.a(this.a.g, (Time)localObject, true);
        if (this.G >= localArrayList.size()) {
          this.G = 0;
        }
        if (localArrayList.size() <= 5)
        {
          this.w.setVisibility(8);
          localObject = y.f(this.mContext);
          if ((localObject == null) || ((!((String)localObject).equals("200")) && (!((String)localObject).equals("414")))) {
            break label209;
          }
        }
        for (;;)
        {
          if (localArrayList.size() >= 10) {
            break label221;
          }
          localArrayList.add(null);
          continue;
          this.w.setVisibility(0);
          if (this.G == 0) {}
          for (localObject = "gw_weather_days_41_arrow_next";; localObject = "gw_weather_days_41_arrow_previous")
          {
            localObject = this.z.a((String)localObject);
            localObject = e.a(this.z.b, (String)localObject, this.z.a);
            this.w.setImageDrawable((Drawable)localObject);
            break;
          }
          label209:
          this.w.setVisibility(8);
        }
        label221:
        if (this.u != null)
        {
          i2 = this.u.length;
          i1 = 0;
          while (i1 < i2)
          {
            this.u[i1].setForecastBean((ForecastBean)localArrayList.get(i1 + 1 + this.G));
            i1 += 1;
          }
        }
        i1 = 0;
      }
    }
    if (i1 != 0)
    {
      if (this.u != null)
      {
        i2 = this.u.length;
        i1 = 0;
        while (i1 < i2)
        {
          this.u[i1].setForecastBean(null);
          i1 += 1;
        }
      }
      this.w.setVisibility(8);
    }
  }
  
  private void f()
  {
    this.o.setText(this.a.d());
  }
  
  private void g()
  {
    setOnClickListener(null);
    setOnLongClickListener(null);
    unSetComponentOnClickListener(this.o);
    unSetComponentOnClickListener(this.r);
    unSetComponentOnClickListener(this.h);
    unSetComponentOnClickListener(this.b);
    unSetComponentOnClickListener(this.w);
    unSetComponentOnClickListener(this.x);
    unSetComponentOnClickListener(this.p);
    unSetComponentOnClickListener(this.i);
    unSetComponentOnClickListener(this.q);
    unSetComponentOnLongClickListener(this.o);
    unSetComponentOnLongClickListener(this.r);
    unSetComponentOnLongClickListener(this.t);
    unSetComponentOnLongClickListener(this.h);
    unSetComponentOnLongClickListener(this.b);
    unSetComponentOnLongClickListener(this.w);
    unSetComponentOnLongClickListener(this.p);
    unSetComponentOnLongClickListener(this.i);
    unSetComponentOnLongClickListener(this.q);
  }
  
  public void adjustTime()
  {
    if ((this.E.d()) && (this.a != null) && (this.a.k.n() != this.F)) {
      this.F = this.a.k.n();
    }
    syncTime(false);
  }
  
  public void cleanup()
  {
    super.cleanup();
    g();
  }
  
  public void doGotoWeatherDetail()
  {
    this.H.gotoWeatherDetail(getCityId());
  }
  
  public String getCityId()
  {
    if (this.a != null) {
      return this.a.c();
    }
    return null;
  }
  
  public Time getCityTime()
  {
    if (this.a != null)
    {
      this.F = this.a.k.n();
      return this.E.b(this.F);
    }
    return this.E.c();
  }
  
  public int getContentViewLayoutId()
  {
    return 2130903347;
  }
  
  public int getIndex()
  {
    return this.a.q();
  }
  
  public int getMyLocation()
  {
    return this.a.e();
  }
  
  public WeatherBean getWeatherBean()
  {
    return this.a;
  }
  
  public boolean isDayTime()
  {
    if (this.a == null) {
      return true;
    }
    String str1 = this.a.k.j();
    String str2 = this.a.k.k();
    if (this.E.d())
    {
      int i1 = this.a.k.n();
      return r.a(str1, str2, this.E.b(i1));
    }
    return r.a(str1, str2);
  }
  
  public boolean isEmptyCity()
  {
    return TextUtils.isEmpty(getCityId());
  }
  
  public void notifyLanguageChanged()
  {
    this.y = c.h(this.mContext);
    if (this.u != null)
    {
      int i2 = this.u.length;
      int i1 = 0;
      while (i1 < i2)
      {
        this.u[i1].setWeek(this.y);
        i1 += 1;
      }
    }
    showWeatherInfo(false);
    if (this.a == null) {
      setTip(this.mContext.getString(2131166455));
    }
  }
  
  public void onApplyTheme(a parama)
  {
    this.z = parama;
    Object localObject1 = this.z.c[0];
    localObject1 = e.a(this.z.b, (String)localObject1, this.z.a);
    if (localObject1 != null)
    {
      localObject1 = GLDrawable.getDrawable((Drawable)localObject1);
      this.p.setWeather((GLDrawable)localObject1, false);
    }
    localObject1 = this.z.a("gw_weather_days_41_temp_minus");
    localObject1 = e.a(this.z.b, (String)localObject1, this.z.a);
    this.l.setImageDrawable((Drawable)localObject1);
    this.m.setImageDrawable((Drawable)localObject1);
    this.j.setImageDrawable((Drawable)localObject1);
    localObject1 = parama.a("gw_weather_days_41_time_divider");
    this.g.setImageDrawable(e.a(this.z.b, (String)localObject1, this.z.a));
    a(0, 0, false);
    if (this.H.mSettings.a == 1) {
      localObject1 = this.z.a("gw_weather_days_41_temp_unit_celsius");
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.z.a("gw_weather_days_41_temp_unit");
      }
      this.n.setImageDrawable(e.a(this.z.b, (String)localObject2, this.z.a));
      localObject1 = e.b(this.z.b, parama.a("gw_weather_days_41_txt_selector"), this.z.a);
      if (localObject1 != null) {
        a((ColorStateList)localObject1);
      }
      try
      {
        a(e.a(this.z.a("gw_weather_days_41_txt_shadow_color"), 16777215), Float.parseFloat(this.z.a("gw_weather_days_41_txt_shadow_dx")), Float.parseFloat(this.z.a("gw_weather_days_41_txt_shadow_dy")), Float.parseFloat(this.z.a("gw_weather_days_41_txt_shadow_radius")));
        localObject1 = this.z.a("gw_weather_days_41_theme_setting_selector");
        localObject1 = e.a(this.z.b, (String)localObject1, this.z.a);
        if (localObject1 != null)
        {
          this.x.setVisibility(0);
          this.x.setImageDrawable((Drawable)localObject1);
          i1 = this.r.getVisibility();
          this.r.setBackgroundDrawable(e.a(this.z.b, parama.a("gw_weather_days_41_refresh_selector"), this.z.a));
          this.r.setVisibility(i1);
          i1 = this.s.getVisibility();
          localObject1 = parama.a("gw_weather_days_41_refresh_selector");
          localObject1 = e.a(this.z.b, (String)localObject1, this.z.a);
          this.s.setBackgroundDrawable((Drawable)localObject1);
          this.s.setVisibility(i1);
          localObject1 = parama.a("gw_weather_days_41_divider_forecast");
          localObject1 = e.a(this.z.b, (String)localObject1, this.z.a);
          if (this.v == null) {
            break label594;
          }
          i2 = this.v.length;
          i1 = 0;
          while (i1 < i2)
          {
            this.v[i1].setImageDrawable((Drawable)localObject1);
            i1 += 1;
            continue;
            localObject1 = this.z.a("gw_weather_days_41_temp_unit_fahrenheit");
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
          this.x.setVisibility(4);
        }
        label594:
        parama = parama.a("gw_weather_days_41_arrow_next");
        parama = e.a(this.z.b, parama, this.z.a);
        this.w.setImageDrawable(parama);
        if (this.u != null)
        {
          i2 = this.u.length;
          i1 = 0;
          while (i1 < i2)
          {
            this.u[i1].onApplyTheme(this.z);
            i1 += 1;
          }
        }
        syncTime(false);
        showWeatherInfo(false);
      }
    }
  }
  
  public void onClick(GLView paramGLView)
  {
    if (paramGLView.equals(this.b)) {
      this.H.gotoClock();
    }
    do
    {
      return;
      if ((paramGLView.equals(this.o)) || (paramGLView.equals(this.p)) || (paramGLView.equals(this.i)) || (paramGLView.equals(this.q)))
      {
        this.H.gotoWeatherDetail(getCityId());
        return;
      }
      if (paramGLView.equals(this.w))
      {
        if (this.H.mIsPro)
        {
          if (this.G == 0) {
            this.G = 4;
          }
          for (paramGLView = "gw_weather_days_41_arrow_previous";; paramGLView = "gw_weather_days_41_arrow_next")
          {
            paramGLView = this.z.a(paramGLView);
            paramGLView = e.a(this.z.b, paramGLView, this.z.a);
            this.w.setImageDrawable(paramGLView);
            e();
            a(true);
            return;
            this.G = 0;
          }
        }
        this.H.gotoBilling();
        return;
      }
      if (paramGLView.equals(this.r))
      {
        this.H.doRefresh();
        return;
      }
    } while (!paramGLView.equals(this.x));
    this.H.gotoThemeSetting();
  }
  
  public boolean onLongClick(GLView paramGLView)
  {
    performLongClick();
    return true;
  }
  
  public void refreshTemp()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      showTempNow(this.a.k.a(this.H.mSettings.a));
      if (this.u != null)
      {
        int i2 = this.u.length;
        int i1 = 0;
        while (i1 < i2)
        {
          this.u[i1].showForecastInfo(this.H.mSettings.a, false);
          i1 += 1;
        }
      }
    }
  }
  
  public void setIndex(int paramInt)
  {
    this.a.e(paramInt);
  }
  
  public void setMyLocation(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void setThemeBean(a parama)
  {
    this.z = parama;
    if (this.u != null)
    {
      int i2 = this.u.length;
      int i1 = 0;
      while (i1 < i2)
      {
        this.u[i1].setThemeBean(parama);
        i1 += 1;
      }
    }
  }
  
  public void setTimeManager(g paramg)
  {
    this.E = paramg;
  }
  
  public void setTip(String paramString)
  {
    this.o.setText(paramString);
  }
  
  public void setWeatherBean(WeatherBean paramWeatherBean, boolean paramBoolean)
  {
    Object localObject;
    if (paramWeatherBean != null)
    {
      if ((paramWeatherBean.g == null) && (this.a != null)) {
        paramWeatherBean.g = this.a.g;
      }
      this.a = paramWeatherBean;
      e();
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
      this.A = Integer.parseInt(localObject[0]);
      this.B = Integer.parseInt(localObject[1]);
      paramWeatherBean = paramWeatherBean.split(":");
      this.C = Integer.parseInt(paramWeatherBean[0]);
      this.D = Integer.parseInt(paramWeatherBean[1]);
      return;
    }
    catch (Exception paramWeatherBean)
    {
      paramWeatherBean.printStackTrace();
      return;
    }
    label135:
    this.A = 6;
    this.B = 0;
    this.C = 18;
    this.D = 0;
  }
  
  public void setWidgetView(GLWeatherWidgetDays41 paramGLWeatherWidgetDays41)
  {
    this.H = paramGLWeatherWidgetDays41;
  }
  
  public void showProgerssView(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.r.setVisibility(4);
      this.s.setVisibility(0);
      this.s.startAnimation();
      return;
    }
    this.r.setVisibility(0);
    this.s.setVisibility(4);
    this.s.stopAnimation();
  }
  
  public void showTempNow(float paramFloat)
  {
    if (paramFloat == -10000.0F)
    {
      localObject1 = this.z.a("gw_weather_days_41_temp_minus");
      localObject1 = e.a(this.z.b, (String)localObject1, this.z.a);
      this.j.setVisibility(8);
      this.k.setVisibility(8);
      this.l.setVisibility(0);
      this.m.setVisibility(0);
      this.l.setImageDrawable((Drawable)localObject1);
      this.m.setImageDrawable((Drawable)localObject1);
      return;
    }
    int i1 = q.a(paramFloat);
    int i2;
    label134:
    int i3;
    if (i1 < 0)
    {
      this.j.setVisibility(0);
      i1 = Math.abs(i1);
      i2 = i1 / 100;
      if (i2 != 0) {
        break label285;
      }
      this.k.setVisibility(8);
      i3 = (i1 - i2 * 100) / 10;
      if ((i3 != 0) || (i2 != 0)) {
        break label326;
      }
      this.l.setVisibility(8);
      label163:
      this.m.setImageDrawable(e.a(this.z.b, a(i1 % 10, false), this.z.a));
      if (this.H.mSettings.a != 1) {
        break label368;
      }
    }
    label285:
    label326:
    label368:
    for (Object localObject1 = this.z.a("gw_weather_days_41_temp_unit_celsius");; localObject1 = this.z.a("gw_weather_days_41_temp_unit_fahrenheit"))
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.z.a("gw_weather_days_41_temp_unit");
      }
      this.n.setImageDrawable(e.a(this.z.b, (String)localObject2, this.z.a));
      return;
      this.j.setVisibility(8);
      break;
      this.k.setImageDrawable(e.a(this.z.b, a(i2, false), this.z.a));
      this.k.setVisibility(0);
      break label134;
      this.l.setImageDrawable(e.a(this.z.b, a(i3, false), this.z.a));
      this.l.setVisibility(0);
      break label163;
    }
  }
  
  public void showWeatherInfo(boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    f();
    Object localObject = this.z.c[0];
    switch (this.a.k.d())
    {
    default: 
      localObject = this.z.c[0];
    }
    for (;;)
    {
      Drawable localDrawable = e.a(this.z.b, (String)localObject, this.z.a);
      localObject = null;
      if (localDrawable != null) {
        localObject = GLDrawable.getDrawable(localDrawable);
      }
      if (localObject != null) {
        this.p.setWeather((GLDrawable)localObject, paramBoolean);
      }
      showTempNow(this.a.k.a(this.H.mSettings.a));
      this.q.setText(this.a.k.e());
      a(paramBoolean);
      return;
      if (this.mIsDay)
      {
        localObject = this.z.c[1];
      }
      else
      {
        localObject = this.z.c[2];
        continue;
        if (this.mIsDay)
        {
          localObject = this.z.c[3];
        }
        else
        {
          localObject = this.z.c[4];
          continue;
          localObject = this.z.c[5];
          continue;
          localObject = this.z.c[6];
          continue;
          localObject = this.z.c[7];
          continue;
          localObject = this.z.c[8];
          continue;
          localObject = this.z.c[9];
        }
      }
    }
  }
  
  public void syncTime(boolean paramBoolean)
  {
    Time localTime = getCityTime();
    if (localTime != null)
    {
      a(localTime.hour, localTime.minute, paramBoolean);
      a(localTime.hour);
      e();
      if (a(localTime.hour, localTime.minute)) {
        showWeatherInfo(paramBoolean);
      }
    }
  }
  
  public void updateAllViews()
  {
    syncTime(true);
    showWeatherInfo(true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherDays41.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */