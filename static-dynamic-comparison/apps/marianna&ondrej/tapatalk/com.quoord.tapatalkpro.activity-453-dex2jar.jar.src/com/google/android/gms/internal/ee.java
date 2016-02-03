package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URI;
import java.net.URISyntaxException;

public class ee
        extends WebViewClient {
    private final dz lC;
    private final String rM = B(paramString);
    private boolean rN = false;
    private final ct rO;

    public ee(ct paramct, dz paramdz, String paramString) {
        this.lC = paramdz;
        this.rO = paramct;
    }

    private String B(String paramString) {
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
                dw.w(localIndexOutOfBoundsException.getMessage());
            }
        }
        return paramString;
    }

    protected boolean A(String paramString) {
        paramString = B(paramString);
        if (TextUtils.isEmpty(paramString)) {
        }
        for (; ; ) {
            return false;
            try {
                Object localObject1 = new URI(paramString);
                if ("passback".equals(((URI) localObject1).getScheme())) {
                    dw.v("Passback received");
                    this.rO.bb();
                    return true;
                }
                if (!TextUtils.isEmpty(this.rM)) {
                    Object localObject2 = new URI(this.rM);
                    paramString = ((URI) localObject2).getHost();
                    String str = ((URI) localObject1).getHost();
                    localObject2 = ((URI) localObject2).getPath();
                    localObject1 = ((URI) localObject1).getPath();
                    if ((fo.equal(paramString, str)) && (fo.equal(localObject2, localObject1))) {
                        dw.v("Passback received");
                        this.rO.bb();
                        return true;
                    }
                }
            } catch (URISyntaxException paramString) {
                dw.w(paramString.getMessage());
            }
        }
        return false;
    }

    public void onLoadResource(WebView paramWebView, String paramString) {
        dw.v("JavascriptAdWebViewClient::onLoadResource: " + paramString);
        if (!A(paramString)) {
            this.lC.bI().onLoadResource(this.lC, paramString);
        }
    }

    public void onPageFinished(WebView paramWebView, String paramString) {
        dw.v("JavascriptAdWebViewClient::onPageFinished: " + paramString);
        if (!this.rN) {
            this.rO.ba();
            this.rN = true;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
        dw.v("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + paramString);
        if (A(paramString)) {
            dw.v("shouldOverrideUrlLoading: received passback url");
            return true;
        }
        return this.lC.bI().shouldOverrideUrlLoading(this.lC, paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/ee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */