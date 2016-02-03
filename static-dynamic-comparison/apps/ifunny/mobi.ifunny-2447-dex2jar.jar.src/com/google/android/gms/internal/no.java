package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@ii
public class no
        extends nb {
    public no(mz parammz, boolean paramBoolean) {
        super(parammz, paramBoolean);
    }

    protected WebResourceResponse a(Context paramContext, String paramString1, String paramString2) {
        paramString2 = (HttpURLConnection) new URL(paramString2).openConnection();
        try {
            lw.a(paramContext, paramString1, true, paramString2, true);
            paramString2.addRequestProperty("Cache-Control", "max-stale=3600");
            paramString2.connect();
            paramContext = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(lw.a(new InputStreamReader(paramString2.getInputStream())).getBytes("UTF-8")));
            return paramContext;
        } finally {
            paramString2.disconnect();
        }
    }

    public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString) {
        try {
            if (!"mraid.js".equalsIgnoreCase(new File(paramString).getName())) {
                return super.shouldInterceptRequest(paramWebView, paramString);
            }
            if (!(paramWebView instanceof mz)) {
                mx.e("Tried to intercept request from a WebView that wasn't an AdWebView.");
                return super.shouldInterceptRequest(paramWebView, paramString);
            }
            Object localObject = (mz) paramWebView;
            ((mz) localObject).f().e();
            if (((mz) localObject).e().e) {
                mx.d("shouldInterceptRequest(https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js)");
                return a(((mz) localObject).getContext(), this.a.i().b, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js");
            }
            if (((mz) localObject).j()) {
                mx.d("shouldInterceptRequest(https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js)");
                return a(((mz) localObject).getContext(), this.a.i().b, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js");
            }
            mx.d("shouldInterceptRequest(https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js)");
            localObject = a(((mz) localObject).getContext(), this.a.i().b, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js");
            return (WebResourceResponse) localObject;
        } catch (IOException localIOException) {
            mx.e("Could not fetch MRAID JS. " + localIOException.getMessage());
        }
        return super.shouldInterceptRequest(paramWebView, paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/no.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */