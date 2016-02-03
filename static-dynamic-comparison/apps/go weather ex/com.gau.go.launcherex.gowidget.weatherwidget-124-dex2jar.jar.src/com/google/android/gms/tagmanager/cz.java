package com.google.android.gms.tagmanager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class cz<K, V>
  implements k<K, V>
{
  private final Map<K, V> aap = new HashMap();
  private final int aaq;
  private final l.a<K, V> aar;
  private int aas;
  
  cz(int paramInt, l.a<K, V> parama)
  {
    this.aaq = paramInt;
    this.aar = parama;
  }
  
  public void e(K paramK, V paramV)
  {
    if ((paramK == null) || (paramV == null)) {
      try
      {
        throw new NullPointerException("key == null || value == null");
      }
      finally {}
    }
    this.aas += this.aar.sizeOf(paramK, paramV);
    if (this.aas > this.aaq)
    {
      Iterator localIterator = this.aap.entrySet().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.aas -= this.aar.sizeOf(localEntry.getKey(), localEntry.getValue());
        localIterator.remove();
      } while (this.aas > this.aaq);
    }
    this.aap.put(paramK, paramV);
  }
  
  public V get(K paramK)
  {
    try
    {
      paramK = this.aap.get(paramK);
      return paramK;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/tagmanager/cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */