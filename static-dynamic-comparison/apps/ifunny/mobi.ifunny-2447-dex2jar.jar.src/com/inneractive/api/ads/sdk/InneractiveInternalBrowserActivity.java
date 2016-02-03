package com.inneractive.api.ads.sdk;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class InneractiveInternalBrowserActivity
        extends Activity {
    private static InneractiveInternalBrowserActivity.a g;
    private LinearLayout a;
    private WebView b;
    private ImageButton c;
    private ImageButton d;
    private ImageButton e;
    private ImageButton f;

    private ImageButton a(Drawable paramDrawable) {
        ImageButton localImageButton = new ImageButton(this);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0F);
        localLayoutParams.gravity = 16;
        localImageButton.setLayoutParams(localLayoutParams);
        localImageButton.setImageDrawable(paramDrawable);
        return localImageButton;
    }

    static void a(InneractiveInternalBrowserActivity.a parama) {
        g = parama;
    }

    private static boolean a(String paramString) {
        return (paramString.startsWith("tel:")) || (paramString.startsWith("voicemail:")) || (paramString.startsWith("sms:")) || (paramString.startsWith("mailto:")) || (paramString.startsWith("geo:")) || (paramString.startsWith("google.streetview:"));
    }

    private boolean b(String paramString) {
        Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        localIntent.addFlags(268435456);
        try {
            startActivity(localIntent);
            if (g != null) {
                g.onApplicationInBackground();
            }
            return true;
        } catch (ActivityNotFoundException localActivityNotFoundException) {
            InneractiveAdView.Log.w("Inneractive_warning", "Failed to start activity for " + paramString + ". Please ensure that your phone can handle this intent.");
        }
        return false;
    }

    public void onBackPressed() {
        finish();
        if (g != null) {
            g.onInternalBrowserDismissed();
        }
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        getWindow().requestFeature(2);
        getWindow().setFeatureInt(2, -1);
        this.a = new LinearLayout(this);
        paramBundle = new LinearLayout.LayoutParams(-1, -1);
        this.a.setLayoutParams(paramBundle);
        this.a.setOrientation(1);
        paramBundle = new RelativeLayout(this);
        paramBundle.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.a.addView(paramBundle);
        Object localObject = new LinearLayout(this);
        ((LinearLayout) localObject).setId(1);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.addRule(12);
        ((LinearLayout) localObject).setLayoutParams(localLayoutParams);
        ((LinearLayout) localObject).setBackgroundDrawable(IAdefines.IAresources.a.a(this));
        paramBundle.addView((View) localObject);
        this.c = a(IAdefines.IAresources.b.a(this));
        this.d = a(IAdefines.IAresources.d.a(this));
        this.e = a(IAdefines.IAresources.f.a(this));
        this.f = a(IAdefines.IAresources.g.a(this));
        ((LinearLayout) localObject).addView(this.c);
        ((LinearLayout) localObject).addView(this.d);
        ((LinearLayout) localObject).addView(this.e);
        ((LinearLayout) localObject).addView(this.f);
        this.b = new WebView(this);
        localObject = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams) localObject).addRule(2, 1);
        this.b.setLayoutParams((ViewGroup.LayoutParams) localObject);
        paramBundle.addView(this.b);
        setContentView(this.a);
        paramBundle = getIntent();
        localObject = this.b.getSettings();
        ((WebSettings) localObject).setJavaScriptEnabled(true);
        ((WebSettings) localObject).setSupportZoom(true);
        ((WebSettings) localObject).setBuiltInZoomControls(true);
        ((WebSettings) localObject).setUseWideViewPort(true);
        this.b.setWebViewClient(new InneractiveInternalBrowserActivity .1 (this));
        this.b.setWebChromeClient(new InneractiveInternalBrowserActivity .2 (this));
        paramBundle = paramBundle.getStringExtra("extra_url");
        if (a(paramBundle)) {
            b(paramBundle);
            finish();
        }
        for (; ; ) {
            this.c.setBackgroundColor(0);
            this.c.setOnClickListener(new InneractiveInternalBrowserActivity .3 (this));
            this.d.setBackgroundColor(0);
            this.d.setOnClickListener(new InneractiveInternalBrowserActivity .4 (this));
            this.e.setBackgroundColor(0);
            this.e.setOnClickListener(new InneractiveInternalBrowserActivity .5 (this));
            this.f.setBackgroundColor(0);
            this.f.setOnClickListener(new InneractiveInternalBrowserActivity .6 (this));
            CookieSyncManager.createInstance(this);
            CookieSyncManager.getInstance().startSync();
            return;
            this.b.loadUrl(paramBundle);
        }
    }

    protected void onDestroy() {
        if (this.a != null) {
            this.a.removeAllViews();
        }
        this.b.destroy();
        super.onDestroy();
    }

    protected void onPause() {
        super.onPause();
        CookieSyncManager.getInstance().stopSync();
    }

    protected void onResume() {
        super.onResume();
        CookieSyncManager.getInstance().startSync();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/InneractiveInternalBrowserActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */