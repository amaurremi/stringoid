package com.mopub.mobileads;

import android.net.Uri;

import java.util.Map;

class MraidInterstitial
        extends ResponseBodyInterstitial {
    private String mHtmlData;

    protected void extractExtras(Map<String, String> paramMap) {
        this.mHtmlData = Uri.decode((String) paramMap.get("Html-Response-Body"));
    }

    protected void preRenderHtml(CustomEventInterstitial.CustomEventInterstitialListener paramCustomEventInterstitialListener) {
        MraidActivity.preRenderHtml(this.mContext, paramCustomEventInterstitialListener, this.mHtmlData);
    }

    protected void showInterstitial() {
        MraidActivity.start(this.mContext, this.mHtmlData, this.mAdConfiguration);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MraidInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */