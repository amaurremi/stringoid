package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.AppEventListener;

public final class am
        extends ar.a {
    private final AppEventListener lV;

    public am(AppEventListener paramAppEventListener) {
        this.lV = paramAppEventListener;
    }

    public void onAppEvent(String paramString1, String paramString2) {
        this.lV.onAppEvent(paramString1, paramString2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */