package com.google.api.client.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class f
{
  public static int a(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    x.ad(paramInputStream);
    x.ad(paramArrayOfByte);
    if (paramInt2 < 0) {
      throw new IndexOutOfBoundsException("len is negative");
    }
    int i = 0;
    for (;;)
    {
      int j;
      if (i < paramInt2)
      {
        j = paramInputStream.read(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
        if (j != -1) {}
      }
      else
      {
        return i;
      }
      i += j;
    }
  }
  
  public static long a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    x.ad(paramInputStream);
    x.ad(paramOutputStream);
    byte[] arrayOfByte = new byte['က'];
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        return l;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static InputStream a(InputStream paramInputStream, long paramLong)
  {
    return new a(paramInputStream, paramLong);
  }
  
  private static final class a
    extends FilterInputStream
  {
    private long ada;
    private long adb = -1L;
    
    a(InputStream paramInputStream, long paramLong)
    {
      super();
      x.ad(paramInputStream);
      if (paramLong >= 0L) {}
      for (boolean bool = true;; bool = false)
      {
        x.d(bool, "limit must be non-negative");
        this.ada = paramLong;
        return;
      }
    }
    
    public int available()
    {
      return (int)Math.min(this.in.available(), this.ada);
    }
    
    public void mark(int paramInt)
    {
      try
      {
        this.in.mark(paramInt);
        this.adb = this.ada;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public int read()
    {
      if (this.ada == 0L) {
        return -1;
      }
      int i = this.in.read();
      if (i != -1) {
        this.ada -= 1L;
      }
      return i;
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (this.ada == 0L) {
        return -1;
      }
      paramInt2 = (int)Math.min(paramInt2, this.ada);
      paramInt1 = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 != -1) {
        this.ada -= paramInt1;
      }
      return paramInt1;
    }
    
    public void reset()
    {
      try
      {
        if (!this.in.markSupported()) {
          throw new IOException("Mark not supported");
        }
      }
      finally {}
      if (this.adb == -1L) {
        throw new IOException("Mark not set");
      }
      this.in.reset();
      this.ada = this.adb;
    }
    
    public long skip(long paramLong)
    {
      paramLong = Math.min(paramLong, this.ada);
      paramLong = this.in.skip(paramLong);
      this.ada -= paramLong;
      return paramLong;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/util/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */