package com.everimaging.fotorsdk.store.utils;

import java.io.File;

public class e {
    public static String a(String paramString) {
        String str = "";
        if (c.b(paramString)) {
            str = "Effect";
        }
        while (!c.a(paramString)) {
            return str;
        }
        return "Border";
    }

    public static String a(String paramString1, String paramString2, String paramString3) {
        return paramString1 + File.separator + "Trail" + File.separator + paramString2 + File.separator + paramString3;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/utils/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */