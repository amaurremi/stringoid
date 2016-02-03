package com.google.android.gms.internal;

import java.util.Map;

final class co
        implements cp {
    public void a(mz parammz, Map<String, String> paramMap) {
        String str1 = (String) paramMap.get("tx");
        String str2 = (String) paramMap.get("ty");
        paramMap = (String) paramMap.get("td");
        try {
            int i = Integer.parseInt(str1);
            int j = Integer.parseInt(str2);
            int k = Integer.parseInt(paramMap);
            parammz = parammz.h();
            if (parammz != null) {
                parammz.a().a(i, j, k);
            }
            return;
        } catch (NumberFormatException parammz) {
            mx.e("Could not parse touch parameters from gmsg.");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/co.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */