package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.format.Time;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.f.a;
import com.gau.go.launcherex.gowidget.weather.f.b;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.WidgetSettingBean;
import com.gau.go.launcherex.gowidget.weather.util.q;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gau.go.launcherex.gowidget.weather.view.dh;
import com.go.gl.graphics.GLDrawable;
import com.go.gl.view.GLView;
import com.go.gl.view.GLView.OnClickListener;
import com.go.gl.view.GLView.OnLongClickListener;
import com.go.gl.widget.GLImageView;
import com.go.gl.widget.GLTextViewWrapper;
import java.util.HashMap;

public class GLWeather11
  extends GLWidgetChildView
  implements GLView.OnClickListener, GLView.OnLongClickListener
{
  private WeatherBean a = null;
  private GLTextViewWrapper b;
  private GLImageView c;
  private GLImageView d;
  private GLImageView e;
  private GLImageView f;
  private GLImageView g;
  private GLView h;
  private GLWeatherLouverView i = null;
  private a j = null;
  private int k;
  private int l;
  private int m;
  private int n;
  private g o = null;
  private GLWeatherWidget11 p;
  
  public GLWeather11(Context paramContext)
  {
    super(paramContext, dh.a);
    a();
    a(paramContext);
  }
  
  private String a(int paramInt)
  {
    String str = this.j.e[0];
    switch (paramInt)
    {
    default: 
      return str;
    case 0: 
      return this.j.e[0];
    case 1: 
      return this.j.e[1];
    case 2: 
      return this.j.e[2];
    case 3: 
      return this.j.e[3];
    case 4: 
      return this.j.e[4];
    case 5: 
      return this.j.e[5];
    case 6: 
      return this.j.e[6];
    case 7: 
      return this.j.e[7];
    case 8: 
      return this.j.e[8];
    }
    return this.j.e[9];
  }
  
  private void a()
  {
    this.b = ((GLTextViewWrapper)findViewById(2131231761));
    this.h = findViewById(2131231981);
    this.c = ((GLImageView)findViewById(2131231982));
    this.d = ((GLImageView)findViewById(2131231983));
    this.e = ((GLImageView)findViewById(2131231984));
    this.f = ((GLImageView)findViewById(2131231985));
    this.g = ((GLImageView)findViewById(2131231986));
    this.i = ((GLWeatherLouverView)findViewById(2131231979));
    try
    {
      GLDrawable localGLDrawable = GLDrawable.getDrawable(getResources(), 2130838042);
      this.i.setWeather(localGLDrawable, false);
      b();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;) {}
    }
  }
  
  private void a(Context paramContext)
  {
    this.j = new a();
    this.j.a = paramContext.getPackageName();
    this.j.b = paramContext.getResources();
    this.j.e = new String[] { "gw_weather_42_temp_num0_w", "gw_weather_42_temp_num1_w", "gw_weather_42_temp_num2_w", "gw_weather_42_temp_num3_w", "gw_weather_42_temp_num4_w", "gw_weather_42_temp_num5_w", "gw_weather_42_temp_num6_w", "gw_weather_42_temp_num7_w", "gw_weather_42_temp_num8_w", "gw_weather_42_temp_num9_w" };
    this.j.c = new String[] { "gowidget_42_weather_na", "gowidget_42_weather_sunny_day", "gowidget_42_weather_sunny_night", "gowidget_42_weather_cloudy_day", "gowidget_42_weather_cloudy_night", "gowidget_42_weather_overcast", "gowidget_42_weather_snowy", "gowidget_42_weather_foggy", "gowidget_42_weather_rainy", "gowidget_42_weather_thunderstorm" };
    paramContext = new HashMap();
    paramContext.put("gw_weather_11_temp_minus", "gw_weather_42_temp_minus_w");
    paramContext.put("gw_weather_11_temp_unit", "gw_weather_42_temp_unit_w");
    paramContext.put("gw_weather_11_temp_unit_celsius", "widget_l_temp_centigrade_w");
    paramContext.put("gw_weather_11_temp_unit_fahrenheit", "widget_l_temp_fahrenheit_w");
    paramContext.put("gw_weather_11_txt_shadow_color", "#66FFFFFF");
    paramContext.put("gw_weather_11_txt_shadow_dx", "0");
    paramContext.put("gw_weather_11_txt_shadow_dy", "1");
    paramContext.put("gw_weather_11_txt_shadow_radius", "1");
    this.j.a(paramContext);
  }
  
  private void b()
  {
    this.b.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.b.setOnLongClickListener(this);
    this.i.setOnLongClickListener(this);
    this.h.setOnLongClickListener(this);
  }
  
  private void c()
  {
    setOnClickListener(null);
    setOnLongClickListener(null);
    unSetComponentOnClickListener(this.b);
    unSetComponentOnClickListener(this.i);
    unSetComponentOnClickListener(this.h);
    unSetComponentOnLongClickListener(this.b);
    unSetComponentOnLongClickListener(this.i);
    unSetComponentOnLongClickListener(this.h);
  }
  
  public void checkToUpdateWeatherIcon()
  {
    if (this.a == null) {}
    int i1;
    int i2;
    do
    {
      return;
      Time localTime = getCityTime();
      i1 = localTime.hour;
      i2 = localTime.minute;
    } while (((i1 != this.k) || (i2 != this.l)) && ((i1 != this.m) || (i2 != this.n)));
    showWeatherInfo(true);
  }
  
  public void cleanup()
  {
    super.cleanup();
    c();
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
      int i1 = this.a.k.n();
      return this.o.b(i1);
    }
    return this.o.c();
  }
  
  public int getContentViewLayoutId()
  {
    return 2130903324;
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
    if (this.o.d())
    {
      int i1 = this.a.k.n();
      return r.a(str1, str2, this.o.b(i1));
    }
    return r.a(str1, str2);
  }
  
  public boolean isEmptyCity()
  {
    return TextUtils.isEmpty(getCityId());
  }
  
  public void notifyLanguageChanged()
  {
    if (this.a == null) {
      setTip(this.mContext.getString(2131166455));
    }
  }
  
  public void onApplyTheme(a parama)
  {
    this.j = parama;
    Object localObject1 = parama.c[0];
    localObject1 = this.j.c[0];
    try
    {
      localObject1 = b.a(this.j.b, (String)localObject1, this.j.a);
      if (localObject1 != null)
      {
        localObject1 = GLDrawable.getDrawable((Drawable)localObject1);
        this.i.setWeather((GLDrawable)localObject1, false);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      int i1;
      for (;;) {}
    }
    localObject1 = parama.a("gw_weather_11_txt_color");
    if (localObject1 != null)
    {
      i1 = b.a((String)localObject1, -1);
      this.b.setTextColor(i1);
    }
    localObject1 = parama.a("gw_weather_11_txt_selector");
    if (localObject1 != null)
    {
      localObject1 = b.b(this.j.b, (String)localObject1, this.j.a);
      this.b.getTextView().setTextColor((ColorStateList)localObject1);
    }
    try
    {
      i1 = b.a(parama.a("gw_weather_11_txt_shadow_color"), 16777215);
      float f1 = Float.parseFloat(parama.a("gw_weather_11_txt_shadow_dx"));
      float f2 = Float.parseFloat(parama.a("gw_weather_11_txt_shadow_dy"));
      float f3 = Float.parseFloat(parama.a("gw_weather_11_txt_shadow_radius"));
      this.b.getTextView().setShadowLayer(f3, f1, f2, i1);
      if (this.p.mSettings.a == 1)
      {
        localObject1 = this.j.a("gw_weather_11_temp_unit_celsius");
        Object localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = this.j.a("gw_weather_11_temp_unit");
        }
        this.g.setImageDrawable(b.a(this.j.b, (String)localObject2, this.j.a));
        localObject1 = parama.a("gw_weather_11_temp_minus");
        parama = b.a(parama.b, (String)localObject1, parama.a);
        this.c.setImageDrawable(parama);
        this.e.setImageDrawable(parama);
        this.f.setImageDrawable(parama);
        showWeatherInfo(false);
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
        continue;
        String str = this.j.a("gw_weather_11_temp_unit_fahrenheit");
      }
    }
  }
  
  public void onClick(GLView paramGLView)
  {
    if ((paramGLView.equals(this.b)) || (paramGLView.equals(this.i)) || (paramGLView.equals(this.h))) {
      this.p.gotoWeatherDetail(getCityId());
    }
  }
  
  public boolean onLongClick(GLView paramGLView)
  {
    performLongClick();
    return true;
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
    this.j = parama;
  }
  
  public void setTimeManager(g paramg)
  {
    this.o = paramg;
  }
  
  public void setTip(String paramString)
  {
    this.b.setText(paramString);
  }
  
  public void setWeatherBean(WeatherBean paramWeatherBean)
  {
    Object localObject;
    if (paramWeatherBean != null)
    {
      this.a = paramWeatherBean;
      localObject = paramWeatherBean.k.j();
      paramWeatherBean = paramWeatherBean.k.k();
      if ((!r.a((String)localObject)) || (!r.a(paramWeatherBean))) {}
    }
    else
    {
      try
      {
        localObject = ((String)localObject).split(":");
        this.k = Integer.parseInt(localObject[0]);
        this.l = Integer.parseInt(localObject[1]);
        paramWeatherBean = paramWeatherBean.split(":");
        this.m = Integer.parseInt(paramWeatherBean[0]);
        this.n = Integer.parseInt(paramWeatherBean[1]);
        return;
      }
      catch (Exception paramWeatherBean)
      {
        paramWeatherBean.printStackTrace();
        return;
      }
    }
    this.k = 6;
    this.l = 0;
    this.m = 18;
    this.n = 0;
  }
  
  public void setWidgetView(GLWeatherWidget11 paramGLWeatherWidget11)
  {
    this.p = paramGLWeatherWidget11;
  }
  
  public void showCity()
  {
    this.b.setText(this.a.d());
  }
  
  public void showTemp(int paramInt)
  {
    if (this.a == null) {
      return;
    }
    float f1 = this.a.k.a(this.p.mSettings.a);
    if (f1 != -10000.0F)
    {
      showTempNow(q.a(f1));
      return;
    }
    Object localObject = this.j.a("gw_weather_11_temp_minus");
    localObject = b.a(this.j.b, (String)localObject, this.j.a);
    this.d.setImageDrawable((Drawable)localObject);
    this.e.setImageDrawable((Drawable)localObject);
    this.f.setImageDrawable((Drawable)localObject);
  }
  
  public void showTempNow(int paramInt)
  {
    int i1;
    label35:
    int i2;
    if (paramInt < 0)
    {
      this.c.setVisibility(0);
      paramInt = Math.abs(paramInt);
      i1 = paramInt / 100;
      if (i1 != 0) {
        break label181;
      }
      this.d.setVisibility(8);
      i2 = (paramInt - i1 * 100) / 10;
      if ((i2 != 0) || (i1 != 0)) {
        break label221;
      }
      this.e.setVisibility(8);
      label62:
      this.f.setImageDrawable(b.a(this.j.b, a(paramInt % 10), this.j.a));
      if (this.p.mSettings.a != 1) {
        break label261;
      }
    }
    label181:
    label221:
    label261:
    for (String str1 = this.j.a("gw_weather_11_temp_unit_celsius");; str1 = this.j.a("gw_weather_11_temp_unit_fahrenheit"))
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1)) {
        str2 = this.j.a("gw_weather_11_temp_unit");
      }
      this.g.setImageDrawable(b.a(this.j.b, str2, this.j.a));
      return;
      this.c.setVisibility(8);
      break;
      this.d.setImageDrawable(b.a(this.j.b, a(i1), this.j.a));
      this.d.setVisibility(0);
      break label35;
      this.e.setImageDrawable(b.a(this.j.b, a(i2), this.j.a));
      this.e.setVisibility(0);
      break label62;
    }
  }
  
  public void showWeatherInfo(boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    showCity();
    Object localObject = this.j.c[0];
    boolean bool = isDayTime();
    switch (this.a.k.d())
    {
    default: 
      localObject = this.j.c[0];
    }
    for (;;)
    {
      localObject = b.a(this.j.b, (String)localObject, this.j.a);
      if (localObject != null) {
        this.i.setWeather(GLDrawable.getDrawable((Drawable)localObject), paramBoolean);
      }
      showTemp(this.p.mSettings.a);
      return;
      if (bool)
      {
        localObject = this.j.c[1];
      }
      else
      {
        localObject = this.j.c[2];
        continue;
        if (bool)
        {
          localObject = this.j.c[3];
        }
        else
        {
          localObject = this.j.c[4];
          continue;
          localObject = this.j.c[5];
          continue;
          localObject = this.j.c[6];
          continue;
          localObject = this.j.c[7];
          continue;
          localObject = this.j.c[8];
          continue;
          localObject = this.j.c[9];
        }
      }
    }
  }
  
  public void updateAllViews()
  {
    showWeatherInfo(true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/GLWeather11.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */