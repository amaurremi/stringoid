package com.mongodb;

import org.bson.types.ObjectId;

@Deprecated
public class DBPointer
  extends DBRefBase
{
  static final boolean D = Boolean.getBoolean("DEBUG.DBPOINTER");
  final String _fieldName;
  final DBObject _parent;
  
  DBPointer(DBObject paramDBObject, String paramString1, DB paramDB, String paramString2, ObjectId paramObjectId)
  {
    super(paramDB, paramString2, paramObjectId);
    this._parent = paramDBObject;
    this._fieldName = paramString1;
  }
  
  public DBPointer(String paramString, ObjectId paramObjectId)
  {
    this(null, null, null, paramString, paramObjectId);
  }
  
  public ObjectId getId()
  {
    return (ObjectId)this._id;
  }
  
  public String toString()
  {
    return "{ \"$ref\" : \"" + this._ns + "\", \"$id\" : ObjectId(\"" + this._id + "\") }";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/DBPointer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */