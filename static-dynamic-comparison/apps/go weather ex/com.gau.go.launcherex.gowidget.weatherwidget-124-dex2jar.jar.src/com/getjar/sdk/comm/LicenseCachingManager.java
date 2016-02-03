package com.getjar.sdk.comm;

import com.getjar.sdk.GetjarLicense.Scope;
import com.getjar.sdk.data.LicenseInternal;
import com.getjar.sdk.data.cache.BasicCache;
import com.getjar.sdk.data.cache.CacheEntry;
import com.getjar.sdk.exceptions.CachingException;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.Base64;
import com.getjar.sdk.utilities.StringUtility;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class LicenseCachingManager
{
  private static final int _LRUCapMaximum = 200;
  private final BasicCache _cachingManager;
  private String cacheNamespace = "commLicenseCache";
  
  public LicenseCachingManager(CommContext paramCommContext)
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("'androidContext' can not be NULL");
    }
    this._cachingManager = new BasicCache(paramCommContext.getApplicationContext(), this.cacheNamespace, 6, true);
  }
  
  private static String getCacheKey(LicenseInternal paramLicenseInternal)
  {
    if (paramLicenseInternal == null) {
      throw new IllegalArgumentException("internalLicense cannot be null");
    }
    try
    {
      GetjarLicense.Scope localScope = GetjarLicense.Scope.valueOf(new JSONObject(paramLicenseInternal.getSignedLicenseData()).getString("license_scope"));
      paramLicenseInternal = getCacheKey(paramLicenseInternal.getItemId(), localScope);
      return paramLicenseInternal;
    }
    catch (JSONException paramLicenseInternal)
    {
      throw new IllegalStateException("'license' does not contain a valid license_scope parameter");
    }
  }
  
  private static String getCacheKey(String paramString, GetjarLicense.Scope paramScope)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'itemId' cannot be null or empty");
    }
    if (paramScope == null) {
      throw new IllegalArgumentException("licenseScope cannot be null");
    }
    return String.format(Locale.US, "%s%s", new Object[] { paramString, paramScope.toString() });
  }
  
  public boolean addLicenseToCache(LicenseInternal paramLicenseInternal, Long paramLong, String paramString)
  {
    if (paramLicenseInternal == null) {
      throw new IllegalArgumentException("license cannot be null");
    }
    Logger.d(Area.LICENSING.value() | Area.STORAGE.value(), "LicenseCachingManager -- addLicenseToCache -- started ", new Object[0]);
    try
    {
      localObject = GetjarLicense.Scope.valueOf(new JSONObject(paramLicenseInternal.getSignedLicenseData()).getString("license_scope"));
      localObject = getCachedLicense(paramLicenseInternal.getItemId(), (GetjarLicense.Scope)localObject);
      if ((localObject != null) && ((((LicenseInternal)localObject).getModificationTime().after(paramLicenseInternal.getModificationTime())) || (((LicenseInternal)localObject).getModificationTime().equals(paramLicenseInternal.getModificationTime()))))
      {
        Logger.d(Area.LICENSING.value() | Area.STORAGE.value(), "LicenseCachingManager -- addLicenseToCache New license already in cache -- returning false", new Object[0]);
        return false;
      }
    }
    catch (JSONException paramLicenseInternal)
    {
      throw new IllegalArgumentException("'license' does not contain a valid license_scope parameter");
    }
    Object localObject = paramLong;
    if (paramLong == null)
    {
      Logger.w(Area.LICENSING.value() | Area.STORAGE.value(), "LicenseCachingManager -- addLicenseToCache ttl is null, using default", new Object[0]);
      localObject = Long.valueOf(86400000L);
    }
    Logger.d(Area.LICENSING.value() | Area.STORAGE.value(), " LicenseCachingManager -- addLicenseToCache TTL" + localObject, new Object[0]);
    try
    {
      boolean bool = this._cachingManager.updateCache(getCacheKey(paramLicenseInternal), Base64.encodeObject(paramLicenseInternal), (Long)localObject, paramString, null);
      Logger.d(Area.LICENSING.value() | Area.STORAGE.value(), "LicenseCachingManager -- addLicenseToCache -- returning %1$s", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
    catch (IOException paramLicenseInternal)
    {
      Logger.e(Area.LICENSING.value() | Area.STORAGE.value(), paramLicenseInternal, "LicenseCachingManager -- addLicenseToCache -- Error", new Object[0]);
      throw new CachingException(paramLicenseInternal);
    }
  }
  
  public LicensesWithETag getAllLicenses()
  {
    Logger.d(Area.LICENSING.value(), "LicenseCachingManager getAllLicenses()", new Object[0]);
    Object localObject3 = null;
    Object localObject1 = null;
    boolean bool2 = false;
    boolean bool1 = false;
    ArrayList localArrayList1 = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        ArrayList localArrayList2 = this._cachingManager.getAllCacheEntries();
        if (localArrayList2 != null)
        {
          i = 0;
          localObject3 = localObject1;
          bool2 = bool1;
          if (i < localArrayList2.size())
          {
            CacheEntry localCacheEntry = (CacheEntry)localArrayList2.get(i);
            localObject3 = localObject1;
            if (StringUtility.isNullOrEmpty((String)localObject1)) {
              localObject3 = localCacheEntry.getEtag();
            }
            bool2 = bool1;
            if (localCacheEntry == null) {
              break label188;
            }
            localObject1 = (LicenseInternal)Base64.decodeToObject(localCacheEntry.getValue());
            if (localCacheEntry.hasTtlExpired())
            {
              bool1 = true;
              ((LicenseInternal)localObject1).setLicenseStale(true);
              localArrayList1.add(localObject1);
              bool2 = bool1;
              break label188;
            }
            ((LicenseInternal)localObject1).setLicenseStale(false);
            continue;
          }
        }
        localObject2 = new LicensesWithETag(localArrayList1, (String)localObject3);
      }
      catch (Exception localException)
      {
        throw new CachingException(localException);
      }
      ((LicensesWithETag)localObject2).setHasStaleLicense(bool2);
      return (LicensesWithETag)localObject2;
      label188:
      i += 1;
      Object localObject2 = localObject3;
      bool1 = bool2;
    }
  }
  
  public LicenseInternal getCachedLicense(String paramString, GetjarLicense.Scope paramScope)
  {
    try
    {
      paramString = this._cachingManager.getCacheEntry(getCacheKey(paramString, paramScope));
      if (paramString != null)
      {
        paramScope = (LicenseInternal)Base64.decodeToObject(paramString.getValue());
        paramScope.setLicenseStale(paramString.hasTtlExpired());
        return paramScope;
      }
    }
    catch (Exception paramString)
    {
      Logger.e(Area.LICENSING.value() | Area.STORAGE.value(), paramString, "LicenseCachingManager: getCachedLicense() failed", new Object[0]);
    }
    return null;
  }
  
  public LicenseInternal getValidCachedLicense(String paramString, GetjarLicense.Scope paramScope)
  {
    Logger.d(Area.LICENSING.value() | Area.STORAGE.value(), "LicenseCachingManager -- getCachedLicense started for " + paramString, new Object[0]);
    try
    {
      paramScope = this._cachingManager.getCacheEntry(getCacheKey(paramString, paramScope));
      if ((paramScope != null) && (!paramScope.hasTtlExpired()))
      {
        Logger.v(Area.LICENSING.value() | Area.STORAGE.value(), "LicenseCachingManager: getValidCachedLicense() Found a cached result for itemId %1$s", new Object[] { paramString });
        paramString = (LicenseInternal)Base64.decodeToObject(paramScope.getValue());
        paramString.setLicenseStale(false);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      Logger.e(Area.LICENSING.value() | Area.STORAGE.value(), paramString, "LicenseCachingManager: getCachedLicense() failed", new Object[0]);
    }
    return null;
  }
  
  public boolean hasExpiredEntry()
  {
    try
    {
      ArrayList localArrayList = this._cachingManager.getAllCacheEntries();
      if (localArrayList != null)
      {
        int i = 0;
        while (i < localArrayList.size())
        {
          boolean bool = ((CacheEntry)localArrayList.get(i)).hasTtlExpired();
          if (bool) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      throw new CachingException(localException);
    }
  }
  
  public boolean isCacheNewVersion()
  {
    return this._cachingManager.isCacheNewVersion();
  }
  
  public void removeCachedLicense(LicenseInternal paramLicenseInternal)
  {
    if (paramLicenseInternal == null) {
      throw new IllegalArgumentException("license cannot be null");
    }
    this._cachingManager.removeCacheEntry(getCacheKey(paramLicenseInternal));
  }
  
  public void removeCachedLicenses()
  {
    this._cachingManager.removeCacheEntries();
  }
  
  public void trimLruEntries()
  {
    this._cachingManager.trimLruEntries(200);
  }
  
  public class LicensesWithETag
  {
    public final String eTag;
    public boolean hasStaleLicense = false;
    public final List<LicenseInternal> licenses;
    
    public LicensesWithETag(String paramString)
    {
      this.licenses = Collections.unmodifiableList(paramString);
      String str;
      this.eTag = str;
    }
    
    private void setHasStaleLicense(boolean paramBoolean)
    {
      this.hasStaleLicense = paramBoolean;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/LicenseCachingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */