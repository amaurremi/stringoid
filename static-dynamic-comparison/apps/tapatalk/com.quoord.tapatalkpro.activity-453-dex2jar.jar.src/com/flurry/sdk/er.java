package com.flurry.sdk;

import android.text.TextUtils;

import java.lang.reflect.Method;

public final class er {
    private static final String a = er.class.getSimpleName();

    public static et a(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            return null;
        }
        try {
            et localet = (et) Class.forName(paramString).getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            paramString = localet;
        } catch (Exception localException) {
            for (; ; ) {
                eo.a(5, a, "FlurryModule " + paramString + " is not available:", localException);
                paramString = null;
            }
        }
        return paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/er.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */