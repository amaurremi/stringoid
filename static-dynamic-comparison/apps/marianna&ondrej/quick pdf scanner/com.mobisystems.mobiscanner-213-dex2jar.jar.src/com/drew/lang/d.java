package com.drew.lang;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

public class d
  implements a
{
  private boolean fD = true;
  private final RandomAccessFile fG;
  private final long fH;
  private int fI;
  
  static
  {
    if (!d.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public d(RandomAccessFile paramRandomAccessFile)
  {
    if (paramRandomAccessFile == null) {
      throw new NullPointerException();
    }
    this.fG = paramRandomAccessFile;
    this.fH = this.fG.length();
  }
  
  private void X(int paramInt)
  {
    if (paramInt == this.fI) {
      return;
    }
    try
    {
      this.fG.seek(paramInt);
      this.fI = paramInt;
      return;
    }
    catch (IOException localIOException)
    {
      throw new BufferBoundsException("IOException seeking in file.", localIOException);
    }
  }
  
  private byte as()
  {
    int i;
    try
    {
      i = this.fG.read();
      if (i < 0) {
        throw new BufferBoundsException("Unexpected end of file encountered.");
      }
    }
    catch (IOException localIOException)
    {
      throw new BufferBoundsException("IOException reading from file.", localIOException);
    }
    assert (i <= 255);
    this.fI += 1;
    return (byte)i;
  }
  
  private void o(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0) {
      throw new BufferBoundsException("Requested negative number of bytes.");
    }
    if (paramInt1 < 0) {
      throw new BufferBoundsException("Requested data from a negative index within the file.");
    }
    if (paramInt1 + paramInt2 - 1L >= this.fH) {
      throw new BufferBoundsException("Requested data from beyond the end of the file.");
    }
  }
  
  public short N(int paramInt)
  {
    o(paramInt, 1);
    X(paramInt);
    return (short)(as() & 0xFF);
  }
  
  public byte O(int paramInt)
  {
    o(paramInt, 1);
    X(paramInt);
    return as();
  }
  
  public int P(int paramInt)
  {
    o(paramInt, 2);
    X(paramInt);
    if (this.fD) {
      return as() << 8 & 0xFF00 | as() & 0xFF;
    }
    return as() & 0xFF | as() << 8 & 0xFF00;
  }
  
  public short Q(int paramInt)
  {
    o(paramInt, 2);
    X(paramInt);
    if (this.fD) {
      return (short)((short)as() << 8 & 0xFF00 | (short)as() & 0xFF);
    }
    return (short)((short)as() & 0xFF | (short)as() << 8 & 0xFF00);
  }
  
  public long R(int paramInt)
  {
    o(paramInt, 4);
    X(paramInt);
    if (this.fD) {
      return as() << 24 & 0xFF000000 | as() << 16 & 0xFF0000 | as() << 8 & 0xFF00 | as() & 0xFF;
    }
    return as() & 0xFF | as() << 8 & 0xFF00 | as() << 16 & 0xFF0000 | as() << 24 & 0xFF000000;
  }
  
  public int S(int paramInt)
  {
    o(paramInt, 4);
    X(paramInt);
    if (this.fD) {
      return as() << 24 & 0xFF000000 | as() << 16 & 0xFF0000 | as() << 8 & 0xFF00 | as() & 0xFF;
    }
    return as() & 0xFF | as() << 8 & 0xFF00 | as() << 16 & 0xFF0000 | as() << 24 & 0xFF000000;
  }
  
  public long T(int paramInt)
  {
    o(paramInt, 8);
    X(paramInt);
    if (this.fD) {
      return as() << 56 & 0xFF00000000000000 | as() << 48 & 0xFF000000000000 | as() << 40 & 0xFF0000000000 | as() << 32 & 0xFF00000000 | as() << 24 & 0xFF000000 | as() << 16 & 0xFF0000 | as() << 8 & 0xFF00 | as() & 0xFF;
    }
    return as() & 0xFF | as() << 8 & 0xFF00 | as() << 16 & 0xFF0000 | as() << 24 & 0xFF000000 | as() << 32 & 0xFF00000000 | as() << 40 & 0xFF0000000000 | as() << 48 & 0xFF000000000000 | as() << 56 & 0xFF00000000000000;
  }
  
  public float U(int paramInt)
  {
    o(paramInt, 4);
    X(paramInt);
    if (this.fD)
    {
      float f = (as() & 0xFF) << 8 | as() & 0xFF;
      paramInt = as();
      i = as();
      double d = f;
      return (float)(((paramInt & 0xFF) << 8 | i & 0xFF) / 65536.0D + d);
    }
    paramInt = as();
    int i = as();
    return (float)((as() & 0xFF | (as() & 0xFF) << 8) + (paramInt & 0xFF | (i & 0xFF) << 8) / 65536.0D);
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
    o(paramInt1, paramInt2);
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
    return this.fH;
  }
  
  public String getString(int paramInt1, int paramInt2)
  {
    return new String(m(paramInt1, paramInt2));
  }
  
  public byte[] m(int paramInt1, int paramInt2)
  {
    o(paramInt1, paramInt2);
    X(paramInt1);
    byte[] arrayOfByte = new byte[paramInt2];
    try
    {
      paramInt1 = this.fG.read(arrayOfByte);
      this.fI += paramInt1;
      if (paramInt1 != paramInt2) {
        throw new BufferBoundsException("Unexpected end of file encountered.");
      }
    }
    catch (IOException localIOException)
    {
      throw new BufferBoundsException("Unexpected end of file encountered.", localIOException);
    }
    return localIOException;
  }
  
  public String n(int paramInt1, int paramInt2)
  {
    o(paramInt1, paramInt2);
    X(paramInt1);
    int i = 0;
    while ((paramInt1 + i < this.fH) && (as() != 0) && (i < paramInt2)) {
      i += 1;
    }
    return new String(m(paramInt1, i));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/lang/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */