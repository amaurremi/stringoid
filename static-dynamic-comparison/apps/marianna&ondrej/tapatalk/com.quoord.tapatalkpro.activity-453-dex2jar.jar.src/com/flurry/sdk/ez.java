package com.flurry.sdk;

import java.util.concurrent.ThreadFactory;

public class ez
        implements ThreadFactory {
    private final ThreadGroup a;
    private final int b;

    public ez(String paramString, int paramInt) {
        this.a = new ThreadGroup(paramString);
        this.b = paramInt;
    }

    public Thread newThread(Runnable paramRunnable) {
        paramRunnable = new Thread(this.a, paramRunnable);
        paramRunnable.setName(this.a.getName() + ":" + paramRunnable.getId());
        paramRunnable.setPriority(this.b);
        return paramRunnable;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */