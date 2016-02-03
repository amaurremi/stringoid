package com.getjar.sdk.comm;

import android.content.Context;
import com.getjar.sdk.config.GetJarConfig;
import com.getjar.sdk.config.SettingsManager.Scope;
import com.getjar.sdk.data.cache.BasicCache;
import com.getjar.sdk.data.cache.CacheEntry;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.Base64;
import com.getjar.sdk.utilities.StringUtility;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class BeaconCachingManager
{
  private static final String _CacheNamespace = "beacon.cache";
  private int _CacheLRUCap = 500;
  private long _CacheTTL = 86400000L;
  private final BasicCache _cachingManager;
  
  public BeaconCachingManager(Context paramContext)
  {
    this._cachingManager = new BasicCache(paramContext, "beacon.cache", 1, false);
    this._CacheTTL = (GetJarConfig.getInstance(paramContext).getIntegerValue("beacon.cache.ttl", Integer.valueOf(86400), SettingsManager.Scope.CLIENT).intValue() * 1000);
    this._CacheLRUCap = GetJarConfig.getInstance(paramContext).getIntegerValue("beacon.cache.ttl", Integer.valueOf(500), SettingsManager.Scope.CLIENT).intValue();
  }
  
  public BeaconMessage get(String paramString)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'key' cannot be null or empty");
    }
    try
    {
      paramString = this._cachingManager.getUnexpiredCacheEntry(paramString);
      if (paramString != null)
      {
        paramString = (BeaconMessage)Base64.decodeToObject(paramString.getValue());
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      Logger.w(Area.BEACON.value() | Area.STORAGE.value(), "BeaconCachingManager: getBeaconMessageString() Error decoding BeaconMessage", new Object[0]);
    }
    return null;
  }
  
  public HashMap<String, BeaconMessage> getAll()
  {
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        Object localObject = this._cachingManager.getAllCacheEntries();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            CacheEntry localCacheEntry = (CacheEntry)((Iterator)localObject).next();
            try
            {
              if (localCacheEntry.hasTtlExpired()) {
                break label121;
              }
              localHashMap.put(localCacheEntry.getName(), (BeaconMessage)Base64.decodeToObject(localCacheEntry.getValue()));
            }
            catch (Exception localException2)
            {
              Logger.w(Area.BEACON.value() | Area.STORAGE.value(), localException2, "BeaconCachingManager: getAll() Error decoding BeaconMessage", new Object[0]);
            }
            continue;
          }
        }
        return localHashMap;
      }
      catch (Exception localException1)
      {
        Logger.w(Area.BEACON.value(), localException1, "BeaconCachingManager: getAll() Error getting cache items", new Object[0]);
      }
      label121:
      remove(localException2.getName());
    }
  }
  
  public void remove(String paramString)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'hashCode' cannot be null or empty");
    }
    this._cachingManager.removeCacheEntry(paramString);
    Logger.v(Area.BEACON.value(), "BeaconCachingManager: removed beacon with key:%1$s", new Object[] { paramString });
  }
  
  public void upsert(String paramString, BeaconMessage paramBeaconMessage)
  {
    Logger.v(Area.BEACON.value(), "BeaconCachingManager: add() started", new Object[0]);
    try
    {
      this._cachingManager.updateCache(paramString, Base64.encodeObject(paramBeaconMessage), Long.valueOf(this._CacheTTL), null, null);
      this._cachingManager.trimLruEntries(this._CacheLRUCap);
      return;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        Logger.w(Area.BEACON.value() | Area.STORAGE.value(), "Error storing beaconMessage", new Object[0]);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/BeaconCachingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */