package mobi.beyondpod.downloadengine;

import java.io.File;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.rss.entities.RssFeed;
import mobi.beyondpod.rsscore.rss.parsers.FeedParseData;
import mobi.beyondpod.rsscore.rss.parsers.FeedParsingEngine;
import mobi.beyondpod.ui.core.FeedImageCache;

class FeedImageDownloader
{
  private static final String TAG = FeedImageDownloader.class.getSimpleName();
  private File _FeedDownloadPath = new File(Configuration.RssCachePath(), "ImageDownloaderTemp.xml");
  FeedImageDownloadListener _FeedImageDownloadListener;
  private DownloadAgent.DownloadListener _FeedUpdateListener = new DownloadAgent.DownloadListener()
  {
    public void OnDownloadCompleted(DownloadAgent paramAnonymousDownloadAgent, boolean paramAnonymousBoolean)
    {
      paramAnonymousDownloadAgent = null;
      try
      {
        FeedParseData localFeedParseData = new FeedParseData(1);
        localFeedParseData.RssFeed.FeedID = FeedImageDownloader.this.m_Feed.ID();
        FeedParsingEngine.ParseFeedFile(FeedImageDownloader.this._FeedDownloadPath, localFeedParseData);
        if (localFeedParseData.HasParseFailed()) {
          CoreHelper.WriteTraceEntry(FeedImageDownloader.TAG, String.format("Failed to parse: %s (%s). Reason: %s", new Object[] { FeedImageDownloader.this.m_Feed.getName(), FeedImageDownloader.this.m_Feed.getFeedUrl(), localFeedParseData.ParseException.getMessage() }));
        }
        while ((paramAnonymousDownloadAgent != null) && (!StringUtils.IsNullOrEmpty(paramAnonymousDownloadAgent.getFeedImageLink())))
        {
          FeedImageDownloader.this.m_Feed.setFeedImageUrl(paramAnonymousDownloadAgent.getFeedImageLink());
          FeedImageDownloader.this.DownloadFeedImage();
          return;
          if (FeedParseData.IsRssFeedType(localFeedParseData.ParsedFeedType)) {
            paramAnonymousDownloadAgent = localFeedParseData.RssFeed;
          }
        }
      }
      catch (Exception paramAnonymousDownloadAgent)
      {
        for (;;)
        {
          paramAnonymousDownloadAgent = null;
        }
        FeedImageDownloader.this.PublishImageDownloadCompletedEvent();
      }
    }
    
    public void OnDownloadError(DownloadAgent paramAnonymousDownloadAgent, Exception paramAnonymousException)
    {
      CoreHelper.WriteTraceEntry(FeedImageDownloader.TAG, String.format("Unable to update feed for image download for: %s! Reason: %s", new Object[] { FeedImageDownloader.this.m_Feed.getFeedUrl(), paramAnonymousException.getMessage() }));
      FeedImageDownloader.this.PublishImageDownloadCompletedEvent();
    }
    
    public void OnDownloadProgress(DownloadAgent paramAnonymousDownloadAgent, long paramAnonymousLong1, long paramAnonymousLong2) {}
    
    public void OnDownloadStarted(DownloadAgent paramAnonymousDownloadAgent) {}
    
    public void OnDownloadTerminated(DownloadAgent paramAnonymousDownloadAgent) {}
  };
  private DownloadAgent.DownloadListener _ImageDownloadListener = new DownloadAgent.DownloadListener()
  {
    public void OnDownloadCompleted(DownloadAgent paramAnonymousDownloadAgent, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousDownloadAgent.Destination().exists())
      {
        FeedImageCache.FormatTempImageForFeed(FeedImageDownloader.this.m_Feed);
        CoreHelper.WriteTraceEntry(FeedImageDownloader.TAG, "Image download complete for: " + FeedImageDownloader.this.m_Feed.getFeedImageUrl());
      }
      FeedImageDownloader.this.PublishImageDownloadCompletedEvent();
    }
    
    public void OnDownloadError(DownloadAgent paramAnonymousDownloadAgent, Exception paramAnonymousException)
    {
      CoreHelper.WriteTraceEntry(FeedImageDownloader.TAG, String.format("Unable to download image for: %s! Reason: %s", new Object[] { FeedImageDownloader.this.m_Feed.getFeedImageUrl(), paramAnonymousException.getMessage() }));
      FeedImageDownloader.this.PublishImageDownloadCompletedEvent();
    }
    
    public void OnDownloadProgress(DownloadAgent paramAnonymousDownloadAgent, long paramAnonymousLong1, long paramAnonymousLong2) {}
    
    public void OnDownloadStarted(DownloadAgent paramAnonymousDownloadAgent) {}
    
    public void OnDownloadTerminated(DownloadAgent paramAnonymousDownloadAgent) {}
  };
  private Feed m_Feed;
  private DownloadAgent m_ImageDownloadAgent;
  private DownloadAgent m_UpdateDownloadAgent;
  
  private void DownloadFeedImage()
  {
    try
    {
      this.m_ImageDownloadAgent = new DownloadAgent(CoreHelper.SafeCreateUri(this.m_Feed.getFeedImageUrl()), FeedImageCache.GetTempFeedImagePath(this.m_Feed), this.m_Feed.Credentials());
      this.m_ImageDownloadAgent.setDownloadListenter(this._ImageDownloadListener);
      this.m_ImageDownloadAgent.SetAllowResume(false);
      CoreHelper.WriteTraceEntry(TAG, "Downloading image for: " + this.m_Feed.getFeedImageUrl());
      this.m_ImageDownloadAgent.StartDownload();
      return;
    }
    catch (Exception localException)
    {
      this._ImageDownloadListener.OnDownloadError(null, localException);
    }
  }
  
  private void PublishImageDownloadCompletedEvent()
  {
    if (this._FeedImageDownloadListener != null) {
      this._FeedImageDownloadListener.OnImageDownloadCompleted(this.m_Feed);
    }
    if (this._FeedDownloadPath.exists()) {
      this._FeedDownloadPath.delete();
    }
  }
  
  public void DownloadImage(Feed paramFeed)
  {
    this.m_Feed = paramFeed;
    this.m_UpdateDownloadAgent = null;
    if (paramFeed.IsGReaderFeed()) {
      try
      {
        this.m_UpdateDownloadAgent = new DownloadAgent(paramFeed.getFeedUri(), this._FeedDownloadPath, this.m_Feed.Credentials());
        this.m_UpdateDownloadAgent.setDownloadListenter(this._FeedUpdateListener);
        this.m_UpdateDownloadAgent.SetAllowResume(false);
        CoreHelper.WriteTraceEntry(TAG, "Updating Feed to get feed image for: " + this.m_Feed.getName());
        this.m_UpdateDownloadAgent.StartDownload();
        return;
      }
      catch (Exception paramFeed)
      {
        CoreHelper.WriteLogEntry(TAG, String.format("Unable to start feed update for image download! Url: %s Reason: %s", new Object[] { this.m_Feed.getFeedUrl(), paramFeed.getMessage() }));
        PublishImageDownloadCompletedEvent();
        return;
      }
    }
    DownloadFeedImage();
  }
  
  public void Stop()
  {
    if (this.m_UpdateDownloadAgent != null) {
      this.m_UpdateDownloadAgent.Stop();
    }
    if (this.m_ImageDownloadAgent != null) {
      this.m_ImageDownloadAgent.Stop();
    }
  }
  
  public void setFeedUpdateListener(FeedImageDownloadListener paramFeedImageDownloadListener)
  {
    this._FeedImageDownloadListener = paramFeedImageDownloadListener;
  }
  
  public static abstract interface FeedImageDownloadListener
  {
    public abstract void OnImageDownloadCompleted(Feed paramFeed);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/downloadengine/FeedImageDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */