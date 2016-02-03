package com.mongodb;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.BSONObject;
import org.bson.BasicBSONCallback;
import org.bson.types.ObjectId;

public class DefaultDBCallback
  extends BasicBSONCallback
  implements DBCallback
{
  public static DBCallbackFactory FACTORY = new DefaultFactory();
  static final Logger LOGGER = Logger.getLogger("com.mongo.DECODING");
  final DBCollection _collection;
  final DB _db;
  private LinkedList<String> _nameStack;
  
  public DefaultDBCallback(DBCollection paramDBCollection)
  {
    this._collection = paramDBCollection;
    if (this._collection == null) {}
    for (paramDBCollection = null;; paramDBCollection = this._collection.getDB())
    {
      this._db = paramDBCollection;
      return;
    }
  }
  
  private DBObject _create(List<String> paramList)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this._collection != null)
    {
      localObject1 = localObject2;
      if (this._collection._objectClass != null) {
        if ((paramList != null) && (paramList.size() != 0)) {
          break label61;
        }
      }
    }
    for (localObject1 = this._collection._objectClass; localObject1 != null; localObject1 = this._collection.getInternalClass(((StringBuilder)localObject1).toString()))
    {
      try
      {
        paramList = (DBObject)((Class)localObject1).newInstance();
        return paramList;
      }
      catch (InstantiationException paramList)
      {
        int i;
        LOGGER.log(Level.FINE, "can't create a: " + localObject1, paramList);
        throw new MongoInternalException("can't instantiate a : " + localObject1, paramList);
      }
      catch (IllegalAccessException paramList)
      {
        label61:
        LOGGER.log(Level.FINE, "can't create a: " + localObject1, paramList);
        throw new MongoInternalException("can't instantiate a : " + localObject1, paramList);
      }
      localObject1 = new StringBuilder();
      i = 0;
      while (i < paramList.size())
      {
        if (i > 0) {
          ((StringBuilder)localObject1).append(".");
        }
        ((StringBuilder)localObject1).append((String)paramList.get(i));
        i += 1;
      }
    }
    return new BasicDBObject();
  }
  
  public BSONObject create()
  {
    return _create(null);
  }
  
  public BSONObject create(boolean paramBoolean, List<String> paramList)
  {
    if (paramBoolean) {
      return new BasicDBList();
    }
    return _create(paramList);
  }
  
  DBObject dbget()
  {
    return (DBObject)get();
  }
  
  public void gotDBRef(String paramString1, String paramString2, ObjectId paramObjectId)
  {
    if (paramObjectId.equals(Bytes.COLLECTION_REF_ID))
    {
      cur().put(paramString1, this._collection);
      return;
    }
    cur().put(paramString1, new DBPointer((DBObject)cur(), paramString1, this._db, paramString2, paramObjectId));
  }
  
  public Object objectDone()
  {
    BSONObject localBSONObject = (BSONObject)super.objectDone();
    String str = null;
    if (this._nameStack.size() > 0) {
      str = (String)this._nameStack.removeLast();
    }
    Object localObject = localBSONObject;
    if (!(localBSONObject instanceof List))
    {
      localObject = localBSONObject;
      if (str != null)
      {
        localObject = localBSONObject;
        if (localBSONObject.containsField("$ref"))
        {
          localObject = localBSONObject;
          if (localBSONObject.containsField("$id")) {
            localObject = cur().put(str, new DBRef(this._db, localBSONObject));
          }
        }
      }
    }
    return localObject;
  }
  
  public void objectStart(boolean paramBoolean, String paramString)
  {
    this._nameStack.addLast(paramString);
    super.objectStart(paramBoolean, paramString);
  }
  
  public void reset()
  {
    this._nameStack = new LinkedList();
    super.reset();
  }
  
  static class DefaultFactory
    implements DBCallbackFactory
  {
    public DBCallback create(DBCollection paramDBCollection)
    {
      return new DefaultDBCallback(paramDBCollection);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/DefaultDBCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */