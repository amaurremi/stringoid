package com.flurry.android.monolithic.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import com.jumptap.adtag.JtAdInterstitial;
import com.jumptap.adtag.JtAdWidgetSettings;
import com.jumptap.adtag.JtAdWidgetSettingsFactory;
import com.jumptap.adtag.utils.JtException;

public final class du
  extends cr
{
  private static final String b = du.class.getSimpleName();
  private final String c;
  private final String d;
  private final String e;
  
  public du(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdUnit paramAdUnit, Bundle paramBundle)
  {
    super(paramContext, paramFlurryAdModule, paramm, paramAdUnit);
    this.c = paramBundle.getString("com.flurry.jumptap.PUBLISHER_ID");
    this.d = paramBundle.getString("com.flurry.jumptap.INT_SPOT_ID");
    this.e = paramBundle.getString("com.flurry.jumptap.INT_SITE_ID");
  }
  
  public void a()
  {
    Object localObject1 = JtAdWidgetSettingsFactory.createWidgetSettings();
    ((JtAdWidgetSettings)localObject1).setPublisherId(this.c);
    if (!TextUtils.isEmpty(this.d)) {
      ((JtAdWidgetSettings)localObject1).setSpotId(this.d);
    }
    if (!TextUtils.isEmpty(this.e)) {
      ((JtAdWidgetSettings)localObject1).setSiteId(this.e);
    }
    ((JtAdWidgetSettings)localObject1).setApplicationId(il.c(b()));
    ((JtAdWidgetSettings)localObject1).setApplicationVersion(il.d(b()));
    ((JtAdWidgetSettings)localObject1).setRefreshPeriod(0);
    ((JtAdWidgetSettings)localObject1).setShouldSendLocation(false);
    try
    {
      localObject1 = new JtAdInterstitial((Activity)b(), (JtAdWidgetSettings)localObject1);
      ((JtAdInterstitial)localObject1).setAdViewListener(new dv(this));
      ((JtAdInterstitial)localObject1).showAsPopup();
      return;
    }
    catch (JtException localJtException)
    {
      for (;;)
      {
        ja.a(3, b, "Jumptap JtException when creating ad object.");
        Object localObject2 = null;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/du.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */