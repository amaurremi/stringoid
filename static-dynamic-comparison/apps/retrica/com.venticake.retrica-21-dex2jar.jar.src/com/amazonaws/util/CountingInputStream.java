package com.amazonaws.util;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.InputStream;

public class CountingInputStream
  extends SdkFilterInputStream
{
  private long byteCount = 0L;
  
  public CountingInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public long getByteCount()
  {
    return this.byteCount;
  }
  
  public int read()
  {
    int i = super.read();
    long l2 = this.byteCount;
    if (i >= 0) {}
    for (long l1 = 1L;; l1 = 0L)
    {
      this.byteCount = (l1 + l2);
      return i;
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    long l2 = this.byteCount;
    if (paramInt1 >= 0) {}
    for (long l1 = paramInt1;; l1 = 0L)
    {
      this.byteCount = (l1 + l2);
      return paramInt1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/CountingInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */