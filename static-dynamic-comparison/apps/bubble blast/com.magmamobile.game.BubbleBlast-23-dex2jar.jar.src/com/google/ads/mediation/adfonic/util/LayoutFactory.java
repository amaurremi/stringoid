package com.google.ads.mediation.adfonic.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.FrameLayout.LayoutParams;
import com.google.ads.AdSize;

public class LayoutFactory
{
  private int convert(int paramInt, DisplayMetrics paramDisplayMetrics)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramDisplayMetrics);
  }
  
  public FrameLayout.LayoutParams buildLayoutForAd(Context paramContext, AdSize paramAdSize)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    if (AdSize.BANNER == paramAdSize) {
      return new FrameLayout.LayoutParams(convert(320, paramContext), convert(48, paramContext), 17);
    }
    if (AdSize.IAB_BANNER == paramAdSize) {
      return new FrameLayout.LayoutParams(convert(468, paramContext), convert(60, paramContext), 17);
    }
    if (AdSize.IAB_LEADERBOARD == paramAdSize) {
      return new FrameLayout.LayoutParams(convert(728, paramContext), convert(90, paramContext), 17);
    }
    if (AdSize.IAB_MRECT == paramAdSize) {
      return new FrameLayout.LayoutParams(convert(300, paramContext), convert(250, paramContext), 17);
    }
    if (AdSize.IAB_WIDE_SKYSCRAPER == paramAdSize) {
      return new FrameLayout.LayoutParams(convert(120, paramContext), convert(600, paramContext), 17);
    }
    return null;
  }
  
  public FrameLayout.LayoutParams buildLayoutForInterstitial(Activity paramActivity)
  {
    return new FrameLayout.LayoutParams(-1, -1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/mediation/adfonic/util/LayoutFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */