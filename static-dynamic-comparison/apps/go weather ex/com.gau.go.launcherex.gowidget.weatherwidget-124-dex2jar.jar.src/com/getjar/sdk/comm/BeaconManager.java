package com.getjar.sdk.comm;

import android.content.Context;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.Utility;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class BeaconManager
{
  private static final ExecutorService _ExecutorService = ;
  private static BeaconManager _Instance = null;
  private static Object _InstanceLock = new Object();
  private static final Object _beaconLock;
  private static final Object _cachingManagerLock = new Object();
  private BeaconCachingManager _beaconCachingManager;
  
  static
  {
    _beaconLock = new Object();
  }
  
  private BeaconManager(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'applicationContext' can not be NULL");
    }
    paramContext.getApplicationContext();
    this._beaconCachingManager = new BeaconCachingManager(paramContext);
  }
  
  public static BeaconManager getInstance(Context paramContext)
  {
    if (paramContext == null) {
      try
      {
        throw new IllegalArgumentException("context cannot be null");
      }
      finally {}
    }
    if (_Instance == null) {}
    synchronized (_InstanceLock)
    {
      if (_Instance == null) {
        _Instance = new BeaconManager(paramContext);
      }
      paramContext = _Instance;
      return paramContext;
    }
  }
  
  private Operation sendBeaconMessage(BeaconMessage paramBeaconMessage, CommContext arg2)
    throws Exception
  {
    Logger.v(Area.BEACON.value(), "BeaconManager: sendBeaconMessage() started()", new Object[0]);
    Object localObject1 = null;
    for (;;)
    {
      Operation localOperation;
      Result localResult;
      synchronized (_beaconLock)
      {
        if (BeaconMessage.BeaconState.CREATED.equals(paramBeaconMessage.getState()))
        {
          localObject1 = new HashMap(2);
          ((HashMap)localObject1).put("tracking_data", paramBeaconMessage.getData());
          ((HashMap)localObject1).put("beacon_type", paramBeaconMessage.getType().name());
          localOperation = BeaconServiceProxy.getInstance().sendBeaconData(???, (HashMap)localObject1, true);
          if (localOperation == null) {
            break label224;
          }
          localResult = localOperation.get();
          if (localResult == null) {
            break label203;
          }
          if (localResult.isSuccessfulResponse())
          {
            updateBeaconState(???, paramBeaconMessage, BeaconMessage.BeaconState.SENT);
            localObject1 = localOperation;
          }
        }
        else if (!BeaconMessage.BeaconState.SENT.equals(paramBeaconMessage.getState())) {}
      }
      synchronized (_cachingManagerLock)
      {
        this._beaconCachingManager.remove(paramBeaconMessage.getId());
        return (Operation)localObject1;
        localObject1 = localOperation;
        if (RequestUtilities.getServicesException(localResult) == null) {
          continue;
        }
        localObject1 = localOperation;
        if (localResult.getResponseCode() == 202) {
          continue;
        }
        updateBeaconState(???, paramBeaconMessage, BeaconMessage.BeaconState.SENT);
        localObject1 = localOperation;
        continue;
        paramBeaconMessage = finally;
        throw paramBeaconMessage;
        label203:
        Logger.w(Area.BEACON.value(), "BeaconManager: sendBeaconMessage() Failed to get results!", new Object[0]);
        localObject1 = localOperation;
        continue;
        label224:
        Logger.e(Area.BEACON.value(), "BeaconManager: sendBeaconMessage() Got null Operation!", new Object[0]);
        localObject1 = localOperation;
      }
    }
  }
  
  private void updateBeaconState(CommContext arg1, BeaconMessage paramBeaconMessage, BeaconMessage.BeaconState paramBeaconState)
  {
    Logger.v(Area.BEACON.value() | Area.STORAGE.value(), "BeaconManager: updateBeaconState() [id: %1$s] [old: %2$s] [new: %3$s] [thread: %4$d]", new Object[] { paramBeaconMessage.getId(), paramBeaconMessage.getState().name(), paramBeaconState.name(), Long.valueOf(Thread.currentThread().getId()) });
    paramBeaconMessage.setState(paramBeaconState);
    synchronized (_cachingManagerLock)
    {
      this._beaconCachingManager.upsert(paramBeaconMessage.getId(), paramBeaconMessage);
      return;
    }
  }
  
  public void initiateBeaconMessage(final CommContext paramCommContext, final BeaconMessage.BeaconType paramBeaconType, final HashMap<String, String> paramHashMap)
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("'commContext' can not be NULL");
    }
    if (paramBeaconType == null) {
      throw new IllegalArgumentException("'beaconType' cannot be NULL");
    }
    if ((paramHashMap == null) || (paramHashMap.isEmpty())) {
      throw new IllegalArgumentException("'mapData' cannot be null or empty");
    }
    Logger.v(Area.BEACON.value(), "BeaconManager: initiateBeaconMessage() started [thread: %1$d]", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    try
    {
      _ExecutorService.execute(new Runnable()
      {
        public void run()
        {
          try
          {
            paramHashMap.put("client_beacon_token", UUID.randomUUID().toString());
            BeaconMessage localBeaconMessage = new BeaconMessage(paramBeaconType, Utility.mapToJsonString(paramHashMap));
            synchronized (BeaconManager._cachingManagerLock)
            {
              BeaconManager.this._beaconCachingManager.upsert(localBeaconMessage.getId(), localBeaconMessage);
              BeaconManager.this.sendBeaconMessage(localBeaconMessage, paramCommContext);
              return;
            }
            return;
          }
          catch (Exception localException)
          {
            Logger.e(Area.BEACON.value(), localException, "BeaconManager initiateBeaconMessage failed()", new Object[0]);
          }
        }
      });
      _ExecutorService.submit(new Runnable()
      {
        public void run()
        {
          try
          {
            BeaconManager.this.recoverUnsentBeacons(paramCommContext);
            return;
          }
          catch (Exception localException)
          {
            Logger.e(Area.BEACON.value(), localException, "BeaconManager: initiateBeaconMessage() failed", new Object[0]);
          }
        }
      });
      return;
    }
    catch (Exception paramBeaconType)
    {
      for (;;)
      {
        Logger.e(Area.BEACON.value(), paramBeaconType, "BeaconManager: initiateBeaconMessage() add to cache failed", new Object[0]);
      }
    }
  }
  
  /* Error */
  public void recoverUnsentBeacons(CommContext paramCommContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 84	com/getjar/sdk/logging/Area:BEACON	Lcom/getjar/sdk/logging/Area;
    //   5: invokevirtual 88	com/getjar/sdk/logging/Area:value	()J
    //   8: ldc_w 260
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: invokestatic 204	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   20: invokevirtual 206	java/lang/Thread:getId	()J
    //   23: invokestatic 212	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   26: aastore
    //   27: invokestatic 96	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   30: getstatic 33	com/getjar/sdk/comm/BeaconManager:_cachingManagerLock	Ljava/lang/Object;
    //   33: astore_3
    //   34: aload_3
    //   35: monitorenter
    //   36: aload_0
    //   37: getfield 60	com/getjar/sdk/comm/BeaconManager:_beaconCachingManager	Lcom/getjar/sdk/comm/BeaconCachingManager;
    //   40: invokevirtual 264	com/getjar/sdk/comm/BeaconCachingManager:getAll	()Ljava/util/HashMap;
    //   43: astore_2
    //   44: aload_3
    //   45: monitorexit
    //   46: aload_2
    //   47: invokevirtual 268	java/util/HashMap:values	()Ljava/util/Collection;
    //   50: invokeinterface 274 1 0
    //   55: astore_3
    //   56: aload_3
    //   57: invokeinterface 279 1 0
    //   62: ifeq +65 -> 127
    //   65: aload_3
    //   66: invokeinterface 282 1 0
    //   71: checkcast 104	com/getjar/sdk/comm/BeaconMessage
    //   74: astore 4
    //   76: aload_0
    //   77: aload 4
    //   79: aload_1
    //   80: invokespecial 72	com/getjar/sdk/comm/BeaconManager:sendBeaconMessage	(Lcom/getjar/sdk/comm/BeaconMessage;Lcom/getjar/sdk/comm/CommContext;)Lcom/getjar/sdk/comm/Operation;
    //   83: pop
    //   84: goto -28 -> 56
    //   87: astore 4
    //   89: getstatic 84	com/getjar/sdk/logging/Area:BEACON	Lcom/getjar/sdk/logging/Area;
    //   92: invokevirtual 88	com/getjar/sdk/logging/Area:value	()J
    //   95: getstatic 195	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   98: invokevirtual 88	com/getjar/sdk/logging/Area:value	()J
    //   101: lor
    //   102: aload 4
    //   104: ldc_w 284
    //   107: iconst_0
    //   108: anewarray 4	java/lang/Object
    //   111: invokestatic 286	com/getjar/sdk/logging/Logger:w	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   114: goto -58 -> 56
    //   117: astore_1
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    //   122: astore_1
    //   123: aload_3
    //   124: monitorexit
    //   125: aload_1
    //   126: athrow
    //   127: getstatic 84	com/getjar/sdk/logging/Area:BEACON	Lcom/getjar/sdk/logging/Area;
    //   130: invokevirtual 88	com/getjar/sdk/logging/Area:value	()J
    //   133: getstatic 195	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   136: invokevirtual 88	com/getjar/sdk/logging/Area:value	()J
    //   139: lor
    //   140: ldc_w 288
    //   143: iconst_1
    //   144: anewarray 4	java/lang/Object
    //   147: dup
    //   148: iconst_0
    //   149: aload_2
    //   150: invokevirtual 291	java/util/HashMap:size	()I
    //   153: invokestatic 296	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   156: aastore
    //   157: invokestatic 299	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   160: aload_0
    //   161: monitorexit
    //   162: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	BeaconManager
    //   0	163	1	paramCommContext	CommContext
    //   43	107	2	localHashMap	HashMap
    //   74	4	4	localBeaconMessage	BeaconMessage
    //   87	16	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   76	84	87	java/lang/Exception
    //   2	36	117	finally
    //   46	56	117	finally
    //   56	76	117	finally
    //   76	84	117	finally
    //   89	114	117	finally
    //   125	127	117	finally
    //   127	160	117	finally
    //   36	46	122	finally
    //   123	125	122	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/BeaconManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */