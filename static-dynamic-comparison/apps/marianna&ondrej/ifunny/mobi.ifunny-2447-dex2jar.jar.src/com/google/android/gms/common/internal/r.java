package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

import java.util.HashSet;
import java.util.Iterator;

public class r
        implements ServiceConnection {
    public r(q paramq) {
    }

    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
        synchronized (p.a(this.a.a)) {
            q.a(this.a, paramIBinder);
            q.a(this.a, paramComponentName);
            Iterator localIterator = q.a(this.a).iterator();
            if (localIterator.hasNext()) {
                ((j) localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
            }
        }
        q.a(this.a, 1);
    }

    public void onServiceDisconnected(ComponentName paramComponentName) {
        synchronized (p.a(this.a.a)) {
            q.a(this.a, null);
            q.a(this.a, paramComponentName);
            Iterator localIterator = q.a(this.a).iterator();
            if (localIterator.hasNext()) {
                ((j) localIterator.next()).onServiceDisconnected(paramComponentName);
            }
        }
        q.a(this.a, 2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/internal/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */