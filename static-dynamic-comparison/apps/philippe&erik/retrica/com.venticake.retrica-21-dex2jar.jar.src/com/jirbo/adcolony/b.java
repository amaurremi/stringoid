package com.jirbo.adcolony;

import android.os.Handler;

class b
  implements ADCDownload.Listener
{
  d a;
  boolean b;
  boolean c;
  boolean d;
  boolean e = true;
  boolean f = false;
  double g;
  Handler h;
  Runnable i;
  n.e j = new n.e();
  
  b(d paramd)
  {
    this.a = paramd;
    this.h = new Handler();
    this.i = new Runnable()
    {
      public void run()
      {
        b.this.e = true;
        if (b.this.f) {
          b.this.e();
        }
      }
    };
  }
  
  void a() {}
  
  boolean a(ADCData.g paramg)
  {
    if (paramg == null) {}
    while ((!paramg.e("status").equals("success")) || (!this.j.a(paramg.b("app")))) {
      return false;
    }
    l.a.b("Finished parsing manifest");
    if (!this.j.h.equalsIgnoreCase("none"))
    {
      l.c.b("Enabling debug logging.");
      a.a(1);
    }
    for (;;)
    {
      return true;
      a.a(2);
    }
  }
  
  boolean a(String paramString)
  {
    return a(paramString, true);
  }
  
  boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool2 = false;
    int k = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (k < this.j.n.a())
      {
        n.y localy = this.j.n.a(k);
        if ((localy.c(paramBoolean)) && (localy.a.equals(paramString))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      k += 1;
    }
  }
  
  void b()
  {
    l.b.b("Attempting to load backup manifest from file.");
    f localf = new f("manifest.txt");
    ADCData.g localg = k.b(localf);
    if (localg != null)
    {
      if (a(localg))
      {
        this.b = true;
        this.j.a();
      }
    }
    else {
      return;
    }
    l.b.b("Invalid manifest loaded.");
    localf.c();
    this.b = false;
  }
  
  boolean b(String paramString)
  {
    return b(paramString, false);
  }
  
  boolean b(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return c(paramString, paramBoolean);
    }
    if (!this.b) {
      return l.c.b("Ads are not ready to be played, as they are still downloading.");
    }
    if (paramBoolean) {
      return this.j.a(paramString, true, false);
    }
    return this.j.a(paramString, false, true);
  }
  
  String c()
  {
    if (!this.b) {
      return null;
    }
    String str = null;
    int k = 0;
    while (k < this.j.n.a())
    {
      n.y localy = this.j.n.a(k);
      if (localy.e())
      {
        str = localy.a;
        if (localy.a()) {
          return localy.a;
        }
      }
      k += 1;
    }
    return str;
  }
  
  boolean c(String paramString, boolean paramBoolean)
  {
    if (!this.b) {
      return false;
    }
    if (paramBoolean) {
      return this.j.a(paramString, true, false);
    }
    return this.j.a(paramString, false, true);
  }
  
  String d()
  {
    if (!this.b) {
      return null;
    }
    String str = null;
    int k = 0;
    while (k < this.j.n.a())
    {
      n.y localy = this.j.n.a(k);
      if (localy.g())
      {
        str = localy.a;
        if (localy.a()) {
          return localy.a;
        }
      }
      k += 1;
    }
    return str;
  }
  
  void e()
  {
    if ((this.e) || (a.z))
    {
      this.e = false;
      this.c = true;
      this.f = false;
      this.h.postDelayed(this.i, 60000L);
      return;
    }
    this.f = true;
  }
  
  void f()
  {
    if (ab.c() >= this.g) {
      this.c = true;
    }
    if (this.c)
    {
      this.c = false;
      if (g.c() >= 32)
      {
        this.g = (ab.c() + 600.0D);
        g();
      }
    }
    if (!q.c())
    {
      if (a.C) {
        a.h();
      }
      a.C = false;
      return;
    }
    if (!a.C) {
      a.h();
    }
    a.C = true;
  }
  
  void g()
  {
    int m = 1;
    a.r = true;
    l.b.b("Refreshing manifest");
    if (!q.c())
    {
      l.b.b("Not connected to network.");
      l.a.a("attempted_load:").a(this.d).a(" is_configured:").b(this.b);
      if (!this.d)
      {
        this.d = true;
        if (!this.b) {
          b();
        }
      }
      return;
    }
    z localz = new z();
    Object localObject = this.a.a;
    localz.a(c.c);
    localz.a("?app_id=");
    localz.a(this.a.a.j);
    localz.a("&zones=");
    if (this.a.a.k != null)
    {
      localObject = this.a.a.k;
      int n = localObject.length;
      int k = 0;
      if (k < n)
      {
        String str = localObject[k];
        if (m != 0) {
          m = 0;
        }
        for (;;)
        {
          localz.a(str);
          k += 1;
          break;
          localz.a(",");
        }
      }
    }
    localz.a(this.a.a.h);
    localz.a("&carrier=");
    localz.a(q.a(this.a.a.w));
    localz.a("&network_type=");
    if (q.a()) {
      localz.a("wifi");
    }
    for (;;)
    {
      localz.a("&custom_id=");
      localz.a(q.a(this.a.a.x));
      l.b.b("Downloading ad manifest from");
      l.b.b(localz);
      new ADCDownload(this.a, localz.toString(), this).b();
      return;
      if (q.b()) {
        localz.a("cell");
      } else {
        localz.a("none");
      }
    }
  }
  
  public void on_download_finished(ADCDownload paramADCDownload)
  {
    a.r = true;
    ADCData.g localg;
    if (paramADCDownload.i)
    {
      l.c.b("Finished downloading:");
      l.c.b(paramADCDownload.c);
      localg = k.b(paramADCDownload.m);
      if (localg == null)
      {
        l.a.b("Invalid JSON in manifest.  Raw data:");
        l.a.b(paramADCDownload.m);
      }
    }
    else
    {
      l.c.b("Error downloading:");
      l.c.b(paramADCDownload.c);
      return;
    }
    if (a(localg))
    {
      l.b.b("Ad manifest updated.");
      new f("manifest.txt").a(paramADCDownload.m);
      this.b = true;
      this.j.a();
      if ((this.j.i == null) || (this.j.i.equals(""))) {
        this.j.i = "all";
      }
      if ((this.j.j == null) || (this.j.j.equals(""))) {
        this.j.j = "all";
      }
      a.h();
      return;
    }
    l.b.b("Invalid manifest.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */