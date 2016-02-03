package com.flurry.android;

import android.util.Log;
import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMAdView.MMAdListener;
import java.util.Collections;

final class cc
  implements MMAdView.MMAdListener
{
  cc(ar paramar) {}
  
  public final void MMAdCachingCompleted(MMAdView paramMMAdView, boolean paramBoolean)
  {
    Log.d(ar.d(), "Millennial MMAdView Interstitial caching completed." + System.currentTimeMillis() + " fInter_success = " + ar.a(this.ep) + " success = " + paramBoolean);
    if (!ar.a(this.ep)) {
      paramMMAdView.display();
    }
  }
  
  public final void MMAdClickedToOverlay(MMAdView paramMMAdView)
  {
    this.ep.onAdClicked(Collections.emptyMap());
    Log.d(ar.d(), "Millennial MMAdView Interstitial clicked to overlay." + System.currentTimeMillis());
  }
  
  public final void MMAdFailed(MMAdView paramMMAdView)
  {
    this.ep.onRenderFailed(Collections.emptyMap());
    Log.d(ar.d(), "Millennial MMAdView Interstitial failed to load ad.");
  }
  
  public final void MMAdOverlayLaunched(MMAdView paramMMAdView)
  {
    this.ep.onAdFilled(Collections.emptyMap());
    this.ep.onAdShown(Collections.emptyMap());
    this.ep.onAdClosed(Collections.emptyMap());
    Log.d(ar.d(), "Millennial MMAdView Interstitial overlay launched." + System.currentTimeMillis());
  }
  
  public final void MMAdRequestIsCaching(MMAdView paramMMAdView)
  {
    Log.d(ar.d(), "Millennial MMAdView Interstitial request is caching.");
  }
  
  public final void MMAdReturned(MMAdView paramMMAdView)
  {
    Log.d(ar.d(), "Millennial MMAdView In returned interstitial ad.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */