package mobi.beyondpod.ui.views;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.downloadengine.UpdateAndDownloadManager;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.TrackSorter;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.rss.entities.RssEnclosure;
import mobi.beyondpod.services.player.PlayList;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.core.ActionBarHelper;
import mobi.beyondpod.ui.core.MasterViewState;
import mobi.beyondpod.ui.core.SimpleMenu;
import mobi.beyondpod.ui.core.volley.ImageLoader;
import mobi.beyondpod.ui.core.volley.ImageLoaderTrack;
import mobi.beyondpod.ui.views.base.CommonMenuHandler;
import mobi.beyondpod.ui.views.base.IView;
import mobi.beyondpod.ui.views.base.TitleBarBase.TitleInfo;
import mobi.beyondpod.ui.views.notifications.UserNotificationManager;
import mobi.beyondpod.ui.views.notifications.UserNotificationManager.OnContinueListener;

public class FeedContentView
  extends LinearLayout
  implements IView
{
  private static final String FILTER_ALL_ITEMS = CoreHelper.LoadResourceString(2131297154);
  private static final String FILTER_DOWNLOADED_ITEMS;
  private static final String FILTER_LOCAL;
  private static final String FILTER_UNREAD = CoreHelper.LoadResourceString(2131297151);
  private static final int MENU_CLEAR_PLAYLIST = 8;
  private static final int MENU_DELETE_ALL_PLAYED = 9;
  private static final int MENU_DELETE_FEED = 5;
  private static final int MENU_EDIT_FEED = 6;
  private static final int MENU_MARK_ALL_AS_READ = 1;
  private static final int MENU_MARK_SCROLLED_AS_READ_SUB_MENU = 7;
  private static final int MENU_PLAY_LATEST = 12;
  private static final int MENU_PLAY_OLDEST = 13;
  private static final int MENU_PLAY_SMART_PLAYLIST = 11;
  private static final int MENU_SORT_LOCAL = 10;
  private static final int MENU_STOP_UPDATE = 4;
  private static final int MENU_UPDATE_FEED = 3;
  FeedContentListView FeedContentList;
  TextView _FooterItemFilter;
  TextView _FooterMarkAllRead;
  ImageLoader _ImageLoader;
  boolean _IsActive = false;
  TextView _NumInPlaylist;
  private FeedContentViewActivity _Owner;
  View _PlaylistEditor;
  View.OnClickListener _itemFilterClickListener = new View.OnClickListener()
  {
    public void onClick(final View paramAnonymousView)
    {
      paramAnonymousView = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(FeedContentView.FILTER_ALL_ITEMS);
      paramAnonymousView.add(Integer.valueOf(0));
      if (FeedContentView.this.FeedContentList.CurrentFeedHasReadItems())
      {
        localArrayList.add(FeedContentView.FILTER_UNREAD);
        paramAnonymousView.add(Integer.valueOf(1));
      }
      if (FeedContentView.this.FeedContentList.CurrentFeedHasLocalEpisodes())
      {
        localArrayList.add(FeedContentView.FILTER_LOCAL);
        paramAnonymousView.add(Integer.valueOf(2));
      }
      if (FeedContentView.this.FeedContentList.CurrentFeedHasDownloadedEpisodes())
      {
        localArrayList.add(FeedContentView.FILTER_DOWNLOADED_ITEMS);
        paramAnonymousView.add(Integer.valueOf(3));
      }
      int i = paramAnonymousView.indexOf(Integer.valueOf(FeedContentView.this.FeedContentList.CurrentFeed().getItemFilter()));
      new AlertDialog.Builder(FeedContentView.this.getContext()).setTitle(2131296788).setSingleChoiceItems((CharSequence[])localArrayList.toArray(new String[localArrayList.size()]), i, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
        {
          paramAnonymous2Int = ((Integer)paramAnonymousView.get(paramAnonymous2Int)).intValue();
          FeedContentView.this.FeedContentList.ApplyFilter(paramAnonymous2Int);
          paramAnonymous2DialogInterface.dismiss();
        }
      }).setCancelable(true).create().show();
    }
  };
  View.OnClickListener _markAllReadClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (FeedContentView.this.FeedContentList.CurrentRssFeed() != null) {
        FeedContentView.this.FeedContentList.MarkAllAsRead();
      }
    }
  };
  
  static
  {
    FILTER_LOCAL = CoreHelper.LoadResourceString(2131297152);
    FILTER_DOWNLOADED_ITEMS = CoreHelper.LoadResourceString(2131297153);
  }
  
  public FeedContentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FeedContentView(FeedContentViewActivity paramFeedContentViewActivity)
  {
    super(paramFeedContentViewActivity);
    this._Owner = paramFeedContentViewActivity;
    View localView = LayoutInflater.from(paramFeedContentViewActivity).inflate(2130903110, this);
    this.FeedContentList = ((FeedContentListView)localView.findViewById(2131230969));
    this._ImageLoader = new ImageLoaderTrack(paramFeedContentViewActivity);
    this.FeedContentList.setOwner(this);
    setOrientation(1);
    this._PlaylistEditor = localView.findViewById(2131230972);
    this._NumInPlaylist = ((TextView)localView.findViewById(2131230973));
    this._FooterItemFilter = ((TextView)localView.findViewById(2131230971));
    this._FooterItemFilter.setMaxWidth((int)getResources().getDimension(2131492924));
    this._FooterMarkAllRead = ((TextView)localView.findViewById(2131230974));
    paramFeedContentViewActivity = this._FooterMarkAllRead;
    if (ActionBarHelper.HasPermanentMenuKey()) {}
    for (float f = getResources().getDimension(2131492925);; f = getResources().getDimension(2131492926))
    {
      paramFeedContentViewActivity.setMaxWidth((int)f);
      this._PlaylistEditor.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          CommandManager.CmdOpenManagePlaylistView(false);
        }
      });
      this._FooterItemFilter.setOnClickListener(this._itemFilterClickListener);
      this._FooterMarkAllRead.setOnClickListener(this._markAllReadClickListener);
      UpdateFooterToolbar();
      RefreshPlaylistCount();
      CoreHelper.ForceBackgroundTile(localView.findViewById(2131230970));
      return;
    }
  }
  
  private void GeneratePlaylistAndPlay(int paramInt)
  {
    List localList = this.FeedContentList.GeneratePlaylist(null);
    TrackSorter localTrackSorter = new TrackSorter();
    localTrackSorter.SortOrder = paramInt;
    Collections.sort(localList, localTrackSorter);
    if (CommandManager.CmdPlayTracks(getContext(), localList)) {
      this._Owner.ActivatePlayer();
    }
  }
  
  private TrackList GetAllPlayedPodcasts()
  {
    TrackList localTrackList = new TrackList();
    Iterator localIterator = this.FeedContentList.CurrentFeed().Tracks().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localTrackList;
      }
      Track localTrack = (Track)localIterator.next();
      if (localTrack.IsPlayed()) {
        localTrackList.add(localTrack);
      }
    }
  }
  
  private void SortLocalEpisodes()
  {
    new AlertDialog.Builder(getContext()).setTitle(2131296787).setSingleChoiceItems(2131623940, this.FeedContentList.CurrentFeed().getLocalOrInheritedTrackSortOrder(), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        for (Feed localFeed = FeedContentView.this.FeedContentList.CurrentFeed();; localFeed = localFeed.ParentFeed()) {
          if (!localFeed.IsSubFeed())
          {
            localFeed.setTrackSortOrder(paramAnonymousInt);
            FeedContentView.this.FeedContentList.ReApplyFilter();
            paramAnonymousDialogInterface.dismiss();
            return;
          }
        }
      }
    }).setCancelable(true).create().show();
  }
  
  public boolean AllowScrollLeftRightFor(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean CanScrollLeft()
  {
    return false;
  }
  
  public boolean CanScrollRight()
  {
    return false;
  }
  
  public void CloseView()
  {
    this._Owner.finish();
  }
  
  public int ConfigureFeedFilter(int paramInt, Feed paramFeed)
  {
    return this._Owner.ConfigureFeedFilter(paramInt, paramFeed);
  }
  
  public TitleBarBase.TitleInfo GetViewTitle()
  {
    return this.FeedContentList.GetViewTitle();
  }
  
  public boolean HandleContextMenu(MenuItem paramMenuItem)
  {
    return this.FeedContentList.HandleContextMenu(paramMenuItem);
  }
  
  public boolean HandleOptionsMenu(int paramInt, MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    case 2: 
    default: 
      if (!CommonMenuHandler.HandleCommonMenu(paramMenuItem, getContext())) {
        break;
      }
    case 1: 
    case 3: 
    case 4: 
    case 5: 
    case 10: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 11: 
      do
      {
        return true;
        this.FeedContentList.MarkAllAsRead();
        return true;
        paramMenuItem = new FeedList();
        paramMenuItem.add(this.FeedContentList.CurrentFeed());
        CommandManager.CmdUpdateFeeds(paramMenuItem, false);
        return true;
        CommandManager.CmdStopAllUpdates();
        return true;
        CommandManager.CmdDeleteFeed(getContext(), this.FeedContentList.CurrentFeed());
        return true;
        SortLocalEpisodes();
        return true;
        CommandManager.CmdEditFeed(this.FeedContentList.CurrentFeed(), -1);
        return true;
        MarkScrolledAsRead();
        break;
        if (Configuration.KeepCurrentEpisodeForClearPlaylist()) {}
        for (boolean bool = false;; bool = true)
        {
          CommandManager.CmdEmptyPlaylist(false, bool);
          return true;
        }
        CommandManager.CmdDeletePodcasts(getContext(), GetAllPlayedPodcasts());
        return true;
      } while (!CommandManager.CmdPlaySmartPlayList(getContext()));
      this._Owner.ActivatePlayer();
      return true;
    case 12: 
      GeneratePlaylistAndPlay(3);
      return true;
    case 13: 
      GeneratePlaylistAndPlay(2);
      return true;
    }
    return false;
  }
  
  public boolean IsActive()
  {
    return this._IsActive;
  }
  
  public void MarkScrolledAsRead()
  {
    if (this.FeedContentList.NumberOfScrolledUnreadItems() > 0) {
      UserNotificationManager.WarnAboutMarkingScrolledAllAsRead(getContext(), new UserNotificationManager.OnContinueListener()
      {
        public void OnContinue()
        {
          int i = FeedContentView.this.FeedContentList.MarkAllcrolledUnreadItemsUntilPosAsRead(FeedContentView.this.FeedContentList.FirstVisibleItemPosition());
          FeedContentView.this.FeedContentList.Refresh();
          Toast.makeText(FeedContentView.this.getContext(), FeedContentView.this.getContext().getString(2131296927, new Object[] { Integer.valueOf(i) }), 0).show();
        }
      });
    }
  }
  
  public void OnActivityDestroy()
  {
    this._ImageLoader.release();
    this.FeedContentList.OnActivityDestroy();
  }
  
  public void OnAfterActivate()
  {
    this.FeedContentList.OnAfterActivate();
    this._IsActive = true;
  }
  
  public void OnAfterDeactivate(boolean paramBoolean)
  {
    this.FeedContentList.OnAfterDeactivate();
    this._IsActive = false;
  }
  
  public void OnBeforeActivate()
  {
    this.FeedContentList.OnBeforeActivate();
  }
  
  FeedContentViewActivity OwnerActivity()
  {
    return this._Owner;
  }
  
  public void PlayEnclosure(RssEnclosure paramRssEnclosure)
  {
    this._Owner.PlayEnclosure(paramRssEnclosure);
  }
  
  public void PrepareContextMenu(ContextMenu paramContextMenu, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    this.FeedContentList.PrepareContextMenu(paramContextMenu, paramContextMenuInfo);
  }
  
  public boolean PrepareOptionsMenu(Menu paramMenu)
  {
    boolean bool = false;
    paramMenu.clear();
    Feed localFeed = this.FeedContentList.CurrentFeed();
    if (localFeed == null) {
      return false;
    }
    if (!localFeed.IsSubFeed())
    {
      if (!UpdateAndDownloadManager.IsWorking()) {
        break label417;
      }
      paramMenu.add(0, 4, 2, 2131296664).setIcon(2130837984);
      paramMenu.add(0, 6, 4, 2131296654).setIcon(2130837951);
      if (!FeedContentListViewDataSource.IsEpisodeOnlyFilter(localFeed.getItemFilter())) {
        paramMenu.add(0, 5, 3, 2131296653).setIcon(2130837948);
      }
      if (Configuration.AllowMarkingReadOfScrolledPosts())
      {
        int i = this.FeedContentList.NumberOfScrolledUnreadItems();
        if (i > 0) {
          paramMenu.add(0, 7, 0, getResources().getString(2131296699, new Object[] { Integer.valueOf(i) })).setIcon(2130837957);
        }
      }
    }
    SubMenu localSubMenu = paramMenu.addSubMenu(0, 0, 0, 2131296693);
    localSubMenu.setIcon(2130837966);
    if (localFeed.Tracks().size() > 0)
    {
      localSubMenu.add(0, 12, 1, getResources().getStringArray(2131623942)[CoreHelper.FindIndexInNumArray(getContext(), 2131623943, Integer.valueOf(3))]);
      localSubMenu.add(0, 13, 2, getResources().getStringArray(2131623942)[CoreHelper.FindIndexInNumArray(getContext(), 2131623943, Integer.valueOf(2))]);
    }
    localSubMenu.add(0, 11, 3, 2131296692);
    if (!PlayList.IsEmpty()) {
      paramMenu.add(0, 8, 1, 2131296656).setIcon(2130837945);
    }
    if (FeedContentListViewDataSource.IsEpisodeOnlyFilter(localFeed.getItemFilter())) {
      paramMenu.add(0, 10, 5, 2131296635).setIcon(2130837843);
    }
    if (GetAllPlayedPodcasts().size() > 0) {
      paramMenu.add(0, 9, 6, 2131296632).setIcon(2130837949);
    }
    if ((ActionBarHelper.HasPermanentMenuKey()) && (CoreHelper.ApiLevel() <= 15)) {}
    for (;;)
    {
      CommonMenuHandler.AddMoreMenuAt(paramMenu, 7, 162, bool);
      return true;
      label417:
      paramMenu.add(0, 3, 2, 2131296655).setIcon(2130837974);
      break;
      bool = true;
    }
  }
  
  public SimpleMenu PreparePopupOptionsMenu()
  {
    SimpleMenu localSimpleMenu = new SimpleMenu(getContext(), this._Owner.ContentRoot().findViewById(2131230867));
    PrepareOptionsMenu(localSimpleMenu);
    return localSimpleMenu;
  }
  
  public void RefreshActiveViewTitle()
  {
    this._Owner.RefreshActiveViewTitle();
  }
  
  public void RefreshOnNextActivate()
  {
    this.FeedContentList.RefreshOnNextActivate();
  }
  
  public void RefreshPlaylistCount()
  {
    int j = 0;
    int i = BeyondPodApplication.GetInstance().PlayList().PlaylistSize();
    if (i == 0)
    {
      this._NumInPlaylist.setVisibility(8);
      this._NumInPlaylist.setText("0");
      RefreshActiveViewTitle();
    }
    do
    {
      return;
      this._NumInPlaylist.setVisibility(0);
      String str1 = Integer.toString(i);
      String str2 = this._NumInPlaylist.getText().toString();
      i = j;
      if (!StringUtils.IsNullOrEmpty(str2))
      {
        i = j;
        if (!StringUtils.Equals(str2, str1)) {
          i = 1;
        }
      }
      this._NumInPlaylist.setText(str1);
    } while (i == 0);
    RefreshActiveViewTitle();
  }
  
  public void RestoreCurrentState(MasterViewState paramMasterViewState)
  {
    this.FeedContentList.RestoreCurrentState(paramMasterViewState);
  }
  
  public void RestoreFeedContentState(Bundle paramBundle)
  {
    this.FeedContentList.RestoreFeedContentState(paramBundle);
  }
  
  public void SaveCurrentState(MasterViewState paramMasterViewState)
  {
    this.FeedContentList.SaveCurrentState(paramMasterViewState);
  }
  
  public void SaveFeedContentState(Bundle paramBundle)
  {
    this.FeedContentList.SaveFeedContentState(paramBundle);
  }
  
  public void ShowToast(final String paramString, final int paramInt)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        Toast.makeText(FeedContentView.this.getContext(), paramString, paramInt).show();
      }
    });
  }
  
  void UpdateFooterToolbar()
  {
    int j = 4;
    Object localObject = this._FooterMarkAllRead;
    label76:
    TextView localTextView;
    if (this.FeedContentList.HasUnReadItems())
    {
      i = 0;
      ((TextView)localObject).setVisibility(i);
      localObject = this.FeedContentList.CurrentFeed();
      if (localObject == null) {
        break label160;
      }
      switch (this.FeedContentList.CurrentFeed().getItemFilter())
      {
      default: 
        localTextView = this._FooterItemFilter;
        if (((Feed)localObject).HasUri()) {
          break;
        }
      }
    }
    for (int i = j;; i = 0)
    {
      localTextView.setVisibility(i);
      return;
      i = 4;
      break;
      this._FooterItemFilter.setText(FILTER_ALL_ITEMS);
      break label76;
      this._FooterItemFilter.setText(FILTER_DOWNLOADED_ITEMS);
      break label76;
      this._FooterItemFilter.setText(FILTER_LOCAL);
      break label76;
      this._FooterItemFilter.setText(FILTER_UNREAD);
      break label76;
    }
    label160:
    this._FooterItemFilter.setVisibility(4);
  }
  
  public ImageLoader getImageLoader()
  {
    return this._ImageLoader;
  }
  
  public void runOnUiThread(Runnable paramRunnable)
  {
    this._Owner.runOnUiThread(paramRunnable);
  }
  
  public void setCurrentFeed(Feed paramFeed, int paramInt)
  {
    this.FeedContentList.setCurrentFeed(paramFeed, paramInt);
  }
  
  public void startActivity(Intent paramIntent)
  {
    this._Owner.startActivity(paramIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/FeedContentView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */