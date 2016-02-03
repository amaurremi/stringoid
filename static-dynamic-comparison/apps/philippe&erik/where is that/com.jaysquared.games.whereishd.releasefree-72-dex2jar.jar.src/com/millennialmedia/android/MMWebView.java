package com.millennialmedia.android;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import com.millennialmedia.google.gson.Gson;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.json.JSONObject;

class MMWebView
  extends WebView
{
  static final String JS_INTERFACE_NAME = "interface";
  static final String PROPERTY_BANNER_TYPE = "PROPERTY_BANNER_TYPE";
  static final String PROPERTY_EXPANDING = "PROPERTY_EXPANDING";
  static final String PROPERTY_STATE = "PROPERTY_STATE";
  private HttpMMHeaders _lastHeaders;
  long creatorAdImplId;
  int currentColor;
  String currentUrl;
  boolean hadFirstRecordingCreation = false;
  boolean hadFirstSpeechKitCreation = false;
  volatile boolean isExpanding;
  boolean isSendingSize = true;
  volatile boolean isUserClosedResize;
  volatile boolean isVisible = false;
  volatile String mraidState;
  int oldHeight = -50;
  int oldWidth = -50;
  volatile boolean requiresPreAdSizeFix;
  final GestureDetector tapDetector;
  final String userAgent;
  
  public MMWebView(Context paramContext, long paramLong)
  {
    super(paramContext);
    MMSDK.Log.d("Setting isExpanding in constructor to " + this.isExpanding);
    setWillNotDraw(false);
    setHorizontalScrollBarEnabled(false);
    setVerticalScrollBarEnabled(false);
    setOnTouchListener(new WebTouchListener(this));
    this.mraidState = "loading";
    this.creatorAdImplId = paramLong;
    MMSDK.Log.v("Assigning WebView internal id: %d", new Object[] { Long.valueOf(this.creatorAdImplId) });
    setId((int)(15063L + this.creatorAdImplId));
    if (HandShake.sharedHandShake(paramContext).hardwareAccelerationEnabled) {
      enableHardwareAcceleration();
    }
    for (;;)
    {
      setMediaPlaybackRequiresUserGesture(false);
      setWebChromeClient(new MyWebChromeClient(this));
      WebSettings localWebSettings = getSettings();
      this.userAgent = localWebSettings.getUserAgentString();
      localWebSettings.setJavaScriptEnabled(true);
      localWebSettings.setCacheMode(-1);
      localWebSettings.setDefaultTextEncodingName("UTF-8");
      localWebSettings.setLoadWithOverviewMode(true);
      localWebSettings.setGeolocationEnabled(true);
      localWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
      this.tapDetector = new GestureDetector(paramContext.getApplicationContext(), new WebGestureListener(this));
      return;
      disableAllAcceleration();
    }
  }
  
  private boolean hasDefaultResizeParams()
  {
    return (this.oldWidth == -50) && (this.oldHeight == -50);
  }
  
  private boolean isInterstitial()
  {
    return getBanner() == null;
  }
  
  private boolean needsSamsungJBOpenGlFixNoAcceleration()
  {
    int i = Integer.parseInt(Build.VERSION.SDK);
    return ("Nexus S".equals(Build.MODEL)) && ("samsung".equals(Build.MANUFACTURER)) && ((i == 16) || (i == 17));
  }
  
  boolean allowMicrophoneCreationCommands()
  {
    boolean bool = true;
    if (this.hadFirstRecordingCreation) {
      bool = allowRecordingCommands();
    }
    do
    {
      return bool;
      this.hadFirstRecordingCreation = true;
    } while ((isInterstitial()) && (this.isVisible));
    return false;
  }
  
  boolean allowRecordingCommands()
  {
    return (hasWindowFocus()) && (isInterstitial());
  }
  
  boolean allowSpeechCreationCommands()
  {
    boolean bool = true;
    if (this.hadFirstSpeechKitCreation) {
      bool = allowRecordingCommands();
    }
    do
    {
      return bool;
      this.hadFirstSpeechKitCreation = true;
    } while ((isInterstitial()) && (this.isVisible));
    return false;
  }
  
  void animateTransition(final MMAdImpl paramMMAdImpl)
  {
    paramMMAdImpl = new FutureTask(new Callable()
    {
      public Void call()
      {
        try
        {
          MMWebView.this.buildDrawingCache();
          Bitmap localBitmap = MMWebView.this.getDrawingCache();
          if (localBitmap != null)
          {
            localBitmap = Bitmap.createBitmap(localBitmap);
            paramMMAdImpl.prepareTransition(localBitmap);
          }
          MMWebView.this.destroyDrawingCache();
        }
        catch (Exception localException)
        {
          for (;;)
          {
            MMSDK.Log.d(localException);
          }
        }
        return null;
      }
    });
    MMSDK.runOnUiThread(paramMMAdImpl);
    try
    {
      paramMMAdImpl.get();
      return;
    }
    catch (InterruptedException paramMMAdImpl) {}catch (ExecutionException paramMMAdImpl) {}
  }
  
  boolean canScroll()
  {
    return getParent() instanceof MMAdView;
  }
  
  public void destroy()
  {
    try
    {
      resetSpeechKit();
      super.destroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  void disableAllAcceleration()
  {
    try
    {
      WebView.class.getMethod("setLayerType", new Class[] { Integer.TYPE, Paint.class }).invoke(this, new Object[] { Integer.valueOf(0), null });
      MMSDK.Log.d("Remove allAcceleration");
      return;
    }
    catch (Exception localException) {}
  }
  
  void enableHardwareAcceleration()
  {
    if (!needsSamsungJBOpenGlFixNoAcceleration()) {}
    try
    {
      WebView.class.getMethod("setLayerType", new Class[] { Integer.TYPE, Paint.class }).invoke(this, new Object[] { Integer.valueOf(2), null });
      MMSDK.Log.d("Enabled hardwareAcceleration");
      return;
    }
    catch (Exception localException) {}
  }
  
  void enableSendingSize()
  {
    this.isSendingSize = true;
  }
  
  void enableSoftwareAcceleration()
  {
    if (!needsSamsungJBOpenGlFixNoAcceleration()) {}
    try
    {
      WebView.class.getMethod("setLayerType", new Class[] { Integer.TYPE, Paint.class }).invoke(this, new Object[] { Integer.valueOf(1), null });
      MMSDK.Log.d("Enable softwareAcceleration");
      return;
    }
    catch (Exception localException) {}
  }
  
  /* Error */
  android.app.Activity getActivity()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 297	com/millennialmedia/android/MMWebView:getParent	()Landroid/view/ViewParent;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +38 -> 46
    //   11: aload_1
    //   12: instanceof 344
    //   15: ifeq +31 -> 46
    //   18: aload_1
    //   19: checkcast 344	android/view/ViewGroup
    //   22: invokevirtual 347	android/view/ViewGroup:getContext	()Landroid/content/Context;
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull +19 -> 46
    //   30: aload_1
    //   31: instanceof 349
    //   34: ifeq +12 -> 46
    //   37: aload_1
    //   38: checkcast 349	com/millennialmedia/android/MMActivity
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: aconst_null
    //   47: astore_1
    //   48: goto -6 -> 42
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	MMWebView
    //   6	42	1	localObject1	Object
    //   51	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	51	finally
    //   11	26	51	finally
    //   30	42	51	finally
  }
  
  String getAdId()
  {
    if ((this._lastHeaders != null) && (!TextUtils.isEmpty(this._lastHeaders.acid))) {
      return this._lastHeaders.acid;
    }
    return "DEFAULT_AD_ID";
  }
  
  /* Error */
  AdViewOverlayView getAdViewOverlayView()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 297	com/millennialmedia/android/MMWebView:getParent	()Landroid/view/ViewParent;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +19 -> 27
    //   11: aload_1
    //   12: instanceof 369
    //   15: ifeq +12 -> 27
    //   18: aload_1
    //   19: checkcast 369	com/millennialmedia/android/AdViewOverlayView
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: areturn
    //   27: aconst_null
    //   28: astore_1
    //   29: goto -6 -> 23
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	MMWebView
    //   6	23	1	localObject1	Object
    //   32	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	32	finally
    //   11	23	32	finally
  }
  
  /* Error */
  MMAdView getBanner()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 297	com/millennialmedia/android/MMWebView:getParent	()Landroid/view/ViewParent;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +19 -> 27
    //   11: aload_1
    //   12: instanceof 299
    //   15: ifeq +12 -> 27
    //   18: aload_1
    //   19: checkcast 299	com/millennialmedia/android/MMAdView
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: areturn
    //   27: aconst_null
    //   28: astore_1
    //   29: goto -6 -> 23
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	MMWebView
    //   6	23	1	localObject1	Object
    //   32	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	32	finally
    //   11	23	32	finally
  }
  
  HttpMMHeaders getLastHeaders()
  {
    return this._lastHeaders;
  }
  
  MMAdView getMMAdView()
  {
    if ((getParent() instanceof MMAdView)) {
      return (MMAdView)getParent();
    }
    return null;
  }
  
  MMLayout getMMLayout()
  {
    if ((getParent() instanceof MMLayout)) {
      return (MMLayout)getParent();
    }
    return null;
  }
  
  String getUserAgent()
  {
    return this.userAgent;
  }
  
  boolean isCurrentParent(long paramLong)
  {
    ViewParent localViewParent = getParent();
    if (localViewParent == null) {
      return false;
    }
    MMSDK.Log.w("Id check for parent: " + paramLong + " versus " + ((MMLayout)localViewParent).adImpl.internalId);
    if (paramLong == ((MMLayout)localViewParent).adImpl.internalId) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  boolean isMraidResized()
  {
    return "resized".equals(this.mraidState);
  }
  
  boolean isOriginalUrl(String paramString)
  {
    return ((!TextUtils.isEmpty(this.currentUrl)) && (paramString.equals(this.currentUrl + "?"))) || (paramString.equals(this.currentUrl + "#"));
  }
  
  boolean isParentBannerAd()
  {
    if (getParent() != null) {
      return (ViewGroup)getParent() instanceof MMAdView;
    }
    return false;
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.currentUrl = paramString1;
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(final String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramString.startsWith("http")) {
      this.currentUrl = paramString;
    }
    MMSDK.Log.v("loadUrl @@" + paramString);
    if (MMSDK.isUiThread()) {
      try
      {
        super.loadUrl(paramString);
        return;
      }
      catch (Exception paramString)
      {
        return;
      }
    }
    MMSDK.runOnUiThread(new Runnable()
    {
      public void run()
      {
        MMWebView.this.loadUrl(paramString);
      }
    });
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int i = getMeasuredHeight();
    paramInt1 = i;
    if (i == 0) {
      paramInt1 = paramInt2;
    }
    if (this.requiresPreAdSizeFix)
    {
      setMeasuredDimension(1, 1);
      return;
    }
    setMeasuredDimension(j, paramInt1);
  }
  
  public void onPauseWebView()
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    try
    {
      WebView.class.getMethod("onPause", new Class[0]).invoke(this, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      MMSDK.Log.w("No onPause()");
    }
  }
  
  public void onResumeWebView()
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    try
    {
      WebView.class.getMethod("onResume", new Class[0]).invoke(this, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      MMSDK.Log.w("No onResume()");
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = new int[2];
    getLocationInWindow((int[])localObject);
    DisplayMetrics localDisplayMetrics = MMSDK.getMetrics(getContext());
    if (localDisplayMetrics != null)
    {
      localObject = new DTOAdViewLayout((int)(localObject[0] / localDisplayMetrics.density), (int)(localObject[1] / localDisplayMetrics.density), (int)(paramInt1 / localDisplayMetrics.density), (int)(paramInt2 / localDisplayMetrics.density));
      localObject = new Gson().toJson(localObject);
      if (!this.isSendingSize) {
        break label192;
      }
      loadUrl("javascript:MMJS.sdk.setAdSize(" + (String)localObject + ");");
      MMSDK.Log.w(" @@@ SENDING IT!!!@@@@@  adSize ! " + (String)localObject);
      if ((getHeight() != 1) || (getWidth() != 1)) {
        MMSDK.runOnUiThreadDelayed(new Runnable()
        {
          public void run()
          {
            MMWebView.this.isSendingSize = false;
          }
        }, 800L);
      }
    }
    for (;;)
    {
      super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
      label192:
      MMSDK.Log.w(" @@@ Not sending adSize ! " + (String)localObject);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      requestFocus();
    }
    if (this.tapDetector != null) {
      this.tapDetector.onTouchEvent(paramMotionEvent);
    }
    if (paramMotionEvent.getAction() == 1) {
      MMSDK.Log.v("Ad clicked: action=%d x=%f y=%f", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()) });
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  void removeFromParent()
  {
    ViewParent localViewParent = getParent();
    if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
      ((ViewGroup)localViewParent).removeView(this);
    }
  }
  
  void resetSpeechKit()
  {
    BridgeMMSpeechkit.releaseSpeechKit();
    this.hadFirstSpeechKitCreation = false;
    this.hadFirstRecordingCreation = false;
  }
  
  void setAdProperties(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      loadUrl("javascript:MMJS.sdk.setAdProperties(" + paramJSONObject + ");");
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.currentColor = paramInt;
    if (paramInt == 0) {
      enableSoftwareAcceleration();
    }
    super.setBackgroundColor(paramInt);
  }
  
  void setLastHeaders(HttpMMHeaders paramHttpMMHeaders)
  {
    this._lastHeaders = paramHttpMMHeaders;
  }
  
  void setMediaPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    try
    {
      WebView.class.getMethod("setMediaPlaybackRequiresUserGesture", new Class[] { Boolean.TYPE }).invoke(this, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception localException) {}
  }
  
  void setMraidDefault()
  {
    loadUrl("javascript:MMJS.sdk.setState('default')");
    this.mraidState = "default";
    this.isSendingSize = true;
  }
  
  void setMraidExpanded()
  {
    MMSDK.Log.d("Changing state to EXPANDED for ---- " + toString() + "---- of creatorId ---" + this.creatorAdImplId + " ----");
    loadUrl("javascript:MMJS.sdk.setState('expanded');");
    this.mraidState = "expanded";
    this.hadFirstSpeechKitCreation = false;
    this.hadFirstRecordingCreation = false;
    this.isSendingSize = true;
  }
  
  void setMraidHidden()
  {
    loadUrl("javascript:MMJS.sdk.setState('hidden')");
    this.mraidState = "hidden";
  }
  
  void setMraidPlacementTypeInline()
  {
    loadUrl("javascript:MMJS.sdk.setPlacementType('inline');");
  }
  
  void setMraidPlacementTypeInterstitial()
  {
    loadUrl("javascript:MMJS.sdk.setPlacementType('interstitial');");
  }
  
  void setMraidReady()
  {
    loadUrl("javascript:MMJS.sdk.ready();");
  }
  
  void setMraidResize(final DTOResizeParameters paramDTOResizeParameters)
  {
    try
    {
      if (MMSDK.hasSetTranslationMethod())
      {
        final MMAdView localMMAdView = getMMAdView();
        this.isUserClosedResize = false;
        MMSDK.Log.d("New DTOResizeParameters = " + paramDTOResizeParameters);
        if (localMMAdView != null) {
          MMSDK.runOnUiThread(new Runnable()
          {
            private void handleMraidResize(DTOResizeParameters paramAnonymousDTOResizeParameters)
            {
              MMAdView localMMAdView = localMMAdView;
              localMMAdView.getClass();
              paramAnonymousDTOResizeParameters = new MMAdView.BannerBounds(localMMAdView, paramAnonymousDTOResizeParameters);
              setUnresizeParameters();
              paramAnonymousDTOResizeParameters.modifyLayoutParams(MMWebView.this.getLayoutParams());
            }
            
            private void setUnresizeParameters()
            {
              if (MMWebView.this.hasDefaultResizeParams())
              {
                ViewGroup.LayoutParams localLayoutParams = MMWebView.this.getLayoutParams();
                MMWebView.this.oldWidth = localLayoutParams.width;
                MMWebView.this.oldHeight = localLayoutParams.height;
                if (MMWebView.this.oldWidth <= 0) {
                  MMWebView.this.oldWidth = MMWebView.this.getWidth();
                }
                if (MMWebView.this.oldHeight <= 0) {
                  MMWebView.this.oldHeight = MMWebView.this.getHeight();
                }
              }
            }
            
            public void run()
            {
              synchronized (MMWebView.this)
              {
                MMWebView.this.isSendingSize = true;
                localMMAdView.handleMraidResize(paramDTOResizeParameters);
                handleMraidResize(paramDTOResizeParameters);
                MMWebView.this.loadUrl("javascript:MMJS.sdk.setState('resized');");
                MMWebView.this.mraidState = "resized";
                return;
              }
            }
          });
        }
      }
      return;
    }
    finally {}
  }
  
  void setMraidViewableHidden()
  {
    loadUrl("javascript:MMJS.sdk.setViewable(false)");
    this.isVisible = false;
  }
  
  void setMraidViewableVisible()
  {
    loadUrl("javascript:MMJS.sdk.setViewable(true)");
    this.isVisible = true;
  }
  
  void setWebViewContent(String paramString1, String paramString2, Context paramContext)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    final String str2 = paramString2.substring(0, paramString2.lastIndexOf("/") + 1);
    resetSpeechKit();
    final String str1 = paramString1;
    if (MRaid.hasMraidLocally(paramContext)) {
      str1 = MRaid.injectMraidJs(paramContext, str1);
    }
    for (;;)
    {
      if (MMSDK.logLevel >= 5)
      {
        MMSDK.Log.v("Received ad with base url %s.", new Object[] { paramString2 });
        MMSDK.Log.v(paramString1);
      }
      MMSDK.runOnUiThread(new Runnable()
      {
        public void run()
        {
          if (HandShake.sharedHandShake(MMWebView.this.getContext()).hardwareAccelerationEnabled) {
            MMWebView.this.enableHardwareAcceleration();
          }
          for (;;)
          {
            MMWebView.this.isSendingSize = true;
            MMWebView.this.loadDataWithBaseURL(str2, str1, "text/html", "UTF-8", null);
            return;
            if (MMWebView.this.currentColor == 0) {
              MMWebView.this.enableSoftwareAcceleration();
            } else {
              MMWebView.this.disableAllAcceleration();
            }
          }
        }
      });
      return;
      MMSDK.Log.e("MMJS is not downloaded");
    }
  }
  
  void setWebViewContent(final String paramString1, final String paramString2, final MMAdImpl paramMMAdImpl)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramMMAdImpl == null)) {
      return;
    }
    unresizeToDefault(paramMMAdImpl);
    resetSpeechKit();
    paramString2 = paramString2.substring(0, paramString2.lastIndexOf("/") + 1);
    if (MMSDK.logLevel >= 5)
    {
      MMSDK.Log.v("Received ad with base url %s.", new Object[] { paramString2 });
      MMSDK.Log.v(paramString1);
    }
    if (paramMMAdImpl.isTransitionAnimated()) {
      animateTransition(paramMMAdImpl);
    }
    if (paramMMAdImpl.ignoreDensityScaling)
    {
      paramString1 = "<head><meta name=\"viewport\" content=\"target-densitydpi=device-dpi\" /></head>" + paramString1;
      if (!MRaid.hasMraidLocally(paramMMAdImpl.getContext())) {
        break label139;
      }
      paramString1 = MRaid.injectMraidJs(paramMMAdImpl.getContext(), paramString1);
    }
    for (;;)
    {
      MMSDK.runOnUiThread(new Runnable()
      {
        public void run()
        {
          if (HandShake.sharedHandShake(MMWebView.this.getContext()).hardwareAccelerationEnabled) {
            MMWebView.this.enableHardwareAcceleration();
          }
          for (;;)
          {
            MMAd localMMAd = paramMMAdImpl.getCallingAd();
            if ((localMMAd != null) && ((localMMAd instanceof MMLayout))) {
              ((MMLayout)localMMAd).removeVideo();
            }
            MMWebView.this.isSendingSize = true;
            MMWebView.this.loadDataWithBaseURL(paramString2, paramString1, "text/html", "UTF-8", null);
            return;
            if (MMWebView.this.currentColor == 0) {
              MMWebView.this.enableSoftwareAcceleration();
            } else {
              MMWebView.this.disableAllAcceleration();
            }
          }
        }
      });
      return;
      break;
      label139:
      MMSDK.Log.e("MMJS is not downloaded");
    }
  }
  
  void setmicrophoneAudioLevelChange(double paramDouble)
  {
    loadUrl("javascript:MMJS.sdk.microphoneAudioLevelChange(" + paramDouble + ")");
  }
  
  void setmicrophoneStateChange(String paramString)
  {
    loadUrl("javascript:MMJS.sdk.microphoneStateChange('" + paramString + "')");
  }
  
  public String toString()
  {
    return "MMWebView originally from(" + this.creatorAdImplId + ") MRaidState(" + this.mraidState + ")." + super.toString();
  }
  
  void unresizeToDefault(final MMAdImpl paramMMAdImpl)
  {
    try
    {
      if ((MMSDK.hasSetTranslationMethod()) && (isMraidResized()) && (paramMMAdImpl != null))
      {
        paramMMAdImpl = paramMMAdImpl.getCallingAd();
        if ((paramMMAdImpl instanceof MMAdView))
        {
          paramMMAdImpl = (MMAdView)paramMMAdImpl;
          this.isUserClosedResize = true;
          MMSDK.runOnUiThread(new Runnable()
          {
            void handleUnresize()
            {
              if ((MMSDK.hasSetTranslationMethod()) && (!MMWebView.this.hasDefaultResizeParams()))
              {
                ViewGroup.LayoutParams localLayoutParams = MMWebView.this.getLayoutParams();
                localLayoutParams.width = MMWebView.this.oldWidth;
                localLayoutParams.height = MMWebView.this.oldHeight;
                MMWebView.this.oldWidth = -50;
                MMWebView.this.oldHeight = -50;
                MMWebView.this.requestLayout();
              }
            }
            
            public void run()
            {
              synchronized (MMWebView.this)
              {
                paramMMAdImpl.handleUnresize();
                handleUnresize();
                MMWebView.this.setMraidDefault();
                MMWebView.this.isSendingSize = true;
                MMWebView.this.invalidate();
                return;
              }
            }
          });
        }
      }
      return;
    }
    finally {}
  }
  
  void updateArgumentsWithSettings(Map<String, String> paramMap)
  {
    if (isParentBannerAd()) {}
    for (String str = "true";; str = "false")
    {
      paramMap.put("PROPERTY_BANNER_TYPE", str);
      paramMap.put("PROPERTY_STATE", this.mraidState);
      paramMap.put("PROPERTY_EXPANDING", String.valueOf(this.creatorAdImplId));
      return;
    }
  }
  
  private static class MyWebChromeClient
    extends WebChromeClient
  {
    private static final String KEY_USE_GEO = "mm_use_geo_location";
    WeakReference<MMWebView> webRef;
    
    MyWebChromeClient(MMWebView paramMMWebView)
    {
      this.webRef = new WeakReference(paramMMWebView);
    }
    
    private String getApplicationName(Context paramContext)
    {
      PackageManager localPackageManager = paramContext.getApplicationContext().getPackageManager();
      try
      {
        paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0);
        if (paramContext != null)
        {
          paramContext = localPackageManager.getApplicationLabel(paramContext);
          return (String)paramContext;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;)
        {
          paramContext = null;
          continue;
          paramContext = "This app";
        }
      }
    }
    
    private boolean isFirstGeoRequest()
    {
      boolean bool2 = false;
      MMWebView localMMWebView = (MMWebView)this.webRef.get();
      boolean bool1 = bool2;
      if (localMMWebView != null)
      {
        bool1 = bool2;
        if (!localMMWebView.getContext().getSharedPreferences("MillennialMediaSettings", 0).contains("mm_use_geo_location")) {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    private boolean retrieveUseGeo()
    {
      boolean bool = false;
      MMWebView localMMWebView = (MMWebView)this.webRef.get();
      if (localMMWebView != null) {
        bool = localMMWebView.getContext().getSharedPreferences("MillennialMediaSettings", 0).getBoolean("mm_use_geo_location", false);
      }
      return bool;
    }
    
    private void saveUseGeo(boolean paramBoolean)
    {
      Object localObject = (MMWebView)this.webRef.get();
      if (localObject != null)
      {
        localObject = ((MMWebView)localObject).getContext().getSharedPreferences("MillennialMediaSettings", 0).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("mm_use_geo_location", paramBoolean);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
    
    public void onConsoleMessage(String paramString1, int paramInt, String paramString2)
    {
      super.onConsoleMessage(paramString1, paramInt, paramString2);
    }
    
    public void onGeolocationPermissionsShowPrompt(final String paramString, final GeolocationPermissions.Callback paramCallback)
    {
      if (isFirstGeoRequest())
      {
        if (retrieveUseGeo()) {
          paramCallback.invoke(paramString, true, true);
        }
        Object localObject;
        do
        {
          do
          {
            return;
            localObject = (MMWebView)this.webRef.get();
          } while (localObject == null);
          localObject = ((MMWebView)localObject).getActivity();
        } while (localObject == null);
        AlertDialog.Builder localBuilder = new AlertDialog.Builder((Context)localObject);
        localBuilder.setTitle(getApplicationName((Context)localObject));
        localBuilder.setMessage("Would like to use your Current Location.").setPositiveButton("Allow", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            MMWebView.MyWebChromeClient.this.saveUseGeo(true);
            paramCallback.invoke(paramString, true, true);
          }
        }).setNegativeButton("Don't Allow", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            MMWebView.MyWebChromeClient.this.saveUseGeo(false);
            paramCallback.invoke(paramString, false, false);
          }
        });
        localBuilder.create().show();
        return;
      }
      paramCallback.invoke(paramString, false, false);
    }
    
    public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      MMWebView localMMWebView = (MMWebView)this.webRef.get();
      if (localMMWebView != null)
      {
        if (localMMWebView.getContext() != localMMWebView.getContext().getApplicationContext()) {
          return super.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
        }
        Toast.makeText(localMMWebView.getContext(), paramString2, 0).show();
      }
      return true;
    }
    
    public boolean onJsBeforeUnload(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      MMWebView localMMWebView = (MMWebView)this.webRef.get();
      if (localMMWebView != null)
      {
        if (localMMWebView.getContext() != localMMWebView.getContext().getApplicationContext()) {
          return super.onJsBeforeUnload(paramWebView, paramString1, paramString2, paramJsResult);
        }
        Toast.makeText(localMMWebView.getContext(), paramString2, 0).show();
      }
      return true;
    }
    
    public boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      MMWebView localMMWebView = (MMWebView)this.webRef.get();
      if (localMMWebView != null)
      {
        if (localMMWebView.getContext() != localMMWebView.getContext().getApplicationContext()) {
          return super.onJsConfirm(paramWebView, paramString1, paramString2, paramJsResult);
        }
        Toast.makeText(localMMWebView.getContext(), paramString2, 0).show();
      }
      return true;
    }
    
    public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
    {
      MMWebView localMMWebView = (MMWebView)this.webRef.get();
      if (localMMWebView != null)
      {
        if (localMMWebView.getContext() != localMMWebView.getContext().getApplicationContext()) {
          return super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
        }
        Toast.makeText(localMMWebView.getContext(), paramString2, 0).show();
      }
      return true;
    }
  }
  
  private static class WebGestureListener
    extends GestureDetector.SimpleOnGestureListener
  {
    WeakReference<MMWebView> webRef;
    
    public WebGestureListener(MMWebView paramMMWebView)
    {
      this.webRef = new WeakReference(paramMMWebView);
    }
    
    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      paramMotionEvent = (MMWebView)this.webRef.get();
      if (paramMotionEvent != null) {
        MMSDK.Event.adSingleTap(MMAdImplController.getAdImplWithId(paramMotionEvent.creatorAdImplId));
      }
      return false;
    }
  }
  
  private static class WebTouchListener
    implements View.OnTouchListener
  {
    WeakReference<MMWebView> webRef;
    
    WebTouchListener(MMWebView paramMMWebView)
    {
      this.webRef = new WeakReference(paramMMWebView);
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      paramView = (MMWebView)this.webRef.get();
      if (paramMotionEvent.getAction() == 2) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        boolean bool2 = bool1;
        if (paramView != null)
        {
          if ((!bool1) || (!paramView.canScroll())) {
            break;
          }
          bool2 = true;
        }
        return bool2;
      }
      return false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/millennialmedia/android/MMWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */