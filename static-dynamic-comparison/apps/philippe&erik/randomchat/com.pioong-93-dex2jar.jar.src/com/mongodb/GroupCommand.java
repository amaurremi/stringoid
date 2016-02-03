package com.mongodb;

public class GroupCommand
{
  DBObject condition;
  String finalize;
  DBObject initial;
  String input;
  DBObject keys;
  String reduce;
  
  public GroupCommand(DBCollection paramDBCollection, DBObject paramDBObject1, DBObject paramDBObject2, DBObject paramDBObject3, String paramString1, String paramString2)
  {
    this.input = paramDBCollection.getName();
    this.keys = paramDBObject1;
    this.condition = paramDBObject2;
    this.initial = paramDBObject3;
    this.reduce = paramString1;
    this.finalize = paramString2;
  }
  
  public DBObject toDBObject()
  {
    BasicDBObject localBasicDBObject = new BasicDBObject();
    localBasicDBObject.put("ns", this.input);
    localBasicDBObject.put("key", this.keys);
    localBasicDBObject.put("cond", this.condition);
    localBasicDBObject.put("$reduce", this.reduce);
    localBasicDBObject.put("initial", this.initial);
    if (this.finalize != null) {
      localBasicDBObject.put("finalize", this.finalize);
    }
    return new BasicDBObject("group", localBasicDBObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/GroupCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */