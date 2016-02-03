package com.gtp.go.weather.sharephoto.c;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gtp.go.weather.sharephoto.b.o;

class i
  extends AsyncTask
{
  private i(d paramd) {}
  
  protected com.gtp.go.weather.sharephoto.b.g a(Object... paramVarArgs)
  {
    int j = -1;
    int k = 1;
    paramVarArgs = (com.gtp.go.weather.sharephoto.b.g)paramVarArgs[0];
    ContentValues localContentValues;
    int i;
    Object localObject;
    if (paramVarArgs != null)
    {
      localContentValues = new ContentValues();
      if (!paramVarArgs.h()) {
        break label297;
      }
      i = 1;
      localContentValues.put("is_myfavourite", Integer.valueOf(i));
      localContentValues.put("favour", Integer.valueOf(paramVarArgs.c()));
      d.a(this.a).getContentResolver().update(WeatherContentProvider.v, localContentValues, "photo_id=?", new String[] { String.valueOf(paramVarArgs.a()) });
      localObject = d.a(this.a).getContentResolver();
      Uri localUri = WeatherContentProvider.x;
      long l = paramVarArgs.a();
      localObject = ((ContentResolver)localObject).query(localUri, new String[] { "data_value" }, "photo_id=? and data_type=?", new String[] { String.valueOf(l), String.valueOf(1) }, null);
      if (localObject == null) {
        break label419;
      }
      if (!((Cursor)localObject).moveToFirst()) {
        break label414;
      }
      int m = ((Cursor)localObject).getColumnCount();
      i = 0;
      if (i >= m) {
        break label414;
      }
      if (!((Cursor)localObject).getColumnName(i).equals("data_value")) {
        break label302;
      }
      i = ((Cursor)localObject).getInt(i);
    }
    for (;;)
    {
      try
      {
        ((Cursor)localObject).close();
        localContentValues.clear();
        if (i == 0)
        {
          localContentValues.put("photo_id", Long.valueOf(paramVarArgs.a()));
          localContentValues.put("data_type", Integer.valueOf(1));
          if (paramVarArgs.h())
          {
            i = k;
            localContentValues.put("data_value", Integer.valueOf(i));
            d.a(this.a).getContentResolver().insert(WeatherContentProvider.x, localContentValues);
            return paramVarArgs;
            label297:
            i = 0;
            break;
            label302:
            i += 1;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
        i = -1;
        continue;
        if (((i != -1) || (!paramVarArgs.h())) && ((i != 1) || (paramVarArgs.h()))) {
          continue;
        }
        i = j;
        if (paramVarArgs.h()) {
          i = 1;
        }
        localContentValues.put("data_value", Integer.valueOf(i));
        d.a(this.a).getContentResolver().update(WeatherContentProvider.x, localContentValues, "photo_id=? and data_type=?", new String[] { String.valueOf(paramVarArgs.a()), String.valueOf(1) });
        return paramVarArgs;
      }
      label414:
      i = 0;
      continue;
      label419:
      i = 0;
    }
  }
  
  protected void a(com.gtp.go.weather.sharephoto.b.g paramg)
  {
    super.onPostExecute(paramg);
    d locald;
    String str;
    long l;
    if (paramg != null)
    {
      locald = this.a;
      str = com.gtp.go.weather.sharephoto.a.g.a(d.a(this.a)).b().a();
      l = paramg.a();
      if (!paramg.h()) {
        break label57;
      }
    }
    label57:
    for (int i = 1;; i = -1)
    {
      d.b(locald, str, l, i);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/c/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */