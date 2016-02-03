package org.bson;

import com.mongodb.util.JSON;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;
import org.bson.types.ObjectId;

public class BasicBSONObject
  extends LinkedHashMap<String, Object>
  implements BSONObject
{
  private static final long serialVersionUID = -4415279469780082174L;
  
  public BasicBSONObject() {}
  
  public BasicBSONObject(int paramInt)
  {
    super(paramInt);
  }
  
  public BasicBSONObject(String paramString, Object paramObject)
  {
    put(paramString, paramObject);
  }
  
  public BasicBSONObject(Map paramMap)
  {
    super(paramMap);
  }
  
  public BasicBSONObject append(String paramString, Object paramObject)
  {
    put(paramString, paramObject);
    return this;
  }
  
  public boolean containsField(String paramString)
  {
    return super.containsKey(paramString);
  }
  
  @Deprecated
  public boolean containsKey(String paramString)
  {
    return containsField(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof BSONObject)) {}
    do
    {
      return false;
      paramObject = (BSONObject)paramObject;
    } while (!keySet().equals(((BSONObject)paramObject).keySet()));
    Iterator localIterator = keySet().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        Object localObject1 = get((String)localObject2);
        localObject2 = ((BSONObject)paramObject).get((String)localObject2);
        if ((localObject1 == null) && (localObject2 != null)) {
          break;
        }
        if (localObject2 == null)
        {
          if (localObject1 != null) {
            return false;
          }
        }
        else if (((localObject1 instanceof Number)) && ((localObject2 instanceof Number)))
        {
          if (((Number)localObject1).doubleValue() != ((Number)localObject2).doubleValue()) {
            return false;
          }
        }
        else
        {
          if (((localObject1 instanceof Pattern)) && ((localObject2 instanceof Pattern)))
          {
            localObject1 = (Pattern)localObject1;
            localObject2 = (Pattern)localObject2;
            if (!((Pattern)localObject1).pattern().equals(((Pattern)localObject2).pattern())) {
              break;
            }
            if (((Pattern)localObject1).flags() == ((Pattern)localObject2).flags()) {
              continue;
            }
            return false;
          }
          if (!localObject1.equals(localObject2)) {
            return false;
          }
        }
      }
    }
    return true;
  }
  
  public Object get(String paramString)
  {
    return super.get(paramString);
  }
  
  public boolean getBoolean(String paramString)
  {
    return getBoolean(paramString, false);
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    paramString = get(paramString);
    if (paramString == null) {
      return paramBoolean;
    }
    if ((paramString instanceof Number))
    {
      if (((Number)paramString).intValue() > 0) {}
      for (paramBoolean = true;; paramBoolean = false) {
        return paramBoolean;
      }
    }
    if ((paramString instanceof Boolean)) {
      return ((Boolean)paramString).booleanValue();
    }
    throw new IllegalArgumentException("can't coerce to bool:" + paramString.getClass());
  }
  
  public Date getDate(String paramString)
  {
    return (Date)get(paramString);
  }
  
  public Date getDate(String paramString, Date paramDate)
  {
    paramString = get(paramString);
    if (paramString != null) {
      return (Date)paramString;
    }
    return paramDate;
  }
  
  public double getDouble(String paramString)
  {
    return ((Number)get(paramString)).doubleValue();
  }
  
  public double getDouble(String paramString, double paramDouble)
  {
    paramString = get(paramString);
    if (paramString == null) {
      return paramDouble;
    }
    return ((Number)paramString).doubleValue();
  }
  
  public int getInt(String paramString)
  {
    Object localObject = get(paramString);
    if (localObject == null) {
      throw new NullPointerException("no value for: " + paramString);
    }
    return BSON.toInt(localObject);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    paramString = get(paramString);
    if (paramString == null) {
      return paramInt;
    }
    return BSON.toInt(paramString);
  }
  
  public long getLong(String paramString)
  {
    return ((Number)get(paramString)).longValue();
  }
  
  public long getLong(String paramString, long paramLong)
  {
    paramString = get(paramString);
    if (paramString == null) {
      return paramLong;
    }
    return ((Number)paramString).longValue();
  }
  
  public ObjectId getObjectId(String paramString)
  {
    return (ObjectId)get(paramString);
  }
  
  public ObjectId getObjectId(String paramString, ObjectId paramObjectId)
  {
    paramString = get(paramString);
    if (paramString != null) {
      return (ObjectId)paramString;
    }
    return paramObjectId;
  }
  
  public String getString(String paramString)
  {
    paramString = get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.toString();
  }
  
  public String getString(String paramString1, String paramString2)
  {
    paramString1 = get(paramString1);
    if (paramString1 == null) {
      return paramString2;
    }
    return paramString1.toString();
  }
  
  public Object put(String paramString, Object paramObject)
  {
    return super.put(paramString, paramObject);
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
    return remove(paramString);
  }
  
  public Map toMap()
  {
    return new LinkedHashMap(this);
  }
  
  public String toString()
  {
    return JSON.serialize(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/BasicBSONObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */