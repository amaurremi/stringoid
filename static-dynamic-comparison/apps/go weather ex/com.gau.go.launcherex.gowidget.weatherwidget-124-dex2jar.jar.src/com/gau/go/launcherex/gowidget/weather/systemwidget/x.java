package com.gau.go.launcherex.gowidget.weather.systemwidget;

import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import java.util.ArrayList;
import java.util.Iterator;

public class x
{
  private static volatile x b;
  public boolean a = false;
  private z c;
  private Context d;
  private q e = new q();
  private y f;
  private boolean g = false;
  private ArrayList h = new ArrayList();
  
  private x(Context paramContext)
  {
    this.d = paramContext.getApplicationContext();
    this.c = new z(this.d.getContentResolver(), this);
    this.f = new y(this);
    paramContext = new IntentFilter();
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_THEME_PACKAGE_REMOVED");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_THEME_CHANGE");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_TEMPERATURE_UNIT");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LUNAR");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_FESTIVAL");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATESTYLE_UNIT");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WORLD_CLOCK");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIND_UNIT");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.action_clock_binding_app");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.action_calendar_binding_app");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_AUTO_LOCATION");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE");
    this.d.registerReceiver(this.f, paramContext);
    c();
  }
  
  public static x a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new x(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  private void a(Cursor paramCursor)
  {
    boolean bool = true;
    if (paramCursor != null) {}
    for (;;)
    {
      try
      {
        paramCursor.moveToFirst();
        q localq = this.e;
        if (paramCursor.getInt(0) == 1) {
          localq.J = bool;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        try
        {
          paramCursor.close();
          return;
        }
        catch (Exception paramCursor) {}
        paramCursor.printStackTrace();
        return;
      }
      finally
      {
        try
        {
          paramCursor.close();
          throw ((Throwable)localObject);
        }
        catch (Exception paramCursor)
        {
          paramCursor.printStackTrace();
          continue;
        }
      }
      try
      {
        paramCursor.close();
        return;
      }
      catch (Exception paramCursor)
      {
        continue;
      }
      bool = false;
    }
  }
  
  private void a(String paramString)
  {
    this.c.startQuery(3, paramString, WeatherContentProvider.g, new String[] { "setting_key", "setting_value" }, "setting_key=?", new String[] { paramString }, null);
  }
  
  private void a(String paramString, Cursor paramCursor)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramCursor == null)) {
      return;
    }
    int i;
    if (paramCursor.getCount() > 0)
    {
      paramCursor.moveToFirst();
      i = paramCursor.getColumnIndex("setting_value");
      if (i != -1)
      {
        if (!paramString.equals("world_clock")) {
          break label83;
        }
        this.e.r = paramCursor.getInt(i);
      }
    }
    for (;;)
    {
      b(paramString);
      try
      {
        paramCursor.close();
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      label83:
      if (paramString.equals("tempUnit"))
      {
        i = paramCursor.getInt(i);
        if (this.e.g != i) {
          this.e.g = i;
        }
      }
      else if (paramString.equals("windUnit"))
      {
        i = paramCursor.getInt(i);
        if (this.e.q != i) {
          this.e.q = i;
        }
      }
      else
      {
        String str;
        if (paramString.equals("app_widget_theme"))
        {
          str = paramCursor.getString(i);
          if (!this.e.G.equals(str)) {
            this.e.G = str;
          }
        }
        else if (paramString.equals("auto_location"))
        {
          i = paramCursor.getInt(i);
          if (this.e.b != i) {
            this.e.b = i;
          }
        }
        else if (paramString.equals("dateStyle"))
        {
          i = paramCursor.getInt(i);
          if (this.e.k != i) {
            this.e.k = i;
          }
        }
        else if (paramString.equals("widgt_calendar"))
        {
          str = paramCursor.getString(i);
          if ((!TextUtils.isEmpty(str)) && (!this.e.I.equals(str))) {
            this.e.I = str;
          }
        }
        else if (paramString.equals("widgt_clock"))
        {
          str = paramCursor.getString(i);
          if ((!TextUtils.isEmpty(str)) && (!this.e.H.equals(str))) {
            this.e.H = str;
          }
        }
        else if (paramString.equals("calendarType"))
        {
          i = paramCursor.getInt(i);
          if (this.e.h != i) {
            this.e.h = i;
          }
        }
        else if (paramString.equals("festival"))
        {
          i = paramCursor.getInt(i);
          if (this.e.i != i) {
            this.e.i = i;
          }
        }
      }
    }
  }
  
  public static void b()
  {
    if (b != null)
    {
      b.d();
      b = null;
    }
  }
  
  private void b(Cursor paramCursor)
  {
    for (;;)
    {
      int j;
      try
      {
        if (paramCursor.getCount() > 0)
        {
          paramCursor.moveToFirst();
          int i = paramCursor.getColumnIndex("setting_key");
          j = paramCursor.getColumnIndex("setting_value");
          str1 = paramCursor.getString(i);
          if (str1.equals("tempUnit")) {
            this.e.g = paramCursor.getInt(j);
          }
          if (!str1.equals("windUnit")) {
            continue;
          }
          this.e.q = paramCursor.getInt(j);
          boolean bool = paramCursor.moveToNext();
          if (bool) {
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        String str1;
        localException.printStackTrace();
        continue;
      }
      finally
      {
        paramCursor.close();
      }
      paramCursor.close();
      return;
      if (str1.equals("calendarType"))
      {
        this.e.h = paramCursor.getInt(j);
      }
      else if (((String)localObject).equals("festival"))
      {
        this.e.i = paramCursor.getInt(j);
      }
      else if (((String)localObject).equals("dateStyle"))
      {
        this.e.k = paramCursor.getInt(j);
      }
      else if (((String)localObject).equals("world_clock"))
      {
        this.e.r = paramCursor.getInt(j);
      }
      else
      {
        String str2;
        if (((String)localObject).equals("widgt_calendar"))
        {
          str2 = paramCursor.getString(j);
          if (!TextUtils.isEmpty(str2)) {
            this.e.I = str2;
          }
        }
        else if (str2.equals("widgt_clock"))
        {
          str2 = paramCursor.getString(j);
          if (!TextUtils.isEmpty(str2)) {
            this.e.H = str2;
          }
        }
        else if (str2.equals("app_widget_theme"))
        {
          this.e.G = paramCursor.getString(j);
        }
        else if (str2.equals("auto_location"))
        {
          this.e.b = paramCursor.getInt(j);
        }
      }
    }
  }
  
  private void b(String paramString)
  {
    Iterator localIterator = new ArrayList(this.h).iterator();
    while (localIterator.hasNext()) {
      ((aa)localIterator.next()).a(paramString, a());
    }
  }
  
  private void c()
  {
    if (!this.g)
    {
      this.g = true;
      this.c.startQuery(1, "need_query_setting", WeatherContentProvider.j, null, null, null, null);
    }
  }
  
  private void d()
  {
    this.d.unregisterReceiver(this.f);
    this.h.clear();
    this.g = false;
    this.a = false;
  }
  
  public q a()
  {
    return this.e;
  }
  
  public void a(aa paramaa)
  {
    if ((paramaa != null) && (!this.h.contains(paramaa))) {
      this.h.add(paramaa);
    }
  }
  
  public void b(aa paramaa)
  {
    this.h.remove(paramaa);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */