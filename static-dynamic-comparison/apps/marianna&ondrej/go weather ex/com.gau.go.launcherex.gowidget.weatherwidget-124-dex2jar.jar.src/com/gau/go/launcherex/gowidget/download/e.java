package com.gau.go.launcherex.gowidget.download;

import java.util.ArrayList;
import java.util.Iterator;

public class e
{
  private long a;
  private String b;
  private String c;
  private String d;
  private long e;
  private int f;
  private String g;
  private ArrayList h;
  private int i = 0;
  private String j;
  
  public e(long paramLong1, String paramString1, String paramString2, long paramLong2, int paramInt, String paramString3, String paramString4)
  {
    if (paramLong1 == Long.MIN_VALUE) {}
    for (this.a = System.currentTimeMillis();; this.a = paramLong1)
    {
      this.b = paramString1;
      this.c = paramString2;
      this.e = paramLong2;
      this.f = paramInt;
      this.g = paramString3;
      this.d = paramString4;
      return;
    }
  }
  
  public void a()
  {
    this.e = 0L;
    this.f = 0;
    this.i = 2;
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void a(f paramf)
  {
    if (paramf != null)
    {
      if (this.h == null) {
        this.h = new ArrayList();
      }
      this.h.add(paramf);
    }
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public long b()
  {
    return this.a;
  }
  
  public void b(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public void c(int paramInt)
  {
    if (this.h != null)
    {
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if (localf != null) {
          switch (paramInt)
          {
          default: 
            break;
          case 1: 
            localf.a(this);
            break;
          case 6: 
            localf.f(this);
            break;
          case 2: 
            localf.b(this);
            break;
          case 5: 
            localf.e(this);
            break;
          case 4: 
            localf.d(this);
            break;
          case 3: 
            localf.c(this);
            break;
          case 7: 
            localf.g(this);
          }
        }
      }
    }
  }
  
  public void c(String paramString)
  {
    this.j = paramString;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public long e()
  {
    return this.e;
  }
  
  public int f()
  {
    return this.f;
  }
  
  public String g()
  {
    return this.g;
  }
  
  public int h()
  {
    return this.i;
  }
  
  public String i()
  {
    return this.j;
  }
  
  public String j()
  {
    return this.d;
  }
  
  public void k()
  {
    this.b = null;
    this.c = null;
    this.g = null;
    if (this.h != null)
    {
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if (localf != null) {
          localf.h(this);
        }
      }
      this.h.clear();
      this.h = null;
    }
    this.j = null;
    this.d = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/download/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */