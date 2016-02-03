package org.bson;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import org.bson.io.BSONByteBuffer;

public class LazyDBList
  extends LazyBSONList
  implements DBObject
{
  private static final long serialVersionUID = -4415279469780082174L;
  private boolean _isPartialObject;
  
  public LazyDBList(BSONByteBuffer paramBSONByteBuffer, int paramInt, LazyBSONCallback paramLazyBSONCallback)
  {
    super(paramBSONByteBuffer, paramInt, paramLazyBSONCallback);
  }
  
  public LazyDBList(BSONByteBuffer paramBSONByteBuffer, LazyBSONCallback paramLazyBSONCallback)
  {
    super(paramBSONByteBuffer, paramLazyBSONCallback);
  }
  
  public LazyDBList(byte[] paramArrayOfByte, int paramInt, LazyBSONCallback paramLazyBSONCallback)
  {
    super(paramArrayOfByte, paramInt, paramLazyBSONCallback);
  }
  
  public LazyDBList(byte[] paramArrayOfByte, LazyBSONCallback paramLazyBSONCallback)
  {
    super(paramArrayOfByte, paramLazyBSONCallback);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/LazyDBList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */