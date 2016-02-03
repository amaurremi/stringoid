package com.mopub.common;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.Toast;
import com.mopub.common.util.Drawables;
import com.mopub.common.util.IntentUtils;

class m
        extends WebViewClient {
    m(MoPubBrowser paramMoPubBrowser) {
    }

    public void onPageFinished(WebView paramWebView, String paramString) {
        super.onPageFinished(paramWebView, paramString);
        if (paramWebView.canGoBack()) {
            paramString = Drawables.LEFT_ARROW.decodeImage(this.a);
            MoPubBrowser.b(this.a).setImageDrawable(paramString);
            if (!paramWebView.canGoForward()) {
                break label79;
            }
        }
        label79:
        for (paramWebView = Drawables.RIGHT_ARROW.decodeImage(this.a); ; paramWebView = Drawables.UNRIGHT_ARROW.decodeImage(this.a)) {
            MoPubBrowser.a(this.a).setImageDrawable(paramWebView);
            return;
            paramString = Drawables.UNLEFT_ARROW.decodeImage(this.a);
            break;
        }
    }

    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
        super.onPageStarted(paramWebView, paramString, paramBitmap);
        MoPubBrowser.a(this.a).setImageDrawable(Drawables.UNRIGHT_ARROW.decodeImage(this.a));
    }

    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
        Toast.makeText(this.a, "MoPubBrowser error: " + paramString1, 0).show();
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
        if (paramString == null) {
        }
        do {
            return false;
            paramWebView = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        } while ((!IntentUtils.isDeepLink(paramString)) || (!IntentUtils.deviceCanHandleIntent(this.a, paramWebView)));
        this.a.startActivity(paramWebView);
        this.a.finish();
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */