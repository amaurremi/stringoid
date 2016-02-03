package com.google.ads.mediation.admob;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.ads.AdRequest.Gender;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.internal.bg;
import com.google.android.gms.internal.cs;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public final class AdMobAdapter
  implements MediationBannerAdapter<AdMobExtras, AdMobServerParameters>, MediationInterstitialAdapter<AdMobExtras, AdMobServerParameters>
{
  private AdView h;
  private InterstitialAd i;
  
  private static AdRequest a(Context paramContext, MediationAdRequest paramMediationAdRequest, AdMobExtras paramAdMobExtras, AdMobServerParameters paramAdMobServerParameters)
  {
    AdRequest.Builder localBuilder = new AdRequest.Builder();
    Object localObject = paramMediationAdRequest.getBirthday();
    if (localObject != null) {
      localBuilder.setBirthday((Date)localObject);
    }
    localObject = paramMediationAdRequest.getGender();
    if (localObject != null) {
      localBuilder.setGender(bg.a((AdRequest.Gender)localObject));
    }
    localObject = paramMediationAdRequest.getKeywords();
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localBuilder.addKeyword((String)((Iterator)localObject).next());
      }
    }
    if (paramMediationAdRequest.isTesting()) {
      localBuilder.addTestDevice(cs.l(paramContext));
    }
    boolean bool;
    if (paramAdMobServerParameters.tagForChildDirectedTreatment != -1)
    {
      if (paramAdMobServerParameters.tagForChildDirectedTreatment == 1)
      {
        bool = true;
        localBuilder.tagForChildDirectedTreatment(bool);
      }
    }
    else {
      if (paramAdMobExtras == null) {
        break label215;
      }
    }
    for (;;)
    {
      paramContext = paramAdMobExtras.getExtras();
      paramContext.putInt("gw", 1);
      paramContext.putString("mad_hac", paramAdMobServerParameters.allowHouseAds);
      if (!TextUtils.isEmpty(paramAdMobServerParameters.adJson)) {
        paramContext.putString("_ad", paramAdMobServerParameters.adJson);
      }
      paramContext.putBoolean("_noRefresh", true);
      localBuilder.addNetworkExtras(paramAdMobExtras);
      return localBuilder.build();
      bool = false;
      break;
      label215:
      paramAdMobExtras = new AdMobExtras(new Bundle());
    }
  }
  
  public void destroy()
  {
    if (this.h != null)
    {
      this.h.destroy();
      this.h = null;
    }
    if (this.i != null) {
      this.i = null;
    }
  }
  
  public Class<AdMobExtras> getAdditionalParametersType()
  {
    return AdMobExtras.class;
  }
  
  public View getBannerView()
  {
    return this.h;
  }
  
  public Class<AdMobServerParameters> getServerParametersType()
  {
    return AdMobServerParameters.class;
  }
  
  public void requestBannerAd(MediationBannerListener paramMediationBannerListener, Activity paramActivity, AdMobServerParameters paramAdMobServerParameters, com.google.ads.AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, AdMobExtras paramAdMobExtras)
  {
    this.h = new AdView(paramActivity);
    this.h.setAdSize(new com.google.android.gms.ads.AdSize(paramAdSize.getWidth(), paramAdSize.getHeight()));
    this.h.setAdUnitId(paramAdMobServerParameters.adUnitId);
    this.h.setAdListener(new a(this, paramMediationBannerListener));
    this.h.loadAd(a(paramActivity, paramMediationAdRequest, paramAdMobExtras, paramAdMobServerParameters));
  }
  
  public void requestInterstitialAd(MediationInterstitialListener paramMediationInterstitialListener, Activity paramActivity, AdMobServerParameters paramAdMobServerParameters, MediationAdRequest paramMediationAdRequest, AdMobExtras paramAdMobExtras)
  {
    this.i = new InterstitialAd(paramActivity);
    this.i.setAdUnitId(paramAdMobServerParameters.adUnitId);
    this.i.setAdListener(new b(this, paramMediationInterstitialListener));
    this.i.loadAd(a(paramActivity, paramMediationAdRequest, paramAdMobExtras, paramAdMobServerParameters));
  }
  
  public void showInterstitial()
  {
    this.i.show();
  }
  
  private static final class a
    extends AdListener
  {
    private final AdMobAdapter j;
    private final MediationBannerListener k;
    
    public a(AdMobAdapter paramAdMobAdapter, MediationBannerListener paramMediationBannerListener)
    {
      this.j = paramAdMobAdapter;
      this.k = paramMediationBannerListener;
    }
    
    public void onAdClosed()
    {
      this.k.onDismissScreen(this.j);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      this.k.onFailedToReceiveAd(this.j, bg.h(paramInt));
    }
    
    public void onAdLeftApplication()
    {
      this.k.onLeaveApplication(this.j);
    }
    
    public void onAdLoaded()
    {
      this.k.onReceivedAd(this.j);
    }
    
    public void onAdOpened()
    {
      this.k.onClick(this.j);
      this.k.onPresentScreen(this.j);
    }
  }
  
  private static final class b
    extends AdListener
  {
    private final AdMobAdapter j;
    private final MediationInterstitialListener l;
    
    public b(AdMobAdapter paramAdMobAdapter, MediationInterstitialListener paramMediationInterstitialListener)
    {
      this.j = paramAdMobAdapter;
      this.l = paramMediationInterstitialListener;
    }
    
    public void onAdClosed()
    {
      this.l.onDismissScreen(this.j);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      this.l.onFailedToReceiveAd(this.j, bg.h(paramInt));
    }
    
    public void onAdLeftApplication()
    {
      this.l.onLeaveApplication(this.j);
    }
    
    public void onAdLoaded()
    {
      this.l.onReceivedAd(this.j);
    }
    
    public void onAdOpened()
    {
      this.l.onPresentScreen(this.j);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/ads/mediation/admob/AdMobAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */