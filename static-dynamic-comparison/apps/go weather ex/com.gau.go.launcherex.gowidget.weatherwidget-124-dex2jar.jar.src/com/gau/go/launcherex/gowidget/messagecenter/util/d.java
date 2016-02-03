package com.gau.go.launcherex.gowidget.messagecenter.util;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import com.gau.go.launcherex.gowidget.messagecenter.a.a;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import java.util.ArrayList;
import java.util.Iterator;

class d
  extends AsyncTask
{
  d(c paramc) {}
  
  protected Void a(ArrayList... paramVarArgs)
  {
    Object localObject = paramVarArgs[0];
    paramVarArgs = c.a(this.a).getContentResolver();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if ((locala.b() == 1) || (locala.b() == 2))
      {
        locala.b(locala.c() + " +0800");
        locala.c(locala.d() + " +0800");
        ContentValues localContentValues = new ContentValues();
        long l = am.a(locala.c());
        if (l != -1L)
        {
          localContentValues.put("effective_time", Long.valueOf(l));
          l = am.a(locala.d());
          if (l != -1L)
          {
            localContentValues.put("expired_time", Long.valueOf(l));
            localContentValues.put("coupon_value", Integer.valueOf(locala.b()));
            if (paramVarArgs.update(WeatherContentProvider.E, localContentValues, "coupon_id=?", new String[] { locala.a() }) < 1)
            {
              localContentValues.put("coupon_id", locala.a());
              localContentValues.put("consumed", Integer.valueOf(0));
              paramVarArgs.insert(WeatherContentProvider.E, localContentValues);
            }
          }
        }
      }
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/util/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */