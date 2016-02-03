package com.google.android.gcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class GCMBroadcastReceiver
        extends BroadcastReceiver {
    private static final String TAG = "GCMBroadcastReceiver";

    protected String getGCMIntentServiceClassName(Context paramContext) {
        return paramContext.getPackageName() + ".GCMIntentService";
    }

    public final void onReceive(Context paramContext, Intent paramIntent) {
        GCMBaseIntentService.runIntentInService(paramContext, paramIntent, getGCMIntentServiceClassName(paramContext));
        setResult(-1, null, null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gcm/GCMBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */