package com.mopub.common;

public final class Preconditions$NoThrow {
    private static volatile boolean a = false;

    public static boolean checkArgument(boolean paramBoolean) {
        return Preconditions.a(paramBoolean, a, "Illegal argument", new Object[]{""});
    }

    public static boolean checkArgument(boolean paramBoolean, String paramString) {
        return Preconditions.a(paramBoolean, a, paramString, new Object[]{""});
    }

    public static boolean checkArgument(boolean paramBoolean, String paramString, Object... paramVarArgs) {
        return Preconditions.a(paramBoolean, a, paramString, paramVarArgs);
    }

    public static boolean checkNotNull(Object paramObject) {
        return Preconditions.a(paramObject, a, "Object can not be null.", new Object[]{""});
    }

    public static boolean checkNotNull(Object paramObject, String paramString) {
        return Preconditions.a(paramObject, a, paramString, new Object[]{""});
    }

    public static boolean checkNotNull(Object paramObject, String paramString, Object... paramVarArgs) {
        return Preconditions.a(paramObject, a, paramString, paramVarArgs);
    }

    public static boolean checkState(boolean paramBoolean) {
        return Preconditions.b(paramBoolean, a, "Illegal state.", new Object[]{""});
    }

    public static boolean checkState(boolean paramBoolean, String paramString) {
        return Preconditions.b(paramBoolean, a, paramString, new Object[]{""});
    }

    public static boolean checkState(boolean paramBoolean, String paramString, Object... paramVarArgs) {
        return Preconditions.b(paramBoolean, a, paramString, paramVarArgs);
    }

    public static boolean checkUiThread() {
        return Preconditions.a(a, "This method must be called from the UI thread.", new Object[]{""});
    }

    public static boolean checkUiThread(String paramString) {
        return Preconditions.a(a, paramString, new Object[]{""});
    }

    public static boolean checkUiThread(String paramString, Object... paramVarArgs) {
        return Preconditions.a(false, paramString, paramVarArgs);
    }

    public static void setStrictMode(boolean paramBoolean) {
        a = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/Preconditions$NoThrow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */