package com.gau.go.launcherex.goweather.livewallpaper.a;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.gau.go.launcherex.gowidget.weather.util.r;

public class b
{
  private float a;
  private float b;
  private float c;
  private float d;
  private float e;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  private float l;
  private float m;
  private float n;
  private float o;
  
  public float a()
  {
    return this.a;
  }
  
  public b a(Resources paramResources, int paramInt)
  {
    this.a = paramResources.getDimension(2131427928);
    this.l = paramResources.getDimension(2131427929);
    this.o = paramResources.getInteger(2131296264);
    int[] arrayOfInt = paramResources.getIntArray(2131558452);
    int i1;
    if (paramInt >= 0)
    {
      i1 = paramInt;
      if (paramInt < arrayOfInt.length) {}
    }
    else
    {
      i1 = 0;
    }
    this.c = arrayOfInt[i1];
    this.e = paramResources.getIntArray(2131558453)[i1];
    this.f = paramResources.getIntArray(2131558454)[i1];
    this.i = paramResources.getIntArray(2131558455)[i1];
    this.j = paramResources.getIntArray(2131558456)[i1];
    this.k = paramResources.getIntArray(2131558457)[i1];
    float f1 = paramResources.getDisplayMetrics().density;
    this.b = r.a(paramResources.getIntArray(2131558448)[i1], f1);
    this.d = r.a(paramResources.getIntArray(2131558449)[i1], f1);
    this.g = r.a(paramResources.getIntArray(2131558450)[i1], f1);
    this.h = r.a(paramResources.getIntArray(2131558451)[i1], f1);
    this.m = r.a(paramResources.getIntArray(2131558459)[i1], f1);
    this.n = r.a(paramResources.getIntArray(2131558460)[i1], f1);
    return this;
  }
  
  public float b()
  {
    return this.b;
  }
  
  public float c()
  {
    return this.c;
  }
  
  public float d()
  {
    return this.d;
  }
  
  public float e()
  {
    return this.e;
  }
  
  public float f()
  {
    return this.f;
  }
  
  public float g()
  {
    return this.g;
  }
  
  public float h()
  {
    return this.h;
  }
  
  public float i()
  {
    return this.i;
  }
  
  public float j()
  {
    return this.j;
  }
  
  public float k()
  {
    return this.k;
  }
  
  public float l()
  {
    return this.m;
  }
  
  public float m()
  {
    return this.n;
  }
  
  public float n()
  {
    return this.o;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/livewallpaper/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */