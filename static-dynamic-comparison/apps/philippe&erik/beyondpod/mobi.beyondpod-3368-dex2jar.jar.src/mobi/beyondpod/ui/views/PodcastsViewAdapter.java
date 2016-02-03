package mobi.beyondpod.ui.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.LevelListDrawable;
import android.os.Handler;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader.ImageContainer;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.R.styleable;
import mobi.beyondpod.downloadengine.EnclosureDownloadManager;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.FeedSorter;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.TrackSorter;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.CoreHelper.TrackSizeInfo;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.helpers.TimeBands;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.services.player.PlayList;
import mobi.beyondpod.ui.core.volley.FadingNetworkImageViewTrack;
import mobi.beyondpod.ui.core.volley.ImageLoaderTrack;

public class PodcastsViewAdapter
  extends BaseAdapter
{
  private static final String DOWNLOADED = CoreHelper.LoadResourceString(2131297098);
  private static final String DOWNLOADING = CoreHelper.LoadResourceString(2131297099);
  private static final String DOWNLOAD_PENDING = CoreHelper.LoadResourceString(2131297097);
  static Typeface FancyFont;
  static final int MULTISELECT_MODE_ADD_TO_PLAYLIST = 2;
  static final int MULTISELECT_MODE_CLEANUP = 1;
  static final int MULTISELECT_MODE_NONE = 0;
  public static final int SCOPE_CURRENT_CATEGORY = 1;
  private static final String THIS = CoreHelper.LoadResourceString(2131297100);
  private FeedCategory _CategoryFilter;
  private int _DescriptionFontSize = 10;
  Handler _Handler = new Handler();
  boolean _HasDPad;
  int _ImageHeight;
  int _ImageWidth;
  private LayoutInflater _Inflater;
  private int _ItemFontSize = 14;
  ArrayList<ListDataItem> _Items = new ArrayList();
  private int _MultiselectModeKind = 0;
  PodcastsListView _Owner;
  private int _PodcastCount;
  private ColorStateList _Primary;
  private ColorStateList _PrimaryPlayed;
  private int _ProgressWidth;
  private ColorStateList _Secondary;
  private ColorStateList _SecondaryPlayed;
  private int _VisiblePodcastCount;
  ImageLoader.ImageListener _prefetchImageListener = new ImageLoader.ImageListener()
  {
    public void onErrorResponse(VolleyError paramAnonymousVolleyError) {}
    
    public void onResponse(ImageLoader.ImageContainer paramAnonymousImageContainer, boolean paramAnonymousBoolean) {}
  };
  
  public PodcastsViewAdapter(Context paramContext, PodcastsListView paramPodcastsListView)
  {
    this._Inflater = LayoutInflater.from(paramContext);
    this._Owner = paramPodcastsListView;
    this._ProgressWidth = ((int)paramContext.getResources().getDimension(2131492882));
    if (paramPodcastsListView.getResources().getConfiguration().navigation != 1) {}
    for (boolean bool = true;; bool = false)
    {
      this._HasDPad = bool;
      paramContext = paramContext.obtainStyledAttributes(R.styleable.FeedContentListViewItemColors);
      this._Primary = paramContext.getColorStateList(0);
      this._PrimaryPlayed = paramContext.getColorStateList(1);
      this._Secondary = paramContext.getColorStateList(2);
      this._SecondaryPlayed = paramContext.getColorStateList(3);
      paramContext.recycle();
      LoadDefaultFontSize();
      this._ImageWidth = ((int)this._Owner.getContext().getResources().getDimension(2131492882));
      this._ImageHeight = ((int)this._Owner.getContext().getResources().getDimension(2131492883));
      return;
    }
  }
  
  private void AssignTrackPrimaryImage(PodcastsViewItem paramPodcastsViewItem, Track paramTrack, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    int k = paramTrack.getCurrentPlayState();
    label38:
    View localView;
    if ((mobi.beyondpod.rsscore.Configuration.AllowEpisodeStreaming() == 2) && (!paramBoolean1))
    {
      i = 1;
      if (k != 1) {
        break label128;
      }
      paramPodcastsViewItem.NowPlaying.setImageResource(2130837993);
      paramPodcastsViewItem.PrimaryImage.setTag(paramTrack);
      paramPodcastsViewItem.PrimaryImage.setErrorImageResId(FadingNetworkImageViewTrack.GetDefaultImage(paramTrack.ContentType()));
      i = 1;
      if (paramTrack.HasContentType()) {
        i = paramTrack.ContentType();
      }
      localView = paramPodcastsViewItem.MovieOverlay;
      if (i != 2) {
        break label235;
      }
    }
    label128:
    label235:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      if (!paramTrack.IsFullyDownloaded()) {
        break label242;
      }
      paramPodcastsViewItem.PrimaryImage.setTrack(paramTrack, this._Owner.getImageLoader());
      return;
      i = 0;
      break;
      if (k == 0)
      {
        paramPodcastsViewItem.NowPlaying.setImageResource(2130837992);
        break label38;
      }
      if ((k == 3) || (k == 6))
      {
        paramPodcastsViewItem.NowPlaying.setImageResource(2130837994);
        break label38;
      }
      if ((k == 3) || (k == 7) || (k == 8))
      {
        paramPodcastsViewItem.NowPlaying.setImageResource(2130837991);
        break label38;
      }
      if ((paramBoolean2) && (i == 0))
      {
        paramPodcastsViewItem.NowPlaying.setImageResource(2130837995);
        break label38;
      }
      paramPodcastsViewItem.NowPlaying.setImageDrawable(null);
      break label38;
    }
    label242:
    paramPodcastsViewItem.PrimaryImage.setFeed(paramTrack.getParentFeed(), this._Owner.getImageLoader());
  }
  
  private void BuildViewItem(PodcastsViewItem paramPodcastsViewItem, Track paramTrack, ViewGroup paramViewGroup)
  {
    boolean bool2 = mobi.beyondpod.rsscore.Configuration.FeedContentItemOptimizeForReading();
    paramViewGroup = paramPodcastsViewItem.ItemCheckBox;
    label43:
    boolean bool1;
    label69:
    TextView localTextView;
    if (this._MultiselectModeKind == 1)
    {
      i = 0;
      paramViewGroup.setVisibility(i);
      paramViewGroup = paramPodcastsViewItem.AddRemovePlaylist;
      if (this._MultiselectModeKind != 2) {
        break label633;
      }
      i = 0;
      paramViewGroup.setVisibility(i);
      paramPodcastsViewItem.PrimaryText.setText(paramTrack.DisplayName());
      if (!mobi.beyondpod.rsscore.Configuration.MultilineEpisodeTitle()) {
        break label640;
      }
      bool1 = false;
      localTextView = paramPodcastsViewItem.PrimaryText;
      if (!bool1) {
        break label667;
      }
      if (!paramTrack.getParentFeed().getLeftTruncateLongTrackNames()) {
        break label646;
      }
      paramViewGroup = TextUtils.TruncateAt.START;
      label94:
      localTextView.setEllipsize(paramViewGroup);
      paramPodcastsViewItem.PrimaryText.setSingleLine(bool1);
      localTextView = paramPodcastsViewItem.PrimaryText;
      if (!paramTrack.IsPlayed()) {
        break label672;
      }
      paramViewGroup = this._PrimaryPlayed;
      label127:
      localTextView.setTextColor(paramViewGroup);
      paramPodcastsViewItem.PrimaryText.setTextSize(this._ItemFontSize);
      localTextView = paramPodcastsViewItem.Description;
      if (!StringUtils.IsNullOrEmpty(paramTrack.TrackDescription())) {
        break label680;
      }
      paramViewGroup = paramTrack.getParentFeed().getName();
      label169:
      localTextView.setText(paramViewGroup);
      localTextView = paramPodcastsViewItem.Description;
      if (!paramTrack.IsPlayed()) {
        break label688;
      }
      paramViewGroup = this._SecondaryPlayed;
      label193:
      localTextView.setTextColor(paramViewGroup);
      paramPodcastsViewItem.Description.setTextSize(this._DescriptionFontSize);
      paramPodcastsViewItem.Description.setEllipsize(TextUtils.TruncateAt.END);
      if (!bool2) {
        break label696;
      }
      paramPodcastsViewItem.ItemImageArea.setOnClickListener(this._Owner);
      paramPodcastsViewItem.ItemImageArea.setOnLongClickListener(this._Owner);
      paramPodcastsViewItem.ItemImageArea.setTag(paramTrack);
      label256:
      if (!bool2) {
        break label715;
      }
      paramPodcastsViewItem.EpisodeNotes.setVisibility(8);
      paramPodcastsViewItem.Description.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      label281:
      paramViewGroup = paramPodcastsViewItem.PlayedPortionIndicator.getLayoutParams();
      float f1 = this._ProgressWidth;
      float f2 = paramTrack.PlayedAsFraction();
      if (paramTrack.PlayedAsFraction() <= 0.0F) {
        break label758;
      }
      i = 1;
      label314:
      paramViewGroup.width = ((int)Math.max(f2 * f1, i));
      paramPodcastsViewItem.PlayedPortionIndicator.setLayoutParams(paramViewGroup);
      paramViewGroup = (LevelListDrawable)paramPodcastsViewItem.PlayedPortionIndicator.getBackground();
      if (!paramTrack.IsPlayed()) {
        break label764;
      }
      i = 20;
      label360:
      paramViewGroup.setLevel(i);
      paramPodcastsViewItem.InPlaylist.setVisibility(8);
      paramPodcastsViewItem.StreamableImage.setVisibility(8);
      paramPodcastsViewItem.Duration.setVisibility(8);
      bool1 = paramTrack.HasDownloadStarted();
      AssignTrackPrimaryImage(paramPodcastsViewItem, paramTrack, bool1, bool2);
      if ((!bool1) || (paramTrack.IsFullyDownloaded())) {
        break label838;
      }
      if (paramTrack.getDownloadStatus() == 2) {
        break label771;
      }
      paramPodcastsViewItem.OverlayImage.setImageResource(2130838126);
      paramPodcastsViewItem.OverlayImage.setVisibility(0);
      label448:
      if (paramTrack.getDownloadStatus() != 2) {
        break label783;
      }
      paramViewGroup = DOWNLOADING;
      label460:
      if (paramTrack.getDownloadSize() > 0L) {
        break label790;
      }
      paramPodcastsViewItem.PodcastDate.setText(String.format("%s %s", new Object[] { paramViewGroup, CoreHelper.GetFileLengthAsString(Long.valueOf(paramTrack.getDownloadedPortion())) }));
      label503:
      paramPodcastsViewItem.Duration.setText("");
      label513:
      if (this._MultiselectModeKind != 1) {
        break label1030;
      }
      localTextView = paramPodcastsViewItem.Duration;
      if (paramTrack.getSizeOnDisk() <= 0L) {
        break label1016;
      }
      paramViewGroup = CoreHelper.GetFileLengthAsString(Long.valueOf(paramTrack.getSizeOnDisk()));
      label547:
      localTextView.setText(paramViewGroup);
      paramViewGroup = paramPodcastsViewItem.Duration;
      if (!bool1) {
        break label1023;
      }
      i = 0;
      label566:
      paramViewGroup.setVisibility(i);
      localTextView = paramPodcastsViewItem.PodcastDate;
      if (!paramTrack.IsPlayed()) {
        break label1109;
      }
      paramViewGroup = this._PrimaryPlayed;
      label590:
      localTextView.setTextColor(paramViewGroup);
      paramPodcastsViewItem = (LevelListDrawable)paramPodcastsViewItem.Duration.getBackground();
      if (!paramTrack.IsPlayed()) {
        break label1117;
      }
    }
    label633:
    label640:
    label646:
    label667:
    label672:
    label680:
    label688:
    label696:
    label715:
    label758:
    label764:
    label771:
    label783:
    label790:
    label838:
    label996:
    label1004:
    label1016:
    label1023:
    label1030:
    label1050:
    label1102:
    label1109:
    label1117:
    for (int i = 20;; i = 10)
    {
      paramPodcastsViewItem.setLevel(i);
      return;
      i = 8;
      break;
      i = 8;
      break label43;
      bool1 = true;
      break label69;
      if (this._HasDPad)
      {
        paramViewGroup = TextUtils.TruncateAt.MARQUEE;
        break label94;
      }
      paramViewGroup = TextUtils.TruncateAt.END;
      break label94;
      paramViewGroup = null;
      break label94;
      paramViewGroup = this._Primary;
      break label127;
      paramViewGroup = paramTrack.TrackDescription();
      break label169;
      paramViewGroup = this._Secondary;
      break label193;
      paramPodcastsViewItem.ItemImageArea.setClickable(false);
      paramPodcastsViewItem.ItemImageArea.setTag(null);
      break label256;
      paramPodcastsViewItem.EpisodeNotes.setOnClickListener(this._Owner);
      paramPodcastsViewItem.EpisodeNotes.setVisibility(0);
      paramPodcastsViewItem.EpisodeNotes.setTag(paramTrack);
      paramPodcastsViewItem.Description.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837806, 0);
      break label281;
      i = 0;
      break label314;
      i = 10;
      break label360;
      paramPodcastsViewItem.OverlayImage.setVisibility(8);
      break label448;
      paramViewGroup = DOWNLOADED;
      break label460;
      paramPodcastsViewItem.PodcastDate.setText(String.format("%s %s%% of %s", new Object[] { paramViewGroup, Integer.valueOf((int)paramTrack.getDownloadPercent()), CoreHelper.GetFileLengthAsString(Long.valueOf(paramTrack.getDownloadSize())) }));
      break label503;
      if (EnclosureDownloadManager.IsDownloadPending(paramTrack.getUrl()))
      {
        paramPodcastsViewItem.PodcastDate.setText(DOWNLOAD_PENDING);
        break label513;
      }
      paramPodcastsViewItem.PodcastDate.setText(DateTime.FormatDateTime(paramTrack.getLastModifiedDate()));
      if (!bool1) {
        paramPodcastsViewItem.StreamableImage.setVisibility(0);
      }
      bool2 = BeyondPodApplication.GetInstance().PlayList().HasTrack(paramTrack);
      if (bool2) {
        paramPodcastsViewItem.InPlaylist.setVisibility(0);
      }
      if (this._MultiselectModeKind == 2)
      {
        paramViewGroup = paramPodcastsViewItem.AddRemovePlaylist;
        if (!bool2) {
          break label996;
        }
      }
      for (i = 2130837971;; i = 2130837970)
      {
        paramViewGroup.setImageResource(i);
        if ((paramPodcastsViewItem.StreamableImage.getVisibility() == 0) && (mobi.beyondpod.rsscore.Configuration.AllowEpisodeStreaming() == 2)) {
          paramPodcastsViewItem.AddRemovePlaylist.setVisibility(8);
        }
        if (paramTrack.AllowAutoDelete()) {
          break label1004;
        }
        paramPodcastsViewItem.OverlayImage.setImageResource(2130838021);
        paramPodcastsViewItem.OverlayImage.setVisibility(0);
        break;
      }
      paramPodcastsViewItem.OverlayImage.setVisibility(8);
      break label513;
      paramViewGroup = "";
      break label547;
      i = 8;
      break label566;
      localTextView = paramPodcastsViewItem.Duration;
      if (paramTrack.getTotalTime() > 0L)
      {
        paramViewGroup = paramTrack.TotalTimeAsString();
        localTextView.setText(paramViewGroup);
        paramViewGroup = paramPodcastsViewItem.Duration;
        if ((!paramTrack.IsPlayed()) && (paramPodcastsViewItem.Duration.getText().length() <= 0)) {
          break label1102;
        }
      }
      for (i = 0;; i = 8)
      {
        paramViewGroup.setVisibility(i);
        break;
        paramViewGroup = "";
        break label1050;
      }
      paramViewGroup = this._Primary;
      break label590;
    }
  }
  
  private void GenerateItemsGroupedByDate(TrackList paramTrackList, int paramInt)
  {
    Collections.sort(paramTrackList, new TrackSorter(paramInt));
    paramInt = -1;
    Calendar localCalendar = Calendar.getInstance();
    TimeBands localTimeBands = new TimeBands();
    paramTrackList = paramTrackList.iterator();
    if (!paramTrackList.hasNext()) {
      return;
    }
    Track localTrack = (Track)paramTrackList.next();
    localCalendar.setTime(localTrack.getLastModifiedDate());
    int j = localTimeBands.GetDateBand(localCalendar);
    int i = paramInt;
    if (paramInt != j) {}
    switch (j)
    {
    default: 
      paramInt = 2131296373;
    case 0: 
    case 1: 
    case 4: 
    case 2: 
    case 5: 
      for (;;)
      {
        i = j;
        this._Items.add(new ListDataItem(this._Owner.getResources().getString(paramInt), null, null));
        this._Items.add(new ListDataItem(null, localTrack, null));
        paramInt = i;
        break;
        paramInt = 2131296364;
        continue;
        if (paramInt == -1) {}
        for (paramInt = 2131296365;; paramInt = 2131296366) {
          break;
        }
        paramInt = 2131296367;
        continue;
        if (paramInt == -1) {}
        for (paramInt = 2131296368;; paramInt = 2131296369) {
          break;
        }
        paramInt = 2131296370;
      }
    }
    if (paramInt == -1) {}
    for (paramInt = 2131296371;; paramInt = 2131296372) {
      break;
    }
  }
  
  private void GenerateItemsGroupedByFeedUsingFeedSort(TrackList paramTrackList)
  {
    Object localObject2 = new FeedList();
    Collections.sort(paramTrackList, new TrackSorter(mobi.beyondpod.rsscore.Configuration.getPodcastsSortOrder()));
    Object localObject1 = paramTrackList.iterator();
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext())
      {
        Collections.sort((List)localObject2, new FeedSorter(mobi.beyondpod.rsscore.Configuration.getFeedsSortOrder()));
        localObject1 = new TrackSorter();
        localObject2 = ((FeedList)localObject2).iterator();
        if (((Iterator)localObject2).hasNext()) {
          break;
        }
        return;
      }
      localObject3 = (Track)((Iterator)localObject1).next();
      if (!((FeedList)localObject2).contains(((Track)localObject3).getParentFeed())) {
        ((FeedList)localObject2).add(((Track)localObject3).getParentFeed());
      }
    }
    Object localObject3 = (Feed)((Iterator)localObject2).next();
    Object localObject4 = new TrackList();
    this._Items.add(new ListDataItem(((Feed)localObject3).getName(), null, (Feed)localObject3));
    Iterator localIterator = paramTrackList.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        ((TrackSorter)localObject1).SortOrder = ((Feed)localObject3).getLocalOrInheritedTrackSortOrder();
        Collections.sort((List)localObject4, (Comparator)localObject1);
        localObject3 = ((TrackList)localObject4).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (Track)((Iterator)localObject3).next();
          this._Items.add(new ListDataItem(null, (Track)localObject4, null));
        }
        break;
      }
      Track localTrack = (Track)localIterator.next();
      if (localTrack.getParentFeed().equals(localObject3)) {
        ((TrackList)localObject4).add(localTrack);
      }
    }
  }
  
  private void GenerateItemsUsingDefaultSortSettings(TrackList paramTrackList, int paramInt)
  {
    Collections.sort(paramTrackList, new TrackSorter(paramInt));
    paramTrackList = paramTrackList.iterator();
    for (;;)
    {
      if (!paramTrackList.hasNext()) {
        return;
      }
      Track localTrack = (Track)paramTrackList.next();
      this._Items.add(new ListDataItem(null, localTrack, null));
    }
  }
  
  private ListDataItem GetItemAt(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this._Items.size())) {
      return (ListDataItem)this._Items.get(paramInt);
    }
    return null;
  }
  
  private void prefetchEpisodeImage(Track paramTrack)
  {
    String str;
    if (paramTrack.IsFullyDownloaded())
    {
      str = FadingNetworkImageViewTrack.getEpisodeImageUrl(paramTrack);
      if (!StringUtils.IsNullOrEmpty(str)) {
        ((ImageLoaderTrack)this._Owner.getImageLoader()).get(str, paramTrack, paramTrack.getParentFeed(), this._prefetchImageListener, this._ImageWidth, this._ImageHeight);
      }
    }
    do
    {
      return;
      str = FadingNetworkImageViewTrack.getFeedImageUrl(paramTrack.getParentFeed());
    } while (StringUtils.IsNullOrEmpty(str));
    ((ImageLoaderTrack)this._Owner.getImageLoader()).get(str, null, paramTrack.getParentFeed(), this._prefetchImageListener, this._ImageWidth, this._ImageHeight);
  }
  
  public void Clear()
  {
    this._Items.clear();
  }
  
  public int CurrentMultiselectMode()
  {
    return this._MultiselectModeKind;
  }
  
  TrackList GeneratePlaylist(Track paramTrack)
  {
    TrackList localTrackList = new TrackList();
    int i = 0;
    Iterator localIterator = this._Items.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localTrackList;
      }
      ListDataItem localListDataItem = (ListDataItem)localIterator.next();
      if (localListDataItem.Track != null)
      {
        int j;
        if (paramTrack != null)
        {
          j = i;
          if (!paramTrack.equals(localListDataItem.Track)) {}
        }
        else
        {
          j = 1;
        }
        i = j;
        if (j != 0)
        {
          i = j;
          if (!localListDataItem.Track.IsPlayed())
          {
            localTrackList.add(localListDataItem.Track);
            i = j;
          }
        }
      }
    }
  }
  
  TrackList GetAllPlayedPodcasts()
  {
    TrackList localTrackList = new TrackList();
    Iterator localIterator = this._Items.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localTrackList;
      }
      ListDataItem localListDataItem = (ListDataItem)localIterator.next();
      if ((localListDataItem.Track != null) && (localListDataItem.Track.IsPlayed())) {
        localTrackList.add(localListDataItem.Track);
      }
    }
  }
  
  public CoreHelper.TrackSizeInfo GetCurrentTracksSizeOnDisk()
  {
    CoreHelper.TrackSizeInfo localTrackSizeInfo = new CoreHelper.TrackSizeInfo();
    Iterator localIterator = this._Items.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localTrackSizeInfo;
      }
      ListDataItem localListDataItem = (ListDataItem)localIterator.next();
      if (localListDataItem.Track != null)
      {
        localTrackSizeInfo.SizeOnDisk += localListDataItem.Track.getSizeOnDisk();
        if (localListDataItem.Track.ContentType() != 3)
        {
          localTrackSizeInfo.TotalTime += localListDataItem.Track.getTotalTime();
          if (localListDataItem.Track.getTotalTime() == 0L) {
            localTrackSizeInfo.TotalTimeIsApproximate = true;
          }
        }
      }
    }
  }
  
  public boolean HasPlayedPodcasts()
  {
    Iterator localIterator = this._Items.iterator();
    ListDataItem localListDataItem;
    do
    {
      if (!localIterator.hasNext()) {
        return false;
      }
      localListDataItem = (ListDataItem)localIterator.next();
    } while ((localListDataItem.Track == null) || (!localListDataItem.Track.IsPlayed()));
    return true;
  }
  
  public void LoadDefaultFontSize()
  {
    this._ItemFontSize = ((int)mobi.beyondpod.rsscore.Configuration.DefaultPrimaryFontSizeInUnits());
    this._DescriptionFontSize = ((int)mobi.beyondpod.rsscore.Configuration.DefaultDescriptionFontSizeInUnits());
  }
  
  void PrefetchItemImages()
  {
    int i = Math.min(this._Owner.getChildCount(), 5);
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
        localListDataItem = GetItemAt(i);
        if ((localListDataItem != null) && (localListDataItem.Track != null)) {
          prefetchEpisodeImage(localListDataItem.Track);
        }
        i += 1;
        break;
      }
      ListDataItem localListDataItem = GetItemAt(i);
      if ((localListDataItem != null) && (localListDataItem.Track != null)) {
        prefetchEpisodeImage(localListDataItem.Track);
      }
      i += 1;
    }
  }
  
  public void Refresh()
  {
    notifyDataSetChanged();
  }
  
  public void ReloadTracks()
  {
    this._Owner.clearChoices();
    this._Items.clear();
    this._PodcastCount = 0;
    this._VisiblePodcastCount = 0;
    TrackList localTrackList = new TrackList();
    Feed localFeed = mobi.beyondpod.rsscore.Configuration.getActiveFeedFilter();
    Iterator localIterator = FeedRepository.GetAllTracks().iterator();
    if (!localIterator.hasNext())
    {
      if (this._VisiblePodcastCount != 0) {
        break label335;
      }
      this._Items.add(new ListDataItem(null, null, null));
    }
    for (;;)
    {
      enableFasScrollIfNeeded();
      notifyDataSetChanged();
      this._Handler.postDelayed(new Runnable()
      {
        public void run()
        {
          PodcastsViewAdapter.this.PrefetchItemImages();
        }
      }, 1000L);
      return;
      Track localTrack = (Track)localIterator.next();
      if (((this._CategoryFilter != CategoryManager.CategoryNull) && (!CategoryManager.IsInCategory(localTrack.getParentFeed(), this._CategoryFilter))) || ((localFeed != null) && (!localTrack.BelongsTo(localFeed)))) {
        break;
      }
      int i = 0;
      switch (mobi.beyondpod.rsscore.Configuration.getActiveMediaFilter())
      {
      }
      for (;;)
      {
        if (i != 0)
        {
          this._VisiblePodcastCount += 1;
          localTrackList.add(localTrack);
        }
        this._PodcastCount += 1;
        break;
        i = 1;
        continue;
        if (localTrack.ContentType() == 2)
        {
          i = 1;
          continue;
          if (localTrack.ContentType() == 1)
          {
            i = 1;
            continue;
            if (localTrack.IsFullyDownloaded())
            {
              i = 1;
              continue;
              if (localTrack.IsPartialyPlayed())
              {
                i = 1;
                continue;
                if ((localTrack.IsNew()) || (localTrack.IsPartialyPlayed()))
                {
                  i = 1;
                  continue;
                  if (!localTrack.AllowAutoDelete()) {
                    i = 1;
                  }
                }
              }
            }
          }
        }
      }
      label335:
      if (localFeed != null) {}
      for (i = localFeed.getLocalOrInheritedTrackSortOrder();; i = mobi.beyondpod.rsscore.Configuration.getPodcastsSortOrder())
      {
        if ((!mobi.beyondpod.rsscore.Configuration.getGroupByFeedIfShowingCategoryTracks()) || (localFeed != null)) {
          break label369;
        }
        GenerateItemsGroupedByFeedUsingFeedSort(localTrackList);
        break;
      }
      label369:
      if ((i == 3) || (i == 2)) {
        GenerateItemsGroupedByDate(localTrackList, i);
      } else {
        GenerateItemsUsingDefaultSortSettings(localTrackList, i);
      }
    }
  }
  
  public boolean areAllItemsSelectable()
  {
    return false;
  }
  
  public void enableFasScrollIfNeeded()
  {
    PodcastsListView localPodcastsListView = this._Owner;
    if ((this._VisiblePodcastCount > 100) && (this._MultiselectModeKind == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      localPodcastsListView.setFastScrollEnabled(bool);
      return;
    }
  }
  
  public int getCount()
  {
    return this._Items.size();
  }
  
  public Feed getFeedAt(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if (localObject != null) {
      return ((ListDataItem)localObject).Feed;
    }
    return null;
  }
  
  public Object getItem(int paramInt)
  {
    return GetItemAt(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    ListDataItem localListDataItem = GetItemAt(paramInt);
    if ((localListDataItem == null) || ((localListDataItem.Track == null) && (localListDataItem.Name == null))) {
      return -1;
    }
    if (localListDataItem.Track == null) {
      return 0;
    }
    return 1;
  }
  
  TrackList getLargestPodcasts()
  {
    TrackList localTrackList = new TrackList();
    Iterator localIterator = this._Items.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        Collections.sort(localTrackList, new TrackSorter(10));
        return localTrackList;
      }
      ListDataItem localListDataItem = (ListDataItem)localIterator.next();
      if (localListDataItem.Track != null) {
        localTrackList.add(localListDataItem.Track);
      }
    }
  }
  
  TrackList getOldestPodcasts()
  {
    TrackList localTrackList = new TrackList();
    Iterator localIterator = this._Items.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        Collections.sort(localTrackList, new TrackSorter(2));
        return localTrackList;
      }
      ListDataItem localListDataItem = (ListDataItem)localIterator.next();
      if (localListDataItem.Track != null) {
        localTrackList.add(localListDataItem.Track);
      }
    }
  }
  
  int getPodcastCount()
  {
    return this._PodcastCount;
  }
  
  public Track getTrackAt(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if (localObject != null) {
      return ((ListDataItem)localObject).Track;
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject3 = GetItemAt(paramInt);
    if (localObject3 == null) {
      return paramView;
    }
    Object localObject1 = paramView;
    try
    {
      if (((ListDataItem)localObject3).Track != null)
      {
        if (paramView == null)
        {
          localObject1 = paramView;
          paramView = this._Inflater.inflate(2130903150, null);
          localObject1 = paramView;
          localObject2 = new PodcastsViewItem(null);
          localObject1 = paramView;
          ((PodcastsViewItem)localObject2).PrimaryText = ((TextView)paramView.findViewById(2131230946));
          localObject1 = paramView;
          ((PodcastsViewItem)localObject2).PodcastDate = ((TextView)paramView.findViewById(2131230948));
          localObject1 = paramView;
          ((PodcastsViewItem)localObject2).Duration = ((TextView)paramView.findViewById(2131230937));
          localObject1 = paramView;
          ((PodcastsViewItem)localObject2).PrimaryImage = ((FadingNetworkImageViewTrack)paramView.findViewById(2131230934));
          localObject1 = paramView;
          ((PodcastsViewItem)localObject2).PrimaryImage.setFadeInImage(true);
          localObject1 = paramView;
          ((PodcastsViewItem)localObject2).PrimaryImage.setMaxImageSize(this._ImageWidth, this._ImageHeight);
          localObject1 = paramView;
          ((PodcastsViewItem)localObject2).PrimaryImage.setImageDrawable(null);
          localObject1 = paramView;
          ((PodcastsViewItem)localObject2).PrimaryImage.setDefaultImageResId(2130838006);
          localObject1 = paramView;
          ((PodcastsViewItem)localObject2).MovieOverlay = paramView.findViewById(2131230935);
          localObject1 = paramView;
          ((PodcastsViewItem)localObject2).OverlayImage = ((ImageView)paramView.findViewById(2131230936));
          localObject1 = paramView;
          ((PodcastsViewItem)localObject2).NowPlaying = ((ImageView)paramView.findViewById(2131230939));
          localObject1 = paramView;
          ((PodcastsViewItem)localObject2).StreamableImage = paramView.findViewById(2131230850);
          localObject1 = paramView;
          ((PodcastsViewItem)localObject2).InPlaylist = ((ImageView)paramView.findViewById(2131230949));
          localObject1 = paramView;
          ((PodcastsViewItem)localObject2).PlayedPortionIndicator = paramView.findViewById(2131230938);
          localObject1 = paramView;
          ((PodcastsViewItem)localObject2).Description = ((TextView)paramView.findViewById(2131231156));
          localObject1 = paramView;
          ((PodcastsViewItem)localObject2).ItemCheckBox = paramView.findViewById(2131231150);
          localObject1 = paramView;
          ((PodcastsViewItem)localObject2).AddRemovePlaylist = ((ImageView)paramView.findViewById(2131230955));
          localObject1 = paramView;
          ((PodcastsViewItem)localObject2).EpisodeNotes = paramView.findViewById(2131230951);
          localObject1 = paramView;
          ((PodcastsViewItem)localObject2).ItemImageArea = paramView.findViewById(2131230933);
          localObject1 = paramView;
          if (FancyFont != null)
          {
            localObject1 = paramView;
            ((PodcastsViewItem)localObject2).PrimaryText.setTypeface(FancyFont);
          }
          localObject1 = paramView;
          paramView.setTag(localObject2);
        }
        for (;;)
        {
          localObject1 = paramView;
          BuildViewItem((PodcastsViewItem)localObject2, ((ListDataItem)localObject3).Track, paramViewGroup);
          break;
          localObject1 = paramView;
          localObject2 = (PodcastsViewItem)paramView.getTag();
        }
      }
      localObject1 = paramView;
      if (((ListDataItem)localObject3).Name != null)
      {
        paramViewGroup = paramView;
        if (paramView == null)
        {
          localObject1 = paramView;
          paramViewGroup = this._Inflater.inflate(2130903132, null);
        }
        localObject1 = paramViewGroup;
        ((TextView)paramViewGroup).setText(((ListDataItem)localObject3).Name);
        paramView = paramViewGroup;
      }
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
      paramView = (View)localObject1;
    }
    paramViewGroup = paramView;
    if (paramView == null)
    {
      localObject1 = paramView;
      paramViewGroup = this._Inflater.inflate(2130903131, null);
    }
    localObject1 = paramViewGroup;
    Object localObject2 = (TextView)paramViewGroup;
    localObject1 = paramViewGroup;
    String str;
    if (this._PodcastCount == 0)
    {
      localObject1 = paramViewGroup;
      paramView = mobi.beyondpod.rsscore.Configuration.getActiveFeedFilter();
      if (paramView == null)
      {
        localObject1 = paramViewGroup;
        localObject3 = this._Owner.getContext();
        localObject1 = paramViewGroup;
        if (this._CategoryFilter == null) {
          localObject1 = paramViewGroup;
        }
        for (paramView = THIS;; paramView = this._CategoryFilter.Name())
        {
          localObject1 = paramViewGroup;
          ((TextView)localObject2).setText(((Context)localObject3).getString(2131296937, new Object[] { paramView }));
          paramView = paramViewGroup;
          break;
          localObject1 = paramViewGroup;
        }
      }
      localObject1 = paramViewGroup;
      localObject3 = this._Owner.getContext();
      localObject1 = paramViewGroup;
      str = paramView.getName();
      localObject1 = paramViewGroup;
      if (paramView.IsSubFeed()) {
        break label769;
      }
      localObject1 = paramViewGroup;
    }
    label767:
    label769:
    for (paramView = this._Owner.getContext().getString(2131296939);; paramView = "")
    {
      localObject1 = paramViewGroup;
      ((TextView)localObject2).setText(((Context)localObject3).getString(2131296938, new Object[] { str, paramView }));
      paramView = paramViewGroup;
      break label767;
      localObject1 = paramViewGroup;
      paramInt = CoreHelper.FindIndexInNumArray(this._Owner.getContext(), 2131623945, Integer.valueOf(mobi.beyondpod.rsscore.Configuration.getActiveMediaFilter()));
      localObject1 = paramViewGroup;
      ((TextView)localObject2).setText(this._Owner.getContext().getString(2131296940, new Object[] { this._Owner.getResources().getStringArray(2131623944)[paramInt] }));
      paramView = paramViewGroup;
      return paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  int getVisiblePodcastCount()
  {
    return this._VisiblePodcastCount;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return GetItemAt(paramInt) != null;
  }
  
  public boolean setCategoryFilter(FeedCategory paramFeedCategory)
  {
    if ((this._CategoryFilter != null) && (this._CategoryFilter != paramFeedCategory)) {}
    for (boolean bool = true;; bool = false)
    {
      this._CategoryFilter = paramFeedCategory;
      ReloadTracks();
      return bool;
    }
  }
  
  public void setCurrentMultiselectMode(int paramInt)
  {
    this._MultiselectModeKind = paramInt;
  }
  
  private static class ListDataItem
  {
    Feed Feed;
    String Name;
    Track Track;
    
    public ListDataItem(String paramString, Track paramTrack, Feed paramFeed)
    {
      this.Name = paramString;
      this.Track = paramTrack;
      this.Feed = paramFeed;
    }
  }
  
  private static class PodcastsViewItem
  {
    ImageView AddRemovePlaylist;
    TextView Description;
    TextView Duration;
    View EpisodeNotes;
    ImageView InPlaylist;
    View ItemCheckBox;
    View ItemImageArea;
    View MovieOverlay;
    ImageView NowPlaying;
    ImageView OverlayImage;
    View PlayedPortionIndicator;
    TextView PodcastDate;
    FadingNetworkImageViewTrack PrimaryImage;
    TextView PrimaryText;
    View StreamableImage;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/PodcastsViewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */