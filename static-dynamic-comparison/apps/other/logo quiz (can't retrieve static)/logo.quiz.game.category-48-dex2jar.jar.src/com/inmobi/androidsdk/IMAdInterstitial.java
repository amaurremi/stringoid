package com.inmobi.androidsdk;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.inmobi.androidsdk.bootstrapper.AppGalleryConfigParams;
import com.inmobi.androidsdk.bootstrapper.ConfigParams;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.androidsdk.impl.ConfigException;
import com.inmobi.androidsdk.impl.SDKUtil;
import com.inmobi.androidsdk.impl.UserInfo;
import com.inmobi.androidsdk.impl.imai.IMAIController;
import com.inmobi.androidsdk.impl.metric.EventLog;
import com.inmobi.androidsdk.impl.metric.EventType;
import com.inmobi.androidsdk.impl.metric.Logger;
import com.inmobi.androidsdk.impl.net.HttpRequestCallback;
import com.inmobi.androidsdk.impl.net.RequestResponseManager;
import com.inmobi.androidsdk.impl.net.RequestResponseManager.ActionType;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.ThinICE;
import com.inmobi.commons.uid.UIDHelper;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.IMWebView.IMWebViewListener;
import com.inmobi.re.container.WrapperFunctions;
import com.inmobi.re.container.mraidimpl.MRAIDInterstitialController;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class IMAdInterstitial
{
  long a = 0L;
  boolean b = true;
  private State c = State.INIT;
  private IMAdRequest d;
  private Activity e;
  private String f;
  private long g = -1L;
  private IMAdInterstitialListener h;
  private String i;
  private long j;
  private long k;
  private UserInfo l;
  private IMWebView m;
  private String n;
  private String o = "http://i.w.inmobi.com/showad.asm";
  private RequestResponseManager p;
  private AdMode q = AdMode.AD_NETWORK;
  private boolean r;
  private HttpRequestCallback s = new f(this);
  private a t = new a(this);
  private IMWebView.IMWebViewListener u = new e(this);
  
  public IMAdInterstitial(Activity paramActivity, String paramString)
  {
    a(paramActivity, paramString);
  }
  
  public IMAdInterstitial(Activity paramActivity, String paramString, long paramLong)
  {
    this.g = paramLong;
    a(paramActivity, paramString);
  }
  
  private void a(final int paramInt, final IMAdRequest.ErrorCode paramErrorCode)
  {
    if (this.h == null) {
      return;
    }
    this.e.runOnUiThread(new c(paramInt, paramErrorCode));
  }
  
  private void a(Activity paramActivity, String paramString)
  {
    if (paramActivity == null) {
      throw new NullPointerException("Activity cannot be null");
    }
    InternalSDKUtil.getUserAgent(paramActivity.getApplicationContext());
    try
    {
      SDKUtil.validateAdConfiguration(paramActivity);
      SDKUtil.validateAppID(paramString);
      this.e = SDKUtil.getRootActivity(paramActivity);
      IMWebView.setIMAIController(IMAIController.class);
    }
    catch (ConfigException localConfigException)
    {
      try
      {
        paramActivity = UIDHelper.getAndroidId(this.e.getApplicationContext());
        Log.debug("InMobiAndroidSDK_3.7.1", "Publisher device Id is " + UIDHelper.getODIN1(paramActivity));
        ThinICE.start(this.e);
        this.f = paramString;
        b();
        return;
        localConfigException = localConfigException;
        Log.internal("InMobiAndroidSDK_3.7.1", "IMConfigException occured while initializing interstitial while validating adConfig", localConfigException);
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
      this.m.requestOnPageFinishedCallback(this.t.obtainMessage(303));
      this.j = System.currentTimeMillis();
      this.t.sendEmptyMessageDelayed(307, Initializer.getConfigParams(this.e.getApplicationContext()).getRenderTimeOut());
      this.m.loadDataWithBaseURL("", paramString, "text/html", null, null);
      return;
    }
    this.c = State.INIT;
    Log.debug("InMobiAndroidSDK_3.7.1", "Cannot load Ad. Invalid Ad Response");
    a(101, IMAdRequest.ErrorCode.INTERNAL_ERROR);
  }
  
  private boolean a()
  {
    return (SDKUtil.getQAMode()) || (InternalSDKUtil.validateAppId(this.f));
  }
  
  private void b()
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
        Log.debug("InMobiAndroidSDK_3.7.1", "Exception occured while setting user agent" + localException);
      }
    }
  }
  
  private void setAdServerUrl(String paramString)
  {
    this.o = paramString;
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
        Log.debug("InMobiAndroidSDK_3.7.1", "Unable to destroy webview, or it has been destroyed already.");
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
  
  public IMAdInterstitialListener getIMAdInterstitialListener()
  {
    return this.h;
  }
  
  public IMAdRequest getIMAdRequest()
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
    Object localObject = Initializer.getConfigParams(this.e.getApplicationContext());
    this.r = Logger.startNewSample(this.e.getApplicationContext());
    Log.debug("InMobiAndroidSDK_3.7.1", " >>>> Start loading new Interstitial Ad <<<<");
    try
    {
      String str = UIDHelper.getAndroidId(this.e.getApplicationContext());
      Log.debug("InMobiAndroidSDK_3.7.1", "Publisher device Id is " + UIDHelper.getODIN1(str));
      if (!InternalSDKUtil.checkNetworkAvailibility(this.e.getApplicationContext()))
      {
        a(101, IMAdRequest.ErrorCode.NETWORK_ERROR);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.internal("InMobiAndroidSDK_3.7.1", "Cannot get publisher device id", localException);
      }
      if (!a())
      {
        a(101, IMAdRequest.ErrorCode.INVALID_REQUEST);
        return;
      }
      if (this.c == State.LOADING)
      {
        a(101, IMAdRequest.ErrorCode.AD_DOWNLOAD_IN_PROGRESS);
        return;
      }
      if (this.c == State.ACTIVE)
      {
        Log.debug("InMobiAndroidSDK_3.7.1", "Interstitial ad is in ACTIVE state. Try again after sometime.");
        a(101, IMAdRequest.ErrorCode.INVALID_REQUEST);
        return;
      }
      this.c = State.LOADING;
      b();
      this.a = System.currentTimeMillis();
      this.k = System.currentTimeMillis();
      this.t.sendEmptyMessageDelayed(306, ((ConfigParams)localObject).getFetchTimeOut());
      this.p = new RequestResponseManager();
      if (this.q != AdMode.APP_GALLERY) {}
    }
    for (localObject = ((ConfigParams)localObject).getAppAppGalleryConfigParams().getUrl();; localObject = this.o)
    {
      this.p.asyncRequestAd(this.l, RequestResponseManager.ActionType.AdRequest_Interstitial, (String)localObject, this.s);
      return;
    }
  }
  
  public void loadNewAd(IMAdRequest paramIMAdRequest)
  {
    this.d = paramIMAdRequest;
    loadNewAd();
  }
  
  public void setAppId(String paramString)
  {
    SDKUtil.validateAppID(paramString);
    this.f = paramString;
  }
  
  public void setIMAdInterstitialListener(IMAdInterstitialListener paramIMAdInterstitialListener)
  {
    this.h = paramIMAdInterstitialListener;
  }
  
  public void setIMAdRequest(IMAdRequest paramIMAdRequest)
  {
    this.d = paramIMAdRequest;
  }
  
  public void setMode(AdMode paramAdMode)
  {
    this.q = paramAdMode;
  }
  
  public void setSlotId(long paramLong)
  {
    this.g = paramLong;
  }
  
  public void show()
  {
    do
    {
      try
      {
        Log.debug("InMobiAndroidSDK_3.7.1", "Showing the Interstitial Ad. ");
        if (this.c != State.READY) {
          throw new IllegalStateException("Interstitial ad is not in the 'READY' state. Current state: " + this.c);
        }
      }
      catch (Exception localException)
      {
        Log.debug("InMobiAndroidSDK_3.7.1", "Error showing ad ", localException);
        return;
      }
    } while (this.i == null);
    this.m.requestOnInterstitialClosed(this.t.obtainMessage(304));
    this.m.requestOnInterstitialShown(this.t.obtainMessage(305));
    this.m.mInterstitialController.changeContentAreaForInterstitials();
    ThinICE.start(this.e);
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
  
  public static enum AdMode
  {
    private AdMode() {}
  }
  
  public static enum State
  {
    static
    {
      LOADING = new State("LOADING", 2);
    }
    
    private State() {}
  }
  
  static class a
    extends Handler
  {
    private final WeakReference<IMAdInterstitial> a;
    
    public a(IMAdInterstitial paramIMAdInterstitial)
    {
      this.a = new WeakReference(paramIMAdInterstitial);
    }
    
    public void handleMessage(Message paramMessage)
    {
      IMAdInterstitial localIMAdInterstitial = (IMAdInterstitial)this.a.get();
      if (localIMAdInterstitial != null) {}
      long l1;
      long l2;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 308: 
        if (IMAdInterstitial.d(localIMAdInterstitial))
        {
          l1 = System.currentTimeMillis();
          l2 = IMAdInterstitial.c(localIMAdInterstitial);
          paramMessage = new JSONObject();
        }
        try
        {
          paramMessage.put("ad", IMAdInterstitial.f(localIMAdInterstitial));
          paramMessage.put("t", l1 - l2);
          Logger.logEvent(IMAdInterstitial.e(localIMAdInterstitial).getApplicationContext(), new EventLog(EventType.FETCH_COMPLETE, paramMessage));
          removeMessages(306);
          try
          {
            if (IMAdInterstitial.g(localIMAdInterstitial) == null)
            {
              IMAdInterstitial.a(localIMAdInterstitial, new IMWebView(IMAdInterstitial.e(localIMAdInterstitial), IMAdInterstitial.h(localIMAdInterstitial), true, false));
              if (!localIMAdInterstitial.b) {
                IMAdInterstitial.g(localIMAdInterstitial).disableHardwareAcceleration();
              }
              IMAdInterstitial.g(localIMAdInterstitial).addJavascriptInterface(new IMAIController(IMAdInterstitial.g(localIMAdInterstitial)), "imaiController");
            }
            IMAdInterstitial.c(localIMAdInterstitial, IMAdInterstitial.i(localIMAdInterstitial));
            return;
          }
          catch (Exception paramMessage)
          {
            Log.debug("InMobiAndroidSDK_3.7.1", "Error retrieving ad ", paramMessage);
            IMAdInterstitial.a(localIMAdInterstitial, IMAdInterstitial.State.INIT);
            IMAdInterstitial.a(localIMAdInterstitial, 101, IMAdRequest.ErrorCode.INTERNAL_ERROR);
            return;
          }
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            Log.internal("InMobiAndroidSDK_3.7.1", "Error creating metric logs for fetch_complete at " + System.currentTimeMillis());
          }
        }
      case 309: 
        removeMessages(306);
        IMAdInterstitial.a(localIMAdInterstitial, IMAdInterstitial.State.INIT);
        IMAdInterstitial.a(localIMAdInterstitial, 101, (IMAdRequest.ErrorCode)paramMessage.obj);
        return;
      case 310: 
        removeMessages(307);
        removeMessages(303);
        IMAdInterstitial.a(localIMAdInterstitial, IMAdInterstitial.State.INIT);
        IMAdInterstitial.a(localIMAdInterstitial, null);
        IMAdInterstitial.a(localIMAdInterstitial, 101, IMAdRequest.ErrorCode.INTERNAL_ERROR);
        return;
      case 307: 
        removeMessages(310);
        removeMessages(303);
        IMAdInterstitial.a(localIMAdInterstitial, IMAdInterstitial.State.INIT);
        IMAdInterstitial.g(localIMAdInterstitial).cancelLoad();
        IMAdInterstitial.g(localIMAdInterstitial).stopLoading();
        IMAdInterstitial.g(localIMAdInterstitial).deinit();
        IMAdInterstitial.a(localIMAdInterstitial, null);
        if (IMAdInterstitial.d(localIMAdInterstitial))
        {
          l1 = System.currentTimeMillis();
          l2 = IMAdInterstitial.j(localIMAdInterstitial);
          paramMessage = new JSONObject();
        }
        try
        {
          paramMessage.put("ad", IMAdInterstitial.f(localIMAdInterstitial));
          paramMessage.put("t", l1 - l2);
          Logger.logEvent(IMAdInterstitial.e(localIMAdInterstitial).getApplicationContext(), new EventLog(EventType.RENDER_TIMEOUT, paramMessage));
          IMAdInterstitial.a(localIMAdInterstitial, 101, IMAdRequest.ErrorCode.AD_RENDERING_TIMEOUT);
          return;
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            Log.internal("InMobiAndroidSDK_3.7.1", "Error creating metric logs for fetch_complete at " + System.currentTimeMillis());
          }
        }
      case 306: 
        removeMessages(308);
        removeMessages(309);
        IMAdInterstitial.a(localIMAdInterstitial, IMAdInterstitial.State.INIT);
        l1 = System.currentTimeMillis();
        l2 = IMAdInterstitial.c(localIMAdInterstitial);
        if (IMAdInterstitial.d(localIMAdInterstitial)) {
          paramMessage = new JSONObject();
        }
        try
        {
          paramMessage.put("t", l1 - l2);
          paramMessage.put("m", 1);
          Logger.logEvent(IMAdInterstitial.e(localIMAdInterstitial).getApplicationContext(), new EventLog(EventType.CONNECT_ERROR, paramMessage));
          IMAdInterstitial.k(localIMAdInterstitial).doCancel();
          IMAdInterstitial.a(localIMAdInterstitial, 101, IMAdRequest.ErrorCode.AD_FETCH_TIMEOUT);
          return;
        }
        catch (JSONException localJSONException3)
        {
          for (;;)
          {
            Log.internal("InMobiAndroidSDK_3.7.1", "Error creating metric logs for error at " + System.currentTimeMillis());
          }
        }
      case 303: 
        if (IMAdInterstitial.d(localIMAdInterstitial))
        {
          l1 = System.currentTimeMillis();
          l2 = IMAdInterstitial.j(localIMAdInterstitial);
          paramMessage = new JSONObject();
        }
        try
        {
          paramMessage.put("ad", IMAdInterstitial.f(localIMAdInterstitial));
          paramMessage.put("t", l1 - l2);
          Logger.logEvent(IMAdInterstitial.e(localIMAdInterstitial).getApplicationContext(), new EventLog(EventType.RENDER_COMPLETE, paramMessage));
          removeMessages(307);
          IMAdInterstitial.a(localIMAdInterstitial, IMAdInterstitial.State.READY);
          IMAdInterstitial.a(localIMAdInterstitial, 100, null);
          return;
        }
        catch (JSONException localJSONException4)
        {
          for (;;)
          {
            Log.internal("InMobiAndroidSDK_3.7.1", "Error creating metric logs for RENDER_COMPLETE at " + System.currentTimeMillis());
          }
        }
      case 304: 
        IMAdInterstitial.a(localIMAdInterstitial, IMAdInterstitial.State.INIT);
        IMAdInterstitial.a(localIMAdInterstitial, 103, null);
        IMAdInterstitial.a(localIMAdInterstitial, null);
        return;
      }
      IMAdInterstitial.a(localIMAdInterstitial, IMAdInterstitial.State.ACTIVE);
      IMAdInterstitial.a(localIMAdInterstitial, 102, null);
    }
  }
  
  class c
    implements Runnable
  {
    c(int paramInt, IMAdRequest.ErrorCode paramErrorCode) {}
    
    public void run()
    {
      switch (paramInt)
      {
      default: 
        Log.debug("InMobiAndroidSDK_3.7.1", paramErrorCode.toString());
        return;
      case 100: 
        IMAdInterstitial.a(IMAdInterstitial.this).onAdRequestLoaded(IMAdInterstitial.this);
        return;
      case 101: 
        switch (IMAdInterstitial.b.a[paramErrorCode.ordinal()])
        {
        default: 
          Log.debug("InMobiAndroidSDK_3.7.1", paramErrorCode.toString());
        }
        for (;;)
        {
          IMAdInterstitial.a(IMAdInterstitial.this).onAdRequestFailed(IMAdInterstitial.this, paramErrorCode);
          return;
          Log.debug("InMobiAndroidSDK_3.7.1", "Ad click in progress. Your request cannot be processed at this time. Try again later.");
          continue;
          Log.debug("InMobiAndroidSDK_3.7.1", "Ad download in progress. Your request cannot be processed at this time. Try again later.");
        }
      case 103: 
        IMAdInterstitial.a(IMAdInterstitial.this).onDismissAdScreen(IMAdInterstitial.this);
        return;
      case 102: 
        IMAdInterstitial.a(IMAdInterstitial.this).onShowAdScreen(IMAdInterstitial.this);
        return;
      }
      IMAdInterstitial.a(IMAdInterstitial.this).onLeaveApplication(IMAdInterstitial.this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/IMAdInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */