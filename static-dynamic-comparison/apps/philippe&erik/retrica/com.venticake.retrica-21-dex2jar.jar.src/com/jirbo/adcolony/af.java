package com.jirbo.adcolony;

import java.io.PrintStream;

abstract class af
{
  boolean h = true;
  int i = 0;
  
  public static void b(String[] paramArrayOfString)
  {
    System.out.println("Test...");
  }
  
  abstract void a(char paramChar);
  
  void a(double paramDouble)
  {
    if (this.h) {
      c();
    }
    if ((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble))) {
      a("0.0");
    }
    long l2;
    long l3;
    for (;;)
    {
      return;
      double d = paramDouble;
      if (paramDouble < 0.0D)
      {
        d = -paramDouble;
        a('-');
      }
      l2 = Math.pow(10.0D, 4);
      l1 = Math.round(l2 * d);
      a(l1 / l2);
      a('.');
      l3 = l1 % l2;
      if (l3 != 0L) {
        break;
      }
      int j = 0;
      while (j < 4)
      {
        a('0');
        j += 1;
      }
    }
    for (long l1 = l3 * 10L; l1 < l2; l1 *= 10L) {
      a('0');
    }
    a(l3);
  }
  
  void a(long paramLong)
  {
    if (this.h) {
      c();
    }
    if (paramLong == 0L)
    {
      a('0');
      return;
    }
    if (paramLong == -paramLong)
    {
      a("-9223372036854775808");
      return;
    }
    if (paramLong < 0L)
    {
      a('-');
      a(-paramLong);
      return;
    }
    b(paramLong);
  }
  
  void a(Object paramObject)
  {
    if (this.h) {
      c();
    }
    if (paramObject == null)
    {
      a("null");
      return;
    }
    a(paramObject.toString());
  }
  
  void a(String paramString)
  {
    int k = paramString.length();
    int j = 0;
    while (j < k)
    {
      b(paramString.charAt(j));
      j += 1;
    }
  }
  
  void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a("true");
      return;
    }
    a("false");
  }
  
  void b(char paramChar)
  {
    if (this.h) {
      c();
    }
    a(paramChar);
    if (paramChar == '\n') {
      this.h = true;
    }
  }
  
  void b(double paramDouble)
  {
    a(paramDouble);
    b('\n');
  }
  
  void b(long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    b(paramLong / 10L);
    a((char)(int)(48L + paramLong % 10L));
  }
  
  void b(Object paramObject)
  {
    a(paramObject);
    b('\n');
  }
  
  void b(String paramString)
  {
    a(paramString);
    b('\n');
  }
  
  void b(boolean paramBoolean)
  {
    a(paramBoolean);
    b('\n');
  }
  
  void c()
  {
    if (this.h)
    {
      this.h = false;
      int j = this.i;
      for (;;)
      {
        j -= 1;
        if (j < 0) {
          break;
        }
        a(' ');
      }
    }
  }
  
  void c(char paramChar)
  {
    b(paramChar);
    b('\n');
  }
  
  void c(long paramLong)
  {
    a(paramLong);
    b('\n');
  }
  
  void d()
  {
    b('\n');
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */