package com.mopub.mobileads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

class MraidDisplayController$OrientationBroadcastReceiver
        extends BroadcastReceiver {
    private Context mContext;
    private int mLastRotation;

    MraidDisplayController$OrientationBroadcastReceiver(MraidDisplayController paramMraidDisplayController) {
    }

    private boolean isRegistered() {
        return this.mContext != null;
    }

    public void onReceive(Context paramContext, Intent paramIntent) {
        if (!isRegistered()) {
        }
        int i;
        do {
            do {
                return;
            } while (!paramIntent.getAction().equals("android.intent.action.CONFIGURATION_CHANGED"));
            i = MraidDisplayController.access$700(this.this$0);
        } while (i == this.mLastRotation);
        this.mLastRotation = i;
        MraidDisplayController.access$800(this.this$0, this.mLastRotation);
    }

    public void register(Context paramContext) {
        this.mContext = paramContext;
        paramContext.registerReceiver(this, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
    }

    public void unregister() {
        this.mContext.unregisterReceiver(this);
        this.mContext = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MraidDisplayController$OrientationBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */