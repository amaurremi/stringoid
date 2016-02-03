package com.mongodb;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.bson.BSONObject;
import org.bson.LazyBSONCallback;
import org.bson.io.BSONByteBuffer;

public class LazyWriteableDBObject
  extends LazyDBObject
{
  private final HashMap<String, Object> writeable = new HashMap();
  
  public LazyWriteableDBObject(BSONByteBuffer paramBSONByteBuffer, int paramInt, LazyBSONCallback paramLazyBSONCallback)
  {
    super(paramBSONByteBuffer, paramInt, paramLazyBSONCallback);
  }
  
  public LazyWriteableDBObject(BSONByteBuffer paramBSONByteBuffer, LazyBSONCallback paramLazyBSONCallback)
  {
    super(paramBSONByteBuffer, paramLazyBSONCallback);
  }
  
  public LazyWriteableDBObject(byte[] paramArrayOfByte, int paramInt, LazyBSONCallback paramLazyBSONCallback)
  {
    super(paramArrayOfByte, paramInt, paramLazyBSONCallback);
  }
  
  public LazyWriteableDBObject(byte[] paramArrayOfByte, LazyBSONCallback paramLazyBSONCallback)
  {
    this(paramArrayOfByte, 0, paramLazyBSONCallback);
  }
  
  public boolean containsField(String paramString)
  {
    boolean bool = this.writeable.containsKey(paramString);
    if (bool) {
      return bool;
    }
    return super.containsField(paramString);
  }
  
  public Object get(String paramString)
  {
    Object localObject = this.writeable.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    return super.get(paramString);
  }
  
  public boolean isEmpty()
  {
    return (this.writeable.isEmpty()) || (super.isEmpty());
  }
  
  public Set<String> keySet()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.writeable.keySet());
    localHashSet.addAll(super.keySet());
    return localHashSet;
  }
  
  public Object put(String paramString, Object paramObject)
  {
    return this.writeable.put(paramString, paramObject);
  }
  
  public void putAll(Map paramMap)
  {
    this.writeable.putAll(paramMap);
  }
  
  public void putAll(BSONObject paramBSONObject)
  {
    Iterator localIterator = paramBSONObject.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      put(str, paramBSONObject.get(str));
    }
  }
  
  public Object removeField(String paramString)
  {
    Object localObject = this.writeable.remove(paramString);
    if (localObject != null) {
      return localObject;
    }
    return super.removeField(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/LazyWriteableDBObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */