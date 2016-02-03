package com.inmobi.monetization.internal;

public class LtvpErrorCode
{
  int a;
  String b;
  
  public LtvpErrorCode(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public int getCode()
  {
    return this.a;
  }
  
  public String getMessage()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/monetization/internal/LtvpErrorCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */