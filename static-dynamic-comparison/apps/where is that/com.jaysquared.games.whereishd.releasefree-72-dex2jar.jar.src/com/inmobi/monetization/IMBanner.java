package com.inmobi.monetization;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.inmobi.androidsdk.AdRequest;
import com.inmobi.androidsdk.AdRequest.ErrorCode;
import com.inmobi.androidsdk.BannerView;
import com.inmobi.androidsdk.BannerViewListener;
import com.inmobi.androidsdk.bootstrapper.ConfigParams;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.commons.AnimationType;
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
import com.inmobi.re.container.mraidimpl.MRAIDInterstitialController;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class IMBanner
  extends RelativeLayout
{
  public static final int INMOBI_AD_UNIT_120X600 = 13;
  public static final int INMOBI_AD_UNIT_300X250 = 10;
  public static final int INMOBI_AD_UNIT_320X48 = 9;
  public static final int INMOBI_AD_UNIT_320X50 = 15;
  public static final int INMOBI_AD_UNIT_468X60 = 12;
  public static final int INMOBI_AD_UNIT_728X90 = 11;
  public static final int REFRESH_INTERVAL_MINIMUM = 0;
  public static final int REFRESH_INTERVAL_OFF = -1;
  private static LtvpRuleProcessor.ActionsRule j = null;
  BannerView a = null;
  LtvpRuleProcessor.ActionsRule b = LtvpRuleProcessor.ActionsRule.MEDIATION;
  BannerViewListener c = null;
  Activity d;
  long e = -1L;
  int f = 15;
  AnimationType g = null;
  boolean h = false;
  private AtomicBoolean i = new AtomicBoolean(false);
  private IMBannerListener k;
  private AtomicBoolean l = new AtomicBoolean(false);
  private String m = null;
  private String n = null;
  private String o = null;
  private Map<String, String> p = null;
  private String q = null;
  private int r = 0;
  private int s = 0;
  private a t = new a(this);
  
  public IMBanner(Activity paramActivity, long paramLong)
  {
    super(paramActivity);
    this.d = paramActivity;
    this.e = paramLong;
    a();
  }
  
  public IMBanner(Activity paramActivity, String paramString, int paramInt)
  {
    super(paramActivity);
    this.d = paramActivity;
    this.f = paramInt;
    this.q = paramString;
    a();
  }
  
  public IMBanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = ((Activity)paramContext);
    try
    {
      this.e = Long.parseLong(paramAttributeSet.getAttributeValue(null, "slotId"));
      try
      {
        this.f = Integer.parseInt(paramAttributeSet.getAttributeValue(null, "adSize"));
        try
        {
          this.q = paramAttributeSet.getAttributeValue(null, "appId");
          if ((this.e == -1L) && (this.q == null)) {
            Log.debug("[InMobi]-[Monetization]", "slotId and appId is missing in IMBanner xml layout. Please integrate using appId or slotId. Refer integration guidelines for more details.");
          }
          a();
          return;
        }
        catch (Exception paramContext)
        {
          for (;;) {}
        }
      }
      catch (Exception paramContext)
      {
        for (;;) {}
      }
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
  
  private void a()
  {
    setRefreshInterval(Initializer.getConfigParams().getDefaultRefreshRate());
    if (!InternalSDKUtil.isInitializedSuccessfully()) {}
    for (;;)
    {
      return;
      try
      {
        ThinICE.start(this.d);
        if (this.e == -1L) {
          continue;
        }
        b();
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.internal("[InMobi]-[Network]-4.1.1", "Cannot start ice. Activity is null");
        }
      }
    }
  }
  
  private void a(int paramInt)
  {
    this.r = paramInt;
    if (paramInt == -1)
    {
      this.t.removeMessages(100);
      return;
    }
    int i1 = Initializer.getConfigParams().getMinimumRefreshRate();
    if (paramInt < i1) {
      Log.debug("[InMobi]-[Network]-4.1.1", "Refresh Interval cannot be less than " + i1 + " seconds. Setting refresh rate to " + i1);
    }
    h();
  }
  
  private void a(boolean paramBoolean)
  {
    if (!InternalSDKUtil.isInitializedSuccessfully()) {
      return;
    }
    c();
    final Object localObject2;
    Object localObject1;
    if ((this.i.get()) || (this.l.get()))
    {
      localObject2 = IMErrorCode.INVALID_REQUEST;
      if (this.i.get()) {}
      for (localObject1 = "Banner load is already in progress.";; localObject1 = "Banner click in progress.")
      {
        ((IMErrorCode)localObject2).setMessage((String)localObject1);
        this.t.post(new d((IMErrorCode)localObject2));
        Log.verbose("[InMobi]-[Monetization]", (String)localObject1);
        h();
        return;
      }
    }
    this.i.set(true);
    this.t.removeMessages(100);
    if (this.a != null)
    {
      localObject2 = this.a.getIMAdRequest().getRequestParams();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new HashMap();
      }
      if (paramBoolean) {
        ((Map)localObject1).put("u-rt", "0");
      }
      for (;;)
      {
        this.a.getIMAdRequest().setRequestParams((Map)localObject1);
        if ((this.q == null) && (this.e == -1L)) {
          break;
        }
        this.a.loadNewAd();
        return;
        ((Map)localObject1).put("u-rt", "1");
      }
      this.i.set(false);
      this.t.post(new e());
      return;
    }
    this.i.set(false);
  }
  
  private LtvpRuleProcessor.ActionsRule b()
  {
    return LtvpRuleProcessor.getInstance().getLtvpRuleConfig(this.e);
  }
  
  private void c()
  {
    if (!InternalSDKUtil.isInitializedSuccessfully(false)) {}
    while ((this.i.get()) || (this.l.get())) {
      return;
    }
    e();
    if (this.e != -1L)
    {
      this.b = b();
      if (j != null) {
        this.b = j;
      }
      switch (f.a[this.b.ordinal()])
      {
      default: 
        g();
        this.t.post(new g());
      }
    }
    while (this.a != null)
    {
      MonetizationUtils.updateIMAdRequest(this.a.getIMAdRequest());
      if ((this.n != null) && (this.o != null)) {
        this.a.setRefTagParam(this.n, this.o);
      }
      if (this.p != null) {
        this.a.getIMAdRequest().setRequestParams(this.p);
      }
      if (this.m != null) {
        this.a.getIMAdRequest().setKeywords(this.m);
      }
      this.a.setAdSize(this.f);
      if (this.g != null) {
        this.a.setAnimationType(this.g);
      }
      if (!this.h) {
        break;
      }
      this.a.disableHardwareAcceleration();
      return;
      d();
      continue;
      g();
      this.t.post(new b());
      continue;
      g();
      this.t.post(new c());
    }
  }
  
  private void d()
  {
    this.a.setAdServerUrl(AnalyticsInitializer.getConfigParams().getEndPoints().getHouseUrl());
    this.a.setSlotId(this.e);
    Map localMap = MonetizationUtils.buildLtvpRequestMap(this);
    this.a.getIMAdRequest().setRequestParams(localMap);
    this.a.setAppId(InMobi.getAppId());
  }
  
  private void e()
  {
    if (this.a == null) {
      f();
    }
    if (this.q != null) {
      this.a.setAppId(this.q);
    }
  }
  
  private void f()
  {
    this.a = new BannerView(this.d, this.f, InMobi.getAppId(), -1L);
    MonetizationUtils.updateIMAdRequest(this.a.getIMAdRequest());
    this.c = new h();
    this.a.setIMAdListener(this.c);
    addView(this.a);
  }
  
  private void g()
  {
    if (this.a != null)
    {
      this.a.destroy();
      removeView(this.a);
      this.a = null;
      this.c = null;
    }
  }
  
  private void h()
  {
    this.t.removeMessages(100);
    if (this.r == -1) {
      return;
    }
    int i1 = Initializer.getConfigParams().getMinimumRefreshRate();
    if (this.r < i1)
    {
      this.t.sendEmptyMessageDelayed(100, i1 * 1000);
      return;
    }
    this.t.sendEmptyMessageDelayed(100, this.r * 1000);
  }
  
  public void destroy()
  {
    if (this.a != null) {
      this.a.destroy();
    }
  }
  
  public void disableHardwareAcceleration()
  {
    this.h = true;
  }
  
  public void loadBanner()
  {
    a(true);
  }
  
  protected final void onWindowVisibilityChanged(int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        ThinICE.start(this.d);
        a(this.s);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.internal("[InMobi]-[Network]-4.1.1", "Cannot start ice. Activity is null");
        }
      }
    }
    a(-1);
  }
  
  public void setAdSize(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setAnimationType(AnimationType paramAnimationType)
  {
    this.g = paramAnimationType;
  }
  
  public void setAppId(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      Log.debug("[InMobi]-[Network]-4.1.1", "AppId cannot be null or blank.");
      return;
    }
    if (this.e != -1L)
    {
      Log.debug("[InMobi]-[Network]-4.1.1", "A new appId cannot be set if a slotId is already set.");
      return;
    }
    this.q = paramString;
  }
  
  public void setIMBannerListener(IMBannerListener paramIMBannerListener)
  {
    this.k = paramIMBannerListener;
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
  
  public void setRefTagParam(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || ("".equals(paramString1.trim())))
    {
      Log.debug("[InMobi]-[Network]-4.1.1", "Ref tag key cannot be null or blank.");
      return;
    }
    if ((paramString2 == null) || ("".equals(paramString2.trim())))
    {
      Log.debug("[InMobi]-[Network]-4.1.1", "RefTag value cannot be null or blank.");
      return;
    }
    this.n = paramString1;
    this.o = paramString2;
  }
  
  public void setRefreshInterval(int paramInt)
  {
    this.s = paramInt;
    a(paramInt);
  }
  
  public void setRequestParams(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      Log.debug("[InMobi]-[Network]-4.1.1", "Request params cannot be null or empty.");
      return;
    }
    this.p = paramMap;
  }
  
  public void setSlotId(long paramLong)
  {
    if (paramLong == -1L) {
      Log.debug("[InMobi]-[Network]-4.1.1", "Invalid slotId : -1");
    }
    do
    {
      return;
      if ((this.e == -1L) && (this.q != null))
      {
        Log.debug("[InMobi]-[Network]-4.1.1", "A new slotId can be set only if a valid slotId is provided during object construction.");
        return;
      }
      this.e = paramLong;
    } while (this.a == null);
    this.a.setSlotId(this.e);
  }
  
  public void stopLoading()
  {
    if (this.a != null) {
      this.a.stopLoading();
    }
  }
  
  static class a
    extends Handler
  {
    private final WeakReference<IMBanner> a;
    
    public a(IMBanner paramIMBanner)
    {
      this.a = new WeakReference(paramIMBanner);
    }
    
    public void handleMessage(Message paramMessage)
    {
      IMBanner localIMBanner = (IMBanner)this.a.get();
      if (localIMBanner == null) {}
      do
      {
        return;
        switch (paramMessage.what)
        {
        default: 
          return;
        }
      } while (IMBanner.e(localIMBanner) == -1);
      if (!localIMBanner.d.hasWindowFocus())
      {
        Log.debug("[InMobi]-[Network]-4.1.1", "Activity is not in the foreground. New ad will not be loaded.");
        return;
      }
      if (MRAIDInterstitialController.isInterstitialDisplayed.get())
      {
        Log.debug("[InMobi]-[Network]-4.1.1", "Ad cannot be loaded.Interstitial Ad is displayed.");
        return;
      }
      IMBanner.a(localIMBanner, false);
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      if (IMBanner.a(IMBanner.this) != null) {
        IMBanner.a(IMBanner.this).onBannerRequestFailed(IMBanner.this, IMErrorCode.DO_MONETIZE);
      }
    }
  }
  
  class c
    implements Runnable
  {
    c() {}
    
    public void run()
    {
      if (IMBanner.a(IMBanner.this) != null) {
        IMBanner.a(IMBanner.this).onBannerRequestFailed(IMBanner.this, IMErrorCode.DO_NOTHING);
      }
    }
  }
  
  class d
    implements Runnable
  {
    d(IMErrorCode paramIMErrorCode) {}
    
    public void run()
    {
      if (IMBanner.a(IMBanner.this) != null) {
        IMBanner.a(IMBanner.this).onBannerRequestFailed(IMBanner.this, localObject2);
      }
    }
  }
  
  class e
    implements Runnable
  {
    e() {}
    
    public void run()
    {
      Log.debug("[InMobi]-[Network]-4.1.1", "AppId Not Set - Please call setAppId on the IMBanner object with a valid appId. For XML, please add \"appId\" attribute to the XML. Please refer integration guideline for more details.");
      if (IMBanner.a(IMBanner.this) != null) {
        IMBanner.a(IMBanner.this).onBannerRequestFailed(IMBanner.this, IMErrorCode.INVALID_REQUEST);
      }
      IMBanner.b(IMBanner.this);
    }
  }
  
  class g
    implements Runnable
  {
    g() {}
    
    public void run()
    {
      if (IMBanner.a(IMBanner.this) != null) {
        IMBanner.a(IMBanner.this).onBannerRequestFailed(IMBanner.this, IMErrorCode.NO_FILL);
      }
    }
  }
  
  class h
    implements BannerViewListener
  {
    h() {}
    
    public void onAdRequestCompleted(BannerView paramBannerView)
    {
      IMBanner.d(IMBanner.this).set(false);
      IMBanner.b(IMBanner.this);
      if (IMBanner.a(IMBanner.this) != null) {
        IMBanner.a(IMBanner.this).onBannerRequestSucceeded(IMBanner.this);
      }
    }
    
    public void onAdRequestFailed(BannerView paramBannerView, AdRequest.ErrorCode paramErrorCode)
    {
      if (IMBanner.this.b == LtvpRuleProcessor.ActionsRule.ACTIONS_TO_MEDIATION) {
        if (IMBanner.a(IMBanner.this) != null) {
          IMBanner.a(IMBanner.this).onBannerRequestFailed(IMBanner.this, IMErrorCode.DO_MONETIZE);
        }
      }
      for (;;)
      {
        IMBanner.d(IMBanner.this).set(false);
        IMBanner.b(IMBanner.this);
        return;
        if (IMBanner.a(IMBanner.this) != null) {
          IMBanner.a(IMBanner.this).onBannerRequestFailed(IMBanner.this, MonetizationUtils.getErrorCode(paramErrorCode));
        }
      }
    }
    
    public void onBannerInteraction(BannerView paramBannerView, Map<String, String> paramMap)
    {
      if (IMBanner.a(IMBanner.this) != null) {
        IMBanner.a(IMBanner.this).onBannerInteraction(IMBanner.this, paramMap);
      }
    }
    
    public void onDismissAdScreen(BannerView paramBannerView)
    {
      IMBanner.c(IMBanner.this).set(false);
      IMBanner.b(IMBanner.this);
      if (IMBanner.a(IMBanner.this) != null) {
        IMBanner.a(IMBanner.this).onDismissBannerScreen(IMBanner.this);
      }
    }
    
    public void onLeaveApplication(BannerView paramBannerView)
    {
      if (IMBanner.a(IMBanner.this) != null) {
        IMBanner.a(IMBanner.this).onLeaveApplication(IMBanner.this);
      }
    }
    
    public void onShowAdScreen(BannerView paramBannerView)
    {
      IMBanner.c(IMBanner.this).set(true);
      if (IMBanner.a(IMBanner.this) != null) {
        IMBanner.a(IMBanner.this).onShowBannerScreen(IMBanner.this);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/monetization/IMBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */