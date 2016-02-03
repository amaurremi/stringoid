package com.facebook.widget;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookServiceException;
import com.facebook.internal.Utility;

class WebDialog$DialogWebViewClient
        extends WebViewClient {
    private WebDialog$DialogWebViewClient(WebDialog paramWebDialog) {
    }

    public void onPageFinished(WebView paramWebView, String paramString) {
        super.onPageFinished(paramWebView, paramString);
        if (!WebDialog.access$500(this.this$0)) {
            WebDialog.access$600(this.this$0).dismiss();
        }
        WebDialog.access$700(this.this$0).setBackgroundColor(0);
        WebDialog.access$800(this.this$0).setVisibility(0);
        WebDialog.access$900(this.this$0).setVisibility(0);
    }

    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
        Utility.logd("FacebookSDK.WebDialog", "Webview loading URL: " + paramString);
        super.onPageStarted(paramWebView, paramString, paramBitmap);
        if (!WebDialog.access$500(this.this$0)) {
            WebDialog.access$600(this.this$0).show();
        }
    }

    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
        super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
        WebDialog.access$400(this.this$0, new FacebookDialogException(paramString1, paramInt, paramString2));
        this.this$0.dismiss();
    }

    public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError) {
        super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
        WebDialog.access$400(this.this$0, new FacebookDialogException(null, -11, null));
        paramSslErrorHandler.cancel();
        this.this$0.dismiss();
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
        Utility.logd("FacebookSDK.WebDialog", "Redirect URL: " + paramString);
        Bundle localBundle;
        String str;
        if (paramString.startsWith(WebDialog.access$200(this.this$0))) {
            localBundle = this.this$0.parseResponseUri(paramString);
            paramString = localBundle.getString("error");
            paramWebView = paramString;
            if (paramString == null) {
                paramWebView = localBundle.getString("error_type");
            }
            str = localBundle.getString("error_msg");
            paramString = str;
            if (str == null) {
                paramString = localBundle.getString("error_description");
            }
            str = localBundle.getString("error_code");
            if (Utility.isNullOrEmpty(str)) {
                break label285;
            }
        }
        for (; ; ) {
            try {
                i = Integer.parseInt(str);
                if ((Utility.isNullOrEmpty(paramWebView)) && (Utility.isNullOrEmpty(paramString)) && (i == -1)) {
                    WebDialog.access$300(this.this$0, localBundle);
                    this.this$0.dismiss();
                    return true;
                }
            } catch (NumberFormatException localNumberFormatException) {
                i = -1;
                continue;
                if ((paramWebView != null) && ((paramWebView.equals("access_denied")) || (paramWebView.equals("OAuthAccessDeniedException")))) {
                    WebDialog.access$000(this.this$0);
                    continue;
                }
                paramWebView = new FacebookRequestError(i, paramWebView, paramString);
                WebDialog.access$400(this.this$0, new FacebookServiceException(paramWebView, paramString));
                continue;
            }
            if (paramString.startsWith("fbconnect://cancel")) {
                WebDialog.access$000(this.this$0);
                this.this$0.dismiss();
                return true;
            }
            if (paramString.contains("touch")) {
                return false;
            }
            this.this$0.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
            return true;
            label285:
            int i = -1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/WebDialog$DialogWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */