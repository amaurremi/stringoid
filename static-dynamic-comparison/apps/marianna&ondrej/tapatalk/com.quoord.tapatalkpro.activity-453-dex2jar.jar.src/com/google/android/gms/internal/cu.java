package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;

public final class cu {
    public static do

    a(Context paramContext, cx paramcx, a parama) {
        if (paramcx.kK.rt) {
            return b(paramContext, paramcx, parama);
        }
        return c(paramContext, paramcx, parama);
    }

    private static do

    b(Context paramContext, cx paramcx, a parama) {
        dw.v("Fetching ad response from local ad request service.");
        paramContext = new cv.a(paramContext, paramcx, parama);
        paramContext.start();
        return paramContext;
    }

    private static do

    c(Context paramContext, cx paramcx, a parama) {
        dw.v("Fetching ad response from remote ad request service.");
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext) != 0) {
            dw.z("Failed to connect to remote ad request service.");
            return null;
        }
        return new cv.b(paramContext, paramcx, parama);
    }

    public static abstract interface a {
        public abstract void a(cz paramcz);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */