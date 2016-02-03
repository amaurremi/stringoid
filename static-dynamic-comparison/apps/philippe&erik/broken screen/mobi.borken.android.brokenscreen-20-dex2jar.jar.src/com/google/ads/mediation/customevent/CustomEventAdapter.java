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
import com.google.android.gms.internal.ev;

public final class CustomEventAdapter
  implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters>
{
  private View n;
  private CustomEventBanner o;
  private CustomEventInterstitial p;
  
  private static <T> T a(String paramString)
  {
    try
    {
      Object localObject = Class.forName(paramString).newInstance();
      return (T)localObject;
    }
    catch (Throwable localThrowable)
    {
      ev.D("Could not instantiate custom event adapter: " + paramString + ". " + localThrowable.getMessage());
    }
    return null;
  }
  
  private void a(View paramView)
  {
    this.n = paramView;
  }
  
  public void destroy()
  {
    if (this.o != null) {
      this.o.destroy();
    }
    if (this.p != null) {
      this.p.destroy();
    }
  }
  
  public Class<CustomEventExtras> getAdditionalParametersType()
  {
    return CustomEventExtras.class;
  }
  
  public View getBannerView()
  {
    return this.n;
  }
  
  public Class<CustomEventServerParameters> getServerParametersType()
  {
    return CustomEventServerParameters.class;
  }
  
  public void requestBannerAd(MediationBannerListener paramMediationBannerListener, Activity paramActivity, CustomEventServerParameters paramCustomEventServerParameters, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, CustomEventExtras paramCustomEventExtras)
  {
    this.o = ((CustomEventBanner)a(paramCustomEventServerParameters.className));
    if (this.o == null)
    {
      paramMediationBannerListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
      return;
    }
    if (paramCustomEventExtras == null) {}
    for (paramCustomEventExtras = null;; paramCustomEventExtras = paramCustomEventExtras.getExtra(paramCustomEventServerParameters.label))
    {
      this.o.requestBannerAd(new a(this, paramMediationBannerListener), paramActivity, paramCustomEventServerParameters.label, paramCustomEventServerParameters.parameter, paramAdSize, paramMediationAdRequest, paramCustomEventExtras);
      return;
    }
  }
  
  public void requestInterstitialAd(MediationInterstitialListener paramMediationInterstitialListener, Activity paramActivity, CustomEventServerParameters paramCustomEventServerParameters, MediationAdRequest paramMediationAdRequest, CustomEventExtras paramCustomEventExtras)
  {
    this.p = ((CustomEventInterstitial)a(paramCustomEventServerParameters.className));
    if (this.p == null)
    {
      paramMediationInterstitialListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
      return;
    }
    if (paramCustomEventExtras == null) {}
    for (paramCustomEventExtras = null;; paramCustomEventExtras = paramCustomEventExtras.getExtra(paramCustomEventServerParameters.label))
    {
      this.p.requestInterstitialAd(new b(this, paramMediationInterstitialListener), paramActivity, paramCustomEventServerParameters.label, paramCustomEventServerParameters.parameter, paramMediationAdRequest, paramCustomEventExtras);
      return;
    }
  }
  
  public void showInterstitial()
  {
    this.p.showInterstitial();
  }
  
  private static final class a
    implements CustomEventBannerListener
  {
    private final CustomEventAdapter q;
    private final MediationBannerListener r;
    
    public a(CustomEventAdapter paramCustomEventAdapter, MediationBannerListener paramMediationBannerListener)
    {
      this.q = paramCustomEventAdapter;
      this.r = paramMediationBannerListener;
    }
    
    public void onClick()
    {
      ev.z("Custom event adapter called onFailedToReceiveAd.");
      this.r.onClick(this.q);
    }
    
    public void onDismissScreen()
    {
      ev.z("Custom event adapter called onFailedToReceiveAd.");
      this.r.onDismissScreen(this.q);
    }
    
    public void onFailedToReceiveAd()
    {
      ev.z("Custom event adapter called onFailedToReceiveAd.");
      this.r.onFailedToReceiveAd(this.q, AdRequest.ErrorCode.NO_FILL);
    }
    
    public void onLeaveApplication()
    {
      ev.z("Custom event adapter called onFailedToReceiveAd.");
      this.r.onLeaveApplication(this.q);
    }
    
    public void onPresentScreen()
    {
      ev.z("Custom event adapter called onFailedToReceiveAd.");
      this.r.onPresentScreen(this.q);
    }
    
    public void onReceivedAd(View paramView)
    {
      ev.z("Custom event adapter called onReceivedAd.");
      CustomEventAdapter.a(this.q, paramView);
      this.r.onReceivedAd(this.q);
    }
  }
  
  private class b
    implements CustomEventInterstitialListener
  {
    private final CustomEventAdapter q;
    private final MediationInterstitialListener s;
    
    public b(CustomEventAdapter paramCustomEventAdapter, MediationInterstitialListener paramMediationInterstitialListener)
    {
      this.q = paramCustomEventAdapter;
      this.s = paramMediationInterstitialListener;
    }
    
    public void onDismissScreen()
    {
      ev.z("Custom event adapter called onDismissScreen.");
      this.s.onDismissScreen(this.q);
    }
    
    public void onFailedToReceiveAd()
    {
      ev.z("Custom event adapter called onFailedToReceiveAd.");
      this.s.onFailedToReceiveAd(this.q, AdRequest.ErrorCode.NO_FILL);
    }
    
    public void onLeaveApplication()
    {
      ev.z("Custom event adapter called onLeaveApplication.");
      this.s.onLeaveApplication(this.q);
    }
    
    public void onPresentScreen()
    {
      ev.z("Custom event adapter called onPresentScreen.");
      this.s.onPresentScreen(this.q);
    }
    
    public void onReceivedAd()
    {
      ev.z("Custom event adapter called onReceivedAd.");
      this.s.onReceivedAd(CustomEventAdapter.this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/ads/mediation/customevent/CustomEventAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */