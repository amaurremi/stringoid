package com.flurry.org.apache.avro.file;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

class LengthLimitedInputStream
  extends FilterInputStream
{
  private long remaining;
  
  protected LengthLimitedInputStream(InputStream paramInputStream, long paramLong)
  {
    super(paramInputStream);
    this.remaining = paramLong;
  }
  
  private int remainingInt()
  {
    return (int)Math.min(this.remaining, 2147483647L);
  }
  
  public int available()
    throws IOException
  {
    return Math.min(super.available(), remainingInt());
  }
  
  public int read()
    throws IOException
  {
    if (this.remaining > 0L)
    {
      int i = super.read();
      if (i != -1) {
        this.remaining -= 1L;
      }
      return i;
    }
    return -1;
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.remaining == 0L) {
      paramInt1 = -1;
    }
    do
    {
      return paramInt1;
      int i = paramInt2;
      if (paramInt2 > this.remaining) {
        i = remainingInt();
      }
      paramInt2 = super.read(paramArrayOfByte, paramInt1, i);
      paramInt1 = paramInt2;
    } while (paramInt2 == -1);
    this.remaining -= paramInt2;
    return paramInt2;
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    paramLong = super.skip(Math.min(this.remaining, paramLong));
    this.remaining -= paramLong;
    return paramLong;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/file/LengthLimitedInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */