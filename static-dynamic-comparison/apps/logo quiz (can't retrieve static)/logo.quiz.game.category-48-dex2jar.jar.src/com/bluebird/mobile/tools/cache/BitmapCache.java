package com.bluebird.mobile.tools.cache;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import com.bluebird.mobile.tools.commonutils.ResourceUtils;

public class BitmapCache
{
  private Context context;
  private LruCache<String, Bitmap> lettersCache;
  
  BitmapCache(Context paramContext, final CacheSizeStategy paramCacheSizeStategy)
  {
    this.context = paramContext.getApplicationContext();
    if (paramCacheSizeStategy != null) {
      this.lettersCache = new LruCache(paramCacheSizeStategy.cacheSize())
      {
        protected int sizeOf(String paramAnonymousString, Bitmap paramAnonymousBitmap)
        {
          return paramCacheSizeStategy.sizeOf(paramAnonymousBitmap);
        }
      };
    }
  }
  
  private void addBitmapToMemoryCache(String paramString, Bitmap paramBitmap)
  {
    if ((getBitmapFromMemCache(paramString) == null) && (paramString != null)) {
      this.lettersCache.put(paramString, paramBitmap);
    }
  }
  
  private Bitmap getBitmapFromMemCache(String paramString)
  {
    return (Bitmap)this.lettersCache.get(paramString);
  }
  
  private Bitmap loadBitmap(String paramString)
  {
    int i = ResourceUtils.getResourceId(paramString, "drawable", this.context);
    return BitmapFactory.decodeResource(this.context.getResources(), i);
  }
  
  public Bitmap getBitmap(int paramInt)
  {
    return getBitmap(this.context.getResources().getResourceEntryName(paramInt));
  }
  
  public Bitmap getBitmap(String paramString)
  {
    Bitmap localBitmap2 = getBitmapFromMemCache(paramString);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      localBitmap1 = loadBitmap(paramString);
      addBitmapToMemoryCache(paramString, localBitmap1);
    }
    return localBitmap1;
  }
  
  public Drawable getDrawable(String paramString)
  {
    try
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(this.context.getResources(), getBitmap(paramString));
      return localBitmapDrawable;
    }
    catch (NullPointerException localNullPointerException)
    {
      throw new NullPointerException("Error while creating bitmap. Resource name: " + paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/cache/BitmapCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */