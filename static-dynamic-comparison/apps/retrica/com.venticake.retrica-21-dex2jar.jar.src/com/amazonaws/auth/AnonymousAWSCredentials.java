package com.amazonaws.auth;

public class AnonymousAWSCredentials
  implements AWSCredentials
{
  public String getAWSAccessKeyId()
  {
    return null;
  }
  
  public String getAWSSecretKey()
  {
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/auth/AnonymousAWSCredentials.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */