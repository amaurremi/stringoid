package com.jumptap.adtag;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.jumptap.adtag.actions.ActionFactory;
import com.jumptap.adtag.actions.AdAction;
import com.jumptap.adtag.callbacks.EmptyBodyChecker;
import com.jumptap.adtag.callbacks.JtWebviewCb;
import com.jumptap.adtag.events.EventManager;
import com.jumptap.adtag.listeners.JtAdViewInnerListener;
import com.jumptap.adtag.utils.JtAccelerator;
import com.jumptap.adtag.utils.JtAdFetcher;
import com.jumptap.adtag.utils.JtAdUrlBuilder;
import com.jumptap.adtag.utils.JtException;
import com.jumptap.adtag.utils.JtSettingsParameters;

public class JtAdView
  extends RelativeLayout
  implements JtAdViewInnerListener
{
  private static final int DISMISS_BTN_HIEGHT = 30;
  private static final int DISMISS_BTN_ID = 999999;
  private static final int DISMISS_BTN_TEXT_SIZE = 20;
  protected static final int MILLIS_IN_SEC = 1000;
  protected int ACTIVE_WEBVIEW_INDEX = 0;
  protected int INACTIVE_WEBVIEW_INDEX = 1;
  private JtAccelerator accel;
  private String adRequestId = "";
  private String adRequestUrl = "";
  private JtAdUrlBuilder adUrlBuilder;
  protected JtAdViewListener adViewListener;
  protected Context context;
  protected TextView dismiss;
  private EmptyBodyChecker emptyBodyChecker;
  protected EventManager eventManager;
  private JtAdFetcher fetcher;
  private ImageView imgView;
  private boolean isExpanded = false;
  private boolean isOnReceivedErrorCalled = false;
  private boolean isWindowVisible = false;
  private boolean launchedActivity = false;
  private Runnable loadUrlRunnable;
  private Handler mainHandler = null;
  private boolean refreshIsImmediate = false;
  private String responseContent = "";
  protected WebView[] webViewArr;
  protected JtAdWidgetSettings widgetSettings = null;
  
  public JtAdView(Context paramContext)
    throws JtException
  {
    super(paramContext);
    Log.d("JtAd", "JtAdView(Context context)");
    init(paramContext, null);
  }
  
  public JtAdView(Context paramContext, AttributeSet paramAttributeSet)
    throws JtException
  {
    super(paramContext, paramAttributeSet);
    Log.d("JtAd", "JtAdView(Context context, AttributeSet attrs)");
    init(paramContext, paramAttributeSet);
  }
  
  public JtAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    throws JtException
  {
    super(paramContext, paramAttributeSet, paramInt);
    Log.d("JtAd", "JtAdView(Context context, AttributeSet attrs, int defStyle)");
    init(paramContext, paramAttributeSet);
  }
  
  public JtAdView(Context paramContext, JtAdWidgetSettings paramJtAdWidgetSettings)
    throws JtException
  {
    super(paramContext);
    this.widgetSettings = paramJtAdWidgetSettings;
    Log.d("JtAd", "JtAdView(Context context, JtAdWidgetSettings widgetSettings)");
    init(paramContext, null);
  }
  
  private void binderBrowser(WebView paramWebView)
  {
    paramWebView.addJavascriptInterface(new JtWebviewCb(this.context, this), "JtVwCb");
    this.accel = new JtAccelerator(this.context, paramWebView);
    paramWebView.addJavascriptInterface(this.accel, "Accel");
    paramWebView.addJavascriptInterface(this.eventManager, "Tracking");
    paramWebView.addJavascriptInterface(this.emptyBodyChecker, "EmptyBodyChecker");
  }
  
  private float getDensity()
  {
    return getContext().getResources().getDisplayMetrics().density;
  }
  
  private Handler getMainHandler()
  {
    if (this.mainHandler == null) {
      this.mainHandler = new Handler(Looper.getMainLooper());
    }
    return this.mainHandler;
  }
  
  private void getUrlFromNetwork()
  {
    this.fetcher.kickOffUrlFetch(this.adRequestUrl);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
    throws JtException
  {
    Log.d("JtAd", "getting into init()");
    this.context = paramContext;
    this.loadUrlRunnable = new Runnable()
    {
      public void run()
      {
        JtAdView.this.loadUrlIfVisible();
      }
    };
    try
    {
      initWidgetSettings(paramAttributeSet);
      setMinimumWidth(getWidthSize());
      setMinimumHeight(getHeightSize());
      this.adUrlBuilder = new JtAdUrlBuilder(this.widgetSettings, paramContext);
      this.eventManager = new EventManager(paramContext, this);
      this.emptyBodyChecker = new EmptyBodyChecker(this, this.eventManager);
      setVerticalScrollBarEnabled(false);
      setHorizontalScrollBarEnabled(false);
      initAlternativeImgView();
      initWebViewArray();
      initDismissButton();
      paramAttributeSet = new RelativeLayout.LayoutParams(getWidthSize(), getDismissBtnHeight());
      addView(this.dismiss, paramAttributeSet);
      paramAttributeSet = new RelativeLayout.LayoutParams(getWidthSize(), getHeightSize());
      paramAttributeSet.addRule(3, 999999);
      paramAttributeSet.addRule(14);
      addView(this.webViewArr[this.INACTIVE_WEBVIEW_INDEX], paramAttributeSet);
      addView(this.webViewArr[this.ACTIVE_WEBVIEW_INDEX], paramAttributeSet);
      addView(this.imgView, paramAttributeSet);
      this.fetcher = new JtAdFetcher(paramContext, this);
      this.fetcher.setShouldDebugNetworkTraffic(this.widgetSettings.getShouldDebugNetworkTraffic());
      return;
    }
    catch (JtException paramContext)
    {
      Log.e("JtAd", paramContext.getMessage());
      throw paramContext;
    }
  }
  
  private void initAlternativeImgView()
  {
    this.imgView = new ImageView(this.context);
    setBgAndImg();
  }
  
  private void initDismissButton()
  {
    this.dismiss = new TextView(this.context);
    this.dismiss.setId(999999);
    this.dismiss.setText(this.widgetSettings.getDismissButtonLabel());
    this.dismiss.setVisibility(8);
    this.dismiss.setClickable(true);
    this.dismiss.setTextColor(-16777216);
    this.dismiss.setTextSize(20.0F);
    this.dismiss.setBackgroundColor(-7829368);
  }
  
  private void initWebView(WebView paramWebView)
  {
    paramWebView.setVerticalScrollBarEnabled(false);
    paramWebView.setHorizontalScrollBarEnabled(false);
    paramWebView.getSettings().setJavaScriptEnabled(true);
    paramWebView.setVisibility(4);
    paramWebView.setBackgroundColor(this.widgetSettings.getBackgroundColor());
    binderBrowser(paramWebView);
    paramWebView.setWebViewClient(new JtAdWebViewClient(null));
    JtAdListener localJtAdListener = new JtAdListener(this, getId());
    paramWebView.setOnTouchListener(localJtAdListener);
    paramWebView.setOnFocusChangeListener(localJtAdListener);
    paramWebView.setOnClickListener(localJtAdListener);
    paramWebView.setOnLongClickListener(localJtAdListener);
    paramWebView.setWebChromeClient(new WebChromeClient()
    {
      public boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
      {
        JtAdView.this.logChromeActivity("Console [" + paramAnonymousConsoleMessage.message() + "]");
        return true;
      }
      
      public boolean onJsAlert(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
      {
        JtAdView.this.logChromeActivity("Alert [" + paramAnonymousString2 + "]");
        return true;
      }
      
      public boolean onJsBeforeUnload(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
      {
        JtAdView.this.logChromeActivity("Before unload [" + paramAnonymousString2 + "]");
        return true;
      }
      
      public boolean onJsConfirm(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
      {
        JtAdView.this.logChromeActivity("Confirm [" + paramAnonymousString2 + "]");
        return true;
      }
      
      public boolean onJsPrompt(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, JsPromptResult paramAnonymousJsPromptResult)
      {
        JtAdView.this.logChromeActivity("Prompt [" + paramAnonymousString2 + "]");
        return true;
      }
    });
  }
  
  private void initWebViewArray()
  {
    this.webViewArr = new WebView[2];
    this.webViewArr[this.ACTIVE_WEBVIEW_INDEX] = new WebView(this.context);
    initWebView(this.webViewArr[this.ACTIVE_WEBVIEW_INDEX]);
    this.webViewArr[this.INACTIVE_WEBVIEW_INDEX] = new WebView(this.context);
    initWebView(this.webViewArr[this.INACTIVE_WEBVIEW_INDEX]);
  }
  
  private void initWidgetSettings(AttributeSet paramAttributeSet)
    throws JtException
  {
    if (this.widgetSettings == null) {
      this.widgetSettings = JtAdWidgetSettingsFactory.createWidgetSettings();
    }
    JtSettingsParameters.populateSettings(this.widgetSettings, paramAttributeSet, this.context);
    if ((this.widgetSettings.getPublisherId() == null) || ("".equals(this.widgetSettings.getPublisherId()))) {
      throw new JtException("Publisher id was not set. Please set it and try again");
    }
    if ((this.widgetSettings.getApplicationId() == null) || ("".equals(this.widgetSettings.getApplicationId()))) {
      Log.e("JtAd", "Application id was not set. empty application id will be sent to Jumptap servers");
    }
    if ((this.widgetSettings.getApplicationVersion() == null) || ("".equals(this.widgetSettings.getApplicationVersion()))) {
      Log.e("JtAd", "Application version was not set. empty application version will be sent to Jumptap servers");
    }
  }
  
  private void loadUrlIfVisible()
  {
    getVisibility();
    if (this.isExpanded) {}
    do
    {
      Log.d("JtAd", "Ad expanded, no refresh.");
      do
      {
        return;
      } while ((!this.refreshIsImmediate) && ((!this.isWindowVisible) || (0 != 0)));
      if (this.context.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
        break;
      }
    } while (this.adUrlBuilder == null);
    this.adRequestUrl = this.adUrlBuilder.getAdUrl(this.webViewArr[this.INACTIVE_WEBVIEW_INDEX]);
    if (this.widgetSettings.getShouldDebugNetworkTraffic()) {
      Log.d("JtAd", "Base url : " + this.adRequestUrl);
    }
    getUrlFromNetwork();
    return;
    Log.e("JtAd", "JtAdView: Requires INTERNET permission");
    onAdError(-1);
  }
  
  private void logChromeActivity(String paramString)
  {
    Log.d("JtAd", paramString);
  }
  
  private void refreshAd(int paramInt)
  {
    if (paramInt == 0) {}
    for (this.refreshIsImmediate = true;; this.refreshIsImmediate = false)
    {
      removeRefreshCallbacks();
      if (!this.refreshIsImmediate) {
        break;
      }
      getMainHandler().post(this.loadUrlRunnable);
      return;
    }
    restoreRefreshCallback(paramInt);
  }
  
  private void removeRefreshCallbacks()
  {
    getMainHandler().removeCallbacks(this.loadUrlRunnable);
  }
  
  private void restoreRefreshCallback(int paramInt)
  {
    getMainHandler().postDelayed(this.loadUrlRunnable, paramInt * 1000);
  }
  
  private void setBgAndImg()
  {
    int i = this.widgetSettings.getBackgroundColor();
    if (i != -1) {
      this.imgView.setBackgroundColor(i);
    }
    Bitmap localBitmap = this.widgetSettings.getAlternateImage();
    if (localBitmap != null)
    {
      Log.d("JtAd", "Loading user's alternate image");
      this.imgView.setImageBitmap(localBitmap);
    }
  }
  
  public String getAdRequestId()
  {
    return this.adRequestId;
  }
  
  public String getAdRequestUrl()
  {
    return this.adRequestUrl;
  }
  
  protected int getDismissBtnHeight()
  {
    return (int)(30.0F * getDensity());
  }
  
  protected int getHeightSize()
  {
    float f = getDensity();
    return (int)(this.widgetSettings.getHeight() * f);
  }
  
  public JtAdWidgetSettings getWidgetSettings()
  {
    return this.widgetSettings;
  }
  
  protected int getWidthSize()
  {
    float f = getDensity();
    return (int)(this.widgetSettings.getWidth() * f);
  }
  
  public void handleClicks(String paramString)
  {
    new Thread(new PerformActionHandler(paramString, this)).start();
  }
  
  public void hide()
  {
    post(new Runnable()
    {
      public void run()
      {
        JtAdView.this.setVisibility(4);
      }
    });
    if (this.adViewListener != null) {
      this.adViewListener.onHide(this, getId());
    }
  }
  
  public void notifyAdClicked()
  {
    if (this.adViewListener != null) {
      this.adViewListener.onBannerClicked(this, getId());
    }
  }
  
  public void notifyContract()
  {
    this.isExpanded = false;
    if (this.adViewListener != null) {
      this.adViewListener.onContract(this, getId());
    }
    int i = this.widgetSettings.getRefreshPeriod();
    if (i > 0) {
      refreshAd(i);
    }
  }
  
  public void notifyExpand()
  {
    removeCallbacks(this.loadUrlRunnable);
    this.isExpanded = true;
    if (this.adViewListener != null) {
      this.adViewListener.onExpand(this, getId());
    }
  }
  
  public void notifyLaunchActivity()
  {
    if (this.adViewListener != null) {
      this.adViewListener.onLaunchActivity(this, getId());
    }
  }
  
  public void notifyReturnFromActivity()
  {
    if (this.adViewListener != null) {
      this.adViewListener.onReturnFromActivity(this, getId());
    }
  }
  
  public void onAdError(int paramInt)
  {
    resize(0, 0, true);
    if (this.adViewListener != null) {
      this.adViewListener.onAdError(this, getId(), paramInt);
    }
    startTimers(false);
  }
  
  public void onBeginAdInteraction()
  {
    if (this.adViewListener != null) {
      this.adViewListener.onBeginAdInteraction(this, getId());
    }
  }
  
  public void onEndAdInteraction()
  {
    if (this.adViewListener != null) {
      this.adViewListener.onEndAdInteraction(this, getId());
    }
  }
  
  public void onInterstitialDismissed()
  {
    if (this.adViewListener != null) {
      this.adViewListener.onInterstitialDismissed(this, getId());
    }
  }
  
  public void onNewAd()
  {
    if (this.adViewListener != null) {
      this.adViewListener.onNewAd(this, getId(), this.responseContent);
    }
  }
  
  public void onNoAdFound()
  {
    resize(0, 0, true);
    if (this.adViewListener != null) {
      this.adViewListener.onNoAdFound(this, getId());
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    Log.d("JtAd", "visibility=" + paramInt);
    super.onWindowVisibilityChanged(paramInt);
    switch (paramInt)
    {
    default: 
      this.isWindowVisible = false;
    }
    do
    {
      do
      {
        do
        {
          return;
          if (this.webViewArr[this.ACTIVE_WEBVIEW_INDEX].getVisibility() == 0) {
            this.webViewArr[this.ACTIVE_WEBVIEW_INDEX].bringToFront();
          }
          if (this.launchedActivity)
          {
            setLaunchedActivity(false);
            notifyReturnFromActivity();
          }
        } while (this.isWindowVisible);
        this.isWindowVisible = true;
        if (this.imgView != null)
        {
          setBgAndImg();
          this.imgView.setVisibility(0);
        }
      } while (getWidgetSettings().getRefreshPeriod() <= 0);
      Log.d("JtAd", "Time to refresh ad because of window visibility");
      if (this.isExpanded)
      {
        Log.d("JtAd", "But not now because the ad is expanded");
        return;
      }
      loadUrlIfVisible();
      return;
      this.isWindowVisible = false;
    } while (this.eventManager == null);
  }
  
  public void refreshAd()
  {
    refreshAd(0);
  }
  
  public void resize(final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    if (getLayoutParams() != null) {
      post(new Runnable()
      {
        public void run()
        {
          int i;
          int j;
          label24:
          Object localObject;
          if (paramBoolean)
          {
            i = paramInt1;
            if (!paramBoolean) {
              break label50;
            }
            j = paramInt2;
            localObject = JtAdView.this.getLayoutParams();
            if (localObject != null) {
              break label61;
            }
          }
          label50:
          label61:
          int k;
          int m;
          do
          {
            return;
            i = JtAdView.this.getWidthSize();
            break;
            j = JtAdView.this.getHeightSize();
            break label24;
            k = ((ViewGroup.LayoutParams)localObject).width;
            m = ((ViewGroup.LayoutParams)localObject).height;
          } while ((k == i) && (m == j));
          if (paramBoolean) {
            if ((paramInt1 > 0) && (paramInt2 > 0)) {
              JtAdView.this.notifyExpand();
            }
          }
          for (;;)
          {
            ((ViewGroup.LayoutParams)localObject).width = i;
            ((ViewGroup.LayoutParams)localObject).height = j;
            localObject = JtAdView.this.webViewArr[JtAdView.this.ACTIVE_WEBVIEW_INDEX];
            if (localObject == null) {
              break;
            }
            localObject = ((View)localObject).getLayoutParams();
            if (localObject == null) {
              break;
            }
            ((ViewGroup.LayoutParams)localObject).width = i;
            ((ViewGroup.LayoutParams)localObject).height = j;
            JtAdView.this.requestLayout();
            return;
            JtAdView.this.notifyContract();
          }
        }
      });
    }
  }
  
  public void resizeWithCallback(boolean paramBoolean, int paramInt1, int paramInt2, final String paramString1, int paramInt3, String paramString2)
  {
    Log.d("JtAd", "JtAdView::resizeWithCallback (" + paramString1 + ")");
    resize(paramInt1, paramInt2, paramBoolean);
    post(new Runnable()
    {
      public void run()
      {
        Log.d("JtAd", "JtAdView/Runnable::run (" + paramString1 + ")");
        JtAdView.this.webViewArr[JtAdView.this.ACTIVE_WEBVIEW_INDEX].loadUrl("javascript:executeCallback('" + paramString1 + "');");
      }
    });
  }
  
  public void setAdViewListener(JtAdViewListener paramJtAdViewListener)
  {
    this.adViewListener = paramJtAdViewListener;
  }
  
  public void setContent(final String paramString1, String paramString2)
  {
    this.responseContent = paramString1;
    this.adRequestId = paramString2;
    if (paramString1 == null)
    {
      onAdError(-1);
      return;
    }
    getMainHandler().post(new Runnable()
    {
      public void run()
      {
        JtAdView.this.webViewArr[JtAdView.this.INACTIVE_WEBVIEW_INDEX].loadDataWithBaseURL(null, paramString1, "text/html", "utf-8", null);
      }
    });
    Log.d("JtAd", "called load data");
  }
  
  public void setLaunchedActivity(boolean paramBoolean)
  {
    this.launchedActivity = paramBoolean;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {
      this.webViewArr[this.ACTIVE_WEBVIEW_INDEX].loadUrl("javascript:if(typeof ORMMAReady == 'function') { if (!ormma.ready) { ormma.ready = true; ORMMAReady(); } else {console.log(\"not ready\");} } else {console.log(\"no ormmaready\");}");
    }
  }
  
  public void setWidgetSettings(JtAdWidgetSettings paramJtAdWidgetSettings)
  {
    this.widgetSettings = paramJtAdWidgetSettings;
  }
  
  protected void startTimers(boolean paramBoolean)
  {
    int i = this.widgetSettings.getRefreshPeriod();
    if ((i > 0) && (paramBoolean)) {
      refreshAd(i);
    }
  }
  
  protected class JtAdListener
    implements View.OnTouchListener, View.OnFocusChangeListener, View.OnClickListener, View.OnLongClickListener
  {
    private JtAdView widget = null;
    private int widgetId = -1;
    
    public JtAdListener(JtAdView paramJtAdView, int paramInt)
    {
      this.widget = paramJtAdView;
      this.widgetId = paramInt;
    }
    
    public void onClick(View paramView) {}
    
    public void onFocusChange(View paramView, boolean paramBoolean)
    {
      if (JtAdView.this.adViewListener != null) {
        JtAdView.this.adViewListener.onFocusChange(this.widget, this.widgetId, paramBoolean);
      }
      if (paramBoolean) {
        JtAdView.this.removeCallbacks(JtAdView.this.loadUrlRunnable);
      }
      while (this.widget.getWidgetSettings().getRefreshPeriod() <= 0) {
        return;
      }
      JtAdView.this.refreshAd(60);
    }
    
    public boolean onLongClick(View paramView)
    {
      return false;
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if (this.widget.getWidgetSettings().getRefreshPeriod() > 0) {
        JtAdView.this.refreshAd(60);
      }
      return false;
    }
  }
  
  private class JtAdWebViewClient
    extends WebViewClient
  {
    private JtAdWebViewClient() {}
    
    private void switchActiveAndInactiveIndex()
    {
      JtAdView.this.INACTIVE_WEBVIEW_INDEX = ((JtAdView.this.INACTIVE_WEBVIEW_INDEX + 1) % 2);
      JtAdView.this.ACTIVE_WEBVIEW_INDEX = ((JtAdView.this.ACTIVE_WEBVIEW_INDEX + 1) % 2);
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      Log.d("JtAd", "onPageFinished=" + paramString);
      JtAdView.this.resize(JtAdView.this.getWidthSize(), JtAdView.this.getHeightSize(), false);
      paramWebView.loadUrl("javascript:EmptyBodyChecker.checkBody(document.getElementsByTagName(\"body\")[0].innerHTML)");
      if (!JtAdView.this.isOnReceivedErrorCalled)
      {
        JtAdView.this.imgView.setVisibility(4);
        switchActiveAndInactiveIndex();
        JtAdView.this.webViewArr[JtAdView.this.INACTIVE_WEBVIEW_INDEX].setVisibility(4);
        JtAdView.this.webViewArr[JtAdView.this.ACTIVE_WEBVIEW_INDEX].setVisibility(0);
      }
      JtAdView.access$502(JtAdView.this, false);
      JtAdView.this.startTimers(true);
      if (JtAdView.this.getVisibility() == 0) {
        paramWebView.loadUrl("javascript:if(typeof ORMMAReady == 'function') { if (!ormma.ready) { ormma.ready = true; ORMMAReady(); } else {console.log(\"not ready\");} } else {console.log(\"no ormmaready\");}");
      }
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      Log.e("JtAd", "errorcode=" + paramInt + " desc=" + paramString1);
      JtAdView.access$502(JtAdView.this, true);
      JtAdView.this.onAdError(paramInt);
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      boolean bool = false;
      if (paramWebView.equals(JtAdView.this.webViewArr[JtAdView.this.ACTIVE_WEBVIEW_INDEX]))
      {
        JtAdView.this.handleClicks(paramString);
        bool = true;
      }
      for (;;)
      {
        Log.d("JtAd", "shouldOverrideUrlLoading=" + bool);
        return bool;
        Log.e("JtAd", "shouldOverrideUrlLoading cannot override url: " + paramString);
      }
    }
  }
  
  private class PerformActionHandler
    implements Runnable
  {
    String url;
    JtAdView widget;
    
    PerformActionHandler(String paramString, JtAdView paramJtAdView)
    {
      this.url = paramString;
      this.widget = paramJtAdView;
    }
    
    public void run()
    {
      AdAction localAdAction = ActionFactory.createAction(this.url, JtAdView.this.widgetSettings.getUserAgent(null));
      if (localAdAction != null)
      {
        JtAdView.this.notifyAdClicked();
        localAdAction.perform(JtAdView.this.context, this.widget);
        return;
      }
      Log.e("JtAd", "Cannot perform action or find AdAction for url: " + this.url);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/JtAdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */