package mobi.beyondpod.ui.views;

import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.TrackSorter;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.rss.LocalEnclosureSorter;
import mobi.beyondpod.rsscore.rss.RssFeedCache;
import mobi.beyondpod.rsscore.rss.entities.RssEnclosure;
import mobi.beyondpod.rsscore.rss.entities.RssFeed;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;
import mobi.beyondpod.rsscore.rss.parsers.FeedParseData;
import mobi.beyondpod.rsscore.rss.parsers.FeedParseData.ParseListener;
import mobi.beyondpod.ui.core.MasterViewState;
import mobi.beyondpod.ui.views.base.FeedContentListViewDataSourceEvents.FeedContentListViewDataSourceEvent;

public class FeedContentListViewDataSource
{
  private static final String TAG = FeedContentListViewDataSource.class.getSimpleName();
  private static CollectionChangedListener _CollectionListener;
  private static volatile Feed _CurrentFeed;
  private static volatile RssFeed _CurrentRssFeed;
  private static boolean _IsLoadingData = false;
  static ArrayList<RssFeedItem> _Items = new ArrayList();
  private static LoadListener _LoadListener;
  private static long _LoadStartTime = 0L;
  private static TrackList _OrphanedTracks = new TrackList();
  private static Exception _ParseException;
  static ArrayList<String> _SavedItemIds;
  static long _SavedItemIdsTimestamp;
  
  private static void AddItem(RssFeedItem paramRssFeedItem)
  {
    if (!_Items.contains(paramRssFeedItem))
    {
      paramRssFeedItem.Title = CoreHelper.cleanTitle(CoreHelper.htmlDecode(paramRssFeedItem.Title));
      paramRssFeedItem.ShortTaglessDescription();
      _Items.add(paramRssFeedItem);
    }
  }
  
  private static boolean AllowItemForCurrentFilter(RssFeedItem paramRssFeedItem, int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            bool = false;
            return bool;
          } while (paramRssFeedItem.getRead());
          return true;
        } while ((paramRssFeedItem.Enclosure() == null) || (paramRssFeedItem.Enclosure().GetLocalEnclosureTrack() == null));
        return true;
      } while (paramRssFeedItem.Enclosure() == null);
      paramRssFeedItem = paramRssFeedItem.Enclosure().GetLocalEnclosureTrack();
    } while ((paramRssFeedItem == null) || (!paramRssFeedItem.IsFullyDownloaded()));
    return true;
  }
  
  public static void ClearItems()
  {
    _Items.clear();
    _OrphanedTracks.clear();
    _CurrentFeed = null;
    _CurrentRssFeed = null;
    _SavedItemIds = null;
    if (_CollectionListener != null) {
      _CollectionListener.OnCollectionChanged();
    }
  }
  
  public static Feed CurrentFeed()
  {
    return _CurrentFeed;
  }
  
  public static boolean CurrentFeedHasDownloadedEpisodes()
  {
    if (_CurrentFeed == null) {}
    Iterator localIterator;
    do
    {
      while (!localIterator.hasNext())
      {
        return false;
        localIterator = _CurrentFeed.Tracks().iterator();
      }
    } while (!((Track)localIterator.next()).IsFullyDownloaded());
    return true;
  }
  
  public static boolean CurrentFeedHasLocalEpisodes()
  {
    if (_CurrentFeed == null) {
      return false;
    }
    return _CurrentFeed.HasPodcasts();
  }
  
  public static boolean CurrentFeedHasReadItems()
  {
    if (_CurrentRssFeed == null) {}
    RssFeedItem localRssFeedItem;
    do
    {
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        return false;
        localIterator = _CurrentRssFeed.Items.iterator();
      }
      localRssFeedItem = (RssFeedItem)localIterator.next();
    } while ((!localRssFeedItem.getRead()) || (localRssFeedItem.IsMockItem().booleanValue()));
    return true;
  }
  
  private static long CurrentFeedTimeStamp()
  {
    if (_CurrentFeed == null) {}
    Date localDate;
    do
    {
      return 0L;
      localDate = RssFeedCache.GetCachedFileDate(_CurrentFeed.getFeedUri());
    } while (localDate == null);
    return localDate.getTime();
  }
  
  public static int CurrentFeedUnreadItemsCount()
  {
    int j;
    if (_CurrentRssFeed == null)
    {
      j = 0;
      return j;
    }
    int i = 0;
    Iterator localIterator = _CurrentRssFeed.Items.iterator();
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
      RssFeedItem localRssFeedItem = (RssFeedItem)localIterator.next();
      if ((!localRssFeedItem.getRead()) && (!localRssFeedItem.IsMockItem().booleanValue())) {
        i += 1;
      }
    }
  }
  
  public static RssFeed CurrentRssFeed()
  {
    return _CurrentRssFeed;
  }
  
  public static void FilterItems(int paramInt)
  {
    _Items.clear();
    Iterator localIterator = CurrentRssFeed().Items.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        MergeOrphanEpisodesForFeed(false);
        if (_CollectionListener != null) {
          _CollectionListener.OnCollectionChanged();
        }
        return;
      }
      RssFeedItem localRssFeedItem = (RssFeedItem)localIterator.next();
      if (AllowItemForCurrentFilter(localRssFeedItem, _CurrentFeed.getItemFilter())) {
        AddItem(localRssFeedItem);
      }
    }
  }
  
  private static ArrayList<RssFeedItem> FindAllMockRssItems()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = _Items.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localArrayList;
      }
      RssFeedItem localRssFeedItem = (RssFeedItem)localIterator.next();
      if (localRssFeedItem.IsMockItem().booleanValue()) {
        localArrayList.add(localRssFeedItem);
      }
    }
  }
  
  public static RssFeedItem GetItemById(String paramString)
  {
    Iterator localIterator = Items().iterator();
    RssFeedItem localRssFeedItem;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localRssFeedItem = (RssFeedItem)localIterator.next();
    } while (!paramString.equals(localRssFeedItem.ItemID()));
    return localRssFeedItem;
  }
  
  public static RssFeedItem GetNextPrevItem(int paramInt, RssFeedItem paramRssFeedItem)
  {
    paramInt = _Items.indexOf(paramRssFeedItem) + paramInt;
    if ((paramInt < 0) || (paramInt > _Items.size() - 1)) {
      return null;
    }
    return (RssFeedItem)_Items.get(paramInt);
  }
  
  public static boolean HasEnclosures()
  {
    if (_CurrentRssFeed == null) {}
    Iterator localIterator;
    do
    {
      while (!localIterator.hasNext())
      {
        return false;
        localIterator = Items().iterator();
      }
    } while (((RssFeedItem)localIterator.next()).Enclosure() == null);
    return true;
  }
  
  public static boolean HasHiddenItems()
  {
    return VisibleItemCount() != TotalItemCount();
  }
  
  public static boolean HasReadItems()
  {
    if (_CurrentRssFeed == null) {}
    RssFeedItem localRssFeedItem;
    do
    {
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        return false;
        localIterator = Items().iterator();
      }
      localRssFeedItem = (RssFeedItem)localIterator.next();
    } while ((!localRssFeedItem.getRead()) || (localRssFeedItem.IsMockItem().booleanValue()));
    return true;
  }
  
  public static boolean HasUnReadItems()
  {
    if (_CurrentRssFeed == null) {}
    RssFeedItem localRssFeedItem;
    do
    {
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        return false;
        localIterator = Items().iterator();
      }
      localRssFeedItem = (RssFeedItem)localIterator.next();
    } while ((localRssFeedItem.getRead()) || (localRssFeedItem.IsMockItem().booleanValue()));
    return true;
  }
  
  public static void HideReadItems()
  {
    _Items.clear();
    Iterator localIterator = CurrentRssFeed().Items.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        MergeOrphanEpisodesForFeed(false);
        if (_CollectionListener != null) {
          _CollectionListener.OnCollectionChanged();
        }
        return;
      }
      RssFeedItem localRssFeedItem = (RssFeedItem)localIterator.next();
      if (!localRssFeedItem.getRead()) {
        AddItem(localRssFeedItem);
      }
    }
  }
  
  public static boolean IsDataLoaded()
  {
    return (_CurrentRssFeed != null) && (!_IsLoadingData);
  }
  
  public static boolean IsEmpty()
  {
    return _Items.size() == 0;
  }
  
  public static boolean IsEpisodeOnlyFilter(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3);
  }
  
  public static boolean IsLoadingData()
  {
    return _IsLoadingData;
  }
  
  public static ArrayList<RssFeedItem> Items()
  {
    return _Items;
  }
  
  public static void LoadItems(Feed paramFeed, boolean paramBoolean)
  {
    if (_IsLoadingData) {}
    do
    {
      return;
      if ((_CurrentFeed == null) || (_CurrentFeed != paramFeed) || (_CurrentFeed.HasNewContent()) || (!IsDataLoaded())) {
        paramBoolean = true;
      }
      if ((_SavedItemIds != null) && ((_CurrentFeed != paramFeed) || (_SavedItemIdsTimestamp != CurrentFeedTimeStamp()))) {
        _SavedItemIds = null;
      }
      boolean bool = paramBoolean;
      if (paramFeed.NumUnreadItems() > 0)
      {
        bool = paramBoolean;
        if (_Items.size() == 0)
        {
          bool = paramBoolean;
          if (!paramFeed.HasNewContent()) {
            bool = true;
          }
        }
      }
      if (bool)
      {
        new LoadFeedContentAsync().execute(new Feed[] { paramFeed });
        return;
      }
    } while (_LoadListener == null);
    _LoadListener.OnLoadStarted();
    _LoadListener.OnLoadCompleted(IsDataLoaded());
  }
  
  private static void MergeOrphanEpisodesForFeed(boolean paramBoolean)
  {
    if (_CurrentFeed.Tracks().size() == 0)
    {
      _OrphanedTracks.clear();
      return;
    }
    if (paramBoolean) {
      RefreshOrphanedTracks();
    }
    Iterator localIterator = _OrphanedTracks.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        SortLocalEpisodesIfNeeded();
        return;
      }
      Track localTrack = (Track)localIterator.next();
      if (((_CurrentFeed.getItemFilter() != 3) || (localTrack.IsFullyDownloaded())) && ((_CurrentFeed.getItemFilter() != 1) || (!localTrack.IsPlayed()))) {
        AddItem(RssFeedItem.BuildMockRssItem(_CurrentFeed, _CurrentRssFeed, localTrack));
      }
    }
  }
  
  public static void RefreshOrphanEpisodesForFeed()
  {
    _Items.removeAll(FindAllMockRssItems());
    MergeOrphanEpisodesForFeed(true);
    if (_CollectionListener != null) {
      _CollectionListener.OnCollectionChanged();
    }
  }
  
  private static void RefreshOrphanedTracks()
  {
    _OrphanedTracks = (TrackList)_CurrentFeed.Tracks().clone();
    Iterator localIterator = _CurrentRssFeed.Items.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        Collections.sort(_OrphanedTracks, new TrackSorter(_CurrentFeed.getLocalOrInheritedTrackSortOrder()));
        return;
      }
      Object localObject = (RssFeedItem)localIterator.next();
      if ((((RssFeedItem)localObject).Enclosure() != null) && (!((RssFeedItem)localObject).IsMockItem().booleanValue()))
      {
        localObject = _CurrentFeed.Tracks().GetTrackByNameOrUrl(((RssFeedItem)localObject).Enclosure().FileName(), ((RssFeedItem)localObject).Enclosure().Url);
        if (localObject != null) {
          _OrphanedTracks.remove(localObject);
        }
      }
    }
  }
  
  public static void RestoreCurrentState(MasterViewState paramMasterViewState)
  {
    _CurrentFeed = paramMasterViewState.ContentViewFeed;
    _SavedItemIds = paramMasterViewState.FeedContentItemIds;
    _SavedItemIdsTimestamp = paramMasterViewState.FeedContentItemIdsTimeStamp;
    if ((paramMasterViewState.FeedContentRssFeed != null) && (paramMasterViewState.FeedContentItems != null))
    {
      _Items = paramMasterViewState.FeedContentItems;
      _CurrentRssFeed = paramMasterViewState.FeedContentRssFeed;
    }
  }
  
  public static void SaveCurrentState(MasterViewState paramMasterViewState)
  {
    paramMasterViewState.ContentViewFeed = _CurrentFeed;
    paramMasterViewState.FeedContentItems = _Items;
    paramMasterViewState.FeedContentRssFeed = _CurrentRssFeed;
    paramMasterViewState.FeedContentItemIdsTimeStamp = CurrentFeedTimeStamp();
  }
  
  public static void ShowAllReadItems()
  {
    _Items.clear();
    Iterator localIterator = CurrentRssFeed().Items.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        MergeOrphanEpisodesForFeed(false);
        if (_CollectionListener != null) {
          _CollectionListener.OnCollectionChanged();
        }
        return;
      }
      AddItem((RssFeedItem)localIterator.next());
    }
  }
  
  private static void SortLocalEpisodesIfNeeded()
  {
    if (!IsEpisodeOnlyFilter(_CurrentFeed.getItemFilter())) {
      return;
    }
    Collections.sort(_Items, new LocalEnclosureSorter(_CurrentFeed.getLocalOrInheritedTrackSortOrder()));
  }
  
  public static int TotalItemCount()
  {
    if (_CurrentRssFeed != null) {}
    for (int i = _CurrentRssFeed.Items.size();; i = 0) {
      return i + _OrphanedTracks.size();
    }
  }
  
  public static int UnreadItemsCount()
  {
    int i = 0;
    Iterator localIterator = Items().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return i;
      }
      RssFeedItem localRssFeedItem = (RssFeedItem)localIterator.next();
      if ((!localRssFeedItem.getRead()) && (!localRssFeedItem.IsMockItem().booleanValue())) {
        i += 1;
      }
    }
  }
  
  public static int VisibleItemCount()
  {
    return _Items.size();
  }
  
  public static void setCollectionChangedListener(CollectionChangedListener paramCollectionChangedListener)
  {
    _CollectionListener = paramCollectionChangedListener;
  }
  
  public static void setLoadListener(LoadListener paramLoadListener)
  {
    _LoadListener = paramLoadListener;
  }
  
  public static abstract interface CollectionChangedListener
  {
    public abstract void OnCollectionChanged();
  }
  
  private static class LoadFeedContentAsync
    extends AsyncTask<Feed, RssFeedItem, Void>
  {
    FeedParseData data = new FeedParseData(0);
    
    LoadFeedContentAsync()
    {
      this.data.setParseListener(new FeedParseData.ParseListener()
      {
        public void OnItemParsed(RssFeedItem paramAnonymousRssFeedItem)
        {
          FeedContentListViewDataSource.LoadFeedContentAsync.this.publishProgress(new RssFeedItem[] { paramAnonymousRssFeedItem });
        }
        
        public void OnParseCompleted(RssFeed paramAnonymousRssFeed) {}
        
        public void OnParseStarted(RssFeed paramAnonymousRssFeed) {}
      });
    }
    
    private void AddItemIfNeeded(RssFeedItem paramRssFeedItem)
    {
      if (FeedContentListViewDataSource._SavedItemIds == null) {
        if (FeedContentListViewDataSource.AllowItemForCurrentFilter(paramRssFeedItem, FeedContentListViewDataSource._CurrentFeed.getItemFilter())) {
          FeedContentListViewDataSource.AddItem(paramRssFeedItem);
        }
      }
      while (!FeedContentListViewDataSource._SavedItemIds.contains(paramRssFeedItem.ItemID())) {
        return;
      }
      FeedContentListViewDataSource.AddItem(paramRssFeedItem);
    }
    
    private boolean AllowAddOnProgress()
    {
      return (FeedContentListViewDataSource._CurrentFeed != null) && (FeedContentListViewDataSource._CurrentFeed.getForceFeedItemSort() == -1) && (!FeedContentListViewDataSource.IsEpisodeOnlyFilter(FeedContentListViewDataSource._CurrentFeed.getItemFilter()));
    }
    
    public Void doInBackground(Feed... paramVarArgs)
    {
      FeedContentListViewDataSource._CurrentFeed = paramVarArgs[0];
      FeedContentListViewDataSource._ParseException = null;
      FeedContentListViewDataSource._CurrentRssFeed = null;
      try
      {
        if (FeedContentListViewDataSource._CurrentFeed != null) {
          if (FeedContentListViewDataSource._CurrentFeed.HasUrl())
          {
            RssFeedCache.LoadFromCache(FeedContentListViewDataSource._CurrentFeed, this.data);
            if (this.data.HasParseFailed()) {
              FeedContentListViewDataSource._ParseException = this.data.ParseException;
            }
            if ((FeedContentListViewDataSource._ParseException == null) && (this.data.RssFeed != null) && (FeedParseData.IsRssFeedType(this.data.ParsedFeedType))) {
              FeedContentListViewDataSource._CurrentRssFeed = this.data.RssFeed;
            }
            if (FeedContentListViewDataSource._CurrentRssFeed != null)
            {
              FeedContentListViewDataSource._CurrentRssFeed.SyncOwnerFeedReadStatus();
              FeedContentListViewDataSource._CurrentFeed.setHasNewContent(false);
              return null;
            }
          }
          else
          {
            FeedContentListViewDataSource._CurrentRssFeed = new RssFeed();
            FeedContentListViewDataSource._CurrentRssFeed.FeedID = FeedContentListViewDataSource._CurrentFeed.ID();
            return null;
          }
        }
      }
      catch (Exception paramVarArgs)
      {
        FeedContentListViewDataSource._CurrentRssFeed = null;
        FeedContentListViewDataSource._ParseException = paramVarArgs;
      }
      return null;
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      if ((FeedContentListViewDataSource._CurrentFeed != null) && (FeedContentListViewDataSource._CurrentRssFeed != null)) {
        if (!AllowAddOnProgress()) {
          paramVoid = FeedContentListViewDataSource._CurrentRssFeed.Items.iterator();
        }
      }
      for (;;)
      {
        if (!paramVoid.hasNext())
        {
          FeedContentListViewDataSource.MergeOrphanEpisodesForFeed(true);
          FeedContentListViewDataSource._IsLoadingData = false;
          CoreHelper.WriteTraceEntry(FeedContentListViewDataSource.TAG, "Loaded " + FeedContentListViewDataSource._Items.size() + " items in " + (System.currentTimeMillis() - FeedContentListViewDataSource._LoadStartTime) + " ms.");
          FeedContentListViewDataSource._SavedItemIds = null;
          FeedContentListViewDataSource._SavedItemIdsTimestamp = -1L;
          if (FeedContentListViewDataSource._LoadListener != null) {
            FeedContentListViewDataSource._LoadListener.OnLoadCompleted(FeedContentListViewDataSource.IsDataLoaded());
          }
          if (FeedContentListViewDataSource._CollectionListener != null) {
            FeedContentListViewDataSource._CollectionListener.OnCollectionChanged();
          }
          BeyondPodApplication.MessageBus.PublishEvent(new FeedContentListViewDataSourceEvents.FeedContentListViewDataSourceEvent(FeedContentListViewDataSource.class, FeedContentListViewDataSourceEvents.FeedContentListViewDataSourceEvent.LOAD_COMPLETED));
          return;
        }
        AddItemIfNeeded((RssFeedItem)paramVoid.next());
      }
    }
    
    protected void onPreExecute()
    {
      FeedContentListViewDataSource._Items.clear();
      if (FeedContentListViewDataSource._CollectionListener != null) {
        FeedContentListViewDataSource._CollectionListener.OnCollectionChanged();
      }
      FeedContentListViewDataSource._IsLoadingData = true;
      FeedContentListViewDataSource._LoadStartTime = System.currentTimeMillis();
      if (FeedContentListViewDataSource._LoadListener != null) {
        FeedContentListViewDataSource._LoadListener.OnLoadStarted();
      }
    }
    
    protected void onProgressUpdate(RssFeedItem... paramVarArgs)
    {
      if (AllowAddOnProgress()) {
        AddItemIfNeeded(paramVarArgs[0]);
      }
      if (FeedContentListViewDataSource._LoadListener != null) {
        FeedContentListViewDataSource._LoadListener.OnLoadProgress();
      }
    }
  }
  
  public static abstract interface LoadListener
  {
    public abstract void OnLoadCompleted(boolean paramBoolean);
    
    public abstract void OnLoadProgress();
    
    public abstract void OnLoadStarted();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/FeedContentListViewDataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */