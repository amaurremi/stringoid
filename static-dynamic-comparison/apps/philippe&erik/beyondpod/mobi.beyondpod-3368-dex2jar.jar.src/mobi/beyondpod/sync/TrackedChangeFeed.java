package mobi.beyondpod.sync;

import java.util.Iterator;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategories;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.helpers.TimeSpan;
import mobi.beyondpod.rsscore.repository.FeedRepository;

public class TrackedChangeFeed
  extends TrackedChangeBase
{
  private static final int BLOB_CAT_1 = 2;
  private static final int BLOB_CAT_2 = 3;
  private static final int BLOB_CLEANUP_DAYS = 9;
  private static final int BLOB_CLEANUP_NUM_EPISODES = 8;
  private static final int BLOB_ENCLOSURE_ACTION = 6;
  private static final int BLOB_ENCLOSURE_INDEX = 10;
  private static final int BLOB_EPISODES_TO_GET = 7;
  private static final int BLOB_EPISODE_SORT_ORDER = 11;
  private static final int BLOB_FEED_NAME = 1;
  private static final int BLOB_FEED_TYPE = 4;
  private static final int BLOB_FEED_URL = 0;
  private static final int BLOB_ITEM_SORT_ORDER = 12;
  private static final int BLOB_NUM_READER_ITEMS = 5;
  private static final String TAG = TrackedChangeFeed.class.getSimpleName();
  private String _Category1;
  private String _Category2;
  private int _EnclosureAction;
  private int _EnclosureIndex;
  private int _EpisodeSortOrder;
  private String _FeedName;
  private int _FeedType;
  private String _FeedUrl;
  private int _ItemSortOrder;
  private int _NumDaysToKeep;
  private int _NumEpisodesToGet;
  private int _NumEpisodesToKeep;
  private int _NumReaderItems;
  
  public TrackedChangeFeed(int paramInt, Feed paramFeed)
  {
    super(paramInt);
    this._FeedUrl = paramFeed.getFeedUrl();
    this._FeedName = paramFeed.getName();
    this._Category1 = paramFeed.getCategories().getPrimary().Value();
    this._Category2 = paramFeed.getCategories().getSecondary().Value();
    this._FeedType = paramFeed.getType();
    this._NumReaderItems = paramFeed.getMaxNumGReaderItemsToGet();
    this._EnclosureAction = paramFeed.getPodcastDownloadAction();
    this._NumEpisodesToGet = paramFeed.getMaxNumberPodcastToDownload();
    this._NumEpisodesToKeep = paramFeed.getKeepAtMostPodcasts();
    this._NumDaysToKeep = ((int)paramFeed.getMaximumPodcastAge().getTotalDays());
    this._EpisodeSortOrder = paramFeed.getTrackSortOrder();
    this._EnclosureIndex = paramFeed.getPreferredEnclosureIndex();
    this._ItemSortOrder = paramFeed.getForceFeedItemSort();
  }
  
  public TrackedChangeFeed(Long paramLong, long paramLong1, int paramInt1, int paramInt2, String paramString)
  {
    super(paramLong, paramLong1, paramInt1, paramInt2, paramString);
    paramLong = ParseBlob();
    paramInt1 = 0;
    for (;;)
    {
      if (paramInt1 == paramLong.length) {
        return;
      }
      LoadFromBlob(paramInt1, paramLong[paramInt1]);
      paramInt1 += 1;
    }
  }
  
  private FeedCategory FindOrCreateCategory(String paramString)
  {
    if (StringUtils.IsNullOrEmpty(paramString)) {
      return CategoryManager.Unassigned;
    }
    if (CategoryManager.GetCategoryByValue(paramString) == CategoryManager.CategoryNull) {}
    try
    {
      CategoryManager.AddCategory(paramString);
      return CategoryManager.GetCategoryByValue(paramString);
    }
    catch (Exception paramString) {}
    return CategoryManager.Unassigned;
  }
  
  private void HandleFeedAdded(boolean paramBoolean)
  {
    if ((ChangeTracker.AllowRemoteFeedAdditions()) || (paramBoolean)) {
      if (FeedRepository.GetFeedByUrl(FeedUrl()) == null)
      {
        Feed localFeed = Feed.CreateAndAddFeedWithDefaults(this._FeedUrl, this._FeedName, null);
        if (this._FeedUrl.contains("google.com/reader/atom")) {
          localFeed.setType(5);
        }
        FeedCategory localFeedCategory1 = FindOrCreateCategory(Category1());
        FeedCategory localFeedCategory2 = FindOrCreateCategory(Category2());
        if ((localFeedCategory1 != CategoryManager.CategoryNull) && (localFeed.getCategories().getPrimary() != localFeedCategory1)) {
          localFeed.getCategories().setPrimary(localFeedCategory1);
        }
        if ((localFeedCategory2 != CategoryManager.CategoryNull) && (localFeed.getCategories().getPrimary() != localFeedCategory2)) {
          localFeed.getCategories().setSecondary(localFeedCategory2);
        }
        localFeed.ChangeTrackingEnabled = false;
        FeedRepository.NotifyFeedChanged(localFeed);
        ChangeTracker.OnFeedImported(localFeed);
        TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY sync FEED ADDED. Feed:" + FeedName() + " (" + localFeedCategory1.Name() + ", " + localFeedCategory2.Name() + ")", this);
      }
    }
    for (;;)
    {
      updateSyncStatusTo(4);
      return;
      TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY sync FEED ADDED. Feed already exist! Ignoring... Feed:" + FeedUrl(), this);
      continue;
      TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY sync FEED ADDED. Remote feed additions are disabled! Ignoring... Feed:" + FeedUrl(), this);
    }
  }
  
  private void HandleFeedDeleted()
  {
    Feed localFeed = FeedRepository.GetFeedByUrl(this._FeedUrl);
    Iterator localIterator;
    if (ChangeTracker.AllowRemoteFeedDeletions()) {
      if (localFeed != null)
      {
        localFeed.ChangeTrackingEnabled = false;
        localIterator = localFeed.Tracks().iterator();
        if (!localIterator.hasNext())
        {
          FeedRepository.DeleteFeedAndRelatedFoldersSync(localFeed);
          TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY sync FEED DELETED. Feed:" + FeedName(), this);
        }
      }
    }
    for (;;)
    {
      updateSyncStatusTo(4);
      return;
      ((Track)localIterator.next()).ChangeTrackingEnabled = false;
      break;
      TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY sync FEED DELETED. Feed does not exist! Ignoring... Feed:" + FeedUrl(), this);
      continue;
      TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY sync FEED DELETED. Remote feed deletions are disabled! Ignoring... Feed:" + FeedUrl(), this);
    }
  }
  
  private void HandleFeedModified(boolean paramBoolean)
  {
    Feed localFeed = FeedRepository.GetFeedByUrl(this._FeedUrl);
    if ((ChangeTracker.AllowRemoteFeedModifications()) || (paramBoolean)) {
      if (localFeed != null)
      {
        int i = 0;
        if (!localFeed.getName().equals(FeedName()))
        {
          localFeed.setName(FeedName());
          i = 1;
        }
        FeedCategory localFeedCategory1 = FindOrCreateCategory(Category1());
        FeedCategory localFeedCategory2 = FindOrCreateCategory(Category2());
        if (localFeed.getCategories().getPrimary() != localFeedCategory1)
        {
          localFeed.getCategories().setPrimary(localFeedCategory1);
          i = 1;
        }
        if (localFeed.getCategories().getSecondary() != localFeedCategory2)
        {
          localFeed.getCategories().setSecondary(localFeedCategory2);
          i = 1;
        }
        if (i != 0)
        {
          FeedRepository.NotifyFeedChanged(localFeed);
          TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY sync FEED MODIFIED. Feed:" + FeedName() + " (" + localFeedCategory1.Name() + ", " + localFeedCategory2.Name() + ")", this);
        }
      }
    }
    for (;;)
    {
      updateSyncStatusTo(4);
      return;
      TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY sync FEED MODIFIED. Feed is already up to date! Feed:" + FeedName(), this);
      continue;
      TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY sync FEED MODIFIED. Feed does not exist! Ignoring... Feed:" + FeedUrl(), this);
      continue;
      TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY sync FEED MODIFIED. Remote feed modifications are disabled! Ignoring... Feed:" + FeedUrl(), this);
    }
  }
  
  public void ApplyRemoteChange()
  {
    if (SyncStatus() != 3) {}
    Feed localFeed;
    do
    {
      return;
      if (!IsValid())
      {
        updateSyncStatusTo(4);
        TrackedChangeBase.LogSyncEvent(TAG, "   --- APPLY sync Feed change was found for invalid feed and was ignored!", this);
        return;
      }
      localFeed = FeedRepository.GetFeedByUrl(this._FeedUrl);
      if (ChangeType() == 1)
      {
        HandleFeedAdded(false);
        return;
      }
      if (ChangeType() == 2)
      {
        HandleFeedDeleted();
        return;
      }
      if (ChangeType() == 3)
      {
        HandleFeedModified(false);
        return;
      }
    } while (ChangeType() != 14);
    if (localFeed == null)
    {
      HandleFeedAdded(ChangeTracker.AlwaysAcceptRemoteFeedPush());
      return;
    }
    HandleFeedModified(ChangeTracker.AlwaysAcceptRemoteFeedPush());
  }
  
  public String Category1()
  {
    return this._Category1;
  }
  
  public String Category2()
  {
    return this._Category2;
  }
  
  public String FeedName()
  {
    return this._FeedName;
  }
  
  public String FeedUrl()
  {
    return this._FeedUrl;
  }
  
  public String FriendlyName()
  {
    return this._FeedName + " (" + this._Category1 + ", " + this._Category2 + ")";
  }
  
  public boolean IsValid()
  {
    boolean bool2 = true;
    Feed localFeed = FeedRepository.GetFeedByUrl(this._FeedUrl);
    boolean bool1;
    if ((this._ChangeType == 2) || (this._ChangeType == 3))
    {
      bool1 = bool2;
      if (localFeed != null) {}
    }
    else if (this._ChangeType == 1)
    {
      bool1 = bool2;
      if (localFeed == null) {}
    }
    else
    {
      bool1 = bool2;
      if (this._ChangeType != 14) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  protected void LoadFromBlob(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this._FeedUrl = paramString;
      return;
    case 1: 
      this._FeedName = paramString;
      return;
    case 2: 
      this._Category1 = paramString;
      return;
    case 3: 
      this._Category2 = paramString;
      return;
    case 4: 
      this._FeedType = StringUtils.SafeParseInt(paramString, 2);
      return;
    case 5: 
      this._NumReaderItems = StringUtils.SafeParseInt(paramString, 20);
      return;
    case 6: 
      this._EnclosureAction = StringUtils.SafeParseInt(paramString, 0);
      return;
    case 7: 
      this._NumEpisodesToGet = StringUtils.SafeParseInt(paramString, 3);
      return;
    case 8: 
      this._NumEpisodesToKeep = StringUtils.SafeParseInt(paramString, 3);
      return;
    case 9: 
      this._NumDaysToKeep = StringUtils.SafeParseInt(paramString, 99999);
      return;
    case 10: 
      this._EnclosureIndex = StringUtils.SafeParseInt(paramString, 0);
      return;
    case 11: 
      this._EpisodeSortOrder = StringUtils.SafeParseInt(paramString, -1);
      return;
    }
    this._ItemSortOrder = StringUtils.SafeParseInt(paramString, -1);
  }
  
  public String MessageId()
  {
    if (this._MessageId == null) {
      this._MessageId = this._FeedUrl;
    }
    return this._MessageId;
  }
  
  public void PrepareForSave()
  {
    SaveToBlob(new String[] { this._FeedUrl, this._FeedName, this._Category1, this._Category2, String.valueOf(this._FeedType), String.valueOf(this._NumReaderItems), String.valueOf(this._EnclosureAction), String.valueOf(this._NumEpisodesToGet), String.valueOf(this._NumEpisodesToKeep), String.valueOf(this._NumDaysToKeep), String.valueOf(this._EnclosureIndex), String.valueOf(this._EpisodeSortOrder), String.valueOf(this._ItemSortOrder) });
  }
  
  public void UpdateTo(TrackedChangeBase paramTrackedChangeBase)
  {
    if (!(paramTrackedChangeBase instanceof TrackedChangeFeed)) {
      throw new ClassCastException("Trying to update TrackedChangeFeed from " + paramTrackedChangeBase.getClass().getSimpleName());
    }
    TrackedChangeFeed localTrackedChangeFeed = (TrackedChangeFeed)paramTrackedChangeBase;
    super.UpdateTo(paramTrackedChangeBase);
    this._FeedUrl = localTrackedChangeFeed.FeedUrl();
    this._Category1 = localTrackedChangeFeed.Category1();
    this._Category2 = localTrackedChangeFeed.Category2();
    this._FeedName = localTrackedChangeFeed.FeedName();
    this._FeedType = localTrackedChangeFeed._FeedType;
    this._NumReaderItems = localTrackedChangeFeed._NumReaderItems;
    this._EnclosureAction = localTrackedChangeFeed._EnclosureAction;
    this._NumEpisodesToGet = localTrackedChangeFeed._NumEpisodesToGet;
    this._NumEpisodesToKeep = localTrackedChangeFeed._NumEpisodesToKeep;
    this._NumDaysToKeep = localTrackedChangeFeed._NumDaysToKeep;
    this._EpisodeSortOrder = localTrackedChangeFeed._EpisodeSortOrder;
    this._EnclosureIndex = localTrackedChangeFeed._EnclosureIndex;
    this._ItemSortOrder = localTrackedChangeFeed._ItemSortOrder;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/sync/TrackedChangeFeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */