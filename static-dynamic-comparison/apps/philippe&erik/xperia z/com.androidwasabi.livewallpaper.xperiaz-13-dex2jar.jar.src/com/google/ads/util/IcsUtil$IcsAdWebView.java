package com.google.ads.util;

import com.google.ads.AdSize;
import com.google.ads.internal.ActivationOverlay;
import com.google.ads.internal.AdWebView;
import com.google.ads.n;

public class IcsUtil$IcsAdWebView
  extends AdWebView
{
  public IcsUtil$IcsAdWebView(n paramn, AdSize paramAdSize)
  {
    super(paramn, paramAdSize);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    if (this.a.e.a() != null) {
      return !((ActivationOverlay)this.a.e.a()).b();
    }
    return super.canScrollHorizontally(paramInt);
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    if (this.a.e.a() != null) {
      return !((ActivationOverlay)this.a.e.a()).b();
    }
    return super.canScrollVertically(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/util/IcsUtil$IcsAdWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */