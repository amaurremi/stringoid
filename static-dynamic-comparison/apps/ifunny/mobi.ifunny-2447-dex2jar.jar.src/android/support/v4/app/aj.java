package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.support.v4.a.f;

public class aj {
    private static final ak a = new al();

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            a = new am();
            return;
        }
    }

    public static Intent a(Activity paramActivity) {
        return a.a(paramActivity);
    }

    public static Intent a(Context paramContext, ComponentName paramComponentName) {
        String str = b(paramContext, paramComponentName);
        if (str == null) {
            return null;
        }
        paramComponentName = new ComponentName(paramComponentName.getPackageName(), str);
        if (b(paramContext, paramComponentName) == null) {
            return f.a(paramComponentName);
        }
        return new Intent().setComponent(paramComponentName);
    }

    public static boolean a(Activity paramActivity, Intent paramIntent) {
        return a.a(paramActivity, paramIntent);
    }

    public static String b(Activity paramActivity) {
        try {
            paramActivity = b(paramActivity, paramActivity.getComponentName());
            return paramActivity;
        } catch (PackageManager.NameNotFoundException paramActivity) {
            throw new IllegalArgumentException(paramActivity);
        }
    }

    public static String b(Context paramContext, ComponentName paramComponentName) {
        paramComponentName = paramContext.getPackageManager().getActivityInfo(paramComponentName, 128);
        return a.a(paramContext, paramComponentName);
    }

    public static void b(Activity paramActivity, Intent paramIntent) {
        a.b(paramActivity, paramIntent);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */