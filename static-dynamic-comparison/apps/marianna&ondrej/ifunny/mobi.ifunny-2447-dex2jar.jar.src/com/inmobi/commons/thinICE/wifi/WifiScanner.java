package com.inmobi.commons.thinICE.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public final class WifiScanner {
    private static Context a = null;
    private static WifiScanListener b = null;
    private static Handler c = null;
    private static boolean d = false;
    private static Runnable e = new b();
    private static boolean f = false;
    private static final BroadcastReceiver g = new a();
    private static final IntentFilter h = new IntentFilter("android.net.wifi.SCAN_RESULTS");
    private static PowerManager.WakeLock i = null;
    private static WifiManager.WifiLock j = null;

    /* Error */
    private static void d() {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: getstatic 31	com/inmobi/commons/thinICE/wifi/WifiScanner:c	Landroid/os/Handler;
        //   6: astore_0
        //   7: aload_0
        //   8: ifnonnull +7 -> 15
        //   11: ldc 2
        //   13: monitorexit
        //   14: return
        //   15: getstatic 31	com/inmobi/commons/thinICE/wifi/WifiScanner:c	Landroid/os/Handler;
        //   18: getstatic 40	com/inmobi/commons/thinICE/wifi/WifiScanner:e	Ljava/lang/Runnable;
        //   21: invokevirtual 72	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
        //   24: invokestatic 74	com/inmobi/commons/thinICE/wifi/WifiScanner:f	()V
        //   27: getstatic 33	com/inmobi/commons/thinICE/wifi/WifiScanner:d	Z
        //   30: ifeq +9 -> 39
        //   33: invokestatic 76	com/inmobi/commons/thinICE/wifi/WifiScanner:h	()V
        //   36: invokestatic 78	com/inmobi/commons/thinICE/wifi/WifiScanner:j	()V
        //   39: aconst_null
        //   40: putstatic 31	com/inmobi/commons/thinICE/wifi/WifiScanner:c	Landroid/os/Handler;
        //   43: aconst_null
        //   44: putstatic 29	com/inmobi/commons/thinICE/wifi/WifiScanner:b	Lcom/inmobi/commons/thinICE/wifi/WifiScanListener;
        //   47: aconst_null
        //   48: putstatic 27	com/inmobi/commons/thinICE/wifi/WifiScanner:a	Landroid/content/Context;
        //   51: iconst_0
        //   52: putstatic 33	com/inmobi/commons/thinICE/wifi/WifiScanner:d	Z
        //   55: goto -44 -> 11
        //   58: astore_0
        //   59: ldc 2
        //   61: monitorexit
        //   62: aload_0
        //   63: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   6	2	0	localHandler	Handler
        //   58	5	0	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   3	7	58	finally
        //   15	39	58	finally
        //   39	55	58	finally
    }

    private static void e() {
        if (f) {
            return;
        }
        f = true;
        a.registerReceiver(g, h, null, c);
    }

    private static void f() {
        if (!f) {
            return;
        }
        f = false;
        try {
            a.unregisterReceiver(g);
            return;
        } catch (IllegalArgumentException localIllegalArgumentException) {
        }
    }

    private static void g() {
        if (i == null) {
            i = ((PowerManager) a.getSystemService("power")).newWakeLock(1, "wifiscanrequester.CpuLock");
            i.setReferenceCounted(false);
        }
        if (!i.isHeld()) {
            i.acquire();
        }
    }

    private static void h() {
        if (i != null) {
            if (i.isHeld()) {
                i.release();
            }
            i = null;
        }
    }

    private static void i() {
        if (j == null) {
            j = ((WifiManager) a.getSystemService("wifi")).createWifiLock(2, "wifiscanrequester.WiFiScanLock");
            j.setReferenceCounted(false);
        }
        if (!j.isHeld()) {
            j.acquire();
        }
    }

    private static void j() {
        if (j != null) {
            if (j.isHeld()) {
                j.release();
            }
            j = null;
        }
    }

    public static boolean requestScan(Context paramContext, WifiScanListener paramWifiScanListener) {
        return requestScan(Looper.myLooper(), paramContext, paramWifiScanListener, 10000L, false);
    }

    /* Error */
    public static boolean requestScan(Looper paramLooper, Context paramContext, WifiScanListener paramWifiScanListener, long paramLong, boolean paramBoolean) {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: getstatic 31	com/inmobi/commons/thinICE/wifi/WifiScanner:c	Landroid/os/Handler;
        //   6: astore 6
        //   8: aload 6
        //   10: ifnull +12 -> 22
        //   13: iconst_0
        //   14: istore 5
        //   16: ldc 2
        //   18: monitorexit
        //   19: iload 5
        //   21: ireturn
        //   22: aload_1
        //   23: ldc 122
        //   25: invokevirtual 96	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
        //   28: checkcast 124	android/net/wifi/WifiManager
        //   31: astore 6
        //   33: aload 6
        //   35: invokevirtual 152	android/net/wifi/WifiManager:isWifiEnabled	()Z
        //   38: ifne +9 -> 47
        //   41: iconst_0
        //   42: istore 5
        //   44: goto -28 -> 16
        //   47: aload_1
        //   48: putstatic 27	com/inmobi/commons/thinICE/wifi/WifiScanner:a	Landroid/content/Context;
        //   51: aload_2
        //   52: putstatic 29	com/inmobi/commons/thinICE/wifi/WifiScanner:b	Lcom/inmobi/commons/thinICE/wifi/WifiScanListener;
        //   55: iload 5
        //   57: putstatic 33	com/inmobi/commons/thinICE/wifi/WifiScanner:d	Z
        //   60: new 68	android/os/Handler
        //   63: dup
        //   64: aload_0
        //   65: invokespecial 155	android/os/Handler:<init>	(Landroid/os/Looper;)V
        //   68: putstatic 31	com/inmobi/commons/thinICE/wifi/WifiScanner:c	Landroid/os/Handler;
        //   71: getstatic 31	com/inmobi/commons/thinICE/wifi/WifiScanner:c	Landroid/os/Handler;
        //   74: getstatic 40	com/inmobi/commons/thinICE/wifi/WifiScanner:e	Ljava/lang/Runnable;
        //   77: lload_3
        //   78: invokevirtual 159	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
        //   81: pop
        //   82: getstatic 33	com/inmobi/commons/thinICE/wifi/WifiScanner:d	Z
        //   85: ifeq +9 -> 94
        //   88: invokestatic 161	com/inmobi/commons/thinICE/wifi/WifiScanner:i	()V
        //   91: invokestatic 163	com/inmobi/commons/thinICE/wifi/WifiScanner:g	()V
        //   94: invokestatic 165	com/inmobi/commons/thinICE/wifi/WifiScanner:e	()V
        //   97: aload 6
        //   99: invokevirtual 168	android/net/wifi/WifiManager:startScan	()Z
        //   102: istore 5
        //   104: goto -88 -> 16
        //   107: astore_0
        //   108: ldc 2
        //   110: monitorexit
        //   111: aload_0
        //   112: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	113	0	paramLooper	Looper
        //   0	113	1	paramContext	Context
        //   0	113	2	paramWifiScanListener	WifiScanListener
        //   0	113	3	paramLong	long
        //   0	113	5	paramBoolean	boolean
        //   6	92	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   3	8	107	finally
        //   22	41	107	finally
        //   47	94	107	finally
        //   94	104	107	finally
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/thinICE/wifi/WifiScanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */