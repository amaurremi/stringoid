package com.jirbo.adcolony;

import java.util.ArrayList;

class n$j
{
  int a;
  int b;
  int c;
  String d;
  String e;
  boolean f;
  
  boolean a()
  {
    if (!this.f) {
      return true;
    }
    return a.l.c.a(this.d);
  }
  
  boolean a(ADCData.g paramg)
  {
    if (paramg == null) {
      return false;
    }
    this.f = paramg.a("enabled", true);
    this.a = paramg.g("width");
    this.b = paramg.g("height");
    this.c = paramg.g("scale");
    this.d = paramg.e("image");
    this.e = paramg.e("image_last_modified");
    if (this.e.equals("")) {
      this.e = paramg.e("last_modified");
    }
    a.V.add(this.d);
    return true;
  }
  
  void b()
  {
    a.l.c.a(this.d, this.e);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/n$j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */