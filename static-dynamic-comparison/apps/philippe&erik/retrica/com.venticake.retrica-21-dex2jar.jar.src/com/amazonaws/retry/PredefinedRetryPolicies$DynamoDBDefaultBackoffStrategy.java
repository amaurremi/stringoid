package com.amazonaws.retry;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceRequest;

class PredefinedRetryPolicies$DynamoDBDefaultBackoffStrategy
  implements RetryPolicy.BackoffStrategy
{
  public final long delayBeforeNextRetry(AmazonWebServiceRequest paramAmazonWebServiceRequest, AmazonClientException paramAmazonClientException, int paramInt)
  {
    if (paramInt <= 0) {
      return 0L;
    }
    return Math.min((1 << paramInt) * 25, 20000L);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/retry/PredefinedRetryPolicies$DynamoDBDefaultBackoffStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */