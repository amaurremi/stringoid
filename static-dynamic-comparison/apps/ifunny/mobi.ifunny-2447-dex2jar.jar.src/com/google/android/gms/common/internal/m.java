package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.a;
import com.google.android.gms.common.e;

import java.util.ArrayList;
import java.util.Iterator;

public final class m {
    final ArrayList<com.google.android.gms.common.api.m> a = new ArrayList();
    private final o b;
    private final ArrayList<com.google.android.gms.common.api.m> c = new ArrayList();
    private boolean d = false;
    private final ArrayList<e> e = new ArrayList();
    private final Handler f;

    public m(Context paramContext, Looper paramLooper, o paramo) {
        this.b = paramo;
        this.f = new n(this, paramLooper);
    }

    protected void a() {
        synchronized (this.c) {
            a(this.b.b_());
            return;
        }
    }

    public void a(int paramInt) {
        this.f.removeMessages(1);
        synchronized (this.c) {
            this.d = true;
            Iterator localIterator = new ArrayList(this.c).iterator();
            com.google.android.gms.common.api.m localm;
            do {
                if (localIterator.hasNext()) {
                    localm = (com.google.android.gms.common.api.m) localIterator.next();
                    if (this.b.c_()) {
                    }
                } else {
                    this.d = false;
                    return;
                }
            } while (!this.c.contains(localm));
            localm.a(paramInt);
        }
    }

    public void a(Bundle paramBundle) {
        boolean bool2 = true;
        for (; ; ) {
            synchronized (this.c) {
                if (!this.d) {
                    bool1 = true;
                    ag.a(bool1);
                    this.f.removeMessages(1);
                    this.d = true;
                    if (this.a.size() != 0) {
                        break label165;
                    }
                    bool1 = bool2;
                    ag.a(bool1);
                    Iterator localIterator = new ArrayList(this.c).iterator();
                    com.google.android.gms.common.api.m localm;
                    if (localIterator.hasNext()) {
                        localm = (com.google.android.gms.common.api.m) localIterator.next();
                        if ((this.b.c_()) && (this.b.c())) {
                        }
                    } else {
                        this.a.clear();
                        this.d = false;
                        return;
                    }
                    if (this.a.contains(localm)) {
                        continue;
                    }
                    localm.a(paramBundle);
                }
            }
            boolean bool1 = false;
            continue;
            label165:
            bool1 = false;
        }
    }

    public void a(a parama) {
        this.f.removeMessages(1);
        synchronized (this.e) {
            Iterator localIterator = new ArrayList(this.e).iterator();
            while (localIterator.hasNext()) {
                e locale = (e) localIterator.next();
                if (!this.b.c_()) {
                    return;
                }
                if (this.e.contains(locale)) {
                    locale.a(parama);
                }
            }
        }
    }

    public void a(com.google.android.gms.common.api.m paramm) {
        ag.a(paramm);
        synchronized (this.c) {
            if (this.c.contains(paramm)) {
                Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + paramm + " is already registered");
                if (this.b.c()) {
                    this.f.sendMessage(this.f.obtainMessage(1, paramm));
                }
                return;
            }
            this.c.add(paramm);
        }
    }

    public void a(e parame) {
        ag.a(parame);
        synchronized (this.e) {
            if (this.e.contains(parame)) {
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + parame + " is already registered");
                return;
            }
            this.e.add(parame);
        }
    }

    public void b(com.google.android.gms.common.api.m paramm) {
        ag.a(paramm);
        synchronized (this.c) {
            if (this.c != null) {
                if (this.c.remove(paramm)) {
                    break label63;
                }
                Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + paramm + " not found");
            }
            label63:
            while (!this.d) {
                return;
            }
            this.a.add(paramm);
        }
    }

    public void b(e parame) {
        ag.a(parame);
        synchronized (this.e) {
            if ((this.e != null) && (!this.e.remove(parame))) {
                Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + parame + " not found");
            }
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/internal/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */