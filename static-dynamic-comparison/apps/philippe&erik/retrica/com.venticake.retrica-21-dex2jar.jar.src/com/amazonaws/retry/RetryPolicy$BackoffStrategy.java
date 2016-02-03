package com.amazonaws.retry;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceRequest;

public abstract interface RetryPolicy$BackoffStrategy
{
  public abstract long delayBeforeNextRetry(AmazonWebServiceRequest paramAmazonWebServiceRequest, AmazonClientException paramAmazonClientException, int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/retry/RetryPolicy$BackoffStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */