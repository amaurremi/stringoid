package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@ii
public class gg
        extends lo
        implements ServiceConnection {
    private final Object a = new Object();
    private boolean b = false;
    private Context c;
    private hh d;
    private gf e;
    private gn f;
    private List<gl> g = null;
    private gq h;

    public gg(Context paramContext, hh paramhh, gq paramgq) {
        this.c = paramContext;
        this.d = paramhh;
        this.h = paramgq;
        this.e = new gf(paramContext);
        this.f = gn.a(this.c);
        this.g = this.f.a(10L);
    }

    private void a(long paramLong) {
        do {
            if (!b(paramLong)) {
                mx.e("Timeout waiting for pending transaction to be processed.");
            }
        } while (!this.b);
    }

    private void a(gl paramgl, String paramString1, String paramString2) {
        Intent localIntent = new Intent();
        localIntent.putExtra("RESPONSE_CODE", 0);
        localIntent.putExtra("INAPP_PURCHASE_DATA", paramString1);
        localIntent.putExtra("INAPP_DATA_SIGNATURE", paramString2);
        mv.a.post(new gh(this, paramgl, localIntent));
    }

    private boolean b(long paramLong) {
        paramLong = 60000L - (SystemClock.elapsedRealtime() - paramLong);
        if (paramLong <= 0L) {
            return false;
        }
        try {
            this.a.wait(paramLong);
            return true;
        } catch (InterruptedException localInterruptedException) {
            for (; ; ) {
                mx.e("waitWithTimeout_lock interrupted");
            }
        }
    }

    private void c() {
        if (this.g.isEmpty()) {
            return;
        }
        HashMap localHashMap = new HashMap();
        Object localObject1 = this.g.iterator();
        Object localObject2;
        while (((Iterator) localObject1).hasNext()) {
            localObject2 = (gl) ((Iterator) localObject1).next();
            localHashMap.put(((gl) localObject2).c, localObject2);
        }
        localObject1 = null;
        for (; ; ) {
            localObject1 = this.e.b(this.c.getPackageName(), (String) localObject1);
            if (localObject1 == null) {
            }
            do {
                do {
                    localObject1 = localHashMap.keySet().iterator();
                    while (((Iterator) localObject1).hasNext()) {
                        localObject2 = (String) ((Iterator) localObject1).next();
                        this.f.a((gl) localHashMap.get(localObject2));
                    }
                    break;
                } while (gp.a((Bundle) localObject1) != 0);
                localObject2 = ((Bundle) localObject1).getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList localArrayList1 = ((Bundle) localObject1).getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList localArrayList2 = ((Bundle) localObject1).getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                localObject1 = ((Bundle) localObject1).getString("INAPP_CONTINUATION_TOKEN");
                int i = 0;
                while (i < ((ArrayList) localObject2).size()) {
                    if (localHashMap.containsKey(((ArrayList) localObject2).get(i))) {
                        String str1 = (String) ((ArrayList) localObject2).get(i);
                        String str2 = (String) localArrayList1.get(i);
                        String str3 = (String) localArrayList2.get(i);
                        gl localgl = (gl) localHashMap.get(str1);
                        String str4 = gp.a(str2);
                        if (localgl.b.equals(str4)) {
                            a(localgl, str2, str3);
                            localHashMap.remove(str1);
                        }
                    }
                    i += 1;
                }
            } while ((localObject1 == null) || (localHashMap.isEmpty()));
        }
    }

    public void a() {
        synchronized (this.a) {
            Context localContext1 = this.c;
            Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            Context localContext2 = this.c;
            localContext1.bindService(localIntent, this, 1);
            a(SystemClock.elapsedRealtime());
            this.c.unbindService(this);
            this.e.a();
            return;
        }
    }

    public void b() {
        synchronized (this.a) {
            this.c.unbindService(this);
            this.e.a();
            return;
        }
    }

    public void onServiceConnected(ComponentName arg1, IBinder paramIBinder) {
        synchronized (this.a) {
            this.e.a(paramIBinder);
            c();
            this.b = true;
            this.a.notify();
            return;
        }
    }

    public void onServiceDisconnected(ComponentName paramComponentName) {
        mx.c("In-app billing service disconnected.");
        this.e.a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/gg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */