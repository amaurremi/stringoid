package com.mopub.mobileads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URI;

class MraidView$MraidWebViewClient
        extends WebViewClient {
    private MraidView$MraidWebViewClient(MraidView paramMraidView) {
    }

    public void onLoadResource(WebView paramWebView, String paramString) {
        Log.d("MraidView", "Loaded resource: " + paramString);
    }

    public void onPageFinished(WebView paramWebView, String paramString) {
        if (!MraidView.access$500(this.this$0)) {
            MraidView.access$600(this.this$0).initializeJavaScriptState();
            this.this$0.fireChangeEventForProperty(MraidPlacementTypeProperty.createWithType(MraidView.access$700(this.this$0)));
            this.this$0.fireReadyEvent();
            if (this.this$0.getMraidListener() != null) {
                this.this$0.getMraidListener().onReady(this.this$0);
            }
            paramWebView = this.this$0;
            if (this.this$0.getVisibility() != 0) {
                break label120;
            }
        }
        label120:
        for (boolean bool = true; ; bool = false) {
            MraidView.access$802(paramWebView, bool);
            this.this$0.fireChangeEventForProperty(MraidViewableProperty.createWithViewable(MraidView.access$800(this.this$0)));
            MraidView.access$502(this.this$0, true);
            return;
        }
    }

    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
        Log.d("MraidView", "Error: " + paramString1);
        super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
        paramWebView = Uri.parse(paramString).getScheme();
        if ("mopub".equals(paramWebView)) {
            return true;
        }
        if ("mraid".equals(paramWebView)) {
            MraidView.access$400(this.this$0, URI.create(paramString));
            return true;
        }
        if (this.this$0.wasClicked()) {
            paramWebView = new Intent();
            paramWebView.setAction("android.intent.action.VIEW");
            paramWebView.setData(Uri.parse(paramString));
            paramWebView.addFlags(268435456);
            try {
                this.this$0.getContext().startActivity(paramWebView);
                return true;
            } catch (ActivityNotFoundException paramWebView) {
                return false;
            }
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MraidView$MraidWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */