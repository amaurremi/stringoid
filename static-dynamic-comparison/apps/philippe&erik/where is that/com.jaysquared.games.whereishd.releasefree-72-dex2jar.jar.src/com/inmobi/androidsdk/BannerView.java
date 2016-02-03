package com.inmobi.androidsdk;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.inmobi.androidsdk.bootstrapper.ConfigParams;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.androidsdk.bootstrapper.NetworkEventType;
import com.inmobi.androidsdk.impl.ConfigException;
import com.inmobi.androidsdk.impl.ConnBroadcastReciever;
import com.inmobi.androidsdk.impl.SDKUtil;
import com.inmobi.androidsdk.impl.UserInfo;
import com.inmobi.androidsdk.impl.imai.IMAIController;
import com.inmobi.androidsdk.impl.net.HttpRequestCallback;
import com.inmobi.androidsdk.impl.net.RequestResponseManager;
import com.inmobi.commons.AnimationType;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import com.inmobi.commons.metric.EventLog;
import com.inmobi.commons.metric.Logger;
import com.inmobi.commons.uid.UIDHelper;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.IMWebView.IMWebViewListener;
import com.inmobi.re.container.IMWebView.ViewState;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public final class BannerView
  extends RelativeLayout
{
  public static final int INMOBI_AD_UNIT_120X600 = 13;
  public static final int INMOBI_AD_UNIT_300X250 = 10;
  public static final int INMOBI_AD_UNIT_320X48 = 9;
  public static final int INMOBI_AD_UNIT_320X50 = 15;
  public static final int INMOBI_AD_UNIT_468X60 = 12;
  public static final int INMOBI_AD_UNIT_728X90 = 11;
  public static final String INMOBI_INTERNAL_TAG = "ref-__in__rt";
  public static final String INMOBI_REF_TAG = "ref-tag";
  private d A = new d(this);
  private Animation.AnimationListener B = new d(this);
  private HttpRequestCallback C = new c(this);
  private IMWebView.IMWebViewListener D = new b(this);
  private boolean E = true;
  private IMWebView a;
  private IMWebView b;
  private IMWebView c;
  private Activity d;
  private boolean e = true;
  private UserInfo f;
  private AtomicBoolean g = new AtomicBoolean();
  private AtomicBoolean h = new AtomicBoolean();
  private Animation i;
  private Animation j;
  private String k = null;
  private String l = null;
  private BannerViewListener m;
  private AdRequest n = new AdRequest();
  private String o;
  private int p;
  private long q = -1L;
  private long r = 0L;
  private long s = 0L;
  private boolean t = true;
  private AnimationType u = AnimationType.ROTATE_HORIZONTAL_AXIS;
  private boolean v = true;
  private a w;
  private String x = "http://i.w.inmobi.com/showad.asm";
  private RequestResponseManager y;
  private boolean z;
  
  public BannerView(Activity paramActivity, int paramInt, String paramString)
  {
    this(paramActivity);
    a(paramActivity, paramInt, paramString);
  }
  
  public BannerView(Activity paramActivity, int paramInt, String paramString, long paramLong)
  {
    this(paramActivity);
    this.q = paramLong;
    a(paramActivity, paramInt, paramString);
  }
  
  private BannerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public BannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (paramAttributeSet == null)
    {
      Log.debug("[InMobi]-[Network]-4.1.1", "Missing attributes in xml layout of IMAdview ");
      return;
    }
    String str = paramAttributeSet.getAttributeValue(null, "appId");
    int i1 = paramAttributeSet.getAttributeIntValue(null, "adSize", -1);
    paramAttributeSet = paramAttributeSet.getAttributeValue(null, "slotId");
    if (paramAttributeSet != null) {
      this.q = Long.parseLong(paramAttributeSet);
    }
    a((Activity)paramContext, i1, str);
  }
  
  private void a(int paramInt)
  {
    if (paramInt < 0) {
      Log.debug("[InMobi]-[Network]-4.1.1", "Invalid Ad Size. Please provide a valid Ad Size. If Ad Size is declared in the layout XML, please provide a valid 'adSize' attribute in the 'com.inmobi.androidsdk.IMAdView' tag of layout XML. For example, adSize=\"yourAdSize\"");
    }
  }
  
  private void a(final int paramInt, final AdRequest.ErrorCode paramErrorCode)
  {
    if (!this.E) {
      this.d.runOnUiThread(new b());
    }
    if (!this.v) {
      Log.debug("[InMobi]-[Network]-4.1.1", "IMAdView not sending callback because the view is not added to any window.");
    }
    while (this.m == null) {
      return;
    }
    this.d.runOnUiThread(new a(paramInt, paramErrorCode));
  }
  
  private void a(Activity paramActivity, int paramInt, String paramString)
  {
    try
    {
      SDKUtil.validateAdConfiguration(paramActivity);
      InternalSDKUtil.getUserAgent(paramActivity.getApplicationContext());
      a(paramInt);
      this.o = paramString;
      this.p = paramInt;
      this.d = SDKUtil.getRootActivity(paramActivity);
      IMWebView.setIMAIController(IMAIController.class);
    }
    catch (ConfigException localConfigException)
    {
      try
      {
        paramActivity = UIDHelper.getAndroidId(paramActivity.getApplicationContext());
        Log.debug("[InMobi]-[Network]-4.1.1", "Publisher device Id is " + UIDHelper.getODIN1(paramActivity));
        if (this.a == null)
        {
          this.a = new IMWebView(this.d, this.D, false, false);
          if (!this.E) {
            this.a.disableHardwareAcceleration();
          }
          this.a.addJavascriptInterface(new IMAIController(this.a), "imaiController");
        }
        if (this.b == null)
        {
          this.b = new IMWebView(this.d, this.D, false, false);
          if (!this.E) {
            this.b.disableHardwareAcceleration();
          }
          paramActivity = new RelativeLayout.LayoutParams(-1, -1);
          this.c = this.b;
          addView(this.b, paramActivity);
          this.b.addJavascriptInterface(new IMAIController(this.b), "imaiController");
        }
        d();
        this.w = new a(this, this.B);
        this.d.getApplicationContext().registerReceiver(new ConnBroadcastReciever(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        return;
        localConfigException = localConfigException;
        Log.internal("[InMobi]-[Network]-4.1.1", "IMConfigException occured while initializing interstitial while validating adView", localConfigException);
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
      if (i()) {
        if (this.a == null)
        {
          this.a = new IMWebView(this.d, this.D, false, false);
          if (!this.E) {
            this.a.disableHardwareAcceleration();
          }
        }
      }
      for (IMWebView localIMWebView = this.a;; localIMWebView = this.b)
      {
        localIMWebView.addJavascriptInterface(new IMAIController(localIMWebView), "imaiController");
        localIMWebView.requestOnPageFinishedCallback(this.A.obtainMessage(101));
        this.r = System.currentTimeMillis();
        this.A.sendEmptyMessageDelayed(108, Initializer.getConfigParams().getRenderTimeOut());
        localIMWebView.resetMraid();
        localIMWebView.loadDataWithBaseURL("", paramString, "text/html", null, null);
        return;
        if (this.b == null)
        {
          this.b = new IMWebView(this.d, this.D, false, false);
          if (!this.E) {
            this.b.disableHardwareAcceleration();
          }
        }
      }
    }
    a(false);
    Log.debug("[InMobi]-[Network]-4.1.1", "Cannot load Ad. Invalid Ad Response");
    a(101, AdRequest.ErrorCode.INTERNAL_ERROR);
  }
  
  private void a(boolean paramBoolean)
  {
    this.g.set(paramBoolean);
  }
  
  private void b(boolean paramBoolean)
  {
    this.h.set(paramBoolean);
  }
  
  private void c()
  {
    int i2 = 320;
    int i1 = 0;
    float f1 = this.d.getResources().getDisplayMetrics().density;
    for (;;)
    {
      try
      {
        switch (this.p)
        {
        case 9: 
          if ((i2 != 0) && (i1 != 0))
          {
            i2 = (int)(i2 * f1);
            i1 = (int)(i1 * f1);
            getLayoutParams().height = i1;
            getLayoutParams().width = i2;
            setLayoutParams(getLayoutParams());
          }
          return;
        }
      }
      catch (Exception localException)
      {
        Log.internal("[InMobi]-[Network]-4.1.1", "Cannot set default size for adview", localException);
        return;
      }
      i1 = 48;
      continue;
      i2 = 300;
      i1 = 250;
      continue;
      i2 = 729;
      i1 = 90;
      continue;
      i2 = 468;
      i1 = 60;
      continue;
      i2 = 120;
      i1 = 600;
      continue;
      i1 = 50;
      continue;
      i2 = 0;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (paramBoolean)
    {
      this.a.deinit();
      this.a = null;
      return;
    }
    this.b.deinit();
    this.b = null;
  }
  
  private void d()
  {
    if (this.f == null)
    {
      this.f = new UserInfo(this.d);
      Object localObject = new DisplayMetrics();
      this.d.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      float f1 = ((DisplayMetrics)localObject).density;
      localObject = ((WindowManager)this.d.getSystemService("window")).getDefaultDisplay();
      int i1 = (int)(WrapperFunctions.getDisplayWidth((Display)localObject) / f1);
      int i2 = (int)(WrapperFunctions.getDisplayHeight((Display)localObject) / f1);
      this.f.setScreenDensity(String.valueOf(f1));
      this.f.setScreenSize("" + i1 + "X" + i2);
    }
    try
    {
      if ((this.a != null) && (this.f.getPhoneDefaultUserAgent().equals(""))) {
        this.f.setPhoneDefaultUserAgent(InternalSDKUtil.getUserAgent(this.d.getApplicationContext()));
      }
      this.f.setAdUnitSlot(String.valueOf(this.p));
      if (this.q != -1L) {
        this.f.setSlotId(Long.toString(this.q));
      }
      this.f.updateInfo(this.o, this.n);
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
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokevirtual 547	com/inmobi/androidsdk/BannerView:removeAllViews	()V
    //   6: aload_0
    //   7: invokespecial 357	com/inmobi/androidsdk/BannerView:i	()Z
    //   10: ifeq +61 -> 71
    //   13: new 292	android/widget/RelativeLayout$LayoutParams
    //   16: dup
    //   17: iconst_m1
    //   18: iconst_m1
    //   19: invokespecial 295	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   22: astore_2
    //   23: aload_0
    //   24: aload_0
    //   25: getfield 197	com/inmobi/androidsdk/BannerView:a	Lcom/inmobi/re/container/IMWebView;
    //   28: putfield 297	com/inmobi/androidsdk/BannerView:c	Lcom/inmobi/re/container/IMWebView;
    //   31: aload_0
    //   32: aload_0
    //   33: getfield 197	com/inmobi/androidsdk/BannerView:a	Lcom/inmobi/re/container/IMWebView;
    //   36: aload_2
    //   37: invokevirtual 301	com/inmobi/androidsdk/BannerView:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   40: aload_0
    //   41: invokespecial 357	com/inmobi/androidsdk/BannerView:i	()Z
    //   44: ifne +5 -> 49
    //   47: iconst_1
    //   48: istore_1
    //   49: aload_0
    //   50: iload_1
    //   51: invokespecial 544	com/inmobi/androidsdk/BannerView:c	(Z)V
    //   54: aload_0
    //   55: iconst_0
    //   56: invokespecial 340	com/inmobi/androidsdk/BannerView:a	(Z)V
    //   59: aload_0
    //   60: invokespecial 549	com/inmobi/androidsdk/BannerView:j	()V
    //   63: aload_0
    //   64: bipush 100
    //   66: aconst_null
    //   67: invokespecial 336	com/inmobi/androidsdk/BannerView:a	(ILcom/inmobi/androidsdk/AdRequest$ErrorCode;)V
    //   70: return
    //   71: new 292	android/widget/RelativeLayout$LayoutParams
    //   74: dup
    //   75: iconst_m1
    //   76: iconst_m1
    //   77: invokespecial 295	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   80: astore_2
    //   81: aload_0
    //   82: aload_0
    //   83: getfield 290	com/inmobi/androidsdk/BannerView:b	Lcom/inmobi/re/container/IMWebView;
    //   86: putfield 297	com/inmobi/androidsdk/BannerView:c	Lcom/inmobi/re/container/IMWebView;
    //   89: aload_0
    //   90: aload_0
    //   91: getfield 290	com/inmobi/androidsdk/BannerView:b	Lcom/inmobi/re/container/IMWebView;
    //   94: aload_2
    //   95: invokevirtual 301	com/inmobi/androidsdk/BannerView:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   98: goto -58 -> 40
    //   101: astore_2
    //   102: ldc -97
    //   104: ldc_w 551
    //   107: aload_2
    //   108: invokestatic 553	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   111: aload_0
    //   112: bipush 100
    //   114: aconst_null
    //   115: invokespecial 336	com/inmobi/androidsdk/BannerView:a	(ILcom/inmobi/androidsdk/AdRequest$ErrorCode;)V
    //   118: return
    //   119: astore_2
    //   120: aload_0
    //   121: bipush 100
    //   123: aconst_null
    //   124: invokespecial 336	com/inmobi/androidsdk/BannerView:a	(ILcom/inmobi/androidsdk/AdRequest$ErrorCode;)V
    //   127: aload_2
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	BannerView
    //   1	50	1	bool	boolean
    //   22	73	2	localLayoutParams	RelativeLayout.LayoutParams
    //   101	7	2	localException	Exception
    //   119	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	40	101	java/lang/Exception
    //   40	47	101	java/lang/Exception
    //   49	63	101	java/lang/Exception
    //   71	98	101	java/lang/Exception
    //   2	40	119	finally
    //   40	47	119	finally
    //   49	63	119	finally
    //   71	98	119	finally
    //   102	111	119	finally
  }
  
  private boolean f()
  {
    if (this.p < 0)
    {
      Log.debug("[InMobi]-[Network]-4.1.1", "Invalid Ad Size. Please provide a valid adSize.");
      return false;
    }
    return true;
  }
  
  private boolean g()
  {
    return this.g.get();
  }
  
  private boolean h()
  {
    if (this.h.get()) {
      return true;
    }
    if (i()) {}
    for (IMWebView localIMWebView = this.b;; localIMWebView = this.a)
    {
      String str = localIMWebView.getState();
      Log.debug("[InMobi]-[Network]-4.1.1", "Current Ad State: " + str);
      if ((!IMWebView.ViewState.EXPANDED.toString().equalsIgnoreCase(str)) && (!IMWebView.ViewState.RESIZED.toString().equalsIgnoreCase(str)) && (!IMWebView.ViewState.RESIZING.toString().equalsIgnoreCase(str)) && (!IMWebView.ViewState.EXPANDING.toString().equalsIgnoreCase(str))) {
        break;
      }
      Log.debug("[InMobi]-[Network]-4.1.1", "Current Ad State is neither default nor loading. New ad will not be shown.");
      return true;
    }
    if (localIMWebView.isBusy())
    {
      Log.debug("[InMobi]-[Network]-4.1.1", "New ad will not be shown because the present ad is busy. Eg. Video/audio is playing, etc.");
      return true;
    }
    return false;
  }
  
  private boolean i()
  {
    return this.e;
  }
  
  private void j()
  {
    try
    {
      if (this.b != null) {
        this.b.setBackgroundColor(0);
      }
      if (this.a != null) {
        this.a.setBackgroundColor(0);
      }
      return;
    }
    catch (Exception localException)
    {
      Log.debug("[InMobi]-[Network]-4.1.1", "Error setNormalBGColor", localException);
    }
  }
  
  Animation a()
  {
    return this.i;
  }
  
  void a(Animation paramAnimation)
  {
    this.i = paramAnimation;
  }
  
  Animation b()
  {
    return this.j;
  }
  
  void b(Animation paramAnimation)
  {
    this.j = paramAnimation;
  }
  
  public void destroy()
  {
    try
    {
      if (this.c != null) {
        this.c.destroy();
      }
      this.c = null;
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
    this.E = false;
    if (this.c != null) {
      this.c.disableHardwareAcceleration();
    }
  }
  
  public int getAdSize()
  {
    return this.p;
  }
  
  public RelativeLayout.LayoutParams getAdViewPosition()
  {
    int[] arrayOfInt = new int[2];
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.c == null) || (this.c.getLayoutParams() == null) || (this.c.getParent() == this))
    {
      localLayoutParams = new RelativeLayout.LayoutParams(getLayoutParams());
      localLayoutParams.width = getWidth();
      localLayoutParams.height = getHeight();
      getLocationOnScreen(arrayOfInt);
      localLayoutParams.leftMargin = arrayOfInt[0];
    }
    for (localLayoutParams.topMargin = arrayOfInt[1];; localLayoutParams.topMargin = arrayOfInt[1])
    {
      ((FrameLayout)getRootView().findViewById(16908290)).getLocationOnScreen(arrayOfInt);
      localLayoutParams.leftMargin -= arrayOfInt[0];
      localLayoutParams.topMargin -= arrayOfInt[1];
      localLayoutParams.rightMargin = 0;
      localLayoutParams.bottomMargin = 0;
      return localLayoutParams;
      localLayoutParams = new RelativeLayout.LayoutParams(this.c.getLayoutParams());
      localLayoutParams.width = this.c.getWidth();
      localLayoutParams.height = this.c.getHeight();
      this.c.getLocationOnScreen(arrayOfInt);
      localLayoutParams.leftMargin = arrayOfInt[0];
    }
  }
  
  public String getAppId()
  {
    return this.o;
  }
  
  public BannerViewListener getIMAdListener()
  {
    return this.m;
  }
  
  public AdRequest getIMAdRequest()
  {
    return this.n;
  }
  
  public long getSlotId()
  {
    return this.q;
  }
  
  public boolean isModal()
  {
    if (this.c != null) {
      return this.c.isModal();
    }
    return false;
  }
  
  /* Error */
  public void loadNewAd()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: new 678	com/inmobi/androidsdk/impl/net/RequestResponseManager
    //   6: dup
    //   7: invokespecial 679	com/inmobi/androidsdk/impl/net/RequestResponseManager:<init>	()V
    //   10: putfield 594	com/inmobi/androidsdk/BannerView:y	Lcom/inmobi/androidsdk/impl/net/RequestResponseManager;
    //   13: aload_0
    //   14: invokestatic 683	com/inmobi/androidsdk/bootstrapper/Initializer:getLogger	()Lcom/inmobi/commons/metric/Logger;
    //   17: invokevirtual 688	com/inmobi/commons/metric/Logger:startNewSample	()Z
    //   20: putfield 456	com/inmobi/androidsdk/BannerView:z	Z
    //   23: aload_0
    //   24: getfield 204	com/inmobi/androidsdk/BannerView:d	Landroid/app/Activity;
    //   27: invokevirtual 227	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   30: invokestatic 256	com/inmobi/commons/uid/UIDHelper:getAndroidId	(Landroid/content/Context;)Ljava/lang/String;
    //   33: astore_1
    //   34: ldc -97
    //   36: new 258	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 261
    //   46: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokestatic 269	com/inmobi/commons/uid/UIDHelper:getODIN1	(Ljava/lang/String;)Ljava/lang/String;
    //   53: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 167	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: ldc -97
    //   64: ldc_w 690
    //   67: invokestatic 167	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload_0
    //   71: getfield 204	com/inmobi/androidsdk/BannerView:d	Landroid/app/Activity;
    //   74: invokevirtual 227	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   77: invokestatic 694	com/inmobi/commons/internal/InternalSDKUtil:checkNetworkAvailibility	(Landroid/content/Context;)Z
    //   80: ifne +33 -> 113
    //   83: aload_0
    //   84: bipush 101
    //   86: getstatic 697	com/inmobi/androidsdk/AdRequest$ErrorCode:NETWORK_ERROR	Lcom/inmobi/androidsdk/AdRequest$ErrorCode;
    //   89: invokespecial 336	com/inmobi/androidsdk/BannerView:a	(ILcom/inmobi/androidsdk/AdRequest$ErrorCode;)V
    //   92: aload_0
    //   93: monitorexit
    //   94: return
    //   95: astore_1
    //   96: ldc -97
    //   98: ldc_w 334
    //   101: aload_1
    //   102: invokestatic 332	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   105: goto -43 -> 62
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    //   113: aload_0
    //   114: invokespecial 699	com/inmobi/androidsdk/BannerView:g	()Z
    //   117: ifeq +28 -> 145
    //   120: aload_0
    //   121: bipush 101
    //   123: getstatic 702	com/inmobi/androidsdk/AdRequest$ErrorCode:AD_DOWNLOAD_IN_PROGRESS	Lcom/inmobi/androidsdk/AdRequest$ErrorCode;
    //   126: invokespecial 336	com/inmobi/androidsdk/BannerView:a	(ILcom/inmobi/androidsdk/AdRequest$ErrorCode;)V
    //   129: goto -37 -> 92
    //   132: astore_1
    //   133: ldc -97
    //   135: ldc_w 704
    //   138: aload_1
    //   139: invokestatic 553	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   142: goto -50 -> 92
    //   145: aload_0
    //   146: invokespecial 706	com/inmobi/androidsdk/BannerView:h	()Z
    //   149: ifeq +15 -> 164
    //   152: aload_0
    //   153: bipush 101
    //   155: getstatic 709	com/inmobi/androidsdk/AdRequest$ErrorCode:AD_CLICK_IN_PROGRESS	Lcom/inmobi/androidsdk/AdRequest$ErrorCode;
    //   158: invokespecial 336	com/inmobi/androidsdk/BannerView:a	(ILcom/inmobi/androidsdk/AdRequest$ErrorCode;)V
    //   161: goto -69 -> 92
    //   164: aload_0
    //   165: invokespecial 711	com/inmobi/androidsdk/BannerView:f	()Z
    //   168: ifne +15 -> 183
    //   171: aload_0
    //   172: bipush 101
    //   174: getstatic 714	com/inmobi/androidsdk/AdRequest$ErrorCode:INVALID_REQUEST	Lcom/inmobi/androidsdk/AdRequest$ErrorCode;
    //   177: invokespecial 336	com/inmobi/androidsdk/BannerView:a	(ILcom/inmobi/androidsdk/AdRequest$ErrorCode;)V
    //   180: goto -88 -> 92
    //   183: aload_0
    //   184: iconst_1
    //   185: invokespecial 340	com/inmobi/androidsdk/BannerView:a	(Z)V
    //   188: aload_0
    //   189: invokespecial 303	com/inmobi/androidsdk/BannerView:d	()V
    //   192: aload_0
    //   193: invokestatic 371	java/lang/System:currentTimeMillis	()J
    //   196: putfield 123	com/inmobi/androidsdk/BannerView:s	J
    //   199: aload_0
    //   200: getfield 143	com/inmobi/androidsdk/BannerView:A	Lcom/inmobi/androidsdk/BannerView$d;
    //   203: bipush 107
    //   205: invokestatic 377	com/inmobi/androidsdk/bootstrapper/Initializer:getConfigParams	()Lcom/inmobi/androidsdk/bootstrapper/ConfigParams;
    //   208: invokevirtual 717	com/inmobi/androidsdk/bootstrapper/ConfigParams:getFetchTimeOut	()I
    //   211: i2l
    //   212: invokevirtual 387	com/inmobi/androidsdk/BannerView$d:sendEmptyMessageDelayed	(IJ)Z
    //   215: pop
    //   216: aload_0
    //   217: getfield 594	com/inmobi/androidsdk/BannerView:y	Lcom/inmobi/androidsdk/impl/net/RequestResponseManager;
    //   220: aload_0
    //   221: getfield 459	com/inmobi/androidsdk/BannerView:f	Lcom/inmobi/androidsdk/impl/UserInfo;
    //   224: getstatic 723	com/inmobi/androidsdk/impl/net/RequestResponseManager$ActionType:AdRequest	Lcom/inmobi/androidsdk/impl/net/RequestResponseManager$ActionType;
    //   227: aload_0
    //   228: getfield 138	com/inmobi/androidsdk/BannerView:x	Ljava/lang/String;
    //   231: aload_0
    //   232: getfield 149	com/inmobi/androidsdk/BannerView:C	Lcom/inmobi/androidsdk/impl/net/HttpRequestCallback;
    //   235: invokevirtual 727	com/inmobi/androidsdk/impl/net/RequestResponseManager:asyncRequestAd	(Lcom/inmobi/androidsdk/impl/UserInfo;Lcom/inmobi/androidsdk/impl/net/RequestResponseManager$ActionType;Ljava/lang/String;Lcom/inmobi/androidsdk/impl/net/HttpRequestCallback;)V
    //   238: goto -146 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	BannerView
    //   33	17	1	str	String
    //   95	7	1	localException1	Exception
    //   108	4	1	localObject	Object
    //   132	7	1	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   23	62	95	java/lang/Exception
    //   2	23	108	finally
    //   23	62	108	finally
    //   62	70	108	finally
    //   70	92	108	finally
    //   96	105	108	finally
    //   113	129	108	finally
    //   133	142	108	finally
    //   145	161	108	finally
    //   164	180	108	finally
    //   183	238	108	finally
    //   70	92	132	java/lang/Exception
    //   113	129	132	java/lang/Exception
    //   145	161	132	java/lang/Exception
    //   164	180	132	java/lang/Exception
    //   183	238	132	java/lang/Exception
  }
  
  public void loadNewAd(AdRequest paramAdRequest)
  {
    if (paramAdRequest != null) {
      setIMAdRequest(paramAdRequest);
    }
    loadNewAd();
  }
  
  protected void onAttachedToWindow()
  {
    Log.debug("[InMobi]-[Network]-4.1.1", "onAttachedToWindow");
    this.v = true;
    c();
  }
  
  protected void onDetachedFromWindow()
  {
    Log.debug("[InMobi]-[Network]-4.1.1", "onDetatchedFromWindow");
    this.v = false;
    if (i()) {}
    for (IMWebView localIMWebView = this.b;; localIMWebView = this.a)
    {
      if (localIMWebView != null) {
        localIMWebView.deinit();
      }
      return;
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    if (paramInt == 0) {}
    try
    {
      RequestResponseManager localRequestResponseManager = new RequestResponseManager();
      localRequestResponseManager.init();
      localRequestResponseManager.processClick(this.d.getApplicationContext(), null);
      return;
    }
    catch (Exception localException)
    {
      Log.internal("[InMobi]-[Network]-4.1.1", "Exception ping in background", localException);
    }
  }
  
  @Deprecated
  public void setAdBackgroundColor(String paramString) {}
  
  @Deprecated
  public void setAdBackgroundGradientColor(String paramString1, String paramString2) {}
  
  public void setAdServerUrl(String paramString)
  {
    this.x = paramString;
  }
  
  public void setAdSize(int paramInt)
  {
    a(paramInt);
    this.p = paramInt;
  }
  
  @Deprecated
  public void setAdTextColor(String paramString) {}
  
  public void setAnimationType(AnimationType paramAnimationType)
  {
    this.u = paramAnimationType;
  }
  
  public void setAppId(String paramString)
  {
    this.o = paramString;
  }
  
  public void setIMAdListener(BannerViewListener paramBannerViewListener)
  {
    this.m = paramBannerViewListener;
  }
  
  public void setIMAdRequest(AdRequest paramAdRequest)
  {
    this.n = paramAdRequest;
  }
  
  public void setRefTagParam(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      Log.debug("[InMobi]-[Network]-4.1.1", "Key or Value cannot be null");
    }
    do
    {
      return;
      if ((paramString1.trim().equals("")) || (paramString2.trim().equals("")))
      {
        Log.debug("[InMobi]-[Network]-4.1.1", "Key or Value cannot be empty");
        return;
      }
    } while (this.f == null);
    this.f.setRefTagKey(paramString1.toLowerCase(Locale.ENGLISH));
    this.f.setRefTagValue(paramString2.toLowerCase(Locale.ENGLISH));
  }
  
  public void setSlotId(long paramLong)
  {
    this.q = paramLong;
  }
  
  public void stopLoading()
  {
    if (this.A.hasMessages(107))
    {
      this.A.removeMessages(107);
      this.A.sendEmptyMessage(107);
    }
    while (!this.A.hasMessages(108)) {
      return;
    }
    this.A.removeMessages(108);
    this.A.sendEmptyMessage(108);
  }
  
  class a
    implements Runnable
  {
    a(int paramInt, AdRequest.ErrorCode paramErrorCode) {}
    
    public void run()
    {
      try
      {
        switch (paramInt)
        {
        case 100: 
          Log.debug("[InMobi]-[Network]-4.1.1", paramErrorCode.toString());
          return;
        }
      }
      catch (Exception localException)
      {
        Log.debug("[InMobi]-[Network]-4.1.1", "Exception giving callback to the publisher ", localException);
        return;
      }
      BannerView.a(BannerView.this).onAdRequestCompleted(BannerView.this);
      return;
      switch (BannerView.c.a[paramErrorCode.ordinal()])
      {
      }
      for (;;)
      {
        Log.debug("[InMobi]-[Network]-4.1.1", paramErrorCode.toString());
        for (;;)
        {
          BannerView.a(BannerView.this).onAdRequestFailed(BannerView.this, paramErrorCode);
          return;
          Log.debug("[InMobi]-[Network]-4.1.1", "Ad click in progress. Your request cannot be processed at this time. Try again later.");
          continue;
          Log.debug("[InMobi]-[Network]-4.1.1", "Ad download in progress. Your request cannot be processed at this time. Try again later.");
          continue;
          Log.debug("[InMobi]-[Network]-4.1.1", "Ad request successful, but no ad was returned due to lack of ad inventory.");
          continue;
          Log.debug("[InMobi]-[Network]-4.1.1", "Your App Id may be invalid or inactive. Please verify the app ID");
        }
        BannerView.a(BannerView.this).onDismissAdScreen(BannerView.this);
        return;
        BannerView.a(BannerView.this).onShowAdScreen(BannerView.this);
        return;
        BannerView.a(BannerView.this).onLeaveApplication(BannerView.this);
        return;
        BannerView.a(BannerView.this).onShowAdScreen(BannerView.this);
        return;
        BannerView.a(BannerView.this).onDismissAdScreen(BannerView.this);
        return;
        break;
      }
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      BannerView.this.disableHardwareAcceleration();
    }
  }
  
  static class d
    extends Handler
  {
    private final WeakReference<BannerView> a;
    
    public d(BannerView paramBannerView)
    {
      this.a = new WeakReference(paramBannerView);
    }
    
    public void handleMessage(Message paramMessage)
    {
      localBannerView = (BannerView)this.a.get();
      if (localBannerView != null) {}
      try
      {
        int i = paramMessage.what;
        switch (i)
        {
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          try
          {
            JSONObject localJSONObject;
            localJSONObject.put("ad", BannerView.d(localBannerView));
            localJSONObject.put("t", l1);
            Initializer.getLogger().logEvent(new EventLog(NetworkEventType.FETCH_COMPLETE, localJSONObject));
            removeMessages(107);
            if (BannerView.e(localBannerView) != null) {
              BannerView.a(localBannerView, BannerView.e(localBannerView).replace("@__imm_aft@", "" + l1));
            }
            BannerView.b(localBannerView, BannerView.e(localBannerView));
            continue;
            localException = localException;
            Log.internal("[InMobi]-[Network]-4.1.1", "Exception hanlde message adview", localException);
          }
          catch (JSONException localJSONException1)
          {
            Log.internal("[InMobi]-[Network]-4.1.1", "Error creating metric logs for fetch_complete at " + System.currentTimeMillis());
            continue;
          }
          removeMessages(107);
          BannerView.a(localBannerView, 101, (AdRequest.ErrorCode)paramMessage.obj);
          BannerView.a(localBannerView, false);
          continue;
          removeMessages(108);
          removeMessages(101);
          BannerView.a(localBannerView, 101, AdRequest.ErrorCode.INTERNAL_ERROR);
          continue;
          Object localObject;
          if (BannerView.c(localBannerView))
          {
            l1 = System.currentTimeMillis();
            l2 = BannerView.f(localBannerView);
            localObject = new JSONObject();
          }
          try
          {
            ((JSONObject)localObject).put("ad", BannerView.d(localBannerView));
            ((JSONObject)localObject).put("t", l1 - l2);
            Initializer.getLogger().logEvent(new EventLog(NetworkEventType.RENDER_TIMEOUT, (JSONObject)localObject));
            removeMessages(111);
            removeMessages(101);
            BannerView.a(localBannerView, false);
            if (BannerView.g(localBannerView))
            {
              localObject = BannerView.h(localBannerView);
              BannerView.a(localBannerView, null);
              ((IMWebView)localObject).cancelLoad();
              ((IMWebView)localObject).stopLoading();
              ((IMWebView)localObject).deinit();
              BannerView.a(localBannerView, 101, AdRequest.ErrorCode.AD_RENDERING_TIMEOUT);
            }
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              Log.internal("[InMobi]-[Network]-4.1.1", "Error creating metric logs for fetch_complete at " + System.currentTimeMillis());
              continue;
              localObject = BannerView.i(localBannerView);
              BannerView.b(localBannerView, null);
            }
          }
          removeMessages(109);
          removeMessages(110);
          BannerView.j(localBannerView).doCancel();
          long l1 = System.currentTimeMillis();
          long l2 = BannerView.b(localBannerView);
          if (BannerView.c(localBannerView)) {
            localObject = new JSONObject();
          }
          try
          {
            ((JSONObject)localObject).put("t", l1 - l2);
            ((JSONObject)localObject).put("m", 1);
            Initializer.getLogger().logEvent(new EventLog(NetworkEventType.CONNECT_ERROR, (JSONObject)localObject));
            BannerView.a(localBannerView, false);
            BannerView.a(localBannerView, 101, AdRequest.ErrorCode.AD_FETCH_TIMEOUT);
          }
          catch (JSONException localJSONException3)
          {
            for (;;)
            {
              Log.internal("[InMobi]-[Network]-4.1.1", "Error creating metric logs for error at " + System.currentTimeMillis());
            }
          }
          if (BannerView.c(localBannerView))
          {
            l1 = System.currentTimeMillis();
            l2 = BannerView.b(localBannerView);
            localObject = new JSONObject();
          }
          try
          {
            ((JSONObject)localObject).put("ad", BannerView.d(localBannerView));
            ((JSONObject)localObject).put("t", l1 - l2);
            Initializer.getLogger().logEvent(new EventLog(NetworkEventType.RENDER_COMPLETE, (JSONObject)localObject));
            removeMessages(108);
            if (BannerView.k(localBannerView))
            {
              BannerView.l(localBannerView);
              BannerView.b(localBannerView, false);
            }
          }
          catch (JSONException localJSONException4)
          {
            for (;;)
            {
              Log.internal("[InMobi]-[Network]-4.1.1", "Error creating metric logs for fetch_complete at " + System.currentTimeMillis());
            }
            if (BannerView.m(localBannerView) == AnimationType.ANIMATION_OFF)
            {
              BannerView.l(localBannerView);
              continue;
            }
            BannerView.n(localBannerView).a(BannerView.m(localBannerView));
          }
          continue;
          BannerView.c(localBannerView, false);
          continue;
          BannerView.a(localBannerView, 103, null);
          continue;
          BannerView.a(localBannerView, 102, null);
          continue;
          BannerView.a(localBannerView, 104, null);
        }
      }
      super.handleMessage(paramMessage);
      return;
      l1 = System.currentTimeMillis() - BannerView.b(localBannerView);
      if (BannerView.c(localBannerView)) {
        localJSONObject = new JSONObject();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/androidsdk/BannerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */