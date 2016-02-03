package com.go.weatherex.weatheralert;

import android.annotation.SuppressLint;
import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;
import com.gau.go.launcherex.gowidget.weather.model.c;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.util.r;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;

@SuppressLint({"HandlerLeak"})
class d
  extends AsyncQueryHandler
{
  public d(WeatherAlertActivity paramWeatherAlertActivity, ContentResolver paramContentResolver)
  {
    super(paramContentResolver);
  }
  
  private void a()
  {
    if (!WeatherAlertActivity.d(this.a).isEmpty())
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm Z", Locale.ENGLISH);
      Collections.sort(WeatherAlertActivity.d(this.a), new e(this, localSimpleDateFormat));
    }
  }
  
  private void a(Cursor paramCursor)
  {
    WeatherAlertActivity.d(this.a).clear();
    c localc;
    int i;
    try
    {
      if (paramCursor.getCount() > 0)
      {
        int j = paramCursor.getColumnCount();
        String[] arrayOfString = paramCursor.getColumnNames();
        paramCursor.moveToFirst();
        localc = new c();
        i = 0;
        label52:
        if (i >= j) {
          break label388;
        }
        if (arrayOfString[i].equals("alert_id")) {
          localc.c(paramCursor.getInt(i));
        } else if (arrayOfString[i].equals("cityId")) {
          localc.g(paramCursor.getString(i));
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      label118:
      return;
      if (localException[i].equals("publish_time")) {
        localc.a(paramCursor.getString(i));
      }
    }
    finally
    {
      paramCursor.close();
    }
    if (localObject[i].equals("exp_time")) {
      localc.b(paramCursor.getString(i));
    } else if (localObject[i].equals("type")) {
      localc.c(paramCursor.getString(i));
    } else if (localObject[i].equals("description")) {
      localc.d(paramCursor.getString(i));
    } else if (localObject[i].equals("phenomena")) {
      localc.e(paramCursor.getString(i));
    } else if (localObject[i].equals("level")) {
      localc.b(paramCursor.getInt(i));
    } else if (localObject[i].equals("message")) {
      localc.f(paramCursor.getString(i));
    } else if (localObject[i].equals("tz_offset")) {
      localc.a(paramCursor.getInt(i));
    } else if (localObject[i].equals("has_read")) {
      if (paramCursor.getInt(i) != 1) {
        break label446;
      }
    }
    label388:
    label439:
    label446:
    for (boolean bool = true;; bool = false)
    {
      localc.c(bool);
      break label439;
      if (!a(localc))
      {
        localc.a(r.c(localc.d()));
        WeatherAlertActivity.d(this.a).add(localc);
      }
      bool = paramCursor.moveToNext();
      if (bool) {
        break;
      }
      break label118;
      i += 1;
      break label52;
    }
  }
  
  private boolean a(c paramc)
  {
    Iterator localIterator = WeatherAlertActivity.d(this.a).iterator();
    while (localIterator.hasNext()) {
      if (((c)localIterator.next()).k() == paramc.k()) {
        return true;
      }
    }
    return false;
  }
  
  public void a(String paramString)
  {
    paramString = "cityId='" + paramString + "'";
    startQuery(0, null, WeatherContentProvider.k, new String[] { "alert_id", "cityId", "exp_time", "publish_time", "level", "message", "description", "tz_offset", "has_read" }, paramString, null, "cityId");
  }
  
  protected void onQueryComplete(int paramInt, Object paramObject, Cursor paramCursor)
  {
    super.onQueryComplete(paramInt, paramObject, paramCursor);
    if (paramCursor != null)
    {
      a(paramCursor);
      a();
      this.a.a();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/weatheralert/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */