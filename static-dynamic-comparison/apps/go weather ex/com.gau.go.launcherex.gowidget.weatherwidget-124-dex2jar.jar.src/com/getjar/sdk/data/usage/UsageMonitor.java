package com.getjar.sdk.data.usage;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import com.getjar.sdk.comm.CommContext;
import com.getjar.sdk.comm.CommManager;
import com.getjar.sdk.config.GetJarConfig;
import com.getjar.sdk.config.SettingsManager.Scope;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.Utility;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsageMonitor
{
  private static final ExecutorService _ExecutorServiceSendWork = Executors.newSingleThreadExecutor();
  private static volatile UsageMonitor _Instance = null;
  private static long lastEnsureMonitoringTime = 0L;
  private final CommContext _commContext;
  private final Context _context;
  private final long _maxMonitorTrackingIntervalInMilliseconds;
  private final long _monitorIntervalInMilliseconds;
  private volatile UsageMonitoringThread _monitoringThread = null;
  private final Object _monitoringThreadLock = new Object();
  private final Object _waitIntervalBeforeSend = new Object();
  
  private UsageMonitor(Context paramContext)
  {
    this._context = paramContext.getApplicationContext();
    this._commContext = getCommContext(paramContext);
    long l2 = Utility.convertMillSec(Long.parseLong(GetJarConfig.getInstance(this._commContext, true).getDirectiveValue("usage.monitoring.interval", SettingsManager.Scope.CLIENT)));
    long l1 = l2;
    if (l2 <= 0L) {
      l1 = 1000L;
    }
    this._monitorIntervalInMilliseconds = l1;
    l2 = Utility.convertMillSec(Long.parseLong(GetJarConfig.getInstance(this._commContext, true).getDirectiveValue("usage.monitoring.tracking_interval", SettingsManager.Scope.CLIENT)));
    l1 = l2;
    if (l2 <= 0L) {
      l1 = 30000L;
    }
    this._maxMonitorTrackingIntervalInMilliseconds = l1;
  }
  
  private CommContext getCommContext(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context cannot be null");
    }
    return CommManager.createContext(paramContext);
  }
  
  public static UsageMonitor getInstance(Context paramContext)
  {
    try
    {
      if (_Instance == null) {
        _Instance = new UsageMonitor(paramContext);
      }
      paramContext = _Instance;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  public void ensureMonitoring()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 139	java/lang/System:currentTimeMillis	()J
    //   5: lstore_1
    //   6: getstatic 43	com/getjar/sdk/data/usage/UsageMonitor:lastEnsureMonitoringTime	J
    //   9: lstore_3
    //   10: lload_1
    //   11: lload_3
    //   12: lsub
    //   13: ldc2_w 105
    //   16: lcmp
    //   17: ifge +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: invokestatic 144	com/getjar/sdk/data/usage/UsageScreenReceiver:getInstance	()Lcom/getjar/sdk/data/usage/UsageScreenReceiver;
    //   26: aload_0
    //   27: getfield 62	com/getjar/sdk/data/usage/UsageMonitor:_context	Landroid/content/Context;
    //   30: invokevirtual 147	com/getjar/sdk/data/usage/UsageScreenReceiver:registerReceiver	(Landroid/content/Context;)V
    //   33: aload_0
    //   34: getfield 62	com/getjar/sdk/data/usage/UsageMonitor:_context	Landroid/content/Context;
    //   37: new 149	android/content/Intent
    //   40: dup
    //   41: aload_0
    //   42: getfield 62	com/getjar/sdk/data/usage/UsageMonitor:_context	Landroid/content/Context;
    //   45: ldc -105
    //   47: invokespecial 154	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   50: invokevirtual 158	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   53: pop
    //   54: aload_0
    //   55: getfield 62	com/getjar/sdk/data/usage/UsageMonitor:_context	Landroid/content/Context;
    //   58: invokestatic 162	com/getjar/sdk/data/usage/UsageScreenReceiver:isScreenOn	(Landroid/content/Context;)Z
    //   61: ifeq +39 -> 100
    //   64: aload_0
    //   65: getfield 52	com/getjar/sdk/data/usage/UsageMonitor:_monitoringThread	Lcom/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread;
    //   68: ifnull +13 -> 81
    //   71: aload_0
    //   72: getfield 52	com/getjar/sdk/data/usage/UsageMonitor:_monitoringThread	Lcom/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread;
    //   75: invokevirtual 166	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:isAlive	()Z
    //   78: ifne +22 -> 100
    //   81: getstatic 172	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
    //   84: invokevirtual 175	com/getjar/sdk/logging/Area:value	()J
    //   87: ldc -79
    //   89: iconst_0
    //   90: anewarray 4	java/lang/Object
    //   93: invokestatic 183	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   96: aload_0
    //   97: invokevirtual 186	com/getjar/sdk/data/usage/UsageMonitor:startMonitoring	()V
    //   100: lload_1
    //   101: putstatic 43	com/getjar/sdk/data/usage/UsageMonitor:lastEnsureMonitoringTime	J
    //   104: goto -84 -> 20
    //   107: astore 5
    //   109: aload_0
    //   110: monitorexit
    //   111: aload 5
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	UsageMonitor
    //   5	96	1	l1	long
    //   9	3	3	l2	long
    //   107	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	107	finally
    //   23	81	107	finally
    //   81	100	107	finally
    //   100	104	107	finally
  }
  
  public long getAppDuration(String paramString)
  {
    long l2 = 0L;
    long l1 = l2;
    try
    {
      if (this._monitoringThread != null)
      {
        l1 = l2;
        if (paramString != null) {
          l1 = this._monitoringThread.getAppDuration(paramString);
        }
      }
      return l1;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  public String getPhoneSessionId()
  {
    String str = null;
    try
    {
      if (this._monitoringThread != null) {
        str = this._monitoringThread.getPhoneSessionId();
      }
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public boolean isMonitoring()
  {
    try
    {
      if (this._monitoringThread != null)
      {
        boolean bool = this._monitoringThread.isMonitoring();
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public void setMonitorIntervalInMilliseconds(long paramLong)
  {
    try
    {
      if (this._monitoringThread != null) {
        this._monitoringThread.setMonitorIntervalInMilliseconds(paramLong);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setMonitorTrackingIntervalInMilliseconds(long paramLong)
  {
    try
    {
      if (this._monitoringThread != null) {
        this._monitoringThread.setMonitorTrackingIntervalInMilliseconds(paramLong);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void startMonitoring()
  {
    if (!UsageManager.getInstance(this._context).isMonitoringEnabled()) {}
    for (;;)
    {
      return;
      synchronized (this._monitoringThreadLock)
      {
        if ((this._monitoringThread == null) || (!this._monitoringThread.isAlive()) || (!this._monitoringThread.isMonitoring()))
        {
          this._monitoringThread = new UsageMonitoringThread(null);
          this._monitoringThread.start();
        }
        if ((!UsageManager.getInstance(this._context).isUsageSessionBackgroundSendEnabled()) || (!UsageScreenReceiver.isScreenOn(this._context))) {
          continue;
        }
        _ExecutorServiceSendWork.execute(new Runnable()
        {
          /* Error */
          public void run()
          {
            // Byte code:
            //   0: getstatic 29	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
            //   3: invokevirtual 33	com/getjar/sdk/logging/Area:value	()J
            //   6: ldc 35
            //   8: iconst_0
            //   9: anewarray 4	java/lang/Object
            //   12: invokestatic 41	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
            //   15: invokestatic 47	java/lang/Math:random	()D
            //   18: ldc2_w 48
            //   21: dmul
            //   22: d2i
            //   23: istore_1
            //   24: aload_0
            //   25: getfield 17	com/getjar/sdk/data/usage/UsageMonitor$1:this$0	Lcom/getjar/sdk/data/usage/UsageMonitor;
            //   28: invokestatic 53	com/getjar/sdk/data/usage/UsageMonitor:access$100	(Lcom/getjar/sdk/data/usage/UsageMonitor;)Ljava/lang/Object;
            //   31: astore_2
            //   32: aload_2
            //   33: monitorenter
            //   34: aload_0
            //   35: getfield 17	com/getjar/sdk/data/usage/UsageMonitor$1:this$0	Lcom/getjar/sdk/data/usage/UsageMonitor;
            //   38: invokestatic 53	com/getjar/sdk/data/usage/UsageMonitor:access$100	(Lcom/getjar/sdk/data/usage/UsageMonitor;)Ljava/lang/Object;
            //   41: iload_1
            //   42: sipush 5000
            //   45: iadd
            //   46: i2l
            //   47: invokevirtual 57	java/lang/Object:wait	(J)V
            //   50: aload_2
            //   51: monitorexit
            //   52: aload_0
            //   53: getfield 17	com/getjar/sdk/data/usage/UsageMonitor$1:this$0	Lcom/getjar/sdk/data/usage/UsageMonitor;
            //   56: invokestatic 61	com/getjar/sdk/data/usage/UsageMonitor:access$200	(Lcom/getjar/sdk/data/usage/UsageMonitor;)Landroid/content/Context;
            //   59: invokestatic 67	com/getjar/sdk/data/usage/UsageManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/data/usage/UsageManager;
            //   62: invokevirtual 71	com/getjar/sdk/data/usage/UsageManager:isUsageSessionBackgroundSendEnabled	()Z
            //   65: ifeq +29 -> 94
            //   68: aload_0
            //   69: getfield 17	com/getjar/sdk/data/usage/UsageMonitor$1:this$0	Lcom/getjar/sdk/data/usage/UsageMonitor;
            //   72: invokestatic 61	com/getjar/sdk/data/usage/UsageMonitor:access$200	(Lcom/getjar/sdk/data/usage/UsageMonitor;)Landroid/content/Context;
            //   75: invokestatic 77	com/getjar/sdk/data/usage/UsageScreenReceiver:isScreenOn	(Landroid/content/Context;)Z
            //   78: ifeq +16 -> 94
            //   81: aload_0
            //   82: getfield 17	com/getjar/sdk/data/usage/UsageMonitor$1:this$0	Lcom/getjar/sdk/data/usage/UsageMonitor;
            //   85: invokestatic 81	com/getjar/sdk/data/usage/UsageMonitor:access$300	(Lcom/getjar/sdk/data/usage/UsageMonitor;)Lcom/getjar/sdk/comm/CommContext;
            //   88: invokestatic 86	com/getjar/sdk/data/usage/UsageReporter:getInstance	(Lcom/getjar/sdk/comm/CommContext;)Lcom/getjar/sdk/data/usage/UsageReporter;
            //   91: invokevirtual 89	com/getjar/sdk/data/usage/UsageReporter:sendUnsyncedData	()V
            //   94: getstatic 29	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
            //   97: invokevirtual 33	com/getjar/sdk/logging/Area:value	()J
            //   100: ldc 91
            //   102: iconst_0
            //   103: anewarray 4	java/lang/Object
            //   106: invokestatic 41	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
            //   109: return
            //   110: astore_3
            //   111: aload_2
            //   112: monitorexit
            //   113: aload_3
            //   114: athrow
            //   115: astore_2
            //   116: getstatic 29	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
            //   119: invokevirtual 33	com/getjar/sdk/logging/Area:value	()J
            //   122: aload_2
            //   123: ldc 93
            //   125: iconst_0
            //   126: anewarray 4	java/lang/Object
            //   129: invokestatic 97	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
            //   132: getstatic 29	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
            //   135: invokevirtual 33	com/getjar/sdk/logging/Area:value	()J
            //   138: ldc 91
            //   140: iconst_0
            //   141: anewarray 4	java/lang/Object
            //   144: invokestatic 41	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
            //   147: return
            //   148: astore_2
            //   149: getstatic 29	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
            //   152: invokevirtual 33	com/getjar/sdk/logging/Area:value	()J
            //   155: ldc 91
            //   157: iconst_0
            //   158: anewarray 4	java/lang/Object
            //   161: invokestatic 41	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
            //   164: aload_2
            //   165: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	166	0	this	1
            //   23	23	1	i	int
            //   115	8	2	localException	Exception
            //   148	17	2	localObject2	Object
            //   110	4	3	localObject3	Object
            // Exception table:
            //   from	to	target	type
            //   34	52	110	finally
            //   111	113	110	finally
            //   15	34	115	java/lang/Exception
            //   52	94	115	java/lang/Exception
            //   113	115	115	java/lang/Exception
            //   15	34	148	finally
            //   52	94	148	finally
            //   113	115	148	finally
            //   116	132	148	finally
          }
        });
        return;
      }
    }
  }
  
  /* Error */
  public void stopMonitoring()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 8
    //   8: aconst_null
    //   9: astore 6
    //   11: aload_3
    //   12: astore 5
    //   14: aload 8
    //   16: astore 4
    //   18: aload_0
    //   19: getfield 54	com/getjar/sdk/data/usage/UsageMonitor:_monitoringThreadLock	Ljava/lang/Object;
    //   22: astore 9
    //   24: aload_3
    //   25: astore 5
    //   27: aload 8
    //   29: astore 4
    //   31: aload 9
    //   33: monitorenter
    //   34: aload 6
    //   36: astore_3
    //   37: aload 7
    //   39: astore 4
    //   41: aload_0
    //   42: getfield 52	com/getjar/sdk/data/usage/UsageMonitor:_monitoringThread	Lcom/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread;
    //   45: ifnull +48 -> 93
    //   48: aload 6
    //   50: astore_3
    //   51: aload 7
    //   53: astore 4
    //   55: aload_0
    //   56: getfield 52	com/getjar/sdk/data/usage/UsageMonitor:_monitoringThread	Lcom/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread;
    //   59: invokevirtual 198	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:isMonitoring	()Z
    //   62: ifeq +31 -> 93
    //   65: aload 7
    //   67: astore 4
    //   69: aload_0
    //   70: getfield 52	com/getjar/sdk/data/usage/UsageMonitor:_monitoringThread	Lcom/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread;
    //   73: invokevirtual 235	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:requestThreadExit	()V
    //   76: aload 7
    //   78: astore 4
    //   80: aload_0
    //   81: getfield 52	com/getjar/sdk/data/usage/UsageMonitor:_monitoringThread	Lcom/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread;
    //   84: astore_3
    //   85: aload_3
    //   86: astore 4
    //   88: aload_0
    //   89: aconst_null
    //   90: putfield 52	com/getjar/sdk/data/usage/UsageMonitor:_monitoringThread	Lcom/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread;
    //   93: aload_3
    //   94: astore 4
    //   96: aload 9
    //   98: monitorexit
    //   99: aload_3
    //   100: astore 5
    //   102: aload_3
    //   103: astore 4
    //   105: aload_0
    //   106: getfield 50	com/getjar/sdk/data/usage/UsageMonitor:_waitIntervalBeforeSend	Ljava/lang/Object;
    //   109: astore 6
    //   111: aload_3
    //   112: astore 5
    //   114: aload_3
    //   115: astore 4
    //   117: aload 6
    //   119: monitorenter
    //   120: aload_0
    //   121: getfield 50	com/getjar/sdk/data/usage/UsageMonitor:_waitIntervalBeforeSend	Ljava/lang/Object;
    //   124: invokevirtual 238	java/lang/Object:notify	()V
    //   127: aload 6
    //   129: monitorexit
    //   130: aload_3
    //   131: ifnull +33 -> 164
    //   134: aload_3
    //   135: astore 4
    //   137: aload_3
    //   138: ldc2_w 239
    //   141: invokevirtual 243	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:join	(J)V
    //   144: aload_3
    //   145: astore 5
    //   147: aload_3
    //   148: astore 4
    //   150: aload_3
    //   151: invokevirtual 246	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:interrupt	()V
    //   154: aload_3
    //   155: astore 4
    //   157: aload_3
    //   158: ldc2_w 247
    //   161: invokevirtual 243	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:join	(J)V
    //   164: getstatic 172	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
    //   167: invokevirtual 175	com/getjar/sdk/logging/Area:value	()J
    //   170: lstore_1
    //   171: aload_3
    //   172: ifnull +265 -> 437
    //   175: aload_3
    //   176: invokevirtual 251	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:getId	()J
    //   179: invokestatic 255	java/lang/Long:toString	(J)Ljava/lang/String;
    //   182: astore_3
    //   183: lload_1
    //   184: ldc_w 257
    //   187: iconst_1
    //   188: anewarray 4	java/lang/Object
    //   191: dup
    //   192: iconst_0
    //   193: aload_3
    //   194: aastore
    //   195: invokestatic 260	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   198: aload_0
    //   199: getfield 62	com/getjar/sdk/data/usage/UsageMonitor:_context	Landroid/content/Context;
    //   202: invokestatic 210	com/getjar/sdk/data/usage/UsageManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/data/usage/UsageManager;
    //   205: invokevirtual 222	com/getjar/sdk/data/usage/UsageManager:isUsageSessionBackgroundSendEnabled	()Z
    //   208: ifeq +13 -> 221
    //   211: aload_0
    //   212: getfield 68	com/getjar/sdk/data/usage/UsageMonitor:_commContext	Lcom/getjar/sdk/comm/CommContext;
    //   215: invokestatic 265	com/getjar/sdk/data/usage/UsageReporter:getInstance	(Lcom/getjar/sdk/comm/CommContext;)Lcom/getjar/sdk/data/usage/UsageReporter;
    //   218: invokevirtual 268	com/getjar/sdk/data/usage/UsageReporter:sendUnsyncedData	()V
    //   221: aload_0
    //   222: getfield 62	com/getjar/sdk/data/usage/UsageMonitor:_context	Landroid/content/Context;
    //   225: invokestatic 273	com/getjar/sdk/data/usage/UsageDatabase:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/data/usage/UsageDatabase;
    //   228: aload_0
    //   229: getfield 62	com/getjar/sdk/data/usage/UsageMonitor:_context	Landroid/content/Context;
    //   232: invokestatic 210	com/getjar/sdk/data/usage/UsageManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/data/usage/UsageManager;
    //   235: invokevirtual 277	com/getjar/sdk/data/usage/UsageManager:getRequestTimeMilliseconds	()I
    //   238: i2l
    //   239: invokevirtual 280	com/getjar/sdk/data/usage/UsageDatabase:purgeOldEntries	(J)V
    //   242: aload_0
    //   243: getfield 62	com/getjar/sdk/data/usage/UsageMonitor:_context	Landroid/content/Context;
    //   246: invokestatic 273	com/getjar/sdk/data/usage/UsageDatabase:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/data/usage/UsageDatabase;
    //   249: invokevirtual 283	com/getjar/sdk/data/usage/UsageDatabase:trimLruEntries	()V
    //   252: return
    //   253: astore_3
    //   254: aload 9
    //   256: monitorexit
    //   257: aload 4
    //   259: astore 5
    //   261: aload_3
    //   262: athrow
    //   263: astore_3
    //   264: aload 5
    //   266: astore 4
    //   268: getstatic 172	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
    //   271: invokevirtual 175	com/getjar/sdk/logging/Area:value	()J
    //   274: aload_3
    //   275: ldc_w 285
    //   278: iconst_0
    //   279: anewarray 4	java/lang/Object
    //   282: invokestatic 289	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   285: getstatic 172	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
    //   288: invokevirtual 175	com/getjar/sdk/logging/Area:value	()J
    //   291: lstore_1
    //   292: aload 5
    //   294: ifnull +150 -> 444
    //   297: aload 5
    //   299: invokevirtual 251	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:getId	()J
    //   302: invokestatic 255	java/lang/Long:toString	(J)Ljava/lang/String;
    //   305: astore_3
    //   306: lload_1
    //   307: ldc_w 257
    //   310: iconst_1
    //   311: anewarray 4	java/lang/Object
    //   314: dup
    //   315: iconst_0
    //   316: aload_3
    //   317: aastore
    //   318: invokestatic 260	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   321: goto -123 -> 198
    //   324: astore 7
    //   326: aload 6
    //   328: monitorexit
    //   329: aload_3
    //   330: astore 5
    //   332: aload_3
    //   333: astore 4
    //   335: aload 7
    //   337: athrow
    //   338: astore 5
    //   340: getstatic 172	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
    //   343: invokevirtual 175	com/getjar/sdk/logging/Area:value	()J
    //   346: lstore_1
    //   347: aload 4
    //   349: ifnull +102 -> 451
    //   352: aload 4
    //   354: invokevirtual 251	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:getId	()J
    //   357: invokestatic 255	java/lang/Long:toString	(J)Ljava/lang/String;
    //   360: astore_3
    //   361: lload_1
    //   362: ldc_w 257
    //   365: iconst_1
    //   366: anewarray 4	java/lang/Object
    //   369: dup
    //   370: iconst_0
    //   371: aload_3
    //   372: aastore
    //   373: invokestatic 260	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   376: aload 5
    //   378: athrow
    //   379: astore 6
    //   381: aload_3
    //   382: astore 5
    //   384: aload_3
    //   385: astore 4
    //   387: getstatic 172	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
    //   390: invokevirtual 175	com/getjar/sdk/logging/Area:value	()J
    //   393: aload 6
    //   395: ldc_w 291
    //   398: iconst_0
    //   399: anewarray 4	java/lang/Object
    //   402: invokestatic 289	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   405: goto -261 -> 144
    //   408: astore 6
    //   410: aload_3
    //   411: astore 5
    //   413: aload_3
    //   414: astore 4
    //   416: getstatic 172	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
    //   419: invokevirtual 175	com/getjar/sdk/logging/Area:value	()J
    //   422: aload 6
    //   424: ldc_w 293
    //   427: iconst_0
    //   428: anewarray 4	java/lang/Object
    //   431: invokestatic 289	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   434: goto -270 -> 164
    //   437: ldc_w 295
    //   440: astore_3
    //   441: goto -258 -> 183
    //   444: ldc_w 295
    //   447: astore_3
    //   448: goto -142 -> 306
    //   451: ldc_w 295
    //   454: astore_3
    //   455: goto -94 -> 361
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	458	0	this	UsageMonitor
    //   170	192	1	l	long
    //   4	190	3	localObject1	Object
    //   253	9	3	localObject2	Object
    //   263	12	3	localException1	Exception
    //   305	150	3	str1	String
    //   16	399	4	localObject3	Object
    //   12	319	5	localObject4	Object
    //   338	39	5	localObject5	Object
    //   382	30	5	str2	String
    //   9	318	6	localObject6	Object
    //   379	15	6	localException2	Exception
    //   408	15	6	localException3	Exception
    //   1	76	7	localObject7	Object
    //   324	12	7	localObject8	Object
    //   6	22	8	localObject9	Object
    //   22	233	9	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   41	48	253	finally
    //   55	65	253	finally
    //   69	76	253	finally
    //   80	85	253	finally
    //   88	93	253	finally
    //   96	99	253	finally
    //   254	257	253	finally
    //   18	24	263	java/lang/Exception
    //   31	34	263	java/lang/Exception
    //   105	111	263	java/lang/Exception
    //   117	120	263	java/lang/Exception
    //   150	154	263	java/lang/Exception
    //   261	263	263	java/lang/Exception
    //   335	338	263	java/lang/Exception
    //   387	405	263	java/lang/Exception
    //   416	434	263	java/lang/Exception
    //   120	130	324	finally
    //   326	329	324	finally
    //   18	24	338	finally
    //   31	34	338	finally
    //   105	111	338	finally
    //   117	120	338	finally
    //   137	144	338	finally
    //   150	154	338	finally
    //   157	164	338	finally
    //   261	263	338	finally
    //   268	285	338	finally
    //   335	338	338	finally
    //   387	405	338	finally
    //   416	434	338	finally
    //   137	144	379	java/lang/Exception
    //   157	164	408	java/lang/Exception
  }
  
  private class UsageMonitoringThread
    extends Thread
  {
    private final Object _intervalWaitMonitor = new Object();
    private boolean _requestThreadExit = false;
    private long _requestThreadExitTime = -1L;
    private final ActivityManager activityManager = (ActivityManager)UsageMonitor.this._context.getSystemService("activity");
    private Map<String, SessionInfo> appSessionInfo = new ConcurrentHashMap();
    long currentMonitorIntervalInMilliseconds = UsageMonitor.this._monitorIntervalInMilliseconds;
    long currentMonitorTrackingIntervalInMilliseconds = this.minMonitorTrackingIntervalInMilliseconds;
    private long minMonitorTrackingIntervalInMilliseconds = 15000L;
    private final String phoneSessionId = UsageDatabase.getNewPhoneSessionID();
    private final UsageDatabase usageDB = UsageDatabase.getInstance(UsageMonitor.this._context);
    
    private UsageMonitoringThread() {}
    
    private String getRunningPackageName()
    {
      return ((ActivityManager.RunningTaskInfo)this.activityManager.getRunningTasks(1).get(0)).topActivity.getPackageName();
    }
    
    private void saveSessionToDatabase(String paramString1, long paramLong, String paramString2)
    {
      SessionInfo localSessionInfo = (SessionInfo)this.appSessionInfo.get(paramString1);
      if (localSessionInfo == null) {
        Logger.e(Area.USAGE.value(), "UsageMonitor: UsageMonitoringThread: saveSessionToDatabase: package %s not found in sessionInfo", new Object[] { paramString1 });
      }
      do
      {
        return;
        localSessionInfo.addDuration(paramLong);
      } while (localSessionInfo.getShouldFilter());
      paramLong = localSessionInfo.getRowId();
      if (paramLong < 0L)
      {
        localSessionInfo.setRowId(this.usageDB.insertAppSession(paramString1, localSessionInfo.getStartTimestamp(), localSessionInfo.getDuration(), paramString2, this.phoneSessionId));
        return;
      }
      this.usageDB.updateAppSession(paramLong, localSessionInfo.getDuration(), paramString2);
    }
    
    public long getAppDuration(String paramString)
    {
      if (paramString == null) {}
      do
      {
        return 0L;
        paramString = (SessionInfo)this.appSessionInfo.get(paramString);
      } while (paramString == null);
      return paramString.getDuration();
    }
    
    public String getPhoneSessionId()
    {
      return this.phoneSessionId;
    }
    
    public boolean isMonitoring()
    {
      return !this._requestThreadExit;
    }
    
    public void requestThreadExit()
    {
      this._requestThreadExit = true;
      long l;
      if (this._requestThreadExitTime > 0L) {
        l = this._requestThreadExitTime;
      }
      for (;;)
      {
        this._requestThreadExitTime = l;
        synchronized (this._intervalWaitMonitor)
        {
          this._intervalWaitMonitor.notify();
          return;
          l = System.currentTimeMillis();
        }
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 34	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:this$0	Lcom/getjar/sdk/data/usage/UsageMonitor;
      //   4: invokestatic 56	com/getjar/sdk/data/usage/UsageMonitor:access$200	(Lcom/getjar/sdk/data/usage/UsageMonitor;)Landroid/content/Context;
      //   7: ldc -62
      //   9: invokestatic 200	com/getjar/sdk/utilities/RewardUtility:checkPermission	(Landroid/content/Context;Ljava/lang/String;)Z
      //   12: istore_1
      //   13: iload_1
      //   14: ifne +31 -> 45
      //   17: getstatic 134	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
      //   20: invokevirtual 138	com/getjar/sdk/logging/Area:value	()J
      //   23: ldc -54
      //   25: iconst_1
      //   26: anewarray 45	java/lang/Object
      //   29: dup
      //   30: iconst_0
      //   31: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   34: invokevirtual 209	java/lang/Thread:getId	()J
      //   37: invokestatic 215	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   40: aastore
      //   41: invokestatic 218	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   44: return
      //   45: aload_0
      //   46: invokespecial 220	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:getRunningPackageName	()Ljava/lang/String;
      //   49: astore 27
      //   51: invokestatic 187	java/lang/System:currentTimeMillis	()J
      //   54: lstore 14
      //   56: aload_0
      //   57: getfield 87	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:appSessionInfo	Ljava/util/Map;
      //   60: aload 27
      //   62: new 9	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread$SessionInfo
      //   65: dup
      //   66: aload_0
      //   67: aload 27
      //   69: lload 14
      //   71: invokespecial 223	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread$SessionInfo:<init>	(Lcom/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread;Ljava/lang/String;J)V
      //   74: invokeinterface 227 3 0
      //   79: pop
      //   80: lconst_0
      //   81: lstore 10
      //   83: aconst_null
      //   84: astore 30
      //   86: aload 27
      //   88: astore 25
      //   90: lload 14
      //   92: lstore 20
      //   94: lload 10
      //   96: lstore 6
      //   98: aload 30
      //   100: astore 29
      //   102: aload 27
      //   104: astore 24
      //   106: lload 14
      //   108: lstore 16
      //   110: lload 10
      //   112: lstore_2
      //   113: aload_0
      //   114: getfield 39	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:_requestThreadExit	Z
      //   117: istore_1
      //   118: iload_1
      //   119: ifne +1431 -> 1550
      //   122: aload 27
      //   124: astore 26
      //   126: lload 14
      //   128: lstore 18
      //   130: lload 10
      //   132: lstore 4
      //   134: aload 27
      //   136: astore 25
      //   138: lload 14
      //   140: lstore 20
      //   142: lload 10
      //   144: lstore 6
      //   146: aload 30
      //   148: astore 29
      //   150: aload 27
      //   152: astore 24
      //   154: lload 14
      //   156: lstore 16
      //   158: lload 10
      //   160: lstore_2
      //   161: aload_0
      //   162: getfield 34	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:this$0	Lcom/getjar/sdk/data/usage/UsageMonitor;
      //   165: invokestatic 56	com/getjar/sdk/data/usage/UsageMonitor:access$200	(Lcom/getjar/sdk/data/usage/UsageMonitor;)Landroid/content/Context;
      //   168: invokestatic 233	com/getjar/sdk/data/usage/UsageScreenReceiver:isScreenOn	(Landroid/content/Context;)Z
      //   171: ifne +514 -> 685
      //   174: aload 27
      //   176: astore 26
      //   178: lload 14
      //   180: lstore 18
      //   182: lload 10
      //   184: lstore 4
      //   186: aload 27
      //   188: astore 25
      //   190: lload 14
      //   192: lstore 20
      //   194: lload 10
      //   196: lstore 6
      //   198: aload 30
      //   200: astore 29
      //   202: aload 27
      //   204: astore 24
      //   206: lload 14
      //   208: lstore 16
      //   210: lload 10
      //   212: lstore_2
      //   213: aload_0
      //   214: iconst_1
      //   215: putfield 39	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:_requestThreadExit	Z
      //   218: aload 27
      //   220: astore 26
      //   222: lload 14
      //   224: lstore 18
      //   226: lload 10
      //   228: lstore 4
      //   230: aload 27
      //   232: astore 25
      //   234: lload 14
      //   236: lstore 20
      //   238: lload 10
      //   240: lstore 6
      //   242: aload 30
      //   244: astore 29
      //   246: aload 27
      //   248: astore 24
      //   250: lload 14
      //   252: lstore 16
      //   254: lload 10
      //   256: lstore_2
      //   257: aload_0
      //   258: getfield 43	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:_requestThreadExitTime	J
      //   261: lconst_0
      //   262: lcmp
      //   263: ifle +375 -> 638
      //   266: aload 27
      //   268: astore 26
      //   270: lload 14
      //   272: lstore 18
      //   274: lload 10
      //   276: lstore 4
      //   278: aload 27
      //   280: astore 25
      //   282: lload 14
      //   284: lstore 20
      //   286: lload 10
      //   288: lstore 6
      //   290: aload 30
      //   292: astore 29
      //   294: aload 27
      //   296: astore 24
      //   298: lload 14
      //   300: lstore 16
      //   302: lload 10
      //   304: lstore_2
      //   305: aload_0
      //   306: getfield 43	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:_requestThreadExitTime	J
      //   309: lstore 8
      //   311: aload 27
      //   313: astore 26
      //   315: lload 14
      //   317: lstore 18
      //   319: lload 10
      //   321: lstore 4
      //   323: aload 27
      //   325: astore 25
      //   327: lload 14
      //   329: lstore 20
      //   331: lload 10
      //   333: lstore 6
      //   335: aload 30
      //   337: astore 29
      //   339: aload 27
      //   341: astore 24
      //   343: lload 14
      //   345: lstore 16
      //   347: lload 10
      //   349: lstore_2
      //   350: aload_0
      //   351: lload 8
      //   353: putfield 43	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:_requestThreadExitTime	J
      //   356: aload 27
      //   358: astore 26
      //   360: lload 14
      //   362: lstore 18
      //   364: lload 10
      //   366: lstore 4
      //   368: aload 27
      //   370: astore 25
      //   372: lload 14
      //   374: lstore 20
      //   376: lload 10
      //   378: lstore 6
      //   380: aload 30
      //   382: astore 29
      //   384: aload 27
      //   386: astore 24
      //   388: lload 14
      //   390: lstore 16
      //   392: lload 10
      //   394: lstore_2
      //   395: getstatic 134	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
      //   398: invokevirtual 138	com/getjar/sdk/logging/Area:value	()J
      //   401: ldc -21
      //   403: iconst_0
      //   404: anewarray 45	java/lang/Object
      //   407: invokestatic 146	com/getjar/sdk/logging/Logger:e	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   410: goto -324 -> 86
      //   413: astore 24
      //   415: aload 26
      //   417: astore 25
      //   419: lload 18
      //   421: lstore 20
      //   423: lload 4
      //   425: lstore 6
      //   427: aload 30
      //   429: astore 29
      //   431: aload 26
      //   433: astore 24
      //   435: lload 18
      //   437: lstore 16
      //   439: lload 4
      //   441: lstore_2
      //   442: getstatic 134	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
      //   445: invokevirtual 138	com/getjar/sdk/logging/Area:value	()J
      //   448: ldc -19
      //   450: iconst_1
      //   451: anewarray 45	java/lang/Object
      //   454: dup
      //   455: iconst_0
      //   456: aload_0
      //   457: getfield 39	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:_requestThreadExit	Z
      //   460: invokestatic 242	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   463: aastore
      //   464: invokestatic 218	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   467: aload 26
      //   469: astore 27
      //   471: lload 18
      //   473: lstore 14
      //   475: lload 4
      //   477: lstore 10
      //   479: goto -393 -> 86
      //   482: astore 27
      //   484: aload 30
      //   486: astore 29
      //   488: aload 25
      //   490: astore 24
      //   492: lload 20
      //   494: lstore 16
      //   496: lload 6
      //   498: lstore_2
      //   499: aload 27
      //   501: invokevirtual 246	java/lang/Object:getClass	()Ljava/lang/Class;
      //   504: invokevirtual 251	java/lang/Class:getName	()Ljava/lang/String;
      //   507: astore 26
      //   509: aload 26
      //   511: astore 29
      //   513: aload 25
      //   515: astore 24
      //   517: lload 20
      //   519: lstore 16
      //   521: lload 6
      //   523: lstore_2
      //   524: aload 27
      //   526: athrow
      //   527: astore 26
      //   529: aload 29
      //   531: ifnonnull +1156 -> 1687
      //   534: getstatic 257	com/getjar/sdk/data/usage/ApplicationSessionEvent$Reason:THREAD_EXIT	Lcom/getjar/sdk/data/usage/ApplicationSessionEvent$Reason;
      //   537: invokevirtual 260	com/getjar/sdk/data/usage/ApplicationSessionEvent$Reason:name	()Ljava/lang/String;
      //   540: astore 25
      //   542: aload_0
      //   543: getfield 43	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:_requestThreadExitTime	J
      //   546: lconst_0
      //   547: lcmp
      //   548: ifle +1099 -> 1647
      //   551: aload_0
      //   552: getfield 43	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:_requestThreadExitTime	J
      //   555: lstore 4
      //   557: aload_0
      //   558: lload 4
      //   560: putfield 43	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:_requestThreadExitTime	J
      //   563: aload_0
      //   564: aload 24
      //   566: lload_2
      //   567: aload_0
      //   568: getfield 43	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:_requestThreadExitTime	J
      //   571: lload 16
      //   573: lsub
      //   574: ladd
      //   575: aload 25
      //   577: invokespecial 262	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:saveSessionToDatabase	(Ljava/lang/String;JLjava/lang/String;)V
      //   580: aload_0
      //   581: getfield 76	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:usageDB	Lcom/getjar/sdk/data/usage/UsageDatabase;
      //   584: invokevirtual 265	com/getjar/sdk/data/usage/UsageDatabase:setSessionAsFinal	()V
      //   587: aload 26
      //   589: athrow
      //   590: astore 24
      //   592: getstatic 134	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
      //   595: invokevirtual 138	com/getjar/sdk/logging/Area:value	()J
      //   598: aload 24
      //   600: ldc_w 267
      //   603: iconst_0
      //   604: anewarray 45	java/lang/Object
      //   607: invokestatic 270	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   610: getstatic 134	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
      //   613: invokevirtual 138	com/getjar/sdk/logging/Area:value	()J
      //   616: ldc -54
      //   618: iconst_1
      //   619: anewarray 45	java/lang/Object
      //   622: dup
      //   623: iconst_0
      //   624: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   627: invokevirtual 209	java/lang/Thread:getId	()J
      //   630: invokestatic 215	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   633: aastore
      //   634: invokestatic 218	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   637: return
      //   638: aload 27
      //   640: astore 26
      //   642: lload 14
      //   644: lstore 18
      //   646: lload 10
      //   648: lstore 4
      //   650: aload 27
      //   652: astore 25
      //   654: lload 14
      //   656: lstore 20
      //   658: lload 10
      //   660: lstore 6
      //   662: aload 30
      //   664: astore 29
      //   666: aload 27
      //   668: astore 24
      //   670: lload 14
      //   672: lstore 16
      //   674: lload 10
      //   676: lstore_2
      //   677: invokestatic 187	java/lang/System:currentTimeMillis	()J
      //   680: lstore 8
      //   682: goto -371 -> 311
      //   685: aload 27
      //   687: astore 26
      //   689: lload 14
      //   691: lstore 18
      //   693: lload 10
      //   695: lstore 4
      //   697: aload 27
      //   699: astore 25
      //   701: lload 14
      //   703: lstore 20
      //   705: lload 10
      //   707: lstore 6
      //   709: aload 30
      //   711: astore 29
      //   713: aload 27
      //   715: astore 24
      //   717: lload 14
      //   719: lstore 16
      //   721: lload 10
      //   723: lstore_2
      //   724: aload_0
      //   725: invokespecial 220	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:getRunningPackageName	()Ljava/lang/String;
      //   728: astore 31
      //   730: aload 27
      //   732: astore 26
      //   734: lload 14
      //   736: lstore 18
      //   738: lload 10
      //   740: lstore 4
      //   742: aload 27
      //   744: astore 25
      //   746: lload 14
      //   748: lstore 20
      //   750: lload 10
      //   752: lstore 6
      //   754: aload 30
      //   756: astore 29
      //   758: aload 27
      //   760: astore 24
      //   762: lload 14
      //   764: lstore 16
      //   766: lload 10
      //   768: lstore_2
      //   769: invokestatic 187	java/lang/System:currentTimeMillis	()J
      //   772: lstore 22
      //   774: lload 22
      //   776: lload 14
      //   778: lsub
      //   779: lstore 8
      //   781: lload 10
      //   783: lstore 12
      //   785: lload 8
      //   787: lconst_0
      //   788: lcmp
      //   789: ifle +67 -> 856
      //   792: aload 27
      //   794: astore 26
      //   796: lload 14
      //   798: lstore 18
      //   800: lload 10
      //   802: lstore 4
      //   804: aload 27
      //   806: astore 25
      //   808: lload 14
      //   810: lstore 20
      //   812: lload 10
      //   814: lstore 6
      //   816: aload 30
      //   818: astore 29
      //   820: aload 27
      //   822: astore 24
      //   824: lload 14
      //   826: lstore 16
      //   828: lload 10
      //   830: lstore_2
      //   831: lload 10
      //   833: lstore 12
      //   835: lload 8
      //   837: aload_0
      //   838: getfield 95	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:currentMonitorIntervalInMilliseconds	J
      //   841: ldc2_w 271
      //   844: ladd
      //   845: lcmp
      //   846: ifge +10 -> 856
      //   849: lload 10
      //   851: lload 8
      //   853: ladd
      //   854: lstore 12
      //   856: aload 27
      //   858: astore 26
      //   860: lload 14
      //   862: lstore 18
      //   864: lload 12
      //   866: lstore 4
      //   868: aload 27
      //   870: astore 25
      //   872: lload 14
      //   874: lstore 20
      //   876: lload 12
      //   878: lstore 6
      //   880: aload 30
      //   882: astore 29
      //   884: aload 27
      //   886: astore 24
      //   888: lload 14
      //   890: lstore 16
      //   892: lload 12
      //   894: lstore_2
      //   895: aload 31
      //   897: aload 27
      //   899: invokevirtual 278	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   902: ifeq +406 -> 1308
      //   905: aload 27
      //   907: astore 26
      //   909: lload 14
      //   911: lstore 18
      //   913: lload 12
      //   915: lstore 4
      //   917: aload 27
      //   919: astore 25
      //   921: lload 14
      //   923: lstore 20
      //   925: lload 12
      //   927: lstore 6
      //   929: aload 30
      //   931: astore 29
      //   933: aload 27
      //   935: astore 24
      //   937: lload 14
      //   939: lstore 16
      //   941: lload 12
      //   943: lstore_2
      //   944: aload 27
      //   946: astore 28
      //   948: lload 12
      //   950: lstore 8
      //   952: lload 12
      //   954: aload_0
      //   955: getfield 89	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:currentMonitorTrackingIntervalInMilliseconds	J
      //   958: lcmp
      //   959: iflt +124 -> 1083
      //   962: aload 27
      //   964: astore 26
      //   966: lload 14
      //   968: lstore 18
      //   970: lload 12
      //   972: lstore 4
      //   974: aload 27
      //   976: astore 25
      //   978: lload 14
      //   980: lstore 20
      //   982: lload 12
      //   984: lstore 6
      //   986: aload 30
      //   988: astore 29
      //   990: aload 27
      //   992: astore 24
      //   994: lload 14
      //   996: lstore 16
      //   998: lload 12
      //   1000: lstore_2
      //   1001: aload_0
      //   1002: aload 27
      //   1004: lload 12
      //   1006: getstatic 281	com/getjar/sdk/data/usage/ApplicationSessionEvent$Reason:THREAD_ERROR	Lcom/getjar/sdk/data/usage/ApplicationSessionEvent$Reason;
      //   1009: invokevirtual 260	com/getjar/sdk/data/usage/ApplicationSessionEvent$Reason:name	()Ljava/lang/String;
      //   1012: invokespecial 262	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:saveSessionToDatabase	(Ljava/lang/String;JLjava/lang/String;)V
      //   1015: lconst_0
      //   1016: lstore 8
      //   1018: aload 27
      //   1020: astore 26
      //   1022: lload 14
      //   1024: lstore 18
      //   1026: lload 8
      //   1028: lstore 4
      //   1030: aload 27
      //   1032: astore 25
      //   1034: lload 14
      //   1036: lstore 20
      //   1038: lload 8
      //   1040: lstore 6
      //   1042: aload 30
      //   1044: astore 29
      //   1046: aload 27
      //   1048: astore 24
      //   1050: lload 14
      //   1052: lstore 16
      //   1054: lload 8
      //   1056: lstore_2
      //   1057: aload_0
      //   1058: aload_0
      //   1059: getfield 89	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:currentMonitorTrackingIntervalInMilliseconds	J
      //   1062: ldc2_w 282
      //   1065: lmul
      //   1066: aload_0
      //   1067: getfield 34	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:this$0	Lcom/getjar/sdk/data/usage/UsageMonitor;
      //   1070: invokestatic 286	com/getjar/sdk/data/usage/UsageMonitor:access$500	(Lcom/getjar/sdk/data/usage/UsageMonitor;)J
      //   1073: invokestatic 292	java/lang/Math:min	(JJ)J
      //   1076: putfield 89	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:currentMonitorTrackingIntervalInMilliseconds	J
      //   1079: aload 27
      //   1081: astore 28
      //   1083: lload 22
      //   1085: lstore 12
      //   1087: aload 28
      //   1089: astore 27
      //   1091: lload 12
      //   1093: lstore 14
      //   1095: lload 8
      //   1097: lstore 10
      //   1099: aload 28
      //   1101: astore 26
      //   1103: lload 12
      //   1105: lstore 18
      //   1107: lload 8
      //   1109: lstore 4
      //   1111: aload 28
      //   1113: astore 25
      //   1115: lload 12
      //   1117: lstore 20
      //   1119: lload 8
      //   1121: lstore 6
      //   1123: aload 30
      //   1125: astore 29
      //   1127: aload 28
      //   1129: astore 24
      //   1131: lload 12
      //   1133: lstore 16
      //   1135: lload 8
      //   1137: lstore_2
      //   1138: aload_0
      //   1139: getfield 39	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:_requestThreadExit	Z
      //   1142: ifne -1056 -> 86
      //   1145: aload 28
      //   1147: astore 26
      //   1149: lload 12
      //   1151: lstore 18
      //   1153: lload 8
      //   1155: lstore 4
      //   1157: aload 28
      //   1159: astore 25
      //   1161: lload 12
      //   1163: lstore 20
      //   1165: lload 8
      //   1167: lstore 6
      //   1169: aload 30
      //   1171: astore 29
      //   1173: aload 28
      //   1175: astore 24
      //   1177: lload 12
      //   1179: lstore 16
      //   1181: lload 8
      //   1183: lstore_2
      //   1184: aload_0
      //   1185: getfield 48	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:_intervalWaitMonitor	Ljava/lang/Object;
      //   1188: astore 27
      //   1190: aload 28
      //   1192: astore 26
      //   1194: lload 12
      //   1196: lstore 18
      //   1198: lload 8
      //   1200: lstore 4
      //   1202: aload 28
      //   1204: astore 25
      //   1206: lload 12
      //   1208: lstore 20
      //   1210: lload 8
      //   1212: lstore 6
      //   1214: aload 30
      //   1216: astore 29
      //   1218: aload 28
      //   1220: astore 24
      //   1222: lload 12
      //   1224: lstore 16
      //   1226: lload 8
      //   1228: lstore_2
      //   1229: aload 27
      //   1231: monitorenter
      //   1232: aload_0
      //   1233: getfield 48	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:_intervalWaitMonitor	Ljava/lang/Object;
      //   1236: aload_0
      //   1237: getfield 95	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:currentMonitorIntervalInMilliseconds	J
      //   1240: invokevirtual 295	java/lang/Object:wait	(J)V
      //   1243: aload 27
      //   1245: monitorexit
      //   1246: aload 28
      //   1248: astore 27
      //   1250: lload 12
      //   1252: lstore 14
      //   1254: lload 8
      //   1256: lstore 10
      //   1258: goto -1172 -> 86
      //   1261: astore 31
      //   1263: aload 27
      //   1265: monitorexit
      //   1266: aload 28
      //   1268: astore 26
      //   1270: lload 12
      //   1272: lstore 18
      //   1274: lload 8
      //   1276: lstore 4
      //   1278: aload 28
      //   1280: astore 25
      //   1282: lload 12
      //   1284: lstore 20
      //   1286: lload 8
      //   1288: lstore 6
      //   1290: aload 30
      //   1292: astore 29
      //   1294: aload 28
      //   1296: astore 24
      //   1298: lload 12
      //   1300: lstore 16
      //   1302: lload 8
      //   1304: lstore_2
      //   1305: aload 31
      //   1307: athrow
      //   1308: aload 27
      //   1310: astore 26
      //   1312: lload 14
      //   1314: lstore 18
      //   1316: lload 12
      //   1318: lstore 4
      //   1320: aload 27
      //   1322: astore 25
      //   1324: lload 14
      //   1326: lstore 20
      //   1328: lload 12
      //   1330: lstore 6
      //   1332: aload 30
      //   1334: astore 29
      //   1336: aload 27
      //   1338: astore 24
      //   1340: lload 14
      //   1342: lstore 16
      //   1344: lload 12
      //   1346: lstore_2
      //   1347: aload_0
      //   1348: aload 27
      //   1350: lload 12
      //   1352: getstatic 298	com/getjar/sdk/data/usage/ApplicationSessionEvent$Reason:THREAD_APP_DETECTION	Lcom/getjar/sdk/data/usage/ApplicationSessionEvent$Reason;
      //   1355: invokevirtual 260	com/getjar/sdk/data/usage/ApplicationSessionEvent$Reason:name	()Ljava/lang/String;
      //   1358: invokespecial 262	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:saveSessionToDatabase	(Ljava/lang/String;JLjava/lang/String;)V
      //   1361: lconst_0
      //   1362: lstore 10
      //   1364: aload 27
      //   1366: astore 26
      //   1368: lload 14
      //   1370: lstore 18
      //   1372: lload 10
      //   1374: lstore 4
      //   1376: aload 27
      //   1378: astore 25
      //   1380: lload 14
      //   1382: lstore 20
      //   1384: lload 10
      //   1386: lstore 6
      //   1388: aload 30
      //   1390: astore 29
      //   1392: aload 27
      //   1394: astore 24
      //   1396: lload 14
      //   1398: lstore 16
      //   1400: lload 10
      //   1402: lstore_2
      //   1403: aload_0
      //   1404: aload_0
      //   1405: getfield 52	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:minMonitorTrackingIntervalInMilliseconds	J
      //   1408: putfield 89	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:currentMonitorTrackingIntervalInMilliseconds	J
      //   1411: aload 31
      //   1413: astore 27
      //   1415: aload 27
      //   1417: astore 26
      //   1419: lload 14
      //   1421: lstore 18
      //   1423: lload 10
      //   1425: lstore 4
      //   1427: aload 27
      //   1429: astore 25
      //   1431: lload 14
      //   1433: lstore 20
      //   1435: lload 10
      //   1437: lstore 6
      //   1439: aload 30
      //   1441: astore 29
      //   1443: aload 27
      //   1445: astore 24
      //   1447: lload 14
      //   1449: lstore 16
      //   1451: lload 10
      //   1453: lstore_2
      //   1454: aload 27
      //   1456: astore 28
      //   1458: lload 10
      //   1460: lstore 8
      //   1462: aload_0
      //   1463: getfield 87	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:appSessionInfo	Ljava/util/Map;
      //   1466: aload 31
      //   1468: invokeinterface 301 2 0
      //   1473: ifne -390 -> 1083
      //   1476: aload 27
      //   1478: astore 26
      //   1480: lload 14
      //   1482: lstore 18
      //   1484: lload 10
      //   1486: lstore 4
      //   1488: aload 27
      //   1490: astore 25
      //   1492: lload 14
      //   1494: lstore 20
      //   1496: lload 10
      //   1498: lstore 6
      //   1500: aload 30
      //   1502: astore 29
      //   1504: aload 27
      //   1506: astore 24
      //   1508: lload 14
      //   1510: lstore 16
      //   1512: lload 10
      //   1514: lstore_2
      //   1515: aload_0
      //   1516: getfield 87	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:appSessionInfo	Ljava/util/Map;
      //   1519: aload 31
      //   1521: new 9	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread$SessionInfo
      //   1524: dup
      //   1525: aload_0
      //   1526: aload 31
      //   1528: lload 22
      //   1530: invokespecial 223	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread$SessionInfo:<init>	(Lcom/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread;Ljava/lang/String;J)V
      //   1533: invokeinterface 227 3 0
      //   1538: pop
      //   1539: aload 27
      //   1541: astore 28
      //   1543: lload 10
      //   1545: lstore 8
      //   1547: goto -464 -> 1083
      //   1550: iconst_0
      //   1551: ifne +83 -> 1634
      //   1554: getstatic 257	com/getjar/sdk/data/usage/ApplicationSessionEvent$Reason:THREAD_EXIT	Lcom/getjar/sdk/data/usage/ApplicationSessionEvent$Reason;
      //   1557: invokevirtual 260	com/getjar/sdk/data/usage/ApplicationSessionEvent$Reason:name	()Ljava/lang/String;
      //   1560: astore 24
      //   1562: aload_0
      //   1563: getfield 43	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:_requestThreadExitTime	J
      //   1566: lconst_0
      //   1567: lcmp
      //   1568: ifle +72 -> 1640
      //   1571: aload_0
      //   1572: getfield 43	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:_requestThreadExitTime	J
      //   1575: lstore_2
      //   1576: aload_0
      //   1577: lload_2
      //   1578: putfield 43	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:_requestThreadExitTime	J
      //   1581: aload_0
      //   1582: aload 27
      //   1584: lload 10
      //   1586: aload_0
      //   1587: getfield 43	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:_requestThreadExitTime	J
      //   1590: lload 14
      //   1592: lsub
      //   1593: ladd
      //   1594: aload 24
      //   1596: invokespecial 262	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:saveSessionToDatabase	(Ljava/lang/String;JLjava/lang/String;)V
      //   1599: aload_0
      //   1600: getfield 76	com/getjar/sdk/data/usage/UsageMonitor$UsageMonitoringThread:usageDB	Lcom/getjar/sdk/data/usage/UsageDatabase;
      //   1603: invokevirtual 265	com/getjar/sdk/data/usage/UsageDatabase:setSessionAsFinal	()V
      //   1606: getstatic 134	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
      //   1609: invokevirtual 138	com/getjar/sdk/logging/Area:value	()J
      //   1612: ldc -54
      //   1614: iconst_1
      //   1615: anewarray 45	java/lang/Object
      //   1618: dup
      //   1619: iconst_0
      //   1620: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   1623: invokevirtual 209	java/lang/Thread:getId	()J
      //   1626: invokestatic 215	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   1629: aastore
      //   1630: invokestatic 218	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   1633: return
      //   1634: aconst_null
      //   1635: astore 24
      //   1637: goto -75 -> 1562
      //   1640: invokestatic 187	java/lang/System:currentTimeMillis	()J
      //   1643: lstore_2
      //   1644: goto -68 -> 1576
      //   1647: invokestatic 187	java/lang/System:currentTimeMillis	()J
      //   1650: lstore 4
      //   1652: goto -1095 -> 557
      //   1655: astore 24
      //   1657: getstatic 134	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
      //   1660: invokevirtual 138	com/getjar/sdk/logging/Area:value	()J
      //   1663: ldc -54
      //   1665: iconst_1
      //   1666: anewarray 45	java/lang/Object
      //   1669: dup
      //   1670: iconst_0
      //   1671: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   1674: invokevirtual 209	java/lang/Thread:getId	()J
      //   1677: invokestatic 215	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   1680: aastore
      //   1681: invokestatic 218	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   1684: aload 24
      //   1686: athrow
      //   1687: aload 29
      //   1689: astore 25
      //   1691: goto -1149 -> 542
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1694	0	this	UsageMonitoringThread
      //   12	107	1	bool	boolean
      //   112	1532	2	l1	long
      //   132	1519	4	l2	long
      //   96	1403	6	l3	long
      //   309	1237	8	l4	long
      //   81	1504	10	l5	long
      //   783	568	12	l6	long
      //   54	1537	14	l7	long
      //   108	1403	16	l8	long
      //   128	1355	18	l9	long
      //   92	1403	20	l10	long
      //   772	757	22	l11	long
      //   104	283	24	localObject1	Object
      //   413	1	24	localInterruptedException	InterruptedException
      //   433	132	24	localObject2	Object
      //   590	9	24	localException1	Exception
      //   668	968	24	localObject3	Object
      //   1655	30	24	localObject4	Object
      //   88	1602	25	localObject5	Object
      //   124	386	26	localObject6	Object
      //   527	61	26	localObject7	Object
      //   640	839	26	localObject8	Object
      //   49	421	27	localObject9	Object
      //   482	598	27	localException2	Exception
      //   1089	494	27	localObject10	Object
      //   946	596	28	localObject11	Object
      //   100	1588	29	localObject12	Object
      //   84	1417	30	localObject13	Object
      //   728	168	31	str	String
      //   1261	266	31	localObject14	Object
      // Exception table:
      //   from	to	target	type
      //   161	174	413	java/lang/InterruptedException
      //   213	218	413	java/lang/InterruptedException
      //   257	266	413	java/lang/InterruptedException
      //   305	311	413	java/lang/InterruptedException
      //   350	356	413	java/lang/InterruptedException
      //   395	410	413	java/lang/InterruptedException
      //   677	682	413	java/lang/InterruptedException
      //   724	730	413	java/lang/InterruptedException
      //   769	774	413	java/lang/InterruptedException
      //   835	849	413	java/lang/InterruptedException
      //   895	905	413	java/lang/InterruptedException
      //   952	962	413	java/lang/InterruptedException
      //   1001	1015	413	java/lang/InterruptedException
      //   1057	1079	413	java/lang/InterruptedException
      //   1138	1145	413	java/lang/InterruptedException
      //   1184	1190	413	java/lang/InterruptedException
      //   1229	1232	413	java/lang/InterruptedException
      //   1305	1308	413	java/lang/InterruptedException
      //   1347	1361	413	java/lang/InterruptedException
      //   1403	1411	413	java/lang/InterruptedException
      //   1462	1476	413	java/lang/InterruptedException
      //   1515	1539	413	java/lang/InterruptedException
      //   113	118	482	java/lang/Exception
      //   161	174	482	java/lang/Exception
      //   213	218	482	java/lang/Exception
      //   257	266	482	java/lang/Exception
      //   305	311	482	java/lang/Exception
      //   350	356	482	java/lang/Exception
      //   395	410	482	java/lang/Exception
      //   442	467	482	java/lang/Exception
      //   677	682	482	java/lang/Exception
      //   724	730	482	java/lang/Exception
      //   769	774	482	java/lang/Exception
      //   835	849	482	java/lang/Exception
      //   895	905	482	java/lang/Exception
      //   952	962	482	java/lang/Exception
      //   1001	1015	482	java/lang/Exception
      //   1057	1079	482	java/lang/Exception
      //   1138	1145	482	java/lang/Exception
      //   1184	1190	482	java/lang/Exception
      //   1229	1232	482	java/lang/Exception
      //   1305	1308	482	java/lang/Exception
      //   1347	1361	482	java/lang/Exception
      //   1403	1411	482	java/lang/Exception
      //   1462	1476	482	java/lang/Exception
      //   1515	1539	482	java/lang/Exception
      //   113	118	527	finally
      //   161	174	527	finally
      //   213	218	527	finally
      //   257	266	527	finally
      //   305	311	527	finally
      //   350	356	527	finally
      //   395	410	527	finally
      //   442	467	527	finally
      //   499	509	527	finally
      //   524	527	527	finally
      //   677	682	527	finally
      //   724	730	527	finally
      //   769	774	527	finally
      //   835	849	527	finally
      //   895	905	527	finally
      //   952	962	527	finally
      //   1001	1015	527	finally
      //   1057	1079	527	finally
      //   1138	1145	527	finally
      //   1184	1190	527	finally
      //   1229	1232	527	finally
      //   1305	1308	527	finally
      //   1347	1361	527	finally
      //   1403	1411	527	finally
      //   1462	1476	527	finally
      //   1515	1539	527	finally
      //   0	13	590	java/lang/Exception
      //   45	80	590	java/lang/Exception
      //   534	542	590	java/lang/Exception
      //   542	557	590	java/lang/Exception
      //   557	590	590	java/lang/Exception
      //   1554	1562	590	java/lang/Exception
      //   1562	1576	590	java/lang/Exception
      //   1576	1606	590	java/lang/Exception
      //   1640	1644	590	java/lang/Exception
      //   1647	1652	590	java/lang/Exception
      //   1232	1246	1261	finally
      //   1263	1266	1261	finally
      //   0	13	1655	finally
      //   45	80	1655	finally
      //   534	542	1655	finally
      //   542	557	1655	finally
      //   557	590	1655	finally
      //   592	610	1655	finally
      //   1554	1562	1655	finally
      //   1562	1576	1655	finally
      //   1576	1606	1655	finally
      //   1640	1644	1655	finally
      //   1647	1652	1655	finally
    }
    
    public void setMonitorIntervalInMilliseconds(long paramLong)
    {
      if ((paramLong > 0L) && (paramLong < this.currentMonitorIntervalInMilliseconds)) {
        this.currentMonitorIntervalInMilliseconds = paramLong;
      }
    }
    
    public void setMonitorTrackingIntervalInMilliseconds(long paramLong)
    {
      if ((paramLong > 0L) && (paramLong < this.minMonitorTrackingIntervalInMilliseconds))
      {
        this.minMonitorTrackingIntervalInMilliseconds = paramLong;
        this.currentMonitorTrackingIntervalInMilliseconds = paramLong;
      }
    }
    
    private class SessionInfo
    {
      private long duration;
      private long rowId;
      private final boolean shouldFilter;
      private final long startTimestamp;
      
      SessionInfo(String paramString, long paramLong)
      {
        this.startTimestamp = paramLong;
        this.duration = 0L;
        this.rowId = -1L;
        this.shouldFilter = UsageManager.getInstance(UsageMonitor.this._context).shouldFilterFromUsage(paramString);
      }
      
      public void addDuration(long paramLong)
      {
        if (paramLong > 0L) {
          this.duration += paramLong;
        }
      }
      
      public long getDuration()
      {
        return this.duration;
      }
      
      public long getRowId()
      {
        return this.rowId;
      }
      
      public boolean getShouldFilter()
      {
        return this.shouldFilter;
      }
      
      public long getStartTimestamp()
      {
        return this.startTimestamp;
      }
      
      public void setRowId(long paramLong)
      {
        this.rowId = paramLong;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/usage/UsageMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */