package mobi.beyondpod.downloadengine;

import java.io.FileNotFoundException;
import java.net.URI;
import java.util.Date;
import mobi.beyondpod.aggregators.AggregatorLoginHelper.AuthenticationException;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.CoreHelper.IssuficientStorageSpaceException;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.ui.core.FeedImageCache;

public class DownloadStatistics
{
  public boolean CompletedNormaly;
  public String ContentDisposition;
  public String ContentEncoding;
  public Date ContentLastModifyDate;
  public boolean DownloadSkipped;
  public long DownloadTime;
  public Long DownloadedSize;
  public Date EventDate;
  public URI FinalDownloadUrl;
  public Exception LastException;
  public Feed OwnerFeed;
  public Track OwnerTrack;
  public String ResponseCookie;
  public Date SkipDate;
  public Long SkipSize;
  public long StartPosition;
  public boolean Terminated;
  public long TimeToFirstByte;
  public Long TotalSize;
  public String Url;
  
  public String DownloadSpeed()
  {
    if ((StringUtils.IsNullOrEmpty(this.ContentEncoding)) && (this.DownloadTime > 0L) && (this.DownloadedSize.longValue() > 0L)) {
      return Math.round(this.DownloadedSize.longValue() / 1024.0D) / this.DownloadTime + "kb/s.";
    }
    return "<N/A>";
  }
  
  public String GetErrorDescription()
  {
    if (this.LastException != null)
    {
      if ((this.LastException instanceof CoreHelper.IssuficientStorageSpaceException)) {
        return this.LastException.getMessage();
      }
      return CoreHelper.ExtractExceptionMessages(this.LastException);
    }
    if (InidicatesSDCardCorruption()) {
      return "Unable to write to the Storage Card! (Try removing and reinserting the storage card)";
    }
    if (InidicatesReaderLoginFailure()) {
      return "Google Reader Login failed or expired! (Try to clear your login and log in again)";
    }
    return "Unknown Error";
  }
  
  public boolean HasErrors()
  {
    return (this.LastException != null) || (InidicatesSDCardCorruption()) || (InidicatesReaderLoginFailure());
  }
  
  public boolean InidicatesReaderLoginFailure()
  {
    if ((this.LastException != null) && (this.FinalDownloadUrl != null) && ((this.LastException instanceof AggregatorLoginHelper.AuthenticationException)) && (this.FinalDownloadUrl.getHost().toLowerCase().contains("feedly.com"))) {}
    while (((this.ResponseCookie != null) && (this.ResponseCookie.startsWith("GoogleAccounts"))) || ((this.FinalDownloadUrl != null) && (this.FinalDownloadUrl.getPath() != null) && (this.FinalDownloadUrl.getHost() != null) && (this.FinalDownloadUrl.getHost().toLowerCase().contains("google.com")) && ((this.FinalDownloadUrl.getPath().toLowerCase().endsWith("servicelogin")) || (this.FinalDownloadUrl.getPath().toLowerCase().endsWith("clientlogin"))))) {
      return true;
    }
    return false;
  }
  
  public boolean InidicatesSDCardCorruption()
  {
    return (this.LastException != null) && ((this.LastException instanceof FileNotFoundException));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str2;
    String str3;
    label49:
    label98:
    label189:
    long l1;
    label225:
    long l2;
    if ((InidicatesSDCardCorruption()) || (InidicatesReaderLoginFailure()))
    {
      str2 = "Failed";
      str1 = "Firebrick";
      if (this.OwnerTrack != null) {
        break label701;
      }
      if (this.OwnerFeed != null) {
        break label689;
      }
      str3 = "Unknown";
      localStringBuilder.append(String.format("<div style='color: %s'><b>%s</b> - %s", new Object[] { str1, str2, str3 }));
      localStringBuilder.append("<ul style='margin-top:5px; margin-bottom:5px'>");
      if (this.OwnerFeed != null) {
        break label713;
      }
      str1 = "Unknown";
      localStringBuilder.append(String.format("<li>Feed Url: %s</li>", new Object[] { str1 }));
      if ((this.OwnerTrack == null) && (this.OwnerFeed != null) && (this.OwnerFeed.getType() == 5)) {
        localStringBuilder.append(String.format("<li>Feed is synced with Feedly! (will get <b>%d</b> posts)</li>", new Object[] { Integer.valueOf(this.OwnerFeed.getMaxNumGReaderItemsToGet()) }));
      }
      if (this.OwnerTrack != null)
      {
        if (this.Url != null) {
          break label725;
        }
        str1 = "Unknown";
        localStringBuilder.append(String.format("<li>Episode Url: %s</li>", new Object[] { str1 }));
      }
      if (!this.DownloadSkipped)
      {
        if (this.DownloadedSize != null) {
          break label734;
        }
        l1 = 0L;
        long l3 = this.StartPosition;
        str1 = CoreHelper.GetTimeDurationAsString(this.DownloadTime + this.TimeToFirstByte);
        if (this.DownloadedSize != null) {
          break label745;
        }
        l2 = 0L;
        label254:
        localStringBuilder.append(String.format("<li>Downloaded: <b>%s</b>, starting at position: <b>%s</b> took: <b>%s</b> at <b>%s</b></li>", new Object[] { Long.valueOf(l1), Long.valueOf(l3), str1, CoreHelper.GetDownloadSpeedAsString(l2, this.DownloadTime + this.TimeToFirstByte) }));
      }
      if (this.TotalSize != null) {
        break label756;
      }
      l1 = 0L;
      label314:
      if (this.SkipSize != null) {
        break label767;
      }
      str1 = "Not Set";
      label325:
      localStringBuilder.append(String.format("<li>Content Size: <b>%s</b>. Cache Size: <b>%s</b></li>", new Object[] { Long.valueOf(l1), str1 }));
      if (this.ContentLastModifyDate == null) {
        break label779;
      }
      str1 = this.ContentLastModifyDate.toString();
      label368:
      if (this.SkipDate == null) {
        break label786;
      }
      str2 = this.SkipDate.toString();
      label384:
      localStringBuilder.append(String.format("<li>Content Date: <b>%s</b>. Cache Date: <b>%s</b></li>", new Object[] { str1, str2 }));
      if (!StringUtils.IsNullOrEmpty(this.OwnerFeed.getFeedImageUrl())) {
        break label793;
      }
      str1 = "No";
      label426:
      if (!FeedImageCache.HasCachedImageFor(this.OwnerFeed)) {
        break label800;
      }
      str2 = "Yes";
      label440:
      localStringBuilder.append(String.format("<li>Feed has Image: <b>%s</b>, image downloaded: <b>%s</b></li>", new Object[] { str1, str2 }));
      if (!this.DownloadSkipped) {
        if (!StringUtils.IsNullOrEmpty(this.ContentEncoding)) {
          break label807;
        }
      }
    }
    label689:
    label701:
    label713:
    label725:
    label734:
    label745:
    label756:
    label767:
    label779:
    label786:
    label793:
    label800:
    label807:
    for (String str1 = "Not Compressed";; str1 = this.ContentEncoding + " compressed")
    {
      localStringBuilder.append(String.format("<li>Content Compression: <b>%s</b></li>", new Object[] { str1 }));
      if (this.LastException != null) {
        localStringBuilder.append(String.format("<li>Reason to fail: <b>%s</b></li>", new Object[] { GetErrorDescription() }));
      }
      if ((InidicatesSDCardCorruption()) || (InidicatesReaderLoginFailure())) {
        localStringBuilder.append("<li>" + GetErrorDescription() + "</li>");
      }
      localStringBuilder.append("</ul></div>");
      localStringBuilder.append(String.format("<hr style='color:%s; height: 0px;' />", new Object[] { "Gainsboro" }));
      return localStringBuilder.toString();
      if (this.CompletedNormaly)
      {
        str2 = "Completed";
        str1 = "DarkGreen";
        break;
      }
      if (this.Terminated)
      {
        str2 = "Canceled";
        str1 = "Goldenrod";
        break;
      }
      if (this.DownloadSkipped)
      {
        str2 = "Unchanged";
        str1 = "DodgerBlue";
        break;
      }
      str2 = "Failed";
      str1 = "Firebrick";
      break;
      str3 = this.OwnerFeed.getName();
      break label49;
      str3 = this.OwnerTrack.DisplayName();
      break label49;
      str1 = this.OwnerFeed.getFeedUrl();
      break label98;
      str1 = this.Url;
      break label189;
      l1 = this.DownloadedSize.longValue();
      break label225;
      l2 = this.DownloadedSize.longValue();
      break label254;
      l1 = this.TotalSize.longValue();
      break label314;
      str1 = this.SkipSize.toString();
      break label325;
      str1 = "Unknown";
      break label368;
      str2 = "Not Set";
      break label384;
      str1 = "Yes";
      break label426;
      str2 = "No";
      break label440;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/downloadengine/DownloadStatistics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */