package com.gau.go.launcherex.gowidget.weather.util;

import android.content.Intent;
import android.os.Bundle;

public class v
{
  public w a(Intent paramIntent)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getExtras();
      localObject1 = localObject2;
      if (paramIntent != null)
      {
        localObject1 = new w(this);
        ((w)localObject1).a = paramIntent.getInt("weather_update_status", 1);
        ((w)localObject1).b = paramIntent.getInt("weather_update_errorcode", 55536);
        ((w)localObject1).c = paramIntent.getInt("weather_update_way", 1);
        ((w)localObject1).d = paramIntent.getInt("request", 21);
        ((w)localObject1).e = paramIntent.getStringArrayList("update_weather_data");
        ((w)localObject1).f = paramIntent.getIntegerArrayList("weather_status");
      }
    }
    return (w)localObject1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/util/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */