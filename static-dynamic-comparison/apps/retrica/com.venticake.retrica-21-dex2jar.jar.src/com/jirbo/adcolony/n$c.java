package com.jirbo.adcolony;

class n$c
{
  boolean a;
  n.s b;
  n.q c;
  
  boolean a()
  {
    if (!this.b.a()) {}
    while (!this.c.a()) {
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
        return false;
        this.a = paramg.h("enabled");
        if (!this.a) {
          return true;
        }
        this.b = new n.s();
      } while (!this.b.a(paramg.b("pre_popup")));
      this.c = new n.q();
    } while (!this.c.a(paramg.b("post_popup")));
    return true;
  }
  
  void b()
  {
    if (!this.a) {
      return;
    }
    this.b.b();
    this.c.b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/n$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */