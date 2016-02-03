package com.google.ads.mediation.millennial;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
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
import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMAdView.MMAdListener;
import java.util.Hashtable;

public final class MillennialAdapter
  implements MediationBannerAdapter<MillennialAdapterExtras, MillennialAdapterServerParameters>, MediationInterstitialAdapter<MillennialAdapterExtras, MillennialAdapterServerParameters>
{
  private static final String TEST_APID = "28911";
  private MMAdView adView;
  private MediationBannerListener bannerListener;
  private MediationInterstitialListener interstitialListener;
  private FrameLayout wrappedAdView;
  
  private static int dip(int paramInt, Context paramContext)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramContext.getResources().getDisplayMetrics());
  }
  
  private void populateAdViewParameters(MMAdView paramMMAdView, Hashtable<String, String> paramHashtable, MediationAdRequest paramMediationAdRequest, MillennialAdapterExtras paramMillennialAdapterExtras)
  {
    paramMMAdView = paramMillennialAdapterExtras;
    if (paramMillennialAdapterExtras == null) {
      paramMMAdView = new MillennialAdapterExtras();
    }
    if (paramMediationAdRequest.getKeywords() != null) {
      paramHashtable.put("keywords", TextUtils.join(",", paramMediationAdRequest.getKeywords()));
    }
    if (paramMMAdView.getChildren() != null)
    {
      if (paramMMAdView.getChildren().booleanValue())
      {
        paramMillennialAdapterExtras = "true";
        paramHashtable.put("children", paramMillennialAdapterExtras);
      }
    }
    else
    {
      this.adView.setId(1897808289);
      if (paramMMAdView.getAdLocation() != null) {}
      switch (paramMMAdView.getAdLocation())
      {
      default: 
        label120:
        if (paramMMAdView.getInterstitialTime() != null) {}
        switch (paramMMAdView.getInterstitialTime())
        {
        default: 
          label160:
          if (paramMediationAdRequest.getAgeInYears() != null) {
            this.adView.setAge(paramMediationAdRequest.getAgeInYears().toString());
          }
          if (paramMediationAdRequest.getGender() != null) {
            switch (paramMediationAdRequest.getGender())
            {
            }
          }
          break;
        }
        break;
      }
    }
    for (;;)
    {
      if (paramMMAdView.getIncomeInUsDollars() != null) {
        this.adView.setIncome(paramMMAdView.getIncomeInUsDollars().toString());
      }
      if (paramMediationAdRequest.getLocation() != null) {
        this.adView.updateUserLocation(paramMediationAdRequest.getLocation());
      }
      if (paramMMAdView.getPostalCode() != null) {
        this.adView.setZip(paramMMAdView.getPostalCode());
      }
      if (paramMMAdView.getMaritalStatus() != null) {
        this.adView.setMarital(paramMMAdView.getMaritalStatus().getDescription());
      }
      if (paramMMAdView.getEthnicity() != null) {
        this.adView.setEthnicity(paramMMAdView.getEthnicity().getDescription());
      }
      if (paramMMAdView.getOrientation() != null) {
        this.adView.setOrientation(paramMMAdView.getOrientation().getDescription());
      }
      if (paramMMAdView.getPolitics() != null) {
        this.adView.setPolitics(paramMMAdView.getPolitics().getDescription());
      }
      if (paramMMAdView.getEducation() != null) {
        this.adView.setEducation(paramMMAdView.getEducation().getDescription());
      }
      return;
      paramMillennialAdapterExtras = "false";
      break;
      this.adView.setAdType("MMBannerAdBottom");
      break label120;
      this.adView.setAdType("MMBannerAdTop");
      break label120;
      this.adView.setAdType("MMFullScreenAdLaunch");
      break label160;
      this.adView.setAdType("MMFullScreenAdTransition");
      break label160;
      this.adView.setGender("male");
      continue;
      this.adView.setGender("female");
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
    Hashtable localHashtable = new Hashtable();
    if (paramAdSize.isSizeAppropriate(320, 53))
    {
      localHashtable.put("width", "320");
      localHashtable.put("height", "53");
      paramMediationBannerListener = new FrameLayout.LayoutParams(dip(320, paramActivity), dip(53, paramActivity));
      if (!paramMediationAdRequest.isTesting()) {
        break label244;
      }
      paramMillennialAdapterServerParameters = "28911";
      label83:
      if (paramMillennialAdapterExtras != null) {
        break label252;
      }
    }
    label244:
    label252:
    for (boolean bool = false;; bool = paramMillennialAdapterExtras.getAccelerate())
    {
      this.adView = new MMAdView(paramActivity, paramMillennialAdapterServerParameters, "MMBannerAdTop", -1, localHashtable, bool);
      populateAdViewParameters(this.adView, localHashtable, paramMediationAdRequest, paramMillennialAdapterExtras);
      this.adView.setListener(new BannerListener(null));
      this.wrappedAdView = new FrameLayout(paramActivity);
      this.wrappedAdView.setLayoutParams(paramMediationBannerListener);
      this.wrappedAdView.addView(this.adView);
      this.adView.callForAd();
      return;
      localHashtable.put("width", Integer.toString(paramAdSize.getWidth()));
      localHashtable.put("height", Integer.toString(paramAdSize.getHeight()));
      paramMediationBannerListener = new FrameLayout.LayoutParams(dip(paramAdSize.getWidth(), paramActivity), dip(paramAdSize.getHeight(), paramActivity));
      break;
      paramMillennialAdapterServerParameters = paramMillennialAdapterServerParameters.apid;
      break label83;
    }
  }
  
  public void requestInterstitialAd(MediationInterstitialListener paramMediationInterstitialListener, Activity paramActivity, MillennialAdapterServerParameters paramMillennialAdapterServerParameters, MediationAdRequest paramMediationAdRequest, MillennialAdapterExtras paramMillennialAdapterExtras)
  {
    this.interstitialListener = paramMediationInterstitialListener;
    paramMediationInterstitialListener = new Hashtable();
    this.adView = new MMAdView(paramActivity, paramMillennialAdapterServerParameters.apid, "MMFullScreenAdTransition", -1, paramMediationInterstitialListener, paramMediationAdRequest.isTesting());
    populateAdViewParameters(this.adView, paramMediationInterstitialListener, paramMediationAdRequest, paramMillennialAdapterExtras);
    this.adView.setListener(new InterstitialListener(null));
    this.adView.fetch();
  }
  
  public void showInterstitial()
  {
    this.adView.display();
  }
  
  private class BannerListener
    implements MMAdView.MMAdListener
  {
    private BannerListener() {}
    
    public void MMAdCachingCompleted(MMAdView paramMMAdView, boolean paramBoolean) {}
    
    public void MMAdClickedToOverlay(MMAdView paramMMAdView)
    {
      MillennialAdapter.this.bannerListener.onClick(MillennialAdapter.this);
      MillennialAdapter.this.bannerListener.onPresentScreen(MillennialAdapter.this);
    }
    
    public void MMAdFailed(MMAdView paramMMAdView)
    {
      MillennialAdapter.this.bannerListener.onFailedToReceiveAd(MillennialAdapter.this, AdRequest.ErrorCode.NO_FILL);
    }
    
    public void MMAdOverlayLaunched(MMAdView paramMMAdView)
    {
      MillennialAdapter.this.bannerListener.onPresentScreen(MillennialAdapter.this);
    }
    
    public void MMAdRequestIsCaching(MMAdView paramMMAdView) {}
    
    public void MMAdReturned(MMAdView paramMMAdView)
    {
      MillennialAdapter.this.bannerListener.onReceivedAd(MillennialAdapter.this);
    }
  }
  
  private class InterstitialListener
    implements MMAdView.MMAdListener
  {
    private InterstitialListener() {}
    
    public void MMAdCachingCompleted(MMAdView paramMMAdView, boolean paramBoolean)
    {
      if (!paramBoolean)
      {
        MillennialAdapter.this.interstitialListener.onFailedToReceiveAd(MillennialAdapter.this, AdRequest.ErrorCode.NETWORK_ERROR);
        return;
      }
      MillennialAdapter.this.interstitialListener.onReceivedAd(MillennialAdapter.this);
    }
    
    public void MMAdClickedToOverlay(MMAdView paramMMAdView)
    {
      MillennialAdapter.this.interstitialListener.onPresentScreen(MillennialAdapter.this);
    }
    
    public void MMAdFailed(MMAdView paramMMAdView)
    {
      MillennialAdapter.this.interstitialListener.onFailedToReceiveAd(MillennialAdapter.this, AdRequest.ErrorCode.NO_FILL);
    }
    
    public void MMAdOverlayLaunched(MMAdView paramMMAdView)
    {
      MillennialAdapter.this.interstitialListener.onPresentScreen(MillennialAdapter.this);
    }
    
    public void MMAdRequestIsCaching(MMAdView paramMMAdView) {}
    
    public void MMAdReturned(MMAdView paramMMAdView) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/mediation/millennial/MillennialAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */