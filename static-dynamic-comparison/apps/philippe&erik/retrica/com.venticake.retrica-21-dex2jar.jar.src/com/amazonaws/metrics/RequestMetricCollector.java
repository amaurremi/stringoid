package com.amazonaws.metrics;

import com.amazonaws.Request;
import com.amazonaws.Response;

public abstract class RequestMetricCollector
{
  public static final RequestMetricCollector NONE = new RequestMetricCollector()
  {
    public void collectMetrics(Request<?> paramAnonymousRequest, Response<?> paramAnonymousResponse) {}
    
    public boolean isEnabled()
    {
      return false;
    }
  };
  
  public abstract void collectMetrics(Request<?> paramRequest, Response<?> paramResponse);
  
  public boolean isEnabled()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/metrics/RequestMetricCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */