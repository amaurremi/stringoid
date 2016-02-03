package com.mongodb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bson.LazyDBList;
import org.bson.types.ObjectId;

public abstract class DBCollection
{
  private WriteConcern _concern = null;
  private final Set<String> _createdIndexes = new HashSet();
  final DB _db;
  private DBDecoderFactory _decoderFactory;
  private DBEncoderFactory _encoderFactory;
  protected final String _fullName;
  protected List<DBObject> _hintFields;
  private Map<String, Class> _internalClass = Collections.synchronizedMap(new HashMap());
  protected final String _name;
  protected Class _objectClass = null;
  final Bytes.OptionHolder _options;
  private ReadPreference _readPref = null;
  private ReflectionDBObject.JavaWrapper _wrapper = null;
  
  protected DBCollection(DB paramDB, String paramString)
  {
    this._db = paramDB;
    this._name = paramString;
    this._fullName = (this._db.getName() + "." + paramString);
    this._options = new Bytes.OptionHolder(this._db._options);
  }
  
  private void _checkKeys(DBObject paramDBObject)
  {
    if (((paramDBObject instanceof LazyDBObject)) || ((paramDBObject instanceof LazyDBList))) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramDBObject.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        validateKey((String)localObject);
        localObject = paramDBObject.get((String)localObject);
        if ((localObject instanceof DBObject)) {
          _checkKeys((DBObject)localObject);
        } else if ((localObject instanceof Map)) {
          _checkKeys((Map)localObject);
        }
      }
    }
  }
  
  private void _checkKeys(Map<String, Object> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      validateKey((String)localObject);
      localObject = paramMap.get(localObject);
      if ((localObject instanceof DBObject)) {
        _checkKeys((DBObject)localObject);
      } else if ((localObject instanceof Map)) {
        _checkKeys((Map)localObject);
      }
    }
  }
  
  public static String genIndexName(DBObject paramDBObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramDBObject.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append('_');
      }
      localStringBuilder.append((String)localObject).append('_');
      localObject = paramDBObject.get((String)localObject);
      if (((localObject instanceof Number)) || ((localObject instanceof String))) {
        localStringBuilder.append(localObject.toString().replace(' ', '_'));
      }
    }
    return localStringBuilder.toString();
  }
  
  private DBEncoder getDBEncoder()
  {
    if (getDBEncoderFactory() != null) {
      return getDBEncoderFactory().create();
    }
    return null;
  }
  
  private DBDecoder getDecoder()
  {
    if (getDBDecoderFactory() != null) {
      return getDBDecoderFactory().create();
    }
    return null;
  }
  
  private DBObject instantiateObjectClassInstance()
  {
    try
    {
      DBObject localDBObject = (DBObject)getObjectClass().newInstance();
      return localDBObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new MongoInternalException("can't create instance of type " + getObjectClass(), localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new MongoInternalException("can't create instance of type " + getObjectClass(), localIllegalAccessException);
    }
  }
  
  private DBObject replaceWithObjectClass(DBObject paramDBObject)
  {
    if (paramDBObject != null) {
      if (getObjectClass() != null) {
        break label31;
      }
    }
    Object localObject;
    label31:
    for (int i = 1; (i & this._internalClass.isEmpty()) != 0; i = 0)
    {
      localObject = paramDBObject;
      return (DBObject)localObject;
    }
    DBObject localDBObject = instantiateObjectClassInstance();
    Iterator localIterator = paramDBObject.keySet().iterator();
    for (;;)
    {
      localObject = localDBObject;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (String)localIterator.next();
      localDBObject.put((String)localObject, paramDBObject.get((String)localObject));
    }
  }
  
  private void validateKey(String paramString)
  {
    if (paramString.contains(".")) {
      throw new IllegalArgumentException("fields stored in the db can't have . in them. (Bad Key: '" + paramString + "')");
    }
    if (paramString.startsWith("$")) {
      throw new IllegalArgumentException("fields stored in the db can't start with '$' (Bad Key: '" + paramString + "')");
    }
  }
  
  abstract Iterator<DBObject> __find(DBObject paramDBObject1, DBObject paramDBObject2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ReadPreference paramReadPreference, DBDecoder paramDBDecoder);
  
  abstract Iterator<DBObject> __find(DBObject paramDBObject1, DBObject paramDBObject2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ReadPreference paramReadPreference, DBDecoder paramDBDecoder, DBEncoder paramDBEncoder);
  
  protected DBObject _checkObject(DBObject paramDBObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    DBObject localDBObject;
    if (paramDBObject == null) {
      if (paramBoolean1) {
        localDBObject = null;
      }
    }
    do
    {
      return localDBObject;
      throw new IllegalArgumentException("can't be null");
      if ((paramDBObject.isPartialObject()) && (!paramBoolean2)) {
        throw new IllegalArgumentException("can't save partial objects");
      }
      localDBObject = paramDBObject;
    } while (paramBoolean2);
    _checkKeys(paramDBObject);
    return paramDBObject;
  }
  
  public void addOption(int paramInt)
  {
    this._options.add(paramInt);
  }
  
  public AggregationOutput aggregate(DBObject paramDBObject, DBObject... paramVarArgs)
  {
    if (paramDBObject == null) {
      throw new IllegalArgumentException("aggregate can not accept null pipeline operation");
    }
    BasicDBObject localBasicDBObject = new BasicDBObject("aggregate", this._name);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramDBObject);
    Collections.addAll(localArrayList, paramVarArgs);
    localBasicDBObject.put("pipeline", localArrayList);
    paramDBObject = this._db.command(localBasicDBObject, getOptions(), getReadPreference());
    paramDBObject.throwOnError();
    return new AggregationOutput(localBasicDBObject, paramDBObject);
  }
  
  public Object apply(DBObject paramDBObject)
  {
    return apply(paramDBObject, true);
  }
  
  public Object apply(DBObject paramDBObject, boolean paramBoolean)
  {
    Object localObject2 = paramDBObject.get("_id");
    Object localObject1 = localObject2;
    if (paramBoolean)
    {
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = ObjectId.get();
        paramDBObject.put("_id", localObject1);
      }
    }
    doapply(paramDBObject);
    return localObject1;
  }
  
  protected boolean checkReadOnly(boolean paramBoolean)
  {
    if (!this._db._readOnly) {
      return false;
    }
    if (!paramBoolean) {
      return true;
    }
    throw new IllegalStateException("db is read only");
  }
  
  CommandResult command(DBObject paramDBObject, int paramInt, ReadPreference paramReadPreference)
  {
    return this._db.command(paramDBObject, getOptions(), paramReadPreference);
  }
  
  public long count()
  {
    return getCount(new BasicDBObject(), null);
  }
  
  public long count(DBObject paramDBObject)
  {
    return getCount(paramDBObject, null);
  }
  
  public long count(DBObject paramDBObject, ReadPreference paramReadPreference)
  {
    return getCount(paramDBObject, null, paramReadPreference);
  }
  
  public void createIndex(DBObject paramDBObject)
  {
    createIndex(paramDBObject, defaultOptions(paramDBObject));
  }
  
  public void createIndex(DBObject paramDBObject1, DBObject paramDBObject2)
  {
    createIndex(paramDBObject1, paramDBObject2, getDBEncoder());
  }
  
  public abstract void createIndex(DBObject paramDBObject1, DBObject paramDBObject2, DBEncoder paramDBEncoder);
  
  DBObject defaultOptions(DBObject paramDBObject)
  {
    BasicDBObject localBasicDBObject = new BasicDBObject();
    localBasicDBObject.put("name", genIndexName(paramDBObject));
    localBasicDBObject.put("ns", this._fullName);
    return localBasicDBObject;
  }
  
  public List distinct(String paramString)
  {
    return distinct(paramString, new BasicDBObject());
  }
  
  public List distinct(String paramString, DBObject paramDBObject)
  {
    return distinct(paramString, paramDBObject, getReadPreference());
  }
  
  public List distinct(String paramString, DBObject paramDBObject, ReadPreference paramReadPreference)
  {
    paramString = BasicDBObjectBuilder.start().add("distinct", getName()).add("key", paramString).add("query", paramDBObject).get();
    paramString = this._db.command(paramString, getOptions(), paramReadPreference);
    paramString.throwOnError();
    return (List)paramString.get("values");
  }
  
  public List distinct(String paramString, ReadPreference paramReadPreference)
  {
    return distinct(paramString, new BasicDBObject(), paramReadPreference);
  }
  
  protected abstract void doapply(DBObject paramDBObject);
  
  public void drop()
  {
    resetIndexCache();
    CommandResult localCommandResult = this._db.command(BasicDBObjectBuilder.start().add("drop", getName()).get());
    if ((localCommandResult.ok()) || (localCommandResult.getErrorMessage().equals("ns not found"))) {
      return;
    }
    localCommandResult.throwOnError();
  }
  
  public void dropIndex(DBObject paramDBObject)
  {
    dropIndexes(genIndexName(paramDBObject));
  }
  
  public void dropIndex(String paramString)
  {
    dropIndexes(paramString);
  }
  
  public void dropIndexes()
  {
    dropIndexes("*");
  }
  
  public void dropIndexes(String paramString)
  {
    paramString = BasicDBObjectBuilder.start().add("deleteIndexes", getName()).add("index", paramString).get();
    resetIndexCache();
    paramString = this._db.command(paramString);
    if ((paramString.ok()) || (paramString.getErrorMessage().equals("ns not found"))) {
      return;
    }
    paramString.throwOnError();
  }
  
  public void ensureIndex(DBObject paramDBObject)
  {
    ensureIndex(paramDBObject, defaultOptions(paramDBObject));
  }
  
  public void ensureIndex(DBObject paramDBObject1, DBObject paramDBObject2)
  {
    if (checkReadOnly(false)) {}
    DBObject localDBObject;
    do
    {
      return;
      localDBObject = defaultOptions(paramDBObject1);
      Iterator localIterator = paramDBObject2.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localDBObject.put(str, paramDBObject2.get(str));
      }
      paramDBObject2 = localDBObject.get("name").toString();
    } while (this._createdIndexes.contains(paramDBObject2));
    createIndex(paramDBObject1, localDBObject);
    this._createdIndexes.add(paramDBObject2);
  }
  
  public void ensureIndex(DBObject paramDBObject, String paramString)
  {
    ensureIndex(paramDBObject, paramString, false);
  }
  
  public void ensureIndex(DBObject paramDBObject, String paramString, boolean paramBoolean)
  {
    DBObject localDBObject = defaultOptions(paramDBObject);
    if ((paramString != null) && (paramString.length() > 0)) {
      localDBObject.put("name", paramString);
    }
    if (paramBoolean) {
      localDBObject.put("unique", Boolean.TRUE);
    }
    ensureIndex(paramDBObject, localDBObject);
  }
  
  public void ensureIndex(String paramString)
  {
    ensureIndex(new BasicDBObject(paramString, Integer.valueOf(1)));
  }
  
  public boolean equals(Object paramObject)
  {
    return paramObject == this;
  }
  
  public DBCursor find()
  {
    return new DBCursor(this, null, null, getReadPreference());
  }
  
  public DBCursor find(DBObject paramDBObject)
  {
    return new DBCursor(this, paramDBObject, null, getReadPreference());
  }
  
  public DBCursor find(DBObject paramDBObject1, DBObject paramDBObject2)
  {
    return new DBCursor(this, paramDBObject1, paramDBObject2, getReadPreference());
  }
  
  @Deprecated
  public DBCursor find(DBObject paramDBObject1, DBObject paramDBObject2, int paramInt1, int paramInt2)
  {
    return find(paramDBObject1, paramDBObject2).skip(paramInt1).batchSize(paramInt2);
  }
  
  @Deprecated
  public DBCursor find(DBObject paramDBObject1, DBObject paramDBObject2, int paramInt1, int paramInt2, int paramInt3)
  {
    return find(paramDBObject1, paramDBObject2, paramInt1, paramInt2).addOption(paramInt3);
  }
  
  public DBObject findAndModify(DBObject paramDBObject1, DBObject paramDBObject2)
  {
    return findAndModify(paramDBObject1, null, null, false, paramDBObject2, false, false);
  }
  
  public DBObject findAndModify(DBObject paramDBObject1, DBObject paramDBObject2, DBObject paramDBObject3)
  {
    return findAndModify(paramDBObject1, null, paramDBObject2, false, paramDBObject3, false, false);
  }
  
  public DBObject findAndModify(DBObject paramDBObject1, DBObject paramDBObject2, DBObject paramDBObject3, boolean paramBoolean1, DBObject paramDBObject4, boolean paramBoolean2, boolean paramBoolean3)
  {
    BasicDBObject localBasicDBObject = new BasicDBObject("findandmodify", this._name);
    if ((paramDBObject1 != null) && (!paramDBObject1.keySet().isEmpty())) {
      localBasicDBObject.append("query", paramDBObject1);
    }
    if ((paramDBObject2 != null) && (!paramDBObject2.keySet().isEmpty())) {
      localBasicDBObject.append("fields", paramDBObject2);
    }
    if ((paramDBObject3 != null) && (!paramDBObject3.keySet().isEmpty())) {
      localBasicDBObject.append("sort", paramDBObject3);
    }
    if (paramBoolean1) {
      localBasicDBObject.append("remove", Boolean.valueOf(paramBoolean1));
    }
    while ((paramBoolean1) && (paramDBObject4 != null) && (!paramDBObject4.keySet().isEmpty()) && (!paramBoolean2))
    {
      throw new MongoException("FindAndModify: Remove cannot be mixed with the Update, or returnNew params!");
      if ((paramDBObject4 != null) && (!paramDBObject4.keySet().isEmpty()))
      {
        if (((String)paramDBObject4.keySet().iterator().next()).charAt(0) != '$') {
          _checkObject(paramDBObject4, false, false);
        }
        localBasicDBObject.append("update", paramDBObject4);
      }
      if (paramBoolean2) {
        localBasicDBObject.append("new", Boolean.valueOf(paramBoolean2));
      }
      if (paramBoolean3) {
        localBasicDBObject.append("upsert", Boolean.valueOf(paramBoolean3));
      }
    }
    paramDBObject1 = this._db.command(localBasicDBObject);
    if ((paramDBObject1.ok()) || (paramDBObject1.getErrorMessage().equals("No matching object found"))) {
      return replaceWithObjectClass((DBObject)paramDBObject1.get("value"));
    }
    paramDBObject1.throwOnError();
    return null;
  }
  
  public DBObject findAndRemove(DBObject paramDBObject)
  {
    return findAndModify(paramDBObject, null, null, true, null, false, false);
  }
  
  public DBObject findOne()
  {
    return findOne(new BasicDBObject());
  }
  
  public DBObject findOne(DBObject paramDBObject)
  {
    return findOne(paramDBObject, null, null, getReadPreference());
  }
  
  public DBObject findOne(DBObject paramDBObject1, DBObject paramDBObject2)
  {
    return findOne(paramDBObject1, paramDBObject2, null, getReadPreference());
  }
  
  public DBObject findOne(DBObject paramDBObject1, DBObject paramDBObject2, DBObject paramDBObject3)
  {
    return findOne(paramDBObject1, paramDBObject2, paramDBObject3, getReadPreference());
  }
  
  public DBObject findOne(DBObject paramDBObject1, DBObject paramDBObject2, DBObject paramDBObject3, ReadPreference paramReadPreference)
  {
    paramDBObject1 = new QueryOpBuilder().addQuery(paramDBObject1).addOrderBy(paramDBObject3);
    if (getDB().getMongo().isMongosConnection()) {
      paramDBObject1.addReadPreference(paramReadPreference.toDBObject());
    }
    paramDBObject1 = __find(paramDBObject1.get(), paramDBObject2, 0, -1, 0, getOptions(), paramReadPreference, getDecoder());
    if (paramDBObject1.hasNext()) {}
    for (paramDBObject1 = (DBObject)paramDBObject1.next();; paramDBObject1 = null)
    {
      if ((paramDBObject1 != null) && (paramDBObject2 != null) && (paramDBObject2.keySet().size() > 0)) {
        paramDBObject1.markAsPartialObject();
      }
      return paramDBObject1;
    }
  }
  
  public DBObject findOne(DBObject paramDBObject1, DBObject paramDBObject2, ReadPreference paramReadPreference)
  {
    return findOne(paramDBObject1, paramDBObject2, null, paramReadPreference);
  }
  
  public DBObject findOne(Object paramObject)
  {
    return findOne(paramObject, null);
  }
  
  public DBObject findOne(Object paramObject, DBObject paramDBObject)
  {
    paramObject = __find(new BasicDBObject("_id", paramObject), paramDBObject, 0, -1, 0, getOptions(), getReadPreference(), getDecoder());
    if (((Iterator)paramObject).hasNext()) {
      return (DBObject)((Iterator)paramObject).next();
    }
    return null;
  }
  
  public DBCollection getCollection(String paramString)
  {
    return this._db.getCollection(this._name + "." + paramString);
  }
  
  public long getCount()
  {
    return getCount(new BasicDBObject(), null);
  }
  
  public long getCount(DBObject paramDBObject)
  {
    return getCount(paramDBObject, null);
  }
  
  public long getCount(DBObject paramDBObject1, DBObject paramDBObject2)
  {
    return getCount(paramDBObject1, paramDBObject2, 0L, 0L);
  }
  
  public long getCount(DBObject paramDBObject1, DBObject paramDBObject2, long paramLong1, long paramLong2)
  {
    return getCount(paramDBObject1, paramDBObject2, paramLong1, paramLong2, getReadPreference());
  }
  
  public long getCount(DBObject paramDBObject1, DBObject paramDBObject2, long paramLong1, long paramLong2, ReadPreference paramReadPreference)
  {
    BasicDBObject localBasicDBObject = new BasicDBObject();
    localBasicDBObject.put("count", getName());
    localBasicDBObject.put("query", paramDBObject1);
    if (paramDBObject2 != null) {
      localBasicDBObject.put("fields", paramDBObject2);
    }
    if (paramLong1 > 0L) {
      localBasicDBObject.put("limit", Long.valueOf(paramLong1));
    }
    if (paramLong2 > 0L) {
      localBasicDBObject.put("skip", Long.valueOf(paramLong2));
    }
    paramDBObject1 = this._db.command(localBasicDBObject, getOptions(), paramReadPreference);
    if (!paramDBObject1.ok())
    {
      paramDBObject2 = paramDBObject1.getErrorMessage();
      if ((paramDBObject2.equals("ns does not exist")) || (paramDBObject2.equals("ns missing"))) {
        return 0L;
      }
      paramDBObject1.throwOnError();
    }
    return paramDBObject1.getLong("n");
  }
  
  public long getCount(DBObject paramDBObject1, DBObject paramDBObject2, ReadPreference paramReadPreference)
  {
    return getCount(paramDBObject1, paramDBObject2, 0L, 0L, paramReadPreference);
  }
  
  public long getCount(ReadPreference paramReadPreference)
  {
    return getCount(new BasicDBObject(), null, paramReadPreference);
  }
  
  public DB getDB()
  {
    return this._db;
  }
  
  public DBDecoderFactory getDBDecoderFactory()
  {
    try
    {
      DBDecoderFactory localDBDecoderFactory = this._decoderFactory;
      return localDBDecoderFactory;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public DBEncoderFactory getDBEncoderFactory()
  {
    try
    {
      DBEncoderFactory localDBEncoderFactory = this._encoderFactory;
      return localDBEncoderFactory;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getFullName()
  {
    return this._fullName;
  }
  
  public List<DBObject> getIndexInfo()
  {
    Object localObject = new BasicDBObject();
    ((BasicDBObject)localObject).put("ns", getFullName());
    localObject = this._db.getCollection("system.indexes").find((DBObject)localObject);
    ArrayList localArrayList = new ArrayList();
    while (((DBCursor)localObject).hasNext()) {
      localArrayList.add(((DBCursor)localObject).next());
    }
    return localArrayList;
  }
  
  protected Class getInternalClass(String paramString)
  {
    Class localClass = (Class)this._internalClass.get(paramString);
    if (localClass != null) {
      return localClass;
    }
    if (this._wrapper == null) {
      return null;
    }
    return this._wrapper.getInternalClass(paramString);
  }
  
  public String getName()
  {
    return this._name;
  }
  
  public Class getObjectClass()
  {
    return this._objectClass;
  }
  
  public int getOptions()
  {
    return this._options.get();
  }
  
  public ReadPreference getReadPreference()
  {
    if (this._readPref != null) {
      return this._readPref;
    }
    return this._db.getReadPreference();
  }
  
  public CommandResult getStats()
  {
    return getDB().command(new BasicDBObject("collstats", getName()), getOptions(), getReadPreference());
  }
  
  public WriteConcern getWriteConcern()
  {
    if (this._concern != null) {
      return this._concern;
    }
    return this._db.getWriteConcern();
  }
  
  @Deprecated
  public DBObject group(DBObject paramDBObject)
  {
    paramDBObject.put("ns", getName());
    paramDBObject = this._db.command(new BasicDBObject("group", paramDBObject), getOptions(), getReadPreference());
    paramDBObject.throwOnError();
    return (DBObject)paramDBObject.get("retval");
  }
  
  public DBObject group(DBObject paramDBObject1, DBObject paramDBObject2, DBObject paramDBObject3, String paramString)
  {
    return group(paramDBObject1, paramDBObject2, paramDBObject3, paramString, null);
  }
  
  public DBObject group(DBObject paramDBObject1, DBObject paramDBObject2, DBObject paramDBObject3, String paramString1, String paramString2)
  {
    return group(new GroupCommand(this, paramDBObject1, paramDBObject2, paramDBObject3, paramString1, paramString2));
  }
  
  public DBObject group(DBObject paramDBObject1, DBObject paramDBObject2, DBObject paramDBObject3, String paramString1, String paramString2, ReadPreference paramReadPreference)
  {
    return group(new GroupCommand(this, paramDBObject1, paramDBObject2, paramDBObject3, paramString1, paramString2), paramReadPreference);
  }
  
  public DBObject group(GroupCommand paramGroupCommand)
  {
    return group(paramGroupCommand, getReadPreference());
  }
  
  public DBObject group(GroupCommand paramGroupCommand, ReadPreference paramReadPreference)
  {
    paramGroupCommand = this._db.command(paramGroupCommand.toDBObject(), getOptions(), paramReadPreference);
    paramGroupCommand.throwOnError();
    return (DBObject)paramGroupCommand.get("retval");
  }
  
  public int hashCode()
  {
    return this._fullName.hashCode();
  }
  
  public WriteResult insert(DBObject paramDBObject, WriteConcern paramWriteConcern)
  {
    return insert(Arrays.asList(new DBObject[] { paramDBObject }), paramWriteConcern);
  }
  
  public WriteResult insert(WriteConcern paramWriteConcern, DBObject... paramVarArgs)
  {
    return insert(paramVarArgs, paramWriteConcern);
  }
  
  public WriteResult insert(List<DBObject> paramList)
  {
    return insert(paramList, getWriteConcern());
  }
  
  public WriteResult insert(List<DBObject> paramList, WriteConcern paramWriteConcern)
  {
    return insert(paramList, paramWriteConcern, getDBEncoder());
  }
  
  public abstract WriteResult insert(List<DBObject> paramList, WriteConcern paramWriteConcern, DBEncoder paramDBEncoder);
  
  public WriteResult insert(DBObject... paramVarArgs)
  {
    return insert(paramVarArgs, getWriteConcern());
  }
  
  public WriteResult insert(DBObject[] paramArrayOfDBObject, WriteConcern paramWriteConcern)
  {
    return insert(paramArrayOfDBObject, paramWriteConcern, getDBEncoder());
  }
  
  public WriteResult insert(DBObject[] paramArrayOfDBObject, WriteConcern paramWriteConcern, DBEncoder paramDBEncoder)
  {
    return insert(Arrays.asList(paramArrayOfDBObject), paramWriteConcern, paramDBEncoder);
  }
  
  public boolean isCapped()
  {
    Object localObject = getStats().get("capped");
    return (localObject != null) && ((localObject.equals(Integer.valueOf(1))) || (localObject.equals(Boolean.valueOf(true))));
  }
  
  public MapReduceOutput mapReduce(DBObject paramDBObject)
  {
    if ((paramDBObject.get("mapreduce") == null) && (paramDBObject.get("mapReduce") == null)) {
      throw new IllegalArgumentException("need mapreduce arg");
    }
    CommandResult localCommandResult = this._db.command(paramDBObject, getOptions(), getReadPreference());
    localCommandResult.throwOnError();
    return new MapReduceOutput(this, paramDBObject, localCommandResult);
  }
  
  public MapReduceOutput mapReduce(MapReduceCommand paramMapReduceCommand)
  {
    DBObject localDBObject = paramMapReduceCommand.toDBObject();
    DB localDB = this._db;
    int i = getOptions();
    if (paramMapReduceCommand.getReadPreference() != null) {}
    for (paramMapReduceCommand = paramMapReduceCommand.getReadPreference();; paramMapReduceCommand = getReadPreference())
    {
      paramMapReduceCommand = localDB.command(localDBObject, i, paramMapReduceCommand);
      paramMapReduceCommand.throwOnError();
      return new MapReduceOutput(this, localDBObject, paramMapReduceCommand);
    }
  }
  
  public MapReduceOutput mapReduce(String paramString1, String paramString2, String paramString3, DBObject paramDBObject)
  {
    return mapReduce(new MapReduceCommand(this, paramString1, paramString2, paramString3, MapReduceCommand.OutputType.REPLACE, paramDBObject));
  }
  
  public MapReduceOutput mapReduce(String paramString1, String paramString2, String paramString3, MapReduceCommand.OutputType paramOutputType, DBObject paramDBObject)
  {
    return mapReduce(new MapReduceCommand(this, paramString1, paramString2, paramString3, paramOutputType, paramDBObject));
  }
  
  public MapReduceOutput mapReduce(String paramString1, String paramString2, String paramString3, MapReduceCommand.OutputType paramOutputType, DBObject paramDBObject, ReadPreference paramReadPreference)
  {
    paramString1 = new MapReduceCommand(this, paramString1, paramString2, paramString3, paramOutputType, paramDBObject);
    paramString1.setReadPreference(paramReadPreference);
    return mapReduce(paramString1);
  }
  
  public WriteResult remove(DBObject paramDBObject)
  {
    return remove(paramDBObject, getWriteConcern());
  }
  
  public WriteResult remove(DBObject paramDBObject, WriteConcern paramWriteConcern)
  {
    return remove(paramDBObject, paramWriteConcern, getDBEncoder());
  }
  
  public abstract WriteResult remove(DBObject paramDBObject, WriteConcern paramWriteConcern, DBEncoder paramDBEncoder);
  
  public DBCollection rename(String paramString)
  {
    return rename(paramString, false);
  }
  
  public DBCollection rename(String paramString, boolean paramBoolean)
  {
    this._db.getSisterDB("admin").command(BasicDBObjectBuilder.start().add("renameCollection", this._fullName).add("to", this._db._name + "." + paramString).add("dropTarget", Boolean.valueOf(paramBoolean)).get()).throwOnError();
    resetIndexCache();
    return this._db.getCollection(paramString);
  }
  
  public void resetIndexCache()
  {
    this._createdIndexes.clear();
  }
  
  public void resetOptions()
  {
    this._options.reset();
  }
  
  public WriteResult save(DBObject paramDBObject)
  {
    return save(paramDBObject, getWriteConcern());
  }
  
  public WriteResult save(DBObject paramDBObject, WriteConcern paramWriteConcern)
  {
    if (checkReadOnly(true)) {
      return null;
    }
    _checkObject(paramDBObject, false, false);
    Object localObject = paramDBObject.get("_id");
    if ((localObject == null) || (((localObject instanceof ObjectId)) && (((ObjectId)localObject).isNew())))
    {
      if ((localObject != null) && ((localObject instanceof ObjectId))) {
        ((ObjectId)localObject).notNew();
      }
      if (paramWriteConcern == null) {
        return insert(new DBObject[] { paramDBObject });
      }
      return insert(paramDBObject, paramWriteConcern);
    }
    BasicDBObject localBasicDBObject = new BasicDBObject();
    localBasicDBObject.put("_id", localObject);
    if (paramWriteConcern == null) {
      return update(localBasicDBObject, paramDBObject, true, false);
    }
    return update(localBasicDBObject, paramDBObject, true, false, paramWriteConcern);
  }
  
  public void setDBDecoderFactory(DBDecoderFactory paramDBDecoderFactory)
  {
    try
    {
      this._decoderFactory = paramDBDecoderFactory;
      return;
    }
    finally
    {
      paramDBDecoderFactory = finally;
      throw paramDBDecoderFactory;
    }
  }
  
  public void setDBEncoderFactory(DBEncoderFactory paramDBEncoderFactory)
  {
    try
    {
      this._encoderFactory = paramDBEncoderFactory;
      return;
    }
    finally
    {
      paramDBEncoderFactory = finally;
      throw paramDBEncoderFactory;
    }
  }
  
  public void setHintFields(List<DBObject> paramList)
  {
    this._hintFields = paramList;
  }
  
  public void setInternalClass(String paramString, Class paramClass)
  {
    this._internalClass.put(paramString, paramClass);
  }
  
  public void setObjectClass(Class paramClass)
  {
    if (paramClass == null)
    {
      this._wrapper = null;
      this._objectClass = null;
      return;
    }
    if (!DBObject.class.isAssignableFrom(paramClass)) {
      throw new IllegalArgumentException(paramClass.getName() + " is not a DBObject");
    }
    this._objectClass = paramClass;
    if (ReflectionDBObject.class.isAssignableFrom(paramClass))
    {
      this._wrapper = ReflectionDBObject.getWrapper(paramClass);
      return;
    }
    this._wrapper = null;
  }
  
  public void setOptions(int paramInt)
  {
    this._options.set(paramInt);
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
    return this._name;
  }
  
  public WriteResult update(DBObject paramDBObject1, DBObject paramDBObject2)
  {
    return update(paramDBObject1, paramDBObject2, false, false);
  }
  
  public WriteResult update(DBObject paramDBObject1, DBObject paramDBObject2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return update(paramDBObject1, paramDBObject2, paramBoolean1, paramBoolean2, getWriteConcern());
  }
  
  public WriteResult update(DBObject paramDBObject1, DBObject paramDBObject2, boolean paramBoolean1, boolean paramBoolean2, WriteConcern paramWriteConcern)
  {
    return update(paramDBObject1, paramDBObject2, paramBoolean1, paramBoolean2, paramWriteConcern, getDBEncoder());
  }
  
  public abstract WriteResult update(DBObject paramDBObject1, DBObject paramDBObject2, boolean paramBoolean1, boolean paramBoolean2, WriteConcern paramWriteConcern, DBEncoder paramDBEncoder);
  
  public WriteResult updateMulti(DBObject paramDBObject1, DBObject paramDBObject2)
  {
    return update(paramDBObject1, paramDBObject2, false, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/DBCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */