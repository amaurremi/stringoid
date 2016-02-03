package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager;

import java.util.regex.Pattern;

public final class pp {
    private static Pattern a = null;

    public static int a(int paramInt) {
        return paramInt / 1000;
    }

    public static boolean a(Context paramContext) {
        return paramContext.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    public static int b(int paramInt) {
        return paramInt % 1000 / 100;
    }

    public static boolean c(int paramInt) {
        return b(paramInt) == 3;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/pp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */