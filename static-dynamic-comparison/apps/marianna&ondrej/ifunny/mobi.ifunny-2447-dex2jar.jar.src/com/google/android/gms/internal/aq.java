package com.google.android.gms.internal;

import com.google.android.gms.ads.a;

@ii
public final class aq
        extends ba {
    private final a a;

    public aq(a parama) {
        this.a = parama;
    }

    public void a() {
        this.a.onAdClosed();
    }

    public void a(int paramInt) {
        this.a.onAdFailedToLoad(paramInt);
    }

    public void b() {
        this.a.onAdLeftApplication();
    }

    public void c() {
        this.a.onAdLoaded();
    }

    public void d() {
        this.a.onAdOpened();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */