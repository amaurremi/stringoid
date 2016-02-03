package com.inmobi.monetization.internal.imai;

import android.content.Context;
import android.os.Handler;
import com.inmobi.commons.analytics.net.AnalyticsCommon.HttpRequestCallback;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.configs.ConfigParams;
import com.inmobi.monetization.internal.configs.IMAIConfigParams;
import com.inmobi.monetization.internal.configs.Initializer;

import java.util.concurrent.atomic.AtomicBoolean;

public final class RequestResponseManager {
    static Thread a;
    static Handler b = new Handler();
    static AtomicBoolean c = null;
    private static AtomicBoolean g;
    private static AtomicBoolean i = null;
    public static AtomicBoolean isSynced;
    public static IMAIClickEventList mDBWriterQueue;
    public static IMAIClickEventList mNetworkQueue = null;
    String d = "";
    String e = "";
    String f = "";
    private WebviewLoader h = null;

    static {
        mDBWriterQueue = new IMAIClickEventList();
        g = null;
    }

    public void deinit() {
        try {
            if (g != null) {
                g.set(false);
            }
            if (mDBWriterQueue != null) {
                mDBWriterQueue.saveClickEvents();
                mDBWriterQueue.clear();
            }
            isSynced.set(false);
            if (mNetworkQueue != null) {
                mNetworkQueue.clear();
            }
            mNetworkQueue = null;
            return;
        } catch (Exception localException) {
            Log.internal("[InMobi]-[Monetization]", "Request Response Manager deinit failed", localException);
        }
    }

    public void init() {
        try {
            if (mNetworkQueue == null) {
                mNetworkQueue = IMAIClickEventList.getLoggedClickEvents();
            }
            if (g == null) {
                g = new AtomicBoolean(false);
            }
            i = new AtomicBoolean(true);
            isSynced = new AtomicBoolean(false);
            c = new AtomicBoolean(false);
            return;
        } catch (Exception localException) {
            Log.internal("[InMobi]-[Monetization]", "Request Response Manager init failed", localException);
        }
    }

    public void processClick(Context paramContext, AnalyticsCommon.HttpRequestCallback paramHttpRequestCallback) {
        try {
            if (g.compareAndSet(false, true)) {
                a = new Thread(new RequestResponseManager.a(this, paramContext, paramHttpRequestCallback));
                a.setPriority(1);
                a.start();
            }
            return;
        } catch (Exception paramContext) {
            Log.internal("[InMobi]-[Monetization]", "Exception ping ", paramContext);
        }
    }

    /* Error */
    public boolean processClickHttpClient(String paramString, boolean paramBoolean) {
        // Byte code:
        //   0: aconst_null
        //   1: astore 5
        //   3: ldc 76
        //   5: new 124	java/lang/StringBuilder
        //   8: dup
        //   9: invokespecial 125	java/lang/StringBuilder:<init>	()V
        //   12: ldc 127
        //   14: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   17: aload_1
        //   18: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   21: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   24: invokestatic 138	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
        //   27: invokestatic 144	com/inmobi/monetization/internal/configs/Initializer:getConfigParams	()Lcom/inmobi/monetization/internal/configs/ConfigParams;
        //   30: invokevirtual 150	com/inmobi/monetization/internal/configs/ConfigParams:getImai	()Lcom/inmobi/monetization/internal/configs/IMAIConfigParams;
        //   33: invokevirtual 156	com/inmobi/monetization/internal/configs/IMAIConfigParams:getPingTimeOut	()I
        //   36: istore_3
        //   37: new 158	java/net/URL
        //   40: dup
        //   41: aload_1
        //   42: invokespecial 161	java/net/URL:<init>	(Ljava/lang/String;)V
        //   45: invokevirtual 165	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   48: checkcast 167	java/net/HttpURLConnection
        //   51: astore_1
        //   52: aload_1
        //   53: iload_2
        //   54: invokevirtual 170	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
        //   57: aload_1
        //   58: ldc -84
        //   60: invokestatic 177	com/inmobi/commons/internal/InternalSDKUtil:getUserAgent	()Ljava/lang/String;
        //   63: invokevirtual 180	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   66: aload_1
        //   67: iload_3
        //   68: invokevirtual 183	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   71: aload_1
        //   72: iload_3
        //   73: invokevirtual 186	java/net/HttpURLConnection:setReadTimeout	(I)V
        //   76: aload_1
        //   77: iconst_0
        //   78: invokevirtual 189	java/net/HttpURLConnection:setUseCaches	(Z)V
        //   81: aload_1
        //   82: ldc -65
        //   84: invokestatic 194	com/inmobi/commons/internal/InternalSDKUtil:getSavedUserAgent	()Ljava/lang/String;
        //   87: invokevirtual 180	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   90: aload_1
        //   91: ldc -60
        //   93: invokevirtual 199	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   96: aload_1
        //   97: invokevirtual 202	java/net/HttpURLConnection:getResponseCode	()I
        //   100: istore_3
        //   101: iload_3
        //   102: sipush 400
        //   105: if_icmpge +125 -> 230
        //   108: iconst_1
        //   109: istore_2
        //   110: iconst_1
        //   111: iload_2
        //   112: if_icmpne +24 -> 136
        //   115: getstatic 44	com/inmobi/monetization/internal/imai/RequestResponseManager:i	Ljava/util/concurrent/atomic/AtomicBoolean;
        //   118: iconst_1
        //   119: invokevirtual 66	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
        //   122: aload_1
        //   123: ifnull +105 -> 228
        //   126: aload_1
        //   127: invokevirtual 205	java/net/HttpURLConnection:disconnect	()V
        //   130: iload_2
        //   131: istore 4
        //   133: iload 4
        //   135: ireturn
        //   136: getstatic 44	com/inmobi/monetization/internal/imai/RequestResponseManager:i	Ljava/util/concurrent/atomic/AtomicBoolean;
        //   139: iconst_0
        //   140: invokevirtual 66	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
        //   143: goto -21 -> 122
        //   146: astore 5
        //   148: getstatic 44	com/inmobi/monetization/internal/imai/RequestResponseManager:i	Ljava/util/concurrent/atomic/AtomicBoolean;
        //   151: iconst_0
        //   152: invokevirtual 66	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
        //   155: ldc 76
        //   157: ldc -49
        //   159: aload 5
        //   161: invokestatic 84	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   164: iload_2
        //   165: istore 4
        //   167: aload_1
        //   168: ifnull -35 -> 133
        //   171: aload_1
        //   172: invokevirtual 205	java/net/HttpURLConnection:disconnect	()V
        //   175: iload_2
        //   176: ireturn
        //   177: astore_1
        //   178: aload 5
        //   180: ifnull +8 -> 188
        //   183: aload 5
        //   185: invokevirtual 205	java/net/HttpURLConnection:disconnect	()V
        //   188: aload_1
        //   189: athrow
        //   190: astore 6
        //   192: aload_1
        //   193: astore 5
        //   195: aload 6
        //   197: astore_1
        //   198: goto -20 -> 178
        //   201: astore 6
        //   203: aload_1
        //   204: astore 5
        //   206: aload 6
        //   208: astore_1
        //   209: goto -31 -> 178
        //   212: astore 5
        //   214: iconst_0
        //   215: istore_2
        //   216: aconst_null
        //   217: astore_1
        //   218: goto -70 -> 148
        //   221: astore 5
        //   223: iconst_0
        //   224: istore_2
        //   225: goto -77 -> 148
        //   228: iload_2
        //   229: ireturn
        //   230: iconst_0
        //   231: istore_2
        //   232: goto -122 -> 110
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	235	0	this	RequestResponseManager
        //   0	235	1	paramString	String
        //   0	235	2	paramBoolean	boolean
        //   36	70	3	j	int
        //   131	35	4	bool	boolean
        //   1	1	5	localObject1	Object
        //   146	38	5	localException1	Exception
        //   193	12	5	str	String
        //   212	1	5	localException2	Exception
        //   221	1	5	localException3	Exception
        //   190	6	6	localObject2	Object
        //   201	6	6	localObject3	Object
        // Exception table:
        //   from	to	target	type
        //   115	122	146	java/lang/Exception
        //   136	143	146	java/lang/Exception
        //   3	52	177	finally
        //   52	101	190	finally
        //   115	122	190	finally
        //   136	143	190	finally
        //   148	164	201	finally
        //   3	52	212	java/lang/Exception
        //   52	101	221	java/lang/Exception
    }

    public boolean processClickUrlInWebview(String arg1) {
        for (; ; ) {
            try {
                Log.internal("[InMobi]-[Monetization]", "Processing click in webview " + ? ??);
                this.h = new WebviewLoader(InternalSDKUtil.getContext());
                int j = Initializer.getConfigParams().getImai().getPingTimeOut();
                this.h.loadInWebview( ???,null);
                synchronized (a) {
                    try {
                        a.wait(j);
                        if (true == c.get()) {
                            i.set(true);
                            this.h.deinit(j);
                            boolean bool = c.get();
                            return bool;
                        }
                    } catch (InterruptedException localInterruptedException) {
                        Log.internal("[InMobi]-[Monetization]", "Network thread wait failure", localInterruptedException);
                        continue;
                    }
                }
                i.set(false);
            } catch (Exception???)
            {
                Log.internal("[InMobi]-[Monetization]", "ping in webview exception", ???);
                return c.get();
            }
            WebviewLoader.b.set(false);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/imai/RequestResponseManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */