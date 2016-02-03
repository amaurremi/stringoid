package mobi.beyondpod.ui.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader.ImageContainer;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import java.util.Formatter;
import java.util.Locale;
import mobi.beyondpod.R.styleable;
import mobi.beyondpod.downloadengine.EnclosureDownloadManager;
import mobi.beyondpod.downloadengine.RssFeedUpdateManager;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.ui.core.FeedImageCache;
import mobi.beyondpod.ui.core.volley.FadingNetworkImageViewFeed;
import mobi.beyondpod.ui.core.volley.ImageLoaderFeed;

public class FeedsViewAdapter
  extends BaseAdapter
{
  private static final String BACK_TO_PARENT;
  private static final String DOWNLOADING;
  private static final String FEEDS = CoreHelper.LoadResourceString(2131296978);
  private static final String OF;
  private static final String S_PENDING = CoreHelper.LoadResourceString(2131296981);
  private static final String TAG;
  private static final String UNREAD;
  private static final String UPDATING;
  private static Formatter sInfoTextFormatter = new Formatter(sInfoTextStringBuilder, Locale.getDefault());
  private static StringBuilder sInfoTextStringBuilder;
  private FeedListViewDataSource _DataSource = new FeedListViewDataSource();
  private Feed _Feed;
  private CharSequence _IfEmptyText;
  private int _ImageHeight = 70;
  private int _ImageWidth = 70;
  private LayoutInflater _Inflater;
  private FeedsListView _Owner;
  private ColorStateList _PrimaryColor;
  private ColorStateList _PrimaryReadColor;
  
  static
  {
    DOWNLOADING = CoreHelper.LoadResourceString(2131296982);
    OF = CoreHelper.LoadResourceString(2131296983);
    UPDATING = CoreHelper.LoadResourceString(2131296984);
    BACK_TO_PARENT = CoreHelper.LoadResourceString(2131296986);
    UNREAD = CoreHelper.LoadResourceString(2131296985);
    TAG = FeedsViewAdapter.class.getSimpleName();
    sInfoTextStringBuilder = new StringBuilder();
  }
  
  public FeedsViewAdapter(Context paramContext, FeedsListView paramFeedsListView)
  {
    this._Inflater = LayoutInflater.from(paramContext);
    this._Owner = paramFeedsListView;
    paramContext = paramContext.obtainStyledAttributes(R.styleable.ListViewPrimaryItemColors);
    this._PrimaryColor = paramContext.getColorStateList(0);
    this._PrimaryReadColor = paramContext.getColorStateList(1);
    paramContext.recycle();
    this._ImageHeight = ((int)this._Owner.getContext().getResources().getDimension(2131492904));
    this._ImageWidth = ((int)this._Owner.getContext().getResources().getDimension(2131492903));
  }
  
  private FeedsViewItem BuildViewItem(FeedsViewItem paramFeedsViewItem, Feed paramFeed)
  {
    paramFeedsViewItem.PrimaryText.setText(paramFeed.getName());
    paramFeedsViewItem.SecondaryText.setText(GetInfoTextForFeed(paramFeed));
    int i = paramFeed.getType();
    Object localObject;
    if (paramFeed.equals(FeedRepository.getGoUpPlaceholder()))
    {
      paramFeedsViewItem.PrimaryImage.setErrorImageResId(2130837845);
      TextView localTextView = paramFeedsViewItem.PrimaryText;
      Formatter localFormatter = sInfoTextFormatter;
      String str = BACK_TO_PARENT;
      if (this._Feed.IsSubFeed())
      {
        localObject = this._Feed.ParentFeed().getName();
        localTextView.setText(localFormatter.format(str, new Object[] { localObject }).toString());
      }
    }
    for (;;)
    {
      paramFeedsViewItem.PrimaryImage.setFeed(paramFeed, this._Owner.getImageLoader());
      paramFeedsViewItem.PrimaryImage.setTag(paramFeed);
      paramFeedsViewItem.OverlayImage.setVisibility(8);
      if (!paramFeed.CanDeleteTracks())
      {
        paramFeedsViewItem.OverlayImage.setImageResource(2130838021);
        paramFeedsViewItem.OverlayImage.setVisibility(0);
      }
      if ((paramFeed.UpdateFailed) || (paramFeed.DownloadFailed))
      {
        paramFeedsViewItem.OverlayImage.setImageResource(2130838126);
        paramFeedsViewItem.OverlayImage.setVisibility(0);
      }
      paramFeedsViewItem.NoteText.setVisibility(8);
      if ((paramFeed.AllowsEnclosures()) && (paramFeed.Tracks().size() > 0))
      {
        paramFeedsViewItem.NoteText.setText(Integer.toString(paramFeed.Tracks().size()));
        paramFeedsViewItem.NoteText.setVisibility(0);
        paramFeedsViewItem.NoteText.setVisibility(0);
        paramFeedsViewItem.NoteText.setOnClickListener(this._Owner);
        paramFeedsViewItem.NoteText.setOnLongClickListener(this._Owner);
        paramFeedsViewItem.NoteText.setTag(paramFeed.ID());
      }
      if ((!paramFeed.HasUnreadItems()) && (paramFeed.HasUrl())) {
        break label411;
      }
      paramFeedsViewItem.PrimaryText.setTextColor(this._PrimaryColor);
      return paramFeedsViewItem;
      localObject = Configuration.getActiveFeedCategory().Name();
      break;
      if (i == 1)
      {
        localObject = paramFeedsViewItem.PrimaryImage;
        if (paramFeed.IsSubFeed()) {}
        for (i = 2130838097;; i = 2130837824)
        {
          ((FadingNetworkImageViewFeed)localObject).setErrorImageResId(i);
          break;
        }
      }
      if (i == 4) {
        paramFeedsViewItem.PrimaryImage.setErrorImageResId(2130837789);
      } else if ((i == 2) || (i == 3) || (i == 5)) {
        paramFeedsViewItem.PrimaryImage.setErrorImageResId(FeedImageCache.GetDefaultImageResId(paramFeed));
      }
    }
    label411:
    paramFeedsViewItem.PrimaryText.setTextColor(this._PrimaryReadColor);
    return paramFeedsViewItem;
  }
  
  private static String GetInfoTextForFeed(Feed paramFeed)
  {
    boolean bool = paramFeed.DownloadPathExists();
    sInfoTextStringBuilder.setLength(0);
    Object localObject;
    String str;
    if ((RssFeedUpdateManager.IsUpdating()) && (RssFeedUpdateManager.CurrentFeed() == paramFeed)) {
      if (paramFeed.getUpdateSize() <= 0L)
      {
        localObject = sInfoTextFormatter;
        str = UPDATING;
        if (paramFeed.getUpdatedPortion() > 0L)
        {
          paramFeed = CoreHelper.GetFileLengthAsString(Long.valueOf(paramFeed.getUpdatedPortion()));
          paramFeed = ((Formatter)localObject).format("%s %s...", new Object[] { str, paramFeed }).toString();
        }
      }
    }
    for (;;)
    {
      localObject = paramFeed;
      if (paramFeed.length() > 29) {
        localObject = paramFeed.substring(0, 29);
      }
      return (String)localObject;
      paramFeed = "";
      break;
      paramFeed = sInfoTextFormatter.format("%s %s%% %s %s...", new Object[] { UPDATING, Integer.valueOf(paramFeed.UpdatePercent()), OF, CoreHelper.GetFileLengthAsString(Long.valueOf(paramFeed.getUpdateSize())) }).toString();
      continue;
      if ((EnclosureDownloadManager.IsDownloading()) && (EnclosureDownloadManager.CurrentFeed() == paramFeed))
      {
        paramFeed = sInfoTextFormatter.format("%s %s %s %s...", new Object[] { DOWNLOADING, Integer.valueOf(paramFeed.NumDownloadedEnclosures + 1), OF, Integer.valueOf(paramFeed.NumEnclosuresAvailableForDownload) }).toString();
      }
      else if ((EnclosureDownloadManager.IsDownloading()) && (!paramFeed.DownloadFailed) && (paramFeed.NumEnclosuresAvailableForDownload > 0) && (paramFeed.NumDownloadedEnclosures == 0))
      {
        paramFeed = sInfoTextFormatter.format(S_PENDING, new Object[] { Integer.valueOf(paramFeed.NumEnclosuresAvailableForDownload) }).toString();
      }
      else if ((bool) && (paramFeed.SubFeeds().size() == 0))
      {
        if (paramFeed.NumUnreadItems() > 0) {
          paramFeed = sInfoTextFormatter.format("%s %s • %s", new Object[] { Integer.valueOf(paramFeed.NumUnreadItems()), UNREAD, DateTime.FormatDateTime(paramFeed.getLastModifiedDate()) }).toString();
        } else {
          paramFeed = DateTime.FormatDateTime(paramFeed.getLastModifiedDate());
        }
      }
      else
      {
        if (bool)
        {
          str = DateTime.FormatDateTime(paramFeed.getLastModifiedDate());
          Formatter localFormatter = sInfoTextFormatter;
          if (StringUtils.IsNullOrEmpty(str)) {}
          for (localObject = "";; localObject = " • ")
          {
            paramFeed = localFormatter.format("%s%s%s %s", new Object[] { str, localObject, Integer.valueOf(paramFeed.SubFeeds().size()), FEEDS }).toString();
            break;
          }
        }
        localObject = DateTime.FormatDateTime(paramFeed.getLastModifiedDate());
        if (paramFeed.NumUnreadItems() == 0) {
          paramFeed = (Feed)localObject;
        } else {
          paramFeed = sInfoTextFormatter.format("%s %s • %s", new Object[] { Integer.valueOf(paramFeed.NumUnreadItems()), UNREAD, localObject }).toString();
        }
      }
    }
  }
  
  private boolean IsFeedValidForNextPrev(Feed paramFeed)
  {
    return (paramFeed != null) && (paramFeed.getType() != 4) && (paramFeed.getType() != 1) && (FeedRepository.GetFeedById(paramFeed.ID()) != null);
  }
  
  private void PrefetchImageForFeed(Feed paramFeed)
  {
    if (paramFeed == null) {}
    String str;
    do
    {
      int i;
      do
      {
        return;
        i = paramFeed.getType();
      } while ((i != 2) && (i != 3) && (i != 5));
      str = FadingNetworkImageViewFeed.getFeedImageUrl(paramFeed);
    } while (StringUtils.IsNullOrEmpty(str));
    ((ImageLoaderFeed)this._Owner.getImageLoader()).get(str, paramFeed, new ImageLoader.ImageListener()
    {
      public void onErrorResponse(VolleyError paramAnonymousVolleyError) {}
      
      public void onResponse(ImageLoader.ImageContainer paramAnonymousImageContainer, boolean paramAnonymousBoolean) {}
    }, this._ImageWidth, this._ImageHeight);
  }
  
  public void Clear()
  {
    this._Feed = null;
    this._DataSource.Clear();
  }
  
  public int FeedCount()
  {
    return this._DataSource.FeedCount();
  }
  
  FeedList Feeds()
  {
    FeedListViewDataSource localFeedListViewDataSource = new FeedListViewDataSource();
    localFeedListViewDataSource.FilterAndGroupByFirstCategory(this._Feed, false, null);
    return localFeedListViewDataSource.GetFeeds();
  }
  
  public boolean HasHiddenFeeds()
  {
    return this._DataSource.HasHiddenReadFeeds();
  }
  
  public boolean HasReadFeeds()
  {
    return this._DataSource.HasReadFeeds();
  }
  
  public int HiddenFeedCount()
  {
    return this._DataSource.HiddenFeedCount();
  }
  
  public Feed NextFeed(Feed paramFeed)
  {
    int j = getFeedIndex(paramFeed);
    int i = j;
    if (j < 0) {
      return null;
    }
    do
    {
      i += 1;
      if ((i < 0) || (i >= getCount())) {
        break;
      }
      paramFeed = getFeedAtPosition(i);
    } while (!IsFeedValidForNextPrev(paramFeed));
    return paramFeed;
    return null;
  }
  
  public Feed NextUnreadFeed(Feed paramFeed)
  {
    int j = getFeedIndex(paramFeed);
    if (j < 0)
    {
      paramFeed = null;
      return paramFeed;
    }
    int i = j + 1;
    for (;;)
    {
      if (i == j) {
        return null;
      }
      if (i < getCount())
      {
        Feed localFeed = getFeedAtPosition(i);
        if (IsFeedValidForNextPrev(localFeed))
        {
          paramFeed = localFeed;
          if (localFeed.HasUnreadItems()) {
            break;
          }
        }
        i += 1;
        continue;
      }
      i = 0;
    }
  }
  
  void PrefetchItemImages()
  {
    int i = Math.min(this._Owner.getChildCount(), 10);
    int j = Math.min(this._Owner.getChildCount() * 2, i * 2);
    i = Math.max(this._Owner.getFirstVisiblePosition() - i, 0);
    int k = this._Owner.getFirstVisiblePosition();
    if ((i >= 0) && (i < k))
    {
      if (i < k) {}
    }
    else
    {
      i = this._Owner.getFirstVisiblePosition() + this._Owner.getChildCount() - 1;
      j = Math.min(i + j, getCount());
      if (i >= j) {}
    }
    for (;;)
    {
      if (i >= j)
      {
        return;
        PrefetchImageForFeed(getFeedAtPosition(i));
        i += 1;
        break;
      }
      PrefetchImageForFeed(getFeedAtPosition(i));
      i += 1;
    }
  }
  
  public Feed PreviousFeed(Feed paramFeed)
  {
    int j = getFeedIndex(paramFeed);
    int i = j;
    if (j < 0) {
      return null;
    }
    do
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      paramFeed = getFeedAtPosition(i);
    } while (!IsFeedValidForNextPrev(paramFeed));
    return paramFeed;
    return null;
  }
  
  public void Refresh()
  {
    SetRootFeed(this._Feed);
    this._Owner.UpdateFooterToolbar();
    notifyDataSetChanged();
  }
  
  public void RefreshFeed(Feed paramFeed)
  {
    SetRootFeed(this._Feed);
  }
  
  void SetRootFeed(Feed paramFeed)
  {
    this._Feed = paramFeed;
    this._DataSource.Clear();
    if (paramFeed != null) {
      this._DataSource.FilterAndGroupByFirstCategory(this._Feed, Configuration.getHideReadFeeds(), null);
    }
    this._Owner.UpdateFooterToolbar();
    notifyDataSetChanged();
  }
  
  public void ToggleReadFeeds(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramBoolean = false;; paramBoolean = true)
    {
      Configuration.setHideReadFeeds(paramBoolean);
      Refresh();
      MasterView.Master().RefreshActiveViewTitle();
      return;
    }
  }
  
  public boolean areAllItemsSelectable()
  {
    return false;
  }
  
  public int getCount()
  {
    return this._DataSource.size();
  }
  
  Feed getFeedAtPosition(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if (localObject != null) {
      return ((FeedListViewDataSource.ListDataItem)localObject).Feed;
    }
    return null;
  }
  
  int getFeedIndex(Feed paramFeed)
  {
    if (paramFeed == null) {
      return -1;
    }
    return this._DataSource.GetFeedIndex(paramFeed);
  }
  
  public Object getItem(int paramInt)
  {
    return this._DataSource.GetAtPosition(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    FeedListViewDataSource.ListDataItem localListDataItem = this._DataSource.GetAtPosition(paramInt);
    if ((localListDataItem == null) || ((localListDataItem.Feed == null) && (localListDataItem.Name == null))) {
      return -1;
    }
    if (localListDataItem.Feed == null) {
      return 0;
    }
    return 1;
  }
  
  Feed getRootFeed()
  {
    return this._Feed;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = this._DataSource.GetAtPosition(paramInt);
    if (localObject2 == null) {
      return this._Inflater.inflate(2130903131, null);
    }
    paramViewGroup = paramView;
    try
    {
      if (((FeedListViewDataSource.ListDataItem)localObject2).Feed != null)
      {
        if (paramView == null)
        {
          paramViewGroup = paramView;
          paramView = this._Inflater.inflate(2130903123, null);
          paramViewGroup = paramView;
          localObject1 = new FeedsViewItem(null);
          paramViewGroup = paramView;
          ((FeedsViewItem)localObject1).PrimaryText = ((TextView)paramView.findViewById(2131230887));
          paramViewGroup = paramView;
          ((FeedsViewItem)localObject1).SecondaryText = ((TextView)paramView.findViewById(2131230888));
          paramViewGroup = paramView;
          ((FeedsViewItem)localObject1).PrimaryImage = ((FadingNetworkImageViewFeed)paramView.findViewById(2131231063));
          paramViewGroup = paramView;
          ((FeedsViewItem)localObject1).PrimaryImage.setFadeInImage(false);
          paramViewGroup = paramView;
          ((FeedsViewItem)localObject1).PrimaryImage.setMaxImageSize(this._ImageWidth, this._ImageHeight);
          paramViewGroup = paramView;
          ((FeedsViewItem)localObject1).NoteText = ((TextView)paramView.findViewById(2131231065));
          paramViewGroup = paramView;
          ((FeedsViewItem)localObject1).OverlayImage = ((ImageView)paramView.findViewById(2131231064));
          paramViewGroup = paramView;
          paramView.setTag(localObject1);
        }
        for (;;)
        {
          paramViewGroup = paramView;
          BuildViewItem((FeedsViewItem)localObject1, ((FeedListViewDataSource.ListDataItem)localObject2).Feed);
          break;
          paramViewGroup = paramView;
          localObject1 = (FeedsViewItem)paramView.getTag();
        }
      }
      paramViewGroup = paramView;
      if (((FeedListViewDataSource.ListDataItem)localObject2).Name != null)
      {
        localObject1 = paramView;
        if (paramView == null)
        {
          paramViewGroup = paramView;
          localObject1 = this._Inflater.inflate(2130903132, null);
        }
        paramViewGroup = (ViewGroup)localObject1;
        ((TextView)localObject1).setText(((FeedListViewDataSource.ListDataItem)localObject2).Name);
        paramView = (View)localObject1;
      }
    }
    catch (Exception paramView)
    {
      CoreHelper.LogException(TAG, "Failed to get feeds view item", paramView);
      paramView = paramViewGroup;
    }
    Object localObject1 = paramView;
    if (paramView == null)
    {
      paramViewGroup = paramView;
      localObject1 = this._Inflater.inflate(2130903131, null);
    }
    paramViewGroup = (ViewGroup)localObject1;
    localObject2 = (TextView)localObject1;
    paramViewGroup = (ViewGroup)localObject1;
    paramView = (View)localObject1;
    if (this._DataSource.size() == 1)
    {
      paramViewGroup = (ViewGroup)localObject1;
      if (!HasHiddenFeeds())
      {
        paramViewGroup = (ViewGroup)localObject1;
        ((TextView)localObject2).setText(this._IfEmptyText);
        paramView = (View)localObject1;
      }
      else
      {
        paramViewGroup = (ViewGroup)localObject1;
        ((TextView)localObject2).setText(2131296913);
        paramView = (View)localObject1;
      }
    }
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public boolean isEnabled(int paramInt)
  {
    FeedListViewDataSource.ListDataItem localListDataItem = this._DataSource.GetAtPosition(paramInt);
    if (localListDataItem == null) {}
    while ((localListDataItem.Feed == null) && ((localListDataItem.Feed != null) || (localListDataItem.Name != null))) {
      return false;
    }
    return true;
  }
  
  public void setIfEmptyText(CharSequence paramCharSequence)
  {
    this._IfEmptyText = paramCharSequence;
  }
  
  private static class FeedsViewItem
  {
    TextView NoteText;
    ImageView OverlayImage;
    FadingNetworkImageViewFeed PrimaryImage;
    TextView PrimaryText;
    TextView SecondaryText;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/FeedsViewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */