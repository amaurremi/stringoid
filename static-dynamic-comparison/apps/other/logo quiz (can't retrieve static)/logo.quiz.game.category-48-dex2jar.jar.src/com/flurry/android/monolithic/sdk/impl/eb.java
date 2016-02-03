package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import com.flurry.android.AdCreative;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import java.util.ArrayList;
import java.util.List;

public final class eb
  extends cy
{
  protected ac a(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdCreative paramAdCreative, Bundle paramBundle)
  {
    if ((paramContext == null) || (paramFlurryAdModule == null) || (paramm == null) || (paramAdCreative == null) || (paramBundle == null)) {
      return null;
    }
    return new ec(paramContext, paramFlurryAdModule, paramm, paramAdCreative, paramBundle);
  }
  
  protected cn a(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdUnit paramAdUnit, Bundle paramBundle)
  {
    if ((paramContext == null) || (paramFlurryAdModule == null) || (paramm == null) || (paramAdUnit == null) || (paramBundle == null)) {
      return null;
    }
    return new ee(paramContext, paramFlurryAdModule, paramm, paramAdUnit, paramBundle);
  }
  
  protected String f()
  {
    return "Mobclix";
  }
  
  protected List<cu> g()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new cu("mobclix", "3.2.1", "com.mobclix.android.sdk.MobclixFullScreenAdView"));
    return localArrayList;
  }
  
  protected List<ActivityInfo> j()
  {
    ArrayList localArrayList = new ArrayList();
    ActivityInfo localActivityInfo = new ActivityInfo();
    localActivityInfo.name = "com.mobclix.android.sdk.MobclixBrowserActivity";
    localArrayList.add(localActivityInfo);
    return localArrayList;
  }
  
  protected List<cu> k()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new cu("mobclix", "3.2.1", "com.mobclix.android.sdk.MobclixAdView"));
    return localArrayList;
  }
  
  protected List<String> n()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("com.mobclix.APPLICATION_ID");
    return localArrayList;
  }
  
  protected List<String> o()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("android.permission.INTERNET");
    localArrayList.add("android.permission.READ_PHONE_STATE");
    return localArrayList;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/eb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */