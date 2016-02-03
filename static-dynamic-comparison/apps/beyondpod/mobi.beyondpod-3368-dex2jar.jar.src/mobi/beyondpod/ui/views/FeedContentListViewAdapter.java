package mobi.beyondpod.ui.views;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.rss.entities.RssEnclosure;
import mobi.beyondpod.rsscore.rss.entities.RssFeed;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;
import mobi.beyondpod.ui.core.MasterViewState;

public class FeedContentListViewAdapter
  extends BaseAdapter
{
  private static final String TAG = FeedContentListViewAdapter.class.getSimpleName();
  static int _CalculatedPageSize;
  static long _LastParseDuration;
  static Exception _ParseException;
  private boolean _IsLoadingData = false;
  FeedContentListViewItemBuilder _ItemBuilder;
  private int _NumItems = 0;
  FeedContentListView _Owner;
  ArrayList<String> _SavedItemIds;
  
  public FeedContentListViewAdapter(Context paramContext, FeedContentListView paramFeedContentListView)
  {
    this._ItemBuilder = new FeedContentListViewItemBuilder(paramFeedContentListView);
    this._Owner = paramFeedContentListView;
  }
  
  private void PrefetchImageFor(int paramInt)
  {
    Object localObject = getItemAt(paramInt);
    RssEnclosure localRssEnclosure;
    if (localObject != null)
    {
      localRssEnclosure = ((RssFeedItem)localObject).Enclosure();
      if (localRssEnclosure != null) {
        break label28;
      }
      this._ItemBuilder.prefetchPostImage((RssFeedItem)localObject);
    }
    label28:
    do
    {
      return;
      localObject = localRssEnclosure.GetLocalEnclosureTrack();
    } while (localObject == null);
    this._ItemBuilder.prefetchEpisodeImage((Track)localObject);
  }
  
  public void ClearItems()
  {
    FeedContentListViewDataSource.ClearItems();
    OnDataSourceChanged();
  }
  
  Feed CurrentFeed()
  {
    return FeedContentListViewDataSource.CurrentFeed();
  }
  
  public boolean CurrentFeedHasDownloadedEpisodes()
  {
    return FeedContentListViewDataSource.CurrentFeedHasDownloadedEpisodes();
  }
  
  public boolean CurrentFeedHasLocalEpisodes()
  {
    return FeedContentListViewDataSource.CurrentFeedHasLocalEpisodes();
  }
  
  public boolean CurrentFeedHasReadItems()
  {
    return FeedContentListViewDataSource.CurrentFeedHasReadItems();
  }
  
  RssFeed CurrentRssFeed()
  {
    return FeedContentListViewDataSource.CurrentRssFeed();
  }
  
  public void FilterItems(int paramInt)
  {
    if (FeedContentListViewDataSource.CurrentRssFeed() == null) {
      return;
    }
    FeedContentListViewDataSource.FilterItems(paramInt);
    this._Owner.RefreshActivityTitle();
    this._Owner.UpdateFooterToolbar();
    OnDataSourceChanged();
  }
  
  public List<Track> GeneratePlaylist(Track paramTrack)
  {
    TrackList localTrackList1 = new TrackList();
    int i = 0;
    TrackList localTrackList2 = CurrentFeed().Tracks();
    Iterator localIterator = FeedContentListViewDataSource.Items().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localTrackList1;
      }
      Object localObject = (RssFeedItem)localIterator.next();
      if (((RssFeedItem)localObject).Enclosure() != null)
      {
        localObject = localTrackList2.GetTrackByNameOrUrl(((RssFeedItem)localObject).Enclosure().FileName(), ((RssFeedItem)localObject).Enclosure().Url);
        if (localObject != null)
        {
          int j;
          if (paramTrack != null)
          {
            j = i;
            if (!paramTrack.equals(localObject)) {}
          }
          else
          {
            j = 1;
          }
          i = j;
          if (j != 0)
          {
            i = j;
            if (!((Track)localObject).IsPlayed())
            {
              localTrackList1.add(localObject);
              i = j;
            }
          }
        }
      }
    }
  }
  
  public boolean HasEnclosures()
  {
    return FeedContentListViewDataSource.HasEnclosures();
  }
  
  boolean HasHiddenItems()
  {
    return FeedContentListViewDataSource.HasHiddenItems();
  }
  
  boolean HasReadItems()
  {
    return FeedContentListViewDataSource.HasReadItems();
  }
  
  boolean HasUnReadItems()
  {
    return FeedContentListViewDataSource.HasUnReadItems();
  }
  
  boolean IsLoadingData()
  {
    return this._IsLoadingData;
  }
  
  public void LoadDefaultFontSize()
  {
    this._ItemBuilder.LoadDefaultFontSize();
  }
  
  public void LoadItems(Feed paramFeed, boolean paramBoolean)
  {
    FeedContentListViewDataSource.LoadItems(paramFeed, paramBoolean);
  }
  
  public int MarkAllScrolledUnreadItemsToPosAsRead(int paramInt)
  {
    int k;
    if (paramInt < 0)
    {
      k = 0;
      return k;
    }
    int i = 0;
    int j = 0;
    for (;;)
    {
      k = i;
      if (j == paramInt) {
        break;
      }
      RssFeedItem localRssFeedItem = getItemAt(j);
      k = i;
      if (localRssFeedItem != null)
      {
        k = i;
        if (!localRssFeedItem.getRead())
        {
          localRssFeedItem.setRead(true);
          k = i + 1;
        }
      }
      j += 1;
      i = k;
    }
  }
  
  public int NumberOfScrolledUnreadItems()
  {
    int k;
    if ((this._Owner.FirstVisibleItemPosition() == 0) || (FeedContentListViewDataSource.IsEmpty()))
    {
      k = 0;
      return k;
    }
    int i = 0;
    int j = 0;
    for (;;)
    {
      k = i;
      if (j == this._Owner.FirstVisibleItemPosition()) {
        break;
      }
      RssFeedItem localRssFeedItem = getItemAt(j);
      k = i;
      if (localRssFeedItem != null)
      {
        k = i;
        if (!localRssFeedItem.getRead()) {
          k = i + 1;
        }
      }
      j += 1;
      i = k;
    }
  }
  
  public void OnAfterActivate()
  {
    FeedContentListViewDataSource.setLoadListener(new FeedContentListViewDataSource.LoadListener()
    {
      public void OnLoadCompleted(boolean paramAnonymousBoolean)
      {
        FeedContentListViewAdapter.this._IsLoadingData = false;
        FeedContentListViewAdapter.this.OnDataSourceChanged();
        FeedContentListViewAdapter.this._Owner.OnAdapterDataLoadCompleted(paramAnonymousBoolean);
      }
      
      public void OnLoadProgress()
      {
        int j = FeedContentListViewDataSource.Items().size();
        if (j > 0) {
          if (j >= 20) {
            break label33;
          }
        }
        label33:
        for (int i = 5;; i = 40)
        {
          if (j % i == 0) {
            FeedContentListViewAdapter.this.OnDataSourceChanged();
          }
          return;
        }
      }
      
      public void OnLoadStarted()
      {
        FeedContentListViewAdapter.this._ItemBuilder.LoadDefaultFontSize();
        FeedContentListViewAdapter.this._IsLoadingData = true;
        FeedContentListViewAdapter.this.OnDataSourceChanged();
        FeedContentListViewAdapter.this._Owner.OnAdapterDataLoadStarted();
      }
    });
  }
  
  public void OnAfterDeactivate()
  {
    FeedContentListViewDataSource.setLoadListener(null);
  }
  
  void OnDataSourceChanged()
  {
    this._NumItems = FeedContentListViewDataSource.Items().size();
    FeedContentListView localFeedContentListView = this._Owner;
    if (this._NumItems > 250) {}
    for (boolean bool = true;; bool = false)
    {
      localFeedContentListView.FastScrollEnabled(bool);
      notifyDataSetChanged();
      return;
    }
  }
  
  void PrefetchItemImages()
  {
    int i = Math.min(this._Owner.NumberOfItemsPerScreen(), 5);
    int j = Math.min(this._Owner.NumberOfItemsPerScreen() * 2, i * 2);
    i = Math.max(this._Owner.FirstVisibleItemPosition() - i, 0);
    int k = this._Owner.FirstVisibleItemPosition();
    if ((i >= 0) && (i < k))
    {
      if (i < k) {}
    }
    else
    {
      i = this._Owner.FirstVisibleItemPosition() + this._Owner.NumberOfItemsPerScreen() - 1;
      j = Math.min(i + j, getCount());
      if (i >= j) {}
    }
    for (;;)
    {
      if (i >= j)
      {
        return;
        PrefetchImageFor(i);
        i += 1;
        break;
      }
      PrefetchImageFor(i);
      i += 1;
    }
  }
  
  public void Refresh()
  {
    OnDataSourceChanged();
  }
  
  public void RefreshOrphanEpisodesForFeed() {}
  
  public void RestoreCurrentState(MasterViewState paramMasterViewState)
  {
    FeedContentListViewDataSource.RestoreCurrentState(paramMasterViewState);
  }
  
  public void RestoreItemsAfterConfigurationChange()
  {
    if (FeedContentListViewDataSource.CurrentRssFeed() != null)
    {
      this._Owner.OnAdapterDataLoadStarted();
      OnDataSourceChanged();
      if (!FeedContentListViewDataSource.IsLoadingData()) {
        this._Owner.OnAdapterDataLoadCompleted(FeedContentListViewDataSource.IsDataLoaded());
      }
      return;
    }
    if (FeedContentListViewDataSource.CurrentFeed() != null)
    {
      FeedContentListViewDataSource.LoadItems(FeedContentListViewDataSource.CurrentFeed(), true);
      return;
    }
    CoreHelper.WriteLogEntry(TAG, "Trying to call FeedContentListViewDataSource.LoadItems with NULL feed");
  }
  
  public void SaveCurrentState(MasterViewState paramMasterViewState)
  {
    FeedContentListViewDataSource.SaveCurrentState(paramMasterViewState);
  }
  
  public boolean SupportsItemImages()
  {
    return (this._ItemBuilder.SupportsItemImages()) && (Configuration.ShowContentListPostImages());
  }
  
  void ToggleReadItems(boolean paramBoolean)
  {
    if (FeedContentListViewDataSource.CurrentRssFeed() == null) {
      return;
    }
    if (paramBoolean) {
      FeedContentListViewDataSource.ShowAllReadItems();
    }
    for (;;)
    {
      this._Owner.RefreshActivityTitle();
      this._Owner.UpdateFooterToolbar();
      OnDataSourceChanged();
      return;
      FeedContentListViewDataSource.HideReadItems();
    }
  }
  
  public boolean areAllItemsSelectable()
  {
    return false;
  }
  
  public int getCount()
  {
    if (this._NumItems > 0) {
      return this._NumItems;
    }
    return 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < FeedContentListViewDataSource.Items().size()) {
      return FeedContentListViewDataSource.Items().get(paramInt);
    }
    return null;
  }
  
  public RssFeedItem getItemAt(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if (localObject != null) {
      return (RssFeedItem)localObject;
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (FeedContentListViewDataSource.Items().size() == 0) {}
    RssFeedItem localRssFeedItem;
    do
    {
      return -1;
      localRssFeedItem = getItemAt(paramInt);
    } while (localRssFeedItem == null);
    if (localRssFeedItem.Enclosure() == null) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (FeedContentListViewDataSource.IsEmpty())
    {
      paramView = this._ItemBuilder;
      boolean bool2 = this._IsLoadingData;
      boolean bool3 = HasHiddenItems();
      if (this._Owner.IsHeaderViewVisible()) {}
      for (boolean bool1 = false;; bool1 = true) {
        return paramView.BuildEmptyView(bool2, bool3, bool1);
      }
    }
    FeedContentListViewItemBuilder localFeedContentListViewItemBuilder = this._ItemBuilder;
    if (paramInt > 0) {}
    for (paramViewGroup = getItemAt(paramInt - 1);; paramViewGroup = null) {
      return localFeedContentListViewItemBuilder.BuildViewFor(paramViewGroup, getItemAt(paramInt), paramView, CurrentFeed());
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/FeedContentListViewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */