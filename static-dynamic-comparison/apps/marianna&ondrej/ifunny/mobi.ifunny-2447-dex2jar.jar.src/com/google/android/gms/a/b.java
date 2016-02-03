package com.google.android.gms.a;

import android.content.Context;

import java.util.ArrayList;

public class b
        implements Thread.UncaughtExceptionHandler {
    private final Thread.UncaughtExceptionHandler a;
    private final m b;
    private final Context c;
    private a d;

    public b(m paramm, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, Context paramContext) {
        if (paramm == null) {
            throw new NullPointerException("tracker cannot be null");
        }
        if (paramContext == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.a = paramUncaughtExceptionHandler;
        this.b = paramm;
        this.d = new l(paramContext, new ArrayList());
        this.c = paramContext.getApplicationContext();
        paramContext = new StringBuilder().append("ExceptionReporter created, original handler is ");
        if (paramUncaughtExceptionHandler == null) {
        }
        for (paramm = "null"; ; paramm = paramUncaughtExceptionHandler.getClass().getName()) {
            bt.c(paramm);
            return;
        }
    }

    Thread.UncaughtExceptionHandler a() {
        return this.a;
    }

    public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
        String str = "UncaughtException";
        if (this.d != null) {
            if (paramThread == null) {
                break label112;
            }
        }
        label112:
        for (str = paramThread.getName(); ; str = null) {
            str = this.d.a(str, paramThrowable);
            bt.c("Tracking Exception: " + str);
            this.b.a(new i().a(str).a(true).a());
            c.a(this.c).e();
            if (this.a != null) {
                bt.c("Passing exception to original handler.");
                this.a.uncaughtException(paramThread, paramThrowable);
            }
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */