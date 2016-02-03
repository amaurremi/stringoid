package com.mongodb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

class DynamicConnectionStatus
  extends ConnectionStatus
{
  private static final Logger logger = Logger.getLogger("com.mongodb.DynamicConnectionStatus");
  private volatile ConnectionStatus connectionStatus;
  private ExecutorService executorService;
  
  DynamicConnectionStatus(Mongo paramMongo, List<ServerAddress> paramList)
  {
    super(paramList, paramMongo);
  }
  
  /* Error */
  private ConnectionStatus getConnectionStatus()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	com/mongodb/DynamicConnectionStatus:connectionStatus	Lcom/mongodb/ConnectionStatus;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +18 -> 26
    //   11: aload_0
    //   12: aload_0
    //   13: getfield 53	com/mongodb/DynamicConnectionStatus:_mongo	Lcom/mongodb/Mongo;
    //   16: invokevirtual 59	com/mongodb/Mongo:getMongoOptions	()Lcom/mongodb/MongoOptions;
    //   19: invokevirtual 65	com/mongodb/MongoOptions:getConnectTimeout	()I
    //   22: i2l
    //   23: invokevirtual 71	java/lang/Object:wait	(J)V
    //   26: aload_0
    //   27: getfield 49	com/mongodb/DynamicConnectionStatus:connectionStatus	Lcom/mongodb/ConnectionStatus;
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: areturn
    //   35: astore_1
    //   36: new 73	com/mongodb/MongoInterruptedException
    //   39: dup
    //   40: ldc 75
    //   42: aload_1
    //   43: invokespecial 78	com/mongodb/MongoInterruptedException:<init>	(Ljava/lang/String;Ljava/lang/InterruptedException;)V
    //   46: athrow
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	DynamicConnectionStatus
    //   6	28	1	localConnectionStatus	ConnectionStatus
    //   35	8	1	localInterruptedException	InterruptedException
    //   47	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	26	35	java/lang/InterruptedException
    //   2	7	47	finally
    //   11	26	47	finally
    //   26	31	47	finally
    //   36	47	47	finally
  }
  
  /* Error */
  private void notifyOfOkNode(DynamicNode paramDynamicNode)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	com/mongodb/DynamicConnectionStatus:connectionStatus	Lcom/mongodb/ConnectionStatus;
    //   6: ifnull +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_1
    //   13: invokestatic 82	com/mongodb/DynamicConnectionStatus$DynamicNode:access$200	(Lcom/mongodb/DynamicConnectionStatus$DynamicNode;)Z
    //   16: ifeq +46 -> 62
    //   19: aload_0
    //   20: new 84	com/mongodb/MongosStatus
    //   23: dup
    //   24: aload_0
    //   25: getfield 53	com/mongodb/DynamicConnectionStatus:_mongo	Lcom/mongodb/Mongo;
    //   28: aload_0
    //   29: getfield 88	com/mongodb/DynamicConnectionStatus:_mongosAddresses	Ljava/util/List;
    //   32: invokespecial 90	com/mongodb/MongosStatus:<init>	(Lcom/mongodb/Mongo;Ljava/util/List;)V
    //   35: putfield 49	com/mongodb/DynamicConnectionStatus:connectionStatus	Lcom/mongodb/ConnectionStatus;
    //   38: aload_0
    //   39: invokevirtual 93	java/lang/Object:notifyAll	()V
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_0
    //   45: getfield 49	com/mongodb/DynamicConnectionStatus:connectionStatus	Lcom/mongodb/ConnectionStatus;
    //   48: invokevirtual 96	com/mongodb/ConnectionStatus:start	()V
    //   51: aload_0
    //   52: getfield 98	com/mongodb/DynamicConnectionStatus:executorService	Ljava/util/concurrent/ExecutorService;
    //   55: invokeinterface 104 1 0
    //   60: pop
    //   61: return
    //   62: aload_0
    //   63: new 106	com/mongodb/ReplicaSetStatus
    //   66: dup
    //   67: aload_0
    //   68: getfield 53	com/mongodb/DynamicConnectionStatus:_mongo	Lcom/mongodb/Mongo;
    //   71: aload_0
    //   72: getfield 88	com/mongodb/DynamicConnectionStatus:_mongosAddresses	Ljava/util/List;
    //   75: invokespecial 107	com/mongodb/ReplicaSetStatus:<init>	(Lcom/mongodb/Mongo;Ljava/util/List;)V
    //   78: putfield 49	com/mongodb/DynamicConnectionStatus:connectionStatus	Lcom/mongodb/ConnectionStatus;
    //   81: goto -43 -> 38
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	DynamicConnectionStatus
    //   0	89	1	paramDynamicNode	DynamicNode
    // Exception table:
    //   from	to	target	type
    //   2	11	84	finally
    //   12	38	84	finally
    //   38	44	84	finally
    //   62	81	84	finally
    //   85	87	84	finally
  }
  
  MongosStatus asMongosStatus()
  {
    ConnectionStatus localConnectionStatus = getConnectionStatus();
    if ((localConnectionStatus instanceof MongosStatus)) {
      return (MongosStatus)localConnectionStatus;
    }
    return null;
  }
  
  ReplicaSetStatus asReplicaSetStatus()
  {
    ConnectionStatus localConnectionStatus = getConnectionStatus();
    if ((localConnectionStatus instanceof ReplicaSetStatus)) {
      return (ReplicaSetStatus)localConnectionStatus;
    }
    return null;
  }
  
  void close()
  {
    if (this.connectionStatus != null) {
      this.connectionStatus.close();
    }
    if (this.executorService != null) {
      this.executorService.shutdownNow();
    }
    super.close();
  }
  
  ConnectionStatus.Node ensureMaster()
  {
    ConnectionStatus localConnectionStatus = getConnectionStatus();
    if (localConnectionStatus != null) {
      return localConnectionStatus.ensureMaster();
    }
    return null;
  }
  
  List<ServerAddress> getServerAddressList()
  {
    if (this.connectionStatus != null) {
      return this.connectionStatus.getServerAddressList();
    }
    return new ArrayList(this._mongosAddresses);
  }
  
  boolean hasServerUp()
  {
    ConnectionStatus localConnectionStatus = getConnectionStatus();
    if (localConnectionStatus != null) {
      return localConnectionStatus.hasServerUp();
    }
    return false;
  }
  
  void initExecutorService()
  {
    try
    {
      Iterator localIterator = this._mongosAddresses.iterator();
      while (localIterator.hasNext())
      {
        final ServerAddress localServerAddress = (ServerAddress)localIterator.next();
        this.executorService.submit(new Runnable()
        {
          public void run()
          {
            DynamicConnectionStatus.DynamicNode localDynamicNode = new DynamicConnectionStatus.DynamicNode(localServerAddress, DynamicConnectionStatus.this._mongo, DynamicConnectionStatus.this._mongoOptions);
            try
            {
              for (;;)
              {
                boolean bool = Thread.interrupted();
                if (!bool) {}
                try
                {
                  localDynamicNode.update();
                  if (localDynamicNode._ok)
                  {
                    DynamicConnectionStatus.this.notifyOfOkNode(localDynamicNode);
                    return;
                  }
                }
                catch (Exception localException)
                {
                  DynamicConnectionStatus.logger.log(Level.WARNING, "couldn't reach " + localDynamicNode._addr, localException);
                  Thread.sleep(ConnectionStatus.updaterIntervalNoMasterMS);
                }
              }
              return;
            }
            catch (InterruptedException localInterruptedException) {}
          }
        });
      }
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException) {}
  }
  
  void start()
  {
    super.start();
    this.executorService = Executors.newFixedThreadPool(this._mongosAddresses.size());
    initExecutorService();
  }
  
  static class DynamicNode
    extends ConnectionStatus.UpdatableNode
  {
    private boolean isMongos;
    
    DynamicNode(ServerAddress paramServerAddress, Mongo paramMongo, MongoOptions paramMongoOptions)
    {
      super(paramMongo, paramMongoOptions);
    }
    
    protected Logger getLogger()
    {
      return DynamicConnectionStatus.logger;
    }
    
    public CommandResult update()
    {
      CommandResult localCommandResult = super.update();
      if (localCommandResult != null)
      {
        String str = localCommandResult.getString("msg");
        if ((str != null) && (str.equals("isdbgrid"))) {
          this.isMongos = true;
        }
      }
      return localCommandResult;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/DynamicConnectionStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */