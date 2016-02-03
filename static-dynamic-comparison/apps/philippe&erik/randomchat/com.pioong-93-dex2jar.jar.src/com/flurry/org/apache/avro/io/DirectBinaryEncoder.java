package com.flurry.org.apache.avro.io;

import java.io.IOException;
import java.io.OutputStream;

public class DirectBinaryEncoder
  extends BinaryEncoder
{
  private final byte[] buf = new byte[12];
  private OutputStream out;
  
  DirectBinaryEncoder(OutputStream paramOutputStream)
  {
    configure(paramOutputStream);
  }
  
  public int bytesBuffered()
  {
    return 0;
  }
  
  DirectBinaryEncoder configure(OutputStream paramOutputStream)
  {
    if (paramOutputStream == null) {
      throw new NullPointerException("OutputStream cannot be null!");
    }
    this.out = paramOutputStream;
    return this;
  }
  
  public void flush()
    throws IOException
  {
    this.out.flush();
  }
  
  public void writeBoolean(boolean paramBoolean)
    throws IOException
  {
    OutputStream localOutputStream = this.out;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localOutputStream.write(i);
      return;
    }
  }
  
  public void writeDouble(double paramDouble)
    throws IOException
  {
    byte[] arrayOfByte = new byte[8];
    int i = BinaryData.encodeDouble(paramDouble, arrayOfByte, 0);
    this.out.write(arrayOfByte, 0, i);
  }
  
  public void writeFixed(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void writeFloat(float paramFloat)
    throws IOException
  {
    int i = BinaryData.encodeFloat(paramFloat, this.buf, 0);
    this.out.write(this.buf, 0, i);
  }
  
  public void writeInt(int paramInt)
    throws IOException
  {
    int i = paramInt << 1 ^ paramInt >> 31;
    if ((i & 0xFFFFFF80) == 0)
    {
      this.out.write(i);
      return;
    }
    if ((i & 0xC000) == 0)
    {
      this.out.write(i | 0x80);
      this.out.write(i >>> 7);
      return;
    }
    paramInt = BinaryData.encodeInt(paramInt, this.buf, 0);
    this.out.write(this.buf, 0, paramInt);
  }
  
  public void writeLong(long paramLong)
    throws IOException
  {
    long l = paramLong << 1 ^ paramLong >> 63;
    if ((0xFFFFFFFF80000000 & l) == 0L)
    {
      i = (int)l;
      while ((i & 0xFFFFFF80) != 0)
      {
        this.out.write((byte)((i | 0x80) & 0xFF));
        i >>>= 7;
      }
      this.out.write((byte)i);
      return;
    }
    int i = BinaryData.encodeLong(paramLong, this.buf, 0);
    this.out.write(this.buf, 0, i);
  }
  
  protected void writeZero()
    throws IOException
  {
    this.out.write(0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/io/DirectBinaryEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */