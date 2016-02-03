package mobi.beyondpod.ui.views;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.provider.Browser;
import android.text.ClipboardManager;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebHistoryItem;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebView.HitTestResult;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import java.net.URLEncoder;
import java.util.ArrayList;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.helpers.AnalyticsTracker;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEvent;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEventListener;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.core.ActionBarHelper;
import mobi.beyondpod.ui.core.MasterViewState;
import mobi.beyondpod.ui.core.ThemeManager;
import mobi.beyondpod.ui.core.WebViewPluginHelper;
import mobi.beyondpod.ui.views.base.FeedContentListViewDataSourceEvents.FeedContentListViewDataSourceEvent;
import mobi.beyondpod.ui.views.base.FeedContentListViewDataSourceEvents.FeedContentListViewDataSourceEventListener;
import mobi.beyondpod.ui.views.base.IWebViewOwner;
import mobi.beyondpod.ui.views.base.WebViewEx;
import mobi.beyondpod.ui.views.notifications.UserNotificationManager;

public class FeedItemContentViewDialog
  extends Activity
  implements FeedContentListViewDataSourceEvents.FeedContentListViewDataSourceEventListener, RepositoryEvents.RepositoryEventListener, IWebViewOwner
{
  private static final String CURRENT_RSS_ITEM_ID_TAG = "CurrentRSSItemID";
  private static final int FOCUS_NODE_HREF = 102;
  private static final int MENU_CHANGE_LAYOUT = 12;
  private static final int MENU_COPY_LINK = 8;
  private static final int MENU_LOAD_IMAGES = 10;
  private static final int MENU_SHARE_LINK = 9;
  private static final String TAG = FeedContentListView.class.getSimpleName();
  private MenuItem.OnMenuItemClickListener _ContextItemSelectedListener = new MenuItem.OnMenuItemClickListener()
  {
    public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
    {
      int i = paramAnonymousMenuItem.getItemId();
      Message localMessage = FeedItemContentViewDialog.this._Handler.obtainMessage(102, i, 0);
      localMessage.obj = this;
      FeedItemContentViewDialog.this._WebView.requestFocusNodeHref(localMessage);
      paramAnonymousMenuItem = paramAnonymousMenuItem.getIntent();
      if (paramAnonymousMenuItem != null) {
        FeedItemContentViewDialog.this.startIntent(paramAnonymousMenuItem);
      }
      return true;
    }
  };
  private TextView _CurrentItemIndex;
  private RssFeedItem _CurrentRssItem;
  private Bundle _CurrentSavedInstanceState;
  private LinearLayout _Footer;
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
        FeedItemContentViewDialog.this.copyToClipboard(str);
        return;
      }
      Browser.sendString(FeedItemContentViewDialog.this, str);
    }
  };
  private LinearLayout _Header;
  private int _HeaderHeight = -2;
  private int _HeaderScrollIncrement = -1;
  private TextView _ItemOriginatingFeed;
  private TextView _ItemPubDate;
  private TextView _ItemText;
  private ProgressBar _LoadProgress;
  private ImageView _OpenLink;
  private View.OnClickListener _OpenLinkClickHandler = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (FeedItemContentViewDialog.this._CurrentRssItem.Enclosure() == null)
      {
        FeedItemContentViewDialog.DoOpenOriginalSource(FeedItemContentViewDialog.this, false, FeedItemContentViewDialog.this._CurrentRssItem.Link, FeedItemContentViewDialog.this._CurrentRssItem.Title);
        return;
      }
      FeedContentViewActivity.PlayPauseEnclosure(FeedItemContentViewDialog.this, FeedItemContentViewDialog.this._CurrentRssItem.Enclosure());
    }
  };
  private View.OnClickListener _OpenOriginalSourceHandler = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      FeedItemContentViewDialog.DoOpenOriginalSource(FeedItemContentViewDialog.this, false, FeedItemContentViewDialog.this._CurrentRssItem.Link, FeedItemContentViewDialog.this._CurrentRssItem.Title);
    }
  };
  private View.OnLongClickListener _OpenOriginalSourceInBrowserHandler = new View.OnLongClickListener()
  {
    public boolean onLongClick(View paramAnonymousView)
    {
      FeedItemContentViewDialog.DoOpenOriginalSource(FeedItemContentViewDialog.this, true, FeedItemContentViewDialog.this._CurrentRssItem.Link, FeedItemContentViewDialog.this._CurrentRssItem.Title);
      return false;
    }
  };
  private ImageView _OverflowMenu;
  private ImageView _ReadUnreadStatus;
  private boolean _ResetHeaderOnNextShow = false;
  private ImageView _Star;
  protected WebViewEx _WebView;
  ImageView _nextButton;
  ImageView _prevButton;
  
  private void ChangeCurrentItemReadStatus(boolean paramBoolean)
  {
    if (SupportMarkingAsRead())
    {
      this._CurrentRssItem.setRead(paramBoolean);
      BeyondPodApplication.MessageBus.PublishEventAsync(new RepositoryEvents.RepositoryEvent(15));
      UpdateItemHeader();
    }
  }
  
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
    if (!StringUtils.IsNullOrEmpty(mobi.beyondpod.rsscore.Configuration.getMobileFormatter()))
    {
      localObject = Uri.parse(mobi.beyondpod.rsscore.Configuration.getMobileFormatter());
      localObject = localObject + paramString;
    }
    if (mobi.beyondpod.rsscore.Configuration.UseExternalBrowser())
    {
      CommandManager.CmdOpenExternalBrowser((String)localObject);
      return;
    }
    StartHtmlViewActivity(paramContext, Uri.parse((String)localObject), paramCharSequence, true);
    return;
  }
  
  private void IndicateEnd()
  {
    ((Vibrator)getSystemService("vibrator")).vibrate(30L);
  }
  
  private void LoadItemData(RssFeedItem paramRssFeedItem)
  {
    AnalyticsTracker.OnViewDisplayed("Item Content View");
    if (paramRssFeedItem != null)
    {
      this._CurrentRssItem = paramRssFeedItem;
      if ((mobi.beyondpod.rsscore.Configuration.MarkAsReadOnOpen() == 2) || ((mobi.beyondpod.rsscore.Configuration.MarkAsReadOnOpen() == 1) && (this._CurrentRssItem.Enclosure() == null))) {
        ChangeCurrentItemReadStatus(true);
      }
      ResetHeader();
      UpdateItemHeader();
      UpdateFooterState();
      if (this._WebView != null)
      {
        this._WebView.clearView();
        this._WebView.loadUrl(mobi.beyondpod.rsscore.Configuration.BeyondPodContentUrl() + "/rssItemId/" + Uri.encode(new StringBuilder(String.valueOf(this._CurrentRssItem.ItemID())).append(".html").toString()));
      }
      return;
    }
    CoreHelper.WriteTraceEntry(TAG, "#*#*# LoadItemData - DataSource is not ready! Ignoring!");
  }
  
  private boolean OpenNextPrevItem(int paramInt)
  {
    RssFeedItem localRssFeedItem = FeedContentListViewDataSource.GetNextPrevItem(paramInt, this._CurrentRssItem);
    if (localRssFeedItem != null)
    {
      LoadItemData(localRssFeedItem);
      return true;
    }
    return false;
  }
  
  private void ResetHeader()
  {
    this._HeaderHeight = -2;
    if (this._Header.getLayoutParams().height != this._HeaderHeight) {
      this._Header.setLayoutParams(new LinearLayout.LayoutParams(-1, this._HeaderHeight));
    }
    this._ResetHeaderOnNextShow = false;
    this._Header.setVisibility(0);
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
    String str = paramBundle.getString("CurrentRSSItemID");
    if (str != null)
    {
      this._CurrentRssItem = FeedContentListViewDataSource.GetItemById(str);
      if (this._CurrentRssItem == null) {
        break label63;
      }
      UpdateItemHeader();
      UpdateFooterState();
    }
    for (;;)
    {
      WireWebView();
      this._WebView.restoreState(paramBundle);
      return;
      label63:
      CoreHelper.WriteTraceEntry(TAG, "#*#*# Restored Item Not Found");
    }
  }
  
  private static void StartHtmlViewActivity(Context paramContext, Uri paramUri, CharSequence paramCharSequence, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, HtmlViewActivity.class);
    localIntent.setData(paramUri);
    localIntent.putExtra("Title", paramCharSequence);
    localIntent.putExtra("IsFeedContentLink", paramBoolean);
    paramContext.startActivity(localIntent);
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
      this._LoadProgress.setVisibility(0);
      this._Star.setVisibility(8);
      this._ReadUnreadStatus.setVisibility(8);
      this._Footer.setVisibility(8);
      this._ItemText.setText("Loading...");
      this._ItemOriginatingFeed.setText("");
      this._ItemPubDate.setText("");
      return;
      CoreHelper.WriteTraceEntry(TAG, "******* StartWaitingForDataSourceToLoad found that repository is not loaded! (repo state is: " + FeedRepository.RepositoryLoadState() + ") Loading repository...");
      FeedRepository.InitializeAndLoadRepository();
    }
  }
  
  private void StopWaitingForDataSourceToLoad()
  {
    BeyondPodApplication.MessageBus.Unsubscribe(this, FeedContentListViewDataSourceEvents.FeedContentListViewDataSourceEvent.class);
    BeyondPodApplication.MessageBus.Unsubscribe(this, RepositoryEvents.RepositoryEvent.class);
    this._Footer.setVisibility(0);
    this._LoadProgress.setVisibility(8);
  }
  
  private boolean SupportMarkingAsRead()
  {
    return (this._CurrentRssItem != null) && (!this._CurrentRssItem.IsMockItem().booleanValue()) && (FeedContentListViewDataSource.CurrentFeed() != null) && (!FeedContentListViewDataSource.CurrentFeed().IsTransient);
  }
  
  private void UpdateFooterState()
  {
    int j = 4;
    ImageView localImageView = this._nextButton;
    if (FeedContentListViewDataSource.GetNextPrevItem(1, this._CurrentRssItem) != null) {}
    for (int i = 0;; i = 4)
    {
      localImageView.setVisibility(i);
      localImageView = this._prevButton;
      i = j;
      if (FeedContentListViewDataSource.GetNextPrevItem(-1, this._CurrentRssItem) != null) {
        i = 0;
      }
      localImageView.setVisibility(i);
      this._CurrentItemIndex.setText(String.format("%s/%s", new Object[] { Integer.valueOf(FeedContentListViewDataSource.Items().indexOf(this._CurrentRssItem) + 1), Integer.valueOf(FeedContentListViewDataSource.Items().size()) }));
      if (this._CurrentRssItem.Enclosure() != null) {
        break;
      }
      this._OpenLink.setImageResource(2130837834);
      return;
    }
    this._OpenLink.setImageResource(2130837844);
  }
  
  private void WireHeaderFooterViews()
  {
    this._CurrentItemIndex = ((TextView)findViewById(2131230986));
    this._prevButton = ((ImageView)findViewById(2131230985));
    this._prevButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (mobi.beyondpod.rsscore.Configuration.CurrentAppStore() != 2) {
          UserNotificationManager.TipNotifyVolumeSwitchPosts(FeedItemContentViewDialog.this);
        }
        FeedItemContentViewDialog.this.OpenNextPrevItem(-1);
      }
    });
    this._nextButton = ((ImageView)findViewById(2131230987));
    this._nextButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (mobi.beyondpod.rsscore.Configuration.CurrentAppStore() != 2) {
          UserNotificationManager.TipNotifyVolumeSwitchPosts(FeedItemContentViewDialog.this);
        }
        FeedItemContentViewDialog.this.OpenNextPrevItem(1);
      }
    });
    this._Header = ((LinearLayout)findViewById(2131230977));
    this._Star = ((ImageView)findViewById(2131230956));
    this._Star.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = FeedItemContentViewDialog.this;
        if (FeedItemContentViewDialog.this._CurrentRssItem.getStarred()) {}
        for (boolean bool = false;; bool = true)
        {
          paramAnonymousView.ChangeCurrentStarredStatus(bool);
          return;
        }
      }
    });
    this._ReadUnreadStatus = ((ImageView)findViewById(2131230957));
    this._ReadUnreadStatus.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = FeedItemContentViewDialog.this;
        if (FeedItemContentViewDialog.this._CurrentRssItem.getRead()) {}
        for (boolean bool = false;; bool = true)
        {
          paramAnonymousView.ChangeCurrentItemReadStatus(bool);
          return;
        }
      }
    });
    this._OverflowMenu = ((ImageView)findViewById(2131230867));
    this._OverflowMenu.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        FeedItemContentViewDialog.this.openOptionsMenu();
      }
    });
    Object localObject = this._OverflowMenu;
    if (ActionBarHelper.HasPermanentMenuKey()) {}
    for (int i = 8;; i = 0)
    {
      ((ImageView)localObject).setVisibility(i);
      this._ItemText = ((TextView)findViewById(2131230966));
      this._ItemOriginatingFeed = ((TextView)findViewById(2131230950));
      this._ItemPubDate = ((TextView)findViewById(2131230967));
      this._LoadProgress = ((ProgressBar)findViewById(16842752));
      this._LoadProgress.setVisibility(8);
      this._Footer = ((LinearLayout)findViewById(2131230982));
      this._OpenLink = ((ImageView)findViewById(2131230984));
      this._OpenLink.setOnClickListener(this._OpenLinkClickHandler);
      ((ImageView)findViewById(2131230988)).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          FeedItemContentViewDialog.this._WebView.zoomIn();
        }
      });
      ((ImageView)findViewById(2131230989)).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          FeedItemContentViewDialog.this._WebView.zoomOut();
        }
      });
      ((ImageView)findViewById(2131230983)).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          FeedItemContentViewDialog.this.finish();
        }
      });
      localObject = findViewById(2131230978);
      ((View)localObject).setOnClickListener(this._OpenOriginalSourceHandler);
      ((View)localObject).setOnLongClickListener(this._OpenOriginalSourceInBrowserHandler);
      CoreHelper.ForceBackgroundTile(this._Header);
      CoreHelper.ForceBackgroundTile(this._Footer);
      return;
    }
  }
  
  private void WireWebView()
  {
    if (this._WebView != null) {
      return;
    }
    this._WebView = ((WebViewEx)((ViewStub)findViewById(2131230980)).inflate());
    this._WebView.Initialize(this, mobi.beyondpod.rsscore.Configuration.AllowMarginNavigationInFeedItemContentDialog(), false);
    registerForContextMenu(this._WebView);
    this._WebView.setWebChromeClient(new WebChrome());
    Object localObject = this._WebView.getSettings();
    ((WebSettings)localObject).setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
    ((WebSettings)localObject).setUseWideViewPort(false);
    ((WebSettings)localObject).setBuiltInZoomControls(true);
    WebViewPluginHelper.EnableBrowserPluginsIfNeeded((WebSettings)localObject);
    localObject = mobi.beyondpod.rsscore.Configuration.ContentThemeBackgroundColor();
    if (localObject != null) {
      this._WebView.setBackgroundColor(((Integer)localObject).intValue());
    }
    this._WebView.setWebViewClient(new WebViewClient()
    {
      public void doUpdateVisitedHistory(WebView paramAnonymousWebView, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        if ((paramAnonymousString != null) && (paramAnonymousString.startsWith(mobi.beyondpod.rsscore.Configuration.BeyondPodContentUrl()))) {
          paramAnonymousWebView.clearHistory();
        }
      }
      
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        FeedItemContentViewDialog.this._WebView.getSettings().setLayoutAlgorithm(mobi.beyondpod.rsscore.Configuration.FeedContentDialogLayoutType());
        super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
      }
      
      public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        FeedItemContentViewDialog.this._WebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        CookieSyncManager.getInstance().resetSync();
      }
      
      public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        CoreHelper.WriteTraceEntry(FeedItemContentViewDialog.TAG, "------ Page Error: " + paramAnonymousString1 + " at " + paramAnonymousString2);
        super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (mobi.beyondpod.rsscore.Configuration.UseExternalBrowser())
        {
          if (!StringUtils.IsNullOrEmpty(paramAnonymousString)) {
            CommandManager.CmdOpenExternalBrowser(paramAnonymousString);
          }
          return true;
        }
        paramAnonymousWebView = paramAnonymousWebView.copyBackForwardList();
        if ((paramAnonymousWebView != null) && (paramAnonymousWebView.getCurrentItem() != null) && (StringUtils.EqualsIgnoreCase(paramAnonymousString, paramAnonymousWebView.getCurrentItem().getUrl()))) {
          return false;
        }
        for (;;)
        {
          try
          {
            localUri1 = Uri.parse(paramAnonymousString);
            if (!paramAnonymousString.contains("youtube.com/?v="))
            {
              paramAnonymousWebView = paramAnonymousString;
              if (!paramAnonymousString.contains("youtube.com?v=")) {}
            }
            else
            {
              paramAnonymousWebView = paramAnonymousString.replace("youtube.com", "youtube.com/watch").replace("/?v=", "?v=");
              localUri1 = Uri.parse(paramAnonymousWebView);
            }
            if (WebViewEx.StartExternalActivityForURLIfNeeded(FeedItemContentViewDialog.this, localUri1)) {
              break;
            }
            paramAnonymousString = paramAnonymousWebView;
          }
          catch (IllegalArgumentException paramAnonymousWebView)
          {
            Uri localUri1;
            return false;
          }
          try
          {
            if (!StringUtils.IsNullOrEmpty(mobi.beyondpod.rsscore.Configuration.getMobileFormatter()))
            {
              Uri localUri2 = Uri.parse(mobi.beyondpod.rsscore.Configuration.getMobileFormatter());
              paramAnonymousString = paramAnonymousWebView;
              if (!localUri2.getHost().equals(localUri1.getHost())) {
                paramAnonymousString = localUri2 + paramAnonymousWebView;
              }
            }
          }
          catch (Exception paramAnonymousString)
          {
            paramAnonymousString = paramAnonymousWebView;
            continue;
          }
          try
          {
            FeedItemContentViewDialog.StartHtmlViewActivity(FeedItemContentViewDialog.this, Uri.parse(paramAnonymousString), "Loading...", true);
            return true;
          }
          catch (IllegalArgumentException paramAnonymousWebView)
          {
            return false;
          }
        }
      }
    });
    this._WebView.setDownloadListener(new DownloadListener()
    {
      public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
      {
        if ((paramAnonymousString3 == null) || (!paramAnonymousString3.regionMatches(true, 0, "attachment", 0, 10)))
        {
          paramAnonymousString2 = new Intent("android.intent.action.VIEW");
          paramAnonymousString2.setDataAndType(Uri.parse(paramAnonymousString1), paramAnonymousString4);
          if (FeedItemContentViewDialog.this.getPackageManager().resolveActivity(paramAnonymousString2, 65536) != null) {
            try
            {
              FeedItemContentViewDialog.this.startActivity(paramAnonymousString2);
              return;
            }
            catch (ActivityNotFoundException paramAnonymousString2)
            {
              CoreHelper.LogException(FeedItemContentViewDialog.TAG, "Activity not found for " + paramAnonymousString4 + " over " + Uri.parse(paramAnonymousString1).getScheme(), paramAnonymousString2);
            }
          }
        }
        CommandManager.CmdOpenExternalBrowser(paramAnonymousString1);
      }
    });
    this._WebView.getSettings().setLoadsImagesAutomatically(mobi.beyondpod.rsscore.Configuration.LoadContentViewImagesAutomatically());
    CookieManager.getInstance().setAcceptCookie(true);
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
  
  public void HideHeader()
  {
    if (this._Header.getVisibility() == 0)
    {
      int i = this._Header.getHeight() - this._HeaderScrollIncrement;
      if (i > 0) {
        this._Header.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
      }
    }
    else
    {
      return;
    }
    this._Header.setVisibility(8);
  }
  
  public void OnDoubleTap() {}
  
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
          FeedItemContentViewDialog.this.RestoreDataSourceState();
        }
      }
    });
  }
  
  public void OnScrollingInDirection(int paramInt)
  {
    int i;
    if (this._HeaderHeight == -2)
    {
      this._HeaderHeight = this._Header.getHeight();
      i = this._HeaderHeight;
      if (getResources().getDisplayMetrics().density != 1.0F) {
        break label50;
      }
    }
    label50:
    for (paramInt = 5;; paramInt = 10)
    {
      this._HeaderScrollIncrement = (i / paramInt);
      return;
    }
  }
  
  public void ShowHeader()
  {
    if (this._ResetHeaderOnNextShow)
    {
      ResetHeader();
      this._ResetHeaderOnNextShow = false;
      return;
    }
    if (this._Header.getHeight() != this._HeaderHeight) {
      this._Header.setLayoutParams(new LinearLayout.LayoutParams(-1, this._HeaderHeight));
    }
    this._Header.setVisibility(0);
  }
  
  protected void UpdateItemHeader()
  {
    int j = 0;
    this._ItemText.setText(this._CurrentRssItem.Title);
    this._ItemText.setTextSize(mobi.beyondpod.rsscore.Configuration.DefaultPrimaryFontSizeInUnits());
    boolean bool2 = this._CurrentRssItem.getRead();
    boolean bool1;
    Object localObject;
    if (FeedContentListViewDataSource.CurrentFeed() != null)
    {
      bool1 = FeedContentListViewDataSource.CurrentFeed().IsGReaderFeed();
      this._ItemOriginatingFeed.setText(this._CurrentRssItem.ResolveOriginatingFeedTitle());
      TextView localTextView = this._ItemPubDate;
      if (this._CurrentRssItem.PubDate() == null) {
        break label196;
      }
      localObject = DateTime.FormatDateTime(this._CurrentRssItem.PubDate());
      label90:
      localTextView.setText((CharSequence)localObject);
      localObject = this._ReadUnreadStatus;
      if (!bool2) {
        break label204;
      }
      i = 2130838008;
      label112:
      ((ImageView)localObject).setImageResource(i);
      localObject = this._ReadUnreadStatus;
      if (!SupportMarkingAsRead()) {
        break label211;
      }
      i = 0;
      label133:
      ((ImageView)localObject).setVisibility(i);
      localObject = this._Star;
      if ((!SupportMarkingAsRead()) || (!bool1)) {
        break label216;
      }
      i = j;
      label158:
      ((ImageView)localObject).setVisibility(i);
      localObject = this._Star;
      if (!this._CurrentRssItem.getStarred()) {
        break label221;
      }
    }
    label196:
    label204:
    label211:
    label216:
    label221:
    for (int i = 2130837696;; i = 2130837694)
    {
      ((ImageView)localObject).setImageResource(i);
      return;
      bool1 = false;
      break;
      localObject = "";
      break label90;
      i = 2130838010;
      break label112;
      i = 4;
      break label133;
      i = 4;
      break label158;
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int i = -1;
    boolean bool2 = true;
    AudioManager localAudioManager = (AudioManager)getSystemService("audio");
    boolean bool1;
    if ((mobi.beyondpod.rsscore.Configuration.VolumeControlsNavigationType() == 1) || ((localAudioManager.isMusicActive()) && (mobi.beyondpod.rsscore.Configuration.VolumeControlsNavigationType() == 0))) {
      bool1 = super.dispatchKeyEvent(paramKeyEvent);
    }
    label100:
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
        int j = i;
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
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void onConfigurationChanged(android.content.res.Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this._ResetHeaderOnNextShow = true;
    if ((this._Header.getVisibility() == 0) && (this._Header.getHeight() == this._HeaderHeight)) {
      ResetHeader();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (ThemeManager.CurrentFeedItemContentViewDialogTheme() != -1) {
      setTheme(ThemeManager.CurrentFeedItemContentViewDialogTheme());
    }
    if (mobi.beyondpod.rsscore.Configuration.OrientationLock() == 2) {
      setRequestedOrientation(0);
    }
    for (;;)
    {
      super.onCreate(paramBundle);
      requestWindowFeature(1);
      setContentView(2130903112);
      WireHeaderFooterViews();
      this._ReadUnreadStatus.setVisibility(8);
      this._LoadProgress.setVisibility(0);
      RssFeedItem localRssFeedItem = FeedContentListViewDataSource.GetItemById(getIntent().getStringExtra("RssItemId"));
      if ((paramBundle == null) && (localRssFeedItem != null))
      {
        WireWebView();
        LoadItemData(localRssFeedItem);
      }
      return;
      if (mobi.beyondpod.rsscore.Configuration.OrientationLock() == 1) {
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
    paramMenu.add(0, 8, 1, 2131296667).setIcon(2130837982).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
    {
      public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        if (FeedItemContentViewDialog.this._CurrentRssItem != null) {
          FeedItemContentViewDialog.this.copyToClipboard(FeedItemContentViewDialog.this._CurrentRssItem.Link);
        }
        return true;
      }
    });
    paramMenu.add(0, 9, 2, 2131296670).setIcon(2130837983).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
    {
      public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        if (FeedItemContentViewDialog.this._CurrentRssItem != null) {
          CommandManager.CmdSendEMail(FeedItemContentViewDialog.this, mobi.beyondpod.rsscore.Configuration.getDefaultSendToMailAddress(), FeedItemContentViewDialog.this._CurrentRssItem.Title.toString(), FeedItemContentViewDialog.this._CurrentRssItem.Link, null, false);
        }
        return true;
      }
    });
    paramMenu.add(0, 10, 4, 2131296669).setIcon(2130837953).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
    {
      public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        if (FeedItemContentViewDialog.this._WebView != null) {
          if (!mobi.beyondpod.rsscore.Configuration.LoadContentViewImagesAutomatically()) {
            break label50;
          }
        }
        label50:
        for (boolean bool = false;; bool = true)
        {
          mobi.beyondpod.rsscore.Configuration.setLoadContentViewImagesAutomatically(bool);
          FeedItemContentViewDialog.this._WebView.getSettings().setLoadsImagesAutomatically(mobi.beyondpod.rsscore.Configuration.LoadContentViewImagesAutomatically());
          FeedItemContentViewDialog.this._WebView.reload();
          return true;
        }
      }
    });
    paramMenu.add(0, 12, 5, 2131296678).setIcon(2130837986).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
    {
      public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        if (FeedItemContentViewDialog.this._WebView != null) {
          if (!mobi.beyondpod.rsscore.Configuration.FeedContentDialogLayoutType().equals(WebSettings.LayoutAlgorithm.NORMAL)) {
            break label48;
          }
        }
        label48:
        for (paramAnonymousMenuItem = WebSettings.LayoutAlgorithm.SINGLE_COLUMN;; paramAnonymousMenuItem = WebSettings.LayoutAlgorithm.NORMAL)
        {
          mobi.beyondpod.rsscore.Configuration.setFeedContentDialogLayoutType(paramAnonymousMenuItem);
          FeedItemContentViewDialog.this._WebView.getSettings().setLayoutAlgorithm(mobi.beyondpod.rsscore.Configuration.FeedContentDialogLayoutType());
          return true;
        }
      }
    });
    return true;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this._WebView != null) {
      this._WebView.destroy();
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    MenuItem localMenuItem = paramMenu.findItem(10);
    if (mobi.beyondpod.rsscore.Configuration.LoadContentViewImagesAutomatically())
    {
      i = 2131296668;
      localMenuItem.setTitle(i);
      localMenuItem = paramMenu.findItem(12);
      if (!mobi.beyondpod.rsscore.Configuration.FeedContentDialogLayoutType().equals(WebSettings.LayoutAlgorithm.NORMAL)) {
        break label73;
      }
    }
    label73:
    for (int i = 2131296677;; i = 2131296678)
    {
      localMenuItem.setTitle(i);
      return super.onPrepareOptionsMenu(paramMenu);
      i = 2131296669;
      break;
    }
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
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this._WebView != null) {
      this._WebView.saveState(paramBundle);
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
      FeedItemContentViewDialog.this.copyToClipboard(this.mText);
      return true;
    }
  }
  
  class WebChrome
    extends WebChromeClient
  {
    WebChrome() {}
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      int j = 0;
      paramWebView = FeedItemContentViewDialog.this._ReadUnreadStatus;
      int i;
      if (paramInt < 100)
      {
        i = 8;
        paramWebView.setVisibility(i);
        paramWebView = FeedItemContentViewDialog.this._LoadProgress;
        if (paramInt >= 100) {
          break label68;
        }
      }
      label68:
      for (paramInt = j;; paramInt = 8)
      {
        paramWebView.setVisibility(paramInt);
        return;
        if (!FeedItemContentViewDialog.this.SupportMarkingAsRead())
        {
          i = 4;
          break;
        }
        i = 0;
        break;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/FeedItemContentViewDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */