package com.gtp.go.weather.sharephoto.takephoto;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.q;

public abstract class ao
{
  protected int a = 0;
  protected final PointF b = new PointF();
  protected int c;
  protected int d;
  protected int e = 720;
  protected int f = 960;
  protected float g = 1.0F;
  protected int h;
  protected int i;
  protected WeatherBean j;
  protected q k;
  
  public int a()
  {
    return this.a;
  }
  
  public abstract Bitmap a(int paramInt1, int paramInt2);
  
  public void a(WeatherBean paramWeatherBean)
  {
    this.j = paramWeatherBean;
  }
  
  public void a(q paramq)
  {
    this.k = paramq;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */