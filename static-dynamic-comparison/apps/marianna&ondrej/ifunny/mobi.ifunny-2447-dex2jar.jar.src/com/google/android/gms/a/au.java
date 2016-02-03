package com.google.android.gms.a;

import android.os.Build.VERSION;

import java.io.File;

class au {
    public static int a() {
        try {
            int i = Integer.parseInt(Build.VERSION.SDK);
            return i;
        } catch (NumberFormatException localNumberFormatException) {
            bt.a("Invalid version number: " + Build.VERSION.SDK);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/a/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */