package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.f.c;
import com.gau.go.launcherex.gowidget.weather.f.f;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.WidgetSettingBean;
import com.gau.go.launcherex.gowidget.weather.util.q;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.GoWidgetDynamicIconView;
import com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a.b;
import com.jiubang.core.a.l;
import java.util.HashMap;

public class bk
  extends dg
  implements View.OnClickListener, View.OnLongClickListener, b
{
  private WeatherBean a = null;
  private ImageView d = null;
  private ImageView e = null;
  private ImageView f = null;
  private ImageView g = null;
  private ImageView h = null;
  private TextView i = null;
  private GoWidgetDynamicIconView j = null;
  private LinearLayout k = null;
  private int l = 1;
  private com.gau.go.launcherex.gowidget.weather.f.a m = null;
  private int n;
  private int o;
  private int p;
  private int q;
  private g r = null;
  private WeatherWidget21 s;
  
  public bk(Context paramContext)
  {
    super(paramContext, dh.a);
    a(paramContext);
    j();
  }
  
  private String a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String[] arrayOfString = this.m.d;; arrayOfString = this.m.e)
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
    this.i.setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
  }
  
  private void a(Context paramContext)
  {
    this.m = new com.gau.go.launcherex.gowidget.weather.f.a();
    this.m.a = paramContext.getPackageName();
    this.m.b = paramContext.getResources();
    this.m.d = new String[] { "gw_weather_42_time_num0_w", "gw_weather_42_time_num1_w", "gw_weather_42_time_num2_w", "gw_weather_42_time_num3_w", "gw_weather_42_time_num4_w", "gw_weather_42_time_num5_w", "gw_weather_42_time_num6_w", "gw_weather_42_time_num7_w", "gw_weather_42_time_num8_w", "gw_weather_42_time_num9_w" };
    this.m.e = new String[] { "gw_weather_42_temp_num0_w", "gw_weather_42_temp_num1_w", "gw_weather_42_temp_num2_w", "gw_weather_42_temp_num3_w", "gw_weather_42_temp_num4_w", "gw_weather_42_temp_num5_w", "gw_weather_42_temp_num6_w", "gw_weather_42_temp_num7_w", "gw_weather_42_temp_num8_w", "gw_weather_42_temp_num9_w" };
    this.m.c = new String[] { "gowidget_42_weather_na", "gowidget_42_weather_sunny_day", "gowidget_42_weather_sunny_night", "gowidget_42_weather_cloudy_day", "gowidget_42_weather_cloudy_night", "gowidget_42_weather_overcast", "gowidget_42_weather_snowy", "gowidget_42_weather_foggy", "gowidget_42_weather_rainy", "gowidget_42_weather_thunderstorm" };
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
    this.m.a(paramContext);
  }
  
  private void a(ColorStateList paramColorStateList)
  {
    this.i.setTextColor(paramColorStateList);
  }
  
  private void a(boolean paramBoolean)
  {
    String str = this.m.c[0];
    boolean bool = i();
    Object localObject = str;
    if (this.a != null) {
      switch (this.a.k.d())
      {
      default: 
        localObject = str;
      }
    }
    for (;;)
    {
      localObject = c.a(this.m.b, (String)localObject, this.m.a);
      if (localObject != null)
      {
        localObject = f.a((Drawable)localObject);
        if (localObject != null) {
          this.j.a((Bitmap)localObject, paramBoolean);
        }
      }
      return;
      if (bool)
      {
        localObject = this.m.c[1];
      }
      else
      {
        localObject = this.m.c[2];
        continue;
        if (bool)
        {
          localObject = this.m.c[3];
        }
        else
        {
          localObject = this.m.c[4];
          continue;
          localObject = this.m.c[5];
          continue;
          localObject = this.m.c[6];
          continue;
          localObject = this.m.c[7];
          continue;
          localObject = this.m.c[8];
          continue;
          localObject = this.m.c[9];
        }
      }
    }
  }
  
  private void j()
  {
    this.d = ((ImageView)findViewById(2131231990));
    this.e = ((ImageView)findViewById(2131231991));
    this.f = ((ImageView)findViewById(2131231992));
    this.g = ((ImageView)findViewById(2131231993));
    this.h = ((ImageView)findViewById(2131231994));
    this.i = ((TextView)findViewById(2131231995));
    this.j = ((GoWidgetDynamicIconView)findViewById(2131231987));
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), 2130838042);
      this.j.a(localBitmap, false);
      this.k = ((LinearLayout)findViewById(2131231989));
      k();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;) {}
    }
  }
  
  private void k()
  {
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.i.setOnLongClickListener(this);
    this.j.setOnLongClickListener(this);
    this.k.setOnLongClickListener(this);
  }
  
  public int a()
  {
    return 2130903327;
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat == -10000.0F)
    {
      localObject1 = this.m.a("gw_weather_41_temp_minus");
      localObject1 = c.a(this.m.b, (String)localObject1, this.m.a);
      this.d.setVisibility(8);
      this.e.setVisibility(8);
      this.f.setVisibility(0);
      this.g.setVisibility(0);
      this.f.setImageDrawable((Drawable)localObject1);
      this.g.setImageDrawable((Drawable)localObject1);
      return;
    }
    int i1 = q.a(paramFloat);
    int i2;
    label133:
    int i3;
    if (i1 < 0)
    {
      this.d.setVisibility(0);
      i1 = Math.abs(i1);
      i2 = i1 / 100;
      if (i2 != 0) {
        break label276;
      }
      this.e.setVisibility(8);
      i3 = (i1 - i2 * 100) / 10;
      if ((i3 != 0) || (i2 != 0)) {
        break label317;
      }
      this.f.setVisibility(8);
      label162:
      this.g.setImageDrawable(c.a(this.m.b, a(i1 % 10, false), this.m.a));
      if (this.l != 1) {
        break label359;
      }
    }
    label276:
    label317:
    label359:
    for (Object localObject1 = this.m.a("gw_weather_41_temp_unit_celsius");; localObject1 = this.m.a("gw_weather_41_temp_unit_fahrenheit"))
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.m.a("gw_weather_41_temp_unit");
      }
      this.h.setImageDrawable(c.a(this.m.b, (String)localObject2, this.m.a));
      return;
      this.d.setVisibility(8);
      break;
      this.e.setImageDrawable(c.a(this.m.b, a(i2, false), this.m.a));
      this.e.setVisibility(0);
      break label133;
      this.f.setImageDrawable(c.a(this.m.b, a(i3, false), this.m.a));
      this.f.setVisibility(0);
      break label162;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.a == null) {
      return;
    }
    this.l = paramInt;
    a(this.a.k.a(this.l));
  }
  
  public void a(g paramg)
  {
    this.r = paramg;
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.f.a parama)
  {
    this.m = parama;
    Object localObject1 = this.m.c[0];
    localObject1 = c.a(this.m.b, (String)localObject1, this.m.a);
    if (localObject1 != null)
    {
      localObject1 = f.a((Drawable)localObject1);
      if (localObject1 != null) {
        this.j.a((Bitmap)localObject1, false);
      }
    }
    localObject1 = this.m.a("gw_weather_41_temp_minus");
    localObject1 = c.a(this.m.b, (String)localObject1, this.m.a);
    this.f.setImageDrawable((Drawable)localObject1);
    this.g.setImageDrawable((Drawable)localObject1);
    this.d.setImageDrawable((Drawable)localObject1);
    parama.a("gw_weather_41_time_divider");
    if (this.l == 1) {
      localObject1 = this.m.a("gw_weather_41_temp_unit_celsius");
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.m.a("gw_weather_41_temp_unit");
      }
      this.h.setImageDrawable(c.a(this.m.b, (String)localObject2, this.m.a));
      a(c.b(this.m.b, parama.a("gw_weather_41_txt_selector"), this.m.a));
      try
      {
        a(c.a(this.m.a("gw_weather_41_txt_shadow_color"), 16777215), Float.parseFloat(this.m.a("gw_weather_41_txt_shadow_dx")), Float.parseFloat(this.m.a("gw_weather_41_txt_shadow_dy")), Float.parseFloat(this.m.a("gw_weather_41_txt_shadow_radius")));
        a(null, false, false, false);
        return;
        localObject1 = this.m.a("gw_weather_41_temp_unit_fahrenheit");
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
  
  public void a(WeatherBean paramWeatherBean)
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
        this.n = Integer.parseInt(localObject[0]);
        this.o = Integer.parseInt(localObject[1]);
        paramWeatherBean = paramWeatherBean.split(":");
        this.p = Integer.parseInt(paramWeatherBean[0]);
        this.q = Integer.parseInt(paramWeatherBean[1]);
        return;
      }
      catch (Exception paramWeatherBean)
      {
        paramWeatherBean.printStackTrace();
        return;
      }
    }
    this.n = 6;
    this.o = 0;
    this.p = 18;
    this.q = 0;
  }
  
  public void a(WeatherWidget21 paramWeatherWidget21)
  {
    this.s = paramWeatherWidget21;
  }
  
  public void a(b paramb, l paraml, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paraml != null)
    {
      if (this.a != null) {
        if (this.a.k.d() == paramInt) {
          this.j.a(paraml, paramBoolean2);
        }
      }
      while (paramInt != 1) {
        return;
      }
      this.j.a(paraml, paramBoolean2);
      return;
    }
    a(paramBoolean2);
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.a == null) {
      return;
    }
    e();
    c(parama, paramBoolean1, paramBoolean2, paramBoolean3);
    a(this.a.k.a(this.l));
  }
  
  public void a(String paramString)
  {
    this.i.setText(paramString);
  }
  
  public void b(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void b(com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.a == null) {}
    int i1;
    int i2;
    do
    {
      return;
      Time localTime = h();
      i1 = localTime.hour;
      i2 = localTime.minute;
    } while (((i1 != this.n) || (i2 != this.o)) && ((i1 != this.p) || (i2 != this.q)));
    a(parama, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public boolean b()
  {
    return TextUtils.isEmpty(c());
  }
  
  public String c()
  {
    if (this.a != null) {
      return this.a.c();
    }
    return null;
  }
  
  public void c(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void c(com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = this.m.c[0];
    boolean bool = i();
    int i1;
    if (this.a != null)
    {
      i1 = this.a.k.d();
      switch (this.a.k.d())
      {
      }
    }
    for (;;)
    {
      localObject = c.a(this.m.b, (String)localObject, this.m.a);
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
            localObject = this.m.c[1];
            break;
          }
          localObject = this.m.c[2];
          break;
          if (bool)
          {
            localObject = this.m.c[3];
            break;
          }
          localObject = this.m.c[4];
          break;
          localObject = this.m.c[5];
          break;
          localObject = this.m.c[6];
          break;
          localObject = this.m.c[7];
          break;
          localObject = this.m.c[8];
          break;
          localObject = this.m.c[9];
          break;
          this.j.a((l)localObject, true);
          return;
        } while (localObject == null);
        parama = f.a((Drawable)localObject);
      } while (parama == null);
      this.j.a(parama, paramBoolean3);
      return;
      i1 = 1;
    }
  }
  
  public WeatherBean d()
  {
    return this.a;
  }
  
  public void e()
  {
    this.i.setText(this.a.d());
  }
  
  public void f()
  {
    a(null, this.s.b, this.s.c.g, true);
  }
  
  public int g()
  {
    return this.a.e();
  }
  
  public Time h()
  {
    if (this.a != null)
    {
      int i1 = this.a.k.n();
      return this.r.b(i1);
    }
    return this.r.c();
  }
  
  public boolean i()
  {
    if (this.a == null) {
      return true;
    }
    String str1 = this.a.k.j();
    String str2 = this.a.k.k();
    if (this.r.d())
    {
      int i1 = this.a.k.n();
      return r.a(str1, str2, this.r.b(i1));
    }
    return r.a(str1, str2);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.equals(this.j)) || (paramView.equals(this.k)) || (paramView.equals(this.i)) || (paramView.equals(this.k)) || (paramView.equals(this.i))) {
      this.s.gotoWeatherDetail(c());
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    performLongClick();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */