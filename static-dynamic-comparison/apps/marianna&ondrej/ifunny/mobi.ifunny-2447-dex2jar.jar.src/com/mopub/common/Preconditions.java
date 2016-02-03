package com.mopub.common;

import android.os.Looper;
import com.mopub.common.logging.MoPubLog;

import java.util.IllegalFormatException;

public final class Preconditions {
    public static final String EMPTY_ARGUMENTS = "";

    private static String a(String paramString, Object... paramVarArgs) {
        paramString = String.valueOf(paramString);
        try {
            paramVarArgs = String.format(paramString, paramVarArgs);
            return paramVarArgs;
        } catch (IllegalFormatException paramVarArgs) {
            MoPubLog.e("MoPub preconditions had a format exception: " + paramVarArgs.getMessage());
        }
        return paramString;
    }

    private static boolean b(Object paramObject, boolean paramBoolean, String paramString, Object... paramVarArgs) {
        if (paramObject != null) {
            return true;
        }
        paramObject = a(paramString, paramVarArgs);
        if (paramBoolean) {
            throw new NullPointerException((String) paramObject);
        }
        MoPubLog.e((String) paramObject);
        return false;
    }

    private static boolean b(boolean paramBoolean, String paramString, Object... paramVarArgs) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            return true;
        }
        paramString = a(paramString, paramVarArgs);
        if (paramBoolean) {
            throw new IllegalStateException(paramString);
        }
        MoPubLog.e(paramString);
        return false;
    }

    private static boolean c(boolean paramBoolean1, boolean paramBoolean2, String paramString, Object... paramVarArgs) {
        if (paramBoolean1) {
            return true;
        }
        paramString = a(paramString, paramVarArgs);
        if (paramBoolean2) {
            throw new IllegalArgumentException(paramString);
        }
        MoPubLog.e(paramString);
        return false;
    }

    public static void checkArgument(boolean paramBoolean) {
        c(paramBoolean, true, "Illegal argument.", new Object[]{""});
    }

    public static void checkArgument(boolean paramBoolean, String paramString) {
        c(paramBoolean, true, paramString, new Object[]{""});
    }

    public static void checkArgument(boolean paramBoolean, String paramString, Object... paramVarArgs) {
        c(paramBoolean, true, paramString, paramVarArgs);
    }

    public static void checkNotNull(Object paramObject) {
        b(paramObject, true, "Object can not be null.", new Object[]{""});
    }

    public static void checkNotNull(Object paramObject, String paramString) {
        b(paramObject, true, paramString, new Object[]{""});
    }

    public static void checkNotNull(Object paramObject, String paramString, Object... paramVarArgs) {
        b(paramObject, true, paramString, paramVarArgs);
    }

    public static void checkState(boolean paramBoolean) {
        d(paramBoolean, true, "Illegal state.", new Object[]{""});
    }

    public static void checkState(boolean paramBoolean, String paramString) {
        d(paramBoolean, true, paramString, new Object[]{""});
    }

    public static void checkState(boolean paramBoolean, String paramString, Object... paramVarArgs) {
        d(paramBoolean, true, paramString, paramVarArgs);
    }

    public static void checkUiThread() {
        b(true, "This method must be called from the UI thread.", new Object[]{""});
    }

    public static void checkUiThread(String paramString) {
        b(true, paramString, new Object[]{""});
    }

    public static void checkUiThread(String paramString, Object... paramVarArgs) {
        b(true, paramString, paramVarArgs);
    }

    private static boolean d(boolean paramBoolean1, boolean paramBoolean2, String paramString, Object... paramVarArgs) {
        if (paramBoolean1) {
            return true;
        }
        paramString = a(paramString, paramVarArgs);
        if (paramBoolean2) {
            throw new IllegalStateException(paramString);
        }
        MoPubLog.e(paramString);
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/Preconditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */