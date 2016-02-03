package com.google.tagmanager.protobuf;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
{
  private int ajk;
  private final boolean ajl;
  private int ajm;
  private int ajn;
  private final InputStream ajo;
  private int ajp;
  private boolean ajq = false;
  private int ajr;
  private int ajs = Integer.MAX_VALUE;
  private int ajt;
  private int aju = 64;
  private int ajv = 67108864;
  private a ajw = null;
  private final byte[] buffer;
  
  private f(m paramm)
  {
    this.buffer = paramm.akd;
    this.ajk = paramm.AH();
    this.ajm = (paramm.AH() + paramm.size());
    this.ajr = (-this.ajk);
    this.ajo = null;
    this.ajl = true;
  }
  
  private f(InputStream paramInputStream)
  {
    this.buffer = new byte['က'];
    this.ajm = 0;
    this.ajk = 0;
    this.ajr = 0;
    this.ajo = paramInputStream;
    this.ajl = false;
  }
  
  private f(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.ajm = (paramInt1 + paramInt2);
    this.ajk = paramInt1;
    this.ajr = (-paramInt1);
    this.ajo = null;
    this.ajl = false;
  }
  
  private void Bm()
  {
    this.ajm += this.ajn;
    int i = this.ajr + this.ajm;
    if (i > this.ajs)
    {
      this.ajn = (i - this.ajs);
      this.ajm -= this.ajn;
      return;
    }
    this.ajn = 0;
  }
  
  public static long E(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }
  
  static f a(m paramm)
  {
    f localf = new f(paramm);
    try
    {
      localf.eV(paramm.size());
      return localf;
    }
    catch (InvalidProtocolBufferException paramm)
    {
      throw new IllegalArgumentException(paramm);
    }
  }
  
  private boolean aH(boolean paramBoolean)
  {
    if (this.ajk < this.ajm) {
      throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }
    if (this.ajr + this.ajm == this.ajs)
    {
      if (paramBoolean) {
        throw InvalidProtocolBufferException.BO();
      }
      return false;
    }
    if (this.ajw != null) {
      this.ajw.Bq();
    }
    this.ajr += this.ajm;
    this.ajk = 0;
    if (this.ajo == null) {}
    for (int i = -1;; i = this.ajo.read(this.buffer))
    {
      this.ajm = i;
      if ((this.ajm != 0) && (this.ajm >= -1)) {
        break;
      }
      throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.ajm + "\nThe InputStream implementation is buggy.");
    }
    if (this.ajm == -1)
    {
      this.ajm = 0;
      if (paramBoolean) {
        throw InvalidProtocolBufferException.BO();
      }
      return false;
    }
    Bm();
    i = this.ajr + this.ajm + this.ajn;
    if ((i > this.ajv) || (i < 0)) {
      throw InvalidProtocolBufferException.BV();
    }
    return true;
  }
  
  public static f c(InputStream paramInputStream)
  {
    return new f(paramInputStream);
  }
  
  public static int eU(int paramInt)
  {
    return paramInt >>> 1 ^ -(paramInt & 0x1);
  }
  
  public static f f(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = new f(paramArrayOfByte, paramInt1, paramInt2);
    try
    {
      paramArrayOfByte.eV(paramInt2);
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferException paramArrayOfByte)
    {
      throw new IllegalArgumentException(paramArrayOfByte);
    }
  }
  
  public static f l(byte[] paramArrayOfByte)
  {
    return f(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int AT()
  {
    if (Bo())
    {
      this.ajp = 0;
      return 0;
    }
    this.ajp = Bi();
    if (WireFormat.fA(this.ajp) == 0) {
      throw InvalidProtocolBufferException.BR();
    }
    return this.ajp;
  }
  
  public long AU()
  {
    return Bj();
  }
  
  public long AV()
  {
    return Bj();
  }
  
  public int AW()
  {
    return Bi();
  }
  
  public long AX()
  {
    return Bl();
  }
  
  public int AY()
  {
    return Bk();
  }
  
  public boolean AZ()
  {
    return Bi() != 0;
  }
  
  public String Ba()
  {
    int i = Bi();
    Object localObject;
    if ((i <= this.ajm - this.ajk) && (i > 0))
    {
      localObject = e.e(this.buffer, this.ajk, i);
      this.ajk = (i + this.ajk);
    }
    while (!((e)localObject).AL())
    {
      throw InvalidProtocolBufferException.BW();
      localObject = new m(eX(i));
    }
    return ((e)localObject).AK();
  }
  
  public e Bb()
  {
    int i = Bi();
    if (i == 0) {
      return e.ajf;
    }
    if ((i <= this.ajm - this.ajk) && (i > 0))
    {
      if ((this.ajl) && (this.ajq)) {}
      for (Object localObject = new d(this.buffer, this.ajk, i);; localObject = e.e(this.buffer, this.ajk, i))
      {
        this.ajk = (i + this.ajk);
        return (e)localObject;
      }
    }
    return new m(eX(i));
  }
  
  public int Bc()
  {
    return Bi();
  }
  
  public int Bd()
  {
    return Bi();
  }
  
  public int Be()
  {
    return Bk();
  }
  
  public long Bf()
  {
    return Bl();
  }
  
  public int Bg()
  {
    return eU(Bi());
  }
  
  public long Bh()
  {
    return E(Bj());
  }
  
  public int Bi()
  {
    int i = Bp();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = Bp();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = Bp();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = Bp();
      if (k >= 0) {
        return i | k << 21;
      }
      j = Bp();
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
      if (Bp() >= 0) {
        break;
      }
      j += 1;
    }
    label133:
    throw InvalidProtocolBufferException.BQ();
  }
  
  public long Bj()
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = Bp();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw InvalidProtocolBufferException.BQ();
  }
  
  public int Bk()
  {
    return Bp() & 0xFF | (Bp() & 0xFF) << 8 | (Bp() & 0xFF) << 16 | (Bp() & 0xFF) << 24;
  }
  
  public long Bl()
  {
    int i = Bp();
    int j = Bp();
    int k = Bp();
    int m = Bp();
    int n = Bp();
    int i1 = Bp();
    int i2 = Bp();
    int i3 = Bp();
    long l = i;
    return (j & 0xFF) << 8 | l & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24 | (n & 0xFF) << 32 | (i1 & 0xFF) << 40 | (i2 & 0xFF) << 48 | (i3 & 0xFF) << 56;
  }
  
  public int Bn()
  {
    if (this.ajs == Integer.MAX_VALUE) {
      return -1;
    }
    int i = this.ajr;
    int j = this.ajk;
    return this.ajs - (i + j);
  }
  
  public boolean Bo()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.ajk == this.ajm)
    {
      bool1 = bool2;
      if (!aH(false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public byte Bp()
  {
    if (this.ajk == this.ajm) {
      aH(true);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.ajk;
    this.ajk = (i + 1);
    return arrayOfByte[i];
  }
  
  public <T extends n> T a(q<T> paramq, g paramg)
  {
    int i = Bi();
    if (this.ajt >= this.aju) {
      throw InvalidProtocolBufferException.BU();
    }
    i = eV(i);
    this.ajt += 1;
    paramq = (n)paramq.b(this, paramg);
    eT(0);
    this.ajt -= 1;
    eW(i);
    return paramq;
  }
  
  public void a(int paramInt, n.a parama, g paramg)
  {
    if (this.ajt >= this.aju) {
      throw InvalidProtocolBufferException.BU();
    }
    this.ajt += 1;
    parama.e(this, paramg);
    eT(WireFormat.D(paramInt, 4));
    this.ajt -= 1;
  }
  
  public void a(n.a parama, g paramg)
  {
    int i = Bi();
    if (this.ajt >= this.aju) {
      throw InvalidProtocolBufferException.BU();
    }
    i = eV(i);
    this.ajt += 1;
    parama.e(this, paramg);
    eT(0);
    this.ajt -= 1;
    eW(i);
  }
  
  public boolean a(int paramInt, CodedOutputStream paramCodedOutputStream)
  {
    long l;
    switch (WireFormat.fz(paramInt))
    {
    default: 
      throw InvalidProtocolBufferException.BT();
    case 0: 
      l = AV();
      paramCodedOutputStream.fn(paramInt);
      paramCodedOutputStream.F(l);
      return true;
    case 1: 
      l = Bl();
      paramCodedOutputStream.fn(paramInt);
      paramCodedOutputStream.H(l);
      return true;
    case 2: 
      e locale = Bb();
      paramCodedOutputStream.fn(paramInt);
      paramCodedOutputStream.b(locale);
      return true;
    case 3: 
      paramCodedOutputStream.fn(paramInt);
      b(paramCodedOutputStream);
      paramInt = WireFormat.D(WireFormat.fA(paramInt), 4);
      eT(paramInt);
      paramCodedOutputStream.fn(paramInt);
      return true;
    case 4: 
      return false;
    }
    int i = Bk();
    paramCodedOutputStream.fn(paramInt);
    paramCodedOutputStream.fa(i);
    return true;
  }
  
  public void b(CodedOutputStream paramCodedOutputStream)
  {
    int i;
    do
    {
      i = AT();
    } while ((i != 0) && (a(i, paramCodedOutputStream)));
  }
  
  public void eT(int paramInt)
  {
    if (this.ajp != paramInt) {
      throw InvalidProtocolBufferException.BS();
    }
  }
  
  public int eV(int paramInt)
  {
    if (paramInt < 0) {
      throw InvalidProtocolBufferException.BP();
    }
    paramInt = this.ajr + this.ajk + paramInt;
    int i = this.ajs;
    if (paramInt > i) {
      throw InvalidProtocolBufferException.BO();
    }
    this.ajs = paramInt;
    Bm();
    return i;
  }
  
  public void eW(int paramInt)
  {
    this.ajs = paramInt;
    Bm();
  }
  
  public byte[] eX(int paramInt)
  {
    if (paramInt < 0) {
      throw InvalidProtocolBufferException.BP();
    }
    if (this.ajr + this.ajk + paramInt > this.ajs)
    {
      eY(this.ajs - this.ajr - this.ajk);
      throw InvalidProtocolBufferException.BO();
    }
    if (paramInt <= this.ajm - this.ajk)
    {
      arrayOfByte1 = new byte[paramInt];
      System.arraycopy(this.buffer, this.ajk, arrayOfByte1, 0, paramInt);
      this.ajk += paramInt;
      return arrayOfByte1;
    }
    if (paramInt < 4096)
    {
      arrayOfByte1 = new byte[paramInt];
      i = this.ajm - this.ajk;
      System.arraycopy(this.buffer, this.ajk, arrayOfByte1, 0, i);
      this.ajk = this.ajm;
      aH(true);
      while (paramInt - i > this.ajm)
      {
        System.arraycopy(this.buffer, 0, arrayOfByte1, i, this.ajm);
        i += this.ajm;
        this.ajk = this.ajm;
        aH(true);
      }
      System.arraycopy(this.buffer, 0, arrayOfByte1, i, paramInt - i);
      this.ajk = (paramInt - i);
      return arrayOfByte1;
    }
    int m = this.ajk;
    int n = this.ajm;
    this.ajr += this.ajm;
    this.ajk = 0;
    this.ajm = 0;
    Object localObject = new ArrayList();
    int i = paramInt - (n - m);
    while (i > 0)
    {
      arrayOfByte1 = new byte[Math.min(i, 4096)];
      int j = 0;
      while (j < arrayOfByte1.length)
      {
        if (this.ajo == null) {}
        for (int k = -1; k == -1; k = this.ajo.read(arrayOfByte1, j, arrayOfByte1.length - j)) {
          throw InvalidProtocolBufferException.BO();
        }
        this.ajr += k;
        j += k;
      }
      j = arrayOfByte1.length;
      ((List)localObject).add(arrayOfByte1);
      i -= j;
    }
    byte[] arrayOfByte1 = new byte[paramInt];
    paramInt = n - m;
    System.arraycopy(this.buffer, m, arrayOfByte1, 0, paramInt);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      byte[] arrayOfByte2 = (byte[])((Iterator)localObject).next();
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, paramInt, arrayOfByte2.length);
      paramInt = arrayOfByte2.length + paramInt;
    }
    return arrayOfByte1;
  }
  
  public void eY(int paramInt)
  {
    if (paramInt < 0) {
      throw InvalidProtocolBufferException.BP();
    }
    if (this.ajr + this.ajk + paramInt > this.ajs)
    {
      eY(this.ajs - this.ajr - this.ajk);
      throw InvalidProtocolBufferException.BO();
    }
    if (paramInt <= this.ajm - this.ajk)
    {
      this.ajk += paramInt;
      return;
    }
    int i = this.ajm - this.ajk;
    this.ajk = this.ajm;
    aH(true);
    while (paramInt - i > this.ajm)
    {
      i += this.ajm;
      this.ajk = this.ajm;
      aH(true);
    }
    this.ajk = (paramInt - i);
  }
  
  public double readDouble()
  {
    return Double.longBitsToDouble(Bl());
  }
  
  public float readFloat()
  {
    return Float.intBitsToFloat(Bk());
  }
  
  public String readString()
  {
    int i = Bi();
    if ((i <= this.ajm - this.ajk) && (i > 0))
    {
      String str = new String(this.buffer, this.ajk, i, "UTF-8");
      this.ajk = (i + this.ajk);
      return str;
    }
    return new String(eX(i), "UTF-8");
  }
  
  private static abstract interface a
  {
    public abstract void Bq();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/protobuf/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */