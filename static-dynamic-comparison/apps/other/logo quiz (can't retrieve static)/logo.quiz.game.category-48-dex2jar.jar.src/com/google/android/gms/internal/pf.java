package com.google.android.gms.internal;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class pf
{
  private final int awx;
  private final byte[] buffer;
  private int position;
  
  private pf(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.position = paramInt1;
    this.awx = (paramInt1 + paramInt2);
  }
  
  public static int D(long paramLong)
  {
    return G(paramLong);
  }
  
  public static int E(long paramLong)
  {
    return G(I(paramLong));
  }
  
  public static int G(long paramLong)
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
  
  public static long I(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  public static int V(boolean paramBoolean)
  {
    return 1;
  }
  
  public static int b(int paramInt, double paramDouble)
  {
    return gy(paramInt) + f(paramDouble);
  }
  
  public static int b(int paramInt, pm parampm)
  {
    return gy(paramInt) * 2 + d(parampm);
  }
  
  public static int b(int paramInt, byte[] paramArrayOfByte)
  {
    return gy(paramInt) + s(paramArrayOfByte);
  }
  
  public static pf b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new pf(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int c(int paramInt, float paramFloat)
  {
    return gy(paramInt) + e(paramFloat);
  }
  
  public static int c(int paramInt, pm parampm)
  {
    return gy(paramInt) + e(parampm);
  }
  
  public static int c(int paramInt, boolean paramBoolean)
  {
    return gy(paramInt) + V(paramBoolean);
  }
  
  public static int d(int paramInt, long paramLong)
  {
    return gy(paramInt) + D(paramLong);
  }
  
  public static int d(pm parampm)
  {
    return parampm.qG();
  }
  
  public static int df(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int i = gA(paramString.length);
      int j = paramString.length;
      return j + i;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported.");
    }
  }
  
  public static int e(float paramFloat)
  {
    return 4;
  }
  
  public static int e(int paramInt, long paramLong)
  {
    return gy(paramInt) + E(paramLong);
  }
  
  public static int e(pm parampm)
  {
    int i = parampm.qG();
    return i + gA(i);
  }
  
  public static int f(double paramDouble)
  {
    return 8;
  }
  
  public static int gA(int paramInt)
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
  
  public static int gC(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  public static int gv(int paramInt)
  {
    if (paramInt >= 0) {
      return gA(paramInt);
    }
    return 10;
  }
  
  public static int gw(int paramInt)
  {
    return gA(gC(paramInt));
  }
  
  public static int gy(int paramInt)
  {
    return gA(pp.x(paramInt, 0));
  }
  
  public static int j(int paramInt, String paramString)
  {
    return gy(paramInt) + df(paramString);
  }
  
  public static pf q(byte[] paramArrayOfByte)
  {
    return b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int s(byte[] paramArrayOfByte)
  {
    return gA(paramArrayOfByte.length) + paramArrayOfByte.length;
  }
  
  public static int u(int paramInt1, int paramInt2)
  {
    return gy(paramInt1) + gv(paramInt2);
  }
  
  public static int v(int paramInt1, int paramInt2)
  {
    return gy(paramInt1) + gw(paramInt2);
  }
  
  public void B(long paramLong)
    throws IOException
  {
    F(paramLong);
  }
  
  public void C(long paramLong)
    throws IOException
  {
    F(I(paramLong));
  }
  
  public void F(long paramLong)
    throws IOException
  {
    for (;;)
    {
      if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L)
      {
        gx((int)paramLong);
        return;
      }
      gx((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  public void H(long paramLong)
    throws IOException
  {
    gx((int)paramLong & 0xFF);
    gx((int)(paramLong >> 8) & 0xFF);
    gx((int)(paramLong >> 16) & 0xFF);
    gx((int)(paramLong >> 24) & 0xFF);
    gx((int)(paramLong >> 32) & 0xFF);
    gx((int)(paramLong >> 40) & 0xFF);
    gx((int)(paramLong >> 48) & 0xFF);
    gx((int)(paramLong >> 56) & 0xFF);
  }
  
  public void U(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      gx(i);
      return;
    }
  }
  
  public void a(int paramInt, double paramDouble)
    throws IOException
  {
    w(paramInt, 1);
    e(paramDouble);
  }
  
  public void a(int paramInt, pm parampm)
    throws IOException
  {
    w(paramInt, 2);
    c(parampm);
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    w(paramInt, 2);
    r(paramArrayOfByte);
  }
  
  public void b(byte paramByte)
    throws IOException
  {
    if (this.position == this.awx) {
      throw new a(this.position, this.awx);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte[i] = paramByte;
  }
  
  public void b(int paramInt, float paramFloat)
    throws IOException
  {
    w(paramInt, 5);
    d(paramFloat);
  }
  
  public void b(int paramInt, long paramLong)
    throws IOException
  {
    w(paramInt, 0);
    B(paramLong);
  }
  
  public void b(int paramInt, String paramString)
    throws IOException
  {
    w(paramInt, 2);
    de(paramString);
  }
  
  public void b(int paramInt, boolean paramBoolean)
    throws IOException
  {
    w(paramInt, 0);
    U(paramBoolean);
  }
  
  public void b(pm parampm)
    throws IOException
  {
    parampm.a(this);
  }
  
  public void c(int paramInt, long paramLong)
    throws IOException
  {
    w(paramInt, 0);
    C(paramLong);
  }
  
  public void c(pm parampm)
    throws IOException
  {
    gz(parampm.qF());
    parampm.a(this);
  }
  
  public void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.awx - this.position >= paramInt2)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.position, paramInt2);
      this.position += paramInt2;
      return;
    }
    throw new a(this.position, this.awx);
  }
  
  public void d(float paramFloat)
    throws IOException
  {
    gB(Float.floatToIntBits(paramFloat));
  }
  
  public void de(String paramString)
    throws IOException
  {
    paramString = paramString.getBytes("UTF-8");
    gz(paramString.length);
    t(paramString);
  }
  
  public void e(double paramDouble)
    throws IOException
  {
    H(Double.doubleToLongBits(paramDouble));
  }
  
  public void gB(int paramInt)
    throws IOException
  {
    gx(paramInt & 0xFF);
    gx(paramInt >> 8 & 0xFF);
    gx(paramInt >> 16 & 0xFF);
    gx(paramInt >> 24 & 0xFF);
  }
  
  public void gt(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      gz(paramInt);
      return;
    }
    F(paramInt);
  }
  
  public void gu(int paramInt)
    throws IOException
  {
    gz(gC(paramInt));
  }
  
  public void gx(int paramInt)
    throws IOException
  {
    b((byte)paramInt);
  }
  
  public void gz(int paramInt)
    throws IOException
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        gx(paramInt);
        return;
      }
      gx(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public int qv()
  {
    return this.awx - this.position;
  }
  
  public void qw()
  {
    if (qv() != 0) {
      throw new IllegalStateException("Did not write as much data as expected.");
    }
  }
  
  public void r(byte[] paramArrayOfByte)
    throws IOException
  {
    gz(paramArrayOfByte.length);
    t(paramArrayOfByte);
  }
  
  public void s(int paramInt1, int paramInt2)
    throws IOException
  {
    w(paramInt1, 0);
    gt(paramInt2);
  }
  
  public void t(int paramInt1, int paramInt2)
    throws IOException
  {
    w(paramInt1, 0);
    gu(paramInt2);
  }
  
  public void t(byte[] paramArrayOfByte)
    throws IOException
  {
    c(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void w(int paramInt1, int paramInt2)
    throws IOException
  {
    gz(pp.x(paramInt1, paramInt2));
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/pf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */