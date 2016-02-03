package com.millennialmedia.android;

import android.content.Context;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

class PreCacheWorker
  extends Thread
  implements AdCache.AdCacheTaskListener
{
  private static boolean busy;
  private Context appContext;
  private String[] cachedVideos;
  
  private PreCacheWorker(String[] paramArrayOfString, Context paramContext)
  {
    this.cachedVideos = paramArrayOfString;
    this.appContext = paramContext.getApplicationContext();
  }
  
  static void preCacheVideos(String[] paramArrayOfString, Context paramContext)
  {
    try
    {
      if (!busy)
      {
        busy = true;
        new PreCacheWorker(paramArrayOfString, paramContext).start();
      }
      return;
    }
    finally
    {
      paramArrayOfString = finally;
      throw paramArrayOfString;
    }
  }
  
  public void downloadCompleted(CachedAd paramCachedAd, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      AdCache.save(this.appContext, paramCachedAd);
      notify();
      return;
    }
    finally {}
  }
  
  public void run()
  {
    int i;
    label123:
    label246:
    label297:
    for (;;)
    {
      try
      {
        String[] arrayOfString = this.cachedVideos;
        int j = arrayOfString.length;
        i = 0;
        if (i >= j) {
          break label246;
        }
        Object localObject3 = arrayOfString[i];
        if (localException.getContentLength() != 0L) {
          break label123;
        }
      }
      finally
      {
        try
        {
          localObject3 = new HttpGetRequest().get((String)localObject3);
          if (localObject3 == null)
          {
            MMAdViewSDK.Log.d("Pre cache worker: HTTP response is null");
          }
          else
          {
            localObject3 = ((HttpResponse)localObject3).getEntity();
            if (localObject3 == null) {
              MMAdViewSDK.Log.d("Pre cache worker: Null HTTP entity");
            }
          }
        }
        catch (Exception localException)
        {
          MMAdViewSDK.Log.d("Pre cache worker HTTP error: %s", new Object[] { localException.getMessage() });
        }
        localObject1 = finally;
      }
      MMAdViewSDK.Log.d("Pre cache worker: Millennial ad return failed. Zero content length returned.");
      break label297;
      Header localHeader = localException.getContentType();
      if ((localHeader != null) && (localHeader.getValue() != null))
      {
        boolean bool = localHeader.getValue().equalsIgnoreCase("application/json");
        if (bool) {
          try
          {
            VideoAd localVideoAd = new VideoAd(HttpGetRequest.convertStreamToString(localException.getContent()));
            if (localVideoAd != null)
            {
              bool = localVideoAd.isValid();
              if (bool) {
                try
                {
                  localVideoAd.downloadPriority = 1;
                  AdCache.startDownloadTask(this.appContext, null, localVideoAd, this);
                  wait();
                }
                catch (InterruptedException localInterruptedException)
                {
                  localInterruptedException.printStackTrace();
                  MMAdViewSDK.Log.e("Pre cache worker interrupted: %s", new Object[] { localInterruptedException.getMessage() });
                }
              }
            }
            i += 1;
          }
          catch (IllegalStateException localIllegalStateException)
          {
            try
            {
              busy = false;
              return;
            }
            finally {}
            localIllegalStateException = localIllegalStateException;
            localIllegalStateException.printStackTrace();
            MMAdViewSDK.Log.d("Pre cache worker: Millennial ad return failed. Invalid response data.");
          }
          catch (IOException localIOException)
          {
            localIOException.printStackTrace();
            MMAdViewSDK.Log.d("Pre cache worker: Millennial ad return failed. Invalid response data.");
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/millennialmedia/android/PreCacheWorker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */