package mobi.beyondpod.rsscore.rss.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.helpers.MediaFile;
import mobi.beyondpod.rsscore.helpers.MediaFile.MediaFileType;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.rss.ItemStateHistory;

public class RssFeed
{
  public static final String IMG_ITUNES_KEY = "itunes";
  public static final String IMG_RSS_CHILD_ITEM_KEY = "rssChildItem";
  public static final String IMG_RSS_KEY = "rss";
  public String Description = "";
  public UUID FeedID;
  public Hashtable<String, String> FeedImageLinks = new Hashtable();
  public int FeedType;
  public boolean IgnoreEnclosures = false;
  public boolean IsSuspectedNotSubscribedInGoogleReader = false;
  public int ItemIDGenerationAlgorithm = 1;
  public final ArrayList<RssFeedItem> Items = new ArrayList();
  public Date LastRetrievalDate;
  public String Link = "";
  public int PreferredEnclosureIndex = 0;
  public Date PubDate = null;
  public boolean RTL = false;
  public String Title = "";
  public Integer Ttl = null;
  SimpleDateFormat _FeedItemDateFormat;
  ArrayList<RssFeedItem> _VisibleItems = null;
  
  private boolean FeedItemsHaveValidGuids()
  {
    int j = Math.min(10, this.Items.size());
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    for (;;)
    {
      if (i == j)
      {
        if ((localArrayList.size() <= 0) || (localArrayList.size() != j)) {
          break;
        }
        return true;
      }
      String str = ((RssFeedItem)this.Items.get(i)).Guid;
      if ((!StringUtils.IsNullOrEmpty(str)) && (!localArrayList.contains(str))) {
        localArrayList.add(str);
      }
      i += 1;
    }
    return false;
  }
  
  public int AutodetectFingerprintType()
  {
    if (FeedItemsHaveValidGuids()) {
      return 2;
    }
    return 1;
  }
  
  public int AutodetectSortOrder()
  {
    if (this.Items.size() > 1)
    {
      Date localDate1 = ((RssFeedItem)this.Items.get(0)).PubDate();
      Date localDate2 = ((RssFeedItem)this.Items.get(this.Items.size() - 1)).PubDate();
      if ((localDate1 != null) && (localDate2 != null))
      {
        if (localDate2.after(localDate1)) {
          return 2;
        }
        if (localDate1.after(localDate2)) {
          return 3;
        }
      }
    }
    return -1;
  }
  
  public FeedList GetAllOriginatingFeeds()
  {
    FeedList localFeedList = new FeedList();
    Iterator localIterator = this.Items.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localFeedList;
      }
      Feed localFeed = FeedRepository.GetFeedById(((RssFeedItem)localIterator.next()).OriginatingFeedID());
      if ((localFeed != null) && (!localFeedList.contains(localFeed))) {
        localFeedList.add(localFeed);
      }
    }
  }
  
  public ArrayList<RssEnclosure> GetCatchUpDownloadableEnclosures(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt <= 0) {}
    int i;
    do
    {
      RssFeedItem localRssFeedItem;
      do
      {
        Iterator localIterator;
        while (!localIterator.hasNext())
        {
          return localArrayList;
          Collections.sort(this.Items, new RssFeedItemSorter(2));
          localIterator = this.Items.iterator();
        }
        localRssFeedItem = (RssFeedItem)localIterator.next();
      } while ((localRssFeedItem.Enclosure() == null) || (localRssFeedItem.Enclosure().Downloaded()) || (localRssFeedItem.Enclosure().IsEnclosureInHistory()));
      localArrayList.add(localRssFeedItem.Enclosure());
      i = paramInt - 1;
      paramInt = i;
    } while (i != 0);
    return localArrayList;
  }
  
  public ArrayList<RssEnclosure> GetDownloadableEnclosures(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt <= 0) {}
    int i;
    do
    {
      RssFeedItem localRssFeedItem;
      do
      {
        Iterator localIterator;
        while (!localIterator.hasNext())
        {
          return localArrayList;
          localIterator = this.Items.iterator();
        }
        localRssFeedItem = (RssFeedItem)localIterator.next();
      } while (localRssFeedItem.Enclosure() == null);
      if ((!localRssFeedItem.Enclosure().Downloaded()) && (!localRssFeedItem.Enclosure().IsEnclosureInHistory())) {
        localArrayList.add(localRssFeedItem.Enclosure());
      }
      i = paramInt - 1;
      paramInt = i;
    } while (i != 0);
    return localArrayList;
  }
  
  public RssEnclosure GetEnclosureByLocalFileName(String paramString)
  {
    Iterator localIterator = this.Items.iterator();
    RssFeedItem localRssFeedItem;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localRssFeedItem = (RssFeedItem)localIterator.next();
    } while ((localRssFeedItem.Enclosure() == null) || (!StringUtils.EqualsIgnoreCase(localRssFeedItem.Enclosure().LocalFileName(), paramString)));
    return localRssFeedItem.Enclosure();
  }
  
  public RssFeedItem GetItemById(String paramString)
  {
    Iterator localIterator = this.Items.iterator();
    RssFeedItem localRssFeedItem;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localRssFeedItem = (RssFeedItem)localIterator.next();
    } while ((localRssFeedItem.ItemID() == null) || (!localRssFeedItem.ItemID().equals(paramString)));
    return localRssFeedItem;
  }
  
  public boolean HasHiddenItems()
  {
    return (this._VisibleItems != null) && (this._VisibleItems.size() < this.Items.size());
  }
  
  public void HideReadItems()
  {
    int i = 0;
    Iterator localIterator = this.Items.iterator();
    if (!localIterator.hasNext()) {
      if (i != 0)
      {
        this._VisibleItems = new ArrayList();
        localIterator = this.Items.iterator();
      }
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        return;
        localRssFeedItem = (RssFeedItem)localIterator.next();
        if (localRssFeedItem.getRead()) {}
        for (boolean bool = false;; bool = true)
        {
          localRssFeedItem.Visible = bool;
          if (localRssFeedItem.Visible) {
            break;
          }
          i = 1;
          break;
        }
      }
      RssFeedItem localRssFeedItem = (RssFeedItem)localIterator.next();
      if (localRssFeedItem.Visible) {
        this._VisibleItems.add(localRssFeedItem);
      }
    }
  }
  
  public boolean IsOld()
  {
    if (this.LastRetrievalDate == null) {}
    for (;;)
    {
      return false;
      if (this.Ttl != null) {}
      for (int i = this.Ttl.intValue(); System.currentTimeMillis() - this.LastRetrievalDate.getTime() > i; i = 86400000) {
        return true;
      }
    }
  }
  
  public boolean IsSubscribedInGoogleReader()
  {
    return true;
  }
  
  public int NumUnreadItems()
  {
    int i = 0;
    Iterator localIterator = this.Items.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return i;
      }
      if (!((RssFeedItem)localIterator.next()).getRead()) {
        i += 1;
      }
    }
  }
  
  public void SetAllItemsAsRead()
  {
    SetItemsAsReadUnread(this.Items, true);
  }
  
  public void SetItemsAsReadUnread(List<RssFeedItem> paramList, boolean paramBoolean)
  {
    ItemStateHistory.SetItemsAsReadUnread(paramList, paramBoolean);
    SyncOwnerFeedReadStatus();
    if (Configuration.SetAsDownloadedOnMarkRead()) {
      SyncAllDownloadedWithRead();
    }
    if (Configuration.SetAsPlayedOnMarkRead()) {
      SyncAllPlayedWithRead();
    }
  }
  
  public void SyncAllDownloadedWithRead()
  {
    Iterator localIterator = this.Items.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((RssFeedItem)localIterator.next()).SyncDownloadedWithRead();
    }
  }
  
  public void SyncAllPlayedWithRead()
  {
    Iterator localIterator = this.Items.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((RssFeedItem)localIterator.next()).SyncPlayedWithRead();
    }
  }
  
  public void SyncOwnerFeedReadStatus()
  {
    Feed localFeed = FeedRepository.GetFeedById(this.FeedID);
    if (localFeed != null) {
      localFeed.setNumUnreadItems(NumUnreadItems());
    }
  }
  
  public int UnreadItemsCount()
  {
    int i = 0;
    Iterator localIterator = this.Items.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return i;
      }
      if (!((RssFeedItem)localIterator.next()).getRead()) {
        i += 1;
      }
    }
  }
  
  public int VisibleItemCount()
  {
    return VisibleItems().size();
  }
  
  public final ArrayList<RssFeedItem> VisibleItems()
  {
    if (this._VisibleItems != null) {
      return this._VisibleItems;
    }
    return this.Items;
  }
  
  public int getDaysOld()
  {
    if (this.LastRetrievalDate == null) {
      return 0;
    }
    return (int)(System.currentTimeMillis() - this.LastRetrievalDate.getTime()) / 86400000;
  }
  
  public String getFeedImageLink()
  {
    if (this.FeedImageLinks.containsKey("itunes")) {
      return (String)this.FeedImageLinks.get("itunes");
    }
    if (this.FeedImageLinks.containsKey("rss")) {
      return (String)this.FeedImageLinks.get("rss");
    }
    if (this.FeedImageLinks.containsKey("rssChildItem")) {
      return (String)this.FeedImageLinks.get("rssChildItem");
    }
    return null;
  }
  
  public Date getLatestItemPubDate()
  {
    Date localDate1 = null;
    Date localDate2 = null;
    if (this.Items.size() > 0) {
      localDate1 = ((RssFeedItem)this.Items.get(0)).PubDate();
    }
    if (this.Items.size() > 1) {
      localDate2 = ((RssFeedItem)this.Items.get(this.Items.size() - 1)).PubDate();
    }
    if ((localDate1 != null) && (localDate2 != null)) {
      if (!localDate1.after(localDate2)) {}
    }
    while (localDate1 != null)
    {
      return localDate1;
      return localDate2;
    }
    return localDate2;
  }
  
  public int peekEnclosureMediaTypes()
  {
    if (this.Items.size() == 0) {
      return -1;
    }
    int k = 0;
    int j = 0;
    int m = 0;
    label215:
    label220:
    for (;;)
    {
      int i2;
      int i;
      try
      {
        i2 = Math.min(this.Items.size(), 10);
        i = 0;
      }
      catch (Exception localException)
      {
        Object localObject;
        int i1;
        int n;
        boolean bool;
        return -1;
      }
      localObject = ((RssFeedItem)this.Items.get(i)).Enclosure();
      if (localObject != null)
      {
        i1 = MediaFile.getFileTypeForMimeType(((RssEnclosure)localObject).Type);
        n = i1;
        if (i1 == 0)
        {
          localObject = MediaFile.getFileType(((RssEnclosure)localObject).FileName());
          n = i1;
          if (localObject != null) {
            n = ((MediaFile.MediaFileType)localObject).fileType;
          }
        }
        if (MediaFile.isImageFileType(n))
        {
          k += 1;
        }
        else
        {
          if (!MediaFile.isAudioFileType(n))
          {
            bool = MediaFile.isVideoFileType(n);
            if (!bool) {}
          }
          else
          {
            j += 1;
            break label215;
          }
          m += 1;
          break label215;
          if ((k > 0) && (j == 0) && (m == 0)) {
            return 1;
          }
          if ((k == 0) && (j > 0) && (m == 0)) {
            return 2;
          }
          return 3;
        }
      }
      for (;;)
      {
        if (i != i2) {
          break label220;
        }
        if ((k != 0) || (j != 0) || (m != 0)) {
          break;
        }
        return 0;
        i += 1;
      }
    }
  }
  
  public void updateFingerprintAlgorithmTo(int paramInt)
  {
    this.ItemIDGenerationAlgorithm = paramInt;
    Iterator localIterator = this.Items.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((RssFeedItem)localIterator.next()).rebuildItemId();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/rss/entities/RssFeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */