package com.amazon.device.ads;

import java.util.ArrayList;

class dv {
    private static boolean a = false;
    private static dm b = new dx(null);

    static Iterable<String> a(String paramString, int paramInt) {
        ArrayList localArrayList = new ArrayList();
        if ((paramString == null) || (paramString.length() == 0)) {
            return localArrayList;
        }
        int i = 0;
        while (i < paramString.length()) {
            localArrayList.add(paramString.substring(i, Math.min(paramString.length(), i + paramInt)));
            i += paramInt;
        }
        return localArrayList;
    }

    public static void a(String paramString1, String paramString2) {
        a(false, paramString1, paramString2);
    }

    public static final void a(String paramString1, String paramString2, Object paramObject) {
        if (!a()) {
            return;
        }
        if ((paramObject instanceof Boolean)) {
            if (((Boolean) paramObject).booleanValue()) {
            }
            for (paramObject = "enabled"; ; paramObject = "disabled") {
                a(paramString1, "%s has been %s.", new Object[]{paramString2, paramObject});
                return;
            }
        }
        a(paramString1, "%s has been set: %s", new Object[]{paramString2, String.valueOf(paramObject)});
    }

    public static void a(String paramString1, String paramString2, Object... paramVarArgs) {
        a(false, paramString1, paramString2, paramVarArgs);
    }

    public static final void a(String paramString, boolean paramBoolean) {
        if (!paramBoolean) {
            a(paramString, "Debug logging", Boolean.valueOf(paramBoolean));
        }
        a(paramBoolean);
        if (paramBoolean) {
            a(paramString, "Debug logging", Boolean.valueOf(paramBoolean));
            a(paramString, "Amazon Mobile Ads API Version: %s", new Object[]{hv.a()});
        }
    }

    public static void a(boolean paramBoolean) {
        a = paramBoolean;
    }

    public static void a(boolean paramBoolean, String paramString1, String paramString2) {
        if ((a()) || (paramBoolean)) {
            b.b("AmazonMobileAds " + paramString1, paramString2);
        }
    }

    public static void a(boolean paramBoolean, String paramString1, String paramString2, Object... paramVarArgs) {
        if ((a()) || (paramBoolean)) {
            b.b("AmazonMobileAds " + paramString1, paramString2, paramVarArgs);
        }
    }

    public static boolean a() {
        if (b == null) {
            return false;
        }
        return cx.a("debug.logging", a);
    }

    public static void b(String paramString1, String paramString2) {
        b(false, paramString1, paramString2);
    }

    public static void b(String paramString1, String paramString2, Object... paramVarArgs) {
        b(false, paramString1, paramString2, paramVarArgs);
    }

    public static void b(boolean paramBoolean, String paramString1, String paramString2) {
        if ((a()) || (paramBoolean)) {
            b.c("AmazonMobileAds " + paramString1, paramString2);
        }
    }

    public static void b(boolean paramBoolean, String paramString1, String paramString2, Object... paramVarArgs) {
        if ((a()) || (paramBoolean)) {
            b.d("AmazonMobileAds " + paramString1, paramString2, paramVarArgs);
        }
    }

    public static void c(String paramString1, String paramString2) {
        c(false, paramString1, paramString2);
    }

    public static void c(String paramString1, String paramString2, Object... paramVarArgs) {
        c(false, paramString1, paramString2, paramVarArgs);
    }

    public static void c(boolean paramBoolean, String paramString1, String paramString2) {
        if ((a()) || (paramBoolean)) {
            b.e("AmazonMobileAds " + paramString1, paramString2);
        }
    }

    public static void c(boolean paramBoolean, String paramString1, String paramString2, Object... paramVarArgs) {
        if ((a()) || (paramBoolean)) {
            b.a("AmazonMobileAds " + paramString1, paramString2, paramVarArgs);
        }
    }

    public static void d(String paramString1, String paramString2) {
        d(false, paramString1, paramString2);
    }

    public static void d(String paramString1, String paramString2, Object... paramVarArgs) {
        d(false, paramString1, paramString2, paramVarArgs);
    }

    public static void d(boolean paramBoolean, String paramString1, String paramString2) {
        if ((a()) || (paramBoolean)) {
            b.a("AmazonMobileAds " + paramString1, paramString2);
        }
    }

    public static void d(boolean paramBoolean, String paramString1, String paramString2, Object... paramVarArgs) {
        if ((a()) || (paramBoolean)) {
            b.c("AmazonMobileAds " + paramString1, paramString2, paramVarArgs);
        }
    }

    public static void e(String paramString1, String paramString2) {
        e(false, paramString1, paramString2);
    }

    public static void e(boolean paramBoolean, String paramString1, String paramString2) {
        if ((a()) || (paramBoolean)) {
            b.d("AmazonMobileAds " + paramString1, paramString2);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/dv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */