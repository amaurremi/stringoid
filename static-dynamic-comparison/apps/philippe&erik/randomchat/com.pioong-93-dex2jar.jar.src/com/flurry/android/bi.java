package com.flurry.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.millennialmedia.android.MMAdView;

final class bi
  extends AdNetworkView
{
  private static final String d = bi.class.getSimpleName();
  private final String g;
  
  bi(Context paramContext, FlurryAds paramFlurryAds, cz paramcz, AdCreative paramAdCreative, Bundle paramBundle)
  {
    super(paramContext, paramFlurryAds, paramcz, paramAdCreative);
    this.g = paramBundle.getString("com.flurry.millennial.MYAPID");
    setFocusable(true);
  }
  
  public final void initLayout(Context paramContext)
  {
    int i = getAdCreative().getHeight();
    int j = getAdCreative().getWidth();
    String str;
    if ((j >= 320) && (i >= 50))
    {
      Log.d(d, "Determined Millennial AdSize as MMBannerAdBottom");
      str = "MMBannerAdBottom";
    }
    while (str != null)
    {
      paramContext = new MMAdView((Activity)paramContext, this.g, str, 0);
      paramContext.setId(1897808289);
      paramContext.setHorizontalScrollBarEnabled(false);
      paramContext.setVerticalScrollBarEnabled(false);
      setGravity(17);
      paramContext.setListener(new bg(this));
      addView(paramContext);
      return;
      if ((j >= 300) && (i >= 250))
      {
        Log.d(d, "Determined Millennial AdSize as MMBannerAdRectangle");
        str = "MMBannerAdRectangle";
      }
      else
      {
        Log.d(d, "Could not find Millennial AdSize that matches size");
        str = null;
      }
    }
    Log.d(d, "**********Could not load Millennial Ad");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */