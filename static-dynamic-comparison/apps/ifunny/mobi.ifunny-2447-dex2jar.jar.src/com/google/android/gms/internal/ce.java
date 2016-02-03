package com.google.android.gms.internal;

import java.util.Map;

@ii
public final class ce
        implements cp {
    private final cf a;

    public ce(cf paramcf) {
        this.a = paramcf;
    }

    public void a(mz parammz, Map<String, String> paramMap) {
        parammz = (String) paramMap.get("name");
        if (parammz == null) {
            mx.e("App event with no name parameter.");
            return;
        }
        this.a.a(parammz, (String) paramMap.get("info"));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */