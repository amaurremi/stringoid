package com.gau.go.launcherex.gowidget.weather.b;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.gau.go.launcherex.gowidget.weather.model.RequestBean;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.gtp.a.a.b.c;
import com.jiubang.goweather.c.g;
import com.jiubang.goweather.c.i;
import java.util.ArrayList;
import java.util.Map;

public class ba
{
  private static ba a = null;
  private Context b;
  private bc c;
  private boolean d;
  private g e;
  private final i f = new bb(this);
  
  private ba(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    this.c = new bc(this.b.getContentResolver(), this);
    this.d = false;
    this.e = new g(this.b);
    this.e.a(this.f);
  }
  
  public static ba a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new ba(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private void a(int paramInt1, Object paramObject, int paramInt2) {}
  
  private void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    if (paramCursor != null) {}
    for (;;)
    {
      try
      {
        paramInt = paramCursor.getCount();
        if (paramInt <= 0) {
          break label467;
        }
        paramInt = 1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        paramCursor.close();
        paramInt = 0;
        continue;
      }
      finally
      {
        paramCursor.close();
      }
      if (paramInt == 0)
      {
        paramObject = (com.gau.go.launcherex.gowidget.weather.model.b)paramObject;
        paramCursor = new ContentValues();
        paramCursor.put("cityId", ((com.gau.go.launcherex.gowidget.weather.model.b)paramObject).a());
        paramCursor.put("oldCityId", ((com.gau.go.launcherex.gowidget.weather.model.b)paramObject).a());
        paramCursor.put("cityName", ((com.gau.go.launcherex.gowidget.weather.model.b)paramObject).b());
        paramCursor.put("state", ((com.gau.go.launcherex.gowidget.weather.model.b)paramObject).d());
        paramCursor.put("country", ((com.gau.go.launcherex.gowidget.weather.model.b)paramObject).c());
        paramCursor.put("tz_offset", Integer.valueOf(((com.gau.go.launcherex.gowidget.weather.model.b)paramObject).e()));
        paramCursor.put("latitude", Float.valueOf(-10000.0F));
        paramCursor.put("longitude", Float.valueOf(-10000.0F));
        paramCursor.put("hasRadar", Integer.valueOf(((com.gau.go.launcherex.gowidget.weather.model.b)paramObject).i()));
        paramCursor.put("hasSatellite", Integer.valueOf(((com.gau.go.launcherex.gowidget.weather.model.b)paramObject).k()));
        paramCursor.put("myLocation", Integer.valueOf(1));
        paramCursor.put("city_my_location", Integer.valueOf(1));
        paramCursor.put("windDirection", "--");
        paramCursor.put("windStrength", "--");
        paramCursor.put("windType", Integer.valueOf(1));
        paramCursor.put("sunrise", "--");
        paramCursor.put("sunset", "--");
        paramCursor.put("type", Integer.valueOf(1));
        paramCursor.put("nowDesp", "--");
        paramCursor.put("sequence", Integer.valueOf(f.a(this.b.getApplicationContext()).c().size()));
        paramCursor.put("pop", Integer.valueOf(55536));
        paramCursor.put("cityType", Integer.valueOf(2));
        paramCursor.put("feelslikeValue", Float.valueOf(-10000.0F));
        paramCursor.put("barometerValue", Float.valueOf(-10000.0F));
        paramCursor.put("dewpointValue", Float.valueOf(-10000.0F));
        paramCursor.put("highTempValue", Float.valueOf(-10000.0F));
        paramCursor.put("lowTempValue", Float.valueOf(-10000.0F));
        paramCursor.put("windStrengthValue", Float.valueOf(-10000.0F));
        paramCursor.put("nowTempValue", Float.valueOf(-10000.0F));
        paramCursor.put("timestamp", Integer.valueOf(55536));
        paramCursor.put("uvIndexValue", Float.valueOf(-10000.0F));
        paramCursor.put("humidityValue", Float.valueOf(-10000.0F));
        paramCursor.put("visibilityValue", Float.valueOf(-10000.0F));
        paramCursor.put("updateTime", Integer.valueOf(55536));
        this.c.a(0, paramObject, WeatherContentProvider.a, paramCursor);
        return;
      }
      this.d = false;
      return;
      this.d = false;
      return;
      label467:
      paramInt = 0;
    }
  }
  
  private void a(int paramInt, Object paramObject, Uri paramUri)
  {
    paramObject = (com.gau.go.launcherex.gowidget.weather.model.b)paramObject;
    paramUri = f.a(this.b);
    paramUri.a((com.gau.go.launcherex.gowidget.weather.model.b)paramObject, paramUri.c().size(), 0);
    com.gau.go.launcherex.gowidget.gcm.b.a(this.b).b(((com.gau.go.launcherex.gowidget.weather.model.b)paramObject).a());
    paramUri = new RequestBean();
    paramUri.a(((com.gau.go.launcherex.gowidget.weather.model.b)paramObject).a(), ((com.gau.go.launcherex.gowidget.weather.model.b)paramObject).b(), 0L);
    paramObject = new ArrayList();
    ((ArrayList)paramObject).add(paramUri);
    paramUri = new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService");
    paramUri.putExtra("notify_request", 21);
    paramUri.putParcelableArrayListExtra("req_arg", (ArrayList)paramObject);
    this.b.startService(paramUri);
    this.d = false;
  }
  
  public void a()
  {
    if ((!this.d) && (this.e != null))
    {
      this.d = true;
      this.e.b();
      c.a("WeatherCityInitializationHandler", "startLocatingCity");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */