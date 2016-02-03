package com.google.android.gms.tagmanager;

import android.util.LruCache;

class an<K, V>
  implements dn<K, V>
{
  private LruCache<K, V> a;
  
  an(int paramInt, final l.a<K, V> parama)
  {
    this.a = new LruCache(paramInt)
    {
      protected int sizeOf(K paramAnonymousK, V paramAnonymousV)
      {
        return parama.sizeOf(paramAnonymousK, paramAnonymousV);
      }
    };
  }
  
  public V a(K paramK)
  {
    return (V)this.a.get(paramK);
  }
  
  public void a(K paramK, V paramV)
  {
    this.a.put(paramK, paramV);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */