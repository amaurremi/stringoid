package com.flurry.android.monolithic.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout.LayoutParams;
import com.flurry.android.AdCreative;
import com.flurry.android.AdNetworkView;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public final class dg
  extends AdNetworkView
{
  private static final String a = dg.class.getSimpleName();
  private final String f;
  private final String g;
  private final boolean h;
  
  public dg(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdCreative paramAdCreative, Bundle paramBundle)
  {
    super(paramContext, paramFlurryAdModule, paramm, paramAdCreative);
    this.f = paramBundle.getString("com.flurry.admob.MY_AD_UNIT_ID");
    this.g = paramBundle.getString("com.flurry.admob.MYTEST_AD_DEVICE_ID");
    this.h = paramBundle.getBoolean("com.flurry.admob.test");
    setFocusable(true);
  }
  
  private AdSize a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 728) && (paramInt2 >= 90)) {
      return AdSize.IAB_LEADERBOARD;
    }
    if ((paramInt1 >= 468) && (paramInt2 >= 60)) {
      return AdSize.IAB_BANNER;
    }
    if ((paramInt1 >= 320) && (paramInt2 >= 50)) {
      return AdSize.BANNER;
    }
    if ((paramInt1 >= 300) && (paramInt2 >= 250)) {
      return AdSize.IAB_MRECT;
    }
    ja.a(3, a, "Could not find AdMob AdSize that matches size");
    return null;
  }
  
  private AdSize a(Context paramContext, int paramInt1, int paramInt2)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    int j = (int)(paramContext.heightPixels / paramContext.density);
    int k = (int)(paramContext.widthPixels / paramContext.density);
    int i;
    if (paramInt1 > 0)
    {
      i = paramInt1;
      if (paramInt1 <= k) {}
    }
    else
    {
      i = k;
    }
    if (paramInt2 > 0)
    {
      paramInt1 = paramInt2;
      if (paramInt2 <= j) {}
    }
    else
    {
      paramInt1 = j;
    }
    return a(i, paramInt1);
  }
  
  public void initLayout()
  {
    Object localObject = getContext();
    int i = getAdCreative().getWidth();
    int j = getAdCreative().getHeight();
    AdSize localAdSize = a((Context)localObject, i, j);
    if (localAdSize == null)
    {
      ja.a(6, a, "Could not find Admob AdSize that matches {width = " + i + ", height " + j + "}");
      return;
    }
    ja.a(3, a, "Determined Admob AdSize as " + localAdSize + " that best matches {width = " + i + ", height = " + j + "}");
    AdView localAdView = new AdView((Activity)localObject, localAdSize, this.f);
    localAdView.setAdListener(new di(this, null));
    setGravity(17);
    addView(localAdView, new RelativeLayout.LayoutParams(localAdSize.getWidthInPixels((Context)localObject), localAdSize.getHeightInPixels((Context)localObject)));
    localObject = new AdRequest();
    if (this.h)
    {
      ja.a(3, a, "Admob AdView set to Test Mode.");
      ((AdRequest)localObject).addTestDevice(AdRequest.TEST_EMULATOR);
      if (!TextUtils.isEmpty(this.g)) {
        ((AdRequest)localObject).addTestDevice(this.g);
      }
    }
    localAdView.loadAd((AdRequest)localObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/dg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */