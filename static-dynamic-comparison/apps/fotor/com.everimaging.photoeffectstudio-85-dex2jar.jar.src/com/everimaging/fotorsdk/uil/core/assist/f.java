package com.everimaging.fotorsdk.uil.core.assist;

import java.util.Comparator;

public final class f {
    public static String a(String paramString, e parame) {
        return paramString + "_" + parame.a() + "x" + parame.b();
    }

    public static Comparator<String> a() {
        new Comparator() {
            public int a(String paramAnonymousString1, String paramAnonymousString2) {
                return paramAnonymousString1.substring(0, paramAnonymousString1.lastIndexOf("_")).compareTo(paramAnonymousString2.substring(0, paramAnonymousString2.lastIndexOf("_")));
            }
        };
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/core/assist/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */