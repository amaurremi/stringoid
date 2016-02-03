package com.amazonaws.handlers;

import com.amazonaws.auth.AWSCredentials;

public abstract class CredentialsRequestHandler
  extends RequestHandler2
{
  protected AWSCredentials awsCredentials;
  
  public void setCredentials(AWSCredentials paramAWSCredentials)
  {
    this.awsCredentials = paramAWSCredentials;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/handlers/CredentialsRequestHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */