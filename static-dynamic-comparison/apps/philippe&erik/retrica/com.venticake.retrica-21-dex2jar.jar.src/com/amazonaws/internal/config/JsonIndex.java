package com.amazonaws.internal.config;

final class JsonIndex<C extends Builder<T>, T>
{
  private C config;
  private String key;
  
  JsonIndex() {}
  
  JsonIndex(String paramString)
  {
    this.key = paramString;
  }
  
  JsonIndex(String paramString, C paramC)
  {
    this.key = paramString;
    this.config = paramC;
  }
  
  public C getConfig()
  {
    return this.config;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  T newReadOnlyConfig()
  {
    return (T)this.config.build();
  }
  
  void setKey(String paramString)
  {
    this.key = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/internal/config/JsonIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */