package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesUtil;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

@ii
public class lj
        implements cy {
    public static final String a = c.b;
    private static final lj c = new lj();
    public final String b = lw.e();
    private final Object d = new Object();
    private final lk e = new lk(this.b);
    private BigInteger f = BigInteger.ONE;
    private final HashSet<lg> g = new HashSet();
    private final HashMap<String, lm> h = new HashMap();
    private boolean i = false;
    private boolean j = true;
    private boolean k = false;
    private Context l;
    private gt m;
    private boolean n = true;
    private ac o = null;
    private ad p = null;
    private ab q = null;
    private LinkedList<Thread> r = new LinkedList();
    private boolean s = false;
    private Bundle t = bt.a();
    private ih u = null;
    private String v;

    public static Bundle a(Context paramContext, ll paramll, String paramString) {
        return c.b(paramContext, paramll, paramString);
    }

    public static lj a() {
        return c;
    }

    public static String a(int paramInt, String paramString) {
        return c.b(paramInt, paramString);
    }

    public static void a(Context paramContext, gt paramgt) {
        c.b(paramContext, paramgt);
    }

    public static void a(Context paramContext, boolean paramBoolean) {
        c.b(paramContext, paramBoolean);
    }

    public static void a(Throwable paramThrowable) {
        c.b(paramThrowable);
    }

    public static void a(HashSet<lg> paramHashSet) {
        c.b(paramHashSet);
    }

    public static String c() {
        return c.d();
    }

    public static lk e() {
        return c.f();
    }

    public static boolean g() {
        return c.h();
    }

    public static boolean i() {
        return c.j();
    }

    public static String k() {
        return c.l();
    }

    public static Bundle m() {
        return c.n();
    }

    public ad a(Context paramContext) {
        if ((!m().getBoolean(bt.g.a(), false)) || (!py.c()) || (b())) {
            return null;
        }
        synchronized (this.d) {
            if (this.o != null) {
                break label83;
            }
            if (!(paramContext instanceof Activity)) {
                return null;
            }
        }
        this.o = new ac((Application) paramContext.getApplicationContext(), (Activity) paramContext);
        label83:
        if (this.q == null) {
            this.q = new ab();
        }
        if (this.p == null) {
            this.p = new ad(this.o, this.q, this.t, new ih(this.l, this.m, null, null));
        }
        this.p.a();
        paramContext = this.p;
        return paramContext;
    }

    public void a(Bundle paramBundle) {
        synchronized (this.d) {
            this.s = true;
            this.t = paramBundle;
            if (!this.r.isEmpty()) {
                ih.a(this.l, (Thread) this.r.remove(0), this.m);
            }
        }
    }

    public void a(lg paramlg) {
        synchronized (this.d) {
            this.g.add(paramlg);
            return;
        }
    }

    public void a(String paramString, lm paramlm) {
        synchronized (this.d) {
            this.h.put(paramString, paramlm);
            return;
        }
    }

    public void a(Thread paramThread) {
        synchronized (this.d) {
            if (this.s) {
                ih.a(this.l, paramThread, this.m);
                return;
            }
            this.r.add(paramThread);
        }
    }

    public void a(boolean paramBoolean) {
        synchronized (this.d) {
            this.n = paramBoolean;
            return;
        }
    }

    public Bundle b(Context paramContext, ll paramll, String paramString) {
        Bundle localBundle;
        synchronized (this.d) {
            localBundle = new Bundle();
            localBundle.putBundle("app", this.e.a(paramContext, paramString));
            paramContext = new Bundle();
            paramString = this.h.keySet().iterator();
            if (paramString.hasNext()) {
                String str = (String) paramString.next();
                paramContext.putBundle(str, ((lm) this.h.get(str)).a());
            }
        }
        localBundle.putBundle("slots", paramContext);
        paramContext = new ArrayList();
        paramString = this.g.iterator();
        while (paramString.hasNext()) {
            paramContext.add(((lg) paramString.next()).d());
        }
        localBundle.putParcelableArrayList("ads", paramContext);
        paramll.a(this.g);
        this.g.clear();
        return localBundle;
    }

    public String b(int paramInt, String paramString) {
        if (this.m.e) {
        }
        for (Resources localResources = this.l.getResources(); localResources == null; localResources = GooglePlayServicesUtil.getRemoteResource(this.l)) {
            return paramString;
        }
        return localResources.getString(paramInt);
    }

    public void b(Context paramContext, gt paramgt) {
        synchronized (this.d) {
            if (!this.k) {
                this.l = paramContext.getApplicationContext();
                this.m = paramgt;
                this.j = lq.a(paramContext);
                or.a(paramContext);
                cw.a(paramContext, this);
                a(Thread.currentThread());
                this.v = lw.a(paramContext, paramgt.b);
                this.k = true;
            }
            return;
        }
    }

    public void b(Context paramContext, boolean paramBoolean) {
        synchronized (this.d) {
            if (paramBoolean != this.j) {
                this.j = paramBoolean;
                lq.a(paramContext, paramBoolean);
            }
            return;
        }
    }

    public void b(Throwable paramThrowable) {
        if (this.k) {
            new ih(this.l, this.m, null, null).b(paramThrowable);
        }
    }

    public void b(HashSet<lg> paramHashSet) {
        synchronized (this.d) {
            this.g.addAll(paramHashSet);
            return;
        }
    }

    public boolean b() {
        synchronized (this.d) {
            boolean bool = this.n;
            return bool;
        }
    }

    public String d() {
        synchronized (this.d) {
            String str = this.f.toString();
            this.f = this.f.add(BigInteger.ONE);
            return str;
        }
    }

    public lk f() {
        synchronized (this.d) {
            lk locallk = this.e;
            return locallk;
        }
    }

    public boolean h() {
        synchronized (this.d) {
            boolean bool = this.i;
            this.i = true;
            return bool;
        }
    }

    public boolean j() {
        synchronized (this.d) {
            boolean bool = this.j;
            return bool;
        }
    }

    public String l() {
        synchronized (this.d) {
            String str = this.v;
            return str;
        }
    }

    public Bundle n() {
        synchronized (this.d) {
            Bundle localBundle = this.t;
            return localBundle;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/lj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */