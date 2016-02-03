package com.umeng.analytics.b;

import com.umeng.analytics.AnalyticsConfig;

public class c
        implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler a;
    private k b;

    public c() {
        if (Thread.getDefaultUncaughtExceptionHandler() == this) {
            return;
        }
        this.a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private void a(Throwable paramThrowable) {
        if (AnalyticsConfig.CATCH_EXCEPTION) {
            this.b.a(paramThrowable);
            return;
        }
        this.b.a(null);
    }

    public void a(k paramk) {
        this.b = paramk;
    }

    public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
        a(paramThrowable);
        if ((this.a != null) && (this.a != Thread.getDefaultUncaughtExceptionHandler())) {
            this.a.uncaughtException(paramThread, paramThrowable);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */