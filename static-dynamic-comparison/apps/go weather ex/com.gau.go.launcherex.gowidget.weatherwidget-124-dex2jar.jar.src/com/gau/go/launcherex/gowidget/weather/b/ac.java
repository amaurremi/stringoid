package com.gau.go.launcherex.gowidget.weather.b;

import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import com.gau.go.launcherex.gowidget.weather.model.b;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.jiubang.core.c.j;

class ac
  extends j
{
  public ac(aa paramaa, ContentResolver paramContentResolver)
  {
    super(paramContentResolver);
  }
  
  protected void a(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt2 > 0) {}
    switch (paramInt1)
    {
    default: 
      return;
    }
    paramObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LIVE_WALLPAPER_SETTINGS_CHANGE");
    aa.b(this.a).sendBroadcast((Intent)paramObject);
    paramObject = new ContentValues();
    ((ContentValues)paramObject).put("setting_value", Integer.valueOf(2));
    a(-1, null, WeatherContentProvider.g, (ContentValues)paramObject, "setting_key=?", new String[] { "key_live_wallpaper_city_flag" });
  }
  
  protected void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
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
      try
      {
        if (paramCursor.moveToNext())
        {
          paramInt = paramCursor.getInt(0);
          if ((paramInt == 2) || (paramInt == -1))
          {
            ContentValues localContentValues = new ContentValues();
            localContentValues.put("setting_value", ((b)paramObject).a());
            a(2, null, WeatherContentProvider.g, localContentValues, "setting_key=?", new String[] { "key_live_wallpaper_city_id" });
          }
        }
      }
      catch (SQLException paramObject) {}
    }
  }
  
  protected void a(int paramInt, Object paramObject, ContentProviderResult[] paramArrayOfContentProviderResult)
  {
    super.a(paramInt, paramObject, paramArrayOfContentProviderResult);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */