package com.google.android.gms.analytics;

import android.os.Build.VERSION;

import java.io.File;

class p {
    static boolean G(String paramString) {
        if (version() < 9) {
            return false;
        }
        paramString = new File(paramString);
        paramString.setReadable(false, false);
        paramString.setWritable(false, false);
        paramString.setReadable(true, true);
        paramString.setWritable(true, true);
        return true;
    }

    public static int version() {
        try {
            int i = Integer.parseInt(Build.VERSION.SDK);
            return i;
        } catch (NumberFormatException localNumberFormatException) {
            aa.w("Invalid version number: " + Build.VERSION.SDK);
        }
        return 0;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/analytics/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */