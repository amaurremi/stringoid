package com.jirbo.adcolony;

import java.util.ArrayList;

class n$m
{
  boolean a;
  String b;
  String c;
  
  boolean a()
  {
    if (!this.a) {}
    while (a.l.c.a(this.b)) {
      return true;
    }
    return false;
  }
  
  boolean a(ADCData.g paramg)
  {
    boolean bool = true;
    if (paramg == null) {
      bool = false;
    }
    do
    {
      return bool;
      this.a = paramg.h("enabled");
    } while (!this.a);
    this.b = paramg.e("url");
    a.V.add(this.b);
    this.c = paramg.e("last_modified");
    return true;
  }
  
  void b()
  {
    a.l.c.a(this.b, this.c);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/n$m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */