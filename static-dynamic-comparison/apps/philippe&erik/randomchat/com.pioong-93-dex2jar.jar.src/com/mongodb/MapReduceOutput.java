package com.mongodb;

public class MapReduceOutput
{
  final DBObject _cmd;
  final DBCollection _coll;
  final String _collname;
  final CommandResult _commandResult;
  final BasicDBObject _counts;
  String _dbname = null;
  final Iterable<DBObject> _resultSet;
  
  public MapReduceOutput(DBCollection paramDBCollection, DBObject paramDBObject, CommandResult paramCommandResult)
  {
    this._commandResult = paramCommandResult;
    this._cmd = paramDBObject;
    if (paramCommandResult.containsField("results"))
    {
      this._coll = null;
      this._collname = null;
      this._resultSet = ((Iterable)paramCommandResult.get("results"));
      this._counts = ((BasicDBObject)paramCommandResult.get("counts"));
      return;
    }
    paramDBObject = paramCommandResult.get("result");
    if ((paramDBObject instanceof String)) {
      this._collname = ((String)paramDBObject);
    }
    for (;;)
    {
      paramDBObject = paramDBCollection._db;
      paramDBCollection = paramDBObject;
      if (this._dbname != null) {
        paramDBCollection = paramDBObject.getSisterDB(this._dbname);
      }
      this._coll = paramDBCollection.getCollection(this._collname);
      this._coll.setOptions(this._coll.getOptions() & 0xFFFFFFFB);
      this._resultSet = this._coll.find();
      break;
      paramDBObject = (BasicDBObject)paramDBObject;
      this._collname = paramDBObject.getString("collection");
      this._dbname = paramDBObject.getString("db");
    }
  }
  
  public void drop()
  {
    if (this._coll != null) {
      this._coll.drop();
    }
  }
  
  public DBObject getCommand()
  {
    return this._cmd;
  }
  
  public CommandResult getCommandResult()
  {
    return this._commandResult;
  }
  
  public DBCollection getOutputCollection()
  {
    return this._coll;
  }
  
  @Deprecated
  public BasicDBObject getRaw()
  {
    return this._commandResult;
  }
  
  public ServerAddress getServerUsed()
  {
    return this._commandResult.getServerUsed();
  }
  
  public Iterable<DBObject> results()
  {
    return this._resultSet;
  }
  
  public String toString()
  {
    return this._commandResult.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/MapReduceOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */