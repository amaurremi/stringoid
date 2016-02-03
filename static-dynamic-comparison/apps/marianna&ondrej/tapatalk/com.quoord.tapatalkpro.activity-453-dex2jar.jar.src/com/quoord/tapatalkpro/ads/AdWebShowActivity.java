package com.quoord.tapatalkpro.ads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.quoord.tapatalkpro.util.Util;

public class AdWebShowActivity
        extends Activity {
    WebView webview;

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903052);
        this.webview = ((WebView) findViewById(2131230789));
        this.webview.getSettings().setBuiltInZoomControls(true);
        paramBundle = getIntent().getStringExtra("tagurl");
        if (Util.checkString(paramBundle)) {
            this.webview.loadUrl(paramBundle);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ads/AdWebShowActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */