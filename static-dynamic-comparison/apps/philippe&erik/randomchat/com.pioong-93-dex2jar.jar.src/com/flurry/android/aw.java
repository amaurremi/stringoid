package com.flurry.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.LinearLayout.LayoutParams;
import com.mobclix.android.sdk.MobclixAdView;
import com.mobclix.android.sdk.MobclixIABRectangleMAdView;
import com.mobclix.android.sdk.MobclixMMABannerXLAdView;

class aw
  extends AdNetworkView
{
  private static final String d = aw.class.getSimpleName();
  
  aw(Context paramContext, FlurryAds paramFlurryAds, cz paramcz, AdCreative paramAdCreative)
  {
    super(paramContext, paramFlurryAds, paramcz, paramAdCreative);
    setFocusable(true);
  }
  
  public void initLayout(Context paramContext)
  {
    int i = 320;
    int j = getAdCreative().getHeight();
    int k = getAdCreative().getWidth();
    if ((k >= 320) && (j >= 50))
    {
      Log.d(d, "Determined Mobclix AdSize as BANNER");
      paramContext = new MobclixMMABannerXLAdView((Activity)paramContext);
      paramContext.addMobclixAdViewListener(new bj(this));
      if (((paramContext instanceof MobclixMMABannerXLAdView)) && (!(paramContext instanceof MobclixIABRectangleMAdView))) {
        break label202;
      }
    }
    for (j = 250;; j = 50)
    {
      float f = getResources().getDisplayMetrics().density;
      paramContext.setLayoutParams(new LinearLayout.LayoutParams((int)(i * f + 0.5F), (int)(j * f + 0.5F)));
      setGravity(17);
      addView(paramContext);
      paramContext.setRefreshTime(-1L);
      return;
      if ((k >= 300) && (j >= 250))
      {
        Log.d(d, "Determined Mobclix AdSize as IAB_RECT");
        paramContext = new MobclixIABRectangleMAdView((Activity)paramContext);
        break;
      }
      Log.d(d, "Could not find Mobclix AdSize that matches size");
      paramContext = null;
      break;
      label202:
      i = 300;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */