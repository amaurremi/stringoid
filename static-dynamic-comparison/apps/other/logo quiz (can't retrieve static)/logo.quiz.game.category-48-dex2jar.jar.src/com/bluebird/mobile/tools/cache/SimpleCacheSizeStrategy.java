package com.bluebird.mobile.tools.cache;

import android.graphics.Bitmap;

public class SimpleCacheSizeStrategy
  implements CacheSizeStategy
{
  private int maxElementsInCache;
  
  public SimpleCacheSizeStrategy(int paramInt)
  {
    this.maxElementsInCache = paramInt;
  }
  
  public int cacheSize()
  {
    return this.maxElementsInCache;
  }
  
  public int sizeOf(Bitmap paramBitmap)
  {
    return 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/cache/SimpleCacheSizeStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */