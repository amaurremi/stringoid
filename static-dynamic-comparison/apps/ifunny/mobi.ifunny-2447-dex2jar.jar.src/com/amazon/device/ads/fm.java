package com.amazon.device.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class fm
        extends BroadcastReceiver {
    private int b;

    fm(fl paramfl) {
    }

    public void onReceive(Context paramContext, Intent paramIntent) {
        try {
            if (paramIntent.getAction().equals("android.intent.action.CONFIGURATION_CHANGED")) {
                int i = fl.a(this.a);
                if (i != this.b) {
                    this.b = i;
                    fl.a(this.a, this.b);
                }
            }
            return;
        } catch (Exception paramContext) {
            dv.a("MraidDisplayController", "Orientation broadcast receiver got exception while executing: %s", new Object[]{paramContext.getLocalizedMessage()});
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/fm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */