package com.mopub.mobileads;

import android.location.Location;
import android.util.Log;
import android.widget.FrameLayout.LayoutParams;
import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class GoogleAdMobAdapter
  extends BaseAdapter
  implements AdListener
{
  private AdView mAdMobView;
  
  public void invalidate()
  {
    if (this.mAdMobView != null)
    {
      this.mMoPubView.removeView(this.mAdMobView);
      this.mAdMobView.destroy();
    }
    super.invalidate();
  }
  
  public void loadAd()
  {
    if (isInvalidated()) {
      return;
    }
    Object localObject1 = AdSize.BANNER;
    int i;
    int j;
    for (;;)
    {
      try
      {
        localObject1 = (JSONObject)new JSONTokener(this.mJsonParams).nextValue();
        Object localObject2 = ((JSONObject)localObject1).getString("adUnitID");
        i = ((JSONObject)localObject1).getInt("adWidth");
        j = ((JSONObject)localObject1).getInt("adHeight");
        if ((i <= AdSize.BANNER.getWidth()) && (j <= AdSize.BANNER.getHeight()))
        {
          localObject1 = AdSize.BANNER;
          this.mAdMobView = new AdView(this.mMoPubView.getActivity(), (AdSize)localObject1, (String)localObject2);
          this.mAdMobView.setAdListener(this);
          localObject1 = new AdRequest();
          localObject2 = this.mMoPubView.getLocation();
          if (localObject2 != null) {
            ((AdRequest)localObject1).setLocation((Location)localObject2);
          }
          this.mAdMobView.loadAd((AdRequest)localObject1);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        this.mMoPubView.loadFailUrl();
        return;
      }
      AdSize localAdSize;
      if ((i <= AdSize.IAB_MRECT.getWidth()) && (j <= AdSize.IAB_MRECT.getHeight()))
      {
        localAdSize = AdSize.IAB_MRECT;
      }
      else if ((i <= AdSize.IAB_BANNER.getWidth()) && (j <= AdSize.IAB_BANNER.getHeight()))
      {
        localAdSize = AdSize.IAB_BANNER;
      }
      else
      {
        if ((i > AdSize.IAB_LEADERBOARD.getWidth()) || (j > AdSize.IAB_LEADERBOARD.getHeight())) {
          break;
        }
        localAdSize = AdSize.IAB_LEADERBOARD;
      }
    }
    Log.e("MoPub", "Failed to retrieve ad from AdMob native. Unsupported ad size: " + i + "x" + j);
    this.mMoPubView.loadFailUrl();
  }
  
  public void onDismissScreen(Ad paramAd) {}
  
  public void onFailedToReceiveAd(Ad paramAd, AdRequest.ErrorCode paramErrorCode)
  {
    if (isInvalidated()) {
      return;
    }
    Log.d("MoPub", "Google AdMob failed. Trying another");
    this.mMoPubView.loadFailUrl();
  }
  
  public void onLeaveApplication(Ad paramAd) {}
  
  public void onPresentScreen(Ad paramAd)
  {
    if (isInvalidated()) {
      return;
    }
    Log.d("MoPub", "Google AdMob clicked");
    this.mMoPubView.registerClick();
  }
  
  public void onReceiveAd(Ad paramAd)
  {
    if (isInvalidated()) {
      return;
    }
    Log.d("MoPub", "Google AdMob load succeeded. Showing ad...");
    this.mMoPubView.removeAllViews();
    paramAd = new FrameLayout.LayoutParams(-1, -1);
    paramAd.gravity = 17;
    this.mMoPubView.addView(this.mAdMobView, paramAd);
    this.mMoPubView.nativeAdLoaded();
    this.mMoPubView.trackNativeImpression();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/mopub/mobileads/GoogleAdMobAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */