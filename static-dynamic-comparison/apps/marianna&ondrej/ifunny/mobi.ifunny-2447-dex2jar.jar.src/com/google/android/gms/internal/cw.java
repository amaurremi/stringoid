package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;

@ii
public final class cw {
    public static void a(Context paramContext, cy paramcy) {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext) != 0) {
            paramcy.a(bt.a());
            return;
        }
        new cx(paramContext, paramcy);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */