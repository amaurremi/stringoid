package com.amazonaws.auth;

public abstract interface ServiceAwareSigner
  extends Signer
{
  public abstract void setServiceName(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/auth/ServiceAwareSigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */