package com.everimaging.fotorsdk.uil.utils;

import android.util.Log;
import com.everimaging.fotorsdk.uil.core.d;

public final class c {
    private static volatile boolean a = false;

    private static void a(int paramInt, Throwable paramThrowable, String paramString, Object... paramVarArgs) {
        if (a) {
            return;
        }
        if (paramVarArgs.length > 0) {
            paramString = String.format(paramString, paramVarArgs);
        }
        for (; ; ) {
            if (paramThrowable == null) {
            }
            for (; ; ) {
                Log.println(paramInt, d.a, paramString);
                return;
                paramVarArgs = paramString;
                if (paramString == null) {
                    paramVarArgs = paramThrowable.getMessage();
                }
                paramString = String.format("%1$s\n%2$s", new Object[]{paramVarArgs, Log.getStackTraceString(paramThrowable)});
            }
        }
    }

    public static void a(String paramString, Object... paramVarArgs) {
        a(3, null, paramString, paramVarArgs);
    }

    public static void a(Throwable paramThrowable) {
        a(6, paramThrowable, null, new Object[0]);
    }

    public static void b(String paramString, Object... paramVarArgs) {
        a(4, null, paramString, paramVarArgs);
    }

    public static void c(String paramString, Object... paramVarArgs) {
        a(5, null, paramString, paramVarArgs);
    }

    public static void d(String paramString, Object... paramVarArgs) {
        a(6, null, paramString, paramVarArgs);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/utils/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */