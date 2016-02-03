package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

class ab
        implements j {
    private static ab a;
    private static Object b = new Object();
    private final Context c;

    protected ab(Context paramContext) {
        this.c = paramContext;
    }

    public static ab a() {
        synchronized (b) {
            ab localab = a;
            return localab;
        }
    }

    public static void a(Context paramContext) {
        synchronized (b) {
            if (a == null) {
                a = new ab(paramContext);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/google/analytics/tracking/android/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */