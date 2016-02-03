package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.api.o;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.plus.a;
import com.google.android.gms.plus.internal.i;

public final class rn
        implements a {
    private static i a(k paramk, com.google.android.gms.common.api.d<i> paramd) {
        boolean bool2 = true;
        if (paramk != null) {
            bool1 = true;
            ag.b(bool1, "GoogleApiClient parameter is required.");
            ag.a(paramk.c(), "GoogleApiClient must be connected.");
            paramk = (i) paramk.a(paramd);
            if (paramk == null) {
                break label55;
            }
        }
        label55:
        for (boolean bool1 = bool2; ; bool1 = false) {
            ag.a(bool1, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
            return paramk;
            bool1 = false;
            break;
        }
    }

    public o<Status> a(k paramk) {
        return paramk.a(new ro(this));
    }

    public void b(k paramk) {
        a(paramk, com.google.android.gms.plus.d.a).p();
    }

    public String c(k paramk) {
        return a(paramk, com.google.android.gms.plus.d.a).n();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/rn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */