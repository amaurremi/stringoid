package com.jirbo.adcolony;

import java.util.ArrayList;

class n$n
{
  boolean a;
  boolean b;
  String c;
  String d;
  String e;
  String f;
  String g;
  String h;
  String i;
  n.o j;
  n.j k;
  n.j l;
  
  boolean a()
  {
    if (!this.a) {}
    while ((!a.l.c.a(this.c)) || (!a.l.c.a(this.g)) || (!this.k.a()) || (!this.l.a())) {
      return false;
    }
    return true;
  }
  
  boolean a(ADCData.g paramg)
  {
    if (paramg == null) {}
    do
    {
      do
      {
        do
        {
          return false;
          this.a = paramg.h("enabled");
          this.c = paramg.e("poster_image");
          this.d = paramg.e("advertiser_name");
          this.e = paramg.e("description");
          this.f = paramg.e("title");
          this.g = paramg.e("thumb_image");
          this.h = paramg.e("poster_image_last_modified");
          this.i = paramg.e("thumb_image_last_modified");
          a.V.add(this.c);
          a.V.add(this.g);
          this.k = new n.j();
        } while (!this.k.a(paramg.b("mute")));
        this.b = this.k.f;
        this.l = new n.j();
      } while (!this.l.a(paramg.b("unmute")));
      this.j = new n.o();
    } while (!this.j.a(paramg.b("overlay")));
    return true;
  }
  
  void b()
  {
    a.l.c.a(this.c, this.h);
    a.l.c.a(this.g, this.i);
    this.k.b();
    this.l.b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/n$n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */