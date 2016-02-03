package com.google.android.gms.internal;

import java.io.IOException;

public final class iw
{
  private int Hp;
  private int Hq;
  private int Hr;
  private int Hs;
  private int Ht = Integer.MAX_VALUE;
  private int Hu = 64;
  private int Hv = 67108864;
  private final byte[] buffer;
  
  private iw(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.Hp = paramInt1;
    this.Hq = (paramInt1 + paramInt2);
    this.Hr = paramInt1;
  }
  
  public static iw a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new iw(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static long n(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }
  
  public void bI(int paramInt)
    throws iy
  {
    if (this.Hs != paramInt) {
      throw iy.gk();
    }
  }
  
  public boolean bJ(int paramInt)
    throws IOException
  {
    switch (jb.bS(paramInt))
    {
    default: 
      throw iy.gl();
    case 0: 
      fW();
      return true;
    case 1: 
      gb();
      return true;
    case 2: 
      bL(fY());
      return true;
    case 3: 
      fV();
      bI(jb.g(jb.bT(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    ga();
    return true;
  }
  
  public byte[] bK(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw iy.gh();
    }
    if (this.Hr + paramInt > this.Ht)
    {
      bL(this.Ht - this.Hr);
      throw iy.gg();
    }
    if (paramInt <= this.Hq - this.Hr)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(this.buffer, this.Hr, arrayOfByte, 0, paramInt);
      this.Hr += paramInt;
      return arrayOfByte;
    }
    throw iy.gg();
  }
  
  public void bL(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw iy.gh();
    }
    if (this.Hr + paramInt > this.Ht)
    {
      bL(this.Ht - this.Hr);
      throw iy.gg();
    }
    if (paramInt <= this.Hq - this.Hr)
    {
      this.Hr += paramInt;
      return;
    }
    throw iy.gg();
  }
  
  public int fU()
    throws IOException
  {
    if (gc())
    {
      this.Hs = 0;
      return 0;
    }
    this.Hs = fY();
    if (this.Hs == 0) {
      throw iy.gj();
    }
    return this.Hs;
  }
  
  public void fV()
    throws IOException
  {
    int i;
    do
    {
      i = fU();
    } while ((i != 0) && (bJ(i)));
  }
  
  public int fW()
    throws IOException
  {
    return fY();
  }
  
  public long fX()
    throws IOException
  {
    return n(fZ());
  }
  
  public int fY()
    throws IOException
  {
    int i = gd();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = gd();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = gd();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = gd();
      if (k >= 0) {
        return i | k << 21;
      }
      j = gd();
      k = i | (k & 0x7F) << 21 | j << 28;
      i = k;
    } while (j >= 0);
    int j = 0;
    for (;;)
    {
      if (j >= 5) {
        break label133;
      }
      i = k;
      if (gd() >= 0) {
        break;
      }
      j += 1;
    }
    label133:
    throw iy.gi();
  }
  
  public long fZ()
    throws IOException
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = gd();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw iy.gi();
  }
  
  public int ga()
    throws IOException
  {
    return gd() & 0xFF | (gd() & 0xFF) << 8 | (gd() & 0xFF) << 16 | (gd() & 0xFF) << 24;
  }
  
  public long gb()
    throws IOException
  {
    int i = gd();
    int j = gd();
    int k = gd();
    int m = gd();
    int n = gd();
    int i1 = gd();
    int i2 = gd();
    int i3 = gd();
    long l = i;
    return (j & 0xFF) << 8 | l & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24 | (n & 0xFF) << 32 | (i1 & 0xFF) << 40 | (i2 & 0xFF) << 48 | (i3 & 0xFF) << 56;
  }
  
  public boolean gc()
  {
    return this.Hr == this.Hq;
  }
  
  public byte gd()
    throws IOException
  {
    if (this.Hr == this.Hq) {
      throw iy.gg();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.Hr;
    this.Hr = (i + 1);
    return arrayOfByte[i];
  }
  
  public String readString()
    throws IOException
  {
    int i = fY();
    if ((i <= this.Hq - this.Hr) && (i > 0))
    {
      String str = new String(this.buffer, this.Hr, i, "UTF-8");
      this.Hr = (i + this.Hr);
      return str;
    }
    return new String(bK(i), "UTF-8");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/iw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */