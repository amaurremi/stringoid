package com.inmobi.monetization;

public enum IMErrorCode
{
  private String a;
  
  static
  {
    INTERNAL_ERROR = new IMErrorCode("INTERNAL_ERROR", 1, "An error occurred while fetching the ad");
    NO_FILL = new IMErrorCode("NO_FILL", 2, "The ad request was successful, but no ad was returned");
  }
  
  private IMErrorCode(String paramString)
  {
    this.a = paramString;
  }
  
  public void setMessage(String paramString)
  {
    this.a = paramString;
  }
  
  public String toString()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/monetization/IMErrorCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */