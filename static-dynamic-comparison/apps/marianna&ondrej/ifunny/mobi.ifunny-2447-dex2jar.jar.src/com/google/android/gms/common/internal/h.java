package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.m;
import com.google.android.gms.common.d;

public final class h
        implements m {
    private final d a;

    public h(d paramd) {
        this.a = paramd;
    }

    public void a(int paramInt) {
        this.a.D_();
    }

    public void a(Bundle paramBundle) {
        this.a.a(paramBundle);
    }

    public boolean equals(Object paramObject) {
        if ((paramObject instanceof h)) {
            return this.a.equals(((h) paramObject).a);
        }
        return this.a.equals(paramObject);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/internal/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */