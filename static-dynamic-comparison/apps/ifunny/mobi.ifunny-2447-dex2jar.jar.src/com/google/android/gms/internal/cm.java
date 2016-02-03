package com.google.android.gms.internal;

import java.util.Map;

final class cm
        implements cp {
    public void a(mz parammz, Map<String, String> paramMap) {
        paramMap = (String) paramMap.get("u");
        if (paramMap == null) {
            mx.e("URL missing from httpTrack GMSG.");
            return;
        }
        new mu(parammz.getContext(), parammz.i().b, paramMap).e();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */