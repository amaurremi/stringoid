package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;

@ii
public final class jw {
    public static lo a(Context paramContext, fi paramfi, jx paramjx) {
        if (paramfi.k.e) {
            return b(paramContext, paramfi, paramjx);
        }
        return c(paramContext, paramfi, paramjx);
    }

    private static lo b(Context paramContext, fi paramfi, jx paramjx) {
        mx.a("Fetching ad response from local ad request service.");
        paramContext = new jz(paramContext, paramfi, paramjx);
        paramContext.e();
        return paramContext;
    }

    private static lo c(Context paramContext, fi paramfi, jx paramjx) {
        mx.a("Fetching ad response from remote ad request service.");
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext) != 0) {
            mx.e("Failed to connect to remote ad request service.");
            return null;
        }
        return new ka(paramContext, paramfi, paramjx);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/jw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */