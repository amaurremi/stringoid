package net.hockeyapp.android.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class e {
    private static String a = "versionInfo";

    public static String a(Context paramContext) {
        if (paramContext != null) {
            return paramContext.getSharedPreferences("HockeyApp", 0).getString(a, "[]");
        }
        return "[]";
    }

    public static void a(Context paramContext, String paramString) {
        if (paramContext != null) {
            paramContext = paramContext.getSharedPreferences("HockeyApp", 0).edit();
            paramContext.putString(a, paramString);
            d.a(paramContext);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/net/hockeyapp/android/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */