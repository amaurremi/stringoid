package com.jirbo.adcolony;

public class AdColonyV4VCReward
{
  boolean a;
  String b;
  int c;
  
  AdColonyV4VCReward(boolean paramBoolean, String paramString, int paramInt)
  {
    this.a = paramBoolean;
    this.b = paramString;
    this.c = paramInt;
  }
  
  public int amount()
  {
    return this.c;
  }
  
  public String name()
  {
    return this.b;
  }
  
  public boolean success()
  {
    return this.a;
  }
  
  public String toString()
  {
    if (this.a) {
      return this.b + ":" + this.c;
    }
    return "no reward";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/AdColonyV4VCReward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */