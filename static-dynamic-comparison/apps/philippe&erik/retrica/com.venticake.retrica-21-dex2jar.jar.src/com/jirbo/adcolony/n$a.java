package com.jirbo.adcolony;

class n$a
{
  String a;
  String b;
  int c;
  int d;
  int e;
  int f;
  int g;
  int h;
  boolean i;
  boolean j;
  boolean k;
  boolean l;
  boolean m;
  boolean n;
  boolean o;
  n.l p;
  n.v q;
  n.k r;
  n.c s;
  n.b t;
  n.h u;
  n.x v;
  n.n w;
  
  boolean a()
  {
    if (!this.r.a()) {}
    while (((this.s.a) && (!this.s.a())) || ((this.w.a) && (!this.w.a())) || ((this.u.d) && (!this.u.a())) || (!this.v.a())) {
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
                    return false;
                    this.a = paramg.e("uuid");
                    this.b = paramg.e("title");
                    this.c = paramg.g("ad_campaign_id");
                    this.d = paramg.g("ad_id");
                    this.e = paramg.g("ad_group_id");
                    this.f = paramg.g("cpcv_bid");
                    this.g = paramg.g("net_earnings");
                    this.h = paramg.g("expires");
                    this.i = paramg.h("enable_in_app_store");
                    this.j = paramg.h("video_events_on_replays");
                    this.k = paramg.h("test_ad");
                    this.l = paramg.h("fullscreen");
                    this.m = paramg.h("house_ad");
                    this.n = paramg.h("contracted");
                    this.p = new n.l();
                  } while (!this.p.a(paramg.b("limits")));
                  this.q = new n.v();
                } while (!this.q.a(paramg.b("third_party_tracking")));
                this.r = new n.k();
              } while (!this.r.a(paramg.b("in_app_browser")));
              this.w = new n.n();
            } while (!this.w.a(paramg.b("native")));
            this.s = new n.c();
          } while (!this.s.a(paramg.b("v4vc")));
          this.t = new n.b();
        } while (!this.t.a(paramg.b("ad_tracking")));
        this.u = new n.h();
      } while (!this.u.a(paramg.b("companion_ad")));
      this.v = new n.x();
    } while (!this.v.a(paramg.b("video")));
    return true;
  }
  
  void b()
  {
    this.s.b();
    this.r.b();
    this.w.b();
    this.u.b();
    this.v.c();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/n$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */