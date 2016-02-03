package com.google.api.client.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

final class j
  extends AbstractMap<String, Object>
{
  final h abf;
  final Object cE;
  
  j(Object paramObject, boolean paramBoolean)
  {
    this.cE = paramObject;
    this.abf = h.a(paramObject.getClass(), paramBoolean);
    if (!this.abf.isEnum()) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      x.av(paramBoolean);
      return;
    }
  }
  
  public boolean containsKey(Object paramObject)
  {
    return get(paramObject) != null;
  }
  
  public Object get(Object paramObject)
  {
    if (!(paramObject instanceof String)) {}
    do
    {
      return null;
      paramObject = this.abf.cs((String)paramObject);
    } while (paramObject == null);
    return ((l)paramObject).aj(this.cE);
  }
  
  public Object put(String paramString, Object paramObject)
  {
    l locall = this.abf.cs(paramString);
    x.h(locall, "no field of key " + paramString);
    paramString = locall.aj(this.cE);
    locall.j(this.cE, x.ad(paramObject));
    return paramString;
  }
  
  public c yJ()
  {
    return new c();
  }
  
  final class a
    implements Map.Entry<String, Object>
  {
    private Object adw;
    private final l adx;
    
    a(l paraml, Object paramObject)
    {
      this.adx = paraml;
      this.adw = x.ad(paramObject);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof Map.Entry)) {
          return false;
        }
        paramObject = (Map.Entry)paramObject;
      } while ((getKey().equals(((Map.Entry)paramObject).getKey())) && (getValue().equals(((Map.Entry)paramObject).getValue())));
      return false;
    }
    
    public String getKey()
    {
      String str2 = this.adx.getName();
      String str1 = str2;
      if (j.this.abf.yH()) {
        str1 = str2.toLowerCase();
      }
      return str1;
    }
    
    public Object getValue()
    {
      return this.adw;
    }
    
    public int hashCode()
    {
      return getKey().hashCode() ^ getValue().hashCode();
    }
    
    public Object setValue(Object paramObject)
    {
      Object localObject = this.adw;
      this.adw = x.ad(paramObject);
      this.adx.j(j.this.cE, paramObject);
      return localObject;
    }
  }
  
  final class b
    implements Iterator<Map.Entry<String, Object>>
  {
    private l adA;
    private Object adB;
    private boolean adC;
    private boolean adD;
    private l adE;
    private int adz = -1;
    
    b() {}
    
    public boolean hasNext()
    {
      if (!this.adD)
      {
        this.adD = true;
        for (this.adB = null; this.adB == null; this.adB = this.adA.aj(j.this.cE))
        {
          int i = this.adz + 1;
          this.adz = i;
          if (i >= j.this.abf.adh.size()) {
            break;
          }
          this.adA = j.this.abf.cs((String)j.this.abf.adh.get(this.adz));
        }
      }
      return this.adB != null;
    }
    
    public Map.Entry<String, Object> r()
    {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      this.adE = this.adA;
      Object localObject = this.adB;
      this.adD = false;
      this.adC = false;
      this.adA = null;
      this.adB = null;
      return new j.a(j.this, this.adE, localObject);
    }
    
    public void remove()
    {
      if ((this.adE != null) && (!this.adC)) {}
      for (boolean bool = true;; bool = false)
      {
        x.aw(bool);
        this.adC = true;
        this.adE.j(j.this.cE, null);
        return;
      }
    }
  }
  
  final class c
    extends AbstractSet<Map.Entry<String, Object>>
  {
    c() {}
    
    public void clear()
    {
      Iterator localIterator = j.this.abf.adh.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        j.this.abf.cs(str).j(j.this.cE, null);
      }
    }
    
    public boolean isEmpty()
    {
      Iterator localIterator = j.this.abf.adh.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (j.this.abf.cs(str).aj(j.this.cE) != null) {
          return false;
        }
      }
      return true;
    }
    
    public int size()
    {
      Iterator localIterator = j.this.abf.adh.iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (j.this.abf.cs(str).aj(j.this.cE) == null) {
          break label70;
        }
        i += 1;
      }
      label70:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    public j.b yK()
    {
      return new j.b(j.this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/util/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */