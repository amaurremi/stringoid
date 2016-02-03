package com.amazonaws.internal;

import com.amazonaws.AbortedException;
import com.amazonaws.util.SdkRuntime;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class SdkInputStream
  extends InputStream
  implements MetricAware
{
  protected void abort() {}
  
  protected final void abortIfNeeded()
  {
    if (SdkRuntime.shouldAbort()) {
      try
      {
        abort();
        throw new AbortedException();
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          LogFactory.getLog(getClass()).debug("FYI", localIOException);
        }
      }
    }
  }
  
  protected abstract InputStream getWrappedInputStream();
  
  public final boolean isMetricActivated()
  {
    InputStream localInputStream = getWrappedInputStream();
    if ((localInputStream instanceof MetricAware)) {
      return ((MetricAware)localInputStream).isMetricActivated();
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/internal/SdkInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */