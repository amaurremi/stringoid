package com.gau.go.launcherex.goweather.livewallpaper.a;

import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.weather.util.q;
import com.gau.go.launcherex.gowidget.weather.util.r;

public class e
{
  private String a;
  private String b;
  private int c;
  private String d;
  private float e;
  private float f;
  private float g;
  private String h;
  private float i;
  private int j = 1;
  private String k;
  private String l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  
  public float a(int paramInt)
  {
    if ((paramInt == 1) && (this.e != -10000.0F)) {
      return q.b(this.e, 1);
    }
    return this.e;
  }
  
  public void a(float paramFloat)
  {
    this.e = paramFloat;
  }
  
  public boolean a()
  {
    boolean bool = true;
    if ((TextUtils.isEmpty(this.a)) || ("--".equals(this.a))) {
      bool = false;
    }
    return bool;
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    if (!this.a.equals(paramString))
    {
      bool = true;
      this.a = paramString;
    }
    return bool;
  }
  
  public float b(int paramInt)
  {
    if ((paramInt == 1) && (this.g != -10000.0F)) {
      return q.b(this.g, 1);
    }
    return this.g;
  }
  
  public String b()
  {
    return this.a;
  }
  
  public void b(float paramFloat)
  {
    this.g = paramFloat;
  }
  
  public void b(String paramString)
  {
    this.a = paramString;
  }
  
  public float c(int paramInt)
  {
    if ((paramInt == 1) && (this.f != -10000.0F)) {
      return q.b(this.f, 1);
    }
    return this.f;
  }
  
  public void c(String paramString)
  {
    this.b = paramString;
  }
  
  public boolean c()
  {
    return this.a.equals("--");
  }
  
  public boolean c(float paramFloat)
  {
    return paramFloat != -10000.0F;
  }
  
  public String d()
  {
    return this.b;
  }
  
  public void d(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  public void d(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void d(String paramString)
  {
    this.d = paramString;
  }
  
  public String e()
  {
    return this.d;
  }
  
  public void e(float paramFloat)
  {
    this.i = paramFloat;
  }
  
  public void e(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void e(String paramString)
  {
    this.h = paramString;
  }
  
  public void f(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void f(String paramString)
  {
    this.k = paramString;
  }
  
  public boolean f()
  {
    return !this.d.equals("--");
  }
  
  public String g()
  {
    return this.h;
  }
  
  public void g(String paramString)
  {
    this.l = paramString;
  }
  
  public float h()
  {
    return this.i;
  }
  
  public int i()
  {
    return this.j;
  }
  
  public String j()
  {
    return this.k;
  }
  
  public String k()
  {
    return this.l;
  }
  
  public int l()
  {
    return this.m;
  }
  
  public int m()
  {
    return this.p;
  }
  
  public int n()
  {
    return this.n;
  }
  
  public int o()
  {
    return this.o;
  }
  
  public int p()
  {
    return this.q;
  }
  
  public void q()
  {
    if ((r.a(this.k)) && (r.a(this.l))) {
      try
      {
        String[] arrayOfString = this.k.split(":");
        this.n = Integer.parseInt(arrayOfString[0]);
        this.o = Integer.parseInt(arrayOfString[1]);
        arrayOfString = this.l.split(":");
        this.p = Integer.parseInt(arrayOfString[0]);
        this.q = Integer.parseInt(arrayOfString[1]);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    this.n = 6;
    this.o = 0;
    this.p = 18;
    this.q = 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/livewallpaper/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */