package com.go.weatherex.home;

import android.content.ContentResolver;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.util.SparseArray;
import com.gau.go.launcherex.goweather.ad.InlandAdView;
import com.gau.go.launcherex.goweather.ad.a.a;
import com.gau.go.launcherex.goweather.ad.a.b;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.util.f;

class j
  extends AsyncTask
{
  private j(c paramc) {}
  
  protected a a(Void... paramVarArgs)
  {
    paramVarArgs = new a();
    Cursor localCursor = this.a.getActivity().getContentResolver().query(WeatherContentProvider.s, new String[] { "ad_id", "ad_interval", "ad_overcount", "ad_monitor", "pcount", "purl", "ad_weather", "ad_text", "ad_url" }, null, null, null);
    if (localCursor != null) {
      if ((localCursor.moveToFirst()) && (localCursor.getCount() > 0))
      {
        paramVarArgs.a(localCursor.getString(localCursor.getColumnIndex("ad_id")));
        paramVarArgs.a(localCursor.getLong(localCursor.getColumnIndex("ad_interval")));
        paramVarArgs.a(localCursor.getInt(localCursor.getColumnIndex("ad_overcount")));
        paramVarArgs.b(localCursor.getString(localCursor.getColumnIndex("ad_monitor")));
        paramVarArgs.b(localCursor.getInt(localCursor.getColumnIndex("pcount")));
        paramVarArgs.c(localCursor.getString(localCursor.getColumnIndex("purl")));
        int i = localCursor.getColumnIndex("ad_weather");
        int j = localCursor.getColumnIndex("ad_text");
        int k = localCursor.getColumnIndex("ad_url");
        SparseArray localSparseArray = paramVarArgs.f();
        do
        {
          b localb = new b();
          localb.a = localCursor.getInt(i);
          localb.b = localCursor.getString(j);
          localb.c = localCursor.getString(k);
          localSparseArray.put(localb.a, localb);
        } while (localCursor.moveToNext());
        paramVarArgs.a(localSparseArray);
      }
    }
    try
    {
      localCursor.close();
      return paramVarArgs;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramVarArgs;
  }
  
  protected void a(a parama)
  {
    if ((parama.f() != null) && (parama.f().size() != 0))
    {
      WeatherBean localWeatherBean = c.e(this.a).a(c.j(this.a));
      if (localWeatherBean != null)
      {
        c.k(this.a).a(parama);
        c.k(this.a).a(localWeatherBean.k.d());
        c.k(this.a).setVisibility(0);
        c.k(this.a).b();
        c.k(this.a).c();
        int i = c.l(this.a).getInt("key_inland_ad_show_count", 0);
        parama = c.l(this.a).edit();
        parama.putLong("key_inland_ad_show", System.currentTimeMillis());
        parama.putInt("key_inland_ad_show_count", i + 1);
        parama.commit();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */