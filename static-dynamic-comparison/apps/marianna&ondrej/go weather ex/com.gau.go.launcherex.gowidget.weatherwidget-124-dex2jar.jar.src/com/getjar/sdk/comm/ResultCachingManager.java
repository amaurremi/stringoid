package com.getjar.sdk.comm;

import android.content.Context;
import com.getjar.sdk.data.cache.BasicCache;
import com.getjar.sdk.data.cache.CacheEntry;
import com.getjar.sdk.exceptions.CachingException;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.Base64;
import com.getjar.sdk.utilities.StringUtility;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ResultCachingManager
{
  private static final int _LRUCapMaximum = 300;
  private final BasicCache _cachingManager;
  
  public ResultCachingManager(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'androidContext' can not be NULL");
    }
    this._cachingManager = new BasicCache(paramContext, paramString, 6, false);
  }
  
  private CacheEntry getCacheEntry(Request paramRequest)
  {
    return this._cachingManager.getCacheEntry(getCacheKey(paramRequest));
  }
  
  private String getCacheKey(Request paramRequest)
  {
    return String.format(Locale.US, "%1$d", new Object[] { Integer.valueOf(paramRequest.getId()) });
  }
  
  public static String getETagFromResult(Operation paramOperation)
  {
    if (paramOperation == null) {
      throw new IllegalArgumentException("'operation' can not be NULL");
    }
    return getETagFromResult(paramOperation.getResult());
  }
  
  public static String getETagFromResult(Result paramResult)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramResult != null)
    {
      localObject1 = localObject2;
      if (paramResult.getHeaders() != null)
      {
        localObject1 = localObject2;
        if (paramResult.getHeaders().containsKey("ETag"))
        {
          localObject1 = localObject2;
          if (paramResult.getHeaders().get("ETag") != null)
          {
            localObject1 = localObject2;
            if (((List)paramResult.getHeaders().get("ETag")).size() > 0) {
              localObject1 = (String)((List)paramResult.getHeaders().get("ETag")).get(0);
            }
          }
        }
      }
    }
    return (String)localObject1;
  }
  
  public static Long getTtlFromResult(Operation paramOperation)
  {
    if (paramOperation == null) {
      throw new IllegalArgumentException("'operation' can not be NULL");
    }
    return getTtlFromResult(paramOperation.getResult());
  }
  
  public static Long getTtlFromResult(Result paramResult)
  {
    String[] arrayOfString2 = null;
    String[] arrayOfString1 = null;
    Object localObject = arrayOfString2;
    Result localResult;
    if (paramResult != null)
    {
      localObject = arrayOfString2;
      if (paramResult.getHeaders() != null)
      {
        localObject = arrayOfString2;
        if (paramResult.getHeaders().containsKey("Cache-Control"))
        {
          localObject = arrayOfString2;
          if (paramResult.getHeaders().get("Cache-Control") != null)
          {
            localObject = arrayOfString2;
            if (((List)paramResult.getHeaders().get("Cache-Control")).size() > 0)
            {
              localObject = null;
              Iterator localIterator = ((List)paramResult.getHeaders().get("Cache-Control")).iterator();
              paramResult = (Result)localObject;
              if (localIterator.hasNext()) {
                paramResult = (String)localIterator.next();
              }
              localObject = arrayOfString2;
              if (!StringUtility.isNullOrEmpty(paramResult))
              {
                arrayOfString2 = paramResult.split(",");
                int j = arrayOfString2.length;
                int i = 0;
                paramResult = arrayOfString1;
                localObject = paramResult;
                if (i < j)
                {
                  localObject = arrayOfString2[i];
                  if (localObject == null) {
                    localObject = paramResult;
                  }
                  for (;;)
                  {
                    i += 1;
                    paramResult = (Result)localObject;
                    break;
                    localObject = ((String)localObject).trim();
                    if ("no-cache".equalsIgnoreCase((String)localObject)) {
                      return null;
                    }
                    arrayOfString1 = ((String)localObject).split("=");
                    localObject = paramResult;
                    if (arrayOfString1.length > 1)
                    {
                      localObject = paramResult;
                      if (arrayOfString1[0] != null)
                      {
                        localObject = paramResult;
                        if (arrayOfString1[1] != null)
                        {
                          localObject = paramResult;
                          if ("max-age".equalsIgnoreCase(arrayOfString1[0].trim())) {
                            try
                            {
                              long l = Long.parseLong(arrayOfString1[1].trim());
                              localObject = paramResult;
                              if (l >= 0L) {
                                localObject = Long.valueOf(1000L * l);
                              }
                            }
                            catch (NumberFormatException localNumberFormatException)
                            {
                              Logger.e(Area.COMM.value() | Area.STORAGE.value(), localNumberFormatException, "ResultCachingManager: getTtl() Parsing max-age failed", new Object[0]);
                              localResult = paramResult;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return localResult;
  }
  
  public void addResultToCache(Operation paramOperation)
  {
    if (paramOperation == null) {
      throw new IllegalArgumentException("'operation' can not be NULL");
    }
    if (paramOperation.getRequest() == null) {
      throw new IllegalStateException("Operation must have a Request");
    }
    if (paramOperation.getResult() == null) {
      throw new IllegalStateException(String.format(Locale.US, "Operation %1$d does not yet have a Result", new Object[] { Integer.valueOf(paramOperation.getId()) }));
    }
    if (!paramOperation.getResult().isSuccessfulResponse()) {}
    Long localLong;
    do
    {
      return;
      localLong = getTtlFromResult(paramOperation);
    } while (localLong == null);
    String str = getETagFromResult(paramOperation);
    try
    {
      this._cachingManager.updateCache(getCacheKey(paramOperation.getRequest()), Base64.encodeObject(paramOperation.getResult()), localLong, str, paramOperation.getRequest().getUriForRequest());
      return;
    }
    catch (IOException paramOperation)
    {
      throw new CachingException(paramOperation);
    }
    catch (URISyntaxException paramOperation)
    {
      throw new CachingException(paramOperation);
    }
  }
  
  public String getETagFromCache(Operation paramOperation)
  {
    try
    {
      paramOperation = getCacheEntry(paramOperation.getRequest());
      if (paramOperation != null)
      {
        paramOperation = paramOperation.getEtag();
        return paramOperation;
      }
    }
    catch (Exception paramOperation)
    {
      Logger.e(Area.COMM.value() | Area.STORAGE.value(), paramOperation, "ResultCachingManager: getETag() failed", new Object[0]);
    }
    return null;
  }
  
  public Result getRequestResult(Operation paramOperation)
  {
    try
    {
      CacheEntry localCacheEntry = getCacheEntry(paramOperation.getRequest());
      if ((localCacheEntry != null) && (!localCacheEntry.hasTtlExpired()))
      {
        Logger.v(Area.COMM.value() | Area.STORAGE.value(), "ResultCachingManager: getRequestResult() Found a cached result for Request %1$d", new Object[] { Integer.valueOf(paramOperation.getRequest().getId()) });
        paramOperation = (Result)Base64.decodeToObject(localCacheEntry.getValue());
        return paramOperation;
      }
    }
    catch (Exception paramOperation)
    {
      Logger.e(Area.COMM.value() | Area.STORAGE.value(), paramOperation, "ResultCachingManager: getRequestResult() failed", new Object[0]);
    }
    return null;
  }
  
  protected void refreshCacheEntry(Operation paramOperation)
  {
    if (paramOperation == null) {
      throw new IllegalArgumentException("'operation' can not be NULL");
    }
    if (paramOperation.getRequest() == null) {
      throw new IllegalStateException("Operation must have a Request");
    }
    if (paramOperation.getResult() == null) {
      throw new IllegalStateException("refreshCacheEntry() can only be called for operations with a result");
    }
    if (paramOperation.getResult().getResponseCode() != 304) {
      throw new IllegalStateException("refreshCacheEntry() can only be called for operations with a 304 result");
    }
    CacheEntry localCacheEntry = getCacheEntry(paramOperation.getRequest());
    if (localCacheEntry == null) {
      throw new IllegalStateException(String.format(Locale.US, "Request %1$d received a 304, but no stale cache entry was found", new Object[] { Integer.valueOf(hashCode()) }));
    }
    try
    {
      Long localLong = getTtlFromResult(paramOperation);
      this._cachingManager.updateCache(localCacheEntry.getName(), localCacheEntry.getValue(), localLong, localCacheEntry.getEtag(), localCacheEntry.getUri());
      Logger.i(Area.COMM.value() | Area.STORAGE.value(), "ResultCachingManager: refreshCacheEntry() Cache entry updated: %1$s", new Object[] { localCacheEntry.toString() });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramOperation.setResult((Result)Base64.decodeToObject(localCacheEntry.getValue()));
          if (paramOperation.getResult() != null) {
            break;
          }
          throw new IllegalStateException(String.format(Locale.US, "Found a NULL result in cache for operation %1$d", new Object[] { Integer.valueOf(paramOperation.getId()) }));
        }
        catch (IOException paramOperation)
        {
          throw new CachingException(paramOperation);
        }
        catch (ClassNotFoundException paramOperation)
        {
          throw new CachingException(paramOperation);
        }
        localException = localException;
        Logger.e(Area.COMM.value() | Area.STORAGE.value(), localException, "ResultCachingManager: refreshCacheEntry() Updating the cache entry TTL failed", new Object[0]);
      }
    }
    Logger.v(Area.COMM.value() | Area.STORAGE.value(), "Operation %1$d received a 304 and has been updated to a cached result with %2$d", new Object[] { Integer.valueOf(paramOperation.getId()), Integer.valueOf(paramOperation.getResult().getResponseCode()) });
  }
  
  public void trimLruEntries()
  {
    this._cachingManager.trimLruEntries(300);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/ResultCachingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */