package com.mongodb;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;
import org.bson.io.PoolOutputBuffer;
import org.bson.util.SimplePool;

public class Mongo
{
  private static final String ADMIN_DATABASE_NAME = "admin";
  private static final String FULL_VERSION = "2.11.1";
  @Deprecated
  public static final int MAJOR_VERSION = 2;
  @Deprecated
  public static final int MINOR_VERSION = 11;
  static int cleanerIntervalMS = Integer.parseInt(System.getProperty("com.mongodb.cleanerIntervalMS", "1000"));
  static Logger logger = Logger.getLogger(Bytes.LOGGER.getName() + ".Mongo");
  final MongoAuthority _authority;
  SimplePool<PoolOutputBuffer> _bufferPool = new SimplePool(1000)
  {
    protected PoolOutputBuffer createNew()
    {
      return new PoolOutputBuffer();
    }
  };
  final CursorCleanerThread _cleaner;
  private WriteConcern _concern = WriteConcern.NORMAL;
  final DBTCPConnector _connector;
  final ConcurrentMap<String, DB> _dbs = new ConcurrentHashMap();
  final Bytes.OptionHolder _netOptions = new Bytes.OptionHolder(null);
  final MongoOptions _options;
  private ReadPreference _readPref = ReadPreference.primary();
  
  @Deprecated
  public Mongo()
    throws UnknownHostException
  {
    this(new ServerAddress());
  }
  
  Mongo(MongoAuthority paramMongoAuthority, MongoOptions paramMongoOptions)
  {
    logger.info("Creating Mongo instance (driver version " + getVersion() + ") with authority " + paramMongoAuthority + " and options " + paramMongoOptions);
    this._authority = paramMongoAuthority;
    this._options = paramMongoOptions;
    _applyMongoOptions();
    this._connector = new DBTCPConnector(this);
    this._connector.start();
    if (this._options.cursorFinalizerEnabled)
    {
      this._cleaner = new CursorCleanerThread();
      this._cleaner.start();
      return;
    }
    this._cleaner = null;
  }
  
  @Deprecated
  public Mongo(MongoURI paramMongoURI)
    throws UnknownHostException
  {
    this(getMongoAuthorityFromURI(paramMongoURI), paramMongoURI.getOptions());
  }
  
  @Deprecated
  public Mongo(ServerAddress paramServerAddress)
  {
    this(paramServerAddress, new MongoOptions());
  }
  
  @Deprecated
  public Mongo(ServerAddress paramServerAddress, MongoOptions paramMongoOptions)
  {
    this(MongoAuthority.direct(paramServerAddress), paramMongoOptions);
  }
  
  @Deprecated
  public Mongo(ServerAddress paramServerAddress1, ServerAddress paramServerAddress2)
  {
    this(paramServerAddress1, paramServerAddress2, new MongoOptions());
  }
  
  @Deprecated
  public Mongo(ServerAddress paramServerAddress1, ServerAddress paramServerAddress2, MongoOptions paramMongoOptions)
  {
    this(MongoAuthority.dynamicSet(Arrays.asList(new ServerAddress[] { paramServerAddress1, paramServerAddress2 })), paramMongoOptions);
  }
  
  @Deprecated
  public Mongo(String paramString)
    throws UnknownHostException
  {
    this(new ServerAddress(paramString));
  }
  
  @Deprecated
  public Mongo(String paramString, int paramInt)
    throws UnknownHostException
  {
    this(new ServerAddress(paramString, paramInt));
  }
  
  @Deprecated
  public Mongo(String paramString, MongoOptions paramMongoOptions)
    throws UnknownHostException
  {
    this(new ServerAddress(paramString), paramMongoOptions);
  }
  
  @Deprecated
  public Mongo(List<ServerAddress> paramList)
  {
    this(paramList, new MongoOptions());
  }
  
  @Deprecated
  public Mongo(List<ServerAddress> paramList, MongoOptions paramMongoOptions)
  {
    this(MongoAuthority.dynamicSet(paramList), paramMongoOptions);
  }
  
  public static DB connect(DBAddress paramDBAddress)
  {
    return new Mongo(paramDBAddress).getDB(paramDBAddress.getDBName());
  }
  
  public static int getMajorVersion()
  {
    return 2;
  }
  
  public static int getMinorVersion()
  {
    return 11;
  }
  
  private static MongoAuthority getMongoAuthorityFromURI(MongoURI paramMongoURI)
    throws UnknownHostException
  {
    if (paramMongoURI.getHosts().size() == 1) {
      return MongoAuthority.direct(new ServerAddress((String)paramMongoURI.getHosts().get(0)), paramMongoURI.getCredentials());
    }
    ArrayList localArrayList = new ArrayList(paramMongoURI.getHosts().size());
    Iterator localIterator = paramMongoURI.getHosts().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new ServerAddress((String)localIterator.next()));
    }
    return MongoAuthority.dynamicSet(localArrayList, paramMongoURI.getCredentials());
  }
  
  void _applyMongoOptions()
  {
    if (this._options.slaveOk) {
      slaveOk();
    }
    if (this._options.getReadPreference() != null) {
      setReadPreference(this._options.getReadPreference());
    }
    setWriteConcern(this._options.getWriteConcern());
  }
  
  public void addOption(int paramInt)
  {
    this._netOptions.add(paramInt);
  }
  
  public void close()
  {
    try
    {
      this._connector.close();
      if (this._cleaner != null) {
        this._cleaner.interrupt();
      }
      try
      {
        this._cleaner.join();
        return;
      }
      catch (InterruptedException localInterruptedException) {}
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public String debugString()
  {
    return this._connector.debugString();
  }
  
  public void dropDatabase(String paramString)
  {
    getDB(paramString).dropDatabase();
  }
  
  public CommandResult fsync(boolean paramBoolean)
  {
    BasicDBObject localBasicDBObject = new BasicDBObject("fsync", Integer.valueOf(1));
    if (paramBoolean) {
      localBasicDBObject.put("async", Integer.valueOf(1));
    }
    return getDB("admin").command(localBasicDBObject);
  }
  
  public CommandResult fsyncAndLock()
  {
    BasicDBObject localBasicDBObject = new BasicDBObject("fsync", Integer.valueOf(1));
    localBasicDBObject.put("lock", Integer.valueOf(1));
    return getDB("admin").command(localBasicDBObject);
  }
  
  public ServerAddress getAddress()
  {
    return this._connector.getAddress();
  }
  
  public List<ServerAddress> getAllAddress()
  {
    List localList2 = this._connector.getAllAddress();
    List localList1 = localList2;
    if (localList2 == null) {
      localList1 = Arrays.asList(new ServerAddress[] { getAddress() });
    }
    return localList1;
  }
  
  MongoAuthority getAuthority()
  {
    return this._authority;
  }
  
  public String getConnectPoint()
  {
    return this._connector.getConnectPoint();
  }
  
  public DBTCPConnector getConnector()
  {
    return this._connector;
  }
  
  public DB getDB(String paramString)
  {
    DB localDB = (DB)this._dbs.get(paramString);
    if (localDB != null) {
      paramString = localDB;
    }
    DBApiLayer localDBApiLayer;
    do
    {
      return paramString;
      localDBApiLayer = new DBApiLayer(this, paramString, this._connector);
      localDB = (DB)this._dbs.putIfAbsent(paramString, localDBApiLayer);
      paramString = localDB;
    } while (localDB != null);
    return localDBApiLayer;
  }
  
  public List<String> getDatabaseNames()
  {
    Object localObject1 = new BasicDBObject();
    ((BasicDBObject)localObject1).put("listDatabases", Integer.valueOf(1));
    localObject1 = getDB("admin").command((DBObject)localObject1, getOptions());
    ((CommandResult)localObject1).throwOnError();
    Object localObject2 = (List)((CommandResult)localObject1).get("databases");
    localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(((BasicDBObject)((Iterator)localObject2).next()).getString("name"));
    }
    return (List<String>)localObject1;
  }
  
  public int getMaxBsonObjectSize()
  {
    if (this._connector.getMaxBsonObjectSize() == 0) {
      this._connector.initDirectConnection();
    }
    int i = this._connector.getMaxBsonObjectSize();
    if (i > 0) {
      return i;
    }
    return 4194304;
  }
  
  public MongoOptions getMongoOptions()
  {
    return this._options;
  }
  
  public int getOptions()
  {
    return this._netOptions.get();
  }
  
  public ReadPreference getReadPreference()
  {
    return this._readPref;
  }
  
  public ReplicaSetStatus getReplicaSetStatus()
  {
    return this._connector.getReplicaSetStatus();
  }
  
  public List<ServerAddress> getServerAddressList()
  {
    return this._connector.getServerAddressList();
  }
  
  public Collection<DB> getUsedDatabases()
  {
    return this._dbs.values();
  }
  
  public String getVersion()
  {
    return "2.11.1";
  }
  
  public WriteConcern getWriteConcern()
  {
    return this._concern;
  }
  
  public boolean isLocked()
  {
    BasicDBObject localBasicDBObject = (BasicDBObject)getDB("admin").getCollection("$cmd.sys.inprog").findOne();
    if (localBasicDBObject.containsField("fsyncLock")) {
      return localBasicDBObject.getInt("fsyncLock") == 1;
    }
    return false;
  }
  
  boolean isMongosConnection()
  {
    return this._connector.isMongosConnection();
  }
  
  public void resetOptions()
  {
    this._netOptions.reset();
  }
  
  public void setOptions(int paramInt)
  {
    this._netOptions.set(paramInt);
  }
  
  public void setReadPreference(ReadPreference paramReadPreference)
  {
    this._readPref = paramReadPreference;
  }
  
  public void setWriteConcern(WriteConcern paramWriteConcern)
  {
    this._concern = paramWriteConcern;
  }
  
  @Deprecated
  public void slaveOk()
  {
    addOption(4);
  }
  
  public String toString()
  {
    return "Mongo{authority=" + this._authority + ", options=" + this._options + '}';
  }
  
  public DBObject unlock()
  {
    return getDB("admin").getCollection("$cmd.sys.unlock").findOne();
  }
  
  class CursorCleanerThread
    extends Thread
  {
    CursorCleanerThread()
    {
      setDaemon(true);
      setName("MongoCleaner" + hashCode());
    }
    
    public void run()
    {
      for (;;)
      {
        if (Mongo.this._connector.isOpen()) {}
        try
        {
          Thread.sleep(Mongo.cleanerIntervalMS);
          Iterator localIterator = Mongo.this._dbs.values().iterator();
          while (localIterator.hasNext()) {
            ((DB)localIterator.next()).cleanCursors(true);
          }
        }
        catch (Throwable localThrowable)
        {
          continue;
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;) {}
        }
      }
    }
  }
  
  public static class Holder
  {
    private static Holder _default = new Holder();
    private final ConcurrentMap<String, Mongo> _mongos = new ConcurrentHashMap();
    
    public static Holder singleton()
    {
      return _default;
    }
    
    String _toKey(MongoURI paramMongoURI)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = paramMongoURI.getHosts().iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append((String)localIterator.next()).append(",");
      }
      localStringBuilder.append(paramMongoURI.getOptions());
      localStringBuilder.append(paramMongoURI.getUsername());
      return localStringBuilder.toString();
    }
    
    public Mongo connect(MongoURI paramMongoURI)
      throws UnknownHostException
    {
      Object localObject = _toKey(paramMongoURI);
      Mongo localMongo = (Mongo)this._mongos.get(localObject);
      if (localMongo != null) {
        return localMongo;
      }
      paramMongoURI = new Mongo(paramMongoURI);
      localObject = (Mongo)this._mongos.putIfAbsent(localObject, paramMongoURI);
      if (localObject == null) {
        return paramMongoURI;
      }
      paramMongoURI.close();
      return (Mongo)localObject;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/Mongo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */