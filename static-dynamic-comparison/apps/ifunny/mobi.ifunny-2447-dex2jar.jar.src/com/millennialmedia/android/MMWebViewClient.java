package com.millennialmedia.android;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

abstract class MMWebViewClient
        extends WebViewClient {
    MMWebViewClient.MMWebViewClientListener a;
    HttpRedirection.RedirectionListenerImpl b;
    boolean c;
    private ExecutorService d = Executors.newCachedThreadPool();

    MMWebViewClient(MMWebViewClient.MMWebViewClientListener paramMMWebViewClientListener, HttpRedirection.RedirectionListenerImpl paramRedirectionListenerImpl) {
        this.a = paramMMWebViewClientListener;
        this.b = paramRedirectionListenerImpl;
    }

    abstract void a(MMWebView paramMMWebView);

    public void onPageFinished(WebView paramWebView, String paramString) {
        MMWebView localMMWebView = (MMWebView) paramWebView;
        if (!localMMWebView.a(paramString)) {
            this.a.onPageFinished(paramString);
            localMMWebView.t();
            a(localMMWebView);
            MMLog.b("MMWebViewClient", "onPageFinished webview: " + localMMWebView.toString() + "url is " + paramString);
        }
        super.onPageFinished(paramWebView, paramString);
    }

    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
        MMLog.b("MMWebViewClient", String.format("onPageStarted: %s", new Object[]{paramString}));
        this.a.a(paramString);
        MMWebView localMMWebView = (MMWebView) paramWebView;
        localMMWebView.c = "loading";
        localMMWebView.g = false;
        super.onPageStarted(paramWebView, paramString, paramBitmap);
    }

    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
        MMLog.e("MMWebViewClient", String.format("Error: %s %s %s", new Object[]{Integer.valueOf(paramInt), paramString1, paramString2}));
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
        MMWebView localMMWebView = (MMWebView) paramWebView;
        if (!localMMWebView.a(paramString)) {
            MMLog.a("MMWebViewClient", "@@@@@@@@@@SHOULDOVERRIDELOADING@@@@@@@@@@@@@ Url is " + paramString + " for " + paramWebView);
            if (paramString.substring(0, 6).equalsIgnoreCase("mmsdk:")) {
                MMLog.a("MMWebViewClient", "Running JS bridge command: " + paramString);
                paramWebView = new MMCommand((MMWebView) paramWebView, paramString);
                this.c = paramWebView.a();
                this.d.execute(paramWebView);
                return true;
            }
            if (this.b.isExpandingToUrl()) {
                return false;
            }
            this.b.a = paramString;
            this.b.b = new WeakReference(paramWebView.getContext());
            this.b.e = localMMWebView.a;
            HttpRedirection.a(this.b);
        }
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */