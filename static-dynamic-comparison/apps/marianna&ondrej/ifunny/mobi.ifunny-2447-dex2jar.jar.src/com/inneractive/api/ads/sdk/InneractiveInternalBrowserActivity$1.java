package com.inneractive.api.ads.sdk;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.Toast;

final class InneractiveInternalBrowserActivity$1
        extends WebViewClient {
    InneractiveInternalBrowserActivity$1(InneractiveInternalBrowserActivity paramInneractiveInternalBrowserActivity) {
    }

    public final void onPageFinished(WebView paramWebView, String paramString) {
        super.onPageFinished(paramWebView, paramString);
        if (paramWebView.canGoBack()) {
            paramString = IAdefines.IAresources.b.a(this.a);
            InneractiveInternalBrowserActivity.b(this.a).setImageDrawable(paramString);
            if (!paramWebView.canGoForward()) {
                break label79;
            }
        }
        label79:
        for (paramWebView = IAdefines.IAresources.d.a(this.a); ; paramWebView = IAdefines.IAresources.e.a(this.a)) {
            InneractiveInternalBrowserActivity.a(this.a).setImageDrawable(paramWebView);
            return;
            paramString = IAdefines.IAresources.c.a(this.a);
            break;
        }
    }

    public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
        super.onPageStarted(paramWebView, paramString, paramBitmap);
        InneractiveInternalBrowserActivity.a(this.a).setImageDrawable(IAdefines.IAresources.e.a(this.a));
    }

    public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
        Toast.makeText((Activity) paramWebView.getContext(), "oops...MRAID error occurs: " + paramString1, 0).show();
    }

    public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
        if (paramString == null) {
        }
        do {
            return false;
            paramWebView = Uri.parse(paramString).getHost();
        }
        while (((paramString.startsWith("http:")) || (paramString.startsWith("https:"))) && (!"play.google.com".equals(paramWebView)) && (!"market.android.com".equals(paramWebView)));
        if (InneractiveInternalBrowserActivity.a(this.a, paramString)) {
            InneractiveInternalBrowserActivity.b(this.a, paramString);
        }
        for (; ; ) {
            this.a.finish();
            return true;
            try {
                if (InneractiveInternalBrowserActivity.a() != null) {
                    InneractiveInternalBrowserActivity.a().onApplicationInBackground();
                }
                this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
            } catch (ActivityNotFoundException paramWebView) {
                InneractiveAdView.Log.w("Inneractive_warning", "Failed to start activity for " + paramString + ". Please ensure that your phone can handle this intent.");
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/InneractiveInternalBrowserActivity$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */