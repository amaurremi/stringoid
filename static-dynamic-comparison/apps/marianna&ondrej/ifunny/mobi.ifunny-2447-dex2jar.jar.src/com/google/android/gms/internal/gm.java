package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

@ii
public final class gm
        extends hd
        implements ServiceConnection {
    private boolean a = false;
    private Context b;
    private int c;
    private Intent d;
    private gf e;
    private gl f;
    private String g;

    public gm(Context paramContext, String paramString, boolean paramBoolean, int paramInt, Intent paramIntent, gl paramgl) {
        this.g = paramString;
        this.c = paramInt;
        this.d = paramIntent;
        this.a = paramBoolean;
        this.b = paramContext;
        this.f = paramgl;
    }

    public boolean a() {
        return this.a;
    }

    public String b() {
        return this.g;
    }

    public Intent c() {
        return this.d;
    }

    public int d() {
        return this.c;
    }

    public void e() {
        int i = gp.a(this.d);
        if ((this.c != -1) || (i != 0)) {
            return;
        }
        this.e = new gf(this.b);
        Context localContext1 = this.b;
        Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        Context localContext2 = this.b;
        localContext1.bindService(localIntent, this, 1);
    }

    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
        mx.c("In-app billing service connected.");
        this.e.a(paramIBinder);
        paramComponentName = gp.b(gp.b(this.d));
        if (paramComponentName == null) {
            return;
        }
        if (this.e.a(this.b.getPackageName(), paramComponentName) == 0) {
            gn.a(this.b).a(this.f);
        }
        this.b.unbindService(this);
        this.e.a();
    }

    public void onServiceDisconnected(ComponentName paramComponentName) {
        mx.c("In-app billing service disconnected.");
        this.e.a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/gm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */