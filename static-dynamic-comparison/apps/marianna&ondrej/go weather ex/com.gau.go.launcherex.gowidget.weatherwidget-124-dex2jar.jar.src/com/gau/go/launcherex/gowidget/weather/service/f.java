package com.gau.go.launcherex.gowidget.weather.service;

import android.os.IInterface;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.WidgetSettingBean;
import java.util.List;

public abstract interface f
  extends IInterface
{
  public abstract String a(int paramInt);
  
  public abstract String a(String paramString);
  
  public abstract List a();
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt1, int paramInt2, String paramString);
  
  public abstract void a(c paramc);
  
  public abstract WidgetSettingBean b();
  
  public abstract void b(int paramInt);
  
  public abstract void b(c paramc);
  
  public abstract WeatherBean c();
  
  public abstract boolean d();
  
  public abstract boolean e();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/service/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */