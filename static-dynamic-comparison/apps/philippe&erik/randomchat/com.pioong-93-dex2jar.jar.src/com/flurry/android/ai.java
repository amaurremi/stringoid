package com.flurry.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

final class ai
  extends AdNetworkView
{
  private static final String bA = ai.class.getSimpleName();
  private static final int bB = AdSize.BANNER.getWidth();
  private static final Map<AdSize, AdSize> bC;
  private final boolean P;
  private final String bD;
  private final String g;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(new AdSize(bB, AdSize.IAB_LEADERBOARD.getHeight()), AdSize.IAB_LEADERBOARD);
    localHashMap.put(new AdSize(bB, AdSize.IAB_BANNER.getHeight()), AdSize.IAB_BANNER);
    localHashMap.put(new AdSize(bB, AdSize.BANNER.getHeight()), AdSize.BANNER);
    localHashMap.put(new AdSize(bB, AdSize.IAB_MRECT.getHeight()), AdSize.IAB_MRECT);
    bC = Collections.unmodifiableMap(localHashMap);
  }
  
  public ai(Context paramContext, FlurryAds paramFlurryAds, cz paramcz, AdCreative paramAdCreative, Bundle paramBundle)
  {
    super(paramContext, paramFlurryAds, paramcz, paramAdCreative);
    this.g = paramBundle.getString("com.flurry.admob.MY_AD_UNIT_ID");
    this.bD = paramBundle.getString("com.flurry.admob.MYTEST_AD_DEVICE_ID");
    this.P = paramBundle.getBoolean("com.flurry.admob.test");
    setFocusable(true);
  }
  
  private static AdSize a(int paramInt)
  {
    Object localObject = bC.keySet();
    localObject = new AdSize(bB, paramInt).findBestSize((AdSize[])((Set)localObject).toArray(new AdSize[((Set)localObject).size()]));
    return (AdSize)bC.get(localObject);
  }
  
  public final void initLayout(Context paramContext)
  {
    int k = getAdCreative().getWidth();
    int m = getAdCreative().getHeight();
    Object localObject1 = paramContext.getResources().getDisplayMetrics();
    int n = (int)(((DisplayMetrics)localObject1).heightPixels / ((DisplayMetrics)localObject1).density);
    int j = (int)(((DisplayMetrics)localObject1).widthPixels / ((DisplayMetrics)localObject1).density);
    int i = j;
    label89:
    Object localObject2;
    if (k > 0)
    {
      if (k > j) {
        i = j;
      }
    }
    else
    {
      j = n;
      if (m > 0)
      {
        if (m <= n) {
          break label395;
        }
        j = n;
      }
      localObject2 = new AdSize(i, j).findBestSize(new AdSize[] { AdSize.IAB_LEADERBOARD, AdSize.IAB_BANNER, AdSize.BANNER, AdSize.IAB_MRECT });
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (k == 0)
        {
          localObject1 = localObject2;
          if (m != 0) {
            localObject1 = a(m);
          }
        }
      }
      if (localObject1 != null) {
        break label401;
      }
      db.d(bA, "Could not find Admob AdSize that matches {width = " + k + ", height " + m + "}");
      localObject1 = a(m);
    }
    label395:
    label401:
    for (;;)
    {
      db.c(bA, "Determined Admob AdSize as " + localObject1 + " that best matches {width = " + k + ", height = " + m + "}");
      localObject2 = new AdView((Activity)paramContext, (AdSize)localObject1, this.g);
      ((AdView)localObject2).setAdListener(new ae(this));
      setGravity(17);
      addView((View)localObject2, new RelativeLayout.LayoutParams(((AdSize)localObject1).getWidthInPixels(paramContext), ((AdSize)localObject1).getHeightInPixels(paramContext)));
      paramContext = new AdRequest();
      if (this.P)
      {
        db.c(bA, "Admob AdView set to Test Mode.");
        paramContext.addTestDevice(AdRequest.TEST_EMULATOR);
        if (!TextUtils.isEmpty(this.bD)) {
          paramContext.addTestDevice(this.bD);
        }
      }
      ((AdView)localObject2).loadAd(paramContext);
      return;
      i = k;
      break;
      j = m;
      break label89;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */