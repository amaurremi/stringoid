package com.mongodb;

import com.mongodb.util.JSON;
import org.bson.types.BasicBSONList;

public class BasicDBList
  extends BasicBSONList
  implements DBObject
{
  private static final long serialVersionUID = -4415279469780082174L;
  private boolean _isPartialObject;
  
  public Object copy()
  {
    BasicDBList localBasicDBList = new BasicDBList();
    int i = 0;
    if (i < size())
    {
      Object localObject2 = get(i);
      Object localObject1;
      if ((localObject2 instanceof BasicDBObject)) {
        localObject1 = ((BasicDBObject)localObject2).copy();
      }
      for (;;)
      {
        localBasicDBList.add(localObject1);
        i += 1;
        break;
        localObject1 = localObject2;
        if ((localObject2 instanceof BasicDBList)) {
          localObject1 = ((BasicDBList)localObject2).copy();
        }
      }
    }
    return localBasicDBList;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/BasicDBList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */