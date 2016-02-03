package mobi.beyondpod.ui.core;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.rss.entities.RssFeed;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;

public class MasterViewState
{
  public static final String CONTENT_VIEW_FEED_ITEM_IDS = "CONTENT_VIEW_FEED_ITEMS";
  public static final String CONTENT_VIEW_FEED_ITEM_ID_TIMESTAMP = "CONTENT_VIEW_FEED_ITEM_ID_TIMESTAMP";
  public static final String CONTENT_VIEW_FEED_KEY = "CONTENT_VIEW_FEED_KEY";
  public static final String CURRENT_VIEW_KEY = "CURRENT_VIEW_KEY";
  public static final String FEEDS_FVI = "FEEDS_FVI";
  public static final String FEEDS_ROOT_KEY = "FEEDS_ROOT_KEY";
  public static final String FEED_CONTENT_FVI = "FEED_CONTENT_FVI";
  public static final String FEED_SCOPE_KEY = "FEED_SCOPE_KEY";
  public static final String LAST_EXTERNAL_PLAYING_TRACK_PATH = "LAST_EXTERNAL_PLAYING_TRACK_PATH";
  public static final String LAST_EXTERNAL_PLAYING_TRACK_TIME = "LAST_EXTERNAL_PLAYING_TRACK_TIME";
  public static final String P2P_KEY = "P2P_KEY";
  public static final String PODCASTS_FVI = "PODCASTS_FVI";
  public Feed ContentViewFeed;
  public int CurrentView = -1;
  public int FeedContentFirstVisibleItem;
  public ArrayList<String> FeedContentItemIds;
  public long FeedContentItemIdsTimeStamp;
  public ArrayList<RssFeedItem> FeedContentItems;
  public RssFeed FeedContentRssFeed;
  public int FeedsFirstVisibleItem;
  public Feed FeedsViewRootFeed;
  public String LastExternalPlayingTrackPath;
  public long LastExternalPlayingTrackTime;
  public int PodcastCurrentScope = -1;
  public int PodcastsFirstVisibleItem;
  
  static String DumpBundle(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "The bundle is <null>";
    }
    return new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder("CURRENT_VIEW_KEY:").append(paramBundle.getInt("CURRENT_VIEW_KEY")).append("\n").toString())).append("P2P_KEY:").append(paramBundle.getInt("P2P_KEY")).append("\n").toString())).append("FEED_SCOPE_KEY:").append(paramBundle.getInt("FEED_SCOPE_KEY")).append("\n").toString())).append("FEEDS_ROOT_KEY:").append(paramBundle.getString("FEEDS_ROOT_KEY")).append("\n").toString() + "CONTENT_VIEW_FEED_KEY:" + paramBundle.getString("CONTENT_VIEW_FEED_KEY") + "\n";
  }
  
  public static MasterViewState FromBundle(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    MasterViewState localMasterViewState = new MasterViewState();
    localMasterViewState.CurrentView = paramBundle.getInt("CURRENT_VIEW_KEY");
    localMasterViewState.PodcastCurrentScope = paramBundle.getInt("FEED_SCOPE_KEY");
    Feed localFeed2 = SafeGetFeed(paramBundle.getString("FEEDS_ROOT_KEY"));
    Feed localFeed1 = localFeed2;
    if (localFeed2 == null) {
      localFeed1 = FeedRepository.getRootFeed();
    }
    localMasterViewState.FeedsViewRootFeed = localFeed1;
    localMasterViewState.ContentViewFeed = SafeGetFeed(paramBundle.getString("CONTENT_VIEW_FEED_KEY"));
    localMasterViewState.FeedContentItemIds = paramBundle.getStringArrayList("CONTENT_VIEW_FEED_ITEMS");
    localMasterViewState.LastExternalPlayingTrackPath = paramBundle.getString("LAST_EXTERNAL_PLAYING_TRACK_PATH");
    localMasterViewState.LastExternalPlayingTrackTime = paramBundle.getLong("LAST_EXTERNAL_PLAYING_TRACK_TIME", -1L);
    localMasterViewState.FeedContentFirstVisibleItem = paramBundle.getInt("FEED_CONTENT_FVI", 0);
    localMasterViewState.PodcastsFirstVisibleItem = paramBundle.getInt("PODCASTS_FVI", 0);
    localMasterViewState.FeedsFirstVisibleItem = paramBundle.getInt("FEEDS_FVI", 0);
    localMasterViewState.FeedContentItemIdsTimeStamp = paramBundle.getLong("CONTENT_VIEW_FEED_ITEM_ID_TIMESTAMP", -1L);
    return localMasterViewState;
  }
  
  static Feed SafeGetFeed(String paramString)
  {
    if (StringUtils.IsNullOrEmpty(paramString)) {}
    do
    {
      return null;
      paramString = UUID.fromString(paramString);
    } while (paramString == null);
    return FeedRepository.GetFeedById(paramString);
  }
  
  public void ToBundle(Bundle paramBundle)
  {
    RssFeedItem localRssFeedItem = null;
    paramBundle.putInt("CURRENT_VIEW_KEY", this.CurrentView);
    paramBundle.putInt("FEED_SCOPE_KEY", this.PodcastCurrentScope);
    Object localObject;
    if (this.FeedsViewRootFeed != null)
    {
      localObject = this.FeedsViewRootFeed.ID().toString();
      paramBundle.putString("FEEDS_ROOT_KEY", (String)localObject);
      localObject = localRssFeedItem;
      if (this.ContentViewFeed != null) {
        localObject = this.ContentViewFeed.ID().toString();
      }
      paramBundle.putString("CONTENT_VIEW_FEED_KEY", (String)localObject);
      paramBundle.putString("LAST_EXTERNAL_PLAYING_TRACK_PATH", this.LastExternalPlayingTrackPath);
      paramBundle.putLong("LAST_EXTERNAL_PLAYING_TRACK_TIME", this.LastExternalPlayingTrackTime);
      paramBundle.putInt("FEED_CONTENT_FVI", this.FeedContentFirstVisibleItem);
      paramBundle.putInt("PODCASTS_FVI", this.PodcastsFirstVisibleItem);
      paramBundle.putInt("FEEDS_FVI", this.FeedsFirstVisibleItem);
      paramBundle.putLong("CONTENT_VIEW_FEED_ITEM_ID_TIMESTAMP", this.FeedContentItemIdsTimeStamp);
      this.FeedContentItemIds = new ArrayList();
      if (this.FeedContentItems != null) {
        localObject = this.FeedContentItems.iterator();
      }
    }
    for (;;)
    {
      if (!((Iterator)localObject).hasNext())
      {
        paramBundle.putStringArrayList("CONTENT_VIEW_FEED_ITEMS", this.FeedContentItemIds);
        return;
        localObject = null;
        break;
      }
      localRssFeedItem = (RssFeedItem)((Iterator)localObject).next();
      this.FeedContentItemIds.add(localRssFeedItem.ItemID());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(new StringBuilder("Current View:").append(this.CurrentView).append("\n").toString() + "PodcastCurrentScope:" + this.PodcastCurrentScope + "\n")).append("FeedsViewRootFeed:");
    if (this.FeedsViewRootFeed != null)
    {
      str = this.FeedsViewRootFeed.ID().toString();
      localStringBuilder = new StringBuilder(String.valueOf(str + "\n")).append("ContentViewFeed:");
      if (this.ContentViewFeed == null) {
        break label155;
      }
    }
    label155:
    for (String str = this.ContentViewFeed.ID().toString();; str = "<null>")
    {
      return str + "\n";
      str = "<null>";
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/MasterViewState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */