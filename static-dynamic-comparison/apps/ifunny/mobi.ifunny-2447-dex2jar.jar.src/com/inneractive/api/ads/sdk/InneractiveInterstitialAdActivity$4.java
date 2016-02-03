package com.inneractive.api.ads.sdk;

import android.view.View;
import android.view.View.OnClickListener;

final class InneractiveInterstitialAdActivity$4
        implements View.OnClickListener {
    InneractiveInterstitialAdActivity$4(InneractiveInterstitialAdActivity paramInneractiveInterstitialAdActivity) {
    }

    public final void onClick(View paramView) {
        this.this$0.finish();
        if (InneractiveInterstitialAdActivity.mAdInterfaceListener != null) {
            InneractiveInterstitialAdActivity.mAdInterfaceListener.e();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/InneractiveInterstitialAdActivity$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */