package com.google.android.gms.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.nu;

import java.util.List;
import java.util.Map;

class ad
        implements ac {
    private ServiceConnection a;
    private af b;
    private ag c;
    private Context d;
    private nu e;

    public ad(Context paramContext, af paramaf, ag paramag) {
        this.d = paramContext;
        if (paramaf == null) {
            throw new IllegalArgumentException("onConnectedListener cannot be null");
        }
        this.b = paramaf;
        if (paramag == null) {
            throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
        }
        this.c = paramag;
    }

    private nu f() {
        d();
        return this.e;
    }

    private void g() {
        h();
    }

    private void h() {
        this.b.d();
    }

    public void a() {
        try {
            f().a();
            return;
        } catch (RemoteException localRemoteException) {
            bt.a("clear hits failed: " + localRemoteException);
        }
    }

    public void a(Map<String, String> paramMap, long paramLong, String paramString, List<hb> paramList) {
        try {
            f().a(paramMap, paramLong, paramString, paramList);
            return;
        } catch (RemoteException paramMap) {
            bt.a("sendHit failed: " + paramMap);
        }
    }

    public void b() {
        Intent localIntent = new Intent("com.google.android.gms.analytics.service.START");
        localIntent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
        localIntent.putExtra("app_package_name", this.d.getPackageName());
        if (this.a != null) {
            bt.a("Calling connect() while still connected, missing disconnect().");
        }
        boolean bool;
        do {
            return;
            this.a = new ae(this);
            bool = this.d.bindService(localIntent, this.a, 129);
            bt.c("connect: bindService returned " + bool + " for " + localIntent);
        } while (bool);
        this.a = null;
        this.c.a(1, null);
    }

    public void c() {
        this.e = null;
        if (this.a != null) {
        }
        try {
            this.d.unbindService(this.a);
            this.a = null;
            this.b.e();
            return;
        } catch (IllegalArgumentException localIllegalArgumentException) {
            for (; ; ) {
            }
        } catch (IllegalStateException localIllegalStateException) {
            for (; ; ) {
            }
        }
    }

    protected void d() {
        if (!e()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public boolean e() {
        return this.e != null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/a/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */