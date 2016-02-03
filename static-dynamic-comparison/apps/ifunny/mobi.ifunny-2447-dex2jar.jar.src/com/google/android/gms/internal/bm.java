package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.b.b;
import com.google.android.gms.ads.b.g;
import com.google.android.gms.ads.d.a;

import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@ii
public final class bm {
    public static final String a = mv.a("emulator");
    private final Date b;
    private final String c;
    private final int d;
    private final Set<String> e;
    private final Location f;
    private final boolean g;
    private final Bundle h;
    private final Map<Class<? extends g>, g> i;
    private final String j;
    private final a k;
    private final int l;
    private final Set<String> m;

    public bm(bn parambn) {
        this(parambn, null);
    }

    public bm(bn parambn, a parama) {
        this.b = bn.a(parambn);
        this.c = bn.b(parambn);
        this.d = bn.c(parambn);
        this.e = Collections.unmodifiableSet(bn.d(parambn));
        this.f = bn.e(parambn);
        this.g = bn.f(parambn);
        this.h = bn.g(parambn);
        this.i = Collections.unmodifiableMap(bn.h(parambn));
        this.j = bn.i(parambn);
        this.k = parama;
        this.l = bn.j(parambn);
        this.m = Collections.unmodifiableSet(bn.k(parambn));
    }

    public Bundle a(Class<? extends b> paramClass) {
        return this.h.getBundle(paramClass.getName());
    }

    public Date a() {
        return this.b;
    }

    public boolean a(Context paramContext) {
        return this.m.contains(mv.a(paramContext));
    }

    public String b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public Set<String> d() {
        return this.e;
    }

    public Location e() {
        return this.f;
    }

    public boolean f() {
        return this.g;
    }

    public String g() {
        return this.j;
    }

    public a h() {
        return this.k;
    }

    public Map<Class<? extends g>, g> i() {
        return this.i;
    }

    public Bundle j() {
        return this.h;
    }

    public int k() {
        return this.l;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */