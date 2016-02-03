package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.content.Intent;
import com.flurry.android.FlurryFullscreenTakeoverActivity;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;

public final class cg
  extends cn
{
  public cg(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdUnit paramAdUnit)
  {
    super(paramContext, paramFlurryAdModule, paramm, paramAdUnit);
  }
  
  public void a()
  {
    Intent localIntent = new Intent(ia.a().b(), FlurryFullscreenTakeoverActivity.class);
    if (!c().a().a(b(), localIntent, e().b().toString())) {
      ja.b(a, "Unable to launch FlurryFullscreenTakeoverActivity. Fix by declaring this Activity in your AndroidManifest.xml");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */