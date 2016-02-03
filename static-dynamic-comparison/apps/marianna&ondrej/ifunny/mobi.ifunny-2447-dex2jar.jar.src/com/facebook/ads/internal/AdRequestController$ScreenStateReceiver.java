package com.facebook.ads.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class AdRequestController$ScreenStateReceiver
        extends BroadcastReceiver {
    private AdRequestController$ScreenStateReceiver(AdRequestController paramAdRequestController) {
    }

    public void onReceive(Context paramContext, Intent paramIntent) {
        paramContext = paramIntent.getAction();
        if ("android.intent.action.SCREEN_OFF".equals(paramContext)) {
            AdRequestController.access$600(this.this$0, paramIntent.getAction());
        }
        while ((!"android.intent.action.SCREEN_ON".equals(paramContext)) || (AdRequestController.access$700(this.this$0) != 0)) {
            return;
        }
        this.this$0.scheduleRefresh(paramIntent.getAction());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/internal/AdRequestController$ScreenStateReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */