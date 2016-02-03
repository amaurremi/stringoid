package com.quoord.tapatalkpro.activity.directory.ics;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.ThemeUtil;

public class TapatalkIdWebviewActivity
        extends Activity {
    ProgressBar progressBar;
    WebView webview;

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        setContentView(2130903052);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setIcon(2130837525);
        this.webview = ((WebView) findViewById(2131230789));
        this.progressBar = ((ProgressBar) findViewById(2131230788));
        paramBundle = this.webview.getSettings();
        paramBundle.setBuiltInZoomControls(true);
        paramBundle.setJavaScriptEnabled(true);
        paramBundle.setAllowFileAccess(true);
        this.webview.setWebViewClient(new myWebClient());
        paramBundle = getIntent().getStringExtra("change_url");
        String str = getIntent().getStringExtra("title");
        getActionBar().setTitle(str);
        this.webview.loadUrl(paramBundle);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return false;
        }
        finish();
        return true;
    }

    protected void onPause() {
        super.onPause();
        CustomTracker.comScorePause(this);
    }

    protected void onResume() {
        super.onResume();
        CustomTracker.comScoreResume(this);
    }

    public void onStart() {
        super.onStart();
        CustomTracker.start(this);
    }

    public void onStop() {
        super.onStop();
        CustomTracker.stop(this);
    }

    public class myWebClient
            extends WebViewClient {
        public myWebClient() {
        }

        public void onPageFinished(WebView paramWebView, String paramString) {
            super.onPageFinished(paramWebView, paramString);
            TapatalkIdWebviewActivity.this.progressBar.setVisibility(8);
        }

        public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
            super.onPageStarted(paramWebView, paramString, paramBitmap);
        }

        public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
            paramWebView.loadUrl(paramString);
            return true;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/directory/ics/TapatalkIdWebviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */