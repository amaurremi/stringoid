package com.google.android.gms.internal;

import java.util.Map;

class kv
        implements cp {
    kv(ku paramku) {
    }

    public void a(mz arg1, Map<String, String> paramMap) {
        synchronized (ku.a(this.a)) {
            if (ku.b(this.a).isDone()) {
                return;
            }
            paramMap = new ky(1, paramMap);
            mx.e("Invalid " + paramMap.e() + " request error: " + paramMap.b());
            ku.b(this.a).a(paramMap);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/kv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */