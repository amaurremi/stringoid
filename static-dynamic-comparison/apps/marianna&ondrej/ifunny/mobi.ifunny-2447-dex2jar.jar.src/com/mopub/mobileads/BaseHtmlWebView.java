package com.mopub.mobileads;

import android.content.Context;
import android.webkit.WebSettings;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.VersionCode;

public class BaseHtmlWebView
        extends BaseWebView
        implements ViewGestureDetector.UserClickListener {
    private boolean mClicked;
    private final ViewGestureDetector mViewGestureDetector;

    public BaseHtmlWebView(Context paramContext, AdConfiguration paramAdConfiguration) {
        super(paramContext);
        disableScrollingAndZoom();
        getSettings().setJavaScriptEnabled(true);
        this.mViewGestureDetector = new ViewGestureDetector(paramContext, this, paramAdConfiguration);
        this.mViewGestureDetector.setUserClickListener(this);
        if (VersionCode.currentApiLevel().isAtLeast(VersionCode.ICE_CREAM_SANDWICH)) {
            enablePlugins(true);
        }
        setBackgroundColor(0);
    }

    private void disableScrollingAndZoom() {
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        getSettings().setSupportZoom(false);
    }

    public void init(boolean paramBoolean) {
        initializeOnTouchListener(paramBoolean);
    }

    void initializeOnTouchListener(boolean paramBoolean) {
        setOnTouchListener(new BaseHtmlWebView .1 (this, paramBoolean));
    }

    void loadHtmlResponse(String paramString) {
        loadDataWithBaseURL("http://ads.mopub.com/", paramString, "text/html", "utf-8", null);
    }

    public void loadUrl(String paramString) {
        if (paramString == null) {
        }
        do {
            return;
            MoPubLog.d("Loading url: " + paramString);
        } while (!paramString.startsWith("javascript:"));
        super.loadUrl(paramString);
    }

    public void onResetUserClick() {
        this.mClicked = false;
    }

    public void onUserClick() {
        this.mClicked = true;
    }

    public boolean wasClicked() {
        return this.mClicked;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/BaseHtmlWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */