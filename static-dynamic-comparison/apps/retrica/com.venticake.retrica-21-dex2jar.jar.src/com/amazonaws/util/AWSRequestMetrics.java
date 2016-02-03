package com.amazonaws.util;

import com.amazonaws.metrics.MetricType;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class AWSRequestMetrics
{
  protected final TimingInfo timingInfo;
  
  public AWSRequestMetrics()
  {
    this.timingInfo = TimingInfo.startTiming();
  }
  
  protected AWSRequestMetrics(TimingInfo paramTimingInfo)
  {
    this.timingInfo = paramTimingInfo;
  }
  
  public void addProperty(MetricType paramMetricType, Object paramObject) {}
  
  public void addProperty(String paramString, Object paramObject) {}
  
  public void endEvent(MetricType paramMetricType) {}
  
  public void endEvent(String paramString) {}
  
  public final TimingInfo getTimingInfo()
  {
    return this.timingInfo;
  }
  
  public void incrementCounter(MetricType paramMetricType) {}
  
  public void incrementCounter(String paramString) {}
  
  public boolean isEnabled()
  {
    return false;
  }
  
  public void log() {}
  
  public void setCounter(MetricType paramMetricType, long paramLong) {}
  
  public void setCounter(String paramString, long paramLong) {}
  
  public void startEvent(MetricType paramMetricType) {}
  
  public void startEvent(String paramString) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/AWSRequestMetrics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */