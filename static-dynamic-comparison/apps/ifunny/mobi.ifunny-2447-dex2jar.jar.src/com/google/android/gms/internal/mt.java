package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebSettings;

@ii
public final class mt {
    public static String a(Context paramContext) {
        return WebSettings.getDefaultUserAgent(paramContext);
    }

    public static void a(Context paramContext, WebSettings paramWebSettings) {
        mj.a(paramContext, paramWebSettings);
        paramWebSettings.setMediaPlaybackRequiresUserGesture(false);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/mt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */