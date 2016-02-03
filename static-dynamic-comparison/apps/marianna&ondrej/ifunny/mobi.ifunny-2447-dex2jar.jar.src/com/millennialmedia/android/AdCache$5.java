package com.millennialmedia.android;

import android.content.Context;

final class AdCache$5
        extends AdCache.Iterator {
    AdCache$5(Context paramContext) {
    }

    boolean a(CachedAd paramCachedAd) {
        MMLog.b("AdCache", String.format("Deleting ad %s.", new Object[]{paramCachedAd.e()}));
        paramCachedAd.c(this.a);
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/AdCache$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */