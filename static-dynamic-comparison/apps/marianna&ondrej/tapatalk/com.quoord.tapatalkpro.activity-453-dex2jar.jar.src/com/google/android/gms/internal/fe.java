package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.lang.reflect.Field;

public abstract class fe
        implements SafeParcelable {
    private static final Object CW = new Object();
    private static ClassLoader CX = null;
    private static Integer CY = null;
    private boolean CZ = false;

    private static boolean a(Class<?> paramClass) {
        try {
            boolean bool = "SAFE_PARCELABLE_NULL_STRING".equals(paramClass.getField("NULL").get(null));
            return bool;
        } catch (IllegalAccessException paramClass) {
            return false;
        } catch (NoSuchFieldException paramClass) {
        }
        return false;
    }

    protected static boolean al(String paramString) {
        ClassLoader localClassLoader = eI();
        if (localClassLoader == null) {
            return true;
        }
        try {
            boolean bool = a(localClassLoader.loadClass(paramString));
            return bool;
        } catch (Exception paramString) {
        }
        return false;
    }

    protected static ClassLoader eI() {
        synchronized (CW) {
            ClassLoader localClassLoader = CX;
            return localClassLoader;
        }
    }

    protected static Integer eJ() {
        synchronized (CW) {
            Integer localInteger = CY;
            return localInteger;
        }
    }

    protected boolean eK() {
        return this.CZ;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/fe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */