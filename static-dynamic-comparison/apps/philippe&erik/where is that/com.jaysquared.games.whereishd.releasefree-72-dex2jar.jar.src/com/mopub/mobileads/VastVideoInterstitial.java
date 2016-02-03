package com.mopub.mobileads;

import android.net.Uri;
import android.util.Log;
import com.mopub.mobileads.factories.VastManagerFactory;
import com.mopub.mobileads.factories.VastVideoDownloadTaskFactory;
import com.mopub.mobileads.util.vast.VastManager;
import com.mopub.mobileads.util.vast.VastManager.VastManagerListener;
import java.util.ArrayList;
import java.util.Map;

class VastVideoInterstitial
  extends ResponseBodyInterstitial
  implements VastManager.VastManagerListener, VastVideoDownloadTask.OnDownloadCompleteListener
{
  public static final int CACHE_MAX_SIZE = 100000000;
  public static final String VIDEO_CACHE_DIRECTORY_NAME = "mopub_vast_video_cache";
  private String mClickThroughUrl;
  private ArrayList<String> mClickTrackers;
  private CustomEventInterstitial.CustomEventInterstitialListener mCustomEventInterstitialListener;
  private ArrayList<String> mImpressionTrackers;
  private VastManager mVastManager;
  private String mVastResponse;
  private VastVideoDownloadTask mVastVideoDownloadTask;
  private DiskLruCache mVideoCache;
  private ArrayList<String> mVideoCompleteTrackers;
  private ArrayList<String> mVideoFirstQuartileTrackers;
  private ArrayList<String> mVideoMidpointTrackers;
  private ArrayList<String> mVideoStartTrackers;
  private ArrayList<String> mVideoThirdQuartileTrackers;
  private String mVideoUrl;
  
  protected void extractExtras(Map<String, String> paramMap)
  {
    this.mVastResponse = Uri.decode((String)paramMap.get("Html-Response-Body"));
  }
  
  @Deprecated
  String getVastResponse()
  {
    return this.mVastResponse;
  }
  
  @Deprecated
  DiskLruCache getVideoCache()
  {
    return this.mVideoCache;
  }
  
  public void onComplete(VastManager paramVastManager)
  {
    this.mVideoUrl = paramVastManager.getMediaFileUrl();
    if (this.mVideoCache.getUri(this.mVideoUrl) != null)
    {
      onDownloadSuccess();
      return;
    }
    this.mVastVideoDownloadTask = VastVideoDownloadTaskFactory.create(this, this.mVideoCache);
    this.mVastVideoDownloadTask.execute(new String[] { this.mVideoUrl });
  }
  
  public void onDownloadFailed()
  {
    this.mCustomEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.VIDEO_DOWNLOAD_ERROR);
  }
  
  public void onDownloadSuccess()
  {
    this.mVideoStartTrackers = new ArrayList(this.mVastManager.getVideoStartTrackers());
    this.mVideoFirstQuartileTrackers = new ArrayList(this.mVastManager.getVideoFirstQuartileTrackers());
    this.mVideoMidpointTrackers = new ArrayList(this.mVastManager.getVideoMidpointTrackers());
    this.mVideoThirdQuartileTrackers = new ArrayList(this.mVastManager.getVideoThirdQuartileTrackers());
    this.mVideoCompleteTrackers = new ArrayList(this.mVastManager.getVideoCompleteTrackers());
    this.mImpressionTrackers = new ArrayList(this.mVastManager.getImpressionTrackers());
    this.mClickThroughUrl = this.mVastManager.getClickThroughUrl();
    this.mClickTrackers = new ArrayList(this.mVastManager.getClickTrackers());
    this.mCustomEventInterstitialListener.onInterstitialLoaded();
  }
  
  protected void onInvalidate()
  {
    if (this.mVastManager != null) {
      this.mVastManager.cancel();
    }
    super.onInvalidate();
  }
  
  protected void preRenderHtml(CustomEventInterstitial.CustomEventInterstitialListener paramCustomEventInterstitialListener)
  {
    this.mCustomEventInterstitialListener = paramCustomEventInterstitialListener;
    if (this.mVideoCache == null) {}
    try
    {
      this.mVideoCache = new DiskLruCache(this.mContext, "mopub_vast_video_cache", 100000000);
      this.mVastManager = VastManagerFactory.create();
      this.mVastManager.processVast(this.mVastResponse, this);
      return;
    }
    catch (Exception paramCustomEventInterstitialListener)
    {
      Log.d("MoPub", "Unable to create VAST video cache.");
      this.mCustomEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.VIDEO_CACHE_ERROR);
    }
  }
  
  @Deprecated
  void setVastManager(VastManager paramVastManager)
  {
    this.mVastManager = paramVastManager;
  }
  
  protected void showInterstitial()
  {
    MraidVideoPlayerActivity.startVast(this.mContext, this.mVideoUrl, this.mVideoStartTrackers, this.mVideoFirstQuartileTrackers, this.mVideoMidpointTrackers, this.mVideoThirdQuartileTrackers, this.mVideoCompleteTrackers, this.mImpressionTrackers, this.mClickThroughUrl, this.mClickTrackers);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/VastVideoInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */