package com.gau.go.launcherex.gowidget.weather.b;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.e;
import com.gau.go.launcherex.gowidget.weather.globaltheme.c.d;
import com.gau.go.launcherex.gowidget.weather.model.u;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.service.ThemeService;
import com.gtp.a.a.a.a;
import com.jiubang.core.c.j;

class i
  extends j
{
  public i(g paramg, ContentResolver paramContentResolver, Context paramContext)
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
      } while (g.c(this.a) == null);
      g.c(this.a).b();
      g.c(this.a).c();
      return;
      if (paramInt2 > 0)
      {
        paramObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_THEME_CHANGE");
        ((Intent)paramObject).putExtra("extra_app_widget_theme_type", "app_widget_theme_white");
        g.e(this.a).sendBroadcast((Intent)paramObject);
      }
    } while (g.c(this.a) == null);
    g.c(this.a).b();
    g.c(this.a).c();
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
        g.a(this.a).a(Long.valueOf(paramCursor.getString(0)).longValue());
      }
      if (g.b(this.a) == null)
      {
        g.a(this.a, new k(this.a, null));
        g.b(this.a).execute(new Void[0]);
        continue;
        Object localObject = (String)paramObject;
        paramObject = "";
        if (paramCursor.moveToNext()) {
          paramObject = paramCursor.getString(0);
        }
        if (((String)localObject).equals(paramObject))
        {
          if (g.c(this.a) != null) {
            g.c(this.a).a();
          }
          paramObject = new ContentValues();
          ((ContentValues)paramObject).put("setting_value", "app_widget_theme_white");
          g.d(this.a).a(7, null, WeatherContentProvider.g, (ContentValues)paramObject, "setting_key=?", new String[] { "app_widget_theme" });
          a.a().a("因为删除主题包，而重置系统插件主题", "Google 付费检查.txt");
        }
        if (g.c(this.a) != null)
        {
          g.c(this.a).b();
          g.c(this.a).c();
          continue;
          paramObject = "";
          if (paramCursor.moveToFirst()) {
            paramObject = paramCursor.getString(0);
          }
          localObject = d.a(g.e(this.a), (String)paramObject, g.e(this.a).getResources());
          if ((!((String)paramObject).equals("app_widget_theme_white")) && (!((String)paramObject).equals("app_widget_theme_black")) && (localObject != null) && (((e)localObject).l() == 2))
          {
            if (g.c(this.a) != null) {
              g.c(this.a).a();
            }
            paramObject = new ContentValues();
            ((ContentValues)paramObject).put("setting_value", "app_widget_theme_white");
            g.d(this.a).a(7, null, WeatherContentProvider.g, (ContentValues)paramObject, "setting_key=?", new String[] { "app_widget_theme" });
            a.a().a("因为发现用户是从付费用户转为未付费用户，而重置系统插件主题", "Google 付费检查.txt");
          }
          if (g.c(this.a) != null)
          {
            g.c(this.a).b();
            g.c(this.a).c();
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */