package mobi.beyondpod.downloadengine;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.helpers.TimeSpan;

public class ProcessStatistics
{
  public List<String> IgnoredEnclosures = new ArrayList();
  public Exception LastException;
  public List<String> NewEnclosures = new ArrayList();
  public boolean PodcastDownloadForced = false;
  public boolean PodcastDownloadSkipped_DeviceIsNotPluggedIn = false;
  public boolean PodcastDownloadSkipped_WiFiNotDetected = false;
  public Feed ProcessedFeed = null;
  public List<String> StreamableEnclosures = new ArrayList();
  
  private String getPodcastDownloadActionAsText(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "N/A";
    case 0: 
      return "Download Manually";
    case 1: 
      return "Download Latest";
    case 2: 
      return "Stream Latest";
    case 3: 
      return "Ignore All Episodes";
    case 4: 
      return "Download In Order";
    }
    return "Stream In Order";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.ProcessedFeed == null) {
      return "<div style='red'>Processed Feed is Empty!</div>";
    }
    if ((this.ProcessedFeed != null) && (this.LastException != null)) {
      localStringBuilder.append(String.format("<div style='red'>Failed to process feed:%s. Reason: %s</div>", new Object[] { this.ProcessedFeed.getName(), this.LastException.getMessage() }));
    }
    String str1;
    Iterator localIterator;
    if (this.NewEnclosures.size() > 0)
    {
      str1 = "DarkGreen";
      localStringBuilder.append(String.format("<div style='color:%s'><b>• %s</b><br>&nbsp;&nbsp;%s, New episodes: <b>%d</b>, Download Max: <b>%d</b>, Keep Max: <b>%d</b>, Delete if more than: <b>%d</b> days old. ", new Object[] { str1, this.ProcessedFeed.getName(), getPodcastDownloadActionAsText(this.ProcessedFeed.getPodcastDownloadAction()), Integer.valueOf(this.NewEnclosures.size()), Integer.valueOf(this.ProcessedFeed.getMaxNumberPodcastToDownload()), Integer.valueOf(this.ProcessedFeed.getKeepAtMostPodcasts()), Integer.valueOf((int)this.ProcessedFeed.getMaximumPodcastAge().getTotalDays()) }));
      if (this.NewEnclosures.size() > 0)
      {
        localStringBuilder.append("<ul style='margin-top:5px; margin-bottom:5px'>");
        localIterator = this.NewEnclosures.iterator();
      }
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        localStringBuilder.append("</ul>");
        localStringBuilder.append("</div>");
        localStringBuilder.append("<hr style='color:Gainsboro; height: 0px;' />");
        return localStringBuilder.toString();
        str1 = "DodgerBlue";
        break;
      }
      String str2 = (String)localIterator.next();
      str1 = "queued for download";
      if (this.IgnoredEnclosures.contains(str2)) {
        str1 = "marked as 'Already Downloaded'";
      }
      if (this.StreamableEnclosures.contains(str2)) {
        str1 = "added as a 'Streamable' track";
      }
      localStringBuilder.append(String.format("<li>%s (%s)</li>", new Object[] { str2, str1 }));
    }
  }
  
  public static class ProcessedFeedList
    extends ArrayList<ProcessStatistics>
  {
    public Exception LastException;
    public Date ProcessTime;
    
    public void ClearStatistics()
    {
      clear();
      this.ProcessTime = null;
      this.LastException = null;
    }
    
    public List<ProcessStatistics> GetFeedsWithNewContent()
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return localArrayList;
        }
        ProcessStatistics localProcessStatistics = (ProcessStatistics)localIterator.next();
        if (localProcessStatistics.NewEnclosures.size() > 0) {
          localArrayList.add(localProcessStatistics);
        }
      }
    }
    
    public List<String> GetUrlsOfNewEpisodes()
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return localArrayList;
        }
        ProcessStatistics localProcessStatistics = (ProcessStatistics)localIterator.next();
        if (localProcessStatistics.NewEnclosures.size() > 0) {
          localArrayList.addAll(localProcessStatistics.NewEnclosures);
        }
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator;
      if (size() > 0)
      {
        localIterator = iterator();
        if (localIterator.hasNext()) {}
      }
      for (;;)
      {
        return localStringBuilder.toString();
        localStringBuilder.append(((ProcessStatistics)localIterator.next()).toString());
        break;
        localStringBuilder.append("There were no feeds to check for new podcasts");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/downloadengine/ProcessStatistics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */