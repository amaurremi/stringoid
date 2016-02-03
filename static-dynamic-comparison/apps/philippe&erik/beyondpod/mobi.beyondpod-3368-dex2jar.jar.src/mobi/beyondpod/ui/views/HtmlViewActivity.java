package mobi.beyondpod.ui.views;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Browser;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
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
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import mobi.beyondpod.downloadengine.DownloadEngineNotificationManager;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.AnalyticsTracker;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.core.ActionBarActivityBase;
import mobi.beyondpod.ui.core.ActionBarHelper;
import mobi.beyondpod.ui.core.WebViewPluginHelper;
import mobi.beyondpod.ui.views.base.IWebViewOwner;
import mobi.beyondpod.ui.views.base.WebViewEx;

public class HtmlViewActivity
  extends ActionBarActivityBase
  implements DownloadListener, IWebViewOwner
{
  private static final int FOCUS_NODE_HREF = 102;
  private static final int HEADER_FLAG = Integer.MIN_VALUE;
  private static final int MENU_BACK_TO_FEED = 7;
  private static final int MENU_BROWSER_REFRESH = 6;
  private static final int MENU_BROWSER_STOP_LOAD = 5;
  private static final int MENU_CHANGE_LAYOUT = 12;
  private static final int MENU_COPY_LINK = 8;
  private static final int MENU_EMAIL_LOG = 13;
  private static final int MENU_LOAD_IMAGES = 11;
  private static final int MENU_OPEN_IN_BROWSER = 10;
  private static final int MENU_SHARE_LINK = 9;
  private static final String TAG = HtmlViewActivity.class.getSimpleName();
  private static volatile int _InstanceCount;
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
      case -2147483648: 
        HtmlViewActivity.this._TitleView.setText(str);
        return;
      case 8: 
        ((ClipboardManager)HtmlViewActivity.this.getSystemService("clipboard")).setText(str);
        return;
      case 9: 
        Browser.sendString(HtmlViewActivity.this, str);
        return;
      }
      CommandManager.CmdOpenExternalBrowser(str);
    }
  };
  boolean _HasBottomToolbar = false;
  boolean _IsFeedContentLink = false;
  private TextView _TitleView = null;
  protected WebViewEx _WebView;
  private SeekBar _loadProgress;
  
  @SuppressLint({"NewApi"})
  public HtmlViewActivity()
  {
    _InstanceCount += 1;
    CoreHelper.WriteTraceEntry(TAG, "######### HtmlView Activity created! Instances: " + _InstanceCount + " #########");
  }
  
  public void OnDoubleTap()
  {
    finish();
  }
  
  public void OnScrollingInDirection(int paramInt) {}
  
  protected void finalize()
    throws Throwable
  {
    _InstanceCount -= 1;
    CoreHelper.WriteTraceEntry(TAG, "######### HtmlView Activity finalized! Instances: " + _InstanceCount + " #########");
    super.finalize();
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    paramMenuItem = this._Handler.obtainMessage(102, i, 0);
    paramMenuItem.obj = this;
    this._WebView.requestFocusNodeHref(paramMenuItem);
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    System.gc();
    super.onCreate(paramBundle);
    Intent localIntent = getIntent();
    this._IsFeedContentLink = localIntent.getBooleanExtra("IsFeedContentLink", false);
    setContentView(2130903128);
    this._WebView = ((WebViewEx)findViewById(2131230981));
    Object localObject = this._WebView;
    boolean bool2 = Configuration.AllowMarginNavigationInFeedItemContentDialog();
    boolean bool1;
    if (this._IsFeedContentLink)
    {
      bool1 = false;
      ((WebViewEx)localObject).Initialize(this, bool2, bool1);
      this._loadProgress = ((SeekBar)findViewById(2131230992));
      localObject = findViewById(2131231078);
      Button localButton = (Button)findViewById(2131231079);
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          HtmlViewActivity.this.finish();
        }
      });
      this._WebView.setWebChromeClient(new WebChrome());
      this._WebView.setWebViewClient(new WebViewClient()
      {
        public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          if (HtmlViewActivity.this._IsFeedContentLink) {
            HtmlViewActivity.this._WebView.getSettings().setLayoutAlgorithm(Configuration.HtmlViewLayoutType());
          }
          super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
          if (HtmlViewActivity.this._WebView.getBlockNetworkLoads()) {
            Toast.makeText(HtmlViewActivity.this._WebView.getContext(), 2131297206, 1).show();
          }
        }
        
        public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
        {
          HtmlViewActivity.this._WebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
          CookieSyncManager.getInstance().resetSync();
        }
        
        public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          Object localObject = paramAnonymousWebView.copyBackForwardList();
          if ((localObject != null) && (((WebBackForwardList)localObject).getCurrentItem() != null) && (StringUtils.EqualsIgnoreCase(paramAnonymousString, ((WebBackForwardList)localObject).getCurrentItem().getUrl()))) {
            return false;
          }
          try
          {
            Uri localUri = Uri.parse(paramAnonymousString);
            if (!paramAnonymousString.contains("youtube.com/?v="))
            {
              localObject = paramAnonymousString;
              if (!paramAnonymousString.contains("youtube.com?v=")) {}
            }
            else
            {
              localObject = paramAnonymousString.replace("youtube.com", "youtube.com/watch").replace("/?v=", "?v=");
              localUri = Uri.parse((String)localObject);
            }
            if (WebViewEx.StartExternalActivityForURLIfNeeded(HtmlViewActivity.this, localUri)) {
              return true;
            }
          }
          catch (IllegalArgumentException paramAnonymousWebView)
          {
            return false;
          }
          paramAnonymousWebView.loadUrl((String)localObject);
          return true;
        }
      });
      this._WebView.setDownloadListener(this);
      if (paramBundle == null) {
        break label300;
      }
      this._WebView.restoreState(paramBundle);
      label168:
      if (!this._IsFeedContentLink) {
        break label349;
      }
      this._WebView.getSettings().setLoadsImagesAutomatically(Configuration.LoadContentViewImagesAutomatically());
      label188:
      this._HasBottomToolbar = localIntent.getBooleanExtra("HasBottomToolbar", false);
      paramBundle = this._WebView.getSettings();
      if (!this._HasBottomToolbar) {
        break label355;
      }
      ((View)localObject).setVisibility(0);
      localButton.setText(2131296759);
      paramBundle.setBuiltInZoomControls(false);
      this._WebView.setScrollBarStyle(0);
    }
    for (;;)
    {
      registerForContextMenu(this._WebView);
      paramBundle.setUseWideViewPort(this._IsFeedContentLink);
      if (CoreHelper.ApiLevel() > 10) {
        paramBundle.setDisplayZoomControls(false);
      }
      paramBundle.setJavaScriptEnabled(true);
      WebViewPluginHelper.EnableBrowserPluginsIfNeeded(paramBundle);
      AnalyticsTracker.OnViewDisplayed("Html View");
      getActionBarHelper().setDisplayOptions(4, 4);
      return;
      bool1 = true;
      break;
      label300:
      if (localIntent.getData() != null) {
        this._WebView.loadUrl(localIntent.getData().toString());
      }
      if (localIntent.getCharSequenceExtra("Title") == null) {
        break label168;
      }
      setTitle(localIntent.getCharSequenceExtra("Title"));
      break label168;
      label349:
      DownloadEngineNotificationManager.ClearNotification();
      break label188;
      label355:
      paramBundle.setBuiltInZoomControls(true);
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramView = this._WebView.getHitTestResult();
    if (paramView == null) {}
    for (;;)
    {
      return;
      int i = paramView.getType();
      if ((i != 0) && (i != 9))
      {
        switch (i)
        {
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        default: 
          return;
        }
        try
        {
          this._TitleView = ((TextView)LayoutInflater.from(this).inflate(17367054, null));
          paramContextMenu.setHeaderView(this._TitleView);
          this._TitleView.setText("");
          paramContextMenuInfo = this._Handler.obtainMessage(102, Integer.MIN_VALUE, 0);
          paramContextMenuInfo.obj = this;
          this._WebView.requestFocusNodeHref(paramContextMenuInfo);
          paramContextMenu.add(0, 8, 0, 2131296667);
          paramContextMenuInfo = getPackageManager();
          Intent localIntent = new Intent("android.intent.action.SEND");
          localIntent.setType("text/plain");
          if (paramContextMenuInfo.queryIntentActivities(localIntent, 65536).size() > 0) {
            paramContextMenu.add(1, 9, 0, 2131296670);
          }
          if (!Configuration.UseExternalBrowser())
          {
            paramContextMenu.add(2, 10, 0, 2131296673);
            return;
          }
        }
        catch (Exception paramContextMenu)
        {
          CoreHelper.LogException(TAG, "Failed to open HtmlView Context menu! Link:" + paramView.getExtra(), paramContextMenu);
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this._WebView.getSettings().setBuiltInZoomControls(true);
    this._WebView.destroy();
  }
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    if ((paramString3 == null) || (!paramString3.regionMatches(true, 0, "attachment", 0, 10)))
    {
      paramString2 = new Intent("android.intent.action.VIEW");
      paramString2.setDataAndType(Uri.parse(paramString1), paramString4);
      if (getPackageManager().queryIntentActivities(paramString2, 65536).size() != 0) {
        try
        {
          startActivity(paramString2);
          return;
        }
        catch (ActivityNotFoundException paramString2) {}
      }
    }
    CommandManager.CmdOpenExternalBrowser(paramString1);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this._WebView.stopLoading();
      if (!this._WebView.canGoBack()) {
        return super.onKeyDown(paramInt, paramKeyEvent);
      }
      this._WebView.goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool = false;
    switch (paramMenuItem.getItemId())
    {
    default: 
    case 16908332: 
    case 5: 
    case 6: 
      for (;;)
      {
        return false;
        finish();
        return true;
        this._WebView.stopLoading();
        continue;
        this._WebView.reload();
      }
    case 7: 
      finish();
      return true;
    case 8: 
      ((ClipboardManager)getApplication().getSystemService("clipboard")).setText(this._WebView.getUrl());
      return true;
    case 9: 
      Browser.sendString(this, this._WebView.getUrl());
      return true;
    case 10: 
      CommandManager.CmdOpenExternalBrowser(this._WebView.getUrl());
      return true;
    case 11: 
      if (Configuration.LoadContentViewImagesAutomatically()) {}
      for (;;)
      {
        Configuration.setLoadContentViewImagesAutomatically(bool);
        this._WebView.getSettings().setLoadsImagesAutomatically(Configuration.LoadContentViewImagesAutomatically());
        this._WebView.reload();
        return true;
        bool = true;
      }
    case 12: 
      if (Configuration.HtmlViewLayoutType().equals(WebSettings.LayoutAlgorithm.NORMAL)) {}
      for (paramMenuItem = WebSettings.LayoutAlgorithm.NARROW_COLUMNS;; paramMenuItem = WebSettings.LayoutAlgorithm.NORMAL)
      {
        Configuration.setHtmlViewLayoutType(paramMenuItem);
        this._WebView.getSettings().setLayoutAlgorithm(Configuration.HtmlViewLayoutType());
        return true;
      }
    }
    CommandManager.CmdSendEMail(this, "support@beyondpod.mobi", "BeyondPod feed Update and Download Log", "Attached is " + Configuration.FeedUpdateLogFilePath(), Configuration.FeedUpdateLogFilePath(), true);
    return true;
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    paramMenu.clear();
    if (this._IsFeedContentLink) {
      paramMenu.add(0, 7, 0, 2131296665).setIcon(2130837954);
    }
    label91:
    Object localObject;
    if (this._WebView.getProgress() != 100)
    {
      paramMenu.add(0, 5, 1, 2131296679).setIcon(2130837984);
      if (this._IsFeedContentLink)
      {
        if (!Configuration.HtmlViewLayoutType().equals(WebSettings.LayoutAlgorithm.NORMAL)) {
          break label285;
        }
        i = 2131296677;
        paramMenu.add(0, 12, 2, i).setIcon(2130837986);
        paramMenu.add(0, 9, 3, 2131296670).setIcon(2130837983);
        localObject = paramMenu.add(0, 11, 4, "");
        if (!Configuration.LoadContentViewImagesAutomatically()) {
          break label292;
        }
      }
    }
    label285:
    label292:
    for (int i = 2131296668;; i = 2131296669)
    {
      ((MenuItem)localObject).setTitle(i).setIcon(2130837953);
      paramMenu.add(0, 10, 5, 2131296673);
      paramMenu.add(0, 8, 6, 2131296667).setIcon(2130837982);
      localObject = getIntent().getData();
      if ((localObject != null) && (((Uri)localObject).toString().endsWith("FeedUpdateLog.htm"))) {
        paramMenu.add(0, 13, 7, 2131297004).setIcon(2130837981);
      }
      return true;
      paramMenu.add(0, 6, 1, 2131296666).setIcon(2130837974);
      break;
      i = 2131296678;
      break label91;
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    CookieSyncManager.getInstance().startSync();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    this._WebView.saveState(paramBundle);
  }
  
  protected void onStop()
  {
    super.onStop();
    CookieSyncManager.getInstance().stopSync();
    this._WebView.stopLoading();
  }
  
  class WebChrome
    extends WebChromeClient
  {
    WebChrome() {}
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      paramWebView = HtmlViewActivity.this._loadProgress;
      if (paramInt < 100) {}
      for (int i = 0;; i = 8)
      {
        paramWebView.setVisibility(i);
        HtmlViewActivity.this._loadProgress.setProgress(paramInt);
        if (paramInt == 100) {
          CookieSyncManager.getInstance().sync();
        }
        return;
      }
    }
    
    public void onReceivedTitle(WebView paramWebView, String paramString)
    {
      HtmlViewActivity.this.setTitle(paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/HtmlViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */