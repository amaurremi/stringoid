package com.jirbo.adcolony;

import java.util.ArrayList;

class n$e
{
  boolean a;
  boolean b;
  String c;
  String d;
  boolean e = false;
  boolean f;
  double g;
  String h;
  String i;
  String j;
  n.f k;
  n.u l;
  ArrayList<String> m;
  n.ab n;
  
  void a()
  {
    l.a.b("Caching media");
    if (!this.a) {}
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < this.n.a())
      {
        this.n.a(i1).l();
        i1 += 1;
      }
    }
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
          this.b = paramg.h("log_screen_overlay");
          this.c = paramg.e("last_country");
          this.d = paramg.e("last_ip");
          this.f = paramg.h("collect_iap_enabled");
          this.g = paramg.f("media_pool_size");
          this.h = paramg.e("log_level");
          this.i = paramg.e("view_network_pass_filter");
          this.j = paramg.e("cache_network_pass_filter");
          this.e = paramg.h("hardware_acceleration_disabled");
          if ((this.i == null) || (this.i.equals(""))) {
            this.i = "all";
          }
          if ((this.j == null) || (this.j.equals(""))) {
            this.j = "all";
          }
          this.k = new n.f();
        } while (!this.k.a(paramg.b("tracking")));
        this.l = new n.u();
      } while (!this.l.a(paramg.b("third_party_tracking")));
      this.m = paramg.d("console_messages");
      l.a.b("Parsing zones");
      this.n = new n.ab();
    } while (!this.n.a(paramg.c("zones")));
    l.a.b("Finished parsing app info");
    return true;
  }
  
  boolean a(String paramString)
  {
    return a(paramString, false, true);
  }
  
  boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.a) {}
    do
    {
      return false;
      paramString = this.n.a(paramString);
    } while (paramString == null);
    return paramString.a(paramBoolean1, paramBoolean2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/n$e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */