package com.amazonaws.internal;

import java.io.FilterOutputStream;
import java.io.OutputStream;

public class SdkFilterOutputStream
  extends FilterOutputStream
  implements MetricAware
{
  public SdkFilterOutputStream(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  public boolean isMetricActivated()
  {
    if ((this.out instanceof MetricAware)) {
      return ((MetricAware)this.out).isMetricActivated();
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/internal/SdkFilterOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */