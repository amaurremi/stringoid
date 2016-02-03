package com.google.analytics.tracking.android;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

public class GAServiceManager
  implements ServiceManager
{
  private static final int MSG_KEY = 1;
  private static final Object MSG_OBJECT = new Object();
  private static GAServiceManager instance;
  private Context ctx;
  private int dispatchPeriodInSeconds = 1800;
  private Handler handler;
  private AnalyticsStoreStateListener listener = new AnalyticsStoreStateListener()
  {
    public void reportStoreIsEmpty(boolean paramAnonymousBoolean)
    {
      GAServiceManager.this.updatePowerSaveMode(paramAnonymousBoolean);
    }
  };
  private boolean pendingDispatch = true;
  private boolean powerSaveMode = false;
  private AnalyticsStore store;
  private volatile AnalyticsThread thread;
  
  private GAServiceManager() {}
  
  GAServiceManager(Context paramContext, AnalyticsThread paramAnalyticsThread, AnalyticsStore paramAnalyticsStore)
  {
    this.store = paramAnalyticsStore;
    this.thread = paramAnalyticsThread;
    initialize(paramContext, paramAnalyticsThread);
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
          GAServiceManager.this.dispatch();
          GAUsage.getInstance().setDisableUsage(false);
          if ((GAServiceManager.this.dispatchPeriodInSeconds > 0) && (!GAServiceManager.this.powerSaveMode)) {
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
  
  /* Error */
  public void dispatch()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 55	com/google/analytics/tracking/android/GAServiceManager:thread	Lcom/google/analytics/tracking/android/AnalyticsThread;
    //   6: ifnonnull +17 -> 23
    //   9: ldc 100
    //   11: invokestatic 106	com/google/analytics/tracking/android/Log:w	(Ljava/lang/String;)I
    //   14: pop
    //   15: aload_0
    //   16: iconst_1
    //   17: putfield 43	com/google/analytics/tracking/android/GAServiceManager:pendingDispatch	Z
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: invokestatic 111	com/google/analytics/tracking/android/GAUsage:getInstance	()Lcom/google/analytics/tracking/android/GAUsage;
    //   26: getstatic 117	com/google/analytics/tracking/android/GAUsage$Field:DISPATCH	Lcom/google/analytics/tracking/android/GAUsage$Field;
    //   29: invokevirtual 121	com/google/analytics/tracking/android/GAUsage:setUsage	(Lcom/google/analytics/tracking/android/GAUsage$Field;)V
    //   32: aload_0
    //   33: getfield 55	com/google/analytics/tracking/android/GAServiceManager:thread	Lcom/google/analytics/tracking/android/AnalyticsThread;
    //   36: invokeinterface 125 1 0
    //   41: goto -21 -> 20
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	GAServiceManager
    //   44	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	44	finally
    //   23	41	44	finally
  }
  
  AnalyticsStoreStateListener getListener()
  {
    return this.listener;
  }
  
  AnalyticsStore getStore()
  {
    try
    {
      if (this.store != null) {
        break label50;
      }
      if (this.ctx == null) {
        throw new IllegalStateException("Cant get a store unless we have a context");
      }
    }
    finally {}
    this.store = new PersistentAnalyticsStore(this.listener, this.ctx);
    label50:
    if (this.handler == null) {
      initializeHandler();
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
    //   3: getfield 79	com/google/analytics/tracking/android/GAServiceManager:ctx	Landroid/content/Context;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 147	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   19: putfield 79	com/google/analytics/tracking/android/GAServiceManager:ctx	Landroid/content/Context;
    //   22: aload_0
    //   23: getfield 55	com/google/analytics/tracking/android/GAServiceManager:thread	Lcom/google/analytics/tracking/android/AnalyticsThread;
    //   26: ifnonnull -15 -> 11
    //   29: aload_0
    //   30: aload_2
    //   31: putfield 55	com/google/analytics/tracking/android/GAServiceManager:thread	Lcom/google/analytics/tracking/android/AnalyticsThread;
    //   34: aload_0
    //   35: getfield 43	com/google/analytics/tracking/android/GAServiceManager:pendingDispatch	Z
    //   38: ifeq -27 -> 11
    //   41: aload_2
    //   42: invokeinterface 125 1 0
    //   47: goto -36 -> 11
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	GAServiceManager
    //   0	55	1	paramContext	Context
    //   0	55	2	paramAnalyticsThread	AnalyticsThread
    //   6	2	3	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	7	50	finally
    //   14	47	50	finally
  }
  
  /* Error */
  public void setDispatchPeriod(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 69	com/google/analytics/tracking/android/GAServiceManager:handler	Landroid/os/Handler;
    //   6: ifnonnull +17 -> 23
    //   9: ldc -105
    //   11: invokestatic 106	com/google/analytics/tracking/android/Log:w	(Ljava/lang/String;)I
    //   14: pop
    //   15: aload_0
    //   16: iload_1
    //   17: putfield 41	com/google/analytics/tracking/android/GAServiceManager:dispatchPeriodInSeconds	I
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: invokestatic 111	com/google/analytics/tracking/android/GAUsage:getInstance	()Lcom/google/analytics/tracking/android/GAUsage;
    //   26: getstatic 154	com/google/analytics/tracking/android/GAUsage$Field:SET_DISPATCH_PERIOD	Lcom/google/analytics/tracking/android/GAUsage$Field;
    //   29: invokevirtual 121	com/google/analytics/tracking/android/GAUsage:setUsage	(Lcom/google/analytics/tracking/android/GAUsage$Field;)V
    //   32: aload_0
    //   33: getfield 50	com/google/analytics/tracking/android/GAServiceManager:powerSaveMode	Z
    //   36: ifne +21 -> 57
    //   39: aload_0
    //   40: getfield 41	com/google/analytics/tracking/android/GAServiceManager:dispatchPeriodInSeconds	I
    //   43: ifle +14 -> 57
    //   46: aload_0
    //   47: getfield 69	com/google/analytics/tracking/android/GAServiceManager:handler	Landroid/os/Handler;
    //   50: iconst_1
    //   51: getstatic 38	com/google/analytics/tracking/android/GAServiceManager:MSG_OBJECT	Ljava/lang/Object;
    //   54: invokevirtual 158	android/os/Handler:removeMessages	(ILjava/lang/Object;)V
    //   57: aload_0
    //   58: iload_1
    //   59: putfield 41	com/google/analytics/tracking/android/GAServiceManager:dispatchPeriodInSeconds	I
    //   62: iload_1
    //   63: ifle -43 -> 20
    //   66: aload_0
    //   67: getfield 50	com/google/analytics/tracking/android/GAServiceManager:powerSaveMode	Z
    //   70: ifne -50 -> 20
    //   73: aload_0
    //   74: getfield 69	com/google/analytics/tracking/android/GAServiceManager:handler	Landroid/os/Handler;
    //   77: aload_0
    //   78: getfield 69	com/google/analytics/tracking/android/GAServiceManager:handler	Landroid/os/Handler;
    //   81: iconst_1
    //   82: getstatic 38	com/google/analytics/tracking/android/GAServiceManager:MSG_OBJECT	Ljava/lang/Object;
    //   85: invokevirtual 93	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   88: iload_1
    //   89: sipush 1000
    //   92: imul
    //   93: i2l
    //   94: invokevirtual 97	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   97: pop
    //   98: goto -78 -> 20
    //   101: astore_2
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_2
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	GAServiceManager
    //   0	106	1	paramInt	int
    //   101	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	101	finally
    //   23	57	101	finally
    //   57	62	101	finally
    //   66	98	101	finally
  }
  
  void setThrottlingEnabled(boolean paramBoolean)
  {
    this.store.setThrottlingEnabled(paramBoolean);
  }
  
  void updatePowerSaveMode(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.powerSaveMode;
        if (bool == paramBoolean) {
          return;
        }
        if ((paramBoolean) && (this.dispatchPeriodInSeconds > 0)) {
          this.handler.removeMessages(1, MSG_OBJECT);
        }
        if ((!paramBoolean) && (this.dispatchPeriodInSeconds > 0)) {
          this.handler.sendMessageDelayed(this.handler.obtainMessage(1, MSG_OBJECT), this.dispatchPeriodInSeconds * 1000);
        }
        StringBuilder localStringBuilder = new StringBuilder().append("PowerSaveMode ");
        if (paramBoolean)
        {
          String str1 = "initiated.";
          Log.iDebug(str1);
          this.powerSaveMode = paramBoolean;
        }
        else
        {
          String str2 = "terminated.";
        }
      }
      finally {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/analytics/tracking/android/GAServiceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */