package com.everimaging.fotor.discovery;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.LayoutParams;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.everimaging.fotor.b;
import com.everimaging.fotorsdk.widget.FotorTitleBackButton;

public class DiscoveryNewsDetailsActivity
        extends b {
    private String a;
    private WebView b;
    private View c;
    private View d;
    private ImageView e;
    private View.OnClickListener f = new View.OnClickListener() {
        public void onClick(View paramAnonymousView) {
            DiscoveryNewsDetailsActivity.e(DiscoveryNewsDetailsActivity.this);
        }
    };

    private void a() {
        this.c = findViewById(2131558575);
        this.d = findViewById(2131558565);
        this.e = ((ImageView) this.d.findViewById(2131558567));
        this.e.setOnClickListener(this.f);
        this.b = ((WebView) findViewById(2131558574));
        this.b.getSettings().setJavaScriptEnabled(true);
        this.b.getSettings().setBuiltInZoomControls(true);
        this.b.getSettings().setSupportZoom(true);
        this.b.setWebViewClient(new WebViewClient() {
            private boolean b;

            public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString) {
                int j = 0;
                DiscoveryNewsDetailsActivity.a(DiscoveryNewsDetailsActivity.this).setVisibility(8);
                if (DiscoveryNewsDetailsActivity.b(DiscoveryNewsDetailsActivity.this) != null) {
                    paramAnonymousWebView = DiscoveryNewsDetailsActivity.c(DiscoveryNewsDetailsActivity.this);
                    if (!this.b) {
                        break label72;
                    }
                    i = 8;
                    paramAnonymousWebView.setVisibility(i);
                    paramAnonymousWebView = DiscoveryNewsDetailsActivity.d(DiscoveryNewsDetailsActivity.this);
                    if (!this.b) {
                        break label77;
                    }
                }
                label72:
                label77:
                for (int i = j; ; i = 8) {
                    paramAnonymousWebView.setVisibility(i);
                    return;
                    i = 0;
                    break;
                }
            }

            public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap) {
                this.b = false;
                DiscoveryNewsDetailsActivity.a(DiscoveryNewsDetailsActivity.this).setVisibility(0);
                DiscoveryNewsDetailsActivity.d(DiscoveryNewsDetailsActivity.this).setVisibility(8);
            }

            public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2) {
                if (DiscoveryNewsDetailsActivity.b(DiscoveryNewsDetailsActivity.this) != null) {
                    this.b = true;
                }
            }

            public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString) {
                return false;
            }
        });
    }

    private void a(Intent paramIntent) {
        if ((paramIntent != null) && (paramIntent.hasExtra("Discovery_News_Link_Url"))) {
            this.a = paramIntent.getStringExtra("Discovery_News_Link_Url");
        }
    }

    private void b() {
        this.b.loadUrl(this.a);
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        paramBundle = getSupportActionBar();
        paramBundle.setNavigationMode(0);
        paramBundle.setDisplayShowCustomEnabled(true);
        paramBundle.setDisplayShowHomeEnabled(false);
        paramBundle.setDisplayShowTitleEnabled(false);
        FotorTitleBackButton localFotorTitleBackButton = new FotorTitleBackButton(this);
        localFotorTitleBackButton.setText(getString(2131296540));
        LinearLayout localLinearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.leftMargin = getResources().getDimensionPixelOffset(2131165196);
        localLinearLayout.addView(localFotorTitleBackButton, localLayoutParams);
        paramBundle.setCustomView(localLinearLayout, new ActionBar.LayoutParams(-2, -2, 19));
        localFotorTitleBackButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                DiscoveryNewsDetailsActivity.this.finish();
            }
        });
        setContentView(2130903094);
        a(getIntent());
        a();
        b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/discovery/DiscoveryNewsDetailsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */