package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public final class AdapterHelper
{
  private final Context mContext;
  private final int mInterval;
  private final int mStart;
  
  public AdapterHelper(Context paramContext, int paramInt1, int paramInt2)
    throws IllegalArgumentException
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Illegal argument: context was null.");
    }
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Illegal argument: negative starting position.");
    }
    if (paramInt2 < 2) {
      throw new IllegalArgumentException("Illegal argument: interval must be at least 2.");
    }
    this.mContext = paramContext.getApplicationContext();
    this.mStart = paramInt1;
    this.mInterval = paramInt2;
  }
  
  private int numberOfAdsSeenUpToPosition(int paramInt)
  {
    if (paramInt <= this.mStart) {
      return 0;
    }
    return (int)Math.floor((paramInt - this.mStart) / this.mInterval) + 1;
  }
  
  private int numberOfAdsThatCouldFitWithContent(int paramInt)
  {
    if (paramInt <= this.mStart) {
      return 0;
    }
    int i = this.mInterval - 1;
    if ((paramInt - this.mStart) % i == 0) {
      return (paramInt - this.mStart) / i;
    }
    return (int)Math.floor((paramInt - this.mStart) / i) + 1;
  }
  
  public View getAdView(View paramView, ViewGroup paramViewGroup, NativeResponse paramNativeResponse, ViewBinder paramViewBinder, MoPubNative.MoPubNativeListener paramMoPubNativeListener)
  {
    return NativeAdViewHelper.getAdView(paramView, paramViewGroup, this.mContext, paramNativeResponse, paramViewBinder, paramMoPubNativeListener);
  }
  
  public boolean isAdPosition(int paramInt)
  {
    if (paramInt < this.mStart) {}
    while ((paramInt - this.mStart) % this.mInterval != 0) {
      return false;
    }
    return true;
  }
  
  public int shiftedCount(int paramInt)
  {
    return numberOfAdsThatCouldFitWithContent(paramInt) + paramInt;
  }
  
  public int shiftedPosition(int paramInt)
  {
    return paramInt - numberOfAdsSeenUpToPosition(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/nativeads/AdapterHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */