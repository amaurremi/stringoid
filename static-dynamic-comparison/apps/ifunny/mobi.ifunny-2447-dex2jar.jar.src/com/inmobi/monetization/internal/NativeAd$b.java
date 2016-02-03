package com.inmobi.monetization.internal;

import com.inmobi.commons.internal.Log;

import java.util.HashMap;

class NativeAd$b
        implements Runnable {
    NativeAd$b(NativeAd paramNativeAd, HashMap paramHashMap) {
    }

    public void run() {
        try {
            this.b.a.a(this.a);
            return;
        } catch (Exception localException) {
            Log.debug("[InMobi]-[Monetization]", "Failed to track click");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/NativeAd$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */