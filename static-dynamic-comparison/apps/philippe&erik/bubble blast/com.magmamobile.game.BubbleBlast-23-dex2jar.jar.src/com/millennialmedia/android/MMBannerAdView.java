package com.millennialmedia.android;

import android.content.Context;
import android.util.AttributeSet;

public class MMBannerAdView
  extends MMAdView
{
  public MMBannerAdView(Context paramContext)
  {
    super(paramContext, "28911", "MMBannerAdBottom", -1);
  }
  
  public MMBannerAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MMBannerAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void getAd(String paramString, MMAdView.RequestListener paramRequestListener)
  {
    paramString = new MMAdView.Request(paramString, paramRequestListener, false);
    if (!super.canRequestAd())
    {
      MMAdViewSDK.Event.requestFailed(getContext(), this, paramString, new MMError(16));
      return;
    }
    super.requestAd(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/millennialmedia/android/MMBannerAdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */