package com.squareup.picasso;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

class Stats
{
  private static final int BITMAP_DECODE_FINISHED = 2;
  private static final int BITMAP_TRANSFORMED_FINISHED = 3;
  private static final int CACHE_HIT = 0;
  private static final int CACHE_MISS = 1;
  private static final int DOWNLOAD_FINISHED = 4;
  private static final String STATS_THREAD_NAME = "Picasso-Stats";
  long averageDownloadSize;
  long averageOriginalBitmapSize;
  long averageTransformedBitmapSize;
  final Cache cache;
  long cacheHits;
  long cacheMisses;
  int downloadCount;
  final Handler handler;
  int originalBitmapCount;
  final HandlerThread statsThread;
  long totalDownloadSize;
  long totalOriginalBitmapSize;
  long totalTransformedBitmapSize;
  int transformedBitmapCount;
  
  Stats(Cache paramCache)
  {
    this.cache = paramCache;
    this.statsThread = new HandlerThread("Picasso-Stats", 10);
    this.statsThread.start();
    this.handler = new StatsHandler(this.statsThread.getLooper(), this);
  }
  
  private static long getAverage(int paramInt, long paramLong)
  {
    return paramLong / paramInt;
  }
  
  private void processBitmap(Bitmap paramBitmap, int paramInt)
  {
    int i = Utils.getBitmapBytes(paramBitmap);
    this.handler.sendMessage(this.handler.obtainMessage(paramInt, i, 0));
  }
  
  StatsSnapshot createSnapshot()
  {
    return new StatsSnapshot(this.cache.maxSize(), this.cache.size(), this.cacheHits, this.cacheMisses, this.totalDownloadSize, this.totalOriginalBitmapSize, this.totalTransformedBitmapSize, this.averageDownloadSize, this.averageOriginalBitmapSize, this.averageTransformedBitmapSize, this.downloadCount, this.originalBitmapCount, this.transformedBitmapCount, System.currentTimeMillis());
  }
  
  void dispatchBitmapDecoded(Bitmap paramBitmap)
  {
    processBitmap(paramBitmap, 2);
  }
  
  void dispatchBitmapTransformed(Bitmap paramBitmap)
  {
    processBitmap(paramBitmap, 3);
  }
  
  void dispatchCacheHit()
  {
    this.handler.sendEmptyMessage(0);
  }
  
  void dispatchCacheMiss()
  {
    this.handler.sendEmptyMessage(1);
  }
  
  void dispatchDownloadFinished(long paramLong)
  {
    this.handler.sendMessage(this.handler.obtainMessage(4, Long.valueOf(paramLong)));
  }
  
  void performBitmapDecoded(long paramLong)
  {
    this.originalBitmapCount += 1;
    this.totalOriginalBitmapSize += paramLong;
    this.averageOriginalBitmapSize = getAverage(this.originalBitmapCount, this.totalOriginalBitmapSize);
  }
  
  void performBitmapTransformed(long paramLong)
  {
    this.transformedBitmapCount += 1;
    this.totalTransformedBitmapSize += paramLong;
    this.averageTransformedBitmapSize = getAverage(this.originalBitmapCount, this.totalTransformedBitmapSize);
  }
  
  void performCacheHit()
  {
    this.cacheHits += 1L;
  }
  
  void performCacheMiss()
  {
    this.cacheMisses += 1L;
  }
  
  void performDownloadFinished(Long paramLong)
  {
    this.downloadCount += 1;
    this.totalDownloadSize += paramLong.longValue();
    this.averageDownloadSize = getAverage(this.downloadCount, this.totalDownloadSize);
  }
  
  void shutdown()
  {
    this.statsThread.quit();
  }
  
  private static class StatsHandler
    extends Handler
  {
    private final Stats stats;
    
    public StatsHandler(Looper paramLooper, Stats paramStats)
    {
      super();
      this.stats = paramStats;
    }
    
    public void handleMessage(final Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        Picasso.HANDLER.post(new Runnable()
        {
          public void run()
          {
            throw new AssertionError("Unhandled stats message." + paramMessage.what);
          }
        });
        return;
      case 0: 
        this.stats.performCacheHit();
        return;
      case 1: 
        this.stats.performCacheMiss();
        return;
      case 2: 
        this.stats.performBitmapDecoded(paramMessage.arg1);
        return;
      case 3: 
        this.stats.performBitmapTransformed(paramMessage.arg1);
        return;
      }
      this.stats.performDownloadFinished((Long)paramMessage.obj);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/picasso/Stats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */