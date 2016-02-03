package com.flurry.org.apache.avro.file;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SeekableByteArrayInput
  extends ByteArrayInputStream
  implements SeekableInput
{
  public SeekableByteArrayInput(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  public long length()
    throws IOException
  {
    return this.count;
  }
  
  public void seek(long paramLong)
    throws IOException
  {
    reset();
    skip(paramLong);
  }
  
  public long tell()
    throws IOException
  {
    return this.pos;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/file/SeekableByteArrayInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */