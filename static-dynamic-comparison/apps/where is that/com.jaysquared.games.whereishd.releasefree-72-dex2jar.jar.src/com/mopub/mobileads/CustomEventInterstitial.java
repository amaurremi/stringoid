package com.mopub.mobileads;

import android.content.Context;
import java.util.Map;

public abstract class CustomEventInterstitial
{
  protected abstract void loadInterstitial(Context paramContext, CustomEventInterstitialListener paramCustomEventInterstitialListener, Map<String, Object> paramMap, Map<String, String> paramMap1);
  
  protected abstract void onInvalidate();
  
  protected abstract void showInterstitial();
  
  public static abstract interface CustomEventInterstitialListener
  {
    public abstract void onInterstitialClicked();
    
    public abstract void onInterstitialDismissed();
    
    public abstract void onInterstitialFailed(MoPubErrorCode paramMoPubErrorCode);
    
    public abstract void onInterstitialLoaded();
    
    public abstract void onInterstitialShown();
    
    public abstract void onLeaveApplication();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/CustomEventInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */