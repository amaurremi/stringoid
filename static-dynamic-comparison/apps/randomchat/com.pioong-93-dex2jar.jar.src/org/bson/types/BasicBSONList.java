package org.bson.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.bson.BSONObject;
import org.bson.util.StringRangeSet;

public class BasicBSONList
  extends ArrayList<Object>
  implements BSONObject
{
  private static final long serialVersionUID = -4415279469780082174L;
  
  int _getInt(String paramString)
  {
    return _getInt(paramString, true);
  }
  
  int _getInt(String paramString, boolean paramBoolean)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception localException)
    {
      if (paramBoolean) {
        throw new IllegalArgumentException("BasicBSONList can only work with numeric keys, not: [" + paramString + "]");
      }
    }
    return -1;
  }
  
  public boolean containsField(String paramString)
  {
    int i = _getInt(paramString, false);
    if (i < 0) {}
    while ((i < 0) || (i >= size())) {
      return false;
    }
    return true;
  }
  
  @Deprecated
  public boolean containsKey(String paramString)
  {
    return containsField(paramString);
  }
  
  public Object get(String paramString)
  {
    int i = _getInt(paramString);
    if (i < 0) {}
    while (i >= size()) {
      return null;
    }
    return get(i);
  }
  
  public Set<String> keySet()
  {
    return new StringRangeSet(size());
  }
  
  public Object put(int paramInt, Object paramObject)
  {
    while (paramInt >= size()) {
      add(null);
    }
    set(paramInt, paramObject);
    return paramObject;
  }
  
  public Object put(String paramString, Object paramObject)
  {
    return put(_getInt(paramString), paramObject);
  }
  
  public void putAll(Map paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey().toString(), localEntry.getValue());
    }
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
    int i = _getInt(paramString);
    if (i < 0) {}
    while (i >= size()) {
      return null;
    }
    return remove(i);
  }
  
  public Map toMap()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      localHashMap.put(localObject, get(String.valueOf(localObject)));
    }
    return localHashMap;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/types/BasicBSONList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */