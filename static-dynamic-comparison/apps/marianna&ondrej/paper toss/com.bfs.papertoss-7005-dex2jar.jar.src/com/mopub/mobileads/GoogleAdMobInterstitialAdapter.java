package com.mopub.mobileads;

import android.location.Location;
import android.util.Log;
import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.InterstitialAd;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class GoogleAdMobInterstitialAdapter
  extends BaseInterstitialAdapter
  implements AdListener
{
  private boolean mHasAlreadyRegisteredClick;
  private boolean mHasPrefetchedInterstitial;
  private InterstitialAd mInterstitialAd;
  
  public void init(MoPubInterstitial paramMoPubInterstitial, String paramString)
  {
    super.init(paramMoPubInterstitial, paramString);
    try
    {
      paramMoPubInterstitial = ((JSONObject)new JSONTokener(this.mJsonParams).nextValue()).getString("adUnitID");
      this.mInterstitialAd = new InterstitialAd(this.mInterstitial.getActivity(), paramMoPubInterstitial);
      this.mInterstitialAd.setAdListener(this);
      return;
    }
    catch (JSONException paramMoPubInterstitial)
    {
      while (this.mAdapterListener == null) {}
      this.mAdapterListener.onNativeInterstitialFailed(this);
    }
  }
  
  public void loadInterstitial()
  {
    if (isInvalidated()) {
      return;
    }
    AdRequest localAdRequest = new AdRequest();
    Location localLocation = this.mInterstitial.getLocation();
    if (localLocation != null) {
      localAdRequest.setLocation(localLocation);
    }
    this.mHasPrefetchedInterstitial = false;
    this.mInterstitialAd.loadAd(localAdRequest);
  }
  
  public void onDismissScreen(Ad paramAd) {}
  
  public void onFailedToReceiveAd(Ad paramAd, AdRequest.ErrorCode paramErrorCode)
  {
    if (isInvalidated()) {}
    do
    {
      return;
      Log.d("MoPub", "Google AdMob interstitial failed. Trying another");
      this.mHasPrefetchedInterstitial = false;
    } while (this.mAdapterListener == null);
    this.mAdapterListener.onNativeInterstitialFailed(this);
  }
  
  public void onLeaveApplication(Ad paramAd)
  {
    if (isInvalidated()) {}
    do
    {
      do
      {
        return;
        Log.d("MoPub", "Google AdMob interstitial was clicked, leaving application");
      } while (this.mHasAlreadyRegisteredClick);
      this.mHasAlreadyRegisteredClick = true;
    } while (this.mAdapterListener == null);
    this.mAdapterListener.onNativeInterstitialClicked(this);
  }
  
  public void onPresentScreen(Ad paramAd) {}
  
  public void onReceiveAd(Ad paramAd)
  {
    if (isInvalidated()) {}
    do
    {
      return;
      Log.d("MoPub", "Google AdMob interstitial received an ad successfully.");
      this.mHasPrefetchedInterstitial = true;
    } while (this.mAdapterListener == null);
    this.mAdapterListener.onNativeInterstitialLoaded(this);
  }
  
  public void showInterstitial()
  {
    if (isInvalidated()) {}
    while (!this.mHasPrefetchedInterstitial) {
      return;
    }
    this.mInterstitialAd.show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/mopub/mobileads/GoogleAdMobInterstitialAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */