package com.gau.go.launcherex.gowidget.weather.b;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.gau.go.launcherex.goweather.livewallpaper.b.h;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.e;
import com.gau.go.launcherex.gowidget.weather.model.u;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.service.ThemeService;
import com.jiubang.core.c.j;
import java.util.HashMap;

class f
  extends j
{
  public f(a parama, ContentResolver paramContentResolver, Context paramContext)
  {
    super(paramContentResolver);
  }
  
  protected void a(int paramInt1, Object paramObject, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
      } while (a.c(this.a) == null);
      a.c(this.a).b();
      a.c(this.a).c();
      return;
      if ((paramInt2 > 0) && (h.a(a.e(this.a))))
      {
        paramObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LIVE_WALLPAPER_THEME_CHANGE");
        a.e(this.a).sendBroadcast((Intent)paramObject);
      }
      if (a.c(this.a) != null)
      {
        a.c(this.a).b();
        a.c(this.a).c();
      }
      if (paramInt2 > 0)
      {
        paramObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APP_THEME_CHANGE");
        ((Intent)paramObject).putExtra("extra_app_theme_package", "com.gau.go.launcherex.gowidget.weatherwidget");
        a.e(this.a).sendBroadcast((Intent)paramObject);
      }
    } while (a.c(this.a) == null);
    a.c(this.a).b();
    a.c(this.a).c();
  }
  
  protected void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    super.a(paramInt, paramObject, paramCursor);
    if (paramCursor == null) {
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramCursor.close();
      return;
      if (paramCursor.moveToNext()) {
        a.a(this.a).a(Long.valueOf(paramCursor.getString(0)).longValue());
      }
      if (a.b(this.a) == null)
      {
        a.a(this.a, new d(this.a, null));
        a.b(this.a).execute(new Void[0]);
        continue;
        Object localObject3 = (String)paramObject;
        int i = paramCursor.getColumnCount();
        Object localObject4 = new HashMap();
        Object localObject1;
        Object localObject2;
        while (paramCursor.moveToNext())
        {
          paramInt = 0;
          paramObject = null;
          localObject1 = null;
          if (paramInt < i)
          {
            String str = paramCursor.getColumnName(paramInt);
            if (str.equals("setting_value")) {
              localObject2 = paramCursor.getString(paramInt);
            }
            for (;;)
            {
              paramInt += 1;
              paramObject = localObject2;
              break;
              localObject2 = paramObject;
              if (str.equals("setting_key"))
              {
                localObject1 = paramCursor.getString(paramInt);
                localObject2 = paramObject;
              }
            }
          }
          if ((localObject1 != null) && (paramObject != null)) {
            ((HashMap)localObject4).put(localObject1, paramObject);
          }
        }
        paramObject = (String)((HashMap)localObject4).get("app_theme");
        if ((paramObject != null) && (((String)localObject3).equals(paramObject)))
        {
          if (a.c(this.a) != null) {
            a.c(this.a).a();
          }
          paramObject = new ContentValues();
          ((ContentValues)paramObject).put("setting_value", "com.gau.go.launcherex.gowidget.weatherwidget");
          a.d(this.a).a(7, null, WeatherContentProvider.g, (ContentValues)paramObject, "setting_key=?", new String[] { "app_theme" });
        }
        paramObject = (String)((HashMap)localObject4).get("key_live_wallpaper_theme");
        if ((paramObject != null) && (((String)localObject3).equals(paramObject)))
        {
          if (a.c(this.a) != null) {
            a.c(this.a).a();
          }
          paramObject = new ContentValues();
          ((ContentValues)paramObject).put("setting_value", "com.gau.go.launcherex.gowidget.weatherwidget");
          a.d(this.a).a(8, null, WeatherContentProvider.g, (ContentValues)paramObject, "setting_key=?", new String[] { "key_live_wallpaper_theme" });
        }
        if (a.c(this.a) != null)
        {
          a.c(this.a).b();
          a.c(this.a).c();
          continue;
          i = paramCursor.getColumnCount();
          localObject3 = new HashMap();
          while (paramCursor.moveToNext())
          {
            paramInt = 0;
            paramObject = null;
            localObject1 = null;
            if (paramInt < i)
            {
              localObject4 = paramCursor.getColumnName(paramInt);
              if (((String)localObject4).equals("setting_value")) {
                localObject2 = paramCursor.getString(paramInt);
              }
              for (;;)
              {
                paramInt += 1;
                paramObject = localObject2;
                break;
                localObject2 = paramObject;
                if (((String)localObject4).equals("setting_key"))
                {
                  localObject1 = paramCursor.getString(paramInt);
                  localObject2 = paramObject;
                }
              }
            }
            if ((localObject1 != null) && (paramObject != null)) {
              ((HashMap)localObject3).put(localObject1, paramObject);
            }
          }
          paramObject = (String)((HashMap)localObject3).get("app_theme");
          localObject1 = com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.a(a.e(this.a), (String)paramObject, a.e(this.a).getResources());
          if ((paramObject != null) && (!((String)paramObject).equals("com.gau.go.launcherex.gowidget.weatherwidget")) && (localObject1 != null) && (((e)localObject1).l() == 2))
          {
            if (a.c(this.a) != null) {
              a.c(this.a).a();
            }
            paramObject = new ContentValues();
            ((ContentValues)paramObject).put("setting_value", "com.gau.go.launcherex.gowidget.weatherwidget");
            a.d(this.a).a(7, null, WeatherContentProvider.g, (ContentValues)paramObject, "setting_key=?", new String[] { "app_theme" });
          }
          paramObject = (String)((HashMap)localObject3).get("key_live_wallpaper_theme");
          localObject1 = com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.a(a.e(this.a), (String)paramObject, a.e(this.a).getResources());
          if ((paramObject != null) && (!((String)paramObject).equals("com.gau.go.launcherex.gowidget.weatherwidget")) && (localObject1 != null) && (((e)localObject1).l() == 2))
          {
            if (a.c(this.a) != null) {
              a.c(this.a).a();
            }
            paramObject = new ContentValues();
            ((ContentValues)paramObject).put("setting_value", "com.gau.go.launcherex.gowidget.weatherwidget");
            a.d(this.a).a(8, null, WeatherContentProvider.g, (ContentValues)paramObject, "setting_key=?", new String[] { "key_live_wallpaper_theme" });
          }
          if (a.c(this.a) != null)
          {
            a.c(this.a).b();
            a.c(this.a).c();
            continue;
            i = paramCursor.getColumnCount();
            localObject1 = "";
            localObject2 = localObject1;
            if (paramCursor.moveToFirst())
            {
              paramInt = 0;
              for (;;)
              {
                localObject2 = localObject1;
                if (paramInt >= i) {
                  break;
                }
                if (paramCursor.getColumnName(paramInt).equals("setting_value")) {
                  localObject1 = paramCursor.getString(paramInt);
                }
                paramInt += 1;
              }
            }
            if ((((String)localObject2).equals((String)paramObject)) && (h.a(a.e(this.a))))
            {
              paramObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LIVE_WALLPAPER_THEME_CHANGE");
              a.e(this.a).sendBroadcast((Intent)paramObject);
            }
            if (a.c(this.a) != null)
            {
              a.c(this.a).b();
              a.c(this.a).c();
            }
          }
        }
      }
    }
  }
  
  protected void a(int paramInt, Object paramObject, Uri paramUri)
  {
    super.a(paramInt, paramObject, paramUri);
  }
  
  protected void b(int paramInt1, Object paramObject, int paramInt2)
  {
    super.b(paramInt1, paramObject, paramInt2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */