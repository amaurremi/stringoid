package com.google.analytics.tracking.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

class p
        extends BroadcastReceiver {
    static final String a = p.class.getName();
    private final ad b;

    p(ad paramad) {
        this.b = paramad;
    }

    public static void b(Context paramContext) {
        Intent localIntent = new Intent("com.google.analytics.RADIO_POWERED");
        localIntent.addCategory(paramContext.getPackageName());
        localIntent.putExtra(a, true);
        paramContext.sendBroadcast(localIntent);
    }

    public void a(Context paramContext) {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        paramContext.registerReceiver(this, localIntentFilter);
        localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.google.analytics.RADIO_POWERED");
        localIntentFilter.addCategory(paramContext.getPackageName());
        paramContext.registerReceiver(this, localIntentFilter);
    }

    public void onReceive(Context paramContext, Intent paramIntent) {
        boolean bool1 = false;
        paramContext = paramIntent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext)) {
            bool2 = paramIntent.getBooleanExtra("noConnectivity", false);
            paramContext = this.b;
            if (!bool2) {
                bool1 = true;
            }
            paramContext.a(bool1);
        }
        while ((!"com.google.analytics.RADIO_POWERED".equals(paramContext)) || (paramIntent.hasExtra(a))) {
            boolean bool2;
            return;
        }
        this.b.e();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/google/analytics/tracking/android/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */