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
import java.util.LinkedList;
import java.util.List;

public final class IceDataCollector
{
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
  private static Runnable l = new a();
  
  private static final boolean a(ThinICEConfigSettings paramThinICEConfigSettings1, ThinICEConfigSettings paramThinICEConfigSettings2)
  {
    return (paramThinICEConfigSettings1.isEnabled() != paramThinICEConfigSettings2.isEnabled()) || (paramThinICEConfigSettings1.getSampleInterval() != paramThinICEConfigSettings2.getSampleInterval());
  }
  
  /* Error */
  public static void flush()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 102	com/inmobi/commons/thinICE/icedatacollector/BuildSettings:DEBUG	Z
    //   6: ifeq +11 -> 17
    //   9: ldc 14
    //   11: ldc 104
    //   13: invokestatic 109	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   16: pop
    //   17: getstatic 70	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:j	Ljava/lang/Object;
    //   20: astore_0
    //   21: aload_0
    //   22: monitorenter
    //   23: aconst_null
    //   24: putstatic 67	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:i	Lcom/inmobi/commons/thinICE/icedatacollector/Sample;
    //   27: new 62	java/util/LinkedList
    //   30: dup
    //   31: invokespecial 63	java/util/LinkedList:<init>	()V
    //   34: putstatic 65	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:h	Ljava/util/LinkedList;
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
  
  public static ThinICEConfigSettings getConfig()
  {
    return new ThinICEConfigSettings(b);
  }
  
  public static WifiInfo getConnectedWifiInfo(Context paramContext)
  {
    Object localObject2 = null;
    int m = b.getWifiFlags();
    if (!ThinICEConfigSettings.bitTest(m, 2)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = ThinICEConfigSettings.bitTest(m, 1);
      Object localObject1 = localObject2;
      if (b.isSampleConnectedWifiEnabled())
      {
        try
        {
          if (WifiUtil.hasGetConnectedWifiInfoPermission(paramContext))
          {
            paramContext = WifiUtil.getConnectedWifiInfo(paramContext, bool1, bool2);
          }
          else
          {
            if (BuildSettings.DEBUG) {
              Log.w("IceDataCollector", "application does not have permission to access connected wifi ap");
            }
            paramContext = null;
          }
        }
        catch (Exception paramContext)
        {
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
      return (WifiInfo)localObject1;
    }
  }
  
  public static List<Sample> getData()
  {
    if (BuildSettings.DEBUG) {
      Log.d("IceDataCollector", "-- getData()");
    }
    synchronized (j)
    {
      LinkedList localLinkedList = h;
      flush();
      return localLinkedList;
    }
  }
  
  public static int getSampleCount()
  {
    synchronized (j)
    {
      int m = h.size();
      return m;
    }
  }
  
  private static void m()
  {
    if (BuildSettings.DEBUG) {
      Log.d("IceDataCollector", "startSampling()");
    }
    if (c != null) {
      if (BuildSettings.DEBUG) {
        Log.d("IceDataCollector", "ignoring, already sampling");
      }
    }
    do
    {
      return;
      HandlerThread localHandlerThread = new HandlerThread("IDC");
      localHandlerThread.start();
      c = localHandlerThread.getLooper();
      d = new Handler(c);
      d.postDelayed(l, b.getSampleInterval() / 2L);
    } while (!BuildSettings.DEBUG);
    Log.d("IceDataCollector", "next sample in " + b.getSampleInterval() / 2L + " ms");
  }
  
  private static void n()
  {
    if (BuildSettings.DEBUG) {
      Log.d("IceDataCollector", "stopSampling()");
    }
    if (c == null) {
      if (BuildSettings.DEBUG) {
        Log.d("IceDataCollector", "ignoring, not currently sampling");
      }
    }
    do
    {
      return;
      d.removeCallbacks(l);
      d = null;
      c.quit();
      c = null;
    } while (!BuildSettings.DEBUG);
    Log.d("IceDataCollector", "sampling stopped");
  }
  
  /* Error */
  public static void setConfig(ThinICEConfigSettings arg0)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 102	com/inmobi/commons/thinICE/icedatacollector/BuildSettings:DEBUG	Z
    //   6: ifeq +33 -> 39
    //   9: ldc 14
    //   11: new 196	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   18: ldc -26
    //   20: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   27: ldc -21
    //   29: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 109	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   38: pop
    //   39: aload_0
    //   40: ifnonnull +21 -> 61
    //   43: getstatic 102	com/inmobi/commons/thinICE/icedatacollector/BuildSettings:DEBUG	Z
    //   46: ifeq +11 -> 57
    //   49: ldc 14
    //   51: ldc -19
    //   53: invokestatic 109	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   56: pop
    //   57: ldc 2
    //   59: monitorexit
    //   60: return
    //   61: getstatic 49	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:b	Lcom/inmobi/commons/thinICE/icedatacollector/ThinICEConfigSettings;
    //   64: astore_3
    //   65: aload_0
    //   66: putstatic 49	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:b	Lcom/inmobi/commons/thinICE/icedatacollector/ThinICEConfigSettings;
    //   69: aload_3
    //   70: invokevirtual 240	com/inmobi/commons/thinICE/icedatacollector/ThinICEConfigSettings:getSampleHistorySize	()I
    //   73: istore_1
    //   74: getstatic 49	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:b	Lcom/inmobi/commons/thinICE/icedatacollector/ThinICEConfigSettings;
    //   77: invokevirtual 240	com/inmobi/commons/thinICE/icedatacollector/ThinICEConfigSettings:getSampleHistorySize	()I
    //   80: istore_2
    //   81: iload_2
    //   82: iload_1
    //   83: if_icmpge +55 -> 138
    //   86: getstatic 70	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:j	Ljava/lang/Object;
    //   89: astore_0
    //   90: aload_0
    //   91: monitorenter
    //   92: getstatic 65	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:h	Ljava/util/LinkedList;
    //   95: invokevirtual 161	java/util/LinkedList:size	()I
    //   98: iload_2
    //   99: if_icmple +37 -> 136
    //   102: getstatic 102	com/inmobi/commons/thinICE/icedatacollector/BuildSettings:DEBUG	Z
    //   105: ifeq +11 -> 116
    //   108: ldc 14
    //   110: ldc -14
    //   112: invokestatic 109	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   115: pop
    //   116: getstatic 65	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:h	Ljava/util/LinkedList;
    //   119: iconst_0
    //   120: getstatic 65	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:h	Ljava/util/LinkedList;
    //   123: invokevirtual 161	java/util/LinkedList:size	()I
    //   126: iload_2
    //   127: isub
    //   128: invokevirtual 246	java/util/LinkedList:subList	(II)Ljava/util/List;
    //   131: invokeinterface 251 1 0
    //   136: aload_0
    //   137: monitorexit
    //   138: getstatic 51	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:c	Landroid/os/Looper;
    //   141: ifnonnull +31 -> 172
    //   144: getstatic 102	com/inmobi/commons/thinICE/icedatacollector/BuildSettings:DEBUG	Z
    //   147: ifeq -90 -> 57
    //   150: ldc 14
    //   152: ldc -3
    //   154: invokestatic 109	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   157: pop
    //   158: goto -101 -> 57
    //   161: astore_0
    //   162: ldc 2
    //   164: monitorexit
    //   165: aload_0
    //   166: athrow
    //   167: astore_3
    //   168: aload_0
    //   169: monitorexit
    //   170: aload_3
    //   171: athrow
    //   172: aload_3
    //   173: getstatic 49	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:b	Lcom/inmobi/commons/thinICE/icedatacollector/ThinICEConfigSettings;
    //   176: invokestatic 255	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:a	(Lcom/inmobi/commons/thinICE/icedatacollector/ThinICEConfigSettings;Lcom/inmobi/commons/thinICE/icedatacollector/ThinICEConfigSettings;)Z
    //   179: ifeq -122 -> 57
    //   182: invokestatic 92	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:n	()V
    //   185: getstatic 49	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:b	Lcom/inmobi/commons/thinICE/icedatacollector/ThinICEConfigSettings;
    //   188: invokevirtual 85	com/inmobi/commons/thinICE/icedatacollector/ThinICEConfigSettings:isEnabled	()Z
    //   191: ifeq +9 -> 200
    //   194: invokestatic 257	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:m	()V
    //   197: goto -140 -> 57
    //   200: invokestatic 155	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:flush	()V
    //   203: aconst_null
    //   204: putstatic 42	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:a	Landroid/content/Context;
    //   207: aconst_null
    //   208: putstatic 57	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:f	Landroid/app/Activity;
    //   211: aconst_null
    //   212: putstatic 72	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:k	Lcom/inmobi/commons/thinICE/icedatacollector/ThinICEListener;
    //   215: goto -158 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   73	11	1	m	int
    //   80	48	2	n	int
    //   64	6	3	localThinICEConfigSettings1	ThinICEConfigSettings
    //   167	6	3	localThinICEConfigSettings2	ThinICEConfigSettings
    // Exception table:
    //   from	to	target	type
    //   3	39	161	finally
    //   43	57	161	finally
    //   61	81	161	finally
    //   86	92	161	finally
    //   138	158	161	finally
    //   170	172	161	finally
    //   172	197	161	finally
    //   200	215	161	finally
    //   92	116	167	finally
    //   116	136	167	finally
    //   136	138	167	finally
    //   168	170	167	finally
  }
  
  public static void setListener(ThinICEListener paramThinICEListener)
  {
    k = paramThinICEListener;
  }
  
  public static void start(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (BuildSettings.DEBUG) {
          Log.d("IceDataCollector", "-- start()");
        }
        if (paramContext == null)
        {
          if (BuildSettings.DEBUG) {
            Log.d("IceDataCollector", "aborting, context is null");
          }
          return;
        }
        if (!b.isEnabled())
        {
          if (!BuildSettings.DEBUG) {
            continue;
          }
          Log.d("IceDataCollector", "ignoring, data collection is disabled in settings");
          continue;
        }
        if (Build.VERSION.SDK_INT >= 14) {
          break label114;
        }
      }
      finally {}
      if (!(paramContext instanceof Activity))
      {
        if (BuildSettings.DEBUG) {
          Log.w("IceDataCollector", "aborting, build < 14 and context is not an activity");
        }
      }
      else
      {
        f = (Activity)paramContext;
        label114:
        a = paramContext.getApplicationContext();
        m();
        if (e)
        {
          if (BuildSettings.DEBUG) {
            Log.d("IceDataCollector", "stop previously requested, clearing request");
          }
          e = false;
          d.removeCallbacks(g);
        }
      }
    }
  }
  
  public static void stop()
  {
    for (;;)
    {
      try
      {
        if (BuildSettings.DEBUG) {
          Log.d("IceDataCollector", "-- stop()");
        }
        if (c == null)
        {
          Log.d("IceDataCollector", "ignoring, not currently running");
          return;
        }
        if (e)
        {
          Log.d("IceDataCollector", "ignoring, stop already requested");
          continue;
        }
        e = true;
      }
      finally {}
      d.postDelayed(g, b.getStopRequestTimeout());
      if (BuildSettings.DEBUG) {
        Log.d("IceDataCollector", "stop requested, occurring in " + b.getStopRequestTimeout() + " ms");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/thinICE/icedatacollector/IceDataCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */