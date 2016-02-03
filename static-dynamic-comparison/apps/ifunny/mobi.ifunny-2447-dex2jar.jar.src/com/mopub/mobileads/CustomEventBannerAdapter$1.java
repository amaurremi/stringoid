package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;

class CustomEventBannerAdapter$1
        implements Runnable {
    CustomEventBannerAdapter$1(CustomEventBannerAdapter paramCustomEventBannerAdapter) {
    }

    public void run() {
        MoPubLog.d("Third-party network timed out.");
        this.this$0.onBannerFailed(MoPubErrorCode.NETWORK_TIMEOUT);
        this.this$0.invalidate();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/CustomEventBannerAdapter$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */