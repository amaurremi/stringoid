package com.amazonaws.util;

import com.amazonaws.metrics.ServiceMetricType;

public enum AWSServiceMetrics
  implements ServiceMetricType
{
  HttpClientGetConnectionTime("HttpClient");
  
  private final String serviceName;
  
  private AWSServiceMetrics(String paramString)
  {
    this.serviceName = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/AWSServiceMetrics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */