package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.av;

public final class InterstitialAd
{
  private final av ky;
  
  public InterstitialAd(Context paramContext)
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
  
  public InAppPurchaseListener getInAppPurchaseListener()
  {
    return this.ky.getInAppPurchaseListener();
  }
  
  public boolean isLoaded()
  {
    return this.ky.isLoaded();
  }
  
  public void loadAd(AdRequest paramAdRequest)
  {
    this.ky.a(paramAdRequest.T());
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    this.ky.setAdListener(paramAdListener);
  }
  
  public void setAdUnitId(String paramString)
  {
    this.ky.setAdUnitId(paramString);
  }
  
  public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener)
  {
    this.ky.setInAppPurchaseListener(paramInAppPurchaseListener);
  }
  
  public void setPlayStorePurchaseParams(PlayStorePurchaseListener paramPlayStorePurchaseListener, String paramString)
  {
    this.ky.setPlayStorePurchaseParams(paramPlayStorePurchaseListener, paramString);
  }
  
  public void show()
  {
    this.ky.show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/ads/InterstitialAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */