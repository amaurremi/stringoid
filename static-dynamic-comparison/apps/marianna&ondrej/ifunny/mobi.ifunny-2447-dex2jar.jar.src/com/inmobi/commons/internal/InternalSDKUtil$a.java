package com.inmobi.commons.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.WebSettings;

@TargetApi(17)
class InternalSDKUtil$a {
    static String a(Context paramContext) {
        return WebSettings.getDefaultUserAgent(paramContext);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/internal/InternalSDKUtil$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */