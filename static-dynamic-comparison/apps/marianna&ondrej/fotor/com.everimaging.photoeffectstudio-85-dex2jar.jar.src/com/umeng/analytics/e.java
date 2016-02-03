package com.umeng.analytics;

public abstract class e
        implements Runnable {
    public abstract void a();

    public void run() {
        try {
            a();
            return;
        } catch (Throwable localThrowable) {
            while (localThrowable == null) {
            }
            localThrowable.printStackTrace();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */