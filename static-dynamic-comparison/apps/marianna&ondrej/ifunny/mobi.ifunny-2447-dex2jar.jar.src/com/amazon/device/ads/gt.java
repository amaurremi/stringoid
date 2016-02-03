package com.amazon.device.ads;

import java.util.HashMap;

abstract class gt
        implements ha {
    private String a;
    private eb b;
    private String c;
    private cd d;

    private static String a(boolean paramBoolean) {
        if (paramBoolean) {
            return "1";
        }
        return "0";
    }

    public static String f() {
        return String.format("{\"make\":\"%s\",\"model\":\"%s\",\"os\":\"%s\",\"osVersion\":\"%s\"}", new Object[]{cz.c(), cz.d(), cz.e(), cz.f()});
    }

    public gt a(cd paramcd) {
        this.d = paramcd;
        return this;
    }

    public gt a(eb parameb) {
        this.b = parameb;
        return this;
    }

    public gt a(String paramString) {
        this.a = paramString;
        return this;
    }

    public String a() {
        return this.a;
    }

    public eb b() {
        return this.b;
    }

    public gt b(String paramString) {
        this.c = paramString;
        return this;
    }

    public String c() {
        return this.c;
    }

    public ib d() {
        ib localib = new ib();
        localib.a("dt", cz.b());
        localib.a("app", dn.i().c().a());
        localib.a("aud", cq.a().a(cs.e));
        localib.a("ua", hu.b(cz.t()));
        localib.a("dinfo", hu.b(f()));
        localib.a("pkg", hu.b(dn.i().a().b()));
        Object localObject;
        if (this.d.c()) {
            localib.a("idfa", this.d.b());
            localib.a("oo", a(this.d.d()));
            localObject = cc.a();
            if (localObject == null) {
                break label230;
            }
        }
        label230:
        for (boolean bool = true; ; bool = false) {
            localib.a("aidts", (String) localObject, bool);
            return localib;
            localObject = dn.i().b();
            localib.a("sha1_mac", ((cz) localObject).g());
            localib.a("sha1_serial", ((cz) localObject).i());
            localib.a("sha1_udid", ((cz) localObject).k());
            localib.a("badMac", "true", ((cz) localObject).h());
            localib.a("badSerial", "true", ((cz) localObject).j());
            localib.a("badUdid", "true", ((cz) localObject).m());
            break;
        }
    }

    protected cd e() {
        return this.d;
    }

    public HashMap<String, String> g() {
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/gt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */