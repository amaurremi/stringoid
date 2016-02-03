package com.gtp.nextlauncher.widget.weatherwidget;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import java.util.List;

class j
  extends com.jiubang.core.c.j
{
  public j(e parame, ContentResolver paramContentResolver)
  {
    super(paramContentResolver);
  }
  
  protected void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    super.a(paramInt, paramObject, paramCursor);
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((paramCursor != null) && (!paramCursor.isClosed())) {}
      try
      {
        paramCursor.close();
        return;
      }
      catch (Exception paramObject)
      {
        ContentValues localContentValues;
        String str;
        boolean bool;
        label494:
        label549:
        label563:
        ((Exception)paramObject).printStackTrace();
      }
      if ((!e.a(this.a, paramCursor)) && (paramObject != null))
      {
        e.a(this.a, (List)paramObject);
      }
      else if (e.a(this.a))
      {
        e.b(this.a);
        continue;
        localContentValues = new ContentValues();
        if ((paramCursor != null) && (paramCursor.getCount() > 0))
        {
          localContentValues.put("city_id", e.c(this.a));
          str = e.d(this.a) + "";
          a(-1, null, WeatherContentProvider.D, localContentValues, "go_widget_id=?", new String[] { str });
        }
        while (paramObject != null)
        {
          e.a(this.a, (List)paramObject);
          break;
          localContentValues.put("go_widget_id", e.d(this.a) + "");
          localContentValues.put("city_id", e.c(this.a));
          a(-1, null, WeatherContentProvider.D, localContentValues);
        }
        e.b(this.a, paramCursor);
        if (paramObject != null)
        {
          e.a(this.a, (List)paramObject);
          continue;
          e.c(this.a, paramCursor);
          if (paramObject != null)
          {
            e.a(this.a, (List)paramObject);
            continue;
            e.d(this.a, paramCursor);
            if (paramObject != null)
            {
              e.a(this.a, (List)paramObject);
              continue;
              e.e(this.a, paramCursor);
              if (paramObject != null)
              {
                e.a(this.a, (List)paramObject);
                continue;
                e.a(this.a, (String)paramObject, paramCursor);
                continue;
                if (paramCursor != null)
                {
                  e.f(this.a, paramCursor);
                  if (paramObject != null)
                  {
                    e.a(this.a, (List)paramObject);
                    continue;
                    if (paramCursor != null)
                    {
                      paramCursor.moveToFirst();
                      if (paramCursor.getInt(0) == 1)
                      {
                        bool = true;
                        e.a(this.a, bool);
                        if (!e.e(this.a)) {
                          break label549;
                        }
                        e.f(this.a).a(true);
                      }
                      for (;;)
                      {
                        if (paramObject == null) {
                          break label563;
                        }
                        e.a(this.a, (List)paramObject);
                        break;
                        bool = false;
                        break label494;
                        e.f(this.a).a(false);
                      }
                      e.b(this.a);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */