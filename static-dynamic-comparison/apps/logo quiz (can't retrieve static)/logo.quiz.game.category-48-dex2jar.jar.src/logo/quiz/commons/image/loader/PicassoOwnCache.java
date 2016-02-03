package logo.quiz.commons.image.loader;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import com.squareup.picasso.Cache;
import com.squareup.picasso.LruCache;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Picasso.Builder;

public class PicassoOwnCache
{
  static Cache cache = null;
  static Picasso singleton = null;
  
  static int calculateMemoryCacheSize(Context paramContext)
  {
    ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
    if ((paramContext.getApplicationInfo().flags & 0x100000) != 0) {}
    for (int i = 1;; i = 0)
    {
      int k = localActivityManager.getMemoryClass();
      int j = k;
      if (i != 0)
      {
        j = k;
        if (Build.VERSION.SDK_INT >= 11) {
          j = ActivityManagerHoneycomb.getLargeMemoryClass(localActivityManager);
        }
      }
      return 1048576 * j / 7;
    }
  }
  
  public static Picasso with(int paramInt, Context paramContext)
  {
    int i;
    if (singleton == null)
    {
      i = calculateMemoryCacheSize(paramContext);
      if (paramInt > i) {
        break label51;
      }
    }
    for (;;)
    {
      cache = new LruCache(paramInt);
      singleton = new Picasso.Builder(paramContext).memoryCache(cache).build();
      return singleton;
      label51:
      paramInt = i;
    }
  }
  
  public static Picasso with(Context paramContext)
  {
    if (singleton == null)
    {
      cache = new LruCache(calculateMemoryCacheSize(paramContext));
      singleton = new Picasso.Builder(paramContext).memoryCache(cache).build();
    }
    return singleton;
  }
  
  @TargetApi(11)
  private static class ActivityManagerHoneycomb
  {
    static int getLargeMemoryClass(ActivityManager paramActivityManager)
    {
      return paramActivityManager.getLargeMemoryClass();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/image/loader/PicassoOwnCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */