package com.mongodb;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BasicDBObjectBuilder
{
  private final LinkedList<DBObject> _stack = new LinkedList();
  
  public BasicDBObjectBuilder()
  {
    this._stack.add(new BasicDBObject());
  }
  
  private DBObject _cur()
  {
    return (DBObject)this._stack.getLast();
  }
  
  public static BasicDBObjectBuilder start()
  {
    return new BasicDBObjectBuilder();
  }
  
  public static BasicDBObjectBuilder start(String paramString, Object paramObject)
  {
    return new BasicDBObjectBuilder().add(paramString, paramObject);
  }
  
  public static BasicDBObjectBuilder start(Map paramMap)
  {
    BasicDBObjectBuilder localBasicDBObjectBuilder = new BasicDBObjectBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localBasicDBObjectBuilder.add(localEntry.getKey().toString(), localEntry.getValue());
    }
    return localBasicDBObjectBuilder;
  }
  
  public BasicDBObjectBuilder add(String paramString, Object paramObject)
  {
    return append(paramString, paramObject);
  }
  
  public BasicDBObjectBuilder append(String paramString, Object paramObject)
  {
    _cur().put(paramString, paramObject);
    return this;
  }
  
  public DBObject get()
  {
    return (DBObject)this._stack.getFirst();
  }
  
  public boolean isEmpty()
  {
    return ((BasicDBObject)this._stack.getFirst()).size() == 0;
  }
  
  public BasicDBObjectBuilder pop()
  {
    if (this._stack.size() <= 1) {
      throw new IllegalArgumentException("can't pop last element");
    }
    this._stack.removeLast();
    return this;
  }
  
  public BasicDBObjectBuilder push(String paramString)
  {
    BasicDBObject localBasicDBObject = new BasicDBObject();
    _cur().put(paramString, localBasicDBObject);
    this._stack.addLast(localBasicDBObject);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/BasicDBObjectBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */