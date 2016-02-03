package com.amazon.device.ads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class hs
        implements hr {
    private ExecutorService a = new ThreadPoolExecutor(1, 3, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public void a(Runnable paramRunnable) {
        this.a.submit(paramRunnable);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/hs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */