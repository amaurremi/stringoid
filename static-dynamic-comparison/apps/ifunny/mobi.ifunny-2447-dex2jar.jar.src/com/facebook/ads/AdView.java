package com.facebook.ads;

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.internal.AdRequest.Callback;
import com.facebook.ads.internal.AdRequestController;
import com.facebook.ads.internal.AdType;
import com.facebook.ads.internal.AdWebViewInterface;
import com.facebook.ads.internal.AdWebViewUtils;
import com.facebook.ads.internal.HtmlAdDataModel;
import com.facebook.ads.internal.HtmlAdHandler;

public class AdView
        extends RelativeLayout
        implements Ad {
    private static final int DEFAULT_ALPHA = 255;
    private static final String DEFAULT_ENCODING = "utf-8";
    private static final String DEFAULT_MIME_TYPE = "text/html";
    private static final int MIN_ALPHA = 229;
    private static final String TAG = AdView.class.getSimpleName();
    private HtmlAdHandler adHandler;
    private AdListener adListener = null;
    private AdRequestController adRequestController;
    private final AdSize adSize;
    private WebView adWebView;
    private int currentAlpha = 255;
    private final DisplayMetrics metrics;
    private final String placementId;
    private final AdView.ScreenStateReceiver screenStateReceiver;

    public AdView(Context paramContext, String paramString, AdSize paramAdSize) {
        super(paramContext);
        if ((paramAdSize == null) || (paramAdSize == AdSize.INTERSTITIAL)) {
            throw new IllegalArgumentException("adSize");
        }
        this.placementId = paramString;
        this.adSize = paramAdSize;
        this.metrics = paramContext.getResources().getDisplayMetrics();
        this.screenStateReceiver = new AdView.ScreenStateReceiver(this, null);
        initializeView(paramContext);
        this.adHandler = new HtmlAdHandler(this.adWebView, new AdView .1 (this), 1000L);
        registerScreenStateReceiver();
    }

    private AdRequest.Callback createAdRequestCallback() {
        return new AdView .2 (this);
    }

    private void ensureAdRequestController() {
        if (this.adRequestController == null) {
            throw new RuntimeException("No request controller available, has the AdView been destroyed?");
        }
    }

    private void initializeView(Context paramContext) {
        if ((int) (this.metrics.widthPixels / this.metrics.density) >= this.adSize.getWidth()) {
        }
        for (int i = this.metrics.widthPixels; ; i = (int) Math.ceil(this.adSize.getWidth() * this.metrics.density)) {
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, (int) Math.ceil(this.adSize.getHeight() * this.metrics.density));
            localLayoutParams.addRule(14);
            setLayoutParams(localLayoutParams);
            this.adWebView = new WebView(paramContext);
            this.adWebView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.adWebView.setVisibility(8);
            AdWebViewUtils.config(this.adWebView, new AdView.AdWebViewClient(this, null), new AdWebViewInterface());
            addView(this.adWebView);
            this.adRequestController = new AdRequestController(getContext(), this.placementId, this.adSize, true, AdType.HTML, createAdRequestCallback());
            return;
        }
    }

    private boolean isAdViewVisible() {
        if (getVisibility() != 0) {
        }
        int[] arrayOfInt;
        int i;
        do {
            do {
                do {
                    return false;
                } while ((getParent() == null) || (this.currentAlpha < 229));
                arrayOfInt = new int[2];
                getLocationOnScreen(arrayOfInt);
            }
            while ((arrayOfInt[0] < 0) || (this.metrics.widthPixels - arrayOfInt[0] < (int) Math.ceil(this.adSize.getWidth() * this.metrics.density)));
            i = (int) Math.ceil(this.adSize.getHeight() * this.metrics.density);
        }
        while (((arrayOfInt[1] < 0) && (Math.abs(arrayOfInt[1]) > i / 2)) || (arrayOfInt[1] + i - this.metrics.heightPixels > i / 2));
        return true;
    }

    private void registerScreenStateReceiver() {
        IntentFilter localIntentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
        localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
        getContext().registerReceiver(this.screenStateReceiver, localIntentFilter);
    }

    private void unregisterScreenStateReceiver() {
        getContext().unregisterReceiver(this.screenStateReceiver);
    }

    private void updateView(HtmlAdDataModel paramHtmlAdDataModel) {
        this.adWebView.loadUrl("about:blank");
        this.adWebView.clearCache(true);
        this.adWebView.setVisibility(8);
        this.adWebView.loadDataWithBaseURL("https://www.facebook.com/", paramHtmlAdDataModel.getMarkup(), "text/html", "utf-8", null);
        this.adWebView.setVisibility(0);
    }

    public void destroy() {
        if (this.adRequestController != null) {
            this.adRequestController.destroy();
            this.adRequestController = null;
        }
        this.adHandler.cancelImpressionRetry();
        unregisterScreenStateReceiver();
    }

    public void loadAd() {
        ensureAdRequestController();
        this.adRequestController.loadAd();
    }

    protected boolean onSetAlpha(int paramInt) {
        this.currentAlpha = paramInt;
        return super.onSetAlpha(paramInt);
    }

    protected void onWindowVisibilityChanged(int paramInt) {
        super.onWindowVisibilityChanged(paramInt);
        if (this.adRequestController != null) {
            this.adRequestController.onWindowVisibilityChanged(paramInt);
        }
        if (paramInt == 0) {
            this.adHandler.scheduleImpressionRetry();
            return;
        }
        this.adHandler.cancelImpressionRetry();
    }

    public void setAdListener(AdListener paramAdListener) {
        this.adListener = paramAdListener;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/AdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */