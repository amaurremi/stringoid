package mobi.beyondpod.rsscore.rss;

import android.net.Uri;
import java.io.File;
import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.Date;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.TimeSpan;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.rss.entities.RssEnclosure;
import mobi.beyondpod.rsscore.rss.entities.RssFeed;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItemSorter;
import mobi.beyondpod.rsscore.rss.parsers.FeedParseData;
import mobi.beyondpod.rsscore.rss.parsers.FeedParsingEngine;

public class RssFeedCache
{
  private static final String TAG = RssFeedCache.class.getSimpleName();
  private static final File _RSSCahcheFolder = new File(Configuration.RssCachePath());
  
  static
  {
    if (!_RSSCahcheFolder.exists()) {
      _RSSCahcheFolder.mkdirs();
    }
  }
  
  public static boolean CopyTempToPrimaryForFeed(Feed paramFeed)
  {
    File localFile = GetFeedTempPath(paramFeed.getFeedUri());
    paramFeed = GetFeedDownloadPath(paramFeed.getFeedUri());
    boolean bool2 = true;
    if (!localFile.exists())
    {
      CoreHelper.WriteLogEntry(TAG, String.format("Unable to move %s to %s! Source File does not exist!", new Object[] { localFile, paramFeed }));
      return true;
    }
    if (paramFeed.exists()) {
      if (localFile.length() == paramFeed.length()) {
        break label134;
      }
    }
    label134:
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!paramFeed.delete())
      {
        CoreHelper.WriteLogEntry(TAG, String.format("Unable to delete %s!", new Object[] { paramFeed }));
        bool2 = bool1;
      }
      if (!localFile.renameTo(paramFeed)) {
        CoreHelper.WriteLogEntry(TAG, String.format("Unable to move %s to %s!", new Object[] { localFile, paramFeed }));
      }
      return bool2;
    }
  }
  
  public static Track CreateStreamableTrackFromEnclosure(Feed paramFeed, RssEnclosure paramRssEnclosure, boolean paramBoolean)
  {
    paramFeed = FeedRepository.FindOrCreateLocalTrack(paramFeed, paramRssEnclosure.Url, paramRssEnclosure.PubDate(), paramRssEnclosure.ParentItemID(), paramRssEnclosure.Type, paramRssEnclosure.Parent.Title.toString(), paramRssEnclosure.Description(), paramRssEnclosure.Parent.Link, paramBoolean);
    if (!paramRssEnclosure.IsEnclosureInHistory()) {
      EnclosureDownloadHistory.AddEnclosure(paramRssEnclosure, paramBoolean);
    }
    if (!paramFeed.Exists())
    {
      paramFeed.setUseParentImage();
      return paramFeed;
    }
    paramFeed.EnsureTrackHasContentTypeAndImage();
    return paramFeed;
  }
  
  public static int DeleteCacheForAllFeeds()
  {
    File[] arrayOfFile = _RSSCahcheFolder.listFiles();
    int j = 0;
    int m = arrayOfFile.length;
    int i = 0;
    if (i >= m) {
      return j;
    }
    File localFile = arrayOfFile[i];
    int k = j;
    if (localFile.isFile()) {
      if (!localFile.delete()) {
        break label62;
      }
    }
    label62:
    for (k = 0;; k = 1)
    {
      k = j + k;
      i += 1;
      j = k;
      break;
    }
  }
  
  public static void DeleteFeedCacheFor(Feed paramFeed)
  {
    if (paramFeed == null) {
      return;
    }
    DeletePrimaryFeedCacheFor(paramFeed);
    DeleteTempFeedCacheFor(paramFeed);
  }
  
  private static void DeleteFile(File paramFile)
  {
    if ((paramFile.exists()) && (!paramFile.delete())) {
      CoreHelper.WriteLogEntry(TAG, String.format("Unable to delete %s!", new Object[] { paramFile }));
    }
  }
  
  public static void DeletePrimaryFeedCacheFor(Feed paramFeed)
  {
    if (!paramFeed.HasUri()) {
      return;
    }
    try
    {
      DeleteFile(GetFeedDownloadPath(paramFeed.getFeedUri()));
      return;
    }
    catch (Exception paramFeed)
    {
      CoreHelper.LogException(TAG, "Unable to delete primary feed cache!", paramFeed);
    }
  }
  
  public static void DeleteTempFeedCacheFor(Feed paramFeed)
  {
    if (!paramFeed.HasUri()) {
      return;
    }
    try
    {
      DeleteFile(GetFeedTempPath(paramFeed.getFeedUri()));
      return;
    }
    catch (Exception paramFeed)
    {
      CoreHelper.LogException(TAG, "Unable to delete temporary feed cache!", paramFeed);
    }
  }
  
  public static Long GetCacheSizeOnDisk()
  {
    if (_RSSCahcheFolder != null) {
      return Long.valueOf(_RSSCahcheFolder.length());
    }
    return Long.valueOf(0L);
  }
  
  public static double GetCachedAgeFor(Feed paramFeed)
  {
    if ((paramFeed == null) || (!paramFeed.HasUrl())) {}
    do
    {
      return -1.0D;
      paramFeed = GetFeedDownloadPath(paramFeed.getFeedUri());
    } while (!paramFeed.exists());
    return new TimeSpan(new Date().getTime() - paramFeed.lastModified()).getTotalHours();
  }
  
  public static Date GetCachedFileDate(Uri paramUri)
  {
    Object localObject = null;
    try
    {
      File localFile = GetFeedDownloadPath(paramUri);
      paramUri = (Uri)localObject;
      if (localFile.exists()) {
        paramUri = new Date(localFile.lastModified());
      }
      return paramUri;
    }
    catch (Exception paramUri)
    {
      CoreHelper.LogException(TAG, "Unable to get cached file date!", paramUri);
    }
    return null;
  }
  
  public static long GetCachedFileSize(Uri paramUri)
  {
    long l = -1L;
    try
    {
      paramUri = GetFeedDownloadPath(paramUri);
      if (paramUri.exists()) {
        l = paramUri.length();
      }
      return l;
    }
    catch (Exception paramUri)
    {
      CoreHelper.LogException(TAG, "Unable to get cached file size!", paramUri);
    }
    return -1L;
  }
  
  private static String GetFeedCacheFileName(Uri paramUri, boolean paramBoolean)
  {
    if (paramUri == null) {
      throw new InvalidParameterException("GetFeedCacheFileName - called with null Url!");
    }
    String str;
    int i;
    if (paramUri.getHost() != null)
    {
      str = paramUri.getHost().replace('.', '_');
      i = paramUri.hashCode();
      if (!paramBoolean) {
        break label77;
      }
    }
    label77:
    for (paramUri = "temp";; paramUri = "")
    {
      return String.format("%s_%X%s.xml", new Object[] { str, Integer.valueOf(i), paramUri });
      str = "bpgeneric";
      break;
    }
  }
  
  public static File GetFeedDownloadPath(Uri paramUri)
  {
    if (paramUri == null) {
      throw new InvalidParameterException("GetFeedCacheFileName - called with null Url!");
    }
    if ("file".equals(paramUri.getScheme())) {
      return new File(paramUri.getPath());
    }
    return new File(_RSSCahcheFolder, GetFeedCacheFileName(paramUri, false));
  }
  
  public static File GetFeedTempPath(Uri paramUri)
  {
    return new File(_RSSCahcheFolder, GetFeedCacheFileName(paramUri, true));
  }
  
  public static boolean HasCachedFileFor(Feed paramFeed)
  {
    if ((paramFeed == null) || (!paramFeed.HasUrl())) {
      return false;
    }
    return GetFeedDownloadPath(paramFeed.getFeedUri()).exists();
  }
  
  public static void LoadFromCache(Feed paramFeed, FeedParseData paramFeedParseData)
  {
    if ((paramFeed == null) || (!paramFeed.HasUri())) {
      throw new InvalidParameterException("The URL of the feed was not provided or is invalid!");
    }
    paramFeed.EnsureFeedHasDownloadPath();
    Object localObject;
    RssFeed localRssFeed;
    if (paramFeedParseData.LoadTempFeed)
    {
      localObject = GetFeedTempPath(paramFeed.getFeedUri());
      paramFeedParseData.EnclosureDownloadPath = paramFeed.getFeedPath();
      paramFeedParseData.ForceUniqueEnclosureNames = paramFeed.getForceUniqueTrackNames();
      paramFeedParseData.RssFeed.PreferredEnclosureIndex = paramFeed.getPreferredEnclosureIndex();
      localRssFeed = paramFeedParseData.RssFeed;
      if (paramFeed.getPodcastDownloadAction() != 3) {
        break label238;
      }
    }
    label238:
    for (boolean bool = true;; bool = false)
    {
      localRssFeed.IgnoreEnclosures = bool;
      paramFeedParseData.RssFeed.ItemIDGenerationAlgorithm = paramFeed.getItemFingerprintAlgorithm();
      paramFeedParseData.RssFeed.FeedID = paramFeed.ID();
      paramFeedParseData.CachedFileSize = ((File)localObject).length();
      FeedParsingEngine.ParseFeedFile((File)localObject, paramFeedParseData);
      if (paramFeedParseData.HasParseFailed()) {
        CoreHelper.WriteTraceEntry(TAG, String.format("Failed to parse: %s (%s). Reason: %s", new Object[] { paramFeed.getName(), paramFeed.getFeedUrl(), paramFeedParseData.ParseException.getMessage() }));
      }
      if (FeedParseData.IsRssFeedType(paramFeedParseData.ParsedFeedType))
      {
        localObject = paramFeedParseData.RssFeed;
        ((RssFeed)localObject).FeedType = paramFeedParseData.ParsedFeedType;
        if ((localObject != null) && (paramFeed.getForceFeedItemSort() != -1)) {
          Collections.sort(((RssFeed)localObject).Items, new RssFeedItemSorter(paramFeed.getForceFeedItemSort()));
        }
      }
      return;
      localObject = GetFeedDownloadPath(paramFeed.getFeedUri());
      break;
    }
  }
  
  public static void SyncFeedReadStatus(Feed paramFeed)
  {
    if ((paramFeed == null) || (!paramFeed.HasUrl())) {}
    for (;;)
    {
      return;
      try
      {
        FeedParseData localFeedParseData = new FeedParseData(1);
        LoadFromCache(paramFeed, localFeedParseData);
        if ((localFeedParseData.RssFeed != null) && (FeedParseData.IsRssFeedType(localFeedParseData.ParsedFeedType)))
        {
          localFeedParseData.RssFeed.SyncOwnerFeedReadStatus();
          return;
        }
      }
      catch (Exception localException)
      {
        CoreHelper.LogException(TAG, "Unable to sync feed read status for feed " + paramFeed.getName() + "!", localException);
      }
    }
  }
  
  public static void TouchFeedCacheFor(Feed paramFeed)
  {
    if (!paramFeed.HasUri()) {
      return;
    }
    CoreHelper.TouchFile(GetFeedDownloadPath(paramFeed.getFeedUri()));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/rss/RssFeedCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */