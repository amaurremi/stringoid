package com.gau.go.launcherex.gowidget.weather.systemwidget;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.weather.model.x;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gtp.a.a.b.c;

public class v
{
  private static v a;
  private w b = new w(paramContext.getContentResolver(), this);
  
  private v(Context paramContext) {}
  
  public static v a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new v(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 0)
    {
      this.b.a(0, null, WeatherContentProvider.t, "widget_id=?", new String[] { String.valueOf(paramInt) });
      c.a("AppWidgetIdManager", "DELETE WIDGET_ID = " + paramInt);
    }
  }
  
  public void a(x paramx)
  {
    ContentValues localContentValues;
    if ((paramx != null) && (paramx.a() != 0))
    {
      localContentValues = new ContentValues();
      localContentValues.put("widget_id", Integer.valueOf(paramx.a()));
      localContentValues.put("widget_type", Integer.valueOf(paramx.d()));
      localContentValues.put("widget_location_type", Integer.valueOf(paramx.e()));
      if (paramx.d() != 6) {
        break label116;
      }
      localContentValues.put("current_cityid", paramx.b() + "#" + paramx.c());
    }
    for (;;)
    {
      this.b.a(0, null, WeatherContentProvider.t, localContentValues);
      return;
      label116:
      localContentValues.put("current_cityid", paramx.b());
    }
  }
  
  public void b(int paramInt)
  {
    this.b.a(0, null, WeatherContentProvider.t, "widget_type=?", new String[] { String.valueOf(paramInt) });
    c.a("AppWidgetIdManager", "DELETE WIDGET_TYPE = " + paramInt);
  }
  
  public void b(x paramx)
  {
    ContentValues localContentValues;
    if ((paramx != null) && (paramx.a() != 0) && (!TextUtils.isEmpty(paramx.b())))
    {
      localContentValues = new ContentValues();
      localContentValues.put("widget_location_type", Integer.valueOf(paramx.e()));
      if (paramx.d() != 6) {
        break label116;
      }
      localContentValues.put("current_cityid", paramx.b() + "#" + paramx.c());
    }
    for (;;)
    {
      this.b.a(0, null, WeatherContentProvider.t, localContentValues, "widget_id=?", new String[] { String.valueOf(paramx.a()) });
      return;
      label116:
      localContentValues.put("current_cityid", paramx.b());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */