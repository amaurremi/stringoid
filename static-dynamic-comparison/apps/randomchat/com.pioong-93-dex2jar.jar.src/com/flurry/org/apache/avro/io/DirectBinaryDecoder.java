package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.util.ByteBufferInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

class DirectBinaryDecoder
  extends BinaryDecoder
{
  private final byte[] buf = new byte[8];
  private ByteReader byteReader;
  private InputStream in;
  
  DirectBinaryDecoder(InputStream paramInputStream)
  {
    configure(paramInputStream);
  }
  
  DirectBinaryDecoder configure(InputStream paramInputStream)
  {
    this.in = paramInputStream;
    if ((paramInputStream instanceof ByteBufferInputStream)) {}
    for (paramInputStream = new ReuseByteReader((ByteBufferInputStream)paramInputStream);; paramInputStream = new ByteReader(null))
    {
      this.byteReader = paramInputStream;
      return this;
    }
  }
  
  protected void doReadBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    for (;;)
    {
      int i = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
      if ((i == paramInt2) || (paramInt2 == 0)) {
        return;
      }
      if (i < 0) {
        throw new EOFException();
      }
      paramInt1 += i;
      paramInt2 -= i;
    }
  }
  
  protected void doSkipBytes(long paramLong)
    throws IOException
  {
    while (paramLong > 0L)
    {
      long l = this.in.skip(paramLong);
      if (l <= 0L) {
        throw new EOFException();
      }
      paramLong -= l;
    }
  }
  
  public InputStream inputStream()
  {
    return this.in;
  }
  
  public boolean isEnd()
    throws IOException
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean readBoolean()
    throws IOException
  {
    int i = this.in.read();
    if (i < 0) {
      throw new EOFException();
    }
    return i == 1;
  }
  
  public ByteBuffer readBytes(ByteBuffer paramByteBuffer)
    throws IOException
  {
    int i = readInt();
    return this.byteReader.read(paramByteBuffer, i);
  }
  
  public double readDouble()
    throws IOException
  {
    doReadBytes(this.buf, 0, 8);
    return Double.longBitsToDouble(this.buf[0] & 0xFF | (this.buf[1] & 0xFF) << 8 | (this.buf[2] & 0xFF) << 16 | (this.buf[3] & 0xFF) << 24 | (this.buf[4] & 0xFF) << 32 | (this.buf[5] & 0xFF) << 40 | (this.buf[6] & 0xFF) << 48 | (this.buf[7] & 0xFF) << 56);
  }
  
  public float readFloat()
    throws IOException
  {
    doReadBytes(this.buf, 0, 4);
    return Float.intBitsToFloat(this.buf[0] & 0xFF | (this.buf[1] & 0xFF) << 8 | (this.buf[2] & 0xFF) << 16 | (this.buf[3] & 0xFF) << 24);
  }
  
  public int readInt()
    throws IOException
  {
    int j = 0;
    int i = 0;
    int k;
    do
    {
      k = this.in.read();
      if (k >= 0)
      {
        j |= (k & 0x7F) << i;
        if ((k & 0x80) == 0) {
          return j >>> 1 ^ -(j & 0x1);
        }
      }
      else
      {
        throw new EOFException();
      }
      k = i + 7;
      i = k;
    } while (k < 32);
    throw new IOException("Invalid int encoding");
  }
  
  public long readLong()
    throws IOException
  {
    long l = 0L;
    int i = 0;
    int j;
    do
    {
      j = this.in.read();
      if (j >= 0)
      {
        l |= (j & 0x7F) << i;
        if ((j & 0x80) == 0) {
          return l >>> 1 ^ -(1L & l);
        }
      }
      else
      {
        throw new EOFException();
      }
      j = i + 7;
      i = j;
    } while (j < 64);
    throw new IOException("Invalid long encoding");
  }
  
  private class ByteReader
  {
    private ByteReader() {}
    
    public ByteBuffer read(ByteBuffer paramByteBuffer, int paramInt)
      throws IOException
    {
      if ((paramByteBuffer != null) && (paramInt <= paramByteBuffer.capacity())) {
        paramByteBuffer.clear();
      }
      for (;;)
      {
        DirectBinaryDecoder.this.doReadBytes(paramByteBuffer.array(), paramByteBuffer.position(), paramInt);
        paramByteBuffer.limit(paramInt);
        return paramByteBuffer;
        paramByteBuffer = ByteBuffer.allocate(paramInt);
      }
    }
  }
  
  private class ReuseByteReader
    extends DirectBinaryDecoder.ByteReader
  {
    private final ByteBufferInputStream bbi;
    
    public ReuseByteReader(ByteBufferInputStream paramByteBufferInputStream)
    {
      super(null);
      this.bbi = paramByteBufferInputStream;
    }
    
    public ByteBuffer read(ByteBuffer paramByteBuffer, int paramInt)
      throws IOException
    {
      if (paramByteBuffer != null) {
        return super.read(paramByteBuffer, paramInt);
      }
      return this.bbi.readBuffer(paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/io/DirectBinaryDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */