package com.mopub.mobileads.util;

import android.util.Log;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

final class e
        extends WebChromeClient {
    public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult) {
        Log.d("MoPub - WebViewsUtil", paramString2);
        return true;
    }

    public boolean onJsBeforeUnload(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult) {
        Log.d("MoPub - WebViewsUtil", paramString2);
        return true;
    }

    public boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult) {
        Log.d("MoPub - WebViewsUtil", paramString2);
        return true;
    }

    public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult) {
        Log.d("MoPub - WebViewsUtil", paramString2);
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/util/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */