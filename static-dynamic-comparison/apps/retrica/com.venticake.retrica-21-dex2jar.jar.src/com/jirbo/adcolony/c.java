package com.jirbo.adcolony;

import android.os.Build.VERSION;

class c
{
  static String c = "https://androidads21.adcolony.com/configure";
  String A;
  String B;
  String C;
  String D;
  String E;
  String F;
  String G;
  String H;
  String I;
  String J;
  String K;
  boolean L;
  d a;
  String b = "2.1.2";
  int d = 300;
  int e = 0;
  boolean f = false;
  boolean g = false;
  String h;
  ADCData.g i = new ADCData.g();
  String j;
  String[] k;
  n.y l;
  n.a m;
  double n = 0.0D;
  String o = "android";
  String p = "android_native";
  String q = "1.0";
  String r = "google";
  boolean s = false;
  String t;
  String u;
  String v;
  String w;
  String x = "";
  String y;
  String z;
  
  c(d paramd)
  {
    this.a = paramd;
  }
  
  String a(String paramString1, String paramString2)
  {
    if (paramString1 != null) {
      return paramString1;
    }
    return paramString2;
  }
  
  void a()
  {
    while ((!AdColony.b) && (this.e < 60)) {
      try
      {
        this.e += 1;
        Thread.sleep(50L);
      }
      catch (Exception localException) {}
    }
    this.e = 0;
    this.a.g.a();
    this.K = a(g.a, "");
    this.L = g.b;
    this.t = a(g.a(), "");
    Object localObject;
    if (!this.K.equals(""))
    {
      localObject = "";
      this.u = ((String)localObject);
      this.w = a(g.b(), "");
      if (this.y == null) {
        this.y = a(g.e(), "");
      }
      this.z = a(g.l(), "");
      this.A = a(g.m(), "");
      this.E = a(g.j(), "en");
      this.F = a(g.n(), "");
      this.G = a(g.o(), "");
      this.J = a("" + Build.VERSION.SDK_INT, "");
      this.C = a(g.h(), "");
      this.D = "";
      this.H = a("" + g.c(), "");
      this.I = a("" + g.d(), "");
      a.T = this.G;
      a.U = this.b;
      if (!a.m) {
        break label1481;
      }
    }
    label1481:
    for (this.B = "tablet";; this.B = "phone")
    {
      this.v = "";
      if ((ab.a("com.android.vending")) || (ab.a("com.android.market"))) {
        this.v = "google";
      }
      if (ab.a("com.amazon.venezia"))
      {
        if (this.v.length() > 0) {
          this.v += ",";
        }
        this.v += "amazon";
      }
      if (l.b.f)
      {
        l.b.a("sdk_version:").b(this.b);
        l.b.a("ad_manifest_url:").b(c);
        l.b.a("app_id:").b(this.j);
        l.b.a("zone_ids:").b(this.k);
        l.b.a("os_name:").b(this.o);
        l.b.a("sdk_type:").b(this.p);
        l.b.a("app_version:").b(this.q);
        l.b.a("origin_store:").b(this.r);
        l.b.a("skippable:").b(this.s);
        l.b.a("android_id:").b(this.t);
        l.b.a("android_id_sha1:").b(this.u);
        l.b.a("available_stores:").b(this.v);
        l.b.a("carrier_name:").b(this.w);
        l.b.a("custom_id:").b(this.x);
        l.b.a("device_id:").b(this.y);
        l.b.a("device_manufacturer:").b(this.z);
        l.b.a("device_model:").b(this.A);
        l.b.a("device_type:").b(this.B);
        l.b.a("imei:").b(this.C);
        l.b.a("imei_sha1:").b(this.D);
        l.b.a("language:").b(this.E);
        l.b.a("open_udid:").b(this.F);
        l.b.a("os_version:").b(this.G);
      }
      localObject = new z();
      ((z)localObject).a("&os_name=");
      ((z)localObject).a(q.a(this.o));
      ((z)localObject).a("&os_version=");
      ((z)localObject).a(q.a(this.G));
      ((z)localObject).a("&device_api=");
      ((z)localObject).a(q.a(this.J));
      ((z)localObject).a("&app_version=");
      ((z)localObject).a(q.a(this.q));
      ((z)localObject).a("&android_id_sha1=");
      ((z)localObject).a(q.a(this.u));
      ((z)localObject).a("&device_id=");
      ((z)localObject).a(q.a(this.y));
      ((z)localObject).a("&open_udid=");
      ((z)localObject).a(q.a(this.F));
      ((z)localObject).a("&device_type=");
      ((z)localObject).a(q.a(this.B));
      ((z)localObject).a("&ln=");
      ((z)localObject).a(q.a(this.E));
      ((z)localObject).a("&device_brand=");
      ((z)localObject).a(q.a(this.z));
      ((z)localObject).a("&device_model=");
      ((z)localObject).a(q.a(this.A));
      ((z)localObject).a("&screen_width=");
      ((z)localObject).a(q.a("" + g.f()));
      ((z)localObject).a("&screen_height=");
      ((z)localObject).a(q.a("" + g.g()));
      ((z)localObject).a("&sdk_type=");
      ((z)localObject).a(q.a(this.p));
      ((z)localObject).a("&sdk_version=");
      ((z)localObject).a(q.a(this.b));
      ((z)localObject).a("&origin_store=");
      ((z)localObject).a(q.a(this.r));
      ((z)localObject).a("&available_stores=");
      ((z)localObject).a(q.a(this.v));
      ((z)localObject).a("&imei_sha1=");
      ((z)localObject).a(q.a(this.D));
      ((z)localObject).a("&memory_class=");
      ((z)localObject).a(q.a(this.H));
      ((z)localObject).a("&memory_used_mb=");
      ((z)localObject).a(q.a(this.I));
      ((z)localObject).a("&advertiser_id=");
      ((z)localObject).a(q.a(this.K));
      ((z)localObject).a("&limit_tracking=");
      ((z)localObject).a(this.L);
      this.h = ((z)localObject).toString();
      this.a.f.a();
      this.a.c.a();
      this.a.d.a();
      this.a.b.a();
      this.a.e.a();
      this.a.h.a();
      this.g = true;
      this.a.b.e();
      if ((this.a.b.j.i == null) || (this.a.b.j.i.equals(""))) {
        this.a.b.j.i = "all";
      }
      if ((this.a.b.j.j == null) || (this.a.b.j.j.equals(""))) {
        this.a.b.j.j = "all";
      }
      return;
      localObject = a(ab.b(this.t), "");
      break;
    }
  }
  
  void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = str.split(",");
    int i2 = paramString.length;
    int i1 = 0;
    if (i1 < i2)
    {
      Object localObject = paramString[i1].split(":");
      if (localObject.length == 2)
      {
        str = localObject[0];
        localObject = localObject[1];
        if (str.equals("version")) {
          this.q = ((String)localObject);
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (str.equals("store"))
        {
          if ((((String)localObject).toLowerCase().equals("google")) || (((String)localObject).toLowerCase().equals("amazon"))) {
            this.r = ((String)localObject);
          } else {
            throw new AdColonyException("Origin store in client options must be set to either 'google' or 'amazon'");
          }
        }
        else if (str.equals("skippable"))
        {
          this.s = false;
          continue;
          if (localObject[0].equals("skippable")) {
            this.s = false;
          }
        }
      }
    }
  }
  
  void a(String paramString, n.a parama)
  {
    this.l = this.a.b.j.n.a(paramString);
    if (this.l == null) {}
    for (;;)
    {
      return;
      if (parama == null) {}
      for (this.m = this.l.i(); this.m != null; this.m = parama)
      {
        paramString = this.a.c;
        parama = this.m.v;
        this.i.b("video_enabled", parama.a);
        this.i.b("video_filepath", parama.b());
        this.i.b("video_width", parama.c);
        this.i.b("video_height", parama.d);
        this.i.b("video_duration", parama.m);
        this.i.b("engagement_delay", parama.o.e);
        this.i.b("skip_delay", parama.n.e);
        this.i.b("browser_close_image_normal", paramString.b(this.m.r.k.f));
        this.i.b("browser_close_image_down", paramString.b(this.m.r.k.h));
        this.i.b("browser_reload_image_normal", paramString.b(this.m.r.m.f));
        this.i.b("browser_reload_image_down", paramString.b(this.m.r.m.h));
        this.i.b("browser_back_image_normal", paramString.b(this.m.r.j.f));
        this.i.b("browser_back_image_down", paramString.b(this.m.r.j.h));
        this.i.b("browser_forward_image_normal", paramString.b(this.m.r.l.f));
        this.i.b("browser_forward_image_down", paramString.b(this.m.r.l.h));
        this.i.b("browser_stop_image_normal", paramString.b(this.m.r.i.f));
        this.i.b("browser_stop_image_down", paramString.b(this.m.r.i.h));
        this.i.b("browser_glow_button", paramString.b(this.m.r.a));
        this.i.b("browser_icon", paramString.b(this.m.r.h.d));
        this.i.b("mute", paramString.b(this.m.w.k.d));
        this.i.b("unmute", paramString.b(this.m.w.l.d));
        this.i.b("poster_image", paramString.b(this.m.w.c));
        this.i.b("thumb_image", paramString.b(this.m.w.g));
        this.i.b("advertiser_name", this.m.w.d);
        this.i.b("description", this.m.w.e);
        this.i.b("title", this.m.w.f);
        this.i.b("native_engagement_enabled", this.m.w.j.a);
        this.i.b("native_engagement_type", this.m.w.j.c);
        this.i.b("native_engagement_command", this.m.w.j.e);
        this.i.b("native_engagement_label", this.m.w.j.d);
        this.i.b("skip_video_image_normal", paramString.b(parama.n.f));
        this.i.b("skip_video_image_down", paramString.b(parama.n.h));
        this.i.b("engagement_image_normal", paramString.b(parama.o.f));
        this.i.b("engagement_image_down", paramString.b(parama.o.h));
        b();
        return;
      }
    }
  }
  
  void b()
  {
    Object localObject = this.m.u.h;
    n.i locali = this.m.u.i;
    o localo = this.a.c;
    if (!this.m.u.d)
    {
      this.i.b("end_card_enabled", this.m.u.d);
      return;
    }
    if (locali.a())
    {
      a.M = true;
      a.R = locali.g;
      a.S = localo.b(locali.f.b);
      this.i.b("close_image_normal", localo.b(locali.j.f));
      this.i.b("close_image_down", localo.b(locali.j.h));
      this.i.b("reload_image_normal", localo.b(locali.i.f));
      this.i.b("reload_image_down", localo.b(locali.i.h));
    }
    for (;;)
    {
      localObject = this.m.v;
      this.i.b("end_card_enabled", this.m.u.d);
      this.i.b("load_timeout_enabled", this.m.u.i.c);
      this.i.b("load_timeout", this.m.u.i.b);
      this.i.b("hardware_acceleration_disabled", this.a.b.j.e);
      return;
      a.M = false;
      this.i.b("end_card_filepath", localo.b(((n.t)localObject).d));
      this.i.b("info_image_normal", localo.b(((n.t)localObject).f.f));
      this.i.b("info_image_down", localo.b(((n.t)localObject).f.h));
      this.i.b("info_url", ((n.t)localObject).f.j);
      this.i.b("replay_image_normal", localo.b(((n.t)localObject).h.f));
      this.i.b("replay_image_down", localo.b(((n.t)localObject).h.h));
      this.i.b("continue_image_normal", localo.b(((n.t)localObject).i.f));
      this.i.b("continue_image_down", localo.b(((n.t)localObject).i.h));
      this.i.b("download_image_normal", localo.b(((n.t)localObject).g.f));
      this.i.b("download_image_down", localo.b(((n.t)localObject).g.h));
      this.i.b("download_url", ((n.t)localObject).g.j);
    }
  }
  
  void b(String paramString)
  {
    a(paramString, null);
  }
  
  void c(String paramString)
  {
    this.l = this.a.b.j.n.a(paramString);
    this.m = this.l.i();
    paramString = this.a.c;
    n.x localx = this.m.v;
    this.i.b("video_enabled", localx.a);
    this.i.b("video_filepath", localx.b());
    this.i.b("video_width", localx.c);
    this.i.b("video_height", localx.d);
    this.i.b("video_duration", localx.m);
    this.i.b("engagement_delay", localx.o.e);
    this.i.b("skip_delay", localx.n.e);
    b();
    n.c localc = this.m.s;
    this.i.b("pre_popup_bg", paramString.b(localc.b.d.e));
    this.i.b("v4vc_logo", paramString.b(localc.b.d.l.d));
    this.i.b("no_button_normal", paramString.b(localc.b.d.n.f));
    this.i.b("no_button_down", paramString.b(localc.b.d.n.h));
    this.i.b("yes_button_normal", paramString.b(localc.b.d.m.f));
    this.i.b("yes_button_down", paramString.b(localc.b.d.m.h));
    this.i.b("done_button_normal", paramString.b(localc.c.d.m.f));
    this.i.b("done_button_down", paramString.b(localc.c.d.m.h));
    this.i.b("browser_close_image_normal", paramString.b(this.m.r.k.f));
    this.i.b("browser_close_image_down", paramString.b(this.m.r.k.h));
    this.i.b("browser_reload_image_normal", paramString.b(this.m.r.m.f));
    this.i.b("browser_reload_image_down", paramString.b(this.m.r.m.h));
    this.i.b("browser_back_image_normal", paramString.b(this.m.r.j.f));
    this.i.b("browser_back_image_down", paramString.b(this.m.r.j.h));
    this.i.b("browser_forward_image_normal", paramString.b(this.m.r.l.f));
    this.i.b("browser_forward_image_down", paramString.b(this.m.r.l.h));
    this.i.b("browser_stop_image_normal", paramString.b(this.m.r.i.f));
    this.i.b("browser_stop_image_down", paramString.b(this.m.r.i.h));
    this.i.b("browser_glow_button", paramString.b(this.m.r.a));
    this.i.b("browser_icon", paramString.b(this.m.r.h.d));
    this.i.b("skip_video_image_normal", paramString.b(localx.n.f));
    this.i.b("skip_video_image_down", paramString.b(localx.n.h));
    this.i.b("engagement_image_normal", paramString.b(localx.o.f));
    this.i.b("engagement_image_down", paramString.b(localx.o.h));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */