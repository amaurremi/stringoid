package com.google.android.gms.tagmanager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class cu<K, V>
  implements dn<K, V>
{
  private final Map<K, V> a = new HashMap();
  private final int b;
  private final l.a<K, V> c;
  private int d;
  
  cu(int paramInt, l.a<K, V> parama)
  {
    this.b = paramInt;
    this.c = parama;
  }
  
  public V a(K paramK)
  {
    try
    {
      paramK = this.a.get(paramK);
      return paramK;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  public void a(K paramK, V paramV)
  {
    if ((paramK == null) || (paramV == null)) {
      try
      {
        throw new NullPointerException("key == null || value == null");
      }
      finally {}
    }
    this.d += this.c.sizeOf(paramK, paramV);
    if (this.d > this.b)
    {
      Iterator localIterator = this.a.entrySet().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.d -= this.c.sizeOf(localEntry.getKey(), localEntry.getValue());
        localIterator.remove();
      } while (this.d > this.b);
    }
    this.a.put(paramK, paramV);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */