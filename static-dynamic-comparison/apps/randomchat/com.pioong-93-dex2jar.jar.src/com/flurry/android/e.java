package com.flurry.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.jumptap.adtag.JtAdView;
import com.jumptap.adtag.JtAdWidgetSettings;
import com.jumptap.adtag.JtAdWidgetSettingsFactory;
import com.jumptap.adtag.utils.JtException;

class e
  extends AdNetworkView
{
  private static final String d = e.class.getSimpleName();
  private final String g;
  
  e(Context paramContext, FlurryAds paramFlurryAds, cz paramcz, AdCreative paramAdCreative, Bundle paramBundle)
  {
    super(paramContext, paramFlurryAds, paramcz, paramAdCreative);
    this.g = paramBundle.getString("com.flurry.jumptap.PUBLISHER_ID");
    setFocusable(true);
  }
  
  public void initLayout(Context paramContext)
  {
    JtAdWidgetSettings localJtAdWidgetSettings = JtAdWidgetSettingsFactory.createWidgetSettings();
    localJtAdWidgetSettings.setPublisherId(this.g);
    localJtAdWidgetSettings.setRefreshPeriod(0);
    localJtAdWidgetSettings.setShouldSendLocation(false);
    setGravity(17);
    try
    {
      paramContext = new JtAdView((Activity)paramContext, localJtAdWidgetSettings);
      paramContext.setAdViewListener(new aa(this));
      addView(paramContext);
      return;
    }
    catch (JtException paramContext)
    {
      for (;;)
      {
        Log.d(d, "Jumptap JtException when creating ad object.");
        paramContext = null;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */