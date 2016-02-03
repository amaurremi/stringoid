package com.mongodb;

import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;
import org.bson.LazyBSONCallback;
import org.bson.types.ObjectId;

public class LazyDBCallback
  extends LazyBSONCallback
  implements DBCallback
{
  private static final Logger log = Logger.getLogger(LazyDBCallback.class.getName());
  final DBCollection _collection;
  final DB _db;
  
  public LazyDBCallback(DBCollection paramDBCollection)
  {
    this._collection = paramDBCollection;
    if (this._collection == null) {}
    for (paramDBCollection = null;; paramDBCollection = this._collection.getDB())
    {
      this._db = paramDBCollection;
      return;
    }
  }
  
  public Object createDBRef(String paramString, ObjectId paramObjectId)
  {
    return new DBRef(this._db, paramString, paramObjectId);
  }
  
  public Object createObject(byte[] paramArrayOfByte, int paramInt)
  {
    LazyDBObject localLazyDBObject = new LazyDBObject(paramArrayOfByte, paramInt, this);
    Iterator localIterator = localLazyDBObject.keySet().iterator();
    paramArrayOfByte = localLazyDBObject;
    if (localIterator.hasNext())
    {
      paramArrayOfByte = localLazyDBObject;
      if (localIterator.next().equals("$ref"))
      {
        paramArrayOfByte = localLazyDBObject;
        if (localLazyDBObject.containsField("$id")) {
          paramArrayOfByte = new DBRef(this._db, localLazyDBObject);
        }
      }
    }
    return paramArrayOfByte;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/LazyDBCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */