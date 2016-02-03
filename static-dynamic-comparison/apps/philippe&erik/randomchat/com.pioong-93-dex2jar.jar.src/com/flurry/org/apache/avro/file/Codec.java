package com.flurry.org.apache.avro.file;

import java.io.IOException;
import java.nio.ByteBuffer;

abstract class Codec
{
  abstract ByteBuffer compress(ByteBuffer paramByteBuffer)
    throws IOException;
  
  abstract ByteBuffer decompress(ByteBuffer paramByteBuffer)
    throws IOException;
  
  public abstract boolean equals(Object paramObject);
  
  abstract String getName();
  
  public abstract int hashCode();
  
  public String toString()
  {
    return getName();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/file/Codec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */