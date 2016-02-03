package com.inmobi.commons.cache;

import java.util.Timer;

public class RetryMechanism {
    private Timer a;
    private int b = 0;
    private int c = 0;
    private int d = 1000;

    public RetryMechanism(int paramInt1, int paramInt2, Timer paramTimer) {
        this.c = paramInt1;
        this.d = paramInt2;
        this.a = paramTimer;
    }

    private void a(RetryMechanism.RetryRunnable paramRetryRunnable, int paramInt) {
        this.a.schedule(new RetryMechanism.a(this, paramRetryRunnable), paramInt);
    }

    public void rescheduleTimer(RetryMechanism.RetryRunnable paramRetryRunnable) {
        this.b = 0;
        a(paramRetryRunnable, 0);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/cache/RetryMechanism.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */