package com.amazonaws.metrics.internal;

import com.amazonaws.Request;
import com.amazonaws.metrics.AwsSdkMetrics;
import com.amazonaws.metrics.SimpleThroughputMetricType;
import com.amazonaws.metrics.ThroughputMetricType;

public enum ServiceMetricTypeGuesser
{
  public static ThroughputMetricType guessThroughputMetricType(Request<?> paramRequest, String paramString1, String paramString2)
  {
    if (!AwsSdkMetrics.isMetricsEnabled()) {}
    while (!paramRequest.getOriginalRequest().getClass().getName().startsWith("com.amazonaws.services.s3")) {
      return null;
    }
    return new SimpleThroughputMetricType("S3" + paramString1, paramRequest.getServiceName(), "S3" + paramString2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/metrics/internal/ServiceMetricTypeGuesser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */