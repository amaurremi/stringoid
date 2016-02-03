package com.appbrain.b;

import java.io.InputStream;
import java.io.OutputStream;

public final class h
{
  private final byte[] a;
  private final int b;
  private int c;
  private final OutputStream d;
  
  private h(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    this.d = paramOutputStream;
    this.a = paramArrayOfByte;
    this.c = 0;
    this.b = paramArrayOfByte.length;
  }
  
  private h(byte[] paramArrayOfByte, int paramInt)
  {
    this.d = null;
    this.a = paramArrayOfByte;
    this.c = 0;
    this.b = (paramInt + 0);
  }
  
  public static int a(int paramInt)
  {
    return g(paramInt) + 1;
  }
  
  public static int a(d paramd)
  {
    return h(paramd.b()) + paramd.b();
  }
  
  public static h a(OutputStream paramOutputStream)
  {
    return new h(paramOutputStream, new byte['က']);
  }
  
  public static h a(byte[] paramArrayOfByte)
  {
    return new h(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  private void a(long paramLong)
  {
    for (;;)
    {
      if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L)
      {
        f((int)paramLong);
        return;
      }
      f((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  public static int b(int paramInt)
  {
    if (paramInt >= 0) {
      return h(paramInt);
    }
    return 10;
  }
  
  public static int b(int paramInt, long paramLong)
  {
    int i = g(paramInt);
    if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L) {
      paramInt = 1;
    }
    for (;;)
    {
      return paramInt + i;
      if ((0xFFFFFFFFFFFFC000 & paramLong) == 0L) {
        paramInt = 2;
      } else if ((0xFFFFFFFFFFE00000 & paramLong) == 0L) {
        paramInt = 3;
      } else if ((0xFFFFFFFFF0000000 & paramLong) == 0L) {
        paramInt = 4;
      } else if ((0xFFFFFFF800000000 & paramLong) == 0L) {
        paramInt = 5;
      } else if ((0xFFFFFC0000000000 & paramLong) == 0L) {
        paramInt = 6;
      } else if ((0xFFFE000000000000 & paramLong) == 0L) {
        paramInt = 7;
      } else if ((0xFF00000000000000 & paramLong) == 0L) {
        paramInt = 8;
      } else if ((0x8000000000000000 & paramLong) == 0L) {
        paramInt = 9;
      } else {
        paramInt = 10;
      }
    }
  }
  
  public static int b(int paramInt, d paramd)
  {
    return g(paramInt) + a(paramd);
  }
  
  public static int b(int paramInt, t paramt)
  {
    paramInt = g(paramInt);
    int i = paramt.c();
    return paramInt + (i + h(i));
  }
  
  public static int c(int paramInt1, int paramInt2)
  {
    return g(paramInt1) + b(paramInt2);
  }
  
  private void c()
  {
    if (this.d == null) {
      throw new i();
    }
    this.d.write(this.a, 0, this.c);
    this.c = 0;
  }
  
  public static int d(int paramInt1, int paramInt2)
  {
    return g(paramInt1) + b(paramInt2);
  }
  
  private void e(int paramInt)
  {
    if (paramInt >= 0)
    {
      c(paramInt);
      return;
    }
    a(paramInt);
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    c(ag.a(paramInt1, paramInt2));
  }
  
  private void f(int paramInt)
  {
    int i = (byte)paramInt;
    if (this.c == this.b) {
      c();
    }
    byte[] arrayOfByte = this.a;
    paramInt = this.c;
    this.c = (paramInt + 1);
    arrayOfByte[paramInt] = i;
  }
  
  private static int g(int paramInt)
  {
    return h(ag.a(paramInt, 0));
  }
  
  private static int h(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((0xF0000000 & paramInt) == 0) {
      return 4;
    }
    return 5;
  }
  
  public final void a()
  {
    if (this.d != null) {
      c();
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    e(paramInt1, 0);
    e(paramInt2);
  }
  
  public final void a(int paramInt, long paramLong)
  {
    e(paramInt, 0);
    a(paramLong);
  }
  
  public final void a(int paramInt, d paramd)
  {
    e(paramInt, 2);
    c(paramd.b());
    paramInt = paramd.b();
    if (this.b - this.c >= paramInt)
    {
      paramd.a(this.a, 0, this.c, paramInt);
      this.c = (paramInt + this.c);
      return;
    }
    int j = this.b - this.c;
    paramd.a(this.a, 0, this.c, j);
    int i = j + 0;
    paramInt -= j;
    this.c = this.b;
    c();
    if (paramInt <= this.b)
    {
      paramd.a(this.a, i, 0, paramInt);
      this.c = paramInt;
      return;
    }
    paramd = paramd.g();
    if (i != paramd.skip(i)) {
      throw new IllegalStateException("Skip failed? Should never happen.");
    }
    do
    {
      this.d.write(this.a, 0, j);
      paramInt -= j;
      if (paramInt <= 0) {
        break;
      }
      i = Math.min(paramInt, this.b);
      j = paramd.read(this.a, 0, i);
    } while (j == i);
    throw new IllegalStateException("Read failed? Should never happen");
  }
  
  public final void a(int paramInt, t paramt)
  {
    e(paramInt, 2);
    c(paramt.c());
    paramt.a(this);
  }
  
  public final void a(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    e(paramInt, 0);
    paramInt = i;
    if (paramBoolean) {
      paramInt = 1;
    }
    f(paramInt);
  }
  
  public final void b()
  {
    if (this.d == null)
    {
      if (this.b - this.c != 0) {
        throw new IllegalStateException("Did not write as much data as expected.");
      }
    }
    else {
      throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    e(paramInt1, 0);
    e(paramInt2);
  }
  
  public final void c(int paramInt)
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        f(paramInt);
        return;
      }
      f(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public final void d(int paramInt)
  {
    f(paramInt & 0xFF);
    f(paramInt >> 8 & 0xFF);
    f(paramInt >> 16 & 0xFF);
    f(paramInt >> 24 & 0xFF);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */