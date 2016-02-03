package com.gtp.go.weather.sharephoto.c;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;

class j
  extends AsyncTask
{
  private j(d paramd) {}
  
  protected com.gtp.go.weather.sharephoto.b.j a(Object... paramVarArgs)
  {
    Object localObject = null;
    com.gtp.go.weather.sharephoto.b.j localj = (com.gtp.go.weather.sharephoto.b.j)paramVarArgs[0];
    if (localj != null)
    {
      paramVarArgs = d.a(this.a).getContentResolver();
      Uri localUri = WeatherContentProvider.x;
      long l = localj.a();
      i = localj.c();
      paramVarArgs = paramVarArgs.query(localUri, new String[] { "data_value" }, "photo_id=? and data_type=? and data_value=?", new String[] { String.valueOf(l), String.valueOf(3), String.valueOf(i) }, null);
      if (paramVarArgs == null) {
        break label198;
      }
      if (paramVarArgs.getCount() <= 0) {
        break label185;
      }
    }
    label185:
    label198:
    for (int i = 1;; i = 0) {
      try
      {
        for (;;)
        {
          paramVarArgs.close();
          paramVarArgs = (Object[])localObject;
          if (i == 0)
          {
            paramVarArgs = new ContentValues();
            paramVarArgs.put("photo_id", Long.valueOf(localj.a()));
            paramVarArgs.put("data_type", Integer.valueOf(3));
            paramVarArgs.put("data_value", Integer.valueOf(localj.c()));
            d.a(this.a).getContentResolver().insert(WeatherContentProvider.x, paramVarArgs);
            paramVarArgs = localj;
          }
          return paramVarArgs;
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
    }
  }
  
  protected void a(com.gtp.go.weather.sharephoto.b.j paramj)
  {
    super.onPostExecute(paramj);
    if (paramj != null) {
      d.a(this.a, paramj);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/c/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */