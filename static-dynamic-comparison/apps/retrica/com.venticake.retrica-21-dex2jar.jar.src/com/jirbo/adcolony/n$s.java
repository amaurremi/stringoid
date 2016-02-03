package com.jirbo.adcolony;

class n$s
{
  String a;
  String b;
  n.j c;
  n.r d;
  
  boolean a()
  {
    if (!a.l.c.a(this.a)) {}
    while ((!this.c.a()) || (!this.d.a())) {
      return false;
    }
    return true;
  }
  
  boolean a(ADCData.g paramg)
  {
    this.a = paramg.e("background_image");
    this.b = paramg.e("background_image_last_modified");
    this.c = new n.j();
    if (!this.c.a(paramg.b("background_logo"))) {}
    do
    {
      return false;
      this.d = new n.r();
    } while (!this.d.a(paramg.b("dialog")));
    return true;
  }
  
  void b()
  {
    a.l.c.a(this.a, this.b);
    this.c.b();
    this.d.b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/n$s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */