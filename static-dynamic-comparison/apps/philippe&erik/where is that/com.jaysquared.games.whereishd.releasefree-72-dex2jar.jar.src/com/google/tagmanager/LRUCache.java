package com.google.tagmanager;

import android.annotation.TargetApi;
import android.util.LruCache;

@TargetApi(12)
class LRUCache<K, V>
  implements Cache<K, V>
{
  private LruCache<K, V> lruCache;
  
  LRUCache(int paramInt, final CacheFactory.CacheSizeManager<K, V> paramCacheSizeManager)
  {
    this.lruCache = new LruCache(paramInt)
    {
      protected int sizeOf(K paramAnonymousK, V paramAnonymousV)
      {
        return paramCacheSizeManager.sizeOf(paramAnonymousK, paramAnonymousV);
      }
    };
  }
  
  public V get(K paramK)
  {
    return (V)this.lruCache.get(paramK);
  }
  
  public void put(K paramK, V paramV)
  {
    this.lruCache.put(paramK, paramV);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/LRUCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */