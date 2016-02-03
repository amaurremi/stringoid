package com.amazon.device.ads;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

abstract class a<T> {
    static final a<String> a = new c();
    static final a<String> b = new w("c", "debug.channel");
    static final a<JSONArray> c = new i("pk", "debug.pk");
    static final a<JSONArray> d = new i("pa", "debug.pa");
    static final a<String> e = new y();
    static final a<String> f = new q();
    static final a<String> g = new g();
    static final a<JSONObject> h = new z();
    static final a<JSONObject> i = new e();
    static final a<JSONObject> j = new o();
    static final a<Boolean> k = new x();
    static final a<String> l = new s();
    static final a<String> m = new r();
    static final a<String> n = new l();
    static final a<JSONArray> o = new i("slots", "debug.slots");
    static final a<String> p = new b();
    static final a<Boolean> q = new n();
    static final a<String> r = new t();
    static final a<String> s = new w("pt", "debug.pt");
    static final a<String> t = new v();
    static final a<String> u = new w("sp", "debug.sp");
    static final a<String> v = new m();
    static final a<Integer> w = new u();
    static final a<Long> x = new f();
    private static final String y = a.class.getSimpleName();
    private final String A;
    private final String z;

    a(String paramString1, String paramString2) {
        this.z = paramString1;
        this.A = paramString2;
    }

    T a(p paramp) {
        if (c()) {
            paramp = d();
        }
        for (; ; ) {
            p localp = paramp;
            if ((paramp instanceof String)) {
                localp = paramp;
                if (hu.d((String) paramp)) {
                    localp = null;
                }
            }
            return localp;
            if (p.a(paramp).containsKey(this.z)) {
                paramp = a((String) p.a(paramp).remove(this.z));
            } else {
                paramp = b(paramp);
            }
        }
    }

    protected abstract T a(String paramString);

    String a() {
        return this.z;
    }

    protected T b(p paramp) {
        return null;
    }

    protected String b() {
        return this.A;
    }

    protected boolean c() {
        return cx.a(this.A);
    }

    protected abstract T d();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */