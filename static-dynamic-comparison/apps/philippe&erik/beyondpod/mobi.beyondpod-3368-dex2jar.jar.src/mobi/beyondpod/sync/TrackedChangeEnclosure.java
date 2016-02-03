package mobi.beyondpod.sync;

import java.util.Date;
import java.util.UUID;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.rss.EnclosureDownloadHistory;
import mobi.beyondpod.rsscore.rss.RssFeedCache;
import mobi.beyondpod.rsscore.rss.entities.RssEnclosure;
import mobi.beyondpod.rsscore.rss.entities.RssFeed;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;

public class TrackedChangeEnclosure
  extends TrackedChangeBase
{
  protected static final int BLOB_Description = 7;
  protected static final int BLOB_EnclSize = 8;
  protected static final int BLOB_EnclType = 3;
  protected static final int BLOB_EnclUrl = 2;
  protected static final int BLOB_ItemId = 0;
  protected static final int BLOB_Link = 6;
  protected static final int BLOB_OriginatingFeedUrl = 1;
  protected static final int BLOB_PubDate = 4;
  protected static final int BLOB_Title = 5;
  public static final String REMOTE_CHANGE = "REMOTE_ADD";
  private static final String TAG = TrackedChangeEpisode.class.getSimpleName();
  protected RssFeedItem _RssFeedItem;
  
  public TrackedChangeEnclosure(int paramInt, RssEnclosure paramRssEnclosure)
  {
    super(paramInt);
    if (paramRssEnclosure == null) {}
    RssFeedItem localRssFeedItem;
    Feed localFeed;
    do
    {
      return;
      localRssFeedItem = paramRssEnclosure.Parent;
      localFeed = FeedRepository.GetFeedById(localRssFeedItem.ParentFeed().FeedID);
    } while ((localFeed == null) || (StringUtils.IsNullOrEmpty(localFeed.getFeedUrl())) || (paramRssEnclosure == null));
    this._RssFeedItem = RssFeedItem.BuildMockRssItem(localFeed.getFeedUrl(), localRssFeedItem.ItemID(), localRssFeedItem.Title.toString(), localRssFeedItem.Link, localRssFeedItem.PubDate(), localRssFeedItem.TaglessDescription().toString(), paramRssEnclosure.Url, paramRssEnclosure.Type, paramRssEnclosure.EnclosureFileLength());
  }
  
  public TrackedChangeEnclosure(Long paramLong, long paramLong1, int paramInt1, int paramInt2, String paramString)
  {
    super(paramLong, paramLong1, paramInt1, paramInt2, paramString);
    LoadFromBlob();
  }
  
  private void HandleEpisodeMarkedAsDownloaded()
  {
    if (!this._RssFeedItem.Enclosure().IsEnclosureInHistory()) {
      EnclosureDownloadHistory.AddEnclosure(this._RssFeedItem.Enclosure(), false);
    }
    TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY sync EPISODE MARKED AS DOWNLOADED. Episode:" + this._RssFeedItem.Title, this);
    updateSyncStatusTo(4);
  }
  
  private void HandleEpisodeMarkedAsNotDownloaded()
  {
    if (this._RssFeedItem.Enclosure().IsEnclosureInHistory()) {
      EnclosureDownloadHistory.RemoveEnclosure(this._RssFeedItem.Enclosure(), false);
    }
    TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY sync EPISODE MARKED AS NOT DOWNLOADED. Episode:" + this._RssFeedItem.Title, this);
    updateSyncStatusTo(4);
  }
  
  private void HandleStreamableTrackAdded()
  {
    Track localTrack = FeedRepository.GetTrackByUrl(this._RssFeedItem.Enclosure().Url);
    Feed localFeed = FeedRepository.GetFeedByUrl(this._RssFeedItem.ParentFeed().Link);
    if ((localFeed != null) && (ChangeTracker.AllowRemoteEpisodeAdditions()) && (localTrack == null) && (localFeed.getPodcastDownloadAction() != 3))
    {
      localTrack = RssFeedCache.CreateStreamableTrackFromEnclosure(localFeed, this._RssFeedItem.Enclosure(), false);
      localTrack.ChangeTrackingEnabled = false;
      localTrack.setProtocol("REMOTE_ADD");
      TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY sync EPISODE ADDED. Episode:" + this._RssFeedItem.Title, this);
    }
    for (;;)
    {
      updateSyncStatusTo(4);
      return;
      if ((localFeed != null) && (localFeed.getPodcastDownloadAction() == 3)) {
        TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY sync EPISODE ADDED. Episode feed is set to ignore episodes! Ignoring... Episode:" + this._RssFeedItem.Title, this);
      } else {
        TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY sync EPISODE ADDED. Episode already exists! Ignoring... Episode:" + this._RssFeedItem.Title, this);
      }
    }
  }
  
  public void ApplyRemoteChange()
  {
    if (SyncStatus() != 3) {
      return;
    }
    if (!IsValid())
    {
      updateSyncStatusTo(4);
      TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY sync Enclosure change was found for a invalid enclosure and was ignored!", this);
      return;
    }
    switch (ChangeType())
    {
    default: 
      return;
    case 4: 
      HandleStreamableTrackAdded();
      return;
    case 5: 
      HandleEpisodeMarkedAsDownloaded();
      return;
    }
    HandleEpisodeMarkedAsNotDownloaded();
  }
  
  public String FriendlyName()
  {
    StringBuilder localStringBuilder;
    if (IsValid())
    {
      str = this._RssFeedItem.Title + " (FP: " + this._RssFeedItem.ItemID() + ")";
      localStringBuilder = new StringBuilder(String.valueOf(str)).append("->");
      if (!IsValid()) {
        break label152;
      }
    }
    label152:
    for (String str = this._RssFeedItem.Enclosure().Url + " (Type: " + this._RssFeedItem.Enclosure().Type + ", Length: " + this._RssFeedItem.Enclosure().EnclosureFileLength() + ")";; str = "")
    {
      return str;
      str = "!!! Invalid Episode (or Feed does not exist) !!!";
      break;
    }
  }
  
  public boolean IsValid()
  {
    return (this._RssFeedItem != null) && (FeedRepository.GetFeedByUrl(this._RssFeedItem.ParentFeed().Link) != null) && (!StringUtils.IsNullOrEmpty(this._RssFeedItem.ItemID())) && (this._RssFeedItem.Enclosure() != null) && (!StringUtils.IsNullOrEmpty(this._RssFeedItem.Enclosure().Url));
  }
  
  protected void LoadFromBlob()
  {
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject7 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject8 = null;
    Object localObject1 = null;
    Long localLong = null;
    String[] arrayOfString = ParseBlob();
    int i = 0;
    if (i == arrayOfString.length)
    {
      this._RssFeedItem = RssFeedItem.BuildMockRssItem((String)localObject8, (String)localObject7, (String)localObject6, (String)localObject5, (Date)localObject1, (String)localObject4, (String)localObject3, (String)localObject2, localLong);
      return;
    }
    Object localObject16;
    Object localObject15;
    Object localObject14;
    Object localObject13;
    Object localObject12;
    Object localObject11;
    Object localObject10;
    Object localObject9;
    switch (i)
    {
    default: 
      localObject16 = localObject2;
      localObject15 = localObject3;
      localObject14 = localObject4;
      localObject13 = localObject1;
      localObject12 = localObject5;
      localObject11 = localObject6;
      localObject10 = localObject7;
      localObject9 = localObject8;
    }
    for (;;)
    {
      i += 1;
      localObject8 = localObject9;
      localObject7 = localObject10;
      localObject6 = localObject11;
      localObject5 = localObject12;
      localObject1 = localObject13;
      localObject4 = localObject14;
      localObject3 = localObject15;
      localObject2 = localObject16;
      break;
      localObject10 = arrayOfString[i];
      localObject9 = localObject8;
      localObject11 = localObject6;
      localObject12 = localObject5;
      localObject13 = localObject1;
      localObject14 = localObject4;
      localObject15 = localObject3;
      localObject16 = localObject2;
      continue;
      localObject9 = arrayOfString[i];
      localObject10 = localObject7;
      localObject11 = localObject6;
      localObject12 = localObject5;
      localObject13 = localObject1;
      localObject14 = localObject4;
      localObject15 = localObject3;
      localObject16 = localObject2;
      continue;
      localObject15 = arrayOfString[i];
      localObject9 = localObject8;
      localObject10 = localObject7;
      localObject11 = localObject6;
      localObject12 = localObject5;
      localObject13 = localObject1;
      localObject14 = localObject4;
      localObject16 = localObject2;
      continue;
      localObject16 = arrayOfString[i];
      localObject9 = localObject8;
      localObject10 = localObject7;
      localObject11 = localObject6;
      localObject12 = localObject5;
      localObject13 = localObject1;
      localObject14 = localObject4;
      localObject15 = localObject3;
      continue;
      long l = StringUtils.TryParseLongFromString(arrayOfString[i], Long.valueOf(0L)).longValue();
      if (l > 0L) {}
      for (localObject1 = new Date(l);; localObject1 = null)
      {
        localObject9 = localObject8;
        localObject10 = localObject7;
        localObject11 = localObject6;
        localObject12 = localObject5;
        localObject13 = localObject1;
        localObject14 = localObject4;
        localObject15 = localObject3;
        localObject16 = localObject2;
        break;
      }
      localObject11 = arrayOfString[i];
      localObject9 = localObject8;
      localObject10 = localObject7;
      localObject12 = localObject5;
      localObject13 = localObject1;
      localObject14 = localObject4;
      localObject15 = localObject3;
      localObject16 = localObject2;
      continue;
      localObject12 = arrayOfString[i];
      localObject9 = localObject8;
      localObject10 = localObject7;
      localObject11 = localObject6;
      localObject13 = localObject1;
      localObject14 = localObject4;
      localObject15 = localObject3;
      localObject16 = localObject2;
      continue;
      localObject14 = arrayOfString[i];
      localObject9 = localObject8;
      localObject10 = localObject7;
      localObject11 = localObject6;
      localObject12 = localObject5;
      localObject13 = localObject1;
      localObject15 = localObject3;
      localObject16 = localObject2;
      continue;
      l = StringUtils.SafeParseLong(arrayOfString[i], -1L);
      localObject9 = localObject8;
      localObject10 = localObject7;
      localObject11 = localObject6;
      localObject12 = localObject5;
      localObject13 = localObject1;
      localObject14 = localObject4;
      localObject15 = localObject3;
      localObject16 = localObject2;
      if (l > 0L)
      {
        localLong = Long.valueOf(l);
        localObject9 = localObject8;
        localObject10 = localObject7;
        localObject11 = localObject6;
        localObject12 = localObject5;
        localObject13 = localObject1;
        localObject14 = localObject4;
        localObject15 = localObject3;
        localObject16 = localObject2;
      }
    }
  }
  
  public String MessageId()
  {
    if (this._MessageId == null) {
      if (this._RssFeedItem == null) {
        break label64;
      }
    }
    label64:
    for (String str = this._RssFeedItem.ParentFeed().Link + "|" + this._RssFeedItem.ItemID();; str = "INVALID_MESSAGE_ID:" + UUID.randomUUID().toString())
    {
      this._MessageId = str;
      return this._MessageId;
    }
  }
  
  public void PrepareForSave()
  {
    int i;
    String[] arrayOfString;
    RssEnclosure localRssEnclosure;
    if (this._ChangeType == 4)
    {
      i = 9;
      arrayOfString = new String[i];
      localRssEnclosure = this._RssFeedItem.Enclosure();
      arrayOfString[0] = this._RssFeedItem.ItemID();
      arrayOfString[1] = this._RssFeedItem.ParentFeed().Link;
      arrayOfString[2] = localRssEnclosure.Url;
      arrayOfString[3] = localRssEnclosure.Type;
      if (this._ChangeType == 4)
      {
        if (this._RssFeedItem.PubDate() == null) {
          break label173;
        }
        str = String.valueOf(this._RssFeedItem.PubDate().getTime());
        label96:
        arrayOfString[4] = str;
        arrayOfString[5] = this._RssFeedItem.Title.toString();
        arrayOfString[6] = this._RssFeedItem.Link;
        arrayOfString[7] = this._RssFeedItem.ShortTaglessDescription().toString();
        if (localRssEnclosure.EnclosureFileLength() == null) {
          break label180;
        }
      }
    }
    label173:
    label180:
    for (String str = String.valueOf(localRssEnclosure.EnclosureFileLength());; str = "")
    {
      arrayOfString[8] = str;
      SaveToBlob(arrayOfString);
      return;
      i = 4;
      break;
      str = "0";
      break label96;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/sync/TrackedChangeEnclosure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */