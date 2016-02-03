package com.umeng.analytics.social;

import android.util.Log;

public class b {
    public static void a(String paramString1, String paramString2) {
        if (e.v) {
            Log.i(paramString1, paramString2);
        }
    }

    public static void a(String paramString1, String paramString2, Exception paramException) {
        if (e.v) {
            Log.i(paramString1, paramException.toString() + ":  [" + paramString2 + "]");
        }
    }

    public static void b(String paramString1, String paramString2) {
        if (e.v) {
            Log.e(paramString1, paramString2);
        }
    }

    public static void b(String paramString1, String paramString2, Exception paramException) {
        if (e.v) {
            Log.e(paramString1, paramException.toString() + ":  [" + paramString2 + "]");
            paramString2 = paramException.getStackTrace();
            int j = paramString2.length;
            int i = 0;
            while (i < j) {
                paramException = paramString2[i];
                Log.e(paramString1, "        at\t " + paramException.toString());
                i += 1;
            }
        }
    }

    public static void c(String paramString1, String paramString2) {
        if (e.v) {
            Log.d(paramString1, paramString2);
        }
    }

    public static void c(String paramString1, String paramString2, Exception paramException) {
        if (e.v) {
            Log.d(paramString1, paramException.toString() + ":  [" + paramString2 + "]");
        }
    }

    public static void d(String paramString1, String paramString2) {
        if (e.v) {
            Log.v(paramString1, paramString2);
        }
    }

    public static void d(String paramString1, String paramString2, Exception paramException) {
        if (e.v) {
            Log.v(paramString1, paramException.toString() + ":  [" + paramString2 + "]");
        }
    }

    public static void e(String paramString1, String paramString2) {
        if (e.v) {
            Log.w(paramString1, paramString2);
        }
    }

    public static void e(String paramString1, String paramString2, Exception paramException) {
        if (e.v) {
            Log.w(paramString1, paramException.toString() + ":  [" + paramString2 + "]");
            paramString2 = paramException.getStackTrace();
            int j = paramString2.length;
            int i = 0;
            while (i < j) {
                paramException = paramString2[i];
                Log.w(paramString1, "        at\t " + paramException.toString());
                i += 1;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/social/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */