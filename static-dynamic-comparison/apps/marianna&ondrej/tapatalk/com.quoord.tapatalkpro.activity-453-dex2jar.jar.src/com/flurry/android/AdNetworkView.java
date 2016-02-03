package com.flurry.android;

import android.content.Context;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.sdk.e;
import com.flurry.sdk.i;

import java.util.Map;

public abstract class AdNetworkView
        extends i {
    private final AdCreative a;

    public AdNetworkView(Context paramContext, AdCreative paramAdCreative) {
        super(paramContext, null, null);
        this.a = paramAdCreative;
    }

    public AdNetworkView(Context paramContext, FlurryAdModule paramFlurryAdModule, e parame, AdCreative paramAdCreative) {
        super(paramContext, paramFlurryAdModule, parame);
        this.a = paramAdCreative;
    }

    public AdCreative getAdCreative() {
        return this.a;
    }

    public void onAdClicked(Map<String, String> paramMap) {
        super.onEvent("clicked", paramMap);
    }

    public void onAdClosed(Map<String, String> paramMap) {
        super.onEvent("adClosed", paramMap);
    }

    public void onAdFilled(Map<String, String> paramMap) {
        super.onEvent("filled", paramMap);
    }

    public void onAdPrepared(Map<String, String> paramMap) {
        super.onEvent("prepared", paramMap);
    }

    public void onAdShown(Map<String, String> paramMap) {
        super.onEvent("rendered", paramMap);
    }

    public void onAdUnFilled(Map<String, String> paramMap) {
        super.onEvent("unfilled", paramMap);
    }

    public void onRenderFailed(Map<String, String> paramMap) {
        super.onEvent("renderFailed", paramMap);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/android/AdNetworkView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */