package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.metadata.a;
import com.google.android.gms.internal.pz;
import com.google.android.gms.internal.qk;
import com.google.android.gms.internal.qr;

import java.util.HashMap;
import java.util.Map;

public final class g {
    private static Map<String, a<?>> a = new HashMap();

    static {
        a(pz.a);
        a(pz.A);
        a(pz.r);
        a(pz.y);
        a(pz.B);
        a(pz.l);
        a(pz.m);
        a(pz.j);
        a(pz.o);
        a(pz.w);
        a(pz.b);
        a(pz.t);
        a(pz.d);
        a(pz.k);
        a(pz.e);
        a(pz.f);
        a(pz.g);
        a(pz.q);
        a(pz.n);
        a(pz.s);
        a(pz.u);
        a(pz.v);
        a(pz.x);
        a(pz.C);
        a(pz.D);
        a(pz.i);
        a(pz.h);
        a(pz.z);
        a(pz.p);
        a(pz.c);
        a(pz.E);
        a(pz.F);
        a(pz.G);
        a(qk.a);
        a(qk.c);
        a(qk.d);
        a(qk.e);
        a(qk.b);
        a(qr.a);
        a(qr.b);
    }

    public static a<?> a(String paramString) {
        return (a) a.get(paramString);
    }

    private static void a(a<?> parama) {
        if (a.containsKey(parama.a())) {
            throw new IllegalArgumentException("Duplicate field name registered: " + parama.a());
        }
        a.put(parama.a(), parama);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */