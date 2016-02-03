package com.inmobi.re.container;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inmobi.commons.internal.Log;
import com.inmobi.re.configs.Initializer;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

class b
        extends WebViewClient {
    b(IMWebView paramIMWebView) {
    }

    public void onLoadResource(WebView paramWebView, String paramString) {
        Log.debug("[InMobi]-[RE]-4.5.1", "IMWebView-> onLoadResource:" + paramString);
        try {
            if (IMWebView.a(this.a) != null) {
                IMWebView.a(this.a).onLoadResource(paramWebView, paramString);
            }
            if ((paramString != null) && (paramString.contains("/mraid.js")) && (!this.a.getUrl().equals("about:blank")) && (!this.a.getUrl().startsWith("file:"))) {
                Log.debug("[InMobi]-[RE]-4.5.1", "IMWebView-> onLoadResource:Hippy, Mraid ad alert!...injecting mraid and mraidview object at " + paramWebView.getUrl());
                paramWebView = this.a.getUrl();
                if (!IMWebView.e(this.a).contains(paramWebView)) {
                    IMWebView.e(this.a).add(paramWebView);
                }
                if (!this.a.mraidLoaded) {
                    this.a.injectJavaScript(Initializer.getMRAIDString());
                }
                this.a.mraidLoaded = true;
            }
            return;
        } catch (Exception paramWebView) {
            Log.internal("[InMobi]-[RE]-4.5.1", "Cannot load resource", paramWebView);
        }
    }

    public void onPageFinished(WebView paramWebView, String paramString) {
        Log.debug("[InMobi]-[RE]-4.5.1", "IMWebView-> onPageFinished, url: " + paramString);
        if (IMWebView.a(this.a) != null) {
            IMWebView.a(this.a).onPageFinished(paramWebView, paramString);
        }
        if (IMWebView.d(this.a)) {
            return;
        }
        for (; ; ) {
            try {
                if ((IMWebView.e(this.a).contains(paramString)) && (!this.a.mraidLoaded)) {
                    this.a.injectJavaScript(Initializer.getMRAIDString());
                }
                Log.debug("[InMobi]-[RE]-4.5.1", "IMWebView-> Current State:" + IMWebView.b(this.a));
                if (IMWebView.b(this.a) != IMWebView.ViewState.LOADING) {
                    break;
                }
                this.a.injectJavaScript("window.mraid.broadcastEvent('ready');");
                this.a.injectJavaScript("window._im_imai.broadcastEvent('ready');");
                Log.debug("[InMobi]-[RE]-4.5.1", "IMWebView-> Firing ready event at " + paramWebView);
                if (this.a.mOriginalWebviewForExpandUrl != null) {
                    this.a.setState(IMWebView.ViewState.EXPANDED);
                    if (((!this.a.mIsInterstitialAd) || (this.a.mWebViewIsBrowserActivity)) && (this.a.getVisibility() == 4)) {
                        this.a.setVisibility(0);
                    }
                    if ((IMWebView.f(this.a) != null) && (!IMWebView.c(this.a).get())) {
                        IMWebView.f(this.a).sendToTarget();
                    }
                    if (IMWebView.g(this.a) == null) {
                        break;
                    }
                    IMWebView.g(this.a).sendToTarget();
                    return;
                }
            } catch (Exception paramWebView) {
                Log.debug("[InMobi]-[RE]-4.5.1", "Exception in onPageFinished ", paramWebView);
                return;
            }
            this.a.setState(IMWebView.ViewState.DEFAULT);
        }
    }

    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
        this.a.setState(IMWebView.ViewState.LOADING);
        Log.debug("[InMobi]-[RE]-4.5.1", "IMWebView-> onPageStarted url: " + paramString + " p " + this.a.getParent());
        if (this.a.getParent() == null) {
            IMWebView.a(this.a, true);
        }
        if (IMWebView.a(this.a) != null) {
            IMWebView.a(this.a).onPageStarted(paramWebView, paramString, paramBitmap);
        }
        this.a.mraidLoaded = false;
    }

    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
        Log.debug("[InMobi]-[RE]-4.5.1", "IMWebView-> error: " + paramString1);
        if (IMWebView.a(this.a) != null) {
            IMWebView.a(this.a).onReceivedError(paramWebView, paramInt, paramString1, paramString2);
        }
        try {
            if ((IMWebView.b(this.a) == IMWebView.ViewState.LOADING) && (this.a.mListener != null) && (!IMWebView.c(this.a).get())) {
                this.a.mListener.onError();
            }
            IMWebView.a(this.a, null);
            IMWebView.b(this.a, true);
            return;
        } catch (Exception paramWebView) {
            Log.debug("[InMobi]-[RE]-4.5.1", "Exception in webview loading ", paramWebView);
        }
    }

    @TargetApi(14)
    public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError) {
        IMWebView.a(this.a, paramSslErrorHandler, paramSslError);
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
        Log.debug("[InMobi]-[RE]-4.5.1", "IMWebView-> shouldOverrideUrlLoading, url:" + paramString + "webview id" + paramWebView);
        try {
            if (this.a.mWebViewIsBrowserActivity) {
                if ((paramString.startsWith("http:")) || (paramString.startsWith("https:"))) {
                    this.a.doHidePlayers();
                    return false;
                }
                IMWebView.a(this.a, paramString);
                return true;
            }
        } catch (Exception paramWebView) {
            Log.internal("[InMobi]-[RE]-4.5.1", "Should override exception", paramWebView);
            return false;
        }
        IMWebView.a(this.a, paramString);
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */