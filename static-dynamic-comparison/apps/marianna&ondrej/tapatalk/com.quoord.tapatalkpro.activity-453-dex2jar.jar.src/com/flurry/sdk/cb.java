package com.flurry.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.flurry.android.impl.ads.avro.protocol.v10.ScreenOrientationType;

public final class cb {
    private static final String a = cb.class.getSimpleName();
    private static final SparseArray<SparseIntArray> b = c();

    public static int a() {
        return 7;
    }

    public static int a(Activity paramActivity, int paramInt1, int paramInt2) {
        if (paramActivity == null) {
            return -1;
        }
        paramActivity = (SparseIntArray) b.get(paramInt2);
        if (paramActivity != null) {
        }
        for (paramInt1 = paramActivity.get(paramInt1, -1); ; paramInt1 = -1) {
            return paramInt1;
        }
    }

    public static int a(Activity paramActivity, ScreenOrientationType paramScreenOrientationType) {
        int i = 0;
        if (ScreenOrientationType.a.equals(paramScreenOrientationType)) {
            i = 1;
        }
        for (; ; ) {
            return a(paramActivity, -1, i);
            if (ScreenOrientationType.b.equals(paramScreenOrientationType)) {
                i = 2;
            }
        }
    }

    @TargetApi(13)
    public static int a(ActivityInfo paramActivityInfo) {
        int i;
        if (paramActivityInfo == null) {
            i = 0;
        }
        int j;
        do {
            return i;
            j = paramActivityInfo.configChanges;
            i = j;
        } while (paramActivityInfo.applicationInfo.targetSdkVersion >= 13);
        return j | 0xC00;
    }

    public static ActivityInfo a(Activity paramActivity) {
        if (paramActivity == null) {
            return null;
        }
        return a(paramActivity.getPackageManager(), paramActivity.getComponentName());
    }

    public static ActivityInfo a(PackageManager paramPackageManager, ComponentName paramComponentName) {
        if ((paramPackageManager == null) || (paramComponentName == null)) {
            return null;
        }
        try {
            paramPackageManager = paramPackageManager.getActivityInfo(paramComponentName, 0);
            return paramPackageManager;
        } catch (PackageManager.NameNotFoundException paramPackageManager) {
            eo.a(5, a, "cannot find info for activity: " + paramComponentName);
        }
        return null;
    }

    public static void a(Activity paramActivity, int paramInt) {
        if (paramActivity == null) {
            eo.b(a, "Context is null. Cannot set requested orientation.");
            return;
        }
        if (a(paramActivity)) {
            eo.b(a, "setRequestedOrientation SCREEN_ORIENTATION_SENSOR");
            paramActivity.setRequestedOrientation(4);
            return;
        }
        eo.b(a, "setRequestedOrientation " + paramInt);
        paramActivity.setRequestedOrientation(paramInt);
    }

    public static boolean a(Activity paramActivity, int paramInt, boolean paramBoolean) {
        boolean bool = true;
        if (paramActivity == null) {
            bool = false;
        }
        do {
            return bool;
            int i = paramInt;
            if (!b(paramActivity)) {
                i = b(paramActivity, paramInt);
                if (-1 == i) {
                    eo.a(5, a, "cannot set requested orientation without restarting activity, requestedOrientation = " + paramInt);
                    eo.b(a, "cannot set requested orientation without restarting activity. It is recommended to add keyboardHidden|orientation|screenSize for android:configChanges attribute for activity: " + paramActivity.getComponentName().getClassName());
                    return false;
                }
                paramBoolean = true;
            }
            paramActivity.setRequestedOrientation(i);
        } while (paramBoolean);
        paramActivity.setRequestedOrientation(-1);
        return true;
    }

    public static boolean a(Context paramContext) {
        if ((paramContext.getResources().getConfiguration().screenLayout & 0xF) >= 3) {
        }
        for (boolean bool = true; ; bool = false) {
            eo.b(a, "isTablet " + bool);
            return bool;
        }
    }

    public static int b() {
        return 6;
    }

    public static int b(Activity paramActivity, int paramInt) {
        if (paramActivity == null) {
            return -1;
        }
        return a(paramActivity, paramInt, paramActivity.getResources().getConfiguration().orientation);
    }

    public static boolean b(Activity paramActivity) {
        int i = a(a(paramActivity));
        if ((i & 0x80) == 0) {
        }
        while ((i & 0x400) == 0) {
            return false;
        }
        return true;
    }

    private static SparseArray<SparseIntArray> c() {
        SparseArray localSparseArray = new SparseArray();
        localSparseArray.put(1, d());
        localSparseArray.put(2, e());
        return localSparseArray;
    }

    private static SparseIntArray d() {
        int i = a();
        SparseIntArray localSparseIntArray = new SparseIntArray();
        localSparseIntArray.put(-1, i);
        localSparseIntArray.put(2, i);
        localSparseIntArray.put(3, i);
        localSparseIntArray.put(4, i);
        localSparseIntArray.put(1, 1);
        localSparseIntArray.put(5, 5);
        localSparseIntArray.put(7, 7);
        localSparseIntArray.put(9, 9);
        localSparseIntArray.put(10, 7);
        return localSparseIntArray;
    }

    private static SparseIntArray e() {
        int i = b();
        SparseIntArray localSparseIntArray = new SparseIntArray();
        localSparseIntArray.put(-1, i);
        localSparseIntArray.put(2, i);
        localSparseIntArray.put(3, i);
        localSparseIntArray.put(4, i);
        localSparseIntArray.put(0, 0);
        localSparseIntArray.put(5, 5);
        localSparseIntArray.put(6, 6);
        localSparseIntArray.put(8, 8);
        localSparseIntArray.put(10, 6);
        return localSparseIntArray;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */