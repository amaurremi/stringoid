package com.jirbo.adcolony;

class n$h
{
  String a;
  int b;
  int c;
  boolean d;
  boolean e;
  boolean f;
  double g;
  n.t h;
  n.i i;
  
  boolean a()
  {
    if ((this.i.a) && (!this.i.a())) {}
    do
    {
      return false;
      if (!this.d) {
        return true;
      }
    } while ((!this.h.a()) && (!this.i.a()));
    return true;
  }
  
  boolean a(ADCData.g paramg)
  {
    if (paramg == null) {}
    do
    {
      do
      {
        return false;
        this.d = paramg.h("enabled");
        if (!this.d) {
          return true;
        }
        this.a = paramg.e("uuid");
        this.b = paramg.g("ad_id");
        this.c = paramg.g("ad_campaign_id");
        this.e = paramg.h("dissolve");
        this.f = paramg.h("enable_in_app_store");
        this.g = paramg.f("dissolve_delay");
        this.h = new n.t();
      } while (!this.h.a(paramg.b("static")));
      this.i = new n.i();
    } while (!this.i.a(paramg.b("html5")));
    return true;
  }
  
  void b()
  {
    if (!this.d) {
      return;
    }
    this.h.b();
    this.i.b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/n$h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */