package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.b;

public class g<V>
{
  public int a;
  int[] b;
  V[] c;
  int d;
  int e;
  V f;
  boolean g;
  private float h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  
  private void a(int paramInt1, V paramV, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    int[] arrayOfInt = this.b;
    Object[] arrayOfObject = this.c;
    int i3 = this.j;
    int i2 = 0;
    int i4 = this.m;
    int i1 = paramInt6;
    int n = paramInt4;
    paramInt6 = paramInt2;
    V ? = paramV;
    paramInt4 = paramInt1;
    paramInt2 = i2;
    label270:
    label332:
    do
    {
      switch (b.a(2))
      {
      default: 
        paramV = arrayOfObject[i1];
        arrayOfInt[i1] = paramInt4;
        arrayOfObject[i1] = ?;
        paramInt1 = paramInt7;
        paramInt6 = paramInt1 & i3;
        paramInt3 = arrayOfInt[paramInt6];
        if (paramInt3 == 0)
        {
          arrayOfInt[paramInt6] = paramInt1;
          arrayOfObject[paramInt6] = paramV;
          paramInt1 = this.a;
          this.a = (paramInt1 + 1);
          if (paramInt1 >= this.k) {
            d(this.d << 1);
          }
        }
        break;
      }
      do
      {
        do
        {
          return;
          paramV = arrayOfObject[paramInt6];
          arrayOfInt[paramInt6] = paramInt4;
          arrayOfObject[paramInt6] = ?;
          paramInt1 = paramInt3;
          break;
          paramV = arrayOfObject[n];
          arrayOfInt[n] = paramInt4;
          arrayOfObject[n] = ?;
          paramInt1 = paramInt5;
          break;
          n = e(paramInt1);
          paramInt5 = arrayOfInt[n];
          if (paramInt5 != 0) {
            break label270;
          }
          arrayOfInt[n] = paramInt1;
          arrayOfObject[n] = paramV;
          paramInt1 = this.a;
          this.a = (paramInt1 + 1);
        } while (paramInt1 < this.k);
        d(this.d << 1);
        return;
        i1 = f(paramInt1);
        paramInt7 = arrayOfInt[i1];
        if (paramInt7 != 0) {
          break label332;
        }
        arrayOfInt[i1] = paramInt1;
        arrayOfObject[i1] = paramV;
        paramInt1 = this.a;
        this.a = (paramInt1 + 1);
      } while (paramInt1 < this.k);
      d(this.d << 1);
      return;
      i2 = paramInt2 + 1;
      paramInt2 = i2;
      paramInt4 = paramInt1;
      ? = paramV;
    } while (i2 != i4);
    c(paramInt1, paramV);
  }
  
  private void b(int paramInt, V paramV)
  {
    if (paramInt == 0)
    {
      this.f = paramV;
      this.g = true;
    }
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    do
    {
      do
      {
        do
        {
          return;
          n = paramInt & this.j;
          i1 = this.b[n];
          if (i1 != 0) {
            break;
          }
          this.b[n] = paramInt;
          this.c[n] = paramV;
          paramInt = this.a;
          this.a = (paramInt + 1);
        } while (paramInt < this.k);
        d(this.d << 1);
        return;
        i2 = e(paramInt);
        i3 = this.b[i2];
        if (i3 != 0) {
          break;
        }
        this.b[i2] = paramInt;
        this.c[i2] = paramV;
        paramInt = this.a;
        this.a = (paramInt + 1);
      } while (paramInt < this.k);
      d(this.d << 1);
      return;
      i4 = f(paramInt);
      i5 = this.b[i4];
      if (i5 != 0) {
        break;
      }
      this.b[i4] = paramInt;
      this.c[i4] = paramV;
      paramInt = this.a;
      this.a = (paramInt + 1);
    } while (paramInt < this.k);
    d(this.d << 1);
    return;
    a(paramInt, paramV, n, i1, i2, i3, i4, i5);
  }
  
  private void c(int paramInt, V paramV)
  {
    if (this.e == this.l)
    {
      d(this.d << 1);
      a(paramInt, paramV);
      return;
    }
    int n = this.d + this.e;
    this.b[n] = paramInt;
    this.c[n] = paramV;
    this.e += 1;
    this.a += 1;
  }
  
  private void d(int paramInt)
  {
    int n = 0;
    int i1 = this.d;
    int i2 = this.e;
    this.d = paramInt;
    this.k = ((int)(paramInt * this.h));
    this.j = (paramInt - 1);
    this.i = (31 - Integer.numberOfTrailingZeros(paramInt));
    this.l = Math.max(3, (int)Math.ceil(Math.log(paramInt)) * 2);
    this.m = Math.max(Math.min(paramInt, 8), (int)Math.sqrt(paramInt) / 8);
    int[] arrayOfInt = this.b;
    Object[] arrayOfObject = this.c;
    this.b = new int[this.l + paramInt];
    this.c = ((Object[])new Object[this.l + paramInt]);
    int i3 = this.a;
    if (this.g) {}
    for (paramInt = 1;; paramInt = 0)
    {
      this.a = paramInt;
      this.e = 0;
      if (i3 <= 0) {
        break;
      }
      paramInt = n;
      while (paramInt < i2 + i1)
      {
        n = arrayOfInt[paramInt];
        if (n != 0) {
          b(n, arrayOfObject[paramInt]);
        }
        paramInt += 1;
      }
    }
  }
  
  private int e(int paramInt)
  {
    paramInt = -1262997959 * paramInt;
    return (paramInt ^ paramInt >>> this.i) & this.j;
  }
  
  private int f(int paramInt)
  {
    paramInt = -825114047 * paramInt;
    return (paramInt ^ paramInt >>> this.i) & this.j;
  }
  
  public V a(int paramInt)
  {
    Object localObject;
    if (paramInt == 0)
    {
      if (!this.g) {
        return null;
      }
      localObject = this.f;
      this.f = null;
      this.g = false;
      this.a -= 1;
      return (V)localObject;
    }
    int n = paramInt & this.j;
    if (this.b[n] == paramInt)
    {
      this.b[n] = 0;
      localObject = this.c[n];
      this.c[n] = null;
      this.a -= 1;
      return (V)localObject;
    }
    n = e(paramInt);
    if (this.b[n] == paramInt)
    {
      this.b[n] = 0;
      localObject = this.c[n];
      this.c[n] = null;
      this.a -= 1;
      return (V)localObject;
    }
    n = f(paramInt);
    if (this.b[n] == paramInt)
    {
      this.b[n] = 0;
      localObject = this.c[n];
      this.c[n] = null;
      this.a -= 1;
      return (V)localObject;
    }
    return (V)b(paramInt);
  }
  
  public V a(int paramInt, V paramV)
  {
    if (paramInt == 0)
    {
      localObject = this.f;
      this.f = paramV;
      if (!this.g)
      {
        this.g = true;
        this.a += 1;
      }
      return (V)localObject;
    }
    Object localObject = this.b;
    int i2 = paramInt & this.j;
    int i3 = localObject[i2];
    if (i3 == paramInt)
    {
      localObject = this.c[i2];
      this.c[i2] = paramV;
      return (V)localObject;
    }
    int i4 = e(paramInt);
    int i5 = localObject[i4];
    if (i5 == paramInt)
    {
      localObject = this.c[i4];
      this.c[i4] = paramV;
      return (V)localObject;
    }
    int i6 = f(paramInt);
    int i7 = localObject[i6];
    if (i7 == paramInt)
    {
      localObject = this.c[i6];
      this.c[i6] = paramV;
      return (V)localObject;
    }
    int i1 = this.d;
    int i8 = this.e;
    int n = i1;
    while (n < i1 + i8)
    {
      if (localObject[n] == paramInt)
      {
        localObject = this.c[n];
        this.c[n] = paramV;
        return (V)localObject;
      }
      n += 1;
    }
    if (i3 == 0)
    {
      localObject[i2] = paramInt;
      this.c[i2] = paramV;
      paramInt = this.a;
      this.a = (paramInt + 1);
      if (paramInt >= this.k) {
        d(this.d << 1);
      }
      return null;
    }
    if (i5 == 0)
    {
      localObject[i4] = paramInt;
      this.c[i4] = paramV;
      paramInt = this.a;
      this.a = (paramInt + 1);
      if (paramInt >= this.k) {
        d(this.d << 1);
      }
      return null;
    }
    if (i7 == 0)
    {
      localObject[i6] = paramInt;
      this.c[i6] = paramV;
      paramInt = this.a;
      this.a = (paramInt + 1);
      if (paramInt >= this.k) {
        d(this.d << 1);
      }
      return null;
    }
    a(paramInt, paramV, i2, i3, i4, i5, i6, i7);
    return null;
  }
  
  V b(int paramInt)
  {
    Object localObject = this.b;
    int i1 = this.d;
    int i2 = this.e;
    int n = i1;
    while (n < i1 + i2)
    {
      if (localObject[n] == paramInt)
      {
        localObject = this.c[n];
        c(n);
        this.a -= 1;
        return (V)localObject;
      }
      n += 1;
    }
    return null;
  }
  
  void c(int paramInt)
  {
    this.e -= 1;
    int n = this.d + this.e;
    if (paramInt < n)
    {
      this.b[paramInt] = this.b[n];
      this.c[paramInt] = this.c[n];
      this.c[n] = null;
      return;
    }
    this.c[paramInt] = null;
  }
  
  public String toString()
  {
    if (this.a == 0) {
      return "[]";
    }
    t localt = new t(32);
    localt.b('[');
    int[] arrayOfInt = this.b;
    Object[] arrayOfObject = this.c;
    int n = arrayOfInt.length;
    int i1;
    if (this.g)
    {
      localt.b("0=");
      localt.a(this.f);
      for (;;)
      {
        i1 = n - 1;
        if (n <= 0) {
          break label184;
        }
        n = arrayOfInt[i1];
        if (n != 0) {
          break;
        }
        n = i1;
      }
    }
    for (;;)
    {
      int i2;
      i1 = i2 - 1;
      n = i1;
      if (i2 <= 0) {
        break;
      }
      n = arrayOfInt[i1];
      if (n == 0)
      {
        i2 = i1;
      }
      else
      {
        localt.a(n);
        localt.b('=');
        localt.a(arrayOfObject[i1]);
        n = i1;
        break;
        localt.b(", ");
        localt.a(n);
        localt.b('=');
        localt.a(arrayOfObject[i1]);
        n = i1;
        break;
        label184:
        localt.b(']');
        return localt.toString();
        i2 = n;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/utils/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */