package com.mopub.nativeads;

import android.content.Context;

import java.util.List;
import java.util.Map;

public abstract class CustomEventNative {
    protected abstract void loadNativeAd(Context paramContext, CustomEventNative.CustomEventNativeListener paramCustomEventNativeListener, Map<String, Object> paramMap, Map<String, String> paramMap1);

    final void preCacheImages(Context paramContext, List<String> paramList, CustomEventNative.ImageListener paramImageListener) {
        ImageService.get(paramContext, paramList, new CustomEventNative .1 (this, paramImageListener));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/CustomEventNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */