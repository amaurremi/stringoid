package mobi.beyondpod.ui.views;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import com.mobeta.android.dslv.DragSortListView;
import com.mobeta.android.dslv.DragSortListView.DragListener;
import com.mobeta.android.dslv.DragSortListView.DropListener;
import java.io.File;
import java.util.List;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.downloadengine.EnclosureDownloadManager;
import mobi.beyondpod.downloadengine.EnclosureDownloadManager.DownloadableEnclosure;
import mobi.beyondpod.downloadengine.UpdateAndDownloadManager;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.rss.entities.RssEnclosure;
import mobi.beyondpod.services.player.CategoryPlaylistTemplate;
import mobi.beyondpod.services.player.PlayList;
import mobi.beyondpod.services.player.SmartPlaylistTemplate;
import mobi.beyondpod.ui.commands.CommandManager;

public class PlaylistEditorListView
  extends DragSortListView
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private static final String ADD_FROM_SMART_PLAY = CoreHelper.LoadResourceString(2131297163);
  private static final String ADD_LATEST_5_AUDIO;
  private static final String ADD_LATEST_5_VIDEO = CoreHelper.LoadResourceString(2131297165);
  private static final int MENU_DELETE_PODCAST = 34;
  static final int MENU_FIRST = 30;
  private static final int MENU_MOVE_TO_BOTTOM = 36;
  private static final int MENU_MOVE_TO_TOP = 35;
  private static final int MENU_PODCAST_INFO = 39;
  private static final int MENU_REMOVE_FROM_PLAYLIST = 31;
  private static final int MENU_RESUME_OR_STOP_DOWNLOAD = 33;
  private static final int MENU_SHARE_PODCAST_URL = 38;
  private static final int MENU_TOGGLE_PLAYED = 32;
  private PlaylistEditorListViewAdapter _Adapter;
  private DragSortListView.DragListener _DragListener = new DragSortListView.DragListener()
  {
    public void drag(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      PlaylistEditorListView.this.clearChoices();
    }
  };
  private DragSortListView.DropListener _DropListener = new DragSortListView.DropListener()
  {
    public void drop(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      BeyondPodApplication.GetInstance().PlayList().MoveTrack(paramAnonymousInt1, paramAnonymousInt2);
      PlaylistEditorListView.this.Refresh();
    }
  };
  private boolean _EditMode = false;
  long _LastTouchTime;
  private IPlaylitOwner _Owner = null;
  
  static
  {
    ADD_LATEST_5_AUDIO = CoreHelper.LoadResourceString(2131297164);
  }
  
  public PlaylistEditorListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private PlayList PlayList()
  {
    return BeyondPodApplication.GetInstance().PlayList();
  }
  
  public void AddEpisodes()
  {
    Object localObject = ADD_FROM_SMART_PLAY;
    String str1 = ADD_LATEST_5_AUDIO;
    String str2 = ADD_LATEST_5_VIDEO;
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(getContext());
    DialogInterface.OnClickListener local3 = new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = null;
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          if ((paramAnonymousDialogInterface != null) && (paramAnonymousDialogInterface.size() > 0))
          {
            BeyondPodApplication.GetInstance().PlayList().AddTracks(paramAnonymousDialogInterface);
            if (BeyondPodApplication.GetInstance().PlayList().CurrentTrack() == null) {
              BeyondPodApplication.GetInstance().PlayList().SetCurrentTrack(0);
            }
          }
          do
          {
            return;
            paramAnonymousDialogInterface = new SmartPlaylistTemplate();
          } while (!paramAnonymousDialogInterface.IsLoaded());
          if (paramAnonymousDialogInterface.IsEmpty())
          {
            CommandManager.CmdEditSmartPlayList();
            return;
          }
          paramAnonymousDialogInterface = paramAnonymousDialogInterface.GeneratePlaylist();
          continue;
          paramAnonymousDialogInterface = CategoryPlaylistTemplate.GeneratePlaylist(CategoryManager.AllFeeds, 10, 3, 1, BeyondPodApplication.GetInstance().PlayList().GetTracks());
          continue;
          paramAnonymousDialogInterface = CategoryPlaylistTemplate.GeneratePlaylist(CategoryManager.AllFeeds, 10, 3, 2, BeyondPodApplication.GetInstance().PlayList().GetTracks());
        }
      }
    };
    localObject = localBuilder.setItems(new String[] { localObject, str1, str2 }, local3);
    ((AlertDialog.Builder)localObject).setCancelable(true);
    ((AlertDialog.Builder)localObject).create().show();
  }
  
  public void BatchSelect(SparseBooleanArray paramSparseBooleanArray)
  {
    clearChoices();
    int i = 0;
    for (;;)
    {
      if (i >= paramSparseBooleanArray.size())
      {
        Refresh();
        return;
      }
      setItemChecked(paramSparseBooleanArray.keyAt(i), true);
      i += 1;
    }
  }
  
  public void DisableEditMode()
  {
    this._EditMode = false;
    setChoiceMode(0);
    clearChoices();
    Refresh();
  }
  
  public void EnableEditMode()
  {
    this._EditMode = true;
    setChoiceMode(2);
    Refresh();
  }
  
  void InitializeView(IPlaylitOwner paramIPlaylitOwner)
  {
    this._Owner = paramIPlaylitOwner;
    this._Adapter = new PlaylistEditorListViewAdapter(getContext(), this);
    setAdapter(this._Adapter);
    this._Adapter.setIfEmptyText(getResources().getText(2131296941));
    setCacheColorHint(0);
    setDragListener(this._DragListener);
    setDropListener(this._DropListener);
    setOnItemClickListener(this);
  }
  
  public boolean IsEmpty()
  {
    return this._Adapter.getPodcastCount() == 0;
  }
  
  protected void OnItemChecked(int paramInt)
  {
    this._Owner.RefreshTitle();
  }
  
  protected void OnItemSelected(int paramInt)
  {
    Track localTrack = getTrackAt(paramInt);
    if (localTrack != null)
    {
      if (localTrack.getCurrentPlayState() == 0)
      {
        CommandManager.CmdResumePlayback();
        return;
      }
      if (localTrack.getCurrentPlayState() == 1)
      {
        CommandManager.CmdPauseAudioPlayback();
        return;
      }
      CommandManager.CmdPlayPosition(paramInt);
      return;
    }
    AddEpisodes();
  }
  
  public void Refresh()
  {
    if (this._Adapter != null) {
      this._Adapter.Refresh();
    }
  }
  
  public void RefreshTrack(Track paramTrack)
  {
    if ((this._Adapter != null) && (isDragIdle()))
    {
      this._Adapter.RefreshTrack(paramTrack);
      if (System.currentTimeMillis() - this._LastTouchTime > 20000L) {
        SelectCurrentEpisode();
      }
    }
  }
  
  public void SelectCurrentEpisode()
  {
    Track localTrack = BeyondPodApplication.GetInstance().PlayList().CurrentTrack();
    if (localTrack != null)
    {
      int i = this._Adapter.getTrackIndex(localTrack);
      if (i >= 0) {
        setSelection(i);
      }
    }
  }
  
  public void clearAllChecked()
  {
    clearChoices();
    Refresh();
  }
  
  public TrackList getCheckedTracks()
  {
    TrackList localTrackList = new TrackList();
    SparseBooleanArray localSparseBooleanArray = getCheckedItemPositions();
    if (localSparseBooleanArray == null) {}
    for (;;)
    {
      return localTrackList;
      int i = 0;
      while (i != this._Adapter.getCount())
      {
        if (localSparseBooleanArray.get(i))
        {
          Track localTrack = this._Adapter.getTrackAt(i);
          if (localTrack != null) {
            localTrackList.add(localTrack);
          }
        }
        i += 1;
      }
    }
  }
  
  public Track getTrackAt(int paramInt)
  {
    return this._Adapter.getTrackAt(paramInt);
  }
  
  public boolean isEditModeEnabled()
  {
    return this._EditMode;
  }
  
  public void onClick(View paramView)
  {
    Track localTrack = (Track)paramView.getTag();
    if (localTrack == null) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    }
    CommandManager.CmdOpenTrackPropertiesDialog(localTrack);
  }
  
  boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    AdapterView.AdapterContextMenuInfo localAdapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo();
    Track localTrack = null;
    if (localAdapterContextMenuInfo != null) {
      localTrack = getTrackAt(localAdapterContextMenuInfo.position);
    }
    if (localTrack == null) {
      return false;
    }
    switch (paramMenuItem.getItemId())
    {
    case 37: 
    default: 
      return false;
    case 31: 
      CommandManager.CmdRemoveFromPlaylist(localTrack);
      return true;
    case 32: 
      CommandManager.CmdTogglePlayedState(localTrack);
      return true;
    case 34: 
      paramMenuItem = new TrackList();
      paramMenuItem.add(localTrack);
      CommandManager.CmdDeletePodcasts(getContext(), paramMenuItem);
      return true;
    case 36: 
      paramMenuItem = new TrackList();
      paramMenuItem.add(localTrack);
      PlayList().MoveTracks(paramMenuItem, 2);
      return true;
    case 35: 
      paramMenuItem = new TrackList();
      paramMenuItem.add(localTrack);
      PlayList().MoveTracks(paramMenuItem, 1);
      return true;
    case 33: 
      paramMenuItem = new File(localTrack.TrackPath());
      paramMenuItem = new RssEnclosure(localTrack.getUrl(), paramMenuItem.getParent(), paramMenuItem.getName(), localTrack.ContentMimeType(), localTrack.RssItemID(), localTrack.getDownloadSize(), localTrack.getLastModifiedDate(), localTrack.DisplayName());
      if (localTrack.getDownloadStatus() == 2) {
        UpdateAndDownloadManager.TerminateAll();
      }
      for (;;)
      {
        return true;
        if (EnclosureDownloadManager.IsDownloadPending(paramMenuItem))
        {
          EnclosureDownloadManager.RemoveFromQueue(paramMenuItem);
        }
        else
        {
          paramMenuItem = new EnclosureDownloadManager.DownloadableEnclosure(localTrack.getParentFeed(), paramMenuItem);
          FeedContentListView.DownloadEnclosures(getContext(), paramMenuItem);
        }
      }
    case 38: 
      CommandManager.CmdSharePodcast(getContext(), localTrack);
      return true;
    }
    CommandManager.CmdOpenTrackPropertiesDialog(localTrack);
    return true;
  }
  
  void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    int i = 2131296646;
    if (isEditModeEnabled()) {}
    do
    {
      return;
      paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      paramView = null;
      if (paramContextMenuInfo != null) {
        paramView = getTrackAt(paramContextMenuInfo.position);
      }
    } while (paramView == null);
    paramContextMenu.add(0, 31, 0, 2131296642);
    paramContextMenu.add(0, 32, 1, 2131296643);
    paramContextMenu.add(0, 34, 2, 2131296636);
    int j = PlayList().GetTrackPosition(paramView);
    if (j > 0) {
      paramContextMenu.add(0, 35, 3, 2131297158);
    }
    if (j < PlayList().PlaylistSize() - 1) {
      paramContextMenu.add(0, 36, 4, 2131297159);
    }
    if (EnclosureDownloadManager.IsDownloadPending(paramView.getUrl())) {
      paramContextMenu.add(0, 33, 5, 2131296646);
    }
    while (paramView.IsFullyDownloaded())
    {
      if (paramView.HasUrl()) {
        paramContextMenu.add(0, 38, 6, 2131296671).setIcon(2130837983);
      }
      paramContextMenu.add(0, 39, 7, 2131296674);
      return;
    }
    if (paramView.getDownloadStatus() == 2) {}
    for (;;)
    {
      paramContextMenu.add(0, 33, 5, i);
      break;
      if (paramView.getDownloadedPortion() > 0L) {
        i = 2131296647;
      } else {
        i = 2131296648;
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (getChoiceMode() == 0)
    {
      OnItemSelected(paramInt);
      return;
    }
    OnItemChecked(paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this._LastTouchTime = System.currentTimeMillis();
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAllChecked()
  {
    int i = 0;
    for (;;)
    {
      if (i >= getCount())
      {
        Refresh();
        return;
      }
      setItemChecked(i, true);
      i += 1;
    }
  }
  
  public static abstract interface IPlaylitOwner
  {
    public abstract void RefreshTitle();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/PlaylistEditorListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */