package com.inmobi.androidsdk;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.inmobi.androidsdk.bootstrapper.AppGalleryConfigParams;
import com.inmobi.androidsdk.bootstrapper.ConfigParams;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.androidsdk.impl.ConfigException;
import com.inmobi.androidsdk.impl.ConnBroadcastReciever;
import com.inmobi.androidsdk.impl.SDKUtil;
import com.inmobi.androidsdk.impl.UserInfo;
import com.inmobi.androidsdk.impl.imai.IMAIController;
import com.inmobi.androidsdk.impl.net.HttpRequestCallback;
import com.inmobi.androidsdk.impl.net.RequestResponseManager;
import com.inmobi.androidsdk.impl.net.RequestResponseManager.ActionType;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import com.inmobi.commons.metric.Logger;
import com.inmobi.commons.uid.UIDHelper;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.IMWebView.IMWebViewListener;
import com.inmobi.re.container.mraidimpl.MRAIDInterstitialController;
import java.lang.ref.WeakReference;

public class InterstitialView
{
  long a = 0L;
  boolean b = true;
  private State c = State.INIT;
  private AdRequest d = new AdRequest();
  private Activity e;
  private String f;
  private long g = -1L;
  private InterstitialViewListener h;
  private String i;
  private long j;
  private long k;
  private UserInfo l;
  private IMWebView m;
  private String n;
  private String o = "http://i.w.inmobi.com/showad.asm";
  private RequestResponseManager p;
  private Mode q = Mode.AD_NETWORK;
  private boolean r;
  private HttpRequestCallback s = new f(this);
  private c t = new c(this);
  private IMWebView.IMWebViewListener u = new e(this);
  
  public InterstitialView(Activity paramActivity, String paramString)
  {
    a(paramActivity, paramString);
  }
  
  public InterstitialView(Activity paramActivity, String paramString, long paramLong)
  {
    this.g = paramLong;
    a(paramActivity, paramString);
  }
  
  private void a()
  {
    Display localDisplay = ((WindowManager)this.e.getSystemService("window")).getDefaultDisplay();
    int i1;
    if (this.l == null)
    {
      this.l = new UserInfo(this.e);
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      this.e.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      float f1 = localDisplayMetrics.density;
      i1 = (int)(WrapperFunctions.getDisplayWidth(localDisplay) / f1);
      int i2 = (int)(WrapperFunctions.getDisplayHeight(localDisplay) / f1);
      this.l.setScreenDensity(String.valueOf(f1));
      this.l.setScreenSize("" + i1 + "X" + i2);
    }
    try
    {
      if (this.l.getPhoneDefaultUserAgent().equals("")) {
        this.l.setPhoneDefaultUserAgent(InternalSDKUtil.getUserAgent(this.e.getApplicationContext()));
      }
      this.l.updateInfo(this.f, this.d);
      i1 = 14;
      if (InternalSDKUtil.isTablet(this.e.getApplicationContext())) {
        i1 = 17;
      }
      this.l.setAdUnitSlot(String.valueOf(i1));
      if (this.g != -1L) {
        this.l.setSlotId(Long.toString(this.g));
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.debug("[InMobi]-[Network]-4.1.1", "Exception occured while setting user agent" + localException);
      }
    }
  }
  
  private void a(final int paramInt, final AdRequest.ErrorCode paramErrorCode)
  {
    if (this.h == null) {
      return;
    }
    this.e.runOnUiThread(new a(paramInt, paramErrorCode));
  }
  
  private void a(Activity paramActivity, String paramString)
  {
    if (paramActivity == null)
    {
      Log.debug("[InMobi]-[Network]-4.1.1", "Activity cannot be null");
      return;
    }
    InternalSDKUtil.getUserAgent(paramActivity.getApplicationContext());
    try
    {
      SDKUtil.validateAdConfiguration(paramActivity);
      this.e = SDKUtil.getRootActivity(paramActivity);
      IMWebView.setIMAIController(IMAIController.class);
    }
    catch (ConfigException localConfigException)
    {
      try
      {
        paramActivity = UIDHelper.getAndroidId(this.e.getApplicationContext());
        Log.debug("[InMobi]-[Network]-4.1.1", "Publisher device Id is " + UIDHelper.getODIN1(paramActivity));
        this.f = paramString;
        a();
        try
        {
          this.e.getApplicationContext().registerReceiver(new ConnBroadcastReciever(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
          return;
        }
        catch (Exception paramActivity)
        {
          Log.internal("[InMobi]-[Network]-4.1.1", "Cannot register network receiver", paramActivity);
          return;
        }
        localConfigException = localConfigException;
        Log.internal("[InMobi]-[Network]-4.1.1", "IMConfigException occured while initializing interstitial while validating adConfig", localConfigException);
      }
      catch (Exception paramActivity)
      {
        for (;;)
        {
          Log.internal("[InMobi]-[Network]-4.1.1", "Cannot get publisher device id", paramActivity);
        }
      }
    }
  }
  
  private void a(String paramString)
  {
    if (paramString != null)
    {
      if (Build.VERSION.SDK_INT <= 8) {
        paramString.replaceAll("%", "%25");
      }
      this.m.requestOnPageFinishedCallback(this.t.obtainMessage(303));
      this.j = System.currentTimeMillis();
      this.t.sendEmptyMessageDelayed(307, Initializer.getConfigParams().getRenderTimeOut());
      this.m.loadDataWithBaseURL("", paramString, "text/html", null, null);
      return;
    }
    this.c = State.INIT;
    Log.debug("[InMobi]-[Network]-4.1.1", "Cannot load Ad. Invalid Ad Response");
    a(101, AdRequest.ErrorCode.INTERNAL_ERROR);
  }
  
  public void destroy()
  {
    try
    {
      if (this.m != null) {
        this.m.destroy();
      }
      this.m = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.debug("[InMobi]-[Network]-4.1.1", "Unable to destroy webview, or it has been destroyed already.");
      }
    }
  }
  
  public void disableHardwareAcceleration()
  {
    this.b = false;
    if (this.m != null) {
      this.m.disableHardwareAcceleration();
    }
  }
  
  public String getAppId()
  {
    return this.f;
  }
  
  public InterstitialViewListener getIMAdInterstitialListener()
  {
    return this.h;
  }
  
  public AdRequest getIMAdRequest()
  {
    return this.d;
  }
  
  public long getSlotId()
  {
    return this.g;
  }
  
  public State getState()
  {
    return this.c;
  }
  
  public void loadNewAd()
  {
    Object localObject = Initializer.getConfigParams();
    this.r = Initializer.getLogger().startNewSample();
    Log.debug("[InMobi]-[Network]-4.1.1", " >>>> Start loading new Interstitial Ad <<<<");
    try
    {
      String str = UIDHelper.getAndroidId(this.e.getApplicationContext());
      Log.debug("[InMobi]-[Network]-4.1.1", "Publisher device Id is " + UIDHelper.getODIN1(str));
      if (!InternalSDKUtil.checkNetworkAvailibility(this.e.getApplicationContext()))
      {
        a(101, AdRequest.ErrorCode.NETWORK_ERROR);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.internal("[InMobi]-[Network]-4.1.1", "Cannot get publisher device id", localException);
      }
      if (this.c == State.LOADING)
      {
        a(101, AdRequest.ErrorCode.AD_DOWNLOAD_IN_PROGRESS);
        return;
      }
      if (this.c == State.ACTIVE)
      {
        Log.debug("[InMobi]-[Network]-4.1.1", "Interstitial ad is in ACTIVE state. Try again after sometime.");
        a(101, AdRequest.ErrorCode.INVALID_REQUEST);
        return;
      }
      this.c = State.LOADING;
      a();
      this.a = System.currentTimeMillis();
      this.k = System.currentTimeMillis();
      this.t.sendEmptyMessageDelayed(306, ((ConfigParams)localObject).getFetchTimeOut());
      this.p = new RequestResponseManager();
      if (this.q != Mode.APP_GALLERY) {}
    }
    for (localObject = ((ConfigParams)localObject).getAppAppGalleryConfigParams().getUrl();; localObject = this.o)
    {
      this.p.asyncRequestAd(this.l, RequestResponseManager.ActionType.AdRequest_Interstitial, (String)localObject, this.s);
      return;
    }
  }
  
  public void loadNewAd(AdRequest paramAdRequest)
  {
    this.d = paramAdRequest;
    loadNewAd();
  }
  
  public void setAdServerUrl(String paramString)
  {
    this.o = paramString;
  }
  
  public void setAppId(String paramString)
  {
    this.f = paramString;
  }
  
  public void setIMAdInterstitialListener(InterstitialViewListener paramInterstitialViewListener)
  {
    this.h = paramInterstitialViewListener;
  }
  
  public void setIMAdRequest(AdRequest paramAdRequest)
  {
    this.d = paramAdRequest;
  }
  
  public void setMode(Mode paramMode)
  {
    this.q = paramMode;
  }
  
  public void setSlotId(long paramLong)
  {
    this.g = paramLong;
  }
  
  public void show()
  {
    try
    {
      Log.debug("[InMobi]-[Network]-4.1.1", "Showing the Interstitial Ad. ");
      if (this.c != State.READY)
      {
        Log.debug("[InMobi]-[Network]-4.1.1", "Interstitial ad is not in the 'READY' state. Current state: " + this.c);
        return;
      }
      if (this.i != null)
      {
        this.m.requestOnInterstitialClosed(this.t.obtainMessage(304));
        this.m.requestOnInterstitialShown(this.t.obtainMessage(305));
        this.m.mInterstitialController.changeContentAreaForInterstitials();
        return;
      }
    }
    catch (Exception localException)
    {
      Log.debug("[InMobi]-[Network]-4.1.1", "Error showing ad ", localException);
    }
  }
  
  public void stopLoading()
  {
    if (this.t.hasMessages(306))
    {
      this.t.removeMessages(306);
      this.t.sendEmptyMessage(306);
    }
    while (!this.t.hasMessages(307)) {
      return;
    }
    this.t.removeMessages(307);
    this.t.sendEmptyMessage(307);
  }
  
  public static enum State
  {
    static
    {
      LOADING = new State("LOADING", 2);
    }
    
    private State() {}
  }
  
  class a
    implements Runnable
  {
    a(int paramInt, AdRequest.ErrorCode paramErrorCode) {}
    
    public void run()
    {
      switch (paramInt)
      {
      default: 
        Log.debug("[InMobi]-[Network]-4.1.1", paramErrorCode.toString());
        return;
      case 100: 
        InterstitialView.a(InterstitialView.this).onAdRequestLoaded(InterstitialView.this);
        return;
      case 101: 
        switch (InterstitialView.b.a[paramErrorCode.ordinal()])
        {
        default: 
          Log.debug("[InMobi]-[Network]-4.1.1", paramErrorCode.toString());
        }
        for (;;)
        {
          InterstitialView.a(InterstitialView.this).onAdRequestFailed(InterstitialView.this, paramErrorCode);
          return;
          Log.debug("[InMobi]-[Network]-4.1.1", "Ad click in progress. Your request cannot be processed at this time. Try again later.");
          continue;
          Log.debug("[InMobi]-[Network]-4.1.1", "Ad download in progress. Your request cannot be processed at this time. Try again later.");
        }
      case 103: 
        InterstitialView.a(InterstitialView.this).onDismissAdScreen(InterstitialView.this);
        return;
      case 102: 
        InterstitialView.a(InterstitialView.this).onShowAdScreen(InterstitialView.this);
        return;
      }
      InterstitialView.a(InterstitialView.this).onLeaveApplication(InterstitialView.this);
    }
  }
  
  static class c
    extends Handler
  {
    private final WeakReference<InterstitialView> a;
    
    public c(InterstitialView paramInterstitialView)
    {
      this.a = new WeakReference(paramInterstitialView);
    }
    
    /* Error */
    public void handleMessage(android.os.Message paramMessage)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 22	com/inmobi/androidsdk/InterstitialView$c:a	Ljava/lang/ref/WeakReference;
      //   4: invokevirtual 33	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   7: checkcast 6	com/inmobi/androidsdk/InterstitialView
      //   10: astore 6
      //   12: aload 6
      //   14: ifnull +857 -> 871
      //   17: aload_1
      //   18: getfield 39	android/os/Message:what	I
      //   21: tableswitch	default:+850->871, 303:+683->704, 304:+807->828, 305:+832->853, 306:+547->568, 307:+384->405, 308:+47->68, 309:+312->333, 310:+343->364
      //   68: invokestatic 45	java/lang/System:currentTimeMillis	()J
      //   71: aload 6
      //   73: invokestatic 48	com/inmobi/androidsdk/InterstitialView:c	(Lcom/inmobi/androidsdk/InterstitialView;)J
      //   76: lsub
      //   77: lstore_2
      //   78: aload 6
      //   80: invokestatic 52	com/inmobi/androidsdk/InterstitialView:d	(Lcom/inmobi/androidsdk/InterstitialView;)Z
      //   83: ifeq +48 -> 131
      //   86: new 54	org/json/JSONObject
      //   89: dup
      //   90: invokespecial 55	org/json/JSONObject:<init>	()V
      //   93: astore_1
      //   94: aload_1
      //   95: ldc 57
      //   97: aload 6
      //   99: invokestatic 61	com/inmobi/androidsdk/InterstitialView:e	(Lcom/inmobi/androidsdk/InterstitialView;)Ljava/lang/String;
      //   102: invokevirtual 65	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   105: pop
      //   106: aload_1
      //   107: ldc 67
      //   109: lload_2
      //   110: invokevirtual 70	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
      //   113: pop
      //   114: invokestatic 76	com/inmobi/androidsdk/bootstrapper/Initializer:getLogger	()Lcom/inmobi/commons/metric/Logger;
      //   117: new 78	com/inmobi/commons/metric/EventLog
      //   120: dup
      //   121: getstatic 84	com/inmobi/androidsdk/bootstrapper/NetworkEventType:FETCH_COMPLETE	Lcom/inmobi/androidsdk/bootstrapper/NetworkEventType;
      //   124: aload_1
      //   125: invokespecial 87	com/inmobi/commons/metric/EventLog:<init>	(Lcom/inmobi/commons/metric/EventType;Lorg/json/JSONObject;)V
      //   128: invokevirtual 93	com/inmobi/commons/metric/Logger:logEvent	(Lcom/inmobi/commons/metric/EventLog;)V
      //   131: aload_0
      //   132: sipush 306
      //   135: invokevirtual 97	com/inmobi/androidsdk/InterstitialView$c:removeMessages	(I)V
      //   138: aload 6
      //   140: invokestatic 101	com/inmobi/androidsdk/InterstitialView:f	(Lcom/inmobi/androidsdk/InterstitialView;)Lcom/inmobi/re/container/IMWebView;
      //   143: ifnonnull +66 -> 209
      //   146: aload 6
      //   148: new 103	com/inmobi/re/container/IMWebView
      //   151: dup
      //   152: aload 6
      //   154: invokestatic 107	com/inmobi/androidsdk/InterstitialView:g	(Lcom/inmobi/androidsdk/InterstitialView;)Landroid/app/Activity;
      //   157: aload 6
      //   159: invokestatic 111	com/inmobi/androidsdk/InterstitialView:h	(Lcom/inmobi/androidsdk/InterstitialView;)Lcom/inmobi/re/container/IMWebView$IMWebViewListener;
      //   162: iconst_1
      //   163: iconst_0
      //   164: invokespecial 114	com/inmobi/re/container/IMWebView:<init>	(Landroid/content/Context;Lcom/inmobi/re/container/IMWebView$IMWebViewListener;ZZ)V
      //   167: invokestatic 117	com/inmobi/androidsdk/InterstitialView:a	(Lcom/inmobi/androidsdk/InterstitialView;Lcom/inmobi/re/container/IMWebView;)Lcom/inmobi/re/container/IMWebView;
      //   170: pop
      //   171: aload 6
      //   173: getfield 121	com/inmobi/androidsdk/InterstitialView:b	Z
      //   176: ifne +11 -> 187
      //   179: aload 6
      //   181: invokestatic 101	com/inmobi/androidsdk/InterstitialView:f	(Lcom/inmobi/androidsdk/InterstitialView;)Lcom/inmobi/re/container/IMWebView;
      //   184: invokevirtual 124	com/inmobi/re/container/IMWebView:disableHardwareAcceleration	()V
      //   187: aload 6
      //   189: invokestatic 101	com/inmobi/androidsdk/InterstitialView:f	(Lcom/inmobi/androidsdk/InterstitialView;)Lcom/inmobi/re/container/IMWebView;
      //   192: new 126	com/inmobi/androidsdk/impl/imai/IMAIController
      //   195: dup
      //   196: aload 6
      //   198: invokestatic 101	com/inmobi/androidsdk/InterstitialView:f	(Lcom/inmobi/androidsdk/InterstitialView;)Lcom/inmobi/re/container/IMWebView;
      //   201: invokespecial 129	com/inmobi/androidsdk/impl/imai/IMAIController:<init>	(Lcom/inmobi/re/container/IMWebView;)V
      //   204: ldc -125
      //   206: invokevirtual 135	com/inmobi/re/container/IMWebView:addJavascriptInterface	(Ljava/lang/Object;Ljava/lang/String;)V
      //   209: aload 6
      //   211: invokestatic 138	com/inmobi/androidsdk/InterstitialView:i	(Lcom/inmobi/androidsdk/InterstitialView;)Ljava/lang/String;
      //   214: ifnull +38 -> 252
      //   217: aload 6
      //   219: aload 6
      //   221: invokestatic 138	com/inmobi/androidsdk/InterstitialView:i	(Lcom/inmobi/androidsdk/InterstitialView;)Ljava/lang/String;
      //   224: ldc -116
      //   226: new 142	java/lang/StringBuilder
      //   229: dup
      //   230: invokespecial 143	java/lang/StringBuilder:<init>	()V
      //   233: ldc -111
      //   235: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   238: lload_2
      //   239: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   242: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   245: invokevirtual 162	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      //   248: invokestatic 165	com/inmobi/androidsdk/InterstitialView:a	(Lcom/inmobi/androidsdk/InterstitialView;Ljava/lang/String;)Ljava/lang/String;
      //   251: pop
      //   252: aload 6
      //   254: aload 6
      //   256: invokestatic 138	com/inmobi/androidsdk/InterstitialView:i	(Lcom/inmobi/androidsdk/InterstitialView;)Ljava/lang/String;
      //   259: invokestatic 168	com/inmobi/androidsdk/InterstitialView:c	(Lcom/inmobi/androidsdk/InterstitialView;Ljava/lang/String;)V
      //   262: return
      //   263: astore_1
      //   264: ldc -86
      //   266: ldc -84
      //   268: aload_1
      //   269: invokestatic 178	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   272: aload 6
      //   274: getstatic 184	com/inmobi/androidsdk/InterstitialView$State:INIT	Lcom/inmobi/androidsdk/InterstitialView$State;
      //   277: invokestatic 187	com/inmobi/androidsdk/InterstitialView:a	(Lcom/inmobi/androidsdk/InterstitialView;Lcom/inmobi/androidsdk/InterstitialView$State;)Lcom/inmobi/androidsdk/InterstitialView$State;
      //   280: pop
      //   281: aload 6
      //   283: bipush 101
      //   285: getstatic 193	com/inmobi/androidsdk/AdRequest$ErrorCode:INTERNAL_ERROR	Lcom/inmobi/androidsdk/AdRequest$ErrorCode;
      //   288: invokestatic 196	com/inmobi/androidsdk/InterstitialView:a	(Lcom/inmobi/androidsdk/InterstitialView;ILcom/inmobi/androidsdk/AdRequest$ErrorCode;)V
      //   291: return
      //   292: astore_1
      //   293: ldc -86
      //   295: ldc -58
      //   297: aload_1
      //   298: invokestatic 201	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   301: return
      //   302: astore 7
      //   304: ldc -86
      //   306: new 142	java/lang/StringBuilder
      //   309: dup
      //   310: invokespecial 143	java/lang/StringBuilder:<init>	()V
      //   313: ldc -53
      //   315: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   318: invokestatic 45	java/lang/System:currentTimeMillis	()J
      //   321: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   324: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   327: invokestatic 206	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
      //   330: goto -216 -> 114
      //   333: aload_0
      //   334: sipush 306
      //   337: invokevirtual 97	com/inmobi/androidsdk/InterstitialView$c:removeMessages	(I)V
      //   340: aload 6
      //   342: getstatic 184	com/inmobi/androidsdk/InterstitialView$State:INIT	Lcom/inmobi/androidsdk/InterstitialView$State;
      //   345: invokestatic 187	com/inmobi/androidsdk/InterstitialView:a	(Lcom/inmobi/androidsdk/InterstitialView;Lcom/inmobi/androidsdk/InterstitialView$State;)Lcom/inmobi/androidsdk/InterstitialView$State;
      //   348: pop
      //   349: aload 6
      //   351: bipush 101
      //   353: aload_1
      //   354: getfield 210	android/os/Message:obj	Ljava/lang/Object;
      //   357: checkcast 189	com/inmobi/androidsdk/AdRequest$ErrorCode
      //   360: invokestatic 196	com/inmobi/androidsdk/InterstitialView:a	(Lcom/inmobi/androidsdk/InterstitialView;ILcom/inmobi/androidsdk/AdRequest$ErrorCode;)V
      //   363: return
      //   364: aload_0
      //   365: sipush 307
      //   368: invokevirtual 97	com/inmobi/androidsdk/InterstitialView$c:removeMessages	(I)V
      //   371: aload_0
      //   372: sipush 303
      //   375: invokevirtual 97	com/inmobi/androidsdk/InterstitialView$c:removeMessages	(I)V
      //   378: aload 6
      //   380: getstatic 184	com/inmobi/androidsdk/InterstitialView$State:INIT	Lcom/inmobi/androidsdk/InterstitialView$State;
      //   383: invokestatic 187	com/inmobi/androidsdk/InterstitialView:a	(Lcom/inmobi/androidsdk/InterstitialView;Lcom/inmobi/androidsdk/InterstitialView$State;)Lcom/inmobi/androidsdk/InterstitialView$State;
      //   386: pop
      //   387: aload 6
      //   389: aconst_null
      //   390: invokestatic 117	com/inmobi/androidsdk/InterstitialView:a	(Lcom/inmobi/androidsdk/InterstitialView;Lcom/inmobi/re/container/IMWebView;)Lcom/inmobi/re/container/IMWebView;
      //   393: pop
      //   394: aload 6
      //   396: bipush 101
      //   398: getstatic 193	com/inmobi/androidsdk/AdRequest$ErrorCode:INTERNAL_ERROR	Lcom/inmobi/androidsdk/AdRequest$ErrorCode;
      //   401: invokestatic 196	com/inmobi/androidsdk/InterstitialView:a	(Lcom/inmobi/androidsdk/InterstitialView;ILcom/inmobi/androidsdk/AdRequest$ErrorCode;)V
      //   404: return
      //   405: aload_0
      //   406: sipush 310
      //   409: invokevirtual 97	com/inmobi/androidsdk/InterstitialView$c:removeMessages	(I)V
      //   412: aload_0
      //   413: sipush 303
      //   416: invokevirtual 97	com/inmobi/androidsdk/InterstitialView$c:removeMessages	(I)V
      //   419: aload 6
      //   421: getstatic 184	com/inmobi/androidsdk/InterstitialView$State:INIT	Lcom/inmobi/androidsdk/InterstitialView$State;
      //   424: invokestatic 187	com/inmobi/androidsdk/InterstitialView:a	(Lcom/inmobi/androidsdk/InterstitialView;Lcom/inmobi/androidsdk/InterstitialView$State;)Lcom/inmobi/androidsdk/InterstitialView$State;
      //   427: pop
      //   428: aload 6
      //   430: invokestatic 101	com/inmobi/androidsdk/InterstitialView:f	(Lcom/inmobi/androidsdk/InterstitialView;)Lcom/inmobi/re/container/IMWebView;
      //   433: invokevirtual 213	com/inmobi/re/container/IMWebView:cancelLoad	()V
      //   436: aload 6
      //   438: invokestatic 101	com/inmobi/androidsdk/InterstitialView:f	(Lcom/inmobi/androidsdk/InterstitialView;)Lcom/inmobi/re/container/IMWebView;
      //   441: invokevirtual 216	com/inmobi/re/container/IMWebView:stopLoading	()V
      //   444: aload 6
      //   446: invokestatic 101	com/inmobi/androidsdk/InterstitialView:f	(Lcom/inmobi/androidsdk/InterstitialView;)Lcom/inmobi/re/container/IMWebView;
      //   449: invokevirtual 219	com/inmobi/re/container/IMWebView:deinit	()V
      //   452: aload 6
      //   454: aconst_null
      //   455: invokestatic 117	com/inmobi/androidsdk/InterstitialView:a	(Lcom/inmobi/androidsdk/InterstitialView;Lcom/inmobi/re/container/IMWebView;)Lcom/inmobi/re/container/IMWebView;
      //   458: pop
      //   459: aload 6
      //   461: invokestatic 52	com/inmobi/androidsdk/InterstitialView:d	(Lcom/inmobi/androidsdk/InterstitialView;)Z
      //   464: ifeq +62 -> 526
      //   467: invokestatic 45	java/lang/System:currentTimeMillis	()J
      //   470: lstore_2
      //   471: aload 6
      //   473: invokestatic 222	com/inmobi/androidsdk/InterstitialView:j	(Lcom/inmobi/androidsdk/InterstitialView;)J
      //   476: lstore 4
      //   478: new 54	org/json/JSONObject
      //   481: dup
      //   482: invokespecial 55	org/json/JSONObject:<init>	()V
      //   485: astore_1
      //   486: aload_1
      //   487: ldc 57
      //   489: aload 6
      //   491: invokestatic 61	com/inmobi/androidsdk/InterstitialView:e	(Lcom/inmobi/androidsdk/InterstitialView;)Ljava/lang/String;
      //   494: invokevirtual 65	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   497: pop
      //   498: aload_1
      //   499: ldc 67
      //   501: lload_2
      //   502: lload 4
      //   504: lsub
      //   505: invokevirtual 70	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
      //   508: pop
      //   509: invokestatic 76	com/inmobi/androidsdk/bootstrapper/Initializer:getLogger	()Lcom/inmobi/commons/metric/Logger;
      //   512: new 78	com/inmobi/commons/metric/EventLog
      //   515: dup
      //   516: getstatic 225	com/inmobi/androidsdk/bootstrapper/NetworkEventType:RENDER_TIMEOUT	Lcom/inmobi/androidsdk/bootstrapper/NetworkEventType;
      //   519: aload_1
      //   520: invokespecial 87	com/inmobi/commons/metric/EventLog:<init>	(Lcom/inmobi/commons/metric/EventType;Lorg/json/JSONObject;)V
      //   523: invokevirtual 93	com/inmobi/commons/metric/Logger:logEvent	(Lcom/inmobi/commons/metric/EventLog;)V
      //   526: aload 6
      //   528: bipush 101
      //   530: getstatic 228	com/inmobi/androidsdk/AdRequest$ErrorCode:AD_RENDERING_TIMEOUT	Lcom/inmobi/androidsdk/AdRequest$ErrorCode;
      //   533: invokestatic 196	com/inmobi/androidsdk/InterstitialView:a	(Lcom/inmobi/androidsdk/InterstitialView;ILcom/inmobi/androidsdk/AdRequest$ErrorCode;)V
      //   536: return
      //   537: astore 7
      //   539: ldc -86
      //   541: new 142	java/lang/StringBuilder
      //   544: dup
      //   545: invokespecial 143	java/lang/StringBuilder:<init>	()V
      //   548: ldc -53
      //   550: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   553: invokestatic 45	java/lang/System:currentTimeMillis	()J
      //   556: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   559: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   562: invokestatic 206	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
      //   565: goto -56 -> 509
      //   568: aload_0
      //   569: sipush 308
      //   572: invokevirtual 97	com/inmobi/androidsdk/InterstitialView$c:removeMessages	(I)V
      //   575: aload_0
      //   576: sipush 309
      //   579: invokevirtual 97	com/inmobi/androidsdk/InterstitialView$c:removeMessages	(I)V
      //   582: aload 6
      //   584: getstatic 184	com/inmobi/androidsdk/InterstitialView$State:INIT	Lcom/inmobi/androidsdk/InterstitialView$State;
      //   587: invokestatic 187	com/inmobi/androidsdk/InterstitialView:a	(Lcom/inmobi/androidsdk/InterstitialView;Lcom/inmobi/androidsdk/InterstitialView$State;)Lcom/inmobi/androidsdk/InterstitialView$State;
      //   590: pop
      //   591: invokestatic 45	java/lang/System:currentTimeMillis	()J
      //   594: lstore_2
      //   595: aload 6
      //   597: invokestatic 48	com/inmobi/androidsdk/InterstitialView:c	(Lcom/inmobi/androidsdk/InterstitialView;)J
      //   600: lstore 4
      //   602: aload 6
      //   604: invokestatic 52	com/inmobi/androidsdk/InterstitialView:d	(Lcom/inmobi/androidsdk/InterstitialView;)Z
      //   607: ifeq +47 -> 654
      //   610: new 54	org/json/JSONObject
      //   613: dup
      //   614: invokespecial 55	org/json/JSONObject:<init>	()V
      //   617: astore_1
      //   618: aload_1
      //   619: ldc 67
      //   621: lload_2
      //   622: lload 4
      //   624: lsub
      //   625: invokevirtual 70	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
      //   628: pop
      //   629: aload_1
      //   630: ldc -26
      //   632: iconst_1
      //   633: invokevirtual 233	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
      //   636: pop
      //   637: invokestatic 76	com/inmobi/androidsdk/bootstrapper/Initializer:getLogger	()Lcom/inmobi/commons/metric/Logger;
      //   640: new 78	com/inmobi/commons/metric/EventLog
      //   643: dup
      //   644: getstatic 236	com/inmobi/androidsdk/bootstrapper/NetworkEventType:CONNECT_ERROR	Lcom/inmobi/androidsdk/bootstrapper/NetworkEventType;
      //   647: aload_1
      //   648: invokespecial 87	com/inmobi/commons/metric/EventLog:<init>	(Lcom/inmobi/commons/metric/EventType;Lorg/json/JSONObject;)V
      //   651: invokevirtual 93	com/inmobi/commons/metric/Logger:logEvent	(Lcom/inmobi/commons/metric/EventLog;)V
      //   654: aload 6
      //   656: invokestatic 240	com/inmobi/androidsdk/InterstitialView:k	(Lcom/inmobi/androidsdk/InterstitialView;)Lcom/inmobi/androidsdk/impl/net/RequestResponseManager;
      //   659: invokevirtual 245	com/inmobi/androidsdk/impl/net/RequestResponseManager:doCancel	()V
      //   662: aload 6
      //   664: bipush 101
      //   666: getstatic 248	com/inmobi/androidsdk/AdRequest$ErrorCode:AD_FETCH_TIMEOUT	Lcom/inmobi/androidsdk/AdRequest$ErrorCode;
      //   669: invokestatic 196	com/inmobi/androidsdk/InterstitialView:a	(Lcom/inmobi/androidsdk/InterstitialView;ILcom/inmobi/androidsdk/AdRequest$ErrorCode;)V
      //   672: return
      //   673: astore 7
      //   675: ldc -86
      //   677: new 142	java/lang/StringBuilder
      //   680: dup
      //   681: invokespecial 143	java/lang/StringBuilder:<init>	()V
      //   684: ldc -6
      //   686: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   689: invokestatic 45	java/lang/System:currentTimeMillis	()J
      //   692: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   695: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   698: invokestatic 206	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
      //   701: goto -64 -> 637
      //   704: aload 6
      //   706: invokestatic 52	com/inmobi/androidsdk/InterstitialView:d	(Lcom/inmobi/androidsdk/InterstitialView;)Z
      //   709: ifeq +62 -> 771
      //   712: invokestatic 45	java/lang/System:currentTimeMillis	()J
      //   715: lstore_2
      //   716: aload 6
      //   718: invokestatic 222	com/inmobi/androidsdk/InterstitialView:j	(Lcom/inmobi/androidsdk/InterstitialView;)J
      //   721: lstore 4
      //   723: new 54	org/json/JSONObject
      //   726: dup
      //   727: invokespecial 55	org/json/JSONObject:<init>	()V
      //   730: astore_1
      //   731: aload_1
      //   732: ldc 57
      //   734: aload 6
      //   736: invokestatic 61	com/inmobi/androidsdk/InterstitialView:e	(Lcom/inmobi/androidsdk/InterstitialView;)Ljava/lang/String;
      //   739: invokevirtual 65	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   742: pop
      //   743: aload_1
      //   744: ldc 67
      //   746: lload_2
      //   747: lload 4
      //   749: lsub
      //   750: invokevirtual 70	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
      //   753: pop
      //   754: invokestatic 76	com/inmobi/androidsdk/bootstrapper/Initializer:getLogger	()Lcom/inmobi/commons/metric/Logger;
      //   757: new 78	com/inmobi/commons/metric/EventLog
      //   760: dup
      //   761: getstatic 253	com/inmobi/androidsdk/bootstrapper/NetworkEventType:RENDER_COMPLETE	Lcom/inmobi/androidsdk/bootstrapper/NetworkEventType;
      //   764: aload_1
      //   765: invokespecial 87	com/inmobi/commons/metric/EventLog:<init>	(Lcom/inmobi/commons/metric/EventType;Lorg/json/JSONObject;)V
      //   768: invokevirtual 93	com/inmobi/commons/metric/Logger:logEvent	(Lcom/inmobi/commons/metric/EventLog;)V
      //   771: aload_0
      //   772: sipush 307
      //   775: invokevirtual 97	com/inmobi/androidsdk/InterstitialView$c:removeMessages	(I)V
      //   778: aload 6
      //   780: getstatic 256	com/inmobi/androidsdk/InterstitialView$State:READY	Lcom/inmobi/androidsdk/InterstitialView$State;
      //   783: invokestatic 187	com/inmobi/androidsdk/InterstitialView:a	(Lcom/inmobi/androidsdk/InterstitialView;Lcom/inmobi/androidsdk/InterstitialView$State;)Lcom/inmobi/androidsdk/InterstitialView$State;
      //   786: pop
      //   787: aload 6
      //   789: bipush 100
      //   791: aconst_null
      //   792: invokestatic 196	com/inmobi/androidsdk/InterstitialView:a	(Lcom/inmobi/androidsdk/InterstitialView;ILcom/inmobi/androidsdk/AdRequest$ErrorCode;)V
      //   795: return
      //   796: astore 7
      //   798: ldc -86
      //   800: new 142	java/lang/StringBuilder
      //   803: dup
      //   804: invokespecial 143	java/lang/StringBuilder:<init>	()V
      //   807: ldc_w 258
      //   810: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   813: invokestatic 45	java/lang/System:currentTimeMillis	()J
      //   816: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   819: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   822: invokestatic 206	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
      //   825: goto -71 -> 754
      //   828: aload 6
      //   830: getstatic 184	com/inmobi/androidsdk/InterstitialView$State:INIT	Lcom/inmobi/androidsdk/InterstitialView$State;
      //   833: invokestatic 187	com/inmobi/androidsdk/InterstitialView:a	(Lcom/inmobi/androidsdk/InterstitialView;Lcom/inmobi/androidsdk/InterstitialView$State;)Lcom/inmobi/androidsdk/InterstitialView$State;
      //   836: pop
      //   837: aload 6
      //   839: bipush 103
      //   841: aconst_null
      //   842: invokestatic 196	com/inmobi/androidsdk/InterstitialView:a	(Lcom/inmobi/androidsdk/InterstitialView;ILcom/inmobi/androidsdk/AdRequest$ErrorCode;)V
      //   845: aload 6
      //   847: aconst_null
      //   848: invokestatic 117	com/inmobi/androidsdk/InterstitialView:a	(Lcom/inmobi/androidsdk/InterstitialView;Lcom/inmobi/re/container/IMWebView;)Lcom/inmobi/re/container/IMWebView;
      //   851: pop
      //   852: return
      //   853: aload 6
      //   855: getstatic 261	com/inmobi/androidsdk/InterstitialView$State:ACTIVE	Lcom/inmobi/androidsdk/InterstitialView$State;
      //   858: invokestatic 187	com/inmobi/androidsdk/InterstitialView:a	(Lcom/inmobi/androidsdk/InterstitialView;Lcom/inmobi/androidsdk/InterstitialView$State;)Lcom/inmobi/androidsdk/InterstitialView$State;
      //   861: pop
      //   862: aload 6
      //   864: bipush 102
      //   866: aconst_null
      //   867: invokestatic 196	com/inmobi/androidsdk/InterstitialView:a	(Lcom/inmobi/androidsdk/InterstitialView;ILcom/inmobi/androidsdk/AdRequest$ErrorCode;)V
      //   870: return
      //   871: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	872	0	this	c
      //   0	872	1	paramMessage	android.os.Message
      //   77	670	2	l1	long
      //   476	272	4	l2	long
      //   10	853	6	localInterstitialView	InterstitialView
      //   302	1	7	localJSONException1	org.json.JSONException
      //   537	1	7	localJSONException2	org.json.JSONException
      //   673	1	7	localJSONException3	org.json.JSONException
      //   796	1	7	localJSONException4	org.json.JSONException
      // Exception table:
      //   from	to	target	type
      //   138	187	263	java/lang/Exception
      //   187	209	263	java/lang/Exception
      //   209	252	263	java/lang/Exception
      //   252	262	263	java/lang/Exception
      //   17	68	292	java/lang/Exception
      //   68	94	292	java/lang/Exception
      //   94	114	292	java/lang/Exception
      //   114	131	292	java/lang/Exception
      //   131	138	292	java/lang/Exception
      //   264	291	292	java/lang/Exception
      //   304	330	292	java/lang/Exception
      //   333	363	292	java/lang/Exception
      //   364	404	292	java/lang/Exception
      //   405	486	292	java/lang/Exception
      //   486	509	292	java/lang/Exception
      //   509	526	292	java/lang/Exception
      //   526	536	292	java/lang/Exception
      //   539	565	292	java/lang/Exception
      //   568	618	292	java/lang/Exception
      //   618	637	292	java/lang/Exception
      //   637	654	292	java/lang/Exception
      //   654	672	292	java/lang/Exception
      //   675	701	292	java/lang/Exception
      //   704	731	292	java/lang/Exception
      //   731	754	292	java/lang/Exception
      //   754	771	292	java/lang/Exception
      //   771	795	292	java/lang/Exception
      //   798	825	292	java/lang/Exception
      //   828	852	292	java/lang/Exception
      //   853	870	292	java/lang/Exception
      //   94	114	302	org/json/JSONException
      //   486	509	537	org/json/JSONException
      //   618	637	673	org/json/JSONException
      //   731	754	796	org/json/JSONException
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/androidsdk/InterstitialView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */