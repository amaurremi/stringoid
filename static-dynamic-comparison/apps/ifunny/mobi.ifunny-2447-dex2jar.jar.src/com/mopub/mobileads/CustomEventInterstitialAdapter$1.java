package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;

class CustomEventInterstitialAdapter$1
        implements Runnable {
    CustomEventInterstitialAdapter$1(CustomEventInterstitialAdapter paramCustomEventInterstitialAdapter) {
    }

    public void run() {
        MoPubLog.d("Third-party network timed out.");
        this.this$0.onInterstitialFailed(MoPubErrorCode.NETWORK_TIMEOUT);
        this.this$0.invalidate();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/CustomEventInterstitialAdapter$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */