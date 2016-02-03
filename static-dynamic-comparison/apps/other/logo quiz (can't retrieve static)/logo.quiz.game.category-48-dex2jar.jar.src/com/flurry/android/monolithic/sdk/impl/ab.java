package com.flurry.android.monolithic.sdk.impl;

import com.flurry.android.AdCreative;
import com.flurry.android.FlurryAdSize;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v6.AdSpaceLayout;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import java.util.List;

public final class ab
{
  public static AdCreative a(AdSpaceLayout paramAdSpaceLayout)
  {
    return new AdCreative(paramAdSpaceLayout.c().intValue(), paramAdSpaceLayout.b().intValue(), paramAdSpaceLayout.e().toString(), paramAdSpaceLayout.d().toString(), paramAdSpaceLayout.f().toString());
  }
  
  public static AdCreative a(AdUnit paramAdUnit)
  {
    if (paramAdUnit == null) {
      return null;
    }
    paramAdUnit = paramAdUnit.d();
    if ((paramAdUnit == null) || (paramAdUnit.isEmpty())) {
      return null;
    }
    paramAdUnit = (AdFrame)paramAdUnit.get(0);
    if (paramAdUnit == null) {
      return null;
    }
    paramAdUnit = paramAdUnit.e();
    if (paramAdUnit == null) {
      return null;
    }
    return a(paramAdUnit);
  }
  
  public static m a(FlurryAdModule paramFlurryAdModule, String paramString)
  {
    paramString = new m(paramFlurryAdModule.d(), paramString, paramFlurryAdModule.i());
    paramFlurryAdModule.a(paramString);
    return paramString;
  }
  
  public static FlurryAdSize b(AdSpaceLayout paramAdSpaceLayout)
  {
    if (paramAdSpaceLayout == null) {
      return FlurryAdSize.BANNER_TOP;
    }
    if (paramAdSpaceLayout.e().toString().equals("takeover")) {
      return FlurryAdSize.FULLSCREEN;
    }
    paramAdSpaceLayout = paramAdSpaceLayout.f().toString().split("-");
    if ((paramAdSpaceLayout.length > 0) && (paramAdSpaceLayout[0].equals("b"))) {
      return FlurryAdSize.BANNER_BOTTOM;
    }
    return FlurryAdSize.BANNER_TOP;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */