package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.f.a;
import com.gau.go.launcherex.gowidget.weather.f.e;
import com.gau.go.launcherex.gowidget.weather.model.ForecastBean;
import com.gau.go.launcherex.gowidget.weather.util.q;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.go.gl.graphics.GLDrawable;
import com.go.gl.view.GLLinearLayout;
import com.go.gl.view.GLView;
import com.go.gl.view.GLView.OnClickListener;
import com.go.gl.view.GLView.OnLongClickListener;
import com.go.gl.widget.GLTextViewWrapper;
import java.util.HashMap;

public class GLWeatherForecastItem
  extends GLLinearLayout
  implements GLView.OnClickListener, GLView.OnLongClickListener
{
  private a a = null;
  private GLWeatherDays41 b;
  ForecastBean mForecastBean = null;
  GLTextViewWrapper mTemp = null;
  GLWeatherLouverView mWeatherIcon = null;
  String[] mWeek;
  GLTextViewWrapper mWeekDay = null;
  
  public GLWeatherForecastItem(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public GLWeatherForecastItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = new a();
    this.a.a = paramContext.getPackageName();
    this.a.b = paramContext.getResources();
    this.a.d = new String[] { "gw_weather_42_time_num0_w", "gw_weather_42_time_num1_w", "gw_weather_42_time_num2_w", "gw_weather_42_time_num3_w", "gw_weather_42_time_num4_w", "gw_weather_42_time_num5_w", "gw_weather_42_time_num6_w", "gw_weather_42_time_num7_w", "gw_weather_42_time_num8_w", "gw_weather_42_time_num9_w" };
    this.a.e = new String[] { "gw_weather_42_temp_num0_w", "gw_weather_42_temp_num1_w", "gw_weather_42_temp_num2_w", "gw_weather_42_temp_num3_w", "gw_weather_42_temp_num4_w", "gw_weather_42_temp_num5_w", "gw_weather_42_temp_num6_w", "gw_weather_42_temp_num7_w", "gw_weather_42_temp_num8_w", "gw_weather_42_temp_num9_w" };
    this.a.c = new String[] { "gw_weather_42_unknown_w", "gw_weather_42_sun_w", "gw_weather_42_sun_night_w", "gw_weather_42_cloudy_w", "gw_weather_42_cloudy_night_w", "gw_weather_42_darkcloudy_w", "gw_weather_42_snow_w", "gw_weather_42_fog_w", "gw_weather_42_rain_w", "gw_weather_42_thunderstorm_w" };
    this.a.f = new String[] { "gw_weather_forecast_item_unknown", "gw_weather_forecast_item_sun", "gw_weather_forecast_item_cloudy", "gw_weather_forecast_item_darkcloudy", "gw_weather_forecast_item_snow", "gw_weather_forecast_item_fog", "gw_weather_forecast_item_rain", "gw_weather_forecast_item_thunderstorm" };
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
    this.a.a(paramContext);
  }
  
  public void cleanup()
  {
    super.cleanup();
    this.mWeekDay.setOnClickListener(null);
    this.mWeatherIcon.setOnClickListener(null);
    this.mTemp.setOnClickListener(null);
    this.mWeekDay.setOnLongClickListener(null);
    this.mWeatherIcon.setOnLongClickListener(null);
    this.mTemp.setOnLongClickListener(null);
  }
  
  public void initView(String[] paramArrayOfString, GLWeatherDays41 paramGLWeatherDays41)
  {
    this.mWeek = paramArrayOfString;
    this.b = paramGLWeatherDays41;
    this.mWeekDay.setOnClickListener(this);
    this.mWeatherIcon.setOnClickListener(this);
    this.mTemp.setOnClickListener(this);
    this.mWeekDay.setOnLongClickListener(this);
    this.mWeatherIcon.setOnLongClickListener(this);
    this.mTemp.setOnLongClickListener(this);
  }
  
  public void onApplyTheme(a parama)
  {
    this.a = parama;
    parama = this.a.f[0];
    parama = GLDrawable.getDrawable(e.a(this.a.b, parama, this.a.a));
    if (parama != null) {
      this.mWeatherIcon.setWeather(parama, false);
    }
    parama = e.b(this.a.b, this.a.a("gw_weather_days_41_txt_selector"), this.a.a);
    this.mWeekDay.getTextView().setTextColor(parama);
    this.mTemp.getTextView().setTextColor(parama);
    try
    {
      int i = e.a(this.a.a("gw_weather_days_41_txt_shadow_color"), 16777215);
      float f1 = Float.parseFloat(this.a.a("gw_weather_days_41_txt_shadow_dx"));
      float f2 = Float.parseFloat(this.a.a("gw_weather_days_41_txt_shadow_dy"));
      float f3 = Float.parseFloat(this.a.a("gw_weather_days_41_txt_shadow_radius"));
      this.mWeekDay.getTextView().setShadowLayer(f3, f1, f2, i);
      this.mTemp.getTextView().setShadowLayer(f3, f1, f2, i);
      return;
    }
    catch (NumberFormatException parama)
    {
      parama.printStackTrace();
    }
  }
  
  public void onClick(GLView paramGLView)
  {
    if (((paramGLView.equals(this.mWeekDay) | paramGLView.equals(this.mWeatherIcon))) || (paramGLView.equals(this.mTemp))) {
      this.b.doGotoWeatherDetail();
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.mWeekDay = ((GLTextViewWrapper)findViewById(2131232103));
    this.mWeatherIcon = ((GLWeatherLouverView)findViewById(2131232104));
    this.mTemp = ((GLTextViewWrapper)findViewById(2131232105));
  }
  
  public boolean onLongClick(GLView paramGLView)
  {
    performLongClick();
    return true;
  }
  
  public void setForecastBean(ForecastBean paramForecastBean)
  {
    this.mForecastBean = paramForecastBean;
  }
  
  public void setThemeBean(a parama)
  {
    this.a = parama;
  }
  
  public void setWeek(String[] paramArrayOfString)
  {
    this.mWeek = paramArrayOfString;
  }
  
  public void showForecastInfo(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = "--";
    String str = "--°/--°";
    Object localObject3 = localObject2;
    Object localObject4 = str;
    Object localObject1;
    if (this.mForecastBean != null)
    {
      int i = r.b(this.mForecastBean.e(), this.mForecastBean.f(), this.mForecastBean.g());
      int j = q.a(this.mForecastBean.b(paramInt));
      paramInt = q.a(this.mForecastBean.a(paramInt));
      localObject1 = str;
      if (j != -10000.0F)
      {
        localObject1 = str;
        if (paramInt != -10000.0F) {
          localObject1 = j + "°/" + paramInt + "°";
        }
      }
      if (i < 7) {
        localObject2 = this.mWeek[i];
      }
      paramInt = this.mForecastBean.i();
      localObject3 = localObject2;
      localObject4 = localObject1;
      if (paramInt != 55536) {
        paramInt -= 1;
      }
    }
    for (;;)
    {
      this.mWeekDay.setText((CharSequence)localObject2);
      this.mTemp.setText((CharSequence)localObject1);
      localObject1 = this.a.f[paramInt];
      localObject1 = e.a(this.a.b, (String)localObject1, this.a.a);
      if (localObject1 != null) {
        this.mWeatherIcon.setWeather(GLDrawable.getDrawable((Drawable)localObject1), paramBoolean);
      }
      return;
      localObject1 = localObject4;
      localObject2 = localObject3;
      paramInt = 0;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherForecastItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */