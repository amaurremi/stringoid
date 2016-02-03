package mobi.beyondpod.ui.views;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.aggregators.AggregatorLoginHelper;
import mobi.beyondpod.aggregators.AggregatorLoginHelper.AuthenticationException;
import mobi.beyondpod.aggregators.AggregatorLoginHelper.GSimpleResult;
import mobi.beyondpod.aggregators.AggregatorLoginHelper.GSyncStatusResult;
import mobi.beyondpod.downloadengine.DownloadStatistics;
import mobi.beyondpod.downloadengine.EnclosureDownloadManager;
import mobi.beyondpod.downloadengine.EnclosureDownloadManager.DownloadableEnclosure;
import mobi.beyondpod.downloadengine.RssFeedCatcher;
import mobi.beyondpod.downloadengine.RssFeedCatcher.FeedUpdateListener;
import mobi.beyondpod.downloadengine.UpdateAndDownloadEvents.UpdateAndDownloadEvent;
import mobi.beyondpod.downloadengine.UpdateAndDownloadEvents.UpdateAndDownloadEventListener;
import mobi.beyondpod.downloadengine.VersionCheckManager;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategories;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.AnalyticsTracker;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.helpers.TimeSpan;
import mobi.beyondpod.rsscore.repository.FlashStorageLocation;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEvent;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEventListener;
import mobi.beyondpod.rsscore.rss.EnclosureDownloadHistory;
import mobi.beyondpod.rsscore.rss.ItemStateHistory;
import mobi.beyondpod.rsscore.rss.LicenseManager;
import mobi.beyondpod.rsscore.rss.RssFeedCache;
import mobi.beyondpod.rsscore.rss.entities.RssEnclosure;
import mobi.beyondpod.rsscore.rss.entities.RssFeed;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;
import mobi.beyondpod.schedulercore.Event;
import mobi.beyondpod.schedulercore.OperationUpdateCategory;
import mobi.beyondpod.schedulercore.ScheduleUtils;
import mobi.beyondpod.schedulercore.ScheduledTask;
import mobi.beyondpod.schedulercore.ScheduledTasksManager;
import mobi.beyondpod.services.player.PlayList;
import mobi.beyondpod.services.player.PlayListEvents.PlayListEvent;
import mobi.beyondpod.services.player.PlayListEvents.PlayListEventListener;
import mobi.beyondpod.sync.ChangeTracker;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.core.FeedImageCache;
import mobi.beyondpod.ui.core.MasterViewState;
import mobi.beyondpod.ui.core.SimpleMenu;
import mobi.beyondpod.ui.core.pulltorefresh.PullToRefreshBase.OnRefreshListener;
import mobi.beyondpod.ui.core.pulltorefresh.PullToRefreshListView;
import mobi.beyondpod.ui.core.volley.FadingNetworkImageViewTrack;
import mobi.beyondpod.ui.core.volley.ImageLoader;
import mobi.beyondpod.ui.views.base.ListViewScaleEx;
import mobi.beyondpod.ui.views.base.ListViewScaleEx.ScaleScrollInfoListener;
import mobi.beyondpod.ui.views.base.TitleBarBase.TitleInfo;
import mobi.beyondpod.ui.views.notifications.UserNotificationManager;
import mobi.beyondpod.ui.views.notifications.UserNotificationManager.OnContinueListener;

public class FeedContentListView
  extends PullToRefreshListView
  implements View.OnClickListener, RepositoryEvents.RepositoryEventListener, UpdateAndDownloadEvents.UpdateAndDownloadEventListener, View.OnLongClickListener, PlayListEvents.PlayListEventListener
{
  private static final String BEYOND_POD_FAQ;
  private static final String CONFIGURE;
  private static final String DISABLED;
  private static final String EPISODE_DETAILS;
  private static final String EPISODE_FORMATS;
  private static final String FAILED_TO_ADD_READER_SUBSCRIPTION_FOR_FEED;
  private static final String FEED_CONTENT;
  private static final String INVALID_OR_EXPIRED_GOOGLE_READER_LOGIN;
  private static final String LAST_UPDATED;
  private static final String LOADING;
  private static final String MAX_S;
  private static final int MENU_ADD_TO_HISTORY = 14;
  private static final int MENU_DELETE_EPISODE = 20;
  private static final int MENU_EPISODE_INFO = 16;
  private static final int MENU_PLAY_IN_EXTERNAL_PLAYER = 18;
  private static final int MENU_REMOVE_FROM_HISTORY = 15;
  private static final int MENU_SHARE_PODCAST_URL = 19;
  private static final int MENU_SHARE_POST_URL = 13;
  private static final int MENU_TOGGLE_LOCK_PODCAST = 17;
  private static final int MENU_TOGGLE_PLAYED = 21;
  private static final String MY_EPISODES_S;
  private static final String NEXT_UPDATE;
  private static final String OPERATION_FAILED;
  private static final String REFRESHING_FEED;
  private static final String TAG = FeedContentListView.class.getSimpleName();
  private static final String THIS_FEED_IS_S_DAYS_OLD;
  private static final String UNREAD = CoreHelper.LoadResourceString(2131297155);
  private static final String UPDATE_CANCELED;
  private static final String UPDATE_FAILED;
  private static Drawable _ReaderFavicon;
  private FeedContentListViewAdapter _Adapter;
  boolean _AllowProgressDisplay = false;
  RssFeedCatcher _Catcher = new RssFeedCatcher();
  private Feed _CurrentFeed;
  FadingNetworkImageViewTrack _FeedImage;
  TextView _FeedPodcasts;
  ImageView _FeedSyncStatus;
  private RssFeedCatcher.FeedUpdateListener _FeedUpdateListener = new RssFeedCatcher.FeedUpdateListener()
  {
    public void OnFeedUpdateCompleted(final Feed paramAnonymousFeed)
    {
      if (LicenseManager.IfInRestrictedMode()) {
        VersionCheckManager.CheckForNewVersionIfNeeded();
      }
      FeedContentListView.this.ToggleProgressIndicator(false);
      FeedContentListView.this._Owner.runOnUiThread(new Runnable()
      {
        public void run()
        {
          if ((paramAnonymousFeed.getType() == 4) && (RssFeedCache.HasCachedFileFor(paramAnonymousFeed)))
          {
            CommandManager.CmdOpenOpmlImporter(paramAnonymousFeed);
            return;
          }
          Date localDate = RssFeedCache.GetCachedFileDate(FeedContentListView.this._CurrentFeed.getFeedUri());
          if ((FeedContentListView.this.CurrentRssFeed() != null) && (FeedContentListView.this.CurrentRssFeed().LastRetrievalDate != null) && (localDate != null) && (FeedContentListView.this.CurrentRssFeed().LastRetrievalDate.getTime() < localDate.getTime())) {
            FeedContentListView.this.CurrentRssFeed().LastRetrievalDate = localDate;
          }
          if ((FeedContentListView.this._CurrentFeed != null) && (FeedContentListView.this._CurrentFeed.HasNewContent()) && (FeedContentListViewDataSource.IsEpisodeOnlyFilter(Configuration.getItemFilter()))) {
            FeedContentListView.this._CurrentFeed.setItemFilter(1);
          }
          FeedContentListView.this.ReloadCurrentFeed(false, false);
          FeedContentListView.this.RefreshFeedInfoHeader();
        }
      });
      ScheduledTasksManager.ScheduleSyncTaskIfSyncIsEnabled(0, TimeSpan.fromSeconds(1.0D), true);
    }
    
    public void OnFeedUpdateError(Feed paramAnonymousFeed, Exception paramAnonymousException)
    {
      FeedContentListView.this.ToggleProgressIndicator(false);
      if ((FeedContentListView.this._Catcher.Statistics() != null) && (FeedContentListView.this._Catcher.Statistics().InidicatesSDCardCorruption()))
      {
        paramAnonymousException = FeedContentListView.this.getResources().getText(2131296909);
        paramAnonymousFeed = paramAnonymousException;
        if (CoreHelper.ApiLevel() >= 19)
        {
          paramAnonymousFeed = paramAnonymousException;
          if (!CoreHelper.isFolderReallyWritable(Configuration.BeyondPodPublicStorageRootPath())) {
            paramAnonymousFeed = FeedContentListView.this.getResources().getText(2131296910);
          }
        }
        FeedContentListView.this._Owner.ShowToast(FeedContentListView.UPDATE_FAILED + "\n\n" + paramAnonymousFeed, 1);
        if (RssFeedCache.HasCachedFileFor(FeedContentListView.this._CurrentFeed)) {
          FeedContentListView.this._Owner.runOnUiThread(new Runnable()
          {
            public void run()
            {
              FeedContentListView.this.ReloadCurrentFeed(false, false);
            }
          });
        }
      }
      else
      {
        paramAnonymousFeed = CoreHelper.ExtractExceptionMessages(paramAnonymousException);
        if ((paramAnonymousException instanceof AggregatorLoginHelper.AuthenticationException))
        {
          if (!AggregatorLoginHelper.IsLoggedIn()) {
            break label250;
          }
          AggregatorLoginHelper.ClearAccountToken();
        }
        label250:
        for (paramAnonymousFeed = FeedContentListView.this.getContext().getString(2131296391);; paramAnonymousFeed = FeedContentListView.INVALID_OR_EXPIRED_GOOGLE_READER_LOGIN)
        {
          FeedContentView localFeedContentView = FeedContentListView.this._Owner;
          StringBuilder localStringBuilder = new StringBuilder(String.valueOf(FeedContentListView.UPDATE_FAILED)).append("\n\n");
          Object localObject = paramAnonymousFeed;
          if (StringUtils.IsNullOrEmpty(paramAnonymousFeed)) {
            localObject = paramAnonymousException.getClass().getSimpleName();
          }
          localFeedContentView.ShowToast((String)localObject, 1);
          break;
        }
      }
      FeedContentListView.this.RefreshFeedInfoHeader();
      FeedContentListView.this.Refresh();
    }
    
    public void OnFeedUpdateProgress(Feed paramAnonymousFeed) {}
    
    public void OnFeedUpdateStarted(Feed paramAnonymousFeed)
    {
      FeedContentListView.this.ToggleProgressIndicator(true);
      if (FeedContentListView.this._Adapter.CurrentFeed() != FeedContentListView.this._CurrentFeed) {
        FeedContentListView.this._Owner.runOnUiThread(new Runnable()
        {
          public void run()
          {
            FeedContentListView.this._Adapter.ClearItems();
          }
        });
      }
      FeedContentListView.this._AllowProgressDisplay = false;
      FeedContentListView.this.RefreshFeedInfoHeader();
    }
    
    public void OnFeedUpdateTerminated(Feed paramAnonymousFeed)
    {
      FeedContentListView.this.ToggleProgressIndicator(false);
      FeedContentListView.this._Owner.ShowToast(FeedContentListView.UPDATE_CANCELED, 0);
      FeedContentListView.this.RefreshFeedInfoHeader();
      FeedContentListView.this.Refresh();
    }
  };
  Handler _Handler = new Handler();
  View _Header;
  boolean _HeaderEnabled = true;
  View _InfoFooter1;
  View _InfoFooter2;
  int _LastSavedVisibleItem = -1;
  TextView _LastUpdatedDate;
  ListViewScaleEx _ListView;
  protected boolean _ListViewisScrolling;
  TextView _NextUpdateDate;
  FeedContentView _Owner;
  View _Progress;
  AggregatorLoginHelper.GSyncStatusResult _ReaderSyncListener = new AggregatorLoginHelper.GSyncStatusResult()
  {
    public void SyncCompleted(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      FeedContentListView.this.RefreshActivityTitle();
      FeedContentListView.this._Catcher.UpdateFeed(FeedContentListView.this._CurrentFeed, true);
    }
  };
  private ListViewScaleEx.ScaleScrollInfoListener _ScaleScrollInfoListener = new ListViewScaleEx.ScaleScrollInfoListener()
  {
    public void ItemChecked(int paramAnonymousInt) {}
    
    public void ItemSelected(int paramAnonymousInt)
    {
      if (FeedContentListViewDataSource.IsEmpty()) {
        if (!FeedContentListView.this._Adapter.IsLoadingData()) {}
      }
      RssFeedItem localRssFeedItem;
      do
      {
        do
        {
          do
          {
            return;
            if (FeedContentListView.this._Adapter.HasHiddenItems())
            {
              FeedContentListView.this.ShowAllItems();
              return;
            }
            if (!FeedContentListView.this.IsUpdating())
            {
              FeedContentListView.this.ReloadCurrentFeed(true, false);
              return;
            }
            if (FeedContentListView.this._Catcher.IsUpdating()) {
              FeedContentListView.this._Catcher.Stop();
            }
          } while (!AggregatorLoginHelper.IsSyncing());
          AggregatorLoginHelper.StopSyncing();
          return;
          localRssFeedItem = (RssFeedItem)FeedContentListView.this._Adapter.getItem(paramAnonymousInt - FeedContentListView.this._ListView.getHeaderViewsCount());
        } while (localRssFeedItem == null);
        if (localRssFeedItem.Enclosure() == null)
        {
          FeedContentListView.this.OpenPostContentFor(localRssFeedItem);
          return;
        }
      } while (!FeedContentListView.this._CurrentFeed.IsTransient);
      FeedContentListView.this._Owner.PlayEnclosure(localRssFeedItem.Enclosure());
    }
    
    public void onCollapse()
    {
      if (FeedContentListView.this._Adapter.HasReadItems())
      {
        FeedContentListView.this.HideRead();
        FeedContentListView.this.UpdateFooters();
      }
    }
    
    public void onExpand()
    {
      if (FeedContentListView.this._Adapter.HasHiddenItems())
      {
        FeedContentListView.this.ShowAllItems();
        FeedContentListView.this.UpdateFooters();
      }
    }
  };
  private AbsListView.OnScrollListener _ScrollListener = new AbsListView.OnScrollListener()
  {
    int _LastFirstVisibleItem = 0;
    
    public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      if ((!FeedContentListView.this._ListViewisScrolling) && (paramAnonymousInt1 != this._LastFirstVisibleItem))
      {
        this._LastFirstVisibleItem = paramAnonymousInt1;
        FeedContentListView.this.PrefetchPostImagesIfNeeded();
        FeedContentListView.this.UpdateNumberOfScrolledUnreadItemsIfNeeded();
      }
    }
    
    public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
    {
      switch (paramAnonymousInt)
      {
      default: 
        return;
      case 0: 
        FeedContentListView.this._ListViewisScrolling = false;
        return;
      case 1: 
        FeedContentListView.this._ListViewisScrolling = true;
        return;
      }
      FeedContentListView.this._ListViewisScrolling = true;
    }
  };
  boolean _ShouldRefreshOnActivate = false;
  private TitleBarBase.TitleInfo _Title = new TitleBarBase.TitleInfo();
  ImageButton _UpdateButton;
  
  static
  {
    LOADING = CoreHelper.LoadResourceString(2131297011);
    BEYOND_POD_FAQ = CoreHelper.LoadResourceString(2131297012);
    FAILED_TO_ADD_READER_SUBSCRIPTION_FOR_FEED = CoreHelper.LoadResourceString(2131297013);
    OPERATION_FAILED = CoreHelper.LoadResourceString(2131297014);
    EPISODE_FORMATS = CoreHelper.LoadResourceString(2131297015);
    EPISODE_DETAILS = CoreHelper.LoadResourceString(2131297016);
    FEED_CONTENT = CoreHelper.LoadResourceString(2131297017);
    MAX_S = CoreHelper.LoadResourceString(2131297018);
    MY_EPISODES_S = CoreHelper.LoadResourceString(2131297019);
    DISABLED = CoreHelper.LoadResourceString(2131297020);
    CONFIGURE = CoreHelper.LoadResourceString(2131297021);
    NEXT_UPDATE = CoreHelper.LoadResourceString(2131297022);
    LAST_UPDATED = CoreHelper.LoadResourceString(2131297023);
    THIS_FEED_IS_S_DAYS_OLD = CoreHelper.LoadResourceString(2131297024);
    REFRESHING_FEED = CoreHelper.LoadResourceString(2131297025);
    UPDATE_CANCELED = CoreHelper.LoadResourceString(2131297026);
    INVALID_OR_EXPIRED_GOOGLE_READER_LOGIN = CoreHelper.LoadResourceString(2131297027);
    UPDATE_FAILED = CoreHelper.LoadResourceString(2131297028);
  }
  
  public FeedContentListView(Context paramContext)
  {
    super(paramContext);
    Initilize();
  }
  
  public FeedContentListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Initilize();
  }
  
  private void DeleteEpisode(RssFeedItem paramRssFeedItem)
  {
    paramRssFeedItem = paramRssFeedItem.Enclosure().GetLocalEnclosureTrack();
    if (paramRssFeedItem != null)
    {
      TrackList localTrackList = new TrackList();
      localTrackList.add(paramRssFeedItem);
      CommandManager.CmdDeletePodcasts(getContext(), localTrackList);
    }
  }
  
  public static void DownloadEnclosures(Context paramContext, EnclosureDownloadManager.DownloadableEnclosure paramDownloadableEnclosure)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramDownloadableEnclosure);
    CommandManager.CmdDownloadEnclosuresManually(paramContext, localArrayList);
  }
  
  static Track FindOrCreateStreamableTrack(RssEnclosure paramRssEnclosure)
  {
    Track localTrack2 = paramRssEnclosure.GetLocalEnclosureTrack();
    Track localTrack1 = localTrack2;
    if (localTrack2 == null)
    {
      if (Configuration.AllowEpisodeStreaming() == 2) {
        return null;
      }
      Feed localFeed = Configuration.FindFeedByIdInTempOrRepository(paramRssEnclosure.Parent.OriginatingFeedID());
      localTrack1 = localTrack2;
      if (localFeed != null) {
        localTrack1 = RssFeedCache.CreateStreamableTrackFromEnclosure(localFeed, paramRssEnclosure, true);
      }
    }
    return localTrack1;
  }
  
  private ScheduledTask GetFirstScheduledTask()
  {
    Object localObject2;
    if (this._CurrentFeed == null) {
      localObject2 = null;
    }
    Object localObject1;
    Object localObject3;
    ArrayList localArrayList;
    do
    {
      return (ScheduledTask)localObject2;
      localObject2 = this._CurrentFeed.getCategories().getPrimary();
      localObject1 = this._CurrentFeed.getCategories().getSecondary();
      ScheduledTask localScheduledTask1 = ScheduleUtils.GetScheduledTaskForCategory((FeedCategory)localObject2);
      ScheduledTask localScheduledTask3 = ScheduleUtils.GetScheduledTaskForCategory((FeedCategory)localObject1);
      ScheduledTask localScheduledTask2 = ScheduleUtils.GetScheduledTaskForCategory(CategoryManager.AllFeeds);
      localObject2 = new Date(Long.MAX_VALUE);
      localObject3 = new Date(Long.MAX_VALUE);
      Date localDate = new Date(Long.MAX_VALUE);
      localArrayList = new ArrayList();
      localObject1 = localObject2;
      if (localScheduledTask1 != null)
      {
        localObject1 = localObject2;
        if (localScheduledTask1.Active)
        {
          localObject1 = localObject2;
          if (localScheduledTask1.ExistsOnDevice())
          {
            localObject1 = localScheduledTask1.Event.StartTime();
            localArrayList.add(localScheduledTask1);
          }
        }
      }
      localObject2 = localObject3;
      if (localScheduledTask3 != null)
      {
        localObject2 = localObject3;
        if (localScheduledTask3.Active)
        {
          localObject2 = localObject3;
          if (localScheduledTask3.ExistsOnDevice())
          {
            localObject2 = localScheduledTask3.Event.StartTime();
            localArrayList.add(localScheduledTask3);
          }
        }
      }
      localObject3 = localDate;
      if (localScheduledTask2 != null)
      {
        localObject3 = localDate;
        if (localScheduledTask2.Active)
        {
          localObject3 = localDate;
          if (localScheduledTask2.ExistsOnDevice())
          {
            localObject3 = localScheduledTask2.Event.StartTime();
            localArrayList.add(localScheduledTask2);
          }
        }
      }
      if (((Date)localObject1).getTime() != ((Date)localObject2).getTime()) {
        break;
      }
      localObject2 = localScheduledTask1;
    } while (((Date)localObject1).getTime() == ((Date)localObject3).getTime());
    return ScheduleUtils.GetEarliestTask(localArrayList);
  }
  
  private Drawable GetSyncStatusIcon()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this._CurrentFeed != null) {
      if ((!this._CurrentFeed.IsGReaderFeed()) || (!ItemStateHistory.HasUnsynchronizedGoogleReaderItems()))
      {
        localObject1 = localObject2;
        if (!ChangeTracker.HasUploadPendingChanges()) {}
      }
      else
      {
        localObject1 = _ReaderFavicon;
      }
    }
    return (Drawable)localObject1;
  }
  
  private void HideRead()
  {
    ApplyFilter(1);
  }
  
  private void Initilize()
  {
    _ReaderFavicon = getResources().getDrawable(2130837846);
    this._ListView = ((ListViewScaleEx)getRefreshableView());
    this._ListView.setScaleScrollListener(this._ScaleScrollInfoListener);
    this._ListView.setItemsCanFocus(true);
    this._ListView.setFadingEdgeLength((int)getResources().getDimension(2131492952));
    this._ListView.setVerticalFadingEdgeEnabled(true);
    this._Catcher.setFeedUpdateListener(this._FeedUpdateListener);
    this._Adapter = new FeedContentListViewAdapter(getContext(), this);
    LayoutInflater localLayoutInflater = LayoutInflater.from(getContext());
    this._Header = localLayoutInflater.inflate(2130903108, null);
    this._UpdateButton = ((ImageButton)this._Header.findViewById(2131230964));
    this._Progress = this._Header.findViewById(2131230868);
    this._LastUpdatedDate = ((TextView)this._Header.findViewById(2131230961));
    this._NextUpdateDate = ((TextView)this._Header.findViewById(2131230962));
    this._FeedPodcasts = ((TextView)this._Header.findViewById(2131230963));
    this._FeedImage = ((FadingNetworkImageViewTrack)this._Header.findViewById(2131230960));
    this._FeedImage.setDefaultImageResId(2130838006);
    this._FeedImage.setMaxImageSize((int)getResources().getDimension(2131492901), (int)getResources().getDimension(2131492902));
    this._FeedImage.setFadeInImage(true);
    this._FeedSyncStatus = ((ImageView)this._Header.findViewById(2131230965));
    if (Configuration.EnableLoggingInProduction()) {
      this._FeedImage.setOnLongClickListener(new View.OnLongClickListener()
      {
        public boolean onLongClick(View paramAnonymousView)
        {
          if ((FeedContentListView.this._CurrentFeed != null) && (FeedContentListView.this.CurrentRssFeed() != null)) {
            RssFeedCatcher.CreateFeedSnapshot(FeedContentListView.this._CurrentFeed, FeedContentListView.this.CurrentRssFeed(), true);
          }
          return true;
        }
      });
    }
    this._NextUpdateDate.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (FeedContentListView.this._CurrentFeed == null) {
          return;
        }
        Object localObject1 = null;
        Object localObject2 = FeedContentListView.this.GetFirstScheduledTask();
        paramAnonymousView = (View)localObject1;
        if (localObject2 != null)
        {
          if ((((ScheduledTask)localObject2).Active) && (!((ScheduledTask)localObject2).ExistsOnDevice()))
          {
            ScheduledTasksManager.RescheduleAllActiveTasks();
            FeedContentListView.this.RefreshFeedInfoHeader();
            return;
          }
          localObject2 = ((ScheduledTask)localObject2).Operation();
          paramAnonymousView = (View)localObject1;
          if ((localObject2 instanceof OperationUpdateCategory)) {
            paramAnonymousView = CategoryManager.GetCategoryByValue(((OperationUpdateCategory)localObject2).getCategoryToUpdate());
          }
        }
        localObject1 = paramAnonymousView;
        if (paramAnonymousView == null) {
          localObject1 = FeedContentListView.this._CurrentFeed.getCategories().getPrimary();
        }
        CommandManager.CmdSetUpdateSchedule((FeedCategory)localObject1, FeedContentListView.this.getContext(), true);
      }
    });
    this._FeedPodcasts.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (FeedContentListView.this._CurrentFeed == null) {}
        do
        {
          return;
          if ((FeedContentListView.this._CurrentFeed.getPodcastDownloadAction() == 1) || (FeedContentListView.this._CurrentFeed.getPodcastDownloadAction() == 2))
          {
            CommandManager.CmdEditFeed(FeedContentListView.this._CurrentFeed, 2131231044);
            return;
          }
        } while ((FeedContentListView.this._CurrentFeed.getPodcastDownloadAction() != 4) && (FeedContentListView.this._CurrentFeed.getPodcastDownloadAction() != 5));
        CommandManager.CmdEditFeed(FeedContentListView.this._CurrentFeed, 2131231039);
      }
    });
    this._UpdateButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (FeedContentListView.this.IsUpdating())
        {
          FeedContentListView.this.StopUpdate();
          return;
        }
        FeedContentListView.this.ReloadCurrentFeed(true, false);
      }
    });
    this._UpdateButton.setOnLongClickListener(new View.OnLongClickListener()
    {
      public boolean onLongClick(View paramAnonymousView)
      {
        CoreHelper.Vibrate(CoreHelper.VIBRATE_SHORT);
        if (FeedContentListView.this.IsUpdating())
        {
          FeedContentListView.this.StopUpdate();
          return true;
        }
        FeedImageCache.DeleteImageCacheFor(FeedContentListView.this._CurrentFeed);
        RssFeedCache.DeleteFeedCacheFor(FeedContentListView.this._CurrentFeed);
        FeedContentListView.this.ReloadCurrentFeed(true, false);
        return true;
      }
    });
    this._InfoFooter1 = localLayoutInflater.inflate(2130903107, null);
    this._InfoFooter2 = localLayoutInflater.inflate(2130903107, null);
    this._ListView.addHeaderView(this._Header, null, false);
    this._ListView.setFooterDividersEnabled(false);
    this._ListView.setAdapter(this._Adapter);
    BeyondPodApplication.MessageBus.Subscribe(this, PlayListEvents.PlayListEvent.class);
    BeyondPodApplication.MessageBus.Subscribe(this, UpdateAndDownloadEvents.UpdateAndDownloadEvent.class);
    BeyondPodApplication.MessageBus.Subscribe(this, RepositoryEvents.RepositoryEvent.class);
    setOnRefreshListener(new PullToRefreshBase.OnRefreshListener()
    {
      public void onRefresh()
      {
        FeedContentListView.this.onRefreshComplete();
        if (!FeedContentListView.this.IsUpdating()) {
          FeedContentListView.this.ReloadCurrentFeed(true, false);
        }
      }
    });
    setOnScrollListener(this._ScrollListener);
    CoreHelper.ForceBackgroundTile(this._Header);
  }
  
  private void NotifyFeedFailedToLoad()
  {
    int i;
    Object localObject;
    int j;
    if ((this._CurrentFeed.getFeedUri() != null) && (this._CurrentFeed.getFeedUri().getQuery() != null) && (this._CurrentFeed.getFeedUri().getQuery().indexOf("auth=") >= 0))
    {
      i = 1;
      localObject = new AlertDialog.Builder(getContext()).setIcon(17301659).setTitle(2131296928);
      if (i == 0) {
        break label136;
      }
      j = 2131296930;
      label76:
      localObject = ((AlertDialog.Builder)localObject).setMessage(j).setNegativeButton(2131296932, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          CommandManager.CmdStartHtmlViewActivity(Configuration.FeedFailsToLoadURL(), FeedContentListView.BEYOND_POD_FAQ, false);
        }
      }).create();
      if (i == 0) {
        break label143;
      }
      ((AlertDialog)localObject).setButton(-1, getResources().getString(2131296931), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          CommandManager.CmdOpenExternalBrowser("http://" + FeedContentListView.this._CurrentFeed.getFeedUri().getHost());
        }
      });
    }
    for (;;)
    {
      ((AlertDialog)localObject).show();
      return;
      i = 0;
      break;
      label136:
      j = 2131296929;
      break label76;
      label143:
      ((AlertDialog)localObject).setButton(-1, getResources().getText(2131296760), null);
    }
  }
  
  private void NotifyGoogleReadMayHaveMoreItemsIfNeeded()
  {
    this._ListView.removeFooterView(this._InfoFooter2);
    int i;
    if (this._CurrentFeed.getMaxNumGReaderItemsToGet() == 0)
    {
      i = 20;
      if ((!this._CurrentFeed.IsGReaderFeed()) || (i != CurrentRssFeed().Items.size())) {
        break label171;
      }
    }
    for (;;)
    {
      if ((!this._CurrentFeed.IsTransient) && (i > 0) && (!this._Adapter.HasHiddenItems()))
      {
        String str = getContext().getString(2131296922, new Object[] { Integer.valueOf(i) });
        ((TextView)this._InfoFooter2.findViewById(2131230901)).setText(str);
        ((TextView)this._InfoFooter2.findViewById(2131230959)).setText(2131296923);
        this._ListView.addFooterView(this._InfoFooter2, null, false);
        this._InfoFooter2.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            CommandManager.CmdEditFeed(FeedContentListView.this._CurrentFeed, 2131230998);
          }
        });
      }
      return;
      i = this._CurrentFeed.getMaxNumGReaderItemsToGet();
      break;
      label171:
      i = -1;
    }
  }
  
  private void NotifyItemsFiltered()
  {
    if ((FeedContentListViewDataSource.VisibleItemCount() == 0) || ((FeedContentListViewDataSource.TotalItemCount() > 0) && (FeedContentListViewDataSource.VisibleItemCount() == FeedContentListViewDataSource.TotalItemCount()))) {
      return;
    }
    this._ListView.removeFooterView(this._InfoFooter2);
    ((TextView)this._InfoFooter2.findViewById(2131230901)).setText(this._Owner.getResources().getString(2131296934, new Object[] { this._Owner.getResources().getString(FeedContentListViewItemBuilder.getFilterStringResource(CurrentFeed().getItemFilter())) }));
    ((TextView)this._InfoFooter2.findViewById(2131230959)).setText("");
    this._ListView.addFooterView(this._InfoFooter2, null, false);
    this._InfoFooter2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        FeedContentListView.this.ShowAllItems();
      }
    });
  }
  
  private void NotifyNotSubscribedInReaderIfNeeded()
  {
    this._ListView.removeFooterView(this._InfoFooter1);
    if ((this._CurrentFeed != null) && (CurrentRssFeed() != null) && (this._CurrentFeed.IsGReaderFeed()) && (!CurrentRssFeed().IsSubscribedInGoogleReader()))
    {
      ((TextView)this._InfoFooter1.findViewById(2131230901)).setText(2131296924);
      ((TextView)this._InfoFooter1.findViewById(2131230959)).setText(2131296925);
      this._ListView.addFooterView(this._InfoFooter1, null, false);
      this._InfoFooter1.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          try
          {
            FeedContentListView.this.ToggleProgressIndicator(true);
            AggregatorLoginHelper.AddSubscription(FeedContentListView.this._CurrentFeed, new AggregatorLoginHelper.GSimpleResult()
            {
              public void Failed(Exception paramAnonymous2Exception)
              {
                FeedContentListView.this._Owner.ShowToast(FeedContentListView.OPERATION_FAILED + "\n" + paramAnonymous2Exception.getMessage(), 1);
                FeedContentListView.this.ToggleProgressIndicator(false);
              }
              
              public void Success()
              {
                FeedContentListView.this.ToggleProgressIndicator(false);
                FeedContentListView.this.ReloadCurrentFeed(true, false);
              }
            });
            return;
          }
          catch (Exception paramAnonymousView)
          {
            CoreHelper.LogException(FeedContentListView.TAG, FeedContentListView.FAILED_TO_ADD_READER_SUBSCRIPTION_FOR_FEED + ": " + FeedContentListView.this._CurrentFeed.getFeedPath(), paramAnonymousView);
            FeedContentListView.this.ToggleProgressIndicator(false);
            FeedContentListView.this._Owner.ShowToast(FeedContentListView.OPERATION_FAILED + "\n" + paramAnonymousView.getMessage(), 1);
          }
        }
      });
    }
  }
  
  public static void OnAddRemoveFromPlaylist(RssFeedItem paramRssFeedItem)
  {
    paramRssFeedItem = paramRssFeedItem.Enclosure();
    if (paramRssFeedItem == null) {}
    do
    {
      return;
      paramRssFeedItem = FindOrCreateStreamableTrack(paramRssFeedItem);
    } while (paramRssFeedItem == null);
    if (BeyondPodApplication.GetInstance().PlayList().HasTrack(paramRssFeedItem))
    {
      CommandManager.CmdRemoveFromPlaylist(paramRssFeedItem);
      return;
    }
    CommandManager.CmdAddToPlaylist(paramRssFeedItem);
  }
  
  public static void OnDownload(Context paramContext, RssFeedItem paramRssFeedItem, Feed paramFeed)
  {
    paramRssFeedItem = paramRssFeedItem.Enclosure();
    if ((paramFeed != null) && (paramRssFeedItem != null))
    {
      if (paramRssFeedItem.PlayableState() != 5) {
        break label25;
      }
      CommandManager.CmdShowDownloadQueue();
    }
    label25:
    do
    {
      return;
      if (EnclosureDownloadManager.IsDownloadPending(paramRssFeedItem))
      {
        EnclosureDownloadManager.RemoveFromQueue(paramRssFeedItem);
        return;
      }
    } while (!paramFeed.EnsureFeedHasDownloadPath());
    Object localObject = paramFeed.getFeedPath();
    long l;
    String str1;
    String str2;
    if (paramRssFeedItem.EnclosureFileLength() == null)
    {
      l = 0L;
      if (FlashStorageLocation.CheckIfSpaceIsAvailable((String)localObject, l)) {
        break label181;
      }
      l = FlashStorageLocation.GetFreeSpaceAtFeedDownloadPath(paramFeed);
      localObject = paramContext.getResources();
      str1 = CoreHelper.GetFileLengthAsString(paramRssFeedItem.EnclosureFileLength());
      str2 = CoreHelper.GetFileLengthAsString(Long.valueOf(l));
      if (!StringUtils.IsNullOrEmpty(paramFeed.getFeedPath())) {
        break label173;
      }
    }
    label173:
    for (paramRssFeedItem = Configuration.EnclosureDownloadRoot();; paramRssFeedItem = paramFeed.getFeedPath())
    {
      paramRssFeedItem = ((Resources)localObject).getString(2131296858, new Object[] { str1, str2, paramRssFeedItem });
      if (l < 0L) {
        paramRssFeedItem = paramContext.getString(2131296909);
      }
      Toast.makeText(paramContext, paramRssFeedItem, 1).show();
      return;
      l = paramRssFeedItem.EnclosureFileLength().longValue();
      break;
    }
    label181:
    DownloadEnclosures(paramContext, new EnclosureDownloadManager.DownloadableEnclosure(paramFeed, paramRssFeedItem));
  }
  
  private void OpenPostContentFor(RssFeedItem paramRssFeedItem)
  {
    if ((StringUtils.IsNullOrEmpty(paramRssFeedItem.Description)) || (paramRssFeedItem.Description.length() < 10) || (paramRssFeedItem.Description.equals(paramRssFeedItem.Title.toString())))
    {
      FeedItemContentViewDialog.DoOpenOriginalSource(getContext(), false, paramRssFeedItem.Link, paramRssFeedItem.Title);
      if ((Configuration.MarkAsReadOnOpen() == 2) || ((Configuration.MarkAsReadOnOpen() == 1) && (paramRssFeedItem.Enclosure() == null)))
      {
        paramRssFeedItem.setRead(true);
        BeyondPodApplication.MessageBus.PublishEventAsync(new RepositoryEvents.RepositoryEvent(15));
      }
      return;
    }
    Context localContext = getContext();
    if (Configuration.UseFeedContentViewPager()) {}
    for (Object localObject = FeedItemContentViewPager.class;; localObject = FeedItemContentViewDialog.class)
    {
      localObject = new Intent(localContext, (Class)localObject);
      ((Intent)localObject).putExtra("RssItemId", paramRssFeedItem.ItemID());
      this._Owner.startActivity((Intent)localObject);
      return;
    }
  }
  
  private void PrefetchPostImagesIfNeeded()
  {
    if ((this._Adapter.SupportsItemImages()) && (findViewById(2131230934) != null)) {
      this._Adapter.PrefetchItemImages();
    }
  }
  
  private void RefreshFeedInfoHeader()
  {
    this._Owner.runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (FeedContentListView.this._CurrentFeed != null)
        {
          if ((!FeedContentListView.this._CurrentFeed.HasUri()) || (!FeedContentListView.this._HeaderEnabled))
          {
            FeedContentListView.this._ListView.removeHeaderView(FeedContentListView.this._Header);
            return;
          }
          FeedContentListView.this._FeedImage.setErrorImageResId(FeedImageCache.GetDefaultImageResId(FeedContentListView.this._CurrentFeed));
          FeedContentListView.this._FeedImage.setFeed(FeedContentListView.this._CurrentFeed, FeedContentListView.this.getImageLoader());
          localObject1 = FeedContentListView.this.GetSyncStatusIcon();
          if (localObject1 != null) {
            break label177;
          }
          FeedContentListView.this._FeedSyncStatus.setVisibility(8);
        }
        while ((FeedContentListView.this._Catcher.IsUpdating()) || (AggregatorLoginHelper.IsSyncing()))
        {
          FeedContentListView.this._LastUpdatedDate.setText(FeedContentListView.REFRESHING_FEED);
          FeedContentListView.this._NextUpdateDate.setText("");
          FeedContentListView.this._FeedPodcasts.setText("");
          return;
          label177:
          FeedContentListView.this._FeedSyncStatus.setImageDrawable((Drawable)localObject1);
          FeedContentListView.this._FeedSyncStatus.setVisibility(0);
        }
        FeedContentListView.this._UpdateButton.setImageResource(2130837907);
        Object localObject1 = FeedContentListView.this.CurrentRssFeed();
        if (localObject1 == null)
        {
          FeedContentListView.this._NextUpdateDate.setText("");
          FeedContentListView.this._FeedPodcasts.setText("");
          return;
        }
        for (;;)
        {
          Object localObject2;
          ScheduledTask localScheduledTask;
          try
          {
            if (((RssFeed)localObject1).getDaysOld() > 0)
            {
              FeedContentListView.this._LastUpdatedDate.setText(String.format(FeedContentListView.THIS_FEED_IS_S_DAYS_OLD, new Object[] { Integer.valueOf(((RssFeed)localObject1).getDaysOld()) }));
              localObject2 = FeedContentListView.NEXT_UPDATE + " ";
              localObject1 = FeedContentListView.CONFIGURE;
              localScheduledTask = FeedContentListView.this.GetFirstScheduledTask();
              if (localScheduledTask != null)
              {
                if ((localScheduledTask.Active) && (localScheduledTask.ExistsOnDevice())) {
                  break label735;
                }
                localObject1 = FeedContentListView.DISABLED;
              }
              localObject1 = new SpannableString(localObject2 + (String)localObject1);
              if ((localScheduledTask == null) || (!localScheduledTask.Active) || (!localScheduledTask.ExistsOnDevice())) {
                ((SpannableString)localObject1).setSpan(new UnderlineSpan(), ((String)localObject2).length(), ((SpannableString)localObject1).length(), 33);
              }
              FeedContentListView.this._NextUpdateDate.setText((CharSequence)localObject1);
              if ((FeedContentListView.this._CurrentFeed == null) || (!FeedContentListView.this._CurrentFeed.HasPodcasts())) {
                break label879;
              }
              localObject1 = String.format(FeedContentListView.MY_EPISODES_S, new Object[] { Integer.valueOf(FeedContentListView.this._CurrentFeed.Tracks().size()) }) + " ";
              if ((FeedContentListView.this._CurrentFeed.getPodcastDownloadAction() != 1) && (FeedContentListView.this._CurrentFeed.getPodcastDownloadAction() != 2)) {
                break label749;
              }
              localObject2 = String.format(FeedContentListView.MAX_S, new Object[] { Integer.valueOf(FeedContentListView.this._CurrentFeed.getKeepAtMostPodcasts()) });
              localObject2 = new SpannableString(localObject1 + (String)localObject2);
              ((SpannableString)localObject2).setSpan(new UnderlineSpan(), ((String)localObject1).length(), ((SpannableString)localObject2).length(), 33);
              FeedContentListView.this._FeedPodcasts.setText((CharSequence)localObject2);
              if ((FeedContentListView.this._CurrentFeed == null) || (FeedContentListView.this._CurrentFeed.getItemFingerprintAlgorithm() != 1)) {
                break;
              }
              FeedContentListView.this._NextUpdateDate.setText(FeedContentListView.this._NextUpdateDate.getText().toString() + ".");
              return;
            }
          }
          catch (Exception localException)
          {
            CoreHelper.LogException(FeedContentListView.TAG, "Failed to refresh ContentListView header", localException);
            return;
          }
          if (localException.LastRetrievalDate != null)
          {
            FeedContentListView.this._LastUpdatedDate.setText(FeedContentListView.LAST_UPDATED + " " + DateTime.FormatDateTime(localException.LastRetrievalDate));
            continue;
            label735:
            String str = DateTime.FormatDateTime(localScheduledTask.Event.StartTime());
            continue;
            label749:
            if ((FeedContentListView.this._CurrentFeed.getPodcastDownloadAction() == 4) || (FeedContentListView.this._CurrentFeed.getPodcastDownloadAction() == 5))
            {
              localObject2 = String.format(FeedContentListView.MAX_S, new Object[] { Integer.valueOf(FeedContentListView.this._CurrentFeed.getMaxNumberPodcastToDownload()) });
              localObject2 = new SpannableString(str + (String)localObject2);
              ((SpannableString)localObject2).setSpan(new UnderlineSpan(), str.length(), ((SpannableString)localObject2).length(), 33);
              FeedContentListView.this._FeedPodcasts.setText((CharSequence)localObject2);
            }
            else
            {
              FeedContentListView.this._FeedPodcasts.setText(str);
              continue;
              label879:
              FeedContentListView.this._FeedPodcasts.setText("");
            }
          }
        }
      }
    });
  }
  
  private void ReloadCurrentFeed(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this._CurrentFeed == null) {
      return;
    }
    CoreHelper.WriteTraceEntry(TAG, "Reloading feed " + this._CurrentFeed.getName() + " in the Feed Content List View!...");
    if ((!this._CurrentFeed.HasUri()) || ((RssFeedCache.HasCachedFileFor(this._CurrentFeed)) && (!paramBoolean1)))
    {
      this._AllowProgressDisplay = true;
      RefreshActivityTitle();
      this._ListViewisScrolling = false;
      this._Adapter.LoadItems(this._CurrentFeed, paramBoolean2);
      return;
    }
    UpdateCurrentFeed();
  }
  
  private void ShowAllItems()
  {
    ApplyFilter(0);
  }
  
  private void StopUpdate()
  {
    if (AggregatorLoginHelper.IsSyncing()) {
      AggregatorLoginHelper.StopSyncing();
    }
    if (this._Catcher.IsUpdating()) {
      this._Catcher.Stop();
    }
  }
  
  private void ToggleItemRead(RssFeedItem paramRssFeedItem)
  {
    if (paramRssFeedItem.getRead()) {}
    for (boolean bool = false;; bool = true)
    {
      paramRssFeedItem.setRead(bool);
      RefreshActivityTitle();
      ScheduledTasksManager.ScheduleGoogleSynUpdateIfNeeded();
      this._Handler.postDelayed(new Runnable()
      {
        public void run()
        {
          FeedContentListView.this.Refresh();
        }
      }, 50L);
      return;
    }
  }
  
  private void ToggleItemStar(RssFeedItem paramRssFeedItem)
  {
    if (paramRssFeedItem.getStarred()) {}
    for (boolean bool = false;; bool = true)
    {
      paramRssFeedItem.setStarred(bool);
      RefreshActivityTitle();
      ScheduledTasksManager.ScheduleGoogleSynUpdateIfNeeded();
      Refresh();
      return;
    }
  }
  
  private void UpdateCurrentFeed()
  {
    StopUpdate();
    Configuration.SetUnableToEstablishWiFiConnectionInThisSession(false);
    if (this._CurrentFeed != this._Adapter.CurrentFeed()) {
      this._Adapter.ClearItems();
    }
    if (this._CurrentFeed.IsGReaderFeed()) {
      try
      {
        AggregatorLoginHelper.SyncItemStatus(this._ReaderSyncListener);
        return;
      }
      catch (Exception localException)
      {
        CoreHelper.LogException(TAG, "Failed to start Google Sync", localException);
        return;
      }
    }
    this._Catcher.UpdateFeed(this._CurrentFeed, true);
  }
  
  private void UpdateFooters()
  {
    NotifyNotSubscribedInReaderIfNeeded();
    NotifyGoogleReadMayHaveMoreItemsIfNeeded();
    NotifyItemsFiltered();
    UpdateFooterToolbar();
  }
  
  public void ApplyFilter(int paramInt)
  {
    if (CurrentRssFeed() == null) {
      return;
    }
    Configuration.setItemFilter(paramInt);
    this._CurrentFeed.setItemFilter(paramInt);
    this._Adapter.FilterItems(paramInt);
    UpdateFooters();
  }
  
  public Feed CurrentFeed()
  {
    return this._CurrentFeed;
  }
  
  boolean CurrentFeedHasDownloadedEpisodes()
  {
    return this._Adapter.CurrentFeedHasDownloadedEpisodes();
  }
  
  boolean CurrentFeedHasLocalEpisodes()
  {
    return this._Adapter.CurrentFeedHasLocalEpisodes();
  }
  
  public boolean CurrentFeedHasReadItems()
  {
    return this._Adapter.CurrentFeedHasReadItems();
  }
  
  RssFeed CurrentRssFeed()
  {
    if (this._Adapter != null) {
      return this._Adapter.CurrentRssFeed();
    }
    return null;
  }
  
  public void FastScrollEnabled(boolean paramBoolean)
  {
    this._ListView.setFastScrollEnabled(paramBoolean);
  }
  
  public int FirstVisibleItemPosition()
  {
    return Math.max(0, this._ListView.getFirstVisiblePosition() - this._ListView.getHeaderViewsCount());
  }
  
  public List<Track> GeneratePlaylist(Track paramTrack)
  {
    return this._Adapter.GeneratePlaylist(paramTrack);
  }
  
  public TitleBarBase.TitleInfo GetViewTitle()
  {
    Object localObject3 = CurrentRssFeed();
    if (this._CurrentFeed == null)
    {
      this._Title.PrimaryTitle = FEED_CONTENT;
      this._Title.SubTitle = "";
    }
    label122:
    label182:
    label228:
    label238:
    label305:
    label337:
    label344:
    label365:
    for (;;)
    {
      return this._Title;
      this._Title.CurrentFeed = this._CurrentFeed;
      this._Title.PrimaryTitle = this._CurrentFeed.getName();
      Object localObject2;
      Object localObject1;
      if (this._CurrentFeed.HasUri())
      {
        int i = FeedContentListViewDataSource.CurrentFeedUnreadItemsCount();
        localObject2 = new StringBuilder(String.valueOf(""));
        if (i > 0)
        {
          localObject1 = i + " " + UNREAD;
          String str = (String)localObject1;
          localObject2 = this._Title;
          if ((localObject3 == null) || (!((RssFeed)localObject3).FeedID.equals(this._CurrentFeed.ID())) || (FeedContentListViewDataSource.VisibleItemCount() <= 0)) {
            break label344;
          }
          if (FeedContentListViewDataSource.VisibleItemCount() != FeedContentListViewDataSource.TotalItemCount()) {
            break label305;
          }
          localObject1 = String.valueOf(FeedContentListViewDataSource.VisibleItemCount());
          localObject3 = new StringBuilder(String.valueOf(localObject1));
          if (str.length() <= 0) {
            break label337;
          }
          localObject1 = " (" + str + ")";
          localObject1 = (String)localObject1;
        }
      }
      for (((TitleBarBase.TitleInfo)localObject2).SubTitle = ((String)localObject1);; this._Title.SubTitle = String.valueOf(FeedContentListViewDataSource.TotalItemCount()))
      {
        if ((!Configuration.AllowMarkingReadOfScrolledPosts()) || (NumberOfScrolledUnreadItems() <= 0)) {
          break label365;
        }
        localObject1 = this._Title;
        ((TitleBarBase.TitleInfo)localObject1).SubTitle = (((TitleBarBase.TitleInfo)localObject1).SubTitle + " - " + NumberOfScrolledUnreadItems());
        break;
        localObject1 = "";
        break label122;
        localObject1 = FeedContentListViewDataSource.VisibleItemCount() + "/" + FeedContentListViewDataSource.TotalItemCount();
        break label182;
        localObject1 = "";
        break label228;
        localObject1 = "";
        break label238;
      }
    }
  }
  
  public boolean HandleContextMenu(MenuItem paramMenuItem)
  {
    Object localObject = (AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo();
    localObject = (RssFeedItem)this._Adapter.getItem(((AdapterView.AdapterContextMenuInfo)localObject).position - this._ListView.getHeaderViewsCount());
    if (localObject == null) {
      return false;
    }
    switch (paramMenuItem.getItemId())
    {
    default: 
      return true;
    case 13: 
      CommandManager.CmdSharePost(getContext(), this._CurrentFeed, (RssFeedItem)localObject);
      return true;
    case 14: 
      EnclosureDownloadHistory.AddEnclosure(((RssFeedItem)localObject).Enclosure(), true);
      if (Configuration.SetAsDownloadedOnMarkRead()) {
        ((RssFeedItem)localObject).setRead(true);
      }
      Refresh();
      return true;
    case 15: 
      EnclosureDownloadHistory.RemoveEnclosure(((RssFeedItem)localObject).Enclosure(), true);
      if (Configuration.SetAsDownloadedOnMarkRead()) {
        ((RssFeedItem)localObject).setRead(false);
      }
      Refresh();
      return true;
    case 19: 
      paramMenuItem = ((RssFeedItem)localObject).Enclosure().GetLocalEnclosureTrack();
      if (paramMenuItem != null) {
        CommandManager.CmdSharePodcast(getContext(), paramMenuItem);
      }
      for (;;)
      {
        return true;
        CommandManager.CmdSharePost(getContext(), this._CurrentFeed, (RssFeedItem)localObject);
      }
    case 17: 
      paramMenuItem = FindOrCreateStreamableTrack(((RssFeedItem)localObject).Enclosure());
      if (paramMenuItem == null) {
        return true;
      }
      if (paramMenuItem.AllowAutoDelete()) {
        CommandManager.CmdLockTrack(getContext(), paramMenuItem);
      }
      for (;;)
      {
        return true;
        CommandManager.CmdUnlockTrack(getContext(), paramMenuItem);
      }
    case 20: 
      DeleteEpisode((RssFeedItem)localObject);
      return true;
    case 21: 
      paramMenuItem = FindOrCreateStreamableTrack(((RssFeedItem)localObject).Enclosure());
      if (paramMenuItem != null) {
        CommandManager.CmdTogglePlayedState(paramMenuItem);
      }
      return true;
    case 16: 
      if (((RssFeedItem)localObject).ItemEnclosures().size() == 1) {
        new AlertDialog.Builder(getContext()).setIcon(17301659).setTitle(EPISODE_DETAILS).setMessage(((RssFeedItem)localObject).DumpItemDetails()).create().show();
      }
      for (;;)
      {
        return true;
        int i = ((RssFeedItem)localObject).ItemEnclosures().indexOf(((RssFeedItem)localObject).Enclosure());
        new AlertDialog.Builder(getContext()).setTitle(EPISODE_FORMATS).setSingleChoiceItems(((RssFeedItem)localObject).DumpEnclosures(), i, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            FeedContentListView.this._CurrentFeed.setPreferredEnclosureIndex(paramAnonymousInt);
            FeedContentListView.this._CurrentFeed.setHasNewContent(true);
            paramAnonymousDialogInterface.dismiss();
            FeedContentListView.this.ReloadCurrentFeed(false, false);
          }
        }).create().show();
      }
    }
    paramMenuItem = ((RssFeedItem)localObject).Enclosure().GetLocalEnclosureTrack();
    if (paramMenuItem != null) {
      CommandManager.CmdOpenExternalPlayer(getContext(), paramMenuItem);
    }
    for (;;)
    {
      return true;
      CommandManager.CmdStreamEnclosure(getContext(), ((RssFeedItem)localObject).Enclosure());
    }
  }
  
  public boolean HandleOptionsMenu(int paramInt, MenuItem paramMenuItem)
  {
    return false;
  }
  
  public boolean HasEnclosures()
  {
    return this._Adapter.HasEnclosures();
  }
  
  boolean HasHiddenItems()
  {
    return this._Adapter.HasHiddenItems();
  }
  
  boolean HasReadItems()
  {
    return this._Adapter.HasReadItems();
  }
  
  public boolean HasUnReadItems()
  {
    return this._Adapter.HasUnReadItems();
  }
  
  public boolean IsEmpty()
  {
    return this._CurrentFeed == null;
  }
  
  public boolean IsHeaderViewVisible()
  {
    return this._ListView.getHeaderViewsCount() > 1;
  }
  
  public boolean IsProgressEnabled()
  {
    return this._AllowProgressDisplay;
  }
  
  public boolean IsUpdating()
  {
    return (this._Catcher.IsUpdating()) || (AggregatorLoginHelper.IsSyncing());
  }
  
  void MarkAllAsRead()
  {
    UserNotificationManager.WarnAboutMarkingAllAsRead(getContext(), new UserNotificationManager.OnContinueListener()
    {
      public void OnContinue()
      {
        if (FeedContentListView.this.CurrentRssFeed() != null)
        {
          FeedContentListView.this.CurrentRssFeed().SetAllItemsAsRead();
          ScheduledTasksManager.ScheduleGoogleSynUpdateIfNeeded();
          FeedContentListView.this.RefreshFeedInfoHeader();
        }
        FeedContentListView.this.HideRead();
        FeedContentListView.this._Owner.CloseView();
      }
    });
  }
  
  public int MarkAllcrolledUnreadItemsUntilPosAsRead(int paramInt)
  {
    paramInt = this._Adapter.MarkAllScrolledUnreadItemsToPosAsRead(paramInt);
    UpdateNumberOfScrolledUnreadItemsIfNeeded();
    return paramInt;
  }
  
  public int NumberOfItemsPerScreen()
  {
    return this._ListView.getChildCount();
  }
  
  public int NumberOfScrolledUnreadItems()
  {
    return this._Adapter.NumberOfScrolledUnreadItems();
  }
  
  public void OnActivityDestroy()
  {
    BeyondPodApplication.MessageBus.Unsubscribe(this, PlayListEvents.PlayListEvent.class);
    BeyondPodApplication.MessageBus.Unsubscribe(this, UpdateAndDownloadEvents.UpdateAndDownloadEvent.class);
    BeyondPodApplication.MessageBus.Unsubscribe(this, RepositoryEvents.RepositoryEvent.class);
  }
  
  void OnAdapterDataLoadCompleted(boolean paramBoolean)
  {
    RefreshActivityTitle();
    ToggleProgressIndicator(false);
    this._LastUpdatedDate.setText("");
    this._NextUpdateDate.setText("");
    this._FeedPodcasts.setText("");
    RefreshFeedInfoHeader();
    if (this._CurrentFeed == null) {
      return;
    }
    if (!paramBoolean)
    {
      NotifyFeedFailedToLoad();
      return;
    }
    UpdateFooters();
    if (this._LastSavedVisibleItem >= 0)
    {
      this._ListView.setSelection(this._LastSavedVisibleItem);
      this._LastSavedVisibleItem = -1;
    }
    if (this._Adapter.SupportsItemImages())
    {
      if (getChildCount() <= 0) {
        break label167;
      }
      PrefetchPostImagesIfNeeded();
    }
    for (;;)
    {
      RssFeedItem localRssFeedItem = (RssFeedItem)this._Adapter.getItem(this._ListView.getHeaderViewsCount());
      if ((localRssFeedItem == null) || (localRssFeedItem.Enclosure() == null) || (this._CurrentFeed.IsTransient) || (Configuration.FeedContentItemOptimizeForReading())) {
        break;
      }
      UserNotificationManager.TipNotifyHowToUseContentView(this._Owner.OwnerActivity().ContentRoot());
      return;
      label167:
      this._Handler.postDelayed(new Runnable()
      {
        public void run()
        {
          FeedContentListView.this.PrefetchPostImagesIfNeeded();
        }
      }, 1000L);
    }
  }
  
  void OnAdapterDataLoadStarted()
  {
    CoreHelper.WriteTraceEntry(TAG, "Dataload Started...");
    this._ListView.removeFooterView(this._InfoFooter1);
    this._ListView.removeFooterView(this._InfoFooter2);
    ToggleProgressIndicator(true);
    if (this._CurrentFeed != null)
    {
      this._FeedImage.setErrorImageResId(FeedImageCache.GetDefaultImageResId(this._CurrentFeed));
      this._FeedImage.setFeed(this._CurrentFeed, getImageLoader());
    }
    this._LastUpdatedDate.setText(LOADING);
    this._NextUpdateDate.setText("");
    this._FeedPodcasts.setText("");
  }
  
  public void OnAfterActivate()
  {
    AnalyticsTracker.OnViewDisplayed("Feed Content View");
    this._Adapter.OnAfterActivate();
    RefreshActivityTitle();
    RefreshFeedInfoHeader();
    Refresh();
  }
  
  public void OnAfterDeactivate()
  {
    this._Adapter.OnAfterDeactivate();
  }
  
  public void OnBeforeActivate()
  {
    this._ListViewisScrolling = false;
    if (this._Adapter != null) {
      this._Adapter.LoadDefaultFontSize();
    }
    if (this._CurrentFeed == null) {
      CoreHelper.WriteTraceEntry(TAG, "Activating FeedContentView with null CurrentFeed!!!");
    }
    if ((this._CurrentFeed != null) && (this._ShouldRefreshOnActivate) && (!this._Catcher.IsUpdating())) {
      this._Adapter.RestoreItemsAfterConfigurationChange();
    }
    this._ShouldRefreshOnActivate = false;
  }
  
  public void OnPlayListEvent(PlayListEvents.PlayListEvent paramPlayListEvent)
  {
    if (paramPlayListEvent.Type == 0) {
      this._Owner.runOnUiThread(new Runnable()
      {
        public void run()
        {
          FeedContentListView.this._Adapter.Refresh();
          FeedContentListView.this._Owner.RefreshPlaylistCount();
        }
      });
    }
  }
  
  public void OnRepositoryEvent(RepositoryEvents.RepositoryEvent paramRepositoryEvent)
  {
    if (this._CurrentFeed == null) {}
    do
    {
      return;
      if ((paramRepositoryEvent.Type == 7) && (paramRepositoryEvent.Feed == this._CurrentFeed)) {
        this._Owner.CloseView();
      }
    } while ((CurrentRssFeed() == null) || ((paramRepositoryEvent.Type != 10) && (paramRepositoryEvent.Type != 15) && (paramRepositoryEvent.Type != 8) && (paramRepositoryEvent.Type != 11)));
    if (((paramRepositoryEvent.Type == 10) || (paramRepositoryEvent.Type == 8)) && (paramRepositoryEvent.Track != null) && (paramRepositoryEvent.Track.getParentFeed() == CurrentFeed()))
    {
      if (FeedContentListViewDataSource.IsEpisodeOnlyFilter(this._CurrentFeed.getItemFilter())) {
        ApplyFilter(this._CurrentFeed.getItemFilter());
      }
      this._Adapter.RefreshOrphanEpisodesForFeed();
    }
    Refresh();
    RefreshActivityTitle();
  }
  
  public void OnUpdateAndDownloadEvent(UpdateAndDownloadEvents.UpdateAndDownloadEvent paramUpdateAndDownloadEvent)
  {
    if ((CurrentRssFeed() == null) || (this._CurrentFeed == null)) {}
    do
    {
      return;
      if ((paramUpdateAndDownloadEvent.Type == UpdateAndDownloadEvents.UpdateAndDownloadEvent.ENCLOSURE_DOWNLOAD_STARTED) || (paramUpdateAndDownloadEvent.Type == UpdateAndDownloadEvents.UpdateAndDownloadEvent.ENCLOSURE_DOWNLOAD_COMPLETED) || (paramUpdateAndDownloadEvent.Type == UpdateAndDownloadEvents.UpdateAndDownloadEvent.ENCLOSURE_DOWNLOAD_QUEUE_CHANGED))
      {
        Refresh();
        return;
      }
    } while (paramUpdateAndDownloadEvent.Type != UpdateAndDownloadEvents.UpdateAndDownloadEvent.UPDATE_AND_DOWNLOAD_COMPLETED);
    this._Owner.runOnUiThread(new Runnable()
    {
      public void run()
      {
        FeedContentListView.this.ReloadCurrentFeed(false, false);
      }
    });
  }
  
  public void PrepareContextMenu(ContextMenu paramContextMenu, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    if (FeedContentListViewDataSource.IsEmpty()) {}
    do
    {
      return;
      paramContextMenuInfo = (RssFeedItem)this._Adapter.getItem(paramContextMenuInfo.position - this._ListView.getHeaderViewsCount());
    } while (paramContextMenuInfo == null);
    if (paramContextMenuInfo.Enclosure() != null)
    {
      Track localTrack = paramContextMenuInfo.Enclosure().GetLocalEnclosureTrack();
      int i;
      if (localTrack != null)
      {
        if (!localTrack.AllowAutoDelete()) {
          paramContextMenu.add(0, 20, 1, 2131296977);
        }
        if (localTrack.AllowAutoDelete())
        {
          i = 2131296644;
          paramContextMenu.add(0, 17, 1, i);
          paramContextMenu.add(0, 21, 2, 2131296643);
        }
      }
      else
      {
        if ((!paramContextMenuInfo.Enclosure().Downloaded()) && (paramContextMenuInfo.IsGoogleReadLocked))
        {
          if (!EnclosureDownloadHistory.HasEntryFor(paramContextMenuInfo.Enclosure())) {
            break label232;
          }
          paramContextMenu.add(0, 15, 6, 2131296702);
        }
        label162:
        if (Configuration.PlayerIntegrationType() != 3) {
          paramContextMenu.add(0, 18, 4, 2131296649);
        }
        if (StringUtils.IsNullOrEmpty(paramContextMenuInfo.Enclosure().Url)) {
          break label250;
        }
        paramContextMenu.add(0, 19, 5, 2131296671);
      }
      for (;;)
      {
        paramContextMenu.add(0, 16, 6, 2131297016);
        return;
        i = 2131296645;
        break;
        label232:
        paramContextMenu.add(0, 14, 6, 2131296701);
        break label162;
        label250:
        paramContextMenu.add(0, 13, 5, 2131296672);
      }
    }
    paramContextMenu.add(0, 13, 1, 2131296672);
  }
  
  public boolean PrepareOptionsMenu(Menu paramMenu)
  {
    return true;
  }
  
  public SimpleMenu PreparePopupOptionsMenu()
  {
    return null;
  }
  
  public void ReApplyFilter()
  {
    ApplyFilter(this._CurrentFeed.getItemFilter());
    this._Adapter.RefreshOrphanEpisodesForFeed();
  }
  
  void Refresh()
  {
    this._Owner.runOnUiThread(new Runnable()
    {
      public void run()
      {
        try
        {
          FeedContentListView.this._Adapter.Refresh();
          FeedContentListView.this.UpdateFooterToolbar();
          FeedContentListView.this.RefreshFeedInfoHeader();
          return;
        }
        catch (Exception localException)
        {
          CoreHelper.LogException(FeedContentListView.TAG, "Exception thrown during feed content refresh!", localException);
        }
      }
    });
  }
  
  public void RefreshActivityTitle()
  {
    this._Owner.RefreshActiveViewTitle();
  }
  
  public void RefreshOnNextActivate()
  {
    this._ShouldRefreshOnActivate = true;
  }
  
  public void RestoreCurrentState(MasterViewState paramMasterViewState)
  {
    this._LastSavedVisibleItem = paramMasterViewState.FeedContentFirstVisibleItem;
    this._CurrentFeed = paramMasterViewState.ContentViewFeed;
    this._Adapter.RestoreCurrentState(paramMasterViewState);
  }
  
  public void RestoreFeedContentState(Bundle paramBundle)
  {
    this._Adapter.RestoreItemsAfterConfigurationChange();
  }
  
  public void SaveCurrentState(MasterViewState paramMasterViewState)
  {
    paramMasterViewState.FeedContentFirstVisibleItem = this._ListView.getFirstVisiblePosition();
    this._Adapter.SaveCurrentState(paramMasterViewState);
  }
  
  public void SaveFeedContentState(Bundle paramBundle) {}
  
  void ToggleProgressIndicator(final boolean paramBoolean)
  {
    this._Owner.runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (paramBoolean)
        {
          FeedContentListView.this._UpdateButton.setVisibility(4);
          FeedContentListView.this._Progress.setVisibility(0);
          return;
        }
        FeedContentListView.this._UpdateButton.setVisibility(0);
        FeedContentListView.this._Progress.setVisibility(8);
      }
    });
  }
  
  void UpdateFooterToolbar()
  {
    if (this._Owner != null) {
      this._Owner.UpdateFooterToolbar();
    }
  }
  
  void UpdateNumberOfScrolledUnreadItemsIfNeeded()
  {
    if (Configuration.AllowMarkingReadOfScrolledPosts()) {
      postDelayed(new Runnable()
      {
        public void run()
        {
          FeedContentListView.this._Owner.RefreshActiveViewTitle();
        }
      }, 100L);
    }
  }
  
  public boolean ViewIsScrolling()
  {
    return this._ListViewisScrolling;
  }
  
  public ImageLoader getImageLoader()
  {
    return this._Owner.getImageLoader();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131230943)
    {
      paramView = paramView.findViewById(2131230953);
      if ((paramView != null) && (paramView.getTag() != null))
      {
        paramView = (RssFeedItem)paramView.getTag();
        if (paramView != null)
        {
          if ((!Configuration.FeedContentItemOptimizeForReading()) && (paramView.Enclosure() != null)) {
            break label60;
          }
          OpenPostContentFor(paramView);
        }
      }
    }
    label60:
    RssFeedItem localRssFeedItem;
    do
    {
      return;
      this._Owner.PlayEnclosure(paramView.Enclosure());
      return;
      localRssFeedItem = (RssFeedItem)paramView.getTag();
    } while (localRssFeedItem == null);
    switch (paramView.getId())
    {
    default: 
      OpenPostContentFor(localRssFeedItem);
      return;
    case 2131230957: 
      UserNotificationManager.TipHowToMarkReadUnread(paramView);
      ToggleItemRead(localRssFeedItem);
      return;
    case 2131230956: 
      ToggleItemStar(localRssFeedItem);
      return;
    case 2131230953: 
      OnDownload(getContext(), localRssFeedItem, this._CurrentFeed);
      return;
    case 2131230955: 
      UserNotificationManager.TipNotifyHowToAddRemovePlaylist(paramView);
      OnAddRemoveFromPlaylist(localRssFeedItem);
      return;
    case 2131230954: 
      DeleteEpisode(localRssFeedItem);
      return;
    }
    if (localRssFeedItem.Enclosure() != null)
    {
      this._Owner.PlayEnclosure(localRssFeedItem.Enclosure());
      return;
    }
    OpenPostContentFor(localRssFeedItem);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
  
  public void setCurrentFeed(Feed paramFeed, int paramInt)
  {
    if (paramFeed == null) {}
    do
    {
      return;
      this._CurrentFeed = paramFeed;
    } while (this._CurrentFeed == null);
    if ((this._CurrentFeed.HasUrl()) && (!this._CurrentFeed.IsTransient) && (Configuration.AllowPullToRefresh())) {}
    for (int i = 1;; i = 0)
    {
      setMode(i);
      paramInt = this._Owner.ConfigureFeedFilter(paramInt, this._CurrentFeed);
      Configuration.setItemFilter(paramInt);
      this._CurrentFeed.setItemFilter(paramInt);
      RefreshActivityTitle();
      ReloadCurrentFeed(Configuration.getUpdateOnFeedOpen(), true);
      return;
    }
  }
  
  public void setHeaderEnabled(boolean paramBoolean)
  {
    this._HeaderEnabled = paramBoolean;
  }
  
  public void setOwner(FeedContentView paramFeedContentView)
  {
    this._Owner = paramFeedContentView;
    RefreshFeedInfoHeader();
  }
  
  public void setSelection(int paramInt)
  {
    this._ListView.setSelection(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/FeedContentListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */