package com.amazonaws.internal;

import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

public class SdkDigestInputStream
  extends DigestInputStream
  implements MetricAware
{
  private static final int SKIP_BUF_SIZE = 2048;
  
  static
  {
    if (!SdkDigestInputStream.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SdkDigestInputStream(InputStream paramInputStream, MessageDigest paramMessageDigest)
  {
    super(paramInputStream, paramMessageDigest);
  }
  
  public final boolean isMetricActivated()
  {
    if ((this.in instanceof MetricAware)) {
      return ((MetricAware)this.in).isMetricActivated();
    }
    return false;
  }
  
  public final long skip(long paramLong)
  {
    if (paramLong <= 0L) {}
    long l;
    do
    {
      return paramLong;
      byte[] arrayOfByte = new byte[(int)Math.min(2048L, paramLong)];
      int i;
      for (l = paramLong; l > 0L; l -= i)
      {
        i = read(arrayOfByte, 0, (int)Math.min(l, arrayOfByte.length));
        if (i == -1)
        {
          if (l == paramLong) {}
          for (paramLong = -1L;; paramLong -= l) {
            return paramLong;
          }
        }
      }
    } while (($assertionsDisabled) || (l == 0L));
    throw new AssertionError();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/internal/SdkDigestInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */