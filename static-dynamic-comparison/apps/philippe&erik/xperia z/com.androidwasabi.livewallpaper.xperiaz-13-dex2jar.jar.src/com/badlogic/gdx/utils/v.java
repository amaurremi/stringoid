package com.badlogic.gdx.utils;

import com.badlogic.gdx.g;

public class v
{
  static final a<v> a = new a(1);
  static x b;
  static v c = new v();
  private final a<w> d = new a(false, 8);
  
  public v()
  {
    b();
  }
  
  public static v a()
  {
    if (c == null) {
      c = new v();
    }
    return c;
  }
  
  public static void b(w paramw, float paramFloat)
  {
    a().a(paramw, paramFloat);
  }
  
  static void c()
  {
    synchronized (a)
    {
      a.notifyAll();
      return;
    }
  }
  
  long a(long paramLong1, long paramLong2)
  {
    a locala = this.d;
    int i = 0;
    int j;
    int k;
    try
    {
      j = this.d.b;
      if (i < j)
      {
        w localw = (w)this.d.a(i);
        if (localw.b > paramLong1)
        {
          paramLong2 = Math.min(paramLong2, localw.b - paramLong1);
          k = i;
          i = j;
          j = k;
        }
        else
        {
          if (localw.d != -1)
          {
            if (localw.d == 0) {
              localw.d = -1;
            }
            g.a.a(localw);
          }
          if (localw.d == -1)
          {
            this.d.b(i);
            j -= 1;
            k = i - 1;
            i = j;
            j = k;
          }
          else
          {
            localw.b = (localw.c + paramLong1);
            paramLong2 = Math.min(paramLong2, localw.c);
            if (localw.d <= 0) {
              break label229;
            }
            localw.d -= 1;
            break label229;
          }
        }
      }
      else
      {
        return paramLong2;
      }
    }
    finally {}
    for (;;)
    {
      k = j + 1;
      j = i;
      i = k;
      break;
      label229:
      k = i;
      i = j;
      j = k;
    }
  }
  
  public void a(long paramLong)
  {
    synchronized (this.d)
    {
      int j = this.d.b;
      int i = 0;
      while (i < j)
      {
        w localw = (w)this.d.a(i);
        localw.b += paramLong;
        i += 1;
      }
      return;
    }
  }
  
  public void a(w paramw, float paramFloat)
  {
    a(paramw, paramFloat, 0.0F, 0);
  }
  
  public void a(w paramw, float paramFloat1, float paramFloat2, int paramInt)
  {
    if (paramw.d != -1) {
      throw new IllegalArgumentException("The same task may not be scheduled twice.");
    }
    paramw.b = (System.nanoTime() / 1000000L + (paramFloat1 * 1000.0F));
    paramw.c = ((paramFloat2 * 1000.0F));
    paramw.d = paramInt;
    synchronized (this.d)
    {
      this.d.a(paramw);
      c();
      return;
    }
  }
  
  public void b()
  {
    synchronized (a)
    {
      if (a.a(this, true)) {
        return;
      }
      a.a(this);
      if (b == null) {
        b = new x();
      }
      c();
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/utils/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */