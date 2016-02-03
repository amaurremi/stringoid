package com.mongodb;

import com.mongodb.util.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import org.bson.BSONObject;

public abstract class DB
{
  private static final Set<String> _obedientCommands = new HashSet();
  private WriteConcern _concern;
  final Mongo _mongo;
  final String _name;
  final Bytes.OptionHolder _options;
  protected boolean _readOnly = false;
  private ReadPreference _readPref;
  private volatile CommandResult authenticationTestCommandResult;
  
  static
  {
    _obedientCommands.add("group");
    _obedientCommands.add("aggregate");
    _obedientCommands.add("collstats");
    _obedientCommands.add("dbstats");
    _obedientCommands.add("count");
    _obedientCommands.add("distinct");
    _obedientCommands.add("geonear");
    _obedientCommands.add("geosearch");
    _obedientCommands.add("geowalk");
  }
  
  public DB(Mongo paramMongo, String paramString)
  {
    this._mongo = paramMongo;
    this._name = paramString;
    this._options = new Bytes.OptionHolder(this._mongo._netOptions);
  }
  
  private CommandResultPair authenticateCommandHelper(String paramString, char[] paramArrayOfChar)
  {
    paramString = MongoCredential.createMongoCRCredential(paramString, getName(), paramArrayOfChar);
    if (getAuthenticationCredentials() != null) {
      if (getAuthenticationCredentials().equals(paramString))
      {
        if (this.authenticationTestCommandResult != null) {
          return new CommandResultPair(this.authenticationTestCommandResult);
        }
      }
      else {
        throw new IllegalStateException("can't authenticate twice on the same database");
      }
    }
    try
    {
      this.authenticationTestCommandResult = doAuthenticate(paramString);
      paramString = new CommandResultPair(this.authenticationTestCommandResult);
      return paramString;
    }
    catch (CommandFailureException paramString) {}
    return new CommandResultPair(paramString);
  }
  
  private DBObject wrapCommand(DBObject paramDBObject, ReadPreference paramReadPreference)
  {
    Object localObject = paramDBObject;
    if (getMongo().isMongosConnection())
    {
      localObject = paramDBObject;
      if (!ReadPreference.primary().equals(paramReadPreference))
      {
        localObject = paramDBObject;
        if (!ReadPreference.secondaryPreferred().equals(paramReadPreference))
        {
          localObject = paramDBObject;
          if ((paramDBObject instanceof BasicDBObject)) {
            localObject = new BasicDBObject("$query", paramDBObject).append("$readPreference", paramReadPreference.toDBObject());
          }
        }
      }
    }
    return (DBObject)localObject;
  }
  
  String _hash(String paramString, char[] paramArrayOfChar)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramString.length() + 20 + paramArrayOfChar.length);
    for (;;)
    {
      int i;
      try
      {
        localByteArrayOutputStream.write(paramString.getBytes());
        localByteArrayOutputStream.write(":mongo:".getBytes());
        i = 0;
        if (i >= paramArrayOfChar.length) {
          break;
        }
        if (paramArrayOfChar[i] >= '') {
          throw new IllegalArgumentException("can't handle non-ascii passwords yet");
        }
      }
      catch (IOException paramString)
      {
        throw new RuntimeException("impossible", paramString);
      }
      localByteArrayOutputStream.write((byte)paramArrayOfChar[i]);
      i += 1;
    }
    return Util.hexMD5(localByteArrayOutputStream.toByteArray());
  }
  
  public void addOption(int paramInt)
  {
    this._options.add(paramInt);
  }
  
  public WriteResult addUser(String paramString, char[] paramArrayOfChar)
  {
    return addUser(paramString, paramArrayOfChar, false);
  }
  
  public WriteResult addUser(String paramString, char[] paramArrayOfChar, boolean paramBoolean)
  {
    DBCollection localDBCollection = getCollection("system.users");
    DBObject localDBObject = localDBCollection.findOne(new BasicDBObject("user", paramString));
    Object localObject = localDBObject;
    if (localDBObject == null) {
      localObject = new BasicDBObject("user", paramString);
    }
    ((DBObject)localObject).put("pwd", _hash(paramString, paramArrayOfChar));
    ((DBObject)localObject).put("readOnly", Boolean.valueOf(paramBoolean));
    return localDBCollection.save((DBObject)localObject);
  }
  
  public boolean authenticate(String paramString, char[] paramArrayOfChar)
  {
    return authenticateCommandHelper(paramString, paramArrayOfChar).failure == null;
  }
  
  public CommandResult authenticateCommand(String paramString, char[] paramArrayOfChar)
  {
    try
    {
      paramString = authenticateCommandHelper(paramString, paramArrayOfChar);
      if (paramString.failure != null) {
        throw paramString.failure;
      }
    }
    finally {}
    paramString = paramString.result;
    return paramString;
  }
  
  public abstract void cleanCursors(boolean paramBoolean);
  
  public boolean collectionExists(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {}
    Object localObject;
    do
    {
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          return false;
          localObject = getCollectionNames();
        } while (((Set)localObject).isEmpty());
        localObject = ((Set)localObject).iterator();
      }
    } while (!paramString.equalsIgnoreCase((String)((Iterator)localObject).next()));
    return true;
  }
  
  public CommandResult command(DBObject paramDBObject)
  {
    return command(paramDBObject, 0);
  }
  
  public CommandResult command(DBObject paramDBObject, int paramInt)
  {
    return command(paramDBObject, paramInt, getReadPreference());
  }
  
  public CommandResult command(DBObject paramDBObject, int paramInt, DBEncoder paramDBEncoder)
  {
    return command(paramDBObject, paramInt, getReadPreference(), paramDBEncoder);
  }
  
  public CommandResult command(DBObject paramDBObject, int paramInt, ReadPreference paramReadPreference)
  {
    return command(paramDBObject, paramInt, paramReadPreference, DefaultDBEncoder.FACTORY.create());
  }
  
  public CommandResult command(DBObject paramDBObject, int paramInt, ReadPreference paramReadPreference, DBEncoder paramDBEncoder)
  {
    paramReadPreference = getCommandReadPreference(paramDBObject, paramReadPreference);
    paramDBObject = wrapCommand(paramDBObject, paramReadPreference);
    paramDBObject = getCollection("$cmd").__find(paramDBObject, new BasicDBObject(), 0, -1, 0, paramInt, paramReadPreference, DefaultDBDecoder.FACTORY.create(), paramDBEncoder);
    if ((paramDBObject == null) || (!paramDBObject.hasNext())) {
      return null;
    }
    paramReadPreference = (DBObject)paramDBObject.next();
    if ((paramDBObject instanceof DBApiLayer.Result)) {}
    for (paramDBObject = ((DBApiLayer.Result)paramDBObject).getServerAddress();; paramDBObject = null)
    {
      paramDBObject = new CommandResult(paramDBObject);
      paramDBObject.putAll(paramReadPreference);
      return paramDBObject;
    }
  }
  
  public CommandResult command(DBObject paramDBObject, DBEncoder paramDBEncoder)
  {
    return command(paramDBObject, 0, paramDBEncoder);
  }
  
  public CommandResult command(String paramString)
  {
    return command(new BasicDBObject(paramString, Boolean.TRUE));
  }
  
  public CommandResult command(String paramString, int paramInt)
  {
    return command(new BasicDBObject(paramString, Boolean.TRUE), paramInt);
  }
  
  public DBCollection createCollection(String paramString, DBObject paramDBObject)
  {
    if (paramDBObject != null)
    {
      BasicDBObject localBasicDBObject = new BasicDBObject("create", paramString);
      localBasicDBObject.putAll(paramDBObject);
      command(localBasicDBObject).throwOnError();
    }
    return getCollection(paramString);
  }
  
  abstract CommandResult doAuthenticate(MongoCredential paramMongoCredential);
  
  public CommandResult doEval(String paramString, Object... paramVarArgs)
  {
    return command(BasicDBObjectBuilder.start().add("$eval", paramString).add("args", paramVarArgs).get());
  }
  
  protected abstract DBCollection doGetCollection(String paramString);
  
  public void dropDatabase()
  {
    command(new BasicDBObject("dropDatabase", Integer.valueOf(1))).throwOnError();
    this._mongo._dbs.remove(getName());
  }
  
  public Object eval(String paramString, Object... paramVarArgs)
  {
    paramString = doEval(paramString, paramVarArgs);
    paramString.throwOnError();
    return paramString.get("retval");
  }
  
  public void forceError()
  {
    command(new BasicDBObject("forceerror", Integer.valueOf(1)));
  }
  
  MongoCredential getAuthenticationCredentials()
  {
    return getMongo().getAuthority().getCredentialsStore().get(getName());
  }
  
  public DBCollection getCollection(String paramString)
  {
    return doGetCollection(paramString);
  }
  
  public DBCollection getCollectionFromString(String paramString)
  {
    String str2 = null;
    int i = paramString.indexOf(".");
    String str1 = paramString;
    paramString = str2;
    if (i >= 0)
    {
      str2 = str1.substring(0, i);
      str1 = str1.substring(i + 1);
      if (paramString == null) {}
      for (paramString = getCollection(str2);; paramString = paramString.getCollection(str2))
      {
        i = str1.indexOf(".");
        break;
      }
    }
    if (paramString != null) {
      return paramString.getCollection(str1);
    }
    return getCollection(str1);
  }
  
  public Set<String> getCollectionNames()
  {
    Object localObject1 = getCollection("system.namespaces");
    if (localObject1 == null) {
      throw new RuntimeException("this is impossible");
    }
    localObject1 = ((DBCollection)localObject1).__find(new BasicDBObject(), null, 0, 0, 0, getOptions(), getReadPreference(), null);
    if (localObject1 == null) {
      return new HashSet();
    }
    ArrayList localArrayList = new ArrayList();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (DBObject)((Iterator)localObject1).next();
      if (((DBObject)localObject2).get("name") == null) {
        throw new MongoException("how is name null : " + localObject2);
      }
      localObject2 = ((DBObject)localObject2).get("name").toString();
      int i = ((String)localObject2).indexOf(".");
      if ((((String)localObject2).substring(0, i).equals(this._name)) && (((String)localObject2).indexOf("$") < 0)) {
        localArrayList.add(((String)localObject2).substring(i + 1));
      }
    }
    Collections.sort(localArrayList);
    return new LinkedHashSet(localArrayList);
  }
  
  ReadPreference getCommandReadPreference(DBObject paramDBObject, ReadPreference paramReadPreference)
  {
    int j = 1;
    int i = 1;
    String str = (String)paramDBObject.keySet().iterator().next();
    if ((str.equals("getnonce")) || (str.equals("authenticate"))) {
      paramDBObject = ReadPreference.primaryPreferred();
    }
    do
    {
      return paramDBObject;
      if (str.equals("mapreduce"))
      {
        paramDBObject = paramDBObject.get("out");
        if ((paramDBObject instanceof BSONObject)) {
          if (((BSONObject)paramDBObject).get("inline") != null) {}
        }
        while (i != 0)
        {
          return ReadPreference.primary();
          i = 0;
          continue;
          i = 1;
        }
      }
      if (!_obedientCommands.contains(str.toLowerCase())) {}
      for (i = j;; i = 0) {
        break;
      }
      paramDBObject = paramReadPreference;
    } while (paramReadPreference != null);
    return ReadPreference.primary();
  }
  
  public CommandResult getLastError()
  {
    return command(new BasicDBObject("getlasterror", Integer.valueOf(1)));
  }
  
  public CommandResult getLastError(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return command(new WriteConcern(paramInt1, paramInt2, paramBoolean).getCommand());
  }
  
  public CommandResult getLastError(WriteConcern paramWriteConcern)
  {
    return command(paramWriteConcern.getCommand());
  }
  
  public Mongo getMongo()
  {
    return this._mongo;
  }
  
  public String getName()
  {
    return this._name;
  }
  
  public int getOptions()
  {
    return this._options.get();
  }
  
  public CommandResult getPreviousError()
  {
    return command(new BasicDBObject("getpreverror", Integer.valueOf(1)));
  }
  
  public ReadPreference getReadPreference()
  {
    if (this._readPref != null) {
      return this._readPref;
    }
    return this._mongo.getReadPreference();
  }
  
  public DB getSisterDB(String paramString)
  {
    return this._mongo.getDB(paramString);
  }
  
  public CommandResult getStats()
  {
    return command("dbstats");
  }
  
  public WriteConcern getWriteConcern()
  {
    if (this._concern != null) {
      return this._concern;
    }
    return this._mongo.getWriteConcern();
  }
  
  public boolean isAuthenticated()
  {
    return getAuthenticationCredentials() != null;
  }
  
  public WriteResult removeUser(String paramString)
  {
    return getCollection("system.users").remove(new BasicDBObject("user", paramString));
  }
  
  public abstract void requestDone();
  
  public abstract void requestEnsureConnection();
  
  public abstract void requestStart();
  
  public void resetError()
  {
    command(new BasicDBObject("reseterror", Integer.valueOf(1)));
  }
  
  public void resetOptions()
  {
    this._options.reset();
  }
  
  public void setOptions(int paramInt)
  {
    this._options.set(paramInt);
  }
  
  public void setReadOnly(Boolean paramBoolean)
  {
    this._readOnly = paramBoolean.booleanValue();
  }
  
  public void setReadPreference(ReadPreference paramReadPreference)
  {
    this._readPref = paramReadPreference;
  }
  
  public void setWriteConcern(WriteConcern paramWriteConcern)
  {
    if (paramWriteConcern == null) {
      throw new IllegalArgumentException();
    }
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
  
  class CommandResultPair
  {
    CommandFailureException failure;
    CommandResult result;
    
    public CommandResultPair(CommandFailureException paramCommandFailureException)
    {
      this.failure = paramCommandFailureException;
    }
    
    public CommandResultPair(CommandResult paramCommandResult)
    {
      this.result = paramCommandResult;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/DB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */