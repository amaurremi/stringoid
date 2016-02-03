package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.util.Utf8;
import java.io.IOException;
import java.nio.ByteBuffer;

public abstract class BinaryEncoder
  extends Encoder
{
  public abstract int bytesBuffered();
  
  public void setItemCount(long paramLong)
    throws IOException
  {
    if (paramLong > 0L) {
      writeLong(paramLong);
    }
  }
  
  public void startItem()
    throws IOException
  {}
  
  public void writeArrayEnd()
    throws IOException
  {
    writeZero();
  }
  
  public void writeArrayStart()
    throws IOException
  {}
  
  public void writeBytes(ByteBuffer paramByteBuffer)
    throws IOException
  {
    int i = paramByteBuffer.position();
    int j = paramByteBuffer.arrayOffset();
    int k = paramByteBuffer.limit();
    writeBytes(paramByteBuffer.array(), j + i, k - i);
  }
  
  public void writeBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 == 0)
    {
      writeZero();
      return;
    }
    writeInt(paramInt2);
    writeFixed(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void writeEnum(int paramInt)
    throws IOException
  {
    writeInt(paramInt);
  }
  
  public void writeIndex(int paramInt)
    throws IOException
  {
    writeInt(paramInt);
  }
  
  public void writeMapEnd()
    throws IOException
  {
    writeZero();
  }
  
  public void writeMapStart()
    throws IOException
  {}
  
  public void writeNull()
    throws IOException
  {}
  
  public void writeString(Utf8 paramUtf8)
    throws IOException
  {
    writeBytes(paramUtf8.getBytes(), 0, paramUtf8.getByteLength());
  }
  
  public void writeString(String paramString)
    throws IOException
  {
    if (paramString.length() == 0)
    {
      writeZero();
      return;
    }
    paramString = paramString.getBytes("UTF-8");
    writeInt(paramString.length);
    writeFixed(paramString, 0, paramString.length);
  }
  
  protected abstract void writeZero()
    throws IOException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/io/BinaryEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */