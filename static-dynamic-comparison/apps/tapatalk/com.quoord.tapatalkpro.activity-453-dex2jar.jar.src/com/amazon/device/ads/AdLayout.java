package com.amazon.device.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebViewDatabase;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

import java.util.Locale;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class AdLayout
        extends FrameLayout
        implements Ad {
    public static final int DEFAULT_TIMEOUT = 20000;
    private static final String LOG_TAG = "AdLayout";
    private static ScheduledThreadPoolExecutor threadPool = new ScheduledThreadPoolExecutor(1);
    private View activityRootView = null;
    private AdSize adSize;
    private boolean attached = false;
    private Context context;
    private IAdController controller;
    private boolean hasPassedActivityValidationCheck = false;
    private boolean hasRegisterBroadcastReciever = false;
    private boolean isInForeground;
    private boolean isParentViewMissingAtLoadTime = false;
    private int lastVisibility = 8;
    private AdLoader.AdReadyToLoadListener listenerOnLayout = null;
    private long loadAdStartTime = 0L;
    private AtomicBoolean needsToLoadAdOnLayout = new AtomicBoolean(false);
    private BroadcastReceiver screenStateReceiver;
    private boolean shouldDisableWebViewHardwareAcceleration;

    static {
        threadPool.setKeepAliveTime(60L, TimeUnit.SECONDS);
    }

    public AdLayout(Activity paramActivity) {
        this(paramActivity, AdSize.SIZE_AUTO);
    }

    public AdLayout(Activity paramActivity, AdSize paramAdSize) {
        super(paramActivity);
        initialize(paramActivity, paramAdSize);
    }

    public AdLayout(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        initialize(paramContext, paramAttributeSet);
    }

    public AdLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        initialize(paramContext, paramAttributeSet);
    }

    AdLayout(IAdController paramIAdController) {
        super(null);
        this.controller = paramIAdController;
        initialize(null, null);
    }

    private static String getAttributeValue(AttributeSet paramAttributeSet, String paramString1, String paramString2) {
        return paramAttributeSet.getAttributeValue(paramString1, paramString2);
    }

    private void initialize(Context paramContext, AttributeSet paramAttributeSet) {
        String str = getAttributeValue(paramAttributeSet, "http://schemas.android.com/apk/lib/com.amazon.device.ads", "adSize");
        Object localObject = str;
        if (str == null) {
            paramAttributeSet = getAttributeValue(paramAttributeSet, "http://schemas.android.com/apk/res/" + paramContext.getPackageName(), "adSize");
            localObject = paramAttributeSet;
            if (paramAttributeSet != null) {
                Log.w(true, "AdLayout", "DEPRECATED - Please use the XML namespace \"http://schemas.android.com/apk/lib/com.amazon.device.ads\" for specifying AdLayout properties.");
                localObject = paramAttributeSet;
                if (paramAttributeSet.toLowerCase(Locale.US).equals("custom")) {
                    Log.e(true, "AdLayout", "Using \"custom\" or \"CUSTOM\" for the \"adSize\" property is no longer supported. Please specifiy a size or remove the property to use Auto Ad Size.");
                    throw new IllegalArgumentException("Using \"custom\" or \"CUSTOM\" for the \"adSize\" property is no longer supported. Please specifiy a size or remove the property to use Auto Ad Size.");
                }
            }
        }
        initialize(paramContext, parseAdSize((String) localObject));
    }

    private void initialize(Context paramContext, AdSize paramAdSize) {
        InternalAdRegistration.getInstance().contextReceived(paramContext);
        AdSize localAdSize = paramAdSize;
        if (paramAdSize == null) {
            localAdSize = AdSize.SIZE_AUTO;
        }
        this.adSize = localAdSize;
        this.context = paramContext;
        if (isInEditMode()) {
            paramContext = new TextView(this.context);
            paramContext.setText("AdLayout");
            paramContext.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            paramContext.setGravity(17);
            addView(paramContext);
            return;
        }
        if (getVisibility() == 0) {
        }
        for (boolean bool = true; ; bool = false) {
            this.isInForeground = bool;
            setHorizontalScrollBarEnabled(false);
            setVerticalScrollBarEnabled(false);
            if (!isWebViewDatabaseNull(this.context)) {
                break;
            }
            Log.e(true, "AdLayout", "Disabling ads. Local cache file is inaccessible so ads will fail if we try to create a WebView. Details of this Android bug found at: http://code.google.com/p/android/issues/detail?id=10789");
            return;
        }
        if (this.controller == null) {
            this.controller = createAdController(this.adSize, this.context);
        }
        this.hasPassedActivityValidationCheck = AdUtils.checkDefinedActivities(this.context);
    }

    private void loadAdWhenParentViewMissing(AdLoader.AdReadyToLoadListener paramAdReadyToLoadListener) {
        if (getLayoutParams() == null) {
            Metrics.getInstance().getMetricsCollector().incrementMetric(Metrics.MetricType.AD_FAILED_NULL_LAYOUT_PARAMS);
            onRequestError("Can't load an ad because layout parameters are blank. Use setLayoutParams() to specify dimensions for this AdLayout.");
            return;
        }
        if (Utils.isAtLeastAndroidAPI(11)) {
            setActivityRootView();
            if (isActivityRootViewNull()) {
                onRequestError("Ad load failed because root view could not be obtained from the activity.");
                return;
            }
            if (isActivityRootViewLayoutRequested()) {
                deferAdLoadToLayoutEvent(paramAdReadyToLoadListener);
                setOnLayoutChangeListenerForRoot(paramAdReadyToLoadListener);
                return;
            }
            setFloatingWindowDimensions();
            loadAdFromAdController(paramAdReadyToLoadListener);
            return;
        }
        setFloatingWindowDimensions();
        loadAdFromAdController(paramAdReadyToLoadListener);
    }

    private static AdSize parseAdSize(String paramString) {
        AdSize localAdSize2 = AdSize.SIZE_AUTO;
        AdSize localAdSize1 = localAdSize2;
        if (paramString != null) {
            paramString = paramString.toLowerCase(Locale.US);
            localAdSize1 = localAdSize2;
            if (!paramString.equals("auto")) {
                paramString = paramString.split("x");
                int j = 0;
                int i = 0;
                if (paramString.length == 2) {
                    j = Utils.parseInt(paramString[0], 0);
                    i = Utils.parseInt(paramString[1], 0);
                }
                localAdSize1 = new AdSize(j, i);
            }
        }
        return localAdSize1;
    }

    private void registerScreenStateBroadcastReceiver() {
        if (this.hasRegisterBroadcastReciever == true) {
            return;
        }
        this.hasRegisterBroadcastReciever = true;
        this.screenStateReceiver = new BroadcastReceiver() {
            public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent) {
                if ((paramAnonymousIntent.getAction().equals("android.intent.action.SCREEN_OFF")) && (AdLayout.this.isInForeground)) {
                    AdLayout.this.controller.sendCommand("close", null);
                }
            }
        };
        IntentFilter localIntentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        localIntentFilter.addAction("android.intent.action.USER_PRESENT");
        this.context.getApplicationContext().registerReceiver(this.screenStateReceiver, localIntentFilter);
    }

    private void unregisterScreenStateBroadcastReceiver() {
        if (this.hasRegisterBroadcastReciever) {
            this.hasRegisterBroadcastReciever = false;
            this.context.getApplicationContext().unregisterReceiver(this.screenStateReceiver);
        }
    }

    public boolean collapseAd() {
        return this.controller.sendCommand("close", null);
    }

    IAdController createAdController(AdSize paramAdSize, Context paramContext) {
        return new AdController(this, paramAdSize, paramContext);
    }

    void deferAdLoadToLayoutEvent(AdLoader.AdReadyToLoadListener paramAdReadyToLoadListener) {
        this.needsToLoadAdOnLayout.set(true);
        this.listenerOnLayout = paramAdReadyToLoadListener;
        scheduleTaskForCheckingIfLayoutHasRun();
    }

    public void destroy() {
        Log.d("AdLayout", "Destroying the AdLayout");
        unregisterScreenStateBroadcastReceiver();
        this.controller.destroy();
    }

    void failLoadIfLayoutHasNotRun() {
        if (this.needsToLoadAdOnLayout.getAndSet(false)) {
            Metrics.getInstance().getMetricsCollector().incrementMetric(Metrics.MetricType.AD_FAILED_LAYOUT_NOT_RUN);
            onRequestError("Can't load an ad because the view size cannot be determined.");
        }
    }

    View getActivityRootView() {
        return this.activityRootView;
    }

    int getActivityRootViewDimension(boolean paramBoolean) {
        if (paramBoolean) {
            return this.activityRootView.getWidth();
        }
        return this.activityRootView.getHeight();
    }

    AdController getAdController() {
        return (AdController) this.controller;
    }

    public AdSize getAdSize() {
        return this.adSize;
    }

    boolean getNeedsToLoadAdOnLayout() {
        return this.needsToLoadAdOnLayout.get();
    }

    int getRawScreenDimension(boolean paramBoolean) {
        WindowManager localWindowManager = (WindowManager) this.context.getSystemService("window");
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
        if (paramBoolean) {
            return localDisplayMetrics.widthPixels;
        }
        return localDisplayMetrics.heightPixels;
    }

    public int getTimeout() {
        return this.controller.getTimeout();
    }

    boolean isActivityRootViewLayoutRequested() {
        return this.activityRootView.isLayoutRequested();
    }

    boolean isActivityRootViewNull() {
        return this.activityRootView == null;
    }

    public boolean isAdLoading() {
        return isLoading();
    }

    public boolean isLoading() {
        return this.controller.isAdLoading();
    }

    boolean isParentViewMissingAtLoadTime() {
        return this.isParentViewMissingAtLoadTime;
    }

    boolean isWebViewDatabaseNull(Context paramContext) {
        return WebViewDatabase.getInstance(paramContext) == null;
    }

    boolean isWebViewOk(Context paramContext) {
        return WebViewFactory.isWebViewOk(paramContext);
    }

    public boolean loadAd() {
        return loadAd(new AdTargetingOptions());
    }

    public boolean loadAd(AdTargetingOptions paramAdTargetingOptions) {
        AdTargetingOptions localAdTargetingOptions = paramAdTargetingOptions;
        if (paramAdTargetingOptions == null) {
            localAdTargetingOptions = new AdTargetingOptions();
        }
        return AdLoader.loadAds(this.controller.getTimeout(), localAdTargetingOptions, new AdSlot[]{new AdSlot(this, localAdTargetingOptions)})[0];
    }

    void loadAdFromAdController(AdLoader.AdReadyToLoadListener paramAdReadyToLoadListener) {
        this.controller.prepareAd(this.loadAdStartTime);
        paramAdReadyToLoadListener.onAdReady(this);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode()) {
            return;
        }
        this.attached = true;
        registerScreenStateBroadcastReceiver();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.attached = false;
        unregisterScreenStateBroadcastReceiver();
        this.controller.prepareToGoAway();
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        if (isInEditMode()) {
        }
        do {
            return;
            this.controller.setWindowDimensions(paramInt3 - paramInt1, paramInt4 - paramInt2);
        } while (!this.needsToLoadAdOnLayout.getAndSet(false));
        loadAdFromAdController(this.listenerOnLayout);
        this.listenerOnLayout = null;
    }

    void onRequestError(String paramString) {
        Log.e("AdLayout", paramString);
        ((IAdLoaderCallback) this.controller).adFailed(new AdError(AdError.ErrorCode.REQUEST_ERROR, paramString));
    }

    protected void onWindowVisibilityChanged(int paramInt) {
        if ((this.attached) && (this.lastVisibility != paramInt)) {
            if (paramInt == 0) {
                break label29;
            }
            this.isInForeground = false;
            unregisterScreenStateBroadcastReceiver();
        }
        label29:
        while (paramInt != 0) {
            return;
        }
        this.isInForeground = true;
    }

    protected boolean passesInternetPermissionCheck(Context paramContext) {
        return PermissionChecker.getInstance().passesInternetPermissionCheck(paramContext);
    }

    int prepareAd(AdLoader.AdReadyToLoadListener paramAdReadyToLoadListener) {
        this.loadAdStartTime = System.nanoTime();
        if ((this.controller.isAdLoading()) || (this.needsToLoadAdOnLayout.get())) {
            Log.e("AdLayout", "Can't load an ad because ad loading is already in progress");
            return -1;
        }
        if (this.controller.isAdExpanded()) {
            Log.e("AdLayout", "Can't load an ad because another ad is currently expanded");
            return -1;
        }
        if (!this.hasPassedActivityValidationCheck) {
            onRequestError("Ads cannot load unless \"com.amazon.device.ads.AdActivity\" is correctly declared as an activity in AndroidManifest.xml. Consult the online documentation for more info.");
            return 1;
        }
        if (!passesInternetPermissionCheck(this.context)) {
            onRequestError("Ads cannot load because the INTERNET permission is missing from the app's manifest.");
            return 1;
        }
        if (InternalAdRegistration.getInstance().getRegistrationInfo().getAppKey() == null) {
            onRequestError("Can't load an ad because Application Key has not been set. Did you forget to call AdRegistration.setAppKey( ... )?");
            return 1;
        }
        if (!isWebViewOk(this.context)) {
            Metrics.getInstance().getMetricsCollector().incrementMetric(Metrics.MetricType.AD_FAILED_UNKNOWN_WEBVIEW_ISSUE);
            onRequestError("We will be unable to create a WebView for rendering an ad due to an unknown issue with the WebView.");
            return 1;
        }
        if (this.adSize.isAuto()) {
            Log.d("AdLayout", "Ad size to be determined automatically.");
        }
        setIsParentViewMissingAtLoadTime();
        if ((isLayoutRequested()) && (this.adSize.isAuto()) && (!isParentViewMissingAtLoadTime())) {
            deferAdLoadToLayoutEvent(paramAdReadyToLoadListener);
        }
        for (; ; ) {
            return 0;
            if (isParentViewMissingAtLoadTime()) {
                loadAdWhenParentViewMissing(paramAdReadyToLoadListener);
            } else {
                loadAdFromAdController(paramAdReadyToLoadListener);
            }
        }
    }

    int resolveLayoutParamForFloatingAd(boolean paramBoolean) {
        int i;
        int j;
        if (paramBoolean) {
            i = getLayoutParams().width;
            if (i != -1) {
                break label49;
            }
            if (!isActivityRootViewNull()) {
                break label43;
            }
            j = getRawScreenDimension(paramBoolean);
        }
        label43:
        label49:
        do {
            return j;
            i = getLayoutParams().height;
            break;
            return getActivityRootViewDimension(paramBoolean);
            j = i;
        } while (i != -2);
        return 0;
    }

    void scheduleTaskForCheckingIfLayoutHasRun() {
        Runnable local2 = new Runnable() {
            public void run() {
                AdLayout.this.failLoadIfLayoutHasNotRun();
            }
        };
        threadPool.schedule(local2, getTimeout(), TimeUnit.MILLISECONDS);
    }

    void setActivityRootView() {
        this.activityRootView = ((Activity) this.context).getWindow().getDecorView().findViewById(16908290).getRootView();
    }

    void setFloatingWindowDimensions() {
        int i = resolveLayoutParamForFloatingAd(true);
        int j = resolveLayoutParamForFloatingAd(false);
        this.controller.setWindowDimensions(i, j);
    }

    void setIsParentViewMissingAtLoadTime() {
        if (getParent() == null) {
        }
        for (boolean bool = true; ; bool = false) {
            this.isParentViewMissingAtLoadTime = bool;
            return;
        }
    }

    void setIsParentViewMissingAtLoadTime(boolean paramBoolean) {
        this.isParentViewMissingAtLoadTime = paramBoolean;
    }

    public void setListener(AdListener paramAdListener) {
        this.controller.setListener(paramAdListener);
    }

    void setNeedsToLoadAdOnLayout(boolean paramBoolean) {
        this.needsToLoadAdOnLayout.set(paramBoolean);
    }

    void setOnLayoutChangeListenerForRoot(AdLoader.AdReadyToLoadListener paramAdReadyToLoadListener) {
        OnLayoutChangeListenerUtil.setOnLayoutChangeListenerForRoot(this, paramAdReadyToLoadListener);
    }

    void setShouldDisableWebViewHardwareAcceleration(boolean paramBoolean) {
        this.shouldDisableWebViewHardwareAcceleration = paramBoolean;
    }

    public void setTimeout(int paramInt) {
        this.controller.setTimeout(paramInt);
    }

    boolean shouldDisableWebViewHardwareAcceleration() {
        return this.shouldDisableWebViewHardwareAcceleration;
    }

    private static class OnLayoutChangeListenerUtil {
        @TargetApi(11)
        protected static void setOnLayoutChangeListenerForRoot(AdLayout paramAdLayout, final AdLoader.AdReadyToLoadListener paramAdReadyToLoadListener) {
            paramAdReadyToLoadListener = new View.OnLayoutChangeListener() {
                public void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8) {
                    if (this.val$adLayout.needsToLoadAdOnLayout.getAndSet(false)) {
                        this.val$adLayout.setFloatingWindowDimensions();
                        this.val$adLayout.loadAdFromAdController(paramAdReadyToLoadListener);
                        this.val$adLayout.activityRootView.removeOnLayoutChangeListener(this);
                    }
                }
            };
            paramAdLayout.activityRootView.addOnLayoutChangeListener(paramAdReadyToLoadListener);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/AdLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */