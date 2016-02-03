package com.gtp.go.weather.coupon.a;

import android.content.ContentResolver;
import android.content.Context;
import android.os.AsyncTask;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import java.util.ArrayList;
import java.util.Iterator;

class b
  extends AsyncTask
{
  ArrayList a;
  
  public b(a parama, ArrayList paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  protected Object doInBackground(Object... paramVarArgs)
  {
    paramVarArgs = this.a.iterator();
    while (paramVarArgs.hasNext())
    {
      Long localLong = (Long)paramVarArgs.next();
      a.a(this.b).getContentResolver().delete(WeatherContentProvider.C, "coupon_id=?", new String[] { String.valueOf(localLong) });
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/coupon/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */