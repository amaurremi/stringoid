package b.a.c;

import b.a.c;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class a
  implements Serializable, Map
{
  private TreeMap a = new TreeMap();
  
  public a a()
  {
    a locala = new a();
    Iterator localIterator = entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if ((str.startsWith("oauth_")) || (str.startsWith("x_oauth_"))) {
        locala.a(str, (SortedSet)localEntry.getValue());
      }
    }
    return locala;
  }
  
  public String a(Object paramObject, boolean paramBoolean)
  {
    paramObject = (SortedSet)this.a.get(paramObject);
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
    return c.b(str);
  }
  
  public String a(String paramString)
  {
    String str = b(paramString);
    if (str == null) {
      return null;
    }
    return paramString + "=\"" + str + "\"";
  }
  
  public String a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, false);
  }
  
  public String a(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str = paramString1;
    if (paramBoolean) {
      str = c.a(paramString1);
    }
    paramString1 = (SortedSet)this.a.get(str);
    Object localObject = paramString1;
    if (paramString1 == null)
    {
      localObject = new TreeSet();
      this.a.put(str, localObject);
    }
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (paramBoolean) {
        paramString1 = c.a(paramString2);
      }
      ((SortedSet)localObject).add(paramString1);
    }
    return paramString1;
  }
  
  public SortedSet a(Object paramObject)
  {
    return (SortedSet)this.a.get(paramObject);
  }
  
  public SortedSet a(String paramString, SortedSet paramSortedSet)
  {
    return (SortedSet)this.a.put(paramString, paramSortedSet);
  }
  
  public SortedSet a(String paramString, SortedSet paramSortedSet, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c(paramString);
      paramSortedSet = paramSortedSet.iterator();
      while (paramSortedSet.hasNext()) {
        a(paramString, (String)paramSortedSet.next(), true);
      }
      return a(paramString);
    }
    return (SortedSet)this.a.put(paramString, paramSortedSet);
  }
  
  public void a(Map paramMap, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        a(str, (SortedSet)paramMap.get(str), true);
      }
    }
    this.a.putAll(paramMap);
  }
  
  public void a(String[] paramArrayOfString, boolean paramBoolean)
  {
    int i = 0;
    while (i < paramArrayOfString.length - 1)
    {
      a(paramArrayOfString[i], paramArrayOfString[(i + 1)], paramBoolean);
      i += 2;
    }
  }
  
  public String b(Object paramObject)
  {
    return a(paramObject, false);
  }
  
  public String b(Object paramObject, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = paramObject;
    if (paramBoolean) {
      localObject = c.a((String)paramObject);
    }
    paramObject = (Set)this.a.get(localObject);
    if (paramObject == null) {
      return localObject + "=";
    }
    paramObject = ((Set)paramObject).iterator();
    while (((Iterator)paramObject).hasNext())
    {
      localStringBuilder.append(localObject + "=" + (String)((Iterator)paramObject).next());
      if (((Iterator)paramObject).hasNext()) {
        localStringBuilder.append("&");
      }
    }
    return localStringBuilder.toString();
  }
  
  public SortedSet c(Object paramObject)
  {
    return (SortedSet)this.a.remove(paramObject);
  }
  
  public void clear()
  {
    this.a.clear();
  }
  
  public boolean containsKey(Object paramObject)
  {
    return this.a.containsKey(paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      if (((SortedSet)localIterator.next()).contains(paramObject)) {
        return true;
      }
    }
    return false;
  }
  
  public Set entrySet()
  {
    return this.a.entrySet();
  }
  
  public boolean isEmpty()
  {
    return this.a.isEmpty();
  }
  
  public Set keySet()
  {
    return this.a.keySet();
  }
  
  public void putAll(Map paramMap)
  {
    this.a.putAll(paramMap);
  }
  
  public int size()
  {
    Iterator localIterator = this.a.keySet().iterator();
    String str;
    for (int i = 0; localIterator.hasNext(); i = ((SortedSet)this.a.get(str)).size() + i) {
      str = (String)localIterator.next();
    }
    return i;
  }
  
  public Collection values()
  {
    return this.a.values();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/b/a/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */