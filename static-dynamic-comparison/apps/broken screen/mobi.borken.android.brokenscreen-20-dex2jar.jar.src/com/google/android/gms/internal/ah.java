package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;

public final class ah
  extends aq.a
{
  private final AdListener lO;
  
  public ah(AdListener paramAdListener)
  {
    this.lO = paramAdListener;
  }
  
  public void onAdClosed()
  {
    this.lO.onAdClosed();
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    this.lO.onAdFailedToLoad(paramInt);
  }
  
  public void onAdLeftApplication()
  {
    this.lO.onAdLeftApplication();
  }
  
  public void onAdLoaded()
  {
    this.lO.onAdLoaded();
  }
  
  public void onAdOpened()
  {
    this.lO.onAdOpened();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */