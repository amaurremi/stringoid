package com.amazon.device.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.WebView;
import android.widget.FrameLayout.LayoutParams;

import java.util.Map;

class MraidRenderer
        extends AdRenderer
        implements MraidView.OnCloseListener, MraidView.OnExpandListener, MraidView.OnReadyListener, MraidView.OnSpecialUrlClickListener {
    private static final String LOG_TAG = "MraidRenderer";
    protected MraidView mraidView_;
    private WebView webView_;

    protected MraidRenderer(AdData paramAdData, IAdController paramIAdController, WebView paramWebView, Context paramContext) {
        super(paramAdData, paramIAdController, paramContext);
        this.webView_ = paramWebView;
    }

    protected void adLoaded(AdProperties paramAdProperties) {
        super.adLoaded(paramAdProperties);
    }

    protected MraidView createNewMraidView() {
        return new MraidView(this, this.controller.getWindowWidth(), this.controller.getWindowHeight(), getScalingMultiplier(), this.context, this.webView_);
    }

    protected void destroy() {
        if (this.mraidView_ != null) {
            this.mraidView_.destroy();
            this.mraidView_ = null;
            this.isDestroyed = true;
        }
        this.webView_ = null;
    }

    protected boolean getAdState(AdRenderer.AdState paramAdState) {
        if (this.mraidView_ == null) {
            Log.w("MraidRenderer", "Unable to retrieve ad state.");
            return false;
        }
        switch (paramAdState) {
            default:
                return false;
        }
        return this.mraidView_.getDisplayController().isExpanded();
    }

    public boolean launchExternalBrowserForLink(String paramString) {
        if (isAdViewRenderable()) {
            return AdUtils.launchActivityForIntentLink(paramString, this.context);
        }
        return false;
    }

    public void onClose(MraidView paramMraidView, MraidView.ViewState paramViewState) {
        if (!isAdViewRemoved()) {
            this.controller.adClosedExpansion();
        }
    }

    public void onExpand(MraidView paramMraidView) {
        if (!isAdViewRemoved()) {
            this.controller.adExpanded();
        }
    }

    public void onPageFinished() {
        if (this.mraidView_ == null) {
            Log.w("MraidRenderer", "Call to onPageFinished() ignored because view is null.");
            return;
        }
        this.mraidView_.onPageFinished();
    }

    public void onReady(MraidView paramMraidView) {
        adLoaded(this.adData.getProperties());
    }

    public void onSpecialUrlClick(MraidView paramMraidView, String paramString) {
        if (isAdViewRenderable()) {
            getSpecialUrlExecutor().execute(paramString);
        }
    }

    protected void prepareToGoAway() {
        if (this.mraidView_ != null) {
            this.mraidView_.prepareToGoAway();
        }
    }

    protected void removeView() {
        if ((!this.viewRemoved) && (!this.isDestroyed)) {
        }
        try {
            this.controller.getAdLayout().removeAllViews();
            this.viewRemoved = true;
            return;
        } catch (NullPointerException localNullPointerException) {
            for (; ; ) {
            }
        }
    }

    protected boolean render() {
        if (isAdViewDestroyed()) {
        }
        do {
            return false;
            this.mraidView_ = createNewMraidView();
        }
        while ((this.mraidView_.getShouldForceRenderFailure()) || (!this.mraidView_.loadHtmlData(this.adData.getCreative())));
        renderMraidView();
        return true;
    }

    @SuppressLint({"InlinedApi"})
    protected void renderMraidView() {
        this.mraidView_.setOnReadyListener(this);
        this.mraidView_.setOnSpecialUrlClickListener(this);
        this.mraidView_.setOnExpandListener(this);
        this.mraidView_.setOnCloseListener(this);
        this.controller.getAdLayout().removeAllViews();
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        this.controller.getAdLayout().addView(this.mraidView_, localLayoutParams);
    }

    protected boolean sendCommand(String paramString, Map<String, String> paramMap) {
        Log.d("MraidRenderer", "sendCommand: %s", new Object[]{paramString});
        if ((paramString.equals("close")) && (this.mraidView_ != null) && (this.mraidView_.getDisplayController().isExpanded())) {
            this.mraidView_.getDisplayController().close();
            return true;
        }
        return false;
    }

    protected boolean shouldReuse() {
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/MraidRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */