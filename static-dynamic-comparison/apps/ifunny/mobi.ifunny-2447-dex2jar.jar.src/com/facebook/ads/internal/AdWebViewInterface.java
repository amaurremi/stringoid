package com.facebook.ads.internal;

import android.util.Log;
import android.webkit.JavascriptInterface;

public class AdWebViewInterface {
    private static final String TAG = AdWebViewInterface.class.getSimpleName();

    @JavascriptInterface
    public void alert(String paramString) {
        Log.e(TAG, paramString);
    }

    @JavascriptInterface
    public String getAnalogInfo() {
        return AdUtilities.jsonEncode(AdAnalogData.getAnalogInfo());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/internal/AdWebViewInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */