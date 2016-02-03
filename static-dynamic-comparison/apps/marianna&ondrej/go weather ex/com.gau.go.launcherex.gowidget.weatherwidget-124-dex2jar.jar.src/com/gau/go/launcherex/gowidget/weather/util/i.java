package com.gau.go.launcherex.gowidget.weather.util;

import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.e.b;
import com.gau.go.launcherex.gowidget.weather.e.g;
import com.gau.go.launcherex.gowidget.weather.e.n;
import com.gau.go.launcherex.gowidget.weather.e.o;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.jiubang.core.c.j;
import java.util.ArrayList;
import java.util.Map;

class i
  extends j
{
  public i(f paramf, ContentResolver paramContentResolver)
  {
    super(paramContentResolver);
  }
  
  protected void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    switch (paramInt)
    {
    case 7: 
    case 8: 
    default: 
      return;
    case 2: 
      if (paramCursor == null) {
        break;
      }
    }
    for (paramObject = f.a(this.a, paramCursor);; paramObject = null)
    {
      if (f.a(this.a).isEmpty())
      {
        paramCursor = GoWidgetApplication.c(f.b(this.a)).a();
        if (!paramCursor.getBoolean("key_sync_with_golauncher", false))
        {
          paramCursor = paramCursor.edit();
          paramCursor.putBoolean("key_sync_with_golauncher", true);
          paramCursor.commit();
        }
      }
      for (paramInt = 1; (paramInt == 0) || (!f.c(this.a)); paramInt = 0)
      {
        if ((paramObject != null) && (!((ArrayList)paramObject).isEmpty()))
        {
          f.d(this.a).a(12, null, "com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", (ArrayList)paramObject);
          return;
        }
        f.e(this.a);
        return;
        if (paramCursor != null) {
          f.b(this.a, paramCursor);
        }
        f.d(this.a).a(4, null, WeatherContentProvider.b, g.a(), null, null, "cityId");
        return;
        if (paramCursor != null) {
          f.c(this.a, paramCursor);
        }
        f.d(this.a).a(5, null, WeatherContentProvider.G, n.a(), null, null, "cityId");
        return;
        if (paramCursor != null) {
          this.a.b(paramCursor);
        }
        f.d(this.a).a(6, null, WeatherContentProvider.H, o.a(), null, null, "cityId");
        return;
        if (paramCursor != null) {
          this.a.a(paramCursor);
        }
        f.d(this.a).a(9, null, WeatherContentProvider.k, com.gau.go.launcherex.gowidget.weather.e.f.a(), null, null, "cityId");
        return;
        if (paramCursor != null) {
          f.d(this.a, paramCursor);
        }
        f.a(this.a, 4);
        return;
      }
    }
  }
  
  protected void a(int paramInt, Object paramObject, Uri paramUri)
  {
    if (paramInt == 13)
    {
      paramUri = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_RELOAD_DATA");
      f.b(this.a).sendBroadcast(paramUri);
      paramUri = com.gau.go.launcherex.gowidget.weather.c.a.c(f.b(this.a));
      if (paramUri[0] != -1)
      {
        paramInt = paramUri[0] + 1;
        if (f.f(this.a).g != paramInt) {
          f.g(this.a).a("tempUnit", String.valueOf(paramInt));
        }
      }
      if (paramUri[1] != -1)
      {
        paramInt = paramUri[1] + 1;
        if (f.f(this.a).k != paramInt) {
          f.g(this.a).a("dateStyle", String.valueOf(paramInt));
        }
      }
      if (paramObject != null)
      {
        paramObject = (com.jiubang.goweather.a.a)paramObject;
        this.a.a(((com.jiubang.goweather.a.a)paramObject).d(), ((com.jiubang.goweather.a.a)paramObject).c(), 0L);
      }
      f.d(this.a).a(2, null, WeatherContentProvider.a, b.a(), null, null, null);
    }
  }
  
  protected void a(int paramInt, Object paramObject, ContentProviderResult[] paramArrayOfContentProviderResult)
  {
    if (paramInt == 12)
    {
      paramObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_RELOAD_DATA");
      f.b(this.a).sendBroadcast((Intent)paramObject);
      f.e(this.a);
    }
    while ((paramInt != 11) || (paramObject == null)) {
      return;
    }
    ((com.gtp.go.weather.sharephoto.photo.a)paramObject).a(null, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/util/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */