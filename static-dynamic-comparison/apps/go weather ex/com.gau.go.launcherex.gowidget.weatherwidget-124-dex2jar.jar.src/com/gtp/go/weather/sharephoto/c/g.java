package com.gtp.go.weather.sharephoto.c;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gtp.go.weather.sharephoto.b.j;
import com.gtp.go.weather.sharephoto.b.o;
import java.util.ArrayList;
import java.util.Iterator;

class g
  extends AsyncTask
{
  private g(d paramd) {}
  
  protected Object doInBackground(Object... paramVarArgs)
  {
    Object localObject = d.a(this.a).getContentResolver().query(WeatherContentProvider.x, new String[] { "photo_id", "data_type", "data_value", "user_id", "city_id" }, null, null, null);
    paramVarArgs = new ArrayList();
    j localj;
    if (localObject != null) {
      if (((Cursor)localObject).moveToFirst())
      {
        int j = ((Cursor)localObject).getColumnCount();
        do
        {
          localj = new j();
          int i = 0;
          if (i < j)
          {
            String str = ((Cursor)localObject).getColumnName(i);
            if (str.equals("photo_id")) {
              localj.a(((Cursor)localObject).getLong(i));
            }
            for (;;)
            {
              i += 1;
              break;
              if (str.equals("data_type")) {
                localj.a(((Cursor)localObject).getInt(i));
              } else if (str.equals("data_value")) {
                localj.b(((Cursor)localObject).getInt(i));
              }
            }
          }
          paramVarArgs.add(localj);
        } while (((Cursor)localObject).moveToNext());
      }
    }
    try
    {
      ((Cursor)localObject).close();
      if (!paramVarArgs.isEmpty())
      {
        localObject = com.gtp.go.weather.sharephoto.a.g.a(d.a(this.a)).b().a();
        paramVarArgs = paramVarArgs.iterator();
        for (;;)
        {
          if (!paramVarArgs.hasNext()) {
            break label354;
          }
          localj = (j)paramVarArgs.next();
          if (localj.b() != 1) {
            break;
          }
          d.a(this.a, (String)localObject, localj.a(), localj.c());
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        if (localj.b() == 2) {
          d.a(this.a, localException, localj.a(), 2);
        } else if (localj.b() == 3) {
          d.a(this.a, localException, localj);
        }
      }
      label354:
      d.b(this.a);
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */