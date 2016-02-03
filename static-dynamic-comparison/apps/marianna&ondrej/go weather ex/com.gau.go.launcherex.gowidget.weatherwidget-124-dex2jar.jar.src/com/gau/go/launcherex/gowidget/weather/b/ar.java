package com.gau.go.launcherex.gowidget.weather.b;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.service.NotifyService;
import java.util.Iterator;
import java.util.Set;

public class ar
{
  private Context a;
  private e b;
  
  public ar(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    this.b = com.gau.go.launcherex.gowidget.weather.c.c.a(this.a).f();
  }
  
  private void a(ContentValues paramContentValues)
  {
    Iterator localIterator = paramContentValues.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ("dynamic_bg_switch".equals(str))
      {
        if (paramContentValues.getAsBoolean(str).booleanValue()) {}
        for (int i = 1;; i = 0)
        {
          this.b.u(i);
          this.b.a(WeatherContentProvider.g, "setting_key", "dynamic_bg_switch", "setting_value", i);
          break;
        }
      }
    }
  }
  
  public static void a(Context paramContext, ContentValues paramContentValues)
  {
    Intent localIntent = new Intent(paramContext, NotifyService.class);
    localIntent.putExtra("notify_request", 52);
    localIntent.putExtra("settings_contentvalues", paramContentValues);
    paramContext.startService(localIntent);
  }
  
  public static boolean a(Context paramContext)
  {
    bool1 = false;
    bool2 = false;
    paramContext = paramContext.getContentResolver().query(WeatherContentProvider.g, new String[] { "setting_value" }, "setting_key=?", new String[] { "dynamic_bg_switch" }, null);
    if (paramContext != null) {}
    for (bool1 = bool2;; bool1 = false)
    {
      try
      {
        if (paramContext.moveToFirst())
        {
          int i = paramContext.getInt(paramContext.getColumnIndex("setting_value"));
          if (i != 1) {
            continue;
          }
          bool1 = true;
        }
      }
      catch (SQLException localSQLException)
      {
        for (;;)
        {
          bool1 = bool2;
          if (com.gtp.a.a.b.c.a())
          {
            localSQLException.printStackTrace();
            bool1 = bool2;
          }
        }
      }
      finally
      {
        paramContext.close();
      }
      paramContext.close();
      return bool1;
    }
  }
  
  public void a() {}
  
  public void a(Intent paramIntent)
  {
    paramIntent = (ContentValues)paramIntent.getParcelableExtra("settings_contentvalues");
    com.gau.go.launcherex.gowidget.weather.c.c localc = com.gau.go.launcherex.gowidget.weather.c.c.a(this.a);
    if (localc.b())
    {
      a(paramIntent);
      return;
    }
    localc.a(new as(this, paramIntent, localc));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */