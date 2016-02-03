package com.google.ads.doubleclick;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import com.google.ads.AdSize;
import com.google.ads.SwipeableAdListener;
import com.google.ads.internal.ActivationOverlay;
import com.google.ads.internal.d;
import com.google.ads.n;
import com.google.ads.util.i.b;

public class SwipeableDfpAdView
  extends DfpAdView
{
  public SwipeableDfpAdView(Activity paramActivity, AdSize paramAdSize, String paramString)
  {
    super(paramActivity, paramAdSize, paramString);
  }
  
  public SwipeableDfpAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SwipeableDfpAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void resize(AdSize paramAdSize)
  {
    super.resize(paramAdSize);
    if (((ActivationOverlay)this.a.i().e.a()).b()) {
      this.a.a(-1, -1, paramAdSize.getWidth(), paramAdSize.getHeight());
    }
  }
  
  public void setSwipeableEventListener(SwipeableAdListener paramSwipeableAdListener)
  {
    super.setSwipeableEventListener(paramSwipeableAdListener);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/doubleclick/SwipeableDfpAdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */