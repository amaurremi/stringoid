package com.google.api.client.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  private final Map<String, a> acS = a.yC();
  private final Map<Field, a> acT = a.yC();
  private final Object acU;
  
  public b(Object paramObject)
  {
    this.acU = paramObject;
  }
  
  public void a(Field paramField, Class<?> paramClass, Object paramObject)
  {
    a locala2 = (a)this.acT.get(paramField);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(paramClass);
      this.acT.put(paramField, locala1);
    }
    locala1.a(paramClass, paramObject);
  }
  
  public void yE()
  {
    Iterator localIterator = this.acS.entrySet().iterator();
    Map.Entry localEntry;
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      ((Map)this.acU).put(localEntry.getKey(), ((a)localEntry.getValue()).yF());
    }
    localIterator = this.acT.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      l.a((Field)localEntry.getKey(), this.acU, ((a)localEntry.getValue()).yF());
    }
  }
  
  static class a
  {
    final Class<?> acV;
    final ArrayList<Object> acW = new ArrayList();
    
    a(Class<?> paramClass)
    {
      this.acV = paramClass;
    }
    
    void a(Class<?> paramClass, Object paramObject)
    {
      if (paramClass == this.acV) {}
      for (boolean bool = true;; bool = false)
      {
        x.av(bool);
        this.acW.add(paramObject);
        return;
      }
    }
    
    Object yF()
    {
      return ae.a(this.acW, this.acV);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/util/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */