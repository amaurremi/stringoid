package com.chartboost.sdk.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

public class ar
  extends LinkedHashMap<String, Object>
  implements ao
{
  public ar() {}
  
  public ar(String paramString, Object paramObject)
  {
    a(paramString, paramObject);
  }
  
  public Object a(String paramString)
  {
    return super.get(paramString);
  }
  
  public Object a(String paramString, Object paramObject)
  {
    return super.put(paramString, paramObject);
  }
  
  public boolean b(String paramString)
  {
    return super.containsKey(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ao)) {
      return false;
    }
    paramObject = (ao)paramObject;
    if (!keySet().equals(((ao)paramObject).keySet())) {
      return false;
    }
    Iterator localIterator = keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      Object localObject1 = a((String)localObject2);
      localObject2 = ((ao)paramObject).a((String)localObject2);
      if ((localObject1 == null) && (localObject2 != null)) {
        return false;
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
      else if (((localObject1 instanceof Pattern)) && ((localObject2 instanceof Pattern)))
      {
        localObject1 = (Pattern)localObject1;
        localObject2 = (Pattern)localObject2;
        if ((!((Pattern)localObject1).pattern().equals(((Pattern)localObject2).pattern())) || (((Pattern)localObject1).flags() != ((Pattern)localObject2).flags())) {
          return false;
        }
      }
      else if (!localObject1.equals(localObject2))
      {
        return false;
      }
    }
    return true;
  }
  
  public void putAll(Map paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      a(localEntry.getKey().toString(), localEntry.getValue());
    }
  }
  
  public String toString()
  {
    return ad.a(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */