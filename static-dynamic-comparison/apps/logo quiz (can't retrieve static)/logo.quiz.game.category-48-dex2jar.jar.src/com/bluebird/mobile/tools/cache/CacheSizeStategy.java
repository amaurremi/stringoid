package com.bluebird.mobile.tools.cache;

import android.graphics.Bitmap;

public abstract interface CacheSizeStategy
{
  public abstract int cacheSize();
  
  public abstract int sizeOf(Bitmap paramBitmap);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/cache/CacheSizeStategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */