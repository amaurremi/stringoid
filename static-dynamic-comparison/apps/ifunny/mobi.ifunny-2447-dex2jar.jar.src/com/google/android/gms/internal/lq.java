package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

@ii
public final class lq {
    public static void a(Context paramContext, boolean paramBoolean) {
        paramContext = b(paramContext).edit();
        paramContext.putBoolean("use_https", paramBoolean);
        paramContext.commit();
    }

    public static boolean a(Context paramContext) {
        return b(paramContext).getBoolean("use_https", true);
    }

    private static SharedPreferences b(Context paramContext) {
        return paramContext.getSharedPreferences("admob", 0);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/lq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */