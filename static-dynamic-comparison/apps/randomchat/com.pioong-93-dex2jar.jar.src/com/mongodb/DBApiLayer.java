package com.mongodb;

import com.mongodb.util.JSON;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;

public class DBApiLayer
  extends DB
{
  static final int NUM_CURSORS_BEFORE_KILL = 100;
  static final int NUM_CURSORS_PER_BATCH = 20000;
  static final Level TRACE_LEVEL;
  static final Logger TRACE_LOGGER = Logger.getLogger("com.mongodb.TRACE");
  final ConcurrentHashMap<String, MyCollection> _collections = new ConcurrentHashMap();
  final DBConnector _connector;
  ConcurrentLinkedQueue<DeadCursor> _deadCursorIds = new ConcurrentLinkedQueue();
  final String _root;
  final String _rootPlusDot;
  
  static
  {
    if (Boolean.getBoolean("DB.TRACE")) {}
    for (Level localLevel = Level.INFO;; localLevel = Level.FINEST)
    {
      TRACE_LEVEL = localLevel;
      return;
    }
  }
  
  protected DBApiLayer(Mongo paramMongo, String paramString, DBConnector paramDBConnector)
  {
    super(paramMongo, paramString);
    if (paramDBConnector == null) {
      throw new IllegalArgumentException("need a connector: " + paramString);
    }
    this._root = paramString;
    this._rootPlusDot = (this._root + ".");
    this._connector = paramDBConnector;
  }
  
  static int chooseBatchSize(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = Math.abs(paramInt1);
    if (paramInt2 > 0)
    {
      paramInt2 -= paramInt3;
      if ((i != 0) || (paramInt2 <= 0)) {
        break label46;
      }
    }
    for (;;)
    {
      paramInt3 = paramInt2;
      if (paramInt1 < 0) {
        paramInt3 = -paramInt2;
      }
      paramInt1 = paramInt3;
      if (paramInt3 == 1) {
        paramInt1 = -1;
      }
      return paramInt1;
      paramInt2 = 0;
      break;
      label46:
      if ((i > 0) && (paramInt2 == 0)) {
        paramInt2 = i;
      } else {
        paramInt2 = Math.min(i, paramInt2);
      }
    }
  }
  
  static void trace(String paramString)
  {
    TRACE_LOGGER.log(TRACE_LEVEL, paramString);
  }
  
  static boolean willTrace()
  {
    return TRACE_LOGGER.isLoggable(TRACE_LEVEL);
  }
  
  public void cleanCursors(boolean paramBoolean)
  {
    int i = this._deadCursorIds.size();
    if ((i == 0) || ((!paramBoolean) && (i < 100))) {
      return;
    }
    Bytes.LOGGER.info("going to kill cursors : " + i);
    HashMap localHashMap = new HashMap();
    Object localObject3;
    Object localObject2;
    for (;;)
    {
      localObject3 = (DeadCursor)this._deadCursorIds.poll();
      if (localObject3 == null) {
        break;
      }
      localObject2 = (List)localHashMap.get(((DeadCursor)localObject3).host);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new LinkedList();
        localHashMap.put(((DeadCursor)localObject3).host, localObject1);
      }
      ((List)localObject1).add(Long.valueOf(((DeadCursor)localObject3).id));
    }
    Object localObject1 = localHashMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      Iterator localIterator;
      try
      {
        killCursors((ServerAddress)((Map.Entry)localObject2).getKey(), (List)((Map.Entry)localObject2).getValue());
      }
      catch (Throwable localThrowable)
      {
        Bytes.LOGGER.log(Level.WARNING, "can't clean cursors", localThrowable);
        localIterator = ((List)((Map.Entry)localObject2).getValue()).iterator();
      }
      while (localIterator.hasNext())
      {
        localObject3 = (Long)localIterator.next();
        this._deadCursorIds.add(new DeadCursor(((Long)localObject3).longValue(), (ServerAddress)((Map.Entry)localObject2).getKey()));
      }
    }
  }
  
  CommandResult doAuthenticate(MongoCredential paramMongoCredential)
  {
    return this._connector.authenticate(paramMongoCredential);
  }
  
  protected MyCollection doGetCollection(String paramString)
  {
    MyCollection localMyCollection1 = (MyCollection)this._collections.get(paramString);
    if (localMyCollection1 != null) {
      paramString = localMyCollection1;
    }
    MyCollection localMyCollection2;
    do
    {
      return paramString;
      localMyCollection2 = new MyCollection(paramString);
      localMyCollection1 = (MyCollection)this._collections.putIfAbsent(paramString, localMyCollection2);
      paramString = localMyCollection1;
    } while (localMyCollection1 != null);
    return localMyCollection2;
  }
  
  void killCursors(ServerAddress paramServerAddress, List<Long> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    OutMessage localOutMessage = OutMessage.killCursors(this._mongo, Math.min(20000, paramList.size()));
    int i = 0;
    int j = 0;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      localOutMessage.writeLong(((Long)localIterator.next()).longValue());
      int k = j + 1;
      int m = i + 1;
      i = m;
      j = k;
      if (m >= 20000)
      {
        this._connector.say(this, localOutMessage, WriteConcern.NONE);
        localOutMessage = OutMessage.killCursors(this._mongo, Math.min(20000, paramList.size() - k));
        i = 0;
        j = k;
      }
    }
    this._connector.say(this, localOutMessage, WriteConcern.NONE, paramServerAddress);
  }
  
  public void requestDone()
  {
    this._connector.requestDone();
  }
  
  public void requestEnsureConnection()
  {
    this._connector.requestEnsureConnection();
  }
  
  public void requestStart()
  {
    this._connector.requestStart();
  }
  
  static class DeadCursor
  {
    final ServerAddress host;
    final long id;
    
    DeadCursor(long paramLong, ServerAddress paramServerAddress)
    {
      this.id = paramLong;
      this.host = paramServerAddress;
    }
  }
  
  class MyCollection
    extends DBCollection
  {
    final String _fullNameSpace;
    
    MyCollection(String paramString)
    {
      super(paramString);
      this._fullNameSpace = (DBApiLayer.this._root + "." + paramString);
    }
    
    Iterator<DBObject> __find(DBObject paramDBObject1, DBObject paramDBObject2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ReadPreference paramReadPreference, DBDecoder paramDBDecoder)
    {
      return __find(paramDBObject1, paramDBObject2, paramInt1, paramInt2, paramInt3, paramInt4, paramReadPreference, paramDBDecoder, DefaultDBEncoder.FACTORY.create());
    }
    
    Iterator<DBObject> __find(DBObject paramDBObject1, DBObject paramDBObject2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ReadPreference paramReadPreference, DBDecoder paramDBDecoder, DBEncoder paramDBEncoder)
    {
      Object localObject = paramDBObject1;
      if (paramDBObject1 == null) {
        localObject = new BasicDBObject();
      }
      if (DBApiLayer.willTrace()) {
        DBApiLayer.trace("find: " + this._fullNameSpace + " " + JSON.serialize(localObject));
      }
      paramDBObject1 = OutMessage.query(this, paramInt4, paramInt1, DBApiLayer.chooseBatchSize(paramInt2, paramInt3, 0), (DBObject)localObject, paramDBObject2, paramReadPreference, paramDBEncoder);
      paramDBObject1 = DBApiLayer.this._connector.call(this._db, this, paramDBObject1, null, 2, paramReadPreference, paramDBDecoder);
      if (paramDBObject1.size() == 1)
      {
        paramDBObject2 = MongoException.parse(paramDBObject1.get(0));
        if ((paramDBObject2 != null) && (!this._name.equals("$cmd"))) {
          throw paramDBObject2;
        }
      }
      return new DBApiLayer.Result(DBApiLayer.this, this, paramDBObject1, paramInt2, paramInt3, paramInt4, paramDBDecoder);
    }
    
    public void createIndex(DBObject paramDBObject1, DBObject paramDBObject2, DBEncoder paramDBEncoder)
    {
      DBEncoder localDBEncoder = paramDBEncoder;
      if (paramDBEncoder == null) {
        localDBEncoder = DefaultDBEncoder.FACTORY.create();
      }
      paramDBEncoder = new BasicDBObject();
      Iterator localIterator = paramDBObject2.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramDBEncoder.put(str, paramDBObject2.get(str));
      }
      paramDBEncoder.put("key", paramDBObject1);
      paramDBObject1 = DBApiLayer.this.doGetCollection("system.indexes");
      if (paramDBObject1.findOne(paramDBEncoder) == null) {
        paramDBObject1.insert(Arrays.asList(new DBObject[] { paramDBEncoder }), false, WriteConcern.SAFE, localDBEncoder);
      }
    }
    
    public void doapply(DBObject paramDBObject) {}
    
    public void drop()
    {
      DBApiLayer.this._collections.remove(getName());
      super.drop();
    }
    
    public WriteResult insert(List<DBObject> paramList, WriteConcern paramWriteConcern, DBEncoder paramDBEncoder)
    {
      if (paramWriteConcern == null) {
        throw new IllegalArgumentException("Write concern can not be null");
      }
      return insert(paramList, true, paramWriteConcern, paramDBEncoder);
    }
    
    protected WriteResult insert(List<DBObject> paramList, boolean paramBoolean, WriteConcern paramWriteConcern, DBEncoder paramDBEncoder)
    {
      DBEncoder localDBEncoder = paramDBEncoder;
      if (paramDBEncoder == null) {
        localDBEncoder = DefaultDBEncoder.FACTORY.create();
      }
      Object localObject;
      if (DBApiLayer.willTrace())
      {
        paramDBEncoder = paramList.iterator();
        while (paramDBEncoder.hasNext())
        {
          localObject = (DBObject)paramDBEncoder.next();
          DBApiLayer.trace("save:  " + this._fullNameSpace + " " + JSON.serialize(localObject));
        }
      }
      if (paramBoolean)
      {
        paramDBEncoder = paramList.iterator();
        while (paramDBEncoder.hasNext())
        {
          localObject = (DBObject)paramDBEncoder.next();
          apply((DBObject)localObject);
          _checkObject((DBObject)localObject, false, false);
          localObject = ((DBObject)localObject).get("_id");
          if ((localObject instanceof ObjectId)) {
            ((ObjectId)localObject).notNew();
          }
        }
      }
      paramDBEncoder = null;
      int i = 0;
      int k = DBApiLayer.this._mongo.getMaxBsonObjectSize();
      if (i < paramList.size())
      {
        paramDBEncoder = OutMessage.insert(this, localDBEncoder, paramWriteConcern);
        for (;;)
        {
          int j = i;
          if (i < paramList.size())
          {
            paramDBEncoder.putObject((DBObject)paramList.get(i));
            if (paramDBEncoder.size() > k * 2) {
              j = i + 1;
            }
          }
          else
          {
            paramDBEncoder = DBApiLayer.this._connector.say(this._db, paramDBEncoder, paramWriteConcern);
            i = j;
            break;
          }
          i += 1;
        }
      }
      return paramDBEncoder;
    }
    
    public WriteResult remove(DBObject paramDBObject, WriteConcern paramWriteConcern, DBEncoder paramDBEncoder)
    {
      if (paramWriteConcern == null) {
        throw new IllegalArgumentException("Write concern can not be null");
      }
      DBEncoder localDBEncoder = paramDBEncoder;
      if (paramDBEncoder == null) {
        localDBEncoder = DefaultDBEncoder.FACTORY.create();
      }
      if (DBApiLayer.willTrace()) {
        DBApiLayer.trace("remove: " + this._fullNameSpace + " " + JSON.serialize(paramDBObject));
      }
      paramDBObject = OutMessage.remove(this, localDBEncoder, paramDBObject);
      return DBApiLayer.this._connector.say(this._db, paramDBObject, paramWriteConcern);
    }
    
    public WriteResult update(DBObject paramDBObject1, DBObject paramDBObject2, boolean paramBoolean1, boolean paramBoolean2, WriteConcern paramWriteConcern, DBEncoder paramDBEncoder)
    {
      if (paramDBObject2 == null) {
        throw new IllegalArgumentException("update can not be null");
      }
      if (paramWriteConcern == null) {
        throw new IllegalArgumentException("Write concern can not be null");
      }
      DBEncoder localDBEncoder = paramDBEncoder;
      if (paramDBEncoder == null) {
        localDBEncoder = DefaultDBEncoder.FACTORY.create();
      }
      if ((!paramDBObject2.keySet().isEmpty()) && (!((String)paramDBObject2.keySet().iterator().next()).startsWith("$"))) {
        _checkObject(paramDBObject2, false, false);
      }
      if (DBApiLayer.willTrace()) {
        DBApiLayer.trace("update: " + this._fullNameSpace + " " + JSON.serialize(paramDBObject1) + " " + JSON.serialize(paramDBObject2));
      }
      paramDBObject1 = OutMessage.update(this, localDBEncoder, paramBoolean1, paramBoolean2, paramDBObject1, paramDBObject2);
      return DBApiLayer.this._connector.say(this._db, paramDBObject1, paramWriteConcern);
    }
  }
  
  class Result
    implements Iterator<DBObject>
  {
    int _batchSize;
    final DBApiLayer.MyCollection _collection;
    Iterator<DBObject> _cur;
    Response _curResult;
    final DBDecoder _decoder;
    final ServerAddress _host;
    int _limit;
    private int _numFetched = 0;
    private int _numGetMores = 0;
    private final OptionalFinalizer _optionalFinalizer;
    final int _options;
    private List<Integer> _sizes = new ArrayList();
    private long _totalBytes = 0L;
    
    Result(DBApiLayer.MyCollection paramMyCollection, Response paramResponse, int paramInt1, int paramInt2, int paramInt3, DBDecoder paramDBDecoder)
    {
      this._collection = paramMyCollection;
      this._batchSize = paramInt1;
      this._limit = paramInt2;
      this._options = paramInt3;
      this._host = paramResponse._host;
      this._decoder = paramDBDecoder;
      init(paramResponse);
      if ((DBApiLayer.this._mongo.getMongoOptions().isCursorFinalizerEnabled()) && (paramResponse.cursor() != 0L)) {}
      for (this$1 = new OptionalFinalizer(null);; this$1 = null)
      {
        this._optionalFinalizer = DBApiLayer.this;
        return;
      }
    }
    
    private void _advance()
    {
      if (this._curResult.cursor() <= 0L) {
        throw new RuntimeException("can't advance a cursor <= 0");
      }
      Object localObject = OutMessage.getMore(this._collection, this._curResult.cursor(), DBApiLayer.chooseBatchSize(this._batchSize, this._limit, this._numFetched));
      localObject = DBApiLayer.this._connector.call(DBApiLayer.this, this._collection, (OutMessage)localObject, this._host, this._decoder);
      this._numGetMores += 1;
      init((Response)localObject);
    }
    
    private void init(Response paramResponse)
    {
      if ((paramResponse._flags & 0x1) > 0) {
        throw new MongoException.CursorNotFound(this._curResult.cursor(), paramResponse.serverUsed());
      }
      this._totalBytes += paramResponse._len;
      this._curResult = paramResponse;
      this._cur = paramResponse.iterator();
      this._sizes.add(Integer.valueOf(paramResponse.size()));
      this._numFetched += paramResponse.size();
      if ((paramResponse._cursor != 0L) && (this._limit > 0) && (this._limit - this._numFetched <= 0)) {
        killCursor();
      }
    }
    
    void close()
    {
      if (this._curResult != null)
      {
        killCursor();
        this._curResult = null;
        this._cur = null;
      }
    }
    
    public int getBatchSize()
    {
      return this._batchSize;
    }
    
    public long getCursorId()
    {
      if (this._curResult == null) {
        return 0L;
      }
      return this._curResult._cursor;
    }
    
    public ServerAddress getServerAddress()
    {
      return this._host;
    }
    
    List<Integer> getSizes()
    {
      return Collections.unmodifiableList(this._sizes);
    }
    
    boolean hasFinalizer()
    {
      return this._optionalFinalizer != null;
    }
    
    public boolean hasNext()
    {
      boolean bool1 = this._cur.hasNext();
      while (!bool1)
      {
        if (!this._curResult.hasGetMore(this._options)) {}
        boolean bool2;
        do
        {
          return false;
          _advance();
          bool2 = this._cur.hasNext();
          bool1 = bool2;
          if (bool2) {
            break;
          }
        } while ((this._options & 0x20) == 0);
        bool1 = bool2;
        if ((this._curResult._flags & 0x8) == 0) {
          try
          {
            Thread.sleep(500L);
            bool1 = bool2;
          }
          catch (InterruptedException localInterruptedException)
          {
            throw new MongoInterruptedException(localInterruptedException);
          }
        }
      }
      return bool1;
    }
    
    void killCursor()
    {
      if (this._curResult == null) {}
      long l;
      do
      {
        return;
        l = this._curResult.cursor();
      } while (l == 0L);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(l));
      try
      {
        DBApiLayer.this.killCursors(this._host, localArrayList);
        this._curResult._cursor = 0L;
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Bytes.LOGGER.log(Level.WARNING, "can't clean 1 cursor", localThrowable);
          DBApiLayer.this._deadCursorIds.add(new DBApiLayer.DeadCursor(l, this._host));
        }
      }
    }
    
    public DBObject next()
    {
      if (this._cur.hasNext()) {
        return (DBObject)this._cur.next();
      }
      if (!this._curResult.hasGetMore(this._options)) {
        throw new NoSuchElementException("no more");
      }
      _advance();
      return next();
    }
    
    int numGetMores()
    {
      return this._numGetMores;
    }
    
    public void remove()
    {
      throw new RuntimeException("can't remove this way");
    }
    
    public void setBatchSize(int paramInt)
    {
      this._batchSize = paramInt;
    }
    
    public String toString()
    {
      return "DBCursor";
    }
    
    public long totalBytes()
    {
      return this._totalBytes;
    }
    
    private class OptionalFinalizer
    {
      private OptionalFinalizer() {}
      
      protected void finalize()
      {
        if (DBApiLayer.Result.this._curResult != null)
        {
          long l = DBApiLayer.Result.this._curResult.cursor();
          DBApiLayer.Result.this._curResult = null;
          DBApiLayer.Result.this._cur = null;
          if (l != 0L) {
            DBApiLayer.this._deadCursorIds.add(new DBApiLayer.DeadCursor(l, DBApiLayer.Result.this._host));
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/DBApiLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */