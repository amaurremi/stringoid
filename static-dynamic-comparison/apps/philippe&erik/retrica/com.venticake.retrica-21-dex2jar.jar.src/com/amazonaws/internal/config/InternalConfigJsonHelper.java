package com.amazonaws.internal.config;

class InternalConfigJsonHelper
{
  private SignerConfigJsonHelper defaultSigner;
  private JsonIndex<HttpClientConfigJsonHelper, HttpClientConfig>[] httpClients;
  private JsonIndex<SignerConfigJsonHelper, SignerConfig>[] regionSigners;
  private JsonIndex<SignerConfigJsonHelper, SignerConfig>[] serviceRegionSigners;
  private JsonIndex<SignerConfigJsonHelper, SignerConfig>[] serviceSigners;
  
  SignerConfigJsonHelper getDefaultSigner()
  {
    return this.defaultSigner;
  }
  
  public JsonIndex<HttpClientConfigJsonHelper, HttpClientConfig>[] getHttpClients()
  {
    return this.httpClients;
  }
  
  public JsonIndex<SignerConfigJsonHelper, SignerConfig>[] getRegionSigners()
  {
    return this.regionSigners;
  }
  
  public JsonIndex<SignerConfigJsonHelper, SignerConfig>[] getServiceRegionSigners()
  {
    return this.serviceRegionSigners;
  }
  
  public JsonIndex<SignerConfigJsonHelper, SignerConfig>[] getServiceSigners()
  {
    return this.serviceSigners;
  }
  
  void setDefaultSigner(SignerConfigJsonHelper paramSignerConfigJsonHelper)
  {
    this.defaultSigner = paramSignerConfigJsonHelper;
  }
  
  public void setHttpClients(JsonIndex<HttpClientConfigJsonHelper, HttpClientConfig>... paramVarArgs)
  {
    this.httpClients = paramVarArgs;
  }
  
  void setRegionSigners(JsonIndex<SignerConfigJsonHelper, SignerConfig>... paramVarArgs)
  {
    this.regionSigners = paramVarArgs;
  }
  
  void setServiceRegionSigners(JsonIndex<SignerConfigJsonHelper, SignerConfig>... paramVarArgs)
  {
    this.serviceRegionSigners = paramVarArgs;
  }
  
  void setServiceSigners(JsonIndex<SignerConfigJsonHelper, SignerConfig>... paramVarArgs)
  {
    this.serviceSigners = paramVarArgs;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/internal/config/InternalConfigJsonHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */