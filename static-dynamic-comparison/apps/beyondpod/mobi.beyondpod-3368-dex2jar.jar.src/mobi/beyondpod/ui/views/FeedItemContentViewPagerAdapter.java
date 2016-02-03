package mobi.beyondpod.ui.views;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebHistoryItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.ArrayList;
import mobi.beyondpod.htmlbuilder.FeedHtmlContentProvider;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.AnalyticsTracker;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.core.WebViewPluginHelper;
import mobi.beyondpod.ui.views.base.WebViewEx;

public class FeedItemContentViewPagerAdapter
  extends PagerAdapter
{
  private static final String TAG = FeedItemContentViewPagerAdapter.class.getSimpleName();
  private static final String TITLE_TAG = "@@@@@";
  private FeedItemContentViewPager _Owner;
  ArrayList<WebView> _RecycledWebViews = new ArrayList();
  Bundle _SavedInstanceState = null;
  
  public FeedItemContentViewPagerAdapter(FeedItemContentViewPager paramFeedItemContentViewPager, Bundle paramBundle)
  {
    this._Owner = paramFeedItemContentViewPager;
    this._SavedInstanceState = paramBundle;
  }
  
  private WebViewEx CreateWebView()
  {
    WebViewEx localWebViewEx = new WebViewEx(this._Owner);
    localWebViewEx.Initialize(this._Owner, Configuration.AllowMarginNavigationInFeedItemContentDialog(), false);
    this._Owner.registerForContextMenu(localWebViewEx);
    localWebViewEx.setWebChromeClient(new WebChrome());
    Object localObject = localWebViewEx.getSettings();
    ((WebSettings)localObject).setBuiltInZoomControls(false);
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    localWebViewEx.setScrollBarStyle(33554432);
    localWebViewEx.setHorizontalScrollbarOverlay(true);
    localWebViewEx.setVerticalScrollbarOverlay(true);
    WebViewPluginHelper.EnableBrowserPluginsIfNeeded((WebSettings)localObject);
    localWebViewEx.setScrollBarStyle(0);
    localObject = Configuration.ContentThemeBackgroundColor();
    if (localObject != null) {
      localWebViewEx.setBackgroundColor(((Integer)localObject).intValue());
    }
    localWebViewEx.setWebViewClient(new WebViewClient()
    {
      public void doUpdateVisitedHistory(WebView paramAnonymousWebView, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        if ((paramAnonymousString != null) && (paramAnonymousString.startsWith(Configuration.BeyondPodContentUrl()))) {
          paramAnonymousWebView.clearHistory();
        }
      }
      
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
      }
      
      public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        CookieSyncManager.getInstance().resetSync();
      }
      
      public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        CoreHelper.WriteTraceEntry(FeedItemContentViewPagerAdapter.TAG, "------ Page Error: " + paramAnonymousString1 + " at " + paramAnonymousString2);
        super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (StringUtils.IsNullOrEmpty(paramAnonymousString)) {
          return true;
        }
        int i = 0;
        int j = paramAnonymousString.indexOf("@@@@@");
        if (j >= 0)
        {
          paramAnonymousString = paramAnonymousString.substring("@@@@@".length() + j);
          i = 1;
        }
        while (Configuration.UseExternalBrowser())
        {
          CommandManager.CmdOpenExternalBrowser(paramAnonymousString);
          return true;
        }
        if (i != 0)
        {
          FeedItemContentViewPager.StartHtmlViewActivity(FeedItemContentViewPagerAdapter.this._Owner, Uri.parse(paramAnonymousString), "Loading...", true);
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
            if (WebViewEx.StartExternalActivityForURLIfNeeded(FeedItemContentViewPagerAdapter.this._Owner, localUri1)) {
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
            if (!StringUtils.IsNullOrEmpty(Configuration.getMobileFormatter()))
            {
              Uri localUri2 = Uri.parse(Configuration.getMobileFormatter());
              paramAnonymousString = paramAnonymousWebView;
              if (!localUri2.getHost().equals(localUri1.getHost())) {
                paramAnonymousString = localUri2 + paramAnonymousWebView;
              }
            }
          }
          catch (Exception paramAnonymousString)
          {
            paramAnonymousString = paramAnonymousWebView;
          }
        }
        return FeedItemContentViewPager.StartHtmlViewActivity(FeedItemContentViewPagerAdapter.this._Owner, Uri.parse(paramAnonymousString), "Loading...", true);
      }
    });
    localWebViewEx.setDownloadListener(new DownloadListener()
    {
      public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
      {
        if ((paramAnonymousString3 == null) || (!paramAnonymousString3.regionMatches(true, 0, "attachment", 0, 10)))
        {
          paramAnonymousString2 = new Intent("android.intent.action.VIEW");
          paramAnonymousString2.setDataAndType(Uri.parse(paramAnonymousString1), paramAnonymousString4);
          if (FeedItemContentViewPagerAdapter.this._Owner.getPackageManager().resolveActivity(paramAnonymousString2, 65536) != null) {
            try
            {
              FeedItemContentViewPagerAdapter.this._Owner.startActivity(paramAnonymousString2);
              return;
            }
            catch (ActivityNotFoundException paramAnonymousString2)
            {
              CoreHelper.LogException(FeedItemContentViewPagerAdapter.TAG, "Activity not found for " + paramAnonymousString4 + " over " + Uri.parse(paramAnonymousString1).getScheme(), paramAnonymousString2);
            }
          }
        }
        CommandManager.CmdOpenExternalBrowser(paramAnonymousString1);
      }
    });
    localWebViewEx.getSettings().setLoadsImagesAutomatically(Configuration.LoadContentViewImagesAutomatically());
    CookieManager.getInstance().setAcceptCookie(true);
    return localWebViewEx;
  }
  
  private void LoadItemContent(WebView paramWebView, RssFeedItem paramRssFeedItem)
  {
    CoreHelper.WriteTraceEntry(TAG, "Loading: " + paramRssFeedItem.Title);
    if (0 == 0)
    {
      paramWebView.loadDataWithBaseURL(paramRssFeedItem.Link, FeedHtmlContentProvider.ConstructItemDocumentWithTemplate(paramRssFeedItem.ItemID(), false, 2131099652), "text/html", "utf-8", null);
      return;
    }
    paramWebView.loadUrl(Configuration.BeyondPodContentUrl() + "/rssItemId/" + Uri.encode(new StringBuilder(String.valueOf(paramRssFeedItem.ItemID())).append(".html").toString()));
  }
  
  private void LoadItemData(WebView paramWebView, RssFeedItem paramRssFeedItem)
  {
    AnalyticsTracker.OnViewDisplayed("Item Content View");
    if (paramRssFeedItem != null)
    {
      paramWebView.setTag(paramRssFeedItem);
      if (paramWebView != null)
      {
        if ((this._SavedInstanceState == null) || (!this._SavedInstanceState.getString("CurrentRSSItemID").equals(paramRssFeedItem.ItemID()))) {
          break label59;
        }
        paramWebView.restoreState(this._SavedInstanceState);
        this._SavedInstanceState = null;
      }
    }
    return;
    label59:
    LoadItemContent(paramWebView, paramRssFeedItem);
  }
  
  @SuppressLint({"NewApi"})
  private WebView getWebView()
  {
    if (this._RecycledWebViews.size() > 0)
    {
      WebView localWebView = (WebView)this._RecycledWebViews.get(0);
      this._RecycledWebViews.remove(0);
      localWebView.onResume();
      return localWebView;
    }
    return CreateWebView();
  }
  
  @SuppressLint({"NewApi"})
  private void putWebView(WebView paramWebView)
  {
    paramWebView.onPause();
    paramWebView.clearView();
    paramWebView.setTag(null);
    this._RecycledWebViews.add(paramWebView);
  }
  
  public void ReloadContent(WebView paramWebView)
  {
    Object localObject = paramWebView.getTag();
    if (localObject != null) {
      LoadItemContent(paramWebView, (RssFeedItem)localObject);
    }
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    ((ViewPager)paramView).removeView((View)paramObject);
    putWebView((WebView)paramObject);
  }
  
  public void finishUpdate(View paramView) {}
  
  public int getCount()
  {
    return FeedContentListViewDataSource.Items().size();
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    WebView localWebView = getWebView();
    LoadItemData(localWebView, (RssFeedItem)FeedContentListViewDataSource.Items().get(paramInt));
    ((ViewPager)paramView).addView(localWebView, 0);
    return localWebView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == (WebView)paramObject;
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader) {}
  
  public Parcelable saveState()
  {
    return null;
  }
  
  public void startUpdate(View paramView) {}
  
  class WebChrome
    extends WebChromeClient
  {
    WebChrome() {}
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      FeedItemContentViewPagerAdapter.this._Owner.OnWebPageProgress(paramWebView, paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/FeedItemContentViewPagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */