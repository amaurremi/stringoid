package com.google.android.gms.analytics;

import android.content.Context;

import java.util.ArrayList;

public class ExceptionReporter
        implements Thread.UncaughtExceptionHandler {
    private final Context mContext;
    private final Thread.UncaughtExceptionHandler sA;
    private final Tracker sB;
    private ExceptionParser sC;

    public ExceptionReporter(Tracker paramTracker, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, Context paramContext) {
        if (paramTracker == null) {
            throw new NullPointerException("tracker cannot be null");
        }
        if (paramContext == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.sA = paramUncaughtExceptionHandler;
        this.sB = paramTracker;
        this.sC = new StandardExceptionParser(paramContext, new ArrayList());
        this.mContext = paramContext.getApplicationContext();
        paramContext = new StringBuilder().append("ExceptionReporter created, original handler is ");
        if (paramUncaughtExceptionHandler == null) {
        }
        for (paramTracker = "null"; ; paramTracker = paramUncaughtExceptionHandler.getClass().getName()) {
            aa.y(paramTracker);
            return;
        }
    }

    public ExceptionParser getExceptionParser() {
        return this.sC;
    }

    public void setExceptionParser(ExceptionParser paramExceptionParser) {
        this.sC = paramExceptionParser;
    }

    public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
        String str = "UncaughtException";
        if (this.sC != null) {
            if (paramThread == null) {
                break label112;
            }
        }
        label112:
        for (str = paramThread.getName(); ; str = null) {
            str = this.sC.getDescription(str, paramThrowable);
            aa.y("Tracking Exception: " + str);
            this.sB.send(new HitBuilders.ExceptionBuilder().setDescription(str).setFatal(true).build());
            GoogleAnalytics.getInstance(this.mContext).dispatchLocalHits();
            if (this.sA != null) {
                aa.y("Passing exception to original handler.");
                this.sA.uncaughtException(paramThread, paramThrowable);
            }
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/analytics/ExceptionReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */