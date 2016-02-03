package com.facebook.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.ads.internal.HtmlAdHandler;

class AdView$ScreenStateReceiver
        extends BroadcastReceiver {
    private AdView$ScreenStateReceiver(AdView paramAdView) {
    }

    public void onReceive(Context paramContext, Intent paramIntent) {
        if ("android.intent.action.SCREEN_OFF".equals(paramIntent.getAction())) {
            AdView.access$400(this.this$0).cancelImpressionRetry();
            return;
        }
        AdView.access$400(this.this$0).scheduleImpressionRetry();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/AdView$ScreenStateReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */