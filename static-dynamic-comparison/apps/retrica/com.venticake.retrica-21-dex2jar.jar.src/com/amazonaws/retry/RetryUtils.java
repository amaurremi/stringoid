package com.amazonaws.retry;

import com.amazonaws.AmazonServiceException;

public class RetryUtils
{
  public static boolean isClockSkewError(AmazonServiceException paramAmazonServiceException)
  {
    if (paramAmazonServiceException == null) {}
    do
    {
      return false;
      paramAmazonServiceException = paramAmazonServiceException.getErrorCode();
    } while ((!"RequestTimeTooSkewed".equals(paramAmazonServiceException)) && (!"RequestExpired".equals(paramAmazonServiceException)) && (!"InvalidSignatureException".equals(paramAmazonServiceException)) && (!"SignatureDoesNotMatch".equals(paramAmazonServiceException)));
    return true;
  }
  
  public static boolean isThrottlingException(AmazonServiceException paramAmazonServiceException)
  {
    if (paramAmazonServiceException == null) {}
    do
    {
      return false;
      paramAmazonServiceException = paramAmazonServiceException.getErrorCode();
    } while ((!"Throttling".equals(paramAmazonServiceException)) && (!"ThrottlingException".equals(paramAmazonServiceException)) && (!"ProvisionedThroughputExceededException".equals(paramAmazonServiceException)));
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/retry/RetryUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */