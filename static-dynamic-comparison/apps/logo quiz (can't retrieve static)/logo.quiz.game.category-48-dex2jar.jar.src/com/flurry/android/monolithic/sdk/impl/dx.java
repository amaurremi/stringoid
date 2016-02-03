package com.flurry.android.monolithic.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.flurry.android.AdCreative;
import com.flurry.android.AdNetworkView;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMSDK;

public final class dx
  extends AdNetworkView
{
  private static final String a = dx.class.getSimpleName();
  private final String f;
  private final String g;
  
  dx(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdCreative paramAdCreative, Bundle paramBundle)
  {
    super(paramContext, paramFlurryAdModule, paramm, paramAdCreative);
    this.f = paramBundle.getString("com.flurry.millennial.MYAPID");
    this.g = paramBundle.getString("com.flurry.millennial.MYAPIDRECTANGLE");
    setFocusable(true);
  }
  
  public void initLayout()
  {
    Object localObject = getContext();
    int i = getAdCreative().getWidth();
    int j = getAdCreative().getHeight();
    ja.a(3, a, String.format("Ad space width: %d Ad space height: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
    if (((i >= 320) && (j >= 50)) || ((i >= 300) && (j >= 250)))
    {
      localObject = new MMAdView((Activity)localObject);
      setId(MMSDK.getDefaultAdId());
      if ((i >= 320) && (j >= 50))
      {
        ((MMAdView)localObject).setApid(this.f);
        if ((i >= 728) && (j >= 90))
        {
          j = 728;
          i = 90;
        }
      }
    }
    for (;;)
    {
      ja.a(3, a, String.format("Determined Millennial AdSize as %d x %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) }));
      ((MMAdView)localObject).setWidth(j);
      ((MMAdView)localObject).setHeight(i);
      setHorizontalScrollBarEnabled(false);
      setVerticalScrollBarEnabled(false);
      setGravity(17);
      ((MMAdView)localObject).setListener(new dy(this));
      addView((View)localObject);
      ((MMAdView)localObject).getAd();
      return;
      if ((i >= 480) && (j >= 60))
      {
        j = 480;
        i = 60;
        continue;
        if ((i >= 300) && (j >= 250))
        {
          ((MMAdView)localObject).setApid(this.g);
          i = 250;
          j = 300;
          continue;
          ja.a(3, a, "**********Could not load Millennial Ad");
          return;
        }
      }
      j = 320;
      i = 50;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/dx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */