package com.inmobi.monetization.internal;

class NativeAd$e
        implements Runnable {
    NativeAd$e(NativeAd paramNativeAd) {
    }

    public void run() {
        try {
            if (this.a.a != null) {
                this.a.a.a();
                this.a.a = null;
                return;
            }
            android.util.Log.e("[InMobi]-[Monetization]", "Please attach the native ad view before calling detach");
            NativeAd.a(this.a, NativeAd.a.e);
            return;
        } catch (Exception localException) {
            NativeAd.a(this.a, NativeAd.a.e);
            com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Failed to detach a view");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/NativeAd$e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */