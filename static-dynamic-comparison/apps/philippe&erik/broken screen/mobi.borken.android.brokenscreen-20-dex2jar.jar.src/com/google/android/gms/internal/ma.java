package com.google.android.gms.internal;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class ma
{
  private final int amT;
  private final byte[] buffer;
  private int position;
  
  private ma(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.position = paramInt1;
    this.amT = (paramInt1 + paramInt2);
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
  
  public static int J(boolean paramBoolean)
  {
    return 1;
  }
  
  public static int b(int paramInt, double paramDouble)
  {
    return eH(paramInt) + f(paramDouble);
  }
  
  public static int b(int paramInt, mf parammf)
  {
    return eH(paramInt) + c(parammf);
  }
  
  public static int b(int paramInt, boolean paramBoolean)
  {
    return eH(paramInt) + J(paramBoolean);
  }
  
  public static int b(int paramInt, byte[] paramArrayOfByte)
  {
    return eH(paramInt) + s(paramArrayOfByte);
  }
  
  public static ma b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new ma(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int c(int paramInt, float paramFloat)
  {
    return eH(paramInt) + e(paramFloat);
  }
  
  public static int c(mf parammf)
  {
    int i = parammf.nV();
    return i + eJ(i);
  }
  
  public static int cz(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int i = eJ(paramString.length);
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
    return eH(paramInt) + D(paramLong);
  }
  
  public static int e(float paramFloat)
  {
    return 4;
  }
  
  public static int e(int paramInt, long paramLong)
  {
    return eH(paramInt) + E(paramLong);
  }
  
  public static int eE(int paramInt)
  {
    if (paramInt >= 0) {
      return eJ(paramInt);
    }
    return 10;
  }
  
  public static int eF(int paramInt)
  {
    return eJ(eL(paramInt));
  }
  
  public static int eH(int paramInt)
  {
    return eJ(mi.u(paramInt, 0));
  }
  
  public static int eJ(int paramInt)
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
  
  public static int eL(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  public static int f(double paramDouble)
  {
    return 8;
  }
  
  public static int h(int paramInt, String paramString)
  {
    return eH(paramInt) + cz(paramString);
  }
  
  public static ma q(byte[] paramArrayOfByte)
  {
    return b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int r(int paramInt1, int paramInt2)
  {
    return eH(paramInt1) + eE(paramInt2);
  }
  
  public static int s(int paramInt1, int paramInt2)
  {
    return eH(paramInt1) + eF(paramInt2);
  }
  
  public static int s(byte[] paramArrayOfByte)
  {
    return eJ(paramArrayOfByte.length) + paramArrayOfByte.length;
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
        eG((int)paramLong);
        return;
      }
      eG((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  public void H(long paramLong)
    throws IOException
  {
    eG((int)paramLong & 0xFF);
    eG((int)(paramLong >> 8) & 0xFF);
    eG((int)(paramLong >> 16) & 0xFF);
    eG((int)(paramLong >> 24) & 0xFF);
    eG((int)(paramLong >> 32) & 0xFF);
    eG((int)(paramLong >> 40) & 0xFF);
    eG((int)(paramLong >> 48) & 0xFF);
    eG((int)(paramLong >> 56) & 0xFF);
  }
  
  public void I(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      eG(i);
      return;
    }
  }
  
  public void a(int paramInt, double paramDouble)
    throws IOException
  {
    t(paramInt, 1);
    e(paramDouble);
  }
  
  public void a(int paramInt, mf parammf)
    throws IOException
  {
    t(paramInt, 2);
    b(parammf);
  }
  
  public void a(int paramInt, boolean paramBoolean)
    throws IOException
  {
    t(paramInt, 0);
    I(paramBoolean);
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    t(paramInt, 2);
    r(paramArrayOfByte);
  }
  
  public void b(byte paramByte)
    throws IOException
  {
    if (this.position == this.amT) {
      throw new a(this.position, this.amT);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte[i] = paramByte;
  }
  
  public void b(int paramInt, float paramFloat)
    throws IOException
  {
    t(paramInt, 5);
    d(paramFloat);
  }
  
  public void b(int paramInt, long paramLong)
    throws IOException
  {
    t(paramInt, 0);
    B(paramLong);
  }
  
  public void b(int paramInt, String paramString)
    throws IOException
  {
    t(paramInt, 2);
    cy(paramString);
  }
  
  public void b(mf parammf)
    throws IOException
  {
    eI(parammf.nU());
    parammf.a(this);
  }
  
  public void c(int paramInt, long paramLong)
    throws IOException
  {
    t(paramInt, 0);
    C(paramLong);
  }
  
  public void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.amT - this.position >= paramInt2)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.position, paramInt2);
      this.position += paramInt2;
      return;
    }
    throw new a(this.position, this.amT);
  }
  
  public void cy(String paramString)
    throws IOException
  {
    paramString = paramString.getBytes("UTF-8");
    eI(paramString.length);
    t(paramString);
  }
  
  public void d(float paramFloat)
    throws IOException
  {
    eK(Float.floatToIntBits(paramFloat));
  }
  
  public void e(double paramDouble)
    throws IOException
  {
    H(Double.doubleToLongBits(paramDouble));
  }
  
  public void eC(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      eI(paramInt);
      return;
    }
    F(paramInt);
  }
  
  public void eD(int paramInt)
    throws IOException
  {
    eI(eL(paramInt));
  }
  
  public void eG(int paramInt)
    throws IOException
  {
    b((byte)paramInt);
  }
  
  public void eI(int paramInt)
    throws IOException
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        eG(paramInt);
        return;
      }
      eG(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public void eK(int paramInt)
    throws IOException
  {
    eG(paramInt & 0xFF);
    eG(paramInt >> 8 & 0xFF);
    eG(paramInt >> 16 & 0xFF);
    eG(paramInt >> 24 & 0xFF);
  }
  
  public int nL()
  {
    return this.amT - this.position;
  }
  
  public void nM()
  {
    if (nL() != 0) {
      throw new IllegalStateException("Did not write as much data as expected.");
    }
  }
  
  public void p(int paramInt1, int paramInt2)
    throws IOException
  {
    t(paramInt1, 0);
    eC(paramInt2);
  }
  
  public void q(int paramInt1, int paramInt2)
    throws IOException
  {
    t(paramInt1, 0);
    eD(paramInt2);
  }
  
  public void r(byte[] paramArrayOfByte)
    throws IOException
  {
    eI(paramArrayOfByte.length);
    t(paramArrayOfByte);
  }
  
  public void t(int paramInt1, int paramInt2)
    throws IOException
  {
    eI(mi.u(paramInt1, paramInt2));
  }
  
  public void t(byte[] paramArrayOfByte)
    throws IOException
  {
    c(paramArrayOfByte, 0, paramArrayOfByte.length);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ma.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */