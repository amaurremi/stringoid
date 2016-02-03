package com.amazon.device.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.util.HashMap;
import java.util.Set;

class AdController
        implements IAdController, IAdLoaderCallback {
    private static final String LOG_TAG = "AdController";
    private AdData adData;
    private final AdLayout adLayout;
    private AdListener adListener;
    private final AdSize adSize;
    private int adWindowHeight;
    private int adWindowWidth;
    private final Context context;
    private AdRenderer currentAdRenderer;
    private boolean isLoading;
    private int timeout = 20000;
    private WebView webView;

    protected AdController() {
        this.adLayout = null;
        this.context = null;
        this.adSize = null;
    }

    AdController(AdLayout paramAdLayout, AdSize paramAdSize, Context paramContext) {
        this.adLayout = paramAdLayout;
        this.context = paramContext;
        this.adSize = paramAdSize;
        this.adListener = createAdListener();
    }

    private void createAndCacheWebView() {
        this.webView = WebViewFactory.getInstance().createWebView(this.context);
    }

    private void destroyCurrentAdRenderer() {
        if (this.currentAdRenderer != null) {
            this.currentAdRenderer.removeView();
            this.currentAdRenderer.destroy();
            this.currentAdRenderer = null;
        }
    }

    protected static String getAsSizeString(int paramInt1, int paramInt2) {
        return Integer.toString(paramInt1) + "x" + Integer.toString(paramInt2);
    }

    private void prepareRenderer(AdData.AAXCreative paramAAXCreative) {
        this.currentAdRenderer = createAdRendererFromFactory(paramAAXCreative, this.currentAdRenderer);
        if (this.currentAdRenderer == null) {
            Log.d("AdController", "No renderer returned, not loading an ad");
            adFailed(new AdError(AdError.ErrorCode.INTERNAL_ERROR, "No renderer returned, not loading an ad"));
        }
        do {
            return;
            this.currentAdRenderer.initialize();
            getAdData().setIsRendering(true);
            long l = System.nanoTime();
            getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START, l);
            getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_RENDER, l);
            getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_RENDER_FAILED, l);
        } while (this.currentAdRenderer.render());
        destroyCurrentAdRenderer();
        Log.d("AdController", "Ad could not render");
        adFailed(new AdError(AdError.ErrorCode.INTERNAL_ERROR, "Ad could not render"));
    }

    private void processAdFailure() {
        if (this.webView != null) {
            this.webView.destroy();
            this.webView = null;
        }
        this.isLoading = false;
    }

    private void retrieveAndSetUserAgentString() {
        createAndCacheWebView();
        DeviceInfo.setUserAgentString(this.webView.getSettings().getUserAgentString());
    }

    private void submitAndResetMetricsIfNecessary(boolean paramBoolean) {
        if (paramBoolean) {
            Metrics.getInstance().submitAndResetMetrics(getAdData());
        }
    }

    protected void accumulateAdFailureMetrics(AdError paramAdError) {
        long l = System.nanoTime();
        getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_RENDER_FAILED, l);
        if (paramAdError.getCode() != AdError.ErrorCode.NO_FILL) {
            getAdData().getMetricsCollector().incrementMetric(Metrics.MetricType.AD_LOAD_FAILED);
        }
        if (getAdData().getIsRendering()) {
            getAdData().getMetricsCollector().incrementMetric(Metrics.MetricType.AD_COUNTER_RENDERING_FATAL);
            getAdData().setIsRendering(false);
        }
        getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE, l);
        getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_TOTAL, l);
        getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_TOTAL_FAILURE, l);
        setAdditionalMetrics();
    }

    public void adClosedExpansion() {
        new Handler(this.context.getMainLooper()).post(new Runnable() {
            public void run() {
                AdController.this.adListener.onAdCollapsed(AdController.this.adLayout);
            }
        });
    }

    public void adExpanded() {
        new Handler(this.context.getMainLooper()).post(new Runnable() {
            public void run() {
                AdController.this.adListener.onAdExpanded(AdController.this.adLayout);
            }
        });
    }

    public void adFailed(AdError paramAdError) {
        if ((getAdData() == null) || (getAdData().getMetricsCollector().isMetricsCollectorEmpty())) {
            adFailedBeforeAdMetricsStart(paramAdError);
            return;
        }
        adFailedAfterAdMetricsStart(paramAdError);
    }

    protected void adFailedAfterAdMetricsStart(AdError paramAdError) {
        processAdFailure();
        accumulateAdFailureMetrics(paramAdError);
        callListenerOnAdFailedToLoad(paramAdError, true);
    }

    protected void adFailedBeforeAdMetricsStart(AdError paramAdError) {
        processAdFailure();
        callListenerOnAdFailedToLoad(paramAdError, false);
    }

    public void adLoaded(final AdProperties paramAdProperties) {
        long l = System.nanoTime();
        adShown();
        getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_TOTAL, l);
        getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_TOTAL_SUCCESS, l);
        getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_RENDER, l);
        setAdditionalMetrics();
        getAdData().setIsRendering(false);
        this.isLoading = false;
        new Handler(this.context.getMainLooper()).post(new Runnable() {
            public void run() {
                AdController.this.adListener.onAdLoaded(AdController.this.adLayout, paramAdProperties);
                AdController.this.submitAndResetMetricsIfNecessary(true);
            }
        });
    }

    public void adShown() {
        WebRequest.executeWebRequestInThread(getAdData().getImpressionPixelUrl());
    }

    protected void callListenerOnAdFailedToLoad(final AdError paramAdError, final boolean paramBoolean) {
        new Handler(this.context.getMainLooper()).post(new Runnable() {
            public void run() {
                AdController.this.adListener.onAdFailedToLoad(AdController.this.adLayout, paramAdError);
                AdController.this.submitAndResetMetricsIfNecessary(paramBoolean);
            }
        });
    }

    protected AdListener createAdListener() {
        return new DefaultAdListener("AdController");
    }

    protected AdRenderer createAdRendererFromFactory(AdData.AAXCreative paramAAXCreative, AdRenderer paramAdRenderer) {
        AdRendererFactory localAdRendererFactory = new AdRendererFactory();
        if (localAdRendererFactory.shouldCreateNewRenderer(paramAAXCreative, paramAdRenderer)) {
            Log.d("AdController", "Creating new renderer");
            if (paramAdRenderer != null) {
                paramAdRenderer.destroy();
            }
            if (this.webView == null) {
                createAndCacheWebView();
            }
            paramAAXCreative = localAdRendererFactory.getAdRenderer(paramAAXCreative, this.adData, this, this.webView, this.context);
            this.webView = null;
            return paramAAXCreative;
        }
        Log.d("AdController", "Re-using renderer");
        paramAdRenderer.setAd(this.adData);
        return paramAdRenderer;
    }

    public void destroy() {
        destroyCurrentAdRenderer();
    }

    protected AdData getAdData() {
        return this.adData;
    }

    public AdLayout getAdLayout() {
        return this.adLayout;
    }

    protected AdListener getAdListener() {
        return this.adListener;
    }

    public AdSize getAdSize() {
        return this.adSize;
    }

    protected Context getContext() {
        return this.context;
    }

    protected AdRenderer getCurrentAdRenderer() {
        return this.currentAdRenderer;
    }

    public String getMaxSize() {
        if (!this.adSize.isAuto()) {
            return null;
        }
        return getAsSizeString(getWindowWidth(), getWindowHeight());
    }

    public AdWebViewClient.UrlExecutor getSpecialUrlExecutor() {
        return new AdWebViewClient.AmazonMobileExecutor(this.currentAdRenderer, this.context);
    }

    public int getTimeout() {
        return this.timeout;
    }

    public int getWindowHeight() {
        return this.adWindowHeight;
    }

    public int getWindowWidth() {
        return this.adWindowWidth;
    }

    public void handleResponse() {
        if (this.currentAdRenderer != null) {
            this.currentAdRenderer.removeView();
        }
        if (this.adData == null) {
            Log.d("AdController", "We are unable to load the ad due to an internal error.");
            adFailed(new AdError(AdError.ErrorCode.INTERNAL_ERROR, "We are unable to load the ad due to an internal error."));
            return;
        }
        AdData.AAXCreative localAAXCreative;
        if ((this.adData.getCreativeTypes() != null) && (!this.adData.getCreativeTypes().isEmpty())) {
            localAAXCreative = AdData.AAXCreative.getTopCreative(this.adData.getCreativeTypes());
            if (localAAXCreative != null) {
            }
        } else {
            Log.d("AdController", "There were no valid creative types returned, and we are unable to load the ad.");
            adFailed(new AdError(AdError.ErrorCode.INTERNAL_ERROR, "There were no valid creative types returned, and we are unable to load the ad."));
            return;
        }
        prepareRenderer(localAAXCreative);
    }

    public boolean isAdExpanded() {
        if (this.currentAdRenderer == null) {
            return false;
        }
        return this.currentAdRenderer.getAdState(AdRenderer.AdState.valueOf("EXPANDED"));
    }

    public boolean isAdLoading() {
        return this.isLoading;
    }

    public void prepareAd(long paramLong) {
        setNewAdData();
        getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_TOTAL, paramLong);
        getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_TOTAL_FAILURE, paramLong);
        getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_TOTAL_SUCCESS, paramLong);
        getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START, paramLong);
        if (this.adSize.isAuto()) {
            getAdData().setMaxSize(getMaxSize());
        }
        this.isLoading = true;
        Looper localLooper;
        if (DeviceInfo.getUserAgentString() == null) {
            localLooper = Looper.getMainLooper();
            if (Thread.currentThread() == localLooper.getThread()) {
                retrieveAndSetUserAgentString();
            }
        } else {
            return;
        }
        new Handler(localLooper).post(new Runnable() {
            public void run() {
                if (DeviceInfo.getUserAgentString() == null) {
                    AdController.this.retrieveAndSetUserAgentString();
                }
            }
        });
    }

    public void prepareToGoAway() {
        if (this.currentAdRenderer != null) {
            this.currentAdRenderer.prepareToGoAway();
        }
    }

    public boolean sendCommand(String paramString, HashMap<String, String> paramHashMap) {
        if (this.currentAdRenderer != null) {
            return this.currentAdRenderer.sendCommand(paramString, paramHashMap);
        }
        return false;
    }

    protected void setAdData(AdData paramAdData) {
        this.adData = paramAdData;
    }

    protected void setAdditionalMetrics() {
        AdUtils.setConnectionMetrics(getAdData());
        if (getAdLayout().isParentViewMissingAtLoadTime()) {
            getAdData().getMetricsCollector().incrementMetric(Metrics.MetricType.AD_COUNTER_PARENT_VIEW_MISSING);
        }
        if (getWindowHeight() == 0) {
            getAdData().getMetricsCollector().incrementMetric(Metrics.MetricType.ADLAYOUT_HEIGHT_ZERO);
        }
        if (this.currentAdRenderer != null) {
            getAdData().getMetricsCollector().setMetricString(Metrics.MetricType.VIEWPORT_SCALE, this.currentAdRenderer.getScalingMultiplierDescription());
        }
    }

    public void setListener(AdListener paramAdListener) {
        if (paramAdListener == null) {
            this.adListener = createAdListener();
            return;
        }
        this.adListener = paramAdListener;
    }

    protected void setNewAdData() {
        setAdData(new AdData(this.adSize));
    }

    public void setTimeout(int paramInt) {
        this.timeout = paramInt;
    }

    public void setWindowDimensions(int paramInt1, int paramInt2) {
        this.adWindowWidth = paramInt1;
        this.adWindowHeight = paramInt2;
    }

    public boolean shouldDisableWebViewHardwareAcceleration() {
        return getAdLayout().shouldDisableWebViewHardwareAcceleration();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/AdController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */