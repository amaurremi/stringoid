package com.google.android.gms.internal;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class jz
{
  private final int SV;
  private final byte[] buffer;
  private int position;
  
  private jz(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.position = paramInt1;
    this.SV = (paramInt1 + paramInt2);
  }
  
  public static int L(boolean paramBoolean)
  {
    return 1;
  }
  
  public static int b(int paramInt, gj paramgj)
  {
    return dC(paramInt) + b(paramgj);
  }
  
  public static int b(gj paramgj)
  {
    int i = paramgj.nq();
    return i + dE(i);
  }
  
  public static jz b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new jz(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int bc(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int i = dE(paramString.length);
      int j = paramString.length;
      return j + i;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported.");
    }
  }
  
  public static int c(int paramInt, String paramString)
  {
    return dC(paramInt) + bc(paramString);
  }
  
  public static int c(int paramInt, boolean paramBoolean)
  {
    return dC(paramInt) + L(paramBoolean);
  }
  
  public static int d(int paramInt, long paramLong)
  {
    return dC(paramInt) + o(paramLong);
  }
  
  public static int dA(int paramInt)
  {
    if (paramInt >= 0) {
      return dE(paramInt);
    }
    return 10;
  }
  
  public static int dC(int paramInt)
  {
    return dE(gm.u(paramInt, 0));
  }
  
  public static int dE(int paramInt)
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
  
  public static int e(int paramInt, long paramLong)
  {
    return dC(paramInt) + p(paramLong);
  }
  
  public static jz e(byte[] paramArrayOfByte)
  {
    return b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int o(long paramLong)
  {
    return r(paramLong);
  }
  
  public static int p(long paramLong)
  {
    return r(s(paramLong));
  }
  
  public static int r(long paramLong)
  {
    if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if ((0xFFFFFFFFFFFFC000 & paramLong) == 0L) {
      return 2;
    }
    if ((0xFFFFFFFFFFE00000 & paramLong) == 0L) {
      return 3;
    }
    if ((0xFFFFFFFFF0000000 & paramLong) == 0L) {
      return 4;
    }
    if ((0xFFFFFFF800000000 & paramLong) == 0L) {
      return 5;
    }
    if ((0xFFFFFC0000000000 & paramLong) == 0L) {
      return 6;
    }
    if ((0xFFFE000000000000 & paramLong) == 0L) {
      return 7;
    }
    if ((0xFF00000000000000 & paramLong) == 0L) {
      return 8;
    }
    if ((0x8000000000000000 & paramLong) == 0L) {
      return 9;
    }
    return 10;
  }
  
  public static int s(int paramInt1, int paramInt2)
  {
    return dC(paramInt1) + dA(paramInt2);
  }
  
  public static long s(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  public void K(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      dB(i);
      return;
    }
  }
  
  public void a(int paramInt, gj paramgj)
  {
    t(paramInt, 2);
    a(paramgj);
  }
  
  public void a(gj paramgj)
  {
    dD(paramgj.np());
    paramgj.a(this);
  }
  
  public void b(int paramInt, long paramLong)
  {
    t(paramInt, 0);
    m(paramLong);
  }
  
  public void b(int paramInt, String paramString)
  {
    t(paramInt, 2);
    bb(paramString);
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    t(paramInt, 0);
    K(paramBoolean);
  }
  
  public void bb(String paramString)
  {
    paramString = paramString.getBytes("UTF-8");
    dD(paramString.length);
    f(paramString);
  }
  
  public void c(int paramInt, long paramLong)
  {
    t(paramInt, 0);
    n(paramLong);
  }
  
  public void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.SV - this.position >= paramInt2)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.position, paramInt2);
      this.position += paramInt2;
      return;
    }
    throw new a(this.position, this.SV);
  }
  
  public void dB(int paramInt)
  {
    e((byte)paramInt);
  }
  
  public void dD(int paramInt)
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        dB(paramInt);
        return;
      }
      dB(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public void dz(int paramInt)
  {
    if (paramInt >= 0)
    {
      dD(paramInt);
      return;
    }
    q(paramInt);
  }
  
  public void e(byte paramByte)
  {
    if (this.position == this.SV) {
      throw new a(this.position, this.SV);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte[i] = paramByte;
  }
  
  public void f(byte[] paramArrayOfByte)
  {
    c(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void m(long paramLong)
  {
    q(paramLong);
  }
  
  public void n(long paramLong)
  {
    q(s(paramLong));
  }
  
  public void q(long paramLong)
  {
    for (;;)
    {
      if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L)
      {
        dB((int)paramLong);
        return;
      }
      dB((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  public void r(int paramInt1, int paramInt2)
  {
    t(paramInt1, 0);
    dz(paramInt2);
  }
  
  public void t(int paramInt1, int paramInt2)
  {
    dD(gm.u(paramInt1, paramInt2));
  }
  
  public int ty()
  {
    return this.SV - this.position;
  }
  
  public void tz()
  {
    if (ty() != 0) {
      throw new IllegalStateException("Did not write as much data as expected.");
    }
  }
  
  public static class a
    extends IOException
  {
    a(int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/jz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */