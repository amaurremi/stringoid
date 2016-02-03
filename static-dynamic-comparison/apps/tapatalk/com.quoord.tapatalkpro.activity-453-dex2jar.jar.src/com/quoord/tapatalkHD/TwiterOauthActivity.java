package com.quoord.tapatalkHD;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import twitter4j.auth.RequestToken;

public class TwiterOauthActivity
        extends Activity {
    private WebView mWebView;

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903411);
        paramBundle = getIntent().getStringExtra("url");
        final RequestToken localRequestToken = (RequestToken) getIntent().getSerializableExtra("token");
        getActionBar().hide();
        this.mWebView = ((WebView) findViewById(2131231689));
        this.mWebView.loadUrl(paramBundle);
        this.mWebView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString) {
                super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
            }

            public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap) {
                super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
                if ((paramAnonymousString != null) && (paramAnonymousString.startsWith("http://tapatalk.com"))) {
                    paramAnonymousWebView = Uri.parse(paramAnonymousString).getQueryParameter("oauth_verifier");
                    Uri.parse(paramAnonymousString).getQueryParameterNames();
                    paramAnonymousString = new Intent();
                    paramAnonymousString.putExtra("oauth_verifier", paramAnonymousWebView);
                    paramAnonymousString.putExtra("token", localRequestToken);
                    TwiterOauthActivity.this.setResult(-1, paramAnonymousString);
                    TwiterOauthActivity.this.finish();
                }
            }

            public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString) {
                paramAnonymousWebView.loadUrl(paramAnonymousString);
                return true;
            }
        });
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkHD/TwiterOauthActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */