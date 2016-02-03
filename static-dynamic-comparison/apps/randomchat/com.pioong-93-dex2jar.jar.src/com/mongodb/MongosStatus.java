package com.mongodb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

class MongosStatus
  extends ConnectionStatus
{
  private static final Logger logger = Logger.getLogger("com.mongodb.MongosStatus");
  private volatile ConnectionStatus.Node preferred;
  
  MongosStatus(Mongo paramMongo, List<ServerAddress> paramList)
  {
    super(paramList, paramMongo);
    this._updater = new MongosUpdater();
  }
  
  /* Error */
  private ConnectionStatus.Node getPreferred()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 53	com/mongodb/MongosStatus:preferred	Lcom/mongodb/ConnectionStatus$Node;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +22 -> 30
    //   11: aload_0
    //   12: monitorenter
    //   13: aload_0
    //   14: aload_0
    //   15: getfield 61	com/mongodb/MongosStatus:_mongo	Lcom/mongodb/Mongo;
    //   18: invokevirtual 67	com/mongodb/Mongo:getMongoOptions	()Lcom/mongodb/MongoOptions;
    //   21: invokevirtual 73	com/mongodb/MongoOptions:getConnectTimeout	()I
    //   24: i2l
    //   25: invokevirtual 79	java/lang/Object:wait	(J)V
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_0
    //   31: getfield 53	com/mongodb/MongosStatus:preferred	Lcom/mongodb/ConnectionStatus$Node;
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: areturn
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    //   44: astore_1
    //   45: new 81	com/mongodb/MongoInterruptedException
    //   48: dup
    //   49: ldc 83
    //   51: aload_1
    //   52: invokespecial 86	com/mongodb/MongoInterruptedException:<init>	(Ljava/lang/String;Ljava/lang/InterruptedException;)V
    //   55: athrow
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	MongosStatus
    //   6	32	1	localNode	ConnectionStatus.Node
    //   39	4	1	localObject1	Object
    //   44	8	1	localInterruptedException	InterruptedException
    //   56	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   13	30	39	finally
    //   40	42	39	finally
    //   11	13	44	java/lang/InterruptedException
    //   42	44	44	java/lang/InterruptedException
    //   2	7	56	finally
    //   11	13	56	finally
    //   30	35	56	finally
    //   42	44	56	finally
    //   45	56	56	finally
  }
  
  private void setPreferred(MongosNode paramMongosNode)
  {
    if (paramMongosNode == null) {}
    for (;;)
    {
      try
      {
        this.preferred = null;
        notifyAll();
        return;
      }
      finally {}
      this.preferred = new ConnectionStatus.Node(paramMongosNode._pingTimeMS, paramMongosNode._addr, paramMongosNode._maxBsonObjectSize, paramMongosNode._ok);
    }
  }
  
  ConnectionStatus.Node ensureMaster()
  {
    checkClosed();
    return getPreferred();
  }
  
  List<ServerAddress> getServerAddressList()
  {
    return new ArrayList(this._mongosAddresses);
  }
  
  boolean hasServerUp()
  {
    return this.preferred != null;
  }
  
  static class MongosNode
    extends ConnectionStatus.UpdatableNode
  {
    MongosNode(ServerAddress paramServerAddress, Mongo paramMongo, MongoOptions paramMongoOptions)
    {
      super(paramMongo, paramMongoOptions);
    }
    
    protected Logger getLogger()
    {
      return MongosStatus.logger;
    }
  }
  
  class MongosUpdater
    extends ConnectionStatus.BackgroundUpdater
  {
    MongosUpdater()
    {
      super();
    }
    
    private List<MongosStatus.MongosNode> getMongosNodes()
    {
      ArrayList localArrayList = new ArrayList(MongosStatus.this._mongosAddresses.size());
      Iterator localIterator = MongosStatus.this._mongosAddresses.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new MongosStatus.MongosNode((ServerAddress)localIterator.next(), MongosStatus.this._mongo, MongosStatus.this._mongoOptions));
      }
      return localArrayList;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 79	com/mongodb/MongosStatus$MongosUpdater:getMongosNodes	()Ljava/util/List;
      //   4: astore 5
      //   6: invokestatic 84	java/lang/Thread:interrupted	()Z
      //   9: istore_2
      //   10: iload_2
      //   11: ifne +112 -> 123
      //   14: aconst_null
      //   15: astore_3
      //   16: aload 5
      //   18: invokeinterface 40 1 0
      //   23: astore 6
      //   25: aload 6
      //   27: invokeinterface 46 1 0
      //   32: ifeq +49 -> 81
      //   35: aload 6
      //   37: invokeinterface 52 1 0
      //   42: checkcast 48	com/mongodb/MongosStatus$MongosNode
      //   45: astore 4
      //   47: aload 4
      //   49: invokevirtual 88	com/mongodb/MongosStatus$MongosNode:update	()Lcom/mongodb/CommandResult;
      //   52: pop
      //   53: aload 4
      //   55: getfield 92	com/mongodb/MongosStatus$MongosNode:_ok	Z
      //   58: ifeq -33 -> 25
      //   61: aload_3
      //   62: ifnull +85 -> 147
      //   65: aload 4
      //   67: getfield 96	com/mongodb/MongosStatus$MongosNode:_pingTimeMS	F
      //   70: aload_3
      //   71: getfield 96	com/mongodb/MongosStatus$MongosNode:_pingTimeMS	F
      //   74: fcmpg
      //   75: ifge -50 -> 25
      //   78: goto +69 -> 147
      //   81: aload_0
      //   82: getfield 13	com/mongodb/MongosStatus$MongosUpdater:this$0	Lcom/mongodb/MongosStatus;
      //   85: aload_3
      //   86: invokestatic 100	com/mongodb/MongosStatus:access$000	(Lcom/mongodb/MongosStatus;Lcom/mongodb/MongosStatus$MongosNode;)V
      //   89: aload_0
      //   90: getfield 13	com/mongodb/MongosStatus$MongosUpdater:this$0	Lcom/mongodb/MongosStatus;
      //   93: invokestatic 104	com/mongodb/MongosStatus:access$200	(Lcom/mongodb/MongosStatus;)Lcom/mongodb/ConnectionStatus$Node;
      //   96: ifnonnull +44 -> 140
      //   99: getstatic 110	com/mongodb/ConnectionStatus:updaterIntervalNoMasterMS	I
      //   102: istore_1
      //   103: iload_1
      //   104: i2l
      //   105: invokestatic 114	java/lang/Thread:sleep	(J)V
      //   108: goto -102 -> 6
      //   111: astore_3
      //   112: invokestatic 118	com/mongodb/MongosStatus:access$100	()Ljava/util/logging/Logger;
      //   115: getstatic 124	java/util/logging/Level:INFO	Ljava/util/logging/Level;
      //   118: ldc 126
      //   120: invokevirtual 132	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;)V
      //   123: return
      //   124: astore_3
      //   125: invokestatic 118	com/mongodb/MongosStatus:access$100	()Ljava/util/logging/Logger;
      //   128: getstatic 135	java/util/logging/Level:WARNING	Ljava/util/logging/Level;
      //   131: ldc -119
      //   133: aload_3
      //   134: invokevirtual 140	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   137: goto -48 -> 89
      //   140: getstatic 143	com/mongodb/ConnectionStatus:updaterIntervalMS	I
      //   143: istore_1
      //   144: goto -41 -> 103
      //   147: aload 4
      //   149: astore_3
      //   150: goto -125 -> 25
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	153	0	this	MongosUpdater
      //   102	42	1	i	int
      //   9	2	2	bool	boolean
      //   15	71	3	localMongosNode1	MongosStatus.MongosNode
      //   111	1	3	localInterruptedException	InterruptedException
      //   124	10	3	localException	Exception
      //   149	1	3	localObject	Object
      //   45	103	4	localMongosNode2	MongosStatus.MongosNode
      //   4	13	5	localList	List
      //   23	13	6	localIterator	Iterator
      // Exception table:
      //   from	to	target	type
      //   6	10	111	java/lang/InterruptedException
      //   16	25	111	java/lang/InterruptedException
      //   25	61	111	java/lang/InterruptedException
      //   65	78	111	java/lang/InterruptedException
      //   81	89	111	java/lang/InterruptedException
      //   89	103	111	java/lang/InterruptedException
      //   103	108	111	java/lang/InterruptedException
      //   125	137	111	java/lang/InterruptedException
      //   140	144	111	java/lang/InterruptedException
      //   16	25	124	java/lang/Exception
      //   25	61	124	java/lang/Exception
      //   65	78	124	java/lang/Exception
      //   81	89	124	java/lang/Exception
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/MongosStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */