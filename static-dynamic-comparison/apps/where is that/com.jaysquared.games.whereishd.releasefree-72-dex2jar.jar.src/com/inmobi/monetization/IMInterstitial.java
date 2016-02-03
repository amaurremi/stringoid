package com.inmobi.monetization;

import android.app.Activity;
import android.os.Handler;
import com.inmobi.androidsdk.AdRequest;
import com.inmobi.androidsdk.AdRequest.ErrorCode;
import com.inmobi.androidsdk.InterstitialView;
import com.inmobi.androidsdk.InterstitialViewListener;
import com.inmobi.androidsdk.Mode;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsEndPointsConfig;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.ThinICE;
import com.inmobi.monetization.internal.LtvpRuleProcessor;
import com.inmobi.monetization.internal.LtvpRuleProcessor.ActionsRule;
import com.inmobi.monetization.internal.MonetizationUtils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class IMInterstitial
{
  private static LtvpRuleProcessor.ActionsRule f = null;
  InterstitialView a;
  LtvpRuleProcessor.ActionsRule b = LtvpRuleProcessor.ActionsRule.MEDIATION;
  AdMode c = AdMode.AD_NETWORK;
  boolean d = false;
  private IMInterstitialListener e;
  private long g = -1L;
  private Activity h;
  private AtomicBoolean i = new AtomicBoolean(false);
  private State j = State.INIT;
  private Handler k = new Handler();
  private String l = null;
  private String m = null;
  private Map<String, String> n = null;
  
  public IMInterstitial(Activity paramActivity, long paramLong)
  {
    this.g = paramLong;
    a(paramActivity);
  }
  
  public IMInterstitial(Activity paramActivity, String paramString)
  {
    a(paramActivity);
    this.l = paramString;
  }
  
  private LtvpRuleProcessor.ActionsRule a()
  {
    return LtvpRuleProcessor.getInstance().getLtvpRuleConfig(this.g);
  }
  
  private void a(long paramLong)
  {
    this.a = new InterstitialView(this.h, InMobi.getAppId(), paramLong);
    this.a.setIMAdInterstitialListener(new e());
  }
  
  private void a(Activity paramActivity)
  {
    this.h = paramActivity;
    if (!InternalSDKUtil.isInitializedSuccessfully()) {}
    for (;;)
    {
      return;
      try
      {
        ThinICE.start(this.h);
        if (this.g == -1L) {
          continue;
        }
        a();
        return;
      }
      catch (Exception paramActivity)
      {
        for (;;)
        {
          Log.internal("[InMobi]-[Network]-4.1.1", "Cannot start ice. Activity is null");
        }
      }
    }
  }
  
  private void b()
  {
    if (!InternalSDKUtil.isInitializedSuccessfully(false)) {}
    label136:
    do
    {
      do
      {
        return;
      } while ((this.i.get()) || ((getState() != State.READY) && (getState() != State.INIT)));
      d();
      if (this.g != -1L)
      {
        this.b = a();
        if (f != null) {
          this.b = f;
        }
        switch (a.a[this.b.ordinal()])
        {
        default: 
          e();
          this.k.post(new b());
        }
      }
    } while (this.a == null);
    MonetizationUtils.updateIMAdRequest(this.a.getIMAdRequest());
    if (this.n != null) {
      this.a.getIMAdRequest().setRequestParams(this.n);
    }
    if (this.m != null) {
      this.a.getIMAdRequest().setKeywords(this.m);
    }
    if (this.c == AdMode.AD_NETWORK) {}
    for (Mode localMode = Mode.AD_NETWORK;; localMode = Mode.APP_GALLERY)
    {
      this.a.setMode(localMode);
      if (!this.d) {
        break;
      }
      this.a.disableHardwareAcceleration();
      return;
      c();
      break label136;
      e();
      this.k.post(new d());
      break label136;
      e();
      this.k.post(new c());
      break label136;
    }
  }
  
  private void c()
  {
    d();
    this.a.setAdServerUrl(AnalyticsInitializer.getConfigParams().getEndPoints().getHouseUrl());
    this.a.setSlotId(this.g);
    Map localMap = MonetizationUtils.buildLtvpRequestMap(null);
    this.a.getIMAdRequest().setRequestParams(localMap);
    this.a.setAppId(InMobi.getAppId());
  }
  
  private void d()
  {
    if (this.a == null) {
      a(this.g);
    }
    if (this.l != null) {
      this.a.setAppId(this.l);
    }
  }
  
  private void e()
  {
    if (this.a != null)
    {
      this.a.setIMAdInterstitialListener(null);
      this.a = null;
    }
  }
  
  public void destroy()
  {
    if (this.a != null) {
      this.a.destroy();
    }
  }
  
  public void disableHardwareAcceleration()
  {
    this.d = true;
  }
  
  public State getState()
  {
    return this.j;
  }
  
  public void loadInterstitial()
  {
    if (!InternalSDKUtil.isInitializedSuccessfully()) {
      return;
    }
    b();
    if ((this.i.get()) || ((getState() != State.READY) && (getState() != State.INIT)))
    {
      final IMErrorCode localIMErrorCode = IMErrorCode.INVALID_REQUEST;
      if (this.i.get()) {}
      for (String str = "Interstitial load is already in progress.";; str = "Interstitial can only be loaded in init or ready state.")
      {
        localIMErrorCode.setMessage(str);
        this.k.post(new g(localIMErrorCode));
        Log.verbose("[InMobi]-[Monetization]", str);
        return;
      }
    }
    this.i.set(true);
    this.j = State.LOADING;
    Log.debug("[InMobi]-[Monetization]", "loading");
    if (this.a != null)
    {
      if ((this.l != null) || (this.g != -1L))
      {
        this.a.loadNewAd();
        return;
      }
      this.i.set(false);
      this.j = State.INIT;
      this.k.post(new f());
      return;
    }
    this.i.set(false);
  }
  
  public void setAppId(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      Log.debug("[InMobi]-[Network]-4.1.1", "AppId cannot be null or blank.");
      return;
    }
    if (this.g != -1L)
    {
      Log.debug("[InMobi]-[Network]-4.1.1", "A new appId cannot be set if a slotId is already set.");
      return;
    }
    this.l = paramString;
  }
  
  public void setIMInterstitialListener(IMInterstitialListener paramIMInterstitialListener)
  {
    this.e = paramIMInterstitialListener;
  }
  
  public void setKeywords(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      Log.debug("[InMobi]-[Network]-4.1.1", "Keywords cannot be null or blank.");
      return;
    }
    this.m = paramString;
  }
  
  public void setMode(AdMode paramAdMode)
  {
    if (paramAdMode != null)
    {
      this.c = paramAdMode;
      return;
    }
    Log.debug("[InMobi]-[Network]-4.1.1", "AdMode cannot be null.");
  }
  
  public void setRequestParams(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      Log.debug("[InMobi]-[Network]-4.1.1", "Request params cannot be null or empty.");
      return;
    }
    this.n = paramMap;
  }
  
  public void setSlotId(long paramLong)
  {
    if (paramLong == -1L) {
      Log.debug("[InMobi]-[Network]-4.1.1", "Invalid slotId : -1");
    }
    do
    {
      return;
      if ((this.g == -1L) && (this.l != null))
      {
        Log.debug("[InMobi]-[Network]-4.1.1", "A new slotId can be set only if a valid slotId is provided during object construction.");
        return;
      }
      this.g = paramLong;
    } while (this.a == null);
    this.a.setSlotId(this.g);
  }
  
  public void show()
  {
    if (this.a != null) {
      this.a.show();
    }
    try
    {
      ThinICE.start(this.h);
      return;
    }
    catch (Exception localException)
    {
      Log.internal("[InMobi]-[Network]-4.1.1", "Cannot start ice. Activity is null");
    }
  }
  
  public void stopLoading()
  {
    if (this.a != null) {
      this.a.stopLoading();
    }
  }
  
  public static enum AdMode
  {
    private AdMode() {}
  }
  
  public static enum State
  {
    private State() {}
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      if (IMInterstitial.a(IMInterstitial.this) != null) {
        IMInterstitial.a(IMInterstitial.this).onInterstitialFailed(IMInterstitial.this, IMErrorCode.NO_FILL);
      }
    }
  }
  
  class c
    implements Runnable
  {
    c() {}
    
    public void run()
    {
      IMInterstitial.b(IMInterstitial.this).set(false);
      IMInterstitial.a(IMInterstitial.this, IMInterstitial.State.INIT);
      if (IMInterstitial.a(IMInterstitial.this) != null) {
        IMInterstitial.a(IMInterstitial.this).onInterstitialFailed(IMInterstitial.this, IMErrorCode.DO_NOTHING);
      }
    }
  }
  
  class d
    implements Runnable
  {
    d() {}
    
    public void run()
    {
      IMInterstitial.b(IMInterstitial.this).set(false);
      IMInterstitial.a(IMInterstitial.this, IMInterstitial.State.INIT);
      if (IMInterstitial.a(IMInterstitial.this) != null) {
        IMInterstitial.a(IMInterstitial.this).onInterstitialFailed(IMInterstitial.this, IMErrorCode.DO_MONETIZE);
      }
    }
  }
  
  class e
    implements InterstitialViewListener
  {
    e() {}
    
    public void onAdRequestFailed(InterstitialView paramInterstitialView, AdRequest.ErrorCode paramErrorCode)
    {
      if (IMInterstitial.this.b == LtvpRuleProcessor.ActionsRule.ACTIONS_TO_MEDIATION) {
        if (IMInterstitial.a(IMInterstitial.this) != null) {
          IMInterstitial.a(IMInterstitial.this).onInterstitialFailed(IMInterstitial.this, IMErrorCode.DO_MONETIZE);
        }
      }
      for (;;)
      {
        IMInterstitial.b(IMInterstitial.this).set(false);
        IMInterstitial.a(IMInterstitial.this, IMInterstitial.State.INIT);
        return;
        if (IMInterstitial.a(IMInterstitial.this) != null) {
          IMInterstitial.a(IMInterstitial.this).onInterstitialFailed(IMInterstitial.this, MonetizationUtils.getErrorCode(paramErrorCode));
        }
      }
    }
    
    public void onAdRequestLoaded(InterstitialView paramInterstitialView)
    {
      IMInterstitial.a(IMInterstitial.this, IMInterstitial.State.READY);
      IMInterstitial.b(IMInterstitial.this).set(false);
      if (IMInterstitial.a(IMInterstitial.this) != null) {
        IMInterstitial.a(IMInterstitial.this).onInterstitialLoaded(IMInterstitial.this);
      }
    }
    
    public void onDismissAdScreen(InterstitialView paramInterstitialView)
    {
      IMInterstitial.a(IMInterstitial.this, IMInterstitial.State.INIT);
      if (IMInterstitial.a(IMInterstitial.this) != null) {
        IMInterstitial.a(IMInterstitial.this).onDismissInterstitialScreen(IMInterstitial.this);
      }
    }
    
    public void onInterstitialInteraction(InterstitialView paramInterstitialView, Map<String, String> paramMap)
    {
      if (IMInterstitial.a(IMInterstitial.this) != null) {
        IMInterstitial.a(IMInterstitial.this).onInterstitialInteraction(IMInterstitial.this, paramMap);
      }
    }
    
    public void onLeaveApplication(InterstitialView paramInterstitialView)
    {
      if (IMInterstitial.a(IMInterstitial.this) != null) {
        IMInterstitial.a(IMInterstitial.this).onLeaveApplication(IMInterstitial.this);
      }
    }
    
    public void onShowAdScreen(InterstitialView paramInterstitialView)
    {
      IMInterstitial.a(IMInterstitial.this, IMInterstitial.State.ACTIVE);
      if (IMInterstitial.a(IMInterstitial.this) != null) {
        IMInterstitial.a(IMInterstitial.this).onShowInterstitialScreen(IMInterstitial.this);
      }
    }
  }
  
  class f
    implements Runnable
  {
    f() {}
    
    public void run()
    {
      Log.debug("[InMobi]-[Network]-4.1.1", "AppId cannot be set to null");
      if (IMInterstitial.a(IMInterstitial.this) != null) {
        IMInterstitial.a(IMInterstitial.this).onInterstitialFailed(IMInterstitial.this, IMErrorCode.INVALID_REQUEST);
      }
    }
  }
  
  class g
    implements Runnable
  {
    g(IMErrorCode paramIMErrorCode) {}
    
    public void run()
    {
      if (IMInterstitial.a(IMInterstitial.this) != null) {
        IMInterstitial.a(IMInterstitial.this).onInterstitialFailed(IMInterstitial.this, localIMErrorCode);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/monetization/IMInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */