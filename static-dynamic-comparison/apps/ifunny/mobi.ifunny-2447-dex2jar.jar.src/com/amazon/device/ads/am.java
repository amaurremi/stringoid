package com.amazon.device.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class am
        extends BroadcastReceiver {
    am(al paramal) {
    }

    public void onReceive(Context paramContext, Intent paramIntent) {
        if ((paramIntent.getAction().equals("android.intent.action.SCREEN_OFF")) && (al.a(this.a))) {
            al.b(this.a).a("close", null);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */