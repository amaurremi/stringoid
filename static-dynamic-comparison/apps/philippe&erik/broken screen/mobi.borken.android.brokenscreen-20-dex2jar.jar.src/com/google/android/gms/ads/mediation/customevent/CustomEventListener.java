package com.google.android.gms.ads.mediation.customevent;

public abstract interface CustomEventListener
{
  public abstract void onAdClicked();
  
  public abstract void onAdClosed();
  
  public abstract void onAdFailedToLoad(int paramInt);
  
  public abstract void onAdLeftApplication();
  
  public abstract void onAdOpened();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/ads/mediation/customevent/CustomEventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */