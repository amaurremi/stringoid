package com.amazonaws.retry;

public class PredefinedRetryPolicies
{
  public static final RetryPolicy DEFAULT = getDefaultRetryPolicy();
  public static final RetryPolicy.BackoffStrategy DEFAULT_BACKOFF_STRATEGY;
  public static final RetryPolicy.RetryCondition DEFAULT_RETRY_CONDITION = new PredefinedRetryPolicies.SDKDefaultRetryCondition();
  public static final RetryPolicy DYNAMODB_DEFAULT = getDynamoDBDefaultRetryPolicy();
  public static final RetryPolicy.BackoffStrategy DYNAMODB_DEFAULT_BACKOFF_STRATEGY;
  
  static
  {
    DEFAULT_BACKOFF_STRATEGY = new PredefinedRetryPolicies.SDKDefaultBackoffStrategy(null);
    DYNAMODB_DEFAULT_BACKOFF_STRATEGY = new PredefinedRetryPolicies.DynamoDBDefaultBackoffStrategy(null);
  }
  
  public static RetryPolicy getDefaultRetryPolicy()
  {
    return new RetryPolicy(DEFAULT_RETRY_CONDITION, DEFAULT_BACKOFF_STRATEGY, 3, true);
  }
  
  public static RetryPolicy getDynamoDBDefaultRetryPolicy()
  {
    return new RetryPolicy(DEFAULT_RETRY_CONDITION, DYNAMODB_DEFAULT_BACKOFF_STRATEGY, 10, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/retry/PredefinedRetryPolicies.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */