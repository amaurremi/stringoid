package com.google.android.gms.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

class u
        implements ar {
    private static u a;
    private static Object b = new Object();
    private final Context c;

    protected u(Context paramContext) {
        this.c = paramContext;
    }

    public static u a() {
        synchronized (b) {
            u localu = a;
            return localu;
        }
    }

    public static void a(Context paramContext) {
        synchronized (b) {
            if (a == null) {
                a = new u(paramContext);
            }
            return;
        }
    }

    public String a(String paramString) {
        if (paramString == null) {
        }
        while (!paramString.equals("&sr")) {
            return null;
        }
        return b();
    }

    protected String b() {
        DisplayMetrics localDisplayMetrics = this.c.getResources().getDisplayMetrics();
        return localDisplayMetrics.widthPixels + "x" + localDisplayMetrics.heightPixels;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/a/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */