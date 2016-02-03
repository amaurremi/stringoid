package com.inmobi.commons.ads.cache;

public class AdData
{
  private long a;
  private String b;
  private long c;
  private String d;
  private String e;
  
  public long getAdId()
  {
    return this.a;
  }
  
  public String getAdType()
  {
    return this.e;
  }
  
  public String getAppId()
  {
    return this.b;
  }
  
  public String getContent()
  {
    return this.d;
  }
  
  public long getTimestamp()
  {
    return this.c;
  }
  
  public void setAdId(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void setAdType(String paramString)
  {
    this.e = paramString;
  }
  
  public void setAppId(String paramString)
  {
    this.b = paramString;
  }
  
  public void setContent(String paramString)
  {
    this.d = paramString;
  }
  
  public void setTimestamp(long paramLong)
  {
    this.c = paramLong;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/ads/cache/AdData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */