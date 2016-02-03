package com.getjar.sdk.data.cache;

import android.content.Context;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.StringUtility;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

public class BasicCache
  implements CacheStorage
{
  private final DBCache _dbCache;
  
  public BasicCache(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'androidContext' cannot be NULL");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'namespace' cannot be NULL or empty");
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("'databaseVersion' cannot be less than 0");
    }
    if (paramBoolean)
    {
      this._dbCache = DBCache.getInstanceUserSpecific(paramContext, paramString, paramInt);
      return;
    }
    this._dbCache = DBCache.getInstanceAllUsers(paramContext, paramString, paramInt);
  }
  
  private CacheEntry getCacheEntryInternal(String paramString)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'name' cannot be NULL or empty");
    }
    try
    {
      CacheEntry localCacheEntry = this._dbCache.loadCacheEntry(paramString);
      return localCacheEntry;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      this._dbCache.deleteCacheEntry(paramString);
    }
    return null;
  }
  
  public ArrayList<CacheEntry> getAllCacheEntries()
  {
    Object localObject1 = null;
    try
    {
      localObject2 = this._dbCache.loadAllCacheEntries();
      localObject1 = localObject2;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      for (;;)
      {
        Object localObject2;
        Logger.e(Area.STORAGE.value(), localURISyntaxException, "BasicCache: getAllCacheEntries() failed to load entries", new Object[0]);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new ArrayList();
    }
    return (ArrayList<CacheEntry>)localObject2;
  }
  
  public HashMap<String, CacheEntry> getCacheEntries(String... paramVarArgs)
  {
    return this._dbCache.loadCacheEntryMap(paramVarArgs);
  }
  
  public CacheEntry getCacheEntry(String paramString)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'name' cannot be NULL or empty");
    }
    CacheEntry localCacheEntry = getCacheEntryInternal(paramString);
    if (localCacheEntry != null)
    {
      Logger.v(Area.STORAGE.value(), "BasicCache: getCacheEntry() Found a cache entry for %1$s.%2$s", new Object[] { this._dbCache.getDatabaseName(), paramString });
      return localCacheEntry;
    }
    return null;
  }
  
  protected ArrayList<CacheEntry> getLruEntries(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("'maxRecordsCap' cannot be negative");
    }
    try
    {
      ArrayList localArrayList = this._dbCache.getLruEntries(paramInt);
      return localArrayList;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      Logger.e(Area.STORAGE.value(), localURISyntaxException, "BasicCache: getLruEntries() failed to load entries", new Object[0]);
    }
    return new ArrayList();
  }
  
  public CacheEntry getUnexpiredCacheEntry(String paramString)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'name' cannot be NULL or empty");
    }
    CacheEntry localCacheEntry = getCacheEntryInternal(paramString);
    if ((localCacheEntry != null) && (!localCacheEntry.hasTtlExpired()))
    {
      Logger.v(Area.STORAGE.value(), "BasicCache: getCurrentCacheEntry() Found a cache entry for %1$s.%2$s", new Object[] { this._dbCache.getDatabaseName(), paramString });
      return localCacheEntry;
    }
    return null;
  }
  
  public boolean isCacheNewVersion()
  {
    return this._dbCache.isDatabaseNewVersion();
  }
  
  public long recordCount()
  {
    return this._dbCache.getRecordCount();
  }
  
  public void removeCacheEntries()
  {
    int i = this._dbCache.deleteCacheEntries();
    Logger.v(Area.STORAGE.value(), "BasicCache: removeCacheEntries() deleted %1$d entries", new Object[] { Integer.valueOf(i) });
  }
  
  public void removeCacheEntry(String paramString)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("name cannot be empty or null");
    }
    this._dbCache.deleteCacheEntry(paramString);
    Logger.v(Area.STORAGE.value(), "BasicCache: removeCacheEntry() CacheEntry \"%1$s\" removed", new Object[] { paramString });
  }
  
  public void trimLruEntries(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("'maxRecordsCap' cannot be negative");
    }
    this._dbCache.trimLruEntries(paramInt);
  }
  
  public boolean updateCache(String paramString1, String paramString2, Long paramLong, String paramString3, URI paramURI)
  {
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("'name' cannot be NULL or empty");
    }
    if (paramLong == null) {
      throw new IllegalArgumentException("'ttl' cannot be NULL");
    }
    paramString2 = new CacheEntry(paramString1, paramString2, paramLong, paramString3, paramURI);
    if (!this._dbCache.upsertCacheEntry(paramString2))
    {
      Logger.e(Area.STORAGE.value(), "BasicCache: updateCache() Cache entry update failed: %1$s.%2$s", new Object[] { this._dbCache.getDatabaseName(), paramString1 });
      return false;
    }
    Logger.d(Area.STORAGE.value(), "BasicCache: updateCache() Cache entry updated: %1$s.%2$s", new Object[] { this._dbCache.getDatabaseName(), paramString1 });
    return true;
  }
  
  public boolean updateCache(String paramString1, byte[] paramArrayOfByte, Long paramLong, String paramString2, URI paramURI)
  {
    throw new UnsupportedOperationException("BasicCache does not support binary values");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/cache/BasicCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */