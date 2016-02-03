package mobi.beyondpod.ui.views;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.downloadengine.UpdateAndDownloadEvents.UpdateAndDownloadEvent;
import mobi.beyondpod.downloadengine.UpdateAndDownloadEvents.UpdateAndDownloadEventListener;
import mobi.beyondpod.downloadengine.UpdateAndDownloadManager;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.CoreHelper.TrackSizeInfo;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEvent;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEventListener;
import mobi.beyondpod.services.player.PlayList;
import mobi.beyondpod.services.player.PlayListEvents.PlayListEvent;
import mobi.beyondpod.services.player.PlayListEvents.PlayListEventListener;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.core.ActionBarActivityBase;
import mobi.beyondpod.ui.core.ActionBarHelper;
import mobi.beyondpod.ui.core.ThemeManager;
import mobi.beyondpod.ui.dialogs.DeletePodcastDialog;
import mobi.beyondpod.ui.dialogs.DeletePodcastDialog.ICompletionListener;
import mobi.beyondpod.ui.views.base.ActionModeBP;
import mobi.beyondpod.ui.views.base.ActionModeBP.Callback;
import mobi.beyondpod.ui.views.notifications.UserNotificationManager;

public class PlaylistEditorActivity
  extends ActionBarActivityBase
  implements PlayListEvents.PlayListEventListener, RepositoryEvents.RepositoryEventListener, UpdateAndDownloadEvents.UpdateAndDownloadEventListener, PlaylistEditorListView.IPlaylitOwner
{
  private static final String ABOUT = CoreHelper.LoadResourceString(2131297085);
  public static final String EXTRA_OPEN_IN_EDIT = "OpenInEdit";
  private static final String PLAYLIST;
  private static final String TAG = PlaylistEditorActivity.class.getSimpleName();
  private ActionModeBP _CurrentActionMode;
  PlaylistEditorListView _PlaylistListView;
  private ActionModeBP.Callback mContentSelectionActionModeCallback = new ActionModeBP.Callback()
  {
    public boolean onActionItemClicked(ActionModeBP paramAnonymousActionModeBP, MenuItem paramAnonymousMenuItem)
    {
      SparseBooleanArray localSparseBooleanArray = new SparseBooleanArray();
      int j = PlaylistEditorActivity.this.PlayList().PlaylistSize();
      switch (paramAnonymousMenuItem.getItemId())
      {
      case 2131231261: 
      default: 
        PlaylistEditorActivity.this.onOptionsItemSelected(paramAnonymousMenuItem);
      }
      int i;
      do
      {
        do
        {
          for (;;)
          {
            PlaylistEditorActivity.this.RefreshTitle();
            return true;
            paramAnonymousMenuItem = PlaylistEditorActivity.this._PlaylistListView.getCheckedTracks();
            if (paramAnonymousMenuItem.size() > 0)
            {
              PlaylistEditorActivity.this.PlayList().RemoveTracks(paramAnonymousMenuItem);
              PlaylistEditorActivity.this._PlaylistListView.clearAllChecked();
              if (PlaylistEditorActivity.this.PlayList().PlaylistSize() == 0) {
                paramAnonymousActionModeBP.finish();
              }
            }
            else
            {
              PlaylistEditorActivity.this._PlaylistListView.AddEpisodes();
              continue;
              PlaylistEditorActivity.this._PlaylistListView.setAllChecked();
              continue;
              PlaylistEditorActivity.this._PlaylistListView.clearAllChecked();
            }
          }
          i = 0;
          for (;;)
          {
            if (i >= j)
            {
              PlaylistEditorActivity.this._PlaylistListView.BatchSelect(localSparseBooleanArray);
              break;
            }
            if (PlaylistEditorActivity.this._PlaylistListView.getTrackAt(i).IsPlayed()) {
              localSparseBooleanArray.append(i, true);
            }
            i += 1;
          }
          j = PlaylistEditorActivity.this.PlayList().GetPreviousTrackPosition();
        } while (j == -1);
        i = 0;
        for (;;)
        {
          if (i > j)
          {
            PlaylistEditorActivity.this._PlaylistListView.BatchSelect(localSparseBooleanArray);
            break;
          }
          localSparseBooleanArray.append(i, true);
          i += 1;
        }
        i = PlaylistEditorActivity.this.PlayList().GetNextTrackPosition();
      } while (i == -1);
      for (;;)
      {
        if (i >= j)
        {
          PlaylistEditorActivity.this._PlaylistListView.BatchSelect(localSparseBooleanArray);
          break;
        }
        localSparseBooleanArray.append(i, true);
        i += 1;
      }
    }
    
    public void onAfterActionModeCreate(ActionModeBP paramAnonymousActionModeBP) {}
    
    public boolean onCreateActionMode(ActionModeBP paramAnonymousActionModeBP, Menu paramAnonymousMenu)
    {
      paramAnonymousMenu.clear();
      PlaylistEditorActivity.this._PlaylistListView.EnableEditMode();
      PlaylistEditorActivity.this.getMenuInflater().inflate(2131755013, paramAnonymousMenu);
      return true;
    }
    
    public void onDestroyActionMode(ActionModeBP paramAnonymousActionModeBP)
    {
      PlaylistEditorActivity.this._PlaylistListView.DisableEditMode();
      PlaylistEditorActivity.this._CurrentActionMode = null;
      PlaylistEditorActivity.this.RefreshTitle();
    }
    
    public boolean onUpdateActionModeToolsVisibility(ActionModeBP paramAnonymousActionModeBP, Menu paramAnonymousMenu)
    {
      Object localObject = PlaylistEditorActivity.this._PlaylistListView.getCheckedTracks();
      boolean bool1;
      MenuItem localMenuItem;
      label61:
      label89:
      label126:
      label163:
      label200:
      int i;
      if (((TrackList)localObject).size() > 0)
      {
        bool1 = true;
        localMenuItem = paramAnonymousMenu.findItem(2131231260);
        if (((TrackList)localObject).size() <= 0) {
          break label378;
        }
        localMenuItem.setIcon(2130837971);
        localMenuItem.setTitle(2131296642);
        localObject = paramAnonymousMenu.findItem(2131231255);
        if ((PlayList.IsEmpty()) || (paramAnonymousActionModeBP.isEmulated())) {
          break label401;
        }
        bool2 = true;
        ((MenuItem)localObject).setVisible(bool2);
        localObject = paramAnonymousMenu.findItem(2131231257);
        if ((!bool1) || (paramAnonymousActionModeBP.isEmulated())) {
          break label407;
        }
        bool2 = true;
        ((MenuItem)localObject).setVisible(bool2);
        localObject = paramAnonymousMenu.findItem(2131231258);
        if ((!bool1) || (paramAnonymousActionModeBP.isEmulated())) {
          break label413;
        }
        bool2 = true;
        ((MenuItem)localObject).setVisible(bool2);
        localObject = paramAnonymousMenu.findItem(2131231259);
        if ((!bool1) || (paramAnonymousActionModeBP.isEmulated())) {
          break label419;
        }
        bool2 = true;
        ((MenuItem)localObject).setVisible(bool2);
        bool2 = false;
        i = 0;
        label215:
        if (i < PlaylistEditorActivity.this.PlayList().PlaylistSize()) {
          break label425;
        }
        label229:
        paramAnonymousActionModeBP = paramAnonymousMenu.findItem(2131231261);
        paramAnonymousActionModeBP.getSubMenu().findItem(2131231262).setVisible(bool2);
        paramAnonymousMenu = paramAnonymousActionModeBP.getSubMenu().findItem(2131231263);
        localObject = paramAnonymousActionModeBP.getSubMenu().findItem(2131231264);
        i = PlaylistEditorActivity.this.PlayList().GetCurrentPlayingTrackPosition();
        if (i <= 0) {
          break label455;
        }
        bool2 = true;
        label306:
        paramAnonymousMenu.setVisible(bool2);
        if ((i == -1) || (i >= PlaylistEditorActivity.this.PlayList().PlaylistSize() - 1)) {
          break label461;
        }
      }
      label378:
      label401:
      label407:
      label413:
      label419:
      label425:
      label455:
      label461:
      for (boolean bool2 = true;; bool2 = false)
      {
        ((MenuItem)localObject).setVisible(bool2);
        paramAnonymousActionModeBP.getSubMenu().findItem(2131231266).setVisible(bool1);
        return false;
        bool1 = false;
        break;
        localMenuItem.setIcon(2130837970);
        localMenuItem.setTitle(2131296638);
        break label61;
        bool2 = false;
        break label89;
        bool2 = false;
        break label126;
        bool2 = false;
        break label163;
        bool2 = false;
        break label200;
        if (PlaylistEditorActivity.this._PlaylistListView.getTrackAt(i).IsPlayed())
        {
          bool2 = true;
          break label229;
        }
        i += 1;
        break label215;
        bool2 = false;
        break label306;
      }
    }
  };
  
  static
  {
    PLAYLIST = CoreHelper.LoadResourceString(2131297096);
  }
  
  private PlayList PlayList()
  {
    return BeyondPodApplication.GetInstance().PlayList();
  }
  
  public boolean EndActionMode()
  {
    if (this._CurrentActionMode != null)
    {
      this._CurrentActionMode.finish();
      return true;
    }
    return false;
  }
  
  public void OnPlayListEvent(PlayListEvents.PlayListEvent paramPlayListEvent)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        PlaylistEditorActivity.this._PlaylistListView.Refresh();
        PlaylistEditorActivity.this.RefreshTitle();
      }
    });
  }
  
  public void OnRepositoryEvent(final RepositoryEvents.RepositoryEvent paramRepositoryEvent)
  {
    if ((paramRepositoryEvent.Type == 11) && (paramRepositoryEvent.Track != null)) {
      runOnUiThread(new Runnable()
      {
        public void run()
        {
          PlaylistEditorActivity.this._PlaylistListView.RefreshTrack(paramRepositoryEvent.Track);
          PlaylistEditorActivity.this.RefreshTitle();
        }
      });
    }
  }
  
  public void OnUpdateAndDownloadEvent(UpdateAndDownloadEvents.UpdateAndDownloadEvent paramUpdateAndDownloadEvent)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        PlaylistEditorActivity.this._PlaylistListView.Refresh();
        PlaylistEditorActivity.this.RefreshTitle();
      }
    });
  }
  
  public void RefreshTitle()
  {
    PlayList localPlayList = PlayList();
    if (this._CurrentActionMode != null)
    {
      this._CurrentActionMode.setTitle(getResources().getString(2131297157));
      localObject = this._PlaylistListView.getCheckedTracks();
      if (localPlayList.PlaylistSize() > 0)
      {
        localActionModeBP = this._CurrentActionMode;
        if (((TrackList)localObject).size() > 0)
        {
          localObject = ((TrackList)localObject).size() + "/";
          localActionModeBP.setSubTitle(String.format("%s%s", new Object[] { localObject, Integer.valueOf(localPlayList.PlaylistSize()) }));
        }
      }
      for (;;)
      {
        this._CurrentActionMode.invalidateOptionsMenu();
        return;
        localObject = "";
        break;
        this._CurrentActionMode.setSubTitle("");
      }
    }
    setTitle(PLAYLIST);
    ActionModeBP localActionModeBP = null;
    Object localObject = localActionModeBP;
    CoreHelper.TrackSizeInfo localTrackSizeInfo;
    int i;
    if (localPlayList.PlaylistSize() > 0)
    {
      localTrackSizeInfo = localPlayList.PlaylistTotalTime();
      if (localTrackSizeInfo.TotalTimeIsApproximate)
      {
        localObject = localActionModeBP;
        if (localTrackSizeInfo.TotalTime <= 200L) {}
      }
      else
      {
        i = localPlayList.PlaylistSize();
        if (!localTrackSizeInfo.TotalTimeIsApproximate) {
          break label279;
        }
      }
    }
    label279:
    for (localObject = ABOUT + " ";; localObject = "")
    {
      localObject = String.format("%s (%s%s)", new Object[] { Integer.valueOf(i), localObject, CoreHelper.GetApproximateTimeDurationAsString(localTrackSizeInfo.TotalTime * 1000L, false) });
      getActionBarHelper().setSubtitle((String)localObject);
      getActionBarHelper().invalidateOptionsMenu();
      return;
    }
  }
  
  public void StartEditMode()
  {
    this._CurrentActionMode = getActionBarHelper().startActionMode(this.mContentSelectionActionModeCallback);
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return this._PlaylistListView.onContextItemSelected(paramMenuItem);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (ThemeManager.CurrentPopupWindowTheme() != -1) {
      setTheme(ThemeManager.CurrentPopupWindowTheme());
    }
    super.onCreate(paramBundle);
    if (!FeedRepository.IsRepositoryAvailable())
    {
      CoreHelper.WriteTraceEntry(TAG, "Closing view because the repository is not Loaded");
      finish();
    }
    do
    {
      return;
      getActionBarHelper().setDisplayOptions(4, 4);
      if (Configuration.PreventKeyguard()) {
        getWindow().addFlags(0x80000 | 0x100000);
      }
      setContentView(2130903148);
      this._PlaylistListView = ((PlaylistEditorListView)findViewById(2131231145));
      this._PlaylistListView.InitializeView(this);
      registerForContextMenu(this._PlaylistListView);
      BeyondPodApplication.MessageBus.Subscribe(this, RepositoryEvents.RepositoryEvent.class);
      BeyondPodApplication.MessageBus.Subscribe(this, UpdateAndDownloadEvents.UpdateAndDownloadEvent.class);
      BeyondPodApplication.MessageBus.Subscribe(this, PlayListEvents.PlayListEvent.class);
      if (paramBundle == null) {
        this._PlaylistListView.postDelayed(new Runnable()
        {
          public void run()
          {
            PlaylistEditorActivity.this._PlaylistListView.SelectCurrentEpisode();
            if (PlaylistEditorActivity.this.getIntent().getBooleanExtra("OpenInEdit", false)) {
              PlaylistEditorActivity.this.StartEditMode();
            }
          }
        }, 300L);
      }
    } while (BeyondPodApplication.GetInstance().PlayList().PlaylistSize() <= 2);
    UserNotificationManager.TipNotifyHowToReorderPlaylist((ViewGroup)findViewById(2131230881));
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    this._PlaylistListView.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131755012, paramMenu);
    onPrepareOptionsMenu(paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    BeyondPodApplication.MessageBus.Unsubscribe(this, RepositoryEvents.RepositoryEvent.class);
    BeyondPodApplication.MessageBus.Unsubscribe(this, UpdateAndDownloadEvents.UpdateAndDownloadEvent.class);
    BeyondPodApplication.MessageBus.Unsubscribe(this, PlayListEvents.PlayListEvent.class);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (EndActionMode())) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool1 = super.onOptionsItemSelected(paramMenuItem);
    case 16908332: 
    case 2131231254: 
    case 2131231255: 
    case 2131231257: 
    case 2131231258: 
    case 2131231259: 
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              bool1 = bool2;
            } while (EndActionMode());
            finish();
            return true;
            if (PlayList.IsEmpty()) {
              this._PlaylistListView.AddEpisodes();
            }
            for (;;)
            {
              RefreshTitle();
              return true;
              StartEditMode();
            }
            if (Configuration.KeepCurrentEpisodeForClearPlaylist()) {}
            for (bool1 = false;; bool1 = true)
            {
              CommandManager.CmdEmptyPlaylist(false, bool1);
              this._PlaylistListView.Refresh();
              EndActionMode();
              return true;
            }
            DeletePodcastDialog.ShowDialog(this, this._PlaylistListView.getCheckedTracks(), new DeletePodcastDialog.ICompletionListener()
            {
              public void OnDeleted()
              {
                PlaylistEditorActivity.this._PlaylistListView.clearAllChecked();
              }
            });
            return true;
            paramMenuItem = this._PlaylistListView.getCheckedTracks();
            bool1 = bool2;
          } while (paramMenuItem.size() <= 0);
          PlayList().MoveTracks(paramMenuItem, 1);
          SparseBooleanArray localSparseBooleanArray = new SparseBooleanArray();
          i = 0;
          for (;;)
          {
            if (i == paramMenuItem.size())
            {
              this._PlaylistListView.BatchSelect(localSparseBooleanArray);
              this._PlaylistListView.setSelection(0);
              return true;
            }
            localSparseBooleanArray.append(i, true);
            i += 1;
          }
          paramMenuItem = this._PlaylistListView.getCheckedTracks();
          bool1 = bool2;
        } while (paramMenuItem.size() <= 0);
        bool1 = bool2;
      } while (paramMenuItem.size() >= PlayList().PlaylistSize());
      PlayList().MoveTracks(paramMenuItem, 2);
      int j = PlayList().GetTrackPosition((Track)paramMenuItem.get(0));
      paramMenuItem = new SparseBooleanArray();
      int i = j;
      for (;;)
      {
        if (i == PlayList().PlaylistSize())
        {
          this._PlaylistListView.BatchSelect(paramMenuItem);
          this._PlaylistListView.setSelection(j);
          return true;
        }
        paramMenuItem.append(i, true);
        i += 1;
      }
    }
    if (UpdateAndDownloadManager.IsWorking())
    {
      CommandManager.CmdShowDownloadQueue();
      return true;
    }
    CommandManager.CmdDownloadAllInPlaylistManually(this);
    return true;
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    RefreshTitle();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    boolean bool2 = false;
    boolean bool3 = this._PlaylistListView.isEditModeEnabled();
    int i;
    MenuItem localMenuItem;
    label66:
    label86:
    label133:
    int j;
    if (this._PlaylistListView.getCheckedTracks().size() > 0)
    {
      i = 1;
      localMenuItem = paramMenu.findItem(2131231254);
      if (!PlayList.IsEmpty()) {
        break label274;
      }
      localMenuItem.setIcon(2130837970);
      localMenuItem.setTitle(2131296638);
      localMenuItem = paramMenu.findItem(2131231255);
      if (!PlayList.IsEmpty()) {
        break label298;
      }
      bool1 = false;
      localMenuItem.setVisible(bool1);
      localMenuItem = paramMenu.findItem(2131231256);
      if ((bool3) || (PlayList.IsEmpty()) || (!BeyondPodApplication.GetInstance().PlayList().HasEpisodesToDownload())) {
        break label304;
      }
      bool1 = true;
      localMenuItem.setVisible(bool1);
      if (!UpdateAndDownloadManager.IsWorking()) {
        break label310;
      }
      j = 2131296646;
      label153:
      localMenuItem.setTitle(j);
      localMenuItem = paramMenu.findItem(2131231257);
      if ((!bool3) || (i == 0)) {
        break label317;
      }
      bool1 = true;
      label185:
      localMenuItem.setVisible(bool1);
      localMenuItem = paramMenu.findItem(2131231258);
      if ((!bool3) || (i == 0)) {
        break label323;
      }
    }
    label274:
    label298:
    label304:
    label310:
    label317:
    label323:
    for (boolean bool1 = true;; bool1 = false)
    {
      localMenuItem.setVisible(bool1);
      paramMenu = paramMenu.findItem(2131231259);
      bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (i != 0) {
          bool1 = true;
        }
      }
      paramMenu.setVisible(bool1);
      return true;
      i = 0;
      break;
      localMenuItem.setIcon(2130837951);
      localMenuItem.setTitle(2131297157);
      break label66;
      bool1 = true;
      break label86;
      bool1 = false;
      break label133;
      j = 2131296650;
      break label153;
      bool1 = false;
      break label185;
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    this._PlaylistListView.Refresh();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/PlaylistEditorActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */