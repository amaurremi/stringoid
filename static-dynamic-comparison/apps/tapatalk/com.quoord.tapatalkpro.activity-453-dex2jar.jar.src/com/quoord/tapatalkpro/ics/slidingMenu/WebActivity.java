package com.quoord.tapatalkpro.ics.slidingMenu;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebActivity
        extends Activity {
    private String mUrl = null;
    public WebView mWebView;
    private String title;

    public void loadUrl(String paramString) {
        this.mWebView.loadUrl(paramString);
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        setContentView(2130903432);
        if (getIntent().hasExtra("title")) {
            this.title = getIntent().getStringExtra("title");
        }
        if (getIntent().hasExtra("url")) {
            this.mUrl = getIntent().getStringExtra("url");
        }
        paramBundle = getActionBar();
        paramBundle.setTitle(this.title);
        paramBundle.setHomeButtonEnabled(true);
        paramBundle.setDisplayHomeAsUpEnabled(true);
        paramBundle.setDisplayShowTitleEnabled(true);
        paramBundle.setIcon(2130837525);
        invalidateOptionsMenu();
        this.mWebView = ((WebView) findViewById(2131231731));
        if (!SettingsFragment.isLightTheme(this)) {
            this.mWebView.setBackgroundResource(2131165282);
        }
        this.mWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString) {
                paramAnonymousString = paramAnonymousString.replace("mailto:", "");
                if (Pattern.compile("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$").matcher(paramAnonymousString).matches()) {
                    paramAnonymousWebView = new Intent("android.intent.action.SEND");
                    paramAnonymousWebView.setType("plain/text");
                    paramAnonymousWebView.putExtra("android.intent.extra.EMAIL", new String[]{paramAnonymousString});
                    paramAnonymousWebView.putExtra("android.intent.extra.SUBJECT", "");
                    paramAnonymousWebView.putExtra("android.intent.extra.TEXT", "");
                    WebActivity.this.startActivity(Intent.createChooser(paramAnonymousWebView, ""));
                    return true;
                }
                paramAnonymousWebView.loadUrl(paramAnonymousString);
                return false;
            }
        });
        this.mWebView.loadUrl(this.mUrl);
        paramBundle = this.mWebView.getSettings();
        paramBundle.setJavaScriptEnabled(true);
        paramBundle.setRenderPriority(WebSettings.RenderPriority.HIGH);
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        if (paramKeyEvent.getAction() == 0) {
        }
        switch (paramInt) {
            default:
                return super.onKeyDown(paramInt, paramKeyEvent);
        }
        if (this.mWebView.canGoBack()) {
            this.mWebView.goBack();
        }
        for (; ; ) {
            return true;
            finish();
        }
    }

    public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
        }
        for (; ; ) {
            return super.onMenuItemSelected(paramInt, paramMenuItem);
            finish();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/WebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */