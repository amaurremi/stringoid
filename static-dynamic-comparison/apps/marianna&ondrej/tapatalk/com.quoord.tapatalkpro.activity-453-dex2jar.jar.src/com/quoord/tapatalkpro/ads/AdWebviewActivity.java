package com.quoord.tapatalkpro.ads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.quoord.tapatalkpro.util.CustomTracker;

public class AdWebviewActivity
        extends Activity {
    WebView webview;

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903052);
        this.webview = ((WebView) findViewById(2131230789));
        this.webview.getSettings().setBuiltInZoomControls(true);
        if (getIntent().getBooleanExtra("ispost", true)) {
            this.webview.loadUrl("http://www.postrelease.com/content/tapatalk/whatsthis.html");
            return;
        }
        this.webview.loadUrl("http://tapatalk.com/promoted.php");
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
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ads/AdWebviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */