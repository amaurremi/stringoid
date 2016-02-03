package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.f.a;
import com.gau.go.launcherex.gowidget.weather.f.e;
import com.gau.go.launcherex.gowidget.weather.f.f;
import com.gau.go.launcherex.gowidget.weather.model.ForecastBean;
import com.gau.go.launcherex.gowidget.weather.util.q;
import com.gau.go.launcherex.gowidget.weather.util.r;
import java.util.HashMap;

public class WeatherForecastItem
  extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  TextView a = null;
  WeatherLouverView b = null;
  TextView c = null;
  String[] d;
  ForecastBean e = null;
  private a f = null;
  private bs g;
  
  public WeatherForecastItem(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public WeatherForecastItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.f = new a();
    this.f.a = paramContext.getPackageName();
    this.f.b = paramContext.getResources();
    this.f.d = new String[] { "gw_weather_42_time_num0_w", "gw_weather_42_time_num1_w", "gw_weather_42_time_num2_w", "gw_weather_42_time_num3_w", "gw_weather_42_time_num4_w", "gw_weather_42_time_num5_w", "gw_weather_42_time_num6_w", "gw_weather_42_time_num7_w", "gw_weather_42_time_num8_w", "gw_weather_42_time_num9_w" };
    this.f.e = new String[] { "gw_weather_42_temp_num0_w", "gw_weather_42_temp_num1_w", "gw_weather_42_temp_num2_w", "gw_weather_42_temp_num3_w", "gw_weather_42_temp_num4_w", "gw_weather_42_temp_num5_w", "gw_weather_42_temp_num6_w", "gw_weather_42_temp_num7_w", "gw_weather_42_temp_num8_w", "gw_weather_42_temp_num9_w" };
    this.f.c = new String[] { "gw_weather_42_unknown_w", "gw_weather_42_sun_w", "gw_weather_42_sun_night_w", "gw_weather_42_cloudy_w", "gw_weather_42_cloudy_night_w", "gw_weather_42_darkcloudy_w", "gw_weather_42_snow_w", "gw_weather_42_fog_w", "gw_weather_42_rain_w", "gw_weather_42_thunderstorm_w" };
    this.f.f = new String[] { "gw_weather_forecast_item_unknown", "gw_weather_forecast_item_sun", "gw_weather_forecast_item_cloudy", "gw_weather_forecast_item_darkcloudy", "gw_weather_forecast_item_snow", "gw_weather_forecast_item_fog", "gw_weather_forecast_item_rain", "gw_weather_forecast_item_thunderstorm" };
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
    this.f.a(paramContext);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = "--";
    String str = "--°/--°";
    Object localObject3 = localObject2;
    Object localObject4 = str;
    Object localObject1;
    if (this.e != null)
    {
      int i = r.b(this.e.e(), this.e.f(), this.e.g());
      int j = q.a(this.e.b(paramInt));
      paramInt = q.a(this.e.a(paramInt));
      localObject1 = str;
      if (j != 55536)
      {
        localObject1 = str;
        if (paramInt != 55536) {
          localObject1 = j + "°/" + paramInt + "°";
        }
      }
      if (i < 7) {
        localObject2 = this.d[i];
      }
      paramInt = this.e.i();
      localObject3 = localObject2;
      localObject4 = localObject1;
      if (paramInt != 55536) {
        paramInt -= 1;
      }
    }
    for (;;)
    {
      this.a.setText((CharSequence)localObject2);
      this.c.setText((CharSequence)localObject1);
      localObject1 = this.f.f[paramInt];
      localObject1 = e.a(this.f.b, (String)localObject1, this.f.a);
      if (localObject1 != null)
      {
        localObject1 = f.a((Drawable)localObject1);
        if (localObject1 != null) {
          this.b.a((Bitmap)localObject1, paramBoolean);
        }
      }
      return;
      localObject1 = localObject4;
      localObject2 = localObject3;
      paramInt = 0;
    }
  }
  
  public void a(a parama)
  {
    this.f = parama;
    parama = this.f.f[0];
    parama = e.a(this.f.b, parama, this.f.a);
    if (parama != null)
    {
      parama = f.a(parama);
      if (parama != null) {
        this.b.a(parama, false);
      }
    }
    parama = e.b(this.f.b, this.f.a("gw_weather_days_41_txt_selector"), this.f.a);
    this.a.setTextColor(parama);
    this.c.setTextColor(parama);
    try
    {
      int i = e.a(this.f.a("gw_weather_days_41_txt_shadow_color"), 16777215);
      float f1 = Float.parseFloat(this.f.a("gw_weather_days_41_txt_shadow_dx"));
      float f2 = Float.parseFloat(this.f.a("gw_weather_days_41_txt_shadow_dy"));
      float f3 = Float.parseFloat(this.f.a("gw_weather_days_41_txt_shadow_radius"));
      this.a.setShadowLayer(f3, f1, f2, i);
      this.c.setShadowLayer(f3, f1, f2, i);
      return;
    }
    catch (NumberFormatException parama)
    {
      parama.printStackTrace();
    }
  }
  
  public void a(ForecastBean paramForecastBean)
  {
    this.e = paramForecastBean;
  }
  
  public void a(String[] paramArrayOfString, bs parambs, Context paramContext)
  {
    this.d = paramArrayOfString;
    this.g = parambs;
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.a.setOnLongClickListener(this);
    this.b.setOnLongClickListener(this);
    this.c.setOnLongClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (((paramView.equals(this.a) | paramView.equals(this.b))) || (paramView.equals(this.c))) {
      this.g.l();
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((TextView)findViewById(2131232103));
    this.b = ((WeatherLouverView)findViewById(2131232104));
    this.c = ((TextView)findViewById(2131232105));
  }
  
  public boolean onLongClick(View paramView)
  {
    performLongClick();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/WeatherForecastItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */