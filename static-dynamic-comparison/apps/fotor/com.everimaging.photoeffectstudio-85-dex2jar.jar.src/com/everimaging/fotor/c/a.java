package com.everimaging.fotor.c;

import android.os.Build;

public class a {
    public static int a() {
        int i = 90;
        if (Build.MANUFACTURER.toLowerCase().contains("meizu")) {
            i = 180;
        }
        return i;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */