package com.go.weatherex.sidebar;

import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.gau.go.launcherex.gowidget.weather.util.w;
import com.go.weatherex.city.EditCityScrollComponent;
import com.go.weatherex.city.a;
import com.go.weatherex.framework.e;
import java.util.List;

class d
  extends e
{
  private d(b paramb) {}
  
  private void a(String paramString, WeatherBean paramWeatherBean)
  {
    paramString = b.a(this.a).a(paramString);
    if (paramString != null)
    {
      paramString.a(paramWeatherBean);
      return;
    }
    b.a(this.a).a(paramWeatherBean);
  }
  
  public void a()
  {
    b.a(this.a).d();
  }
  
  public void a(int paramInt)
  {
    b.a(this.a).d();
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    b.a(this.a).a(b.b(this.a).a(paramString1));
  }
  
  public void a(List paramList, int paramInt)
  {
    if (paramList != null) {
      b.a(this.a).a(paramList);
    }
  }
  
  public void a(List paramList, w paramw)
  {
    b.a(this.a).c();
  }
  
  public void a(boolean paramBoolean)
  {
    b.a(this.a).d();
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    WeatherBean localWeatherBean;
    if (paramBoolean)
    {
      localWeatherBean = b.b(this.a).a(paramString2);
      if (localWeatherBean != null) {}
    }
    else
    {
      return;
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      a locala = b.a(this.a).a(paramString1);
      if (paramString1.equals(paramString2))
      {
        locala.a(localWeatherBean);
        return;
      }
      paramString1 = b.b(this.a).a(paramString1);
      if (paramString1 == null) {
        b.a(this.a).a(locala);
      }
      for (;;)
      {
        a(paramString2, localWeatherBean);
        return;
        locala.e = paramString1.e();
      }
    }
    a(paramString2, localWeatherBean);
  }
  
  public void b()
  {
    b.a(this.a).d();
  }
  
  public void b(boolean paramBoolean)
  {
    a locala;
    WeatherBean localWeatherBean;
    if (!paramBoolean)
    {
      locala = b.a(this.a).e();
      if (locala != null)
      {
        localWeatherBean = b.b(this.a).a(locala.a);
        if (localWeatherBean != null) {
          break label50;
        }
        b.a(this.a).a(locala);
      }
    }
    return;
    label50:
    locala.e = localWeatherBean.e();
  }
  
  public void c()
  {
    super.c();
    b.c(this.a);
    b.d(this.a).a();
  }
  
  public void e()
  {
    b.a(this.a).d();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/sidebar/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */