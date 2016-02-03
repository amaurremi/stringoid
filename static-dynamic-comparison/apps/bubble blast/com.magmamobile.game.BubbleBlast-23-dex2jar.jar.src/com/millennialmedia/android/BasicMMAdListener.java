package com.millennialmedia.android;

import android.util.Log;

public class BasicMMAdListener
  implements MMAdView.MMAdListener
{
  public void MMAdCachingCompleted(MMAdView paramMMAdView, boolean paramBoolean)
  {
    Log.i("MillennialMediaSDK", "Millennial Media Ad View caching request completed successfully: " + paramBoolean);
  }
  
  public void MMAdClickedToNewBrowser(MMAdView paramMMAdView)
  {
    Log.i("MillennialMediaSDK", "Millennial Media Ad View clicked and launched new browser");
  }
  
  public void MMAdClickedToOverlay(MMAdView paramMMAdView)
  {
    Log.i("MillennialMediaSDK", "Millennial Media Ad View clicked to overlay");
  }
  
  public void MMAdFailed(MMAdView paramMMAdView)
  {
    Log.i("MillennialMediaSDK", "Millennial Media Ad View request failed");
  }
  
  public void MMAdOverlayLaunched(MMAdView paramMMAdView)
  {
    Log.i("MillennialMediaSDK", "Millennial Media Ad View overlay launched");
  }
  
  public void MMAdRequestIsCaching(MMAdView paramMMAdView)
  {
    Log.i("MillennialMediaSDK", "Millennial Media Ad View caching request");
  }
  
  public void MMAdReturned(MMAdView paramMMAdView)
  {
    Log.i("MillennialMediaSDK", "Millennial Media Ad View request succeeded");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/millennialmedia/android/BasicMMAdListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */