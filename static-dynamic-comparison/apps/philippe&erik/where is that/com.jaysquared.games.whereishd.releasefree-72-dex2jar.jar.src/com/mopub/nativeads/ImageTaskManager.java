package com.mopub.nativeads;

import android.graphics.Bitmap;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class ImageTaskManager
{
  protected final AtomicInteger mCompletedCount;
  protected final AtomicBoolean mFailed;
  protected final ImageTaskManagerListener mImageTaskManagerListener;
  protected final Map<String, Bitmap> mImages;
  protected final int mSize;
  
  ImageTaskManager(List<String> paramList, ImageTaskManagerListener paramImageTaskManagerListener)
    throws IllegalArgumentException
  {
    if (paramList == null) {
      throw new IllegalArgumentException("Urls list cannot be null");
    }
    if (paramList.contains(null)) {
      throw new IllegalArgumentException("Urls list cannot contain null");
    }
    if (paramImageTaskManagerListener == null) {
      throw new IllegalArgumentException("ImageTaskManagerListener cannot be null");
    }
    this.mSize = paramList.size();
    this.mImageTaskManagerListener = paramImageTaskManagerListener;
    this.mCompletedCount = new AtomicInteger(0);
    this.mFailed = new AtomicBoolean(false);
    this.mImages = Collections.synchronizedMap(new HashMap(this.mSize));
  }
  
  abstract void execute();
  
  static abstract interface ImageTaskManagerListener
  {
    public abstract void onFail();
    
    public abstract void onSuccess(Map<String, Bitmap> paramMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/nativeads/ImageTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */