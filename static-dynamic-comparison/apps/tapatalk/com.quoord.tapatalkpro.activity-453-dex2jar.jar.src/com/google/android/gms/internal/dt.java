package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebSettings;

public final class dt {
    public static void a(Context paramContext, WebSettings paramWebSettings) {
        ds.a(paramContext, paramWebSettings);
        paramWebSettings.setMediaPlaybackRequiresUserGesture(false);
    }

    public static String getDefaultUserAgent(Context paramContext) {
        return WebSettings.getDefaultUserAgent(paramContext);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/dt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */