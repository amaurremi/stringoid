package com.gau.go.launcherex.gowidget.weather.view;

import android.os.Bundle;
import android.os.Message;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.service.k;
import java.util.List;

class cc
  extends k
{
  cc(WeatherWidget21 paramWeatherWidget21) {}
  
  private void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, Bundle paramBundle)
  {
    Message localMessage = WeatherWidget21.e(this.a).obtainMessage();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    if (paramObject != null) {
      localMessage.obj = paramObject;
    }
    if (paramBundle != null) {
      localMessage.setData(paramBundle);
    }
    WeatherWidget21.e(this.a).sendMessage(localMessage);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(3, paramInt1, paramInt2, null, null);
  }
  
  public void a(int paramInt, List paramList)
  {
    a(1, paramInt, -1, paramList, null);
  }
  
  public void a(WeatherBean paramWeatherBean)
  {
    a(4, -1, -1, paramWeatherBean, null);
  }
  
  public void a(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString(paramString1, paramString2);
    a(2, -1, -1, null, localBundle);
  }
  
  public void a(List paramList)
  {
    a(5, -1, -1, paramList, null);
  }
  
  public void a(boolean paramBoolean)
  {
    a(7, -1, -1, Boolean.valueOf(paramBoolean), null);
  }
  
  public void b(WeatherBean paramWeatherBean)
  {
    a(6, -1, -1, paramWeatherBean, null);
  }
  
  public void b(boolean paramBoolean)
  {
    a(8, -1, -1, Boolean.valueOf(paramBoolean), null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */