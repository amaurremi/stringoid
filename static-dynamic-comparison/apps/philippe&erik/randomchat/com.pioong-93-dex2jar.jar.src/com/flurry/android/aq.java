package com.flurry.android;

import android.content.Context;
import android.content.Intent;

final class aq
  extends ao
{
  public aq(Context paramContext, FlurryAds paramFlurryAds, cz paramcz, AdUnit paramAdUnit)
  {
    super(paramContext, paramFlurryAds, paramcz, paramAdUnit);
  }
  
  public final void f()
  {
    Intent localIntent = new Intent(getContext(), FlurryFullscreenTakeoverActivity.class);
    if (!C().a(getContext(), localIntent, E().getAdSpace().toString())) {
      db.d(d, "Unable to launch FlurryFullscreenTakeoverActivity. Fix by declaring this Activity in your AndroidManifest.xml");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */