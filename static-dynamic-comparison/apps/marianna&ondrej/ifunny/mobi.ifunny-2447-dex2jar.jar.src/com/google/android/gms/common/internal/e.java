package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.api.n;
import com.google.android.gms.common.d;

import java.util.ArrayList;

public abstract class e<T extends IInterface>
        implements b, o {
    public static final String[] c = {"service_esmobile", "service_googleme"};
    final Handler a;
    boolean b = false;
    private final Context d;
    private final Looper e;
    private T f;
    private final ArrayList<e<T>.g<?>> g = new ArrayList();
    private e<T>.j h;
    private volatile int i = 1;
    private final String[] j;
    private final m k;

    protected e(Context paramContext, Looper paramLooper, com.google.android.gms.common.api.m paramm, n paramn, String... paramVarArgs) {
        this.d = ((Context) ag.a(paramContext));
        this.e = ((Looper) ag.a(paramLooper, "Looper must not be null"));
        this.k = new m(paramContext, paramLooper, this);
        this.a = new f(this, paramLooper);
        a(paramVarArgs);
        this.j = paramVarArgs;
        a((com.google.android.gms.common.api.m) ag.a(paramm));
        a((n) ag.a(paramn));
    }

    @Deprecated
    protected e(Context paramContext, d paramd, com.google.android.gms.common.e parame, String... paramVarArgs) {
        this(paramContext, paramContext.getMainLooper(), new h(paramd), new k(parame), paramVarArgs);
    }

    private void a(int paramInt) {
        int m = this.i;
        this.i = paramInt;
        if (m != paramInt) {
            if (paramInt != 3) {
                break label25;
            }
            g();
        }
        label25:
        while ((m != 3) || (paramInt != 1)) {
            return;
        }
        h();
    }

    protected abstract T a(IBinder paramIBinder);

    public void a() {
        this.b = true;
        a(2);
        int m = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.d);
        if (m != 0) {
            a(1);
            this.a.sendMessage(this.a.obtainMessage(3, Integer.valueOf(m)));
        }
        do {
            return;
            if (this.h != null) {
                Log.e("GmsClient", "Calling connect() while still connected, missing disconnect().");
                this.f = null;
                p.a(this.d).b(e(), this.h);
            }
            this.h = new j(this);
        } while (p.a(this.d).a(e(), this.h));
        Log.e("GmsClient", "unable to connect to service: " + e());
        this.a.sendMessage(this.a.obtainMessage(3, Integer.valueOf(9)));
    }

    protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle) {
        this.a.sendMessage(this.a.obtainMessage(1, new l(this, paramInt, paramIBinder, paramBundle)));
    }

    public void a(com.google.android.gms.common.api.m paramm) {
        this.k.a(paramm);
    }

    public void a(n paramn) {
        this.k.a(paramn);
    }

    protected abstract void a(aa paramaa, i parami);

    @Deprecated
    public final void a(e<T>.g<?> parame) {
        synchronized (this.g) {
            this.g.add(parame);
            this.a.sendMessage(this.a.obtainMessage(2, parame));
            return;
        }
    }

    protected void a(String... paramVarArgs) {
    }

    public void b() {
        this.b = false;
        synchronized (this.g) {
            int n = this.g.size();
            int m = 0;
            while (m < n) {
                ((g) this.g.get(m)).d();
                m += 1;
            }
            this.g.clear();
            a(1);
            this.f = null;
            if (this.h != null) {
                p.a(this.d).b(e(), this.h);
                this.h = null;
            }
            return;
        }
    }

    protected final void b(IBinder paramIBinder) {
        try {
            a(ab.a(paramIBinder), new i(this));
            return;
        } catch (RemoteException paramIBinder) {
            Log.w("GmsClient", "service died");
        }
    }

    public Bundle b_() {
        return null;
    }

    public boolean c() {
        return this.i == 3;
    }

    public boolean c_() {
        return this.b;
    }

    public final Looper d() {
        return this.e;
    }

    protected abstract String e();

    protected abstract String f();

    protected void g() {
    }

    protected void h() {
    }

    public boolean i() {
        return this.i == 2;
    }

    public final Context j() {
        return this.d;
    }

    public final String[] k() {
        return this.j;
    }

    protected final void l() {
        if (!c()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T m() {
        l();
        return this.f;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/internal/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */