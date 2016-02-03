package com.millennialmedia.android;

import android.content.Context;

final class MMSDK$2
        extends AdCache.Iterator {
    MMSDK$2(Context paramContext) {
    }

    boolean a(CachedAd paramCachedAd) {
        String str2 = paramCachedAd.d();
        String str3 = paramCachedAd.e();
        String str1;
        if (paramCachedAd.d(this.a)) {
            str1 = "";
            if (!paramCachedAd.a()) {
                break label74;
            }
        }
        label74:
        for (paramCachedAd = ""; ; paramCachedAd = "not ") {
            MMLog.c("MMSDK", String.format("%s %s is %son disk. Is %sexpired.", new Object[]{str2, str3, str1, paramCachedAd}));
            return true;
            str1 = "not ";
            break;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMSDK$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */