package com.google.android.gms.internal;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class ko
{
  private final int adT;
  private final byte[] buffer;
  private int position;
  
  private ko(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.position = paramInt1;
    this.adT = (paramInt1 + paramInt2);
  }
  
  public static int A(long paramLong)
  {
    return D(paramLong);
  }
  
  public static int B(long paramLong)
  {
    return D(E(paramLong));
  }
  
  public static int D(long paramLong)
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
  
  public static int E(boolean paramBoolean)
  {
    return 1;
  }
  
  public static long E(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  public static int b(int paramInt, kt paramkt)
  {
    return cZ(paramInt) + c(paramkt);
  }
  
  public static int b(int paramInt, boolean paramBoolean)
  {
    return cZ(paramInt) + E(paramBoolean);
  }
  
  public static ko b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new ko(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int c(int paramInt, float paramFloat)
  {
    return cZ(paramInt) + e(paramFloat);
  }
  
  public static int c(kt paramkt)
  {
    int i = paramkt.c();
    return i + db(i);
  }
  
  public static int cX(int paramInt)
  {
    if (paramInt >= 0) {
      return db(paramInt);
    }
    return 10;
  }
  
  public static int cZ(int paramInt)
  {
    return db(kw.l(paramInt, 0));
  }
  
  public static int cf(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int i = db(paramString.length);
      int j = paramString.length;
      return j + i;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported.");
    }
  }
  
  public static int d(int paramInt, long paramLong)
  {
    return cZ(paramInt) + A(paramLong);
  }
  
  public static int db(int paramInt)
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
  
  public static int e(float paramFloat)
  {
    return 4;
  }
  
  public static int e(int paramInt, long paramLong)
  {
    return cZ(paramInt) + B(paramLong);
  }
  
  public static int g(int paramInt, String paramString)
  {
    return cZ(paramInt) + cf(paramString);
  }
  
  public static int j(int paramInt1, int paramInt2)
  {
    return cZ(paramInt1) + cX(paramInt2);
  }
  
  public static ko o(byte[] paramArrayOfByte)
  {
    return b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void C(long paramLong)
    throws IOException
  {
    for (;;)
    {
      if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L)
      {
        cY((int)paramLong);
        return;
      }
      cY((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  public void D(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      cY(i);
      return;
    }
  }
  
  public void a(int paramInt, kt paramkt)
    throws IOException
  {
    k(paramInt, 2);
    b(paramkt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
    throws IOException
  {
    k(paramInt, 0);
    D(paramBoolean);
  }
  
  public void b(byte paramByte)
    throws IOException
  {
    if (this.position == this.adT) {
      throw new a(this.position, this.adT);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte[i] = paramByte;
  }
  
  public void b(int paramInt, float paramFloat)
    throws IOException
  {
    k(paramInt, 5);
    d(paramFloat);
  }
  
  public void b(int paramInt, long paramLong)
    throws IOException
  {
    k(paramInt, 0);
    y(paramLong);
  }
  
  public void b(int paramInt, String paramString)
    throws IOException
  {
    k(paramInt, 2);
    ce(paramString);
  }
  
  public void b(kt paramkt)
    throws IOException
  {
    da(paramkt.mF());
    paramkt.a(this);
  }
  
  public void c(int paramInt, long paramLong)
    throws IOException
  {
    k(paramInt, 0);
    z(paramLong);
  }
  
  public void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.adT - this.position >= paramInt2)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.position, paramInt2);
      this.position += paramInt2;
      return;
    }
    throw new a(this.position, this.adT);
  }
  
  public void cW(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      da(paramInt);
      return;
    }
    C(paramInt);
  }
  
  public void cY(int paramInt)
    throws IOException
  {
    b((byte)paramInt);
  }
  
  public void ce(String paramString)
    throws IOException
  {
    paramString = paramString.getBytes("UTF-8");
    da(paramString.length);
    p(paramString);
  }
  
  public void d(float paramFloat)
    throws IOException
  {
    dc(Float.floatToIntBits(paramFloat));
  }
  
  public void da(int paramInt)
    throws IOException
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        cY(paramInt);
        return;
      }
      cY(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public void dc(int paramInt)
    throws IOException
  {
    cY(paramInt & 0xFF);
    cY(paramInt >> 8 & 0xFF);
    cY(paramInt >> 16 & 0xFF);
    cY(paramInt >> 24 & 0xFF);
  }
  
  public void i(int paramInt1, int paramInt2)
    throws IOException
  {
    k(paramInt1, 0);
    cW(paramInt2);
  }
  
  public void k(int paramInt1, int paramInt2)
    throws IOException
  {
    da(kw.l(paramInt1, paramInt2));
  }
  
  public int mv()
  {
    return this.adT - this.position;
  }
  
  public void mw()
  {
    if (mv() != 0) {
      throw new IllegalStateException("Did not write as much data as expected.");
    }
  }
  
  public void p(byte[] paramArrayOfByte)
    throws IOException
  {
    c(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void y(long paramLong)
    throws IOException
  {
    C(paramLong);
  }
  
  public void z(long paramLong)
    throws IOException
  {
    C(E(paramLong));
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/ko.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */