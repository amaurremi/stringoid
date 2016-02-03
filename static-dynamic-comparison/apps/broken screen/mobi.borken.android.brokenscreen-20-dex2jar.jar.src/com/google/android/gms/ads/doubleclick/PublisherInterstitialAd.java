package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.aw;

public final class PublisherInterstitialAd
{
  private final aw kw;
  
  public PublisherInterstitialAd(Context paramContext)
  {
    this.kw = new aw(paramContext);
  }
  
  public AdListener getAdListener()
  {
    return this.kw.getAdListener();
  }
  
  public String getAdUnitId()
  {
    return this.kw.getAdUnitId();
  }
  
  public AppEventListener getAppEventListener()
  {
    return this.kw.getAppEventListener();
  }
  
  public boolean isLoaded()
  {
    return this.kw.isLoaded();
  }
  
  public void loadAd(PublisherAdRequest paramPublisherAdRequest)
  {
    this.kw.a(paramPublisherAdRequest.O());
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    this.kw.setAdListener(paramAdListener);
  }
  
  public void setAdUnitId(String paramString)
  {
    this.kw.setAdUnitId(paramString);
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    this.kw.setAppEventListener(paramAppEventListener);
  }
  
  public void show()
  {
    this.kw.show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/ads/doubleclick/PublisherInterstitialAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */