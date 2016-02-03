package com.amazonaws.metrics;

public abstract class ServiceMetricCollector
{
  public static final ServiceMetricCollector NONE = new ServiceMetricCollector()
  {
    public void collectByteThroughput(ByteThroughputProvider paramAnonymousByteThroughputProvider) {}
    
    public void collectLatency(ServiceLatencyProvider paramAnonymousServiceLatencyProvider) {}
  };
  
  public abstract void collectByteThroughput(ByteThroughputProvider paramByteThroughputProvider);
  
  public abstract void collectLatency(ServiceLatencyProvider paramServiceLatencyProvider);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/metrics/ServiceMetricCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */