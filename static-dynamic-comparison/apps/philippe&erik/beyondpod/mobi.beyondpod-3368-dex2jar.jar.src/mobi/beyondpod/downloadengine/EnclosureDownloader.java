package mobi.beyondpod.downloadengine;

import java.io.File;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.rss.EnclosureDownloadHistory;
import mobi.beyondpod.rsscore.rss.entities.RssEnclosure;

class EnclosureDownloader
  implements DownloadAgent.DownloadListener
{
  private static final String TAG = EnclosureDownloader.class.getSimpleName();
  private static DownloadAgent m_Agent;
  EnclosureDownloadListener _EnclosureDownloadListener;
  long _LastProgressNotificationTime = 0L;
  private RssEnclosure m_CurrentEnclosure;
  private Track m_CurrentTrack;
  
  public void DownloadTrack(Track paramTrack, RssEnclosure paramRssEnclosure)
  {
    this.m_CurrentTrack = paramTrack;
    this.m_CurrentEnclosure = paramRssEnclosure;
    try
    {
      m_Agent = new DownloadAgent(CoreHelper.SafeCreateUri(this.m_CurrentTrack.getUrl()), new File(this.m_CurrentTrack.TrackPath()), this.m_CurrentTrack.getParentFeed().Credentials());
      m_Agent.setDownloadListenter(this);
      m_Agent.SetUpdateType(1);
      m_Agent.SetAllowMobileDataUse(UpdateAndDownloadManager.AllowMobiuleDataUseForDownloads());
      m_Agent.StartDownload();
      return;
    }
    catch (Exception paramTrack)
    {
      CoreHelper.LogException(TAG, String.format("Unable to start the download of Url:%s!", new Object[] { this.m_CurrentTrack.getUrl() }), paramTrack);
      OnDownloadError(null, paramTrack);
    }
  }
  
  public boolean IsDownloading()
  {
    return (m_Agent != null) && (m_Agent.IsDownloading());
  }
  
  public void OnDownloadCompleted(DownloadAgent paramDownloadAgent, boolean paramBoolean)
  {
    paramDownloadAgent = this.m_CurrentTrack;
    if (this.m_CurrentTrack.IsFullyDownloaded()) {}
    for (int i = 3;; i = 4)
    {
      paramDownloadAgent.setDownloadStatus(i);
      FeedRepository.NotifyTrackChanged(this.m_CurrentTrack);
      FeedRepository.NotifyFeedChanged(this.m_CurrentTrack.getParentFeed());
      if (this.m_CurrentTrack.IsFullyDownloaded()) {
        EnclosureDownloadHistory.AddEnclosure(this.m_CurrentEnclosure, true);
      }
      if (this._EnclosureDownloadListener != null) {
        this._EnclosureDownloadListener.OnEnclosureDownloadCompleted(this.m_CurrentTrack);
      }
      return;
    }
  }
  
  public void OnDownloadError(DownloadAgent paramDownloadAgent, Exception paramException)
  {
    this.m_CurrentTrack.setDownloadStatus(5);
    this.m_CurrentTrack.getParentFeed().DownloadFailed = true;
    FeedRepository.NotifyTrackChanged(this.m_CurrentTrack);
    FeedRepository.NotifyFeedChanged(this.m_CurrentTrack.getParentFeed());
    if (this._EnclosureDownloadListener != null) {
      this._EnclosureDownloadListener.OnEnclosureDownloadError(this.m_CurrentTrack, paramException);
    }
  }
  
  public void OnDownloadProgress(DownloadAgent paramDownloadAgent, long paramLong1, long paramLong2)
  {
    this.m_CurrentTrack.setDownloadSize(paramLong2);
    this.m_CurrentTrack.setDownloadedPortion(paramLong1);
    this.m_CurrentTrack.setDownloadStatus(2);
    paramLong1 = System.currentTimeMillis();
    if (paramLong1 - this._LastProgressNotificationTime > 3000L)
    {
      FeedRepository.NotifyTrackChanged(this.m_CurrentTrack);
      FeedRepository.NotifyFeedChanged(this.m_CurrentTrack.getParentFeed());
      this._LastProgressNotificationTime = paramLong1;
      if (this._EnclosureDownloadListener != null) {
        this._EnclosureDownloadListener.OnEnclosureDownloadProgress(this.m_CurrentTrack);
      }
    }
  }
  
  public void OnDownloadStarted(DownloadAgent paramDownloadAgent)
  {
    this.m_CurrentTrack.setDownloadStatus(1);
    this.m_CurrentTrack.getParentFeed().DownloadFailed = false;
    FeedRepository.NotifyTrackChanged(this.m_CurrentTrack);
    FeedRepository.NotifyFeedChanged(this.m_CurrentTrack.getParentFeed());
    if (this._EnclosureDownloadListener != null) {
      this._EnclosureDownloadListener.OnEnclosureDownloadStarted(this.m_CurrentTrack);
    }
  }
  
  public void OnDownloadTerminated(DownloadAgent paramDownloadAgent)
  {
    this.m_CurrentTrack.setDownloadStatus(4);
    FeedRepository.NotifyTrackChanged(this.m_CurrentTrack);
    FeedRepository.NotifyFeedChanged(this.m_CurrentTrack.getParentFeed());
    if (this._EnclosureDownloadListener != null) {
      this._EnclosureDownloadListener.OnEnclosureDownloadTerminated(this.m_CurrentTrack);
    }
  }
  
  public DownloadStatistics Statistics()
  {
    if (m_Agent != null) {
      return m_Agent.Statistics();
    }
    return null;
  }
  
  public void Stop()
  {
    if (m_Agent != null) {
      m_Agent.Stop();
    }
  }
  
  public Track Track()
  {
    return this.m_CurrentTrack;
  }
  
  public void setEnclosureDownloadListener(EnclosureDownloadListener paramEnclosureDownloadListener)
  {
    this._EnclosureDownloadListener = paramEnclosureDownloadListener;
  }
  
  public static abstract interface EnclosureDownloadListener
  {
    public abstract void OnEnclosureDownloadCompleted(Track paramTrack);
    
    public abstract void OnEnclosureDownloadError(Track paramTrack, Exception paramException);
    
    public abstract void OnEnclosureDownloadProgress(Track paramTrack);
    
    public abstract void OnEnclosureDownloadStarted(Track paramTrack);
    
    public abstract void OnEnclosureDownloadTerminated(Track paramTrack);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/downloadengine/EnclosureDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */