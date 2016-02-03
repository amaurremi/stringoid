package com.inneractive.api.ads.sdk;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class InneractiveAdView$1
        extends BroadcastReceiver {
    InneractiveAdView$1(InneractiveAdView paramInneractiveAdView) {
    }

    public final void onReceive(Context paramContext, Intent paramIntent) {
        int j = 1;
        InneractiveAdView.Log.v("Inneractive_verbose", "onReceive. action = " + paramIntent.getAction());
        paramContext = (KeyguardManager) InneractiveAdView.a(this.a).getSystemService("keyguard");
        int i = j;
        if (IAdefines.ApiLevel.a().a(IAdefines.ApiLevel.f)) {
        }
        try {
            paramContext = new IAreflectionHandler.a(paramContext, "isKeyguardLocked").a();
            if (paramContext == null) {
                break label159;
            }
            i = ((Integer) paramContext).intValue();
            if (i != 0) {
                break label159;
            }
            i = 1;
        } catch (Exception paramContext) {
            for (; ; ) {
                label159:
                InneractiveAdView.Log.d("Inneractive_debug", "Failed to get lock screen status");
                i = j;
            }
            InneractiveAdView.Log.v("Inneractive_verbose", "Refresh Disabled (screen is off and the ad is in the background).");
            return;
        }
        if ("android.intent.action.SCREEN_OFF".equals(paramIntent.getAction())) {
            if (InneractiveAdView.b(this.a)) {
                InneractiveAdView.Log.v("Inneractive_verbose", "Refresh Disabled (screen is off and ad is in foreground).");
                if (this.a.a != null) {
                    InneractiveAdView.a(this.a, this.a.a.k());
                    this.a.a.c(false);
                }
            }
        }
        do {
            do {
                return;
                i = 0;
                break;
            }
            while (((!"android.intent.action.SCREEN_ON".equals(paramIntent.getAction())) || (i != 0)) && (!"android.intent.action.USER_PRESENT".equals(paramIntent.getAction())));
            if (!InneractiveAdView.b(this.a)) {
                break label259;
            }
            InneractiveAdView.Log.v("Inneractive_verbose", "Enable Refresh (screen awake and ad is in foreground).");
        } while (this.a.a == null);
        this.a.a.c(InneractiveAdView.c(this.a));
        return;
        label259:
        InneractiveAdView.Log.v("Inneractive_verbose", "Refresh Disabled (screen is awake but ad is in background).");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/InneractiveAdView$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */