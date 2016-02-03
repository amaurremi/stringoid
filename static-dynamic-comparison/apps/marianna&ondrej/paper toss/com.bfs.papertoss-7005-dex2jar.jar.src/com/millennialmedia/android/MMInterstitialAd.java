package com.millennialmedia.android;

import android.content.Context;

public class MMInterstitialAd
  extends MMAdView
{
  public MMInterstitialAd(Context paramContext)
  {
    super(paramContext, "28911", "MMFullScreenAdTransition", false, null);
  }
  
  public boolean display()
  {
    return display(false);
  }
  
  public boolean display(boolean paramBoolean)
  {
    boolean bool = false;
    try
    {
      i = super.displayInternal();
      if ((i != 0) && (paramBoolean)) {
        throw new MMError(i);
      }
    }
    catch (Exception localException)
    {
      int i;
      if (paramBoolean)
      {
        throw new MMError(localException);
        if (i == 0) {
          bool = true;
        }
      }
    }
    return bool;
  }
  
  public void fetch(String paramString, MMAdView.RequestListener paramRequestListener)
  {
    paramString = new MMAdView.Request(paramString, paramRequestListener, true);
    if (super.check())
    {
      MMAdViewSDK.Log.d("Ad already fetched and ready for display...");
      MMAdViewSDK.Event.requestFailed(getContext(), this, paramString, new MMError(17));
      return;
    }
    if (!canRequestAd())
    {
      MMAdViewSDK.Event.requestFailed(getContext(), this, paramString, new MMError(16));
      return;
    }
    MMAdViewSDK.Log.d("Fetching new ad...");
    super.requestAd(paramString);
  }
  
  public boolean isAdAvailable()
  {
    return super.check();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/millennialmedia/android/MMInterstitialAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */