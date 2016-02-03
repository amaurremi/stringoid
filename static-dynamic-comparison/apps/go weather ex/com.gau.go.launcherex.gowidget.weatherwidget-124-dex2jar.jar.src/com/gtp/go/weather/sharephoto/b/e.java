package com.gtp.go.weather.sharephoto.b;

import android.text.TextUtils;
import java.io.File;

public class e
{
  private int a;
  private long b = -1L;
  private String c = "";
  private String d = "";
  private long e = 0L;
  private long f = 0L;
  private boolean g = false;
  private String h;
  private String i;
  private String j;
  
  public String a()
  {
    return this.h;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void a(String paramString)
  {
    this.h = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public String b()
  {
    return this.i;
  }
  
  public void b(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void b(String paramString)
  {
    this.i = paramString;
  }
  
  public String c()
  {
    return this.j;
  }
  
  public void c(long paramLong)
  {
    this.f = paramLong;
  }
  
  public void c(String paramString)
  {
    this.j = paramString;
  }
  
  public int d()
  {
    return this.a;
  }
  
  public void d(String paramString)
  {
    this.c = paramString;
  }
  
  public void e(String paramString)
  {
    this.d = paramString;
  }
  
  public boolean e()
  {
    return this.g;
  }
  
  public long f()
  {
    return this.b;
  }
  
  public String g()
  {
    return this.c;
  }
  
  public String h()
  {
    return this.d;
  }
  
  public long i()
  {
    return this.e;
  }
  
  public long j()
  {
    return this.f;
  }
  
  public boolean k()
  {
    boolean bool2 = true;
    boolean bool1;
    if (!TextUtils.isEmpty(this.c)) {
      if (new File(this.c).length() == this.e) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if (!bool1)
      {
        return bool1;
        bool1 = false;
      }
      else
      {
        if ((this.g) && (!TextUtils.isEmpty(this.d))) {
          if (new File(this.d).length() == this.f) {
            bool1 = bool2;
          }
        }
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
        bool1 = true;
      }
    }
  }
  
  public boolean l()
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(this.c)) {
      bool = new File(this.c).exists();
    }
    return bool;
  }
  
  public boolean m()
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(this.d)) {
      bool = new File(this.d).exists();
    }
    return bool;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */