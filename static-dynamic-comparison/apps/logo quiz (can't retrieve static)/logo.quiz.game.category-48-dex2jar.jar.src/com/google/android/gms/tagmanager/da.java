package com.google.android.gms.tagmanager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class da<K, V>
  implements k<K, V>
{
  private final Map<K, V> ars = new HashMap();
  private final int art;
  private final l.a<K, V> aru;
  private int arv;
  
  da(int paramInt, l.a<K, V> parama)
  {
    this.art = paramInt;
    this.aru = parama;
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
    this.arv += this.aru.sizeOf(paramK, paramV);
    if (this.arv > this.art)
    {
      Iterator localIterator = this.ars.entrySet().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.arv -= this.aru.sizeOf(localEntry.getKey(), localEntry.getValue());
        localIterator.remove();
      } while (this.arv > this.art);
    }
    this.ars.put(paramK, paramV);
  }
  
  public V get(K paramK)
  {
    try
    {
      paramK = this.ars.get(paramK);
      return paramK;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */