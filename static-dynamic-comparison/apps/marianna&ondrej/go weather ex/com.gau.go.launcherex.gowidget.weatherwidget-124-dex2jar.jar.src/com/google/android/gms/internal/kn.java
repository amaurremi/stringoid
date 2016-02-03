package com.google.android.gms.internal;

import java.io.IOException;

public final class kn
{
  private int adK;
  private int adL;
  private int adM;
  private int adN;
  private int adO;
  private int adP = Integer.MAX_VALUE;
  private int adQ;
  private int adR = 64;
  private int adS = 67108864;
  private final byte[] buffer;
  
  private kn(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.adK = paramInt1;
    this.adL = (paramInt1 + paramInt2);
    this.adN = paramInt1;
  }
  
  public static kn a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new kn(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private void mr()
  {
    this.adL += this.adM;
    int i = this.adL;
    if (i > this.adP)
    {
      this.adM = (i - this.adP);
      this.adL -= this.adM;
      return;
    }
    this.adM = 0;
  }
  
  public static kn n(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static long x(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }
  
  public void a(kt paramkt)
    throws IOException
  {
    int i = mn();
    if (this.adQ >= this.adR) {
      throw ks.mE();
    }
    i = cR(i);
    this.adQ += 1;
    paramkt.b(this);
    cP(0);
    this.adQ -= 1;
    cS(i);
  }
  
  public void a(kt paramkt, int paramInt)
    throws IOException
  {
    if (this.adQ >= this.adR) {
      throw ks.mE();
    }
    this.adQ += 1;
    paramkt.b(this);
    cP(kw.l(paramInt, 4));
    this.adQ -= 1;
  }
  
  public void cP(int paramInt)
    throws ks
  {
    if (this.adO != paramInt) {
      throw ks.mC();
    }
  }
  
  public boolean cQ(int paramInt)
    throws IOException
  {
    switch (kw.de(paramInt))
    {
    default: 
      throw ks.mD();
    case 0: 
      mk();
      return true;
    case 1: 
      mq();
      return true;
    case 2: 
      cV(mn());
      return true;
    case 3: 
      mi();
      cP(kw.l(kw.df(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    mp();
    return true;
  }
  
  public int cR(int paramInt)
    throws ks
  {
    if (paramInt < 0) {
      throw ks.mz();
    }
    paramInt = this.adN + paramInt;
    int i = this.adP;
    if (paramInt > i) {
      throw ks.my();
    }
    this.adP = paramInt;
    mr();
    return i;
  }
  
  public void cS(int paramInt)
  {
    this.adP = paramInt;
    mr();
  }
  
  public void cT(int paramInt)
  {
    if (paramInt > this.adN - this.adK) {
      throw new IllegalArgumentException("Position " + paramInt + " is beyond current " + (this.adN - this.adK));
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("Bad position " + paramInt);
    }
    this.adN = (this.adK + paramInt);
  }
  
  public byte[] cU(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw ks.mz();
    }
    if (this.adN + paramInt > this.adP)
    {
      cV(this.adP - this.adN);
      throw ks.my();
    }
    if (paramInt <= this.adL - this.adN)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(this.buffer, this.adN, arrayOfByte, 0, paramInt);
      this.adN += paramInt;
      return arrayOfByte;
    }
    throw ks.my();
  }
  
  public void cV(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw ks.mz();
    }
    if (this.adN + paramInt > this.adP)
    {
      cV(this.adP - this.adN);
      throw ks.my();
    }
    if (paramInt <= this.adL - this.adN)
    {
      this.adN += paramInt;
      return;
    }
    throw ks.my();
  }
  
  public int getPosition()
  {
    return this.adN - this.adK;
  }
  
  public byte[] h(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return kw.aeh;
    }
    byte[] arrayOfByte = new byte[paramInt2];
    int i = this.adK;
    System.arraycopy(this.buffer, i + paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public int mh()
    throws IOException
  {
    if (mt())
    {
      this.adO = 0;
      return 0;
    }
    this.adO = mn();
    if (this.adO == 0) {
      throw ks.mB();
    }
    return this.adO;
  }
  
  public void mi()
    throws IOException
  {
    int i;
    do
    {
      i = mh();
    } while ((i != 0) && (cQ(i)));
  }
  
  public long mj()
    throws IOException
  {
    return mo();
  }
  
  public int mk()
    throws IOException
  {
    return mn();
  }
  
  public boolean ml()
    throws IOException
  {
    return mn() != 0;
  }
  
  public long mm()
    throws IOException
  {
    return x(mo());
  }
  
  public int mn()
    throws IOException
  {
    int i = mu();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = mu();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = mu();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = mu();
      if (k >= 0) {
        return i | k << 21;
      }
      j = mu();
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
      if (mu() >= 0) {
        break;
      }
      j += 1;
    }
    label133:
    throw ks.mA();
  }
  
  public long mo()
    throws IOException
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = mu();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw ks.mA();
  }
  
  public int mp()
    throws IOException
  {
    return mu() & 0xFF | (mu() & 0xFF) << 8 | (mu() & 0xFF) << 16 | (mu() & 0xFF) << 24;
  }
  
  public long mq()
    throws IOException
  {
    int i = mu();
    int j = mu();
    int k = mu();
    int m = mu();
    int n = mu();
    int i1 = mu();
    int i2 = mu();
    int i3 = mu();
    long l = i;
    return (j & 0xFF) << 8 | l & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24 | (n & 0xFF) << 32 | (i1 & 0xFF) << 40 | (i2 & 0xFF) << 48 | (i3 & 0xFF) << 56;
  }
  
  public int ms()
  {
    if (this.adP == Integer.MAX_VALUE) {
      return -1;
    }
    int i = this.adN;
    return this.adP - i;
  }
  
  public boolean mt()
  {
    return this.adN == this.adL;
  }
  
  public byte mu()
    throws IOException
  {
    if (this.adN == this.adL) {
      throw ks.my();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.adN;
    this.adN = (i + 1);
    return arrayOfByte[i];
  }
  
  public float readFloat()
    throws IOException
  {
    return Float.intBitsToFloat(mp());
  }
  
  public String readString()
    throws IOException
  {
    int i = mn();
    if ((i <= this.adL - this.adN) && (i > 0))
    {
      String str = new String(this.buffer, this.adN, i, "UTF-8");
      this.adN = (i + this.adN);
      return str;
    }
    return new String(cU(i), "UTF-8");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/kn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */