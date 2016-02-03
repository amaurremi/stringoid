package com.mopub.mobileads;

import android.app.Activity;
import android.location.Location;
import android.os.Handler;
import android.util.Log;
import android.widget.FrameLayout.LayoutParams;
import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMAdView.MMAdListener;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class MillennialAdapter
  extends BaseAdapter
  implements MMAdView.MMAdListener
{
  private WeakReference<Activity> mActivityReference;
  private final Handler mHandler = new Handler();
  private boolean mHasAlreadyRegisteredImpression;
  private MMAdView mMillennialAdView;
  
  public void MMAdCachingCompleted(MMAdView paramMMAdView, boolean paramBoolean) {}
  
  public void MMAdClickedToOverlay(MMAdView paramMMAdView)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if (MillennialAdapter.this.isInvalidated()) {
          return;
        }
        Log.d("MoPub", "Millennial clicked");
        MillennialAdapter.this.mMoPubView.registerClick();
      }
    });
  }
  
  public void MMAdFailed(MMAdView paramMMAdView)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if (MillennialAdapter.this.isInvalidated()) {
          return;
        }
        Log.d("MoPub", "Millennial failed. Trying another");
        MillennialAdapter.this.mMoPubView.loadFailUrl();
      }
    });
  }
  
  public void MMAdOverlayLaunched(MMAdView paramMMAdView) {}
  
  public void MMAdRequestIsCaching(MMAdView paramMMAdView) {}
  
  public void MMAdReturned(MMAdView paramMMAdView)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if (MillennialAdapter.this.isInvalidated()) {}
        do
        {
          return;
          MillennialAdapter.this.mMoPubView.removeAllViews();
          MillennialAdapter.this.mMillennialAdView.setVisibility(0);
          MillennialAdapter.this.mMillennialAdView.setHorizontalScrollBarEnabled(false);
          MillennialAdapter.this.mMillennialAdView.setVerticalScrollBarEnabled(false);
          FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
          localLayoutParams.gravity = 17;
          MillennialAdapter.this.mMoPubView.addView(MillennialAdapter.this.mMillennialAdView, localLayoutParams);
        } while (MillennialAdapter.this.mHasAlreadyRegisteredImpression);
        MillennialAdapter.access$102(MillennialAdapter.this, true);
        MillennialAdapter.this.mMoPubView.nativeAdLoaded();
        MillennialAdapter.this.mMoPubView.trackNativeImpression();
      }
    });
  }
  
  public void init(MoPubView paramMoPubView, String paramString)
  {
    super.init(paramMoPubView, paramString);
    this.mActivityReference = new WeakReference((Activity)paramMoPubView.getContext());
  }
  
  public void invalidate()
  {
    if (this.mMillennialAdView != null)
    {
      this.mMillennialAdView.removeAllViews();
      this.mMoPubView.removeView(this.mMillennialAdView);
    }
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
  
  public void loadAd()
  {
    if (isInvalidated()) {
      return;
    }
    for (;;)
    {
      int i;
      int j;
      String str3;
      String str4;
      String str5;
      try
      {
        Object localObject1 = (JSONObject)new JSONTokener(this.mJsonParams).nextValue();
        String str6 = ((JSONObject)localObject1).getString("adUnitID");
        i = ((JSONObject)localObject1).getInt("adWidth");
        j = ((JSONObject)localObject1).getInt("adHeight");
        str3 = "MMBannerAdTop";
        str4 = "320";
        str5 = "53";
        if ((i == 300) && (j == 250))
        {
          str1 = "MMBannerAdRectangle";
          str2 = Integer.toString(i);
          localObject1 = Integer.toString(j);
          this.mMillennialAdView = new MMAdView((Activity)this.mActivityReference.get(), str6, str1, -1);
          this.mMillennialAdView.setId(1897808289);
          this.mMillennialAdView.setListener(this);
          this.mMillennialAdView.setVisibility(4);
          this.mMillennialAdView.setWidth(str2);
          this.mMillennialAdView.setHeight((String)localObject1);
          localObject1 = this.mMoPubView.getLocation();
          if (localObject1 != null) {
            this.mMillennialAdView.updateUserLocation((Location)localObject1);
          }
          this.mHasAlreadyRegisteredImpression = false;
          Log.d("MoPub", "Loading Millennial ad...");
          this.mMillennialAdView.callForAd();
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        this.mMoPubView.loadFailUrl();
        return;
      }
      Object localObject2 = str5;
      String str1 = str3;
      String str2 = str4;
      if (i == 728)
      {
        localObject2 = str5;
        str1 = str3;
        str2 = str4;
        if (j == 90)
        {
          str1 = "MMBannerAdTop";
          str2 = Integer.toString(i);
          localObject2 = Integer.toString(j);
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/mopub/mobileads/MillennialAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */