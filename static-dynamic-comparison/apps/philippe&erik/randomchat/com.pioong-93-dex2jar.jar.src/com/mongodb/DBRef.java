package com.mongodb;

import org.bson.BSONObject;

public class DBRef
  extends DBRefBase
{
  static final boolean D = Boolean.getBoolean("DEBUG.DBREF");
  
  public DBRef(DB paramDB, String paramString, Object paramObject)
  {
    super(paramDB, paramString, paramObject);
  }
  
  public DBRef(DB paramDB, BSONObject paramBSONObject)
  {
    super(paramDB, paramBSONObject.get("$ref").toString(), paramBSONObject.get("$id"));
  }
  
  public static DBObject fetch(DB paramDB, DBObject paramDBObject)
  {
    String str = (String)paramDBObject.get("$ref");
    if (str != null)
    {
      paramDBObject = paramDBObject.get("$id");
      if (paramDBObject != null) {
        return paramDB.getCollection(str).findOne(new BasicDBObject("_id", paramDBObject));
      }
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/DBRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */