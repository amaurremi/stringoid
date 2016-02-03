package com.google.android.gms.internal;

import android.content.Context;

public abstract class or<T> {
    private static final Object c = new Object();
    private static ov d = null;
    protected final String a;
    protected final T b;
    private T e = null;

    protected or(String paramString, T paramT) {
        this.a = paramString;
        this.b = paramT;
    }

    public static or<Integer> a(String paramString, Integer paramInteger) {
        return new ot(paramString, paramInteger);
    }

    public static or<String> a(String paramString1, String paramString2) {
        return new ou(paramString1, paramString2);
    }

    public static or<Boolean> a(String paramString, boolean paramBoolean) {
        return new os(paramString, Boolean.valueOf(paramBoolean));
    }

    public static void a(Context paramContext) {
        synchronized (c) {
            if (d == null) {
                d = new ow(paramContext.getContentResolver());
            }
            return;
        }
    }

    public String a() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/or.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */