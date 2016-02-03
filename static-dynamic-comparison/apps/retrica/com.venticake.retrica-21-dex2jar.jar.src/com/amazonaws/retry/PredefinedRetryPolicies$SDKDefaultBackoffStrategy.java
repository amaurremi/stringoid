package com.amazonaws.retry;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import java.util.Random;

class PredefinedRetryPolicies$SDKDefaultBackoffStrategy
  implements RetryPolicy.BackoffStrategy
{
  private final Random random = new Random();
  
  public final long delayBeforeNextRetry(AmazonWebServiceRequest paramAmazonWebServiceRequest, AmazonClientException paramAmazonClientException, int paramInt)
  {
    if (paramInt <= 0) {
      return 0L;
    }
    if (((paramAmazonClientException instanceof AmazonServiceException)) && (RetryUtils.isThrottlingException((AmazonServiceException)paramAmazonClientException))) {}
    for (int i = this.random.nextInt(125) + 500;; i = 300) {
      return Math.min(i * (1 << paramInt), 20000L);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/retry/PredefinedRetryPolicies$SDKDefaultBackoffStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */