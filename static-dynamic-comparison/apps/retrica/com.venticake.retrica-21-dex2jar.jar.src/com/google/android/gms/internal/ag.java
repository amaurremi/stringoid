package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;

public final class ag
  extends ap.a
{
  private final AdListener lQ;
  
  public ag(AdListener paramAdListener)
  {
    this.lQ = paramAdListener;
  }
  
  public void onAdClosed()
  {
    this.lQ.onAdClosed();
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    this.lQ.onAdFailedToLoad(paramInt);
  }
  
  public void onAdLeftApplication()
  {
    this.lQ.onAdLeftApplication();
  }
  
  public void onAdLoaded()
  {
    this.lQ.onAdLoaded();
  }
  
  public void onAdOpened()
  {
    this.lQ.onAdOpened();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */