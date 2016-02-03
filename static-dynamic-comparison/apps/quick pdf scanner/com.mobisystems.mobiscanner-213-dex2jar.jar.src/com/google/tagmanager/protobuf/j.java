package com.google.tagmanager.protobuf;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

class j
{
  private final n ajU;
  private final g ajV;
  private e ajW;
  private volatile n ajX;
  private volatile boolean ajY;
  
  private void BY()
  {
    if (this.ajX != null) {
      return;
    }
    try
    {
      if (this.ajX != null) {
        return;
      }
    }
    finally {}
    try
    {
      if (this.ajW != null) {
        this.ajX = ((n)this.ajU.fA().c(this.ajW, this.ajV));
      }
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public n BX()
  {
    BY();
    return this.ajX;
  }
  
  public boolean equals(Object paramObject)
  {
    BY();
    return this.ajX.equals(paramObject);
  }
  
  public int fI()
  {
    if (this.ajY) {
      return this.ajX.fI();
    }
    return this.ajW.size();
  }
  
  public int hashCode()
  {
    BY();
    return this.ajX.hashCode();
  }
  
  public n i(n paramn)
  {
    n localn = this.ajX;
    this.ajX = paramn;
    this.ajW = null;
    this.ajY = true;
    return localn;
  }
  
  public String toString()
  {
    BY();
    return this.ajX.toString();
  }
  
  static class a<K>
    implements Map.Entry<K, Object>
  {
    private Map.Entry<K, j> ajZ;
    
    private a(Map.Entry<K, j> paramEntry)
    {
      this.ajZ = paramEntry;
    }
    
    public K getKey()
    {
      return (K)this.ajZ.getKey();
    }
    
    public Object getValue()
    {
      j localj = (j)this.ajZ.getValue();
      if (localj == null) {
        return null;
      }
      return localj.BX();
    }
    
    public Object setValue(Object paramObject)
    {
      if (!(paramObject instanceof n)) {
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
      }
      return ((j)this.ajZ.getValue()).i((n)paramObject);
    }
  }
  
  static class b<K>
    implements Iterator<Map.Entry<K, Object>>
  {
    private Iterator<Map.Entry<K, Object>> aka;
    
    public b(Iterator<Map.Entry<K, Object>> paramIterator)
    {
      this.aka = paramIterator;
    }
    
    public boolean hasNext()
    {
      return this.aka.hasNext();
    }
    
    public Map.Entry<K, Object> r()
    {
      Map.Entry localEntry = (Map.Entry)this.aka.next();
      Object localObject = localEntry;
      if ((localEntry.getValue() instanceof j)) {
        localObject = new j.a(localEntry, null);
      }
      return (Map.Entry<K, Object>)localObject;
    }
    
    public void remove()
    {
      this.aka.remove();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/protobuf/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */