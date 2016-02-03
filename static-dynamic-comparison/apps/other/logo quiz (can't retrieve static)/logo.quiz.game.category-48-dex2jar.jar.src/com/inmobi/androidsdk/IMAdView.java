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
import com.inmobi.androidsdk.impl.ConfigException;
import com.inmobi.androidsdk.impl.ConnBroadcastReciever;
import com.inmobi.androidsdk.impl.SDKUtil;
import com.inmobi.androidsdk.impl.UserInfo;
import com.inmobi.androidsdk.impl.imai.IMAIController;
import com.inmobi.androidsdk.impl.metric.EventLog;
import com.inmobi.androidsdk.impl.metric.EventType;
import com.inmobi.androidsdk.impl.metric.Logger;
import com.inmobi.androidsdk.impl.net.HttpRequestCallback;
import com.inmobi.androidsdk.impl.net.RequestResponseManager;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.ThinICE;
import com.inmobi.commons.uid.UIDHelper;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.IMWebView.IMWebViewListener;
import com.inmobi.re.container.IMWebView.ViewState;
import com.inmobi.re.container.WrapperFunctions;
import com.inmobi.re.container.mraidimpl.MRAIDInterstitialController;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public final class IMAdView
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
  public static final int REFRESH_INTERVAL_OFF = -1;
  private boolean A;
  private a B = new a(this);
  private Animation.AnimationListener C = new a(this);
  private HttpRequestCallback D = new c(this);
  private IMWebView.IMWebViewListener E = new b(this);
  private boolean F = true;
  private int a;
  private IMWebView b;
  private IMWebView c;
  private IMWebView d;
  private Activity e;
  private boolean f = true;
  private UserInfo g;
  private AtomicBoolean h = new AtomicBoolean();
  private AtomicBoolean i = new AtomicBoolean();
  private Animation j;
  private Animation k;
  private String l = null;
  private String m = null;
  private IMAdListener n;
  private IMAdRequest o;
  private String p;
  private int q;
  private long r = -1L;
  private long s = 0L;
  private long t = 0L;
  private boolean u = true;
  private AnimationType v = AnimationType.ROTATE_HORIZONTAL_AXIS;
  private boolean w = true;
  private d x;
  private String y = "http://i.w.inmobi.com/showad.asm";
  private RequestResponseManager z;
  
  public IMAdView(Activity paramActivity, int paramInt, String paramString)
  {
    this(paramActivity);
    a(paramActivity, paramInt, paramString);
  }
  
  public IMAdView(Activity paramActivity, int paramInt, String paramString, long paramLong)
  {
    this(paramActivity);
    this.r = paramLong;
    a(paramActivity, paramInt, paramString);
  }
  
  private IMAdView(Context paramContext)
  {
    super(paramContext);
  }
  
  public IMAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (paramAttributeSet == null) {
      throw new IllegalArgumentException("Missing attributes in xml layout of IMAdview ");
    }
    String str = paramAttributeSet.getAttributeValue(null, "appId");
    int i1 = paramAttributeSet.getAttributeIntValue(null, "adSize", -1);
    paramAttributeSet = paramAttributeSet.getAttributeValue(null, "slotId");
    if (paramAttributeSet != null) {
      this.r = Long.parseLong(paramAttributeSet);
    }
    a((Activity)paramContext, i1, str);
  }
  
  private void a(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Invalid Ad Size. Please provide a valid Ad Size. If Ad Size is declared in the layout XML, please provide a valid 'adSize' attribute in the 'com.inmobi.androidsdk.IMAdView' tag of layout XML. For example, adSize=\"yourAdSize\"");
    }
  }
  
  private void a(final int paramInt, final IMAdRequest.ErrorCode paramErrorCode)
  {
    if (!this.w) {
      Log.debug("InMobiAndroidSDK_3.7.1", "IMAdView not sending callback because the view is not added to any window.");
    }
    while (this.n == null) {
      return;
    }
    this.e.runOnUiThread(new b(paramInt, paramErrorCode));
  }
  
  private void a(Activity paramActivity, int paramInt, String paramString)
  {
    try
    {
      SDKUtil.validateAdConfiguration(paramActivity);
      InternalSDKUtil.getUserAgent(paramActivity.getApplicationContext());
      this.a = Initializer.getConfigParams(getContext()).getDefaultRefreshRate();
      a(paramInt);
      SDKUtil.validateAppID(paramString);
      this.p = paramString;
      this.q = paramInt;
      this.e = SDKUtil.getRootActivity(paramActivity);
      IMWebView.setIMAIController(IMAIController.class);
    }
    catch (ConfigException localConfigException)
    {
      try
      {
        paramActivity = UIDHelper.getAndroidId(paramActivity.getApplicationContext());
        Log.debug("InMobiAndroidSDK_3.7.1", "Publisher device Id is " + UIDHelper.getODIN1(paramActivity));
        ThinICE.start(this.e);
        if (this.b == null)
        {
          this.b = new IMWebView(this.e, this.E, false, false);
          if (!this.F) {
            this.b.disableHardwareAcceleration();
          }
          this.b.addJavascriptInterface(new IMAIController(this.b), "imaiController");
        }
        if (this.c == null)
        {
          this.c = new IMWebView(this.e, this.E, false, false);
          if (!this.F) {
            this.c.disableHardwareAcceleration();
          }
          paramActivity = new RelativeLayout.LayoutParams(-1, -1);
          this.d = this.c;
          addView(this.c, paramActivity);
          this.c.addJavascriptInterface(new IMAIController(this.c), "imaiController");
        }
        d();
        this.x = new d(this, this.C);
        this.e.getApplicationContext().registerReceiver(new ConnBroadcastReciever(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        return;
        localConfigException = localConfigException;
        Log.internal("InMobiAndroidSDK_3.7.1", "IMConfigException occured while initializing interstitial while validating adView", localConfigException);
      }
      catch (Exception paramActivity)
      {
        for (;;)
        {
          Log.internal("InMobiAndroidSDK_3.7.1", "Cannot get publisher device id", paramActivity);
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
        if (this.b == null)
        {
          this.b = new IMWebView(this.e, this.E, false, false);
          if (!this.F) {
            this.b.disableHardwareAcceleration();
          }
        }
      }
      for (IMWebView localIMWebView = this.b;; localIMWebView = this.c)
      {
        localIMWebView.addJavascriptInterface(new IMAIController(localIMWebView), "imaiController");
        localIMWebView.requestOnPageFinishedCallback(this.B.obtainMessage(101));
        this.s = System.currentTimeMillis();
        this.B.sendEmptyMessageDelayed(108, Initializer.getConfigParams(getContext()).getRenderTimeOut());
        localIMWebView.resetMraid();
        localIMWebView.loadDataWithBaseURL("", paramString, "text/html", null, null);
        return;
        if (this.c == null)
        {
          this.c = new IMWebView(this.e, this.E, false, false);
          if (!this.F) {
            this.c.disableHardwareAcceleration();
          }
        }
      }
    }
    a(false);
    Log.debug("InMobiAndroidSDK_3.7.1", "Cannot load Ad. Invalid Ad Response");
    a(101, IMAdRequest.ErrorCode.INTERNAL_ERROR);
  }
  
  private void a(boolean paramBoolean)
  {
    this.h.set(paramBoolean);
  }
  
  private void b(boolean paramBoolean)
  {
    this.i.set(paramBoolean);
  }
  
  private void c()
  {
    int i2 = 320;
    int i1 = 0;
    float f1 = this.e.getResources().getDisplayMetrics().density;
    for (;;)
    {
      try
      {
        switch (this.q)
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
        Log.internal("InMobiAndroidSDK_3.7.1", "Cannot set default size for adview", localException);
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
    this.f = paramBoolean;
    if (paramBoolean)
    {
      this.b.deinit();
      this.b = null;
      return;
    }
    this.c.deinit();
    this.c = null;
  }
  
  private void d()
  {
    if (this.g == null)
    {
      this.g = new UserInfo(this.e);
      Object localObject = new DisplayMetrics();
      this.e.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      float f1 = ((DisplayMetrics)localObject).density;
      localObject = ((WindowManager)this.e.getSystemService("window")).getDefaultDisplay();
      int i1 = (int)(WrapperFunctions.getDisplayWidth((Display)localObject) / f1);
      int i2 = (int)(WrapperFunctions.getDisplayHeight((Display)localObject) / f1);
      this.g.setScreenDensity(String.valueOf(f1));
      this.g.setScreenSize("" + i1 + "X" + i2);
    }
    try
    {
      if ((this.b != null) && (this.g.getPhoneDefaultUserAgent().equals(""))) {
        this.g.setPhoneDefaultUserAgent(InternalSDKUtil.getUserAgent(this.e.getApplicationContext()));
      }
      this.g.setAdUnitSlot(String.valueOf(this.q));
      if (this.r != -1L) {
        this.g.setSlotId(Long.toString(this.r));
      }
      this.g.updateInfo(this.p, this.o);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.debug("InMobiAndroidSDK_3.7.1", "Exception occured while setting user agent" + localException);
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
    //   3: invokevirtual 565	com/inmobi/androidsdk/IMAdView:removeAllViews	()V
    //   6: aload_0
    //   7: invokespecial 384	com/inmobi/androidsdk/IMAdView:i	()Z
    //   10: ifeq +61 -> 71
    //   13: new 318	android/widget/RelativeLayout$LayoutParams
    //   16: dup
    //   17: iconst_m1
    //   18: iconst_m1
    //   19: invokespecial 321	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   22: astore_2
    //   23: aload_0
    //   24: aload_0
    //   25: getfield 191	com/inmobi/androidsdk/IMAdView:b	Lcom/inmobi/re/container/IMWebView;
    //   28: putfield 323	com/inmobi/androidsdk/IMAdView:d	Lcom/inmobi/re/container/IMWebView;
    //   31: aload_0
    //   32: aload_0
    //   33: getfield 191	com/inmobi/androidsdk/IMAdView:b	Lcom/inmobi/re/container/IMWebView;
    //   36: aload_2
    //   37: invokevirtual 327	com/inmobi/androidsdk/IMAdView:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   40: aload_0
    //   41: invokespecial 384	com/inmobi/androidsdk/IMAdView:i	()Z
    //   44: ifne +5 -> 49
    //   47: iconst_1
    //   48: istore_1
    //   49: aload_0
    //   50: iload_1
    //   51: invokespecial 561	com/inmobi/androidsdk/IMAdView:c	(Z)V
    //   54: aload_0
    //   55: iconst_0
    //   56: invokespecial 367	com/inmobi/androidsdk/IMAdView:a	(Z)V
    //   59: aload_0
    //   60: invokespecial 567	com/inmobi/androidsdk/IMAdView:j	()V
    //   63: aload_0
    //   64: bipush 100
    //   66: aconst_null
    //   67: invokespecial 360	com/inmobi/androidsdk/IMAdView:a	(ILcom/inmobi/androidsdk/IMAdRequest$ErrorCode;)V
    //   70: return
    //   71: new 318	android/widget/RelativeLayout$LayoutParams
    //   74: dup
    //   75: iconst_m1
    //   76: iconst_m1
    //   77: invokespecial 321	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   80: astore_2
    //   81: aload_0
    //   82: aload_0
    //   83: getfield 316	com/inmobi/androidsdk/IMAdView:c	Lcom/inmobi/re/container/IMWebView;
    //   86: putfield 323	com/inmobi/androidsdk/IMAdView:d	Lcom/inmobi/re/container/IMWebView;
    //   89: aload_0
    //   90: aload_0
    //   91: getfield 316	com/inmobi/androidsdk/IMAdView:c	Lcom/inmobi/re/container/IMWebView;
    //   94: aload_2
    //   95: invokevirtual 327	com/inmobi/androidsdk/IMAdView:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   98: goto -58 -> 40
    //   101: astore_2
    //   102: ldc -59
    //   104: ldc_w 569
    //   107: aload_2
    //   108: invokestatic 571	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   111: aload_0
    //   112: bipush 100
    //   114: aconst_null
    //   115: invokespecial 360	com/inmobi/androidsdk/IMAdView:a	(ILcom/inmobi/androidsdk/IMAdRequest$ErrorCode;)V
    //   118: return
    //   119: astore_2
    //   120: aload_0
    //   121: bipush 100
    //   123: aconst_null
    //   124: invokespecial 360	com/inmobi/androidsdk/IMAdView:a	(ILcom/inmobi/androidsdk/IMAdRequest$ErrorCode;)V
    //   127: aload_2
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	IMAdView
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
    if ((!SDKUtil.getQAMode()) && (!InternalSDKUtil.validateAppId(this.p))) {
      return false;
    }
    if (this.q < 0)
    {
      Log.debug("InMobiAndroidSDK_3.7.1", "Invalid Ad Size. Please provide a valid adSize.");
      return false;
    }
    return true;
  }
  
  private boolean g()
  {
    return this.h.get();
  }
  
  private boolean h()
  {
    if (this.i.get()) {
      return true;
    }
    if (i()) {}
    for (IMWebView localIMWebView = this.c;; localIMWebView = this.b)
    {
      String str = localIMWebView.getState();
      Log.debug("InMobiAndroidSDK_3.7.1", "Current Ad State: " + str);
      if ((!IMWebView.ViewState.EXPANDED.toString().equalsIgnoreCase(str)) && (!IMWebView.ViewState.RESIZED.toString().equalsIgnoreCase(str)) && (!IMWebView.ViewState.RESIZING.toString().equalsIgnoreCase(str)) && (!IMWebView.ViewState.EXPANDING.toString().equalsIgnoreCase(str))) {
        break;
      }
      Log.debug("InMobiAndroidSDK_3.7.1", "Current Ad State is neither default nor loading. New ad will not be shown.");
      return true;
    }
    if (localIMWebView.isBusy())
    {
      Log.debug("InMobiAndroidSDK_3.7.1", "New ad will not be shown because the present ad is busy. Eg. Video/audio is playing, etc.");
      return true;
    }
    return false;
  }
  
  private boolean i()
  {
    return this.f;
  }
  
  private void j()
  {
    try
    {
      if (this.c != null) {
        this.c.setBackgroundColor(0);
      }
      if (this.b != null) {
        this.b.setBackgroundColor(0);
      }
      return;
    }
    catch (Exception localException)
    {
      Log.debug("InMobiAndroidSDK_3.7.1", "Error setNormalBGColor", localException);
    }
  }
  
  private void k()
  {
    this.B.removeMessages(100);
    int i1 = Initializer.getConfigParams(getContext()).getMinimumRefreshRate();
    if (this.a < i1)
    {
      this.B.sendEmptyMessageDelayed(100, i1 * 1000);
      return;
    }
    this.B.sendEmptyMessageDelayed(100, this.a * 1000);
  }
  
  private void l()
  {
    if (this.B.hasMessages(100)) {
      this.B.removeMessages(100);
    }
    this.B.sendEmptyMessageDelayed(100, this.a * 1000);
  }
  
  private void setAdServerUrl(String paramString)
  {
    this.y = paramString;
  }
  
  Animation a()
  {
    return this.j;
  }
  
  void a(Animation paramAnimation)
  {
    this.j = paramAnimation;
  }
  
  Animation b()
  {
    return this.k;
  }
  
  void b(Animation paramAnimation)
  {
    this.k = paramAnimation;
  }
  
  public void destroy()
  {
    try
    {
      if (this.d != null) {
        this.d.destroy();
      }
      this.d = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.debug("InMobiAndroidSDK_3.7.1", "Unable to destroy webview, or it has been destroyed already.");
      }
    }
  }
  
  public void disableHardwareAcceleration()
  {
    this.F = false;
    if (this.d != null) {
      this.d.disableHardwareAcceleration();
    }
  }
  
  public int getAdSize()
  {
    return this.q;
  }
  
  public RelativeLayout.LayoutParams getAdViewPosition()
  {
    int[] arrayOfInt = new int[2];
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.d == null) || (this.d.getLayoutParams() == null) || (this.d.getParent() == this))
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
      localLayoutParams = new RelativeLayout.LayoutParams(this.d.getLayoutParams());
      localLayoutParams.width = this.d.getWidth();
      localLayoutParams.height = this.d.getHeight();
      this.d.getLocationOnScreen(arrayOfInt);
      localLayoutParams.leftMargin = arrayOfInt[0];
    }
  }
  
  public String getAppId()
  {
    return this.p;
  }
  
  public IMAdListener getIMAdListener()
  {
    return this.n;
  }
  
  public IMAdRequest getIMAdRequest()
  {
    return this.o;
  }
  
  public long getSlotId()
  {
    return this.r;
  }
  
  public boolean isModal()
  {
    if (this.d != null) {
      return this.d.isModal();
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
    //   3: new 716	com/inmobi/androidsdk/impl/net/RequestResponseManager
    //   6: dup
    //   7: invokespecial 717	com/inmobi/androidsdk/impl/net/RequestResponseManager:<init>	()V
    //   10: putfield 623	com/inmobi/androidsdk/IMAdView:z	Lcom/inmobi/androidsdk/impl/net/RequestResponseManager;
    //   13: aload_0
    //   14: aload_0
    //   15: invokevirtual 236	com/inmobi/androidsdk/IMAdView:getContext	()Landroid/content/Context;
    //   18: invokestatic 723	com/inmobi/androidsdk/impl/metric/Logger:startNewSample	(Landroid/content/Context;)Z
    //   21: putfield 472	com/inmobi/androidsdk/IMAdView:A	Z
    //   24: aload_0
    //   25: getfield 207	com/inmobi/androidsdk/IMAdView:e	Landroid/app/Activity;
    //   28: invokevirtual 227	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   31: invokestatic 276	com/inmobi/commons/uid/UIDHelper:getAndroidId	(Landroid/content/Context;)Ljava/lang/String;
    //   34: astore_1
    //   35: ldc -59
    //   37: new 278	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 279	java/lang/StringBuilder:<init>	()V
    //   44: ldc_w 281
    //   47: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_1
    //   51: invokestatic 289	com/inmobi/commons/uid/UIDHelper:getODIN1	(Ljava/lang/String;)Ljava/lang/String;
    //   54: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 205	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: ldc -59
    //   65: ldc_w 725
    //   68: invokestatic 205	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload_0
    //   72: getfield 207	com/inmobi/androidsdk/IMAdView:e	Landroid/app/Activity;
    //   75: invokevirtual 227	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   78: invokestatic 728	com/inmobi/commons/internal/InternalSDKUtil:checkNetworkAvailibility	(Landroid/content/Context;)Z
    //   81: ifne +33 -> 114
    //   84: aload_0
    //   85: bipush 101
    //   87: getstatic 731	com/inmobi/androidsdk/IMAdRequest$ErrorCode:NETWORK_ERROR	Lcom/inmobi/androidsdk/IMAdRequest$ErrorCode;
    //   90: invokespecial 360	com/inmobi/androidsdk/IMAdView:a	(ILcom/inmobi/androidsdk/IMAdRequest$ErrorCode;)V
    //   93: aload_0
    //   94: monitorexit
    //   95: return
    //   96: astore_1
    //   97: ldc -59
    //   99: ldc_w 358
    //   102: aload_1
    //   103: invokestatic 356	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   106: goto -43 -> 63
    //   109: astore_1
    //   110: aload_0
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: aload_0
    //   115: invokespecial 733	com/inmobi/androidsdk/IMAdView:g	()Z
    //   118: ifeq +28 -> 146
    //   121: aload_0
    //   122: bipush 101
    //   124: getstatic 736	com/inmobi/androidsdk/IMAdRequest$ErrorCode:AD_DOWNLOAD_IN_PROGRESS	Lcom/inmobi/androidsdk/IMAdRequest$ErrorCode;
    //   127: invokespecial 360	com/inmobi/androidsdk/IMAdView:a	(ILcom/inmobi/androidsdk/IMAdRequest$ErrorCode;)V
    //   130: goto -37 -> 93
    //   133: astore_1
    //   134: ldc -59
    //   136: ldc_w 738
    //   139: aload_1
    //   140: invokestatic 571	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   143: goto -50 -> 93
    //   146: aload_0
    //   147: invokespecial 740	com/inmobi/androidsdk/IMAdView:h	()Z
    //   150: ifeq +15 -> 165
    //   153: aload_0
    //   154: bipush 101
    //   156: getstatic 743	com/inmobi/androidsdk/IMAdRequest$ErrorCode:AD_CLICK_IN_PROGRESS	Lcom/inmobi/androidsdk/IMAdRequest$ErrorCode;
    //   159: invokespecial 360	com/inmobi/androidsdk/IMAdView:a	(ILcom/inmobi/androidsdk/IMAdRequest$ErrorCode;)V
    //   162: goto -69 -> 93
    //   165: aload_0
    //   166: invokespecial 745	com/inmobi/androidsdk/IMAdView:f	()Z
    //   169: ifne +15 -> 184
    //   172: aload_0
    //   173: bipush 101
    //   175: getstatic 748	com/inmobi/androidsdk/IMAdRequest$ErrorCode:INVALID_REQUEST	Lcom/inmobi/androidsdk/IMAdRequest$ErrorCode;
    //   178: invokespecial 360	com/inmobi/androidsdk/IMAdView:a	(ILcom/inmobi/androidsdk/IMAdRequest$ErrorCode;)V
    //   181: goto -88 -> 93
    //   184: aload_0
    //   185: iconst_1
    //   186: invokespecial 367	com/inmobi/androidsdk/IMAdView:a	(Z)V
    //   189: aload_0
    //   190: invokespecial 329	com/inmobi/androidsdk/IMAdView:d	()V
    //   193: aload_0
    //   194: getfield 475	com/inmobi/androidsdk/IMAdView:g	Lcom/inmobi/androidsdk/impl/UserInfo;
    //   197: ifnull +11 -> 208
    //   200: aload_0
    //   201: getfield 475	com/inmobi/androidsdk/IMAdView:g	Lcom/inmobi/androidsdk/impl/UserInfo;
    //   204: iconst_0
    //   205: invokevirtual 751	com/inmobi/androidsdk/impl/UserInfo:setRefreshType	(I)V
    //   208: aload_0
    //   209: invokestatic 398	java/lang/System:currentTimeMillis	()J
    //   212: putfield 122	com/inmobi/androidsdk/IMAdView:t	J
    //   215: aload_0
    //   216: getfield 140	com/inmobi/androidsdk/IMAdView:B	Lcom/inmobi/androidsdk/IMAdView$a;
    //   219: bipush 107
    //   221: aload_0
    //   222: invokevirtual 236	com/inmobi/androidsdk/IMAdView:getContext	()Landroid/content/Context;
    //   225: invokestatic 242	com/inmobi/androidsdk/bootstrapper/Initializer:getConfigParams	(Landroid/content/Context;)Lcom/inmobi/androidsdk/bootstrapper/ConfigParams;
    //   228: invokevirtual 754	com/inmobi/androidsdk/bootstrapper/ConfigParams:getFetchTimeOut	()I
    //   231: i2l
    //   232: invokevirtual 405	com/inmobi/androidsdk/IMAdView$a:sendEmptyMessageDelayed	(IJ)Z
    //   235: pop
    //   236: aload_0
    //   237: getfield 140	com/inmobi/androidsdk/IMAdView:B	Lcom/inmobi/androidsdk/IMAdView$a;
    //   240: bipush 100
    //   242: invokevirtual 626	com/inmobi/androidsdk/IMAdView$a:removeMessages	(I)V
    //   245: aload_0
    //   246: getfield 623	com/inmobi/androidsdk/IMAdView:z	Lcom/inmobi/androidsdk/impl/net/RequestResponseManager;
    //   249: aload_0
    //   250: getfield 475	com/inmobi/androidsdk/IMAdView:g	Lcom/inmobi/androidsdk/impl/UserInfo;
    //   253: getstatic 760	com/inmobi/androidsdk/impl/net/RequestResponseManager$ActionType:AdRequest	Lcom/inmobi/androidsdk/impl/net/RequestResponseManager$ActionType;
    //   256: aload_0
    //   257: getfield 135	com/inmobi/androidsdk/IMAdView:y	Ljava/lang/String;
    //   260: aload_0
    //   261: getfield 146	com/inmobi/androidsdk/IMAdView:D	Lcom/inmobi/androidsdk/impl/net/HttpRequestCallback;
    //   264: invokevirtual 764	com/inmobi/androidsdk/impl/net/RequestResponseManager:asyncRequestAd	(Lcom/inmobi/androidsdk/impl/UserInfo;Lcom/inmobi/androidsdk/impl/net/RequestResponseManager$ActionType;Ljava/lang/String;Lcom/inmobi/androidsdk/impl/net/HttpRequestCallback;)V
    //   267: goto -174 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	IMAdView
    //   34	17	1	str	String
    //   96	7	1	localException1	Exception
    //   109	4	1	localObject	Object
    //   133	7	1	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   24	63	96	java/lang/Exception
    //   2	24	109	finally
    //   24	63	109	finally
    //   63	71	109	finally
    //   71	93	109	finally
    //   97	106	109	finally
    //   114	130	109	finally
    //   134	143	109	finally
    //   146	162	109	finally
    //   165	181	109	finally
    //   184	208	109	finally
    //   208	267	109	finally
    //   71	93	133	java/lang/Exception
    //   114	130	133	java/lang/Exception
    //   146	162	133	java/lang/Exception
    //   165	181	133	java/lang/Exception
    //   184	208	133	java/lang/Exception
    //   208	267	133	java/lang/Exception
  }
  
  public void loadNewAd(IMAdRequest paramIMAdRequest)
  {
    if (paramIMAdRequest != null) {
      setIMAdRequest(paramIMAdRequest);
    }
    loadNewAd();
  }
  
  protected void onAttachedToWindow()
  {
    Log.debug("InMobiAndroidSDK_3.7.1", "onAttachedToWindow");
    this.w = true;
    c();
    setRefreshInterval(this.a);
  }
  
  protected void onDetachedFromWindow()
  {
    Log.debug("InMobiAndroidSDK_3.7.1", "onDetatchedFromWindow");
    this.w = false;
    setRefreshInterval(-1);
    if (i()) {}
    for (IMWebView localIMWebView = this.c;; localIMWebView = this.b)
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
    if (paramInt == 0)
    {
      l();
      ThinICE.start(this.e);
      RequestResponseManager localRequestResponseManager = new RequestResponseManager();
      localRequestResponseManager.init();
      localRequestResponseManager.processClickInBackground(this.e.getApplicationContext());
    }
  }
  
  @Deprecated
  public void setAdBackgroundColor(String paramString) {}
  
  @Deprecated
  public void setAdBackgroundGradientColor(String paramString1, String paramString2) {}
  
  public void setAdSize(int paramInt)
  {
    a(paramInt);
    this.q = paramInt;
  }
  
  @Deprecated
  public void setAdTextColor(String paramString) {}
  
  public void setAnimationType(AnimationType paramAnimationType)
  {
    this.v = paramAnimationType;
  }
  
  public void setAppId(String paramString)
  {
    SDKUtil.validateAppID(paramString);
    this.p = paramString;
  }
  
  public void setIMAdListener(IMAdListener paramIMAdListener)
  {
    this.n = paramIMAdListener;
  }
  
  public void setIMAdRequest(IMAdRequest paramIMAdRequest)
  {
    this.o = paramIMAdRequest;
  }
  
  public void setRefTagParam(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      throw new NullPointerException("Key or Value cannot be null");
    }
    if ((paramString1.trim().equals("")) || (paramString2.trim().equals(""))) {
      throw new IllegalArgumentException("Key or Value cannot be empty");
    }
    if (this.g != null)
    {
      this.g.setRefTagKey(paramString1.toLowerCase(Locale.ENGLISH));
      this.g.setRefTagValue(paramString2.toLowerCase(Locale.ENGLISH));
    }
  }
  
  public void setRefreshInterval(int paramInt)
  {
    if (paramInt == -1)
    {
      this.a = -1;
      this.B.removeMessages(100);
      return;
    }
    int i1 = Initializer.getConfigParams(getContext()).getMinimumRefreshRate();
    if (paramInt < i1)
    {
      Log.debug("InMobiAndroidSDK_3.7.1", "Refresh Interval cannot be less than " + i1 + " seconds. Setting refresh rate to " + i1);
      this.a = 0;
    }
    this.a = paramInt;
    k();
  }
  
  public void setSlotId(long paramLong)
  {
    this.r = paramLong;
  }
  
  public void stopLoading()
  {
    if (this.B.hasMessages(107))
    {
      this.B.removeMessages(107);
      this.B.sendEmptyMessage(107);
    }
    while (!this.B.hasMessages(108)) {
      return;
    }
    this.B.removeMessages(108);
    this.B.sendEmptyMessage(108);
  }
  
  public static enum AnimationType
  {
    private AnimationType() {}
  }
  
  static class a
    extends Handler
  {
    private final WeakReference<IMAdView> a;
    
    public a(IMAdView paramIMAdView)
    {
      this.a = new WeakReference(paramIMAdView);
    }
    
    public void handleMessage(Message paramMessage)
    {
      IMAdView localIMAdView = (IMAdView)this.a.get();
      if (localIMAdView != null) {
        switch (paramMessage.what)
        {
        }
      }
      for (;;)
      {
        super.handleMessage(paramMessage);
        long l1;
        long l2;
        Object localObject;
        do
        {
          return;
          if (IMAdView.c(localIMAdView))
          {
            l1 = System.currentTimeMillis();
            l2 = IMAdView.d(localIMAdView);
            localObject = new JSONObject();
          }
          try
          {
            ((JSONObject)localObject).put("ad", IMAdView.e(localIMAdView));
            ((JSONObject)localObject).put("t", l1 - l2);
            Logger.logEvent(localIMAdView.getContext().getApplicationContext(), new EventLog(EventType.FETCH_COMPLETE, (JSONObject)localObject));
            removeMessages(107);
            IMAdView.a(localIMAdView, IMAdView.f(localIMAdView));
          }
          catch (JSONException localJSONException1)
          {
            for (;;)
            {
              Log.internal("InMobiAndroidSDK_3.7.1", "Error creating metric logs for fetch_complete at " + System.currentTimeMillis());
            }
          }
          removeMessages(107);
          IMAdView.a(localIMAdView, 101, (IMAdRequest.ErrorCode)paramMessage.obj);
          IMAdView.a(localIMAdView, false);
          break;
          removeMessages(108);
          removeMessages(101);
          IMAdView.a(localIMAdView, 101, IMAdRequest.ErrorCode.INTERNAL_ERROR);
          break;
          if (IMAdView.c(localIMAdView))
          {
            l1 = System.currentTimeMillis();
            l2 = IMAdView.g(localIMAdView);
            localObject = new JSONObject();
          }
          try
          {
            ((JSONObject)localObject).put("ad", IMAdView.e(localIMAdView));
            ((JSONObject)localObject).put("t", l1 - l2);
            Logger.logEvent(localIMAdView.getContext().getApplicationContext(), new EventLog(EventType.RENDER_TIMEOUT, (JSONObject)localObject));
            removeMessages(111);
            removeMessages(101);
            IMAdView.a(localIMAdView, false);
            if (IMAdView.h(localIMAdView))
            {
              localObject = IMAdView.i(localIMAdView);
              IMAdView.a(localIMAdView, null);
              ((IMWebView)localObject).cancelLoad();
              ((IMWebView)localObject).stopLoading();
              ((IMWebView)localObject).deinit();
              IMAdView.a(localIMAdView, 101, IMAdRequest.ErrorCode.AD_RENDERING_TIMEOUT);
            }
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              Log.internal("InMobiAndroidSDK_3.7.1", "Error creating metric logs for fetch_complete at " + System.currentTimeMillis());
              continue;
              localObject = IMAdView.j(localIMAdView);
              IMAdView.b(localIMAdView, null);
            }
          }
          removeMessages(109);
          removeMessages(110);
          IMAdView.k(localIMAdView).doCancel();
          l1 = System.currentTimeMillis();
          l2 = IMAdView.d(localIMAdView);
          if (IMAdView.c(localIMAdView)) {
            localObject = new JSONObject();
          }
          try
          {
            ((JSONObject)localObject).put("t", l1 - l2);
            ((JSONObject)localObject).put("m", 1);
            Logger.logEvent(localIMAdView.getContext().getApplicationContext(), new EventLog(EventType.CONNECT_ERROR, (JSONObject)localObject));
            IMAdView.a(localIMAdView, false);
            IMAdView.a(localIMAdView, 101, IMAdRequest.ErrorCode.AD_FETCH_TIMEOUT);
          }
          catch (JSONException localJSONException3)
          {
            for (;;)
            {
              Log.internal("InMobiAndroidSDK_3.7.1", "Error creating metric logs for error at " + System.currentTimeMillis());
            }
          }
        } while (IMAdView.l(localIMAdView) == -1);
        if (!IMAdView.m(localIMAdView).hasWindowFocus()) {
          Log.debug("InMobiAndroidSDK_3.7.1", "Activity is not in the foreground. New ad will not be loaded.");
        }
        while (IMAdView.n(localIMAdView) != null)
        {
          IMAdView.n(localIMAdView).setRefreshType(1);
          break;
          if (MRAIDInterstitialController.isInterstitialDisplayed.get()) {
            Log.debug("InMobiAndroidSDK_3.7.1", "Ad cannot be loaded.Interstitial Ad is displayed.");
          } else {
            localIMAdView.loadNewAd();
          }
        }
        if (IMAdView.c(localIMAdView))
        {
          l1 = System.currentTimeMillis();
          l2 = IMAdView.d(localIMAdView);
          localObject = new JSONObject();
        }
        try
        {
          ((JSONObject)localObject).put("ad", IMAdView.e(localIMAdView));
          ((JSONObject)localObject).put("t", l1 - l2);
          Logger.logEvent(localIMAdView.getContext().getApplicationContext(), new EventLog(EventType.RENDER_COMPLETE, (JSONObject)localObject));
          removeMessages(108);
          if (IMAdView.o(localIMAdView))
          {
            IMAdView.p(localIMAdView);
            IMAdView.b(localIMAdView, false);
          }
        }
        catch (JSONException localJSONException4)
        {
          for (;;)
          {
            Log.internal("InMobiAndroidSDK_3.7.1", "Error creating metric logs for fetch_complete at " + System.currentTimeMillis());
          }
          if (IMAdView.q(localIMAdView) == IMAdView.AnimationType.ANIMATION_OFF)
          {
            IMAdView.p(localIMAdView);
            continue;
          }
          IMAdView.r(localIMAdView).a(IMAdView.q(localIMAdView));
        }
        continue;
        IMAdView.c(localIMAdView, false);
        continue;
        IMAdView.a(localIMAdView, 103, null);
        continue;
        IMAdView.a(localIMAdView, 102, null);
        continue;
        IMAdView.a(localIMAdView, 104, null);
      }
    }
  }
  
  class b
    implements Runnable
  {
    b(int paramInt, IMAdRequest.ErrorCode paramErrorCode) {}
    
    public void run()
    {
      try
      {
        switch (paramInt)
        {
        case 100: 
          Log.debug("InMobiAndroidSDK_3.7.1", paramErrorCode.toString());
          return;
        }
      }
      catch (Exception localException)
      {
        Log.debug("InMobiAndroidSDK_3.7.1", "Exception giving callback to the publisher ", localException);
        return;
      }
      IMAdView.a(IMAdView.this).onAdRequestCompleted(IMAdView.this);
      IMAdView.b(IMAdView.this);
      return;
      IMAdView.b(IMAdView.this);
      switch (IMAdView.c.a[paramErrorCode.ordinal()])
      {
      }
      for (;;)
      {
        Log.debug("InMobiAndroidSDK_3.7.1", paramErrorCode.toString());
        for (;;)
        {
          IMAdView.a(IMAdView.this).onAdRequestFailed(IMAdView.this, paramErrorCode);
          return;
          Log.debug("InMobiAndroidSDK_3.7.1", "Ad click in progress. Your request cannot be processed at this time. Try again later.");
          continue;
          Log.debug("InMobiAndroidSDK_3.7.1", "Ad download in progress. Your request cannot be processed at this time. Try again later.");
          continue;
          Log.debug("InMobiAndroidSDK_3.7.1", "Ad request successful, but no ad was returned due to lack of ad inventory.");
          continue;
          Log.debug("InMobiAndroidSDK_3.7.1", "Your App Id may be invalid or inactive. Please verify the app ID");
        }
        IMAdView.a(IMAdView.this).onDismissAdScreen(IMAdView.this);
        return;
        IMAdView.a(IMAdView.this).onShowAdScreen(IMAdView.this);
        return;
        IMAdView.a(IMAdView.this).onLeaveApplication(IMAdView.this);
        return;
        IMAdView.a(IMAdView.this).onShowAdScreen(IMAdView.this);
        return;
        IMAdView.a(IMAdView.this).onDismissAdScreen(IMAdView.this);
        return;
        break;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/IMAdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */