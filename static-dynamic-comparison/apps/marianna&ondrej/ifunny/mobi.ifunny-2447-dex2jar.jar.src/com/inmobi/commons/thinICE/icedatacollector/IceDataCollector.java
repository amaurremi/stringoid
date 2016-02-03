package com.inmobi.commons.thinICE.icedatacollector;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.inmobi.commons.thinICE.wifi.WifiInfo;
import com.inmobi.commons.thinICE.wifi.WifiUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class IceDataCollector {
    public static final String TAG = "IceDataCollector";
    private static Context a = null;
    private static ThinICEConfigSettings b = new ThinICEConfigSettings();
    private static Looper c = null;
    private static Handler d = null;
    private static boolean e = false;
    private static Activity f = null;
    private static Runnable g = new b();
    private static LinkedList<Sample> h = new LinkedList();
    private static Sample i = null;
    private static final Object j = new Object();
    private static ThinICEListener k = null;
    private static IceDataCollector.ThinIceDataCollectedListener l = null;
    private static Runnable m = new a();

    private static final boolean a(ThinICEConfigSettings paramThinICEConfigSettings1, ThinICEConfigSettings paramThinICEConfigSettings2) {
        return (paramThinICEConfigSettings1.isEnabled() != paramThinICEConfigSettings2.isEnabled()) || (paramThinICEConfigSettings1.getSampleInterval() != paramThinICEConfigSettings2.getSampleInterval());
    }

    /* Error */
    public static void flush() {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: getstatic 104	com/inmobi/commons/thinICE/icedatacollector/BuildSettings:DEBUG	Z
        //   6: ifeq +11 -> 17
        //   9: ldc 8
        //   11: ldc 106
        //   13: invokestatic 111	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   16: pop
        //   17: getstatic 68	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:j	Ljava/lang/Object;
        //   20: astore_0
        //   21: aload_0
        //   22: monitorenter
        //   23: aconst_null
        //   24: putstatic 65	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:i	Lcom/inmobi/commons/thinICE/icedatacollector/Sample;
        //   27: new 60	java/util/LinkedList
        //   30: dup
        //   31: invokespecial 61	java/util/LinkedList:<init>	()V
        //   34: putstatic 63	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:h	Ljava/util/LinkedList;
        //   37: aload_0
        //   38: monitorexit
        //   39: ldc 2
        //   41: monitorexit
        //   42: return
        //   43: astore_1
        //   44: aload_0
        //   45: monitorexit
        //   46: aload_1
        //   47: athrow
        //   48: astore_0
        //   49: ldc 2
        //   51: monitorexit
        //   52: aload_0
        //   53: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   48	5	0	localObject2	Object
        //   43	4	1	localObject3	Object
        // Exception table:
        //   from	to	target	type
        //   23	39	43	finally
        //   44	46	43	finally
        //   3	17	48	finally
        //   17	23	48	finally
        //   46	48	48	finally
    }

    public static ThinICEConfigSettings getConfig() {
        return new ThinICEConfigSettings(b);
    }

    public static WifiInfo getConnectedWifiInfo(Context paramContext) {
        Object localObject2 = null;
        int n = b.getWifiFlags();
        if (!ThinICEConfigSettings.bitTest(n, 2)) {
        }
        for (boolean bool1 = true; ; bool1 = false) {
            boolean bool2 = ThinICEConfigSettings.bitTest(n, 1);
            Object localObject1 = localObject2;
            if (b.isSampleConnectedWifiEnabled()) {
                try {
                    if (WifiUtil.hasGetConnectedWifiInfoPermission(paramContext)) {
                        paramContext = WifiUtil.getConnectedWifiInfo(paramContext, bool1, bool2);
                    } else {
                        if (BuildSettings.DEBUG) {
                            Log.w("IceDataCollector", "application does not have permission to access connected wifi ap");
                        }
                        paramContext = null;
                    }
                } catch (Exception paramContext) {
                    localObject1 = localObject2;
                    if (!BuildSettings.DEBUG) {
                        break label100;
                    }
                }
                Log.e("IceDataCollector", "Error getting wifi data", paramContext);
                return null;
                localObject1 = paramContext;
            }
            label100:
            return (WifiInfo) localObject1;
        }
    }

    public static List<Sample> getData() {
        if (BuildSettings.DEBUG) {
            Log.d("IceDataCollector", "-- getData()");
        }
        synchronized (j) {
            LinkedList localLinkedList = h;
            flush();
            return localLinkedList;
        }
    }

    public static int getSampleCount() {
        synchronized (j) {
            int n = h.size();
            return n;
        }
    }

    public static List<Long> getVisbleWifiInfoBssId(Context paramContext) {
        Object localObject2 = null;
        paramContext = null;
        Object localObject1 = localObject2;
        try {
            List localList;
            int n;
            if (b.isSampleVisibleWifiEnabled()) {
                localObject1 = localObject2;
                if (i != null) {
                    localList = i.visibleWifiAp;
                    localObject1 = localObject2;
                    if (localList != null) {
                        localObject1 = localObject2;
                        if (localList.size() != 0) {
                            localObject1 = new ArrayList();
                            n = 0;
                        }
                    }
                }
            }
            return (List<Long>) localObject1;
        } catch (Exception localException1) {
            try {
                while (n < localList.size()) {
                    ((List) localObject1).add(Long.valueOf(((WifiInfo) localList.get(n)).bssid));
                    n += 1;
                }
                localException1 = localException1;
            } catch (Exception localException2) {
                for (; ; ) {
                    paramContext = (Context) localObject1;
                }
            }
            localObject1 = paramContext;
            if (BuildSettings.DEBUG) {
                Log.e("IceDataCollector", "Error getting wifi data", localException1);
                localObject1 = paramContext;
            }
        }
        return (List<Long>) localObject1;
    }

    private static void n() {
        if (BuildSettings.DEBUG) {
            Log.d("IceDataCollector", "startSampling()");
        }
        if (c != null) {
            if (BuildSettings.DEBUG) {
                Log.d("IceDataCollector", "ignoring, already sampling");
            }
        }
        do {
            return;
            HandlerThread localHandlerThread = new HandlerThread("IDC");
            localHandlerThread.start();
            c = localHandlerThread.getLooper();
            d = new Handler(c);
            d.postDelayed(m, b.getSampleInterval() / 2L);
        } while (!BuildSettings.DEBUG);
        Log.d("IceDataCollector", "next sample in " + b.getSampleInterval() / 2L + " ms");
    }

    private static void o() {
        if (BuildSettings.DEBUG) {
            Log.d("IceDataCollector", "stopSampling()");
        }
        if (c == null) {
            if (BuildSettings.DEBUG) {
                Log.d("IceDataCollector", "ignoring, not currently sampling");
            }
        }
        do {
            return;
            d.removeCallbacks(m);
            d = null;
            c.quit();
            c = null;
        } while (!BuildSettings.DEBUG);
        Log.d("IceDataCollector", "sampling stopped");
    }

    /* Error */
    public static void setConfig(ThinICEConfigSettings arg0) {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: getstatic 104	com/inmobi/commons/thinICE/icedatacollector/BuildSettings:DEBUG	Z
        //   6: ifeq +35 -> 41
        //   9: ldc 8
        //   11: new 237	java/lang/StringBuilder
        //   14: dup
        //   15: invokespecial 238	java/lang/StringBuilder:<init>	()V
        //   18: ldc_w 271
        //   21: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   24: aload_0
        //   25: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   28: ldc_w 276
        //   31: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   34: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   37: invokestatic 111	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   40: pop
        //   41: aload_0
        //   42: ifnonnull +22 -> 64
        //   45: getstatic 104	com/inmobi/commons/thinICE/icedatacollector/BuildSettings:DEBUG	Z
        //   48: ifeq +12 -> 60
        //   51: ldc 8
        //   53: ldc_w 278
        //   56: invokestatic 111	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   59: pop
        //   60: ldc 2
        //   62: monitorexit
        //   63: return
        //   64: getstatic 45	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:b	Lcom/inmobi/commons/thinICE/icedatacollector/ThinICEConfigSettings;
        //   67: astore_3
        //   68: aload_0
        //   69: putstatic 45	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:b	Lcom/inmobi/commons/thinICE/icedatacollector/ThinICEConfigSettings;
        //   72: aload_3
        //   73: invokevirtual 281	com/inmobi/commons/thinICE/icedatacollector/ThinICEConfigSettings:getSampleHistorySize	()I
        //   76: istore_1
        //   77: getstatic 45	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:b	Lcom/inmobi/commons/thinICE/icedatacollector/ThinICEConfigSettings;
        //   80: invokevirtual 281	com/inmobi/commons/thinICE/icedatacollector/ThinICEConfigSettings:getSampleHistorySize	()I
        //   83: istore_2
        //   84: iload_2
        //   85: iload_1
        //   86: if_icmpge +56 -> 142
        //   89: getstatic 68	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:j	Ljava/lang/Object;
        //   92: astore_0
        //   93: aload_0
        //   94: monitorenter
        //   95: getstatic 63	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:h	Ljava/util/LinkedList;
        //   98: invokevirtual 163	java/util/LinkedList:size	()I
        //   101: iload_2
        //   102: if_icmple +38 -> 140
        //   105: getstatic 104	com/inmobi/commons/thinICE/icedatacollector/BuildSettings:DEBUG	Z
        //   108: ifeq +12 -> 120
        //   111: ldc 8
        //   113: ldc_w 283
        //   116: invokestatic 111	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   119: pop
        //   120: getstatic 63	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:h	Ljava/util/LinkedList;
        //   123: iconst_0
        //   124: getstatic 63	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:h	Ljava/util/LinkedList;
        //   127: invokevirtual 163	java/util/LinkedList:size	()I
        //   130: iload_2
        //   131: isub
        //   132: invokevirtual 287	java/util/LinkedList:subList	(II)Ljava/util/List;
        //   135: invokeinterface 290 1 0
        //   140: aload_0
        //   141: monitorexit
        //   142: getstatic 47	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:c	Landroid/os/Looper;
        //   145: ifnonnull +32 -> 177
        //   148: getstatic 104	com/inmobi/commons/thinICE/icedatacollector/BuildSettings:DEBUG	Z
        //   151: ifeq -91 -> 60
        //   154: ldc 8
        //   156: ldc_w 292
        //   159: invokestatic 111	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   162: pop
        //   163: goto -103 -> 60
        //   166: astore_0
        //   167: ldc 2
        //   169: monitorexit
        //   170: aload_0
        //   171: athrow
        //   172: astore_3
        //   173: aload_0
        //   174: monitorexit
        //   175: aload_3
        //   176: athrow
        //   177: aload_3
        //   178: getstatic 45	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:b	Lcom/inmobi/commons/thinICE/icedatacollector/ThinICEConfigSettings;
        //   181: invokestatic 294	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:a	(Lcom/inmobi/commons/thinICE/icedatacollector/ThinICEConfigSettings;Lcom/inmobi/commons/thinICE/icedatacollector/ThinICEConfigSettings;)Z
        //   184: ifeq -124 -> 60
        //   187: invokestatic 94	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:o	()V
        //   190: getstatic 45	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:b	Lcom/inmobi/commons/thinICE/icedatacollector/ThinICEConfigSettings;
        //   193: invokevirtual 87	com/inmobi/commons/thinICE/icedatacollector/ThinICEConfigSettings:isEnabled	()Z
        //   196: ifeq +9 -> 205
        //   199: invokestatic 296	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:n	()V
        //   202: goto -142 -> 60
        //   205: invokestatic 157	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:flush	()V
        //   208: aconst_null
        //   209: putstatic 38	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:a	Landroid/content/Context;
        //   212: aconst_null
        //   213: putstatic 53	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:f	Landroid/app/Activity;
        //   216: aconst_null
        //   217: putstatic 70	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:k	Lcom/inmobi/commons/thinICE/icedatacollector/ThinICEListener;
        //   220: goto -160 -> 60
        // Local variable table:
        //   start	length	slot	name	signature
        //   76	11	1	n	int
        //   83	49	2	i1	int
        //   67	6	3	localThinICEConfigSettings1	ThinICEConfigSettings
        //   172	6	3	localThinICEConfigSettings2	ThinICEConfigSettings
        // Exception table:
        //   from	to	target	type
        //   3	41	166	finally
        //   45	60	166	finally
        //   64	84	166	finally
        //   89	95	166	finally
        //   142	163	166	finally
        //   175	177	166	finally
        //   177	202	166	finally
        //   205	220	166	finally
        //   95	120	172	finally
        //   120	140	172	finally
        //   140	142	172	finally
        //   173	175	172	finally
    }

    public static void setIceDataCollectionListener(IceDataCollector.ThinIceDataCollectedListener paramThinIceDataCollectedListener) {
        l = paramThinIceDataCollectedListener;
    }

    public static void setListener(ThinICEListener paramThinICEListener) {
        k = paramThinICEListener;
    }

    public static void start(Context paramContext) {
        for (; ; ) {
            try {
                if (BuildSettings.DEBUG) {
                    Log.d("IceDataCollector", "-- start()");
                }
                if (paramContext == null) {
                    if (BuildSettings.DEBUG) {
                        Log.d("IceDataCollector", "aborting, context is null");
                    }
                    return;
                }
                if (!b.isEnabled()) {
                    if (!BuildSettings.DEBUG) {
                        continue;
                    }
                    Log.d("IceDataCollector", "ignoring, data collection is disabled in settings");
                    continue;
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    break label114;
                }
            } finally {
            }
            if (!(paramContext instanceof Activity)) {
                if (BuildSettings.DEBUG) {
                    Log.w("IceDataCollector", "aborting, build < 14 and context is not an activity");
                }
            } else {
                f = (Activity) paramContext;
                label114:
                a = paramContext.getApplicationContext();
                n();
                if (e) {
                    if (BuildSettings.DEBUG) {
                        Log.d("IceDataCollector", "stop previously requested, clearing request");
                    }
                    e = false;
                    d.removeCallbacks(g);
                }
            }
        }
    }

    public static void stop() {
        for (; ; ) {
            try {
                if (BuildSettings.DEBUG) {
                    Log.d("IceDataCollector", "-- stop()");
                }
                if (c == null) {
                    Log.d("IceDataCollector", "ignoring, not currently running");
                    return;
                }
                if (e) {
                    Log.d("IceDataCollector", "ignoring, stop already requested");
                    continue;
                }
                e = true;
            } finally {
            }
            d.postDelayed(g, b.getStopRequestTimeout());
            if (BuildSettings.DEBUG) {
                Log.d("IceDataCollector", "stop requested, occurring in " + b.getStopRequestTimeout() + " ms");
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/thinICE/icedatacollector/IceDataCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */