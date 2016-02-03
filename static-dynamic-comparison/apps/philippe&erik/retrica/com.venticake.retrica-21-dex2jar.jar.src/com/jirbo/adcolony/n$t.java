package com.jirbo.adcolony;

class n$t
{
  boolean a;
  int b;
  int c;
  String d;
  String e;
  n.g f;
  n.g g;
  n.g h;
  n.g i;
  
  boolean a()
  {
    if (!this.a) {}
    do
    {
      return true;
      if (!a.l.c.a(this.d)) {
        return false;
      }
      if (!this.h.a()) {
        return false;
      }
      if (!this.i.a()) {
        return false;
      }
      if (!this.g.a()) {
        return false;
      }
    } while (this.f.a());
    return false;
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
          do
          {
            return false;
            this.a = paramg.h("enabled");
            if (!this.a) {
              return true;
            }
            this.b = paramg.g("width");
            this.c = paramg.g("height");
            this.d = paramg.e("background_image");
            this.e = paramg.e("background_image_last_modified");
            if (a.f != null) {
              this.d = a.f;
            }
            this.h = new n.g();
          } while (!this.h.a(paramg.b("replay")));
          this.i = new n.g();
        } while (!this.i.a(paramg.b("continue")));
        this.g = new n.g();
      } while (!this.g.a(paramg.b("download")));
      this.f = new n.g();
    } while (!this.f.a(paramg.b("info")));
    return true;
  }
  
  void b()
  {
    if (!this.a) {
      return;
    }
    a.l.c.a(this.d, this.e);
    this.h.b();
    this.i.b();
    this.g.b();
    this.f.b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/n$t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */