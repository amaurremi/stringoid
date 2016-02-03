package com.jirbo.adcolony;

class n$aa
{
  boolean a;
  n.w b;
  int c;
  String d;
  boolean e;
  int f;
  
  boolean a(ADCData.g paramg)
  {
    if (paramg == null) {}
    do
    {
      return false;
      this.a = paramg.h("enabled");
      if (!this.a) {
        return true;
      }
      this.b = new n.w();
    } while (!this.b.a(paramg.b("limits")));
    this.c = paramg.g("reward_amount");
    this.d = paramg.e("reward_name");
    this.e = paramg.h("client_side");
    this.f = paramg.g("videos_per_reward");
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/n$aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */