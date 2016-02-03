package com.jirbo.adcolony;

class n$o
{
  boolean a;
  boolean b;
  String c;
  String d;
  String e;
  
  boolean a(ADCData.g paramg)
  {
    if (paramg == null) {
      return false;
    }
    this.a = paramg.h("enabled");
    this.b = paramg.h("in_app");
    this.c = paramg.e("click_action_type");
    this.e = paramg.e("click_action");
    this.d = paramg.e("label");
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/n$o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */