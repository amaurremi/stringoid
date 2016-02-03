package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import java.io.IOException;
import java.io.InputStream;

public class ClasspathPropertiesFileCredentialsProvider
  implements AWSCredentialsProvider
{
  private static String DEFAULT_PROPERTIES_FILE = "AwsCredentials.properties";
  private final String credentialsFilePath;
  
  public ClasspathPropertiesFileCredentialsProvider()
  {
    this(DEFAULT_PROPERTIES_FILE);
  }
  
  public ClasspathPropertiesFileCredentialsProvider(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Credentials file path cannot be null");
    }
    if (!paramString.startsWith("/"))
    {
      this.credentialsFilePath = ("/" + paramString);
      return;
    }
    this.credentialsFilePath = paramString;
  }
  
  public AWSCredentials getCredentials()
  {
    Object localObject = getClass().getResourceAsStream(this.credentialsFilePath);
    if (localObject == null) {
      throw new AmazonClientException("Unable to load AWS credentials from the " + this.credentialsFilePath + " file on the classpath");
    }
    try
    {
      localObject = new PropertiesCredentials((InputStream)localObject);
      return (AWSCredentials)localObject;
    }
    catch (IOException localIOException)
    {
      throw new AmazonClientException("Unable to load AWS credentials from the " + this.credentialsFilePath + " file on the classpath", localIOException);
    }
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + "(" + this.credentialsFilePath + ")";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/auth/ClasspathPropertiesFileCredentialsProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */