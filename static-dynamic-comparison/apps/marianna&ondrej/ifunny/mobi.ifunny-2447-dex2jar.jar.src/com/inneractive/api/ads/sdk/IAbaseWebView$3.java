package com.inneractive.api.ads.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class IAbaseWebView$3
        extends BroadcastReceiver {
    IAbaseWebView$3(IAbaseWebView paramIAbaseWebView) {
    }

    public final void onReceive(Context paramContext, Intent paramIntent) {
        InneractiveAdView.Log.v("Inneractive_verbose", "onReceive. action = " + paramIntent.getAction());
        "android.intent.action.SCREEN_OFF".equals(paramIntent.getAction());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAbaseWebView$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */