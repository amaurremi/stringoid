package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;

public final class t
  extends ab.a
{
  private final AdListener ev;
  
  public t(AdListener paramAdListener)
  {
    this.ev = paramAdListener;
  }
  
  public void onAdClosed()
  {
    this.ev.onAdClosed();
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    this.ev.onAdFailedToLoad(paramInt);
  }
  
  public void onAdLeftApplication()
  {
    this.ev.onAdLeftApplication();
  }
  
  public void onAdLoaded()
  {
    this.ev.onAdLoaded();
  }
  
  public void onAdOpened()
  {
    this.ev.onAdOpened();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */