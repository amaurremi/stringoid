package com.b.a.a.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class i
{
  Map<String, l> a = new HashMap();
  Map<String, j> b = new HashMap();
  
  public l a(String paramString)
  {
    return (l)this.a.get(paramString);
  }
  
  void a(j paramj)
  {
    this.b.put(paramj.b(), paramj);
  }
  
  void a(l paraml)
  {
    this.a.put(paraml.a(), paraml);
  }
  
  public j b(String paramString)
  {
    return (j)this.b.get(paramString);
  }
  
  public boolean c(String paramString)
  {
    return this.b.containsKey(paramString);
  }
  
  List<String> d(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.values().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localArrayList;
      }
      j localj = (j)localIterator.next();
      if (localj.a().equals(paramString)) {
        localArrayList.add(localj.b());
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/b/a/a/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */