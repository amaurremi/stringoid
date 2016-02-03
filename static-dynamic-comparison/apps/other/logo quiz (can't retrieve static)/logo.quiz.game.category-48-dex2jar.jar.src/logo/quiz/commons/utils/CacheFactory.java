package logo.quiz.commons.utils;

import android.content.Context;
import com.bluebird.mobile.tools.cache.BitmapCache;
import com.bluebird.mobile.tools.cache.BitmapCacheFactory;
import com.bluebird.mobile.tools.cache.MemoryCacheSizeStartegy;

public class CacheFactory
{
  public static final String APP_IMAGE_CACHE = "APP_IMAGE_CACHE";
  public static final String LOGO_IMAGE_CACHE = "LOGO_IMAGE_CACHE";
  
  public static BitmapCache getAppCache(Context paramContext)
  {
    return BitmapCacheFactory.getInstance(paramContext, "APP_IMAGE_CACHE", new MemoryCacheSizeStartegy(0.1F));
  }
  
  public static BitmapCache getLogoCache(Context paramContext)
  {
    return BitmapCacheFactory.getInstance(paramContext, "LOGO_IMAGE_CACHE", new MemoryCacheSizeStartegy(0.1F));
  }
  
  public static BitmapCache getLogoIconImageCache(Context paramContext)
  {
    return BitmapCacheFactory.getInstance(paramContext, "LOGO_IMAGE_CACHE", new MemoryCacheSizeStartegy(0.3F));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/CacheFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */