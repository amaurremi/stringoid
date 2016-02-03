package com.mopub.mobileads;

import android.content.Context;

import java.util.Map;

public abstract class CustomEventBanner {
    protected abstract void loadBanner(Context paramContext, CustomEventBanner.CustomEventBannerListener paramCustomEventBannerListener, Map<String, Object> paramMap, Map<String, String> paramMap1);

    protected abstract void onInvalidate();

    protected void onPause() {
    }

    protected void onResume() {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/CustomEventBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */