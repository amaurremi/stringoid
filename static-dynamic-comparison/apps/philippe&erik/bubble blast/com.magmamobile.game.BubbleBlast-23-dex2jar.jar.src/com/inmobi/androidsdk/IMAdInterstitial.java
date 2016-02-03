package com.inmobi.androidsdk;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.inmobi.androidsdk.ai.container.IMWebView;
import com.inmobi.androidsdk.ai.container.IMWebView.IMWebViewListener;
import com.inmobi.androidsdk.ai.container.IMWrapperFunctions;
import com.inmobi.androidsdk.ai.controller.util.IMConfigException;
import com.inmobi.androidsdk.ai.controller.util.IMSDKUtil;
import com.inmobi.androidsdk.impl.IMAdUnit;
import com.inmobi.androidsdk.impl.IMAdUnit.AdTypes;
import com.inmobi.androidsdk.impl.IMNiceInfo;
import com.inmobi.androidsdk.impl.IMUserInfo;
import com.inmobi.androidsdk.impl.net.IMHttpRequestCallback;
import com.inmobi.androidsdk.impl.net.IMRequestResponseManager;
import com.inmobi.androidsdk.impl.net.IMRequestResponseManager.ActionType;
import com.inmobi.commons.internal.IMLog;
import com.inmobi.commons.internal.InternalSDKUtil;
import java.lang.ref.WeakReference;

public class IMAdInterstitial
{
  private State a = State.INIT;
  private IMAdRequest b;
  private Activity c;
  private String d;
  private long e = -1L;
  private IMAdInterstitialListener f;
  private IMAdUnit g;
  private IMUserInfo h;
  private IMNiceInfo i;
  private IMWebView j;
  private String k = "http://i.w.inmobi.com/showad.asm";
  private String l = "http://i.w.sandbox.inmobi.com/showad.asm";
  private String m;
  private IMRequestResponseManager n;
  private IMHttpRequestCallback o = new IMHttpRequestCallback()
  {
    public void notifyResult(int paramAnonymousInt, Object paramAnonymousObject)
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", ">>> Got HTTP REQUEST callback. Status: " + paramAnonymousInt + " ,data=" + paramAnonymousObject);
      if (paramAnonymousInt == 0)
      {
        IMAdInterstitial.a(IMAdInterstitial.this, (IMAdUnit)paramAnonymousObject);
        IMAdInterstitial.a(IMAdInterstitial.this).sendEmptyMessage(308);
      }
      while (paramAnonymousInt != 1) {
        return;
      }
      Message localMessage = IMAdInterstitial.a(IMAdInterstitial.this).obtainMessage(309);
      localMessage.obj = paramAnonymousObject;
      localMessage.sendToTarget();
    }
  };
  private a p = new a(this);
  private IMWebView.IMWebViewListener q = new IMWebView.IMWebViewListener()
  {
    public void onDismissAdScreen()
    {
      IMAdInterstitial.a(IMAdInterstitial.this, 103, null);
    }
    
    public void onError()
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "Error loading the interstitial ad ");
      IMAdInterstitial.a(IMAdInterstitial.this).sendEmptyMessage(310);
    }
    
    public void onExpand() {}
    
    public void onExpandClose() {}
    
    public void onLeaveApplication()
    {
      IMAdInterstitial.a(IMAdInterstitial.this, 104, null);
    }
    
    public void onShowAdScreen()
    {
      IMAdInterstitial.a(IMAdInterstitial.this, 102, null);
    }
  };
  
  public IMAdInterstitial(Activity paramActivity, String paramString)
  {
    String str = Integer.toString(InternalSDKUtil.incrementBaseUrl());
    this.m = ("http://localhost/" + str + "/");
    a(paramActivity, paramString);
  }
  
  public IMAdInterstitial(Activity paramActivity, String paramString, long paramLong)
  {
    String str = Integer.toString(InternalSDKUtil.incrementBaseUrl());
    this.m = ("http://localhost/" + str + "/");
    this.e = paramLong;
    a(paramActivity, paramString);
  }
  
  private void a(final int paramInt, final IMAdRequest.ErrorCode paramErrorCode)
  {
    if (this.f == null) {
      return;
    }
    this.c.runOnUiThread(new Runnable()
    {
      public void run()
      {
        switch (paramInt)
        {
        default: 
          return;
        case 100: 
          IMAdInterstitial.g(IMAdInterstitial.this).onAdRequestLoaded(IMAdInterstitial.this);
          return;
        case 101: 
          switch (a()[paramErrorCode.ordinal()])
          {
          }
          for (;;)
          {
            IMAdInterstitial.g(IMAdInterstitial.this).onAdRequestFailed(IMAdInterstitial.this, paramErrorCode);
            return;
            IMLog.debug("InMobiAndroidSDK_3.6.1", "Ad click in progress. Your request cannot be processed at this time. Try again later.");
            continue;
            IMLog.debug("InMobiAndroidSDK_3.6.1", "Ad download in progress. Your request cannot be processed at this time. Try again later.");
          }
        case 103: 
          IMAdInterstitial.g(IMAdInterstitial.this).onDismissAdScreen(IMAdInterstitial.this);
          return;
        case 102: 
          IMAdInterstitial.g(IMAdInterstitial.this).onShowAdScreen(IMAdInterstitial.this);
          return;
        }
        IMAdInterstitial.g(IMAdInterstitial.this).onLeaveApplication(IMAdInterstitial.this);
      }
    });
  }
  
  private void a(Activity paramActivity, String paramString)
  {
    if (paramActivity == null) {
      throw new NullPointerException("Activity cannot be null");
    }
    try
    {
      IMSDKUtil.validateAdConfiguration(paramActivity);
      IMSDKUtil.validateAppID(paramString);
      this.c = IMSDKUtil.getRootActivity(paramActivity);
      this.d = paramString;
      c();
      return;
    }
    catch (IMConfigException localIMConfigException)
    {
      for (;;)
      {
        localIMConfigException.printStackTrace();
      }
    }
  }
  
  private void a(IMAdUnit paramIMAdUnit)
  {
    if ((paramIMAdUnit != null) && (IMAdUnit.AdTypes.NONE != paramIMAdUnit.getAdType()) && (paramIMAdUnit.getCDATABlock() != null))
    {
      paramIMAdUnit = paramIMAdUnit.getCDATABlock().replaceAll("%", "%25");
      IMLog.debug("InMobiAndroidSDK_3.6.1", "Final HTML String: " + paramIMAdUnit);
      this.j.requestOnPageFinishedCallback(this.p.obtainMessage(303));
      this.p.sendEmptyMessageDelayed(307, 60000L);
      this.j.loadDataWithBaseURL(this.m, "<html><head><meta name=\"viewport\" content=\"width=device-width,initial-scale=1,user-scalable=no,maximum-scale=1\"><meta http-equiv=\"Content-Type\" content=\"text/html charset=utf-16le\"></head><body style=\"margin:0;padding:0\">" + paramIMAdUnit + "</body></html>", "text/html", null, this.m);
      return;
    }
    this.a = State.INIT;
    IMLog.debug("InMobiAndroidSDK_3.6.1", "Cannot load Ad. Invalid Ad Response");
    a(101, IMAdRequest.ErrorCode.INTERNAL_ERROR);
  }
  
  private boolean a()
  {
    if (this.b == null) {}
    for (boolean bool = false; (!bool) && (!InternalSDKUtil.validateAppId(this.d)); bool = this.b.isTestMode()) {
      return false;
    }
    return true;
  }
  
  private void b()
  {
    if (this.i == null) {
      this.i = new IMNiceInfo(this.c.getApplicationContext(), this.h);
    }
  }
  
  private void c()
  {
    int i1;
    if (this.h == null)
    {
      this.h = new IMUserInfo(this.c);
      Object localObject = new DisplayMetrics();
      this.c.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      float f1 = ((DisplayMetrics)localObject).density;
      localObject = ((WindowManager)this.c.getSystemService("window")).getDefaultDisplay();
      i1 = IMWrapperFunctions.getDisplayWidth((Display)localObject);
      int i2 = IMWrapperFunctions.getDisplayHeight((Display)localObject);
      this.h.setScreenDensity(String.valueOf(f1));
      this.h.setScreenSize(i1 + "X" + i2);
    }
    try
    {
      if (this.h.getPhoneDefaultUserAgent().equals("")) {
        this.h.setPhoneDefaultUserAgent(InternalSDKUtil.getUserAgent(this.c));
      }
      this.h.updateInfo(this.d, this.b);
      i1 = 14;
      if ((Build.VERSION.SDK_INT == 11) || (Build.VERSION.SDK_INT == 12) || (Build.VERSION.SDK_INT == 13)) {
        i1 = 17;
      }
      this.h.setAdUnitSlot(String.valueOf(i1));
      if (this.e != -1L) {
        this.h.setSlotId(Long.toString(this.e));
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        IMLog.debug("InMobiAndroidSDK_3.6.1", "Exception occured while setting user agent" + localException);
      }
    }
  }
  
  private void setAdServerTestUrl(String paramString)
  {
    this.l = paramString;
  }
  
  private void setAdServerUrl(String paramString)
  {
    this.k = paramString;
  }
  
  public String getAppId()
  {
    return this.d;
  }
  
  public IMAdInterstitialListener getIMAdInterstitialListener()
  {
    return this.f;
  }
  
  public IMAdRequest getIMAdRequest()
  {
    return this.b;
  }
  
  public long getSlotId()
  {
    return this.e;
  }
  
  public State getState()
  {
    return this.a;
  }
  
  public void loadNewAd()
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", " >>>> Start loading new Interstitial Ad <<<<");
    if (!a())
    {
      a(101, IMAdRequest.ErrorCode.INVALID_REQUEST);
      return;
    }
    if (this.a == State.LOADING)
    {
      a(101, IMAdRequest.ErrorCode.AD_DOWNLOAD_IN_PROGRESS);
      return;
    }
    if (this.a == State.ACTIVE)
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "Interstitial ad is in ACTIVE state. Try again after sometime.");
      a(101, IMAdRequest.ErrorCode.INVALID_REQUEST);
      return;
    }
    this.a = State.LOADING;
    c();
    b();
    this.p.sendEmptyMessageDelayed(306, 60000L);
    this.n = new IMRequestResponseManager();
    this.n.asyncRequestAd(this.h, this.i, IMRequestResponseManager.ActionType.AdRequest_Interstitial, this.k, this.l, this.o);
  }
  
  public void loadNewAd(IMAdRequest paramIMAdRequest)
  {
    this.b = paramIMAdRequest;
    loadNewAd();
  }
  
  public void setAppId(String paramString)
  {
    IMSDKUtil.validateAppID(paramString);
    this.d = paramString;
  }
  
  public void setIMAdInterstitialListener(IMAdInterstitialListener paramIMAdInterstitialListener)
  {
    this.f = paramIMAdInterstitialListener;
  }
  
  public void setIMAdRequest(IMAdRequest paramIMAdRequest)
  {
    this.b = paramIMAdRequest;
  }
  
  public void setSlotId(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void show()
  {
    do
    {
      try
      {
        IMLog.debug("InMobiAndroidSDK_3.6.1", "Showing the Interstitial Ad. ");
        if (this.a != State.READY) {
          throw new IllegalStateException("Interstitial ad is not in the 'READY' state. Current state: " + this.a);
        }
      }
      catch (Exception localException)
      {
        IMLog.debug("InMobiAndroidSDK_3.6.1", "Error showing ad ", localException);
        return;
      }
    } while (this.g == null);
    this.j.setAdUnitData(false, null);
    this.j.requestOnInterstitialClosed(this.p.obtainMessage(304));
    this.j.requestOnInterstitialShown(this.p.obtainMessage(305));
    this.j.changeContentAreaForInterstitials(false);
  }
  
  public void stopLoading()
  {
    if (this.p.hasMessages(306))
    {
      this.p.removeMessages(306);
      this.p.sendEmptyMessage(306);
    }
    while (!this.p.hasMessages(307)) {
      return;
    }
    this.p.removeMessages(307);
    this.p.sendEmptyMessage(307);
  }
  
  public static enum State
  {
    static
    {
      LOADING = new State("LOADING", 2);
    }
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
      switch (paramMessage.what)
      {
      default: 
        return;
      case 308: 
        removeMessages(306);
        try
        {
          if (IMAdInterstitial.b(localIMAdInterstitial) == null) {
            IMAdInterstitial.a(localIMAdInterstitial, new IMWebView(IMAdInterstitial.c(localIMAdInterstitial), IMAdInterstitial.d(localIMAdInterstitial), true, false));
          }
          IMAdInterstitial.b(localIMAdInterstitial, IMAdInterstitial.e(localIMAdInterstitial));
          return;
        }
        catch (Exception paramMessage)
        {
          IMLog.debug("InMobiAndroidSDK_3.6.1", "Error retrieving ad ", paramMessage);
          IMAdInterstitial.a(localIMAdInterstitial, IMAdInterstitial.State.INIT);
          IMAdInterstitial.a(localIMAdInterstitial, 101, IMAdRequest.ErrorCode.INTERNAL_ERROR);
          return;
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
        IMAdInterstitial.b(localIMAdInterstitial).cancelLoad();
        IMAdInterstitial.b(localIMAdInterstitial).stopLoading();
        IMAdInterstitial.b(localIMAdInterstitial).deinit();
        IMAdInterstitial.a(localIMAdInterstitial, null);
        IMAdInterstitial.a(localIMAdInterstitial, 101, IMAdRequest.ErrorCode.AD_RENDERING_TIMEOUT);
        return;
      case 306: 
        removeMessages(308);
        removeMessages(309);
        IMAdInterstitial.a(localIMAdInterstitial, IMAdInterstitial.State.INIT);
        IMAdInterstitial.f(localIMAdInterstitial).doCancel();
        IMAdInterstitial.a(localIMAdInterstitial, 101, IMAdRequest.ErrorCode.AD_FETCH_TIMEOUT);
        return;
      case 303: 
        removeMessages(307);
        IMAdInterstitial.a(localIMAdInterstitial, IMAdInterstitial.State.READY);
        IMAdInterstitial.a(localIMAdInterstitial, 100, null);
        return;
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/androidsdk/IMAdInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */