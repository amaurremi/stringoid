package com.umeng.analytics.a;

import android.content.Context;
import android.provider.Settings.Secure;

public class b
        extends a {
    private static final String a = "android_id";
    private Context b;

    public b(Context paramContext) {
        super("android_id");
        this.b = paramContext;
    }

    public String f() {
        try {
            String str = Settings.Secure.getString(this.b.getContentResolver(), "android_id");
            return str;
        } catch (Exception localException) {
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */