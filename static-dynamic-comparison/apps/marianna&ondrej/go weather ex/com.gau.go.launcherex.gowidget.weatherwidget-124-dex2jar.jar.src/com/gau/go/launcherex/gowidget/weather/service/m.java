package com.gau.go.launcherex.gowidget.weather.service;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.SparseArray;
import com.gau.go.launcherex.gowidget.weather.e.b;
import com.gau.go.launcherex.gowidget.weather.e.f;
import com.gau.go.launcherex.gowidget.weather.e.i;
import com.gau.go.launcherex.gowidget.weather.e.o;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.WidgetSettingBean;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.util.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class m
  extends g
{
  public m(WeatherService paramWeatherService) {}
  
  private void a(ContentResolver paramContentResolver, Map paramMap)
  {
    paramContentResolver = paramContentResolver.query(WeatherContentProvider.a, b.a(), null, null, "sequence");
    if (paramContentResolver != null) {
      if (paramContentResolver.moveToFirst()) {
        do
        {
          WeatherBean localWeatherBean = new WeatherBean();
          localWeatherBean.a(paramContentResolver);
          paramMap.put(localWeatherBean.c(), localWeatherBean);
        } while (paramContentResolver.moveToNext());
      }
    }
    try
    {
      paramContentResolver.close();
      return;
    }
    catch (Exception paramContentResolver)
    {
      paramContentResolver.printStackTrace();
    }
  }
  
  private void b(ContentResolver paramContentResolver, Map paramMap)
  {
    paramContentResolver = paramContentResolver.query(WeatherContentProvider.e, i.a(), null, null, "cityId");
    if (paramContentResolver != null) {
      if (paramContentResolver.moveToFirst())
      {
        int i = paramContentResolver.getColumnIndex("cityId");
        do
        {
          WeatherBean localWeatherBean = (WeatherBean)paramMap.get(paramContentResolver.getString(i));
          if (localWeatherBean != null) {
            localWeatherBean.b(paramContentResolver);
          }
        } while (paramContentResolver.moveToNext());
      }
    }
    try
    {
      paramContentResolver.close();
      return;
    }
    catch (Exception paramContentResolver)
    {
      paramContentResolver.printStackTrace();
    }
  }
  
  private void c(ContentResolver paramContentResolver, Map paramMap)
  {
    paramContentResolver = paramContentResolver.query(WeatherContentProvider.b, com.gau.go.launcherex.gowidget.weather.e.g.a(), null, null, "cityId");
    if (paramContentResolver != null) {
      if (paramContentResolver.moveToFirst())
      {
        int i = paramContentResolver.getColumnIndex("cityId");
        do
        {
          WeatherBean localWeatherBean = (WeatherBean)paramMap.get(paramContentResolver.getString(i));
          if (localWeatherBean != null) {
            localWeatherBean.c(paramContentResolver);
          }
        } while (paramContentResolver.moveToNext());
      }
    }
    try
    {
      paramContentResolver.close();
      return;
    }
    catch (Exception paramContentResolver)
    {
      paramContentResolver.printStackTrace();
    }
  }
  
  private void d(ContentResolver paramContentResolver, Map paramMap)
  {
    paramContentResolver = paramContentResolver.query(WeatherContentProvider.G, com.gau.go.launcherex.gowidget.weather.e.n.a(), null, null, "cityId");
    if (paramContentResolver != null) {
      if (paramContentResolver.moveToFirst())
      {
        int i = paramContentResolver.getColumnIndex("cityId");
        do
        {
          WeatherBean localWeatherBean = (WeatherBean)paramMap.get(paramContentResolver.getString(i));
          if (localWeatherBean != null) {
            localWeatherBean.e(paramContentResolver);
          }
        } while (paramContentResolver.moveToNext());
      }
    }
    try
    {
      paramContentResolver.close();
      return;
    }
    catch (Exception paramContentResolver)
    {
      paramContentResolver.printStackTrace();
    }
  }
  
  private void e(ContentResolver paramContentResolver, Map paramMap)
  {
    paramContentResolver = paramContentResolver.query(WeatherContentProvider.H, o.a(), null, null, "cityId");
    if (paramContentResolver != null) {
      if (paramContentResolver.moveToFirst())
      {
        int i = paramContentResolver.getColumnIndex("cityId");
        do
        {
          WeatherBean localWeatherBean = (WeatherBean)paramMap.get(paramContentResolver.getString(i));
          if (localWeatherBean != null) {
            localWeatherBean.f(paramContentResolver);
          }
        } while (paramContentResolver.moveToNext());
      }
    }
    try
    {
      paramContentResolver.close();
      return;
    }
    catch (Exception paramContentResolver)
    {
      paramContentResolver.printStackTrace();
    }
  }
  
  private void f(ContentResolver paramContentResolver, Map paramMap)
  {
    paramContentResolver = paramContentResolver.query(WeatherContentProvider.k, f.a(), null, null, "cityId");
    if (paramContentResolver != null) {
      if (paramContentResolver.moveToFirst()) {
        do
        {
          com.gau.go.launcherex.gowidget.weather.model.c localc = WeatherBean.d(paramContentResolver);
          WeatherBean localWeatherBean = (WeatherBean)paramMap.get(localc.j());
          if (localWeatherBean != null)
          {
            localc.a(r.c(localc.d()));
            localWeatherBean.l.put(Integer.valueOf(localc.k()), localc);
          }
        } while (paramContentResolver.moveToNext());
      }
    }
    try
    {
      paramContentResolver.close();
      return;
    }
    catch (Exception paramContentResolver)
    {
      paramContentResolver.printStackTrace();
    }
  }
  
  public String a(int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Cursor localCursor = this.a.getContentResolver().query(WeatherContentProvider.l, new String[] { "city_id" }, "go_widget_id=?", new String[] { String.valueOf(paramInt) }, null);
    if (localCursor != null)
    {
      localObject1 = localObject2;
      if (localCursor.moveToFirst()) {
        localObject1 = localCursor.getString(0);
      }
    }
    try
    {
      localCursor.close();
      return (String)localObject1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return (String)localObject1;
  }
  
  public String a(String paramString)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    Cursor localCursor;
    if (!TextUtils.isEmpty(paramString))
    {
      localCursor = this.a.getContentResolver().query(WeatherContentProvider.g, new String[] { "setting_value" }, "setting_key=?", new String[] { paramString }, null);
      localObject1 = localObject3;
      if (localCursor != null)
      {
        paramString = (String)localObject2;
        if (localCursor.moveToFirst()) {
          paramString = localCursor.getString(0);
        }
      }
    }
    try
    {
      localCursor.close();
      localObject1 = paramString;
      return (String)localObject1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramString;
  }
  
  public List a()
  {
    Object localObject = new HashMap();
    ContentResolver localContentResolver = this.a.getContentResolver();
    a(localContentResolver, (Map)localObject);
    if (!((Map)localObject).isEmpty())
    {
      b(localContentResolver, (Map)localObject);
      c(localContentResolver, (Map)localObject);
      d(localContentResolver, (Map)localObject);
      e(localContentResolver, (Map)localObject);
      f(localContentResolver, (Map)localObject);
    }
    localObject = new ArrayList(((Map)localObject).values());
    Collections.sort((List)localObject, new n(this));
    return (List)localObject;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ContentResolver localContentResolver = this.a.getContentResolver();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("go_widget_type", Integer.valueOf(paramInt2));
    localContentValues.put("go_widget_id", Integer.valueOf(paramInt1));
    localContentValues.put("city_id", "");
    localContentResolver.insert(WeatherContentProvider.l, localContentValues);
    Cursor localCursor = localContentResolver.query(WeatherContentProvider.l, new String[] { "go_widget_id" }, "go_widget_type=?", new String[] { String.valueOf(paramInt2) }, null);
    if (localCursor != null) {
      if (localCursor.moveToFirst()) {
        paramInt1 = localCursor.getCount();
      }
    }
    for (;;)
    {
      try
      {
        localCursor.close();
        localContentValues.clear();
        switch (paramInt2)
        {
        default: 
          localCursor = null;
          if (!TextUtils.isEmpty(localCursor))
          {
            localContentValues.put(localCursor, Integer.valueOf(paramInt1));
            localContentResolver.update(WeatherContentProvider.o, localContentValues, null, null);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
        String str = "count_gowidget_11";
        continue;
        str = "count_gowidget_21";
        continue;
        str = "count_gowidget_41";
        continue;
        str = "count_gowidget_42";
        continue;
        str = "count_gowidget_41_style2";
        continue;
        str = "count_gowidget_days_41";
        continue;
      }
      paramInt1 = 0;
      continue;
      paramInt1 = 0;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    ContentResolver localContentResolver = this.a.getContentResolver();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("go_widget_type", Integer.valueOf(paramInt1));
    localContentValues.put("go_widget_id", String.valueOf(paramInt2));
    localContentValues.put("city_id", paramString);
    if (localContentResolver.update(WeatherContentProvider.l, localContentValues, "go_widget_id=?", new String[] { String.valueOf(paramInt2) }) < 1) {
      localContentResolver.insert(WeatherContentProvider.l, localContentValues);
    }
  }
  
  public void a(c paramc)
  {
    WeatherService.a(this.a).put(paramc.hashCode(), paramc);
  }
  
  public WidgetSettingBean b()
  {
    WidgetSettingBean localWidgetSettingBean = new WidgetSettingBean();
    Object localObject = this.a.getContentResolver();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setting_key").append(" in ('").append("tempUnit").append("', '").append("windUnit").append("', '").append("dateStyle").append("', '").append("widgt_clock").append("', '").append("widgt_calendar").append("', '").append("isCycle").append("', '").append("dynamic_icon_gowidget").append("', '").append("world_clock").append("', '").append("auto_location").append("', '").append("festival").append("', '").append("calendarType").append("', '").append("widget_theme_switcher").append("', '").append("')");
    localObject = ((ContentResolver)localObject).query(WeatherContentProvider.g, com.gau.go.launcherex.gowidget.weather.e.c.a(), localStringBuilder.toString(), null, null);
    if (localObject != null) {
      if (((Cursor)localObject).moveToFirst()) {
        localWidgetSettingBean.a((Cursor)localObject);
      }
    }
    try
    {
      ((Cursor)localObject).close();
      return localWidgetSettingBean;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localWidgetSettingBean;
  }
  
  public void b(int paramInt)
  {
    this.a.getContentResolver().delete(WeatherContentProvider.l, "go_widget_id=?", new String[] { String.valueOf(paramInt) });
  }
  
  public void b(c paramc)
  {
    if (WeatherService.a(this.a).indexOfKey(paramc.hashCode()) != -1) {
      WeatherService.a(this.a).remove(paramc.hashCode());
    }
    if (WeatherService.a(this.a).size() == 0) {
      this.a.stopSelf();
    }
  }
  
  public WeatherBean c()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Cursor localCursor = this.a.getContentResolver().query(WeatherContentProvider.a, b.a(), "city_my_location!=?", new String[] { String.valueOf(1) }, null);
    if (localCursor != null)
    {
      localObject1 = localObject2;
      if (localCursor.moveToFirst())
      {
        localObject1 = new WeatherBean();
        ((WeatherBean)localObject1).a(localCursor);
      }
    }
    try
    {
      localCursor.close();
      return (WeatherBean)localObject1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return (WeatherBean)localObject1;
  }
  
  public boolean d()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Cursor localCursor = this.a.getContentResolver().query(WeatherContentProvider.j, null, null, null, null);
    if (localCursor != null)
    {
      bool1 = bool2;
      if (localCursor.moveToFirst()) {
        if (localCursor.getInt(0) != 1) {
          break label58;
        }
      }
    }
    for (bool1 = true;; bool1 = false) {
      try
      {
        localCursor.close();
        return bool1;
      }
      catch (Exception localException)
      {
        label58:
        localException.printStackTrace();
      }
    }
    return bool1;
  }
  
  public boolean e()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Cursor localCursor = this.a.getContentResolver().query(WeatherContentProvider.o, new String[] { "flag_new_theme" }, null, null, null);
    if (localCursor != null)
    {
      bool1 = bool2;
      if (localCursor.moveToFirst()) {
        if (localCursor.getInt(0) != 1) {
          break label67;
        }
      }
    }
    for (bool1 = true;; bool1 = false) {
      try
      {
        localCursor.close();
        return bool1;
      }
      catch (Exception localException)
      {
        label67:
        localException.printStackTrace();
      }
    }
    return bool1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/service/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */