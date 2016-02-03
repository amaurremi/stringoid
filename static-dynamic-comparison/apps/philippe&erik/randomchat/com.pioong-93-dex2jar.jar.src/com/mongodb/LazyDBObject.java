package com.mongodb;

import org.bson.LazyBSONCallback;
import org.bson.LazyBSONObject;
import org.bson.io.BSONByteBuffer;

public class LazyDBObject
  extends LazyBSONObject
  implements DBObject
{
  private boolean _partial = false;
  
  public LazyDBObject(BSONByteBuffer paramBSONByteBuffer, int paramInt, LazyBSONCallback paramLazyBSONCallback)
  {
    super(paramBSONByteBuffer, paramInt, paramLazyBSONCallback);
  }
  
  public LazyDBObject(BSONByteBuffer paramBSONByteBuffer, LazyBSONCallback paramLazyBSONCallback)
  {
    super(paramBSONByteBuffer, paramLazyBSONCallback);
  }
  
  public LazyDBObject(byte[] paramArrayOfByte, int paramInt, LazyBSONCallback paramLazyBSONCallback)
  {
    super(paramArrayOfByte, paramInt, paramLazyBSONCallback);
  }
  
  public LazyDBObject(byte[] paramArrayOfByte, LazyBSONCallback paramLazyBSONCallback)
  {
    this(paramArrayOfByte, 0, paramLazyBSONCallback);
  }
  
  public boolean isPartialObject()
  {
    return this._partial;
  }
  
  public void markAsPartialObject()
  {
    this._partial = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/LazyDBObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */