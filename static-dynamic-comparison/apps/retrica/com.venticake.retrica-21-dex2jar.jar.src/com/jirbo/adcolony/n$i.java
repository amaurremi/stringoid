package com.jirbo.adcolony;

class n$i
{
  boolean a;
  double b;
  boolean c;
  boolean d;
  String e;
  n.m f;
  String g;
  n.j h;
  n.g i;
  n.g j;
  
  boolean a()
  {
    boolean bool2 = false;
    boolean bool1;
    if (!q.c())
    {
      a.Y = 8;
      bool1 = l.c.b("Ad not ready due to no network connection.");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              bool1 = bool2;
            } while (!this.a);
            bool1 = bool2;
          } while (!this.f.a());
          bool1 = bool2;
        } while (!this.h.a());
        bool1 = bool2;
      } while (!this.i.a());
      bool1 = bool2;
    } while (!this.j.a());
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
          do
          {
            return false;
            this.a = paramg.h("enabled");
            this.b = paramg.f("load_timeout");
            this.c = paramg.h("load_timeout_enabled");
            this.d = paramg.h("load_spinner_enabled");
            this.e = paramg.e("background_color");
            this.g = paramg.e("html5_tag");
            this.f = new n.m();
          } while (!this.f.a(paramg.b("mraid_js")));
          this.h = new n.j();
        } while (!this.h.a(paramg.b("background_logo")));
        this.i = new n.g();
      } while (!this.i.a(paramg.b("replay")));
      this.j = new n.g();
    } while (!this.j.a(paramg.b("close")));
    return true;
  }
  
  void b()
  {
    if (!this.a) {}
    do
    {
      return;
      if (this.f != null) {
        this.f.b();
      }
      if (this.h != null) {
        this.h.b();
      }
      if (this.i != null) {
        this.i.b();
      }
    } while (this.j == null);
    this.j.b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/n$i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */