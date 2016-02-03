package com.amazon.device.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class em
        extends WebViewClient {
    em(el paramel) {
    }

    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
        dv.d(el.a, "MRAID error: %s", new Object[]{paramString1});
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
        if (paramString == null) {
        }
        while ((!paramString.startsWith("market:")) && (!paramString.startsWith("tel:")) && (!paramString.startsWith("voicemail:")) && (!paramString.startsWith("sms:")) && (!paramString.startsWith("mailto:")) && (!paramString.startsWith("geo:")) && (!paramString.startsWith("google.streetview:"))) {
            return false;
        }
        try {
            el.a(this.a).startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
            return true;
        } catch (ActivityNotFoundException paramWebView) {
            for (; ; ) {
                dv.d(el.a, "Could not handle intent with URI: %s", new Object[]{paramString});
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/em.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */