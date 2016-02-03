package org.bson;

import com.mongodb.LazyDBObject;
import java.util.List;
import java.util.logging.Logger;
import org.bson.types.ObjectId;

public class LazyBSONCallback
  extends EmptyBSONCallback
{
  private static final Logger log = Logger.getLogger("org.bson.LazyBSONCallback");
  private Object _root;
  
  public List createArray(byte[] paramArrayOfByte, int paramInt)
  {
    return new LazyDBList(paramArrayOfByte, paramInt, this);
  }
  
  public Object createDBRef(String paramString, ObjectId paramObjectId)
  {
    return new BasicBSONObject("$ns", paramString).append("$id", paramObjectId);
  }
  
  public Object createObject(byte[] paramArrayOfByte, int paramInt)
  {
    return new LazyDBObject(paramArrayOfByte, paramInt, this);
  }
  
  public Object get()
  {
    return this._root;
  }
  
  public void gotBinary(String paramString, byte paramByte, byte[] paramArrayOfByte)
  {
    setRootObject(createObject(paramArrayOfByte, 0));
  }
  
  public Object objectDone()
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
  public void objectStart()
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
  public void objectStart(String paramString)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
  public void objectStart(boolean paramBoolean)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
  public void reset()
  {
    this._root = null;
  }
  
  public void setRootObject(Object paramObject)
  {
    this._root = paramObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/LazyBSONCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */