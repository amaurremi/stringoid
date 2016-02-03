package com.mongodb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBTCPConnector
  implements DBConnector
{
  static Logger _logger = Logger.getLogger(Bytes.LOGGER.getName() + ".tcp");
  private final AtomicBoolean _closed = new AtomicBoolean(false);
  private ConnectionStatus _connectionStatus;
  private volatile Boolean _isMongosDirectConnection;
  private volatile DBPortPool _masterPortPool;
  private volatile int _maxBsonObjectSize;
  private final Mongo _mongo;
  MyPort _myPort = new MyPort();
  private DBPortPool.Holder _portHolder;
  
  public DBTCPConnector(Mongo paramMongo)
  {
    this._mongo = paramMongo;
    this._portHolder = new DBPortPool.Holder(paramMongo._options);
    MongoAuthority.Type localType = paramMongo.getAuthority().getType();
    if (localType == MongoAuthority.Type.Direct)
    {
      setMasterAddress((ServerAddress)paramMongo.getAuthority().getServerAddresses().get(0));
      return;
    }
    if (localType == MongoAuthority.Type.Set)
    {
      this._connectionStatus = new DynamicConnectionStatus(paramMongo, paramMongo.getAuthority().getServerAddresses());
      return;
    }
    throw new IllegalArgumentException("Unsupported authority type: " + localType);
  }
  
  /* Error */
  private Response innerCall(DB paramDB, DBCollection paramDBCollection, OutMessage paramOutMessage, ServerAddress paramServerAddress, int paramInt, ReadPreference paramReadPreference, DBDecoder paramDBDecoder)
  {
    // Byte code:
    //   0: aload 6
    //   2: astore 11
    //   4: aload 6
    //   6: ifnonnull +8 -> 14
    //   9: invokestatic 165	com/mongodb/ReadPreference:primary	()Lcom/mongodb/ReadPreference;
    //   12: astore 11
    //   14: aload 11
    //   16: astore 12
    //   18: aload 11
    //   20: invokestatic 165	com/mongodb/ReadPreference:primary	()Lcom/mongodb/ReadPreference;
    //   23: if_acmpne +20 -> 43
    //   26: aload 11
    //   28: astore 12
    //   30: aload_3
    //   31: iconst_4
    //   32: invokevirtual 171	com/mongodb/OutMessage:hasOption	(I)Z
    //   35: ifeq +8 -> 43
    //   38: invokestatic 174	com/mongodb/ReadPreference:secondaryPreferred	()Lcom/mongodb/ReadPreference;
    //   41: astore 12
    //   43: aload 12
    //   45: invokestatic 165	com/mongodb/ReadPreference:primary	()Lcom/mongodb/ReadPreference;
    //   48: if_acmpeq +226 -> 274
    //   51: iconst_1
    //   52: istore 9
    //   54: aload_0
    //   55: invokevirtual 177	com/mongodb/DBTCPConnector:_checkClosed	()V
    //   58: iload 9
    //   60: ifeq +10 -> 70
    //   63: aload_0
    //   64: invokevirtual 181	com/mongodb/DBTCPConnector:getReplicaSetStatus	()Lcom/mongodb/ReplicaSetStatus;
    //   67: ifnonnull +18 -> 85
    //   70: iload 9
    //   72: ifne +208 -> 280
    //   75: iconst_1
    //   76: istore 10
    //   78: aload_0
    //   79: iconst_0
    //   80: iload 10
    //   82: invokevirtual 185	com/mongodb/DBTCPConnector:checkMaster	(ZZ)V
    //   85: aload_0
    //   86: getfield 78	com/mongodb/DBTCPConnector:_myPort	Lcom/mongodb/DBTCPConnector$MyPort;
    //   89: iconst_0
    //   90: aload 12
    //   92: aload 4
    //   94: invokevirtual 188	com/mongodb/DBTCPConnector$MyPort:get	(ZLcom/mongodb/ReadPreference;Lcom/mongodb/ServerAddress;)Lcom/mongodb/DBPort;
    //   97: astore 13
    //   99: aconst_null
    //   100: astore 11
    //   102: iconst_0
    //   103: istore 8
    //   105: aload 11
    //   107: astore 6
    //   109: aload 13
    //   111: aload_1
    //   112: invokevirtual 194	com/mongodb/DB:getMongo	()Lcom/mongodb/Mongo;
    //   115: invokevirtual 199	com/mongodb/DBPort:checkAuth	(Lcom/mongodb/Mongo;)V
    //   118: aload 11
    //   120: astore 6
    //   122: aload 13
    //   124: aload_3
    //   125: aload_2
    //   126: aload 7
    //   128: invokevirtual 203	com/mongodb/DBPort:call	(Lcom/mongodb/OutMessage;Lcom/mongodb/DBCollection;Lcom/mongodb/DBDecoder;)Lcom/mongodb/Response;
    //   131: astore 11
    //   133: aload 11
    //   135: astore 6
    //   137: aload 11
    //   139: getfield 208	com/mongodb/Response:_responseTo	I
    //   142: aload_3
    //   143: invokevirtual 212	com/mongodb/OutMessage:getId	()I
    //   146: if_icmpeq +140 -> 286
    //   149: aload 11
    //   151: astore 6
    //   153: new 214	com/mongodb/MongoException
    //   156: dup
    //   157: ldc -40
    //   159: invokespecial 217	com/mongodb/MongoException:<init>	(Ljava/lang/String;)V
    //   162: athrow
    //   163: astore 11
    //   165: aload_0
    //   166: getfield 78	com/mongodb/DBTCPConnector:_myPort	Lcom/mongodb/DBTCPConnector$MyPort;
    //   169: aload 13
    //   171: aload 11
    //   173: invokevirtual 221	com/mongodb/DBTCPConnector$MyPort:error	(Lcom/mongodb/DBPort;Ljava/lang/Exception;)V
    //   176: iload 5
    //   178: ifle +148 -> 326
    //   181: aload_2
    //   182: getfield 227	com/mongodb/DBCollection:_name	Ljava/lang/String;
    //   185: ldc -27
    //   187: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   190: ifne +136 -> 326
    //   193: aload 11
    //   195: instanceof 237
    //   198: ifne +128 -> 326
    //   201: aload_0
    //   202: aload 11
    //   204: iload 9
    //   206: invokevirtual 241	com/mongodb/DBTCPConnector:_error	(Ljava/lang/Throwable;Z)Z
    //   209: ifeq +117 -> 326
    //   212: iconst_1
    //   213: istore 8
    //   215: iload 8
    //   217: ifne +115 -> 332
    //   220: new 243	com/mongodb/MongoException$Network
    //   223: dup
    //   224: new 34	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   231: ldc -11
    //   233: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload 13
    //   238: invokevirtual 248	com/mongodb/DBPort:host	()Ljava/lang/String;
    //   241: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc -6
    //   246: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_1
    //   250: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: aload 11
    //   258: invokespecial 253	com/mongodb/MongoException$Network:<init>	(Ljava/lang/String;Ljava/io/IOException;)V
    //   261: athrow
    //   262: astore_1
    //   263: aload_0
    //   264: getfield 78	com/mongodb/DBTCPConnector:_myPort	Lcom/mongodb/DBTCPConnector$MyPort;
    //   267: aload 13
    //   269: invokevirtual 257	com/mongodb/DBTCPConnector$MyPort:done	(Lcom/mongodb/DBPort;)V
    //   272: aload_1
    //   273: athrow
    //   274: iconst_0
    //   275: istore 9
    //   277: goto -223 -> 54
    //   280: iconst_0
    //   281: istore 10
    //   283: goto -205 -> 78
    //   286: aload_0
    //   287: getfield 78	com/mongodb/DBTCPConnector:_myPort	Lcom/mongodb/DBTCPConnector$MyPort;
    //   290: aload 13
    //   292: invokevirtual 257	com/mongodb/DBTCPConnector$MyPort:done	(Lcom/mongodb/DBPort;)V
    //   295: aload 11
    //   297: astore 6
    //   299: iload 8
    //   301: ifeq +56 -> 357
    //   304: aload_0
    //   305: aload_1
    //   306: aload_2
    //   307: aload_3
    //   308: aload 4
    //   310: iload 5
    //   312: iconst_1
    //   313: isub
    //   314: aload 12
    //   316: aload 7
    //   318: invokespecial 259	com/mongodb/DBTCPConnector:innerCall	(Lcom/mongodb/DB;Lcom/mongodb/DBCollection;Lcom/mongodb/OutMessage;Lcom/mongodb/ServerAddress;ILcom/mongodb/ReadPreference;Lcom/mongodb/DBDecoder;)Lcom/mongodb/Response;
    //   321: astore 11
    //   323: aload 11
    //   325: areturn
    //   326: iconst_0
    //   327: istore 8
    //   329: goto -114 -> 215
    //   332: aload_0
    //   333: getfield 78	com/mongodb/DBTCPConnector:_myPort	Lcom/mongodb/DBTCPConnector$MyPort;
    //   336: aload 13
    //   338: invokevirtual 257	com/mongodb/DBTCPConnector$MyPort:done	(Lcom/mongodb/DBPort;)V
    //   341: goto -42 -> 299
    //   344: astore_1
    //   345: aload_0
    //   346: getfield 78	com/mongodb/DBTCPConnector:_myPort	Lcom/mongodb/DBTCPConnector$MyPort;
    //   349: aload 13
    //   351: aload_1
    //   352: invokevirtual 221	com/mongodb/DBTCPConnector$MyPort:error	(Lcom/mongodb/DBPort;Ljava/lang/Exception;)V
    //   355: aload_1
    //   356: athrow
    //   357: aload 6
    //   359: invokevirtual 263	com/mongodb/Response:getError	()Lcom/mongodb/ServerError;
    //   362: astore 13
    //   364: aload 6
    //   366: astore 11
    //   368: aload 13
    //   370: ifnull -47 -> 323
    //   373: aload 6
    //   375: astore 11
    //   377: aload 13
    //   379: invokevirtual 269	com/mongodb/ServerError:isNotMasterError	()Z
    //   382: ifeq -59 -> 323
    //   385: aload_0
    //   386: iconst_1
    //   387: iconst_1
    //   388: invokevirtual 185	com/mongodb/DBTCPConnector:checkMaster	(ZZ)V
    //   391: iload 5
    //   393: ifgt +14 -> 407
    //   396: new 214	com/mongodb/MongoException
    //   399: dup
    //   400: ldc_w 271
    //   403: invokespecial 217	com/mongodb/MongoException:<init>	(Ljava/lang/String;)V
    //   406: athrow
    //   407: aload_0
    //   408: aload_1
    //   409: aload_2
    //   410: aload_3
    //   411: aload 4
    //   413: iload 5
    //   415: iconst_1
    //   416: isub
    //   417: aload 12
    //   419: aload 7
    //   421: invokespecial 259	com/mongodb/DBTCPConnector:innerCall	(Lcom/mongodb/DB;Lcom/mongodb/DBCollection;Lcom/mongodb/OutMessage;Lcom/mongodb/ServerAddress;ILcom/mongodb/ReadPreference;Lcom/mongodb/DBDecoder;)Lcom/mongodb/Response;
    //   424: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	425	0	this	DBTCPConnector
    //   0	425	1	paramDB	DB
    //   0	425	2	paramDBCollection	DBCollection
    //   0	425	3	paramOutMessage	OutMessage
    //   0	425	4	paramServerAddress	ServerAddress
    //   0	425	5	paramInt	int
    //   0	425	6	paramReadPreference	ReadPreference
    //   0	425	7	paramDBDecoder	DBDecoder
    //   103	225	8	i	int
    //   52	224	9	bool1	boolean
    //   76	206	10	bool2	boolean
    //   2	148	11	localObject1	Object
    //   163	133	11	localIOException	IOException
    //   321	55	11	localObject2	Object
    //   16	402	12	localObject3	Object
    //   97	281	13	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   109	118	163	java/io/IOException
    //   122	133	163	java/io/IOException
    //   137	149	163	java/io/IOException
    //   153	163	163	java/io/IOException
    //   109	118	262	finally
    //   122	133	262	finally
    //   137	149	262	finally
    //   153	163	262	finally
    //   165	176	262	finally
    //   181	212	262	finally
    //   220	262	262	finally
    //   345	357	262	finally
    //   109	118	344	java/lang/RuntimeException
    //   122	133	344	java/lang/RuntimeException
    //   137	149	344	java/lang/RuntimeException
    //   153	163	344	java/lang/RuntimeException
  }
  
  /* Error */
  private boolean setMasterAddress(ServerAddress paramServerAddress)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 93	com/mongodb/DBTCPConnector:_portHolder	Lcom/mongodb/DBPortPool$Holder;
    //   6: aload_1
    //   7: invokevirtual 274	com/mongodb/DBPortPool$Holder:get	(Lcom/mongodb/ServerAddress;)Lcom/mongodb/DBPortPool;
    //   10: astore_3
    //   11: aload_0
    //   12: getfield 151	com/mongodb/DBTCPConnector:_masterPortPool	Lcom/mongodb/DBPortPool;
    //   15: astore 4
    //   17: aload_3
    //   18: aload 4
    //   20: if_acmpne +9 -> 29
    //   23: iconst_0
    //   24: istore_2
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_2
    //   28: ireturn
    //   29: aload_0
    //   30: getfield 151	com/mongodb/DBTCPConnector:_masterPortPool	Lcom/mongodb/DBPortPool;
    //   33: ifnull +48 -> 81
    //   36: getstatic 63	com/mongodb/DBTCPConnector:_logger	Ljava/util/logging/Logger;
    //   39: getstatic 280	java/util/logging/Level:WARNING	Ljava/util/logging/Level;
    //   42: new 34	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 282
    //   52: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_0
    //   56: getfield 151	com/mongodb/DBTCPConnector:_masterPortPool	Lcom/mongodb/DBPortPool;
    //   59: invokevirtual 288	com/mongodb/DBPortPool:getServerAddress	()Lcom/mongodb/ServerAddress;
    //   62: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   65: ldc_w 290
    //   68: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_1
    //   72: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokevirtual 294	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;)V
    //   81: aload_0
    //   82: aload_3
    //   83: putfield 151	com/mongodb/DBTCPConnector:_masterPortPool	Lcom/mongodb/DBPortPool;
    //   86: iconst_1
    //   87: istore_2
    //   88: goto -63 -> 25
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	DBTCPConnector
    //   0	96	1	paramServerAddress	ServerAddress
    //   24	64	2	bool	boolean
    //   10	73	3	localDBPortPool1	DBPortPool
    //   15	4	4	localDBPortPool2	DBPortPool
    // Exception table:
    //   from	to	target	type
    //   2	17	91	finally
    //   29	81	91	finally
    //   81	86	91	finally
  }
  
  void _checkClosed()
  {
    if (this._closed.get()) {
      throw new IllegalStateException("this Mongo has been closed");
    }
  }
  
  WriteResult _checkWriteError(DB paramDB, DBPort paramDBPort, WriteConcern paramWriteConcern)
    throws IOException
  {
    paramDB = paramDBPort.runCommand(paramDB, paramWriteConcern.getCommand());
    paramDB.throwOnError();
    return new WriteResult(paramDB, paramWriteConcern);
  }
  
  boolean _error(Throwable paramThrowable, boolean paramBoolean)
  {
    boolean bool = false;
    if (this._connectionStatus == null) {
      return false;
    }
    if (this._connectionStatus.hasServerUp())
    {
      if (!paramBoolean) {
        bool = true;
      }
      checkMaster(true, bool);
    }
    return this._connectionStatus.hasServerUp();
  }
  
  public CommandResult authenticate(MongoCredential paramMongoCredential)
  {
    checkMaster(false, true);
    DBPort localDBPort = this._myPort.get(false, ReadPreference.primaryPreferred(), null);
    try
    {
      CommandResult localCommandResult = localDBPort.authenticate(this._mongo, paramMongoCredential);
      this._mongo.getAuthority().getCredentialsStore().add(paramMongoCredential);
      return localCommandResult;
    }
    finally
    {
      this._myPort.done(localDBPort);
    }
  }
  
  public Response call(DB paramDB, DBCollection paramDBCollection, OutMessage paramOutMessage, ServerAddress paramServerAddress, int paramInt)
  {
    return call(paramDB, paramDBCollection, paramOutMessage, paramServerAddress, paramInt, null, null);
  }
  
  public Response call(DB paramDB, DBCollection paramDBCollection, OutMessage paramOutMessage, ServerAddress paramServerAddress, int paramInt, ReadPreference paramReadPreference, DBDecoder paramDBDecoder)
  {
    try
    {
      paramDB = innerCall(paramDB, paramDBCollection, paramOutMessage, paramServerAddress, paramInt, paramReadPreference, paramDBDecoder);
      return paramDB;
    }
    finally
    {
      paramOutMessage.doneWithMessage();
    }
  }
  
  public Response call(DB paramDB, DBCollection paramDBCollection, OutMessage paramOutMessage, ServerAddress paramServerAddress, DBDecoder paramDBDecoder)
  {
    return call(paramDB, paramDBCollection, paramOutMessage, paramServerAddress, 2, null, paramDBDecoder);
  }
  
  void checkMaster(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this._connectionStatus != null) {
      if ((this._masterPortPool == null) || (paramBoolean1))
      {
        localNode = this._connectionStatus.ensureMaster();
        if (localNode == null)
        {
          if (paramBoolean2) {
            throw new MongoException("can't find a master");
          }
        }
        else {
          setMaster(localNode);
        }
      }
    }
    while (this._maxBsonObjectSize != 0)
    {
      ConnectionStatus.Node localNode;
      return;
    }
    initDirectConnection();
  }
  
  public void close()
  {
    this._closed.set(true);
    if (this._portHolder != null) {}
    try
    {
      this._portHolder.close();
      this._portHolder = null;
      if (this._connectionStatus != null) {}
      try
      {
        this._connectionStatus.close();
        this._connectionStatus = null;
        return;
      }
      catch (Throwable localThrowable1) {}
    }
    catch (Throwable localThrowable2)
    {
      for (;;) {}
    }
  }
  
  public String debugString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("DBTCPConnector: ");
    if (this._connectionStatus != null)
    {
      localStringBuilder1.append("set : ").append(this._mongo._authority.getServerAddresses());
      return localStringBuilder1.toString();
    }
    Object localObject = getAddress();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(localObject).append(" ");
    if (localObject != null) {}
    for (localObject = ((ServerAddress)localObject).getSocketAddress();; localObject = null)
    {
      localStringBuilder2.append(localObject);
      break;
    }
  }
  
  public ServerAddress getAddress()
  {
    DBPortPool localDBPortPool = this._masterPortPool;
    if (localDBPortPool != null) {
      return localDBPortPool.getServerAddress();
    }
    return null;
  }
  
  public List<ServerAddress> getAllAddress()
  {
    return this._mongo._authority.getServerAddresses();
  }
  
  public String getConnectPoint()
  {
    ServerAddress localServerAddress = getAddress();
    if (localServerAddress != null) {
      return localServerAddress.toString();
    }
    return null;
  }
  
  public DBPortPool getDBPortPool(ServerAddress paramServerAddress)
  {
    return this._portHolder.get(paramServerAddress);
  }
  
  public int getMaxBsonObjectSize()
  {
    return this._maxBsonObjectSize;
  }
  
  MyPort getMyPort()
  {
    return this._myPort;
  }
  
  public ReplicaSetStatus getReplicaSetStatus()
  {
    if ((this._connectionStatus instanceof ReplicaSetStatus)) {
      return (ReplicaSetStatus)this._connectionStatus;
    }
    if ((this._connectionStatus instanceof DynamicConnectionStatus)) {
      return ((DynamicConnectionStatus)this._connectionStatus).asReplicaSetStatus();
    }
    return null;
  }
  
  public List<ServerAddress> getServerAddressList()
  {
    if (this._connectionStatus != null) {
      return this._connectionStatus.getServerAddressList();
    }
    ServerAddress localServerAddress = getAddress();
    if (localServerAddress != null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localServerAddress);
      return localArrayList;
    }
    return null;
  }
  
  void initDirectConnection()
  {
    if (this._masterPortPool == null) {
      return;
    }
    localDBPort = this._masterPortPool.get();
    for (;;)
    {
      try
      {
        Object localObject1 = localDBPort.runCommand(this._mongo.getDB("admin"), new BasicDBObject("isMaster", Integer.valueOf(1)));
        if (!((CommandResult)localObject1).containsField("maxBsonObjectSize")) {
          continue;
        }
        this._maxBsonObjectSize = ((Integer)((CommandResult)localObject1).get("maxBsonObjectSize")).intValue();
        localObject1 = ((CommandResult)localObject1).getString("msg");
        if ((localObject1 == null) || (!((String)localObject1).equals("isdbgrid"))) {
          continue;
        }
        bool = true;
      }
      catch (Exception localException)
      {
        _logger.log(Level.WARNING, "Exception executing isMaster command on " + localDBPort.serverAddress(), localException);
        return;
        boolean bool = false;
        continue;
      }
      finally
      {
        localDBPort.getPool().done(localDBPort);
      }
      this._isMongosDirectConnection = Boolean.valueOf(bool);
      localDBPort.getPool().done(localDBPort);
      return;
      this._maxBsonObjectSize = 4194304;
    }
  }
  
  boolean isMongosConnection()
  {
    boolean bool = false;
    if ((this._connectionStatus instanceof MongosStatus)) {
      return true;
    }
    if ((this._connectionStatus instanceof DynamicConnectionStatus))
    {
      if (((DynamicConnectionStatus)this._connectionStatus).asMongosStatus() != null) {}
      for (bool = true;; bool = false) {
        return bool;
      }
    }
    if (this._isMongosDirectConnection == null) {
      initDirectConnection();
    }
    if (this._isMongosDirectConnection != null) {
      bool = this._isMongosDirectConnection.booleanValue();
    }
    return bool;
  }
  
  public boolean isOpen()
  {
    return !this._closed.get();
  }
  
  public void requestDone()
  {
    this._myPort.requestDone();
  }
  
  public void requestEnsureConnection()
  {
    checkMaster(false, true);
    this._myPort.requestEnsureConnection();
  }
  
  public void requestStart()
  {
    this._myPort.requestStart();
  }
  
  public WriteResult say(DB paramDB, OutMessage paramOutMessage, WriteConcern paramWriteConcern)
  {
    return say(paramDB, paramOutMessage, paramWriteConcern, null);
  }
  
  /* Error */
  public WriteResult say(DB paramDB, OutMessage paramOutMessage, WriteConcern paramWriteConcern, ServerAddress paramServerAddress)
  {
    // Byte code:
    //   0: aload_3
    //   1: ifnonnull +14 -> 15
    //   4: new 137	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 513
    //   11: invokespecial 145	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aload_0
    //   16: invokevirtual 177	com/mongodb/DBTCPConnector:_checkClosed	()V
    //   19: aload_0
    //   20: iconst_0
    //   21: iconst_1
    //   22: invokevirtual 185	com/mongodb/DBTCPConnector:checkMaster	(ZZ)V
    //   25: aload_0
    //   26: getfield 78	com/mongodb/DBTCPConnector:_myPort	Lcom/mongodb/DBTCPConnector$MyPort;
    //   29: iconst_1
    //   30: invokestatic 165	com/mongodb/ReadPreference:primary	()Lcom/mongodb/ReadPreference;
    //   33: aload 4
    //   35: invokevirtual 188	com/mongodb/DBTCPConnector$MyPort:get	(ZLcom/mongodb/ReadPreference;Lcom/mongodb/ServerAddress;)Lcom/mongodb/DBPort;
    //   38: astore 4
    //   40: aload 4
    //   42: aload_1
    //   43: invokevirtual 194	com/mongodb/DB:getMongo	()Lcom/mongodb/Mongo;
    //   46: invokevirtual 199	com/mongodb/DBPort:checkAuth	(Lcom/mongodb/Mongo;)V
    //   49: aload 4
    //   51: aload_2
    //   52: invokevirtual 516	com/mongodb/DBPort:say	(Lcom/mongodb/OutMessage;)V
    //   55: aload_3
    //   56: invokevirtual 519	com/mongodb/WriteConcern:callGetLastError	()Z
    //   59: ifeq +29 -> 88
    //   62: aload_0
    //   63: aload_1
    //   64: aload 4
    //   66: aload_3
    //   67: invokevirtual 521	com/mongodb/DBTCPConnector:_checkWriteError	(Lcom/mongodb/DB;Lcom/mongodb/DBPort;Lcom/mongodb/WriteConcern;)Lcom/mongodb/WriteResult;
    //   70: astore 5
    //   72: aload_0
    //   73: getfield 78	com/mongodb/DBTCPConnector:_myPort	Lcom/mongodb/DBTCPConnector$MyPort;
    //   76: aload 4
    //   78: invokevirtual 257	com/mongodb/DBTCPConnector$MyPort:done	(Lcom/mongodb/DBPort;)V
    //   81: aload_2
    //   82: invokevirtual 353	com/mongodb/OutMessage:doneWithMessage	()V
    //   85: aload 5
    //   87: areturn
    //   88: new 320	com/mongodb/WriteResult
    //   91: dup
    //   92: aload_1
    //   93: aload 4
    //   95: aload_3
    //   96: invokespecial 524	com/mongodb/WriteResult:<init>	(Lcom/mongodb/DB;Lcom/mongodb/DBPort;Lcom/mongodb/WriteConcern;)V
    //   99: astore 5
    //   101: aload_0
    //   102: getfield 78	com/mongodb/DBTCPConnector:_myPort	Lcom/mongodb/DBTCPConnector$MyPort;
    //   105: aload 4
    //   107: invokevirtual 257	com/mongodb/DBTCPConnector$MyPort:done	(Lcom/mongodb/DBPort;)V
    //   110: aload_2
    //   111: invokevirtual 353	com/mongodb/OutMessage:doneWithMessage	()V
    //   114: aload 5
    //   116: areturn
    //   117: astore 5
    //   119: aload_0
    //   120: getfield 78	com/mongodb/DBTCPConnector:_myPort	Lcom/mongodb/DBTCPConnector$MyPort;
    //   123: aload 4
    //   125: aload 5
    //   127: invokevirtual 221	com/mongodb/DBTCPConnector$MyPort:error	(Lcom/mongodb/DBPort;Ljava/lang/Exception;)V
    //   130: aload_0
    //   131: aload 5
    //   133: iconst_0
    //   134: invokevirtual 241	com/mongodb/DBTCPConnector:_error	(Ljava/lang/Throwable;Z)Z
    //   137: pop
    //   138: aload_3
    //   139: invokevirtual 527	com/mongodb/WriteConcern:raiseNetworkErrors	()Z
    //   142: ifeq +62 -> 204
    //   145: new 243	com/mongodb/MongoException$Network
    //   148: dup
    //   149: new 34	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 529
    //   159: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload 4
    //   164: invokevirtual 248	com/mongodb/DBPort:host	()Ljava/lang/String;
    //   167: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: ldc -6
    //   172: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_1
    //   176: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: aload 5
    //   184: invokespecial 253	com/mongodb/MongoException$Network:<init>	(Ljava/lang/String;Ljava/io/IOException;)V
    //   187: athrow
    //   188: astore_1
    //   189: aload_0
    //   190: getfield 78	com/mongodb/DBTCPConnector:_myPort	Lcom/mongodb/DBTCPConnector$MyPort;
    //   193: aload 4
    //   195: invokevirtual 257	com/mongodb/DBTCPConnector$MyPort:done	(Lcom/mongodb/DBPort;)V
    //   198: aload_2
    //   199: invokevirtual 353	com/mongodb/OutMessage:doneWithMessage	()V
    //   202: aload_1
    //   203: athrow
    //   204: new 315	com/mongodb/CommandResult
    //   207: dup
    //   208: aload 4
    //   210: invokevirtual 483	com/mongodb/DBPort:serverAddress	()Lcom/mongodb/ServerAddress;
    //   213: invokespecial 532	com/mongodb/CommandResult:<init>	(Lcom/mongodb/ServerAddress;)V
    //   216: astore_1
    //   217: aload_1
    //   218: ldc_w 534
    //   221: iconst_0
    //   222: invokestatic 468	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   225: invokevirtual 538	com/mongodb/CommandResult:put	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   228: pop
    //   229: aload_1
    //   230: ldc_w 540
    //   233: ldc_w 542
    //   236: invokevirtual 538	com/mongodb/CommandResult:put	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   239: pop
    //   240: new 320	com/mongodb/WriteResult
    //   243: dup
    //   244: aload_1
    //   245: aload_3
    //   246: invokespecial 323	com/mongodb/WriteResult:<init>	(Lcom/mongodb/CommandResult;Lcom/mongodb/WriteConcern;)V
    //   249: astore_1
    //   250: aload_0
    //   251: getfield 78	com/mongodb/DBTCPConnector:_myPort	Lcom/mongodb/DBTCPConnector$MyPort;
    //   254: aload 4
    //   256: invokevirtual 257	com/mongodb/DBTCPConnector$MyPort:done	(Lcom/mongodb/DBPort;)V
    //   259: aload_2
    //   260: invokevirtual 353	com/mongodb/OutMessage:doneWithMessage	()V
    //   263: aload_1
    //   264: areturn
    //   265: astore_1
    //   266: aload_1
    //   267: athrow
    //   268: astore_1
    //   269: aload_0
    //   270: getfield 78	com/mongodb/DBTCPConnector:_myPort	Lcom/mongodb/DBTCPConnector$MyPort;
    //   273: aload 4
    //   275: aload_1
    //   276: invokevirtual 221	com/mongodb/DBTCPConnector$MyPort:error	(Lcom/mongodb/DBPort;Ljava/lang/Exception;)V
    //   279: aload_1
    //   280: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	this	DBTCPConnector
    //   0	281	1	paramDB	DB
    //   0	281	2	paramOutMessage	OutMessage
    //   0	281	3	paramWriteConcern	WriteConcern
    //   0	281	4	paramServerAddress	ServerAddress
    //   70	45	5	localWriteResult	WriteResult
    //   117	66	5	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   40	72	117	java/io/IOException
    //   88	101	117	java/io/IOException
    //   40	72	188	finally
    //   88	101	188	finally
    //   119	188	188	finally
    //   204	250	188	finally
    //   266	268	188	finally
    //   269	281	188	finally
    //   40	72	265	com/mongodb/MongoException
    //   88	101	265	com/mongodb/MongoException
    //   40	72	268	java/lang/RuntimeException
    //   88	101	268	java/lang/RuntimeException
  }
  
  /* Error */
  void setMaster(ConnectionStatus.Node paramNode)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 73	com/mongodb/DBTCPConnector:_closed	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual 296	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   9: istore_2
    //   10: iload_2
    //   11: ifeq +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: aload_1
    //   19: invokevirtual 545	com/mongodb/ConnectionStatus$Node:getServerAddress	()Lcom/mongodb/ServerAddress;
    //   22: invokespecial 125	com/mongodb/DBTCPConnector:setMasterAddress	(Lcom/mongodb/ServerAddress;)Z
    //   25: pop
    //   26: aload_0
    //   27: aload_1
    //   28: invokevirtual 547	com/mongodb/ConnectionStatus$Node:getMaxBsonObjectSize	()I
    //   31: putfield 366	com/mongodb/DBTCPConnector:_maxBsonObjectSize	I
    //   34: goto -20 -> 14
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	DBTCPConnector
    //   0	42	1	paramNode	ConnectionStatus.Node
    //   9	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	10	37	finally
    //   17	34	37	finally
  }
  
  public void start()
  {
    if (this._connectionStatus != null) {
      this._connectionStatus.start();
    }
  }
  
  public void updatePortPool(ServerAddress paramServerAddress)
  {
    this._portHolder._pools.remove(paramServerAddress);
  }
  
  class MyPort
  {
    private final ThreadLocal<DBTCPConnector.PinnedRequestStatus> pinnedRequestStatusThreadLocal = new ThreadLocal();
    
    MyPort() {}
    
    void done(DBPort paramDBPort)
    {
      if (paramDBPort != getPinnedRequestPortForThread()) {
        paramDBPort.getPool().done(paramDBPort);
      }
    }
    
    void error(DBPort paramDBPort, Exception paramException)
    {
      paramDBPort.close();
      this.pinnedRequestStatusThreadLocal.remove();
      if ((!paramDBPort.getPool().gotError(paramException)) && (DBTCPConnector.this._connectionStatus != null) && (DBTCPConnector.this._masterPortPool._addr.equals(paramDBPort.serverAddress())))
      {
        paramDBPort = DBTCPConnector.this._connectionStatus.ensureMaster();
        if (paramDBPort != null) {
          DBTCPConnector.this.setMaster(paramDBPort);
        }
      }
    }
    
    DBPort get(boolean paramBoolean, ReadPreference paramReadPreference, ServerAddress paramServerAddress)
    {
      Object localObject = getPinnedRequestPortForThread();
      if (paramServerAddress != null) {
        if ((localObject == null) || (!((DBPort)localObject).serverAddress().equals(paramServerAddress))) {}
      }
      do
      {
        return (DBPort)localObject;
        return DBTCPConnector.this._portHolder.get(paramServerAddress).get();
        if (localObject == null) {
          break;
        }
      } while ((((DBPort)localObject).getPool() == DBTCPConnector.this._masterPortPool) || (!paramBoolean));
      ((DBPort)localObject).getPool().done(localObject);
      setPinnedRequestPortForThread(null);
      if (DBTCPConnector.this.getReplicaSetStatus() == null) {
        if (DBTCPConnector.this._masterPortPool == null) {
          throw new MongoException("Rare case where master=null, probably all servers are down");
        }
      }
      for (paramReadPreference = DBTCPConnector.this._masterPortPool.get();; paramReadPreference = DBTCPConnector.this._portHolder.get(((ConnectionStatus.Node)localObject).getServerAddress()).get())
      {
        if (threadHasPinnedRequest()) {
          setPinnedRequestPortForThread(paramReadPreference);
        }
        return paramReadPreference;
        paramServerAddress = DBTCPConnector.this.getReplicaSetStatus()._replicaSetHolder.get();
        localObject = paramReadPreference.getNode(paramServerAddress);
        if (localObject == null) {
          throw new MongoException("No replica set members available in " + paramServerAddress + " for " + paramReadPreference.toDBObject().toString());
        }
      }
    }
    
    DBPort getPinnedRequestPortForThread()
    {
      if (threadHasPinnedRequest()) {
        return ((DBTCPConnector.PinnedRequestStatus)this.pinnedRequestStatusThreadLocal.get()).requestPort;
      }
      return null;
    }
    
    DBTCPConnector.PinnedRequestStatus getPinnedRequestStatusForThread()
    {
      return (DBTCPConnector.PinnedRequestStatus)this.pinnedRequestStatusThreadLocal.get();
    }
    
    void requestDone()
    {
      DBPort localDBPort = getPinnedRequestPortForThread();
      if (localDBPort != null) {
        localDBPort.getPool().done(localDBPort);
      }
      this.pinnedRequestStatusThreadLocal.remove();
    }
    
    void requestEnsureConnection()
    {
      if (!threadHasPinnedRequest()) {}
      while (getPinnedRequestPortForThread() != null) {
        return;
      }
      setPinnedRequestPortForThread(DBTCPConnector.this._masterPortPool.get());
    }
    
    void requestStart()
    {
      this.pinnedRequestStatusThreadLocal.set(new DBTCPConnector.PinnedRequestStatus());
    }
    
    void setPinnedRequestPortForThread(DBPort paramDBPort)
    {
      ((DBTCPConnector.PinnedRequestStatus)this.pinnedRequestStatusThreadLocal.get()).requestPort = paramDBPort;
    }
    
    boolean threadHasPinnedRequest()
    {
      return this.pinnedRequestStatusThreadLocal.get() != null;
    }
  }
  
  static class PinnedRequestStatus
  {
    DBPort requestPort;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/DBTCPConnector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */