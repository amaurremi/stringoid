package com.mopub.mobileads;

import android.content.Context;

import java.util.Map;

abstract class ResponseBodyInterstitial
        extends CustomEventInterstitial {
    protected AdConfiguration mAdConfiguration;
    long mBroadcastIdentifier;
    private EventForwardingBroadcastReceiver mBroadcastReceiver;
    protected Context mContext;

    private boolean extrasAreValid(Map<String, String> paramMap) {
        return paramMap.containsKey("Html-Response-Body");
    }

    protected abstract void extractExtras(Map<String, String> paramMap);

    protected void loadInterstitial(Context paramContext, CustomEventInterstitial.CustomEventInterstitialListener paramCustomEventInterstitialListener, Map<String, Object> paramMap, Map<String, String> paramMap1) {
        this.mContext = paramContext;
        if (extrasAreValid(paramMap1)) {
            extractExtras(paramMap1);
            this.mAdConfiguration = AdConfiguration.extractFromMap(paramMap);
            if (this.mAdConfiguration != null) {
                this.mBroadcastIdentifier = this.mAdConfiguration.getBroadcastIdentifier();
            }
            this.mBroadcastReceiver = new EventForwardingBroadcastReceiver(paramCustomEventInterstitialListener, this.mBroadcastIdentifier);
            this.mBroadcastReceiver.register(paramContext);
            preRenderHtml(paramCustomEventInterstitialListener);
            return;
        }
        paramCustomEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
    }

    protected void onInvalidate() {
        if (this.mBroadcastReceiver != null) {
            this.mBroadcastReceiver.unregister();
        }
    }

    protected abstract void preRenderHtml(CustomEventInterstitial.CustomEventInterstitialListener paramCustomEventInterstitialListener);

    protected abstract void showInterstitial();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/ResponseBodyInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */