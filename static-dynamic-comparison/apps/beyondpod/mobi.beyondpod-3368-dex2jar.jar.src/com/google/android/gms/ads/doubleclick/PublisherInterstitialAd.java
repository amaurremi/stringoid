package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.ah;

public final class PublisherInterstitialAd
{
  private final ah ea;
  
  public PublisherInterstitialAd(Context paramContext)
  {
    this.ea = new ah(paramContext);
  }
  
  public AdListener getAdListener()
  {
    return this.ea.getAdListener();
  }
  
  public String getAdUnitId()
  {
    return this.ea.getAdUnitId();
  }
  
  public AppEventListener getAppEventListener()
  {
    return this.ea.getAppEventListener();
  }
  
  public boolean isLoaded()
  {
    return this.ea.isLoaded();
  }
  
  public void loadAd(PublisherAdRequest paramPublisherAdRequest)
  {
    this.ea.a(paramPublisherAdRequest.v());
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    this.ea.setAdListener(paramAdListener);
  }
  
  public void setAdUnitId(String paramString)
  {
    this.ea.setAdUnitId(paramString);
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    this.ea.setAppEventListener(paramAppEventListener);
  }
  
  public void show()
  {
    this.ea.show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/ads/doubleclick/PublisherInterstitialAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */