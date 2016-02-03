package com.inmobi.monetization.internal;

import java.util.HashMap;

public class GetLtvpRulesResponse
{
  private String a;
  private long b;
  private HashMap<String, Integer> c;
  private long d;
  private long e;
  
  public long getHardExpiry()
  {
    return this.e;
  }
  
  public String getRuleId()
  {
    return this.a;
  }
  
  public HashMap<String, Integer> getRules()
  {
    return this.c;
  }
  
  public long getSoftExpiry()
  {
    return this.d;
  }
  
  public long getTimeStamp()
  {
    return this.b;
  }
  
  public void setHardExpiry(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void setRuleId(String paramString)
  {
    this.a = paramString;
  }
  
  public void setRules(HashMap<String, Integer> paramHashMap)
  {
    this.c = paramHashMap;
  }
  
  public void setSoftExpiry(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void setTimeStamp(long paramLong)
  {
    this.b = paramLong;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/monetization/internal/GetLtvpRulesResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */