package com.google.android.gms.internal;

import android.net.Uri;

import java.util.Map;

final class cj
        implements cp {
    public void a(mz parammz, Map<String, String> paramMap) {
        str = (String) paramMap.get("u");
        if (str == null) {
            mx.e("URL missing from click GMSG.");
            return;
        }
        paramMap = Uri.parse(str);
        try {
            Object localObject = parammz.h();
            if ((localObject == null) || (!((pv) localObject).b(paramMap))) {
                break label111;
            }
            localObject = ((pv) localObject).a(paramMap, parammz.getContext());
            paramMap = (Map<String, String>) localObject;
        } catch (qu localqu) {
            for (; ; ) {
                mx.e("Unable to append parameter to URL: " + str);
            }
        }
        paramMap = paramMap.toString();
        new mu(parammz.getContext(), parammz.i().b, paramMap).e();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */