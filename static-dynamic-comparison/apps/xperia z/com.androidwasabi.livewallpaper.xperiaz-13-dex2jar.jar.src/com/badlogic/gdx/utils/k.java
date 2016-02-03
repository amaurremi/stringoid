package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.b;

public class k<K, V>
{
  public int a;
  K[] b;
  V[] c;
  int d;
  int e;
  private float f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private l l;
  private l m;
  private n n;
  private n o;
  
  public k()
  {
    this(32, 0.8F);
  }
  
  public k(int paramInt, float paramFloat)
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
    this.c = ((Object[])new Object[this.b.length]);
  }
  
  private void a(K paramK1, V paramV, int paramInt1, K paramK2, int paramInt2, K paramK3, int paramInt3, K paramK4)
  {
    Object[] arrayOfObject1 = this.b;
    Object[] arrayOfObject2 = this.c;
    int i3 = this.h;
    int i2 = 0;
    int i4 = this.k;
    int i1 = paramInt3;
    paramInt3 = paramInt2;
    paramInt2 = paramInt1;
    V ? = paramV;
    K ? = paramK1;
    paramInt1 = i2;
    label278:
    label341:
    do
    {
      switch (b.a(2))
      {
      default: 
        paramV = arrayOfObject2[i1];
        arrayOfObject1[i1] = ?;
        arrayOfObject2[i1] = ?;
        paramK1 = paramK4;
        i1 = paramK1.hashCode();
        paramInt2 = i1 & i3;
        paramK2 = arrayOfObject1[paramInt2];
        if (paramK2 == null)
        {
          arrayOfObject1[paramInt2] = paramK1;
          arrayOfObject2[paramInt2] = paramV;
          paramInt1 = this.a;
          this.a = (paramInt1 + 1);
          if (paramInt1 >= this.i) {
            b(this.d << 1);
          }
        }
        break;
      }
      do
      {
        do
        {
          return;
          paramV = arrayOfObject2[paramInt2];
          arrayOfObject1[paramInt2] = ?;
          arrayOfObject2[paramInt2] = ?;
          paramK1 = paramK2;
          break;
          paramV = arrayOfObject2[paramInt3];
          arrayOfObject1[paramInt3] = ?;
          arrayOfObject2[paramInt3] = ?;
          paramK1 = paramK3;
          break;
          paramInt3 = c(i1);
          paramK3 = arrayOfObject1[paramInt3];
          if (paramK3 != null) {
            break label278;
          }
          arrayOfObject1[paramInt3] = paramK1;
          arrayOfObject2[paramInt3] = paramV;
          paramInt1 = this.a;
          this.a = (paramInt1 + 1);
        } while (paramInt1 < this.i);
        b(this.d << 1);
        return;
        i1 = d(i1);
        paramK4 = arrayOfObject1[i1];
        if (paramK4 != null) {
          break label341;
        }
        arrayOfObject1[i1] = paramK1;
        arrayOfObject2[i1] = paramV;
        paramInt1 = this.a;
        this.a = (paramInt1 + 1);
      } while (paramInt1 < this.i);
      b(this.d << 1);
      return;
      i2 = paramInt1 + 1;
      paramInt1 = i2;
      ? = paramK1;
      ? = paramV;
    } while (i2 != i4);
    d(paramK1, paramV);
  }
  
  private V b(K paramK, V paramV)
  {
    Object[] arrayOfObject = this.b;
    int i1 = paramK.hashCode();
    int i3 = i1 & this.h;
    Object localObject1 = arrayOfObject[i3];
    if (paramK.equals(localObject1))
    {
      paramK = this.c[i3];
      this.c[i3] = paramV;
      return paramK;
    }
    int i4 = c(i1);
    Object localObject2 = arrayOfObject[i4];
    if (paramK.equals(localObject2))
    {
      paramK = this.c[i4];
      this.c[i4] = paramV;
      return paramK;
    }
    int i5 = d(i1);
    Object localObject3 = arrayOfObject[i5];
    if (paramK.equals(localObject3))
    {
      paramK = this.c[i5];
      this.c[i5] = paramV;
      return paramK;
    }
    int i2 = this.d;
    int i6 = this.e;
    i1 = i2;
    while (i1 < i2 + i6)
    {
      if (paramK.equals(arrayOfObject[i1]))
      {
        paramK = this.c[i1];
        this.c[i1] = paramV;
        return paramK;
      }
      i1 += 1;
    }
    if (localObject1 == null)
    {
      arrayOfObject[i3] = paramK;
      this.c[i3] = paramV;
      i1 = this.a;
      this.a = (i1 + 1);
      if (i1 >= this.i) {
        b(this.d << 1);
      }
      return null;
    }
    if (localObject2 == null)
    {
      arrayOfObject[i4] = paramK;
      this.c[i4] = paramV;
      i1 = this.a;
      this.a = (i1 + 1);
      if (i1 >= this.i) {
        b(this.d << 1);
      }
      return null;
    }
    if (localObject3 == null)
    {
      arrayOfObject[i5] = paramK;
      this.c[i5] = paramV;
      i1 = this.a;
      this.a = (i1 + 1);
      if (i1 >= this.i) {
        b(this.d << 1);
      }
      return null;
    }
    a(paramK, paramV, i3, localObject1, i4, localObject2, i5, localObject3);
    return null;
  }
  
  private void b(int paramInt)
  {
    int i1 = this.d;
    int i2 = this.e;
    this.d = paramInt;
    this.i = ((int)(paramInt * this.f));
    this.h = (paramInt - 1);
    this.g = (31 - Integer.numberOfTrailingZeros(paramInt));
    this.j = Math.max(3, (int)Math.ceil(Math.log(paramInt)) * 2);
    this.k = Math.max(Math.min(paramInt, 8), (int)Math.sqrt(paramInt) / 8);
    Object[] arrayOfObject1 = this.b;
    Object[] arrayOfObject2 = this.c;
    this.b = ((Object[])new Object[this.j + paramInt]);
    this.c = ((Object[])new Object[this.j + paramInt]);
    paramInt = this.a;
    this.a = 0;
    this.e = 0;
    if (paramInt > 0)
    {
      paramInt = 0;
      while (paramInt < i2 + i1)
      {
        Object localObject = arrayOfObject1[paramInt];
        if (localObject != null) {
          c(localObject, arrayOfObject2[paramInt]);
        }
        paramInt += 1;
      }
    }
  }
  
  private int c(int paramInt)
  {
    paramInt = -1262997959 * paramInt;
    return (paramInt ^ paramInt >>> this.g) & this.h;
  }
  
  private void c(K paramK, V paramV)
  {
    int i3 = paramK.hashCode();
    int i1 = i3 & this.h;
    Object localObject1 = this.b[i1];
    if (localObject1 == null)
    {
      this.b[i1] = paramK;
      this.c[i1] = paramV;
      i1 = this.a;
      this.a = (i1 + 1);
      if (i1 >= this.i) {
        b(this.d << 1);
      }
    }
    int i2;
    Object localObject2;
    Object localObject3;
    do
    {
      do
      {
        return;
        i2 = c(i3);
        localObject2 = this.b[i2];
        if (localObject2 != null) {
          break;
        }
        this.b[i2] = paramK;
        this.c[i2] = paramV;
        i1 = this.a;
        this.a = (i1 + 1);
      } while (i1 < this.i);
      b(this.d << 1);
      return;
      i3 = d(i3);
      localObject3 = this.b[i3];
      if (localObject3 != null) {
        break;
      }
      this.b[i3] = paramK;
      this.c[i3] = paramV;
      i1 = this.a;
      this.a = (i1 + 1);
    } while (i1 < this.i);
    b(this.d << 1);
    return;
    a(paramK, paramV, i1, localObject1, i2, localObject2, i3, localObject3);
  }
  
  private int d(int paramInt)
  {
    paramInt = -825114047 * paramInt;
    return (paramInt ^ paramInt >>> this.g) & this.h;
  }
  
  private void d(K paramK, V paramV)
  {
    if (this.e == this.j)
    {
      b(this.d << 1);
      b(paramK, paramV);
      return;
    }
    int i1 = this.d + this.e;
    this.b[i1] = paramK;
    this.c[i1] = paramV;
    this.e += 1;
    this.a += 1;
  }
  
  private V e(K paramK)
  {
    Object[] arrayOfObject = this.b;
    int i2 = this.d;
    int i3 = this.e;
    int i1 = i2;
    while (i1 < i3 + i2)
    {
      if (paramK.equals(arrayOfObject[i1])) {
        return (V)this.c[i1];
      }
      i1 += 1;
    }
    return null;
  }
  
  private boolean f(K paramK)
  {
    Object[] arrayOfObject = this.b;
    int i2 = this.d;
    int i3 = this.e;
    int i1 = i2;
    while (i1 < i3 + i2)
    {
      if (paramK.equals(arrayOfObject[i1])) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public V a(K paramK)
  {
    int i3 = paramK.hashCode();
    int i2 = this.h & i3;
    int i1 = i2;
    if (!paramK.equals(this.b[i2]))
    {
      i2 = c(i3);
      i1 = i2;
      if (!paramK.equals(this.b[i2]))
      {
        i2 = d(i3);
        i1 = i2;
        if (!paramK.equals(this.b[i2])) {
          return (V)e(paramK);
        }
      }
    }
    return (V)this.c[i1];
  }
  
  public V a(K paramK, V paramV)
  {
    if (paramK == null) {
      throw new IllegalArgumentException("key cannot be null.");
    }
    return (V)b(paramK, paramV);
  }
  
  public void a()
  {
    Object[] arrayOfObject1 = this.b;
    Object[] arrayOfObject2 = this.c;
    int i2;
    for (int i1 = this.d + this.e;; i1 = i2)
    {
      i2 = i1 - 1;
      if (i1 <= 0) {
        break;
      }
      arrayOfObject1[i2] = null;
      arrayOfObject2[i2] = null;
    }
    this.a = 0;
    this.e = 0;
  }
  
  void a(int paramInt)
  {
    this.e -= 1;
    int i1 = this.d + this.e;
    if (paramInt < i1)
    {
      this.b[paramInt] = this.b[i1];
      this.c[paramInt] = this.c[i1];
      this.c[i1] = null;
      return;
    }
    this.c[paramInt] = null;
  }
  
  public l<K, V> b()
  {
    if (this.l == null)
    {
      this.l = new l(this);
      this.m = new l(this);
    }
    if (!this.l.f)
    {
      this.l.b();
      this.l.f = true;
      this.m.f = false;
      return this.l;
    }
    this.m.b();
    this.m.f = true;
    this.l.f = false;
    return this.m;
  }
  
  public V b(K paramK)
  {
    int i1 = paramK.hashCode();
    int i2 = this.h & i1;
    if (paramK.equals(this.b[i2]))
    {
      this.b[i2] = null;
      paramK = this.c[i2];
      this.c[i2] = null;
      this.a -= 1;
      return paramK;
    }
    i2 = c(i1);
    if (paramK.equals(this.b[i2]))
    {
      this.b[i2] = null;
      paramK = this.c[i2];
      this.c[i2] = null;
      this.a -= 1;
      return paramK;
    }
    i1 = d(i1);
    if (paramK.equals(this.b[i1]))
    {
      this.b[i1] = null;
      paramK = this.c[i1];
      this.c[i1] = null;
      this.a -= 1;
      return paramK;
    }
    return (V)c(paramK);
  }
  
  public n<K> c()
  {
    if (this.n == null)
    {
      this.n = new n(this);
      this.o = new n(this);
    }
    if (!this.n.f)
    {
      this.n.b();
      this.n.f = true;
      this.o.f = false;
      return this.n;
    }
    this.o.b();
    this.o.f = true;
    this.n.f = false;
    return this.o;
  }
  
  V c(K paramK)
  {
    Object[] arrayOfObject = this.b;
    int i2 = this.d;
    int i3 = this.e;
    int i1 = i2;
    while (i1 < i2 + i3)
    {
      if (paramK.equals(arrayOfObject[i1]))
      {
        paramK = this.c[i1];
        a(i1);
        this.a -= 1;
        return paramK;
      }
      i1 += 1;
    }
    return null;
  }
  
  public boolean d(K paramK)
  {
    int i1 = paramK.hashCode();
    int i2 = this.h;
    if (!paramK.equals(this.b[(i2 & i1)]))
    {
      i2 = c(i1);
      if (!paramK.equals(this.b[i2]))
      {
        i1 = d(i1);
        if (!paramK.equals(this.b[i1])) {
          return f(paramK);
        }
      }
    }
    return true;
  }
  
  public String toString()
  {
    if (this.a == 0) {
      return "{}";
    }
    t localt = new t(32);
    localt.b('{');
    Object[] arrayOfObject1 = this.b;
    Object[] arrayOfObject2 = this.c;
    int i3;
    Object localObject;
    for (int i2 = arrayOfObject1.length;; i2 = i3)
    {
      i3 = i2 - 1;
      i1 = i3;
      if (i2 <= 0) {
        break label99;
      }
      localObject = arrayOfObject1[i3];
      if (localObject != null) {
        break;
      }
    }
    localt.a(localObject);
    localt.b('=');
    localt.a(arrayOfObject2[i3]);
    int i1 = i3;
    for (;;)
    {
      label99:
      i2 = i1 - 1;
      if (i1 <= 0) {
        break;
      }
      localObject = arrayOfObject1[i2];
      if (localObject == null)
      {
        i1 = i2;
      }
      else
      {
        localt.b(", ");
        localt.a(localObject);
        localt.b('=');
        localt.a(arrayOfObject2[i2]);
        i1 = i2;
      }
    }
    localt.b('}');
    return localt.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/utils/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */