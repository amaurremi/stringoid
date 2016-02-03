package com.inmobi.commons.analytics.iat.impl.net;

import android.annotation.TargetApi;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inmobi.commons.analytics.iat.impl.AdTrackerUtils;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerEventType;
import com.inmobi.commons.internal.Log;

import java.util.concurrent.atomic.AtomicBoolean;

public class AdTrackerWebViewLoader$MyWebViewClient
        extends WebViewClient {
    protected AdTrackerWebViewLoader$MyWebViewClient(AdTrackerWebViewLoader paramAdTrackerWebViewLoader) {
    }

    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
        for (; ; ) {
            try {
                if (AdTrackerWebViewLoader.b().compareAndSet(true, false)) {
                    AdTrackerNetworkInterface.setWebviewUploadStatus(false);
                }
            } catch (Exception localException) {
                Log.internal("[InMobi]-[AdTracker]-4.5.1", "Exception onReceived Error", localException);
                continue;
            }
            synchronized (AdTrackerNetworkInterface.getNetworkThread()) {
                AdTrackerNetworkInterface.getNetworkThread().notify();
                AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, AdTrackerWebViewLoader.b(this.a), 0, 0L, paramInt, null);
                Log.internal("[InMobi]-[AdTracker]-4.5.1", "Webview Received Error");
                super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
                return;
            }
        }
    }

    @TargetApi(8)
    public void onReceivedSslError(WebView arg1, SslErrorHandler paramSslErrorHandler, SslError paramSslError) {
        Log.internal("[InMobi]-[AdTracker]-4.5.1", "SSL Error. Proceeding" + paramSslError);
        for (; ; ) {
            try {
                if (AdTrackerWebViewLoader.b().compareAndSet(true, false)) {
                    AdTrackerNetworkInterface.setWebviewUploadStatus(false);
                }
            } catch (Exception???)
            {
                Log.internal("[InMobi]-[AdTracker]-4.5.1", "Exception onReceived SSL Error", ???);
                continue;
            }
            synchronized (AdTrackerNetworkInterface.getNetworkThread()) {
                AdTrackerNetworkInterface.getNetworkThread().notify();
                AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, AdTrackerWebViewLoader.b(this.a), 0, 0L, paramSslError.getPrimaryError(), null);
                Log.internal("[InMobi]-[AdTracker]-4.5.1", "Webview Received SSL Error");
                paramSslErrorHandler.proceed();
                return;
            }
        }
    }

    /* Error */
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
        // Byte code:
        //   0: invokestatic 24	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader:b	()Ljava/util/concurrent/atomic/AtomicBoolean;
        //   3: iconst_1
        //   4: iconst_0
        //   5: invokevirtual 30	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
        //   8: ifeq +69 -> 77
        //   11: aload_0
        //   12: getfield 10	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$MyWebViewClient:a	Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader;
        //   15: invokestatic 122	java/lang/System:currentTimeMillis	()J
        //   18: aload_0
        //   19: getfield 10	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$MyWebViewClient:a	Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader;
        //   22: invokestatic 125	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader:a	(Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader;)J
        //   25: lsub
        //   26: invokestatic 128	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader:a	(Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader;J)J
        //   29: pop2
        //   30: aload_2
        //   31: ldc -126
        //   33: invokevirtual 136	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   36: ifeq +27 -> 63
        //   39: aload_2
        //   40: bipush 7
        //   42: invokevirtual 140	java/lang/String:substring	(I)Ljava/lang/String;
        //   45: astore_3
        //   46: aload_0
        //   47: getfield 10	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$MyWebViewClient:a	Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader;
        //   50: aload_3
        //   51: invokestatic 143	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader:a	(Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader;Ljava/lang/String;)Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$d;
        //   54: astore_3
        //   55: aload_3
        //   56: ifnonnull +28 -> 84
        //   59: iconst_0
        //   60: invokestatic 36	com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface:setWebviewUploadStatus	(Z)V
        //   63: invokestatic 40	com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface:getNetworkThread	()Ljava/lang/Thread;
        //   66: astore_3
        //   67: aload_3
        //   68: monitorenter
        //   69: invokestatic 40	com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface:getNetworkThread	()Ljava/lang/Thread;
        //   72: invokevirtual 45	java/lang/Object:notify	()V
        //   75: aload_3
        //   76: monitorexit
        //   77: aload_1
        //   78: aload_2
        //   79: invokevirtual 149	android/webkit/WebView:loadUrl	(Ljava/lang/String;)V
        //   82: iconst_1
        //   83: ireturn
        //   84: invokestatic 155	com/inmobi/commons/internal/InternalSDKUtil:getContext	()Landroid/content/Context;
        //   87: ldc -99
        //   89: ldc -97
        //   91: aload_3
        //   92: invokestatic 164	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$d:a	(Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$d;)I
        //   95: invokestatic 168	java/lang/Integer:toString	(I)Ljava/lang/String;
        //   98: invokestatic 174	com/inmobi/commons/internal/FileOperations:setPreferences	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
        //   101: pop
        //   102: sipush 5000
        //   105: aload_3
        //   106: invokestatic 164	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$d:a	(Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$d;)I
        //   109: if_icmpeq +41 -> 150
        //   112: iconst_0
        //   113: invokestatic 36	com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface:setWebviewUploadStatus	(Z)V
        //   116: getstatic 51	com/inmobi/commons/analytics/iat/impl/config/AdTrackerEventType:GOAL_FAILURE	Lcom/inmobi/commons/analytics/iat/impl/config/AdTrackerEventType;
        //   119: aload_0
        //   120: getfield 10	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$MyWebViewClient:a	Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader;
        //   123: invokestatic 54	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader:b	(Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader;)Lcom/inmobi/commons/analytics/iat/impl/Goal;
        //   126: iconst_0
        //   127: lconst_0
        //   128: aload_3
        //   129: invokestatic 164	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$d:a	(Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$d;)I
        //   132: aconst_null
        //   133: invokestatic 60	com/inmobi/commons/analytics/iat/impl/AdTrackerUtils:reportMetric	(Lcom/inmobi/commons/analytics/iat/impl/config/AdTrackerEventType;Lcom/inmobi/commons/analytics/iat/impl/Goal;IJILjava/lang/String;)V
        //   136: goto -73 -> 63
        //   139: astore_1
        //   140: ldc 62
        //   142: ldc -80
        //   144: aload_1
        //   145: invokestatic 77	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   148: iconst_1
        //   149: ireturn
        //   150: aload_0
        //   151: getfield 10	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$MyWebViewClient:a	Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader;
        //   154: aload_3
        //   155: invokestatic 179	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$d:b	(Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$d;)Ljava/lang/String;
        //   158: invokestatic 182	com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader:b	(Lcom/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader;Ljava/lang/String;)Z
        //   161: ifeq +10 -> 171
        //   164: iconst_1
        //   165: invokestatic 36	com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface:setWebviewUploadStatus	(Z)V
        //   168: goto -105 -> 63
        //   171: iconst_0
        //   172: invokestatic 36	com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface:setWebviewUploadStatus	(Z)V
        //   175: goto -112 -> 63
        //   178: astore_1
        //   179: aload_3
        //   180: monitorexit
        //   181: aload_1
        //   182: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	183	0	this	MyWebViewClient
        //   0	183	1	paramWebView	WebView
        //   0	183	2	paramString	String
        // Exception table:
        //   from	to	target	type
        //   0	55	139	java/lang/Exception
        //   59	63	139	java/lang/Exception
        //   63	69	139	java/lang/Exception
        //   77	82	139	java/lang/Exception
        //   84	136	139	java/lang/Exception
        //   150	168	139	java/lang/Exception
        //   171	175	139	java/lang/Exception
        //   181	183	139	java/lang/Exception
        //   69	77	178	finally
        //   179	181	178	finally
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$MyWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */