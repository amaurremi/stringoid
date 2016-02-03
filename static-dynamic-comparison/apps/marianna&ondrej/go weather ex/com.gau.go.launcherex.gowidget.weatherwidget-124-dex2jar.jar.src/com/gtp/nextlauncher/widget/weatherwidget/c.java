package com.gtp.nextlauncher.widget.weatherwidget;

import android.content.ContentResolver;
import android.database.Cursor;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.jiubang.core.c.j;

class c
  extends j
{
  public c(ClearManager paramClearManager, ContentResolver paramContentResolver)
  {
    super(paramContentResolver);
  }
  
  protected void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    super.a(paramInt, paramObject, paramCursor);
    if ((paramCursor != null) && (paramCursor.getCount() > 0)) {
      while (paramCursor.moveToNext()) {
        paramCursor.getString(0);
      }
    }
  }
  
  protected void b(int paramInt1, Object paramObject, int paramInt2)
  {
    super.b(paramInt1, paramObject, paramInt2);
    ClearManager.a(this.a).a(-1, null, WeatherContentProvider.D, new String[] { "city_id" }, null, null, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */