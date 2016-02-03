package com.google.android.gms.common.internal;

import com.google.android.gms.common.a;
import com.google.android.gms.common.api.n;
import com.google.android.gms.common.e;

public final class k
        implements n {
    private final e a;

    public k(e parame) {
        this.a = parame;
    }

    public void a(a parama) {
        this.a.a(parama);
    }

    public boolean equals(Object paramObject) {
        if ((paramObject instanceof k)) {
            return this.a.equals(((k) paramObject).a);
        }
        return this.a.equals(paramObject);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/internal/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */