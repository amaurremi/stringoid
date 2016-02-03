package com.amazon.device.ads;

import android.annotation.SuppressLint;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

class bk {
    private static final String b = bk.class.getSimpleName();
    private static final a<?>[] c = {a.a, a.b, a.c, a.d, a.e, a.f, a.g, a.h, a.i, a.j, a.k, a.l, a.m, a.n, a.p, a.q};
    protected final Map<Integer, bm> a;
    private final bl d;
    private final br e;
    private final String f;
    private final hk g;
    private final String h;
    private String i;
    private cd j;

    @SuppressLint({"UseSparseArrays"})
    bk(br parambr) {
        this.e = parambr;
        this.a = new HashMap();
        parambr = dn.i().b();
        this.f = parambr.u();
        this.g = parambr.b(this.f);
        this.h = parambr.n();
        parambr = this.e.c();
        p localp = new p().a(parambr).a(this);
        this.d = new bl().a(c).a(parambr).a(localp);
    }

    bk a(cd paramcd) {
        this.j = paramcd;
        return this;
    }

    public String a() {
        return this.i;
    }

    public void a(ah paramah, br parambr) {
        paramah.d(this.h);
        paramah.c(this.g.b());
        paramah.d(this.g.a());
        if (d().f()) {
            paramah.n().a(eb.v);
        }
        paramah = new bm(paramah, parambr, this);
        this.a.put(Integer.valueOf(paramah.a().l()), paramah);
    }

    protected void a(hy paramhy) {
        this.d.c();
        Object localObject2 = a.o.a(this.d.a());
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = e();
        }
        this.d.a(a.o, localObject1);
        localObject1 = this.d.b();
        localObject2 = cx.a("debug.aaxAdParams", null);
        if (!hu.c((String) localObject2)) {
            paramhy.g((String) localObject2);
        }
        a(paramhy, (JSONObject) localObject1);
    }

    protected void a(hy paramhy, JSONObject paramJSONObject) {
        paramhy.e(paramJSONObject.toString());
    }

    public void a(String paramString) {
        this.i = paramString;
    }

    br b() {
        return this.e;
    }

    String c() {
        return this.f;
    }

    cd d() {
        return this.j;
    }

    protected JSONArray e() {
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = this.a.values().iterator();
        while (localIterator.hasNext()) {
            localJSONArray.put(((bm) localIterator.next()).c());
        }
        return localJSONArray;
    }

    public hy f() {
        hy localhy = hy.c();
        localhy.h(b);
        localhy.a(ia.b);
        localhy.b(cq.a().a(cs.a));
        localhy.c("/e/msdk/ads");
        localhy.d(true);
        localhy.f("application/json");
        a(localhy);
        return localhy;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */