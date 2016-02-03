package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.au;

public final class InterstitialAd {
    private final au kv;

    public InterstitialAd(Context paramContext) {
        this.kv = new au(paramContext);
    }

    public AdListener getAdListener() {
        return this.kv.getAdListener();
    }

    public String getAdUnitId() {
        return this.kv.getAdUnitId();
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.kv.getInAppPurchaseListener();
    }

    public boolean isLoaded() {
        return this.kv.isLoaded();
    }

    public void loadAd(AdRequest paramAdRequest) {
        this.kv.a(paramAdRequest.O());
    }

    public void setAdListener(AdListener paramAdListener) {
        this.kv.setAdListener(paramAdListener);
    }

    public void setAdUnitId(String paramString) {
        this.kv.setAdUnitId(paramString);
    }

    public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener) {
        this.kv.setInAppPurchaseListener(paramInAppPurchaseListener);
    }

    public void show() {
        this.kv.show();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/ads/InterstitialAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */