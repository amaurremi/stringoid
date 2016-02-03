package com.jirbo.adcolony;

import java.util.ArrayList;

class n$p
{
  int a;
  String b;
  int c;
  int d;
  String e;
  String f;
  String g;
  String h;
  String i;
  String j;
  String k;
  n.j l;
  n.g m;
  
  boolean a()
  {
    if (!a.l.c.a(this.e)) {}
    while ((!this.l.a()) || (!this.m.a())) {
      return false;
    }
    return true;
  }
  
  boolean a(ADCData.g paramg)
  {
    this.a = paramg.g("scale");
    this.b = paramg.e("label_reward");
    this.c = paramg.g("width");
    this.d = paramg.g("height");
    this.e = paramg.e("image");
    this.f = paramg.e("image_last_modified");
    this.g = paramg.e("label");
    this.h = paramg.e("label_rgba");
    this.i = paramg.e("label_shadow_rgba");
    this.j = paramg.e("label_fraction");
    this.k = paramg.e("label_html");
    a.V.add(this.e);
    this.l = new n.j();
    if (!this.l.a(paramg.b("logo"))) {}
    do
    {
      return false;
      this.m = new n.g();
    } while (!this.m.a(paramg.b("option_done")));
    return true;
  }
  
  void b()
  {
    a.l.c.a(this.e, this.f);
    this.l.b();
    this.m.b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/n$p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */