package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.lang.reflect.Field;

public abstract class c
        implements SafeParcelable {
    private static final Object a = new Object();
    private static ClassLoader b = null;
    private static Integer c = null;
    private boolean d = false;

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

    protected static boolean a(String paramString) {
        ClassLoader localClassLoader = b();
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

    protected static ClassLoader b() {
        synchronized (a) {
            ClassLoader localClassLoader = b;
            return localClassLoader;
        }
    }

    protected static Integer c() {
        synchronized (a) {
            Integer localInteger = c;
            return localInteger;
        }
    }

    protected boolean d() {
        return this.d;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/internal/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */