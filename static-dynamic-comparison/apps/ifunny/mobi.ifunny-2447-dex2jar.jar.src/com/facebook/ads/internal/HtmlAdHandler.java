package com.facebook.ads.internal;

import android.os.Handler;
import android.webkit.WebView;

public class HtmlAdHandler {
    private volatile boolean adActivated;
    private HtmlAdDataModel adDataModel;
    private final Handler handler;
    private final HtmlAdHandler.ImpressionHelper impressionHelper;
    private volatile boolean impressionRetryScheduled;
    private volatile boolean impressionSent;
    private final long sendImpressionDelay;
    private final Runnable sendImpressionRunnable = new HtmlAdHandler
    .1(this);
    private final WebView webView;

    public HtmlAdHandler(WebView paramWebView, HtmlAdHandler.ImpressionHelper paramImpressionHelper, long paramLong) {
        this.webView = paramWebView;
        this.impressionHelper = paramImpressionHelper;
        this.sendImpressionDelay = paramLong;
        this.handler = new Handler();
    }

    private void trySendImpression() {
        for (; ; ) {
            try {
                if (this.adDataModel != null) {
                    boolean bool = this.impressionSent;
                    if (!bool) {
                    }
                } else {
                    return;
                }
                if ((this.impressionHelper != null) && (!this.impressionHelper.shouldSendImpression())) {
                    scheduleImpressionRetry();
                    continue;
                }
                if (StringUtils.isNullOrEmpty(this.adDataModel.getSendImpressionCommand())) {
                    break label97;
                }
            } finally {
            }
            this.webView.loadUrl("javascript:" + this.adDataModel.getSendImpressionCommand());
            label97:
            this.impressionSent = true;
            if (this.impressionHelper != null) {
                this.impressionHelper.afterImpressionSent();
            }
        }
    }

    /* Error */
    public void activateAd() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 101	com/facebook/ads/internal/HtmlAdHandler:adActivated	Z
        //   6: ifne +12 -> 18
        //   9: aload_0
        //   10: getfield 54	com/facebook/ads/internal/HtmlAdHandler:adDataModel	Lcom/facebook/ads/internal/HtmlAdDataModel;
        //   13: astore_1
        //   14: aload_1
        //   15: ifnonnull +6 -> 21
        //   18: aload_0
        //   19: monitorexit
        //   20: return
        //   21: aload_0
        //   22: getfield 54	com/facebook/ads/internal/HtmlAdHandler:adDataModel	Lcom/facebook/ads/internal/HtmlAdDataModel;
        //   25: invokevirtual 104	com/facebook/ads/internal/HtmlAdDataModel:getActivationCommand	()Ljava/lang/String;
        //   28: invokestatic 77	com/facebook/ads/internal/StringUtils:isNullOrEmpty	(Ljava/lang/String;)Z
        //   31: ifne +35 -> 66
        //   34: aload_0
        //   35: getfield 34	com/facebook/ads/internal/HtmlAdHandler:webView	Landroid/webkit/WebView;
        //   38: new 79	java/lang/StringBuilder
        //   41: dup
        //   42: invokespecial 80	java/lang/StringBuilder:<init>	()V
        //   45: ldc 82
        //   47: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   50: aload_0
        //   51: getfield 54	com/facebook/ads/internal/HtmlAdHandler:adDataModel	Lcom/facebook/ads/internal/HtmlAdDataModel;
        //   54: invokevirtual 104	com/facebook/ads/internal/HtmlAdDataModel:getActivationCommand	()Ljava/lang/String;
        //   57: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   60: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   63: invokevirtual 95	android/webkit/WebView:loadUrl	(Ljava/lang/String;)V
        //   66: aload_0
        //   67: invokevirtual 65	com/facebook/ads/internal/HtmlAdHandler:scheduleImpressionRetry	()V
        //   70: aload_0
        //   71: iconst_1
        //   72: putfield 101	com/facebook/ads/internal/HtmlAdHandler:adActivated	Z
        //   75: goto -57 -> 18
        //   78: astore_1
        //   79: aload_0
        //   80: monitorexit
        //   81: aload_1
        //   82: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	HtmlAdHandler
        //   13	2	1	localHtmlAdDataModel	HtmlAdDataModel
        //   78	4	1	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	14	78	finally
        //   21	66	78	finally
        //   66	75	78	finally
    }

    public void cancelImpressionRetry() {
        try {
            if (this.impressionRetryScheduled) {
                this.handler.removeCallbacks(this.sendImpressionRunnable);
                this.impressionRetryScheduled = false;
            }
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    /* Error */
    public void scheduleImpressionRetry() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 56	com/facebook/ads/internal/HtmlAdHandler:impressionSent	Z
        //   6: ifne +19 -> 25
        //   9: aload_0
        //   10: getfield 48	com/facebook/ads/internal/HtmlAdHandler:impressionRetryScheduled	Z
        //   13: ifne +12 -> 25
        //   16: aload_0
        //   17: getfield 54	com/facebook/ads/internal/HtmlAdHandler:adDataModel	Lcom/facebook/ads/internal/HtmlAdDataModel;
        //   20: astore_1
        //   21: aload_1
        //   22: ifnonnull +6 -> 28
        //   25: aload_0
        //   26: monitorexit
        //   27: return
        //   28: aload_0
        //   29: getfield 43	com/facebook/ads/internal/HtmlAdHandler:handler	Landroid/os/Handler;
        //   32: aload_0
        //   33: getfield 32	com/facebook/ads/internal/HtmlAdHandler:sendImpressionRunnable	Ljava/lang/Runnable;
        //   36: aload_0
        //   37: getfield 38	com/facebook/ads/internal/HtmlAdHandler:sendImpressionDelay	J
        //   40: invokevirtual 113	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
        //   43: pop
        //   44: aload_0
        //   45: iconst_1
        //   46: putfield 48	com/facebook/ads/internal/HtmlAdHandler:impressionRetryScheduled	Z
        //   49: goto -24 -> 25
        //   52: astore_1
        //   53: aload_0
        //   54: monitorexit
        //   55: aload_1
        //   56: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	57	0	this	HtmlAdHandler
        //   20	2	1	localHtmlAdDataModel	HtmlAdDataModel
        //   52	4	1	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	21	52	finally
        //   28	49	52	finally
    }

    public void setAdDataModel(HtmlAdDataModel paramHtmlAdDataModel) {
        this.adDataModel = paramHtmlAdDataModel;
        this.adActivated = false;
        this.impressionSent = false;
        this.impressionRetryScheduled = false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/internal/HtmlAdHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */