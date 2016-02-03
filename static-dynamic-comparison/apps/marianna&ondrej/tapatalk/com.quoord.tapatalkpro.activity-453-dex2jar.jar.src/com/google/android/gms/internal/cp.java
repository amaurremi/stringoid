package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;

public final class cp
        extends co.a {
    private final InAppPurchaseListener mp;

    public cp(InAppPurchaseListener paramInAppPurchaseListener) {
        this.mp = paramInAppPurchaseListener;
    }

    public void a(cn paramcn) {
        this.mp.onInAppPurchaseRequested(new cq(paramcn));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */