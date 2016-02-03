package com.getjar.sdk.rewards;

import android.content.Context;
import com.getjar.sdk.data.cache.BasicCache;
import com.getjar.sdk.data.cache.CacheEntry;

public class GooglePlayLaunchCachingManager
{
  private static final int _CacheLRUCap = 10;
  private static final String _CacheNamespace = "google.play.launch.cache";
  private static final long _CacheTTL = 1209600000L;
  private final BasicCache _cachingManager;
  
  public GooglePlayLaunchCachingManager(Context paramContext)
  {
    this._cachingManager = new BasicCache(paramContext, "google.play.launch.cache", 5, false);
  }
  
  public GooglePlayLaunchReason get(String paramString)
  {
    Object localObject = null;
    CacheEntry localCacheEntry = this._cachingManager.getCacheEntry(paramString);
    paramString = (String)localObject;
    if (localCacheEntry != null) {
      paramString = GooglePlayLaunchReason.valueOf(localCacheEntry.getValue());
    }
    return paramString;
  }
  
  public void remove(String paramString)
  {
    this._cachingManager.removeCacheEntry(paramString);
  }
  
  public void update(String paramString, GooglePlayLaunchReason paramGooglePlayLaunchReason)
  {
    this._cachingManager.updateCache(paramString, paramGooglePlayLaunchReason.name(), Long.valueOf(1209600000L), null, null);
    this._cachingManager.trimLruEntries(10);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/rewards/GooglePlayLaunchCachingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */