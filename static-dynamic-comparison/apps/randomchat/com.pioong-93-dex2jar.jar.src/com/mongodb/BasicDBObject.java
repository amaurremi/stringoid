package com.mongodb;

import com.mongodb.util.JSON;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.bson.BasicBSONObject;

public class BasicDBObject
  extends BasicBSONObject
  implements DBObject
{
  private static final long serialVersionUID = -4415279469780082174L;
  private boolean _isPartialObject;
  
  public BasicDBObject() {}
  
  public BasicDBObject(int paramInt)
  {
    super(paramInt);
  }
  
  public BasicDBObject(String paramString, Object paramObject)
  {
    super(paramString, paramObject);
  }
  
  public BasicDBObject(Map paramMap)
  {
    super(paramMap);
  }
  
  public BasicDBObject append(String paramString, Object paramObject)
  {
    put(paramString, paramObject);
    return this;
  }
  
  public Object copy()
  {
    BasicDBObject localBasicDBObject = new BasicDBObject(toMap());
    Iterator localIterator = keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = get(str);
      if ((localObject instanceof BasicDBObject)) {
        localBasicDBObject.put(str, ((BasicDBObject)localObject).copy());
      } else if ((localObject instanceof BasicDBList)) {
        localBasicDBObject.put(str, ((BasicDBList)localObject).copy());
      }
    }
    return localBasicDBObject;
  }
  
  public boolean isPartialObject()
  {
    return this._isPartialObject;
  }
  
  public void markAsPartialObject()
  {
    this._isPartialObject = true;
  }
  
  public String toString()
  {
    return JSON.serialize(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/BasicDBObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */