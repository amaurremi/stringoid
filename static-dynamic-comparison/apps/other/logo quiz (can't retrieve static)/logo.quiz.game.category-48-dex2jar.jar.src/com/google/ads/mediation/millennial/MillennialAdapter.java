package com.google.ads.mediation.millennial;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
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
import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.MMInterstitial;
import com.millennialmedia.android.MMRequest;
import com.millennialmedia.android.MMSDK;
import com.millennialmedia.android.RequestListener;
import java.util.Hashtable;

public final class MillennialAdapter
  implements MediationBannerAdapter<MillennialAdapterExtras, MillennialAdapterServerParameters>, MediationInterstitialAdapter<MillennialAdapterExtras, MillennialAdapterServerParameters>
{
  private MMAdView adView;
  private MediationBannerListener bannerListener;
  private MediationInterstitialListener interstitialListener;
  private MMInterstitial interstitialView;
  private FrameLayout wrappedAdView;
  
  private void populateAdViewParameters(MMAd paramMMAd, Hashtable<String, String> paramHashtable, MediationAdRequest paramMediationAdRequest, MillennialAdapterExtras paramMillennialAdapterExtras)
  {
    MillennialAdapterExtras localMillennialAdapterExtras = paramMillennialAdapterExtras;
    if (paramMillennialAdapterExtras == null) {
      localMillennialAdapterExtras = new MillennialAdapterExtras();
    }
    if (paramMediationAdRequest.getKeywords() != null) {
      paramHashtable.put("keywords", TextUtils.join(",", paramMediationAdRequest.getKeywords()));
    }
    if (localMillennialAdapterExtras.getChildren() != null)
    {
      if (localMillennialAdapterExtras.getChildren().booleanValue())
      {
        paramMillennialAdapterExtras = "true";
        paramHashtable.put("children", paramMillennialAdapterExtras);
      }
    }
    else
    {
      paramMillennialAdapterExtras = new MMRequest();
      MMSDK.setBroadcastEvents(true);
      if (paramMediationAdRequest.getAgeInYears() != null) {
        paramMillennialAdapterExtras.setAge(paramMediationAdRequest.getAgeInYears().toString());
      }
      if (paramMediationAdRequest.getGender() != null) {
        switch (paramMediationAdRequest.getGender())
        {
        }
      }
    }
    for (;;)
    {
      if (localMillennialAdapterExtras.getIncomeInUsDollars() != null) {
        paramMillennialAdapterExtras.setIncome(localMillennialAdapterExtras.getIncomeInUsDollars().toString());
      }
      if (paramMediationAdRequest.getLocation() != null) {
        MMRequest.setUserLocation(paramMediationAdRequest.getLocation());
      }
      if (localMillennialAdapterExtras.getPostalCode() != null) {
        paramMillennialAdapterExtras.setZip(localMillennialAdapterExtras.getPostalCode());
      }
      if (localMillennialAdapterExtras.getMaritalStatus() != null) {
        paramMillennialAdapterExtras.setMarital(localMillennialAdapterExtras.getMaritalStatus().getDescription());
      }
      if (localMillennialAdapterExtras.getEthnicity() != null) {
        paramMillennialAdapterExtras.setEthnicity(localMillennialAdapterExtras.getEthnicity().getDescription());
      }
      if (localMillennialAdapterExtras.getOrientation() != null) {
        paramMillennialAdapterExtras.setOrientation(localMillennialAdapterExtras.getOrientation().getDescription());
      }
      if (localMillennialAdapterExtras.getPolitics() != null) {
        paramMillennialAdapterExtras.setPolitics(localMillennialAdapterExtras.getPolitics().getDescription());
      }
      if (localMillennialAdapterExtras.getEducation() != null) {
        paramMillennialAdapterExtras.setEducation(localMillennialAdapterExtras.getEducation().getDescription());
      }
      if (paramHashtable != null) {
        paramMillennialAdapterExtras.setMetaValues(paramHashtable);
      }
      paramMMAd.setMMRequest(paramMillennialAdapterExtras);
      return;
      paramMillennialAdapterExtras = "false";
      break;
      paramMillennialAdapterExtras.setGender("male");
      continue;
      paramMillennialAdapterExtras.setGender("female");
    }
  }
  
  public void destroy() {}
  
  public Class<MillennialAdapterExtras> getAdditionalParametersType()
  {
    return MillennialAdapterExtras.class;
  }
  
  public View getBannerView()
  {
    return this.wrappedAdView;
  }
  
  public Class<MillennialAdapterServerParameters> getServerParametersType()
  {
    return MillennialAdapterServerParameters.class;
  }
  
  public void requestBannerAd(MediationBannerListener paramMediationBannerListener, Activity paramActivity, MillennialAdapterServerParameters paramMillennialAdapterServerParameters, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, MillennialAdapterExtras paramMillennialAdapterExtras)
  {
    this.bannerListener = paramMediationBannerListener;
    paramMediationBannerListener = new Hashtable();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramAdSize.getWidthInPixels(paramActivity), paramAdSize.getHeightInPixels(paramActivity));
    this.adView = new MMAdView(paramActivity);
    this.adView.setApid(paramMillennialAdapterServerParameters.apid);
    this.adView.setHeight(paramAdSize.getHeight());
    this.adView.setWidth(paramAdSize.getWidth());
    this.adView.setId(MMSDK.getDefaultAdId());
    populateAdViewParameters(this.adView, paramMediationBannerListener, paramMediationAdRequest, paramMillennialAdapterExtras);
    this.adView.setListener(new BannerListener(null));
    this.wrappedAdView = new FrameLayout(paramActivity);
    this.wrappedAdView.setLayoutParams(localLayoutParams);
    this.wrappedAdView.addView(this.adView);
    if (paramAdSize.getWidthInPixels(paramActivity) <= paramActivity.getResources().getDisplayMetrics().widthPixels)
    {
      this.adView.getAd();
      return;
    }
    this.bannerListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.NO_FILL);
  }
  
  public void requestInterstitialAd(MediationInterstitialListener paramMediationInterstitialListener, Activity paramActivity, MillennialAdapterServerParameters paramMillennialAdapterServerParameters, MediationAdRequest paramMediationAdRequest, MillennialAdapterExtras paramMillennialAdapterExtras)
  {
    this.interstitialListener = paramMediationInterstitialListener;
    paramMediationInterstitialListener = new Hashtable();
    this.interstitialView = new MMInterstitial(paramActivity);
    this.interstitialView.setApid(paramMillennialAdapterServerParameters.apid);
    populateAdViewParameters(this.interstitialView, paramMediationInterstitialListener, paramMediationAdRequest, paramMillennialAdapterExtras);
    this.interstitialView.setListener(new InterstitialListener(null));
    this.interstitialView.fetch();
  }
  
  public void showInterstitial()
  {
    this.interstitialView.display();
  }
  
  private class BannerListener
    implements RequestListener
  {
    private BannerListener() {}
    
    public void MMAdOverlayClosed(MMAd paramMMAd)
    {
      MillennialAdapter.this.bannerListener.onDismissScreen(MillennialAdapter.this);
    }
    
    public void MMAdOverlayLaunched(MMAd paramMMAd)
    {
      MillennialAdapter.this.bannerListener.onPresentScreen(MillennialAdapter.this);
    }
    
    public void MMAdRequestIsCaching(MMAd paramMMAd) {}
    
    public void onSingleTap(MMAd paramMMAd) {}
    
    public void requestCompleted(MMAd paramMMAd)
    {
      MillennialAdapter.this.bannerListener.onReceivedAd(MillennialAdapter.this);
    }
    
    public void requestFailed(MMAd paramMMAd, MMException paramMMException)
    {
      if (11 == paramMMException.getCode())
      {
        MillennialAdapter.this.bannerListener.onFailedToReceiveAd(MillennialAdapter.this, AdRequest.ErrorCode.NETWORK_ERROR);
        return;
      }
      MillennialAdapter.this.bannerListener.onFailedToReceiveAd(MillennialAdapter.this, AdRequest.ErrorCode.NO_FILL);
    }
  }
  
  private class InterstitialListener
    implements RequestListener
  {
    private InterstitialListener() {}
    
    public void MMAdOverlayClosed(MMAd paramMMAd)
    {
      MillennialAdapter.this.interstitialListener.onDismissScreen(MillennialAdapter.this);
    }
    
    public void MMAdOverlayLaunched(MMAd paramMMAd)
    {
      MillennialAdapter.this.interstitialListener.onPresentScreen(MillennialAdapter.this);
    }
    
    public void MMAdRequestIsCaching(MMAd paramMMAd) {}
    
    public void onSingleTap(MMAd paramMMAd) {}
    
    public void requestCompleted(MMAd paramMMAd)
    {
      MillennialAdapter.this.interstitialListener.onReceivedAd(MillennialAdapter.this);
    }
    
    public void requestFailed(MMAd paramMMAd, MMException paramMMException)
    {
      if (11 == paramMMException.getCode())
      {
        MillennialAdapter.this.interstitialListener.onFailedToReceiveAd(MillennialAdapter.this, AdRequest.ErrorCode.NETWORK_ERROR);
        return;
      }
      if (17 == paramMMException.getCode())
      {
        requestCompleted(paramMMAd);
        return;
      }
      MillennialAdapter.this.interstitialListener.onFailedToReceiveAd(MillennialAdapter.this, AdRequest.ErrorCode.NO_FILL);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/ads/mediation/millennial/MillennialAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */