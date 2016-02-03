package com.flurry.android.monolithic.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.flurry.android.AdCreative;
import com.flurry.android.AdNetworkView;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.inmobi.androidsdk.IMAdRequest;
import com.inmobi.androidsdk.IMAdView;

public final class dn
  extends AdNetworkView
{
  private static final String a = dn.class.getSimpleName();
  private final String f;
  private final boolean g;
  
  dn(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdCreative paramAdCreative, Bundle paramBundle)
  {
    super(paramContext, paramFlurryAdModule, paramm, paramAdCreative);
    this.f = paramBundle.getString("com.flurry.inmobi.MY_APP_ID");
    this.g = paramBundle.getBoolean("com.flurry.inmobi.test");
    setFocusable(true);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if ((paramInt2 >= 728) && (paramInt1 >= 90))
    {
      ja.a(3, a, "Determined InMobi AdSize as 728x90");
      return 11;
    }
    if ((paramInt2 >= 468) && (paramInt1 >= 60))
    {
      ja.a(3, a, "Determined InMobi AdSize as 468x60");
      return 12;
    }
    if ((paramInt2 >= 320) && (paramInt1 >= 50))
    {
      ja.a(3, a, "Determined InMobi AdSize as 320x50");
      return 15;
    }
    if ((paramInt2 >= 300) && (paramInt1 >= 250))
    {
      ja.a(3, a, "Determined InMobi AdSize as 300x250");
      return 10;
    }
    if ((paramInt2 >= 120) && (paramInt1 >= 600))
    {
      ja.a(3, a, "Determined InMobi AdSize as 120x600");
      return 13;
    }
    ja.a(3, a, "Could not find InMobi AdSize that matches size");
    return -1;
  }
  
  public void initLayout()
  {
    Object localObject1 = getContext();
    Object localObject2 = ((Context)localObject1).getResources().getDisplayMetrics();
    int k = a((int)(((DisplayMetrics)localObject2).heightPixels / ((DisplayMetrics)localObject2).density), (int)(((DisplayMetrics)localObject2).widthPixels / ((DisplayMetrics)localObject2).density));
    int i;
    int j;
    if (k != -1)
    {
      localObject1 = new IMAdView((Activity)localObject1, k, this.f);
      if ((k == 15) && (k != 11)) {
        break label262;
      }
      i = 728;
      j = 90;
    }
    for (;;)
    {
      if (k == 12)
      {
        i = 468;
        j = 60;
      }
      if (k == 10)
      {
        i = 300;
        j = 250;
      }
      if (k == 13)
      {
        i = 120;
        j = 600;
      }
      float f1 = getResources().getDisplayMetrics().density;
      ((IMAdView)localObject1).setLayoutParams(new LinearLayout.LayoutParams((int)(i * f1 + 0.5F), (int)(j * f1 + 0.5F)));
      ((IMAdView)localObject1).setIMAdListener(new do(this));
      setGravity(17);
      addView((View)localObject1);
      localObject2 = new IMAdRequest();
      if (this.g)
      {
        ja.a(3, a, "InMobi AdView set to Test Mode.");
        ((IMAdRequest)localObject2).setTestMode(true);
      }
      ((IMAdView)localObject1).setIMAdRequest((IMAdRequest)localObject2);
      ((IMAdView)localObject1).setRefreshInterval(-1);
      ((IMAdView)localObject1).loadNewAd();
      return;
      ja.a(3, a, "**********Could not load InMobi Ad");
      return;
      label262:
      j = 50;
      i = 320;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/dn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */