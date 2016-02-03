package com.flurry.org.apache.avro.file;

import java.io.Closeable;
import java.io.IOException;

public abstract interface SeekableInput
  extends Closeable
{
  public abstract long length()
    throws IOException;
  
  public abstract int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void seek(long paramLong)
    throws IOException;
  
  public abstract long tell()
    throws IOException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/file/SeekableInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */