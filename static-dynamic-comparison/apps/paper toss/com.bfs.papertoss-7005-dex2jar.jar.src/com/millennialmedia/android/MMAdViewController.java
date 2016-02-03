package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

class MMAdViewController
  implements AdCache.AdCacheTaskListener, HttpRedirection.Listener
{
  private static final HashMap<Long, MMAdViewController> controllers = new HashMap();
  private static String overrideAdURL;
  String adUrl;
  WeakReference<MMAdView> adViewRef;
  private boolean appPaused;
  private Handler cacheHandler = new Handler(Looper.getMainLooper());
  private Handler handler;
  String nextUrl;
  private boolean paused = true;
  private boolean refreshTimerOn;
  boolean requestInProgress;
  private Runnable runnable = new Runnable()
  {
    public void run()
    {
      MMAdView localMMAdView = (MMAdView)MMAdViewController.this.adViewRef.get();
      if (localMMAdView == null)
      {
        MMAdViewSDK.Log.e("The reference to the ad view was broken.");
        return;
      }
      MMAdViewController.this.requestAd(new MMAdView.Request(localMMAdView.apid, null, false));
      MMAdViewController.this.handler.postDelayed(this, localMMAdView.refreshInterval * 1000);
    }
  };
  OverlaySettings settings = new OverlaySettings();
  private long timeRemaining;
  private long timeResumed;
  private String urlString;
  private String useragent;
  private WebView webView;
  
  private MMAdViewController(MMAdView paramMMAdView)
  {
    this.adViewRef = new WeakReference(paramMMAdView);
    this.webView = new WebView(paramMMAdView.getContext().getApplicationContext());
    this.webView.getSettings().setJavaScriptEnabled(true);
    this.webView.getSettings().setCacheMode(2);
    this.webView.setBackgroundColor(0);
    this.webView.setWillNotDraw(false);
    this.webView.addJavascriptInterface(new MMJSInterface(null), "interface");
    this.webView.setId(15063);
    this.useragent = (this.webView.getSettings().getUserAgentString() + Build.MODEL);
    this.settings.isBannerAd = true;
  }
  
  static void assignAdViewController(MMAdView paramMMAdView)
  {
    int i = 1;
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = paramMMAdView.controller;
        if (localObject != null) {
          return;
        }
        if ((paramMMAdView.getId() == -1) && (!paramMMAdView.isInterstitial())) {
          MMAdViewSDK.Log.w("MMAdView created without a view id. Performance may be affected.");
        }
        if (paramMMAdView.getWindowToken() != null)
        {
          MMAdViewController localMMAdViewController = (MMAdViewController)controllers.get(paramMMAdView.adViewId);
          localObject = localMMAdViewController;
          if (localMMAdViewController == null)
          {
            localObject = new MMAdViewController(paramMMAdView);
            controllers.put(paramMMAdView.adViewId, localObject);
            i = 0;
          }
          ((MMAdViewController)localObject).adViewRef = new WeakReference(paramMMAdView);
          paramMMAdView.controller = ((MMAdViewController)localObject);
          if (((MMAdViewController)localObject).webView.getParent() != null) {
            ((ViewGroup)((MMAdViewController)localObject).webView.getParent()).removeView(((MMAdViewController)localObject).webView);
          }
          paramMMAdView.addView(((MMAdViewController)localObject).webView, new ViewGroup.LayoutParams(-1, -1));
          if ((paramMMAdView.refreshInterval < 0) || (paramMMAdView.refreshInterval >= 15)) {
            break label252;
          }
          ((MMAdViewController)localObject).refreshTimerOn = false;
          MMAdViewSDK.Log.d("Refresh interval is %d. Change to at least %s to refresh ads.", new Object[] { Integer.valueOf(paramMMAdView.refreshInterval), Integer.valueOf(15) });
          if ((paramMMAdView.refreshInterval < 0) || (i != 0)) {
            continue;
          }
          ((MMAdViewController)localObject).requestAd(new MMAdView.Request(paramMMAdView.apid, null, false));
          continue;
        }
        localObject = new MMAdViewController(paramMMAdView);
      }
      finally {}
      MMAdViewSDK.Log.w("MMAdView not attached to a window. Performance may be affected.");
      continue;
      label252:
      if (paramMMAdView.refreshInterval < 0)
      {
        ((MMAdViewController)localObject).refreshTimerOn = false;
        MMAdViewSDK.Log.d("Automatic ad fetching is off with %d. You must manually call for ads.", new Object[] { Integer.valueOf(paramMMAdView.refreshInterval) });
      }
      else
      {
        ((MMAdViewController)localObject).refreshTimerOn = true;
        ((MMAdViewController)localObject).resumeTimer(false);
      }
    }
  }
  
  private void getAdType(String paramString, TreeMap<String, String> paramTreeMap)
  {
    if ((paramString != null) && ((paramString.equals("MMBannerAdTop")) || (paramString.equals("MMBannerAdBottom")) || (paramString.equals("MMBannerAdRectangle")) || (paramString.equals("MMFullScreenAdLaunch")) || (paramString.equals("MMFullScreenAdTransition"))))
    {
      paramTreeMap.put("adtype", paramString);
      return;
    }
    MMAdViewSDK.Log.e("******* ERROR: INCORRECT AD TYPE IN MMADVIEW OBJECT PARAMETERS (" + paramString + ") **********");
    MMAdViewSDK.Log.e("******* SDK DEFAULTED TO MMBannerAdBottom. THIS MAY AFFECT THE ADS YOU RECIEVE!!! **********");
    paramTreeMap.put("adtype", "MMBannerAdBottom");
  }
  
  /* Error */
  static MMAdView getAdViewWithId(Long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 61	com/millennialmedia/android/MMAdViewController:controllers	Ljava/util/HashMap;
    //   6: aload_0
    //   7: invokevirtual 220	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 2	com/millennialmedia/android/MMAdViewController
    //   13: astore_0
    //   14: aload_0
    //   15: ifnull +19 -> 34
    //   18: aload_0
    //   19: getfield 96	com/millennialmedia/android/MMAdViewController:adViewRef	Ljava/lang/ref/WeakReference;
    //   22: invokevirtual 319	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   25: checkcast 100	com/millennialmedia/android/MMAdView
    //   28: astore_0
    //   29: ldc 2
    //   31: monitorexit
    //   32: aload_0
    //   33: areturn
    //   34: aconst_null
    //   35: astore_0
    //   36: goto -7 -> 29
    //   39: astore_0
    //   40: ldc 2
    //   42: monitorexit
    //   43: aload_0
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	paramLong	Long
    // Exception table:
    //   from	to	target	type
    //   3	14	39	finally
    //   18	29	39	finally
  }
  
  static void getUrlAdMetaValues(MMAdView paramMMAdView, Map<String, String> paramMap)
  {
    Context localContext = paramMMAdView.getContext();
    if (paramMMAdView.acid != null) {
      paramMap.put("acid", paramMMAdView.acid);
    }
    if (paramMMAdView.mxsdk != null) {
      paramMap.put("mxsdk", paramMMAdView.mxsdk);
    }
    if (paramMMAdView.height != null) {
      paramMap.put("hsht", paramMMAdView.height);
    }
    if (paramMMAdView.width != null) {
      paramMap.put("hswd", paramMMAdView.width);
    }
    if ((paramMMAdView.controller != null) && (paramMMAdView.controller.refreshTimerOn)) {
      paramMap.put("ar", Integer.toString(paramMMAdView.refreshInterval));
    }
    while (HandShake.sharedHandShake(localContext).canRequestVideo(localContext, paramMMAdView.adType))
    {
      paramMap.put("video", "true");
      return;
      paramMap.put("ar", "manual");
    }
    paramMap.put("video", "false");
  }
  
  static void getUrlCommonValues(Context paramContext, Map<String, String> paramMap)
  {
    paramMap.put("accelerometer", MMAdViewSDK.hasAccelerometer(paramContext));
    Object localObject = paramContext.getResources().getDisplayMetrics();
    paramMap.put("density", Float.toString(((DisplayMetrics)localObject).density));
    paramMap.put("hpx", Integer.toString(((DisplayMetrics)localObject).heightPixels));
    paramMap.put("wpx", Integer.toString(((DisplayMetrics)localObject).widthPixels));
    if ((paramContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == -1) || ((Build.VERSION.SDK.equalsIgnoreCase("8")) && (!Environment.getExternalStorageState().equals("mounted")))) {
      paramMap.put("cachedvideo", "false");
    }
    for (;;)
    {
      localObject = MMAdViewSDK.getAuidOrHdid(paramContext);
      if (localObject != null)
      {
        if (((String)localObject).startsWith("mmh_")) {
          paramMap.put("hdid", localObject);
        }
      }
      else
      {
        label151:
        if (Build.MODEL != null) {
          paramMap.put("dm", Build.MODEL);
        }
        if (Build.VERSION.RELEASE != null) {
          paramMap.put("dv", "Android" + Build.VERSION.RELEASE);
        }
        localObject = MMAdViewSDK.getMMdid(paramContext);
        if (localObject != null) {
          paramMap.put("mmdid", localObject);
        }
        paramMap.put("mmisdk", "4.6.0-12.07.16.a");
        localObject = Locale.getDefault();
        if (localObject != null)
        {
          paramMap.put("language", ((Locale)localObject).getLanguage());
          paramMap.put("country", ((Locale)localObject).getCountry());
        }
      }
      try
      {
        paramMap.put("pkid", paramContext.getPackageName());
        localObject = paramContext.getPackageManager();
        paramMap.put("pknm", ((PackageManager)localObject).getApplicationLabel(((PackageManager)localObject).getApplicationInfo(paramContext.getPackageName(), 0)).toString());
        if (MMAdViewSDK.debugMode) {
          paramMap.put("debug", "true");
        }
        if (MMAdViewSDK.demographic != null) {
          MMAdViewSDK.demographic.getUrlParams(paramMap);
        }
        localObject = HandShake.sharedHandShake(paramContext).getSchemesList(paramContext);
        if (localObject != null) {
          paramMap.put("appsids", localObject);
        }
        localObject = AdCache.getCachedVideoList(paramContext);
        if (localObject != null) {
          paramMap.put("vid", localObject);
        }
        for (;;)
        {
          try
          {
            String str2 = MMAdViewSDK.getConnectionType(paramContext);
            if (!Environment.getExternalStorageState().equals("mounted")) {
              continue;
            }
            localObject = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            String str3 = Long.toString(((StatFs)localObject).getAvailableBlocks() * ((StatFs)localObject).getBlockSize());
            localObject = null;
            String str1 = null;
            Intent localIntent = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            paramContext = str1;
            if (localIntent != null)
            {
              if (localIntent.getIntExtra("plugged", 0) != 0) {
                continue;
              }
              paramContext = "false";
              float f = 100.0F / localIntent.getIntExtra("scale", 100);
              str1 = Integer.toString((int)(localIntent.getIntExtra("level", 0) * f));
              localObject = paramContext;
              paramContext = str1;
            }
            if ((paramContext != null) && (paramContext.length() > 0)) {
              paramMap.put("bl", paramContext);
            }
            if ((localObject != null) && (((String)localObject).length() > 0)) {
              paramMap.put("plugged", localObject);
            }
            if (str3.length() > 0) {
              paramMap.put("space", str3);
            }
            if (str2 != null) {
              paramMap.put("conn", str2);
            }
          }
          catch (Exception paramContext)
          {
            MMAdViewSDK.Log.v(paramContext);
            continue;
            paramMap.put("loc", "false");
            return;
          }
          if (MMAdViewSDK.location == null) {
            continue;
          }
          paramMap.put("lat", Double.toString(MMAdViewSDK.location.getLatitude()));
          paramMap.put("long", Double.toString(MMAdViewSDK.location.getLongitude()));
          if (MMAdViewSDK.location.hasAccuracy())
          {
            paramMap.put("ha", Float.toString(MMAdViewSDK.location.getAccuracy()));
            paramMap.put("va", Float.toString(MMAdViewSDK.location.getAccuracy()));
          }
          if (MMAdViewSDK.location.hasSpeed()) {
            paramMap.put("spd", Float.toString(MMAdViewSDK.location.getSpeed()));
          }
          if (MMAdViewSDK.location.hasBearing()) {
            paramMap.put("brg", Float.toString(MMAdViewSDK.location.getBearing()));
          }
          if (MMAdViewSDK.location.hasAltitude()) {
            paramMap.put("alt", Double.toString(MMAdViewSDK.location.getAltitude()));
          }
          paramMap.put("tslr", Long.toString(MMAdViewSDK.location.getTime()));
          paramMap.put("loc", "true");
          return;
          paramMap.put("cachedvideo", "true");
          break;
          paramMap.put("auid", localObject);
          break label151;
          localObject = new StatFs(paramContext.getCacheDir().getPath());
          continue;
          paramContext = "true";
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  static void removeAdViewController(MMAdView paramMMAdView, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        localMMAdViewController = paramMMAdView.controller;
        if (localMMAdViewController == null) {
          return;
        }
        if (paramMMAdView.getWindowToken() == null) {
          break label99;
        }
        if (paramBoolean)
        {
          localMMAdViewController = (MMAdViewController)controllers.put(paramMMAdView.adViewId, null);
          paramMMAdView.controller = null;
          if (localMMAdViewController == null) {
            continue;
          }
          localMMAdViewController.pauseTimer(false);
          if (paramBoolean) {
            localMMAdViewController.handler = null;
          }
          paramMMAdView.removeView(localMMAdViewController.webView);
          continue;
        }
        localMMAdViewController = (MMAdViewController)controllers.get(paramMMAdView.adViewId);
      }
      finally {}
      continue;
      label99:
      MMAdViewController localMMAdViewController = paramMMAdView.controller;
    }
  }
  
  static void setAdURL(Context paramContext, String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        overrideAdURL = paramString + "getAd.php5?";
        return;
      }
      finally {}
      overrideAdURL = "http://androidsdk.ads.mp.mydas.mobi/getAd.php5?";
    }
  }
  
  int check(MMAdView paramMMAdView)
  {
    CachedAd localCachedAd = AdCache.loadNextCachedAd(paramMMAdView.getContext(), paramMMAdView.getCachedName());
    if (localCachedAd != null)
    {
      if (localCachedAd.canShow(paramMMAdView.getContext(), paramMMAdView, true)) {
        return 0;
      }
      return checkReason(paramMMAdView, localCachedAd);
    }
    MMAdViewSDK.Log.i("No next ad.");
    return 20;
  }
  
  int checkReason(MMAdView paramMMAdView, CachedAd paramCachedAd)
  {
    if (paramCachedAd.isExpired())
    {
      MMAdViewSDK.Log.d("%s is expired.", new Object[] { paramCachedAd.id });
      return 21;
    }
    if (!paramCachedAd.isOnDisk(paramMMAdView.getContext()))
    {
      MMAdViewSDK.Log.d("%s is not on disk.", new Object[] { paramCachedAd.id });
      return 22;
    }
    if (!HandShake.sharedHandShake(paramMMAdView.getContext()).canDisplayCachedAd(paramMMAdView.adType, paramCachedAd.deferredViewStart))
    {
      MMAdViewSDK.Log.d("%s cannot be shown at this time.", new Object[] { paramCachedAd.id });
      return 24;
    }
    return 100;
  }
  
  public void didFailToResolveUri(Uri paramUri) {}
  
  int display(MMAdView paramMMAdView)
  {
    CachedAd localCachedAd = AdCache.loadNextCachedAd(paramMMAdView.getContext(), paramMMAdView.getCachedName());
    if (localCachedAd != null)
    {
      if (localCachedAd.canShow(paramMMAdView.getContext(), paramMMAdView, true))
      {
        MMAdViewSDK.Event.displayStarted(paramMMAdView.getContext(), paramMMAdView);
        AdCache.setNextCachedAd(paramMMAdView.getContext(), paramMMAdView.getCachedName(), null);
        localCachedAd.show(paramMMAdView.getContext(), paramMMAdView);
        HandShake.sharedHandShake(paramMMAdView.getContext()).updateLastVideoViewedTime(paramMMAdView.getContext(), paramMMAdView.adType);
        return 0;
      }
      return checkReason(paramMMAdView, localCachedAd);
    }
    return 20;
  }
  
  public void downloadCompleted(CachedAd paramCachedAd, boolean paramBoolean)
  {
    MMAdView localMMAdView = (MMAdView)this.adViewRef.get();
    if (localMMAdView == null)
    {
      MMAdViewSDK.Log.e("The reference to the ad view was broken.");
      return;
    }
    if (paramBoolean) {
      AdCache.setNextCachedAd(localMMAdView.getContext(), localMMAdView.getCachedName(), paramCachedAd.id);
    }
    if (paramBoolean)
    {
      MMAdViewSDK.Event.fetchFinishedCaching(localMMAdView.getContext(), localMMAdView, paramCachedAd.request);
      return;
    }
    MMAdViewSDK.Event.fetchFailed(localMMAdView.getContext(), localMMAdView, paramCachedAd.request, new MMError(15));
  }
  
  void fetch(MMAdView.Request paramRequest)
  {
    for (;;)
    {
      MMAdView localMMAdView;
      Context localContext;
      try
      {
        localMMAdView = (MMAdView)this.adViewRef.get();
        if (localMMAdView == null)
        {
          MMAdViewSDK.Log.e("The reference to the ad view was broken.");
          return;
        }
        localContext = localMMAdView.getContext();
        if (HandShake.sharedHandShake(localContext).kill)
        {
          MMAdViewSDK.Log.i("The server is no longer allowing ads.");
          MMAdViewSDK.Event.requestFailed(localContext, localMMAdView, paramRequest, new MMError(16));
          continue;
        }
        if (!this.requestInProgress) {
          break label101;
        }
      }
      finally {}
      MMAdViewSDK.Log.i("There is already an ad request in progress. Defering call for new ad");
      MMAdViewSDK.Event.requestFailed(localContext, localMMAdView, paramRequest, new MMError(12));
      continue;
      label101:
      if (HandShake.sharedHandShake(localContext).isAdTypeDownloading(localMMAdView.adType))
      {
        MMAdViewSDK.Log.i("There is a download in progress. Defering call for new ad");
        MMAdViewSDK.Event.requestFailed(localContext, localMMAdView, paramRequest, new MMError(12));
      }
      else
      {
        MMAdViewSDK.Log.d("No download in progress.");
        CachedAd localCachedAd = AdCache.loadIncompleteDownload(localMMAdView.getContext(), localMMAdView.getCachedName());
        if (localCachedAd != null)
        {
          MMAdViewSDK.Log.i("Last ad wasn't fully downloaded. Download again.");
          MMAdViewSDK.Event.fetchStartedCaching(localContext, localMMAdView);
          localCachedAd.request = paramRequest;
          AdCache.startDownloadTask(localMMAdView.getContext(), localMMAdView.getCachedName(), localCachedAd, this);
        }
        else
        {
          MMAdViewSDK.Log.i("No incomplete downloads.");
          requestAd(paramRequest);
        }
      }
    }
  }
  
  void handleClick(String paramString)
  {
    MMAdViewSDK.Log.d("Touch occured, opening ad...");
    if (paramString == null) {
      return;
    }
    MMAdView localMMAdView = (MMAdView)this.adViewRef.get();
    if (localMMAdView == null)
    {
      MMAdViewSDK.Log.e("The reference to the ad view was broken.");
      return;
    }
    Context localContext = localMMAdView.getContext();
    if (localContext == null)
    {
      MMAdViewSDK.Log.e("The ad view does not have a parent activity.");
      return;
    }
    HttpRedirection.startActivityFromUri(localContext, paramString, this.settings, this, localMMAdView.adType);
  }
  
  void loadUrl(String paramString)
  {
    this.webView.loadUrl(paramString);
  }
  
  void pauseTimer(boolean paramBoolean)
  {
    try
    {
      if (!this.refreshTimerOn) {
        return;
      }
      if (this.paused)
      {
        if (paramBoolean) {
          this.appPaused = true;
        }
        return;
      }
    }
    finally {}
    this.handler.removeCallbacks(this.runnable);
    this.timeRemaining = (SystemClock.uptimeMillis() - this.timeResumed);
    this.paused = true;
    this.appPaused = paramBoolean;
  }
  
  void requestAd(final MMAdView.Request paramRequest)
  {
    this.requestInProgress = true;
    new Thread()
    {
      public void run()
      {
        MMAdView localMMAdView = (MMAdView)MMAdViewController.this.adViewRef.get();
        if (localMMAdView == null)
        {
          MMAdViewSDK.Log.e("The reference to the ad view was broken.");
          MMAdViewController.this.requestInProgress = false;
          return;
        }
        if (paramRequest.apid == null)
        {
          MMAdViewSDK.Event.requestFailed(localMMAdView.getContext(), localMMAdView, paramRequest, new MMError(1));
          MMAdViewSDK.Log.e("MMAdView found with a null apid. New ad requests on this MMAdView are disabled until an apid has been assigned.");
          MMAdViewController.this.requestInProgress = false;
          return;
        }
        if (MMAdViewSDK.isConnected(localMMAdView.getContext())) {
          MMAdViewController.this.adUrl = null;
        }
        for (;;)
        {
          Object localObject3;
          try
          {
            localObject3 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            MMAdViewController.getUrlAdMetaValues(localMMAdView, (Map)localObject3);
            MMAdViewController.getUrlCommonValues(localMMAdView.getContext(), (Map)localObject3);
            MMAdViewController.this.getAdType(localMMAdView.adType, (TreeMap)localObject3);
            if (MMAdViewController.this.useragent != null)
            {
              ((TreeMap)localObject3).put("ua", MMAdViewController.this.useragent);
              if (!paramRequest.fetch) {
                ((TreeMap)localObject3).put("cachedvideo", "false");
              }
              ((TreeMap)localObject3).put("sdkapid", paramRequest.apid);
              if (!paramRequest.fetch) {
                break label1731;
              }
              Object localObject1 = "fetch";
              ((TreeMap)localObject3).put("reqtype", localObject1);
              if (MMAdViewController.overrideAdURL != null) {
                break label379;
              }
              localObject1 = "http://androidsdk.ads.mp.mydas.mobi/getAd.php5?";
              localObject1 = new StringBuilder((String)localObject1);
              localObject3 = ((TreeMap)localObject3).entrySet().iterator();
              if (!((Iterator)localObject3).hasNext()) {
                break label387;
              }
              localObject4 = (Map.Entry)((Iterator)localObject3).next();
              ((StringBuilder)localObject1).append(String.format("%s=%s&", new Object[] { ((Map.Entry)localObject4).getKey(), URLEncoder.encode((String)((Map.Entry)localObject4).getValue(), "UTF-8") }));
              continue;
            }
            ((TreeMap)localObject3).put("ua", "UNKNOWN");
          }
          catch (Exception localException1)
          {
            MMAdViewSDK.Log.e(localException1);
            MMAdViewController.this.requestInProgress = false;
            MMAdViewSDK.Event.requestFailed(localMMAdView.getContext(), localMMAdView, paramRequest, new MMError(localException1));
            return;
          }
          continue;
          label379:
          String str1 = MMAdViewController.overrideAdURL;
          continue;
          label387:
          str1.delete(str1.length() - 1, str1.length());
          MMAdViewController.this.adUrl = str1.toString();
          MMAdViewSDK.Log.d("Calling for an advertisement: %s", new Object[] { MMAdViewController.this.adUrl });
          try
          {
            localObject3 = new HttpGetRequest().get(MMAdViewController.this.adUrl);
            if (localObject3 == null)
            {
              MMAdViewSDK.Log.e("HTTP response is null");
              MMAdViewController.this.requestInProgress = false;
              MMAdViewSDK.Event.requestFailed(localMMAdView.getContext(), localMMAdView, paramRequest, new MMError(14));
              return;
            }
          }
          catch (Exception localException2)
          {
            MMAdViewSDK.Log.e("Ad request HTTP error. %s", new Object[] { localException2.getMessage() });
            MMAdViewController.this.requestInProgress = false;
            MMAdViewSDK.Event.requestFailed(localMMAdView.getContext(), localMMAdView, paramRequest, new MMError(localException2));
            return;
          }
          Object localObject2 = ((HttpResponse)localObject3).getEntity();
          if (localObject2 == null)
          {
            MMAdViewSDK.Log.i("Null HTTP entity");
            MMAdViewController.this.requestInProgress = false;
            MMAdViewSDK.Event.requestFailed(localMMAdView.getContext(), localMMAdView, paramRequest, new MMError(14));
            return;
          }
          if (((HttpEntity)localObject2).getContentLength() == 0L)
          {
            MMAdViewSDK.Log.i("Millennial ad return failed. Zero content length returned.");
            MMAdViewController.this.requestInProgress = false;
            MMAdViewSDK.Event.requestFailed(localMMAdView.getContext(), localMMAdView, paramRequest, new MMError(14));
            return;
          }
          Object localObject4 = ((HttpResponse)localObject3).getHeaders("Set-Cookie");
          int j = localObject4.length;
          int i = 0;
          Object localObject5;
          while (i < j)
          {
            localObject5 = localObject4[i].getValue();
            int k = ((String)localObject5).indexOf("MAC-ID=");
            if (k >= 0)
            {
              int m = ((String)localObject5).indexOf(';', k);
              if (m > k) {
                MMAdViewSDK.macId = ((String)localObject5).substring(k + 7, m);
              }
            }
            i += 1;
          }
          localObject4 = ((HttpEntity)localObject2).getContentType();
          if (localObject4 != null) {
            if (((Header)localObject4).getValue() != null) {
              if (((Header)localObject4).getValue().equalsIgnoreCase("application/json")) {
                if (!paramRequest.fetch)
                {
                  MMAdViewSDK.Log.e("Millennial ad return unsupported format.");
                  MMAdViewController.this.requestInProgress = false;
                  MMAdViewSDK.Event.requestFailed(localMMAdView.getContext(), localMMAdView, paramRequest, new MMError(15));
                  return;
                }
              }
            }
          }
          for (;;)
          {
            try
            {
              localObject2 = (VideoAd)CachedAd.parseJSON(HttpGetRequest.convertStreamToString(((HttpEntity)localObject2).getContent()));
              if ((localObject2 != null) && (((VideoAd)localObject2).isValid()))
              {
                MMAdViewSDK.Log.i("Cached video ad JSON received: " + ((VideoAd)localObject2).id);
                if (((VideoAd)localObject2).isExpired())
                {
                  MMAdViewSDK.Log.i("New ad has expiration date in the past. Not downloading ad content.");
                  ((VideoAd)localObject2).delete(localMMAdView.getContext());
                  MMAdViewSDK.Event.requestFailed(localMMAdView.getContext(), localMMAdView, paramRequest, new MMError(15));
                }
              }
              else
              {
                MMAdViewController.this.requestInProgress = false;
                return;
              }
            }
            catch (IllegalStateException localIllegalStateException)
            {
              localIllegalStateException.printStackTrace();
              MMAdViewSDK.Log.i("Millennial ad return failed. Invalid response data.");
              MMAdViewController.this.requestInProgress = false;
              MMAdViewSDK.Event.requestFailed(localMMAdView.getContext(), localMMAdView, paramRequest, new MMError(localIllegalStateException));
              return;
            }
            catch (IOException localIOException1)
            {
              localIOException1.printStackTrace();
              MMAdViewSDK.Log.i("Millennial ad return failed. %s", new Object[] { localIOException1.getMessage() });
              MMAdViewController.this.requestInProgress = false;
              MMAdViewSDK.Event.requestFailed(localMMAdView.getContext(), localMMAdView, paramRequest, new MMError(localIOException1));
              return;
            }
            if (AdCache.loadNextCachedAd(localMMAdView.getContext(), localMMAdView.getCachedName()) != null)
            {
              MMAdViewSDK.Log.i("Previously fetched ad exists in the playback queue. Not downloading ad content.");
              localIOException1.delete(localMMAdView.getContext());
              MMAdViewSDK.Event.requestFailed(localMMAdView.getContext(), localMMAdView, paramRequest, new MMError(17));
            }
            else
            {
              AdCache.save(localMMAdView.getContext(), localIOException1);
              if (!localIOException1.isOnDisk(localMMAdView.getContext()))
              {
                MMAdViewSDK.Log.d("Downloading ad...");
                MMAdViewSDK.Event.fetchStartedCaching(localMMAdView.getContext(), localMMAdView);
                localIOException1.downloadPriority = 3;
                localIOException1.request = paramRequest;
                AdCache.startDownloadTask(localMMAdView.getContext(), localMMAdView.getCachedName(), localIOException1, MMAdViewController.this);
              }
              else
              {
                MMAdViewSDK.Log.d("Cached ad is valid. Moving it to the front of the queue.");
                AdCache.setNextCachedAd(localMMAdView.getContext(), localMMAdView.getCachedName(), localIOException1.id);
                MMAdViewSDK.Event.fetchStartedCaching(localMMAdView.getContext(), localMMAdView);
                MMAdViewSDK.Event.fetchFinishedCaching(localMMAdView.getContext(), localMMAdView, paramRequest);
                continue;
                if (((Header)localObject4).getValue().equalsIgnoreCase("text/html"))
                {
                  localObject3 = ((HttpResponse)localObject3).getFirstHeader("X-MM-Video");
                  if ((localObject3 != null) && (((Header)localObject3).getValue().equalsIgnoreCase("true")))
                  {
                    localObject3 = localMMAdView.getContext();
                    HandShake.sharedHandShake((Context)localObject3).updateLastVideoViewedTime((Context)localObject3, localMMAdView.adType);
                  }
                  try
                  {
                    if (!paramRequest.fetch) {
                      break label1499;
                    }
                    localObject3 = new InterstitialAd();
                    ((InterstitialAd)localObject3).content = HttpGetRequest.convertStreamToString(localIOException1.getContent());
                    ((InterstitialAd)localObject3).id = localMMAdView.adType;
                    ((InterstitialAd)localObject3).baseUrl = MMAdViewController.this.adUrl.substring(0, MMAdViewController.this.adUrl.lastIndexOf("/") + 1);
                    if (MMAdViewSDK.logLevel >= 4)
                    {
                      MMAdViewSDK.Log.v("Received interstitial ad with base url %s.", new Object[] { ((InterstitialAd)localObject3).baseUrl });
                      MMAdViewSDK.Log.v(((InterstitialAd)localObject3).content);
                    }
                    AdCache.save(localMMAdView.getContext(), (CachedAd)localObject3);
                    AdCache.setNextCachedAd(localMMAdView.getContext(), localMMAdView.getCachedName(), ((InterstitialAd)localObject3).id);
                    MMAdViewSDK.Event.fetchStartedCaching(localMMAdView.getContext(), localMMAdView);
                    MMAdViewSDK.Event.fetchFinishedCaching(localMMAdView.getContext(), localMMAdView, paramRequest);
                  }
                  catch (IOException localIOException2)
                  {
                    MMAdViewSDK.Log.e("Exception raised in HTTP stream: ", new Object[] { localIOException2 });
                    MMAdViewSDK.Event.requestFailed(localMMAdView.getContext(), localMMAdView, paramRequest, new MMError(localIOException2));
                  }
                  continue;
                  label1499:
                  MMAdViewController.this.settings.adUrl = MMAdViewController.this.adUrl;
                  localObject3 = MMAdViewController.this;
                  str2 = HttpGetRequest.convertStreamToString(localIOException2.getContent());
                  localObject4 = MMAdViewController.this.adUrl.substring(0, MMAdViewController.this.adUrl.lastIndexOf("/") + 1);
                  localObject5 = paramRequest;
                  if (localMMAdView.transitionType != 0) {}
                  for (boolean bool = true;; bool = false)
                  {
                    ((MMAdViewController)localObject3).setWebViewContent(str2, (String)localObject4, localMMAdView, (MMAdView.Request)localObject5, bool);
                    break;
                  }
                }
                else
                {
                  MMAdViewSDK.Log.i("Millennial ad return failed. Invalid mime type returned.");
                  MMAdViewSDK.Event.requestFailed(localMMAdView.getContext(), localMMAdView, paramRequest, new MMError(15));
                  continue;
                  MMAdViewSDK.Log.i("Millennial ad return failed. HTTP Header value null.");
                  MMAdViewSDK.Event.requestFailed(localMMAdView.getContext(), localMMAdView, paramRequest, new MMError(15));
                  continue;
                  MMAdViewSDK.Log.i("Millennial ad return failed. HTTP Header is null.");
                  MMAdViewSDK.Event.requestFailed(localMMAdView.getContext(), localMMAdView, paramRequest, new MMError(15));
                  continue;
                  MMAdViewSDK.Log.i("No network available, can't call for ads.");
                  MMAdViewSDK.Event.requestFailed(localMMAdView.getContext(), localMMAdView, paramRequest, new MMError(11));
                }
              }
            }
          }
          label1731:
          String str2 = "getad";
        }
      }
    }.start();
  }
  
  void resumeTimer(boolean paramBoolean)
  {
    try
    {
      if (!this.refreshTimerOn) {
        return;
      }
      if (!this.paused) {
        return;
      }
    }
    finally {}
    if ((this.appPaused) && (!paramBoolean)) {
      return;
    }
    MMAdView localMMAdView = (MMAdView)this.adViewRef.get();
    if (localMMAdView == null)
    {
      MMAdViewSDK.Log.e("The reference to the ad view was broken.");
      return;
    }
    if (this.handler == null) {
      this.handler = new Handler(Looper.getMainLooper());
    }
    if ((this.timeRemaining <= 0L) || (this.timeRemaining > localMMAdView.refreshInterval * 1000)) {
      this.timeRemaining = (localMMAdView.refreshInterval * 1000);
    }
    this.handler.postDelayed(this.runnable, this.timeRemaining);
    this.timeResumed = SystemClock.uptimeMillis();
    this.appPaused = false;
    this.paused = false;
  }
  
  /* Error */
  void setWebViewContent(final String paramString1, final String paramString2, final MMAdView paramMMAdView, final MMAdView.Request paramRequest, final boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_2
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: getstatic 850	com/millennialmedia/android/MMAdViewSDK:logLevel	I
    //   12: iconst_4
    //   13: if_icmplt +21 -> 34
    //   16: ldc_w 852
    //   19: iconst_1
    //   20: anewarray 4	java/lang/Object
    //   23: dup
    //   24: iconst_0
    //   25: aload_2
    //   26: aastore
    //   27: invokestatic 854	com/millennialmedia/android/MMAdViewSDK$Log:v	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aload_1
    //   31: invokestatic 856	com/millennialmedia/android/MMAdViewSDK$Log:v	(Ljava/lang/String;)V
    //   34: iload 5
    //   36: ifeq +30 -> 66
    //   39: new 12	com/millennialmedia/android/MMAdViewController$2
    //   42: dup
    //   43: aload_0
    //   44: aload_3
    //   45: invokespecial 859	com/millennialmedia/android/MMAdViewController$2:<init>	(Lcom/millennialmedia/android/MMAdViewController;Lcom/millennialmedia/android/MMAdView;)V
    //   48: astore 6
    //   50: aload 6
    //   52: monitorenter
    //   53: aload 6
    //   55: invokestatic 862	com/millennialmedia/android/MMAdViewSDK:runOnUiThread	(Ljava/lang/Runnable;)V
    //   58: aload 6
    //   60: invokevirtual 865	java/lang/Object:wait	()V
    //   63: aload 6
    //   65: monitorexit
    //   66: new 14	com/millennialmedia/android/MMAdViewController$3
    //   69: dup
    //   70: aload_0
    //   71: aload_0
    //   72: getfield 84	com/millennialmedia/android/MMAdViewController:settings	Lcom/millennialmedia/android/OverlaySettings;
    //   75: iload 5
    //   77: aload 4
    //   79: aload_3
    //   80: invokespecial 868	com/millennialmedia/android/MMAdViewController$3:<init>	(Lcom/millennialmedia/android/MMAdViewController;Lcom/millennialmedia/android/OverlaySettings;ZLcom/millennialmedia/android/MMAdView$Request;Lcom/millennialmedia/android/MMAdView;)V
    //   83: astore 4
    //   85: aload_3
    //   86: getfield 871	com/millennialmedia/android/MMAdView:ignoreDensityScaling	Z
    //   89: ifeq +65 -> 154
    //   92: new 148	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   99: ldc_w 873
    //   102: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_1
    //   106: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: astore_1
    //   113: aload_0
    //   114: getfield 84	com/millennialmedia/android/MMAdViewController:settings	Lcom/millennialmedia/android/OverlaySettings;
    //   117: invokevirtual 876	com/millennialmedia/android/OverlaySettings:reset	()V
    //   120: aload_3
    //   121: iconst_0
    //   122: invokevirtual 879	com/millennialmedia/android/MMAdView:setClickable	(Z)V
    //   125: new 16	com/millennialmedia/android/MMAdViewController$4
    //   128: dup
    //   129: aload_0
    //   130: aload 4
    //   132: aload_2
    //   133: aload_1
    //   134: invokespecial 882	com/millennialmedia/android/MMAdViewController$4:<init>	(Lcom/millennialmedia/android/MMAdViewController;Landroid/webkit/WebViewClient;Ljava/lang/String;Ljava/lang/String;)V
    //   137: invokestatic 862	com/millennialmedia/android/MMAdViewSDK:runOnUiThread	(Ljava/lang/Runnable;)V
    //   140: return
    //   141: astore 7
    //   143: aload 6
    //   145: monitorexit
    //   146: aload 7
    //   148: athrow
    //   149: astore 6
    //   151: goto -85 -> 66
    //   154: goto -41 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	MMAdViewController
    //   0	157	1	paramString1	String
    //   0	157	2	paramString2	String
    //   0	157	3	paramMMAdView	MMAdView
    //   0	157	4	paramRequest	MMAdView.Request
    //   0	157	5	paramBoolean	boolean
    //   149	1	6	localInterruptedException	InterruptedException
    //   141	6	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   53	66	141	finally
    //   143	146	141	finally
    //   50	53	149	java/lang/InterruptedException
    //   146	149	149	java/lang/InterruptedException
  }
  
  public boolean shouldStartActivityForUri(Uri paramUri)
  {
    MMAdViewSDK.Log.d("Starting activity for %s", new Object[] { paramUri });
    if ((this.adViewRef != null) && ((paramUri.getScheme().equalsIgnoreCase("http")) || (paramUri.getScheme().equalsIgnoreCase("https"))))
    {
      paramUri = (MMAdView)this.adViewRef.get();
      if (paramUri != null) {
        MMAdViewSDK.Event.overlayOpened(paramUri.getContext(), paramUri);
      }
    }
    if (this.adViewRef != null)
    {
      paramUri = (MMAdView)this.adViewRef.get();
      if (paramUri != null)
      {
        paramUri = paramUri.getContext();
        if ((paramUri != null) && ((paramUri instanceof Activity)) && (((Activity)paramUri).isFinishing())) {
          return false;
        }
      }
    }
    return true;
  }
  
  void touchWebView(MotionEvent paramMotionEvent)
  {
    this.webView.onTouchEvent(paramMotionEvent);
  }
  
  private class MMJSInterface
  {
    private MMJSInterface() {}
    
    public void getUrl(String paramString)
    {
      MMAdViewController.this.nextUrl = paramString;
      MMAdViewSDK.Log.v("nextUrl: %s", new Object[] { MMAdViewController.this.nextUrl });
      if (MMAdViewController.this.nextUrl.toLowerCase().startsWith("mmvideo")) {
        MMAdViewController.this.settings.shouldLaunchToOverlay = true;
      }
    }
    
    public void log(String paramString)
    {
      MMAdViewSDK.Log.d(paramString);
    }
    
    public void overlayTitle(String paramString)
    {
      MMAdViewController.this.settings.overlayTitle = paramString;
    }
    
    public void overlayTransition(String paramString, long paramLong)
    {
      MMAdViewController.this.settings.overlayTransition = paramString;
      MMAdViewController.this.settings.transitionTime = paramLong;
    }
    
    public void shouldAccelerate(boolean paramBoolean)
    {
      if ((MMAdView)MMAdViewController.this.adViewRef.get() != null) {
        MMAdViewController.this.settings.canAccelerate = paramBoolean;
      }
    }
    
    public void shouldEnableBottomBar(boolean paramBoolean)
    {
      MMAdViewController.this.settings.shouldEnableBottomBar = paramBoolean;
    }
    
    public void shouldMakeOverlayTransparent(boolean paramBoolean)
    {
      MMAdViewController.this.settings.shouldMakeOverlayTransparent = paramBoolean;
    }
    
    public void shouldOpen(String paramString)
    {
      final MMAdView localMMAdView = (MMAdView)MMAdViewController.this.adViewRef.get();
      if (localMMAdView == null) {
        MMAdViewSDK.Log.e("The reference to the ad view was broken.");
      }
      do
      {
        return;
        MMAdViewController.this.settings.shouldLaunchToOverlay = true;
        MMAdViewController.this.handleClick(paramString);
      } while (localMMAdView.listener == null);
      MMAdViewSDK.runOnUiThread(new Runnable()
      {
        public void run()
        {
          try
          {
            localMMAdView.listener.MMAdOverlayLaunched(localMMAdView);
            return;
          }
          catch (Exception localException)
          {
            MMAdViewSDK.Log.w("Exception raised in your MMAdListener: ", new Object[] { localException });
          }
        }
      });
    }
    
    public void shouldOverlay(boolean paramBoolean)
    {
      MMAdViewController.this.settings.shouldLaunchToOverlay = paramBoolean;
    }
    
    public void shouldResizeOverlay(int paramInt)
    {
      MMAdViewController.this.settings.shouldResizeOverlay = paramInt;
    }
    
    public void shouldShowBottomBar(boolean paramBoolean)
    {
      MMAdViewController.this.settings.shouldShowBottomBar = paramBoolean;
    }
    
    public void shouldShowTitlebar(boolean paramBoolean)
    {
      MMAdViewController.this.settings.shouldShowTitlebar = paramBoolean;
    }
    
    public void vibrate(int paramInt)
    {
      MMAdView localMMAdView = (MMAdView)MMAdViewController.this.adViewRef.get();
      if (localMMAdView != null) {}
      try
      {
        ((Vibrator)localMMAdView.getContext().getSystemService("vibrator")).vibrate(paramInt);
        return;
      }
      catch (SecurityException localSecurityException)
      {
        MMAdViewSDK.Log.w("Advertisement is trying to use vibrator but permissions are missing.");
        return;
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/millennialmedia/android/MMAdViewController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */