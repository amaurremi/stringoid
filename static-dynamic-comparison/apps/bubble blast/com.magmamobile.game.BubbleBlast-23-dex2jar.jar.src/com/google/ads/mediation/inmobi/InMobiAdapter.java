package com.google.ads.mediation.inmobi;

import android.app.Activity;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.inmobi.androidsdk.IMAdInterstitial;
import com.inmobi.androidsdk.IMAdInterstitialListener;
import com.inmobi.androidsdk.IMAdListener;
import com.inmobi.androidsdk.IMAdRequest;
import com.inmobi.androidsdk.IMAdRequest.ErrorCode;
import com.inmobi.androidsdk.IMAdRequest.GenderType;
import com.inmobi.androidsdk.IMAdView;
import com.inmobi.androidsdk.IMAdView.AnimationType;
import com.inmobi.commons.IMCommonUtil;
import java.util.Calendar;
import java.util.HashMap;

public final class InMobiAdapter
  implements MediationInterstitialAdapter<InMobiAdapterExtras, InMobiAdapterServerParameters>, MediationBannerAdapter<InMobiAdapterExtras, InMobiAdapterServerParameters>
{
  private static final AdSize ADSIZE_INMOBI_AD_UNIT_120X600 = new AdSize(120, 600);
  private static final AdSize ADSIZE_INMOBI_AD_UNIT_300X250;
  private static final AdSize ADSIZE_INMOBI_AD_UNIT_320X48 = new AdSize(320, 48);
  private static final AdSize ADSIZE_INMOBI_AD_UNIT_320X50 = new AdSize(320, 50);
  private static final AdSize ADSIZE_INMOBI_AD_UNIT_468X60 = new AdSize(468, 60);
  private static final AdSize ADSIZE_INMOBI_AD_UNIT_728X90 = new AdSize(728, 90);
  private IMAdInterstitial adInterstitial;
  private IMAdView adView;
  private MediationBannerListener bannerListener;
  private MediationInterstitialListener interstitialListener;
  private boolean isAdShown;
  private boolean shouldSendClickAndPresence;
  private FrameLayout wrappedAdView;
  
  static
  {
    ADSIZE_INMOBI_AD_UNIT_300X250 = new AdSize(300, 250);
  }
  
  private IMAdRequest buildAdRequest(InMobiAdapterServerParameters paramInMobiAdapterServerParameters, MediationAdRequest paramMediationAdRequest, InMobiAdapterExtras paramInMobiAdapterExtras)
  {
    paramInMobiAdapterServerParameters = paramInMobiAdapterExtras;
    if (paramInMobiAdapterExtras == null) {
      paramInMobiAdapterServerParameters = new InMobiAdapterExtras();
    }
    paramInMobiAdapterExtras = new IMAdRequest();
    if (paramMediationAdRequest.getAgeInYears() != null) {
      paramInMobiAdapterExtras.setAge(paramMediationAdRequest.getAgeInYears().intValue());
    }
    if (paramInMobiAdapterServerParameters.getAreaCode() != null) {
      paramInMobiAdapterExtras.setAreaCode(paramInMobiAdapterServerParameters.getAreaCode());
    }
    if (paramMediationAdRequest.getLocation() != null)
    {
      paramInMobiAdapterExtras.setLocationInquiryAllowed(true);
      paramInMobiAdapterExtras.setCurrentLocation(paramMediationAdRequest.getLocation());
    }
    if (paramMediationAdRequest.getBirthday() != null)
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(paramMediationAdRequest.getBirthday());
      paramInMobiAdapterExtras.setDateOfBirth(localCalendar);
    }
    if (paramInMobiAdapterServerParameters.getEducation() != null) {
      paramInMobiAdapterExtras.setEducation(paramInMobiAdapterServerParameters.getEducation());
    }
    if (paramInMobiAdapterServerParameters.getEthnicity() != null) {
      paramInMobiAdapterExtras.setEthnicity(paramInMobiAdapterServerParameters.getEthnicity());
    }
    if (paramMediationAdRequest.getGender() != null) {
      switch (paramMediationAdRequest.getGender())
      {
      }
    }
    for (;;)
    {
      if (paramInMobiAdapterServerParameters.getIncome() != null) {
        paramInMobiAdapterExtras.setIncome(paramInMobiAdapterServerParameters.getIncome().intValue());
      }
      if (paramInMobiAdapterServerParameters.getInterests() != null) {
        paramInMobiAdapterExtras.setInterests(TextUtils.join(", ", paramInMobiAdapterServerParameters.getInterests()));
      }
      if (paramMediationAdRequest.getKeywords() != null) {
        paramInMobiAdapterExtras.setKeywords(TextUtils.join(", ", paramMediationAdRequest.getKeywords()));
      }
      if (paramInMobiAdapterServerParameters.getPostalCode() != null) {
        paramInMobiAdapterExtras.setPostalCode(paramInMobiAdapterServerParameters.getPostalCode());
      }
      if (paramInMobiAdapterServerParameters.getSearchString() != null) {
        paramInMobiAdapterExtras.setSearchString(paramInMobiAdapterServerParameters.getSearchString());
      }
      IMCommonUtil.setDeviceIDMask(paramInMobiAdapterServerParameters.getDeviceIdMask());
      paramInMobiAdapterExtras.setTestMode(paramMediationAdRequest.isTesting());
      paramInMobiAdapterServerParameters = new HashMap();
      paramInMobiAdapterServerParameters.put("tp", "c_gwhirl");
      paramInMobiAdapterExtras.setRequestParams(paramInMobiAdapterServerParameters);
      return paramInMobiAdapterExtras;
      paramInMobiAdapterExtras.setGender(IMAdRequest.GenderType.MALE);
      continue;
      paramInMobiAdapterExtras.setGender(IMAdRequest.GenderType.FEMALE);
    }
  }
  
  public void destroy() {}
  
  public Class<InMobiAdapterExtras> getAdditionalParametersType()
  {
    return InMobiAdapterExtras.class;
  }
  
  public View getBannerView()
  {
    return this.wrappedAdView;
  }
  
  public Class<InMobiAdapterServerParameters> getServerParametersType()
  {
    return InMobiAdapterServerParameters.class;
  }
  
  public void requestBannerAd(MediationBannerListener paramMediationBannerListener, Activity paramActivity, InMobiAdapterServerParameters paramInMobiAdapterServerParameters, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, InMobiAdapterExtras paramInMobiAdapterExtras)
  {
    if (Build.VERSION.SDK_INT < 7)
    {
      paramMediationBannerListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INVALID_REQUEST);
      return;
    }
    this.bannerListener = paramMediationBannerListener;
    paramAdSize = paramAdSize.findBestSize(new AdSize[] { ADSIZE_INMOBI_AD_UNIT_320X48, ADSIZE_INMOBI_AD_UNIT_320X50, ADSIZE_INMOBI_AD_UNIT_468X60, ADSIZE_INMOBI_AD_UNIT_728X90, ADSIZE_INMOBI_AD_UNIT_300X250, ADSIZE_INMOBI_AD_UNIT_120X600 });
    int i;
    if (paramAdSize == ADSIZE_INMOBI_AD_UNIT_320X48) {
      i = 9;
    }
    for (;;)
    {
      paramMediationBannerListener = new FrameLayout.LayoutParams(paramAdSize.getWidthInPixels(paramActivity), paramAdSize.getHeightInPixels(paramActivity));
      this.adView = new IMAdView(paramActivity, i, paramInMobiAdapterServerParameters.appId);
      this.adView.setRefreshInterval(-1);
      this.adView.setAnimationType(IMAdView.AnimationType.ANIMATION_OFF);
      this.adView.setIMAdListener(new BannerListener(null));
      this.wrappedAdView = new FrameLayout(paramActivity);
      this.wrappedAdView.setLayoutParams(paramMediationBannerListener);
      this.wrappedAdView.addView(this.adView);
      this.adView.loadNewAd(buildAdRequest(paramInMobiAdapterServerParameters, paramMediationAdRequest, paramInMobiAdapterExtras));
      return;
      if (paramAdSize == ADSIZE_INMOBI_AD_UNIT_320X50)
      {
        i = 15;
      }
      else if (paramAdSize == ADSIZE_INMOBI_AD_UNIT_468X60)
      {
        i = 12;
      }
      else if (paramAdSize == ADSIZE_INMOBI_AD_UNIT_728X90)
      {
        i = 11;
      }
      else if (paramAdSize == ADSIZE_INMOBI_AD_UNIT_300X250)
      {
        i = 10;
      }
      else
      {
        if (paramAdSize != ADSIZE_INMOBI_AD_UNIT_120X600) {
          break;
        }
        i = 13;
      }
    }
    paramMediationBannerListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INVALID_REQUEST);
  }
  
  public void requestInterstitialAd(MediationInterstitialListener paramMediationInterstitialListener, Activity paramActivity, InMobiAdapterServerParameters paramInMobiAdapterServerParameters, MediationAdRequest paramMediationAdRequest, InMobiAdapterExtras paramInMobiAdapterExtras)
  {
    if (Build.VERSION.SDK_INT < 7)
    {
      paramMediationInterstitialListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INVALID_REQUEST);
      return;
    }
    this.interstitialListener = paramMediationInterstitialListener;
    this.adInterstitial = new IMAdInterstitial(paramActivity, paramInMobiAdapterServerParameters.appId);
    this.adInterstitial.setIMAdInterstitialListener(new InterstitialListener(null));
    this.adInterstitial.loadNewAd(buildAdRequest(paramInMobiAdapterServerParameters, paramMediationAdRequest, paramInMobiAdapterExtras));
  }
  
  public void showInterstitial()
  {
    this.adInterstitial.show();
  }
  
  private class BannerListener
    implements IMAdListener
  {
    private BannerListener() {}
    
    public void onAdRequestCompleted(IMAdView paramIMAdView)
    {
      InMobiAdapter.this.shouldSendClickAndPresence = true;
      InMobiAdapter.this.bannerListener.onReceivedAd(InMobiAdapter.this);
    }
    
    public void onAdRequestFailed(IMAdView paramIMAdView, IMAdRequest.ErrorCode paramErrorCode)
    {
      switch (paramErrorCode)
      {
      case AD_DOWNLOAD_IN_PROGRESS: 
      case AD_FETCH_TIMEOUT: 
      default: 
        InMobiAdapter.this.bannerListener.onFailedToReceiveAd(InMobiAdapter.this, AdRequest.ErrorCode.INVALID_REQUEST);
        return;
      case INVALID_REQUEST: 
        InMobiAdapter.this.bannerListener.onFailedToReceiveAd(InMobiAdapter.this, AdRequest.ErrorCode.INTERNAL_ERROR);
        return;
      case AD_CLICK_IN_PROGRESS: 
        InMobiAdapter.this.bannerListener.onFailedToReceiveAd(InMobiAdapter.this, AdRequest.ErrorCode.INVALID_REQUEST);
        return;
      case INVALID_APP_ID: 
        InMobiAdapter.this.bannerListener.onFailedToReceiveAd(InMobiAdapter.this, AdRequest.ErrorCode.NETWORK_ERROR);
        return;
      case NETWORK_ERROR: 
        InMobiAdapter.this.bannerListener.onFailedToReceiveAd(InMobiAdapter.this, AdRequest.ErrorCode.NO_FILL);
        return;
      case NO_FILL: 
        InMobiAdapter.this.bannerListener.onFailedToReceiveAd(InMobiAdapter.this, AdRequest.ErrorCode.INVALID_REQUEST);
      }
      InMobiAdapter.this.interstitialListener.onFailedToReceiveAd(InMobiAdapter.this, AdRequest.ErrorCode.NO_FILL);
    }
    
    public void onDismissAdScreen(IMAdView paramIMAdView)
    {
      InMobiAdapter.this.shouldSendClickAndPresence = true;
      InMobiAdapter.this.isAdShown = false;
      InMobiAdapter.this.bannerListener.onDismissScreen(InMobiAdapter.this);
    }
    
    public void onLeaveApplication(IMAdView paramIMAdView)
    {
      if (InMobiAdapter.this.shouldSendClickAndPresence)
      {
        if (InMobiAdapter.this.isAdShown) {
          InMobiAdapter.this.shouldSendClickAndPresence = false;
        }
        InMobiAdapter.this.bannerListener.onClick(InMobiAdapter.this);
        InMobiAdapter.this.bannerListener.onPresentScreen(InMobiAdapter.this);
      }
      InMobiAdapter.this.bannerListener.onLeaveApplication(InMobiAdapter.this);
    }
    
    public void onShowAdScreen(IMAdView paramIMAdView)
    {
      if (InMobiAdapter.this.shouldSendClickAndPresence)
      {
        InMobiAdapter.this.shouldSendClickAndPresence = false;
        InMobiAdapter.this.isAdShown = true;
        InMobiAdapter.this.bannerListener.onClick(InMobiAdapter.this);
        InMobiAdapter.this.bannerListener.onPresentScreen(InMobiAdapter.this);
      }
    }
  }
  
  private class InterstitialListener
    implements IMAdInterstitialListener
  {
    private InterstitialListener() {}
    
    public void onAdRequestFailed(IMAdInterstitial paramIMAdInterstitial, IMAdRequest.ErrorCode paramErrorCode)
    {
      switch (paramErrorCode)
      {
      case AD_DOWNLOAD_IN_PROGRESS: 
      case AD_FETCH_TIMEOUT: 
      default: 
        InMobiAdapter.this.bannerListener.onFailedToReceiveAd(InMobiAdapter.this, AdRequest.ErrorCode.INVALID_REQUEST);
        return;
      case INVALID_REQUEST: 
        InMobiAdapter.this.interstitialListener.onFailedToReceiveAd(InMobiAdapter.this, AdRequest.ErrorCode.INTERNAL_ERROR);
        return;
      case AD_CLICK_IN_PROGRESS: 
        InMobiAdapter.this.interstitialListener.onFailedToReceiveAd(InMobiAdapter.this, AdRequest.ErrorCode.INVALID_REQUEST);
        return;
      case INVALID_APP_ID: 
        InMobiAdapter.this.interstitialListener.onFailedToReceiveAd(InMobiAdapter.this, AdRequest.ErrorCode.NETWORK_ERROR);
        return;
      case NETWORK_ERROR: 
        InMobiAdapter.this.interstitialListener.onFailedToReceiveAd(InMobiAdapter.this, AdRequest.ErrorCode.NO_FILL);
        return;
      case NO_FILL: 
        InMobiAdapter.this.interstitialListener.onFailedToReceiveAd(InMobiAdapter.this, AdRequest.ErrorCode.INVALID_REQUEST);
        return;
      }
      InMobiAdapter.this.interstitialListener.onFailedToReceiveAd(InMobiAdapter.this, AdRequest.ErrorCode.NO_FILL);
    }
    
    public void onAdRequestLoaded(IMAdInterstitial paramIMAdInterstitial)
    {
      InMobiAdapter.this.interstitialListener.onReceivedAd(InMobiAdapter.this);
    }
    
    public void onDismissAdScreen(IMAdInterstitial paramIMAdInterstitial)
    {
      InMobiAdapter.this.interstitialListener.onDismissScreen(InMobiAdapter.this);
    }
    
    public void onLeaveApplication(IMAdInterstitial paramIMAdInterstitial)
    {
      InMobiAdapter.this.interstitialListener.onLeaveApplication(InMobiAdapter.this);
    }
    
    public void onShowAdScreen(IMAdInterstitial paramIMAdInterstitial)
    {
      InMobiAdapter.this.interstitialListener.onPresentScreen(InMobiAdapter.this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/mediation/inmobi/InMobiAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */