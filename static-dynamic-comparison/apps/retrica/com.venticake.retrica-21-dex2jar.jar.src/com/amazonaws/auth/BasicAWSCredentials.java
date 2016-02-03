package com.amazonaws.auth;

public class BasicAWSCredentials
  implements AWSCredentials
{
  private final String accessKey;
  private final String secretKey;
  
  public BasicAWSCredentials(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Access key cannot be null.");
    }
    if (paramString2 == null) {
      throw new IllegalArgumentException("Secret key cannot be null.");
    }
    this.accessKey = paramString1;
    this.secretKey = paramString2;
  }
  
  public String getAWSAccessKeyId()
  {
    return this.accessKey;
  }
  
  public String getAWSSecretKey()
  {
    return this.secretKey;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/auth/BasicAWSCredentials.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */