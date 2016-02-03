package com.mongodb;

import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

public class LazyWriteableDBCallback
  extends LazyDBCallback
{
  private static final Logger log = Logger.getLogger(LazyWriteableDBCallback.class.getName());
  
  public LazyWriteableDBCallback(DBCollection paramDBCollection)
  {
    super(paramDBCollection);
  }
  
  public Object createObject(byte[] paramArrayOfByte, int paramInt)
  {
    LazyWriteableDBObject localLazyWriteableDBObject = new LazyWriteableDBObject(paramArrayOfByte, paramInt, this);
    Iterator localIterator = localLazyWriteableDBObject.keySet().iterator();
    paramArrayOfByte = localLazyWriteableDBObject;
    if (localIterator.hasNext())
    {
      paramArrayOfByte = localLazyWriteableDBObject;
      if (localIterator.next().equals("$ref"))
      {
        paramArrayOfByte = localLazyWriteableDBObject;
        if (localLazyWriteableDBObject.containsField("$id")) {
          paramArrayOfByte = new DBRef(this._db, localLazyWriteableDBObject);
        }
      }
    }
    return paramArrayOfByte;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/LazyWriteableDBCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */