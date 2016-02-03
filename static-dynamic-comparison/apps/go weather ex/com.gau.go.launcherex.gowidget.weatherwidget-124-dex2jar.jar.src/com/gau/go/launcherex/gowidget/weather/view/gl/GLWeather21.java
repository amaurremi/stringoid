package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.format.Time;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.f.a;
import com.gau.go.launcherex.gowidget.weather.f.c;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.WidgetSettingBean;
import com.gau.go.launcherex.gowidget.weather.util.q;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gau.go.launcherex.gowidget.weather.view.dh;
import com.go.gl.graphics.GLDrawable;
import com.go.gl.view.GLLinearLayout;
import com.go.gl.view.GLView;
import com.go.gl.view.GLView.OnClickListener;
import com.go.gl.view.GLView.OnLongClickListener;
import com.go.gl.widget.GLImageView;
import com.go.gl.widget.GLTextViewWrapper;
import java.util.HashMap;

public class GLWeather21
  extends GLWidgetChildView
  implements GLView.OnClickListener, GLView.OnLongClickListener
{
  private Context a = null;
  private WeatherBean b = null;
  private GLImageView c = null;
  private GLImageView d = null;
  private GLImageView e = null;
  private GLImageView f = null;
  private GLImageView g = null;
  private GLTextViewWrapper h = null;
  private GLWeatherLouverView i = null;
  private GLLinearLayout j = null;
  private a k = null;
  private int l;
  private int m;
  private int n;
  private int o;
  private g p = null;
  private GLWeatherWidget21 q;
  
  public GLWeather21(Context paramContext)
  {
    super(paramContext, dh.a);
    this.a = paramContext;
    a();
    a(paramContext);
  }
  
  private String a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String[] arrayOfString = this.k.d;; arrayOfString = this.k.e)
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
    this.c = ((GLImageView)findViewById(2131231990));
    this.d = ((GLImageView)findViewById(2131231991));
    this.e = ((GLImageView)findViewById(2131231992));
    this.f = ((GLImageView)findViewById(2131231993));
    this.g = ((GLImageView)findViewById(2131231994));
    this.h = ((GLTextViewWrapper)findViewById(2131231995));
    this.i = ((GLWeatherLouverView)findViewById(2131231987));
    try
    {
      GLDrawable localGLDrawable = GLDrawable.getDrawable(getResources(), 2130838042);
      this.i.setWeather(localGLDrawable, false);
      this.j = ((GLLinearLayout)findViewById(2131231989));
      b();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;) {}
    }
  }
  
  private void a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.h.getTextView().setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
  }
  
  private void a(Context paramContext)
  {
    this.k = new a();
    this.k.a = paramContext.getPackageName();
    this.k.b = paramContext.getResources();
    this.k.d = new String[] { "gw_weather_42_time_num0_w", "gw_weather_42_time_num1_w", "gw_weather_42_time_num2_w", "gw_weather_42_time_num3_w", "gw_weather_42_time_num4_w", "gw_weather_42_time_num5_w", "gw_weather_42_time_num6_w", "gw_weather_42_time_num7_w", "gw_weather_42_time_num8_w", "gw_weather_42_time_num9_w" };
    this.k.e = new String[] { "gw_weather_42_temp_num0_w", "gw_weather_42_temp_num1_w", "gw_weather_42_temp_num2_w", "gw_weather_42_temp_num3_w", "gw_weather_42_temp_num4_w", "gw_weather_42_temp_num5_w", "gw_weather_42_temp_num6_w", "gw_weather_42_temp_num7_w", "gw_weather_42_temp_num8_w", "gw_weather_42_temp_num9_w" };
    this.k.c = new String[] { "gowidget_42_weather_na", "gowidget_42_weather_sunny_day", "gowidget_42_weather_sunny_night", "gowidget_42_weather_cloudy_day", "gowidget_42_weather_cloudy_night", "gowidget_42_weather_overcast", "gowidget_42_weather_snowy", "gowidget_42_weather_foggy", "gowidget_42_weather_rainy", "gowidget_42_weather_thunderstorm" };
    paramContext = new HashMap();
    paramContext.put("gw_weather_41_temp_minus", "gw_weather_42_temp_minus_w");
    paramContext.put("gw_weather_41_temp_unit", "gw_weather_42_temp_unit_w");
    paramContext.put("gw_weather_41_temp_unit_celsius", "widget_l_temp_centigrade_w");
    paramContext.put("gw_weather_41_temp_unit_fahrenheit", "widget_l_temp_fahrenheit_w");
    paramContext.put("gw_weather_41_time_divider", "gw_weather_41_time_divider_w");
    paramContext.put("gw_weather_41_time_am", "gw_weather_41_am_w");
    paramContext.put("gw_weather_41_time_pm", "gw_weather_41_pm_w");
    paramContext.put("gw_weather_41_bg", "gw_weather_41_bg_w");
    paramContext.put("gw_weather_41_txt_selector", "text_selector_w");
    paramContext.put("gw_weather_41_txt_shadow_color", "#66FFFFFF");
    paramContext.put("gw_weather_41_txt_shadow_dx", "0");
    paramContext.put("gw_weather_41_txt_shadow_dy", "1");
    paramContext.put("gw_weather_41_txt_shadow_radius", "1");
    this.k.a(paramContext);
  }
  
  private void a(ColorStateList paramColorStateList)
  {
    this.h.getTextView().setTextColor(paramColorStateList);
  }
  
  private void b()
  {
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.h.setOnLongClickListener(this);
    this.i.setOnLongClickListener(this);
    this.j.setOnLongClickListener(this);
  }
  
  private void c()
  {
    setOnClickListener(null);
    setOnLongClickListener(null);
    unSetComponentOnClickListener(this.h);
    unSetComponentOnClickListener(this.i);
    unSetComponentOnClickListener(this.j);
    unSetComponentOnLongClickListener(this.h);
    unSetComponentOnLongClickListener(this.i);
    unSetComponentOnLongClickListener(this.j);
  }
  
  public void checkToUpdateWeatherIcon()
  {
    if (this.b == null) {}
    int i1;
    int i2;
    do
    {
      return;
      Time localTime = getCityTime();
      i1 = localTime.hour;
      i2 = localTime.minute;
    } while (((i1 != this.l) || (i2 != this.m)) && ((i1 != this.n) || (i2 != this.o)));
    showWeatherInfo(true);
  }
  
  public void cleanup()
  {
    super.cleanup();
    c();
  }
  
  public String getCityId()
  {
    if (this.b != null) {
      return this.b.c();
    }
    return null;
  }
  
  public Time getCityTime()
  {
    if (this.b != null)
    {
      int i1 = this.b.k.n();
      return this.p.b(i1);
    }
    return this.p.c();
  }
  
  public int getContentViewLayoutId()
  {
    return 2130903328;
  }
  
  public int getIndex()
  {
    return this.b.q();
  }
  
  public int getMyLocation()
  {
    return this.b.e();
  }
  
  public WeatherBean getWeatherBean()
  {
    return this.b;
  }
  
  public boolean isDayTime()
  {
    if (this.b == null) {
      return true;
    }
    String str1 = this.b.k.j();
    String str2 = this.b.k.k();
    if (this.p.d())
    {
      int i1 = this.b.k.n();
      return r.a(str1, str2, this.p.b(i1));
    }
    return r.a(str1, str2);
  }
  
  public boolean isEmptyCity()
  {
    return TextUtils.isEmpty(getCityId());
  }
  
  public void notifyLanguageChanged()
  {
    if (this.b == null) {
      setTip(this.a.getString(2131166455));
    }
  }
  
  public void onApplyTheme(a parama)
  {
    this.k = parama;
    Object localObject1 = this.k.c[0];
    try
    {
      localObject1 = c.a(this.k.b, (String)localObject1, this.k.a);
      if (localObject1 != null)
      {
        localObject1 = GLDrawable.getDrawable((Drawable)localObject1);
        this.i.setWeather((GLDrawable)localObject1, false);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;) {}
    }
    localObject1 = this.k.a("gw_weather_41_temp_minus");
    localObject1 = c.a(this.k.b, (String)localObject1, this.k.a);
    this.e.setImageDrawable((Drawable)localObject1);
    this.f.setImageDrawable((Drawable)localObject1);
    this.c.setImageDrawable((Drawable)localObject1);
    parama.a("gw_weather_41_time_divider");
    if (this.q.mSettings.a == 1) {
      localObject1 = this.k.a("gw_weather_41_temp_unit_celsius");
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.k.a("gw_weather_41_temp_unit");
      }
      this.g.setImageDrawable(c.a(this.k.b, (String)localObject2, this.k.a));
      a(c.b(this.k.b, parama.a("gw_weather_41_txt_selector"), this.k.a));
      try
      {
        a(c.a(this.k.a("gw_weather_41_txt_shadow_color"), 16777215), Float.parseFloat(this.k.a("gw_weather_41_txt_shadow_dx")), Float.parseFloat(this.k.a("gw_weather_41_txt_shadow_dy")), Float.parseFloat(this.k.a("gw_weather_41_txt_shadow_radius")));
        showWeatherInfo(false);
        return;
        localObject1 = this.k.a("gw_weather_41_temp_unit_fahrenheit");
      }
      catch (NumberFormatException parama)
      {
        for (;;)
        {
          parama.printStackTrace();
        }
      }
    }
  }
  
  public void onClick(GLView paramGLView)
  {
    if ((paramGLView.equals(this.i)) || (paramGLView.equals(this.j)) || (paramGLView.equals(this.h))) {
      this.q.gotoWeatherDetail(getCityId());
    }
  }
  
  public boolean onLongClick(GLView paramGLView)
  {
    performLongClick();
    return true;
  }
  
  public void setIndex(int paramInt)
  {
    this.b.e(paramInt);
  }
  
  public void setMyLocation(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public void setThemeBean(a parama)
  {
    this.k = parama;
  }
  
  public void setTimeManager(g paramg)
  {
    this.p = paramg;
  }
  
  public void setTip(String paramString)
  {
    this.h.setText(paramString);
  }
  
  public void setWeatherBean(WeatherBean paramWeatherBean)
  {
    Object localObject;
    if (paramWeatherBean != null)
    {
      this.b = paramWeatherBean;
      localObject = paramWeatherBean.k.j();
      paramWeatherBean = paramWeatherBean.k.k();
      if ((!r.a((String)localObject)) || (!r.a(paramWeatherBean))) {}
    }
    else
    {
      try
      {
        localObject = ((String)localObject).split(":");
        this.l = Integer.parseInt(localObject[0]);
        this.m = Integer.parseInt(localObject[1]);
        paramWeatherBean = paramWeatherBean.split(":");
        this.n = Integer.parseInt(paramWeatherBean[0]);
        this.o = Integer.parseInt(paramWeatherBean[1]);
        return;
      }
      catch (Exception paramWeatherBean)
      {
        paramWeatherBean.printStackTrace();
        return;
      }
    }
    this.l = 6;
    this.m = 0;
    this.n = 18;
    this.o = 0;
  }
  
  public void setWidgetView(GLWeatherWidget21 paramGLWeatherWidget21)
  {
    this.q = paramGLWeatherWidget21;
  }
  
  public void showCity()
  {
    this.h.setText(this.b.d());
  }
  
  public void showTemp(int paramInt)
  {
    if (this.b == null) {
      return;
    }
    showTempNow(this.b.k.a(this.q.mSettings.a));
  }
  
  public void showTempNow(float paramFloat)
  {
    if (paramFloat == -10000.0F)
    {
      localObject1 = this.k.a("gw_weather_41_temp_minus");
      localObject1 = c.a(this.k.b, (String)localObject1, this.k.a);
      this.c.setVisibility(8);
      this.d.setVisibility(8);
      this.e.setVisibility(0);
      this.f.setVisibility(0);
      this.e.setImageDrawable((Drawable)localObject1);
      this.f.setImageDrawable((Drawable)localObject1);
      return;
    }
    int i1 = q.a(paramFloat);
    int i2;
    label133:
    int i3;
    if (i1 < 0)
    {
      this.c.setVisibility(0);
      i1 = Math.abs(i1);
      i2 = i1 / 100;
      if (i2 != 0) {
        break label282;
      }
      this.d.setVisibility(8);
      i3 = (i1 - i2 * 100) / 10;
      if ((i3 != 0) || (i2 != 0)) {
        break label323;
      }
      this.e.setVisibility(8);
      label162:
      this.f.setImageDrawable(c.a(this.k.b, a(i1 % 10, false), this.k.a));
      if (this.q.mSettings.a != 1) {
        break label365;
      }
    }
    label282:
    label323:
    label365:
    for (Object localObject1 = this.k.a("gw_weather_41_temp_unit_celsius");; localObject1 = this.k.a("gw_weather_41_temp_unit_fahrenheit"))
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.k.a("gw_weather_41_temp_unit");
      }
      this.g.setImageDrawable(c.a(this.k.b, (String)localObject2, this.k.a));
      return;
      this.c.setVisibility(8);
      break;
      this.d.setImageDrawable(c.a(this.k.b, a(i2, false), this.k.a));
      this.d.setVisibility(0);
      break label133;
      this.e.setImageDrawable(c.a(this.k.b, a(i3, false), this.k.a));
      this.e.setVisibility(0);
      break label162;
    }
  }
  
  public void showWeatherInfo(boolean paramBoolean)
  {
    if (this.b == null) {
      return;
    }
    showCity();
    Object localObject = this.k.c[0];
    boolean bool = isDayTime();
    switch (this.b.k.d())
    {
    default: 
      localObject = this.k.c[0];
    }
    for (;;)
    {
      localObject = c.a(this.k.b, (String)localObject, this.k.a);
      if (localObject != null) {
        this.i.setWeather(GLDrawable.getDrawable((Drawable)localObject), paramBoolean);
      }
      showTempNow(this.b.k.a(this.q.mSettings.a));
      return;
      if (bool)
      {
        localObject = this.k.c[1];
      }
      else
      {
        localObject = this.k.c[2];
        continue;
        if (bool)
        {
          localObject = this.k.c[3];
        }
        else
        {
          localObject = this.k.c[4];
          continue;
          localObject = this.k.c[5];
          continue;
          localObject = this.k.c[6];
          continue;
          localObject = this.k.c[7];
          continue;
          localObject = this.k.c[8];
          continue;
          localObject = this.k.c[9];
        }
      }
    }
  }
  
  public void updateAllViews()
  {
    showWeatherInfo(true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/GLWeather21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */