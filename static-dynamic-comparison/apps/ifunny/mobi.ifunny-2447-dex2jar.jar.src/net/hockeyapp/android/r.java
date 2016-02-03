package net.hockeyapp.android;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;

import java.lang.ref.WeakReference;

import net.hockeyapp.android.c.a;

public class r {
    private static a a = null;
    private static s b = null;

    @SuppressLint({"NewApi"})
    public static Boolean a() {
        try {
            if ((Build.VERSION.SDK_INT >= 11) && (Fragment.class != null)) {
            }
            for (boolean bool = true; ; bool = false) {
                return Boolean.valueOf(bool);
            }
            return Boolean.valueOf(false);
        } catch (NoClassDefFoundError localNoClassDefFoundError) {
        }
    }

    public static Boolean a(WeakReference<Activity> paramWeakReference) {
        if (paramWeakReference != null) {
            paramWeakReference = (Activity) paramWeakReference.get();
            if (paramWeakReference != null) {
                paramWeakReference = paramWeakReference.getResources().getConfiguration();
                if (((paramWeakReference.screenLayout & 0xF) == 3) || ((paramWeakReference.screenLayout & 0xF) == 4)) {
                }
                for (boolean bool = true; ; bool = false) {
                    return Boolean.valueOf(bool);
                }
            }
        }
        return Boolean.valueOf(false);
    }

    public static s b() {
        return b;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/net/hockeyapp/android/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */