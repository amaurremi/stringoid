package com.google.android.gms.internal;

import java.util.Map;

class kw
        implements cp {
    kw(ku paramku) {
    }

    public void a(mz parammz, Map<String, String> paramMap) {
        ky localky;
        String str;
        synchronized (ku.a(this.a)) {
            if (ku.b(this.a).isDone()) {
                return;
            }
            localky = new ky(-2, paramMap);
            str = localky.d();
            if (str == null) {
                mx.e("URL missing in loadAdUrl GMSG.");
                return;
            }
        }
        if (str.contains("%40mediation_adapters%40")) {
            parammz = str.replaceAll("%40mediation_adapters%40", ln.a(parammz.getContext(), (String) paramMap.get("check_adapters"), ku.c(this.a)));
            localky.a(parammz);
            mx.d("Ad request URL modified to " + parammz);
        }
        ku.b(this.a).a(localky);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/kw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */