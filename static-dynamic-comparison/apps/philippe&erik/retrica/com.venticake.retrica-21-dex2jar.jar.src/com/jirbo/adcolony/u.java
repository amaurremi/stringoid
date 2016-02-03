package com.jirbo.adcolony;

import java.util.ArrayList;
import java.util.HashMap;

class u
  implements ADCDownload.Listener
{
  d a;
  ArrayList<u.a> b = new ArrayList();
  ArrayList<u.a> c = new ArrayList();
  int d = 0;
  boolean e = false;
  
  u(d paramd)
  {
    this.a = paramd;
  }
  
  void a()
  {
    b();
    this.d = 0;
  }
  
  void a(double paramDouble, AdColonyAd paramAdColonyAd)
  {
    double d1 = paramAdColonyAd.m;
    if (paramDouble < d1) {
      return;
    }
    label106:
    label152:
    ADCData.g localg;
    if ((d1 < 0.25D) && (paramDouble >= 0.25D))
    {
      if ((!AdColony.isZoneV4VC(paramAdColonyAd.g)) && (paramAdColonyAd.k.equals("native"))) {
        b("native_first_quartile", paramAdColonyAd);
      }
    }
    else
    {
      if ((d1 < 0.5D) && (paramDouble >= 0.5D))
      {
        if ((AdColony.isZoneV4VC(paramAdColonyAd.g)) || (!paramAdColonyAd.k.equals("native"))) {
          break label255;
        }
        b("native_midpoint", paramAdColonyAd);
      }
      if ((d1 < 0.75D) && (paramDouble >= 0.75D))
      {
        if ((AdColony.isZoneV4VC(paramAdColonyAd.g)) || (!paramAdColonyAd.k.equals("native"))) {
          break label265;
        }
        b("native_third_quartile", paramAdColonyAd);
      }
      if ((d1 < 1.0D) && (paramDouble >= 1.0D) && (!paramAdColonyAd.k.equals("native")))
      {
        l.a.a("Tracking ad event - complete");
        localg = new ADCData.g();
        if (!paramAdColonyAd.q) {
          break label275;
        }
        localg.b("ad_slot", paramAdColonyAd.h.k.d);
      }
    }
    for (;;)
    {
      localg.b("replay", paramAdColonyAd.r);
      a("complete", localg, paramAdColonyAd);
      paramAdColonyAd.m = paramDouble;
      return;
      b("first_quartile", paramAdColonyAd);
      break;
      label255:
      b("midpoint", paramAdColonyAd);
      break label106;
      label265:
      b("third_quartile", paramAdColonyAd);
      break label152;
      label275:
      localg.b("ad_slot", paramAdColonyAd.h.k.d);
    }
  }
  
  void a(String paramString, ADCData.g paramg)
  {
    n.f localf = this.a.b.j.k;
    if (localf != null) {
      a(paramString, localf.h.e(paramString), paramg);
    }
    paramg = this.a.b.j.l;
    if (paramg != null) {
      a(paramString, (ArrayList)paramg.d.get(paramString));
    }
  }
  
  void a(String paramString, ADCData.g paramg, AdColonyAd paramAdColonyAd)
  {
    if (paramString == null)
    {
      l.d.b("No such event type:").b(paramString);
      return;
    }
    ADCData.g localg = paramg;
    if (paramg == null)
    {
      localg = new ADCData.g();
      localg.b("replay", paramAdColonyAd.r);
    }
    a(paramString, paramAdColonyAd.i.t.C.e(paramString), localg, paramAdColonyAd);
    a(paramString, (ArrayList)paramAdColonyAd.i.q.B.get(paramString));
  }
  
  void a(String paramString, AdColonyAd paramAdColonyAd)
  {
    if ((this.a == null) || (this.a.b == null) || (this.a.b.j == null) || (this.a.b.j.n == null) || (this.a.b.j.n.a(paramString) == null)) {}
    do
    {
      return;
      l.a.a("Ad request for zone ").b(paramString);
      paramString = this.a.b.j.n.a(paramString);
    } while ((paramString == null) || (paramString.h == null) || (paramString.h.a == null));
    ADCData.g localg = new ADCData.g();
    if (a.Y == 0) {
      localg.b("request_denied", false);
    }
    for (;;)
    {
      localg.b("request_denied_reason", a.Y);
      a("request", paramString.h.a, localg, paramAdColonyAd);
      l.a.a("Tracking ad request - URL : ").b(paramString.h.a);
      return;
      localg.b("request_denied", true);
    }
  }
  
  void a(String paramString1, String paramString2, ADCData.g paramg)
  {
    a(paramString1, paramString2, paramg, null);
  }
  
  void a(String paramString1, String paramString2, ADCData.g paramg, AdColonyAd paramAdColonyAd)
  {
    if ((paramString2 == null) || (paramString2.equals(""))) {
      return;
    }
    ADCData.g localg = paramg;
    if (paramg == null) {
      localg = new ADCData.g();
    }
    paramg = ab.b();
    if (paramAdColonyAd != null) {
      localg.b("asi", paramAdColonyAd.l);
    }
    localg.b("sid", this.a.e.i);
    localg.b("guid", paramg);
    localg.b("guid_key", ab.b(paramg + "DUBu6wJ27y6xs7VWmNDw67DD"));
    paramg = new u.a();
    paramg.a = paramString1;
    paramg.b = paramString2;
    l.a.b("EVENT ----------------------------");
    l.a.a("EVENT - TYPE = ").b(paramString1);
    l.a.a("EVENT - URL  = ").b(paramString2);
    paramg.c = localg.q();
    if (paramString1.equals("reward_v4vc"))
    {
      paramg.d = localg.e("v4vc_name");
      paramg.h = localg.g("v4vc_amount");
    }
    this.b.add(paramg);
    this.e = true;
    a.r = true;
  }
  
  void a(String paramString, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    int i = 0;
    while (i < paramArrayList.size())
    {
      String str = (String)paramArrayList.get(i);
      u.a locala = new u.a();
      locala.a = paramString;
      locala.b = str;
      locala.k = true;
      this.b.add(locala);
      i += 1;
    }
    this.e = true;
    a.r = true;
  }
  
  void b()
  {
    a.r = true;
    ADCData.c localc = k.c(new f("tracking_info.txt"));
    if (localc != null)
    {
      this.b.clear();
      int i = 0;
      while (i < localc.i())
      {
        ADCData.g localg = localc.b(i);
        u.a locala = new u.a();
        locala.a = localg.e("type");
        locala.b = localg.e("url");
        locala.c = localg.a("payload", null);
        locala.f = localg.g("attempts");
        locala.k = localg.h("third_party");
        if ((locala.a.equals("v4vc_callback")) || (locala.a.equals("reward_v4vc")))
        {
          locala.d = localg.e("v4vc_name");
          locala.h = localg.g("v4vc_amount");
        }
        this.b.add(locala);
        i += 1;
      }
    }
    l.a.a("Loaded ").a(this.b.size()).b(" events");
  }
  
  void b(String paramString, AdColonyAd paramAdColonyAd)
  {
    a(paramString, null, paramAdColonyAd);
  }
  
  void c()
  {
    this.c.clear();
    this.c.addAll(this.b);
    this.b.clear();
    ADCData.c localc = new ADCData.c();
    int i = 0;
    while (i < this.c.size())
    {
      u.a locala = (u.a)this.c.get(i);
      if (!locala.i)
      {
        this.b.add(locala);
        ADCData.g localg = new ADCData.g();
        localg.b("type", locala.a);
        localg.b("url", locala.b);
        if (locala.c != null) {
          localg.b("payload", locala.c);
        }
        localg.b("attempts", locala.f);
        if (locala.d != null)
        {
          localg.b("v4vc_name", locala.d);
          localg.b("v4vc_amount", locala.h);
        }
        if (locala.k) {
          localg.b("third_party", true);
        }
        localc.a(localg);
      }
      i += 1;
    }
    this.c.clear();
    l.a.a("Saving tracking_info (").a(this.b.size()).b(" events)");
    k.a(new f("tracking_info.txt"), localc);
  }
  
  void d()
  {
    if (this.e)
    {
      this.e = false;
      c();
    }
    e();
  }
  
  void e()
  {
    if (this.b.size() == 0) {}
    label246:
    for (;;)
    {
      return;
      while (this.b.size() > 1000) {
        this.b.remove(this.b.size() - 1);
      }
      if (q.c())
      {
        double d1 = ab.c();
        int i = 0;
        for (;;)
        {
          if (i >= this.b.size()) {
            break label246;
          }
          u.a locala = (u.a)this.b.get(i);
          if ((locala.e < d1) && (!locala.j))
          {
            if (this.d == 5) {
              break;
            }
            this.d += 1;
            locala.j = true;
            if (locala.a.equals("v4vc_callback")) {
              a.V.add(locala.b);
            }
            ADCDownload localADCDownload = new ADCDownload(this.a, locala.b, this).a(locala);
            if (locala.k) {
              localADCDownload.h = true;
            }
            if (locala.c != null) {
              localADCDownload.a("application/json", locala.c);
            }
            l.b.a("Submitting '").a(locala.a).b("' event.");
            localADCDownload.b();
            a.r = true;
          }
          i += 1;
        }
      }
    }
  }
  
  public void on_download_finished(ADCDownload paramADCDownload)
  {
    int j = 10000;
    a.r = true;
    this.e = true;
    this.d -= 1;
    u.a locala1 = (u.a)paramADCDownload.e;
    l.a.a("on_download_finished - event.type = ").b(locala1.a);
    locala1.j = false;
    boolean bool2 = paramADCDownload.i;
    boolean bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (locala1.c != null)
      {
        Object localObject = k.b(paramADCDownload.m);
        if (localObject == null) {
          break label424;
        }
        bool2 = ((ADCData.g)localObject).e("status").equals("success");
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (locala1.a.equals("reward_v4vc"))
          {
            if (!((ADCData.g)localObject).h("v4vc_status")) {
              break label407;
            }
            localObject = ((ADCData.g)localObject).e("v4vc_callback");
            if (((String)localObject).length() <= 0) {
              break label377;
            }
            u.a locala2 = new u.a();
            locala2.a = "v4vc_callback";
            locala2.b = ((String)localObject);
            locala2.d = locala1.d;
            locala2.h = locala1.h;
            this.b.add(locala2);
            bool1 = bool2;
          }
        }
      }
    }
    bool2 = bool1;
    if (bool1)
    {
      bool2 = bool1;
      if (locala1.a.equals("v4vc_callback"))
      {
        l.a.b("v4vc_callback response:").b(paramADCDownload.m);
        if (paramADCDownload.m.indexOf("vc_success") == -1) {
          break label430;
        }
        if (a.I != null) {
          a.I.o = true;
        }
        l.a.b("v4vc_callback success");
        this.a.a(true, locala1.d, locala1.h);
        bool2 = bool1;
      }
    }
    label330:
    if (bool2)
    {
      l.a.a("Event submission SUCCESS for type: ").b(locala1.a);
      locala1.i = true;
    }
    for (;;)
    {
      if (!this.a.e.b) {
        c();
      }
      return;
      label377:
      if (a.I != null) {
        a.I.o = true;
      }
      l.a.b("Client-side V4VC success");
      bool1 = bool2;
      break;
      label407:
      l.a.b("Client-side V4VC failure");
      bool1 = bool2;
      break;
      label424:
      bool1 = false;
      break;
      label430:
      if ((paramADCDownload.m.indexOf("vc_decline") != -1) || (paramADCDownload.m.indexOf("vc_noreward") != -1))
      {
        l.c.a("Server-side V4VC failure: ").b(paramADCDownload.c);
        l.a.b("v4vc_callback declined");
        this.a.a(false, "", 0);
        bool2 = bool1;
        break label330;
      }
      l.c.a("Server-side V4VC failure: ").b(paramADCDownload.c);
      bool2 = false;
      break label330;
      l.a.a("Event submission FAILED for type: ").a(locala1.a).a(" on try ").b(locala1.f + 1);
      locala1.f += 1;
      if (locala1.f < 24) {
        break label626;
      }
      l.d.b("Discarding event after 24 attempts to report.");
      locala1.i = true;
      if (locala1.a.equals("v4vc_callback")) {
        this.a.a(false, "", 0);
      }
    }
    label626:
    int i = 20;
    if (locala1.g > 0) {
      i = locala1.g * 3;
    }
    if (i > 10000) {
      i = j;
    }
    for (;;)
    {
      l.a.a("Retrying in ").a(i).a(" seconds (attempt ").a(locala1.f).b(")");
      locala1.g = i;
      locala1.e = (ab.c() + i);
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */