package com.google.analytics.tracking.android;

import android.os.Build.VERSION;

import java.io.File;

class o {
    public static int a() {
        try {
            int i = Integer.parseInt(Build.VERSION.SDK);
            return i;
        } catch (NumberFormatException localNumberFormatException) {
            v.a("Invalid version number: " + Build.VERSION.SDK);
        }
        return 0;
    }

    static boolean a(String paramString) {
        if (a() < 9) {
            return false;
        }
        paramString = new File(paramString);
        paramString.setReadable(false, false);
        paramString.setWritable(false, false);
        paramString.setReadable(true, true);
        paramString.setWritable(true, true);
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/google/analytics/tracking/android/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */