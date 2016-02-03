package com.mopub.nativeads;

import android.graphics.Bitmap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class ImageDiskTaskManager
  extends ImageTaskManager
{
  private final List<String> mUrls;
  
  ImageDiskTaskManager(List<String> paramList, ImageTaskManager.ImageTaskManagerListener paramImageTaskManagerListener)
    throws IllegalArgumentException
  {
    super(paramList, paramImageTaskManagerListener);
    this.mUrls = paramList;
  }
  
  void execute()
  {
    if (this.mUrls.isEmpty()) {
      this.mImageTaskManagerListener.onSuccess(this.mImages);
    }
    ImageDiskTaskListener localImageDiskTaskListener = new ImageDiskTaskListener(null);
    Iterator localIterator = this.mUrls.iterator();
    while (localIterator.hasNext()) {
      CacheService.getFromDiskCacheAsync((String)localIterator.next(), localImageDiskTaskListener);
    }
  }
  
  void failAllTasks()
  {
    if (this.mFailed.compareAndSet(false, true)) {
      this.mImageTaskManagerListener.onFail();
    }
  }
  
  private class ImageDiskTaskListener
    implements CacheService.DiskLruCacheGetListener
  {
    private ImageDiskTaskListener() {}
    
    public void onComplete(String paramString, byte[] paramArrayOfByte)
    {
      if (paramString == null) {
        ImageDiskTaskManager.this.failAllTasks();
      }
      do
      {
        return;
        Bitmap localBitmap = null;
        if (paramArrayOfByte != null) {
          localBitmap = ImageService.byteArrayToBitmap(paramArrayOfByte);
        }
        ImageDiskTaskManager.this.mImages.put(paramString, localBitmap);
      } while (ImageDiskTaskManager.this.mCompletedCount.incrementAndGet() != ImageDiskTaskManager.this.mSize);
      ImageDiskTaskManager.this.mImageTaskManagerListener.onSuccess(ImageDiskTaskManager.this.mImages);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/nativeads/ImageDiskTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */