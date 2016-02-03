package com.inneractive.api.ads.sdk;

import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

final class IAbaseWebView$a
        extends WebChromeClient {
    IAbaseWebView$a(IAbaseWebView paramIAbaseWebView) {
    }

    public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage) {
        InneractiveAdView.Log.v("Inneractive_verbose", "onConsoleMessage: " + paramConsoleMessage.message());
        return true;
    }

    public final boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult) {
        InneractiveAdView.Log.v("Inneractive_verbose", "onJsAlert: " + paramString2);
        if (paramString2 != null) {
            int i = paramString2.indexOf("playerState");
            if (i < 0) {
                break label84;
            }
            IAbaseWebView.setPlayerState(paramString2.substring(i + 11, paramString2.length()));
            InneractiveAdView.Log.d("Inneractive_debug", "Player State:" + IAbaseWebView.playerState);
            paramJsResult.confirm();
        }
        for (; ; ) {
            return true;
            label84:
            IAbaseWebView.setPlayerState(null);
        }
    }

    public final boolean onJsBeforeUnload(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult) {
        InneractiveAdView.Log.v("Inneractive_verbose", "onJsBeforeUnload: " + paramString2);
        return true;
    }

    public final boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult) {
        InneractiveAdView.Log.v("Inneractive_verbose", "onJsConfirm: " + paramString2);
        return true;
    }

    public final boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult) {
        InneractiveAdView.Log.v("Inneractive_verbose", "onJsPrompt: " + paramString2);
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAbaseWebView$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */