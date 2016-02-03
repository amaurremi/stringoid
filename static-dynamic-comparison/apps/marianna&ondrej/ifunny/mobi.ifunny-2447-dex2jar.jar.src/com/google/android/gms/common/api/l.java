package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.ag;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class l {
    private String a;
    private final Set<String> b = new HashSet();
    private int c;
    private View d;
    private String e;
    private final Context f;
    private final Map g = new HashMap();
    private android.support.v4.app.k h;
    private int i = -1;
    private n j;
    private Looper k;
    private final Set<m> l = new HashSet();
    private final Set<n> m = new HashSet();

    public l(Context paramContext) {
        this.f = paramContext;
        this.k = paramContext.getMainLooper();
        this.e = paramContext.getPackageName();
    }

    private k c() {
        ae localae = ae.a(this.h);
        k localk = localae.a(this.i);
        Object localObject = localk;
        if (localk == null) {
            localObject = new v(this.f.getApplicationContext(), this.k, a(), this.g, this.l, this.m, this.i);
        }
        localae.a(this.i, (k) localObject, this.j);
        return (k) localObject;
    }

    public l a(a parama) {
        this.g.put(parama, null);
        parama = parama.b();
        int i1 = parama.size();
        int n = 0;
        while (n < i1) {
            this.b.add(((t) parama.get(n)).a());
            n += 1;
        }
        return this;
    }

    public l a(m paramm) {
        this.l.add(paramm);
        return this;
    }

    public l a(n paramn) {
        this.m.add(paramn);
        return this;
    }

    public l a(t paramt) {
        this.b.add(paramt.a());
        return this;
    }

    public ClientSettings a() {
        return new ClientSettings(this.a, this.b, this.c, this.d, this.e);
    }

    public k b() {
        if (!this.g.isEmpty()) {
        }
        for (boolean bool = true; ; bool = false) {
            ag.b(bool, "must call addApi() to add at least one API");
            if (this.i < 0) {
                break;
            }
            return c();
        }
        return new v(this.f, this.k, a(), this.g, this.l, this.m, -1);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/api/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */