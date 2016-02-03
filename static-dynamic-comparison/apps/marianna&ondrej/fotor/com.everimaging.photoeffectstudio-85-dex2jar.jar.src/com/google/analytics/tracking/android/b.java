package com.google.analytics.tracking.android;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.analytics.internal.a.a;

import java.util.List;
import java.util.Map;

class b
        implements a {
    private ServiceConnection a;
    private b b;
    private c c;
    private Context d;
    private com.google.android.gms.analytics.internal.a e;

    public b(Context paramContext, b paramb, c paramc) {
        this.d = paramContext;
        if (paramb == null) {
            throw new IllegalArgumentException("onConnectedListener cannot be null");
        }
        this.b = paramb;
        if (paramc == null) {
            throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
        }
        this.c = paramc;
    }

    private com.google.android.gms.analytics.internal.a f() {
        d();
        return this.e;
    }

    private void g() {
        h();
    }

    private void h() {
        this.b.a();
    }

    public void a() {
        try {
            f().a();
            return;
        } catch (RemoteException localRemoteException) {
            v.a("clear hits failed: " + localRemoteException);
        }
    }

    public void a(Map<String, String> paramMap, long paramLong, String paramString, List<Command> paramList) {
        try {
            f().a(paramMap, paramLong, paramString, paramList);
            return;
        } catch (RemoteException paramMap) {
            v.a("sendHit failed: " + paramMap);
        }
    }

    public void b() {
        Intent localIntent = new Intent("com.google.android.gms.analytics.service.START");
        localIntent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
        localIntent.putExtra("app_package_name", this.d.getPackageName());
        if (this.a != null) {
            v.a("Calling connect() while still connected, missing disconnect().");
        }
        boolean bool;
        do {
            return;
            this.a = new a();
            bool = this.d.bindService(localIntent, this.a, 129);
            v.c("connect: bindService returned " + bool + " for " + localIntent);
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
            this.b.b();
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

    final class a
            implements ServiceConnection {
        a() {
        }

        public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
            v.c("service connected, binder: " + paramIBinder);
            try {
                if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(paramIBinder.getInterfaceDescriptor())) {
                    v.c("bound to service");
                    b.a(b.this, a.a.a(paramIBinder));
                    b.a(b.this);
                    return;
                }
            } catch (RemoteException paramComponentName) {
                b.b(b.this).unbindService(this);
                b.a(b.this, null);
                b.c(b.this).a(2, null);
            }
        }

        public void onServiceDisconnected(ComponentName paramComponentName) {
            v.c("service disconnected: " + paramComponentName);
            b.a(b.this, null);
            b.d(b.this).b();
        }
    }

    public static abstract interface b {
        public abstract void a();

        public abstract void b();
    }

    public static abstract interface c {
        public abstract void a(int paramInt, Intent paramIntent);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/google/analytics/tracking/android/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */