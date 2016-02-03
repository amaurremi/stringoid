package com.millennialmedia.android;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class AdCacheThreadPool
{
  private static AdCacheThreadPool sharedThreadPool;
  private ThreadPoolExecutor executor;
  private PriorityBlockingQueue queue;
  
  private AdCacheThreadPool()
  {
    TimeUnit localTimeUnit = TimeUnit.SECONDS;
    PriorityBlockingQueue localPriorityBlockingQueue = new PriorityBlockingQueue(32);
    this.queue = localPriorityBlockingQueue;
    this.executor = new ThreadPoolExecutor(1, 2, 30L, localTimeUnit, localPriorityBlockingQueue);
  }
  
  static AdCacheThreadPool sharedThreadPool()
  {
    try
    {
      if (sharedThreadPool == null) {
        sharedThreadPool = new AdCacheThreadPool();
      }
      AdCacheThreadPool localAdCacheThreadPool = sharedThreadPool;
      return localAdCacheThreadPool;
    }
    finally {}
  }
  
  void startDownloadTask(Context paramContext, String paramString, CachedAd paramCachedAd, AdCache.AdCacheTaskListener paramAdCacheTaskListener)
  {
    if ((paramContext != null) && (paramCachedAd != null)) {}
    try
    {
      paramString = new AdCacheTask(paramContext, paramString, paramCachedAd, paramAdCacheTaskListener);
      if ((!this.queue.contains(paramString)) && (!paramCachedAd.isOnDisk(paramContext))) {
        this.executor.execute(paramString);
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private class AdCacheTask
    implements Runnable, Comparable<AdCacheTask>
  {
    private CachedAd ad;
    private String adName;
    private WeakReference<Context> contextRef;
    private WeakReference<AdCache.AdCacheTaskListener> listenerRef;
    
    AdCacheTask(Context paramContext, String paramString, CachedAd paramCachedAd, AdCache.AdCacheTaskListener paramAdCacheTaskListener)
    {
      this.contextRef = new WeakReference(paramContext.getApplicationContext());
      this.adName = paramString;
      this.ad = paramCachedAd;
      if (paramAdCacheTaskListener != null) {
        this.listenerRef = new WeakReference(paramAdCacheTaskListener);
      }
    }
    
    public int compareTo(AdCacheTask paramAdCacheTask)
    {
      return this.ad.downloadPriority - paramAdCacheTask.ad.downloadPriority;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      return this.ad.equals(((AdCacheTask)paramObject).ad);
    }
    
    public void run()
    {
      Object localObject1 = null;
      Object localObject2 = null;
      HandShake.sharedHandShake((Context)this.contextRef.get()).lockAdTypeDownload(this.adName);
      boolean bool = this.ad.download((Context)this.contextRef.get());
      HandShake.sharedHandShake((Context)this.contextRef.get()).unlockAdTypeDownload(this.adName);
      Object localObject3;
      if (!bool)
      {
        localObject3 = AdCache.getIncompleteDownload((Context)this.contextRef.get(), this.adName);
        if ((localObject3 != null) && (this.ad.id.equals(localObject3)))
        {
          this.ad.delete((Context)this.contextRef.get());
          AdCache.setIncompleteDownload((Context)this.contextRef.get(), this.adName, null);
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (this.listenerRef != null) {
          localObject1 = (AdCache.AdCacheTaskListener)this.listenerRef.get();
        }
        if (localObject1 != null) {
          ((AdCache.AdCacheTaskListener)localObject1).downloadCompleted(this.ad, bool);
        }
        return;
        localObject3 = (Context)this.contextRef.get();
        String str = this.adName;
        if (!this.ad.downloadAllOrNothing) {
          localObject1 = this.ad.id;
        }
        AdCache.setIncompleteDownload((Context)localObject3, str, (String)localObject1);
        continue;
        AdCache.setIncompleteDownload((Context)this.contextRef.get(), this.adName, null);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/millennialmedia/android/AdCacheThreadPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */