package com.inneractive.api.ads.sdk;

import android.os.Build.VERSION;

enum IAdefines$ApiLevel {
    int i;

    static {
        a = new ApiLevel("GINGERBREAD", 8, 9);
        b = new ApiLevel("GINGERBREAD_MR1", 9, 10);
        c = new ApiLevel("HONEYCOMB", 10, 11);
        r = new ApiLevel("HONEYCOMB_MR1", 11, 12);
        d = new ApiLevel("HONEYCOMB_MR2", 12, 13);
        e = new ApiLevel("ICECREAM_SANDWICH", 13, 14);
        s = new ApiLevel("ICECREAM_SANDWICH_MR1", 14, 15);
        f = new ApiLevel("JELLYBEAN", 15, 16);
        t = new ApiLevel("JELLYBEAN_MR1", 16, 17);
    }

    private IAdefines$ApiLevel(int paramInt1) {
        this.i = paramInt1;
    }

    static ApiLevel a() {
        int i2 = Build.VERSION.SDK_INT;
        ApiLevel[] arrayOfApiLevel = values();
        int i3 = arrayOfApiLevel.length;
        int i1 = 0;
        while (i1 < i3) {
            ApiLevel localApiLevel = arrayOfApiLevel[i1];
            if (localApiLevel.i == i2) {
                return localApiLevel;
            }
            i1 += 1;
        }
        return u;
    }

    final boolean a(ApiLevel paramApiLevel) {
        return this.i >= paramApiLevel.i;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAdefines$ApiLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */