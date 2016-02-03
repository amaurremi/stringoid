package com.amazonaws.internal;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;

public class StaticCredentialsProvider
  implements AWSCredentialsProvider
{
  private final AWSCredentials credentials;
  
  public StaticCredentialsProvider(AWSCredentials paramAWSCredentials)
  {
    this.credentials = paramAWSCredentials;
  }
  
  public AWSCredentials getCredentials()
  {
    return this.credentials;
  }
  
  public void refresh() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/internal/StaticCredentialsProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */