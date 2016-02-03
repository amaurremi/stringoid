package mobi.beyondpod.rsscore.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackDictionary;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategories;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.helpers.TimeSpan;
import mobi.beyondpod.rsscore.rss.LicenseManager;
import mobi.beyondpod.schedulercore.ScheduledTasksManager;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.DefaultHandler;

public class RepositoryHandler
  extends DefaultHandler
{
  private static final String TAG = "RepositoryParser";
  private StringBuilder _Categories = new StringBuilder();
  private Feed _Feed;
  private boolean _IsInCategories = false;
  private TrackDictionary _Tracks;
  
  public RepositoryHandler(TrackDictionary paramTrackDictionary, Feed paramFeed)
  {
    this._Tracks = paramTrackDictionary;
    this._Feed = paramFeed;
  }
  
  private void ReadFeed(Attributes paramAttributes)
  {
    Object localObject2 = getAttributeValue(paramAttributes);
    try
    {
      Object localObject1 = StringUtils.TryParseUUIDFromString((String)((HashMap)localObject2).get("id"), UUID.randomUUID());
      paramAttributes = StringUtils.TryParseStringFromString((String)((HashMap)localObject2).get("name"), "");
      String str1 = StringUtils.TryParseStringFromString((String)((HashMap)localObject2).get("path"), "");
      String str2 = StringUtils.TryParseStringFromString((String)((HashMap)localObject2).get("url"), "");
      String str3 = StringUtils.TryParseStringFromString((String)((HashMap)localObject2).get("imageUrl"), "");
      String str4 = StringUtils.TryParseStringFromString((String)((HashMap)localObject2).get("category"), "");
      String str5 = StringUtils.TryParseStringFromString((String)((HashMap)localObject2).get("username"), "");
      int i = StringUtils.TryParseIntFromString((String)((HashMap)localObject2).get("autodelete"), Integer.valueOf(0)).intValue();
      int j = StringUtils.TryParseIntFromString((String)((HashMap)localObject2).get("view"), Integer.valueOf(0)).intValue();
      int k = StringUtils.TryParseIntFromString((String)((HashMap)localObject2).get("type"), Integer.valueOf(0)).intValue();
      int m = StringUtils.TryParseIntFromString((String)((HashMap)localObject2).get("maxTracks"), Integer.valueOf(Configuration.getGlobalDefaultKeepAtMostPodcasts())).intValue();
      int n = StringUtils.TryParseIntFromString((String)((HashMap)localObject2).get("maxTrackAge"), Integer.valueOf(99999)).intValue();
      int i1 = StringUtils.TryParseIntFromString((String)((HashMap)localObject2).get("maxDownload"), Integer.valueOf(Configuration.getGlobalDefaultNumberPodcastsToDownload())).intValue();
      int i2 = StringUtils.TryParseIntFromString((String)((HashMap)localObject2).get("maxGReaderItems"), Integer.valueOf(0)).intValue();
      int i3 = StringUtils.TryParseIntFromString((String)((HashMap)localObject2).get("hasUnread"), Integer.valueOf(0)).intValue();
      int i4 = StringUtils.TryParseIntFromString((String)((HashMap)localObject2).get("custDownload"), Integer.valueOf(0)).intValue();
      boolean bool1 = StringUtils.TryParseBooleanFromString((String)((HashMap)localObject2).get("forceUniqueNames"), false);
      boolean bool2 = StringUtils.TryParseBooleanFromString((String)((HashMap)localObject2).get("savePlayedPosition"), true);
      int i5 = StringUtils.TryParseIntFromString((String)((HashMap)localObject2).get("fingerprintType"), Integer.valueOf(1)).intValue();
      boolean bool3 = StringUtils.TryParseBooleanFromString((String)((HashMap)localObject2).get("leftTruncateLongTrackNames"), false);
      int i6 = StringUtils.TryParseIntFromString((String)((HashMap)localObject2).get("forceItemSort"), Integer.valueOf(-1)).intValue();
      int i7 = StringUtils.TryParseIntFromString((String)((HashMap)localObject2).get("trackSort"), Integer.valueOf(-1)).intValue();
      int i8 = StringUtils.TryParseIntFromString((String)((HashMap)localObject2).get("feedPlayer"), Integer.valueOf(-1)).intValue();
      Date localDate1 = DateTime.TryParseDateTime((String)((HashMap)localObject2).get("pubDate"));
      Date localDate2 = DateTime.TryParseDateTime((String)((HashMap)localObject2).get("srvPubDate"));
      localObject2 = StringUtils.TryParseStringFromString((String)((HashMap)localObject2).get("lastItemId"), null);
      localObject1 = new Feed((UUID)localObject1, this._Feed);
      try
      {
        ((Feed)localObject1).setName(paramAttributes);
        ((Feed)localObject1).setFeedUrl(str2);
        ((Feed)localObject1).setFeedImageUrl(str3);
        ((Feed)localObject1).setAllowAutoTrackDeletions(i);
        ((Feed)localObject1).setPreferredEnclosureIndex(j);
        ((Feed)localObject1).setType(k);
        ((Feed)localObject1).setFeedPath(str1);
        ((Feed)localObject1).setNumUnreadItems(i3);
        ((Feed)localObject1).setLastModifiedDate(localDate1);
        ((Feed)localObject1).setLastServerModifiedDate(localDate2);
        ((Feed)localObject1).setCategories(FeedCategories.Deserialize(str4));
        ((Feed)localObject1).setForceFeedItemSort(i6);
        ((Feed)localObject1).setForceUniqueTrackNames(bool1);
        ((Feed)localObject1).setShouldRememberPlayedPosition(bool2);
        ((Feed)localObject1).setItemFingerprintAlgorithm(i5);
        ((Feed)localObject1).setLeftTruncateLongTrackNames(bool3);
        ((Feed)localObject1).setLastItemID((String)localObject2);
        ((Feed)localObject1).setFeedPlayer(i8);
        ((Feed)localObject1).setUserName(str5);
        ((Feed)localObject1).setTrackSortOrder(i7);
        if (i2 > 0) {
          ((Feed)localObject1).setMaxNumGReaderItemsToGet(i2);
        }
        ((Feed)localObject1).setPodcastDownloadAction(i4);
        ((Feed)localObject1).setMaxNumberPodcastsToDownload(i1);
        ((Feed)localObject1).setKeepAtMostPodcasts(m);
        ((Feed)localObject1).setMaximumPodcastAge(new TimeSpan(n, 0L, 0L, 0L));
      }
      catch (Throwable paramAttributes)
      {
        for (;;)
        {
          CoreHelper.WriteLogEntry("RepositoryParser", "Unable to read feed! " + paramAttributes.getMessage());
        }
      }
      this._Feed.SubFeeds().add(localObject1);
      return;
    }
    catch (Throwable paramAttributes)
    {
      CoreHelper.WriteLogEntry("RepositoryParser", "Unable to read feed! " + paramAttributes.getMessage());
    }
  }
  
  private void ReadTrack(Attributes paramAttributes)
  {
    Object localObject2 = getAttributeValue(paramAttributes);
    try
    {
      Object localObject1 = StringUtils.TryParseStringFromString((String)((HashMap)localObject2).get("path"), "");
      paramAttributes = StringUtils.TryParseStringFromString((String)((HashMap)localObject2).get("name"), "");
      String str1 = StringUtils.TryParseStringFromString((String)((HashMap)localObject2).get("protocol"), "");
      String str2 = StringUtils.TryParseStringFromString((String)((HashMap)localObject2).get("description"), "");
      String str3 = StringUtils.TryParseStringFromString((String)((HashMap)localObject2).get("imagePath"), "");
      String str4 = StringUtils.TryParseStringFromString((String)((HashMap)localObject2).get("postTitle"), "");
      String str5 = StringUtils.TryParseStringFromString((String)((HashMap)localObject2).get("postUrl"), "");
      String str6 = StringUtils.TryParseStringFromString((String)((HashMap)localObject2).get("url"), "");
      String str7 = StringUtils.TryParseStringFromString((String)((HashMap)localObject2).get("contentType"), "");
      long l1 = StringUtils.TryParseLongFromString((String)((HashMap)localObject2).get("totalTime"), Long.valueOf(0L)).longValue();
      long l2 = StringUtils.TryParseLongFromString((String)((HashMap)localObject2).get("playedTime"), Long.valueOf(0L)).longValue();
      boolean bool = StringUtils.TryParseBooleanFromString((String)((HashMap)localObject2).get("played"), false);
      long l3 = StringUtils.TryParseLongFromString((String)((HashMap)localObject2).get("downloadSize"), Long.valueOf(0L)).longValue();
      long l4 = StringUtils.TryParseLongFromString((String)((HashMap)localObject2).get("downloadPortion"), Long.valueOf(0L)).longValue();
      int i = StringUtils.TryParseIntFromString((String)((HashMap)localObject2).get("locked"), Integer.valueOf(0)).intValue();
      localObject2 = DateTime.TryParseDateTime((String)((HashMap)localObject2).get("pubDate"));
      localObject1 = new Track((String)localObject1, null);
      ((Track)localObject1).setName(paramAttributes);
      ((Track)localObject1).setContentMimeType(str7);
      ((Track)localObject1).InitializePlayedTimes(l2, l1, bool);
      ((Track)localObject1).setProtocol(str1);
      ((Track)localObject1).setTrackDescription(str2);
      ((Track)localObject1).setTrackImagePath(str3);
      ((Track)localObject1).setTrackPostTitle(str4);
      ((Track)localObject1).setTrackPostUrl(str5);
      ((Track)localObject1).setUrl(str6);
      ((Track)localObject1).setDownloadedPortion(l4);
      ((Track)localObject1).setDownloadSize(l3);
      ((Track)localObject1).setLastModifiedDate((Date)localObject2);
      if (i == 1) {}
      for (bool = true;; bool = false)
      {
        ((Track)localObject1).setLocked(bool);
        this._Tracks.put(((Track)localObject1).TrackPath(), localObject1);
        return;
      }
      return;
    }
    catch (Throwable paramAttributes)
    {
      CoreHelper.WriteLogEntry("RepositoryParser", "Unable to read track! " + paramAttributes.getMessage());
    }
  }
  
  private HashMap<String, String> getAttributeValue(Attributes paramAttributes)
  {
    HashMap localHashMap = new HashMap(paramAttributes.getLength());
    int i = 0;
    for (;;)
    {
      if (i >= paramAttributes.getLength()) {
        return localHashMap;
      }
      localHashMap.put(paramAttributes.getLocalName(i), paramAttributes.getValue(i));
      i += 1;
    }
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this._IsInCategories)
    {
      paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
      this._Categories.append(paramArrayOfChar);
    }
  }
  
  public void endDocument()
    throws SAXException
  {}
  
  public void endElement(String paramString1, String paramString2, String paramString3)
    throws SAXException
  {
    if (this._IsInCategories) {}
    try
    {
      paramString1 = this._Categories.toString();
      if (!StringUtils.IsNullOrEmpty(paramString1)) {
        CategoryManager.Deserialize(paramString1);
      }
      return;
    }
    catch (Exception paramString1)
    {
      CoreHelper.WriteLogEntry("RepositoryParser", "Unable to read categories! Reason: " + paramString1.getMessage());
    }
  }
  
  public void startDocument()
    throws SAXException
  {}
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    throws SAXException
  {
    this._IsInCategories = false;
    if (paramString2.equals("categories")) {
      this._IsInCategories = true;
    }
    do
    {
      return;
      if (paramString2.equals("tracks"))
      {
        LicenseManager.SetTrialStartDate(DateTime.TryParseDateTime((String)getAttributeValue(paramAttributes).get("versionId")));
        return;
      }
      if (paramString2.equals("track"))
      {
        ReadTrack(paramAttributes);
        return;
      }
      if (paramString2.equals("feed"))
      {
        ReadFeed(paramAttributes);
        return;
      }
    } while (!paramString2.equals("task"));
    ScheduledTasksManager.LoadTask(new AttributesImpl(paramAttributes));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/repository/RepositoryHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */