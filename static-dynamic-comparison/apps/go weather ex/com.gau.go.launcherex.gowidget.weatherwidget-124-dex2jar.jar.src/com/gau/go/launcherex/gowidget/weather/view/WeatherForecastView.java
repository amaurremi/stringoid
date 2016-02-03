package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.util.r;

public class WeatherForecastView
  extends LinearLayout
{
  private String a = "";
  private String b = "";
  private TextView c;
  private TextView d;
  
  public WeatherForecastView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    if (!r.a(paramString))
    {
      this.c.setText(2131165325);
      return;
    }
    this.c.setText(paramString);
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    if (!r.a(paramString))
    {
      this.d.setText(2131165325);
      return;
    }
    this.d.setText(paramString);
  }
  
  public void c(String paramString)
  {
    this.a = paramString;
  }
  
  public void d(String paramString)
  {
    this.b = paramString;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.c = ((TextView)findViewById(2131232099));
    this.d = ((TextView)findViewById(2131232101));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/WeatherForecastView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */