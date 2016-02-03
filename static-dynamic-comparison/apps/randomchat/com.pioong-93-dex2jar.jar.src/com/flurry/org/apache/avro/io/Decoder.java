package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.util.Utf8;
import java.io.IOException;
import java.nio.ByteBuffer;

public abstract class Decoder
{
  public abstract long arrayNext()
    throws IOException;
  
  public abstract long mapNext()
    throws IOException;
  
  public abstract long readArrayStart()
    throws IOException;
  
  public abstract boolean readBoolean()
    throws IOException;
  
  public abstract ByteBuffer readBytes(ByteBuffer paramByteBuffer)
    throws IOException;
  
  public abstract double readDouble()
    throws IOException;
  
  public abstract int readEnum()
    throws IOException;
  
  public void readFixed(byte[] paramArrayOfByte)
    throws IOException
  {
    readFixed(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public abstract void readFixed(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract float readFloat()
    throws IOException;
  
  public abstract int readIndex()
    throws IOException;
  
  public abstract int readInt()
    throws IOException;
  
  public abstract long readLong()
    throws IOException;
  
  public abstract long readMapStart()
    throws IOException;
  
  public abstract void readNull()
    throws IOException;
  
  public abstract Utf8 readString(Utf8 paramUtf8)
    throws IOException;
  
  public abstract String readString()
    throws IOException;
  
  public abstract long skipArray()
    throws IOException;
  
  public abstract void skipBytes()
    throws IOException;
  
  public abstract void skipFixed(int paramInt)
    throws IOException;
  
  public abstract long skipMap()
    throws IOException;
  
  public abstract void skipString()
    throws IOException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/io/Decoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */