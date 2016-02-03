package com.amazonaws.metrics;

import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class ServiceLatencyProvider
{
  private long endNano = this.startNano;
  private final ServiceMetricType serviceMetricType;
  private final long startNano = System.nanoTime();
  
  public ServiceLatencyProvider(ServiceMetricType paramServiceMetricType)
  {
    this.serviceMetricType = paramServiceMetricType;
  }
  
  public ServiceLatencyProvider endTiming()
  {
    if (this.endNano != this.startNano) {
      throw new IllegalStateException();
    }
    this.endNano = System.nanoTime();
    return this;
  }
  
  public String getProviderId()
  {
    return super.toString();
  }
  
  public String toString()
  {
    return String.format("providerId=%s, serviceMetricType=%s, startNano=%d, endNano=%d", new Object[] { getProviderId(), this.serviceMetricType, Long.valueOf(this.startNano), Long.valueOf(this.endNano) });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/metrics/ServiceLatencyProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */