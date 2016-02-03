package com.getjar.sdk.comm;

import com.getjar.sdk.data.cache.BasicCache;
import com.getjar.sdk.data.cache.CacheEntry;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.StringUtility;

public class LocalizationCachingManager
{
  private static final int _LRUCapMaximum = 500;
  private final BasicCache _cachingManager;
  private String cacheNamespace = "commLocalizationCache";
  
  public LocalizationCachingManager(CommContext paramCommContext)
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("'androidContext' can not be NULL");
    }
    this._cachingManager = new BasicCache(paramCommContext.getApplicationContext(), this.cacheNamespace, 5, false);
  }
  
  public void addPricingToCache(String paramString1, int paramInt, Long paramLong, String paramString2)
  {
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("theLookup cannot be null or empty");
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("recommendedPrice cannot be less than 0");
    }
    addPricingToCache(paramString1, Integer.toString(paramInt), paramLong, paramString2);
  }
  
  public void addPricingToCache(String paramString1, String paramString2, Long paramLong, String paramString3)
  {
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("theLookup cannot be null or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("recommendedPrice cannot be null or empty");
    }
    Logger.d(Area.LOCALIZATION.value() | Area.STORAGE.value(), "LocalizationCachingManager -- addPricingToCache -- started ", new Object[0]);
    Long localLong = paramLong;
    if (paramLong == null)
    {
      Logger.e(Area.LOCALIZATION.value() | Area.STORAGE.value(), "LocalizationCachingManager -- addLicenseToCache ttl cannot be null", new Object[0]);
      localLong = Long.valueOf(86400000L);
    }
    this._cachingManager.updateCache(paramString1, paramString2, localLong, paramString3, null);
  }
  
  public Integer getCachedPrice(String paramString)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'theLookup' cannot be null or empty");
    }
    paramString = getCachedPriceInternal(paramString, false);
    if (paramString != null) {
      return Integer.valueOf(Integer.parseInt(paramString));
    }
    return null;
  }
  
  public String getCachedPriceInternal(String paramString, boolean paramBoolean)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'theLookup' cannot be null or empty");
    }
    Object localObject1 = null;
    try
    {
      localObject2 = this._cachingManager.getCacheEntry(paramString);
      if (localObject2 != null) {
        if (paramBoolean)
        {
          if (paramBoolean)
          {
            localObject1 = localObject2;
            if (((CacheEntry)localObject2).hasTtlExpired()) {}
          }
        }
        else
        {
          localObject1 = localObject2;
          localObject2 = ((CacheEntry)localObject2).getValue();
          return (String)localObject2;
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject2 = null;
      if (localObject1 != null) {
        localObject2 = ((CacheEntry)localObject1).getValue();
      }
      Logger.w(Area.LOCALIZATION.value() | Area.STORAGE.value(), localException, "LocalizationCachingManager: getCachedPrice() failed for key[=%s] value[=%s]. Returning default value[null]", new Object[] { paramString, localObject2 });
    }
    return null;
  }
  
  public Integer getValidCachedPrice(String paramString)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'theLookup' cannot be null or empty");
    }
    paramString = getCachedPriceInternal(paramString, true);
    if (paramString != null) {
      return Integer.valueOf(Integer.parseInt(paramString));
    }
    return null;
  }
  
  public void removeCachedPricing(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("pricing cannot be null");
    }
    this._cachingManager.removeCacheEntry(paramString);
  }
  
  public void trimLruEntries()
  {
    this._cachingManager.trimLruEntries(500);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/LocalizationCachingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */