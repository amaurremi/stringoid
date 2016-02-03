package com.amazonaws.internal.config;

import org.apache.http.annotation.Immutable;

@Immutable
public class SignerConfig
{
  private final String signerType;
  
  SignerConfig(SignerConfig paramSignerConfig)
  {
    this.signerType = paramSignerConfig.getSignerType();
  }
  
  SignerConfig(String paramString)
  {
    this.signerType = paramString;
  }
  
  public String getSignerType()
  {
    return this.signerType;
  }
  
  public String toString()
  {
    return this.signerType;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/internal/config/SignerConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */