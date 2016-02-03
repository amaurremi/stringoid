package com.google.ads.mediation.adfonic;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.adfonic.android.AdfonicView;
import com.adfonic.android.api.Request;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.adfonic.listener.MediationBannerAdListener;
import com.google.ads.mediation.adfonic.listener.MediationInterstitialAdListener;
import com.google.ads.mediation.adfonic.util.LayoutFactory;
import com.google.ads.mediation.adfonic.util.RequestHelper;

public class AdfonicAdapter
  implements MediationBannerAdapter<AdfonicNetworkExtras, AdfonicServerParameters>, MediationInterstitialAdapter<AdfonicNetworkExtras, AdfonicServerParameters>
{
  private FrameLayout adContainer;
  private AdfonicView adView;
  private MediationBannerListener bannerListener;
  private MediationInterstitialListener interstitialListener;
  private LayoutFactory layoutFactory = new LayoutFactory();
  
  private Request prepareRequest(MediationAdRequest paramMediationAdRequest, AdfonicServerParameters paramAdfonicServerParameters, AdfonicNetworkExtras paramAdfonicNetworkExtras)
  {
    return new RequestHelper().createRequest(paramAdfonicServerParameters.adSlotID, paramMediationAdRequest);
  }
  
  public void destroy()
  {
    this.bannerListener = null;
    this.interstitialListener = null;
    if (this.adContainer != null)
    {
      this.adContainer.removeAllViews();
      this.adContainer = null;
    }
  }
  
  public Class<AdfonicNetworkExtras> getAdditionalParametersType()
  {
    return AdfonicNetworkExtras.class;
  }
  
  public View getBannerView()
  {
    return this.adContainer;
  }
  
  public Class<AdfonicServerParameters> getServerParametersType()
  {
    return AdfonicServerParameters.class;
  }
  
  public final void requestBannerAd(MediationBannerListener paramMediationBannerListener, Activity paramActivity, AdfonicServerParameters paramAdfonicServerParameters, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, AdfonicNetworkExtras paramAdfonicNetworkExtras)
  {
    this.bannerListener = paramMediationBannerListener;
    this.adContainer = new FrameLayout(paramActivity);
    paramMediationBannerListener = this.layoutFactory.buildLayoutForAd(paramActivity, paramAdSize);
    this.adContainer.setLayoutParams(paramMediationBannerListener);
    this.adView = new AdfonicView(paramActivity);
    this.adView.setAdListener(new MediationBannerAdListener(this.bannerListener, this));
    this.adContainer.addView(this.adView, paramMediationBannerListener);
    paramMediationBannerListener = prepareRequest(paramMediationAdRequest, paramAdfonicServerParameters, paramAdfonicNetworkExtras);
    this.adView.loadAd(paramMediationBannerListener);
  }
  
  public void requestInterstitialAd(MediationInterstitialListener paramMediationInterstitialListener, Activity paramActivity, AdfonicServerParameters paramAdfonicServerParameters, MediationAdRequest paramMediationAdRequest, AdfonicNetworkExtras paramAdfonicNetworkExtras)
  {
    this.interstitialListener = paramMediationInterstitialListener;
    this.adView = new AdfonicView(paramActivity);
    this.adView.setAdListener(new MediationInterstitialAdListener(this.interstitialListener, this));
    this.adView.loadAd(prepareRequest(paramMediationAdRequest, paramAdfonicServerParameters, paramAdfonicNetworkExtras));
  }
  
  public void showInterstitial()
  {
    this.adView.showInterstitial();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/mediation/adfonic/AdfonicAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */