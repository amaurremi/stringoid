package com.google.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.google.android.gms.common.util.VisibleForTesting;

class ServiceManagerImpl
  extends ServiceManager
{
  private static final int MSG_KEY = 1;
  private static final Object MSG_OBJECT = new Object();
  private static ServiceManagerImpl instance;
  private boolean connected = true;
  private Context ctx;
  private int dispatchPeriodInSeconds = 1800;
  private Handler handler;
  private boolean listenForNetwork = true;
  private HitStoreStateListener listener = new HitStoreStateListener()
  {
    public void reportStoreIsEmpty(boolean paramAnonymousBoolean)
    {
      ServiceManagerImpl.this.updatePowerSaveMode(paramAnonymousBoolean, ServiceManagerImpl.this.connected);
    }
  };
  private NetworkReceiver networkReceiver;
  private boolean pendingDispatch = true;
  private boolean readyToDispatch = false;
  private HitStore store;
  private boolean storeIsEmpty = false;
  private volatile HitSendingThread thread;
  
  private ServiceManagerImpl() {}
  
  @VisibleForTesting
  ServiceManagerImpl(Context paramContext, HitSendingThread paramHitSendingThread, HitStore paramHitStore, boolean paramBoolean)
  {
    this.store = paramHitStore;
    this.thread = paramHitSendingThread;
    this.listenForNetwork = paramBoolean;
    initialize(paramContext, paramHitSendingThread);
  }
  
  @VisibleForTesting
  static void clearInstance()
  {
    instance = null;
  }
  
  public static ServiceManagerImpl getInstance()
  {
    if (instance == null) {
      instance = new ServiceManagerImpl();
    }
    return instance;
  }
  
  private void initializeHandler()
  {
    this.handler = new Handler(this.ctx.getMainLooper(), new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        if ((1 == paramAnonymousMessage.what) && (ServiceManagerImpl.MSG_OBJECT.equals(paramAnonymousMessage.obj)))
        {
          ServiceManagerImpl.this.dispatch();
          if ((ServiceManagerImpl.this.dispatchPeriodInSeconds > 0) && (!ServiceManagerImpl.this.storeIsEmpty)) {
            ServiceManagerImpl.this.handler.sendMessageDelayed(ServiceManagerImpl.this.handler.obtainMessage(1, ServiceManagerImpl.MSG_OBJECT), ServiceManagerImpl.this.dispatchPeriodInSeconds * 1000);
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
    this.networkReceiver = new NetworkReceiver(this);
    this.networkReceiver.register(this.ctx);
  }
  
  /* Error */
  public void dispatch()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 53	com/google/tagmanager/ServiceManagerImpl:readyToDispatch	Z
    //   6: ifne +16 -> 22
    //   9: ldc -124
    //   11: invokestatic 138	com/google/tagmanager/Log:v	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 51	com/google/tagmanager/ServiceManagerImpl:pendingDispatch	Z
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 70	com/google/tagmanager/ServiceManagerImpl:thread	Lcom/google/tagmanager/HitSendingThread;
    //   26: new 10	com/google/tagmanager/ServiceManagerImpl$3
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 139	com/google/tagmanager/ServiceManagerImpl$3:<init>	(Lcom/google/tagmanager/ServiceManagerImpl;)V
    //   34: invokeinterface 145 2 0
    //   39: goto -20 -> 19
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	ServiceManagerImpl
    //   42	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	42	finally
    //   22	39	42	finally
  }
  
  @VisibleForTesting
  HitStoreStateListener getListener()
  {
    return this.listener;
  }
  
  HitStore getStore()
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
    this.store = new PersistentHitStore(this.listener, this.ctx);
    label50:
    if (this.handler == null) {
      initializeHandler();
    }
    this.readyToDispatch = true;
    if (this.pendingDispatch)
    {
      dispatch();
      this.pendingDispatch = false;
    }
    if ((this.networkReceiver == null) && (this.listenForNetwork)) {
      initializeNetworkReceiver();
    }
    HitStore localHitStore = this.store;
    return localHitStore;
  }
  
  /* Error */
  void initialize(Context paramContext, HitSendingThread paramHitSendingThread)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 99	com/google/tagmanager/ServiceManagerImpl:ctx	Landroid/content/Context;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 170	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   19: putfield 99	com/google/tagmanager/ServiceManagerImpl:ctx	Landroid/content/Context;
    //   22: aload_0
    //   23: getfield 70	com/google/tagmanager/ServiceManagerImpl:thread	Lcom/google/tagmanager/HitSendingThread;
    //   26: ifnonnull -15 -> 11
    //   29: aload_0
    //   30: aload_2
    //   31: putfield 70	com/google/tagmanager/ServiceManagerImpl:thread	Lcom/google/tagmanager/HitSendingThread;
    //   34: goto -23 -> 11
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	ServiceManagerImpl
    //   0	42	1	paramContext	Context
    //   0	42	2	paramHitSendingThread	HitSendingThread
    //   6	2	3	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	7	37	finally
    //   14	34	37	finally
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
  public void setDispatchPeriod(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 86	com/google/tagmanager/ServiceManagerImpl:handler	Landroid/os/Handler;
    //   6: ifnonnull +16 -> 22
    //   9: ldc -73
    //   11: invokestatic 138	com/google/tagmanager/Log:v	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iload_1
    //   16: putfield 49	com/google/tagmanager/ServiceManagerImpl:dispatchPeriodInSeconds	I
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 64	com/google/tagmanager/ServiceManagerImpl:storeIsEmpty	Z
    //   26: ifne +28 -> 54
    //   29: aload_0
    //   30: getfield 55	com/google/tagmanager/ServiceManagerImpl:connected	Z
    //   33: ifeq +21 -> 54
    //   36: aload_0
    //   37: getfield 49	com/google/tagmanager/ServiceManagerImpl:dispatchPeriodInSeconds	I
    //   40: ifle +14 -> 54
    //   43: aload_0
    //   44: getfield 86	com/google/tagmanager/ServiceManagerImpl:handler	Landroid/os/Handler;
    //   47: iconst_1
    //   48: getstatic 45	com/google/tagmanager/ServiceManagerImpl:MSG_OBJECT	Ljava/lang/Object;
    //   51: invokevirtual 175	android/os/Handler:removeMessages	(ILjava/lang/Object;)V
    //   54: aload_0
    //   55: iload_1
    //   56: putfield 49	com/google/tagmanager/ServiceManagerImpl:dispatchPeriodInSeconds	I
    //   59: iload_1
    //   60: ifle -41 -> 19
    //   63: aload_0
    //   64: getfield 64	com/google/tagmanager/ServiceManagerImpl:storeIsEmpty	Z
    //   67: ifne -48 -> 19
    //   70: aload_0
    //   71: getfield 55	com/google/tagmanager/ServiceManagerImpl:connected	Z
    //   74: ifeq -55 -> 19
    //   77: aload_0
    //   78: getfield 86	com/google/tagmanager/ServiceManagerImpl:handler	Landroid/os/Handler;
    //   81: aload_0
    //   82: getfield 86	com/google/tagmanager/ServiceManagerImpl:handler	Landroid/os/Handler;
    //   85: iconst_1
    //   86: getstatic 45	com/google/tagmanager/ServiceManagerImpl:MSG_OBJECT	Ljava/lang/Object;
    //   89: invokevirtual 113	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   92: iload_1
    //   93: sipush 1000
    //   96: imul
    //   97: i2l
    //   98: invokevirtual 117	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   101: pop
    //   102: goto -83 -> 19
    //   105: astore_2
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_2
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	ServiceManagerImpl
    //   0	110	1	paramInt	int
    //   105	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	105	finally
    //   22	54	105	finally
    //   54	59	105	finally
    //   63	102	105	finally
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/ServiceManagerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */