package com.google.analytics.tracking.android;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.google.android.gms.common.util.VisibleForTesting;

public class GAServiceManager
  extends ServiceManager
{
  private static final int MSG_KEY = 1;
  private static final Object MSG_OBJECT = new Object();
  private static GAServiceManager instance;
  private boolean connected = true;
  private Context ctx;
  private int dispatchPeriodInSeconds = 1800;
  private Handler handler;
  private boolean listenForNetwork = true;
  private AnalyticsStoreStateListener listener = new AnalyticsStoreStateListener()
  {
    public void reportStoreIsEmpty(boolean paramAnonymousBoolean)
    {
      GAServiceManager.this.updatePowerSaveMode(paramAnonymousBoolean, GAServiceManager.this.connected);
    }
  };
  private GANetworkReceiver networkReceiver;
  private boolean pendingDispatch = true;
  private boolean pendingForceLocalDispatch;
  private String pendingHostOverride;
  private AnalyticsStore store;
  private boolean storeIsEmpty = false;
  private volatile AnalyticsThread thread;
  
  private GAServiceManager() {}
  
  @VisibleForTesting
  GAServiceManager(Context paramContext, AnalyticsThread paramAnalyticsThread, AnalyticsStore paramAnalyticsStore, boolean paramBoolean)
  {
    this.store = paramAnalyticsStore;
    this.thread = paramAnalyticsThread;
    this.listenForNetwork = paramBoolean;
    initialize(paramContext, paramAnalyticsThread);
  }
  
  @VisibleForTesting
  static void clearInstance()
  {
    instance = null;
  }
  
  public static GAServiceManager getInstance()
  {
    if (instance == null) {
      instance = new GAServiceManager();
    }
    return instance;
  }
  
  private void initializeHandler()
  {
    this.handler = new Handler(this.ctx.getMainLooper(), new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        if ((1 == paramAnonymousMessage.what) && (GAServiceManager.MSG_OBJECT.equals(paramAnonymousMessage.obj)))
        {
          GAUsage.getInstance().setDisableUsage(true);
          GAServiceManager.this.dispatchLocalHits();
          GAUsage.getInstance().setDisableUsage(false);
          if ((GAServiceManager.this.dispatchPeriodInSeconds > 0) && (!GAServiceManager.this.storeIsEmpty)) {
            GAServiceManager.this.handler.sendMessageDelayed(GAServiceManager.this.handler.obtainMessage(1, GAServiceManager.MSG_OBJECT), GAServiceManager.this.dispatchPeriodInSeconds * 1000);
          }
        }
        return true;
      }
    });
    if (this.dispatchPeriodInSeconds > 0) {
      this.handler.sendMessageDelayed(this.handler.obtainMessage(1, MSG_OBJECT), this.dispatchPeriodInSeconds * 1000);
    }
  }
  
  private void initializeNetworkReceiver()
  {
    this.networkReceiver = new GANetworkReceiver(this);
    this.networkReceiver.register(this.ctx);
  }
  
  /* Error */
  @Deprecated
  public void dispatchLocalHits()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 68	com/google/analytics/tracking/android/GAServiceManager:thread	Lcom/google/analytics/tracking/android/AnalyticsThread;
    //   6: ifnonnull +16 -> 22
    //   9: ldc -127
    //   11: invokestatic 135	com/google/analytics/tracking/android/Log:v	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 51	com/google/analytics/tracking/android/GAServiceManager:pendingDispatch	Z
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 140	com/google/analytics/tracking/android/GAUsage:getInstance	()Lcom/google/analytics/tracking/android/GAUsage;
    //   25: getstatic 146	com/google/analytics/tracking/android/GAUsage$Field:DISPATCH	Lcom/google/analytics/tracking/android/GAUsage$Field;
    //   28: invokevirtual 150	com/google/analytics/tracking/android/GAUsage:setUsage	(Lcom/google/analytics/tracking/android/GAUsage$Field;)V
    //   31: aload_0
    //   32: getfield 68	com/google/analytics/tracking/android/GAServiceManager:thread	Lcom/google/analytics/tracking/android/AnalyticsThread;
    //   35: invokeinterface 155 1 0
    //   40: goto -21 -> 19
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	GAServiceManager
    //   43	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	43	finally
    //   22	40	43	finally
  }
  
  @VisibleForTesting
  AnalyticsStoreStateListener getListener()
  {
    return this.listener;
  }
  
  AnalyticsStore getStore()
  {
    try
    {
      if (this.store != null) {
        break label80;
      }
      if (this.ctx == null) {
        throw new IllegalStateException("Cant get a store unless we have a context");
      }
    }
    finally {}
    this.store = new PersistentAnalyticsStore(this.listener, this.ctx);
    if (this.pendingHostOverride != null)
    {
      this.store.getDispatcher().overrideHostUrl(this.pendingHostOverride);
      this.pendingHostOverride = null;
    }
    label80:
    if (this.handler == null) {
      initializeHandler();
    }
    if ((this.networkReceiver == null) && (this.listenForNetwork)) {
      initializeNetworkReceiver();
    }
    AnalyticsStore localAnalyticsStore = this.store;
    return localAnalyticsStore;
  }
  
  /* Error */
  void initialize(Context paramContext, AnalyticsThread paramAnalyticsThread)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 95	com/google/analytics/tracking/android/GAServiceManager:ctx	Landroid/content/Context;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 192	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   19: putfield 95	com/google/analytics/tracking/android/GAServiceManager:ctx	Landroid/content/Context;
    //   22: aload_0
    //   23: getfield 68	com/google/analytics/tracking/android/GAServiceManager:thread	Lcom/google/analytics/tracking/android/AnalyticsThread;
    //   26: ifnonnull -15 -> 11
    //   29: aload_0
    //   30: aload_2
    //   31: putfield 68	com/google/analytics/tracking/android/GAServiceManager:thread	Lcom/google/analytics/tracking/android/AnalyticsThread;
    //   34: aload_0
    //   35: getfield 51	com/google/analytics/tracking/android/GAServiceManager:pendingDispatch	Z
    //   38: ifeq +12 -> 50
    //   41: aload_0
    //   42: invokevirtual 194	com/google/analytics/tracking/android/GAServiceManager:dispatchLocalHits	()V
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 51	com/google/analytics/tracking/android/GAServiceManager:pendingDispatch	Z
    //   50: aload_0
    //   51: getfield 196	com/google/analytics/tracking/android/GAServiceManager:pendingForceLocalDispatch	Z
    //   54: ifeq -43 -> 11
    //   57: aload_0
    //   58: invokevirtual 199	com/google/analytics/tracking/android/GAServiceManager:setForceLocalDispatch	()V
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield 196	com/google/analytics/tracking/android/GAServiceManager:pendingForceLocalDispatch	Z
    //   66: goto -55 -> 11
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	GAServiceManager
    //   0	74	1	paramContext	Context
    //   0	74	2	paramAnalyticsThread	AnalyticsThread
    //   6	2	3	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	7	69	finally
    //   14	50	69	finally
    //   50	66	69	finally
  }
  
  void onRadioPowered()
  {
    try
    {
      if ((!this.storeIsEmpty) && (this.connected) && (this.dispatchPeriodInSeconds > 0))
      {
        this.handler.removeMessages(1, MSG_OBJECT);
        this.handler.sendMessage(this.handler.obtainMessage(1, MSG_OBJECT));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  @VisibleForTesting
  void overrideHostUrl(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 66	com/google/analytics/tracking/android/GAServiceManager:store	Lcom/google/analytics/tracking/android/AnalyticsStore;
    //   6: ifnonnull +11 -> 17
    //   9: aload_0
    //   10: aload_1
    //   11: putfield 173	com/google/analytics/tracking/android/GAServiceManager:pendingHostOverride	Ljava/lang/String;
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 66	com/google/analytics/tracking/android/GAServiceManager:store	Lcom/google/analytics/tracking/android/AnalyticsStore;
    //   21: invokeinterface 179 1 0
    //   26: aload_1
    //   27: invokeinterface 184 2 0
    //   32: goto -18 -> 14
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	GAServiceManager
    //   0	40	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	14	35	finally
    //   17	32	35	finally
  }
  
  @Deprecated
  public void setForceLocalDispatch()
  {
    if (this.thread == null)
    {
      Log.v("setForceLocalDispatch() queued. It will be called once initialization is complete.");
      this.pendingForceLocalDispatch = true;
      return;
    }
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_FORCE_LOCAL_DISPATCH);
    this.thread.setForceLocalDispatch();
  }
  
  /* Error */
  @Deprecated
  public void setLocalDispatchPeriod(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 84	com/google/analytics/tracking/android/GAServiceManager:handler	Landroid/os/Handler;
    //   6: ifnonnull +16 -> 22
    //   9: ldc -38
    //   11: invokestatic 135	com/google/analytics/tracking/android/Log:v	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iload_1
    //   16: putfield 49	com/google/analytics/tracking/android/GAServiceManager:dispatchPeriodInSeconds	I
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 140	com/google/analytics/tracking/android/GAUsage:getInstance	()Lcom/google/analytics/tracking/android/GAUsage;
    //   25: getstatic 221	com/google/analytics/tracking/android/GAUsage$Field:SET_DISPATCH_PERIOD	Lcom/google/analytics/tracking/android/GAUsage$Field;
    //   28: invokevirtual 150	com/google/analytics/tracking/android/GAUsage:setUsage	(Lcom/google/analytics/tracking/android/GAUsage$Field;)V
    //   31: aload_0
    //   32: getfield 62	com/google/analytics/tracking/android/GAServiceManager:storeIsEmpty	Z
    //   35: ifne +28 -> 63
    //   38: aload_0
    //   39: getfield 53	com/google/analytics/tracking/android/GAServiceManager:connected	Z
    //   42: ifeq +21 -> 63
    //   45: aload_0
    //   46: getfield 49	com/google/analytics/tracking/android/GAServiceManager:dispatchPeriodInSeconds	I
    //   49: ifle +14 -> 63
    //   52: aload_0
    //   53: getfield 84	com/google/analytics/tracking/android/GAServiceManager:handler	Landroid/os/Handler;
    //   56: iconst_1
    //   57: getstatic 45	com/google/analytics/tracking/android/GAServiceManager:MSG_OBJECT	Ljava/lang/Object;
    //   60: invokevirtual 204	android/os/Handler:removeMessages	(ILjava/lang/Object;)V
    //   63: aload_0
    //   64: iload_1
    //   65: putfield 49	com/google/analytics/tracking/android/GAServiceManager:dispatchPeriodInSeconds	I
    //   68: iload_1
    //   69: ifle -50 -> 19
    //   72: aload_0
    //   73: getfield 62	com/google/analytics/tracking/android/GAServiceManager:storeIsEmpty	Z
    //   76: ifne -57 -> 19
    //   79: aload_0
    //   80: getfield 53	com/google/analytics/tracking/android/GAServiceManager:connected	Z
    //   83: ifeq -64 -> 19
    //   86: aload_0
    //   87: getfield 84	com/google/analytics/tracking/android/GAServiceManager:handler	Landroid/os/Handler;
    //   90: aload_0
    //   91: getfield 84	com/google/analytics/tracking/android/GAServiceManager:handler	Landroid/os/Handler;
    //   94: iconst_1
    //   95: getstatic 45	com/google/analytics/tracking/android/GAServiceManager:MSG_OBJECT	Ljava/lang/Object;
    //   98: invokevirtual 109	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   101: iload_1
    //   102: sipush 1000
    //   105: imul
    //   106: i2l
    //   107: invokevirtual 113	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   110: pop
    //   111: goto -92 -> 19
    //   114: astore_2
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_2
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	GAServiceManager
    //   0	119	1	paramInt	int
    //   114	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	114	finally
    //   22	63	114	finally
    //   63	68	114	finally
    //   72	111	114	finally
  }
  
  void updateConnectivityStatus(boolean paramBoolean)
  {
    try
    {
      updatePowerSaveMode(this.storeIsEmpty, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @VisibleForTesting
  void updatePowerSaveMode(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      String str1;
      try
      {
        if (this.storeIsEmpty == paramBoolean1)
        {
          boolean bool = this.connected;
          if (bool == paramBoolean2) {
            return;
          }
        }
        if (((paramBoolean1) || (!paramBoolean2)) && (this.dispatchPeriodInSeconds > 0)) {
          this.handler.removeMessages(1, MSG_OBJECT);
        }
        if ((!paramBoolean1) && (paramBoolean2) && (this.dispatchPeriodInSeconds > 0)) {
          this.handler.sendMessageDelayed(this.handler.obtainMessage(1, MSG_OBJECT), this.dispatchPeriodInSeconds * 1000);
        }
        localStringBuilder = new StringBuilder().append("PowerSaveMode ");
        if (paramBoolean1) {
          break label157;
        }
        if (paramBoolean2) {
          break label150;
        }
      }
      finally {}
      Log.v(str1);
      this.storeIsEmpty = paramBoolean1;
      this.connected = paramBoolean2;
      continue;
      label150:
      String str2 = "terminated.";
      continue;
      label157:
      str2 = "initiated.";
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/analytics/tracking/android/GAServiceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */