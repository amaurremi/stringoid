package com.google.analytics.tracking.android;

import android.content.Context;

import java.util.ArrayList;

public class n
        implements Thread.UncaughtExceptionHandler {
    private final Thread.UncaughtExceptionHandler a;
    private final ah b;
    private final ad c;
    private m d;

    public n(ah paramah, ad paramad, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, Context paramContext) {
        if (paramah == null) {
            throw new NullPointerException("tracker cannot be null");
        }
        if (paramad == null) {
            throw new NullPointerException("serviceManager cannot be null");
        }
        this.a = paramUncaughtExceptionHandler;
        this.b = paramah;
        this.c = paramad;
        this.d = new ag(paramContext, new ArrayList());
        paramad = new StringBuilder().append("ExceptionReporter created, original handler is ");
        if (paramUncaughtExceptionHandler == null) {
        }
        for (paramah = "null"; ; paramah = paramUncaughtExceptionHandler.getClass().getName()) {
            v.c(paramah);
            return;
        }
    }

    public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
        String str = "UncaughtException";
        if (this.d != null) {
            if (paramThread == null) {
                break label102;
            }
        }
        label102:
        for (str = paramThread.getName(); ; str = null) {
            str = this.d.a(str, paramThrowable);
            v.c("Tracking Exception: " + str);
            this.b.a(w.a(str, Boolean.valueOf(true)).a());
            this.c.c();
            if (this.a != null) {
                v.c("Passing exception to original handler.");
                this.a.uncaughtException(paramThread, paramThrowable);
            }
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/google/analytics/tracking/android/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */