package mobi.beyondpod.ui.views;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.FeedSorter;
import mobi.beyondpod.rsscore.categories.CategoryList;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategories;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.repository.FeedRepository;

public class FeedListViewDataSource
{
  private int _FeedCount;
  private int _HiddenFeedCount;
  private ArrayList<ListDataItem> _Items = new ArrayList();
  
  void Clear()
  {
    this._Items.clear();
    this._FeedCount = 0;
    this._HiddenFeedCount = 0;
  }
  
  public int FeedCount()
  {
    return this._FeedCount;
  }
  
  public void FilterAndGroupByFirstCategory(Feed paramFeed1, boolean paramBoolean, Feed paramFeed2)
  {
    HashMap localHashMap = new HashMap();
    Object localObject2 = Configuration.getActiveFeedCategory();
    Object localObject3 = paramFeed1.SubFeeds().iterator();
    Object localObject1;
    if (!((Iterator)localObject3).hasNext())
    {
      localObject1 = new ArrayList();
      localObject2 = CategoryManager.GetCategoriesForFeedsList().iterator();
      label50:
      if (((Iterator)localObject2).hasNext()) {
        break label234;
      }
      localObject2 = new FeedSorter(Configuration.getFeedsSortOrder());
      localObject3 = ((ArrayList)localObject1).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject3).hasNext())
      {
        if (this._FeedCount == 0) {
          this._Items.add(new ListDataItem(null, null));
        }
        if (paramFeed1.CanNavigateUp()) {
          this._Items.add(0, new ListDataItem(null, FeedRepository.getGoUpPlaceholder()));
        }
        return;
        localObject4 = (Feed)((Iterator)localObject3).next();
        if (!CategoryManager.IsInCategory((Feed)localObject4, (FeedCategory)localObject2)) {
          break;
        }
        if (((FeedCategory)localObject2).equals(CategoryManager.AllFeeds)) {}
        for (localObject1 = ((Feed)localObject4).getCategories().getPrimary();; localObject1 = localObject2)
        {
          if (!localHashMap.containsKey(localObject1)) {
            localHashMap.put(localObject1, new FeedList());
          }
          ((FeedList)localHashMap.get(localObject1)).add(localObject4);
          break;
        }
        label234:
        localObject3 = (FeedCategory)((Iterator)localObject2).next();
        if (!localHashMap.keySet().contains(localObject3)) {
          break label50;
        }
        ((ArrayList)localObject1).add(localObject3);
        break label50;
      }
      Object localObject4 = (FeedCategory)((Iterator)localObject3).next();
      if (((ArrayList)localObject1).size() > 1) {
        this._Items.add(new ListDataItem(((FeedCategory)localObject4).Name(), null));
      }
      Collections.sort((FeedList)localHashMap.get(localObject4), (Comparator)localObject2);
      localObject4 = ((FeedList)localHashMap.get(localObject4)).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        Feed localFeed = (Feed)((Iterator)localObject4).next();
        if ((!paramBoolean) || (localFeed.MayHaveUnreadItems()) || ((paramFeed2 != null) && (localFeed == paramFeed2)))
        {
          this._Items.add(new ListDataItem(null, localFeed));
          this._FeedCount += 1;
        }
        else
        {
          this._HiddenFeedCount += 1;
        }
      }
    }
  }
  
  public ListDataItem GetAtPosition(int paramInt)
  {
    if (paramInt < size()) {
      return (ListDataItem)this._Items.get(paramInt);
    }
    return null;
  }
  
  public int GetFeedIndex(Feed paramFeed)
  {
    int i = 0;
    Iterator localIterator = this._Items.iterator();
    for (;;)
    {
      int j;
      if (!localIterator.hasNext()) {
        j = -1;
      }
      ListDataItem localListDataItem;
      do
      {
        return j;
        localListDataItem = (ListDataItem)localIterator.next();
        if (localListDataItem.Feed == null) {
          break;
        }
        j = i;
      } while (localListDataItem.Feed.equals(paramFeed));
      i += 1;
    }
  }
  
  public int GetFeedPosition(Feed paramFeed)
  {
    int i = -1;
    Iterator localIterator = this._Items.iterator();
    ListDataItem localListDataItem;
    int j;
    do
    {
      do
      {
        if (!localIterator.hasNext()) {
          return -1;
        }
        localListDataItem = (ListDataItem)localIterator.next();
        j = i + 1;
        i = j;
      } while (localListDataItem.Feed == null);
      i = j;
    } while (localListDataItem.Feed != paramFeed);
    return j;
  }
  
  public FeedList GetFeeds()
  {
    FeedList localFeedList = new FeedList();
    Iterator localIterator = this._Items.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localFeedList;
      }
      ListDataItem localListDataItem = (ListDataItem)localIterator.next();
      if (localListDataItem.Feed != null) {
        localFeedList.add(localListDataItem.Feed);
      }
    }
  }
  
  public boolean HasHiddenReadFeeds()
  {
    return this._HiddenFeedCount > 0;
  }
  
  public boolean HasReadFeeds()
  {
    Iterator localIterator = this._Items.iterator();
    ListDataItem localListDataItem;
    do
    {
      if (!localIterator.hasNext()) {
        return false;
      }
      localListDataItem = (ListDataItem)localIterator.next();
    } while ((localListDataItem.Feed == null) || (localListDataItem.Feed.MayHaveUnreadItems()));
    return true;
  }
  
  public int HiddenFeedCount()
  {
    return this._HiddenFeedCount;
  }
  
  public int size()
  {
    return this._Items.size();
  }
  
  public static class ListDataItem
  {
    public Feed Feed;
    public String Name;
    
    public ListDataItem(String paramString, Feed paramFeed)
    {
      this.Name = paramString;
      this.Feed = paramFeed;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/FeedListViewDataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */