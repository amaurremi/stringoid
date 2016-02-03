package com.millennialmedia.android;

import android.content.Context;

import java.util.Set;

final class AdCache$1
        extends AdCache.Iterator {
    AdCache$1(Context paramContext, Set paramSet) {
    }

    boolean a(CachedAd paramCachedAd) {
        if ((paramCachedAd.a != null) && (paramCachedAd.c() == 1) && (paramCachedAd.d(this.a))) {
            this.b.add(paramCachedAd.a);
        }
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/AdCache$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */