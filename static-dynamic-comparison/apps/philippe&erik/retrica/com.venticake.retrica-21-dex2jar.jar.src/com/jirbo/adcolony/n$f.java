package com.jirbo.adcolony;

import java.util.ArrayList;

class n$f
{
  String a;
  String b;
  String c;
  String d;
  String e;
  String f;
  String g;
  ADCData.g h;
  
  boolean a(ADCData.g paramg)
  {
    if (paramg == null) {
      return true;
    }
    this.a = paramg.a("update", null);
    this.b = paramg.a("install", null);
    this.c = paramg.a("dynamic_interests", null);
    this.d = paramg.a("user_meta_data", null);
    this.e = paramg.a("in_app_purchase", null);
    this.g = paramg.a("session_end", null);
    this.f = paramg.a("session_start", null);
    a.V.add(this.a);
    a.V.add(this.b);
    a.V.add(this.c);
    a.V.add(this.d);
    a.V.add(this.e);
    a.V.add(this.g);
    a.V.add(this.f);
    this.h = new ADCData.g();
    this.h.b("update", this.a);
    this.h.b("install", this.b);
    this.h.b("dynamic_interests", this.c);
    this.h.b("user_meta_data", this.d);
    this.h.b("in_app_purchase", this.e);
    this.h.b("session_end", this.g);
    this.h.b("session_start", this.f);
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/n$f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */