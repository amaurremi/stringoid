package com.flurry.org.apache.avro.file;

import java.io.IOException;
import java.nio.ByteBuffer;

final class NullCodec
  extends Codec
{
  private static final NullCodec INSTANCE = new NullCodec();
  public static final CodecFactory OPTION = new Option();
  
  ByteBuffer compress(ByteBuffer paramByteBuffer)
    throws IOException
  {
    return paramByteBuffer;
  }
  
  ByteBuffer decompress(ByteBuffer paramByteBuffer)
    throws IOException
  {
    return paramByteBuffer;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    while (getClass() == paramObject.getClass()) {
      return true;
    }
    return false;
  }
  
  String getName()
  {
    return "null";
  }
  
  public int hashCode()
  {
    return 2;
  }
  
  static class Option
    extends CodecFactory
  {
    protected Codec createInstance()
    {
      return NullCodec.INSTANCE;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/file/NullCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */