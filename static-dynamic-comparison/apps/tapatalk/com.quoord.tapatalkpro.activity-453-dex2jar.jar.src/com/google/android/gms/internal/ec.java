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

public class ec
        extends ea {
    public ec(dz paramdz, boolean paramBoolean) {
        super(paramdz, paramBoolean);
    }

    protected WebResourceResponse d(Context paramContext, String paramString1, String paramString2)
            throws IOException {
        paramString2 = (HttpURLConnection) new URL(paramString2).openConnection();
        try {
            dq.a(paramContext, paramString1, true, paramString2);
            paramString2.connect();
            paramContext = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(dq.a(new InputStreamReader(paramString2.getInputStream())).getBytes("UTF-8")));
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
            if (!(paramWebView instanceof dz)) {
                dw.z("Tried to intercept request from a WebView that wasn't an AdWebView.");
                return super.shouldInterceptRequest(paramWebView, paramString);
            }
            Object localObject = (dz) paramWebView;
            ((dz) localObject).bI().aM();
            if (((dz) localObject).R().lT) {
                dw.y("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_interstitial.js)");
                return d(((dz) localObject).getContext(), this.lC.bK().rq, "http://media.admob.com/mraid/v1/mraid_app_interstitial.js");
            }
            if (((dz) localObject).bL()) {
                dw.y("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js)");
                return d(((dz) localObject).getContext(), this.lC.bK().rq, "http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js");
            }
            dw.y("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_banner.js)");
            localObject = d(((dz) localObject).getContext(), this.lC.bK().rq, "http://media.admob.com/mraid/v1/mraid_app_banner.js");
            return (WebResourceResponse) localObject;
        } catch (IOException localIOException) {
            dw.z("Could not fetching MRAID JS. " + localIOException.getMessage());
        }
        return super.shouldInterceptRequest(paramWebView, paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/ec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */