package com.amazonaws.metrics;

import java.util.concurrent.TimeUnit;

class ByteThroughputHelper
  extends ByteThroughputProvider
{
  ByteThroughputHelper(ThroughputMetricType paramThroughputMetricType)
  {
    super(paramThroughputMetricType);
  }
  
  public void increment(int paramInt, long paramLong)
  {
    super.increment(paramInt, paramLong);
  }
  
  void reportMetrics()
  {
    if (getByteCount() > 0)
    {
      AwsSdkMetrics.getServiceMetricCollector().collectByteThroughput(this);
      reset();
    }
  }
  
  long startTiming()
  {
    if (TimeUnit.NANOSECONDS.toSeconds(getDurationNano()) > 10L) {
      reportMetrics();
    }
    return System.nanoTime();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/metrics/ByteThroughputHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */