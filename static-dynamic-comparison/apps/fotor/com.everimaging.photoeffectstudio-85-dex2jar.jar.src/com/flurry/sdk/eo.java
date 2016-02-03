package com.flurry.sdk;

import android.text.TextUtils;
import android.util.Log;

public final class eo {
    private static int a = 4000;
    private static boolean b = false;
    private static int c = 5;
    private static boolean d = false;

    public static void a() {
        b = true;
    }

    public static void a(int paramInt) {
        c = paramInt;
    }

    public static void a(int paramInt, String paramString1, String paramString2) {
        c(paramInt, paramString1, paramString2);
    }

    public static void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable) {
        c(paramInt, paramString1, paramString2, paramThrowable);
    }

    public static void a(String paramString1, String paramString2) {
        b(3, paramString1, paramString2);
    }

    public static void a(String paramString1, String paramString2, Throwable paramThrowable) {
        b(6, paramString1, paramString2, paramThrowable);
    }

    public static void a(boolean paramBoolean) {
        d = paramBoolean;
    }

    public static void b() {
        b = false;
    }

    private static void b(int paramInt, String paramString1, String paramString2) {
        if ((!b) && (c <= paramInt)) {
            d(paramInt, paramString1, paramString2);
        }
    }

    private static void b(int paramInt, String paramString1, String paramString2, Throwable paramThrowable) {
        b(paramInt, paramString1, paramString2 + '\n' + Log.getStackTraceString(paramThrowable));
    }

    public static void b(String paramString1, String paramString2) {
        b(6, paramString1, paramString2);
    }

    public static void b(String paramString1, String paramString2, Throwable paramThrowable) {
        b(5, paramString1, paramString2, paramThrowable);
    }

    public static int c() {
        return c;
    }

    private static void c(int paramInt, String paramString1, String paramString2) {
        if (d) {
            d(paramInt, paramString1, paramString2);
        }
    }

    private static void c(int paramInt, String paramString1, String paramString2, Throwable paramThrowable) {
        c(paramInt, paramString1, paramString2 + '\n' + Log.getStackTraceString(paramThrowable));
    }

    public static void c(String paramString1, String paramString2) {
        b(2, paramString1, paramString2);
    }

    private static void d(int paramInt, String paramString1, String paramString2) {
        int i;
        if (d) {
            if (!TextUtils.isEmpty(paramString2)) {
                break label60;
            }
            i = 0;
        }
        label15:
        int j;
        label60:
        label68:
        label79:
        for (int k = 0; ; k = j) {
            if (k < i) {
                if (a <= i - k) {
                    break label68;
                }
            }
            for (j = i; ; j = a + k) {
                if (Log.println(paramInt, paramString1, paramString2.substring(k, j)) > 0) {
                    break label79;
                }
                return;
                paramString1 = "FlurryAgent";
                break;
                i = paramString2.length();
                break label15;
            }
        }
    }

    public static void d(String paramString1, String paramString2) {
        b(5, paramString1, paramString2);
    }

    public static boolean d() {
        return d;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/flurry/sdk/eo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */