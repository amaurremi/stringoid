package mobi.beyondpod.ui.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.TextUtils.TruncateAt;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.R.styleable;
import mobi.beyondpod.downloadengine.EnclosureDownloadManager;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.categories.FeedCategories;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.services.player.PlayList;
import mobi.beyondpod.ui.core.CheckableRelativeLayout;
import mobi.beyondpod.ui.core.InertCheckBox;

public class PlaylistEditorListViewAdapter
  extends BaseAdapter
{
  private static final String DOWNLOADED = CoreHelper.LoadResourceString(2131297098);
  private static final String DOWNLOADING = CoreHelper.LoadResourceString(2131297099);
  private static final String DOWNLOAD_PENDING = CoreHelper.LoadResourceString(2131297097);
  int _CurrentPlayingTrackPos = -1;
  Runnable _DelayedRefreshRunnable = new Runnable()
  {
    public void run()
    {
      PlaylistEditorListViewAdapter.this.notifyDataSetChanged();
    }
  };
  private CharSequence _IfEmptyText;
  private LayoutInflater _Inflater;
  ArrayList<Track> _Items = new ArrayList();
  private PlaylistEditorListView _ListView;
  private ColorStateList _Played;
  private int _PodcastCount;
  private ColorStateList _Unplayed;
  
  public PlaylistEditorListViewAdapter(Context paramContext, PlaylistEditorListView paramPlaylistEditorListView)
  {
    this._Inflater = LayoutInflater.from(paramContext);
    this._ListView = paramPlaylistEditorListView;
    paramContext = paramContext.obtainStyledAttributes(R.styleable.FeedContentListViewItemColors);
    this._Unplayed = paramContext.getColorStateList(0);
    this._Played = paramContext.getColorStateList(1);
    paramContext.recycle();
  }
  
  private void BuildViewItem(PlayListViewItem paramPlayListViewItem, Track paramTrack, ViewGroup paramViewGroup)
  {
    paramPlayListViewItem.TrackText.setText(paramTrack.DisplayName());
    Object localObject = paramPlayListViewItem.TrackText;
    label61:
    label103:
    int i;
    if (paramTrack.IsPlayed())
    {
      paramViewGroup = this._Played;
      ((TextView)localObject).setTextColor(paramViewGroup);
      if ((!paramTrack.HasDownloadStarted()) || (paramTrack.IsFullyDownloaded())) {
        break label407;
      }
      if (paramTrack.getDownloadStatus() != 2) {
        break label352;
      }
      paramViewGroup = DOWNLOADING;
      if (paramTrack.getDownloadSize() > 0L) {
        break label359;
      }
      paramPlayListViewItem.TrackFeed.setText(String.format("%s %s", new Object[] { paramViewGroup, CoreHelper.GetFileLengthAsString(Long.valueOf(paramTrack.getDownloadedPortion())) }));
      paramPlayListViewItem.EpisodeNotes.setOnClickListener(this._ListView);
      paramPlayListViewItem.EpisodeNotes.setTag(paramTrack);
      paramViewGroup = paramTrack.getParentFeed().getCategories().getPrimary();
      localObject = paramTrack.getParentFeed().getCategories().getSecondary();
      int j = paramViewGroup.Color();
      i = j;
      if (j == 0) {
        i = ((FeedCategory)localObject).Color();
      }
      paramPlayListViewItem.CategoryColor.setBackgroundColor(i);
      localObject = paramPlayListViewItem.TrackText;
      if (!paramTrack.getParentFeed().getLeftTruncateLongTrackNames()) {
        break label476;
      }
      paramViewGroup = TextUtils.TruncateAt.START;
      label196:
      ((TextView)localObject).setEllipsize(paramViewGroup);
      i = paramTrack.getCurrentPlayState();
      if (i != 1) {
        break label483;
      }
      paramPlayListViewItem.IsPlayingIndicator.setImageResource(2130837993);
      label223:
      paramPlayListViewItem.DragHandle.setVisibility(0);
      if (!this._ListView.isEditModeEnabled()) {
        break label573;
      }
      paramPlayListViewItem.CheckBox.setVisibility(0);
      paramPlayListViewItem.ItemLayout.setCheckDisabled(false);
      label257:
      if ((paramTrack.getPlayedTime() <= 0L) && (!paramTrack.IsPlayed())) {
        break label593;
      }
      paramPlayListViewItem.PlayedPortionIndicator.setVisibility(0);
      paramPlayListViewItem.PlayedPortionIndicator.setProgress((int)(paramTrack.PlayedAsFraction() * 100.0F));
      label297:
      paramViewGroup = paramPlayListViewItem.StreamableImage;
      if (!paramTrack.HasDownloadStarted()) {
        break label604;
      }
      i = 8;
      label313:
      paramViewGroup.setVisibility(i);
      paramViewGroup = paramPlayListViewItem.TrackDuration;
      if (paramTrack.getTotalTime() <= 0L) {
        break label610;
      }
    }
    label352:
    label359:
    label407:
    label476:
    label483:
    label573:
    label593:
    label604:
    label610:
    for (paramPlayListViewItem = paramTrack.TotalTimeAsString();; paramPlayListViewItem = "")
    {
      paramViewGroup.setText(paramPlayListViewItem);
      return;
      paramViewGroup = this._Unplayed;
      break;
      paramViewGroup = DOWNLOADED;
      break label61;
      paramPlayListViewItem.TrackFeed.setText(String.format("%s %s%% of %s", new Object[] { paramViewGroup, Integer.valueOf((int)paramTrack.getDownloadPercent()), CoreHelper.GetFileLengthAsString(Long.valueOf(paramTrack.getDownloadSize())) }));
      break label103;
      if (EnclosureDownloadManager.IsDownloadPending(paramTrack.getUrl()))
      {
        paramPlayListViewItem.TrackFeed.setText(DOWNLOAD_PENDING);
        break label103;
      }
      paramPlayListViewItem.TrackFeed.setText(DateTime.FormatDateTimeToday(paramTrack.getLastModifiedDate()) + " - " + paramTrack.getParentFeed().getName());
      break label103;
      paramViewGroup = TextUtils.TruncateAt.END;
      break label196;
      if ((i == 3) || (i == 6))
      {
        paramPlayListViewItem.IsPlayingIndicator.setImageResource(2130837994);
        break label223;
      }
      if ((i == 7) || (i == 8))
      {
        paramPlayListViewItem.IsPlayingIndicator.setImageResource(2130837991);
        break label223;
      }
      if (paramTrack == BeyondPodApplication.GetInstance().PlayList().CurrentTrack())
      {
        paramPlayListViewItem.IsPlayingIndicator.setImageResource(2130837992);
        break label223;
      }
      paramPlayListViewItem.IsPlayingIndicator.setImageDrawable(null);
      break label223;
      paramPlayListViewItem.CheckBox.setVisibility(8);
      paramPlayListViewItem.ItemLayout.setCheckDisabled(true);
      break label257;
      paramPlayListViewItem.PlayedPortionIndicator.setVisibility(4);
      break label297;
      i = 0;
      break label313;
    }
  }
  
  private void LoadPlayList(Track paramTrack)
  {
    this._Items.clear();
    this._PodcastCount = BeyondPodApplication.GetInstance().PlayList().PlaylistSize();
    float f;
    if (this._PodcastCount == 0)
    {
      this._Items.add(null);
      notifyDataSetChanged();
      if (this._Items.size() <= 20) {
        break label109;
      }
      f = 2.0F;
    }
    for (;;)
    {
      this._ListView.setMaxScrollSpeed(f);
      return;
      paramTrack = BeyondPodApplication.GetInstance().PlayList().GetTracks().iterator();
      while (paramTrack.hasNext())
      {
        Track localTrack = (Track)paramTrack.next();
        this._Items.add(localTrack);
      }
      break;
      label109:
      if (this._Items.size() > 40) {
        f = 3.0F;
      } else {
        f = 4.0F;
      }
    }
  }
  
  public void Clear()
  {
    this._Items.clear();
  }
  
  public void Refresh()
  {
    LoadPlayList(null);
  }
  
  public void RefreshTrack(Track paramTrack)
  {
    notifyDataSetChanged();
  }
  
  public SparseBooleanArray TrackLocations(List<Track> paramList)
  {
    SparseBooleanArray localSparseBooleanArray = new SparseBooleanArray(paramList.size());
    paramList = paramList.iterator();
    for (;;)
    {
      if (!paramList.hasNext()) {
        return localSparseBooleanArray;
      }
      int i = getTrackIndex((Track)paramList.next());
      if (i >= 0) {
        localSparseBooleanArray.append(i, true);
      }
    }
  }
  
  public boolean areAllItemsSelectable()
  {
    return false;
  }
  
  public int getCount()
  {
    return this._Items.size();
  }
  
  public Track getItem(int paramInt)
  {
    if (paramInt < getCount()) {
      return (Track)this._Items.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this._PodcastCount == 0) {
      return -1;
    }
    return 0;
  }
  
  public int getPodcastCount()
  {
    return this._PodcastCount;
  }
  
  public Track getTrackAt(int paramInt)
  {
    Track localTrack = getItem(paramInt);
    if (localTrack != null) {
      return localTrack;
    }
    return null;
  }
  
  public int getTrackIndex(Track paramTrack)
  {
    if (paramTrack == null) {
      return -1;
    }
    return this._Items.indexOf(paramTrack);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Track localTrack = (Track)this._Items.get(paramInt);
    if (this._PodcastCount == 0)
    {
      paramView = this._Inflater.inflate(2130903149, null);
      ((TextView)paramView.findViewById(2131231091)).setText(this._IfEmptyText);
      return paramView;
    }
    View localView = paramView;
    if (localTrack != null)
    {
      if (paramView == null) {
        localView = paramView;
      }
      for (;;)
      {
        try
        {
          paramView = this._Inflater.inflate(2130903147, null);
          localView = paramView;
          localPlayListViewItem = new PlayListViewItem(null);
          localView = paramView;
          localPlayListViewItem.ItemLayout = ((CheckableRelativeLayout)paramView.findViewById(2131231148));
          localView = paramView;
          localPlayListViewItem.DragHandle = ((ImageView)paramView.findViewById(2131230885));
          localView = paramView;
          localPlayListViewItem.TrackText = ((TextView)paramView.findViewById(2131231151));
          localView = paramView;
          localPlayListViewItem.TrackDuration = ((TextView)paramView.findViewById(2131230937));
          localView = paramView;
          localPlayListViewItem.TrackFeed = ((TextView)paramView.findViewById(2131231153));
          localView = paramView;
          localPlayListViewItem.IsPlayingIndicator = ((ImageView)paramView.findViewById(2131231152));
          localView = paramView;
          localPlayListViewItem.StreamableImage = ((TextView)paramView.findViewById(2131230850));
          localView = paramView;
          localPlayListViewItem.PlayedPortionIndicator = ((ProgressBar)paramView.findViewById(2131230938));
          localView = paramView;
          localPlayListViewItem.PlayedPortionIndicator.setMax(100);
          localView = paramView;
          localPlayListViewItem.CheckBox = ((InertCheckBox)paramView.findViewById(2131231150));
          localView = paramView;
          localPlayListViewItem.CategoryColor = paramView.findViewById(2131230886);
          localView = paramView;
          localPlayListViewItem.EpisodeNotes = paramView.findViewById(2131230951);
          localView = paramView;
          paramView.setTag(localPlayListViewItem);
          localView = paramView;
          BuildViewItem(localPlayListViewItem, localTrack, paramViewGroup);
          localView = paramView;
        }
        catch (Exception paramView)
        {
          PlayListViewItem localPlayListViewItem;
          paramView.printStackTrace();
        }
        localView = paramView;
        localPlayListViewItem = (PlayListViewItem)paramView.getTag();
      }
    }
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return true;
  }
  
  public void setIfEmptyText(CharSequence paramCharSequence)
  {
    this._IfEmptyText = paramCharSequence;
  }
  
  private static class PlayListViewItem
  {
    View CategoryColor;
    InertCheckBox CheckBox;
    ImageView DragHandle;
    View EpisodeNotes;
    ImageView IsPlayingIndicator;
    CheckableRelativeLayout ItemLayout;
    ProgressBar PlayedPortionIndicator;
    TextView StreamableImage;
    TextView TrackDuration;
    TextView TrackFeed;
    TextView TrackText;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/PlaylistEditorListViewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */