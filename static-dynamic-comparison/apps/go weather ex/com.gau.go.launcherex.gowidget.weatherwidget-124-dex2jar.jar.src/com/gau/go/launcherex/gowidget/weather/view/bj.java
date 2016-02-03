package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.f.f;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.WidgetSettingBean;
import com.gau.go.launcherex.gowidget.weather.util.q;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.GoWidgetDynamicIconView;
import com.jiubang.core.a.l;
import java.util.HashMap;

public class bj
  extends dg
  implements View.OnClickListener, View.OnLongClickListener, com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a.b
{
  private WeatherBean a = null;
  private TextView d;
  private ImageView e;
  private ImageView f;
  private ImageView g;
  private ImageView h;
  private ImageView i;
  private View j;
  private GoWidgetDynamicIconView k = null;
  private int l = 1;
  private com.gau.go.launcherex.gowidget.weather.f.a m = null;
  private int n;
  private int o;
  private int p;
  private int q;
  private g r = null;
  private WeatherWidget11 s;
  
  public bj(Context paramContext)
  {
    super(paramContext, dh.a);
    a(paramContext);
    h();
  }
  
  private void a(Context paramContext)
  {
    this.m = new com.gau.go.launcherex.gowidget.weather.f.a();
    this.m.a = paramContext.getPackageName();
    this.m.b = paramContext.getResources();
    this.m.e = new String[] { "gw_weather_42_temp_num0_w", "gw_weather_42_temp_num1_w", "gw_weather_42_temp_num2_w", "gw_weather_42_temp_num3_w", "gw_weather_42_temp_num4_w", "gw_weather_42_temp_num5_w", "gw_weather_42_temp_num6_w", "gw_weather_42_temp_num7_w", "gw_weather_42_temp_num8_w", "gw_weather_42_temp_num9_w" };
    this.m.c = new String[] { "gowidget_42_weather_na", "gowidget_42_weather_sunny_day", "gowidget_42_weather_sunny_night", "gowidget_42_weather_cloudy_day", "gowidget_42_weather_cloudy_night", "gowidget_42_weather_overcast", "gowidget_42_weather_snowy", "gowidget_42_weather_foggy", "gowidget_42_weather_rainy", "gowidget_42_weather_thunderstorm" };
    paramContext = new HashMap();
    paramContext.put("gw_weather_11_temp_minus", "gw_weather_42_temp_minus_w");
    paramContext.put("gw_weather_11_temp_unit", "gw_weather_42_temp_unit_w");
    paramContext.put("gw_weather_11_temp_unit_celsius", "widget_l_temp_centigrade_w");
    paramContext.put("gw_weather_11_temp_unit_fahrenheit", "widget_l_temp_fahrenheit_w");
    paramContext.put("gw_weather_11_txt_shadow_color", "#66FFFFFF");
    paramContext.put("gw_weather_11_txt_shadow_dx", "0");
    paramContext.put("gw_weather_11_txt_shadow_dy", "1");
    paramContext.put("gw_weather_11_txt_shadow_radius", "1");
    this.m.a(paramContext);
  }
  
  private void a(boolean paramBoolean)
  {
    String str = this.m.c[0];
    boolean bool = g();
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
      localObject = com.gau.go.launcherex.gowidget.weather.f.b.a(this.m.b, (String)localObject, this.m.a);
      if (localObject != null)
      {
        localObject = f.a((Drawable)localObject);
        if (localObject != null) {
          this.k.a((Bitmap)localObject, paramBoolean);
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
  
  private String e(int paramInt)
  {
    String str = this.m.e[0];
    switch (paramInt)
    {
    default: 
      return str;
    case 0: 
      return this.m.e[0];
    case 1: 
      return this.m.e[1];
    case 2: 
      return this.m.e[2];
    case 3: 
      return this.m.e[3];
    case 4: 
      return this.m.e[4];
    case 5: 
      return this.m.e[5];
    case 6: 
      return this.m.e[6];
    case 7: 
      return this.m.e[7];
    case 8: 
      return this.m.e[8];
    }
    return this.m.e[9];
  }
  
  private void h()
  {
    this.d = ((TextView)findViewById(2131231761));
    this.j = findViewById(2131231981);
    this.e = ((ImageView)findViewById(2131231982));
    this.f = ((ImageView)findViewById(2131231983));
    this.g = ((ImageView)findViewById(2131231984));
    this.h = ((ImageView)findViewById(2131231985));
    this.i = ((ImageView)findViewById(2131231986));
    this.k = ((GoWidgetDynamicIconView)findViewById(2131231979));
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), 2130838042);
      this.k.a(localBitmap, false);
      i();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;) {}
    }
  }
  
  private void i()
  {
    this.d.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.d.setOnLongClickListener(this);
    this.k.setOnLongClickListener(this);
    this.j.setOnLongClickListener(this);
  }
  
  private void j()
  {
    this.d.setText(this.a.d());
  }
  
  public int a()
  {
    return 2130903323;
  }
  
  public void a(int paramInt)
  {
    if (this.a == null) {
      return;
    }
    this.l = paramInt;
    float f1 = this.a.k.a(this.l);
    if (f1 != -10000.0F)
    {
      b(q.a(f1));
      return;
    }
    Object localObject = this.m.a("gw_weather_11_temp_minus");
    localObject = com.gau.go.launcherex.gowidget.weather.f.b.a(this.m.b, (String)localObject, this.m.a);
    this.f.setImageDrawable((Drawable)localObject);
    this.g.setImageDrawable((Drawable)localObject);
    this.h.setImageDrawable((Drawable)localObject);
  }
  
  public void a(g paramg)
  {
    this.r = paramg;
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.f.a parama)
  {
    this.m = parama;
    Object localObject1 = parama.c[0];
    localObject1 = com.gau.go.launcherex.gowidget.weather.f.b.a(parama.b, (String)localObject1, parama.a);
    if (localObject1 != null)
    {
      localObject1 = f.a((Drawable)localObject1);
      if (localObject1 != null) {
        this.k.a((Bitmap)localObject1, false);
      }
    }
    localObject1 = parama.a("gw_weather_11_txt_color");
    int i1;
    if (localObject1 != null)
    {
      i1 = com.gau.go.launcherex.gowidget.weather.f.b.a((String)localObject1, -1);
      this.d.setTextColor(i1);
    }
    localObject1 = parama.a("gw_weather_11_txt_selector");
    if (localObject1 != null)
    {
      localObject1 = com.gau.go.launcherex.gowidget.weather.f.b.b(this.m.b, (String)localObject1, this.m.a);
      this.d.setTextColor((ColorStateList)localObject1);
    }
    try
    {
      i1 = com.gau.go.launcherex.gowidget.weather.f.b.a(parama.a("gw_weather_11_txt_shadow_color"), 16777215);
      float f1 = Float.parseFloat(parama.a("gw_weather_11_txt_shadow_dx"));
      float f2 = Float.parseFloat(parama.a("gw_weather_11_txt_shadow_dy"));
      float f3 = Float.parseFloat(parama.a("gw_weather_11_txt_shadow_radius"));
      this.d.setShadowLayer(f3, f1, f2, i1);
      if (this.l == 1)
      {
        localObject1 = this.m.a("gw_weather_11_temp_unit_celsius");
        Object localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = this.m.a("gw_weather_11_temp_unit");
        }
        this.i.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.b.a(this.m.b, (String)localObject2, this.m.a));
        localObject1 = parama.a("gw_weather_11_temp_minus");
        parama = com.gau.go.launcherex.gowidget.weather.f.b.a(parama.b, (String)localObject1, parama.a);
        this.e.setImageDrawable(parama);
        this.g.setImageDrawable(parama);
        this.h.setImageDrawable(parama);
        a(null, false, false, false);
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
        continue;
        String str = this.m.a("gw_weather_11_temp_unit_fahrenheit");
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
  
  public void a(WeatherWidget11 paramWeatherWidget11)
  {
    this.s = paramWeatherWidget11;
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a.b paramb, l paraml, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paraml != null)
    {
      if (this.a != null) {
        if (this.a.k.d() == paramInt) {
          this.k.a(paraml, paramBoolean2);
        }
      }
      while (paramInt != 1) {
        return;
      }
      this.k.a(paraml, paramBoolean2);
      return;
    }
    a(paramBoolean2);
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.a == null) {
      return;
    }
    j();
    b(parama, paramBoolean1, paramBoolean2, paramBoolean3);
    a(this.l);
  }
  
  public void a(String paramString)
  {
    this.d.setText(paramString);
  }
  
  public void b(int paramInt)
  {
    int i1;
    label35:
    int i2;
    if (paramInt < 0)
    {
      this.e.setVisibility(0);
      paramInt = Math.abs(paramInt);
      i1 = paramInt / 100;
      if (i1 != 0) {
        break label175;
      }
      this.f.setVisibility(8);
      i2 = (paramInt - i1 * 100) / 10;
      if ((i2 != 0) || (i1 != 0)) {
        break label215;
      }
      this.g.setVisibility(8);
      label62:
      this.h.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.b.a(this.m.b, e(paramInt % 10), this.m.a));
      if (this.l != 1) {
        break label255;
      }
    }
    label175:
    label215:
    label255:
    for (String str1 = this.m.a("gw_weather_11_temp_unit_celsius");; str1 = this.m.a("gw_weather_11_temp_unit_fahrenheit"))
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1)) {
        str2 = this.m.a("gw_weather_11_temp_unit");
      }
      this.i.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.b.a(this.m.b, str2, this.m.a));
      return;
      this.e.setVisibility(8);
      break;
      this.f.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.b.a(this.m.b, e(i1), this.m.a));
      this.f.setVisibility(0);
      break label35;
      this.g.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.b.a(this.m.b, e(i2), this.m.a));
      this.g.setVisibility(0);
      break label62;
    }
  }
  
  public void b(com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = this.m.c[0];
    boolean bool = g();
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
      localObject = com.gau.go.launcherex.gowidget.weather.f.b.a(this.m.b, (String)localObject, this.m.a);
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
          this.k.a((l)localObject, true);
          return;
        } while (localObject == null);
        parama = f.a((Drawable)localObject);
      } while (parama == null);
      this.k.a(parama, paramBoolean3);
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
    if (this.a != null) {
      return this.a.c();
    }
    return null;
  }
  
  public void c(int paramInt)
  {
    this.l = paramInt;
  }
  
  public WeatherBean d()
  {
    return this.a;
  }
  
  public void d(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void e()
  {
    a(null, this.s.b, this.s.c.g, true);
  }
  
  public int f()
  {
    return this.a.e();
  }
  
  public boolean g()
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
    if ((paramView.equals(this.d)) || (paramView.equals(this.k)) || (paramView.equals(this.j))) {
      this.s.gotoWeatherDetail(c());
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    performLongClick();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */