package com.bluebird.mobile.tools.cache;

import android.graphics.Bitmap;
import android.os.Build.VERSION;

public class MemoryCacheSizeStartegy
  implements CacheSizeStategy
{
  private float memorySizeForCache;
  
  public MemoryCacheSizeStartegy(float paramFloat)
  {
    this.memorySizeForCache = paramFloat;
  }
  
  public int cacheSize()
  {
    return (int)((int)(Runtime.getRuntime().maxMemory() / 1024L) * this.memorySizeForCache);
  }
  
  public int sizeOf(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT < 12) {
      return paramBitmap.getRowBytes() * paramBitmap.getHeight() / 1024;
    }
    return paramBitmap.getByteCount() / 1024;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/cache/MemoryCacheSizeStartegy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */