package com.mopub.nativeads;

import com.mopub.common.util.AsyncTasks;
import com.mopub.nativeads.util.Utils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

class ImageDownloadTaskManager
  extends ImageTaskManager
{
  private final Map<HttpUriRequest, DownloadTask> mDownloadTasks;
  
  ImageDownloadTaskManager(List<String> paramList, ImageTaskManager.ImageTaskManagerListener paramImageTaskManagerListener)
    throws IllegalArgumentException
  {
    super(paramList, paramImageTaskManagerListener);
    paramImageTaskManagerListener = new ImageDownloadTaskListener(null);
    this.mDownloadTasks = new HashMap(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      HttpGet localHttpGet = new HttpGet((String)paramList.next());
      this.mDownloadTasks.put(localHttpGet, new DownloadTask(paramImageTaskManagerListener));
    }
  }
  
  void execute()
  {
    if (this.mDownloadTasks.isEmpty()) {
      this.mImageTaskManagerListener.onSuccess(this.mImages);
    }
    Iterator localIterator = this.mDownloadTasks.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      HttpUriRequest localHttpUriRequest = (HttpUriRequest)localEntry.getKey();
      AsyncTasks.safeExecuteOnExecutor((DownloadTask)localEntry.getValue(), new HttpUriRequest[] { localHttpUriRequest });
    }
  }
  
  void failAllTasks()
  {
    if (this.mFailed.compareAndSet(false, true))
    {
      Iterator localIterator = this.mDownloadTasks.values().iterator();
      while (localIterator.hasNext()) {
        ((DownloadTask)localIterator.next()).cancel(true);
      }
      this.mImageTaskManagerListener.onFail();
    }
  }
  
  private class ImageDownloadTaskListener
    implements DownloadTask.DownloadTaskListener
  {
    private ImageDownloadTaskListener() {}
    
    public void onComplete(String paramString, DownloadResponse paramDownloadResponse)
    {
      if ((paramDownloadResponse == null) || (paramDownloadResponse.getStatusCode() != 200))
      {
        Utils.MoPubLog("Failed to download image: " + paramString);
        ImageDownloadTaskManager.this.failAllTasks();
      }
      do
      {
        return;
        paramDownloadResponse = HttpResponses.asBitmap(paramDownloadResponse);
        if (paramDownloadResponse == null)
        {
          Utils.MoPubLog("Failed to decode bitmap from response for image: " + paramString);
          ImageDownloadTaskManager.this.failAllTasks();
          return;
        }
        Utils.MoPubLog("Successfully downloaded image: " + paramString);
        ImageDownloadTaskManager.this.mImages.put(paramString, paramDownloadResponse);
      } while (ImageDownloadTaskManager.this.mCompletedCount.incrementAndGet() != ImageDownloadTaskManager.this.mSize);
      ImageDownloadTaskManager.this.mImageTaskManagerListener.onSuccess(ImageDownloadTaskManager.this.mImages);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/nativeads/ImageDownloadTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */