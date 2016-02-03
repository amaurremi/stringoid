package com.androidquery.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Picture;
import android.os.Build.VERSION;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebView.PictureListener;
import android.webkit.WebViewClient;

public class WebImage
        extends WebViewClient {
    private static final String DOUBLE_TAP_TOAST_COUNT = "double_tap_toast_count";
    private static final String PREF_FILE = "WebViewSettings";
    private static String template;
    private int color;
    private boolean control;
    private Object progress;
    private String url;
    private WebView wv;
    private boolean zoom;

    public WebImage(WebView paramWebView, String paramString, Object paramObject, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
        this.wv = paramWebView;
        this.url = paramString;
        this.progress = paramObject;
        this.zoom = paramBoolean1;
        this.control = paramBoolean2;
        this.color = paramInt;
    }

    private void delaySetup() {
        this.wv.setPictureListener(new WebView.PictureListener() {
            public void onNewPicture(WebView paramAnonymousWebView, Picture paramAnonymousPicture) {
                WebImage.this.wv.setPictureListener(null);
                WebImage.this.setup();
            }
        });
        this.wv.loadData("<html></html>", "text/html", "utf-8");
        this.wv.setBackgroundColor(this.color);
    }

    private static void disableZoomControl(WebView paramWebView) {
        if (Build.VERSION.SDK_INT < 11) {
            return;
        }
        AQUtility.invokeHandler(paramWebView.getSettings(), "setDisplayZoomControls", false, false, new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(false)});
    }

    private void done(WebView paramWebView) {
        if (this.progress != null) {
            paramWebView.setVisibility(0);
            Common.showProgress(this.progress, this.url, false);
        }
        paramWebView.setWebViewClient(null);
    }

    private static void fixWebviewTip(Context paramContext) {
        paramContext = paramContext.getSharedPreferences("WebViewSettings", 0);
        if (paramContext.getInt("double_tap_toast_count", 1) > 0) {
            paramContext.edit().putInt("double_tap_toast_count", 0).commit();
        }
    }

    private static String getSource(Context paramContext) {
        if (template == null) {
        }
        try {
            template = new String(AQUtility.toBytes(paramContext.getClassLoader().getResourceAsStream("com/androidquery/util/web_image.html")));
            return template;
        } catch (Exception paramContext) {
            for (; ; ) {
                AQUtility.debug(paramContext);
            }
        }
    }

    private void setup() {
        String str = getSource(this.wv.getContext()).replace("@src", this.url).replace("@color", Integer.toHexString(this.color));
        this.wv.setWebViewClient(this);
        this.wv.loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
        this.wv.setBackgroundColor(this.color);
    }

    public void load() {
        if (this.url.equals(this.wv.getTag(1090453505))) {
            return;
        }
        this.wv.setTag(1090453505, this.url);
        if (Build.VERSION.SDK_INT <= 10) {
            this.wv.setDrawingCacheEnabled(true);
        }
        fixWebviewTip(this.wv.getContext());
        WebSettings localWebSettings = this.wv.getSettings();
        localWebSettings.setSupportZoom(this.zoom);
        localWebSettings.setBuiltInZoomControls(this.zoom);
        if (!this.control) {
            disableZoomControl(this.wv);
        }
        localWebSettings.setJavaScriptEnabled(true);
        this.wv.setBackgroundColor(this.color);
        if (this.progress != null) {
            Common.showProgress(this.progress, this.url, true);
        }
        if (this.wv.getWidth() > 0) {
            setup();
            return;
        }
        delaySetup();
    }

    public void onPageFinished(WebView paramWebView, String paramString) {
        done(paramWebView);
    }

    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
        done(paramWebView);
    }

    public void onScaleChanged(WebView paramWebView, float paramFloat1, float paramFloat2) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/androidquery/util/WebImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */