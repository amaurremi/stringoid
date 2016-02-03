package com.flurry.android;

import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest.ErrorCode;
import java.util.Collections;

final class ae
  implements AdListener
{
  private ae(ai paramai, byte paramByte) {}
  
  public final void onDismissScreen(Ad paramAd)
  {
    this.au.onAdClosed(Collections.emptyMap());
    db.e(ai.z(), "Admob AdView dismissed from screen.");
  }
  
  public final void onFailedToReceiveAd(Ad paramAd, AdRequest.ErrorCode paramErrorCode)
  {
    this.au.onRenderFailed(Collections.emptyMap());
    db.g(ai.z(), "Admob AdView failed to receive ad.");
  }
  
  public final void onLeaveApplication(Ad paramAd)
  {
    this.au.onAdClicked(Collections.emptyMap());
    db.e(ai.z(), "Admob AdView leave application.");
  }
  
  public final void onPresentScreen(Ad paramAd)
  {
    db.e(ai.z(), "Admob AdView present on screen.");
  }
  
  public final void onReceiveAd(Ad paramAd)
  {
    this.au.onAdFilled(Collections.emptyMap());
    this.au.onAdShown(Collections.emptyMap());
    db.e(ai.z(), "Admob AdView received ad.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */