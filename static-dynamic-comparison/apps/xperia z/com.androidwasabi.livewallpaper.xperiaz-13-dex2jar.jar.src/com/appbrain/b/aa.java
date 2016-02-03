package com.appbrain.b;

import java.io.InputStream;

final class aa
  extends InputStream
{
  private y b;
  private r c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public aa(x paramx)
  {
    a();
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    int j = paramInt1;
    paramInt1 = i;
    for (i = j; paramInt1 > 0; i = j)
    {
      b();
      if (this.c == null)
      {
        if (paramInt1 != paramInt2) {
          break;
        }
        return -1;
      }
      int k = Math.min(this.d - this.e, paramInt1);
      j = i;
      if (paramArrayOfByte != null)
      {
        this.c.a(paramArrayOfByte, this.e, i, k);
        j = i + k;
      }
      this.e += k;
      paramInt1 -= k;
    }
    return paramInt2 - paramInt1;
  }
  
  private void a()
  {
    this.b = new y(this.a, (byte)0);
    this.c = this.b.a();
    this.d = this.c.b();
    this.e = 0;
    this.f = 0;
  }
  
  private void b()
  {
    if ((this.c != null) && (this.e == this.d))
    {
      this.f += this.d;
      this.e = 0;
      if (this.b.hasNext())
      {
        this.c = this.b.a();
        this.d = this.c.b();
      }
    }
    else
    {
      return;
    }
    this.c = null;
    this.d = 0;
  }
  
  public final int available()
  {
    int i = this.f;
    int j = this.e;
    return this.a.b() - (i + j);
  }
  
  public final void mark(int paramInt)
  {
    this.g = (this.f + this.e);
  }
  
  public final boolean markSupported()
  {
    return true;
  }
  
  public final int read()
  {
    b();
    if (this.c == null) {
      return -1;
    }
    r localr = this.c;
    int i = this.e;
    this.e = (i + 1);
    return localr.b(i) & 0xFF;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException();
    }
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt2 > paramArrayOfByte.length - paramInt1)) {
      throw new IndexOutOfBoundsException();
    }
    return a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public final void reset()
  {
    try
    {
      a();
      a(null, 0, this.g);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final long skip(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IndexOutOfBoundsException();
    }
    long l = paramLong;
    if (paramLong > 2147483647L) {
      l = 2147483647L;
    }
    return a(null, 0, (int)l);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/b/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */