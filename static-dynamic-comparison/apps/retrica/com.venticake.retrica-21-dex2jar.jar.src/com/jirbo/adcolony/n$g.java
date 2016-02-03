package com.jirbo.adcolony;

import java.util.ArrayList;

class n$g
{
  boolean a;
  int b;
  int c;
  int d;
  int e;
  String f;
  String g;
  String h;
  String i;
  String j;
  String k;
  String l;
  String m;
  String n;
  String o;
  String p;
  
  boolean a()
  {
    if (!this.a) {}
    do
    {
      return true;
      if (!a.l.c.a(this.f)) {
        return false;
      }
    } while (a.l.c.a(this.h));
    return false;
  }
  
  boolean a(ADCData.g paramg)
  {
    if (paramg == null) {
      return false;
    }
    this.a = paramg.a("enabled", true);
    this.e = paramg.g("delay");
    this.b = paramg.g("width");
    this.c = paramg.g("height");
    this.d = paramg.g("scale");
    this.f = paramg.e("image_normal");
    this.g = paramg.e("image_normal_last_modified");
    this.h = paramg.e("image_down");
    this.i = paramg.e("image_down_last_modified");
    this.j = paramg.e("click_action");
    this.k = paramg.e("click_action_type");
    this.l = paramg.e("label");
    this.m = paramg.e("label_rgba");
    this.n = paramg.e("label_shadow_rgba");
    this.o = paramg.e("label_html");
    this.p = paramg.e("event");
    a.V.add(this.f);
    a.V.add(this.h);
    return true;
  }
  
  void b()
  {
    a.l.c.a(this.f, this.g);
    a.l.c.a(this.h, this.i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/n$g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */