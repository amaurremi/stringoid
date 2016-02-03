package com.amazonaws.metrics;

import com.amazonaws.internal.MetricAware;
import com.amazonaws.org.apache.http.entity.InputStreamEntity;
import java.io.InputStream;
import java.io.OutputStream;

public class MetricInputStreamEntity
  extends InputStreamEntity
{
  private final ByteThroughputHelper helper;
  
  public MetricInputStreamEntity(ThroughputMetricType paramThroughputMetricType, InputStream paramInputStream, long paramLong)
  {
    super(paramInputStream, paramLong);
    this.helper = new ByteThroughputHelper(paramThroughputMetricType);
  }
  
  private void writeToWithMetrics(OutputStream paramOutputStream)
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("Output stream may not be null");
    }
    InputStream localInputStream = getContent();
    long l2 = getContentLength();
    byte[] arrayOfByte;
    long l1;
    int i;
    try
    {
      arrayOfByte = new byte['ࠀ'];
      l1 = l2;
      if (l2 < 0L)
      {
        for (;;)
        {
          i = localInputStream.read(arrayOfByte);
          if (i == -1) {
            break;
          }
          l1 = this.helper.startTiming();
          paramOutputStream.write(arrayOfByte, 0, i);
          this.helper.increment(i, l1);
        }
        l2 = this.helper.startTiming();
      }
    }
    finally
    {
      this.helper.reportMetrics();
      localInputStream.close();
    }
    do
    {
      paramOutputStream.write(arrayOfByte, 0, i);
      this.helper.increment(i, l2);
      l1 -= i;
      if (l1 <= 0L) {
        break;
      }
      i = localInputStream.read(arrayOfByte, 0, (int)Math.min(2048L, l1));
    } while (i != -1);
    this.helper.reportMetrics();
    localInputStream.close();
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    if (((paramOutputStream instanceof MetricAware)) && (((MetricAware)paramOutputStream).isMetricActivated()))
    {
      super.writeTo(paramOutputStream);
      return;
    }
    writeToWithMetrics(paramOutputStream);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/metrics/MetricInputStreamEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */