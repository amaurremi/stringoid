package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;

public class SystemPropertiesCredentialsProvider
  implements AWSCredentialsProvider
{
  public AWSCredentials getCredentials()
  {
    if ((System.getProperty("aws.accessKeyId") != null) && (System.getProperty("aws.secretKey") != null)) {
      return new BasicAWSCredentials(System.getProperty("aws.accessKeyId"), System.getProperty("aws.secretKey"));
    }
    throw new AmazonClientException("Unable to load AWS credentials from Java system properties (aws.accessKeyId and aws.secretKey)");
  }
  
  public String toString()
  {
    return getClass().getSimpleName();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/auth/SystemPropertiesCredentialsProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */