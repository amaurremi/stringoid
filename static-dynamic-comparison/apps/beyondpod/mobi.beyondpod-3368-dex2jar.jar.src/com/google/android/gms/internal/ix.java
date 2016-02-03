package com.google.android.gms.internal;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class ix
{
  private final int Hw;
  private final byte[] buffer;
  private int position;
  
  private ix(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.position = paramInt1;
    this.Hw = (paramInt1 + paramInt2);
  }
  
  public static int aD(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int i = bR(paramString.length);
      int j = paramString.length;
      return j + i;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported.");
    }
  }
  
  public static ix b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new ix(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int bN(int paramInt)
  {
    if (paramInt >= 0) {
      return bR(paramInt);
    }
    return 10;
  }
  
  public static int bP(int paramInt)
  {
    return bR(jb.g(paramInt, 0));
  }
  
  public static int bR(int paramInt)
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
  
  public static int d(int paramInt, long paramLong)
  {
    return bP(paramInt) + q(paramLong);
  }
  
  public static int e(int paramInt1, int paramInt2)
  {
    return bP(paramInt1) + bN(paramInt2);
  }
  
  public static int e(int paramInt, String paramString)
  {
    return bP(paramInt) + aD(paramString);
  }
  
  public static ix i(byte[] paramArrayOfByte)
  {
    return b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int q(long paramLong)
  {
    return s(t(paramLong));
  }
  
  public static int s(long paramLong)
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
  
  public static long t(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  public void aC(String paramString)
    throws IOException
  {
    paramString = paramString.getBytes("UTF-8");
    bQ(paramString.length);
    j(paramString);
  }
  
  public void b(byte paramByte)
    throws IOException
  {
    if (this.position == this.Hw) {
      throw new a(this.position, this.Hw);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte[i] = paramByte;
  }
  
  public void b(int paramInt, long paramLong)
    throws IOException
  {
    f(paramInt, 0);
    o(paramLong);
  }
  
  public void b(int paramInt, String paramString)
    throws IOException
  {
    f(paramInt, 2);
    aC(paramString);
  }
  
  public void bM(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      bQ(paramInt);
      return;
    }
    r(paramInt);
  }
  
  public void bO(int paramInt)
    throws IOException
  {
    b((byte)paramInt);
  }
  
  public void bQ(int paramInt)
    throws IOException
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        bO(paramInt);
        return;
      }
      bO(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public void c(int paramInt, long paramLong)
    throws IOException
  {
    f(paramInt, 0);
    p(paramLong);
  }
  
  public void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.Hw - this.position >= paramInt2)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.position, paramInt2);
      this.position += paramInt2;
      return;
    }
    throw new a(this.position, this.Hw);
  }
  
  public void d(int paramInt1, int paramInt2)
    throws IOException
  {
    f(paramInt1, 0);
    bM(paramInt2);
  }
  
  public void f(int paramInt1, int paramInt2)
    throws IOException
  {
    bQ(jb.g(paramInt1, paramInt2));
  }
  
  public int ge()
  {
    return this.Hw - this.position;
  }
  
  public void gf()
  {
    if (ge() != 0) {
      throw new IllegalStateException("Did not write as much data as expected.");
    }
  }
  
  public void j(byte[] paramArrayOfByte)
    throws IOException
  {
    c(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void o(long paramLong)
    throws IOException
  {
    r(paramLong);
  }
  
  public void p(long paramLong)
    throws IOException
  {
    r(t(paramLong));
  }
  
  public void r(long paramLong)
    throws IOException
  {
    for (;;)
    {
      if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L)
      {
        bO((int)paramLong);
        return;
      }
      bO((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/ix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */