package com.amazonaws.internal.config;

import org.apache.http.annotation.Immutable;

@Immutable
public class HttpClientConfig
{
  private final String serviceName;
  
  HttpClientConfig(String paramString)
  {
    this.serviceName = paramString;
  }
  
  public String getServiceName()
  {
    return this.serviceName;
  }
  
  public String toString()
  {
    return "serviceName: " + this.serviceName;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/internal/config/HttpClientConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */