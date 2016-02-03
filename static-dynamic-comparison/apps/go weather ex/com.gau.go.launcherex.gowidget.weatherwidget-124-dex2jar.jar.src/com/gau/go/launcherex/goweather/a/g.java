package com.gau.go.launcherex.goweather.a;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.gtp.a.a.b.c;
import com.jiubang.goweather.b.e;
import java.io.UnsupportedEncodingException;

public class g
  extends a
{
  private double a;
  private double b;
  private double c;
  private double d;
  private int e;
  private int f;
  private String g = h.b.e;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private int k = 107;
  private int l = 2;
  private String m = "http://gwm.3g.cn:8099/goweatherexMeteor/satellite/image";
  
  private boolean n()
  {
    return (this.f == 0) || (this.e == 0) || (this.b == this.a) || (this.d == this.c);
  }
  
  public int a()
  {
    return this.l;
  }
  
  public void a(double paramDouble)
  {
    this.a = paramDouble;
  }
  
  public void a(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void a(h paramh)
  {
    this.g = paramh.e;
  }
  
  public void a(LatLngBounds paramLatLngBounds)
  {
    b(paramLatLngBounds.northeast.latitude);
    c(paramLatLngBounds.southwest.longitude);
    a(paramLatLngBounds.southwest.latitude);
    d(paramLatLngBounds.northeast.longitude);
  }
  
  public void a(String paramString)
  {
    this.m = paramString;
  }
  
  public int b()
  {
    return this.k;
  }
  
  public void b(double paramDouble)
  {
    this.b = paramDouble;
  }
  
  public void b(int paramInt)
  {
    this.e = paramInt;
  }
  
  public int c()
  {
    return this.j;
  }
  
  public void c(double paramDouble)
  {
    this.c = paramDouble;
  }
  
  public void c(int paramInt)
  {
    this.f = paramInt;
  }
  
  public int d()
  {
    return this.i;
  }
  
  public void d(double paramDouble)
  {
    this.d = paramDouble;
  }
  
  public double e()
  {
    return this.a;
  }
  
  public double f()
  {
    return this.b;
  }
  
  public double g()
  {
    return this.c;
  }
  
  public double h()
  {
    return this.d;
  }
  
  public int i()
  {
    return this.e;
  }
  
  public int j()
  {
    return this.f;
  }
  
  public String k()
  {
    return this.g;
  }
  
  public int l()
  {
    return this.h;
  }
  
  public String m()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!n())
    {
      localObject1 = new e(this.m, "GET");
      ((e)localObject1).a("minlat", String.valueOf(e()));
      ((e)localObject1).a("maxlat", String.valueOf(f()));
      ((e)localObject1).a("minlon", String.valueOf(g()));
      ((e)localObject1).a("maxlon", String.valueOf(h()));
      ((e)localObject1).a("width", String.valueOf(i()));
      ((e)localObject1).a("height", String.valueOf(j()));
      ((e)localObject1).a("key", String.valueOf(k()));
      ((e)localObject1).a("basemap", String.valueOf(l()));
      ((e)localObject1).a("timelabel", String.valueOf(d()));
      ((e)localObject1).a("smooth", String.valueOf(c()));
      ((e)localObject1).a("gtt", String.valueOf(b()));
      ((e)localObject1).a("zoom", String.valueOf(a()));
    }
    try
    {
      localObject1 = ((e)localObject1).i();
      return (String)localObject1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      do
      {
        localObject1 = localObject2;
      } while (!c.a());
      localUnsupportedEncodingException.printStackTrace();
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */