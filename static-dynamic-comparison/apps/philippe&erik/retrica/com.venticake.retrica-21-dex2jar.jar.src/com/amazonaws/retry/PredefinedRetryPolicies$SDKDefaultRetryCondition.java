package com.amazonaws.retry;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import java.io.IOException;

public class PredefinedRetryPolicies$SDKDefaultRetryCondition
  implements RetryPolicy.RetryCondition
{
  public boolean shouldRetry(AmazonWebServiceRequest paramAmazonWebServiceRequest, AmazonClientException paramAmazonClientException, int paramInt)
  {
    if ((paramAmazonClientException.getCause() instanceof IOException)) {}
    do
    {
      return true;
      if (!(paramAmazonClientException instanceof AmazonServiceException)) {
        break;
      }
      paramAmazonWebServiceRequest = (AmazonServiceException)paramAmazonClientException;
    } while ((paramAmazonWebServiceRequest.getStatusCode() == 500) || (paramAmazonWebServiceRequest.getStatusCode() == 503) || (RetryUtils.isThrottlingException(paramAmazonWebServiceRequest)) || (RetryUtils.isClockSkewError(paramAmazonWebServiceRequest)));
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/retry/PredefinedRetryPolicies$SDKDefaultRetryCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */