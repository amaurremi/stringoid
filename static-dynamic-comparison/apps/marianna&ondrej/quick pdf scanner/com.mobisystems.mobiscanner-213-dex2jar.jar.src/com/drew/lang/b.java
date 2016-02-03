package com.drew.lang;

import java.io.UnsupportedEncodingException;

public class b
  implements a
{
  private final byte[] fC;
  private boolean fD = true;
  
  public b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException();
    }
    this.fC = paramArrayOfByte;
  }
  
  private void o(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 0) || (paramInt1 < 0) || (paramInt1 + paramInt2 - 1L >= this.fC.length)) {
      throw new BufferBoundsException(this.fC, paramInt1, paramInt2);
    }
  }
  
  public short N(int paramInt)
  {
    o(paramInt, 1);
    return (short)(this.fC[paramInt] & 0xFF);
  }
  
  public byte O(int paramInt)
  {
    o(paramInt, 1);
    return this.fC[paramInt];
  }
  
  public int P(int paramInt)
  {
    o(paramInt, 2);
    if (this.fD) {
      return this.fC[paramInt] << 8 & 0xFF00 | this.fC[(paramInt + 1)] & 0xFF;
    }
    return this.fC[(paramInt + 1)] << 8 & 0xFF00 | this.fC[paramInt] & 0xFF;
  }
  
  public short Q(int paramInt)
  {
    o(paramInt, 2);
    if (this.fD) {
      return (short)((short)this.fC[paramInt] << 8 & 0xFF00 | (short)this.fC[(paramInt + 1)] & 0xFF);
    }
    return (short)((short)this.fC[(paramInt + 1)] << 8 & 0xFF00 | (short)this.fC[paramInt] & 0xFF);
  }
  
  public long R(int paramInt)
  {
    o(paramInt, 4);
    if (this.fD) {
      return this.fC[paramInt] << 24 & 0xFF000000 | this.fC[(paramInt + 1)] << 16 & 0xFF0000 | this.fC[(paramInt + 2)] << 8 & 0xFF00 | this.fC[(paramInt + 3)] & 0xFF;
    }
    return this.fC[(paramInt + 3)] << 24 & 0xFF000000 | this.fC[(paramInt + 2)] << 16 & 0xFF0000 | this.fC[(paramInt + 1)] << 8 & 0xFF00 | this.fC[paramInt] & 0xFF;
  }
  
  public int S(int paramInt)
  {
    o(paramInt, 4);
    if (this.fD) {
      return this.fC[paramInt] << 24 & 0xFF000000 | this.fC[(paramInt + 1)] << 16 & 0xFF0000 | this.fC[(paramInt + 2)] << 8 & 0xFF00 | this.fC[(paramInt + 3)] & 0xFF;
    }
    return this.fC[(paramInt + 3)] << 24 & 0xFF000000 | this.fC[(paramInt + 2)] << 16 & 0xFF0000 | this.fC[(paramInt + 1)] << 8 & 0xFF00 | this.fC[paramInt] & 0xFF;
  }
  
  public long T(int paramInt)
  {
    o(paramInt, 8);
    if (this.fD) {
      return this.fC[paramInt] << 56 & 0xFF00000000000000 | this.fC[(paramInt + 1)] << 48 & 0xFF000000000000 | this.fC[(paramInt + 2)] << 40 & 0xFF0000000000 | this.fC[(paramInt + 3)] << 32 & 0xFF00000000 | this.fC[(paramInt + 4)] << 24 & 0xFF000000 | this.fC[(paramInt + 5)] << 16 & 0xFF0000 | this.fC[(paramInt + 6)] << 8 & 0xFF00 | this.fC[(paramInt + 7)] & 0xFF;
    }
    return this.fC[(paramInt + 7)] << 56 & 0xFF00000000000000 | this.fC[(paramInt + 6)] << 48 & 0xFF000000000000 | this.fC[(paramInt + 5)] << 40 & 0xFF0000000000 | this.fC[(paramInt + 4)] << 32 & 0xFF00000000 | this.fC[(paramInt + 3)] << 24 & 0xFF000000 | this.fC[(paramInt + 2)] << 16 & 0xFF0000 | this.fC[(paramInt + 1)] << 8 & 0xFF00 | this.fC[paramInt] & 0xFF;
  }
  
  public float U(int paramInt)
  {
    o(paramInt, 4);
    if (this.fD)
    {
      f = (this.fC[paramInt] & 0xFF) << 8 | this.fC[(paramInt + 1)] & 0xFF;
      i = this.fC[(paramInt + 2)];
      paramInt = this.fC[(paramInt + 3)];
      d = f;
      return (float)(((i & 0xFF) << 8 | paramInt & 0xFF) / 65536.0D + d);
    }
    float f = (this.fC[(paramInt + 3)] & 0xFF) << 8 | this.fC[(paramInt + 2)] & 0xFF;
    int i = this.fC[(paramInt + 1)];
    paramInt = this.fC[paramInt];
    double d = f;
    return (float)(((i & 0xFF) << 8 | paramInt & 0xFF) / 65536.0D + d);
  }
  
  public float V(int paramInt)
  {
    return Float.intBitsToFloat(S(paramInt));
  }
  
  public double W(int paramInt)
  {
    return Double.longBitsToDouble(T(paramInt));
  }
  
  public String a(int paramInt1, int paramInt2, String paramString)
  {
    byte[] arrayOfByte = m(paramInt1, paramInt2);
    try
    {
      paramString = new String(arrayOfByte, paramString);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString) {}
    return new String(arrayOfByte);
  }
  
  public boolean ar()
  {
    return this.fD;
  }
  
  public void f(boolean paramBoolean)
  {
    this.fD = paramBoolean;
  }
  
  public long getLength()
  {
    return this.fC.length;
  }
  
  public String getString(int paramInt1, int paramInt2)
  {
    return new String(m(paramInt1, paramInt2));
  }
  
  public byte[] m(int paramInt1, int paramInt2)
  {
    o(paramInt1, paramInt2);
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(this.fC, paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public String n(int paramInt1, int paramInt2)
  {
    o(paramInt1, paramInt2);
    int i = 0;
    while ((paramInt1 + i < this.fC.length) && (this.fC[(paramInt1 + i)] != 0) && (i < paramInt2)) {
      i += 1;
    }
    return new String(m(paramInt1, i));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/lang/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */