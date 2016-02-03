package com.google.android.gms.a;

public class bt {
    private static c a;

    public static void a(String paramString) {
        k localk = b();
        if (localk != null) {
            localk.d(paramString);
        }
    }

    public static boolean a() {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (b() != null) {
            bool1 = bool2;
            if (b().a() == 0) {
                bool1 = true;
            }
        }
        return bool1;
    }

    private static k b() {
        if (a == null) {
            a = c.a();
        }
        if (a != null) {
            return a.d();
        }
        return null;
    }

    public static void b(String paramString) {
        k localk = b();
        if (localk != null) {
            localk.b(paramString);
        }
    }

    public static void c(String paramString) {
        k localk = b();
        if (localk != null) {
            localk.a(paramString);
        }
    }

    public static void d(String paramString) {
        k localk = b();
        if (localk != null) {
            localk.c(paramString);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/a/bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */