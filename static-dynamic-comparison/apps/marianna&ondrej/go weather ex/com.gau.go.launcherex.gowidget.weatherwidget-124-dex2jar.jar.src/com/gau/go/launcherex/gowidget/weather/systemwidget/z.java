package com.gau.go.launcherex.gowidget.weather.systemwidget;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import java.lang.ref.SoftReference;

class z
  extends AsyncQueryHandler
{
  private SoftReference a;
  
  public z(ContentResolver paramContentResolver, x paramx)
  {
    super(paramContentResolver);
    this.a = new SoftReference(paramx);
  }
  
  protected void onQueryComplete(int paramInt, Object paramObject, Cursor paramCursor)
  {
    x localx;
    if ((paramCursor != null) && (this.a != null))
    {
      localx = (x)this.a.get();
      if (localx != null) {
        break label29;
      }
    }
    label29:
    do
    {
      return;
      switch (paramInt)
      {
      default: 
        return;
      case 1: 
        x.a(localx, paramCursor);
        if (paramObject == null) {}
        for (paramObject = ""; ((String)paramObject).equals("need_query_setting"); paramObject = (String)paramObject)
        {
          x.a(localx).startQuery(2, null, WeatherContentProvider.g, new String[] { "setting_key", "setting_value" }, "setting_key in ('tempUnit', 'calendarType', 'festival', 'dateStyle', 'world_clock', 'windUnit', 'widgt_calendar', 'widgt_clock', 'auto_location', 'app_widget_theme')", null, null);
          return;
        }
      }
    } while (!((String)paramObject).equals("need_notify_widget"));
    x.b(localx, "Google_play_billing");
    return;
    x.b(localx, paramCursor);
    x.a(localx, false);
    localx.a = true;
    x.b(localx, "");
    return;
    x.a(localx, (String)paramObject, paramCursor);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */