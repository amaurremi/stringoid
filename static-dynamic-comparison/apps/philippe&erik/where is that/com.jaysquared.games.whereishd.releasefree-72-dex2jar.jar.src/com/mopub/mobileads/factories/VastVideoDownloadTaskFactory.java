package com.mopub.mobileads.factories;

import com.mopub.mobileads.DiskLruCache;
import com.mopub.mobileads.VastVideoDownloadTask;
import com.mopub.mobileads.VastVideoDownloadTask.OnDownloadCompleteListener;

public class VastVideoDownloadTaskFactory
{
  private static VastVideoDownloadTaskFactory instance = new VastVideoDownloadTaskFactory();
  
  public static VastVideoDownloadTask create(VastVideoDownloadTask.OnDownloadCompleteListener paramOnDownloadCompleteListener, DiskLruCache paramDiskLruCache)
  {
    return instance.internalCreate(paramOnDownloadCompleteListener, paramDiskLruCache);
  }
  
  @Deprecated
  public static void setInstance(VastVideoDownloadTaskFactory paramVastVideoDownloadTaskFactory)
  {
    instance = paramVastVideoDownloadTaskFactory;
  }
  
  protected VastVideoDownloadTask internalCreate(VastVideoDownloadTask.OnDownloadCompleteListener paramOnDownloadCompleteListener, DiskLruCache paramDiskLruCache)
  {
    return new VastVideoDownloadTask(paramOnDownloadCompleteListener, paramDiskLruCache);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/factories/VastVideoDownloadTaskFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */