package com.google.ads.mediation.admob;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.et;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public final class AdMobAdapter
  implements MediationBannerAdapter, MediationInterstitialAdapter
{
  private AdView i;
  private InterstitialAd j;
  
  private static AdRequest a(Context paramContext, MediationAdRequest paramMediationAdRequest, Bundle paramBundle1, Bundle paramBundle2)
  {
    AdRequest.Builder localBuilder = new AdRequest.Builder();
    Object localObject = paramMediationAdRequest.getBirthday();
    if (localObject != null) {
      localBuilder.setBirthday((Date)localObject);
    }
    int k = paramMediationAdRequest.getGender();
    if (k != 0) {
      localBuilder.setGender(k);
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
      localBuilder.addTestDevice(et.r(paramContext));
    }
    boolean bool;
    if (paramBundle2.getInt("tagForChildDirectedTreatment") != -1)
    {
      if (paramBundle2.getInt("tagForChildDirectedTreatment") == 1)
      {
        bool = true;
        localBuilder.tagForChildDirectedTreatment(bool);
      }
    }
    else {
      if (paramBundle1 == null) {
        break label227;
      }
    }
    for (;;)
    {
      paramBundle1.putInt("gw", 1);
      paramBundle1.putString("mad_hac", paramBundle2.getString("mad_hac"));
      if (!TextUtils.isEmpty(paramBundle2.getString("adJson"))) {
        paramBundle1.putString("_ad", paramBundle2.getString("adJson"));
      }
      paramBundle1.putBoolean("_noRefresh", true);
      localBuilder.addNetworkExtrasBundle(AdMobAdapter.class, paramBundle1);
      return localBuilder.build();
      bool = false;
      break;
      label227:
      paramBundle1 = new Bundle();
    }
  }
  
  public View getBannerView()
  {
    return this.i;
  }
  
  public void onDestroy()
  {
    if (this.i != null)
    {
      this.i.destroy();
      this.i = null;
    }
    if (this.j != null) {
      this.j = null;
    }
  }
  
  public void onPause()
  {
    if (this.i != null) {
      this.i.pause();
    }
  }
  
  public void onResume()
  {
    if (this.i != null) {
      this.i.resume();
    }
  }
  
  public void requestBannerAd(Context paramContext, MediationBannerListener paramMediationBannerListener, Bundle paramBundle1, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    this.i = new AdView(paramContext);
    this.i.setAdSize(new AdSize(paramAdSize.getWidth(), paramAdSize.getHeight()));
    this.i.setAdUnitId(paramBundle1.getString("pubid"));
    this.i.setAdListener(new a(this, paramMediationBannerListener));
    this.i.loadAd(a(paramContext, paramMediationAdRequest, paramBundle2, paramBundle1));
  }
  
  public void requestInterstitialAd(Context paramContext, MediationInterstitialListener paramMediationInterstitialListener, Bundle paramBundle1, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    this.j = new InterstitialAd(paramContext);
    this.j.setAdUnitId(paramBundle1.getString("pubid"));
    this.j.setAdListener(new b(this, paramMediationInterstitialListener));
    this.j.loadAd(a(paramContext, paramMediationAdRequest, paramBundle2, paramBundle1));
  }
  
  public void showInterstitial()
  {
    this.j.show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/ads/mediation/admob/AdMobAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */