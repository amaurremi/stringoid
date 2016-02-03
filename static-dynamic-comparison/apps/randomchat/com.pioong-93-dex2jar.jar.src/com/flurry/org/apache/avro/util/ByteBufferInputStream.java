package com.flurry.org.apache.avro.util;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class ByteBufferInputStream
  extends InputStream
{
  private List<ByteBuffer> buffers;
  private int current;
  
  public ByteBufferInputStream(List<ByteBuffer> paramList)
  {
    this.buffers = paramList;
  }
  
  private ByteBuffer getBuffer()
    throws IOException
  {
    while (this.current < this.buffers.size())
    {
      ByteBuffer localByteBuffer = (ByteBuffer)this.buffers.get(this.current);
      if (localByteBuffer.hasRemaining()) {
        return localByteBuffer;
      }
      this.current += 1;
    }
    throw new EOFException();
  }
  
  public int read()
    throws IOException
  {
    return getBuffer().get() & 0xFF;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 == 0) {
      return 0;
    }
    ByteBuffer localByteBuffer = getBuffer();
    int i = localByteBuffer.remaining();
    if (paramInt2 > i)
    {
      localByteBuffer.get(paramArrayOfByte, paramInt1, i);
      return i;
    }
    localByteBuffer.get(paramArrayOfByte, paramInt1, paramInt2);
    return paramInt2;
  }
  
  public ByteBuffer readBuffer(int paramInt)
    throws IOException
  {
    if (paramInt == 0) {
      return ByteBuffer.allocate(0);
    }
    ByteBuffer localByteBuffer = getBuffer();
    if (localByteBuffer.remaining() == paramInt)
    {
      this.current += 1;
      return localByteBuffer;
    }
    localByteBuffer = ByteBuffer.allocate(paramInt);
    int i = 0;
    while (i < paramInt) {
      i += read(localByteBuffer.array(), i, paramInt - i);
    }
    return localByteBuffer;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/util/ByteBufferInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */