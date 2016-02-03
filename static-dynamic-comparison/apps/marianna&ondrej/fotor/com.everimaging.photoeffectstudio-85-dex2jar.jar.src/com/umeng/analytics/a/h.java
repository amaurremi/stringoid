package com.umeng.analytics.a;

import android.content.Context;

public class h {
    private static d a = null;
    private static f b = null;

    public static d a(Context paramContext) {
        if (a == null) {
            a = new d(paramContext);
            a.a(new e(paramContext));
            a.a(new g(paramContext));
            a.a(new b(paramContext));
            a.a(new i(paramContext));
            a.e();
        }
        return a;
    }

    public static f b(Context paramContext) {
        if (b == null) {
            b = new f(paramContext);
            b.b();
        }
        return b;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */