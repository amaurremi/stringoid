package com.google.android.gms.internal;

public final class ly
{
  private int amN;
  private int amO;
  private int amP;
  private int amQ;
  private int amR;
  private int amS = Integer.MAX_VALUE;
  private int amT;
  private int amU = 64;
  private int amV = 67108864;
  private final byte[] buffer;
  
  private ly(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.amN = paramInt1;
    this.amO = (paramInt1 + paramInt2);
    this.amQ = paramInt1;
  }
  
  public static long A(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }
  
  public static ly a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new ly(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int ew(int paramInt)
  {
    return paramInt >>> 1 ^ -(paramInt & 0x1);
  }
  
  private void nM()
  {
    this.amO += this.amP;
    int i = this.amO;
    if (i > this.amS)
    {
      this.amP = (i - this.amS);
      this.amO -= this.amP;
      return;
    }
    this.amP = 0;
  }
  
  public static ly p(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void a(me paramme)
  {
    int i = nI();
    if (this.amT >= this.amU) {
      throw md.nY();
    }
    i = ex(i);
    this.amT += 1;
    paramme.b(this);
    eu(0);
    this.amT -= 1;
    ey(i);
  }
  
  public void a(me paramme, int paramInt)
  {
    if (this.amT >= this.amU) {
      throw md.nY();
    }
    this.amT += 1;
    paramme.b(this);
    eu(mh.u(paramInt, 4));
    this.amT -= 1;
  }
  
  public byte[] eA(int paramInt)
  {
    if (paramInt < 0) {
      throw md.nT();
    }
    if (this.amQ + paramInt > this.amS)
    {
      eB(this.amS - this.amQ);
      throw md.nS();
    }
    if (paramInt <= this.amO - this.amQ)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(this.buffer, this.amQ, arrayOfByte, 0, paramInt);
      this.amQ += paramInt;
      return arrayOfByte;
    }
    throw md.nS();
  }
  
  public void eB(int paramInt)
  {
    if (paramInt < 0) {
      throw md.nT();
    }
    if (this.amQ + paramInt > this.amS)
    {
      eB(this.amS - this.amQ);
      throw md.nS();
    }
    if (paramInt <= this.amO - this.amQ)
    {
      this.amQ += paramInt;
      return;
    }
    throw md.nS();
  }
  
  public void eu(int paramInt)
  {
    if (this.amR != paramInt) {
      throw md.nW();
    }
  }
  
  public boolean ev(int paramInt)
  {
    switch (mh.eN(paramInt))
    {
    default: 
      throw md.nX();
    case 0: 
      nE();
      return true;
    case 1: 
      nL();
      return true;
    case 2: 
      eB(nI());
      return true;
    case 3: 
      nC();
      eu(mh.u(mh.eO(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    nK();
    return true;
  }
  
  public int ex(int paramInt)
  {
    if (paramInt < 0) {
      throw md.nT();
    }
    paramInt = this.amQ + paramInt;
    int i = this.amS;
    if (paramInt > i) {
      throw md.nS();
    }
    this.amS = paramInt;
    nM();
    return i;
  }
  
  public void ey(int paramInt)
  {
    this.amS = paramInt;
    nM();
  }
  
  public void ez(int paramInt)
  {
    if (paramInt > this.amQ - this.amN) {
      throw new IllegalArgumentException("Position " + paramInt + " is beyond current " + (this.amQ - this.amN));
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("Bad position " + paramInt);
    }
    this.amQ = (this.amN + paramInt);
  }
  
  public int getPosition()
  {
    return this.amQ - this.amN;
  }
  
  public int nB()
  {
    if (nO())
    {
      this.amR = 0;
      return 0;
    }
    this.amR = nI();
    if (this.amR == 0) {
      throw md.nV();
    }
    return this.amR;
  }
  
  public void nC()
  {
    int i;
    do
    {
      i = nB();
    } while ((i != 0) && (ev(i)));
  }
  
  public long nD()
  {
    return nJ();
  }
  
  public int nE()
  {
    return nI();
  }
  
  public boolean nF()
  {
    return nI() != 0;
  }
  
  public int nG()
  {
    return ew(nI());
  }
  
  public long nH()
  {
    return A(nJ());
  }
  
  public int nI()
  {
    int i = nP();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = nP();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = nP();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = nP();
      if (k >= 0) {
        return i | k << 21;
      }
      j = nP();
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
      if (nP() >= 0) {
        break;
      }
      j += 1;
    }
    label133:
    throw md.nU();
  }
  
  public long nJ()
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = nP();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw md.nU();
  }
  
  public int nK()
  {
    return nP() & 0xFF | (nP() & 0xFF) << 8 | (nP() & 0xFF) << 16 | (nP() & 0xFF) << 24;
  }
  
  public long nL()
  {
    int i = nP();
    int j = nP();
    int k = nP();
    int m = nP();
    int n = nP();
    int i1 = nP();
    int i2 = nP();
    int i3 = nP();
    long l = i;
    return (j & 0xFF) << 8 | l & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24 | (n & 0xFF) << 32 | (i1 & 0xFF) << 40 | (i2 & 0xFF) << 48 | (i3 & 0xFF) << 56;
  }
  
  public int nN()
  {
    if (this.amS == Integer.MAX_VALUE) {
      return -1;
    }
    int i = this.amQ;
    return this.amS - i;
  }
  
  public boolean nO()
  {
    return this.amQ == this.amO;
  }
  
  public byte nP()
  {
    if (this.amQ == this.amO) {
      throw md.nS();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.amQ;
    this.amQ = (i + 1);
    return arrayOfByte[i];
  }
  
  public byte[] o(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return mh.ank;
    }
    byte[] arrayOfByte = new byte[paramInt2];
    int i = this.amN;
    System.arraycopy(this.buffer, i + paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public byte[] readBytes()
  {
    int i = nI();
    if ((i <= this.amO - this.amQ) && (i > 0))
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.buffer, this.amQ, arrayOfByte, 0, i);
      this.amQ = (i + this.amQ);
      return arrayOfByte;
    }
    return eA(i);
  }
  
  public double readDouble()
  {
    return Double.longBitsToDouble(nL());
  }
  
  public float readFloat()
  {
    return Float.intBitsToFloat(nK());
  }
  
  public String readString()
  {
    int i = nI();
    if ((i <= this.amO - this.amQ) && (i > 0))
    {
      String str = new String(this.buffer, this.amQ, i, "UTF-8");
      this.amQ = (i + this.amQ);
      return str;
    }
    return new String(eA(i), "UTF-8");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */