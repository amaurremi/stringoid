package com.flurry.android.monolithic.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.LinearLayout.LayoutParams;
import com.flurry.android.AdCreative;
import com.flurry.android.AdNetworkView;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.mobclix.android.sdk.MobclixAdView;
import com.mobclix.android.sdk.MobclixIABRectangleMAdView;
import com.mobclix.android.sdk.MobclixMMABannerXLAdView;

public class ec
  extends AdNetworkView
{
  private static final String a = ec.class.getSimpleName();
  
  ec(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdCreative paramAdCreative, Bundle paramBundle)
  {
    super(paramContext, paramFlurryAdModule, paramm, paramAdCreative);
    setFocusable(true);
  }
  
  private MobclixAdView a(Context paramContext, int paramInt1, int paramInt2)
  {
    if ((paramInt2 >= 320) && (paramInt1 >= 50))
    {
      ja.a(3, a, "Determined Mobclix AdSize as BANNER");
      return new MobclixMMABannerXLAdView((Activity)paramContext);
    }
    if ((paramInt2 >= 300) && (paramInt1 >= 250))
    {
      ja.a(3, a, "Determined Mobclix AdSize as IAB_RECT");
      return new MobclixIABRectangleMAdView((Activity)paramContext);
    }
    ja.a(3, a, "Could not find Mobclix AdSize that matches size");
    return null;
  }
  
  public void initLayout()
  {
    int j = 300;
    int i = 50;
    MobclixAdView localMobclixAdView = a(getContext(), getAdCreative().getHeight(), getAdCreative().getWidth());
    localMobclixAdView.addMobclixAdViewListener(new ed(this));
    if ((!(localMobclixAdView instanceof MobclixMMABannerXLAdView)) || ((localMobclixAdView instanceof MobclixIABRectangleMAdView)))
    {
      j = 320;
      i = 250;
    }
    float f = getResources().getDisplayMetrics().density;
    localMobclixAdView.setLayoutParams(new LinearLayout.LayoutParams((int)(j * f + 0.5F), (int)(i * f + 0.5F)));
    setGravity(17);
    addView(localMobclixAdView);
    localMobclixAdView.setRefreshTime(-1L);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */