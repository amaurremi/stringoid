package com.google.android.gcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class GCMBroadcastReceiver
        extends BroadcastReceiver {
    private static boolean a = false;

    static final String b(Context paramContext) {
        return paramContext.getPackageName() + ".GCMIntentService";
    }

    protected String a(Context paramContext) {
        return b(paramContext);
    }

    public final void onReceive(Context paramContext, Intent paramIntent) {
        Log.v("GCMBroadcastReceiver", "onReceive: " + paramIntent.getAction());
        if (!a) {
            a = true;
            str = getClass().getName();
            if (!str.equals(GCMBroadcastReceiver.class.getName())) {
                b.a(str);
            }
        }
        String str = a(paramContext);
        Log.v("GCMBroadcastReceiver", "GCM IntentService class: " + str);
        a.a(paramContext, paramIntent, str);
        setResult(-1, null, null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/google/android/gcm/GCMBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */