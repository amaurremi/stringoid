package com.amazonaws.retry;

import org.apache.http.annotation.Immutable;

@Immutable
public final class RetryPolicy
{
  private final RetryPolicy.BackoffStrategy backoffStrategy;
  private final boolean honorMaxErrorRetryInClientConfig;
  private final int maxErrorRetry;
  private final RetryPolicy.RetryCondition retryCondition;
  
  public RetryPolicy(RetryPolicy.RetryCondition paramRetryCondition, RetryPolicy.BackoffStrategy paramBackoffStrategy, int paramInt, boolean paramBoolean)
  {
    RetryPolicy.RetryCondition localRetryCondition = paramRetryCondition;
    if (paramRetryCondition == null) {
      localRetryCondition = PredefinedRetryPolicies.DEFAULT_RETRY_CONDITION;
    }
    paramRetryCondition = paramBackoffStrategy;
    if (paramBackoffStrategy == null) {
      paramRetryCondition = PredefinedRetryPolicies.DEFAULT_BACKOFF_STRATEGY;
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("Please provide a non-negative value for maxErrorRetry.");
    }
    this.retryCondition = localRetryCondition;
    this.backoffStrategy = paramRetryCondition;
    this.maxErrorRetry = paramInt;
    this.honorMaxErrorRetryInClientConfig = paramBoolean;
  }
  
  public RetryPolicy.BackoffStrategy getBackoffStrategy()
  {
    return this.backoffStrategy;
  }
  
  public int getMaxErrorRetry()
  {
    return this.maxErrorRetry;
  }
  
  public RetryPolicy.RetryCondition getRetryCondition()
  {
    return this.retryCondition;
  }
  
  public boolean isMaxErrorRetryInClientConfigHonored()
  {
    return this.honorMaxErrorRetryInClientConfig;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/retry/RetryPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */