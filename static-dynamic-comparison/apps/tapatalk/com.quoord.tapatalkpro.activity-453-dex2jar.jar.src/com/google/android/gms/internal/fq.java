package com.google.android.gms.internal;

import android.os.Looper;
import android.text.TextUtils;

public final class fq {
    public static void a(boolean paramBoolean, Object paramObject) {
        if (!paramBoolean) {
            throw new IllegalStateException(String.valueOf(paramObject));
        }
    }

    public static void a(boolean paramBoolean, String paramString, Object... paramVarArgs) {
        if (!paramBoolean) {
            throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
        }
    }

    public static void aj(String paramString) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException(paramString);
        }
    }

    public static void ak(String paramString) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException(paramString);
        }
    }

    public static String ap(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        return paramString;
    }

    public static <T> T b(T paramT, Object paramObject) {
        if (paramT == null) {
            throw new NullPointerException(String.valueOf(paramObject));
        }
        return paramT;
    }

    public static String b(String paramString, Object paramObject) {
        if (TextUtils.isEmpty(paramString)) {
            throw new IllegalArgumentException(String.valueOf(paramObject));
        }
        return paramString;
    }

    public static void b(boolean paramBoolean, Object paramObject) {
        if (!paramBoolean) {
            throw new IllegalArgumentException(String.valueOf(paramObject));
        }
    }

    public static <T> T f(T paramT) {
        if (paramT == null) {
            throw new NullPointerException("null reference");
        }
        return paramT;
    }

    public static void x(boolean paramBoolean) {
        if (!paramBoolean) {
            throw new IllegalStateException();
        }
    }

    public static void z(boolean paramBoolean) {
        if (!paramBoolean) {
            throw new IllegalArgumentException();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/fq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */