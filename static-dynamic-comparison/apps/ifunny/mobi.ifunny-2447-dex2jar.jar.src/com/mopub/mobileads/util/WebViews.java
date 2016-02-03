package com.mopub.mobileads.util;

import android.webkit.WebView;

import java.lang.reflect.Method;

public class WebViews {
    public static void onPause(WebView paramWebView) {
        try {
            WebView.class.getDeclaredMethod("onPause", new Class[0]).invoke(paramWebView, new Object[0]);
            return;
        } catch (Exception paramWebView) {
        }
    }

    public static void onResume(WebView paramWebView) {
        try {
            WebView.class.getDeclaredMethod("onResume", new Class[0]).invoke(paramWebView, new Object[0]);
            return;
        } catch (Exception paramWebView) {
        }
    }

    public static void setDisableJSChromeClient(WebView paramWebView) {
        paramWebView.setWebChromeClient(new e());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/util/WebViews.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */