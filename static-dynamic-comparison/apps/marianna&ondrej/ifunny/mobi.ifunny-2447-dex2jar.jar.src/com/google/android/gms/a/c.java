package com.google.android.gms.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class c
        extends o {
    private static boolean a;
    private static c l;
    private boolean b;
    private aj c;
    private v d;
    private Context e;
    private volatile Boolean f = Boolean.valueOf(false);
    private k g;
    private String h;
    private String i;
    private Set<d> j;
    private boolean k = false;

    protected c(Context paramContext) {
        this(paramContext, bh.a(paramContext), aw.c());
    }

    private c(Context paramContext, aj paramaj, v paramv) {
        if (paramContext == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.e = paramContext.getApplicationContext();
        this.c = paramaj;
        this.d = paramv;
        ak.a(this.e);
        u.a(this.e);
        al.a(this.e);
        this.g = new aq();
        this.j = new HashSet();
        f();
    }

    private int a(String paramString) {
        paramString = paramString.toLowerCase();
        if ("verbose".equals(paramString)) {
            return 0;
        }
        if ("info".equals(paramString)) {
            return 1;
        }
        if ("warning".equals(paramString)) {
            return 2;
        }
        if ("error".equals(paramString)) {
            return 3;
        }
        return -1;
    }

    static c a() {
        try {
            c localc = l;
            return localc;
        } finally {
        }
    }

    public static c a(Context paramContext) {
        try {
            if (l == null) {
                l = new c(paramContext);
            }
            paramContext = l;
            return paramContext;
        } finally {
        }
    }

    private m a(m paramm) {
        if (this.i != null) {
            paramm.a("&an", this.i);
        }
        if (this.h != null) {
            paramm.a("&av", this.h);
        }
        return paramm;
    }

    private void f() {
        if (a) {
        }
        Object localObject;
        do {
            int m;
            do {
                do {
                    return;
                    try {
                        ApplicationInfo localApplicationInfo = this.e.getPackageManager().getApplicationInfo(this.e.getPackageName(), 129);
                        if (localApplicationInfo == null) {
                            bt.d("Couldn't get ApplicationInfo to load gloabl config.");
                            return;
                        }
                    } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
                        for (; ; ) {
                            bt.c("PackageManager doesn't know about package: " + localNameNotFoundException);
                            localObject = null;
                        }
                        localObject = ((ApplicationInfo) localObject).metaData;
                    }
                } while (localObject == null);
                m = ((Bundle) localObject).getInt("com.google.android.gms.analytics.globalConfigResource");
            } while (m <= 0);
            localObject = (bp) new bn(this.e).a(m);
        } while (localObject == null);
        a((bp) localObject);
    }

    public m a(int paramInt) {
        try {
            bl.a().a(bm.N);
            m localm = new m(null, this, this.e);
            if (paramInt > 0) {
                aa localaa = (aa) new y(this.e).a(paramInt);
                if (localaa != null) {
                    localm.a(localaa);
                }
            }
            localm = a(localm);
            return localm;
        } finally {
        }
    }

    void a(Activity paramActivity) {
        Iterator localIterator = this.j.iterator();
        while (localIterator.hasNext()) {
            ((d) localIterator.next()).a(paramActivity);
        }
    }

    public void a(Application paramApplication) {
        if ((Build.VERSION.SDK_INT >= 14) && (!this.k)) {
            paramApplication.registerActivityLifecycleCallbacks(new e(this));
            this.k = true;
        }
    }

    void a(bp parambp) {
        bt.c("Loading global config values.");
        if (parambp.a()) {
            this.i = parambp.b();
            bt.c("app name loaded: " + this.i);
        }
        if (parambp.c()) {
            this.h = parambp.d();
            bt.c("app version loaded: " + this.h);
        }
        if (parambp.e()) {
            int m = a(parambp.f());
            if (m >= 0) {
                bt.c("log level loaded: " + m);
                d().a(m);
            }
        }
        if (parambp.g()) {
            this.d.a(parambp.h());
        }
        if (parambp.i()) {
            a(parambp.j());
        }
    }

    void a(d paramd) {
        this.j.add(paramd);
        if ((this.e instanceof Application)) {
            a((Application) this.e);
        }
    }

    void a(Map<String, String> paramMap) {
        if (paramMap == null) {
            try {
                throw new IllegalArgumentException("hit cannot be null");
            } finally {
            }
        }
        ab.a(paramMap, "&ul", ab.a(Locale.getDefault()));
        ab.a(paramMap, "&sr", u.a());
        paramMap.put("&_u", bl.a().c());
        bl.a().b();
        this.c.a(paramMap);
    }

    public void a(boolean paramBoolean) {
        bl.a().a(bm.ac);
        this.b = paramBoolean;
    }

    void b(Activity paramActivity) {
        Iterator localIterator = this.j.iterator();
        while (localIterator.hasNext()) {
            ((d) localIterator.next()).b(paramActivity);
        }
    }

    void b(d paramd) {
        this.j.remove(paramd);
    }

    public boolean b() {
        bl.a().a(bm.ad);
        return this.b;
    }

    public boolean c() {
        bl.a().a(bm.R);
        return this.f.booleanValue();
    }

    public k d() {
        return this.g;
    }

    @Deprecated
    public void e() {
        this.d.a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */