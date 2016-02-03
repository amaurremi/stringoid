package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.au;

public final class PublisherInterstitialAd
{
  private final au kv;
  
  public PublisherInterstitialAd(Context paramContext)
  {
    this.kv = new au(paramContext);
  }
  
  public AdListener getAdListener()
  {
    return this.kv.getAdListener();
  }
  
  public String getAdUnitId()
  {
    return this.kv.getAdUnitId();
  }
  
  public AppEventListener getAppEventListener()
  {
    return this.kv.getAppEventListener();
  }
  
  public boolean isLoaded()
  {
    return this.kv.isLoaded();
  }
  
  public void loadAd(PublisherAdRequest paramPublisherAdRequest)
  {
    this.kv.a(paramPublisherAdRequest.O());
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    this.kv.setAdListener(paramAdListener);
  }
  
  public void setAdUnitId(String paramString)
  {
    this.kv.setAdUnitId(paramString);
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    this.kv.setAppEventListener(paramAppEventListener);
  }
  
  public void show()
  {
    this.kv.show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/ads/doubleclick/PublisherInterstitialAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */