package com.go.weatherex.home.current;

import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.gtp.a.a.b.c;

class k
  implements Runnable
{
  k(j paramj) {}
  
  public void run()
  {
    double[] arrayOfDouble1 = j.a(this.a).k.z();
    double[] arrayOfDouble2 = j.a(this.a).k.A();
    if ((r.a(arrayOfDouble1)) && (r.a(arrayOfDouble2))) {}
    do
    {
      float f1;
      float f2;
      do
      {
        try
        {
          j.b(this.a).moveCamera(CameraUpdateFactory.newLatLngBounds(new LatLngBounds(new LatLng(arrayOfDouble2[0], arrayOfDouble2[1]), new LatLng(arrayOfDouble1[0], arrayOfDouble1[1])), 0));
          return;
        }
        catch (IllegalStateException localIllegalStateException1)
        {
          while (!c.a()) {}
          localIllegalStateException1.printStackTrace();
          return;
        }
        f1 = j.a(this.a).k.w();
        f2 = j.a(this.a).k.v();
      } while ((f1 == -10000.0F) || (f2 == -10000.0F));
      try
      {
        j.b(this.a).moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(f1, f2), 7.0F));
        return;
      }
      catch (IllegalStateException localIllegalStateException2) {}
    } while (!c.a());
    localIllegalStateException2.printStackTrace();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/current/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */