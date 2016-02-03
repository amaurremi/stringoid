package com.mopub.nativeads;

import android.content.Context;

import java.util.Map;

import org.json.JSONException;

public class MoPubCustomEventNative
        extends CustomEventNative {
    protected void loadNativeAd(Context paramContext, CustomEventNative.CustomEventNativeListener paramCustomEventNativeListener, Map<String, Object> paramMap, Map<String, String> paramMap1) {
        try {
            paramMap = new MoPubCustomEventNative.MoPubForwardingNativeAd((String) paramMap1.get("response_body_key"));
            preCacheImages(paramContext, paramMap.getAllImageUrls(), new MoPubCustomEventNative .1
            (this, paramCustomEventNativeListener, paramMap));
            return;
        } catch (IllegalArgumentException paramContext) {
            paramCustomEventNativeListener.onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
            return;
        } catch (JSONException paramContext) {
            paramCustomEventNativeListener.onNativeAdFailed(NativeErrorCode.INVALID_JSON);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/MoPubCustomEventNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */