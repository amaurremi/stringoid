package com.flurry.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.jumptap.adtag.JtAdInterstitial;
import com.jumptap.adtag.JtAdWidgetSettings;
import com.jumptap.adtag.JtAdWidgetSettingsFactory;
import com.jumptap.adtag.utils.JtException;

final class bo
  extends m
{
  private static final String d = bo.class.getSimpleName();
  private final String g;
  
  public bo(Context paramContext, FlurryAds paramFlurryAds, cz paramcz, AdUnit paramAdUnit, Bundle paramBundle)
  {
    super(paramContext, paramFlurryAds, paramcz, paramAdUnit);
    this.g = paramBundle.getString("com.flurry.jumptap.PUBLISHER_ID");
  }
  
  public final void f()
  {
    Object localObject1 = JtAdWidgetSettingsFactory.createWidgetSettings();
    ((JtAdWidgetSettings)localObject1).setPublisherId(this.g);
    ((JtAdWidgetSettings)localObject1).setRefreshPeriod(0);
    ((JtAdWidgetSettings)localObject1).setShouldSendLocation(false);
    try
    {
      localObject1 = new JtAdInterstitial((Activity)getContext(), (JtAdWidgetSettings)localObject1);
      ((JtAdInterstitial)localObject1).setAdViewListener(new ah(this));
      ((JtAdInterstitial)localObject1).showAsPopup();
      return;
    }
    catch (JtException localJtException)
    {
      for (;;)
      {
        Log.d(d, "Jumptap JtException when creating ad object.");
        Object localObject2 = null;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */