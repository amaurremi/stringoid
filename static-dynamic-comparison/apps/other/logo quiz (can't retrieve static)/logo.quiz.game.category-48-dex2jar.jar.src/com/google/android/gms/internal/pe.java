package com.google.android.gms.internal;

import java.io.IOException;

public final class pe
{
  private int awo;
  private int awp;
  private int awq;
  private int awr;
  private int aws;
  private int awt = Integer.MAX_VALUE;
  private int awu;
  private int awv = 64;
  private int aww = 67108864;
  private final byte[] buffer;
  
  private pe(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.awo = paramInt1;
    this.awp = (paramInt1 + paramInt2);
    this.awr = paramInt1;
  }
  
  public static long A(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }
  
  public static pe a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new pe(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int gn(int paramInt)
  {
    return paramInt >>> 1 ^ -(paramInt & 0x1);
  }
  
  public static pe p(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private void qr()
  {
    this.awp += this.awq;
    int i = this.awp;
    if (i > this.awt)
    {
      this.awq = (i - this.awt);
      this.awp -= this.awq;
      return;
    }
    this.awq = 0;
  }
  
  public void a(pm parampm)
    throws IOException
  {
    int i = qn();
    if (this.awu >= this.awv) {
      throw pl.qE();
    }
    i = go(i);
    this.awu += 1;
    parampm.b(this);
    gl(0);
    this.awu -= 1;
    gp(i);
  }
  
  public void a(pm parampm, int paramInt)
    throws IOException
  {
    if (this.awu >= this.awv) {
      throw pl.qE();
    }
    this.awu += 1;
    parampm.b(this);
    gl(pp.x(paramInt, 4));
    this.awu -= 1;
  }
  
  public int getPosition()
  {
    return this.awr - this.awo;
  }
  
  public void gl(int paramInt)
    throws pl
  {
    if (this.aws != paramInt) {
      throw pl.qC();
    }
  }
  
  public boolean gm(int paramInt)
    throws IOException
  {
    switch (pp.gG(paramInt))
    {
    default: 
      throw pl.qD();
    case 0: 
      qj();
      return true;
    case 1: 
      qq();
      return true;
    case 2: 
      gs(qn());
      return true;
    case 3: 
      qh();
      gl(pp.x(pp.gH(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    qp();
    return true;
  }
  
  public int go(int paramInt)
    throws pl
  {
    if (paramInt < 0) {
      throw pl.qz();
    }
    paramInt = this.awr + paramInt;
    int i = this.awt;
    if (paramInt > i) {
      throw pl.qy();
    }
    this.awt = paramInt;
    qr();
    return i;
  }
  
  public void gp(int paramInt)
  {
    this.awt = paramInt;
    qr();
  }
  
  public void gq(int paramInt)
  {
    if (paramInt > this.awr - this.awo) {
      throw new IllegalArgumentException("Position " + paramInt + " is beyond current " + (this.awr - this.awo));
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("Bad position " + paramInt);
    }
    this.awr = (this.awo + paramInt);
  }
  
  public byte[] gr(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw pl.qz();
    }
    if (this.awr + paramInt > this.awt)
    {
      gs(this.awt - this.awr);
      throw pl.qy();
    }
    if (paramInt <= this.awp - this.awr)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(this.buffer, this.awr, arrayOfByte, 0, paramInt);
      this.awr += paramInt;
      return arrayOfByte;
    }
    throw pl.qy();
  }
  
  public void gs(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw pl.qz();
    }
    if (this.awr + paramInt > this.awt)
    {
      gs(this.awt - this.awr);
      throw pl.qy();
    }
    if (paramInt <= this.awp - this.awr)
    {
      this.awr += paramInt;
      return;
    }
    throw pl.qy();
  }
  
  public int qg()
    throws IOException
  {
    if (qt())
    {
      this.aws = 0;
      return 0;
    }
    this.aws = qn();
    if (this.aws == 0) {
      throw pl.qB();
    }
    return this.aws;
  }
  
  public void qh()
    throws IOException
  {
    int i;
    do
    {
      i = qg();
    } while ((i != 0) && (gm(i)));
  }
  
  public long qi()
    throws IOException
  {
    return qo();
  }
  
  public int qj()
    throws IOException
  {
    return qn();
  }
  
  public boolean qk()
    throws IOException
  {
    return qn() != 0;
  }
  
  public int ql()
    throws IOException
  {
    return gn(qn());
  }
  
  public long qm()
    throws IOException
  {
    return A(qo());
  }
  
  public int qn()
    throws IOException
  {
    int i = qu();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = qu();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = qu();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = qu();
      if (k >= 0) {
        return i | k << 21;
      }
      j = qu();
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
      if (qu() >= 0) {
        break;
      }
      j += 1;
    }
    label133:
    throw pl.qA();
  }
  
  public long qo()
    throws IOException
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = qu();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw pl.qA();
  }
  
  public int qp()
    throws IOException
  {
    return qu() & 0xFF | (qu() & 0xFF) << 8 | (qu() & 0xFF) << 16 | (qu() & 0xFF) << 24;
  }
  
  public long qq()
    throws IOException
  {
    int i = qu();
    int j = qu();
    int k = qu();
    int m = qu();
    int n = qu();
    int i1 = qu();
    int i2 = qu();
    int i3 = qu();
    long l = i;
    return (j & 0xFF) << 8 | l & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24 | (n & 0xFF) << 32 | (i1 & 0xFF) << 40 | (i2 & 0xFF) << 48 | (i3 & 0xFF) << 56;
  }
  
  public int qs()
  {
    if (this.awt == Integer.MAX_VALUE) {
      return -1;
    }
    int i = this.awr;
    return this.awt - i;
  }
  
  public boolean qt()
  {
    return this.awr == this.awp;
  }
  
  public byte qu()
    throws IOException
  {
    if (this.awr == this.awp) {
      throw pl.qy();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.awr;
    this.awr = (i + 1);
    return arrayOfByte[i];
  }
  
  public byte[] r(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return pp.awS;
    }
    byte[] arrayOfByte = new byte[paramInt2];
    int i = this.awo;
    System.arraycopy(this.buffer, i + paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public byte[] readBytes()
    throws IOException
  {
    int i = qn();
    if ((i <= this.awp - this.awr) && (i > 0))
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.buffer, this.awr, arrayOfByte, 0, i);
      this.awr = (i + this.awr);
      return arrayOfByte;
    }
    return gr(i);
  }
  
  public double readDouble()
    throws IOException
  {
    return Double.longBitsToDouble(qq());
  }
  
  public float readFloat()
    throws IOException
  {
    return Float.intBitsToFloat(qp());
  }
  
  public String readString()
    throws IOException
  {
    int i = qn();
    if ((i <= this.awp - this.awr) && (i > 0))
    {
      String str = new String(this.buffer, this.awr, i, "UTF-8");
      this.awr = (i + this.awr);
      return str;
    }
    return new String(gr(i), "UTF-8");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/pe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */