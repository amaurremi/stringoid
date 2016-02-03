package com.gau.go.launcherex.gowidget.weather.b;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import com.gau.go.launcherex.gowidget.weather.model.b;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gtp.a.a.b.c;
import com.jiubang.goweather.c.i;

class bb
  extends i
{
  bb(ba paramba) {}
  
  public void a(int paramInt, Location paramLocation) {}
  
  public void a(int paramInt, b paramb)
  {
    c.a("WeatherCityInitializationHandler", "onLocateCityFinish: locationState=" + paramInt);
    if ((paramInt == 4) && (paramb != null))
    {
      c.a("WeatherCityInitializationHandler", "onLocateCityFinish: curCity=" + paramb.b());
      Object localObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INITIALIZED_CITY");
      ((Intent)localObject).putExtra("city_location_state", paramInt);
      ((Intent)localObject).putExtra("city_location_id", paramb.a());
      ba.a(this.a).sendBroadcast((Intent)localObject);
      localObject = ba.b(this.a);
      Uri localUri = WeatherContentProvider.a;
      String str = paramb.a();
      ((bc)localObject).a(0, paramb, localUri, new String[] { "cityId" }, "cityId=?", new String[] { str }, null);
      return;
    }
    paramb = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INITIALIZED_CITY");
    paramb.putExtra("city_location_state", paramInt);
    ba.a(this.a).sendBroadcast(paramb);
    ba.a(this.a, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */