package com.google.ads.mediation.admob;

import com.google.android.gms.ads.a;
import com.google.android.gms.ads.b.f;

final class AdMobAdapter$b
        extends a {
    private final AdMobAdapter k;
    private final f m;

    public AdMobAdapter$b(AdMobAdapter paramAdMobAdapter, f paramf) {
        this.k = paramAdMobAdapter;
        this.m = paramf;
    }

    public void onAdClosed() {
        this.m.c(this.k);
    }

    public void onAdFailedToLoad(int paramInt) {
        this.m.a(this.k, paramInt);
    }

    public void onAdLeftApplication() {
        this.m.d(this.k);
    }

    public void onAdLoaded() {
        this.m.a(this.k);
    }

    public void onAdOpened() {
        this.m.b(this.k);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/ads/mediation/admob/AdMobAdapter$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */