package com.google.android.gms.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.nw;

final class ae
        implements ServiceConnection {
    ae(ad paramad) {
    }

    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
        bt.c("service connected, binder: " + paramIBinder);
        try {
            if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(paramIBinder.getInterfaceDescriptor())) {
                bt.c("bound to service");
                ad.a(this.a, nw.a(paramIBinder));
                ad.a(this.a);
                return;
            }
        } catch (RemoteException paramComponentName) {
        }
        try {
            ad.b(this.a).unbindService(this);
            ad.a(this.a, null);
            ad.c(this.a).a(2, null);
            return;
        } catch (IllegalArgumentException paramComponentName) {
            for (; ; ) {
            }
        }
    }

    public void onServiceDisconnected(ComponentName paramComponentName) {
        bt.c("service disconnected: " + paramComponentName);
        ad.a(this.a, null);
        ad.d(this.a).e();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/a/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */