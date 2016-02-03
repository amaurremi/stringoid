package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class ly
        extends BroadcastReceiver {
    public void onReceive(Context paramContext, Intent paramIntent) {
        if ("android.intent.action.USER_PRESENT".equals(paramIntent.getAction())) {
            lw.a(true);
        }
        while (!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction())) {
            return;
        }
        lw.a(false);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */