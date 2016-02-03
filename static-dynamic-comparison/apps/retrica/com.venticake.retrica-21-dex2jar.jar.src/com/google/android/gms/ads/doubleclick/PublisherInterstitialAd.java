package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.av;

public final class PublisherInterstitialAd
{
  private final av ky;
  
  public PublisherInterstitialAd(Context paramContext)
  {
    this.ky = new av(paramContext);
  }
  
  public AdListener getAdListener()
  {
    return this.ky.getAdListener();
  }
  
  public String getAdUnitId()
  {
    return this.ky.getAdUnitId();
  }
  
  public AppEventListener getAppEventListener()
  {
    return this.ky.getAppEventListener();
  }
  
  public boolean isLoaded()
  {
    return this.ky.isLoaded();
  }
  
  public void loadAd(PublisherAdRequest paramPublisherAdRequest)
  {
    this.ky.a(paramPublisherAdRequest.T());
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    this.ky.setAdListener(paramAdListener);
  }
  
  public void setAdUnitId(String paramString)
  {
    this.ky.setAdUnitId(paramString);
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    this.ky.setAppEventListener(paramAppEventListener);
  }
  
  public void show()
  {
    this.ky.show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/ads/doubleclick/PublisherInterstitialAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */