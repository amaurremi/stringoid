package com.amazon.device.ads;

import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout.LayoutParams;

import java.util.Map;

class HtmlRenderer
        extends AdRenderer {
    public static final String LOG_TAG = HtmlRenderer.class.getSimpleName();
    protected WebView adView_;
    protected boolean hasLoadedAd = false;
    protected boolean shouldForceRenderFailure = false;

    protected HtmlRenderer(AdData paramAdData, IAdController paramIAdController, WebView paramWebView, Context paramContext) {
        super(paramAdData, paramIAdController, paramContext);
        this.adView_ = paramWebView;
        setupAdView();
        if ((Build.VERSION.SDK_INT >= 11) && (this.controller.shouldDisableWebViewHardwareAcceleration())) {
            disableHardwareAcceleration();
        }
    }

    protected void adLoaded(AdProperties paramAdProperties) {
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        this.controller.getAdLayout().addView(this.adView_, localLayoutParams);
        super.adLoaded(paramAdProperties);
    }

    protected void destroy() {
        if (isAdViewNull()) {
            Log.w(LOG_TAG, "Called destroy(), but view is already null.");
        }
        for (; ; ) {
            this.isDestroyed = true;
            return;
            this.adView_.destroy();
            this.adView_ = null;
        }
    }

    protected void disableHardwareAcceleration() {
        AndroidTargetUtils.disableHardwareAcceleration(this.adView_);
    }

    protected boolean getAdState(AdRenderer.AdState paramAdState) {
        return false;
    }

    public void initialize() {
        setupAdView();
        super.initialize();
    }

    protected boolean isAdViewNull() {
        return this.adView_ == null;
    }

    public boolean launchExternalBrowserForLink(String paramString) {
        AdUtils.launchActivityForIntentLink(paramString, this.context);
        return true;
    }

    public void onPageFinished() {
        if ((!this.isDestroyed) && (!this.hasLoadedAd)) {
            this.hasLoadedAd = true;
            adLoaded(this.adData.getProperties());
        }
    }

    protected void prepareToGoAway() {
    }

    protected void removeView() {
        if (this.controller.getAdLayout() != null) {
            this.controller.getAdLayout().removeView(this.adView_);
        }
        this.viewRemoved = true;
    }

    protected boolean render() {
        if ((isAdViewNull()) || (isAdViewDestroyed()) || (this.shouldForceRenderFailure)) {
            return false;
        }
        renderAdView();
        return true;
    }

    protected void renderAdView() {
        this.adView_.loadUrl("about:blank");
        this.hasLoadedAd = false;
        String str = this.adData.getCreative();
        str = ("<html><meta name=\"viewport\" content=\"width=" + this.controller.getWindowWidth() + ", height=" + this.controller.getWindowHeight() + ", initial-scale=" + AdUtils.getViewportInitialScale(getScalingMultiplier()) + ", minimum-scale=" + getScalingMultiplier() + ", maximum-scale=" + getScalingMultiplier() + "\">" + str + "</html>").replace("<head>", "<head><script type=\"text/javascript\">htmlWillCallFinishLoad = 1;</script>");
        this.adView_.loadDataWithBaseURL("http://amazon-adsystem.amazon.com/", str, "text/html", "utf-8", null);
    }

    protected boolean sendCommand(String paramString, Map<String, String> paramMap) {
        return true;
    }

    protected void setupAdView() {
        boolean bool = true;
        this.adView_.setHorizontalScrollBarEnabled(false);
        this.adView_.setHorizontalScrollbarOverlay(false);
        this.adView_.setVerticalScrollBarEnabled(false);
        this.adView_.setVerticalScrollbarOverlay(false);
        this.adView_.getSettings().setSupportZoom(false);
        if (!WebViewFactory.setJavaScriptEnabledForWebView(true, this.adView_, LOG_TAG)) {
        }
        for (; ; ) {
            this.shouldForceRenderFailure = bool;
            this.adView_.setBackgroundColor(0);
            AdWebViewClient localAdWebViewClient = new AdWebViewClient(this, this.context);
            localAdWebViewClient.putUrlExecutor("amazonmobile", this.controller.getSpecialUrlExecutor());
            this.adView_.setWebViewClient(localAdWebViewClient);
            return;
            bool = false;
        }
    }

    protected boolean shouldReuse() {
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/HtmlRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */