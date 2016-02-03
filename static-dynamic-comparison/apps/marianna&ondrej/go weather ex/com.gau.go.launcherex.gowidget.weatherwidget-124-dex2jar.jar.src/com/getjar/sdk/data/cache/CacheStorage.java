package com.getjar.sdk.data.cache;

import java.net.URI;
import java.util.ArrayList;

public abstract interface CacheStorage
{
  public abstract ArrayList<CacheEntry> getAllCacheEntries();
  
  public abstract CacheEntry getCacheEntry(String paramString);
  
  public abstract CacheEntry getUnexpiredCacheEntry(String paramString);
  
  public abstract void removeCacheEntries();
  
  public abstract void removeCacheEntry(String paramString);
  
  public abstract void trimLruEntries(int paramInt);
  
  public abstract boolean updateCache(String paramString1, String paramString2, Long paramLong, String paramString3, URI paramURI);
  
  public abstract boolean updateCache(String paramString1, byte[] paramArrayOfByte, Long paramLong, String paramString2, URI paramURI);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/cache/CacheStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */