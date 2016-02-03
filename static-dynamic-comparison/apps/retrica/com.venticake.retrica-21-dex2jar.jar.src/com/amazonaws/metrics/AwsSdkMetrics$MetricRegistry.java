package com.amazonaws.metrics;

import com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazonaws.util.AWSServiceMetrics;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class AwsSdkMetrics$MetricRegistry
{
  private final Set<MetricType> metricTypes = new HashSet();
  private volatile Set<MetricType> readOnly;
  
  AwsSdkMetrics$MetricRegistry()
  {
    this.metricTypes.add(AWSRequestMetrics.Field.ClientExecuteTime);
    this.metricTypes.add(AWSRequestMetrics.Field.Exception);
    this.metricTypes.add(AWSRequestMetrics.Field.HttpClientRetryCount);
    this.metricTypes.add(AWSRequestMetrics.Field.HttpRequestTime);
    this.metricTypes.add(AWSRequestMetrics.Field.RequestCount);
    this.metricTypes.add(AWSRequestMetrics.Field.RetryCount);
    this.metricTypes.add(AWSRequestMetrics.Field.HttpClientSendRequestTime);
    this.metricTypes.add(AWSRequestMetrics.Field.HttpClientReceiveResponseTime);
    this.metricTypes.add(AWSRequestMetrics.Field.HttpClientPoolAvailableCount);
    this.metricTypes.add(AWSRequestMetrics.Field.HttpClientPoolLeasedCount);
    this.metricTypes.add(AWSRequestMetrics.Field.HttpClientPoolPendingCount);
    this.metricTypes.add(AWSServiceMetrics.HttpClientGetConnectionTime);
    syncReadOnly();
  }
  
  private void syncReadOnly()
  {
    this.readOnly = Collections.unmodifiableSet(new HashSet(this.metricTypes));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/metrics/AwsSdkMetrics$MetricRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */