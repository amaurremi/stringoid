package mobi.beyondpod.ui.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mobi.beyondpod.downloadengine.EnclosureDownloadManager;
import mobi.beyondpod.downloadengine.EnclosureDownloadManager.DownloadableEnclosure;
import mobi.beyondpod.downloadengine.RssFeedUpdateManager;
import mobi.beyondpod.downloadengine.UpdateAndDownloadManager;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.rss.entities.RssEnclosure;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;

public class UpdateAndDownloadQueueViewAdapter
  extends BaseAdapter
{
  private static final String CONNECTING;
  private static final String DOWNLOADED;
  private static final String UPDATING = CoreHelper.LoadResourceString(2131297103);
  private static final String UPDATING_S = CoreHelper.LoadResourceString(2131297104);
  private static Formatter sInfoTextFormatter = new Formatter(sInfoTextStringBuilder, Locale.getDefault());
  private static StringBuilder sInfoTextStringBuilder;
  private LayoutInflater _Inflater;
  ArrayList<QueleListDataItem> _Items = new ArrayList();
  UpdateAndDownloadQueueActivityDialog _Owner;
  
  static
  {
    DOWNLOADED = CoreHelper.LoadResourceString(2131297105);
    CONNECTING = CoreHelper.LoadResourceString(2131297106);
    sInfoTextStringBuilder = new StringBuilder();
  }
  
  public UpdateAndDownloadQueueViewAdapter(UpdateAndDownloadQueueActivityDialog paramUpdateAndDownloadQueueActivityDialog)
  {
    this._Owner = paramUpdateAndDownloadQueueActivityDialog;
    this._Inflater = LayoutInflater.from(paramUpdateAndDownloadQueueActivityDialog);
  }
  
  private void BuildViewItem(QueueListViewItem paramQueueListViewItem, QueleListDataItem paramQueleListDataItem, ViewGroup paramViewGroup)
  {
    sInfoTextStringBuilder.setLength(0);
    paramQueueListViewItem.RemoveFromQueueBtn.setOnClickListener(this._Owner);
    paramQueueListViewItem.RemoveFromQueueBtn.setTag(paramQueleListDataItem);
    if (paramQueleListDataItem.Enclosure != null)
    {
      TextView localTextView = paramQueueListViewItem.PrimaryText;
      if (paramQueleListDataItem.Enclosure.Enclosure.Parent == null) {
        break label372;
      }
      paramViewGroup = paramQueleListDataItem.Enclosure.Enclosure.Parent.Title;
      localTextView.setText(paramViewGroup);
      paramQueueListViewItem.SecondaryText.setVisibility(0);
      paramQueueListViewItem.RemoveFromQueueBtn.setVisibility(0);
      localTextView = paramQueueListViewItem.SecondaryText;
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramQueleListDataItem.Enclosure.Feed.getName()));
      if ((paramQueleListDataItem.Enclosure.Enclosure.EnclosureFileLength() != null) && (paramQueleListDataItem.Enclosure.Enclosure.EnclosureFileLength().longValue() != 0L)) {
        break label413;
      }
      paramViewGroup = "";
      label150:
      localTextView.setText(paramViewGroup);
      if (paramQueleListDataItem.Enclosure.Enclosure.PlayableState() != 5) {
        break label520;
      }
      paramQueueListViewItem.ItemLayout.setBackgroundColor(822083583);
      paramQueueListViewItem.ProgressText.setVisibility(0);
      paramViewGroup = paramQueleListDataItem.Enclosure.Enclosure.GetLocalEnclosureTrack();
      if (paramViewGroup != null)
      {
        if (paramViewGroup.getDownloadedPortion() != 0L) {
          break label442;
        }
        paramQueueListViewItem.Progress.setVisibility(8);
        paramQueueListViewItem.ProgressIndeterminate.setVisibility(0);
        paramQueueListViewItem.ProgressText.setText(CONNECTING);
      }
    }
    label246:
    if (paramQueleListDataItem.Feed != null)
    {
      paramQueueListViewItem.PrimaryText.setText(paramQueleListDataItem.Feed.getName());
      paramQueueListViewItem.SecondaryText.setVisibility(8);
      paramQueueListViewItem.RemoveFromQueueBtn.setVisibility(8);
      if ((!RssFeedUpdateManager.IsUpdating()) || (RssFeedUpdateManager.CurrentFeed() != paramQueleListDataItem.Feed)) {
        break label696;
      }
      paramQueueListViewItem.ItemLayout.setBackgroundColor(822083583);
      paramQueueListViewItem.ProgressText.setVisibility(0);
      if (paramQueleListDataItem.Feed.getUpdateSize() > 0L) {
        break label609;
      }
      paramQueueListViewItem.Progress.setVisibility(8);
      paramQueueListViewItem.ProgressIndeterminate.setVisibility(0);
      if (paramQueleListDataItem.Feed.getUpdatedPortion() != 0L) {
        break label573;
      }
      paramQueleListDataItem = CONNECTING;
    }
    for (;;)
    {
      paramQueueListViewItem.ProgressText.setText(paramQueleListDataItem);
      return;
      label372:
      if (paramQueleListDataItem.Enclosure.Enclosure.TempTitle != null)
      {
        paramViewGroup = paramQueleListDataItem.Enclosure.Enclosure.TempTitle;
        break;
      }
      paramViewGroup = paramQueleListDataItem.Enclosure.Enclosure.LocalFileName();
      break;
      label413:
      paramViewGroup = " - " + paramQueleListDataItem.Enclosure.Enclosure.EnclosureSizeAsString();
      break label150;
      label442:
      paramQueueListViewItem.Progress.setVisibility(0);
      paramQueueListViewItem.ProgressIndeterminate.setVisibility(8);
      paramQueueListViewItem.Progress.setSecondaryProgress((int)paramViewGroup.getDownloadPercent());
      paramQueueListViewItem.ProgressText.setText(String.format("%s %s%% of %s", new Object[] { DOWNLOADED, Integer.valueOf((int)paramViewGroup.getDownloadPercent()), CoreHelper.GetFileLengthAsString(Long.valueOf(paramViewGroup.getDownloadSize())) }));
      break label246;
      label520:
      if (!EnclosureDownloadManager.IsDownloadPending(paramQueleListDataItem.Enclosure.Enclosure)) {
        break label246;
      }
      paramQueueListViewItem.ItemLayout.setBackgroundColor(285212671);
      paramQueueListViewItem.ProgressText.setVisibility(8);
      paramQueueListViewItem.Progress.setVisibility(8);
      paramQueueListViewItem.ProgressIndeterminate.setVisibility(8);
      break label246;
      label573:
      paramQueleListDataItem = sInfoTextFormatter.format(UPDATING_S, new Object[] { CoreHelper.GetFileLengthAsString(Long.valueOf(paramQueleListDataItem.Feed.getUpdatedPortion())) }).toString();
      continue;
      label609:
      paramViewGroup = sInfoTextFormatter.format("%s %s%% of %s", new Object[] { UPDATING, Integer.valueOf(paramQueleListDataItem.Feed.UpdatePercent()), CoreHelper.GetFileLengthAsString(Long.valueOf(paramQueleListDataItem.Feed.getUpdateSize())) }).toString();
      paramQueueListViewItem.Progress.setVisibility(0);
      paramQueueListViewItem.ProgressIndeterminate.setVisibility(8);
      paramQueueListViewItem.Progress.setSecondaryProgress(paramQueleListDataItem.Feed.UpdatePercent());
      paramQueleListDataItem = paramViewGroup;
    }
    label696:
    paramQueueListViewItem.ItemLayout.setBackgroundColor(285212671);
    paramQueueListViewItem.ProgressText.setVisibility(8);
    paramQueueListViewItem.Progress.setVisibility(8);
    paramQueueListViewItem.ProgressIndeterminate.setVisibility(8);
  }
  
  public void Clear()
  {
    this._Items.clear();
  }
  
  public void Refresh()
  {
    this._Items.clear();
    Iterator localIterator;
    if ((UpdateAndDownloadManager.HasWorkToDo()) || (EnclosureDownloadManager.QueueCount() > 0))
    {
      localIterator = RssFeedUpdateManager.UpdateQueue().iterator();
      if (localIterator.hasNext()) {
        break label85;
      }
      localIterator = EnclosureDownloadManager.DownloadQueue().iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        if (this._Items.size() == 0) {
          this._Items.add(new QueleListDataItem(null, null));
        }
        notifyDataSetChanged();
        return;
        label85:
        localObject = (Feed)localIterator.next();
        this._Items.add(new QueleListDataItem((Feed)localObject, null));
        break;
      }
      Object localObject = (EnclosureDownloadManager.DownloadableEnclosure)localIterator.next();
      this._Items.add(new QueleListDataItem(null, (EnclosureDownloadManager.DownloadableEnclosure)localObject));
    }
  }
  
  public int getCount()
  {
    return this._Items.size();
  }
  
  public EnclosureDownloadManager.DownloadableEnclosure getEnclosureAt(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if (localObject != null) {
      return ((QueleListDataItem)localObject).Enclosure;
    }
    return null;
  }
  
  public Feed getFeedAt(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if (localObject != null) {
      return ((QueleListDataItem)localObject).Feed;
    }
    return null;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < getCount()) {
      return this._Items.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    QueleListDataItem localQueleListDataItem = (QueleListDataItem)this._Items.get(paramInt);
    if ((localQueleListDataItem.Feed == null) && (localQueleListDataItem.Enclosure == null)) {
      return -1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    QueleListDataItem localQueleListDataItem = (QueleListDataItem)this._Items.get(paramInt);
    Object localObject = paramView;
    try
    {
      if (localQueleListDataItem.Enclosure == null)
      {
        localObject = paramView;
        if (localQueleListDataItem.Feed == null) {}
      }
      else
      {
        QueueListViewItem localQueueListViewItem;
        if (paramView == null)
        {
          localObject = paramView;
          paramView = this._Inflater.inflate(2130903174, null);
          localObject = paramView;
          localQueueListViewItem = new QueueListViewItem(null);
          localObject = paramView;
          localQueueListViewItem.PrimaryText = ((TextView)paramView.findViewById(2131231221));
          localObject = paramView;
          localQueueListViewItem.SecondaryText = ((TextView)paramView.findViewById(2131231222));
          localObject = paramView;
          localQueueListViewItem.ProgressText = ((TextView)paramView.findViewById(2131231226));
          localObject = paramView;
          localQueueListViewItem.Progress = ((SeekBar)paramView.findViewById(2131231224));
          localObject = paramView;
          localQueueListViewItem.ProgressIndeterminate = ((SeekBar)paramView.findViewById(2131231225));
          localObject = paramView;
          localQueueListViewItem.ItemLayout = paramView.findViewById(2131231218);
          localObject = paramView;
          localQueueListViewItem.RemoveFromQueueBtn = ((ImageView)paramView.findViewById(2131231223));
          localObject = paramView;
          paramView.setTag(localQueueListViewItem);
        }
        for (;;)
        {
          localObject = paramView;
          BuildViewItem(localQueueListViewItem, localQueleListDataItem, paramViewGroup);
          return paramView;
          localObject = paramView;
          localQueueListViewItem = (QueueListViewItem)paramView.getTag();
        }
      }
      paramViewGroup = paramView;
      if (paramView == null)
      {
        localObject = paramView;
        paramViewGroup = this._Inflater.inflate(2130903173, null);
      }
      localObject = paramViewGroup;
      paramView = (TextView)paramViewGroup;
      localObject = paramViewGroup;
      if (UpdateAndDownloadManager.HasWorkToDo())
      {
        localObject = paramViewGroup;
        paramView.setText(2131296881);
        return paramViewGroup;
      }
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
      return (View)localObject;
    }
    localObject = paramViewGroup;
    paramView.setText(2131296880);
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return true;
  }
  
  public static class QueleListDataItem
  {
    EnclosureDownloadManager.DownloadableEnclosure Enclosure;
    Feed Feed;
    
    public QueleListDataItem(Feed paramFeed, EnclosureDownloadManager.DownloadableEnclosure paramDownloadableEnclosure)
    {
      this.Feed = paramFeed;
      this.Enclosure = paramDownloadableEnclosure;
    }
  }
  
  private static class QueueListViewItem
  {
    View ItemLayout;
    TextView PrimaryText;
    SeekBar Progress;
    SeekBar ProgressIndeterminate;
    TextView ProgressText;
    ImageView RemoveFromQueueBtn;
    TextView SecondaryText;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/UpdateAndDownloadQueueViewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */