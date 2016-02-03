package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.WeakHashMap;

public final class aa
        implements ac {
    private final Object li = new Object();
    private WeakHashMap<dh, ab> lj = new WeakHashMap();
    private ArrayList<ab> lk = new ArrayList();

    public ab a(ak paramak, dh paramdh) {
        synchronized (this.li) {
            if (c(paramdh)) {
                paramak = (ab) this.lj.get(paramdh);
                return paramak;
            }
            paramak = new ab(paramak, paramdh);
            paramak.a(this);
            this.lj.put(paramdh, paramak);
            this.lk.add(paramak);
            return paramak;
        }
    }

    public void a(ab paramab) {
        synchronized (this.li) {
            if (!paramab.at()) {
                this.lk.remove(paramab);
            }
            return;
        }
    }

    public boolean c(dh paramdh) {
        for (; ; ) {
            synchronized (this.li) {
                paramdh = (ab) this.lj.get(paramdh);
                if ((paramdh != null) && (paramdh.at())) {
                    bool = true;
                    return bool;
                }
            }
            boolean bool = false;
        }
    }

    public void d(dh paramdh) {
        synchronized (this.li) {
            paramdh = (ab) this.lj.get(paramdh);
            if (paramdh != null) {
                paramdh.ar();
            }
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */