package mobi.beyondpod.sync;

import java.util.Date;
import java.util.UUID;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEvent;
import mobi.beyondpod.rsscore.rss.ItemStateHistory;
import mobi.beyondpod.rsscore.rss.entities.RssFeed;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;

public class TrackedChangePost
  extends TrackedChangeBase
{
  protected static final int BLOB_ItemId = 0;
  protected static final int BLOB_OriginatingFeedUrl = 1;
  private static final String TAG = TrackedChangePost.class.getSimpleName();
  protected RssFeedItem _RssFeedItem;
  
  public TrackedChangePost(int paramInt, RssFeedItem paramRssFeedItem)
  {
    super(paramInt);
    Feed localFeed = FeedRepository.GetFeedById(paramRssFeedItem.ParentFeed().FeedID);
    if ((localFeed != null) && (!StringUtils.IsNullOrEmpty(localFeed.getFeedUrl()))) {
      this._RssFeedItem = RssFeedItem.BuildMockRssItem(localFeed.getFeedUrl(), paramRssFeedItem.ItemID(), paramRssFeedItem.Title.toString(), paramRssFeedItem.Link, paramRssFeedItem.PubDate(), paramRssFeedItem.TaglessDescription().toString(), null, null, null);
    }
  }
  
  public TrackedChangePost(Long paramLong, long paramLong1, int paramInt1, int paramInt2, String paramString)
  {
    super(paramLong, paramLong1, paramInt1, paramInt2, paramString);
    LoadFromBlob();
  }
  
  public void ApplyRemoteChange()
  {
    if (SyncStatus() != 3) {
      return;
    }
    if (!IsValid())
    {
      updateSyncStatusTo(4);
      TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY sync Post change was found for a non existing feed and was ignored!", this);
      return;
    }
    switch (ChangeType())
    {
    }
    for (;;)
    {
      updateSyncStatusTo(4);
      BeyondPodApplication.MessageBus.PublishEventAsync(new RepositoryEvents.RepositoryEvent(15));
      return;
      TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY sync POST STARRED. Item:" + this._RssFeedItem.Title, this);
      ItemStateHistory.SetItemAsStarred(this._RssFeedItem);
      continue;
      TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY sync POST UNSTARRED. Item:" + this._RssFeedItem.Title, this);
      ItemStateHistory.ClearItemStarredStatus(this._RssFeedItem);
      continue;
      TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY sync POST READ. Item:" + this._RssFeedItem.Title, this);
      ItemStateHistory.SetItemAsRead(this._RssFeedItem);
      continue;
      TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY sync POST UNREAD. Item:" + this._RssFeedItem.Title, this);
      ItemStateHistory.ClearItemReadStatus(this._RssFeedItem);
    }
  }
  
  public String FriendlyName()
  {
    if (IsValid()) {
      return this._RssFeedItem.Title + " (FP: " + this._RssFeedItem.ItemID() + ")";
    }
    return "!!! Invalid Post (or Feed does not exist) !!!";
  }
  
  public boolean IsValid()
  {
    return (this._RssFeedItem != null) && (FeedRepository.GetFeedByUrl(this._RssFeedItem.ParentFeed().Link) != null) && (!StringUtils.IsNullOrEmpty(this._RssFeedItem.ItemID()));
  }
  
  protected void LoadFromBlob()
  {
    String str1 = null;
    String str2 = null;
    String[] arrayOfString = ParseBlob();
    int i = 0;
    if (i == arrayOfString.length)
    {
      this._RssFeedItem = RssFeedItem.BuildMockRssItem(str2, str1, "", "", new Date(), "", null, null, null);
      return;
    }
    switch (i)
    {
    }
    for (;;)
    {
      i += 1;
      break;
      str1 = arrayOfString[i];
      continue;
      str2 = arrayOfString[i];
    }
  }
  
  public String MessageId()
  {
    if (this._MessageId == null) {
      if (this._RssFeedItem == null) {
        break label63;
      }
    }
    label63:
    for (String str = this._RssFeedItem.ParentFeed().Link + "|" + this._RssFeedItem.ItemID();; str = "INVALID_MESSAGE_ID:" + UUID.randomUUID().toString())
    {
      this._MessageId = str;
      return this._MessageId;
    }
  }
  
  public void PrepareForSave()
  {
    SaveToBlob(new String[] { this._RssFeedItem.ItemID(), this._RssFeedItem.ParentFeed().Link });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/sync/TrackedChangePost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */