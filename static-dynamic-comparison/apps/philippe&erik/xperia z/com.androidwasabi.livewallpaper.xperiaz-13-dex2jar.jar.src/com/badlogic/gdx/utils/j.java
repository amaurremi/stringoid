package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.b;

public class j<K>
{
  public int a;
  K[] b;
  int[] c;
  int d;
  int e;
  private float f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  
  public j()
  {
    this(32, 0.8F);
  }
  
  public j(int paramInt, float paramFloat)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("initialCapacity must be >= 0: " + paramInt);
    }
    if (paramInt > 1073741824) {
      throw new IllegalArgumentException("initialCapacity is too large: " + paramInt);
    }
    this.d = b.b(paramInt);
    if (paramFloat <= 0.0F) {
      throw new IllegalArgumentException("loadFactor must be > 0: " + paramFloat);
    }
    this.f = paramFloat;
    this.i = ((int)(this.d * paramFloat));
    this.h = (this.d - 1);
    this.g = (31 - Integer.numberOfTrailingZeros(this.d));
    this.j = Math.max(3, (int)Math.ceil(Math.log(this.d)) * 2);
    this.k = Math.max(Math.min(this.d, 8), (int)Math.sqrt(this.d) / 8);
    this.b = ((Object[])new Object[this.d + this.j]);
    this.c = new int[this.b.length];
  }
  
  private void a(int paramInt)
  {
    int m = this.d;
    int n = this.e;
    this.d = paramInt;
    this.i = ((int)(paramInt * this.f));
    this.h = (paramInt - 1);
    this.g = (31 - Integer.numberOfTrailingZeros(paramInt));
    this.j = Math.max(3, (int)Math.ceil(Math.log(paramInt)) * 2);
    this.k = Math.max(Math.min(paramInt, 8), (int)Math.sqrt(paramInt) / 8);
    Object[] arrayOfObject = this.b;
    int[] arrayOfInt = this.c;
    this.b = ((Object[])new Object[this.j + paramInt]);
    this.c = new int[this.j + paramInt];
    paramInt = this.a;
    this.a = 0;
    this.e = 0;
    if (paramInt > 0)
    {
      paramInt = 0;
      while (paramInt < n + m)
      {
        Object localObject = arrayOfObject[paramInt];
        if (localObject != null) {
          c(localObject, arrayOfInt[paramInt]);
        }
        paramInt += 1;
      }
    }
  }
  
  private void a(K paramK1, int paramInt1, int paramInt2, K paramK2, int paramInt3, K paramK3, int paramInt4, K paramK4)
  {
    Object[] arrayOfObject = this.b;
    int[] arrayOfInt = this.c;
    int i2 = this.h;
    int i1 = 0;
    int i3 = this.k;
    int n = paramInt4;
    int m = paramInt3;
    paramInt4 = paramInt2;
    paramInt3 = paramInt1;
    K ? = paramK1;
    paramInt2 = i1;
    label278:
    label341:
    do
    {
      switch (b.a(2))
      {
      default: 
        paramInt1 = arrayOfInt[n];
        arrayOfObject[n] = ?;
        arrayOfInt[n] = paramInt3;
        paramK1 = paramK4;
        paramInt3 = paramK1.hashCode();
        paramInt4 = paramInt3 & i2;
        paramK2 = arrayOfObject[paramInt4];
        if (paramK2 == null)
        {
          arrayOfObject[paramInt4] = paramK1;
          arrayOfInt[paramInt4] = paramInt1;
          paramInt1 = this.a;
          this.a = (paramInt1 + 1);
          if (paramInt1 >= this.i) {
            a(this.d << 1);
          }
        }
        break;
      }
      do
      {
        do
        {
          return;
          paramInt1 = arrayOfInt[paramInt4];
          arrayOfObject[paramInt4] = ?;
          arrayOfInt[paramInt4] = paramInt3;
          paramK1 = paramK2;
          break;
          paramInt1 = arrayOfInt[m];
          arrayOfObject[m] = ?;
          arrayOfInt[m] = paramInt3;
          paramK1 = paramK3;
          break;
          m = b(paramInt3);
          paramK3 = arrayOfObject[m];
          if (paramK3 != null) {
            break label278;
          }
          arrayOfObject[m] = paramK1;
          arrayOfInt[m] = paramInt1;
          paramInt1 = this.a;
          this.a = (paramInt1 + 1);
        } while (paramInt1 < this.i);
        a(this.d << 1);
        return;
        n = c(paramInt3);
        paramK4 = arrayOfObject[n];
        if (paramK4 != null) {
          break label341;
        }
        arrayOfObject[n] = paramK1;
        arrayOfInt[n] = paramInt1;
        paramInt1 = this.a;
        this.a = (paramInt1 + 1);
      } while (paramInt1 < this.i);
      a(this.d << 1);
      return;
      i1 = paramInt2 + 1;
      paramInt2 = i1;
      ? = paramK1;
      paramInt3 = paramInt1;
    } while (i1 != i3);
    d(paramK1, paramInt1);
  }
  
  private int b(int paramInt)
  {
    paramInt = -1262997959 * paramInt;
    return (paramInt ^ paramInt >>> this.g) & this.h;
  }
  
  private int c(int paramInt)
  {
    paramInt = -825114047 * paramInt;
    return (paramInt ^ paramInt >>> this.g) & this.h;
  }
  
  private void c(K paramK, int paramInt)
  {
    int i1 = paramK.hashCode();
    int m = i1 & this.h;
    Object localObject1 = this.b[m];
    if (localObject1 == null)
    {
      this.b[m] = paramK;
      this.c[m] = paramInt;
      paramInt = this.a;
      this.a = (paramInt + 1);
      if (paramInt >= this.i) {
        a(this.d << 1);
      }
    }
    int n;
    Object localObject2;
    Object localObject3;
    do
    {
      do
      {
        return;
        n = b(i1);
        localObject2 = this.b[n];
        if (localObject2 != null) {
          break;
        }
        this.b[n] = paramK;
        this.c[n] = paramInt;
        paramInt = this.a;
        this.a = (paramInt + 1);
      } while (paramInt < this.i);
      a(this.d << 1);
      return;
      i1 = c(i1);
      localObject3 = this.b[i1];
      if (localObject3 != null) {
        break;
      }
      this.b[i1] = paramK;
      this.c[i1] = paramInt;
      paramInt = this.a;
      this.a = (paramInt + 1);
    } while (paramInt < this.i);
    a(this.d << 1);
    return;
    a(paramK, paramInt, m, localObject1, n, localObject2, i1, localObject3);
  }
  
  private void d(K paramK, int paramInt)
  {
    if (this.e == this.j)
    {
      a(this.d << 1);
      a(paramK, paramInt);
      return;
    }
    int m = this.d + this.e;
    this.b[m] = paramK;
    this.c[m] = paramInt;
    this.e += 1;
    this.a += 1;
  }
  
  private int e(K paramK, int paramInt)
  {
    Object[] arrayOfObject = this.b;
    int n = this.d;
    int i2 = this.e;
    int i1;
    for (int m = n;; m = i1 + 1)
    {
      i1 = m;
      m = paramInt;
      if (i1 < i2 + n)
      {
        if (paramK.equals(arrayOfObject[i1])) {
          m = this.c[i1];
        }
      }
      else {
        return m;
      }
    }
  }
  
  public void a()
  {
    Object[] arrayOfObject = this.b;
    int n;
    for (int m = this.d + this.e;; m = n)
    {
      n = m - 1;
      if (m <= 0) {
        break;
      }
      arrayOfObject[n] = null;
    }
    this.a = 0;
    this.e = 0;
  }
  
  public void a(K paramK, int paramInt)
  {
    if (paramK == null) {
      throw new IllegalArgumentException("key cannot be null.");
    }
    Object[] arrayOfObject = this.b;
    int m = paramK.hashCode();
    int i1 = m & this.h;
    Object localObject1 = arrayOfObject[i1];
    if (paramK.equals(localObject1)) {
      this.c[i1] = paramInt;
    }
    int i2;
    Object localObject2;
    int i3;
    Object localObject3;
    do
    {
      do
      {
        do
        {
          return;
          i2 = b(m);
          localObject2 = arrayOfObject[i2];
          if (paramK.equals(localObject2))
          {
            this.c[i2] = paramInt;
            return;
          }
          i3 = c(m);
          localObject3 = arrayOfObject[i3];
          if (paramK.equals(localObject3))
          {
            this.c[i3] = paramInt;
            return;
          }
          int n = this.d;
          int i4 = this.e;
          m = n;
          while (m < i4 + n)
          {
            if (paramK.equals(arrayOfObject[m]))
            {
              this.c[m] = paramInt;
              return;
            }
            m += 1;
          }
          if (localObject1 != null) {
            break;
          }
          arrayOfObject[i1] = paramK;
          this.c[i1] = paramInt;
          paramInt = this.a;
          this.a = (paramInt + 1);
        } while (paramInt < this.i);
        a(this.d << 1);
        return;
        if (localObject2 != null) {
          break;
        }
        arrayOfObject[i2] = paramK;
        this.c[i2] = paramInt;
        paramInt = this.a;
        this.a = (paramInt + 1);
      } while (paramInt < this.i);
      a(this.d << 1);
      return;
      if (localObject3 != null) {
        break;
      }
      arrayOfObject[i3] = paramK;
      this.c[i3] = paramInt;
      paramInt = this.a;
      this.a = (paramInt + 1);
    } while (paramInt < this.i);
    a(this.d << 1);
    return;
    a(paramK, paramInt, i1, localObject1, i2, localObject2, i3, localObject3);
  }
  
  public int b(K paramK, int paramInt)
  {
    int i1 = paramK.hashCode();
    int n = this.h & i1;
    int m = n;
    if (!paramK.equals(this.b[n]))
    {
      n = b(i1);
      m = n;
      if (!paramK.equals(this.b[n]))
      {
        n = c(i1);
        m = n;
        if (!paramK.equals(this.b[n])) {
          return e(paramK, paramInt);
        }
      }
    }
    return this.c[m];
  }
  
  public String toString()
  {
    if (this.a == 0) {
      return "{}";
    }
    t localt = new t(32);
    localt.b('{');
    Object[] arrayOfObject = this.b;
    int[] arrayOfInt = this.c;
    int i1;
    Object localObject;
    for (int n = arrayOfObject.length;; n = i1)
    {
      i1 = n - 1;
      m = i1;
      if (n <= 0) {
        break label99;
      }
      localObject = arrayOfObject[i1];
      if (localObject != null) {
        break;
      }
    }
    localt.a(localObject);
    localt.b('=');
    localt.a(arrayOfInt[i1]);
    int m = i1;
    for (;;)
    {
      label99:
      n = m - 1;
      if (m <= 0) {
        break;
      }
      localObject = arrayOfObject[n];
      if (localObject == null)
      {
        m = n;
      }
      else
      {
        localt.b(", ");
        localt.a(localObject);
        localt.b('=');
        localt.a(arrayOfInt[n]);
        m = n;
      }
    }
    localt.b('}');
    return localt.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/utils/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */