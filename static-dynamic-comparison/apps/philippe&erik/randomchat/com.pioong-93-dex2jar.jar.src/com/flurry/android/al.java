package com.flurry.android;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

final class al
  extends az
{
  private static final String d = be.class.getSimpleName();
  
  protected final Bundle a(Context paramContext)
  {
    Bundle localBundle = bp.p(paramContext);
    paramContext = localBundle;
    if (TextUtils.isEmpty(localBundle.getString("com.mobclix.APPLICATION_ID")))
    {
      db.d(d, "The meta-data should include not empty value for com.mobclix.APPLICATION_ID key in AndroidManifest.xml");
      paramContext = null;
    }
    return paramContext;
  }
  
  protected final ao a(Context paramContext, FlurryAds paramFlurryAds, cz paramcz, AdUnit paramAdUnit, Bundle paramBundle)
  {
    if ((paramContext == null) || (paramFlurryAds == null) || (paramcz == null) || (paramAdUnit == null) || (paramBundle == null)) {
      return null;
    }
    return new cg(paramContext, paramFlurryAds, paramcz, paramAdUnit);
  }
  
  protected final p a(Context paramContext, FlurryAds paramFlurryAds, cz paramcz, AdCreative paramAdCreative, Bundle paramBundle)
  {
    if ((paramContext == null) || (paramFlurryAds == null) || (paramcz == null) || (paramAdCreative == null) || (paramBundle == null)) {
      return null;
    }
    return new aw(paramContext, paramFlurryAds, paramcz, paramAdCreative);
  }
  
  protected final av b()
  {
    return new av("mobclix", "3.2.0", "com.mobclix.android.sdk.MobclixFullScreenAdView");
  }
  
  protected final av c()
  {
    return new av("mobclix", "3.2.0", "com.mobclix.android.sdk.MobclixAdView");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */