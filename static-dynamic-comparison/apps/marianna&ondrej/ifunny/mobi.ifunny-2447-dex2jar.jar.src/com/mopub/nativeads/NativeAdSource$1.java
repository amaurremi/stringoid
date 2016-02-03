package com.mopub.nativeads;

class NativeAdSource$1
        implements Runnable {
    NativeAdSource$1(NativeAdSource paramNativeAdSource) {
    }

    public void run() {
        this.this$0.mRetryInFlight = false;
        this.this$0.replenishCache();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/NativeAdSource$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */