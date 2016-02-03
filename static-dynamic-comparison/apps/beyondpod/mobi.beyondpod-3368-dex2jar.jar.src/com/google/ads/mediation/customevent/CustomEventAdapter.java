package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.internal.ct;

public final class CustomEventAdapter
  implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters>
{
  private View m;
  private CustomEventBanner n;
  private CustomEventInterstitial o;
  
  private static <T> T a(String paramString)
  {
    try
    {
      Object localObject = Class.forName(paramString).newInstance();
      return (T)localObject;
    }
    catch (Throwable localThrowable)
    {
      ct.v("Could not instantiate custom event adapter: " + paramString + ". " + localThrowable.getMessage());
    }
    return null;
  }
  
  private void a(View paramView)
  {
    this.m = paramView;
  }
  
  public void destroy()
  {
    if (this.n != null) {
      this.n.destroy();
    }
    if (this.o != null) {
      this.o.destroy();
    }
  }
  
  public Class<CustomEventExtras> getAdditionalParametersType()
  {
    return CustomEventExtras.class;
  }
  
  public View getBannerView()
  {
    return this.m;
  }
  
  public Class<CustomEventServerParameters> getServerParametersType()
  {
    return CustomEventServerParameters.class;
  }
  
  public void requestBannerAd(MediationBannerListener paramMediationBannerListener, Activity paramActivity, CustomEventServerParameters paramCustomEventServerParameters, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, CustomEventExtras paramCustomEventExtras)
  {
    this.n = ((CustomEventBanner)a(paramCustomEventServerParameters.className));
    if (this.n == null)
    {
      paramMediationBannerListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
      return;
    }
    if (paramCustomEventExtras == null) {}
    for (paramCustomEventExtras = null;; paramCustomEventExtras = paramCustomEventExtras.getExtra(paramCustomEventServerParameters.label))
    {
      this.n.requestBannerAd(new a(this, paramMediationBannerListener), paramActivity, paramCustomEventServerParameters.label, paramCustomEventServerParameters.parameter, paramAdSize, paramMediationAdRequest, paramCustomEventExtras);
      return;
    }
  }
  
  public void requestInterstitialAd(MediationInterstitialListener paramMediationInterstitialListener, Activity paramActivity, CustomEventServerParameters paramCustomEventServerParameters, MediationAdRequest paramMediationAdRequest, CustomEventExtras paramCustomEventExtras)
  {
    this.o = ((CustomEventInterstitial)a(paramCustomEventServerParameters.className));
    if (this.o == null)
    {
      paramMediationInterstitialListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
      return;
    }
    if (paramCustomEventExtras == null) {}
    for (paramCustomEventExtras = null;; paramCustomEventExtras = paramCustomEventExtras.getExtra(paramCustomEventServerParameters.label))
    {
      this.o.requestInterstitialAd(new b(this, paramMediationInterstitialListener), paramActivity, paramCustomEventServerParameters.label, paramCustomEventServerParameters.parameter, paramMediationAdRequest, paramCustomEventExtras);
      return;
    }
  }
  
  public void showInterstitial()
  {
    this.o.showInterstitial();
  }
  
  private static final class a
    implements CustomEventBannerListener
  {
    private final MediationBannerListener k;
    private final CustomEventAdapter p;
    
    public a(CustomEventAdapter paramCustomEventAdapter, MediationBannerListener paramMediationBannerListener)
    {
      this.p = paramCustomEventAdapter;
      this.k = paramMediationBannerListener;
    }
    
    public void onClick()
    {
      ct.r("Custom event adapter called onFailedToReceiveAd.");
      this.k.onClick(this.p);
    }
    
    public void onDismissScreen()
    {
      ct.r("Custom event adapter called onFailedToReceiveAd.");
      this.k.onDismissScreen(this.p);
    }
    
    public void onFailedToReceiveAd()
    {
      ct.r("Custom event adapter called onFailedToReceiveAd.");
      this.k.onFailedToReceiveAd(this.p, AdRequest.ErrorCode.NO_FILL);
    }
    
    public void onLeaveApplication()
    {
      ct.r("Custom event adapter called onFailedToReceiveAd.");
      this.k.onLeaveApplication(this.p);
    }
    
    public void onPresentScreen()
    {
      ct.r("Custom event adapter called onFailedToReceiveAd.");
      this.k.onPresentScreen(this.p);
    }
    
    public void onReceivedAd(View paramView)
    {
      ct.r("Custom event adapter called onReceivedAd.");
      CustomEventAdapter.a(this.p, paramView);
      this.k.onReceivedAd(this.p);
    }
  }
  
  private class b
    implements CustomEventInterstitialListener
  {
    private final MediationInterstitialListener l;
    private final CustomEventAdapter p;
    
    public b(CustomEventAdapter paramCustomEventAdapter, MediationInterstitialListener paramMediationInterstitialListener)
    {
      this.p = paramCustomEventAdapter;
      this.l = paramMediationInterstitialListener;
    }
    
    public void onDismissScreen()
    {
      ct.r("Custom event adapter called onDismissScreen.");
      this.l.onDismissScreen(this.p);
    }
    
    public void onFailedToReceiveAd()
    {
      ct.r("Custom event adapter called onFailedToReceiveAd.");
      this.l.onFailedToReceiveAd(this.p, AdRequest.ErrorCode.NO_FILL);
    }
    
    public void onLeaveApplication()
    {
      ct.r("Custom event adapter called onLeaveApplication.");
      this.l.onLeaveApplication(this.p);
    }
    
    public void onPresentScreen()
    {
      ct.r("Custom event adapter called onPresentScreen.");
      this.l.onPresentScreen(this.p);
    }
    
    public void onReceivedAd()
    {
      ct.r("Custom event adapter called onReceivedAd.");
      this.l.onReceivedAd(CustomEventAdapter.this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/ads/mediation/customevent/CustomEventAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */