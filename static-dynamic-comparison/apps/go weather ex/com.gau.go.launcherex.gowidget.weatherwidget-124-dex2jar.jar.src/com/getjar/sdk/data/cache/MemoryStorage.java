package com.getjar.sdk.data.cache;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryStorage
  implements CacheStorage
{
  private final CacheEntryTTLComparator _cacheEntryTTLComparator = new CacheEntryTTLComparator(null);
  private final ConcurrentHashMap<String, CacheEntry> _nameToEntry = new ConcurrentHashMap();
  
  public ArrayList<CacheEntry> getAllCacheEntries()
  {
    return new ArrayList(this._nameToEntry.values());
  }
  
  public CacheEntry getCacheEntry(String paramString)
  {
    return (CacheEntry)this._nameToEntry.get(paramString);
  }
  
  public CacheEntry getUnexpiredCacheEntry(String paramString)
  {
    CacheEntry localCacheEntry = getCacheEntry(paramString);
    paramString = localCacheEntry;
    if (localCacheEntry.hasTtlExpired()) {
      paramString = null;
    }
    return paramString;
  }
  
  public void removeCacheEntries()
  {
    this._nameToEntry.clear();
  }
  
  public void removeCacheEntry(String paramString)
  {
    this._nameToEntry.remove(paramString);
  }
  
  public void trimLruEntries(int paramInt)
  {
    ArrayList localArrayList = getAllCacheEntries();
    if (localArrayList.size() < paramInt) {}
    for (;;)
    {
      return;
      Collections.sort(localArrayList, this._cacheEntryTTLComparator);
      while (paramInt < localArrayList.size())
      {
        removeCacheEntry(((CacheEntry)localArrayList.get(paramInt)).getName());
        paramInt += 1;
      }
    }
  }
  
  public boolean updateCache(String paramString1, String paramString2, Long paramLong, String paramString3, URI paramURI)
  {
    this._nameToEntry.put(paramString1, new CacheEntry(paramString1, paramString2, paramLong, paramString3, paramURI));
    return true;
  }
  
  public boolean updateCache(String paramString1, byte[] paramArrayOfByte, Long paramLong, String paramString2, URI paramURI)
  {
    throw new UnsupportedOperationException("MemoryStorage does not support binary values");
  }
  
  private class CacheEntryTTLComparator
    implements Comparator<CacheEntry>
  {
    private CacheEntryTTLComparator() {}
    
    public int compare(CacheEntry paramCacheEntry1, CacheEntry paramCacheEntry2)
    {
      return (int)(paramCacheEntry2.getCreateTimestamp().longValue() - paramCacheEntry1.getCreateTimestamp().longValue());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/cache/MemoryStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */