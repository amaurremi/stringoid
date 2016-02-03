package com.flurry.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.LinearLayout.LayoutParams;
import com.inmobi.androidsdk.IMAdRequest;
import com.inmobi.androidsdk.IMAdView;

final class an
  extends AdNetworkView
{
  private static final String d = an.class.getSimpleName();
  private final boolean P;
  private final String g;
  
  an(Context paramContext, FlurryAds paramFlurryAds, cz paramcz, AdCreative paramAdCreative, Bundle paramBundle)
  {
    super(paramContext, paramFlurryAds, paramcz, paramAdCreative);
    this.g = paramBundle.getString("com.flurry.inmobi.MY_APP_ID");
    this.P = paramBundle.getBoolean("com.flurry.inmobi.test");
    setFocusable(true);
  }
  
  public final void initLayout(Context paramContext)
  {
    int j = 320;
    int k = 50;
    Object localObject = paramContext.getResources().getDisplayMetrics();
    int i = (int)(((DisplayMetrics)localObject).heightPixels / ((DisplayMetrics)localObject).density);
    int m = (int)(((DisplayMetrics)localObject).widthPixels / ((DisplayMetrics)localObject).density);
    if ((m >= 728) && (i >= 90))
    {
      Log.d(d, "Determined InMobi AdSize as 728x90");
      i = 11;
    }
    while (i != -1)
    {
      paramContext = new IMAdView((Activity)paramContext, i, this.g);
      if ((i != 15) || (i == 11))
      {
        j = 728;
        k = 90;
      }
      if (i == 12)
      {
        j = 468;
        k = 60;
      }
      if (i == 10)
      {
        j = 300;
        k = 250;
      }
      if (i == 13)
      {
        j = 120;
        k = 600;
      }
      float f = getResources().getDisplayMetrics().density;
      paramContext.setLayoutParams(new LinearLayout.LayoutParams((int)(j * f + 0.5F), (int)(k * f + 0.5F)));
      paramContext.setIMAdListener(new as(this));
      setGravity(17);
      addView(paramContext);
      localObject = new IMAdRequest();
      if (this.P)
      {
        Log.d(d, "InMobi AdView set to Test Mode.");
        ((IMAdRequest)localObject).setTestMode(true);
      }
      paramContext.setIMAdRequest((IMAdRequest)localObject);
      paramContext.setRefreshInterval(-1);
      paramContext.loadNewAd();
      return;
      if ((m >= 468) && (i >= 60))
      {
        Log.d(d, "Determined InMobi AdSize as 468x60");
        i = 12;
      }
      else if ((m >= 320) && (i >= 50))
      {
        Log.d(d, "Determined InMobi AdSize as 320x50");
        i = 15;
      }
      else if ((m >= 300) && (i >= 250))
      {
        Log.d(d, "Determined InMobi AdSize as 300x250");
        i = 10;
      }
      else if ((m >= 120) && (i >= 600))
      {
        Log.d(d, "Determined InMobi AdSize as 120x600");
        i = 13;
      }
      else
      {
        Log.d(d, "Could not find InMobi AdSize that matches size");
        i = -1;
      }
    }
    Log.d(d, "**********Could not load InMobi Ad");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */