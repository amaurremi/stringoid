package org.a.a.b;

import org.a.a.c.g;
import org.a.a.c.h;

class j
  extends h
{
  private final d a;
  private final int c;
  private final int d;
  
  j(d paramd, int paramInt)
  {
    super(org.a.a.d.r(), paramd.V());
    this.a = paramd;
    this.c = this.a.S();
    this.d = paramInt;
  }
  
  public int a(long paramLong)
  {
    return this.a.b(paramLong);
  }
  
  public long a(long paramLong, int paramInt)
  {
    if (paramInt == 0) {
      return paramLong;
    }
    long l = this.a.h(paramLong);
    int k = this.a.a(paramLong);
    int m = this.a.a(paramLong, k);
    int j = m - 1 + paramInt;
    int i;
    if (j >= 0)
    {
      paramInt = j / this.c + k;
      i = j % this.c + 1;
    }
    for (;;)
    {
      j = this.a.a(paramLong, k, m);
      k = this.a.b(paramInt, i);
      if (j > k) {
        j = k;
      }
      for (;;)
      {
        return this.a.a(paramInt, i, j) + l;
        i = j / this.c + k - 1;
        j = Math.abs(j) % this.c;
        paramInt = j;
        if (j == 0) {
          paramInt = this.c;
        }
        paramInt = this.c - paramInt + 1;
        if (paramInt != 1) {
          break label198;
        }
        j = i + 1;
        i = paramInt;
        paramInt = j;
        break;
      }
      label198:
      j = paramInt;
      paramInt = i;
      i = j;
    }
  }
  
  public long a(long paramLong1, long paramLong2)
  {
    int i = (int)paramLong2;
    if (i == paramLong2) {
      return a(paramLong1, i);
    }
    long l4 = this.a.h(paramLong1);
    int n = this.a.a(paramLong1);
    int i1 = this.a.a(paramLong1, n);
    long l3 = i1 - 1 + paramLong2;
    long l1;
    long l2;
    if (l3 >= 0L)
    {
      l1 = n + l3 / this.c;
      l2 = l3 % this.c + 1L;
    }
    for (;;)
    {
      int j;
      if ((l1 < this.a.Q()) || (l1 > this.a.R()))
      {
        throw new IllegalArgumentException("Magnitude of add amount is too large: " + paramLong2);
        l2 = n + l3 / this.c - 1L;
        j = (int)(Math.abs(l3) % this.c);
        i = j;
        if (j == 0) {
          i = this.c;
        }
        l1 = this.c - i + 1;
        if (l1 == 1L)
        {
          l3 = l2 + 1L;
          l2 = l1;
          l1 = l3;
        }
      }
      else
      {
        int k = (int)l1;
        int m = (int)l2;
        i = this.a.a(paramLong1, n, i1);
        j = this.a.b(k, m);
        if (i > j) {
          i = j;
        }
        for (;;)
        {
          return this.a.a(k, m, i) + l4;
        }
      }
      l3 = l1;
      l1 = l2;
      l2 = l3;
    }
  }
  
  public long b(long paramLong, int paramInt)
  {
    g.a(this, paramInt, 1, this.c);
    int k = this.a.a(paramLong);
    int i = this.a.b(paramLong, k);
    int j = this.a.b(k, paramInt);
    if (i > j) {
      i = j;
    }
    for (;;)
    {
      return this.a.a(k, paramInt, i) + this.a.h(paramLong);
    }
  }
  
  public boolean b(long paramLong)
  {
    boolean bool2 = false;
    int i = this.a.a(paramLong);
    boolean bool1 = bool2;
    if (this.a.e(i))
    {
      bool1 = bool2;
      if (this.a.a(paramLong, i) == this.d) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public long d(long paramLong)
  {
    int i = this.a.a(paramLong);
    int j = this.a.a(paramLong, i);
    return this.a.a(i, j);
  }
  
  public org.a.a.j e()
  {
    return this.a.D();
  }
  
  public org.a.a.j f()
  {
    return this.a.s();
  }
  
  public int g()
  {
    return 1;
  }
  
  public int h()
  {
    return this.c;
  }
  
  public long i(long paramLong)
  {
    return paramLong - d(paramLong);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */