package com.amazonaws.auth;

public class DefaultAWSCredentialsProviderChain
  extends AWSCredentialsProviderChain
{
  public DefaultAWSCredentialsProviderChain()
  {
    super(new AWSCredentialsProvider[] { new SystemPropertiesCredentialsProvider(), new ClasspathPropertiesFileCredentialsProvider() });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/auth/DefaultAWSCredentialsProviderChain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */