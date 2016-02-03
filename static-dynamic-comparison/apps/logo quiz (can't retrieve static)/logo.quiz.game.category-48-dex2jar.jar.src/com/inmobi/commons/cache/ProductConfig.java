package com.inmobi.commons.cache;

public abstract class ProductConfig
{
  protected String data = null;
  protected int expiry = 0;
  protected int maxRetry = 3;
  protected String protocol = null;
  protected int retryInterval = 10;
  protected int retryNumber = 0;
  protected boolean sendUidMap = true;
  protected int timestamp = -1;
  protected String url = null;
  
  public String getData()
  {
    return this.data;
  }
  
  public int getExpiry()
  {
    return this.expiry;
  }
  
  public int getMaxRetry()
  {
    return this.maxRetry;
  }
  
  public String getProtocol()
  {
    return this.protocol;
  }
  
  public int getTimestamp()
  {
    return this.timestamp;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public boolean isSendUidMap()
  {
    return this.sendUidMap;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/commons/cache/ProductConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */