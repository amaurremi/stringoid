package com.amazonaws.org.apache.http.impl;

import com.amazonaws.org.apache.http.io.HttpTransportMetrics;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class HttpConnectionMetricsImpl
{
  private final HttpTransportMetrics inTransportMetric;
  private final HttpTransportMetrics outTransportMetric;
  private long requestCount = 0L;
  private long responseCount = 0L;
  
  public HttpConnectionMetricsImpl(HttpTransportMetrics paramHttpTransportMetrics1, HttpTransportMetrics paramHttpTransportMetrics2)
  {
    this.inTransportMetric = paramHttpTransportMetrics1;
    this.outTransportMetric = paramHttpTransportMetrics2;
  }
  
  public void incrementRequestCount()
  {
    this.requestCount += 1L;
  }
  
  public void incrementResponseCount()
  {
    this.responseCount += 1L;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/HttpConnectionMetricsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */