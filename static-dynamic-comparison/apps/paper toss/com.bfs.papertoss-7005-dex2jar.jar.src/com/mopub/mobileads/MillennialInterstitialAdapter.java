package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.util.Log;
import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMAdView.MMAdListener;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class MillennialInterstitialAdapter
  extends BaseInterstitialAdapter
  implements MMAdView.MMAdListener
{
  private WeakReference<Activity> mActivityReference;
  private final Handler mHandler = new Handler();
  private boolean mHasAlreadyRegisteredClick;
  private MMAdView mMillennialAdView;
  
  private void recordClickIfNecessary()
  {
    if (!this.mHasAlreadyRegisteredClick)
    {
      this.mHasAlreadyRegisteredClick = true;
      if (this.mAdapterListener != null) {
        this.mAdapterListener.onNativeInterstitialClicked(this);
      }
    }
  }
  
  public void MMAdCachingCompleted(MMAdView paramMMAdView, boolean paramBoolean)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if (MillennialInterstitialAdapter.this.isInvalidated()) {}
        while (MillennialInterstitialAdapter.this.mAdapterListener == null) {
          return;
        }
        if (MillennialInterstitialAdapter.this.mMillennialAdView.check())
        {
          Log.d("MoPub", "Millennial interstitial caching completed.");
          MillennialInterstitialAdapter.this.mAdapterListener.onNativeInterstitialLoaded(MillennialInterstitialAdapter.this);
          return;
        }
        Log.d("MoPub", "Millennial interstitial caching failed. Trying another.");
        MillennialInterstitialAdapter.this.mAdapterListener.onNativeInterstitialFailed(MillennialInterstitialAdapter.this);
      }
    });
  }
  
  public void MMAdClickedToOverlay(MMAdView paramMMAdView)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if (MillennialInterstitialAdapter.this.isInvalidated()) {
          return;
        }
        Log.d("MoPub", "Millennial interstitial clicked to overlay");
        MillennialInterstitialAdapter.this.recordClickIfNecessary();
      }
    });
  }
  
  public void MMAdFailed(MMAdView paramMMAdView)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if (MillennialInterstitialAdapter.this.isInvalidated()) {}
        do
        {
          return;
          Log.d("MoPub", "Millennial interstitial failed. Trying another.");
        } while (MillennialInterstitialAdapter.this.mAdapterListener == null);
        MillennialInterstitialAdapter.this.mAdapterListener.onNativeInterstitialFailed(MillennialInterstitialAdapter.this);
      }
    });
  }
  
  public void MMAdOverlayLaunched(MMAdView paramMMAdView)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if (MillennialInterstitialAdapter.this.isInvalidated()) {}
        do
        {
          return;
          Log.d("MoPub", "Millennial interstitial launched overlay");
        } while (MillennialInterstitialAdapter.this.mAdapterListener == null);
        MillennialInterstitialAdapter.this.mAdapterListener.onNativeInterstitialExpired(MillennialInterstitialAdapter.this);
      }
    });
  }
  
  public void MMAdRequestIsCaching(MMAdView paramMMAdView)
  {
    Log.d("MoPub", "Millennial interstitial is caching.");
  }
  
  public void MMAdReturned(MMAdView paramMMAdView)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if (MillennialInterstitialAdapter.this.isInvalidated()) {}
        do
        {
          return;
          Log.d("MoPub", "Millennial interstitial returned an ad.");
        } while (MillennialInterstitialAdapter.this.mAdapterListener == null);
      }
    });
  }
  
  public void init(MoPubInterstitial paramMoPubInterstitial, String paramString)
  {
    super.init(paramMoPubInterstitial, paramString);
    this.mActivityReference = new WeakReference(paramMoPubInterstitial.getActivity());
    try
    {
      paramMoPubInterstitial = ((JSONObject)new JSONTokener(this.mJsonParams).nextValue()).getString("adUnitID");
      this.mMillennialAdView = new MMAdView((Context)this.mActivityReference.get(), paramMoPubInterstitial, "MMFullScreenAdTransition", -1);
      this.mMillennialAdView.setId(1897808289);
      this.mMillennialAdView.setListener(this);
      return;
    }
    catch (JSONException paramMoPubInterstitial)
    {
      while (this.mAdapterListener == null) {}
      this.mAdapterListener.onNativeInterstitialFailed(this);
    }
  }
  
  public void invalidate()
  {
    this.mMillennialAdView.removeAllViews();
    this.mActivityReference = null;
    super.invalidate();
  }
  
  public boolean isInvalidated()
  {
    if (this.mActivityReference == null) {}
    while (this.mActivityReference.get() == null) {
      return true;
    }
    return super.isInvalidated();
  }
  
  public void loadInterstitial()
  {
    if (isInvalidated()) {
      return;
    }
    Log.d("MoPub", "Fetching Millennial ad...");
    Location localLocation = this.mInterstitial.getLocation();
    if (localLocation != null) {
      this.mMillennialAdView.updateUserLocation(localLocation);
    }
    this.mMillennialAdView.setVisibility(4);
    this.mHasAlreadyRegisteredClick = false;
    this.mMillennialAdView.fetch();
  }
  
  public void showInterstitial()
  {
    if (isInvalidated()) {
      return;
    }
    if (this.mMillennialAdView.check())
    {
      this.mMillennialAdView.display();
      return;
    }
    Log.d("MoPub", "Tried to show a Millennial interstitial before it finished caching. Please try again.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/mopub/mobileads/MillennialInterstitialAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */