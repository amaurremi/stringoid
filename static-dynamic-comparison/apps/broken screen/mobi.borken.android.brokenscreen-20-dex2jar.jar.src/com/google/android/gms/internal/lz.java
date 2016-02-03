package com.google.android.gms.internal;

import java.io.IOException;

public final class lz
{
  private int amK;
  private int amL;
  private int amM;
  private int amN;
  private int amO;
  private int amP = Integer.MAX_VALUE;
  private int amQ;
  private int amR = 64;
  private int amS = 67108864;
  private final byte[] buffer;
  
  private lz(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.amK = paramInt1;
    this.amL = (paramInt1 + paramInt2);
    this.amN = paramInt1;
  }
  
  public static long A(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }
  
  public static lz a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new lz(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int ew(int paramInt)
  {
    return paramInt >>> 1 ^ -(paramInt & 0x1);
  }
  
  private void nH()
  {
    this.amL += this.amM;
    int i = this.amL;
    if (i > this.amP)
    {
      this.amM = (i - this.amP);
      this.amL -= this.amM;
      return;
    }
    this.amM = 0;
  }
  
  public static lz p(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void a(mf parammf)
    throws IOException
  {
    int i = nD();
    if (this.amQ >= this.amR) {
      throw me.nT();
    }
    i = ex(i);
    this.amQ += 1;
    parammf.b(this);
    eu(0);
    this.amQ -= 1;
    ey(i);
  }
  
  public void a(mf parammf, int paramInt)
    throws IOException
  {
    if (this.amQ >= this.amR) {
      throw me.nT();
    }
    this.amQ += 1;
    parammf.b(this);
    eu(mi.u(paramInt, 4));
    this.amQ -= 1;
  }
  
  public byte[] eA(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw me.nO();
    }
    if (this.amN + paramInt > this.amP)
    {
      eB(this.amP - this.amN);
      throw me.nN();
    }
    if (paramInt <= this.amL - this.amN)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(this.buffer, this.amN, arrayOfByte, 0, paramInt);
      this.amN += paramInt;
      return arrayOfByte;
    }
    throw me.nN();
  }
  
  public void eB(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw me.nO();
    }
    if (this.amN + paramInt > this.amP)
    {
      eB(this.amP - this.amN);
      throw me.nN();
    }
    if (paramInt <= this.amL - this.amN)
    {
      this.amN += paramInt;
      return;
    }
    throw me.nN();
  }
  
  public void eu(int paramInt)
    throws me
  {
    if (this.amO != paramInt) {
      throw me.nR();
    }
  }
  
  public boolean ev(int paramInt)
    throws IOException
  {
    switch (mi.eN(paramInt))
    {
    default: 
      throw me.nS();
    case 0: 
      nz();
      return true;
    case 1: 
      nG();
      return true;
    case 2: 
      eB(nD());
      return true;
    case 3: 
      nx();
      eu(mi.u(mi.eO(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    nF();
    return true;
  }
  
  public int ex(int paramInt)
    throws me
  {
    if (paramInt < 0) {
      throw me.nO();
    }
    paramInt = this.amN + paramInt;
    int i = this.amP;
    if (paramInt > i) {
      throw me.nN();
    }
    this.amP = paramInt;
    nH();
    return i;
  }
  
  public void ey(int paramInt)
  {
    this.amP = paramInt;
    nH();
  }
  
  public void ez(int paramInt)
  {
    if (paramInt > this.amN - this.amK) {
      throw new IllegalArgumentException("Position " + paramInt + " is beyond current " + (this.amN - this.amK));
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("Bad position " + paramInt);
    }
    this.amN = (this.amK + paramInt);
  }
  
  public int getPosition()
  {
    return this.amN - this.amK;
  }
  
  public boolean nA()
    throws IOException
  {
    return nD() != 0;
  }
  
  public int nB()
    throws IOException
  {
    return ew(nD());
  }
  
  public long nC()
    throws IOException
  {
    return A(nE());
  }
  
  public int nD()
    throws IOException
  {
    int i = nK();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = nK();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = nK();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = nK();
      if (k >= 0) {
        return i | k << 21;
      }
      j = nK();
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
      if (nK() >= 0) {
        break;
      }
      j += 1;
    }
    label133:
    throw me.nP();
  }
  
  public long nE()
    throws IOException
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = nK();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw me.nP();
  }
  
  public int nF()
    throws IOException
  {
    return nK() & 0xFF | (nK() & 0xFF) << 8 | (nK() & 0xFF) << 16 | (nK() & 0xFF) << 24;
  }
  
  public long nG()
    throws IOException
  {
    int i = nK();
    int j = nK();
    int k = nK();
    int m = nK();
    int n = nK();
    int i1 = nK();
    int i2 = nK();
    int i3 = nK();
    long l = i;
    return (j & 0xFF) << 8 | l & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24 | (n & 0xFF) << 32 | (i1 & 0xFF) << 40 | (i2 & 0xFF) << 48 | (i3 & 0xFF) << 56;
  }
  
  public int nI()
  {
    if (this.amP == Integer.MAX_VALUE) {
      return -1;
    }
    int i = this.amN;
    return this.amP - i;
  }
  
  public boolean nJ()
  {
    return this.amN == this.amL;
  }
  
  public byte nK()
    throws IOException
  {
    if (this.amN == this.amL) {
      throw me.nN();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.amN;
    this.amN = (i + 1);
    return arrayOfByte[i];
  }
  
  public int nw()
    throws IOException
  {
    if (nJ())
    {
      this.amO = 0;
      return 0;
    }
    this.amO = nD();
    if (this.amO == 0) {
      throw me.nQ();
    }
    return this.amO;
  }
  
  public void nx()
    throws IOException
  {
    int i;
    do
    {
      i = nw();
    } while ((i != 0) && (ev(i)));
  }
  
  public long ny()
    throws IOException
  {
    return nE();
  }
  
  public int nz()
    throws IOException
  {
    return nD();
  }
  
  public byte[] o(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return mi.anh;
    }
    byte[] arrayOfByte = new byte[paramInt2];
    int i = this.amK;
    System.arraycopy(this.buffer, i + paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public byte[] readBytes()
    throws IOException
  {
    int i = nD();
    if ((i <= this.amL - this.amN) && (i > 0))
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.buffer, this.amN, arrayOfByte, 0, i);
      this.amN = (i + this.amN);
      return arrayOfByte;
    }
    return eA(i);
  }
  
  public double readDouble()
    throws IOException
  {
    return Double.longBitsToDouble(nG());
  }
  
  public float readFloat()
    throws IOException
  {
    return Float.intBitsToFloat(nF());
  }
  
  public String readString()
    throws IOException
  {
    int i = nD();
    if ((i <= this.amL - this.amN) && (i > 0))
    {
      String str = new String(this.buffer, this.amN, i, "UTF-8");
      this.amN = (i + this.amN);
      return str;
    }
    return new String(eA(i), "UTF-8");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/lz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */