package com.google.android.gms.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

@ii
public class gj
        extends ha
        implements ServiceConnection {
    private final Activity a;
    private final gn b;
    private Context c;
    private hh d;
    private gs e;
    private gf f;
    private gl g;
    private gq h;
    private String i;

    public static void a(Context paramContext, boolean paramBoolean, dv paramdv) {
        Intent localIntent = new Intent();
        localIntent.setClassName(paramContext, "com.google.android.gms.ads.purchase.InAppPurchaseActivity");
        localIntent.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", paramBoolean);
        dv.a(localIntent, paramdv);
        paramContext.startActivity(localIntent);
    }

    private void a(String paramString, boolean paramBoolean, int paramInt, Intent paramIntent) {
        try {
            this.d.a(new gm(this.c, paramString, paramBoolean, paramInt, paramIntent, this.g));
            return;
        } catch (RemoteException paramString) {
            mx.e("Fail to invoke PlayStorePurchaseListener.");
        }
    }

    public void a() {
        Object localObject = dv.a(this.a.getIntent());
        this.d = ((dv) localObject).b;
        this.h = ((dv) localObject).c;
        this.e = ((dv) localObject).d;
        this.f = new gf(this.a.getApplicationContext());
        this.c = ((dv) localObject).e;
        localObject = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        ((Intent) localObject).setPackage("com.android.vending");
        this.a.bindService((Intent) localObject, this, 1);
    }

    public void a(int paramInt1, int paramInt2, Intent paramIntent) {
        if (paramInt1 == 1001) {
        }
        for (; ; ) {
            try {
                paramInt1 = gp.a(paramIntent);
                if ((paramInt2 != -1) || (paramInt1 != 0)) {
                    continue;
                }
                if (!this.h.a(this.i, paramInt2, paramIntent)) {
                    continue;
                }
                a(this.e.a(), true, paramInt2, paramIntent);
            } catch (RemoteException paramIntent) {
                mx.e("Fail to process purchase result.");
                return;
                this.b.a(this.g);
                a(this.e.a(), false, paramInt2, paramIntent);
                continue;
            } finally {
                this.i = null;
                this.a.finish();
            }
            this.e.c(paramInt1);
            this.i = null;
            this.a.finish();
            return;
            a(this.e.a(), false, paramInt2, paramIntent);
        }
    }

    public void b() {
        this.a.unbindService(this);
        this.f.a();
    }

    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
        this.f.a(paramIBinder);
        try {
            this.i = this.h.a();
            paramComponentName = this.f.a(this.a.getPackageName(), this.e.a(), this.i);
            paramIBinder = (PendingIntent) paramComponentName.getParcelable("BUY_INTENT");
            if (paramIBinder == null) {
                int j = gp.a(paramComponentName);
                this.e.c(j);
                a(this.e.a(), false, j, null);
                this.a.finish();
                return;
            }
            this.g = new gl(this.e.a(), this.i);
            this.b.b(this.g);
            this.a.startIntentSenderForResult(paramIBinder.getIntentSender(), 1001, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
            return;
        } catch (RemoteException paramComponentName) {
            mx.d("Error when connecting in-app billing service", paramComponentName);
            this.a.finish();
            return;
        } catch (IntentSender.SendIntentException paramComponentName) {
            for (; ; ) {
            }
        }
    }

    public void onServiceDisconnected(ComponentName paramComponentName) {
        mx.c("In-app billing service disconnected.");
        this.f.a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/gj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */