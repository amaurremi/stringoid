package com.androidquery;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.androidquery.util.AQUtility;

public class WebDialog
        extends Dialog {
    private WebViewClient client;
    private LinearLayout ll;
    private String message;
    private String url;
    private WebView wv;

    public WebDialog(Context paramContext, String paramString, WebViewClient paramWebViewClient) {
        super(paramContext, 16973830);
        this.url = paramString;
        this.client = paramWebViewClient;
    }

    private void setupProgress(RelativeLayout paramRelativeLayout) {
        Object localObject1 = getContext();
        this.ll = new LinearLayout((Context) localObject1);
        Object localObject2 = new ProgressBar((Context) localObject1);
        int i = AQUtility.dip2pixel((Context) localObject1, 30.0F);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
        this.ll.addView((View) localObject2, localLayoutParams);
        if (this.message != null) {
            localObject2 = new TextView((Context) localObject1);
            localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
            localLayoutParams.leftMargin = AQUtility.dip2pixel((Context) localObject1, 5.0F);
            localLayoutParams.gravity = 16;
            ((TextView) localObject2).setText(this.message);
            this.ll.addView((View) localObject2, localLayoutParams);
        }
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams) localObject1).addRule(13);
        paramRelativeLayout.addView(this.ll, (ViewGroup.LayoutParams) localObject1);
    }

    private void setupWebView(RelativeLayout paramRelativeLayout) {
        this.wv = new WebView(getContext());
        this.wv.setVerticalScrollBarEnabled(false);
        this.wv.setHorizontalScrollBarEnabled(false);
        if (this.client == null) {
            this.client = new WebViewClient();
        }
        this.wv.setWebViewClient(new DialogWebViewClient(null));
        this.wv.getSettings().setJavaScriptEnabled(true);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        paramRelativeLayout.addView(this.wv, localLayoutParams);
    }

    private void showProgress(boolean paramBoolean) {
        if (this.ll != null) {
            if (paramBoolean) {
                this.ll.setVisibility(0);
            }
        } else {
            return;
        }
        this.ll.setVisibility(8);
    }

    public void dismiss() {
        try {
            super.dismiss();
            return;
        } catch (Exception localException) {
        }
    }

    public void load() {
        if (this.wv != null) {
            this.wv.loadUrl(this.url);
        }
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        paramBundle = new RelativeLayout(getContext());
        paramBundle.setBackgroundColor(-1);
        setupWebView(paramBundle);
        setupProgress(paramBundle);
        addContentView(paramBundle, new FrameLayout.LayoutParams(-1, -1));
    }

    public void setLoadingMessage(String paramString) {
        this.message = paramString;
    }

    private class DialogWebViewClient
            extends WebViewClient {
        private DialogWebViewClient() {
        }

        public void onPageFinished(WebView paramWebView, String paramString) {
            WebDialog.this.showProgress(false);
            WebDialog.this.client.onPageFinished(paramWebView, paramString);
        }

        public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
            WebDialog.this.client.onPageStarted(paramWebView, paramString, paramBitmap);
        }

        public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
            WebDialog.this.client.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
        }

        public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
            return WebDialog.this.client.shouldOverrideUrlLoading(paramWebView, paramString);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/androidquery/WebDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */