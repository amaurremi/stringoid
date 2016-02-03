package com.facebook.ads.internal;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AdWebViewUtils {
    public static final long DEFAULT_IMPRESSION_DELAY_MS = 1000L;
    public static final String FBAD_SCHEME = "fbad";
    public static final String WEBVIEW_BASE_URL = "https://www.facebook.com/";
    private static String userAgentString = null;

    public static void config(WebView paramWebView, WebViewClient paramWebViewClient, AdWebViewInterface paramAdWebViewInterface) {
        paramWebView.getSettings().setJavaScriptEnabled(true);
        paramWebView.getSettings().setSupportZoom(false);
        paramWebView.setHorizontalScrollBarEnabled(false);
        paramWebView.setHorizontalScrollbarOverlay(false);
        paramWebView.setVerticalScrollBarEnabled(false);
        paramWebView.setVerticalScrollbarOverlay(false);
        paramWebView.addJavascriptInterface(paramAdWebViewInterface, "AdControl");
        paramWebView.setWebViewClient(paramWebViewClient);
    }

    public static String getUserAgentString(Context paramContext) {
        if (userAgentString == null) {
            paramContext = new WebView(paramContext.getApplicationContext());
            userAgentString = paramContext.getSettings().getUserAgentString();
            paramContext.destroy();
        }
        return userAgentString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/internal/AdWebViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */