package com.google.ads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ViewSwitcher;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;

public class GoogleAdView
  extends ViewSwitcher
{
  private static final String AD_FOOTER1 = ";\n</script>\n<script type='text/javascript' src='";
  private static final String AD_FOOTER2 = "'></script>\n</body>\n</html>";
  private static final String AD_HEADER = "<html>\n<body marginwidth='0' marginheight='0'>\n<script type='text/javascript'>\nwindow.google_afma_request = ";
  private static final String DEBUG_WATERMARK_FILE = "test_ad.png";
  private static final String DEFAULT_ENCODING = "utf8";
  private static final int DEFAULT_HEIGHT = 50;
  private static final String DEFAULT_MIME_TYPE = "text/html";
  private static final int DEFAULT_WIDTH = 320;
  private static final String DOUBLECLICK_AD_FETCH_FAILURE = "http://__NO_MATCHING_AD__";
  private static final boolean ENABLE_LOCAL_URL_CAPTURE = true;
  private static final boolean ENABLE_REDIRECT_OPTIMIZATION = false;
  private static final String[] LOCAL_URLS = { "about:blank" };
  private static final String LOGTAG = "GoogleAdView";
  public static final int MINIMUM_AUTO_REFRESH_SECONDS = 180;
  private static final String PARAM_AUTO_REFRESH = "ar";
  private static final String PARAM_CLICK_LATENCY = "pcl";
  private static final String PARAM_CLICK_STRING = "ai";
  private static final String PARAM_LATENCY = "prl";
  private static final String PARAM_LOCATION = "uule";
  private static final String PARAM_PRIOR_CLICK_STRING = "pai";
  private static final String PARAM_SPACING_BOTTOM = "bsp";
  private static final String PARAM_SPACING_LEFT = "lsp";
  private static final String PARAM_SPACING_RIGHT = "rsp";
  private static final String PARAM_SPACING_TOP = "tsp";
  private static final String PARENT_STATE = "google_ad_view_parent_state";
  private static final int PROGRESS_BAR_INDEX = 0;
  private static final String[] REDIRECT_DOMAINS = { "googleads.g.doubleclick.net", "googleadservices.com" };
  private static final int WEBVIEW_INDEX = 1;
  static final int WINDOW_EXPAND_DELAY = 150;
  static final int WINDOW_RETRACT_DELAY = 400;
  private int mAdHeight;
  private FrameLayout mAdViewHolder;
  private AdViewListener mAdViewListener;
  private AdWebViewClient mAdWebViewClient;
  private int mAdWidth;
  private int mAutoRefreshSecs;
  private AdViewCommunicator mCommunicator;
  private Drawable mDebugDrawable;
  private boolean mDebugMode;
  private boolean mExpanded;
  private InstalledApplications mInstalledApplications;
  private AdSpec mLastAdSpec;
  private LatencyTracker mLatencyTracker;
  private LocationTracker mLocationTracker;
  private GoogleAdOverlay mOverlay;
  private WebViewPlaceHolder mPlaceHolder;
  private LinearLayout mProgressBarLayout;
  private Runnable mRefreshRunnable;
  private boolean mShowAdsDeferred;
  private WebView mWebView;
  
  public GoogleAdView(Context paramContext)
  {
    super(paramContext);
    init(paramContext, new WebView(paramContext), 320, 50);
  }
  
  public GoogleAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, new WebView(paramContext), 320, 50);
  }
  
  GoogleAdView(Context paramContext, WebView paramWebView)
  {
    super(paramContext);
    init(paramContext, paramWebView, 320, 50);
  }
  
  private Drawable getDebugDrawable()
  {
    if (this.mDebugDrawable == null) {}
    for (;;)
    {
      try
      {
        localBitmap = BitmapFactory.decodeStream(getContext().getAssets().open("test_ad.png"));
      }
      catch (IOException localIOException)
      {
        Bitmap localBitmap;
        Log.e("GoogleAdView", "Error loading debug watermark", localIOException);
        continue;
      }
      try
      {
        Bitmap.class.getMethod("setDensity", new Class[] { Integer.TYPE }).invoke(localBitmap, new Object[] { Integer.valueOf(160) });
        this.mDebugDrawable = ((Drawable)BitmapDrawable.class.getConstructor(new Class[] { Resources.class, Bitmap.class }).newInstance(new Object[] { getContext().getResources(), localBitmap }));
        return this.mDebugDrawable;
      }
      catch (Exception localException)
      {
        this.mDebugDrawable = new BitmapDrawable(localBitmap);
      }
    }
  }
  
  private void init(Context paramContext, WebView paramWebView, int paramInt1, int paramInt2)
  {
    this.mInstalledApplications = new InstalledApplications(paramContext.getPackageManager());
    ProgressBar localProgressBar = new ProgressBar(paramContext, null, 16842873);
    localProgressBar.setIndeterminate(true);
    this.mProgressBarLayout = new LinearLayout(paramContext);
    this.mProgressBarLayout.setGravity(17);
    this.mProgressBarLayout.addView(localProgressBar);
    addView(this.mProgressBarLayout, AdUtil.scaleDipsToPixels(paramContext, paramInt1), AdUtil.scaleDipsToPixels(paramContext, paramInt2));
    this.mCommunicator = new AdViewCommunicator(this);
    registerAdResponses();
    this.mWebView = paramWebView;
    this.mAdWebViewClient = new AdWebViewClient();
    this.mWebView.setBackgroundColor(0);
    this.mWebView.setWebViewClient(this.mAdWebViewClient);
    this.mWebView.setInitialScale(AdUtil.scaleDipsToPixels(paramContext, 100));
    this.mAdViewHolder = new FrameLayout(paramContext);
    this.mAdViewHolder.setBackgroundColor(0);
    this.mAdViewHolder.setBackgroundDrawable(null);
    this.mAdViewHolder.addView(this.mWebView);
    addView(this.mAdViewHolder, AdUtil.scaleDipsToPixels(paramContext, paramInt1), AdUtil.scaleDipsToPixels(paramContext, paramInt2));
    this.mOverlay = new GoogleAdOverlay(paramContext, this, paramWebView);
    this.mPlaceHolder = new WebViewPlaceHolder(paramContext);
    this.mWebView.setVerticalScrollBarEnabled(false);
    this.mWebView.setHorizontalScrollBarEnabled(false);
    paramWebView = this.mWebView.getLayoutParams();
    paramWebView.width = -1;
    paramWebView.height = -1;
    paramWebView = this.mWebView.getSettings();
    paramWebView.setJavaScriptEnabled(true);
    paramWebView.setPluginsEnabled(true);
    paramWebView.setSupportZoom(false);
    paramWebView.setCacheMode(0);
    this.mLatencyTracker = new LatencyTracker(paramContext);
    this.mLocationTracker = new LocationTracker(paramContext);
    this.mExpanded = false;
    setOutAnimation(paramContext, 17432577);
    setInAnimation(paramContext, 17432576);
    this.mDebugMode = false;
    this.mAutoRefreshSecs = -1;
    this.mRefreshRunnable = new RefreshRunnable(null);
  }
  
  private void registerAdResponses()
  {
    this.mCommunicator.registerAdResponse("/loadAdURL", new LoadAdResponse());
    this.mCommunicator.registerAdResponse("/resize", new ResizeResponse());
    this.mCommunicator.registerAdResponse("/requestApplications", new InstalledAppsResponse(this.mInstalledApplications, this.mCommunicator));
  }
  
  private void saveWebViewPicture()
  {
    Picture localPicture = this.mWebView.capturePicture();
    this.mPlaceHolder.setSize(this.mWebView.getWidth(), this.mWebView.getHeight());
    this.mPlaceHolder.setPicture(localPicture);
  }
  
  private void scheduleAutoRefresh()
  {
    removeCallbacks(this.mRefreshRunnable);
    if ((this.mLastAdSpec != null) && (this.mAutoRefreshSecs > 0) && (hasWindowFocus())) {
      postDelayed(this.mRefreshRunnable, this.mAutoRefreshSecs * 1000);
    }
  }
  
  private void showAds(AdSpec paramAdSpec, boolean paramBoolean)
  {
    showAds(paramAdSpec, paramBoolean, hasWindowFocus());
  }
  
  void closeAdImmediately()
  {
    if (!this.mExpanded) {
      return;
    }
    this.mAdViewHolder.removeAllViews();
    this.mOverlay.removeAllViewsAndDismiss();
    this.mAdViewHolder.addView(this.mWebView);
    resize(this.mAdWidth, this.mAdHeight);
    this.mExpanded = false;
  }
  
  void expandAd(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mExpanded) {
      return;
    }
    this.mExpanded = true;
    Context localContext = getContext();
    int i = this.mAdWidth;
    int j = this.mAdHeight;
    saveWebViewPicture();
    int[] arrayOfInt = new int[2];
    this.mWebView.getLocationOnScreen(arrayOfInt);
    int k = AdUtil.scalePixelsToDips(localContext, arrayOfInt[0]);
    int m = AdUtil.scalePixelsToDips(localContext, arrayOfInt[1]);
    this.mOverlay.resize(i + (paramInt3 + paramInt4), j + (paramInt1 + paramInt2));
    this.mAdViewHolder.removeAllViews();
    this.mAdViewHolder.addView(this.mPlaceHolder);
    this.mWebView.setVisibility(4);
    this.mOverlay.addAndShowWebView(AdUtil.scaleDipsToPixels(localContext, k - paramInt3), AdUtil.scaleDipsToPixels(localContext, m - paramInt1));
    postDelayed(new WebViewExpandRunnable(null), 150L);
  }
  
  String generateHtml(AdSpec paramAdSpec, boolean paramBoolean)
  {
    List localList = paramAdSpec.generateParameters(getContext());
    Object localObject = getContext();
    int[] arrayOfInt = new int[2];
    this.mWebView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    getWindowVisibleDisplayFrame(localRect);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = localRect.height();
    int m = this.mWebView.getHeight();
    int n = localRect.width();
    int i1 = this.mWebView.getWidth();
    localList.add(new AdSpec.Parameter("tsp", Integer.toString(AdUtil.scalePixelsToDips((Context)localObject, j))));
    localList.add(new AdSpec.Parameter("lsp", Integer.toString(AdUtil.scalePixelsToDips((Context)localObject, i))));
    localList.add(new AdSpec.Parameter("bsp", Integer.toString(AdUtil.scalePixelsToDips((Context)localObject, k - m - j))));
    localList.add(new AdSpec.Parameter("rsp", Integer.toString(AdUtil.scalePixelsToDips((Context)localObject, n - i1 - i))));
    if (paramBoolean) {
      localList.add(new AdSpec.Parameter("ar", Integer.toString(this.mAutoRefreshSecs)));
    }
    localList.addAll(this.mInstalledApplications.getInstallationState());
    if (this.mLatencyTracker.hasAdFetchLatency()) {
      localList.add(new AdSpec.Parameter("prl", Integer.toString(this.mLatencyTracker.getAdFetchLatency())));
    }
    if (this.mLatencyTracker.hasAdClickLatency()) {
      localList.add(new AdSpec.Parameter("pcl", Integer.toString(this.mLatencyTracker.getAdClickLatency())));
    }
    if (this.mLatencyTracker.hasClickString()) {
      localList.add(new AdSpec.Parameter("pai", this.mLatencyTracker.getClickString()));
    }
    this.mLatencyTracker.clear();
    localObject = this.mLocationTracker.getLocationParam();
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      localList.add(new AdSpec.Parameter("uule", (String)localObject));
    }
    paramAdSpec = ";\n</script>\n<script type='text/javascript' src='" + paramAdSpec.getAdUrl() + "'></script>\n</body>\n</html>";
    return "<html>\n<body marginwidth='0' marginheight='0'>\n<script type='text/javascript'>\nwindow.google_afma_request = " + AdUtil.generateJSONParameters(localList) + paramAdSpec;
  }
  
  int getAdHeight()
  {
    return this.mAdHeight;
  }
  
  public AdViewListener getAdViewListener()
  {
    return this.mAdViewListener;
  }
  
  int getAdWidth()
  {
    return this.mAdWidth;
  }
  
  public int getAutoRefreshSeconds()
  {
    return this.mAutoRefreshSecs;
  }
  
  AdViewCommunicator getCommunicator()
  {
    return this.mCommunicator;
  }
  
  WebView getWebView()
  {
    return this.mWebView;
  }
  
  boolean isExpanded()
  {
    return this.mExpanded;
  }
  
  void loadAdFromUrl(String paramString)
  {
    this.mWebView.loadUrl(paramString);
  }
  
  protected void onAttachedToWindow()
  {
    onWindowFocusChanged(hasWindowFocus());
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.mExpanded) {
      closeAdImmediately();
    }
    super.onDetachedFromWindow();
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (Bundle)paramParcelable;
    this.mLatencyTracker.restoreTransientState(paramParcelable);
    paramParcelable = paramParcelable.getParcelable("google_ad_view_parent_state");
    if (paramParcelable != null) {
      super.onRestoreInstanceState(paramParcelable);
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    Parcelable localParcelable = super.onSaveInstanceState();
    if (localParcelable != null) {
      localBundle.putParcelable("google_ad_view_parent_state", localParcelable);
    }
    this.mLatencyTracker.saveTransientState(localBundle);
    return localBundle;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((this.mShowAdsDeferred) && (paramBoolean) && (this.mLastAdSpec != null) && (!this.mExpanded)) {
      showAds(this.mLastAdSpec, false);
    }
    if (paramBoolean) {
      this.mLatencyTracker.onWindowGetFocus();
    }
    scheduleAutoRefresh();
  }
  
  public void reset()
  {
    setDisplayedChild(0);
    this.mWebView.stopLoading();
    this.mWebView.clearView();
    this.mAdWebViewClient.reset();
  }
  
  void resize(int paramInt1, int paramInt2)
  {
    this.mAdWidth = paramInt1;
    this.mAdHeight = paramInt2;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      ViewGroup.LayoutParams localLayoutParams = getChildAt(i).getLayoutParams();
      localLayoutParams.width = AdUtil.scaleDipsToPixels(getContext(), paramInt1);
      localLayoutParams.height = AdUtil.scaleDipsToPixels(getContext(), paramInt2);
      i += 1;
    }
    requestLayout();
  }
  
  void retractAd()
  {
    if (!this.mExpanded) {
      return;
    }
    saveWebViewPicture();
    this.mAdViewHolder.removeAllViews();
    this.mOverlay.removeAllViews();
    this.mAdViewHolder.addView(this.mWebView);
    this.mOverlay.addView(this.mPlaceHolder);
    resize(this.mAdWidth, this.mAdHeight);
    postDelayed(new WebViewRetractRunnable(null), 400L);
  }
  
  public void setAdViewListener(AdViewListener paramAdViewListener)
  {
    this.mAdViewListener = paramAdViewListener;
  }
  
  public void setAutoRefreshSeconds(int paramInt)
  {
    if (paramInt <= 0)
    {
      this.mAutoRefreshSecs = -1;
      return;
    }
    int i = paramInt;
    if (paramInt < 180) {
      i = 180;
    }
    this.mAutoRefreshSecs = i;
    scheduleAutoRefresh();
  }
  
  public void setDisplayedChild(int paramInt)
  {
    super.setDisplayedChild(paramInt);
    if ((this.mDebugMode) && (paramInt == 1))
    {
      setForeground(getDebugDrawable());
      return;
    }
    setForeground(null);
  }
  
  public void showAds(AdSpec paramAdSpec)
  {
    showAds(paramAdSpec, false);
  }
  
  void showAds(AdSpec paramAdSpec, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mShowAdsDeferred = false;
    this.mLastAdSpec = paramAdSpec;
    if (!paramBoolean2)
    {
      this.mShowAdsDeferred = true;
      return;
    }
    if (this.mExpanded) {
      closeAdImmediately();
    }
    resize(paramAdSpec.getWidth(), paramAdSpec.getHeight());
    this.mDebugMode = paramAdSpec.getDebugMode();
    paramAdSpec = generateHtml(paramAdSpec, paramBoolean1);
    if (this.mDebugMode)
    {
      Log.i("GoogleAdView", "Fetching ad: " + paramAdSpec);
      getDebugDrawable();
      this.mWebView.setWebChromeClient(new WebChromeClient());
    }
    for (;;)
    {
      this.mWebView.loadData(paramAdSpec, "text/html", "utf8");
      scheduleAutoRefresh();
      return;
      this.mWebView.setWebChromeClient(null);
    }
  }
  
  class AdWebViewClient
    extends WebViewClient
  {
    private boolean mStartedAdFetch;
    private Random random = new Random();
    
    AdWebViewClient() {}
    
    private String getClickString(Uri paramUri)
    {
      if (!paramUri.isHierarchical()) {
        return null;
      }
      return paramUri.getQueryParameter("ai");
    }
    
    private boolean isAdFetchFailure(String paramString, Uri paramUri)
    {
      if (paramString.startsWith("http://__NO_MATCHING_AD__"))
      {
        Log.w("GoogleAdView", "DoubleClick could not fill the ad request.");
        return true;
      }
      return false;
    }
    
    private boolean isBlacklisted(Uri paramUri)
    {
      paramUri = paramUri.toString();
      int i = 0;
      while (i < GoogleAdView.LOCAL_URLS.length)
      {
        if (paramUri.equals(GoogleAdView.LOCAL_URLS[i])) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    private boolean isRedirect(Uri paramUri)
    {
      paramUri = paramUri.getHost();
      int i = GoogleAdView.REDIRECT_DOMAINS.length - 1;
      while (i >= 0)
      {
        if (paramUri.endsWith(GoogleAdView.REDIRECT_DOMAINS[i])) {
          return true;
        }
        i -= 1;
      }
      return false;
    }
    
    private void patchDoubleClickBug()
    {
      GoogleAdView.this.mWebView.loadUrl("javascript: document.body.style.margin = 0;");
    }
    
    private void reset()
    {
      this.mStartedAdFetch = false;
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      patchDoubleClickBug();
      super.onPageFinished(paramWebView, paramString);
      if ((this.mStartedAdFetch) && (!URLUtil.isDataUrl(paramString)))
      {
        this.mStartedAdFetch = false;
        GoogleAdView.this.setDisplayedChild(1);
        GoogleAdView.this.mLatencyTracker.onAdFetchFinished();
        if (GoogleAdView.this.mAdViewListener != null) {
          GoogleAdView.this.mAdViewListener.onFinishFetchAd();
        }
      }
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      if (URLUtil.isDataUrl(paramString))
      {
        this.mStartedAdFetch = true;
        GoogleAdView.this.mLatencyTracker.onAdFetchStart();
        if (GoogleAdView.this.mAdViewListener != null) {
          GoogleAdView.this.mAdViewListener.onStartFetchAd();
        }
      }
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      paramWebView = Uri.parse(paramString);
      if (AdViewCommunicator.isMessage(paramWebView)) {
        GoogleAdView.this.mCommunicator.testAndForwardMessage(paramWebView);
      }
      do
      {
        return true;
        if (isBlacklisted(paramWebView)) {
          return false;
        }
        if (!isAdFetchFailure(paramString, paramWebView)) {
          break;
        }
      } while (GoogleAdView.this.mAdViewListener == null);
      GoogleAdView.this.mAdViewListener.onAdFetchFailure();
      return true;
      if (GoogleAdView.this.mAdViewListener != null) {
        GoogleAdView.this.mAdViewListener.onClickAd();
      }
      GoogleAdView.this.mLatencyTracker.onAdClickStart(getClickString(paramWebView));
      paramWebView = new Intent("android.intent.action.VIEW", AFMAUtil.a(paramWebView));
      paramWebView.addCategory("android.intent.category.BROWSABLE");
      try
      {
        GoogleAdView.this.getContext().startActivity(paramWebView);
        return true;
      }
      catch (ActivityNotFoundException paramWebView)
      {
        Log.e("GoogleAdView", paramWebView.getMessage(), paramWebView);
      }
      return true;
    }
  }
  
  private class RefreshRunnable
    implements Runnable
  {
    private RefreshRunnable() {}
    
    public void run()
    {
      if ((GoogleAdView.this.mLastAdSpec == null) || (!GoogleAdView.this.hasWindowFocus())) {}
      do
      {
        return;
        if (!GoogleAdView.this.mExpanded) {
          GoogleAdView.this.showAds(GoogleAdView.this.mLastAdSpec, true);
        }
      } while (GoogleAdView.this.mAutoRefreshSecs <= 0);
      GoogleAdView.this.postDelayed(this, GoogleAdView.this.mAutoRefreshSecs * 1000);
    }
  }
  
  private class WebViewExpandRunnable
    implements Runnable
  {
    private WebViewExpandRunnable() {}
    
    public void run()
    {
      if (!GoogleAdView.this.mExpanded) {
        return;
      }
      GoogleAdView.this.mWebView.setVisibility(0);
      GoogleAdView.this.mOverlay.dimBackground();
    }
  }
  
  private class WebViewPlaceHolder
    extends View
  {
    private int mHeight;
    private Picture mTemporaryPicture;
    private int mWidth;
    
    public WebViewPlaceHolder(Context paramContext)
    {
      super();
    }
    
    public Picture getPicture()
    {
      return this.mTemporaryPicture;
    }
    
    public void onDraw(Canvas paramCanvas)
    {
      super.onDraw(paramCanvas);
      paramCanvas.drawPicture(this.mTemporaryPicture, new Rect(0, 0, this.mWidth, this.mHeight));
    }
    
    public void setPicture(Picture paramPicture)
    {
      this.mTemporaryPicture = paramPicture;
    }
    
    public void setSize(int paramInt1, int paramInt2)
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
    }
  }
  
  private class WebViewRetractRunnable
    implements Runnable
  {
    private WebViewRetractRunnable() {}
    
    public void run()
    {
      if (!GoogleAdView.this.mExpanded) {
        return;
      }
      GoogleAdView.this.mOverlay.removeAllViewsAndDismiss();
      GoogleAdView.access$1002(GoogleAdView.this, false);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/GoogleAdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */