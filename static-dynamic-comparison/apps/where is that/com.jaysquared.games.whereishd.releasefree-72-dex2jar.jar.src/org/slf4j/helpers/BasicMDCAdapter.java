package org.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.slf4j.spi.MDCAdapter;

public class BasicMDCAdapter
  implements MDCAdapter
{
  private InheritableThreadLocal inheritableThreadLocal = new InheritableThreadLocal();
  
  public void clear()
  {
    HashMap localHashMap = (HashMap)this.inheritableThreadLocal.get();
    if (localHashMap != null)
    {
      localHashMap.clear();
      this.inheritableThreadLocal.remove();
    }
  }
  
  public String get(String paramString)
  {
    HashMap localHashMap = (HashMap)this.inheritableThreadLocal.get();
    if ((localHashMap != null) && (paramString != null)) {
      return (String)localHashMap.get(paramString);
    }
    return null;
  }
  
  public Map getCopyOfContextMap()
  {
    HashMap localHashMap = (HashMap)this.inheritableThreadLocal.get();
    if (localHashMap != null) {
      return new HashMap(localHashMap);
    }
    return null;
  }
  
  public Set getKeys()
  {
    HashMap localHashMap = (HashMap)this.inheritableThreadLocal.get();
    if (localHashMap != null) {
      return localHashMap.keySet();
    }
    return null;
  }
  
  public void put(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("key cannot be null");
    }
    HashMap localHashMap2 = (HashMap)this.inheritableThreadLocal.get();
    HashMap localHashMap1 = localHashMap2;
    if (localHashMap2 == null)
    {
      localHashMap1 = new HashMap();
      this.inheritableThreadLocal.set(localHashMap1);
    }
    localHashMap1.put(paramString1, paramString2);
  }
  
  public void remove(String paramString)
  {
    HashMap localHashMap = (HashMap)this.inheritableThreadLocal.get();
    if (localHashMap != null) {
      localHashMap.remove(paramString);
    }
  }
  
  public void setContextMap(Map paramMap)
  {
    HashMap localHashMap = (HashMap)this.inheritableThreadLocal.get();
    if (localHashMap != null)
    {
      localHashMap.clear();
      localHashMap.putAll(paramMap);
      return;
    }
    paramMap = new HashMap(paramMap);
    this.inheritableThreadLocal.set(paramMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/slf4j/helpers/BasicMDCAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */