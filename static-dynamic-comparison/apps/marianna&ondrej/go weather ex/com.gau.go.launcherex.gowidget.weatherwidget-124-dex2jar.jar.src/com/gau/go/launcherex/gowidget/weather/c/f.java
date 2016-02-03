package com.gau.go.launcherex.gowidget.weather.c;

import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.jiubang.core.c.j;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;

class f
  extends j
{
  private SoftReference c;
  
  public f(e parame1, ContentResolver paramContentResolver, e parame2)
  {
    super(paramContentResolver);
    this.c = new SoftReference(parame2);
  }
  
  protected void a(int paramInt1, Object paramObject, int paramInt2)
  {
    super.a(paramInt1, paramObject, paramInt2);
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LIVE_WALLPAPER_SETTINGS_CHANGE");
      e.d(this.a).sendBroadcast(localIntent);
      paramInt1 = ((Integer)paramObject).intValue();
      paramObject = new ContentValues();
      ((ContentValues)paramObject).put("setting_value", Integer.valueOf(paramInt1));
      a(-1, null, WeatherContentProvider.g, (ContentValues)paramObject, "setting_key=?", new String[] { "key_live_wallpaper_city_flag" });
      return;
    }
    e.a(this.a, paramObject);
  }
  
  protected void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    int i = -1;
    super.a(paramInt, paramObject, paramCursor);
    Object localObject = (e)this.c.get();
    if (localObject != null) {}
    switch (paramInt)
    {
    case 3: 
    default: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          return;
          e.a((e)localObject, paramCursor);
          ((e)localObject).a(1);
        } while (e.a(this.a).D != 1);
        e.b(this.a);
        return;
      } while (paramCursor == null);
    }
    for (;;)
    {
      try
      {
        if (paramCursor.moveToFirst())
        {
          localObject = paramCursor.getString(0);
          paramObject = ((ArrayList)paramObject).iterator();
          if (((Iterator)paramObject).hasNext())
          {
            if (!((String)localObject).equals((String)((Iterator)paramObject).next())) {
              continue;
            }
            localObject = (WeatherBean)e.c(this.a).d().get(0);
            if (localObject == null) {
              break label419;
            }
            paramObject = ((WeatherBean)localObject).c();
            if (((WeatherBean)localObject).e() != 1) {
              continue;
            }
            paramInt = 1;
            localObject = new ContentValues();
            ((ContentValues)localObject).put("setting_value", (String)paramObject);
            a(1, Integer.valueOf(paramInt), WeatherContentProvider.g, (ContentValues)localObject, "setting_key=?", new String[] { "key_live_wallpaper_city_id" });
          }
        }
        return;
        paramInt = 2;
        continue;
        if (paramCursor == null) {
          break;
        }
      }
      catch (SQLException paramObject)
      {
        return;
      }
      finally
      {
        paramCursor.close();
      }
      for (;;)
      {
        try
        {
          if ((paramCursor.moveToFirst()) && (paramCursor.getInt(0) == 2))
          {
            paramObject = e.c(this.a).d().iterator();
            if (((Iterator)paramObject).hasNext())
            {
              localObject = (WeatherBean)((Iterator)paramObject).next();
              if (((WeatherBean)localObject).e() != 1) {
                continue;
              }
              paramObject = ((WeatherBean)localObject).c();
              paramInt = 1;
              localObject = new ContentValues();
              ((ContentValues)localObject).put("setting_value", (String)paramObject);
              a(1, Integer.valueOf(paramInt), WeatherContentProvider.g, (ContentValues)localObject, "setting_key=?", new String[] { "key_live_wallpaper_city_id" });
            }
          }
          else
          {
            return;
          }
        }
        catch (SQLException paramObject)
        {
          return;
        }
        finally
        {
          paramCursor.close();
        }
        paramInt = -1;
        paramObject = "--";
      }
      label419:
      paramObject = "--";
      paramInt = i;
    }
  }
  
  protected void a(int paramInt, Object paramObject, ContentProviderResult[] paramArrayOfContentProviderResult)
  {
    super.a(paramInt, paramObject, paramArrayOfContentProviderResult);
    if (paramInt == 1)
    {
      paramObject = (Object[])paramObject;
      bool1 = ((Boolean)paramObject[0]).booleanValue();
      bool2 = ((Boolean)paramObject[1]).booleanValue();
      paramObject = (ArrayList)paramObject[2];
      this.a.a(e.a(this.a).b, bool2);
      if (bool1) {
        this.a.a((ArrayList)paramObject);
      }
    }
    while ((paramInt != 2) || (e.a(this.a).m != 1))
    {
      boolean bool1;
      boolean bool2;
      return;
    }
    e.e(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */