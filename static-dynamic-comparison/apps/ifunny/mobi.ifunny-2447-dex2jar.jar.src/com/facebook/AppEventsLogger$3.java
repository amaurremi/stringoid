package com.facebook;

final class AppEventsLogger$3
        implements Runnable {
    public void run() {
        if (AppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
            AppEventsLogger.access$300(AppEventsLogger.FlushReason.TIMER);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/AppEventsLogger$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */