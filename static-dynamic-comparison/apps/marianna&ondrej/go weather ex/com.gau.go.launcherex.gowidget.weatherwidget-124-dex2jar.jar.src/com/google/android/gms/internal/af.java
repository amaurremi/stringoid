package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;

public final class af
  extends ao.a
{
  private final AdListener lF;
  
  public af(AdListener paramAdListener)
  {
    this.lF = paramAdListener;
  }
  
  public void onAdClosed()
  {
    this.lF.onAdClosed();
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    this.lF.onAdFailedToLoad(paramInt);
  }
  
  public void onAdLeftApplication()
  {
    this.lF.onAdLeftApplication();
  }
  
  public void onAdLoaded()
  {
    this.lF.onAdLoaded();
  }
  
  public void onAdOpened()
  {
    this.lF.onAdOpened();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */