package com.parse.signpost.http;

import com.parse.signpost.OAuth;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class HttpParameters
  implements Map<String, SortedSet<String>>, Serializable
{
  private TreeMap<String, SortedSet<String>> wrappedMap = new TreeMap();
  
  public void clear()
  {
    this.wrappedMap.clear();
  }
  
  public boolean containsKey(Object paramObject)
  {
    return this.wrappedMap.containsKey(paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    Iterator localIterator = this.wrappedMap.values().iterator();
    do
    {
      if (!localIterator.hasNext()) {
        return false;
      }
    } while (!((Set)localIterator.next()).contains(paramObject));
    return true;
  }
  
  public Set<Map.Entry<String, SortedSet<String>>> entrySet()
  {
    return this.wrappedMap.entrySet();
  }
  
  public SortedSet<String> get(Object paramObject)
  {
    return (SortedSet)this.wrappedMap.get(paramObject);
  }
  
  public String getAsHeaderElement(String paramString)
  {
    String str = getFirst(paramString);
    if (str == null) {
      return null;
    }
    return paramString + "=\"" + str + "\"";
  }
  
  public String getAsQueryString(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramObject = OAuth.percentEncode((String)paramObject);
    Object localObject = (Set)this.wrappedMap.get(paramObject);
    if (localObject == null) {
      return paramObject + "=";
    }
    localObject = ((Set)localObject).iterator();
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        return localStringBuilder.toString();
      }
      localStringBuilder.append(paramObject + "=" + (String)((Iterator)localObject).next());
      if (((Iterator)localObject).hasNext()) {
        localStringBuilder.append("&");
      }
    }
  }
  
  public String getFirst(Object paramObject)
  {
    return getFirst(paramObject, false);
  }
  
  public String getFirst(Object paramObject, boolean paramBoolean)
  {
    paramObject = (SortedSet)this.wrappedMap.get(paramObject);
    if ((paramObject == null) || (((SortedSet)paramObject).isEmpty())) {
      paramObject = null;
    }
    String str;
    do
    {
      return (String)paramObject;
      str = (String)((SortedSet)paramObject).first();
      paramObject = str;
    } while (!paramBoolean);
    return OAuth.percentDecode(str);
  }
  
  public boolean isEmpty()
  {
    return this.wrappedMap.isEmpty();
  }
  
  public Set<String> keySet()
  {
    return this.wrappedMap.keySet();
  }
  
  public String put(String paramString1, String paramString2)
  {
    return put(paramString1, paramString2, false);
  }
  
  public String put(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject2 = (SortedSet)this.wrappedMap.get(paramString1);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = new TreeSet();
      TreeMap localTreeMap = this.wrappedMap;
      localObject1 = paramString1;
      if (paramBoolean) {
        localObject1 = OAuth.percentEncode(paramString1);
      }
      localTreeMap.put(localObject1, localObject2);
      localObject1 = localObject2;
    }
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (paramBoolean) {
        paramString1 = OAuth.percentEncode(paramString2);
      }
      ((SortedSet)localObject1).add(paramString1);
    }
    return paramString1;
  }
  
  public SortedSet<String> put(String paramString, SortedSet<String> paramSortedSet)
  {
    return (SortedSet)this.wrappedMap.put(paramString, paramSortedSet);
  }
  
  public SortedSet<String> put(String paramString, SortedSet<String> paramSortedSet, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      remove(paramString);
      paramSortedSet = paramSortedSet.iterator();
      for (;;)
      {
        if (!paramSortedSet.hasNext()) {
          return get(paramString);
        }
        put(paramString, (String)paramSortedSet.next(), true);
      }
    }
    return (SortedSet)this.wrappedMap.put(paramString, paramSortedSet);
  }
  
  public void putAll(Map<? extends String, ? extends SortedSet<String>> paramMap)
  {
    this.wrappedMap.putAll(paramMap);
  }
  
  public void putAll(Map<? extends String, ? extends SortedSet<String>> paramMap, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return;
        }
        String str = (String)localIterator.next();
        put(str, (SortedSet)paramMap.get(str), true);
      }
    }
    this.wrappedMap.putAll(paramMap);
  }
  
  public void putAll(String[] paramArrayOfString, boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfString.length - 1) {
        return;
      }
      put(paramArrayOfString[i], paramArrayOfString[(i + 1)], paramBoolean);
      i += 2;
    }
  }
  
  public void putMap(Map<String, List<String>> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      String str = (String)localIterator.next();
      SortedSet localSortedSet = get(str);
      Object localObject = localSortedSet;
      if (localSortedSet == null)
      {
        localObject = new TreeSet();
        put(str, (SortedSet)localObject);
      }
      ((SortedSet)localObject).addAll((Collection)paramMap.get(str));
    }
  }
  
  public String putNull(String paramString1, String paramString2)
  {
    return put(paramString1, paramString2);
  }
  
  public SortedSet<String> remove(Object paramObject)
  {
    return (SortedSet)this.wrappedMap.remove(paramObject);
  }
  
  public int size()
  {
    int i = 0;
    Iterator localIterator = this.wrappedMap.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return i;
      }
      String str = (String)localIterator.next();
      i += ((SortedSet)this.wrappedMap.get(str)).size();
    }
  }
  
  public Collection<SortedSet<String>> values()
  {
    return this.wrappedMap.values();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/signpost/http/HttpParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */