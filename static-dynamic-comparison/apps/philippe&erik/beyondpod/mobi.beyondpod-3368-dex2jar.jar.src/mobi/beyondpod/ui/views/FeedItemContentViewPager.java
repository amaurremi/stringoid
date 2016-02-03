package mobi.beyondpod.ui.views;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Browser;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebView.HitTestResult;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.net.URLEncoder;
import java.util.ArrayList;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.downloadengine.EnclosureDownloadManager;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.MediaFile;
import mobi.beyondpod.rsscore.helpers.MediaFile.MediaFileType;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEvent;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEventListener;
import mobi.beyondpod.rsscore.rss.entities.RssEnclosure;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;
import mobi.beyondpod.services.player.PlayList;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.core.ActionBarHelper;
import mobi.beyondpod.ui.core.MasterViewState;
import mobi.beyondpod.ui.core.SimpleMenu;
import mobi.beyondpod.ui.core.ThemeManager;
import mobi.beyondpod.ui.views.base.CommonMenuHandler;
import mobi.beyondpod.ui.views.base.FeedContentListViewDataSourceEvents.FeedContentListViewDataSourceEvent;
import mobi.beyondpod.ui.views.base.FeedContentListViewDataSourceEvents.FeedContentListViewDataSourceEventListener;
import mobi.beyondpod.ui.views.base.IWebViewOwner;
import mobi.beyondpod.ui.views.notifications.UserNotificationManager;

public class FeedItemContentViewPager
  extends Activity
  implements FeedContentListViewDataSourceEvents.FeedContentListViewDataSourceEventListener, RepositoryEvents.RepositoryEventListener, IWebViewOwner
{
  static final String CURRENT_RSS_ITEM_ID_TAG = "CurrentRSSItemID";
  private static final int FL_MENU_FIRST = 90;
  private static final int FOCUS_NODE_HREF = 102;
  private static final int MENU_ADD_TO_PLAYLIST = 96;
  private static final int MENU_DOWNLOAD = 97;
  private static final int MENU_LOAD_IMAGES = 93;
  private static final int MENU_OPEN_PLAYLIST = 91;
  private static final int MENU_OPEN_POST_IN_BROWSER = 94;
  private static final int MENU_PLAY = 95;
  private static final int MENU_SHARE_LINK = 92;
  private static final String TAG = FeedItemContentViewPager.class.getSimpleName();
  private static int _InstanceCount;
  private boolean _AllowVibrate = true;
  private MenuItem.OnMenuItemClickListener _ContextItemSelectedListener = new MenuItem.OnMenuItemClickListener()
  {
    public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
    {
      int i = paramAnonymousMenuItem.getItemId();
      Message localMessage = FeedItemContentViewPager.this._Handler.obtainMessage(102, i, 0);
      localMessage.obj = this;
      FeedItemContentViewPager.this.currentWebView().requestFocusNodeHref(localMessage);
      paramAnonymousMenuItem = paramAnonymousMenuItem.getIntent();
      if (paramAnonymousMenuItem != null) {
        FeedItemContentViewPager.this.startIntent(paramAnonymousMenuItem);
      }
      return true;
    }
  };
  ViewPager.OnPageChangeListener _CurrentItemChangedListener = new ViewPager.OnPageChangeListener()
  {
    public void onPageScrollStateChanged(int paramAnonymousInt)
    {
      boolean bool = true;
      FeedItemContentViewPager localFeedItemContentViewPager = FeedItemContentViewPager.this;
      if (paramAnonymousInt == 1) {}
      for (;;)
      {
        localFeedItemContentViewPager._IsPageSwitching = bool;
        return;
        bool = false;
      }
    }
    
    public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
    {
      if ((FeedItemContentViewPager.this._AllowVibrate) && (FeedItemContentViewPager.this._IsPageSwitching) && (paramAnonymousFloat == 0.0F) && (paramAnonymousInt2 == 0))
      {
        CoreHelper.Vibrate(CoreHelper.VIBRATE_SHORT);
        FeedItemContentViewPager.this._AllowVibrate = false;
      }
    }
    
    public void onPageSelected(int paramAnonymousInt)
    {
      FeedItemContentViewPager.this._CurrentRssItem = ((RssFeedItem)FeedContentListViewDataSource.Items().get(paramAnonymousInt));
      if ((Configuration.MarkAsReadOnOpen() == 2) || ((Configuration.MarkAsReadOnOpen() == 1) && (FeedItemContentViewPager.this._CurrentRssItem.Enclosure() == null))) {
        FeedItemContentViewPager.this.ChangeCurrentItemReadStatus(true);
      }
      FeedItemContentViewPager.this.UpdateItemHeader();
      FeedItemContentViewPager.this.OnWebPageProgress(FeedItemContentViewPager.this.currentWebView(), 100);
    }
  };
  private TextView _CurrentItemIndex;
  private RssFeedItem _CurrentRssItem;
  private Bundle _CurrentSavedInstanceState;
  private Handler _Handler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
      String str;
      do
      {
        return;
        str = (String)paramAnonymousMessage.getData().get("url");
      } while ((str == null) || (str.length() == 0));
      switch (paramAnonymousMessage.arg1)
      {
      default: 
        return;
      case 2131231244: 
        CommandManager.CmdOpenExternalBrowser(str);
        return;
      case 2131231246: 
        FeedItemContentViewPager.this.copyToClipboard(str);
        return;
      }
      Browser.sendString(FeedItemContentViewPager.this, str);
    }
  };
  boolean _IsPageSwitching = false;
  private ImageView _OpenLink;
  private View.OnClickListener _OpenOriginalSourceHandler = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      FeedItemContentViewPager.DoOpenOriginalSource(FeedItemContentViewPager.this, false, FeedItemContentViewPager.this._CurrentRssItem.Link, FeedItemContentViewPager.this._CurrentRssItem.Title);
    }
  };
  private View.OnLongClickListener _OpenOriginalSourceInBrowserHandler = new View.OnLongClickListener()
  {
    public boolean onLongClick(View paramAnonymousView)
    {
      FeedItemContentViewPager.DoOpenOriginalSource(FeedItemContentViewPager.this, true, FeedItemContentViewPager.this._CurrentRssItem.Link, FeedItemContentViewPager.this._CurrentRssItem.Title);
      return false;
    }
  };
  ImageView _OverflowMenu;
  private FeedItemContentViewPagerAdapter _PagerAdapter;
  private ImageView _PlayEpisode;
  private View.OnClickListener _PopupMenuHandler = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      paramAnonymousView = new SimpleMenu(FeedItemContentViewPager.this, FeedItemContentViewPager.this._OverflowMenu);
      paramAnonymousView.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
      {
        public boolean onMenuItemClick(MenuItem paramAnonymous2MenuItem)
        {
          return FeedItemContentViewPager.this.onMenuItemSelected(0, paramAnonymous2MenuItem);
        }
      });
      FeedItemContentViewPager.this.PrepareOptionsMenu(paramAnonymousView);
      paramAnonymousView.showAsPopupMenu();
    }
  };
  private ImageView _ReadUnreadStatus;
  private ImageView _Star;
  private ViewPager _ViewPager;
  private SeekBar _loadProgress;
  ImageView _nextButton;
  ImageView _prevButton;
  private SeekBar _repositoryLoadProgress;
  
  private void ChangeCurrentStarredStatus(boolean paramBoolean)
  {
    if (this._CurrentRssItem != null)
    {
      this._CurrentRssItem.setStarred(paramBoolean);
      BeyondPodApplication.MessageBus.PublishEventAsync(new RepositoryEvents.RepositoryEvent(15));
      UpdateItemHeader();
    }
  }
  
  public static void DoOpenOriginalSource(Context paramContext, boolean paramBoolean, String paramString, CharSequence paramCharSequence)
  {
    if (StringUtils.IsNullOrEmpty(paramString)) {
      return;
    }
    if (paramBoolean) {}
    try
    {
      CommandManager.CmdOpenExternalBrowser(paramString);
      return;
    }
    catch (Exception paramContext) {}
    Object localObject = paramString;
    if (!StringUtils.IsNullOrEmpty(Configuration.getMobileFormatter()))
    {
      localObject = Uri.parse(Configuration.getMobileFormatter());
      localObject = localObject + paramString;
    }
    if (Configuration.UseExternalBrowser())
    {
      CommandManager.CmdOpenExternalBrowser((String)localObject);
      return;
    }
    StartHtmlViewActivity(paramContext, Uri.parse((String)localObject), paramCharSequence, true);
    return;
  }
  
  private void IndicateEnd()
  {
    CoreHelper.Vibrate(CoreHelper.VIBRATE_SHORT);
  }
  
  private boolean OpenNextPrevItem(int paramInt)
  {
    RssFeedItem localRssFeedItem = FeedContentListViewDataSource.GetNextPrevItem(paramInt, this._CurrentRssItem);
    if (localRssFeedItem != null)
    {
      this._ViewPager.setCurrentItem(FeedContentListViewDataSource.Items().indexOf(localRssFeedItem));
      return true;
    }
    return false;
  }
  
  @SuppressLint({"NewApi"})
  private void PausePlugins()
  {
    if (this._ViewPager == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i != this._ViewPager.getChildCount())
      {
        View localView = this._ViewPager.getChildAt(i);
        if ((localView instanceof WebView))
        {
          CoreHelper.WriteTraceEntry(TAG, "Pausing plugins...");
          ((WebView)localView).onPause();
        }
        i += 1;
      }
    }
  }
  
  private void PlayEpisode()
  {
    if (this._CurrentRssItem.Enclosure() == null) {
      return;
    }
    FeedContentViewActivity.PlayPauseEnclosure(this, this._CurrentRssItem.Enclosure());
  }
  
  private void PrepareOptionsMenu(Menu paramMenu)
  {
    paramMenu.clear();
    int k;
    int j;
    if ((this._CurrentRssItem != null) && (this._CurrentRssItem.Enclosure() != null))
    {
      localObject1 = this._CurrentRssItem.Enclosure().GetLocalEnclosureTrack();
      if ((localObject1 == null) || (!BeyondPodApplication.GetInstance().PlayList().HasTrack((Track)localObject1))) {
        break label456;
      }
      i = 1;
      k = MediaFile.getFileTypeForMimeType(this._CurrentRssItem.Enclosure().Type);
      j = k;
      Object localObject2;
      if (k == 0)
      {
        localObject2 = MediaFile.getFileType(this._CurrentRssItem.Enclosure().FileName());
        j = k;
        if (localObject2 != null) {
          j = ((MediaFile.MediaFileType)localObject2).fileType;
        }
      }
      k = this._CurrentRssItem.Enclosure().PlayableState();
      if ((MediaFile.isImageFileType(j)) || ((Configuration.AllowEpisodeStreaming() == 2) && (k != 0) && (k != 6))) {
        break label461;
      }
      j = 0;
      label148:
      if (j == 0)
      {
        if (i == 0) {
          break label466;
        }
        j = 2131296642;
        label160:
        localObject2 = paramMenu.add(0, 96, 2, j);
        if (i == 0) {
          break label473;
        }
        i = 2130837971;
        label181:
        ((MenuItem)localObject2).setIcon(i);
      }
      paramMenu.add(0, 91, 3, 2131296651).setIcon(2130837969);
      if ((!StringUtils.IsNullOrEmpty(this._CurrentRssItem.Enclosure().Url)) && ((localObject1 == null) || ((localObject1 != null) && (!((Track)localObject1).IsFullyDownloaded()))))
      {
        localObject1 = this._CurrentRssItem.Enclosure();
        if (k != 5) {
          break label480;
        }
        i = 2131296970;
        label265:
        paramMenu.add(0, 97, 4, i).setIcon(2130837950);
      }
    }
    paramMenu.add(0, 92, 5, 2131296670).setIcon(2130837983);
    Object localObject1 = paramMenu.add(0, 93, 6, 2131296669).setIcon(2130837953);
    if (Configuration.LoadContentViewImagesAutomatically())
    {
      i = 2131296668;
      label341:
      ((MenuItem)localObject1).setTitle(i);
      if ((this._OverflowMenu.getVisibility() == 0) && (this._CurrentRssItem != null) && (this._CurrentRssItem.Enclosure() != null))
      {
        i = 0;
        localObject1 = this._CurrentRssItem.Enclosure().GetLocalEnclosureTrack();
        if (localObject1 != null)
        {
          if ((((Track)localObject1).getCurrentPlayState() == 1) || (((Track)localObject1).getCurrentPlayState() == 3)) {
            break label535;
          }
          i = 0;
        }
        label416:
        if (i == 0) {
          break label540;
        }
      }
    }
    label456:
    label461:
    label466:
    label473:
    label480:
    label535:
    label540:
    for (int i = 2131296976;; i = 2131296975)
    {
      paramMenu.add(0, 95, 1, i).setIcon(2130837966);
      CommonMenuHandler.AddMoreMenuAt(paramMenu, 7, 158, false);
      return;
      i = 0;
      break;
      j = 1;
      break label148;
      j = 2131296638;
      break label160;
      i = 2130837970;
      break label181;
      if (EnclosureDownloadManager.IsDownloadPending((RssEnclosure)localObject1))
      {
        i = 2131296971;
        break label265;
      }
      if (k == 1)
      {
        i = 2131296974;
        break label265;
      }
      if (k == 3)
      {
        i = 2131296973;
        break label265;
      }
      i = 2131296972;
      break label265;
      i = 2131296669;
      break label341;
      i = 1;
      break label416;
    }
  }
  
  private void RestoreDataSourceState()
  {
    if ((!FeedContentListViewDataSource.IsDataLoaded()) && (this._CurrentSavedInstanceState != null))
    {
      FeedContentListViewDataSource.RestoreCurrentState(MasterViewState.FromBundle(this._CurrentSavedInstanceState));
      if (FeedContentListViewDataSource.CurrentFeed() != null) {
        FeedContentListViewDataSource.LoadItems(FeedContentListViewDataSource.CurrentFeed(), true);
      }
    }
    else
    {
      return;
    }
    CoreHelper.WriteLogEntry(TAG, "Trying to call FeedContentListViewDataSource.LoadItems with NULL feed");
  }
  
  private void RestoreDialogInstanceState(Bundle paramBundle)
  {
    if (!FeedContentListViewDataSource.IsDataLoaded()) {}
    while ((paramBundle == null) || (paramBundle == null)) {
      return;
    }
    paramBundle = paramBundle.getString("CurrentRSSItemID");
    if (paramBundle != null)
    {
      this._CurrentRssItem = FeedContentListViewDataSource.GetItemById(paramBundle);
      if (this._CurrentRssItem == null) {
        break label55;
      }
      UpdateItemHeader();
    }
    for (;;)
    {
      WireViewPager(this._CurrentRssItem, null);
      return;
      label55:
      CoreHelper.WriteTraceEntry(TAG, "#*#*# Restored Item Not Found");
    }
  }
  
  static boolean StartHtmlViewActivity(Context paramContext, Uri paramUri, CharSequence paramCharSequence, boolean paramBoolean)
  {
    try
    {
      Intent localIntent = new Intent(paramContext, HtmlViewActivity.class);
      localIntent.setData(paramUri);
      localIntent.putExtra("Title", paramCharSequence);
      localIntent.putExtra("IsFeedContentLink", paramBoolean);
      paramContext.startActivity(localIntent);
      return true;
    }
    catch (IllegalArgumentException paramContext) {}
    return false;
  }
  
  private void StartWaitingForDataSourceToLoad()
  {
    BeyondPodApplication.MessageBus.Subscribe(this, FeedContentListViewDataSourceEvents.FeedContentListViewDataSourceEvent.class);
    BeyondPodApplication.MessageBus.Subscribe(this, RepositoryEvents.RepositoryEvent.class);
    if (FeedRepository.RepositoryLoadState() == 2) {
      RestoreDataSourceState();
    }
    for (;;)
    {
      this._repositoryLoadProgress.setVisibility(0);
      this._Star.setVisibility(8);
      this._OpenLink.setVisibility(8);
      this._PlayEpisode.setVisibility(8);
      this._ReadUnreadStatus.setVisibility(8);
      this._prevButton.setVisibility(8);
      this._nextButton.setVisibility(8);
      this._CurrentItemIndex.setText(2131296917);
      return;
      CoreHelper.WriteTraceEntry(TAG, "******* StartWaitingForDataSourceToLoad found that repository is not loaded! (repo state is: " + FeedRepository.RepositoryLoadState() + ") Loading repository...");
      FeedRepository.InitializeAndLoadRepository();
    }
  }
  
  private void StopWaitingForDataSourceToLoad()
  {
    BeyondPodApplication.MessageBus.Unsubscribe(this, FeedContentListViewDataSourceEvents.FeedContentListViewDataSourceEvent.class);
    BeyondPodApplication.MessageBus.Unsubscribe(this, RepositoryEvents.RepositoryEvent.class);
    this._OpenLink.setVisibility(0);
    this._repositoryLoadProgress.setVisibility(8);
  }
  
  private boolean SupportMarkingAsRead()
  {
    return (this._CurrentRssItem != null) && (!this._CurrentRssItem.IsMockItem().booleanValue()) && (FeedContentListViewDataSource.CurrentFeed() != null) && (!FeedContentListViewDataSource.CurrentFeed().IsTransient);
  }
  
  private void WireHeaderFooterViews()
  {
    this._CurrentItemIndex = ((TextView)findViewById(2131230986));
    this._OverflowMenu = ((ImageView)findViewById(2131230867));
    this._OverflowMenu.setOnClickListener(this._PopupMenuHandler);
    ImageView localImageView = this._OverflowMenu;
    if (ActionBarHelper.HasPermanentMenuKey()) {}
    for (int i = 8;; i = 0)
    {
      localImageView.setVisibility(i);
      this._prevButton = ((ImageView)findViewById(2131230985));
      this._prevButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (Configuration.CurrentAppStore() != 2) {
            UserNotificationManager.TipNotifyVolumeSwitchPosts(FeedItemContentViewPager.this);
          }
          FeedItemContentViewPager.this.OpenNextPrevItem(-1);
        }
      });
      this._nextButton = ((ImageView)findViewById(2131230987));
      this._nextButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (Configuration.CurrentAppStore() != 2) {
            UserNotificationManager.TipNotifyVolumeSwitchPosts(FeedItemContentViewPager.this);
          }
          FeedItemContentViewPager.this.OpenNextPrevItem(1);
        }
      });
      this._Star = ((ImageView)findViewById(2131230956));
      this._Star.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = FeedItemContentViewPager.this;
          if (FeedItemContentViewPager.this._CurrentRssItem.getStarred()) {}
          for (boolean bool = false;; bool = true)
          {
            paramAnonymousView.ChangeCurrentStarredStatus(bool);
            return;
          }
        }
      });
      this._OpenLink = ((ImageView)findViewById(2131230984));
      this._OpenLink.setOnClickListener(this._OpenOriginalSourceHandler);
      this._OpenLink.setOnLongClickListener(this._OpenOriginalSourceInBrowserHandler);
      this._PlayEpisode = ((ImageView)findViewById(2131230993));
      this._PlayEpisode.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          FeedItemContentViewPager.this.PlayEpisode();
        }
      });
      this._ReadUnreadStatus = ((ImageView)findViewById(2131230957));
      this._ReadUnreadStatus.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = FeedItemContentViewPager.this;
          if (FeedItemContentViewPager.this._CurrentRssItem.getRead()) {}
          for (boolean bool = false;; bool = true)
          {
            paramAnonymousView.ChangeCurrentItemReadStatus(bool);
            return;
          }
        }
      });
      this._repositoryLoadProgress = ((SeekBar)findViewById(2131230991));
      this._loadProgress = ((SeekBar)findViewById(2131230992));
      return;
    }
  }
  
  private void copyToClipboard(CharSequence paramCharSequence)
  {
    ((ClipboardManager)getSystemService("clipboard")).setText(paramCharSequence);
  }
  
  private void startIntent(Intent paramIntent)
  {
    try
    {
      startActivity(paramIntent);
      return;
    }
    catch (Exception paramIntent)
    {
      Toast.makeText(BeyondPodApplication.GetInstance(), "Unable to open URL!\n\n" + paramIntent.getMessage(), 1).show();
    }
  }
  
  void ChangeCurrentItemReadStatus(boolean paramBoolean)
  {
    if (SupportMarkingAsRead())
    {
      this._CurrentRssItem.setRead(paramBoolean);
      BeyondPodApplication.MessageBus.PublishEventAsync(new RepositoryEvents.RepositoryEvent(15));
      UpdateItemHeader();
    }
  }
  
  public void OnDoubleTap()
  {
    finish();
  }
  
  public void OnFeedContentListViewDataSourceEvent(FeedContentListViewDataSourceEvents.FeedContentListViewDataSourceEvent paramFeedContentListViewDataSourceEvent)
  {
    if (paramFeedContentListViewDataSourceEvent.Type == FeedContentListViewDataSourceEvents.FeedContentListViewDataSourceEvent.LOAD_COMPLETED)
    {
      StopWaitingForDataSourceToLoad();
      RestoreDialogInstanceState(this._CurrentSavedInstanceState);
    }
  }
  
  public void OnRepositoryEvent(final RepositoryEvents.RepositoryEvent paramRepositoryEvent)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (paramRepositoryEvent.Type == 2) {
          FeedItemContentViewPager.this.RestoreDataSourceState();
        }
      }
    });
  }
  
  public void OnScrollingInDirection(int paramInt) {}
  
  void OnWebPageProgress(WebView paramWebView, int paramInt)
  {
    int i = 8;
    this._repositoryLoadProgress.setVisibility(8);
    if (paramWebView == currentWebView())
    {
      paramWebView = this._loadProgress;
      if (paramInt < 100) {
        i = 0;
      }
      paramWebView.setVisibility(i);
      this._loadProgress.setProgress(paramInt);
    }
  }
  
  protected void UpdateItemHeader()
  {
    int j = 4;
    boolean bool2 = this._CurrentRssItem.getRead();
    boolean bool1;
    ImageView localImageView;
    if (FeedContentListViewDataSource.CurrentFeed() != null)
    {
      bool1 = FeedContentListViewDataSource.CurrentFeed().IsGReaderFeed();
      localImageView = this._ReadUnreadStatus;
      if (!bool2) {
        break label250;
      }
      i = 2130838008;
      label39:
      localImageView.setImageResource(i);
      localImageView = this._ReadUnreadStatus;
      if (SupportMarkingAsRead()) {
        break label257;
      }
      i = 4;
      label60:
      localImageView.setVisibility(i);
      localImageView = this._Star;
      if ((!SupportMarkingAsRead()) || (!bool1)) {
        break label262;
      }
      i = 0;
      label85:
      localImageView.setVisibility(i);
      localImageView = this._Star;
      if (!this._CurrentRssItem.getStarred()) {
        break label267;
      }
      i = 2130837696;
      label111:
      localImageView.setImageResource(i);
      localImageView = this._nextButton;
      if (FeedContentListViewDataSource.GetNextPrevItem(1, this._CurrentRssItem) == null) {
        break label274;
      }
      i = 0;
      label136:
      localImageView.setVisibility(i);
      localImageView = this._prevButton;
      if (FeedContentListViewDataSource.GetNextPrevItem(-1, this._CurrentRssItem) == null) {
        break label279;
      }
      i = 0;
      label161:
      localImageView.setVisibility(i);
      this._CurrentItemIndex.setText(String.format("%s/%s", new Object[] { Integer.valueOf(FeedContentListViewDataSource.Items().indexOf(this._CurrentRssItem) + 1), Integer.valueOf(FeedContentListViewDataSource.Items().size()) }));
      if (!ActionBarHelper.HasPermanentMenuKey()) {
        break label289;
      }
      localImageView = this._PlayEpisode;
      if (this._CurrentRssItem.Enclosure() != null) {
        break label284;
      }
    }
    label250:
    label257:
    label262:
    label267:
    label274:
    label279:
    label284:
    for (int i = j;; i = 0)
    {
      localImageView.setVisibility(i);
      return;
      bool1 = false;
      break;
      i = 2130838010;
      break label39;
      i = 0;
      break label60;
      i = 4;
      break label85;
      i = 2130837694;
      break label111;
      i = 4;
      break label136;
      i = 4;
      break label161;
    }
    label289:
    this._PlayEpisode.setVisibility(8);
    ((LinearLayout.LayoutParams)this._ReadUnreadStatus.getLayoutParams()).weight = 0.5F;
  }
  
  void WireViewPager(RssFeedItem paramRssFeedItem, Bundle paramBundle)
  {
    this._ViewPager = ((ViewPager)findViewById(2131230990));
    this._PagerAdapter = new FeedItemContentViewPagerAdapter(this, paramBundle);
    this._ViewPager.setAdapter(this._PagerAdapter);
    this._ViewPager.setOnPageChangeListener(this._CurrentItemChangedListener);
    this._ViewPager.setPageMargin(20);
    FeedContentListViewDataSource.setCollectionChangedListener(new FeedContentListViewDataSource.CollectionChangedListener()
    {
      public void OnCollectionChanged()
      {
        CoreHelper.WriteTraceEntry(FeedItemContentViewPager.TAG, "Underlying feed has changed! Refreshing...");
        FeedItemContentViewPager.this._PagerAdapter.notifyDataSetChanged();
      }
    });
    int i = FeedContentListViewDataSource.Items().indexOf(paramRssFeedItem);
    if (i > 0)
    {
      this._ViewPager.setCurrentItem(i);
      return;
    }
    this._CurrentItemChangedListener.onPageSelected(0);
  }
  
  WebView currentWebView()
  {
    if (this._ViewPager == null) {
      return null;
    }
    return (WebView)this._ViewPager.findViewWithTag(this._CurrentRssItem);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int i = -1;
    boolean bool2 = true;
    AudioManager localAudioManager = (AudioManager)getSystemService("audio");
    boolean bool1;
    if ((Configuration.VolumeControlsNavigationType() == 1) || ((localAudioManager.isMusicActive()) && (Configuration.VolumeControlsNavigationType() == 0))) {
      bool1 = super.dispatchKeyEvent(paramKeyEvent);
    }
    label100:
    do
    {
      do
      {
        do
        {
          int j;
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return bool1;
                        j = paramKeyEvent.getKeyCode();
                        if (j != 24) {
                          break;
                        }
                        bool1 = bool2;
                      } while (paramKeyEvent.getAction() != 0);
                      j = i;
                      if (0 != 0) {
                        if (1 != 0) {
                          break label100;
                        }
                      }
                      for (j = i;; j = 1)
                      {
                        bool1 = bool2;
                        if (OpenNextPrevItem(j)) {
                          break;
                        }
                        IndicateEnd();
                        return true;
                      }
                      if (j != 25) {
                        break;
                      }
                      bool1 = bool2;
                    } while (paramKeyEvent.getAction() != 0);
                    if ((0 == 0) || (1 == 0)) {
                      i = 1;
                    }
                    bool1 = bool2;
                  } while (OpenNextPrevItem(i));
                  IndicateEnd();
                  return true;
                  if ((j != 87) && (j != 90)) {
                    break;
                  }
                  bool1 = bool2;
                } while (paramKeyEvent.getAction() != 0);
                bool1 = bool2;
              } while (OpenNextPrevItem(1));
              IndicateEnd();
              return true;
              if ((j != 88) && (j != 89)) {
                break;
              }
              bool1 = bool2;
            } while (paramKeyEvent.getAction() != 0);
            bool1 = bool2;
          } while (OpenNextPrevItem(-1));
          IndicateEnd();
          return true;
          if ((j != 126) && (j != 85)) {
            break;
          }
          bool1 = bool2;
        } while (this._CurrentRssItem == null);
        bool1 = bool2;
      } while (paramKeyEvent.getAction() != 0);
      bool1 = bool2;
    } while (this._CurrentRssItem.Enclosure() == null);
    PlayEpisode();
    return true;
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this._AllowVibrate = true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void finalize()
    throws Throwable
  {
    if (CoreHelper.IsDebugBuild())
    {
      _InstanceCount -= 1;
      CoreHelper.WriteTraceEntryInDebug(TAG, "######### FeedItemContentViewPager FINALIZED! Remaining instances: " + _InstanceCount);
    }
    super.finalize();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    System.gc();
    _InstanceCount += 1;
    CoreHelper.WriteTraceEntryInDebug(TAG, "######### FeedItemContentViewPager Created! Current instances: " + _InstanceCount);
    if (_InstanceCount > 1) {
      CoreHelper.WriteTraceErrorInDebug(TAG, "######### Possible FeedItemContentViewPager Leak ######### " + _InstanceCount);
    }
    if (ThemeManager.CurrentFeedItemContentViewDialogTheme() != -1) {
      setTheme(ThemeManager.CurrentFeedItemContentViewDialogTheme());
    }
    if (Configuration.OrientationLock() == 2) {
      setRequestedOrientation(0);
    }
    for (;;)
    {
      super.onCreate(paramBundle);
      requestWindowFeature(1);
      setContentView(2130903114);
      WireHeaderFooterViews();
      this._ReadUnreadStatus.setVisibility(8);
      this._repositoryLoadProgress.setVisibility(0);
      this._prevButton.setVisibility(8);
      this._nextButton.setVisibility(8);
      RssFeedItem localRssFeedItem = FeedContentListViewDataSource.GetItemById(getIntent().getStringExtra("RssItemId"));
      if ((paramBundle == null) && (localRssFeedItem != null)) {
        WireViewPager(localRssFeedItem, null);
      }
      return;
      if (Configuration.OrientationLock() == 1) {
        setRequestedOrientation(1);
      }
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramView = ((WebView)paramView).getHitTestResult();
    if (paramView == null) {}
    int i;
    do
    {
      return;
      i = paramView.getType();
      if (i == 0)
      {
        CoreHelper.WriteTraceEntry(TAG, "We should not show context menu when nothing is touched");
        return;
      }
    } while (i == 9);
    getMenuInflater().inflate(2131755009, paramContextMenu);
    paramView = paramView.getExtra();
    if (i == 2)
    {
      bool = true;
      label66:
      paramContextMenu.setGroupVisible(2131231233, bool);
      if (i != 4) {
        break label232;
      }
      bool = true;
      label86:
      paramContextMenu.setGroupVisible(2131231237, bool);
      if (i != 3) {
        break label238;
      }
      bool = true;
      label106:
      paramContextMenu.setGroupVisible(2131231240, bool);
      if ((i == 5) || (i == 8)) {
        break label244;
      }
      bool = false;
      label133:
      paramContextMenu.setGroupVisible(2131231247, bool);
      if ((i == 7) || (i == 8)) {
        break label250;
      }
    }
    label232:
    label238:
    label244:
    label250:
    for (boolean bool = false;; bool = true)
    {
      paramContextMenu.setGroupVisible(2131231243, bool);
      switch (i)
      {
      case 6: 
      default: 
        CoreHelper.WriteLogEntry(TAG, "We should not get here.");
        return;
        bool = false;
        break label66;
        bool = false;
        break label86;
        bool = false;
        break label106;
        bool = true;
        break label133;
      }
    }
    paramContextMenu.setHeaderTitle(Uri.decode(paramView));
    paramContextMenu.findItem(2131231234).setIntent(new Intent("android.intent.action.VIEW", Uri.parse("tel:" + paramView))).setOnMenuItemClickListener(this._ContextItemSelectedListener);
    paramContextMenuInfo = new Intent("android.intent.action.INSERT_OR_EDIT");
    paramContextMenuInfo.putExtra("phone", Uri.decode(paramView));
    paramContextMenuInfo.setType("vnd.android.cursor.item/person");
    paramContextMenu.findItem(2131231235).setIntent(paramContextMenuInfo).setOnMenuItemClickListener(this._ContextItemSelectedListener);
    paramContextMenu.findItem(2131231236).setOnMenuItemClickListener(new CopyListener(paramView));
    return;
    paramContextMenu.setHeaderTitle(paramView);
    paramContextMenu.findItem(2131231238).setIntent(new Intent("android.intent.action.VIEW", Uri.parse("mailto:" + paramView))).setOnMenuItemClickListener(this._ContextItemSelectedListener);
    paramContextMenu.findItem(2131231239).setOnMenuItemClickListener(new CopyListener(paramView));
    return;
    paramContextMenu.setHeaderTitle(paramView);
    paramContextMenu.findItem(2131231241).setIntent(new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=" + URLEncoder.encode(paramView)))).setOnMenuItemClickListener(this._ContextItemSelectedListener);
    paramContextMenu.findItem(2131231242).setOnMenuItemClickListener(new CopyListener(paramView));
    return;
    paramContextMenuInfo = (TextView)LayoutInflater.from(this).inflate(17367054, null);
    paramContextMenuInfo.setText(paramView);
    paramContextMenu.setHeaderView(paramContextMenuInfo);
    paramContextMenu.findItem(2131231244).setOnMenuItemClickListener(this._ContextItemSelectedListener);
    paramContextMenu.findItem(2131231246).setOnMenuItemClickListener(this._ContextItemSelectedListener);
    paramContextMenuInfo = getPackageManager();
    Object localObject = new Intent("android.intent.action.SEND");
    ((Intent)localObject).setType("text/plain");
    paramContextMenuInfo = paramContextMenuInfo.resolveActivity((Intent)localObject, 65536);
    localObject = paramContextMenu.findItem(2131231245);
    if (paramContextMenuInfo != null) {}
    for (bool = true;; bool = false)
    {
      ((MenuItem)localObject).setVisible(bool).setOnMenuItemClickListener(this._ContextItemSelectedListener);
      if (i == 7) {
        break;
      }
      if (i == 5) {
        paramContextMenu.setHeaderTitle(paramView);
      }
      paramContextMenu.findItem(2131231248).setIntent(new Intent("android.intent.action.VIEW", Uri.parse(paramView))).setOnMenuItemClickListener(this._ContextItemSelectedListener);
      return;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return true;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    FeedContentListViewDataSource.setCollectionChangedListener(null);
    if (this._ViewPager != null) {}
    for (;;)
    {
      if (this._ViewPager.getChildCount() <= 0) {
        return;
      }
      View localView = this._ViewPager.getChildAt(0);
      if ((localView instanceof WebView)) {
        ((WebView)localView).destroy();
      }
    }
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    boolean bool = false;
    switch (paramMenuItem.getItemId())
    {
    default: 
      if (!CommonMenuHandler.HandleCommonMenu(paramMenuItem, this)) {
        break;
      }
    case 16908332: 
    case 94: 
    case 91: 
    case 92: 
    case 93: 
      do
      {
        do
        {
          return true;
          finish();
          return true;
          this._OpenOriginalSourceHandler.onClick(null);
          return true;
          CommandManager.CmdOpenManagePlaylistView(false);
          return true;
        } while (this._CurrentRssItem == null);
        CommandManager.CmdSendEMail(this, Configuration.getDefaultSendToMailAddress(), this._CurrentRssItem.Title.toString(), this._CurrentRssItem.Link, null, false);
        return true;
      } while (currentWebView() == null);
      if (Configuration.LoadContentViewImagesAutomatically()) {}
      for (;;)
      {
        Configuration.setLoadContentViewImagesAutomatically(bool);
        paramInt = 0;
        while (paramInt != this._ViewPager.getChildCount())
        {
          paramMenuItem = this._ViewPager.getChildAt(paramInt);
          if ((paramMenuItem instanceof WebView))
          {
            ((WebView)paramMenuItem).getSettings().setLoadsImagesAutomatically(Configuration.LoadContentViewImagesAutomatically());
            this._PagerAdapter.ReloadContent((WebView)paramMenuItem);
          }
          paramInt += 1;
        }
        bool = true;
      }
    case 95: 
      PlayEpisode();
      return true;
    case 96: 
      FeedContentListView.OnAddRemoveFromPlaylist(this._CurrentRssItem);
      return true;
    case 97: 
      FeedContentListView.OnDownload(this, this._CurrentRssItem, FeedContentListViewDataSource.CurrentFeed());
      return true;
    }
    return super.onMenuItemSelected(paramInt, paramMenuItem);
  }
  
  protected void onPause()
  {
    PausePlugins();
    super.onPause();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (ActionBarHelper.HasPermanentMenuKey())
    {
      PrepareOptionsMenu(paramMenu);
      return super.onPrepareOptionsMenu(paramMenu);
    }
    this._PopupMenuHandler.onClick(null);
    return false;
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if (FeedContentListViewDataSource.IsDataLoaded())
    {
      RestoreDialogInstanceState(paramBundle);
      return;
    }
    this._CurrentSavedInstanceState = paramBundle;
    StartWaitingForDataSourceToLoad();
  }
  
  @SuppressLint({"NewApi"})
  protected void onResume()
  {
    int i;
    if (this._ViewPager != null) {
      i = 0;
    }
    for (;;)
    {
      if (i == this._ViewPager.getChildCount())
      {
        super.onResume();
        return;
      }
      View localView = this._ViewPager.getChildAt(i);
      if ((localView instanceof WebView)) {
        ((WebView)localView).onResume();
      }
      i += 1;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    CoreHelper.WriteTraceEntry(TAG, "#*#*# Save Instance State for: " + this._CurrentRssItem);
    super.onSaveInstanceState(paramBundle);
    if (currentWebView() != null) {
      currentWebView().saveState(paramBundle);
    }
    if (this._CurrentRssItem != null) {
      paramBundle.putString("CurrentRSSItemID", this._CurrentRssItem.ItemID());
    }
    MasterViewState localMasterViewState = new MasterViewState();
    FeedContentListViewDataSource.SaveCurrentState(localMasterViewState);
    localMasterViewState.ToBundle(paramBundle);
  }
  
  protected void onStart()
  {
    super.onStart();
    CookieSyncManager.getInstance().startSync();
  }
  
  protected void onStop()
  {
    super.onStop();
    CookieSyncManager.getInstance().stopSync();
  }
  
  private class CopyListener
    implements MenuItem.OnMenuItemClickListener
  {
    private CharSequence mText;
    
    public CopyListener(CharSequence paramCharSequence)
    {
      this.mText = paramCharSequence;
    }
    
    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      FeedItemContentViewPager.this.copyToClipboard(this.mText);
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/FeedItemContentViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */