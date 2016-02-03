package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.util.Utf8;
import java.io.Flushable;
import java.io.IOException;
import java.nio.ByteBuffer;

public abstract class Encoder
  implements Flushable
{
  public abstract void setItemCount(long paramLong)
    throws IOException;
  
  public abstract void startItem()
    throws IOException;
  
  public abstract void writeArrayEnd()
    throws IOException;
  
  public abstract void writeArrayStart()
    throws IOException;
  
  public abstract void writeBoolean(boolean paramBoolean)
    throws IOException;
  
  public abstract void writeBytes(ByteBuffer paramByteBuffer)
    throws IOException;
  
  public void writeBytes(byte[] paramArrayOfByte)
    throws IOException
  {
    writeBytes(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public abstract void writeBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void writeDouble(double paramDouble)
    throws IOException;
  
  public abstract void writeEnum(int paramInt)
    throws IOException;
  
  public void writeFixed(byte[] paramArrayOfByte)
    throws IOException
  {
    writeFixed(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public abstract void writeFixed(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void writeFloat(float paramFloat)
    throws IOException;
  
  public abstract void writeIndex(int paramInt)
    throws IOException;
  
  public abstract void writeInt(int paramInt)
    throws IOException;
  
  public abstract void writeLong(long paramLong)
    throws IOException;
  
  public abstract void writeMapEnd()
    throws IOException;
  
  public abstract void writeMapStart()
    throws IOException;
  
  public abstract void writeNull()
    throws IOException;
  
  public abstract void writeString(Utf8 paramUtf8)
    throws IOException;
  
  public void writeString(CharSequence paramCharSequence)
    throws IOException
  {
    if ((paramCharSequence instanceof Utf8))
    {
      writeString((Utf8)paramCharSequence);
      return;
    }
    writeString(paramCharSequence.toString());
  }
  
  public void writeString(String paramString)
    throws IOException
  {
    writeString(new Utf8(paramString));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/io/Encoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */