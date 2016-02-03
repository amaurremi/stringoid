package com.jirbo.adcolony;

class n$l
{
  int a;
  int b;
  int c;
  int d;
  int e;
  int f;
  int g;
  int h;
  
  boolean a(ADCData.g paramg)
  {
    if (paramg == null) {
      return false;
    }
    this.a = paramg.g("daily_play_cap");
    this.b = paramg.g("custom_play_cap");
    this.c = paramg.g("custom_play_cap_period");
    this.d = paramg.g("total_play_cap");
    this.e = paramg.g("monthly_play_cap");
    this.f = paramg.g("weekly_play_cap");
    this.g = paramg.g("volatile_expiration");
    this.h = paramg.g("volatile_play_cap");
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/n$l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */