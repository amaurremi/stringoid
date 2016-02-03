package com.google.tagmanager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class SimpleCache<K, V>
  implements Cache<K, V>
{
  private final Map<K, V> mHashMap = new HashMap();
  private final int mMaxSize;
  private final CacheFactory.CacheSizeManager<K, V> mSizeManager;
  private int mTotalSize;
  
  SimpleCache(int paramInt, CacheFactory.CacheSizeManager<K, V> paramCacheSizeManager)
  {
    this.mMaxSize = paramInt;
    this.mSizeManager = paramCacheSizeManager;
  }
  
  public V get(K paramK)
  {
    try
    {
      paramK = this.mHashMap.get(paramK);
      return paramK;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  public void put(K paramK, V paramV)
  {
    if ((paramK == null) || (paramV == null)) {
      try
      {
        throw new NullPointerException("key == null || value == null");
      }
      finally {}
    }
    this.mTotalSize += this.mSizeManager.sizeOf(paramK, paramV);
    if (this.mTotalSize > this.mMaxSize)
    {
      Iterator localIterator = this.mHashMap.entrySet().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.mTotalSize -= this.mSizeManager.sizeOf(localEntry.getKey(), localEntry.getValue());
        localIterator.remove();
      } while (this.mTotalSize > this.mMaxSize);
    }
    this.mHashMap.put(paramK, paramV);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/SimpleCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */