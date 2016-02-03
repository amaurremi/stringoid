package com.gau.go.launcherex.goweather.a;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.gtp.a.a.b.c;
import com.jiubang.goweather.b.e;
import java.io.UnsupportedEncodingException;

public class f
  extends a
{
  private double a;
  private double b;
  private double c;
  private double d;
  private int e;
  private int f;
  private int g = 0;
  private int h = 2;
  private String i = "http://gwm.3g.cn:8099/goweatherexMeteor/radar/image";
  
  private boolean j()
  {
    return (this.f == 0) || (this.e == 0) || (this.b == this.a) || (this.d == this.c);
  }
  
  public int a()
  {
    return this.h;
  }
  
  public void a(double paramDouble)
  {
    this.a = paramDouble;
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
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
    this.i = paramString;
  }
  
  public double b()
  {
    return this.a;
  }
  
  public void b(double paramDouble)
  {
    this.b = paramDouble;
  }
  
  public void b(int paramInt)
  {
    this.e = paramInt;
  }
  
  public double c()
  {
    return this.b;
  }
  
  public void c(double paramDouble)
  {
    this.c = paramDouble;
  }
  
  public void c(int paramInt)
  {
    this.f = paramInt;
  }
  
  public double d()
  {
    return this.c;
  }
  
  public void d(double paramDouble)
  {
    this.d = paramDouble;
  }
  
  public double e()
  {
    return this.d;
  }
  
  public int f()
  {
    return this.e;
  }
  
  public int g()
  {
    return this.f;
  }
  
  public int h()
  {
    return this.g;
  }
  
  public String i()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!j())
    {
      localObject1 = new e(this.i, "GET");
      ((e)localObject1).a("minlat", String.valueOf(b()));
      ((e)localObject1).a("maxlat", String.valueOf(c()));
      ((e)localObject1).a("minlon", String.valueOf(d()));
      ((e)localObject1).a("maxlon", String.valueOf(e()));
      ((e)localObject1).a("width", String.valueOf(f()));
      ((e)localObject1).a("height", String.valueOf(g()));
      ((e)localObject1).a("newmaps", String.valueOf(h()));
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */