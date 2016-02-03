package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.common.internal.ad;

import java.net.URI;
import java.net.URISyntaxException;

@ii
public class nr
        extends WebViewClient {
    private final String a = b(paramString);
    private boolean b = false;
    private final mz c;
    private final jk d;

    public nr(jk paramjk, mz parammz, String paramString) {
        this.c = parammz;
        this.d = paramjk;
    }

    private String b(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
        }
        for (; ; ) {
            return paramString;
            try {
                if (paramString.endsWith("/")) {
                    String str = paramString.substring(0, paramString.length() - 1);
                    return str;
                }
            } catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {
                mx.b(localIndexOutOfBoundsException.getMessage());
            }
        }
        return paramString;
    }

    protected boolean a(String paramString) {
        paramString = b(paramString);
        if (TextUtils.isEmpty(paramString)) {
        }
        for (; ; ) {
            return false;
            try {
                Object localObject1 = new URI(paramString);
                if ("passback".equals(((URI) localObject1).getScheme())) {
                    mx.a("Passback received");
                    this.d.b();
                    return true;
                }
                if (!TextUtils.isEmpty(this.a)) {
                    Object localObject2 = new URI(this.a);
                    paramString = ((URI) localObject2).getHost();
                    String str = ((URI) localObject1).getHost();
                    localObject2 = ((URI) localObject2).getPath();
                    localObject1 = ((URI) localObject1).getPath();
                    if ((ad.a(paramString, str)) && (ad.a(localObject2, localObject1))) {
                        mx.a("Passback received");
                        this.d.b();
                        return true;
                    }
                }
            } catch (URISyntaxException paramString) {
                mx.b(paramString.getMessage());
            }
        }
        return false;
    }

    public void onLoadResource(WebView paramWebView, String paramString) {
        mx.a("JavascriptAdWebViewClient::onLoadResource: " + paramString);
        if (!a(paramString)) {
            this.c.f().onLoadResource(this.c, paramString);
        }
    }

    public void onPageFinished(WebView paramWebView, String paramString) {
        mx.a("JavascriptAdWebViewClient::onPageFinished: " + paramString);
        if (!this.b) {
            this.d.a();
            this.b = true;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
        mx.a("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + paramString);
        if (a(paramString)) {
            mx.a("shouldOverrideUrlLoading: received passback url");
            return true;
        }
        return this.c.f().shouldOverrideUrlLoading(this.c, paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/nr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */