package com.amazonaws.auth;

public class BasicSessionCredentials
  implements AWSSessionCredentials
{
  private final String awsAccessKey;
  private final String awsSecretKey;
  private final String sessionToken;
  
  public BasicSessionCredentials(String paramString1, String paramString2, String paramString3)
  {
    this.awsAccessKey = paramString1;
    this.awsSecretKey = paramString2;
    this.sessionToken = paramString3;
  }
  
  public String getAWSAccessKeyId()
  {
    return this.awsAccessKey;
  }
  
  public String getAWSSecretKey()
  {
    return this.awsSecretKey;
  }
  
  public String getSessionToken()
  {
    return this.sessionToken;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/auth/BasicSessionCredentials.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */