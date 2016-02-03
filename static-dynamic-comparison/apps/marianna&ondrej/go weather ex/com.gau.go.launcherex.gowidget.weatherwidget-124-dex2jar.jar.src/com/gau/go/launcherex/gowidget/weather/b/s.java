package com.gau.go.launcherex.gowidget.weather.b;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.gau.go.launcherex.gowidget.weather.model.u;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.service.ThemeService;
import com.jiubang.core.c.j;

class s
  extends j
{
  public s(o paramo, ContentResolver paramContentResolver, Context paramContext)
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
        do
        {
          return;
        } while (o.c(this.a) == null);
        o.c(this.a).b();
        o.c(this.a).c();
        return;
      } while (o.c(this.a) == null);
      o.c(this.a).b();
      o.c(this.a).c();
      return;
      if (paramInt2 > 0)
      {
        paramObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_GOWIDGET_THEME_CHANGE");
        ((Intent)paramObject).putExtra("extra_gowidget_theme_package", "app_widget_theme_white");
        ((Intent)paramObject).putExtra("extra_gowidget_theme_billing_overdue", true);
        o.e(this.a).sendBroadcast((Intent)paramObject);
      }
    } while (o.c(this.a) == null);
    o.c(this.a).b();
    o.c(this.a).c();
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
        o.a(this.a).a(Long.valueOf(paramCursor.getString(0)).longValue());
      }
      if (o.b(this.a) == null)
      {
        o.a(this.a, new r(this.a, null));
        o.b(this.a).execute(new Void[0]);
        continue;
        String str = (String)paramObject;
        paramObject = "";
        if (paramCursor.moveToNext()) {
          paramObject = paramCursor.getString(0);
        }
        if (str.equals(paramObject))
        {
          if (o.c(this.a) != null) {
            o.c(this.a).a();
          }
          paramObject = new ContentValues();
          ((ContentValues)paramObject).put("setting_value", "app_widget_theme_white");
          o.d(this.a).a(8, null, WeatherContentProvider.g, (ContentValues)paramObject, "setting_key=?", new String[] { "go_widget_theme" });
        }
        if (o.c(this.a) != null)
        {
          o.c(this.a).b();
          o.c(this.a).c();
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */