package com.amazonaws.internal;

import com.amazonaws.AbortedException;
import com.amazonaws.util.SdkRuntime;
import java.io.FilterInputStream;
import java.io.InputStream;

public class SdkFilterInputStream
  extends FilterInputStream
  implements MetricAware
{
  protected SdkFilterInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  protected void abort() {}
  
  protected final void abortIfNeeded()
  {
    if (SdkRuntime.shouldAbort())
    {
      abort();
      throw new AbortedException();
    }
  }
  
  public int available()
  {
    abortIfNeeded();
    return this.in.available();
  }
  
  public void close()
  {
    this.in.close();
    abortIfNeeded();
  }
  
  public boolean isMetricActivated()
  {
    if ((this.in instanceof MetricAware)) {
      return ((MetricAware)this.in).isMetricActivated();
    }
    return false;
  }
  
  public void mark(int paramInt)
  {
    try
    {
      abortIfNeeded();
      this.in.mark(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean markSupported()
  {
    abortIfNeeded();
    return this.in.markSupported();
  }
  
  public int read()
  {
    abortIfNeeded();
    return this.in.read();
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    abortIfNeeded();
    return this.in.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void reset()
  {
    try
    {
      abortIfNeeded();
      this.in.reset();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long skip(long paramLong)
  {
    abortIfNeeded();
    return this.in.skip(paramLong);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/internal/SdkFilterInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */