package com.gau.go.launcherex.gowidget.weather.c;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.service.NotifyService;
import com.gau.go.launcherex.gowidget.weather.util.o;
import com.jiubang.core.b.a;
import java.util.ArrayList;
import java.util.Locale;

public class e
  extends b
{
  private static e a;
  private Context b;
  private f c;
  private q d;
  private com.gau.go.launcherex.gowidget.weather.util.f e;
  
  private e(Context paramContext)
  {
    this.b = paramContext;
    this.c = new f(this, paramContext.getContentResolver(), this);
    this.d = new q();
  }
  
  public static e a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new e(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private void a(Cursor paramCursor)
  {
    if (paramCursor != null) {}
    for (;;)
    {
      int j;
      try
      {
        if (!paramCursor.moveToFirst()) {
          continue;
        }
        int i = paramCursor.getColumnIndex("setting_key");
        j = paramCursor.getColumnIndex("setting_value");
        str1 = paramCursor.getString(i);
        if (!str1.equals("auto_location")) {
          continue;
        }
        this.d.b = paramCursor.getInt(j);
      }
      catch (Exception localException)
      {
        String str1;
        boolean bool;
        if (!com.gtp.a.a.b.c.a()) {
          continue;
        }
        localException.printStackTrace();
        return;
        if (!localException.equals("app_theme")) {
          break label181;
        }
        this.d.d = paramCursor.getString(j);
        continue;
      }
      finally
      {
        if (paramCursor == null) {
          continue;
        }
        paramCursor.close();
      }
      bool = paramCursor.moveToNext();
      if (!bool)
      {
        if (paramCursor != null) {
          paramCursor.close();
        }
        return;
        if (str1.equals("launch_refresh")) {
          this.d.c = paramCursor.getInt(j);
        } else {
          label181:
          if (((String)localObject).equals("weather_focecast_switch"))
          {
            this.d.s = paramCursor.getInt(j);
          }
          else if (((String)localObject).equals("weather_warning_switch"))
          {
            this.d.t = paramCursor.getInt(j);
          }
          else if (((String)localObject).equals("no_alerts_cities"))
          {
            this.d.F = paramCursor.getString(j);
          }
          else if (((String)localObject).equals("temp_change"))
          {
            this.d.u = paramCursor.getInt(j);
          }
          else if (((String)localObject).equals("temp_change_low"))
          {
            this.d.v = paramCursor.getInt(j);
          }
          else if (((String)localObject).equals("temp_change_high"))
          {
            this.d.w = paramCursor.getInt(j);
          }
          else if (((String)localObject).equals("temp_change_city"))
          {
            this.d.x = paramCursor.getString(j);
          }
          else if (((String)localObject).equals("temp_change_type"))
          {
            this.d.y = paramCursor.getInt(j);
          }
          else if (((String)localObject).equals("autoUpdate"))
          {
            this.d.a = paramCursor.getInt(j);
          }
          else if (((String)localObject).equals("autpUpdateFreq"))
          {
            this.d.e = paramCursor.getInt(j);
          }
          else if (((String)localObject).equals("tempUnit"))
          {
            this.d.g = paramCursor.getInt(j);
          }
          else if (((String)localObject).equals("calendarType"))
          {
            this.d.h = paramCursor.getInt(j);
          }
          else if (((String)localObject).equals("festival"))
          {
            this.d.i = paramCursor.getInt(j);
          }
          else if (((String)localObject).equals("isCycle"))
          {
            this.d.j = paramCursor.getInt(j);
          }
          else if (((String)localObject).equals("dateStyle"))
          {
            this.d.k = paramCursor.getInt(j);
          }
          else if (((String)localObject).equals("notify"))
          {
            this.d.m = paramCursor.getInt(j);
          }
          else if (((String)localObject).equals("notify_city"))
          {
            this.d.n = paramCursor.getString(j);
          }
          else if (((String)localObject).equals("notify_city_type"))
          {
            this.d.o = paramCursor.getInt(j);
          }
          else if (((String)localObject).equals("notify_type"))
          {
            this.d.p = paramCursor.getInt(j);
          }
          else
          {
            String str2;
            if (((String)localObject).equals("windUnit"))
            {
              this.d.q = paramCursor.getInt(j);
              if (this.d.q > 6)
              {
                str2 = Locale.getDefault().getCountry();
                String str3 = Locale.getDefault().getLanguage();
                if ((str2.indexOf("CN") != -1) && (str3.equalsIgnoreCase("zh"))) {
                  this.d.q = 5;
                } else if ((str2.indexOf("KR") != -1) && (str3.equalsIgnoreCase("ko"))) {
                  this.d.q = 4;
                } else {
                  this.d.q = 2;
                }
              }
            }
            else if (str2.equals("world_clock"))
            {
              this.d.r = paramCursor.getInt(j);
            }
            else if (str2.equals("notification_sound"))
            {
              this.d.z = paramCursor.getInt(j);
            }
            else if (str2.equals("visibility_unit"))
            {
              this.d.A = paramCursor.getInt(j);
              if (this.d.A > 2) {
                if (Locale.getDefault().getLanguage().equalsIgnoreCase("en")) {
                  this.d.A = 1;
                } else {
                  this.d.A = 2;
                }
              }
            }
            else if (str2.equals("pressure_unit"))
            {
              this.d.B = paramCursor.getInt(j);
            }
            else if (str2.equals("notification_style"))
            {
              this.d.C = paramCursor.getString(j);
            }
            else if (str2.equals("weather_assistant_switch"))
            {
              this.d.D = paramCursor.getInt(j);
            }
            else if (str2.equals("dynamic_bg_switch"))
            {
              this.d.l = paramCursor.getInt(j);
            }
            else if (str2.equals("dynamic_icon_gowidget"))
            {
              this.d.E = paramCursor.getInt(j);
            }
            else if (str2.equals("widget_theme_switcher"))
            {
              this.d.L = paramCursor.getInt(j);
            }
          }
        }
      }
    }
  }
  
  private void a(Uri paramUri, String paramString1, ArrayList paramArrayList, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    paramString1 = new ContentValues();
    paramString1.put(paramString4, Integer.valueOf(paramInt));
    paramArrayList.add(ContentProviderOperation.newUpdate(paramUri).withValues(paramString1).withSelection(paramString2 + "='" + paramString3 + "'", null).build());
  }
  
  private void a(Uri paramUri, String paramString1, ArrayList paramArrayList, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString1 = new ContentValues();
    paramString1.put(paramString4, paramString5);
    paramArrayList.add(ContentProviderOperation.newUpdate(paramUri).withValues(paramString1).withSelection(paramString2 + "='" + paramString3 + "'", null).build());
  }
  
  private void a(WeatherBean paramWeatherBean, ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    paramWeatherBean.a(1);
    paramWeatherBean.e(paramInt2);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("sequence", Integer.valueOf(paramInt2));
    localContentValues.put("city_my_location", Integer.valueOf(1));
    paramArrayList.add(ContentProviderOperation.newUpdate(WeatherContentProvider.a).withValues(localContentValues).withSelection("cityId='" + paramWeatherBean.c() + "'" + " and " + "city_my_location" + "='" + paramInt1 + "'", null).build());
  }
  
  private void a(Object paramObject)
  {
    if (paramObject != null)
    {
      paramObject = (ContentValues)paramObject;
      if (!((ContentValues)paramObject).containsKey("tempUnit")) {
        break label32;
      }
      b(((ContentValues)paramObject).getAsInteger("tempUnit").intValue());
    }
    label32:
    do
    {
      do
      {
        return;
        if (((ContentValues)paramObject).containsKey("windUnit"))
        {
          c(((ContentValues)paramObject).getAsInteger("windUnit").intValue());
          return;
        }
        if (((ContentValues)paramObject).containsKey("visibility_unit"))
        {
          d(((ContentValues)paramObject).getAsInteger("visibility_unit").intValue());
          return;
        }
        if (((ContentValues)paramObject).containsKey("pressure_unit"))
        {
          e(((ContentValues)paramObject).getAsInteger("pressure_unit").intValue());
          return;
        }
        if (((ContentValues)paramObject).containsKey("world_clock"))
        {
          f(((ContentValues)paramObject).getAsInteger("world_clock").intValue());
          return;
        }
        if (((ContentValues)paramObject).containsKey("dateStyle"))
        {
          g(((ContentValues)paramObject).getAsInteger("dateStyle").intValue());
          return;
        }
        if (((ContentValues)paramObject).containsKey("calendarType"))
        {
          k(((ContentValues)paramObject).getAsInteger("calendarType").intValue());
          return;
        }
        if (((ContentValues)paramObject).containsKey("festival"))
        {
          j(((ContentValues)paramObject).getAsInteger("festival").intValue());
          return;
        }
        if (((ContentValues)paramObject).containsKey("isCycle"))
        {
          l(((ContentValues)paramObject).getAsInteger("isCycle").intValue());
          return;
        }
        if (((ContentValues)paramObject).containsKey("weather_focecast_switch"))
        {
          o(((ContentValues)paramObject).getAsInteger("weather_focecast_switch").intValue());
          return;
        }
      } while ((((ContentValues)paramObject).containsKey("notify")) || (((ContentValues)paramObject).containsKey("notify_city")) || (((ContentValues)paramObject).containsKey("notify_type")));
      if (((ContentValues)paramObject).containsKey("notification_style"))
      {
        c(((ContentValues)paramObject).getAsString("notification_style"));
        return;
      }
      if (((ContentValues)paramObject).containsKey("notification_sound"))
      {
        v(((ContentValues)paramObject).getAsInteger("notification_sound").intValue());
        return;
      }
      if (((ContentValues)paramObject).containsKey("autoUpdate"))
      {
        h(((ContentValues)paramObject).getAsInteger("autoUpdate").intValue());
        return;
      }
      if (((ContentValues)paramObject).containsKey("launch_refresh"))
      {
        t(((ContentValues)paramObject).getAsInteger("launch_refresh").intValue());
        return;
      }
      if (((ContentValues)paramObject).containsKey("autpUpdateFreq"))
      {
        i(((ContentValues)paramObject).getAsInteger("autpUpdateFreq").intValue());
        return;
      }
      if (((ContentValues)paramObject).containsKey("weather_assistant_switch"))
      {
        w(((ContentValues)paramObject).getAsInteger("weather_assistant_switch").intValue());
        return;
      }
      if (((ContentValues)paramObject).containsKey("dynamic_icon_gowidget"))
      {
        m(((ContentValues)paramObject).getAsInteger("dynamic_icon_gowidget").intValue());
        return;
      }
    } while (!((ContentValues)paramObject).containsKey("widget_theme_switcher"));
    n(((ContentValues)paramObject).getAsInteger("widget_theme_switcher").intValue());
  }
  
  private void a(ArrayList paramArrayList, WeatherBean paramWeatherBean)
  {
    this.d.n = paramWeatherBean.c();
    this.d.o = 1;
    a(WeatherContentProvider.g, "common_setting_table", paramArrayList, "setting_key", "notify_city", "setting_value", this.d.n);
    a(WeatherContentProvider.g, "common_setting_table", paramArrayList, "setting_key", "notify_city_type", "setting_value", this.d.o);
    j();
  }
  
  private void c(String paramString)
  {
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_STATUS_BAR_MATCHED");
    localIntent.putExtra("extra_status_bar_style", paramString);
    this.b.sendBroadcast(localIntent);
  }
  
  private void c(ArrayList paramArrayList)
  {
    this.d.o = 1;
    a(WeatherContentProvider.g, "common_setting_table", paramArrayList, "setting_key", "notify_city_type", "setting_value", this.d.o);
    j();
  }
  
  private void d(ArrayList paramArrayList)
  {
    a(WeatherContentProvider.g, "common_setting_table", paramArrayList, "setting_key", "key_live_wallpaper_city_flag", "setting_value", 1);
  }
  
  private void h()
  {
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WEATHER_UPDATE_TIME");
    localIntent.putExtra("auto_weather_update", this.d.a);
    localIntent.putExtra("auto_weather_frequency", this.d.e);
    this.b.sendBroadcast(localIntent);
  }
  
  private void i()
  {
    Intent localIntent = new Intent(this.b, NotifyService.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("notify_request", 16);
    localIntent.putExtras(localBundle);
    this.b.startService(localIntent);
  }
  
  private void j()
  {
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService");
    localIntent.putExtra("notify_request", 1);
    localIntent.putExtra("notify_on_or_off", this.d.m);
    this.b.startService(localIntent);
  }
  
  private void k()
  {
    this.c.a(4, null, WeatherContentProvider.g, new String[] { "setting_value" }, "setting_key=?", new String[] { "key_live_wallpaper_city_flag" }, "_id");
  }
  
  private void v(int paramInt)
  {
    if (this.d.z != paramInt)
    {
      this.d.z = paramInt;
      Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CHANGE_NOTIFICATION_SOUND");
      this.b.sendBroadcast(localIntent);
    }
  }
  
  private void w(int paramInt)
  {
    if (paramInt != this.d.D)
    {
      this.d.D = paramInt;
      localObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WEATHER_ASSISTANT_SWITCH_CHANGE");
      ((Intent)localObject).putExtra("extra_weather_assistant_value", this.d.D);
      this.b.sendBroadcast((Intent)localObject);
      if (this.d.D == 1) {
        i();
      }
    }
    else
    {
      return;
    }
    Object localObject = GoWidgetApplication.c(this.b).a().edit();
    ((SharedPreferences.Editor)localObject).putInt("key_inland_ad_show_count", 0);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public q a()
  {
    return this.d;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    if (this.d.m != paramInt1) {
      this.d.m = paramInt1;
    }
    if (this.d.p != paramInt2) {
      this.d.p = paramInt2;
    }
    if ((paramString1 != null) && (!this.d.n.equals(paramString1))) {
      this.d.n = paramString1;
    }
    if (paramInt3 != this.d.o) {
      this.d.o = paramInt3;
    }
    if ((!TextUtils.isEmpty(paramString2)) && (!paramString2.equals(this.d.C))) {
      this.d.C = paramString2;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.d.b = paramInt;
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_AUTO_LOCATION");
    localIntent.putExtra("extra_auto_location_flag", paramInt);
    localIntent.putExtra("extra_delete_my_location", paramBoolean);
    this.b.sendBroadcast(localIntent);
  }
  
  public void a(Uri paramUri, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put(paramString3, Integer.valueOf(paramInt));
    paramString3 = new ContentValues();
    paramString3.put(paramString2, Integer.valueOf(paramInt));
    this.c.a(2, paramString3, paramUri, localContentValues, paramString1 + "='" + paramString2 + "'", null);
  }
  
  public void a(Uri paramUri, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put(paramString3, paramString4);
    paramString3 = new ContentValues();
    paramString3.put(paramString2, paramString4);
    this.c.a(2, paramString3, paramUri, localContentValues, paramString1 + "='" + paramString2 + "'", null);
  }
  
  public void a(o paramo)
  {
    super.a(paramo);
    this.e = c.a(this.b).h();
    this.c.a(1, null, WeatherContentProvider.g, com.gau.go.launcherex.gowidget.weather.e.c.a(), null, null, null);
  }
  
  public void a(String paramString)
  {
    if ((paramString != null) && (!paramString.equals(this.d.K))) {
      this.d.K = paramString;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    this.d.n = paramString;
    this.d.o = paramInt;
    ArrayList localArrayList = new ArrayList();
    a(WeatherContentProvider.g, "common_setting_table", localArrayList, "setting_key", "notify_city", "setting_value", paramString);
    a(WeatherContentProvider.g, "common_setting_table", localArrayList, "setting_key", "notify_city_type", "setting_value", paramInt);
    this.c.a(2, null, "com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", localArrayList);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(WeatherContentProvider.g, "setting_key", paramString1, "setting_value", paramString2);
  }
  
  public void a(ArrayList paramArrayList)
  {
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DELETE_EXPIRED_EXTREME_WEATHER");
    localIntent.putParcelableArrayListExtra("extra_extreme_city_ids", paramArrayList);
    this.b.sendBroadcast(localIntent);
  }
  
  public void b(int paramInt)
  {
    int i = 1;
    if (this.d.g != paramInt)
    {
      this.d.g = paramInt;
      Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_TEMPERATURE_UNIT");
      localIntent.putExtra("temperature_unit", this.d.g);
      this.b.sendBroadcast(localIntent);
      if ((this.d.m != 1) || (this.d.p != 1)) {
        break label88;
      }
    }
    label88:
    for (paramInt = i;; paramInt = 0)
    {
      if (paramInt != 0) {
        c();
      }
      return;
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    Object localObject2;
    ArrayList localArrayList1;
    int i;
    WeatherBean localWeatherBean1;
    int j;
    boolean bool;
    Object localObject1;
    if (this.d.b != paramInt)
    {
      localObject2 = new ArrayList();
      this.d.b = paramInt;
      localArrayList1 = new ArrayList();
      if (paramInt != 0) {
        break label880;
      }
      ((ArrayList)localObject2).add(ContentProviderOperation.newUpdate(WeatherContentProvider.g).withSelection("setting_key='auto_location'", null).withValue("setting_value", Integer.valueOf(0)).build());
      i = this.e.e();
      localWeatherBean1 = this.e.g();
      if (localWeatherBean1 == null) {
        break label911;
      }
      j = localWeatherBean1.e();
      if ((j != 2) && (!paramBoolean)) {
        break label714;
      }
      if (i != 1) {
        break label258;
      }
      a(localWeatherBean1, (ArrayList)localObject2, 2, 0);
      c((ArrayList)localObject2);
      d((ArrayList)localObject2);
      paramBoolean = false;
      bool = false;
      localObject1 = null;
    }
    for (;;)
    {
      if (((ArrayList)localObject2).size() > 0)
      {
        this.c.a(1, new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), localArrayList1 }, "com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", (ArrayList)localObject2);
        if (paramInt == 0) {
          k();
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DELETE_CITY");
          localArrayList1 = new ArrayList(1);
          localArrayList1.add(localObject1);
          ((Intent)localObject2).putExtra("city_code_list", localArrayList1);
          this.b.sendBroadcast((Intent)localObject2);
        }
      }
      return;
      label258:
      if (i > 1)
      {
        localObject1 = localWeatherBean1.c();
        this.e.c((String)localObject1);
        this.e.d((String)localObject1);
        ArrayList localArrayList2 = this.e.d();
        new ContentValues();
        i = 0;
        while (i < localArrayList2.size())
        {
          WeatherBean localWeatherBean2 = (WeatherBean)localArrayList2.get(i);
          localWeatherBean2.e(i);
          ContentValues localContentValues = new ContentValues();
          localContentValues.put("sequence", Integer.valueOf(i));
          ((ArrayList)localObject2).add(ContentProviderOperation.newUpdate(WeatherContentProvider.a).withValues(localContentValues).withSelection("cityId='" + localWeatherBean2.c() + "'", null).build());
          i += 1;
        }
        ((ArrayList)localObject2).add(ContentProviderOperation.newDelete(WeatherContentProvider.a).withSelection("cityId='" + (String)localObject1 + "'", null).build());
        ((ArrayList)localObject2).add(ContentProviderOperation.newDelete(WeatherContentProvider.b).withSelection("cityId='" + (String)localObject1 + "'", null).build());
        ((ArrayList)localObject2).add(ContentProviderOperation.newDelete(WeatherContentProvider.f).withSelection("cityId='" + (String)localObject1 + "'", null).build());
        ((ArrayList)localObject2).add(ContentProviderOperation.newDelete(WeatherContentProvider.e).withSelection("cityId='" + (String)localObject1 + "'", null).build());
        ((ArrayList)localObject2).add(ContentProviderOperation.newDelete(WeatherContentProvider.k).withSelection("cityId='" + (String)localObject1 + "'", null).build());
        if (this.d.o != 1) {
          a((ArrayList)localObject2, (WeatherBean)localArrayList2.get(0));
        }
        if (localWeatherBean1.o() > 0) {
          this.e.a(localWeatherBean1, localArrayList1);
        }
        com.gau.go.launcherex.gowidget.gcm.b.a(this.b).a(localWeatherBean1.c());
        paramBoolean = true;
        bool = true;
        continue;
        label714:
        if (j == 3)
        {
          localWeatherBean1.a(1);
          localObject1 = new ContentValues();
          ((ContentValues)localObject1).put("city_my_location", Integer.valueOf(1));
          ((ArrayList)localObject2).add(ContentProviderOperation.newUpdate(WeatherContentProvider.a).withValues((ContentValues)localObject1).withSelection("cityId=?", new String[] { localWeatherBean1.c() }).build());
          if (this.d.o == 2)
          {
            if (i > 1)
            {
              localObject1 = (WeatherBean)this.e.d().get(0);
              if (localWeatherBean1.q() > ((WeatherBean)localObject1).q()) {
                a((ArrayList)localObject2, (WeatherBean)localObject1);
              }
              for (;;)
              {
                localObject1 = null;
                paramBoolean = false;
                bool = false;
                break;
                c((ArrayList)localObject2);
              }
            }
            if (i == 1) {
              c((ArrayList)localObject2);
            }
          }
          localObject1 = null;
          paramBoolean = false;
          bool = false;
          continue;
          label880:
          ((ArrayList)localObject2).add(ContentProviderOperation.newUpdate(WeatherContentProvider.g).withSelection("setting_key='auto_location'", null).withValue("setting_value", Integer.valueOf(1)).build());
        }
      }
      label911:
      paramBoolean = false;
      bool = false;
      localObject1 = null;
    }
  }
  
  public void b(String paramString)
  {
    if (!paramString.equals(this.d.F)) {
      this.d.F = paramString;
    }
  }
  
  public void b(ArrayList paramArrayList)
  {
    this.c.a(2, paramArrayList, WeatherContentProvider.g, new String[] { "setting_value" }, "setting_key=?", new String[] { "key_live_wallpaper_city_id" }, "_id");
  }
  
  public void c()
  {
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService");
    localIntent.putExtra("notify_request", 1);
    localIntent.putExtra("notify_on_or_off", this.d.m);
    this.b.startService(localIntent);
  }
  
  public void c(int paramInt)
  {
    if (paramInt != this.d.q)
    {
      this.d.q = paramInt;
      Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIND_UNIT");
      localIntent.putExtra("wind_unit", this.d.q);
      this.b.sendBroadcast(localIntent);
    }
  }
  
  public void d()
  {
    WeatherBean localWeatherBean = (WeatherBean)this.e.d().get(0);
    String str;
    if (localWeatherBean != null)
    {
      str = localWeatherBean.c();
      if (localWeatherBean.e() != 1) {
        break label41;
      }
    }
    label41:
    for (int i = 1;; i = 2)
    {
      a(str, i);
      return;
    }
  }
  
  public void d(int paramInt)
  {
    if (paramInt != this.d.A)
    {
      this.d.A = paramInt;
      Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_VISIBILITY_UNIT");
      localIntent.putExtra("visibility_unit", this.d.A);
      this.b.sendBroadcast(localIntent);
    }
  }
  
  public void e(int paramInt)
  {
    if (paramInt != this.d.B)
    {
      this.d.B = paramInt;
      Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_PRESSURE_UNIT");
      localIntent.putExtra("pressure_unit", this.d.B);
      this.b.sendBroadcast(localIntent);
    }
  }
  
  public boolean e()
  {
    return this.d.b == 1;
  }
  
  public void f(int paramInt)
  {
    boolean bool = true;
    Object localObject;
    if (paramInt != this.d.r)
    {
      this.d.r = paramInt;
      localObject = c.a(this.b).g();
      if (this.d.r != 1) {
        break label83;
      }
    }
    for (;;)
    {
      ((g)localObject).a(bool);
      localObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WORLD_CLOCK");
      ((Intent)localObject).putExtra("extra_world_clock", this.d.r);
      this.b.sendBroadcast((Intent)localObject);
      return;
      label83:
      bool = false;
    }
  }
  
  public boolean f()
  {
    return this.d.m == 1;
  }
  
  public void g(int paramInt)
  {
    if (paramInt != this.d.k)
    {
      this.d.k = paramInt;
      Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATESTYLE_UNIT");
      localIntent.putExtra("datestyle_unit", this.d.k);
      this.b.sendBroadcast(localIntent);
    }
  }
  
  public boolean g()
  {
    return this.d.c == 1;
  }
  
  public void h(int paramInt)
  {
    if (paramInt != this.d.a)
    {
      this.d.a = paramInt;
      h();
    }
  }
  
  public void i(int paramInt)
  {
    if (paramInt != this.d.e)
    {
      this.d.e = paramInt;
      h();
    }
  }
  
  public void j(int paramInt)
  {
    Intent localIntent;
    if (paramInt != this.d.i)
    {
      this.d.i = paramInt;
      localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_FESTIVAL");
      if (this.d.i != 1) {
        break label58;
      }
      localIntent.putExtra("festival", 1);
    }
    for (;;)
    {
      this.b.sendBroadcast(localIntent);
      return;
      label58:
      if (this.d.i == 2) {
        localIntent.putExtra("festival", 2);
      } else if (this.d.i == 3) {
        localIntent.putExtra("festival", 3);
      } else {
        localIntent.putExtra("festival", 0);
      }
    }
  }
  
  public void k(int paramInt)
  {
    if (this.d.h != paramInt)
    {
      this.d.h = paramInt;
      Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LUNAR");
      localIntent.putExtra("lunar", this.d.h);
      this.b.sendBroadcast(localIntent);
    }
  }
  
  public void l(int paramInt)
  {
    if (this.d.j != paramInt)
    {
      this.d.j = paramInt;
      Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_CYCLE_MODE");
      localIntent.putExtra("cycle", this.d.j);
      this.b.sendBroadcast(localIntent);
    }
  }
  
  public void m(int paramInt)
  {
    if (this.d.E != paramInt)
    {
      this.d.E = paramInt;
      Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_GOWIDGET_DYNAMIC_ICON_CHANGE");
      localIntent.putExtra("extra_is_on", this.d.E);
      this.b.sendBroadcast(localIntent);
    }
  }
  
  public void n(int paramInt)
  {
    if (this.d.L != paramInt)
    {
      this.d.L = paramInt;
      Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_THEME_SWITCHER_CHANGE");
      localIntent.putExtra("extra_theme_switcher", paramInt);
      this.b.sendBroadcast(localIntent);
    }
  }
  
  public void o(int paramInt)
  {
    if (paramInt != this.d.s)
    {
      this.d.s = paramInt;
      Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService");
      localIntent.putExtra("notify_request", 4);
      this.b.startService(localIntent);
    }
  }
  
  public void p(int paramInt)
  {
    if (paramInt != this.d.t) {
      this.d.t = paramInt;
    }
  }
  
  public void q(int paramInt)
  {
    if (paramInt != this.d.u)
    {
      this.d.u = paramInt;
      Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService");
      localIntent.putExtra("notify_request", 4);
      this.b.startService(localIntent);
    }
  }
  
  public void r(int paramInt)
  {
    if (paramInt != this.d.v) {
      this.d.v = paramInt;
    }
  }
  
  public void s(int paramInt)
  {
    if (paramInt != this.d.w) {
      this.d.w = paramInt;
    }
  }
  
  public void t(int paramInt)
  {
    if (paramInt != this.d.c) {
      this.d.c = paramInt;
    }
  }
  
  public void u(int paramInt)
  {
    if (paramInt != this.d.l)
    {
      this.d.l = paramInt;
      Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CHANGE_DYNAMIC_BG");
      this.b.sendBroadcast(localIntent);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */