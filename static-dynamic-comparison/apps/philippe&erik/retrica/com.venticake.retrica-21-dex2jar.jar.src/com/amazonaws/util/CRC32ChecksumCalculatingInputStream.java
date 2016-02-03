package com.amazonaws.util;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.InputStream;
import java.util.zip.CRC32;

public class CRC32ChecksumCalculatingInputStream
  extends SdkFilterInputStream
{
  private CRC32 crc32 = new CRC32();
  
  public CRC32ChecksumCalculatingInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public long getCRC32Checksum()
  {
    return this.crc32.getValue();
  }
  
  public int read()
  {
    abortIfNeeded();
    int i = this.in.read();
    if (i != -1) {
      this.crc32.update(i);
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    abortIfNeeded();
    paramInt2 = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt2 != -1) {
      this.crc32.update(paramArrayOfByte, paramInt1, paramInt2);
    }
    return paramInt2;
  }
  
  public void reset()
  {
    try
    {
      abortIfNeeded();
      this.crc32.reset();
      this.in.reset();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/CRC32ChecksumCalculatingInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */