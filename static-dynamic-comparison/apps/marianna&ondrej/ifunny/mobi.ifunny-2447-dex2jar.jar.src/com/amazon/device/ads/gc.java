package com.amazon.device.ads;

import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class gc
        extends WebChromeClient {
    protected gc(fy paramfy) {
    }

    public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult) {
        dv.b(fy.x(), paramString2);
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/gc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */