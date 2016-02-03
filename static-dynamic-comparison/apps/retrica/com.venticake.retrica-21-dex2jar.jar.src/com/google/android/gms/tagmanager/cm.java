package com.google.android.gms.tagmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class cm
{
  private final Set<cq.e> a = new HashSet();
  private final Map<cq.e, List<cq.a>> b = new HashMap();
  private final Map<cq.e, List<cq.a>> c = new HashMap();
  private final Map<cq.e, List<String>> d = new HashMap();
  private final Map<cq.e, List<String>> e = new HashMap();
  private cq.a f;
  
  public Set<cq.e> a()
  {
    return this.a;
  }
  
  public void a(cq.a parama)
  {
    this.f = parama;
  }
  
  public void a(cq.e parame)
  {
    this.a.add(parame);
  }
  
  public void a(cq.e parame, cq.a parama)
  {
    List localList = (List)this.b.get(parame);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.b.put(parame, localObject);
    }
    ((List)localObject).add(parama);
  }
  
  public void a(cq.e parame, String paramString)
  {
    List localList = (List)this.d.get(parame);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.d.put(parame, localObject);
    }
    ((List)localObject).add(paramString);
  }
  
  public Map<cq.e, List<cq.a>> b()
  {
    return this.b;
  }
  
  public void b(cq.e parame, cq.a parama)
  {
    List localList = (List)this.c.get(parame);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.c.put(parame, localObject);
    }
    ((List)localObject).add(parama);
  }
  
  public void b(cq.e parame, String paramString)
  {
    List localList = (List)this.e.get(parame);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.e.put(parame, localObject);
    }
    ((List)localObject).add(paramString);
  }
  
  public Map<cq.e, List<String>> c()
  {
    return this.d;
  }
  
  public Map<cq.e, List<String>> d()
  {
    return this.e;
  }
  
  public Map<cq.e, List<cq.a>> e()
  {
    return this.c;
  }
  
  public cq.a f()
  {
    return this.f;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */