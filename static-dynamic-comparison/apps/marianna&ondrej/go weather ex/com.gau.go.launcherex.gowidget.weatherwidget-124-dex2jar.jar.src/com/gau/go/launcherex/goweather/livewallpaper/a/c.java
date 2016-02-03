package com.gau.go.launcherex.goweather.livewallpaper.a;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.gau.go.launcherex.gowidget.weather.util.r;

public class c
{
  private String a;
  private int b;
  private int c;
  private int d;
  private int e = 0;
  private int f = 0;
  private a g = new a();
  
  public float a(Resources paramResources)
  {
    int j = this.d - 1;
    int[] arrayOfInt = paramResources.getIntArray(2131558458);
    int i;
    if (j >= 0)
    {
      i = j;
      if (j < arrayOfInt.length) {}
    }
    else
    {
      i = 0;
    }
    float f1 = paramResources.getDisplayMetrics().density;
    return r.a(arrayOfInt[i], f1);
  }
  
  public a a()
  {
    return this.g;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public int b()
  {
    return this.e;
  }
  
  public b b(Resources paramResources)
  {
    return new b().a(paramResources, this.f - 1);
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void c(int paramInt)
  {
    this.e = paramInt;
  }
  
  public boolean c()
  {
    return this.c != 0;
  }
  
  public void d(int paramInt)
  {
    this.c = paramInt;
  }
  
  public boolean d()
  {
    return this.b != 0;
  }
  
  public String e()
  {
    return this.a;
  }
  
  public void e(int paramInt)
  {
    this.b = paramInt;
  }
  
  public boolean f(int paramInt)
  {
    boolean bool = false;
    if (this.b != paramInt)
    {
      this.b = paramInt;
      bool = true;
    }
    return bool;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/livewallpaper/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */