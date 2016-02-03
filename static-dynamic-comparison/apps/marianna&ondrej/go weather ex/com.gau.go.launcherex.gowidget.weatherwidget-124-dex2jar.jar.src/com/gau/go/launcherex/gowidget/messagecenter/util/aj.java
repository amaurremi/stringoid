package com.gau.go.launcherex.gowidget.messagecenter.util;

import android.content.ContentValues;
import android.content.Context;
import com.gau.go.launcherex.gowidget.messagecenter.a.f;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;

public class aj
{
  private al a;
  
  public aj(Context paramContext)
  {
    this.a = new al(this, paramContext.getContentResolver());
  }
  
  public void a(f paramf)
  {
    if (paramf != null)
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("promo_code", paramf.c());
      localContentValues.put("effective_time", Long.valueOf(paramf.a()));
      localContentValues.put("expired_time", Long.valueOf(paramf.b()));
      this.a.startInsert(0, null, WeatherContentProvider.F, localContentValues);
    }
  }
  
  public void a(ak paramak)
  {
    this.a.startQuery(0, paramak, WeatherContentProvider.F, new String[] { "_id", "promo_code", "effective_time", "expired_time" }, null, null, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/util/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */