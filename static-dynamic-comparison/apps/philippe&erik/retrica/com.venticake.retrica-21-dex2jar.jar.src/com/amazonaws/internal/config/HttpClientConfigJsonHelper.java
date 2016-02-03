package com.amazonaws.internal.config;

class HttpClientConfigJsonHelper
  implements Builder<HttpClientConfig>
{
  private String serviceName;
  
  HttpClientConfigJsonHelper() {}
  
  HttpClientConfigJsonHelper(String paramString)
  {
    this.serviceName = paramString;
  }
  
  public HttpClientConfig build()
  {
    return new HttpClientConfig(this.serviceName);
  }
  
  public String getServiceName()
  {
    return this.serviceName;
  }
  
  public void setServiceName(String paramString)
  {
    this.serviceName = paramString;
  }
  
  public String toString()
  {
    return "serviceName: " + this.serviceName;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/internal/config/HttpClientConfigJsonHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */