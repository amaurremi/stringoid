package com.gtp.go.weather.sharephoto.c;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gtp.go.weather.sharephoto.a.g;
import com.gtp.go.weather.sharephoto.b.o;

class h
  extends AsyncTask
{
  private h(d paramd) {}
  
  protected Long a(Object... paramVarArgs)
  {
    long l = ((Long)paramVarArgs[0]).longValue();
    if (l <= 0L) {
      return Long.valueOf(0L);
    }
    paramVarArgs = d.a(this.a).getContentResolver().query(WeatherContentProvider.x, new String[] { "data_value" }, "photo_id=? and data_type=?", new String[] { String.valueOf(l), String.valueOf(2) }, null);
    if (paramVarArgs != null) {
      if (paramVarArgs.getCount() <= 0) {}
    }
    for (int i = 1;; i = 0)
    {
      try
      {
        for (;;)
        {
          paramVarArgs.close();
          if (i != 0) {
            break;
          }
          paramVarArgs = new ContentValues();
          paramVarArgs.put("photo_id", Long.valueOf(l));
          paramVarArgs.put("data_type", Integer.valueOf(2));
          d.a(this.a).getContentResolver().insert(WeatherContentProvider.x, paramVarArgs);
          return Long.valueOf(l);
          i = 0;
        }
      }
      catch (Exception paramVarArgs)
      {
        for (;;)
        {
          paramVarArgs.printStackTrace();
        }
      }
      return Long.valueOf(0L);
    }
  }
  
  protected void a(Long paramLong)
  {
    super.onPostExecute(paramLong);
    if (paramLong.longValue() != 0L) {
      d.b(this.a, g.a(d.a(this.a)).b().a(), paramLong.longValue(), 2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/c/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */