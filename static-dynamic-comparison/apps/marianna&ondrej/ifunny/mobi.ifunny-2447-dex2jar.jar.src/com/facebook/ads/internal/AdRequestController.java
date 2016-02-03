package com.facebook.ads.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Handler;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;

public class AdRequestController {
    private static final String ANDROID_PERMISSION_ACCESS_NETWORK_STATE = "android.permission.ACCESS_NETWORK_STATE";
    private static final int DEFAULT_REFRESH_THRESHOLD_MILLIS = 20000;
    private static final int MIN_REFRESH_INTERVAL_MILLIS = 30000;
    private final AdSize adSize;
    private final AdType adType;
    private final AdRequest.Callback adViewRequestCallback;
    private final Context context;
    private int currentVisibility = 8;
    private final Handler handler;
    private boolean initialLoadFinished = false;
    private volatile long lastLoadTimeMillis;
    private AsyncTask lastRequest;
    private final String placementId;
    private int refreshInterval = 30000;
    private final Runnable refreshRunnable;
    private volatile boolean refreshScheduled = false;
    private int refreshThreshold = 20000;
    private final AdRequestController.ScreenStateReceiver screenStateReceiver;
    private final boolean shouldRefresh;

    public AdRequestController(Context paramContext, String paramString, AdSize paramAdSize, boolean paramBoolean, AdType paramAdType, AdRequest.Callback paramCallback) {
        if (paramCallback == null) {
            throw new IllegalArgumentException("adViewRequestCallback");
        }
        this.context = paramContext;
        this.placementId = paramString;
        this.adSize = paramAdSize;
        this.shouldRefresh = paramBoolean;
        this.adType = paramAdType;
        this.adViewRequestCallback = paramCallback;
        this.screenStateReceiver = new AdRequestController.ScreenStateReceiver(this, null);
        this.handler = new Handler();
        this.refreshRunnable = new AdRequestController .1 (this);
        registerScreenStateReceiver();
    }

    /* Error */
    private void cancelRefresh(String paramString) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 52	com/facebook/ads/internal/AdRequestController:refreshScheduled	Z
        //   6: istore_2
        //   7: iload_2
        //   8: ifne +6 -> 14
        //   11: aload_0
        //   12: monitorexit
        //   13: return
        //   14: aload_0
        //   15: getfield 84	com/facebook/ads/internal/AdRequestController:handler	Landroid/os/Handler;
        //   18: aload_0
        //   19: getfield 91	com/facebook/ads/internal/AdRequestController:refreshRunnable	Ljava/lang/Runnable;
        //   22: invokevirtual 114	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
        //   25: aload_0
        //   26: iconst_0
        //   27: putfield 52	com/facebook/ads/internal/AdRequestController:refreshScheduled	Z
        //   30: goto -19 -> 11
        //   33: astore_1
        //   34: aload_0
        //   35: monitorexit
        //   36: aload_1
        //   37: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	38	0	this	AdRequestController
        //   0	38	1	paramString	String
        //   6	2	2	bool	boolean
        // Exception table:
        //   from	to	target	type
        //   2	7	33	finally
        //   14	30	33	finally
    }

    private boolean isNetworkConnected() {
        if (this.context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return true;
        }
        NetworkInfo localNetworkInfo = ((ConnectivityManager) this.context.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((localNetworkInfo != null) && (localNetworkInfo.isConnected())) {
        }
        for (boolean bool = true; ; bool = false) {
            return bool;
        }
    }

    private void registerScreenStateReceiver() {
        if (!this.shouldRefresh) {
            return;
        }
        IntentFilter localIntentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
        localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
        this.context.registerReceiver(this.screenStateReceiver, localIntentFilter);
    }

    private void unregisterScreenStateReceiver() {
        if (!this.shouldRefresh) {
            return;
        }
        this.context.unregisterReceiver(this.screenStateReceiver);
    }

    public void destroy() {
        unregisterScreenStateReceiver();
        cancelRefresh("destroy");
    }

    public void loadAd() {
        for (; ; ) {
            try {
                long l1 = this.lastLoadTimeMillis;
                long l2 = this.refreshThreshold;
                long l3 = System.currentTimeMillis();
                if ((this.shouldRefresh) && (l3 < l1 + l2)) {
                    this.adViewRequestCallback.onError(AdError.LOAD_TOO_FREQUENTLY);
                    return;
                }
                if (this.refreshScheduled) {
                    cancelRefresh(null);
                }
                if ((this.lastRequest != null) && (this.lastRequest.getStatus() != AsyncTask.Status.FINISHED)) {
                    this.lastRequest.cancel(true);
                }
                if (!isNetworkConnected()) {
                    this.refreshInterval = 30000;
                    this.refreshThreshold = 20000;
                    this.adViewRequestCallback.onError(new AdError(-1, "network unavailable"));
                    scheduleRefresh("no network connection");
                    continue;
                }
                this.lastLoadTimeMillis = l3;
            } finally {
            }
            this.lastRequest = new AdRequest(this.context, this.placementId, this.adSize, this.adType, AdSettings.isTestMode(this.context), new AdRequestController
            .2 (this)).executeAsync();
        }
    }

    public void onWindowVisibilityChanged(int paramInt) {
        this.currentVisibility = paramInt;
        if (paramInt == 0) {
            if (this.initialLoadFinished) {
                scheduleRefresh("onWindowVisibilityChanged");
            }
            return;
        }
        cancelRefresh("onWindowVisibilityChanged");
    }

    /* Error */
    public void scheduleRefresh(String paramString) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 68	com/facebook/ads/internal/AdRequestController:shouldRefresh	Z
        //   6: istore_2
        //   7: iload_2
        //   8: ifne +6 -> 14
        //   11: aload_0
        //   12: monitorexit
        //   13: return
        //   14: aload_0
        //   15: getfield 46	com/facebook/ads/internal/AdRequestController:refreshInterval	I
        //   18: ifle -7 -> 11
        //   21: aload_0
        //   22: getfield 52	com/facebook/ads/internal/AdRequestController:refreshScheduled	Z
        //   25: ifne -14 -> 11
        //   28: aload_0
        //   29: getfield 84	com/facebook/ads/internal/AdRequestController:handler	Landroid/os/Handler;
        //   32: aload_0
        //   33: getfield 91	com/facebook/ads/internal/AdRequestController:refreshRunnable	Ljava/lang/Runnable;
        //   36: aload_0
        //   37: getfield 46	com/facebook/ads/internal/AdRequestController:refreshInterval	I
        //   40: i2l
        //   41: invokevirtual 238	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
        //   44: pop
        //   45: aload_0
        //   46: iconst_1
        //   47: putfield 52	com/facebook/ads/internal/AdRequestController:refreshScheduled	Z
        //   50: goto -39 -> 11
        //   53: astore_1
        //   54: aload_0
        //   55: monitorexit
        //   56: aload_1
        //   57: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	58	0	this	AdRequestController
        //   0	58	1	paramString	String
        //   6	2	2	bool	boolean
        // Exception table:
        //   from	to	target	type
        //   2	7	53	finally
        //   14	50	53	finally
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/internal/AdRequestController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */