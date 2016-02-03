package com.jiubang.goweather.a;

import com.gau.go.launcherex.gowidget.weather.util.r;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class a
{
  public int a;
  public volatile String b;
  public volatile String c;
  public volatile long d = 0L;
  public volatile long e = 0L;
  public volatile long f;
  public volatile e g;
  public volatile List h;
  public volatile List i;
  public volatile List j;
  public volatile List k;
  public volatile int l = 55536;
  public volatile List m;
  private String n;
  private String o;
  private float p = -10000.0F;
  private float q = -10000.0F;
  private int r;
  private int s;
  private double[] t = { -10000.0D, -10000.0D };
  private double[] u = { -10000.0D, -10000.0D };
  private String v;
  
  public a(String paramString1, String paramString2, long paramLong)
  {
    a(paramString1, paramString2, paramLong);
  }
  
  private void a(String paramString1, String paramString2, long paramLong)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramLong;
    this.f = -10000L;
    this.e = -10000L;
    this.g = new e();
    this.h = new ArrayList();
    this.i = new ArrayList();
    this.j = new ArrayList();
    this.k = new ArrayList();
    this.m = new ArrayList();
  }
  
  private long e(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm Z");
    try
    {
      long l1 = localSimpleDateFormat.parse(paramString).getTime();
      return l1;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
    }
    return -10000L;
  }
  
  public String a()
  {
    return this.n;
  }
  
  public void a(float paramFloat)
  {
    this.p = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.f = paramLong;
  }
  
  public void a(String paramString)
  {
    this.n = paramString;
  }
  
  public void a(double[] paramArrayOfDouble)
  {
    this.t = paramArrayOfDouble;
  }
  
  public String b()
  {
    return this.o;
  }
  
  public void b(float paramFloat)
  {
    this.q = paramFloat;
  }
  
  public void b(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void b(String paramString)
  {
    this.o = paramString;
  }
  
  public void b(double[] paramArrayOfDouble)
  {
    this.u = paramArrayOfDouble;
  }
  
  public c c(int paramInt)
  {
    if ((this.h == null) || (paramInt < 0) || (paramInt >= this.h.size())) {
      return null;
    }
    return (c)this.h.get(paramInt);
  }
  
  public String c()
  {
    return this.b;
  }
  
  public void c(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void c(String paramString)
  {
    if ((paramString == null) || (paramString.equals("--")))
    {
      this.f = -10000L;
      return;
    }
    this.f = e(paramString);
  }
  
  public d d(int paramInt)
  {
    if ((this.i == null) || (paramInt < 0) || (paramInt >= this.i.size())) {
      return null;
    }
    return (d)this.i.get(paramInt);
  }
  
  public String d()
  {
    return this.c;
  }
  
  public void d(String paramString)
  {
    this.v = paramString;
  }
  
  public float e()
  {
    return this.p;
  }
  
  public b e(int paramInt)
  {
    if ((this.k == null) || (paramInt < 0) || (paramInt >= this.k.size())) {
      return null;
    }
    return (b)this.k.get(paramInt);
  }
  
  public float f()
  {
    return this.q;
  }
  
  public void f(int paramInt)
  {
    this.l = paramInt;
  }
  
  public int g()
  {
    return this.r;
  }
  
  public f g(int paramInt)
  {
    if ((this.m == null) || (paramInt < 0) || (paramInt >= this.m.size())) {
      return null;
    }
    return (f)this.m.get(paramInt);
  }
  
  public int h()
  {
    return this.s;
  }
  
  public void h(int paramInt)
  {
    this.a = paramInt;
  }
  
  public double[] i()
  {
    return this.t;
  }
  
  public String j()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (r.a(this.t))
    {
      localStringBuffer.append(this.t[0]);
      localStringBuffer.append("#");
      localStringBuffer.append(this.t[1]);
    }
    for (;;)
    {
      return localStringBuffer.toString();
      localStringBuffer.append("");
    }
  }
  
  public double[] k()
  {
    return this.u;
  }
  
  public String l()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (r.a(this.u))
    {
      localStringBuffer.append(this.u[0]);
      localStringBuffer.append("#");
      localStringBuffer.append(this.u[1]);
    }
    for (;;)
    {
      return localStringBuffer.toString();
      localStringBuffer.append("");
    }
  }
  
  public long m()
  {
    return this.f;
  }
  
  public long n()
  {
    return this.e;
  }
  
  public long o()
  {
    return this.d;
  }
  
  public e p()
  {
    return this.g;
  }
  
  public int q()
  {
    if (this.h == null) {
      return 0;
    }
    return this.h.size();
  }
  
  public int r()
  {
    if (this.i == null) {
      return 0;
    }
    return this.i.size();
  }
  
  public int s()
  {
    if (this.k == null) {
      return 0;
    }
    return this.k.size();
  }
  
  public int t()
  {
    return this.l;
  }
  
  public int u()
  {
    if (this.m == null) {
      return 0;
    }
    return this.m.size();
  }
  
  public String v()
  {
    return this.v;
  }
  
  public int w()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */