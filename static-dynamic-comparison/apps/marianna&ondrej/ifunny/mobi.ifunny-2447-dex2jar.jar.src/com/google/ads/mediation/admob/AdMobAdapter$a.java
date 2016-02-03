package com.google.ads.mediation.admob;

import com.google.android.gms.ads.a;
import com.google.android.gms.ads.b.d;

final class AdMobAdapter$a
        extends a {
    private final AdMobAdapter k;
    private final d l;

    public AdMobAdapter$a(AdMobAdapter paramAdMobAdapter, d paramd) {
        this.k = paramAdMobAdapter;
        this.l = paramd;
    }

    public void onAdClosed() {
        this.l.c(this.k);
    }

    public void onAdFailedToLoad(int paramInt) {
        this.l.a(this.k, paramInt);
    }

    public void onAdLeftApplication() {
        this.l.d(this.k);
    }

    public void onAdLoaded() {
        this.l.a(this.k);
    }

    public void onAdOpened() {
        this.l.e(this.k);
        this.l.b(this.k);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/ads/mediation/admob/AdMobAdapter$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */