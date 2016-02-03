package com.amazon.device.ads;

import android.os.Looper;

class ht {
    private static ht a = new ht();

    static ht a() {
        return a;
    }

    boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/ht.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */