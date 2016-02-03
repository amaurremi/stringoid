package com.google.ads.mediation.jumptap;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.jumptap.adtag.JtAdInterstitial;
import com.jumptap.adtag.JtAdView;
import com.jumptap.adtag.JtAdViewListener;
import com.jumptap.adtag.JtAdWidgetSettings;
import com.jumptap.adtag.utils.JtException;

public final class JumpTapAdapter
  implements MediationInterstitialAdapter<JumpTapAdapterExtras, JumpTapAdapterServerParameters>, MediationBannerAdapter<JumpTapAdapterExtras, JumpTapAdapterServerParameters>
{
  private JtAdView adView;
  private MediationBannerListener bannerListener;
  private JtAdInterstitial interstitial;
  private MediationInterstitialListener interstitialListener;
  
  private JtAdWidgetSettings buildSettings(JumpTapAdapterServerParameters paramJumpTapAdapterServerParameters, MediationAdRequest paramMediationAdRequest, JumpTapAdapterExtras paramJumpTapAdapterExtras)
  {
    JumpTapAdapterExtras localJumpTapAdapterExtras = paramJumpTapAdapterExtras;
    if (paramJumpTapAdapterExtras == null) {
      localJumpTapAdapterExtras = new JumpTapAdapterExtras();
    }
    paramJumpTapAdapterExtras = new CleanJtAdWidgetSettings(null);
    paramJumpTapAdapterExtras.setRefreshPeriod(0);
    paramJumpTapAdapterExtras.setPublisherId(paramJumpTapAdapterServerParameters.publisherId);
    paramJumpTapAdapterExtras.setSpotId(paramJumpTapAdapterServerParameters.spotId);
    paramJumpTapAdapterExtras.setSiteId(paramJumpTapAdapterServerParameters.siteId);
    paramJumpTapAdapterExtras.setApplicationId("GWhirl Adapter");
    paramJumpTapAdapterExtras.setApplicationVersion("1.2.3");
    if (localJumpTapAdapterExtras.getAdultContent() != null) {
      paramJumpTapAdapterExtras.setAdultContentType(localJumpTapAdapterExtras.getAdultContent().getDescription());
    }
    if (paramMediationAdRequest.getAgeInYears() != null) {
      paramJumpTapAdapterExtras.setAge(paramMediationAdRequest.getAgeInYears().toString());
    }
    if (localJumpTapAdapterExtras.getApplicationId() != null) {
      paramJumpTapAdapterExtras.setApplicationId(localJumpTapAdapterExtras.getApplicationId());
    }
    if (localJumpTapAdapterExtras.getApplicationVersion() != null) {
      paramJumpTapAdapterExtras.setApplicationVersion(localJumpTapAdapterExtras.getApplicationVersion());
    }
    if (localJumpTapAdapterExtras.getCountry() != null) {
      paramJumpTapAdapterExtras.setCountry(localJumpTapAdapterExtras.getCountry());
    }
    if (localJumpTapAdapterExtras.getDismissButtonLabel() != null) {
      paramJumpTapAdapterExtras.setDismissButtonLabel(localJumpTapAdapterExtras.getDismissButtonLabel());
    }
    if (paramMediationAdRequest.getGender() != null) {
      switch (paramMediationAdRequest.getGender())
      {
      }
    }
    for (;;)
    {
      if (localJumpTapAdapterExtras.getIncome() != null) {
        paramJumpTapAdapterExtras.setHHI(localJumpTapAdapterExtras.getIncome().getDescription());
      }
      if (localJumpTapAdapterExtras.getLanguage() != null) {
        paramJumpTapAdapterExtras.setLanguage(localJumpTapAdapterExtras.getLanguage());
      }
      if (localJumpTapAdapterExtras.getPostalCode() != null) {
        paramJumpTapAdapterExtras.setPostalCode(localJumpTapAdapterExtras.getPostalCode());
      }
      paramJumpTapAdapterExtras.setShouldSendLocation(localJumpTapAdapterExtras.getShouldSendLocation());
      return paramJumpTapAdapterExtras;
      paramJumpTapAdapterExtras.setGender("m");
      continue;
      paramJumpTapAdapterExtras.setGender("f");
    }
  }
  
  public void destroy() {}
  
  public Class<JumpTapAdapterExtras> getAdditionalParametersType()
  {
    return JumpTapAdapterExtras.class;
  }
  
  public View getBannerView()
  {
    return this.adView;
  }
  
  public Class<JumpTapAdapterServerParameters> getServerParametersType()
  {
    return JumpTapAdapterServerParameters.class;
  }
  
  public void requestBannerAd(MediationBannerListener paramMediationBannerListener, Activity paramActivity, JumpTapAdapterServerParameters paramJumpTapAdapterServerParameters, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, JumpTapAdapterExtras paramJumpTapAdapterExtras)
  {
    this.bannerListener = paramMediationBannerListener;
    try
    {
      this.adView = new JtAdView(paramActivity, buildSettings(paramJumpTapAdapterServerParameters, paramMediationAdRequest, paramJumpTapAdapterExtras));
      this.adView.setAdViewListener(new BannerListener(null));
      this.adView.refreshAd();
      return;
    }
    catch (JtException paramActivity)
    {
      paramMediationBannerListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
    }
  }
  
  public void requestInterstitialAd(MediationInterstitialListener paramMediationInterstitialListener, Activity paramActivity, JumpTapAdapterServerParameters paramJumpTapAdapterServerParameters, MediationAdRequest paramMediationAdRequest, JumpTapAdapterExtras paramJumpTapAdapterExtras)
  {
    this.interstitialListener = paramMediationInterstitialListener;
    try
    {
      this.interstitial = new JtAdInterstitial(paramActivity, buildSettings(paramJumpTapAdapterServerParameters, paramMediationAdRequest, paramJumpTapAdapterExtras));
      this.interstitial.setAdViewListener(new InterstitialListener(null));
      this.interstitial.refreshAd();
      return;
    }
    catch (JtException paramMediationInterstitialListener)
    {
      this.interstitialListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
    }
  }
  
  public void showInterstitial()
  {
    this.interstitial.showAsPopup();
  }
  
  private class BannerListener
    implements JtAdViewListener
  {
    private BannerListener() {}
    
    public void onAdError(JtAdView paramJtAdView, int paramInt1, int paramInt2)
    {
      JumpTapAdapter.this.bannerListener.onFailedToReceiveAd(JumpTapAdapter.this, AdRequest.ErrorCode.INTERNAL_ERROR);
    }
    
    public void onBannerClicked(JtAdView paramJtAdView, int paramInt)
    {
      JumpTapAdapter.this.bannerListener.onClick(JumpTapAdapter.this);
    }
    
    public void onBeginAdInteraction(JtAdView paramJtAdView, int paramInt) {}
    
    public void onContract(JtAdView paramJtAdView, int paramInt) {}
    
    public void onEndAdInteraction(JtAdView paramJtAdView, int paramInt) {}
    
    public void onExpand(JtAdView paramJtAdView, int paramInt)
    {
      JumpTapAdapter.this.bannerListener.onPresentScreen(JumpTapAdapter.this);
    }
    
    public void onFocusChange(JtAdView paramJtAdView, int paramInt, boolean paramBoolean) {}
    
    public void onHide(JtAdView paramJtAdView, int paramInt) {}
    
    public void onInterstitialDismissed(JtAdView paramJtAdView, int paramInt) {}
    
    public void onLaunchActivity(JtAdView paramJtAdView, int paramInt)
    {
      JumpTapAdapter.this.bannerListener.onLeaveApplication(JumpTapAdapter.this);
    }
    
    public void onNewAd(JtAdView paramJtAdView, int paramInt, String paramString)
    {
      JumpTapAdapter.this.bannerListener.onReceivedAd(JumpTapAdapter.this);
    }
    
    public void onNoAdFound(JtAdView paramJtAdView, int paramInt)
    {
      JumpTapAdapter.this.bannerListener.onFailedToReceiveAd(JumpTapAdapter.this, AdRequest.ErrorCode.NO_FILL);
    }
    
    public void onReturnFromActivity(JtAdView paramJtAdView, int paramInt) {}
  }
  
  private static class CleanJtAdWidgetSettings
    extends JtAdWidgetSettings
  {}
  
  private class InterstitialListener
    implements JtAdViewListener
  {
    private InterstitialListener() {}
    
    public void onAdError(JtAdView paramJtAdView, int paramInt1, int paramInt2)
    {
      JumpTapAdapter.this.interstitialListener.onFailedToReceiveAd(JumpTapAdapter.this, AdRequest.ErrorCode.INTERNAL_ERROR);
    }
    
    public void onBannerClicked(JtAdView paramJtAdView, int paramInt) {}
    
    public void onBeginAdInteraction(JtAdView paramJtAdView, int paramInt) {}
    
    public void onContract(JtAdView paramJtAdView, int paramInt)
    {
      JumpTapAdapter.this.interstitialListener.onDismissScreen(JumpTapAdapter.this);
    }
    
    public void onEndAdInteraction(JtAdView paramJtAdView, int paramInt) {}
    
    public void onExpand(JtAdView paramJtAdView, int paramInt)
    {
      JumpTapAdapter.this.interstitialListener.onPresentScreen(JumpTapAdapter.this);
    }
    
    public void onFocusChange(JtAdView paramJtAdView, int paramInt, boolean paramBoolean) {}
    
    public void onHide(JtAdView paramJtAdView, int paramInt) {}
    
    public void onInterstitialDismissed(JtAdView paramJtAdView, int paramInt)
    {
      JumpTapAdapter.this.interstitialListener.onDismissScreen(JumpTapAdapter.this);
    }
    
    public void onLaunchActivity(JtAdView paramJtAdView, int paramInt)
    {
      JumpTapAdapter.this.interstitialListener.onLeaveApplication(JumpTapAdapter.this);
    }
    
    public void onNewAd(JtAdView paramJtAdView, int paramInt, String paramString)
    {
      JumpTapAdapter.this.interstitialListener.onReceivedAd(JumpTapAdapter.this);
    }
    
    public void onNoAdFound(JtAdView paramJtAdView, int paramInt)
    {
      JumpTapAdapter.this.interstitialListener.onFailedToReceiveAd(JumpTapAdapter.this, AdRequest.ErrorCode.NO_FILL);
    }
    
    public void onReturnFromActivity(JtAdView paramJtAdView, int paramInt) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/ads/mediation/jumptap/JumpTapAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */