package com.amazonaws.metrics;

public abstract class MetricCollector
{
  public static final MetricCollector NONE = new MetricCollector()
  {
    public RequestMetricCollector getRequestMetricCollector()
    {
      return RequestMetricCollector.NONE;
    }
    
    public ServiceMetricCollector getServiceMetricCollector()
    {
      return ServiceMetricCollector.NONE;
    }
    
    public boolean isEnabled()
    {
      return false;
    }
    
    public boolean stop()
    {
      return true;
    }
  };
  
  public abstract RequestMetricCollector getRequestMetricCollector();
  
  public abstract ServiceMetricCollector getServiceMetricCollector();
  
  public abstract boolean isEnabled();
  
  public abstract boolean stop();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/metrics/MetricCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */