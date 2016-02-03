package com.millennialmedia.android;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

class MMAdImplController
  implements AdCache.AdCacheTaskListener
{
  static final long NO_ID_RETURNED = -4L;
  private static final Map<Long, MMAdImplController> saveableControllers = new ConcurrentHashMap();
  private static final Map<Long, WeakReference<MMAdImplController>> weakUnsaveableAdRef = new ConcurrentHashMap();
  volatile WeakReference<MMAdImpl> adImplRef;
  volatile long linkedAdImplId;
  RequestAdRunnable requestAdRunnable;
  volatile MMWebView webView;
  
  private MMAdImplController(MMAdImpl paramMMAdImpl)
  {
    MMSDK.Log.d("**************** creating new controller.");
    this.adImplRef = new WeakReference(paramMMAdImpl);
    if (paramMMAdImpl.linkForExpansionId != 0L)
    {
      linkForExpansion(paramMMAdImpl);
      this.webView = getWebViewFromExistingAdImpl(paramMMAdImpl);
    }
    while ((paramMMAdImpl instanceof MMInterstitial.MMInterstitialAdImpl)) {
      return;
    }
    if (paramMMAdImpl.isBanner())
    {
      this.webView = new MMWebView(paramMMAdImpl.getContext().getApplicationContext(), paramMMAdImpl.internalId);
      this.webView.requiresPreAdSizeFix = true;
      return;
    }
    this.webView = new MMWebView(paramMMAdImpl.getContext(), paramMMAdImpl.internalId);
  }
  
  static void assignAdViewController(MMAdImpl paramMMAdImpl)
  {
    try
    {
      if (paramMMAdImpl.controller != null)
      {
        if (!saveableControllers.containsValue(paramMMAdImpl.controller))
        {
          if (!paramMMAdImpl.isLifecycleObservable()) {
            break label112;
          }
          saveableControllers.put(Long.valueOf(paramMMAdImpl.internalId), paramMMAdImpl.controller);
          if (weakUnsaveableAdRef.containsKey(Long.valueOf(paramMMAdImpl.internalId))) {
            weakUnsaveableAdRef.remove(Long.valueOf(paramMMAdImpl.internalId));
          }
        }
        for (;;)
        {
          MMSDK.Log.d(paramMMAdImpl + " - Has a controller");
          return;
          label112:
          if (!weakUnsaveableAdRef.containsKey(Long.valueOf(paramMMAdImpl.internalId))) {
            weakUnsaveableAdRef.put(Long.valueOf(paramMMAdImpl.internalId), new WeakReference(paramMMAdImpl.controller));
          }
        }
      }
      MMSDK.Log.d("*****************************************assignAdViewController for " + paramMMAdImpl);
    }
    finally {}
    MMAdImplController localMMAdImplController = (MMAdImplController)saveableControllers.get(Long.valueOf(paramMMAdImpl.internalId));
    Object localObject = localMMAdImplController;
    if (localMMAdImplController == null)
    {
      localObject = (WeakReference)weakUnsaveableAdRef.get(Long.valueOf(paramMMAdImpl.internalId));
      if (localObject != null) {
        localMMAdImplController = (MMAdImplController)((WeakReference)localObject).get();
      }
      localObject = localMMAdImplController;
      if (localMMAdImplController == null)
      {
        localObject = new MMAdImplController(paramMMAdImpl);
        if (!paramMMAdImpl.isLifecycleObservable()) {
          break label321;
        }
        saveableControllers.put(Long.valueOf(paramMMAdImpl.internalId), localObject);
      }
    }
    for (;;)
    {
      paramMMAdImpl.controller = ((MMAdImplController)localObject);
      ((MMAdImplController)localObject).adImplRef = new WeakReference(paramMMAdImpl);
      if ((((MMAdImplController)localObject).webView == null) || ((paramMMAdImpl instanceof MMInterstitial.MMInterstitialAdImpl))) {
        break;
      }
      setupWebView(paramMMAdImpl);
      break;
      label321:
      weakUnsaveableAdRef.put(Long.valueOf(paramMMAdImpl.internalId), new WeakReference(localObject));
    }
  }
  
  static boolean attachWebViewFromOverlay(MMAdImpl paramMMAdImpl)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramMMAdImpl == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      try
      {
        MMSDK.Log.d("attachWebViewFromOverlay with " + paramMMAdImpl);
        if ((paramMMAdImpl.controller != null) && (paramMMAdImpl.controller.webView != null)) {
          paramMMAdImpl.controller.webView.resetSpeechKit();
        }
        MMAdImpl localMMAdImpl = getAdImplWithId(paramMMAdImpl.linkForExpansionId);
        bool1 = bool2;
        if (localMMAdImpl == null) {
          continue;
        }
        bool1 = bool2;
        if (localMMAdImpl.controller == null) {
          continue;
        }
        if (localMMAdImpl.controller.webView == null)
        {
          localMMAdImpl.controller.webView = paramMMAdImpl.controller.webView;
          paramMMAdImpl.removeView(paramMMAdImpl.controller.webView);
          paramMMAdImpl.controller.webView = null;
        }
        localMMAdImpl.controller.webView.setMraidDefault();
        localMMAdImpl.controller.webView.setWebViewClient(localMMAdImpl.getMMWebViewClient());
        bool1 = true;
      }
      finally {}
    }
  }
  
  static String controllersToString()
  {
    return weakUnsaveableAdRef.toString() + " SAVED:" + saveableControllers.toString();
  }
  
  static void destroyOtherInlineVideo(Context paramContext)
  {
    paramContext = saveableControllers.entrySet().iterator();
    while (paramContext.hasNext())
    {
      Object localObject = (MMAdImplController)((Map.Entry)paramContext.next()).getValue();
      if (localObject != null)
      {
        localObject = (MMAdImpl)((MMAdImplController)localObject).adImplRef.get();
        if (localObject != null)
        {
          localObject = ((MMAdImpl)localObject).getCallingAd();
          if ((localObject != null) && ((localObject instanceof MMLayout))) {
            ((MMLayout)localObject).removeVideo();
          }
        }
      }
    }
  }
  
  static MMAdImpl getAdImplWithId(long paramLong)
  {
    MMAdImpl localMMAdImpl = null;
    if (paramLong == -4L) {}
    for (;;)
    {
      return localMMAdImpl;
      try
      {
        MMAdImplController localMMAdImplController2 = (MMAdImplController)saveableControllers.get(Long.valueOf(paramLong));
        MMAdImplController localMMAdImplController1 = localMMAdImplController2;
        if (localMMAdImplController2 == null)
        {
          WeakReference localWeakReference = (WeakReference)weakUnsaveableAdRef.get(Long.valueOf(paramLong));
          localMMAdImplController1 = localMMAdImplController2;
          if (localWeakReference != null) {
            localMMAdImplController1 = (MMAdImplController)localWeakReference.get();
          }
        }
        if (localMMAdImplController1 == null) {
          continue;
        }
        localMMAdImpl = (MMAdImpl)localMMAdImplController1.adImplRef.get();
      }
      finally {}
    }
  }
  
  static MMWebView getWebViewFromExistingAdImpl(MMAdImpl paramMMAdImpl)
  {
    try
    {
      MMSDK.Log.i("getWebViewFromExistingLayout(" + paramMMAdImpl.internalId + " taking from " + paramMMAdImpl.linkForExpansionId + ")");
      Object localObject = null;
      MMAdImpl localMMAdImpl = getAdImplWithId(paramMMAdImpl.linkForExpansionId);
      paramMMAdImpl = (MMAdImpl)localObject;
      if (localMMAdImpl != null)
      {
        paramMMAdImpl = (MMAdImpl)localObject;
        if (localMMAdImpl.controller != null)
        {
          paramMMAdImpl = localMMAdImpl.controller.webView;
          localMMAdImpl.controller.webView = null;
        }
      }
      return paramMMAdImpl;
    }
    finally {}
  }
  
  private boolean isDownloadingCachedAd(MMAdImpl paramMMAdImpl)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        Context localContext = paramMMAdImpl.getContext();
        if (HandShake.sharedHandShake(localContext).isAdTypeDownloading(paramMMAdImpl.adType))
        {
          MMSDK.Log.i("There is a download in progress. Defering call for new ad");
          MMSDK.Event.requestFailed(paramMMAdImpl, new MMException(12));
          return bool;
        }
        MMSDK.Log.d("No download in progress.");
        CachedAd localCachedAd = AdCache.loadIncompleteDownload(localContext, paramMMAdImpl.getCachedName());
        if (localCachedAd != null)
        {
          MMSDK.Log.i("Last ad wasn't fully downloaded. Download again.");
          MMSDK.Event.fetchStartedCaching(paramMMAdImpl);
          AdCache.startDownloadTask(localContext, paramMMAdImpl.getCachedName(), localCachedAd, this);
          continue;
        }
        MMSDK.Log.i("No incomplete downloads.");
      }
      finally {}
      bool = false;
    }
  }
  
  static void removeAdViewController(MMAdImpl paramMMAdImpl)
  {
    for (;;)
    {
      try
      {
        MMAdImplController localMMAdImplController = paramMMAdImpl.controller;
        if (localMMAdImplController == null) {
          return;
        }
        if (paramMMAdImpl.isLifecycleObservable())
        {
          saveableControllers.put(Long.valueOf(paramMMAdImpl.internalId), paramMMAdImpl.controller);
          if (weakUnsaveableAdRef.get(Long.valueOf(paramMMAdImpl.internalId)) != null) {
            weakUnsaveableAdRef.remove(Long.valueOf(paramMMAdImpl.internalId));
          }
          MMSDK.Log.d("****************RemoveAdviewcontroller - " + paramMMAdImpl);
          if (paramMMAdImpl.isFinishing)
          {
            saveableControllers.remove(Long.valueOf(paramMMAdImpl.internalId));
            weakUnsaveableAdRef.remove(Long.valueOf(paramMMAdImpl.internalId));
          }
          localMMAdImplController = paramMMAdImpl.controller;
          paramMMAdImpl.controller = null;
          MMSDK.Log.d("****************RemoveAdviewcontroller - controllers " + controllersToString());
          if (localMMAdImplController.webView != null)
          {
            MMSDK.Log.d("****************RemoveAdviewcontroller - controller!=null, expanding=" + localMMAdImplController.webView.isExpanding);
            paramMMAdImpl.removeView(localMMAdImplController.webView);
            localMMAdImplController.webView.isExpanding = false;
            if ((paramMMAdImpl.isFinishing) && (paramMMAdImpl.linkForExpansionId == 0L))
            {
              localMMAdImplController.webView.destroy();
              localMMAdImplController.webView = null;
            }
          }
        }
        else
        {
          weakUnsaveableAdRef.put(Long.valueOf(paramMMAdImpl.internalId), new WeakReference(paramMMAdImpl.controller));
        }
      }
      finally {}
    }
  }
  
  private void requestAdInternal(MMAdImpl paramMMAdImpl)
  {
    if (paramMMAdImpl.apid == null)
    {
      localMMException = new MMException("MMAdView found with a null apid. New ad requests on this MMAdView are disabled until an apid has been assigned.", 1);
      MMSDK.Log.e(localMMException);
      MMSDK.Event.requestFailed(paramMMAdImpl, localMMException);
    }
    while ((!paramMMAdImpl.isBanner()) && (isDownloadingCachedAd(paramMMAdImpl)))
    {
      MMException localMMException;
      return;
    }
    try
    {
      if (this.requestAdRunnable != null)
      {
        MMSDK.Log.i(MMException.getErrorCodeMessage(12));
        MMSDK.Event.requestFailed(paramMMAdImpl, new MMException(12));
        return;
      }
    }
    finally {}
    this.requestAdRunnable = new RequestAdRunnable(null);
    Utils.ThreadUtils.execute(this.requestAdRunnable);
  }
  
  /* Error */
  private static void setupWebView(MMAdImpl paramMMAdImpl)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: getfield 103	com/millennialmedia/android/MMAdImpl:controller	Lcom/millennialmedia/android/MMAdImplController;
    //   7: astore_3
    //   8: aload_3
    //   9: getfield 71	com/millennialmedia/android/MMAdImplController:webView	Lcom/millennialmedia/android/MMWebView;
    //   12: aload_0
    //   13: invokevirtual 180	com/millennialmedia/android/MMAdImpl:getMMWebViewClient	()Lcom/millennialmedia/android/MMWebViewClient;
    //   16: invokevirtual 184	com/millennialmedia/android/MMWebView:setWebViewClient	(Landroid/webkit/WebViewClient;)V
    //   19: aload_3
    //   20: getfield 71	com/millennialmedia/android/MMAdImplController:webView	Lcom/millennialmedia/android/MMWebView;
    //   23: aload_0
    //   24: getfield 91	com/millennialmedia/android/MMAdImpl:internalId	J
    //   27: invokevirtual 339	com/millennialmedia/android/MMWebView:isCurrentParent	(J)Z
    //   30: ifne +60 -> 90
    //   33: aload_0
    //   34: invokevirtual 77	com/millennialmedia/android/MMAdImpl:isBanner	()Z
    //   37: ifeq +57 -> 94
    //   40: new 341	android/widget/RelativeLayout$LayoutParams
    //   43: dup
    //   44: bipush -2
    //   46: bipush -2
    //   48: invokespecial 344	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   51: astore_2
    //   52: aload_2
    //   53: astore_1
    //   54: aload_3
    //   55: getfield 71	com/millennialmedia/android/MMAdImplController:webView	Lcom/millennialmedia/android/MMWebView;
    //   58: invokevirtual 347	com/millennialmedia/android/MMWebView:isMraidResized	()Z
    //   61: ifeq +13 -> 74
    //   64: aload_3
    //   65: getfield 71	com/millennialmedia/android/MMAdImplController:webView	Lcom/millennialmedia/android/MMWebView;
    //   68: aload_0
    //   69: invokevirtual 350	com/millennialmedia/android/MMWebView:unresizeToDefault	(Lcom/millennialmedia/android/MMAdImpl;)V
    //   72: aload_2
    //   73: astore_1
    //   74: aload_3
    //   75: getfield 71	com/millennialmedia/android/MMAdImplController:webView	Lcom/millennialmedia/android/MMWebView;
    //   78: invokevirtual 353	com/millennialmedia/android/MMWebView:removeFromParent	()V
    //   81: aload_0
    //   82: aload_3
    //   83: getfield 71	com/millennialmedia/android/MMAdImplController:webView	Lcom/millennialmedia/android/MMWebView;
    //   86: aload_1
    //   87: invokevirtual 357	com/millennialmedia/android/MMAdImpl:addView	(Lcom/millennialmedia/android/MMWebView;Landroid/widget/RelativeLayout$LayoutParams;)V
    //   90: ldc 2
    //   92: monitorexit
    //   93: return
    //   94: new 341	android/widget/RelativeLayout$LayoutParams
    //   97: dup
    //   98: bipush -2
    //   100: iconst_m1
    //   101: invokespecial 344	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   104: astore_1
    //   105: goto -31 -> 74
    //   108: astore_0
    //   109: ldc 2
    //   111: monitorexit
    //   112: aload_0
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramMMAdImpl	MMAdImpl
    //   53	52	1	localLayoutParams1	android.widget.RelativeLayout.LayoutParams
    //   51	22	2	localLayoutParams2	android.widget.RelativeLayout.LayoutParams
    //   7	76	3	localMMAdImplController	MMAdImplController
    // Exception table:
    //   from	to	target	type
    //   3	52	108	finally
    //   54	72	108	finally
    //   74	90	108	finally
    //   94	105	108	finally
  }
  
  int checkReason(MMAdImpl paramMMAdImpl, CachedAd paramCachedAd)
  {
    if (paramCachedAd.isExpired())
    {
      MMSDK.Log.d("%s is expired.", new Object[] { paramCachedAd.getId() });
      return 21;
    }
    if (!paramCachedAd.isOnDisk(paramMMAdImpl.getContext()))
    {
      MMSDK.Log.d("%s is not on disk.", new Object[] { paramCachedAd.getId() });
      return 22;
    }
    if (!HandShake.sharedHandShake(paramMMAdImpl.getContext()).canDisplayCachedAd(paramMMAdImpl.adType, paramCachedAd.deferredViewStart))
    {
      MMSDK.Log.d("%s cannot be shown at this time.", new Object[] { paramCachedAd.getId() });
      return 24;
    }
    return 100;
  }
  
  int display(MMAdImpl paramMMAdImpl)
  {
    CachedAd localCachedAd = AdCache.loadNextCachedAd(paramMMAdImpl.getContext(), paramMMAdImpl.getCachedName());
    if (localCachedAd != null)
    {
      if (localCachedAd.canShow(paramMMAdImpl.getContext(), paramMMAdImpl, true))
      {
        MMSDK.Event.displayStarted(paramMMAdImpl);
        AdCache.setNextCachedAd(paramMMAdImpl.getContext(), paramMMAdImpl.getCachedName(), null);
        localCachedAd.show(paramMMAdImpl.getContext(), paramMMAdImpl.internalId);
        HandShake.sharedHandShake(paramMMAdImpl.getContext()).updateLastVideoViewedTime(paramMMAdImpl.getContext(), paramMMAdImpl.adType);
        return 0;
      }
      return checkReason(paramMMAdImpl, localCachedAd);
    }
    return 20;
  }
  
  public void downloadCompleted(CachedAd paramCachedAd, boolean paramBoolean)
  {
    MMAdImpl localMMAdImpl = (MMAdImpl)this.adImplRef.get();
    if (localMMAdImpl == null)
    {
      MMSDK.Log.e(MMException.getErrorCodeMessage(25));
      return;
    }
    if (paramBoolean) {
      AdCache.setNextCachedAd(localMMAdImpl.getContext(), localMMAdImpl.getCachedName(), paramCachedAd.getId());
    }
    if (paramBoolean)
    {
      MMSDK.Event.requestCompleted(localMMAdImpl);
      return;
    }
    MMSDK.Event.requestFailed(localMMAdImpl, new MMException(15));
  }
  
  public void downloadStart(CachedAd paramCachedAd) {}
  
  public String getDefaultUserAgentString(Context paramContext)
  {
    return System.getProperty("http.agent");
  }
  
  HttpMMHeaders getLastHeaders()
  {
    if (this.webView == null) {
      return null;
    }
    return this.webView.getLastHeaders();
  }
  
  String getUserAgent()
  {
    Object localObject2 = null;
    Object localObject3 = (MMAdImpl)this.adImplRef.get();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((MMAdImpl)localObject3).getContext();
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = getDefaultUserAgentString((Context)localObject3);
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = Build.MODEL;
    }
    return (String)localObject2;
  }
  
  int isAdAvailable(MMAdImpl paramMMAdImpl)
  {
    CachedAd localCachedAd = AdCache.loadNextCachedAd(paramMMAdImpl.getContext(), paramMMAdImpl.getCachedName());
    if (localCachedAd != null)
    {
      if (localCachedAd.canShow(paramMMAdImpl.getContext(), paramMMAdImpl, true)) {
        return 0;
      }
      return checkReason(paramMMAdImpl, localCachedAd);
    }
    MMSDK.Log.i("No next ad.");
    return 20;
  }
  
  void linkForExpansion(MMAdImpl paramMMAdImpl)
  {
    MMAdImpl localMMAdImpl = getAdImplWithId(paramMMAdImpl.linkForExpansionId);
    if (localMMAdImpl != null)
    {
      this.linkedAdImplId = paramMMAdImpl.linkForExpansionId;
      localMMAdImpl.controller.linkedAdImplId = paramMMAdImpl.internalId;
      localMMAdImpl.linkForExpansionId = paramMMAdImpl.internalId;
    }
  }
  
  void loadUrl(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.webView != null)) {
      this.webView.loadUrl(paramString);
    }
  }
  
  void loadWebContent(String paramString1, String paramString2)
  {
    MMAdImpl localMMAdImpl = (MMAdImpl)this.adImplRef.get();
    if ((localMMAdImpl != null) && (this.webView != null)) {
      this.webView.setWebViewContent(paramString1, paramString2, localMMAdImpl);
    }
  }
  
  void requestAd()
  {
    MMAdImpl localMMAdImpl = (MMAdImpl)this.adImplRef.get();
    if (localMMAdImpl == null)
    {
      MMSDK.Log.e(MMException.getErrorCodeMessage(25));
      MMSDK.Event.requestFailed(localMMAdImpl, new MMException(25));
      return;
    }
    if (!localMMAdImpl.isRefreshable())
    {
      MMSDK.Event.requestFailed(localMMAdImpl, new MMException(16));
      return;
    }
    if (!MMSDK.isUiThread())
    {
      MMSDK.Log.e(MMException.getErrorCodeMessage(3));
      MMSDK.Event.requestFailed(localMMAdImpl, new MMException(3));
      return;
    }
    if (HandShake.sharedHandShake(localMMAdImpl.getContext()).kill)
    {
      MMSDK.Log.i("The server is no longer allowing ads.");
      MMSDK.Event.requestFailed(localMMAdImpl, new MMException(16));
      return;
    }
    try
    {
      MMSDK.Log.d("adLayout - requestAd");
      requestAdInternal(localMMAdImpl);
      return;
    }
    catch (Exception localException)
    {
      MMSDK.Log.e("There was an exception with the ad request. %s", new Object[] { localException.getMessage() });
      localException.printStackTrace();
    }
  }
  
  void setLastHeaders(HttpMMHeaders paramHttpMMHeaders)
  {
    if (this.webView != null) {
      this.webView.setLastHeaders(paramHttpMMHeaders);
    }
  }
  
  void setWebViewContent(String paramString1, String paramString2)
  {
    if (this.webView != null) {
      this.webView.setWebViewContent(paramString1, paramString2, (MMAdImpl)this.adImplRef.get());
    }
  }
  
  public String toString()
  {
    MMAdImpl localMMAdImpl = (MMAdImpl)this.adImplRef.get();
    StringBuilder localStringBuilder = new StringBuilder();
    if (localMMAdImpl != null) {
      localStringBuilder.append(localMMAdImpl + "-LinkInC=" + this.linkedAdImplId);
    }
    return localStringBuilder.toString() + " w/" + this.webView;
  }
  
  void unresizeToDefault()
  {
    if (this.webView != null) {
      this.webView.unresizeToDefault((MMAdImpl)this.adImplRef.get());
    }
  }
  
  private class RequestAdRunnable
    implements Runnable
  {
    String adUrl;
    HttpMMHeaders mmHeaders;
    
    private RequestAdRunnable() {}
    
    private boolean isAdUrlBuildable()
    {
      this.adUrl = null;
      Object localObject1 = null;
      if (MMAdImplController.this.adImplRef != null) {
        localObject1 = (MMAdImpl)MMAdImplController.this.adImplRef.get();
      }
      if (localObject1 != null)
      {
        try
        {
          Object localObject2 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
          ((MMAdImpl)localObject1).insertUrlAdMetaValues((Map)localObject2);
          MMSDK.insertUrlCommonValues(((MMAdImpl)localObject1).getContext(), (Map)localObject2);
          ((Map)localObject2).put("ua", ((MMAdImpl)localObject1).controller.getUserAgent());
          localObject1 = new StringBuilder(HandShake.getAdUrl());
          MMSDK.Log.d(((Map)localObject2).entrySet().toString());
          localObject2 = ((Map)localObject2).entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
            ((StringBuilder)localObject1).append(String.format("%s=%s&", new Object[] { localEntry.getKey(), URLEncoder.encode((String)localEntry.getValue(), "UTF-8") }));
          }
          localUnsupportedEncodingException.delete(localUnsupportedEncodingException.length() - 1, localUnsupportedEncodingException.length());
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          return failWithErrorMessage(new MMException(localUnsupportedEncodingException));
        }
        this.adUrl = localUnsupportedEncodingException.toString();
        MMSDK.Log.d("Calling for an advertisement: %s", new Object[] { this.adUrl });
      }
      else
      {
        failWithInfoMessage(new MMException(25));
      }
      return true;
    }
    
    private boolean isHandledHtmlResponse(HttpEntity paramHttpEntity)
    {
      MMAdImpl localMMAdImpl = null;
      try
      {
        if (MMAdImplController.this.adImplRef != null) {
          localMMAdImpl = (MMAdImpl)MMAdImplController.this.adImplRef.get();
        }
        if (localMMAdImpl != null) {
          if (!localMMAdImpl.isBanner())
          {
            InterstitialAd localInterstitialAd = new InterstitialAd();
            localInterstitialAd.content = HttpGetRequest.convertStreamToString(paramHttpEntity.getContent());
            localInterstitialAd.setId(localMMAdImpl.adType);
            localInterstitialAd.adUrl = this.adUrl;
            localInterstitialAd.mmHeaders = this.mmHeaders;
            if (MMSDK.logLevel >= 5)
            {
              MMSDK.Log.v("Received interstitial ad with url %s.", new Object[] { localInterstitialAd.adUrl });
              MMSDK.Log.v(localInterstitialAd.content);
            }
            AdCache.save(localMMAdImpl.getContext(), localInterstitialAd);
            AdCache.setNextCachedAd(localMMAdImpl.getContext(), localMMAdImpl.getCachedName(), localInterstitialAd.getId());
            MMSDK.Event.fetchStartedCaching(localMMAdImpl);
            MMSDK.Event.requestCompleted(localMMAdImpl);
          }
          else
          {
            if (localMMAdImpl.controller != null)
            {
              localMMAdImpl.controller.setLastHeaders(this.mmHeaders);
              localMMAdImpl.controller.setWebViewContent(HttpGetRequest.convertStreamToString(paramHttpEntity.getContent()), this.adUrl);
            }
            MMSDK.Event.requestCompleted(localMMAdImpl);
          }
        }
      }
      catch (IOException paramHttpEntity)
      {
        return failWithErrorMessage(new MMException("Exception raised in HTTP stream: " + paramHttpEntity.getMessage(), paramHttpEntity));
      }
      return true;
    }
    
    private boolean isHandledJsonResponse(HttpEntity paramHttpEntity)
    {
      MMAdImpl localMMAdImpl = null;
      if (MMAdImplController.this.adImplRef != null) {
        localMMAdImpl = (MMAdImpl)MMAdImplController.this.adImplRef.get();
      }
      if (localMMAdImpl != null) {
        if (localMMAdImpl.isBanner()) {
          return failWithErrorMessage(new MMException("Millennial ad return unsupported format.", 15));
        }
      }
      for (;;)
      {
        try
        {
          paramHttpEntity = (VideoAd)CachedAd.parseJSON(HttpGetRequest.convertStreamToString(paramHttpEntity.getContent()));
          if ((paramHttpEntity != null) && (paramHttpEntity.isValid()))
          {
            MMSDK.Log.i("Cached video ad JSON received: " + paramHttpEntity.getId());
            if (paramHttpEntity.isExpired())
            {
              MMSDK.Log.i("New ad has expiration date in the past. Not downloading ad content.");
              paramHttpEntity.delete(localMMAdImpl.getContext());
              MMSDK.Event.requestFailed(localMMAdImpl, new MMException(15));
            }
          }
          else
          {
            return true;
          }
        }
        catch (IllegalStateException paramHttpEntity)
        {
          paramHttpEntity.printStackTrace();
          return failWithInfoMessage(new MMException("Millennial ad return failed. Invalid response data.", paramHttpEntity));
        }
        catch (IOException paramHttpEntity)
        {
          paramHttpEntity.printStackTrace();
          return failWithInfoMessage(new MMException("Millennial ad return failed. " + paramHttpEntity.getMessage(), paramHttpEntity));
        }
        if (AdCache.loadNextCachedAd(localMMAdImpl.getContext(), localMMAdImpl.getCachedName()) != null)
        {
          MMSDK.Log.i("Previously fetched ad exists in the playback queue. Not downloading ad content.");
          paramHttpEntity.delete(localMMAdImpl.getContext());
          MMSDK.Event.requestFailed(localMMAdImpl, new MMException(17));
        }
        else
        {
          AdCache.save(localMMAdImpl.getContext(), paramHttpEntity);
          if (!paramHttpEntity.isOnDisk(localMMAdImpl.getContext()))
          {
            MMSDK.Event.logEvent(paramHttpEntity.cacheMissURL);
            MMSDK.Log.d("Downloading ad...");
            MMSDK.Event.fetchStartedCaching(localMMAdImpl);
            paramHttpEntity.downloadPriority = 3;
            AdCache.startDownloadTask(localMMAdImpl.getContext(), localMMAdImpl.getCachedName(), paramHttpEntity, localMMAdImpl.controller);
          }
          else
          {
            MMSDK.Log.d("Cached ad is valid. Moving it to the front of the queue.");
            AdCache.setNextCachedAd(localMMAdImpl.getContext(), localMMAdImpl.getCachedName(), paramHttpEntity.getId());
            MMSDK.Event.fetchStartedCaching(localMMAdImpl);
            MMSDK.Event.requestCompleted(localMMAdImpl);
          }
        }
      }
    }
    
    private boolean isHandledResponse(HttpResponse paramHttpResponse)
    {
      HttpEntity localHttpEntity = paramHttpResponse.getEntity();
      if (localHttpEntity == null)
      {
        failWithInfoMessage(new MMException("Null HTTP entity", 14));
        return false;
      }
      if (localHttpEntity.getContentLength() == 0L)
      {
        failWithInfoMessage(new MMException("Millennial ad return failed. Zero content length returned.", 14));
        return false;
      }
      saveMacId(paramHttpResponse);
      Object localObject = localHttpEntity.getContentType();
      if ((localObject != null) && (((Header)localObject).getValue() != null))
      {
        if (((Header)localObject).getValue().toLowerCase().startsWith("application/json")) {
          isHandledJsonResponse(localHttpEntity);
        }
        for (;;)
        {
          return true;
          if (!((Header)localObject).getValue().toLowerCase().startsWith("text/html")) {
            break;
          }
          localObject = paramHttpResponse.getFirstHeader("X-MM-Video");
          this.mmHeaders = new HttpMMHeaders(paramHttpResponse.getAllHeaders());
          if ((localObject != null) && (((Header)localObject).getValue().equalsIgnoreCase("true")))
          {
            paramHttpResponse = null;
            if (MMAdImplController.this.adImplRef != null) {
              paramHttpResponse = (MMAdImpl)MMAdImplController.this.adImplRef.get();
            }
            if (paramHttpResponse != null)
            {
              localObject = paramHttpResponse.getContext();
              HandShake.sharedHandShake((Context)localObject).updateLastVideoViewedTime((Context)localObject, paramHttpResponse.adType);
            }
          }
          isHandledHtmlResponse(localHttpEntity);
        }
        failWithInfoMessage(new MMException("Millennial ad return failed. Invalid (JSON/HTML expected) mime type returned.", 15));
        return false;
      }
      failWithInfoMessage(new MMException("Millennial ad return failed. HTTP Header value null.", 15));
      return false;
    }
    
    private void saveMacId(HttpResponse paramHttpResponse)
    {
      paramHttpResponse = paramHttpResponse.getHeaders("Set-Cookie");
      int j = paramHttpResponse.length;
      int i = 0;
      while (i < j)
      {
        String str = paramHttpResponse[i].getValue();
        int k = str.indexOf("MAC-ID=");
        if (k >= 0)
        {
          int m = str.indexOf(';', k);
          if (m > k) {
            MMSDK.macId = str.substring(k + 7, m);
          }
        }
        i += 1;
      }
    }
    
    boolean fail(MMException paramMMException)
    {
      MMAdImpl localMMAdImpl = null;
      if (MMAdImplController.this.adImplRef != null) {
        localMMAdImpl = (MMAdImpl)MMAdImplController.this.adImplRef.get();
      }
      MMSDK.Event.requestFailed(localMMAdImpl, paramMMException);
      return false;
    }
    
    boolean failWithErrorMessage(MMException paramMMException)
    {
      MMSDK.Log.e(paramMMException.getMessage());
      return fail(paramMMException);
    }
    
    boolean failWithInfoMessage(MMException paramMMException)
    {
      MMSDK.Log.i(paramMMException.getMessage());
      return fail(paramMMException);
    }
    
    public void run()
    {
      try
      {
        if (MMAdImplController.this.adImplRef != null)
        {
          Object localObject1 = (MMAdImpl)MMAdImplController.this.adImplRef.get();
          if ((localObject1 != null) && (MMSDK.isConnected(((MMAdImpl)localObject1).getContext())))
          {
            boolean bool = isAdUrlBuildable();
            if (!bool) {
              return;
            }
            try
            {
              localObject1 = new HttpGetRequest().get(this.adUrl);
              if (localObject1 == null)
              {
                failWithErrorMessage(new MMException("HTTP response is null.", 14));
                return;
              }
            }
            catch (Exception localException1)
            {
              failWithErrorMessage(new MMException("Ad request HTTP error. " + localException1.getMessage(), 14));
              return;
            }
            bool = isHandledResponse(localException1);
            if (bool) {}
          }
          else
          {
            failWithInfoMessage(new MMException("No network available, can't call for ads.", 11));
            return;
          }
        }
        return;
      }
      catch (Exception localException2)
      {
        failWithInfoMessage(new MMException("Request not filled, can't call for ads.", 14));
        return;
      }
      finally
      {
        MMAdImplController.this.requestAdRunnable = null;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/millennialmedia/android/MMAdImplController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */