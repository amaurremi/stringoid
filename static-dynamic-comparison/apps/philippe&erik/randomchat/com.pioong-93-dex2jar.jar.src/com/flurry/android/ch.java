package com.flurry.android;

import android.util.Log;
import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.InterstitialAd;
import java.util.Collections;

final class ch
  implements AdListener
{
  private ch(ak paramak, byte paramByte) {}
  
  public final void onDismissScreen(Ad paramAd)
  {
    this.es.onAdClosed(Collections.emptyMap());
    Log.i(ak.B(), "Admob Interstitial dismissed from screen.");
  }
  
  public final void onFailedToReceiveAd(Ad paramAd, AdRequest.ErrorCode paramErrorCode)
  {
    this.es.onRenderFailed(Collections.emptyMap());
    Log.d(ak.B(), "Admob Interstitial failed to receive takeover.");
  }
  
  public final void onLeaveApplication(Ad paramAd)
  {
    this.es.onAdClicked(Collections.emptyMap());
    Log.i(ak.B(), "Admob Interstitial leave application.");
  }
  
  public final void onPresentScreen(Ad paramAd)
  {
    Log.d(ak.B(), "Admob Interstitial present on screen.");
  }
  
  public final void onReceiveAd(Ad paramAd)
  {
    if (paramAd == ak.a(this.es))
    {
      this.es.onAdFilled(Collections.emptyMap());
      Log.d(ak.B(), "Admob Interstitial received takeover.");
      this.es.onAdShown(Collections.emptyMap());
      ak.a(this.es).show();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */