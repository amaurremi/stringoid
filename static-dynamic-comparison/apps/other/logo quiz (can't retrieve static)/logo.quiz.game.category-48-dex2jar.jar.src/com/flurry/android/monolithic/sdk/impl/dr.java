package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import com.flurry.android.AdCreative;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import java.util.ArrayList;
import java.util.List;

public final class dr
  extends cy
{
  protected ac a(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdCreative paramAdCreative, Bundle paramBundle)
  {
    if ((paramContext == null) || (paramFlurryAdModule == null) || (paramm == null) || (paramAdCreative == null) || (paramBundle == null)) {
      return null;
    }
    return new ds(paramContext, paramFlurryAdModule, paramm, paramAdCreative, paramBundle);
  }
  
  protected cn a(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdUnit paramAdUnit, Bundle paramBundle)
  {
    if ((paramContext == null) || (paramFlurryAdModule == null) || (paramm == null) || (paramAdUnit == null) || (paramBundle == null)) {
      return null;
    }
    return new du(paramContext, paramFlurryAdModule, paramm, paramAdUnit, paramBundle);
  }
  
  protected String f()
  {
    return "Jumptap";
  }
  
  protected List<cu> g()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new cu("JtAdTag", "1.1.10.4", "com.jumptap.adtag.JtAdInterstitial"));
    return localArrayList;
  }
  
  protected List<ActivityInfo> j()
  {
    return new ArrayList();
  }
  
  protected List<cu> k()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new cu("JtAdTag", "1.1.10.4", "com.jumptap.adtag.JtAdView"));
    return localArrayList;
  }
  
  protected List<String> n()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("com.flurry.jumptap.PUBLISHER_ID");
    return localArrayList;
  }
  
  protected List<String> o()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("android.permission.INTERNET");
    localArrayList.add("android.permission.READ_PHONE_STATE");
    localArrayList.add("android.permission.ACCESS_NETWORK_STATE");
    return localArrayList;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/dr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */