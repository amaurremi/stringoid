package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.internal.ah;

public final class InterstitialAd
{
  private final ah ea;
  
  public InterstitialAd(Context paramContext)
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
  
  public boolean isLoaded()
  {
    return this.ea.isLoaded();
  }
  
  public void loadAd(AdRequest paramAdRequest)
  {
    this.ea.a(paramAdRequest.v());
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    this.ea.setAdListener(paramAdListener);
  }
  
  public void setAdUnitId(String paramString)
  {
    this.ea.setAdUnitId(paramString);
  }
  
  public void show()
  {
    this.ea.show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/ads/InterstitialAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */