package com.amazonaws.auth;

public abstract interface AWSSessionCredentials
  extends AWSCredentials
{
  public abstract String getSessionToken();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/auth/AWSSessionCredentials.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */