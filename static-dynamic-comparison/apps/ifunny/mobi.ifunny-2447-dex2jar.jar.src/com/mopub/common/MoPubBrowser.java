package com.mopub.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Drawables;

public class MoPubBrowser
        extends Activity {
    public static final String DESTINATION_URL_KEY = "URL";
    private WebView a;
    private ImageButton b;
    private ImageButton c;
    private ImageButton d;
    private ImageButton e;

    private ImageButton a(Drawable paramDrawable) {
        ImageButton localImageButton = new ImageButton(this);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0F);
        localLayoutParams.gravity = 16;
        localImageButton.setLayoutParams(localLayoutParams);
        localImageButton.setImageDrawable(paramDrawable);
        return localImageButton;
    }

    private void a() {
        WebSettings localWebSettings = this.a.getSettings();
        localWebSettings.setJavaScriptEnabled(true);
        localWebSettings.setSupportZoom(true);
        localWebSettings.setBuiltInZoomControls(true);
        localWebSettings.setUseWideViewPort(true);
        this.a.loadUrl(getIntent().getStringExtra("URL"));
        this.a.setWebViewClient(new m(this));
        this.a.setWebChromeClient(new n(this));
    }

    private void b() {
        this.b.setBackgroundColor(0);
        this.b.setOnClickListener(new o(this));
        this.c.setBackgroundColor(0);
        this.c.setOnClickListener(new p(this));
        this.d.setBackgroundColor(0);
        this.d.setOnClickListener(new q(this));
        this.e.setBackgroundColor(0);
        this.e.setOnClickListener(new r(this));
    }

    private void c() {
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().startSync();
    }

    private View d() {
        LinearLayout localLinearLayout = new LinearLayout(this);
        localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        localLinearLayout.setOrientation(1);
        RelativeLayout localRelativeLayout = new RelativeLayout(this);
        localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        localLinearLayout.addView(localRelativeLayout);
        Object localObject = new LinearLayout(this);
        ((LinearLayout) localObject).setId(1);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.addRule(12);
        ((LinearLayout) localObject).setLayoutParams(localLayoutParams);
        ((LinearLayout) localObject).setBackgroundDrawable(Drawables.BACKGROUND.decodeImage(this));
        localRelativeLayout.addView((View) localObject);
        this.b = a(Drawables.LEFT_ARROW.decodeImage(this));
        this.c = a(Drawables.RIGHT_ARROW.decodeImage(this));
        this.d = a(Drawables.REFRESH.decodeImage(this));
        this.e = a(Drawables.CLOSE.decodeImage(this));
        ((LinearLayout) localObject).addView(this.b);
        ((LinearLayout) localObject).addView(this.c);
        ((LinearLayout) localObject).addView(this.d);
        ((LinearLayout) localObject).addView(this.e);
        this.a = new WebView(this);
        localObject = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams) localObject).addRule(2, 1);
        this.a.setLayoutParams((ViewGroup.LayoutParams) localObject);
        localRelativeLayout.addView(this.a);
        return localLinearLayout;
    }

    public static void open(Context paramContext, String paramString) {
        MoPubLog.d("Opening url in MoPubBrowser: " + paramString);
        Intent localIntent = new Intent(paramContext, MoPubBrowser.class);
        localIntent.putExtra("URL", paramString);
        localIntent.addFlags(268435456);
        paramContext.startActivity(localIntent);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setResult(-1);
        getWindow().requestFeature(2);
        getWindow().setFeatureInt(2, -1);
        setContentView(d());
        a();
        b();
        c();
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/MoPubBrowser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */