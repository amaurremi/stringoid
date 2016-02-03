package com.google.ads.mediation.customevent;

import android.view.View;

public abstract interface CustomEventBannerListener
  extends CustomEventListener
{
  public abstract void onClick();
  
  public abstract void onReceivedAd(View paramView);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/google/ads/mediation/customevent/CustomEventBannerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */