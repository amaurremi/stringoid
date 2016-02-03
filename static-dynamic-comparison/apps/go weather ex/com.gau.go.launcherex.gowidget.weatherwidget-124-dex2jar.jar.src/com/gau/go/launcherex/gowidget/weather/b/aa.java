package com.gau.go.launcherex.gowidget.weather.b;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.model.b;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.jiubang.goweather.c.m;
import java.util.ArrayList;
import java.util.Map;

public class aa
{
  private Context a;
  private m b;
  private boolean c;
  private boolean d = false;
  private boolean e = false;
  private ac f;
  
  public aa(Context paramContext)
  {
    this.a = paramContext;
    this.c = false;
    this.f = new ac(this, paramContext.getContentResolver());
  }
  
  private ContentValues a(b paramb, int paramInt, boolean paramBoolean)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("cityId", paramb.a());
    localContentValues.put("oldCityId", paramb.g());
    localContentValues.put("cityName", paramb.b());
    localContentValues.put("state", paramb.d());
    localContentValues.put("cityType", Integer.valueOf(2));
    localContentValues.put("myLocation", Integer.valueOf(1));
    localContentValues.put("city_my_location", Integer.valueOf(paramInt));
    localContentValues.put("latitude", Float.valueOf(-10000.0F));
    localContentValues.put("longitude", Float.valueOf(-10000.0F));
    localContentValues.put("hasRadar", Integer.valueOf(paramb.i()));
    localContentValues.put("hasSatellite", Integer.valueOf(paramb.k()));
    localContentValues.put("nowTempValue", Float.valueOf(-10000.0F));
    localContentValues.put("lowTempValue", Float.valueOf(-10000.0F));
    localContentValues.put("highTempValue", Float.valueOf(-10000.0F));
    localContentValues.put("windDirection", "--");
    localContentValues.put("windStrength", "--");
    localContentValues.put("windType", Integer.valueOf(1));
    localContentValues.put("windStrengthValue", Float.valueOf(-10000.0F));
    localContentValues.put("visibilityValue", Float.valueOf(-10000.0F));
    localContentValues.put("barometerValue", Float.valueOf(-10000.0F));
    localContentValues.put("dewpointValue", Float.valueOf(-10000.0F));
    localContentValues.put("uvIndexValue", Float.valueOf(-10000.0F));
    localContentValues.put("sunrise", "--");
    localContentValues.put("sunset", "--");
    localContentValues.put("type", Integer.valueOf(1));
    localContentValues.put("nowDesp", "--");
    localContentValues.put("humidityValue", Integer.valueOf(55536));
    if (paramBoolean) {
      localContentValues.put("sequence", Integer.valueOf(f.a(this.a).c().size()));
    }
    localContentValues.put("tz_offset", Integer.valueOf(55536));
    localContentValues.put("pop", Integer.valueOf(55536));
    localContentValues.put("feelslikeValue", Float.valueOf(-10000.0F));
    return localContentValues;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.b.a(paramInt1, paramInt2, paramInt3, new ab(this, paramInt1, paramInt2));
  }
  
  private void a(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LOCATION");
    localIntent.putExtra("location_status", paramInt1);
    localIntent.putExtra("city_code", paramString1);
    localIntent.putExtra("city_name", paramString2);
    localIntent.putExtra("last_location_cityid", paramString3);
    localIntent.putExtra("isMyLocation", paramInt2);
    this.a.sendOrderedBroadcast(localIntent, null);
  }
  
  private void a(Location paramLocation, b paramb)
  {
    SharedPreferences.Editor localEditor = this.a.getSharedPreferences("myLocation", 0).edit();
    localEditor.putString("lat", String.valueOf(paramLocation.getLatitude()));
    localEditor.putString("lng", String.valueOf(paramLocation.getLongitude()));
    localEditor.putString("cityId", paramb.a());
    localEditor.putString("cityName", paramb.b());
    localEditor.putString("countryName", paramb.c());
    localEditor.putString("stateName", paramb.d());
    localEditor.putString("url", paramb.l());
    localEditor.commit();
  }
  
  private void a(b paramb)
  {
    this.f.a(1, paramb, WeatherContentProvider.g, new String[] { "setting_value" }, "setting_key=?", new String[] { "key_live_wallpaper_city_flag" }, "_id");
  }
  
  private void a(ArrayList paramArrayList, String paramString)
  {
    if (c.a(this.a.getApplicationContext()).f().a().o != 1)
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("setting_value", paramString);
      paramArrayList.add(ContentProviderOperation.newUpdate(WeatherContentProvider.g).withValues(localContentValues).withSelection("setting_key='notify_city'", null).build());
    }
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt2)
    {
    default: 
      return;
    case 1: 
      if ((paramInt3 == 6) || (paramInt3 == 7))
      {
        a(paramInt1, 2, 10);
        return;
      }
      a(paramInt2, 2, 10);
      return;
    case 2: 
      if ((paramInt3 == 2) || (paramInt3 == 1))
      {
        a(paramInt2, 3, 30);
        return;
      }
      a(paramInt2, 3, 30);
      return;
    }
    this.c = false;
    c();
  }
  
  private void c()
  {
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LOCATION_FAILED");
    this.a.sendOrderedBroadcast(localIntent, null);
  }
  
  public void a()
  {
    this.d = true;
    if (!this.c)
    {
      if (this.e)
      {
        this.c = true;
        this.e = false;
        this.b = new m(this.a);
        a(0, 1, 15);
      }
      return;
    }
    this.e = false;
  }
  
  public void a(int paramInt)
  {
    if (!this.c)
    {
      if (this.d)
      {
        this.c = true;
        this.b = new m(this.a);
        a(0, 1, 15);
      }
    }
    else {
      return;
    }
    this.e = true;
  }
  
  public void b()
  {
    if (this.b != null) {
      this.b.b();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */