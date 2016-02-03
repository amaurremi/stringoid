package com.amazonaws.internal.config;

class SignerConfigJsonHelper
  implements Builder<SignerConfig>
{
  private String signerType;
  
  SignerConfigJsonHelper() {}
  
  SignerConfigJsonHelper(String paramString)
  {
    this.signerType = paramString;
  }
  
  public SignerConfig build()
  {
    return new SignerConfig(this.signerType);
  }
  
  public String getSignerType()
  {
    return this.signerType;
  }
  
  void setSignerType(String paramString)
  {
    this.signerType = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/internal/config/SignerConfigJsonHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */