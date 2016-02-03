package com.gau.go.launcherex.goweather.livewallpaper;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.text.format.Time;
import com.gau.go.launcherex.goweather.livewallpaper.a.a;
import com.gau.go.launcherex.goweather.livewallpaper.a.c;
import com.gau.go.launcherex.goweather.livewallpaper.a.e;
import com.gau.go.launcherex.goweather.livewallpaper.b.b;
import com.gau.go.launcherex.gowidget.language.i;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.jiubang.core.c.j;

public class k
  implements i
{
  private j a;
  private com.gau.go.launcherex.goweather.livewallpaper.a.g b;
  private c c;
  private e d;
  private BroadcastReceiver e;
  private n f;
  private com.gau.go.launcherex.gowidget.weather.d.f g;
  private com.gau.go.launcherex.gowidget.weather.c.g h;
  private com.gau.go.launcherex.gowidget.language.d i;
  private com.gau.go.launcherex.goweather.livewallpaper.b.g j;
  private com.gau.go.launcherex.goweather.livewallpaper.b.f k;
  private com.gau.go.launcherex.goweather.livewallpaper.b.d l;
  private b m;
  private String n;
  private int o = 0;
  private final int p = 1;
  private BroadcastReceiver q;
  private Context r;
  private boolean s;
  
  public k(Context paramContext, com.gau.go.launcherex.goweather.livewallpaper.b.g paramg, com.gau.go.launcherex.goweather.livewallpaper.b.f paramf, com.gau.go.launcherex.goweather.livewallpaper.b.d paramd, b paramb)
  {
    this.r = paramContext;
    this.j = paramg;
    this.k = paramf;
    this.l = paramd;
    this.m = paramb;
    this.d = new e();
    this.c = new c();
    this.a = new o(this, paramContext.getContentResolver());
    this.h = new com.gau.go.launcherex.gowidget.weather.c.g(paramContext);
    this.g = com.gau.go.launcherex.gowidget.weather.d.f.a(paramContext);
    this.i = com.gau.go.launcherex.gowidget.language.d.a(paramContext);
    this.s = false;
  }
  
  private void a(int paramInt)
  {
    this.a.a(paramInt, null, WeatherContentProvider.a, new String[] { "cityId", "cityName", "type", "nowTempValue", "nowDesp", "highTempValue", "lowTempValue", "windDirection", "windStrengthValue", "sunrise", "sunset", "tz_offset" }, null, null, "sequence");
  }
  
  private void a(int paramInt, String paramString)
  {
    j localj = this.a;
    Uri localUri = WeatherContentProvider.a;
    paramString = "cityId = '" + paramString + "'";
    localj.a(paramInt, null, localUri, new String[] { "cityName", "type", "nowTempValue", "nowDesp", "highTempValue", "lowTempValue", "windDirection", "windStrengthValue", "sunrise", "sunset", "tz_offset" }, paramString, null, null);
  }
  
  private void a(int paramInt, String[] paramArrayOfString)
  {
    int i1 = 0;
    String str = "setting_key in ('";
    int i2 = paramArrayOfString.length - 1;
    while (i1 < i2)
    {
      str = str + paramArrayOfString[i1] + "', '";
      i1 += 1;
    }
    paramArrayOfString = str + paramArrayOfString[i2] + "')";
    this.a.a(paramInt, null, WeatherContentProvider.g, new String[] { "setting_key", "setting_value" }, paramArrayOfString, null, null);
  }
  
  private void a(Cursor paramCursor, String paramString)
  {
    if ((paramCursor != null) && (paramCursor.moveToFirst()))
    {
      paramCursor = paramCursor.getString(paramCursor.getColumnIndex("setting_value"));
      if (paramCursor.equals(paramString))
      {
        this.c.a(paramCursor);
        this.k.a(paramCursor);
        d(paramCursor);
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.d != null) {
      if (!this.h.d()) {
        break label131;
      }
    }
    label131:
    for (Time localTime = this.h.b(this.d.l());; localTime = this.h.c())
    {
      if ((this.d.i() != 1) && (((localTime.hour == this.d.n()) && (localTime.minute == this.d.o())) || ((localTime.hour == this.d.m()) && (localTime.minute == this.d.p())) || (paramBoolean))) {
        this.k.a(this.d.i(), this.c.d(), b());
      }
      return;
    }
  }
  
  private int b(Cursor paramCursor)
  {
    int i1 = 0;
    int i3 = 1;
    for (;;)
    {
      int i2;
      try
      {
        if (paramCursor.getCount() <= 0) {
          break label420;
        }
        int i4 = paramCursor.getColumnCount();
        String[] arrayOfString = paramCursor.getColumnNames();
        paramCursor.moveToFirst();
        i2 = i3;
        if (i1 >= i4) {
          break label422;
        }
        if (arrayOfString[i1].equals("cityId")) {
          this.d.b(paramCursor.getString(i1));
        } else if (arrayOfString[i1].equals("cityName")) {
          this.d.c(paramCursor.getString(i1));
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return -1;
        if (localException[i1].equals("type")) {
          this.d.d(paramCursor.getInt(i1));
        }
      }
      finally
      {
        paramCursor.close();
      }
      if (localObject[i1].equals("nowTempValue"))
      {
        this.d.a(paramCursor.getFloat(i1));
      }
      else if (localObject[i1].equals("nowDesp"))
      {
        this.d.d(paramCursor.getString(i1));
      }
      else if (localObject[i1].equals("highTempValue"))
      {
        this.d.d(paramCursor.getFloat(i1));
      }
      else if (localObject[i1].equals("lowTempValue"))
      {
        this.d.b(paramCursor.getFloat(i1));
      }
      else if (localObject[i1].equals("windDirection"))
      {
        this.d.e(paramCursor.getString(i1));
      }
      else if (localObject[i1].equals("windStrengthValue"))
      {
        this.d.e(paramCursor.getFloat(i1));
      }
      else if (localObject[i1].equals("sunrise"))
      {
        this.d.f(paramCursor.getString(i1));
      }
      else if (localObject[i1].equals("sunset"))
      {
        this.d.g(paramCursor.getString(i1));
      }
      else if (localObject[i1].equals("tz_offset"))
      {
        this.d.e(paramCursor.getInt(i1));
        break label430;
        label420:
        i2 = 0;
        label422:
        paramCursor.close();
        return i2;
      }
      label430:
      i1 += 1;
    }
  }
  
  private void b(int paramInt, String paramString)
  {
    j localj = this.a;
    Uri localUri = WeatherContentProvider.g;
    paramString = "setting_key = '" + paramString + "'";
    localj.a(paramInt, null, localUri, new String[] { "setting_key", "setting_value" }, paramString, null, null);
  }
  
  private void b(String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("setting_value", paramString);
    this.a.a(0, null, WeatherContentProvider.g, localContentValues, "setting_key = 'key_live_wallpaper_city_id'", null);
  }
  
  private void c(Cursor paramCursor)
  {
    int i1 = b(paramCursor);
    if (i1 == 1)
    {
      this.d.q();
      this.j.a(this.d, this.b, this.c, b(), this.i.a());
      this.k.a(this.c.d(), this.c.e());
    }
    while (i1 != 0) {
      return;
    }
    a(4);
  }
  
  private void c(String paramString)
  {
    this.a.a(12, paramString, WeatherContentProvider.g, new String[] { "setting_value" }, "setting_key=?", new String[] { "app_theme" }, null);
  }
  
  private void d(String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("setting_value", paramString);
    this.a.a(-1, null, WeatherContentProvider.g, localContentValues, "setting_key=?", new String[] { "key_live_wallpaper_theme" });
  }
  
  private boolean d(Cursor paramCursor)
  {
    boolean bool = false;
    if (b(paramCursor) == 1)
    {
      this.d.q();
      this.j.b(this.d, this.b, this.c, b(), this.i.a());
      bool = true;
    }
    return bool;
  }
  
  private void e(Cursor paramCursor)
  {
    int i1 = b(paramCursor);
    if (i1 == 1)
    {
      this.d.q();
      this.j.a(this.d, this.b, this.c, b(), this.i.a());
      this.k.a(this.c.d(), this.c.e());
      b(this.d.b());
    }
    while (i1 != 0) {
      return;
    }
    this.j.a(this.d, this.b, this.c, b(), this.i.a());
    this.k.a(this.c.d(), this.c.e());
  }
  
  private void f(Cursor paramCursor)
  {
    int i1 = 1;
    int i3;
    String str;
    do
    {
      try
      {
        if (paramCursor.getCount() <= 0) {
          break label561;
        }
        this.c = new c();
        this.b = new com.gau.go.launcherex.goweather.livewallpaper.a.g();
        a locala = this.c.a();
        paramCursor.moveToFirst();
        int i2 = paramCursor.getColumnIndex("setting_key");
        i3 = paramCursor.getColumnIndex("setting_value");
        str = paramCursor.getString(i2);
        if (!str.equals("key_live_wallpaper_city_id")) {
          break label147;
        }
        this.d.b(paramCursor.getString(i3));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          boolean bool;
          localException.printStackTrace();
          paramCursor.close();
          i1 = 0;
          continue;
          if (!str.equals("key_live_wallpaper_dynamic_effect_on")) {
            break;
          }
          this.c.e(paramCursor.getInt(i3));
        }
      }
      finally
      {
        paramCursor.close();
      }
      bool = paramCursor.moveToNext();
    } while (bool);
    for (;;)
    {
      paramCursor.close();
      if (i1 != 0)
      {
        i();
        j();
        a(2, this.d.b());
      }
      return;
      label147:
      if (str.equals("key_live_wallpaper_city_flag"))
      {
        this.d.f(paramCursor.getInt(i3));
        break;
      }
      if (str.equals("key_live_wallpaper_theme"))
      {
        this.c.a(paramCursor.getString(i3));
        break;
      }
      if (str.equals("key_live_wallpaper_show_weather_info_on"))
      {
        this.c.d(paramCursor.getInt(i3));
        break;
      }
      if (str.equals("key_live_wallpaper_weather_info_description_on"))
      {
        ((a)localObject).a(paramCursor.getInt(i3));
        break;
      }
      if (str.equals("key_live_wallpaper_weather_info_hight_low_temperature_on"))
      {
        ((a)localObject).b(paramCursor.getInt(i3));
        break;
      }
      if (str.equals("key_live_wallpaper_weather_info_wind_on"))
      {
        ((a)localObject).c(paramCursor.getInt(i3));
        break;
      }
      if (str.equals("key_live_wallpaper_weather_info_font_size"))
      {
        this.c.b(paramCursor.getInt(i3));
        break;
      }
      if (str.equals("key_live_wallpaper_weather_info_position"))
      {
        this.c.a(paramCursor.getInt(i3));
        break;
      }
      if (str.equals("key_live_wallpaper_weather_info_show_moment"))
      {
        this.c.c(paramCursor.getInt(i3));
        break;
      }
      if (str.equals("world_clock"))
      {
        this.b.a(paramCursor.getInt(i3));
        this.h.a(this.b.a());
        break;
      }
      if (str.equals("tempUnit"))
      {
        this.b.c(paramCursor.getInt(i3));
        break;
      }
      if (!str.equals("windUnit")) {
        break;
      }
      this.b.e(paramCursor.getInt(i3));
      break;
      label561:
      i1 = 0;
    }
  }
  
  private void g()
  {
    if ((!TextUtils.isEmpty(this.n)) && (this.o == 1))
    {
      String str = this.c.e();
      if (!this.n.equals(str)) {
        this.k.a(str);
      }
      this.n = "";
      this.o = 0;
    }
  }
  
  private void g(Cursor paramCursor)
  {
    int i6 = 0;
    int i5 = 0;
    i4 = 2;
    i2 = i4;
    i3 = i5;
    i1 = i6;
    try
    {
      if (paramCursor.getCount() > 0)
      {
        i1 = i6;
        paramCursor.moveToFirst();
        i1 = i6;
        int i8 = paramCursor.getColumnIndex("setting_key");
        i1 = i6;
        int i7 = paramCursor.getColumnIndex("setting_value");
        i2 = i4;
        i3 = i5;
        i1 = i6;
        if (paramCursor.getString(i8).equals("tempUnit"))
        {
          i1 = 1;
          i3 = 1;
          i2 = paramCursor.getInt(i7);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        paramCursor.close();
        i2 = i4;
        i3 = i1;
      }
    }
    finally
    {
      paramCursor.close();
    }
    if ((i3 != 0) && (this.b.d(i2))) {
      this.j.a(this.d, this.b, this.i.a());
    }
  }
  
  private void h()
  {
    int i1 = 0;
    String[] arrayOfString = new String[13];
    arrayOfString[0] = "key_live_wallpaper_city_id";
    arrayOfString[1] = "key_live_wallpaper_dynamic_effect_on";
    arrayOfString[2] = "key_live_wallpaper_theme";
    arrayOfString[3] = "key_live_wallpaper_show_weather_info_on";
    arrayOfString[4] = "key_live_wallpaper_weather_info_description_on";
    arrayOfString[5] = "key_live_wallpaper_weather_info_wind_on";
    arrayOfString[6] = "key_live_wallpaper_weather_info_hight_low_temperature_on";
    arrayOfString[7] = "key_live_wallpaper_weather_info_font_size";
    arrayOfString[8] = "key_live_wallpaper_weather_info_position";
    arrayOfString[9] = "key_live_wallpaper_weather_info_show_moment";
    arrayOfString[10] = "world_clock";
    arrayOfString[11] = "tempUnit";
    arrayOfString[12] = "windUnit";
    String str = "setting_key in ('";
    int i2 = arrayOfString.length - 1;
    while (i1 < i2)
    {
      str = str + arrayOfString[i1] + "', '";
      i1 += 1;
    }
    str = str + arrayOfString[i2] + "')";
    this.a.a(1, null, WeatherContentProvider.g, new String[] { "setting_key", "setting_value" }, str, null, null);
  }
  
  private void h(Cursor paramCursor)
  {
    int i6 = 0;
    int i5 = 0;
    i4 = 2;
    i2 = i4;
    i3 = i5;
    i1 = i6;
    try
    {
      if (paramCursor.getCount() > 0)
      {
        i1 = i6;
        paramCursor.moveToFirst();
        i1 = i6;
        int i8 = paramCursor.getColumnIndex("setting_key");
        i1 = i6;
        int i7 = paramCursor.getColumnIndex("setting_value");
        i2 = i4;
        i3 = i5;
        i1 = i6;
        if (paramCursor.getString(i8).equals("windUnit"))
        {
          i1 = 1;
          i3 = 1;
          i2 = paramCursor.getInt(i7);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        paramCursor.close();
        i2 = i4;
        i3 = i1;
      }
    }
    finally
    {
      paramCursor.close();
    }
    if ((i3 != 0) && (this.b.f(i2))) {
      this.j.b(this.d, this.b, this.i.a());
    }
  }
  
  private void i()
  {
    this.e = new l(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.TIME_TICK");
    localIntentFilter.addAction("android.intent.action.TIME_SET");
    localIntentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_TEMPERATURE_UNIT");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIND_UNIT");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WORLD_CLOCK");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_AUTO_LOCATION");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LIVE_WALLPAPER_SETTINGS_CHANGE");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LIVE_WALLPAPER_THEME_CHANGE");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_USER_LANGUAGE_CHANGED");
    localIntentFilter.addAction("android.intent.action.LOCALE_CHANGED");
    this.r.registerReceiver(this.e, localIntentFilter);
    this.f = new n(this, null);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
    localIntentFilter.addDataScheme("package");
    this.r.registerReceiver(this.f, localIntentFilter);
  }
  
  private void i(Cursor paramCursor)
  {
    int i3 = 0;
    int i1 = 0;
    for (;;)
    {
      try
      {
        int i4;
        if (paramCursor.getCount() > 0)
        {
          paramCursor.moveToFirst();
          i2 = paramCursor.getColumnIndex("setting_key");
          i4 = paramCursor.getColumnIndex("setting_value");
          boolean bool = paramCursor.getString(i2).equals("world_clock");
          if (bool) {
            i2 = 1;
          }
        }
        int i2 = 0;
      }
      catch (Exception localException1)
      {
        localException1 = localException1;
        i1 = 0;
        localException1.printStackTrace();
        paramCursor.close();
        i2 = i1;
        i1 = i3;
      }
      finally
      {
        paramCursor.close();
      }
    }
  }
  
  private void j()
  {
    this.q = new m(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
    localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
    localIntentFilter.addDataScheme("file");
    this.r.registerReceiver(this.q, localIntentFilter);
  }
  
  private void j(Cursor paramCursor)
  {
    boolean bool2 = false;
    boolean bool1;
    boolean bool3;
    label587:
    label674:
    for (;;)
    {
      try
      {
        if (paramCursor.getCount() > 0)
        {
          locala = this.c.a();
          paramCursor.moveToFirst();
          i1 = paramCursor.getColumnIndex("setting_key");
          i2 = paramCursor.getColumnIndex("setting_value");
          bool2 = false;
          bool1 = false;
        }
      }
      catch (Exception localException1)
      {
        a locala;
        int i2;
        String str;
        bool2 = false;
        bool1 = false;
        localException1.printStackTrace();
        paramCursor.close();
        int i1 = 0;
        bool3 = bool2;
        continue;
      }
      finally
      {
        paramCursor.close();
      }
      try
      {
        str = paramCursor.getString(i1);
        if (str.equals("key_live_wallpaper_city_id"))
        {
          bool3 = this.d.a(paramCursor.getString(i2));
          bool1 = bool2;
          bool2 = bool3;
        }
      }
      catch (Exception localException2)
      {
        continue;
      }
      try
      {
        bool3 = paramCursor.moveToNext();
        if (bool3) {
          break label674;
        }
        i1 = 1;
        paramCursor.close();
        bool3 = bool1;
        bool1 = bool2;
        if (i1 != 0)
        {
          if (!bool1) {
            break label587;
          }
          a(10, this.d.b());
        }
        return;
      }
      catch (Exception localException3)
      {
        bool3 = bool2;
        bool2 = bool1;
        bool1 = bool3;
        continue;
        bool3 = bool2;
        bool2 = bool1;
        bool1 = bool3;
      }
      if (str.equals("key_live_wallpaper_city_flag"))
      {
        this.d.f(paramCursor.getInt(i2));
        bool3 = bool1;
        bool1 = bool2;
        bool2 = bool3;
      }
      else if (str.equals("key_live_wallpaper_dynamic_effect_on"))
      {
        bool3 = this.c.f(paramCursor.getInt(i2));
        bool2 = bool1;
        bool1 = bool3;
      }
      else if (str.equals("key_live_wallpaper_theme"))
      {
        this.c.a(paramCursor.getString(i2));
        bool3 = bool1;
        bool1 = bool2;
        bool2 = bool3;
      }
      else if (str.equals("key_live_wallpaper_show_weather_info_on"))
      {
        this.c.d(paramCursor.getInt(i2));
        bool3 = bool1;
        bool1 = bool2;
        bool2 = bool3;
      }
      else if (str.equals("key_live_wallpaper_weather_info_description_on"))
      {
        locala.a(paramCursor.getInt(i2));
        bool3 = bool1;
        bool1 = bool2;
        bool2 = bool3;
      }
      else if (str.equals("key_live_wallpaper_weather_info_hight_low_temperature_on"))
      {
        locala.b(paramCursor.getInt(i2));
        bool3 = bool1;
        bool1 = bool2;
        bool2 = bool3;
      }
      else if (str.equals("key_live_wallpaper_weather_info_wind_on"))
      {
        locala.c(paramCursor.getInt(i2));
        bool3 = bool1;
        bool1 = bool2;
        bool2 = bool3;
      }
      else if (str.equals("key_live_wallpaper_weather_info_font_size"))
      {
        this.c.b(paramCursor.getInt(i2));
        bool3 = bool1;
        bool1 = bool2;
        bool2 = bool3;
      }
      else if (str.equals("key_live_wallpaper_weather_info_position"))
      {
        this.c.a(paramCursor.getInt(i2));
        bool3 = bool1;
        bool1 = bool2;
        bool2 = bool3;
      }
      else
      {
        if (str.equals("key_live_wallpaper_weather_info_show_moment")) {
          this.c.c(paramCursor.getInt(i2));
        }
        bool3 = bool1;
        bool1 = bool2;
        bool2 = bool3;
        continue;
        bool1 = false;
        i1 = 0;
        continue;
        this.j.a(this.d, this.b, this.c, b(), this.i.a());
        if (bool3)
        {
          this.k.a(this.d.i(), this.c.d(), b());
          return;
        }
      }
    }
  }
  
  private void k()
  {
    a(9, new String[] { "key_live_wallpaper_city_flag", "key_live_wallpaper_city_id", "key_live_wallpaper_dynamic_effect_on", "key_live_wallpaper_theme", "key_live_wallpaper_show_weather_info_on", "key_live_wallpaper_weather_info_description_on", "key_live_wallpaper_weather_info_wind_on", "key_live_wallpaper_weather_info_hight_low_temperature_on", "key_live_wallpaper_weather_info_font_size", "key_live_wallpaper_weather_info_position", "key_live_wallpaper_weather_info_show_moment" });
  }
  
  private void k(Cursor paramCursor)
  {
    int i4 = 0;
    int i3 = 0;
    localObject4 = null;
    Object localObject5 = null;
    Object localObject1 = localObject5;
    i2 = i3;
    i1 = i4;
    try
    {
      if (paramCursor.getCount() > 0)
      {
        i1 = i4;
        paramCursor.moveToFirst();
        i1 = i4;
        int i6 = paramCursor.getColumnIndex("setting_key");
        i1 = i4;
        int i5 = paramCursor.getColumnIndex("setting_value");
        localObject1 = localObject5;
        i2 = i3;
        i1 = i4;
        if (paramCursor.getString(i6).equals("key_live_wallpaper_theme"))
        {
          i1 = 1;
          i2 = 1;
          localObject1 = paramCursor.getString(i5);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        paramCursor.close();
        Object localObject2 = localObject4;
        i2 = i1;
      }
    }
    finally
    {
      paramCursor.close();
    }
    if (i2 != 0)
    {
      this.c.a((String)localObject1);
      this.k.a((String)localObject1);
    }
  }
  
  private void l(Cursor paramCursor)
  {
    if (d(paramCursor)) {
      b(this.d.b());
    }
  }
  
  private void m(Cursor paramCursor)
  {
    if (paramCursor != null) {}
    try
    {
      if (paramCursor.getCount() > 0)
      {
        paramCursor.moveToFirst();
        int i1 = paramCursor.getColumnIndex("setting_key");
        int i2 = paramCursor.getColumnIndex("setting_value");
        if ((paramCursor.getString(i1).equals("auto_location")) && (paramCursor.getInt(i2) == 0)) {
          k();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      paramCursor.close();
    }
  }
  
  public void a()
  {
    h();
  }
  
  public void a(Cursor paramCursor)
  {
    if (b(paramCursor) == 1)
    {
      this.d.q();
      this.j.a(this.d, this.b, this.c, b(), this.i.a());
      this.k.a(this.d.i(), this.c.d(), b());
    }
  }
  
  public void a(String paramString)
  {
    this.n = paramString;
    g();
  }
  
  public boolean b()
  {
    if (!this.d.c())
    {
      String str1 = this.d.j();
      String str2 = this.d.k();
      if ((this.g.b()) && (this.h.d()))
      {
        int i1 = this.d.l();
        return r.a(str1, str2, this.h.b(i1));
      }
      return r.a(str1, str2);
    }
    return r.a("06:00", "18:00");
  }
  
  public c c()
  {
    return this.c;
  }
  
  public e d()
  {
    return this.d;
  }
  
  public void e()
  {
    this.m.c(this.d, this.b, this.i.a());
  }
  
  public void f()
  {
    this.s = true;
    if (this.e != null)
    {
      this.r.unregisterReceiver(this.e);
      this.e = null;
    }
    if (this.f != null)
    {
      this.r.unregisterReceiver(this.f);
      this.f = null;
    }
    if (this.q != null)
    {
      this.r.unregisterReceiver(this.q);
      this.q = null;
    }
    if (this.g != null) {
      this.g.g();
    }
    if (this.i != null) {
      com.gau.go.launcherex.gowidget.language.d.f();
    }
    if (this.h != null) {
      this.h.b();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/livewallpaper/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */