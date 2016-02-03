package com.gau.go.launcherex.gowidget.weather.service;

import android.os.IInterface;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import java.util.List;

public abstract interface c
  extends IInterface
{
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt, List paramList);
  
  public abstract void a(WeatherBean paramWeatherBean);
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(List paramList);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b(WeatherBean paramWeatherBean);
  
  public abstract void b(boolean paramBoolean);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/service/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */