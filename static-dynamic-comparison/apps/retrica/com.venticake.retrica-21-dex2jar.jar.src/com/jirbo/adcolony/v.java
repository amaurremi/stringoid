package com.jirbo.adcolony;

class v
{
  d a;
  boolean b;
  boolean c;
  boolean d = false;
  boolean e = false;
  double f;
  double g;
  double h;
  String i = "uuid";
  
  v(d paramd)
  {
    this.a = paramd;
  }
  
  void a() {}
  
  void a(double paramDouble)
  {
    l.a.a("Submitting session duration ").b(paramDouble);
    ADCData.g localg = new ADCData.g();
    localg.b("session_length", (int)paramDouble);
    this.a.d.a("session_end", localg);
  }
  
  void b()
  {
    if (this.a.b.b)
    {
      if (this.d)
      {
        this.d = false;
        this.a.d.a("install", null);
      }
      if (this.e)
      {
        this.e = false;
        this.a.d.a("session_start", null);
      }
    }
  }
  
  void c()
  {
    l.b.b("AdColony resuming");
    a.r = true;
    if (this.b) {
      l.d.b("AdColony.onResume() called multiple times in succession.");
    }
    this.b = true;
    g();
    double d1 = ab.c();
    if (this.c)
    {
      if (d1 - this.g > this.a.a.d)
      {
        a(this.h);
        this.f = d1;
        h();
      }
      this.c = false;
      f();
    }
    for (;;)
    {
      a.h();
      return;
      this.f = d1;
      h();
    }
  }
  
  void d()
  {
    l.b.b("AdColony suspending");
    a.r = true;
    if (!this.b) {
      l.d.b("AdColony.onPause() called without initial call to onResume().");
    }
    this.b = false;
    this.c = true;
    this.g = ab.c();
    f();
  }
  
  void e()
  {
    l.b.b("AdColony terminating");
    a.r = true;
    a(this.h);
    this.c = false;
    f();
  }
  
  void f()
  {
    ADCData.g localg = new ADCData.g();
    localg.b("allow_resume", this.c);
    localg.b("start_time", this.f);
    localg.b("finish_time", this.g);
    localg.b("session_time", this.h);
    k.a(new f("session_info.txt"), localg);
  }
  
  void g()
  {
    ADCData.g localg = k.b(new f("session_info.txt"));
    if (localg != null)
    {
      this.c = localg.h("allow_resume");
      this.f = localg.f("start_time");
      this.g = localg.f("finish_time");
      this.h = localg.f("session_time");
      return;
    }
    this.d = true;
  }
  
  void h()
  {
    this.e = true;
    this.i = ab.b();
    this.h = 0.0D;
    if ((a.l == null) || (a.l.b == null) || (a.l.b.j == null) || (a.l.b.j.n == null)) {}
    for (;;)
    {
      return;
      int j = 0;
      while (j < a.l.b.j.n.a())
      {
        if (a.l.b.j.n.a(j).k != null) {
          a.l.b.j.n.a(j).k.d = 0;
        }
        j += 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */