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
  
  /* Error */
  boolean startDownloadTask(Context paramContext, String paramString, CachedAd paramCachedAd, AdCache.AdCacheTaskListener paramAdCacheTaskListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +56 -> 59
    //   6: aload_3
    //   7: ifnull +52 -> 59
    //   10: new 6	com/millennialmedia/android/AdCacheThreadPool$AdCacheTask
    //   13: dup
    //   14: aload_0
    //   15: aload_1
    //   16: aload_2
    //   17: aload_3
    //   18: aload 4
    //   20: invokespecial 49	com/millennialmedia/android/AdCacheThreadPool$AdCacheTask:<init>	(Lcom/millennialmedia/android/AdCacheThreadPool;Landroid/content/Context;Ljava/lang/String;Lcom/millennialmedia/android/CachedAd;Lcom/millennialmedia/android/AdCache$AdCacheTaskListener;)V
    //   23: astore_2
    //   24: aload_0
    //   25: getfield 30	com/millennialmedia/android/AdCacheThreadPool:queue	Ljava/util/concurrent/PriorityBlockingQueue;
    //   28: aload_2
    //   29: invokevirtual 53	java/util/concurrent/PriorityBlockingQueue:contains	(Ljava/lang/Object;)Z
    //   32: ifne +27 -> 59
    //   35: aload_3
    //   36: aload_1
    //   37: invokevirtual 59	com/millennialmedia/android/CachedAd:isOnDisk	(Landroid/content/Context;)Z
    //   40: ifne +19 -> 59
    //   43: aload_0
    //   44: getfield 39	com/millennialmedia/android/AdCacheThreadPool:executor	Ljava/util/concurrent/ThreadPoolExecutor;
    //   47: aload_2
    //   48: invokevirtual 63	java/util/concurrent/ThreadPoolExecutor:execute	(Ljava/lang/Runnable;)V
    //   51: iconst_1
    //   52: istore 5
    //   54: aload_0
    //   55: monitorexit
    //   56: iload 5
    //   58: ireturn
    //   59: iconst_0
    //   60: istore 5
    //   62: goto -8 -> 54
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	AdCacheThreadPool
    //   0	70	1	paramContext	Context
    //   0	70	2	paramString	String
    //   0	70	3	paramCachedAd	CachedAd
    //   0	70	4	paramAdCacheTaskListener	AdCache.AdCacheTaskListener
    //   52	9	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   10	51	65	finally
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
      if (!(paramObject instanceof AdCacheTask)) {
        return false;
      }
      paramObject = (AdCacheTask)paramObject;
      return this.ad.equals(((AdCacheTask)paramObject).ad);
    }
    
    public void run()
    {
      String str1 = null;
      AdCache.AdCacheTaskListener localAdCacheTaskListener = null;
      if (this.listenerRef != null) {
        localAdCacheTaskListener = (AdCache.AdCacheTaskListener)this.listenerRef.get();
      }
      if (localAdCacheTaskListener != null) {
        localAdCacheTaskListener.downloadStart(this.ad);
      }
      HandShake.sharedHandShake((Context)this.contextRef.get()).lockAdTypeDownload(this.adName);
      boolean bool = this.ad.download((Context)this.contextRef.get());
      HandShake.sharedHandShake((Context)this.contextRef.get()).unlockAdTypeDownload(this.adName);
      Object localObject;
      if (!bool)
      {
        localObject = AdCache.getIncompleteDownload((Context)this.contextRef.get(), this.adName);
        if ((localObject != null) && (this.ad.getId().equals(localObject)))
        {
          this.ad.delete((Context)this.contextRef.get());
          AdCache.setIncompleteDownload((Context)this.contextRef.get(), this.adName, null);
        }
      }
      for (;;)
      {
        if (localAdCacheTaskListener != null) {
          localAdCacheTaskListener.downloadCompleted(this.ad, bool);
        }
        return;
        localObject = (Context)this.contextRef.get();
        String str2 = this.adName;
        if (!this.ad.downloadAllOrNothing) {
          str1 = this.ad.getId();
        }
        AdCache.setIncompleteDownload((Context)localObject, str2, str1);
        continue;
        AdCache.setIncompleteDownload((Context)this.contextRef.get(), this.adName, null);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/millennialmedia/android/AdCacheThreadPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */