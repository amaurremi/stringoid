package com.facebook.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.a.n;

class InterstitialAd$AdInterstitialBroadcastReceiver
        extends BroadcastReceiver {
    private InterstitialAd$AdInterstitialBroadcastReceiver(InterstitialAd paramInterstitialAd) {
    }

    public void onReceive(Context paramContext, Intent paramIntent) {
        if (InterstitialAd.access$200(this.this$0) == null) {
        }
        do {
            do {
                return;
                paramContext = paramIntent.getStringExtra("adInterstitialUniqueId");
            } while (!InterstitialAd.access$400(this.this$0).equals(paramContext));
            paramContext = paramIntent.getAction();
            if ("com.facebook.ads.interstitial.clicked".equals(paramContext)) {
                InterstitialAd.access$200(this.this$0).onAdClicked(this.this$0);
                return;
            }
            if ("com.facebook.ads.interstitial.dismissed".equals(paramContext)) {
                InterstitialAd.access$200(this.this$0).onInterstitialDismissed(this.this$0);
                return;
            }
        } while (!"com.facebook.ads.interstitial.displayed".equals(paramContext));
        InterstitialAd.access$200(this.this$0).onInterstitialDisplayed(this.this$0);
    }

    public void register() {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.facebook.ads.interstitial.displayed");
        localIntentFilter.addAction("com.facebook.ads.interstitial.dismissed");
        localIntentFilter.addAction("com.facebook.ads.interstitial.clicked");
        n.a(InterstitialAd.access$500(this.this$0)).a(this, localIntentFilter);
    }

    public void unregister() {
        n.a(InterstitialAd.access$500(this.this$0)).a(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/InterstitialAd$AdInterstitialBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */