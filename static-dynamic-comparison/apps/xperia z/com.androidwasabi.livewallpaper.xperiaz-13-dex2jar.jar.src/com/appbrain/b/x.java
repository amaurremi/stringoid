package com.appbrain.b;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class x
  extends d
{
  private static final int[] c;
  private final int d;
  private final d e;
  private final d f;
  private final int g;
  private int h;
  
  static
  {
    int i = 1;
    ArrayList localArrayList = new ArrayList();
    int j = 1;
    for (;;)
    {
      int k = j;
      if (i <= 0) {
        break;
      }
      localArrayList.add(Integer.valueOf(i));
      j = i;
      i = k + i;
    }
    localArrayList.add(Integer.valueOf(Integer.MAX_VALUE));
    c = new int[localArrayList.size()];
    i = 0;
    while (i < c.length)
    {
      c[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
  }
  
  protected final int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 + paramInt3 <= this.g) {
      return this.e.a(paramInt1, paramInt2, paramInt3);
    }
    if (paramInt2 >= this.g) {
      return this.f.a(paramInt1, paramInt2 - this.g, paramInt3);
    }
    int i = this.g - paramInt2;
    paramInt1 = this.e.a(paramInt1, paramInt2, i);
    return this.f.a(paramInt1, 0, paramInt3 - i);
  }
  
  public final e a()
  {
    return new z(this, (byte)0);
  }
  
  public final int b()
  {
    return this.d;
  }
  
  protected final int b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 + paramInt3 <= this.g) {
      return this.e.b(paramInt1, paramInt2, paramInt3);
    }
    if (paramInt2 >= this.g) {
      return this.f.b(paramInt1, paramInt2 - this.g, paramInt3);
    }
    int i = this.g - paramInt2;
    paramInt1 = this.e.b(paramInt1, paramInt2, i);
    return this.f.b(paramInt1, 0, paramInt3 - i);
  }
  
  public final String b(String paramString)
  {
    return new String(d(), paramString);
  }
  
  protected final void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 + paramInt3 <= this.g)
    {
      this.e.b(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
      return;
    }
    if (paramInt1 >= this.g)
    {
      this.f.b(paramArrayOfByte, paramInt1 - this.g, paramInt2, paramInt3);
      return;
    }
    int i = this.g - paramInt1;
    this.e.b(paramArrayOfByte, paramInt1, paramInt2, i);
    this.f.b(paramArrayOfByte, 0, paramInt2 + i, paramInt3 - i);
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool3 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool3;
        } while (!(paramObject instanceof d));
        paramObject = (d)paramObject;
        bool1 = bool3;
      } while (this.d != ((d)paramObject).b());
      if (this.d == 0) {
        return true;
      }
      if (this.h == 0) {
        break;
      }
      i = ((d)paramObject).h();
      if (i == 0) {
        break;
      }
      bool1 = bool3;
    } while (this.h != i);
    y localy1 = new y(this, (byte)0);
    r localr = (r)localy1.next();
    y localy2 = new y((d)paramObject, (byte)0);
    paramObject = (r)localy2.next();
    int i = 0;
    int j = 0;
    int k = 0;
    for (;;)
    {
      int i1 = localr.b() - j;
      int m = ((r)paramObject).b() - i;
      int n = Math.min(i1, m);
      if (j == 0) {}
      for (boolean bool2 = localr.a((r)paramObject, i, n);; bool2 = ((r)paramObject).a(localr, j, n))
      {
        bool1 = bool3;
        if (!bool2) {
          break;
        }
        k += n;
        if (k < this.d) {
          break label233;
        }
        if (k != this.d) {
          break label225;
        }
        return true;
      }
      label225:
      throw new IllegalStateException();
      label233:
      if (n == i1)
      {
        localr = (r)localy1.next();
        j = 0;
      }
      for (;;)
      {
        if (n != m) {
          break label285;
        }
        paramObject = (r)localy2.next();
        i = 0;
        break;
        j += n;
      }
      label285:
      i += n;
    }
  }
  
  public final boolean f()
  {
    boolean bool = false;
    int i = this.e.a(0, 0, this.g);
    if (this.f.a(i, 0, this.f.b()) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public final InputStream g()
  {
    return new aa(this);
  }
  
  protected final int h()
  {
    return this.h;
  }
  
  public final int hashCode()
  {
    int j = this.h;
    int i = j;
    if (j == 0)
    {
      j = b(this.d, 0, this.d);
      i = j;
      if (j == 0) {
        i = 1;
      }
      this.h = i;
    }
    return i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/b/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */