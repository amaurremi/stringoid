package com.inneractive.api.ads.sdk;

import android.view.View;

final class IAadViewController$5
        implements Runnable {
    IAadViewController$5(IAadViewController paramIAadViewController, View paramView) {
    }

    public final void run() {
        InneractiveAdView localInneractiveAdView = this.b.c();
        if (localInneractiveAdView == null) {
            return;
        }
        localInneractiveAdView.removeAllViews();
        localInneractiveAdView.addView(this.a, IAadViewController.a(this.b).a(this.a, IAadViewController.b(this.b)));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAadViewController$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */