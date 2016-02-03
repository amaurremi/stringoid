package com.appbrain.b;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

final class r
  extends d
{
  protected final byte[] c;
  private int d = 0;
  
  r(byte[] paramArrayOfByte)
  {
    this.c = paramArrayOfByte;
  }
  
  protected final int a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 += 0;
    return af.a(paramInt1, this.c, paramInt2, paramInt2 + paramInt3);
  }
  
  public final e a()
  {
    return new s(this, (byte)0);
  }
  
  final boolean a(r paramr, int paramInt1, int paramInt2)
  {
    if (paramInt2 > paramr.c.length) {
      throw new IllegalArgumentException("Length too large: " + paramInt2 + this.c.length);
    }
    if (paramInt1 + paramInt2 > paramr.c.length) {
      throw new IllegalArgumentException("Ran off end of other: " + paramInt1 + ", " + paramInt2 + ", " + paramr.c.length);
    }
    byte[] arrayOfByte = this.c;
    paramr = paramr.c;
    paramInt1 += 0;
    int i = 0;
    while (i < paramInt2 + 0)
    {
      if (arrayOfByte[i] != paramr[paramInt1]) {
        return false;
      }
      i += 1;
      paramInt1 += 1;
    }
    return true;
  }
  
  public final byte b(int paramInt)
  {
    return this.c[paramInt];
  }
  
  public final int b()
  {
    return this.c.length;
  }
  
  protected final int b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = this.c;
    int i = paramInt2 + 0;
    paramInt2 = paramInt1;
    paramInt1 = i;
    while (paramInt1 < i + paramInt3)
    {
      paramInt2 = paramInt2 * 31 + arrayOfByte[paramInt1];
      paramInt1 += 1;
    }
    return paramInt2;
  }
  
  public final String b(String paramString)
  {
    return new String(this.c, 0, this.c.length, paramString);
  }
  
  protected final void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(this.c, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof d)) {
      return false;
    }
    if (this.c.length != ((d)paramObject).b()) {
      return false;
    }
    if (this.c.length == 0) {
      return true;
    }
    if ((paramObject instanceof r)) {
      return a((r)paramObject, 0, this.c.length);
    }
    if ((paramObject instanceof x)) {
      return paramObject.equals(this);
    }
    throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + paramObject.getClass());
  }
  
  public final boolean f()
  {
    boolean bool = false;
    if (af.a(this.c, 0, this.c.length + 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public final InputStream g()
  {
    return new ByteArrayInputStream(this.c, 0, this.c.length);
  }
  
  protected final int h()
  {
    return this.d;
  }
  
  public final int hashCode()
  {
    int j = this.d;
    int i = j;
    if (j == 0)
    {
      i = this.c.length;
      j = b(i, 0, i);
      i = j;
      if (j == 0) {
        i = 1;
      }
      this.d = i;
    }
    return i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/b/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */