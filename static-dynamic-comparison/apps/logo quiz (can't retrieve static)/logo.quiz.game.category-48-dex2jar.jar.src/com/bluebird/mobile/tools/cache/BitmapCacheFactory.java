package com.bluebird.mobile.tools.cache;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public class BitmapCacheFactory
{
  private static Map<String, BitmapCache> caches = new HashMap();
  
  public static BitmapCache getInstance(Context paramContext, String paramString, CacheSizeStategy paramCacheSizeStategy)
  {
    BitmapCache localBitmapCache2 = (BitmapCache)caches.get(paramString);
    BitmapCache localBitmapCache1 = localBitmapCache2;
    if (localBitmapCache2 == null)
    {
      localBitmapCache1 = new BitmapCache(paramContext.getApplicationContext(), paramCacheSizeStategy);
      caches.put(paramString, localBitmapCache1);
    }
    return localBitmapCache1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/cache/BitmapCacheFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */